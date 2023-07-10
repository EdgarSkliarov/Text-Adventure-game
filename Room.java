import java.util.HashMap;

class Room {
    private String name;
    private String description;
    private HashMap<String, Room> exits;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void enter() {
        System.out.println("You enter the " + name + ".");
    }
}
