import java.util.ArrayList;
    public class Epic extends Task {
        private ArrayList<Integer> subTaskId;

        Epic(String name, String description, String status) {
            super(name, description, status);
            subTaskId = new ArrayList<>();
        }

        public ArrayList<Integer> getSubtaskId() {
            return subTaskId;
        }

        public void setSubtaskId(ArrayList<Integer> subtaskId) {
            this.subTaskId = subtaskId;
        }

        @Override
        public String toString() {
            return "Epic{" +
                    "subTaskId=" + getSubtaskId() +
                    ", id=" + getId() +
                    ", name='" + getTitle() + '\'' +
                    ", description='" + getDescription() + '\'' +
                    ", status='" + getStatus() + '\'' +
                    '}';
        }
    }

