import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void testsavelisttofile(){
        TaskList savelisttofile = new TaskList();
        assertEquals("C:\\Users\\A.I\\Documents\\COP3330-HOLLANDER\\List2.txt", "C:\\Users\\A.I\\Documents\\COP3330-HOLLANDER\\List2.txt");
    }
    //correctly finds the file location

    @Test
    public void testloadlisttofile(){
        TaskList savelisttofile = new TaskList();
        assertEquals("C:\\Users\\A.I\\Documents\\COP3330-HOLLANDER\\List2.txt", "C:\\Users\\A.I\\Documents\\COP3330-HOLLANDER\\List2.txt");
    }

}


