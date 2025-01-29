import static org.junit.Assert.*;

import org.junit.Test;

public class RobotServiceTest {

    // Moves the robot one step to the NORTH if it doesn't cause robot to move off the board, then it doesn't move
    @Test
    public void testMoveRobotNorth() {
        Robot robot = new Robot(2, 2, Direction.NORTH);
        RobotService.moveRobot(robot);
        assertEquals(3, robot.getYPos());
        RobotService.moveRobot(robot);
        assertEquals(4, robot.getYPos());
        RobotService.moveRobot(robot);
        assertEquals(4, robot.getYPos());
    }

    // Moves the robot one step to the SOUTH if it doesn't cause robot to move off the board, then it doesn't move
    @Test
    public void testMoveRobotSouth() {
        Robot robot = new Robot(2, 2, Direction.SOUTH);
        RobotService.moveRobot(robot);
        assertEquals(1, robot.getYPos());
        RobotService.moveRobot(robot);
        assertEquals(0, robot.getYPos());
        RobotService.moveRobot(robot);
        assertEquals(0, robot.getYPos());
    }

    // Moves the robot one step to the EAST if it doesn't cause robot to move off the board, then it doesn't move
    @Test
    public void testMoveRobotEast() {
        Robot robot = new Robot(2, 2, Direction.EAST);
        RobotService.moveRobot(robot);
        assertEquals(3, robot.getXPos());
        RobotService.moveRobot(robot);
        assertEquals(4, robot.getXPos());
        RobotService.moveRobot(robot);
        assertEquals(4, robot.getXPos());
    }

    // Moves the robot one step to the WEST if it doesn't cause robot to move off the board, then it doesn't move
    @Test
    public void testMoveRobotWest() {
        Robot robot = new Robot(2, 2, Direction.WEST);
        RobotService.moveRobot(robot);
        assertEquals(1, robot.getXPos());
        RobotService.moveRobot(robot);
        assertEquals(0, robot.getXPos());
        RobotService.moveRobot(robot);
        assertEquals(0, robot.getXPos());
    }

    // Turns the robot to the left all the way around
    @Test
    public void testTurnRobotLeft() {
        Robot robot = new Robot(2, 2, Direction.NORTH);
        RobotService.turnRobot(robot, "LEFT");
        assertEquals(Direction.WEST, robot.getDirection());
        RobotService.turnRobot(robot, "LEFT");
        assertEquals(Direction.SOUTH, robot.getDirection());
        RobotService.turnRobot(robot, "LEFT");
        assertEquals(Direction.EAST, robot.getDirection());
        RobotService.turnRobot(robot, "LEFT");
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    // Turns the robot to the right all the way around
    @Test
    public void testTurnRobotRight() {
        Robot robot = new Robot(2, 2, Direction.NORTH);
        RobotService.turnRobot(robot, "RIGHT");
        assertEquals(Direction.EAST, robot.getDirection());
        RobotService.turnRobot(robot, "RIGHT");
        assertEquals(Direction.SOUTH, robot.getDirection());
        RobotService.turnRobot(robot, "RIGHT");
        assertEquals(Direction.WEST, robot.getDirection());
        RobotService.turnRobot(robot, "RIGHT");
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    // turns the robot left and right, twice
    @Test
    public void testTurnRobotLeftAndRight() {
        Robot robot = new Robot(2, 2, Direction.NORTH);
        RobotService.turnRobot(robot, "LEFT");
        assertEquals(Direction.WEST, robot.getDirection());
        RobotService.turnRobot(robot, "RIGHT");
        assertEquals(Direction.NORTH, robot.getDirection());
        RobotService.turnRobot(robot, "RIGHT");
        assertEquals(Direction.EAST, robot.getDirection());
        RobotService.turnRobot(robot, "LEFT");
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    // Incorrect input causes the robot to not turn
    @Test
    public void testTurnRobotWrongInput() {
        Robot robot = new Robot(2, 2, Direction.NORTH);
        RobotService.turnRobot(robot, "Left");
        assertEquals(Direction.NORTH, robot.getDirection());
        RobotService.turnRobot(robot, "UP");
        assertEquals(Direction.NORTH, robot.getDirection());
        RobotService.turnRobot(robot, "Right");
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    // Returns a robot if the placement is valid
    @Test
    public void testPlaceRobotCorrectly() {
        Robot robot = RobotService.placeRobot(2, 2, Direction.NORTH);
        assertNotNull(robot);
    }

    // Returns null if the placement is invalid
    @Test
    public void testPlaceRobotIncorrectly() {
        assertThrows(IllegalArgumentException.class, () -> {
                    RobotService.placeRobot(5, 2, Direction.SOUTH);
                }
        );
    }
}
