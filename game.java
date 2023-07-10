import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class game {
    private static Scanner scanner = new Scanner(System.in);
    private static Room currentLocation;
    private static HashMap<String, Room> rooms = new HashMap<>();

    public static void main(String[] args) {
        createRooms();
        startGame();
    }

    private static void createRooms() {
        Room forest = new Room("Forest", "You are in a dense forest.");
        Room cave = new Room("Cave", "You are in a dark cave.");
        Room lake = new Room("Lake", "You are near a calm lake.");
        Room beach = new Room("Beach", "You are on a sandy beach.");
        Room mountainPeak = new Room("Mountain Peak", "You are at the top of a towering mountain.");
        Room volcano = new Room("Volcano", "You are near a fiery volcano.");
        Room desert = new Room("Desert", "You are in a vast desert.");
        Room undergroundCave = new Room("Underground Cavern", "You are in a mysterious underground cavern.");
        Room ancientTemple = new Room("Ancient Temple", "You are inside an ancient temple.");
        Room enchantedForest = new Room("Enchanted Forest", "You are in a magical and enchanting forest.");
        Room ruinedCity = new Room("Ruined City", "You are in a decaying and abandoned city.");
        Room deepOcean = new Room("Deep Ocean", "You are deep underwater in the ocean.");
        Room snowyTundra = new Room("Snowy Tundra", "You are in a freezing snowy tundra.");
        Room hauntedMansion = new Room("Haunted Mansion", "You are inside a spooky haunted mansion.");

        // Set the exits for each room
        forest.setExit("south", cave);
        cave.setExit("north", forest);
        cave.setExit("east", lake);
        lake.setExit("west", cave);
        lake.setExit("east", beach);
        beach.setExit("west", lake);
        mountainPeak.setExit("south", forest);
        forest.setExit("north", mountainPeak);
        forest.setExit("east", enchantedForest);
        enchantedForest.setExit("west", forest);
        enchantedForest.setExit("east", ancientTemple);
        ancientTemple.setExit("west", enchantedForest);
        ancientTemple.setExit("south", ruinedCity);
        ruinedCity.setExit("north", ancientTemple);
        ruinedCity.setExit("west", desert);
        desert.setExit("east", ruinedCity);
        desert.setExit("south", undergroundCave);
        undergroundCave.setExit("north", desert);
        undergroundCave.setExit("east", cave);
        volcano.setExit("west", cave);
        lake.setExit("north", volcano);
        snowyTundra.setExit("east", mountainPeak);
        mountainPeak.setExit("west", snowyTundra);
        deepOcean.setExit("west", beach);
        beach.setExit("east", deepOcean);

        currentLocation = forest;

        rooms.put("forest", forest);
        rooms.put("cave", cave);
        rooms.put("lake", lake);
        rooms.put("beach", beach);
        rooms.put("mountain peak", mountainPeak);
        rooms.put("volcano", volcano);
        rooms.put("desert", desert);
        rooms.put("underground cavern", undergroundCave);
        rooms.put("ancient temple", ancientTemple);
        rooms.put("enchanted forest", enchantedForest);
        rooms.put("ruinedcity", ruinedCity);
        rooms.put("deep ocean", deepOcean);
        rooms.put("snowy tundra", snowyTundra);
        rooms.put("haunted mansion", hauntedMansion);
    }

    private static void startGame() {
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

            ArrayList<String> currentData = currentAction();
            System.out.println(currentData);
        }
    }

    private static boolean isGameOver() {
        return false;
    }

    private static String processCommand(String command) {
        String result = "";

        if (command.equals("command list") || command.equals("cmd")) {
            result = "north / south / east / west / look / quit";
        } else if (command.equals("north") || command.equals("n")) {
            result = navigate("north");
        } else if (command.equals("south") || command.equals("s")) {
            result = navigate("south");
        } else if (command.equals("east") || command.equals("e")) {
            result = navigate("east");
        } else if (command.equals("west") || command.equals("w")) {
            result = navigate("west");
        } else if (command.equals("look")) {
            result = currentLocation.getDescription();
        } else if (command.equals("quit") || command.equals("q")) {
            result = "You quit";
        } else {
            result = "Not a command";
        }

        return result;
    }

    private static String navigate(String direction) {
        Room nextRoom = currentLocation.getExit(direction);
        if (nextRoom != null) {
            currentLocation = nextRoom;
            currentLocation.enter();
            return "You head " + direction;
        } else {
            return "There is a mysterious border in that direction";
        }
    }

    public static ArrayList<String> currentAction() {
        ArrayList<String> current = new ArrayList<>();
        current.add("Location: " + currentLocation.getName());

        return current;
    }
}
