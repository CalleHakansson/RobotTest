import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class InputHandlerTest {

    // returns null if no file has been used as input
    @Test
    public void returnNullIfFileDoesNotExist() {
        String input = null;
        List<String> list = InputHandler.inputHandler(input);
        assertNull(list);
    }

    // returns null if input is not a file
    @Test
    public void returnNullIfFaultyInputIsUsed() {
        String input = "test";
        List<String> list = InputHandler.inputHandler(input);
        assertNull(list);
    }

    // returns null if input is empty string
    @Test
    public void returnNullIfInputIsEmpty() {
        String input = "";
        List<String> list = InputHandler.inputHandler(input);
        assertNull(list);
    }

    // returns a list of strings(commands) if a file is used as input
    @Test
    public void returnFileIfSentCorrectly() {
        String input = "test\\resourcesTest\\input1test";
        List<String> list = InputHandler.inputHandler(input);
        assertNotNull(list);
        assertEquals(8, list.size());
    }

    // returns an empty list if an empty file is used as input
    @Test
    public void returnEmptyListIfInputFileIsEmpty() {
        String input = "test\\resourcesTest\\input2test";
        List<String> list = InputHandler.inputHandler(input);
        assertNotNull(list);
        assertEquals(0, list.size());
    }

}
