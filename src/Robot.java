public class Robot {

    private int xPos;
    private int yPos;
    private Direction direction;

    public Robot(int xPos, int yPos, Direction direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setPosition(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", direction=" + direction +
                '}';
    }
}
