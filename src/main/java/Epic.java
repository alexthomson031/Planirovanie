import java.util.Objects;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        Epic[] result = new Epic[0];
        for (String subtask : subtasks) {
            if (Objects.equals(subtusk, query))
                return true;
        }
        return false;
    }
}
