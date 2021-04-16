import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
  private Map map;
  private Player player;
  private String currentRoomId;

  public Controller(Map map, Player player, String starterRoomId) {
    this.map = map;
    this.player = player;
    this.currentRoomId = starterRoomId;
  }

  public void printCurrentRoom() {
    map.getRoom(currentRoomId).print();
  }

  public void getInput() {
    Scanner scan = new Scanner(System.in);
    System.out.println("[1]> inspect room");
    System.out.println("[2]> leave room");
    System.out.println("[3]> show inventory");
    String input = scan.nextLine();
    switch (input) {
      case "1" -> inspectRoom();
      case "2" -> leaveRoom();
      case "3" -> showInventory();
    }
  }

  private void leaveRoom() {
    ASCIIart.clearConsole();
    printCurrentRoom();
    Scanner scan = new Scanner(System.in);
    ArrayList<String> awailableDoors = map.getDoorsOfRoom(currentRoomId);
    for (int i = 0; i < awailableDoors.size(); i++) {
      System.out.println("[" + i + "]> " + map.getDoor(awailableDoors.get(i)).name);
    }
    System.out.println("[" + awailableDoors.size() + "]> cancel");
    int input = 0;
    try {
      input = Integer.parseInt(scan.nextLine());
      if (input != awailableDoors.size()) {
        useDoor(awailableDoors.get(input));
      }
    } catch (Exception e) {
      System.out.println("Incorrect input. Try again.");
    }
  }

  private void inspectRoom() {
    ASCIIart.clearConsole();
    printCurrentRoom();
    Room room = map.getRoom(currentRoomId);
    ArrayList<String> items = room.getItems();
    for (String string : items) {
      System.out.println("[" + items.indexOf(string) + "]> " + room.getItem(string).getInfo());
    }
    if (items.size() > 0) {
      System.out.println("[" + items.size() + "]> close");
    } else {
      System.out.println("There are no items in this room");
      System.out.println("[ok]> close");
    }
    Scanner scan = new Scanner(System.in);
    int input = 0;
    try {
      input = Integer.parseInt(scan.nextLine());
      if (input != items.size()) {
        takeItem(items.get(input));
      }
    } catch (Exception e) {
      System.out.println("Incorrect input. Try again.");
    }
  }

  private void showInventory() {
    ASCIIart.clearConsole();
    ArrayList<Item> items = player.items;
    player.printInventory();
    System.out.println("[" + items.size() + "]> close");
    Scanner scan = new Scanner(System.in);
    boolean repeat = false;
    int input = 0;
    try {
      input = Integer.parseInt(scan.nextLine());
      if (input != items.size()) {
        selectItem(items.get(input).id);
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

  private void takeItem(String id) {
    map.getRoom(currentRoomId).getItem(id).take();
    player.items.add(map.getRoom(currentRoomId).getItem(id));
    map.getRoom(currentRoomId).items.remove(map.getRoom(currentRoomId).getItem(id));
  }

  private void selectItem(String id) {
    ASCIIart.clearConsole();
    player.printInventory(id);
    System.out.println("[us]> use");
    System.out.println("[dr]> drop");
    System.out.println("[cl]> close");
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    switch (input) {
      case "us" -> player.getItem(id).use();
      case "dr" -> player.getItem(id).drop();
    }
  }
}