import static org.junit.Assert.*;
import org.junit.Test;

public class TodoAppTest {

    @Test
    public void testAddTask() {
        // simple logic verification
        TodoApp.todoList.add("Task 1");
        assertEquals("Task 1", TodoApp.todoList.get(0));
    }
}
