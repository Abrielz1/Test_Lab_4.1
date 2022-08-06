import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryTaskManager implements  TaskManager { //сюда копируем содержимое бывшего Task manager

//todo Просмотром будем считаться вызов у менеджера методов получения задачи по идентификатору — getTask(), getSubtask() и getEpic().
// От повторных просмотров избавляться не нужно.
// public Task getHistory(){
//    return task;
// }
private int id = 0;

    private HashMap<Integer, Epic> epicHash = new HashMap<Integer, Epic>();
    private HashMap<Integer, SubTask> subEpicHash = new HashMap<Integer, SubTask>();
    private HashMap<Integer, Task> taskArray = new HashMap<Integer, Task>();

    public HashMap<Integer, Epic> getEpicHash() {
        return epicHash;
    }

    public HashMap<Integer, SubTask> getSubEpicHash() {
        return subEpicHash;
    }

    public HashMap<Integer, Task> getTaskArray() {
        return taskArray;
    }

    public Task getTaskById(int id) {
        return taskArray.get(id);
    }

    public Epic getEpicById(int id) {
        return epicHash.get(id);
    }

    public SubTask getSubtaskById() {
        return subEpicHash.get(id);
    }

    public ArrayList<Epic> getEpicHashValues() {
        return new ArrayList<>(epicHash.values());
    }

    public ArrayList<Task> getValuesSubTask() {
        return new ArrayList<>(subEpicHash.values());
    }

    public ArrayList<Task> getTaskValues() {
        return new ArrayList<>(taskArray.values());
    }

    @Override
    public void add(Task task, TaskStatus taskStatus) {
        task.setId(id++);
        taskArray.put(task.getId(), task);
    }

    @Override
    public void addEpicTask(Epic epic, TaskStatus taskStatus) {
        epic.setId(id++);
        epicHash.put(epic.getId(), epic);
    }


    @Override
    public void addSubEpicTask(SubTask subtask, TaskStatus taskStatus) {
        subtask.setId(id++);
        subEpicHash.put(subtask.getId(), subtask);
        johnTheRipper(getEpicById(subtask.getEpicId()), taskStatus);
    }

    @Override
    public void updateSubEpic(SubTask subtask, TaskStatus taskStatus) {
        subEpicHash.put(subtask.getId(), subtask);
        johnTheRipper(getEpicById(subtask.getEpicId()), taskStatus);
    }

    @Override
    public void removeSubTask(int id, SubTask subtask, TaskStatus taskStatus) {
        int Ids = subEpicHash.get(id).getEpicId();
        epicHash.get(Ids).getSubtaskId().remove(id);
        johnTheRipper(getEpicById(subtask.getEpicId()), taskStatus);
        subEpicHash.remove(id);
    }

    @Override
    public void johnTheRipper(Epic epic, TaskStatus taskStatus) {
        epic.setStatus(taskStatus.NEW);
        ArrayList<Integer> subTaskId = epic.getSubtaskId();
        for (int id : subTaskId) {
            if (subEpicHash.get(id).getStatus().equals(taskStatus.DONE)) {
                epic.setStatus(taskStatus.DONE);
                break;
            } else if (subEpicHash.get(id).getStatus().equals(taskStatus.IN_PROGRESS)) {
                epic.setStatus(taskStatus.IN_PROGRESS);
                return;
            } else if (epic.getStatus().equals(taskStatus.DONE) && taskArray.get(id).getStatus().equals(taskStatus.NEW)) {
                epic.setStatus(taskStatus.IN_PROGRESS);
                return;
            }
        }
    }

    @Override
    public void update(Task task, TaskStatus taskStatus) {
        taskArray.put(task.getId(), task);
    }

    @Override
    public void updateEpic(Epic epic, TaskStatus taskStatus) {
        epicHash.put(epic.getId(), epic);
    }

    @Override
    public ArrayList<SubTask> getAllSubtasksFromEpic(int id) {
        ArrayList<Integer> numbers = epicHash.get(id).getSubtaskId();
        ArrayList<SubTask> subtaskArrayList = new ArrayList<>();
        for (int item : numbers) {
            subtaskArrayList.add(subEpicHash.get(item));
        }
        return subtaskArrayList;
    }

    @Override
    public void removeTask(int id) {
        taskArray.remove(id);
    }

    @Override
    public void removeEpic(int id) {
        ArrayList<Integer> containerSubTasksIDs = epicHash.get(id).getSubtaskId();
        for (Integer Ids : containerSubTasksIDs) {
            epicHash.remove(Ids);
        }
        epicHash.remove(id);
    }

    @Override
    public void purgeTask() {
        taskArray.clear();
    }

    @Override
    public void purgeEpic() {
        epicHash.clear();
    }

    @Override
    public void purgeAllTask() {
        epicHash.clear();
        subEpicHash.clear();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", epicHash=" + epicHash +
                ", subEpicHash=" + subEpicHash +
                ", taskArray=" + taskArray +
                '}';
    }
}
