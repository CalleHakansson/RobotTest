public class ValidatorUtil {

    // validates if PLACE-command would cause placement off the board
    public static boolean validatePlacement(int xPos, int yPos) {
        return (xPos >= 0 && xPos <= 4) && (yPos >= 0 && yPos <= 4);
    }

    // validates if MOVE-command would cause the robot to move off the board
    public static boolean validateMove(Robot robot) {
        Direction direction = robot.getDirection();
        if (direction == Direction.NORTH && robot.getYPos() < 4) {
            return true;
        }
        if (direction == Direction.SOUTH && robot.getYPos() > 0) {
            return true;
        }
        if (direction == Direction.EAST && robot.getXPos() < 4) {
            return true;
        }
        if (direction == Direction.WEST && robot.getXPos() > 0) {
            return true;
        }
        return false;
    }
}
