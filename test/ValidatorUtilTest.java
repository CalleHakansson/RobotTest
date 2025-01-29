import static org.junit.Assert.*;
import org.junit.Test;

public class ValidatorUtilTest {

    // returns true if placement of the robot is on the board
    @Test
    public void testValidPlacement() {
        assertTrue(ValidatorUtil.validatePlacement(0, 3));
    }

    // returns false placement of the robot is off the board
    @Test
    public void testInvalidPlacement() {
        assertFalse(ValidatorUtil.validatePlacement(6, -1));
        assertFalse(ValidatorUtil.validatePlacement(5, 4));
        assertFalse(ValidatorUtil.validatePlacement(1, -1));
    }

    // returns false if the move would cause the robot to go off the board
    @Test
    public void testInvalidMovements() {
        assertFalse(ValidatorUtil.validateMove(new Robot(1, 4, Direction.NORTH)));
        assertFalse(ValidatorUtil.validateMove(new Robot(0, 4, Direction.WEST)));
        assertFalse(ValidatorUtil.validateMove(new Robot(2, 0, Direction.SOUTH)));
        assertFalse(ValidatorUtil.validateMove(new Robot(4, 4, Direction.EAST)));
    }

    // returns true if move is successful
    @Test
    public void testValidMovements() {
        assertTrue(ValidatorUtil.validateMove(new Robot(1, 3, Direction.NORTH)));
        assertTrue(ValidatorUtil.validateMove(new Robot(4, 4, Direction.WEST)));
        assertTrue(ValidatorUtil.validateMove(new Robot(2, 1, Direction.SOUTH)));
        assertTrue(ValidatorUtil.validateMove(new Robot(0, 0, Direction.EAST)));
    }
}
