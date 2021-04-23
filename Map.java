import java.util.ArrayList;
import java.util.Random;

public class Map {
  public String id;
  public Room[] rooms;
  public Door[] doors;
  public Map nextStage;
  private static final Room DEBUG_ROOM = new Room("debug_room", "Room not found.", new Item[0],
    "+------------------+\n" +
    "|  THIS ROOM DOES  |\n" + 
    "|  NOT EXIST       |\n" +
    "+------------------+"
  );
  private static final Door DEBUG_DOOR = new Door("debug_door", "Door not found.", "debug_room", "debug_room", false);

  public Map(Room[] rooms, Door[] doors, Map nextStage) {
    this.rooms = rooms;
    this.doors = doors;
    this.nextStage = nextStage;
  }

  public Map(Room[] rooms, Door[] doors) {
    this.rooms = rooms;
    this.doors = doors;
  }

  public Map(Map map) {
    this.id = map.id;
    this.rooms = map.rooms;
    this.doors = map.doors;
    this.nextStage = map.nextStage;
  }

  public Room getRoom(String id) {
    Room output = null;
    boolean roomFound = false;
    for (Room room : rooms) {
      if (room.id.equals(id)) {
        output = room;
        roomFound = true;
      }
    }
    if (roomFound) {
      return output;
    } else {
      return DEBUG_ROOM;
    }
  }

  public Door getDoor(String id) {
    Door output = null;
    boolean doorFound = false;
    for (Door door : doors) {
      if (door.id.equals(id)) {
        output = door;
        doorFound = true;
      }
    }
    if (doorFound) {
      return output;
    } else {
      return DEBUG_DOOR;
    }
  }

  public ArrayList<String> getDoorsOfRoom(String id) {
    ArrayList<String> output = new ArrayList<String>();
    for (Door door : doors) {
      if (door.roomId1.equals(id) || door.roomId2.equals(id)) {
        output.add(door.id);
      }
    }
    return output;
  }

  public ArrayList<String> getItemsInRoom(String id) {
    return getRoom(id).getItems();
  }

  public String getMapId() {
    return id;
  }
}