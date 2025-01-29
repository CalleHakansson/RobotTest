import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    // Returns the same robot as the input instructed
    @Test
    public void testInitialPlaceCommand() {
        Robot robot = Main.takeCommand(null, "PLACE 3,4,EAST");
        assertNotNull(robot);
        assertEquals(Direction.EAST, robot.getDirection());
        assertEquals(4, robot.getYPos());
        assertEquals(3, robot.getXPos());
    }

    // First place command is performed, the second place command picks up and places the robot again
    @Test
    public void testTwoPlaceCommands() {
        Robot robot = Main.takeCommand(null, "PLACE 3 4,EAST");
        assertNotNull(robot);
        assertEquals(Direction.EAST, robot.getDirection());
        assertEquals(3, robot.getXPos());
        assertEquals(4, robot.getYPos());
        robot = Main.takeCommand(robot, "PLACE 1,2,NORTH");
        assertNotNull(robot);
        assertEquals(Direction.NORTH, robot.getDirection());
        assertEquals(1, robot.getXPos());
        assertEquals(2, robot.getYPos());
    }

    @Test
    public void testValidAndThenInvalidPlaceCommands() {
        Robot robot = Main.takeCommand(null, "PLACE 3 4,EAST");
        assertNotNull(robot);
        assertEquals(Direction.EAST, robot.getDirection());
        assertEquals(3, robot.getXPos());
        assertEquals(4, robot.getYPos());
        robot = Main.takeCommand(robot, "PLACE 5,2,NORTH");
        assertNotNull(robot);
        assertEquals(Direction.EAST, robot.getDirection());
        assertEquals(3, robot.getXPos());
        assertEquals(4, robot.getYPos());
    }

    // Doesn't place a robot if the place command is followed by faulty input
    @Test
    public void testFaultyPlaceCommand() {
        Robot robot = Main.takeCommand(null, "PLACE Hej,4,EAST");
        assertNull(robot);
        Robot robot2 = Main.takeCommand(null, "PLACE 12,NORTH");
        assertNull(robot2);
        Robot robot3 = Main.takeCommand(null, "PLACE 1,2NORTH");
        assertNull(robot3);
        Robot robot4 = Main.takeCommand(null, "PLACE,1 2 NORR");
        assertNull(robot4);
    }

    // Tests the move command, moves the robot one step north
    @Test
    public void testMoveCommand() {
        Robot robot = Main.takeCommand(null, "PLACE 3,3,NORTH");
        assertNotNull(robot);
        assertEquals(3, robot.getYPos());
        robot = Main.takeCommand(robot, "MOVE");
        assertNotNull(robot);
        assertEquals(4, robot.getYPos());
    }

    // Tests the left command, turns the robot to the left, from north to west
    @Test
    public void testLeftCommand() {
        Robot robot = Main.takeCommand(null, "PLACE 3,3,NORTH");
        assertNotNull(robot);
        assertEquals(Direction.NORTH, robot.getDirection());
        robot = Main.takeCommand(robot, "LEFT");
        assertNotNull(robot);
        assertEquals(Direction.WEST, robot.getDirection());
    }

    // Tests the right command, turns the robot to the right, from north to east
    @Test
    public void testRightCommand() {
        Robot robot = Main.takeCommand(null, "PLACE 3,3,NORTH");
        assertNotNull(robot);
        assertEquals(Direction.NORTH, robot.getDirection());
        robot = Main.takeCommand(robot, "RIGHT");
        assertNotNull(robot);
        assertEquals(Direction.EAST, robot.getDirection());
    }
}
