import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    // Takes input file and returns a list of commands
    public static List<String> inputHandler(String fileName) {
        List<String> lines = new ArrayList<>();
        if (fileName == null) {
            System.out.println("File is null");
            return null;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            System.out.println("invalid file: " + e.getMessage());
        }
        return null;
    }
}
