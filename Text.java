import java.util.ArrayList;
import java.util.Scanner;

public class Text {
    private static Scanner scanner = new Scanner(System.in);
    // all place holder/ beggining info for user
    private static String currentLocation = "unknown";
    private static String currentDirection = "unknown";
    private static String currentInventory = "";

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        //intro
        System.out.println("You find yourself in a mysterious area.");
        System.out.println("\nnorth / south / east / west / look / quit");
        boolean gameRunning = true;
        while (gameRunning) {
            
            System.out.print("\nEnter your command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            String result = processCommand(command);

            System.out.println(result);

            if (isGameOver()) {
                gameRunning = false;
            }

            ArrayList<String> currentData = currentAction(currentLocation, currentDirection, currentInventory);
            System.out.println(currentData);
        }
    }

    private static String processCommand(String command) {
        String result = "";

        if (command.equals("command list") || command.equals("cmd")) {
            // List commands
            result = "north / south / east / west / look / quit";
        } else if (command.equals("north") || command.equals("n")) {
            // head north
            result = "You head north.";
            currentDirection = "North";
        } else if (command.equals("south") || command.equals("s")) {
            // head south
            result = "You head south.";
            currentDirection = "South";
        } else if (command.equals("east") || command.equals("e")) {
            // head east
            result = "You head east.";
            currentDirection = "East";
        } else if (command.equals("west") || command.equals("w")) {
            // head west
            result = "You head west.";
            currentDirection = "West";
        } else if (command.equals("look")) {
            // Examine surroundings
            result = "You look around, you see " + currentLocation + ".";
        } else if (command.equals("quit") || command.equals("q")) {
            // Quit the game
            result = "You decided to die.";
        } else {
            // Invalid command
            result = "Not a command";
        }

        return result;
    }

    public static ArrayList<String> currentAction(String location, String direction, String inventory) {
        ArrayList<String> current = new ArrayList<>();
        current.add("Location: " + location);
        current.add("Direction: " + direction);
        current.add("Inventory: " + inventory);

        return current;
    }

    public static void setLocation(String location) {
        
    }

    public static void setInventory(String inventory) {

    }

    private static boolean isGameOver() {
        return false;
    }
}