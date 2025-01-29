import java.util.List;

public class Main {

    //InputHandler should receive the input file of your choice
    public static void main(String[] args) {
        List<String> input = InputHandler.inputHandler("src\\resources\\input1");
        performCommand(input);
    }

    //Performs the input loop
    protected static void performCommand(List<String> input) {
        Robot robot = null;
        if (input != null) {
            for (String command : input) {
                robot = takeCommand(robot, command);
            }
        }
    }

    // Takes command from input. If command is "PLACE", split line into parts to get each valid part of the command
    // Returns robot to keep the robot active between commands.
    protected static Robot takeCommand(Robot robot, String command) {
        String[] commandParts = command.split("[, ]+");
        try {
            if (commandParts[0].equals("PLACE")) {
                return RobotService.placeRobot(Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2]), Direction.valueOf(commandParts[3]));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return robot;
        }
        switch (command) {
            case "MOVE" -> RobotService.moveRobot(robot);
            case "LEFT" -> RobotService.turnRobot(robot, "LEFT");
            case "RIGHT" -> RobotService.turnRobot(robot, "RIGHT");
            case "REPORT" -> System.out.println(robot);
        }
        return robot;
    }
}