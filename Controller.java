import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
  private String currentRoomId;
  private static Scanner scan = new Scanner(System.in);

  public Controller(String spawnerRoomId) {
    this.currentRoomId = spawnerRoomId;
  }

  public void printCurrentRoom() {
    ASCIIart.printHealth(Ref.player.getHealth(), Ref.player.getMaxHealth());
    Ref.map.getRoom(currentRoomId).print();
  }

  public void getInput() {
    System.out.println("[0]> leave room");
    System.out.println("[1]> inspect room");
    System.out.println("[2]> show inventory");
    String input = scan.nextLine();
    switch (input) {
      case "0" -> leaveRoom();
      case "1" -> inspectRoom();
      case "2" -> showInventory();
      case "/" -> Debug.open();
    }
    ;
  }

  private void leaveRoom() {
    ConsoleUtil.clear();
    printCurrentRoom();
    ArrayList<String> awailableDoors = Ref.map.getDoorsOfRoom(currentRoomId);
    for (int i = 0; i < awailableDoors.size(); i++) {
      System.out.println("[" + i + "]> " + Ref.map.getDoor(awailableDoors.get(i)).name);
    }
    if (awailableDoors.size() > 1) {
      System.out.println("[c]> close");
      String input = scan.nextLine();
      if (input != "c") {
        try {
          int input2 = Integer.parseInt(input);
          useDoor(awailableDoors.get(input2));
        } catch (Exception e) {
          System.out.println("Incorrect input. Try again.");
        }
      }
      
    } else if (awailableDoors.size() > 0) {
      useDoor(awailableDoors.get(0));
    } else {
      ConsoleUtil.clear();
      printCurrentRoom();
      System.out.println("This room has no doors.");
      ConsoleUtil.cToClose();
    }
    ;
  }

  private void inspectRoom() {
    ConsoleUtil.clear();
    printCurrentRoom();
    Room room = Ref.map.getRoom(currentRoomId);
    ArrayList<String> items = room.getItems();
    for (String string : items) {
      System.out.println("[" + items.indexOf(string) + "]> " + room.getItem(string).getInfo());
    }
    if (items.size() > 0) {
      System.out.println("[" + items.size() + "]> close");
    } else {
      System.out.println("There are no items in this room");
      System.out.println("[c]> close");
    }
    int input = 0;
    try {
      input = Integer.parseInt(scan.nextLine());
      if (input != items.size()) {
        takeItem(items.get(input));
      }
    } catch (Exception e) {
      System.out.println("Incorrect input. Try again.");
    }
    ;
  }

  private void showInventory() {
    ConsoleUtil.clear();
    printCurrentRoom();
    ArrayList<Item> items = Ref.player.items;
    Ref.player.printInventory();
    if (Ref.player.itemCount() > 0) {
      System.out.println("[c]> close");
      String input = scan.nextLine();
      if (input != "c") {
        try {
        int input2 = Integer.parseInt(input);
        selectItem(items.get(input2).id);
        } catch (Exception e) {
          ConsoleUtil.cToClose("Incorrect input. Try again.");
        }
      }
      ;
    } else {
      ConsoleUtil.cToClose();
    }
  }

  private void useDoor(String id) {
    Door door = Ref.map.getDoor(id);
    if (door.isLocked) {
      ConsoleUtil.cToClose("The door is locked.");
    } else {
      if (door.roomId1.equals(currentRoomId)) {
        currentRoomId = door.roomId2;
      } else if (door.roomId2.equals(currentRoomId)) {
        currentRoomId = door.roomId1;
      } else {
        System.out.println("The door you want to use is not in your current room.");
      }
    }
  }

  private void takeItem(String id) {
    Ref.map.getRoom(currentRoomId).getItem(id).take();
    Ref.player.items.add(Ref.map.getRoom(currentRoomId).getItem(id));
    Ref.map.getRoom(currentRoomId).items.remove(Ref.map.getRoom(currentRoomId).getItem(id));
  }

  private void selectItem(String id) {
    ConsoleUtil.clear();
    Ref.player.printInventory(id);
    System.out.println("[u]> use");
    System.out.println("[d]> drop");
    System.out.println("[c]> close");
    String input = scan.nextLine();
    switch (input) {
      case "us" -> useItem(id);
      case "dr" -> dropItem(id);
    }
    ;
  }

  private void useItem(String id) {
    Ref.player.getItem(id).use(currentRoomId);
  }

  private void dropItem(String id) {
    Ref.player.getItem(id).drop();
    Ref.map.getRoom(currentRoomId).items.add(Ref.player.getItem(id));
    Ref.player.removeItem(id);
  }

  public String getCurrentRoom() {
    return currentRoomId;
  }

  public void setCurrentRoom(String id) {
    currentRoomId = id;
  }
}