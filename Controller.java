import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
  public String currentRoomId;
  private static Scanner scan = new Scanner(System.in);

  public Controller(String spawnerRoomId) {
    this.currentRoomId = spawnerRoomId;
  }

  public void getInput() {
    System.out.println("[l]> leave room");
    System.out.println("[i]> inspect room");
    System.out.println("[s]> show inventory");
    String input = scan.nextLine();
    switch (input) {
      case "l" -> leaveRoom();
      case "i" -> inspectRoom();
      case "s" -> showInventory();
      case "/" -> Debug.enterCommand();
    }
    ;
  }

  private void leaveRoom() {
    ConsoleUI.clear();
    ConsoleUI.printMainUI();
    ArrayList<String> awailableDoors = Ref.map.getIdsOfDoorsOfRoom(currentRoomId);
    for (int i = 0; i < awailableDoors.size(); i++) {
      System.out.println("[" + i + "]> " + Ref.getDoor(awailableDoors.get(i)).description);
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
      ConsoleUI.clear();
      ConsoleUI.printMainUI();
      System.out.println("This room has no doors.");
      ConsoleUI.cToClose();
    }
    ;
  }

  private void inspectRoom() {
    ConsoleUI.clear();
    ConsoleUI.printMainUI();
    Room room = Ref.getRoom(currentRoomId);
    ArrayList<String> items = room.getIdsOfItems();
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
    ConsoleUI.clear();
    ConsoleUI.printMainUI();
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
          ConsoleUI.cToClose("Incorrect input. Try again.");
        }
      }
      ;
    } else {
      ConsoleUI.cToClose();
    }
  }

  private void useDoor(String id) {
    Door door = Ref.getDoor(id);
    if (door.isLocked) {
      ConsoleUI.clear();
      ConsoleUI.printMainUI();
      System.out.println("The door is locked.");
      ConsoleUI.cToClose();
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
    Ref.getRoom(currentRoomId).getItem(id).take();
    Ref.player.items.add(Ref.getRoom(currentRoomId).getItem(id));
    Ref.getRoom(currentRoomId).items.remove(Ref.getRoom(currentRoomId).getItem(id));
  }

  private void selectItem(String id) {
    ConsoleUI.clear();
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
    Ref.getRoom(currentRoomId).items.add(Ref.player.getItem(id));
    Ref.player.removeItem(id);
  }

  public String getCurrentRoomId() {
    return currentRoomId;
  }

  public void setCurrentRoom(String id) {
    currentRoomId = id;
  }
}