public class Ref {
  public static Map map;
  public static Controller controller;
  public static Player player;

  private Ref() {
    // static class
  }

  public static void setRefs(Map mapRef, Controller controllerRef, Player playerRef) {
    map = mapRef;
    controller = controllerRef;
    player = playerRef;
  }

  public static Room getRoom(String id) {
    return map.getRoom(id);
  }

  public static String currentRoomId() {
    return controller.getCurrentRoomId();
  }

  public static Door getDoor(String id) {
    return map.getDoor(id);
  }

  public static Item getItem(String id) {
    Item output = null;
    if (player.getItem(id) != null) { // search in player inventory
      output = player.getItem(id);
    } else {
      for (Room room : map.rooms) {   // search in rooms
        if (room.getItem(id) != null) {
          output = room.getItem(id);
        }
      }
    }
    return output;
  }
}
