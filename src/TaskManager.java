import java.util.ArrayList;
import java.util.HashMap;

public interface TaskManager {

    int id = 0;

    HashMap<Integer, Epic> epicHash = new HashMap<Integer, Epic>();
    HashMap<Integer, SubTask> subEpicHash = new HashMap<Integer, SubTask>();
    HashMap<Integer, Task> taskArray = new HashMap<Integer, Task>();

   HashMap<Integer, Epic> getEpicHash();

    HashMap<Integer, SubTask> getSubEpicHash();

    HashMap<Integer, Task> getTaskArray();

    Task getTaskById(int id);

    Epic getEpicById(int id);

    SubTask getSubtaskById();

    ArrayList<Epic> getEpicHashValues();

    ArrayList<Task> getValuesSubTask();

    ArrayList<Task> getTaskValues();

    void add(Task task, TaskStatus taskStatus);

    void addEpicTask(Epic epic, TaskStatus taskStatus);

    void addSubEpicTask(SubTask subtask, TaskStatus taskStatus);

    void update(Task task, TaskStatus taskStatus);

    void updateEpic(Epic epic, TaskStatus taskStatus);

   void johnTheRipper(Epic epic, TaskStatus taskStatus);

    void updateSubEpic(SubTask subtask, TaskStatus taskStatus);

    ArrayList<SubTask> getAllSubtasksFromEpic(int id);

    void removeTask(int id);

    void removeEpic(int id);

    void removeSubTask(int id, SubTask subtask, TaskStatus taskStatus);

    void purgeTask();

    void purgeEpic();

    void purgeAllTask();

    String toString();

}
