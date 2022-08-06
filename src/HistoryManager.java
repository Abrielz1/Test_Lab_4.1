import java.util.ArrayList;

public interface HistoryManager {

    ArrayList<Task> history();   //List<Task> getHistory();

    void add(Task task);

}
