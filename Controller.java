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
    ArrayList<String> awailableDoors = map.getDoorsOfRoom(currentRoomId);
  }
}