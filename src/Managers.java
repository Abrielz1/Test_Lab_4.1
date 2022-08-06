import java.util.ArrayList;
import java.util.HashMap;

public class Managers implements TaskManager {
    @Override
    public HashMap<Integer, Epic> getEpicHash() {
        return null;
    }

    @Override
    public HashMap<Integer, SubTask> getSubEpicHash() {
        return null;
    }

    @Override
    public HashMap<Integer, Task> getTaskArray() {
        return null;
    }

    @Override
    public Task getTaskById(int id) {
        return null;
    }

    @Override
    public Epic getEpicById(int id) {
        return null;
    }

    @Override
    public SubTask getSubtaskById() {
        return null;
    }

    @Override
    public ArrayList<Epic> getEpicHashValues() {
        return null;
    }

    @Override
    public ArrayList<Task> getValuesSubTask() {
        return null;
    }

    @Override
    public ArrayList<Task> getTaskValues() {
        return null;
    }

    @Override
    public void add(Task task, TaskStatus taskStatus) {

    }

    @Override
    public void addEpicTask(Epic epic, TaskStatus taskStatus) {

    }

    @Override
    public void addSubEpicTask(SubTask subtask, TaskStatus taskStatus) {

    }

    @Override
    public void update(Task task, TaskStatus taskStatus) {

    }

    @Override
    public void updateEpic(Epic epic, TaskStatus taskStatus) {

    }

    @Override
    public void johnTheRipper(Epic epic, TaskStatus taskStatus) {

    }

    @Override
    public void updateSubEpic(SubTask subtask, TaskStatus taskStatus) {

    }

    @Override
    public ArrayList<SubTask> getAllSubtasksFromEpic(int id) {
        return null;
    }

    @Override
    public void removeTask(int id) {

    }

    @Override
    public void removeEpic(int id) {

    }

    @Override
    public void removeSubTask(int id, SubTask subtask, TaskStatus taskStatus) {

    }

    @Override
    public void purgeTask() {

    }

    @Override
    public void purgeEpic() {

    }

    @Override
    public void purgeAllTask() {

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

    //todo У Managers будет метод getDefault()
    // При этом вызывающему неизвестен конкретный класс, только то, что объект, который возвращает getDefault(),
    // реализует интерфейс TaskManager.

  //  public TaskManager getDefault(){
   //     return TaskManager;
   // }
}
