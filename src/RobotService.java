public class RobotService {

    // If PLACE command has been issued and move is valid (won't bring the robot off the board), move the robot 1 step forward
    protected static void moveRobot(Robot robot) {
        if (robot == null) {
            System.out.println("There is no robot to move");
            return;
        }
        if (!ValidatorUtil.validateMove(robot)) {
            System.out.println("Invalid move, you cant move off the table");
            return;
        }
        switch (robot.getDirection()) {
            case NORTH -> robot.setPosition(robot.getXPos(), robot.getYPos() + 1);
            case SOUTH -> robot.setPosition(robot.getXPos(), robot.getYPos() - 1);
            case EAST -> robot.setPosition(robot.getXPos() + 1, robot.getYPos());
            case WEST -> robot.setPosition(robot.getXPos() - 1, robot.getYPos());
        }
    }

    // If PLACE command has been issued, turn left or right based on command/turnDirection
    protected static void turnRobot(Robot robot, String turnDirection) {
        if (robot == null) {
            System.out.println("There is no robot to turn");
            return;
        }
        if (turnDirection.equals("LEFT")) {
            turnLeft(robot);
        } else if (turnDirection.equals("RIGHT")) {
            turnRight(robot);
        }
    }

    // turning the robot to the left
    private static void turnLeft(Robot robot) {
        switch (robot.getDirection()) {
            case EAST -> robot.setDirection(Direction.NORTH);
            case NORTH -> robot.setDirection(Direction.WEST);
            case WEST -> robot.setDirection(Direction.SOUTH);
            case SOUTH -> robot.setDirection(Direction.EAST);
        }
    }

    // turning the robot to the right
    private static void turnRight(Robot robot) {
        switch (robot.getDirection()) {
            case EAST -> robot.setDirection(Direction.SOUTH);
            case NORTH -> robot.setDirection(Direction.EAST);
            case WEST -> robot.setDirection(Direction.NORTH);
            case SOUTH -> robot.setDirection(Direction.WEST);
        }
    }

    // place the robot on the board if valid coordinates have been used else return null;
    // returns new Robot
    protected static Robot placeRobot(int xPos, int yPos, Direction direction) {
        if (!ValidatorUtil.validatePlacement(xPos, yPos)) {
            throw new IllegalArgumentException("Invalid placement, place the robot on the table!");
        }
        return new Robot(xPos, yPos, direction);
    }
}
