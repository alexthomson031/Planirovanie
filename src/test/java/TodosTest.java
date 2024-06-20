import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TodosTest {
    private final Todos todos = new Todos();
    private final SimpleTask simple5 = new SimpleTask(5, "Позвонить родителям 5123312");
    private final SimpleTask simple1 = new SimpleTask(6, "Позвонить пожарным 01");
    private final SimpleTask simple2 = new SimpleTask(10, "Позвонить скорую 03");
    private final SimpleTask simple3 = new SimpleTask(2, "Позвонить пожарным 01");
    private final SimpleTask simple4 = new SimpleTask(1, "Позвонить МЧС 112");

    @Test
    @DisplayName("Тест обучения из Нетологии")
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Добавил 1 таску, проверил название")
    public void checkOneTask() {
        todos.add(simple5);

        Task[] expected = todos.findAll();
        Task[] actual = todos.search("Позвонить родителям 5123312");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Завел 5 таск, проверил 1")
    public void checkFiveTask() {
        todos.add(simple5);
        todos.add(simple2);
        todos.add(simple1);
        todos.add(simple4);
        todos.add(simple3);

        Task[] expected = {simple4};
        Task[] actual = todos.search("Позвонить МЧС 112");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Завел 5 таск, отрицательный ответ")
    public void checkNegativeTask() {
        todos.add(simple5);
        todos.add(simple2);
        todos.add(simple1);
        todos.add(simple4);
        todos.add(simple3);

        Task[] expected = {};
        Task[] actual = todos.search("Позвонить реанимацию 111");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Завел 5 таск, проверил 5")
    public void checkSomeTasks() {
        todos.add(simple5);
        todos.add(simple2);
        todos.add(simple1);
        todos.add(simple4);
        todos.add(simple3);

        Task[] expected = {simple1, simple3};
        Task[] actual = todos.search("Позвонить пожарным 01");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchMoreThanOne() {
        todos.add(simple2);
        todos.add(simple3);
        todos.add(simple1);
        Task[] expected = {simple3, simple1};
        Task[] actual = todos.search("Позвонить пожарным 01");
        Assertions.assertArrayEquals(expected, actual);
    }
}


