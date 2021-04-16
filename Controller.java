import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
  private Map map;
  String currentRoomId;

  public Controller(Map map, String starterRoomId) {
    this.map = map;
    this.currentRoomId = starterRoomId;
  }

  public void printCurrentRoom() {
    map.getRoom(currentRoomId).print();
  }

  public void getInput() {
    Scanner scan = new Scanner(System.in);
    System.out.println("[1] = inspect room");
    System.out.println("[2] = leave room");
    String input = scan.nextLine();
    switch (input) {
      case "1" -> {
        //todo
      }
      case "2" -> {
        leaveRoom();
      }
    }
  }

  private void leaveRoom() {
    Scanner scan = new Scanner(System.in);
    ArrayList<String> awailableDoors = map.getDoorsOfRoom(currentRoomId);
    int input = 0;
    for (int i = 0; i < awailableDoors.size(); i++) {
      System.out.println("[" + i + "]--> " + map.getDoor(awailableDoors.get(i)).name);
    }
    System.out.println("[" + awailableDoors.size() + "]--> cancel");
    try {
      input = Integer.parseInt(scan.nextLine());
      if (input != awailableDoors.size()) {
        useDoor(awailableDoors.get(input));
      }
    } catch (Exception e) {
      System.out.println("Incorrect input. Try again.");
    }
  }

  private void useDoor(String id) {
    Door door = map.getDoor(id);
    if (door.roomId1 == currentRoomId) {
      currentRoomId = door.roomId2;
    } else if (door.roomId2 == currentRoomId) {
      currentRoomId = door.roomId1;
    } else {
      System.out.println("The door you want to use is not in your current room.");
    }
  }
}