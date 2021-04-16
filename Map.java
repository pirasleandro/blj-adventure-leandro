import java.util.ArrayList;

public class Map {
  public Room[] rooms;
  public Door[] doors;
  private static final Room DEBUG_ROOM = new Room("debug_room", "Room not found.",
    "+------------------+\n" +
    "|  THIS ROOM DOES  |\n" + 
    "|  NOT EXIST       |\n" +
    "+------------------+"
  );
  private static final Door DEBUG_DOOR = new Door("debug_door", "Door not found.", "debug_room", "debug_room");

  public Map(Room[] rooms, Door[] doors) {
    this.rooms = rooms;
    this.doors = doors;
  }

  public Room getRoom(String id) {
    Room output = null;
    boolean roomFound = false;
    for (Room room : rooms) {
      if (room.id == id) {
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
      if (door.id == id) {
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
      if (door.roomId1 == id || door.roomId2 == id) {
        output.add(door.id);
      }
    }
    return output;
  }
}