import java.util.Random;

public class Starter {
  public static boolean gameOver = false;
  public static int mapStage = 1;
  public static void main(String[] args) {
    Map map = MapArchive.LIGHT_CONTAINMENT;
    Player player = new Player("testing");
    Controller controller = new Controller(map,player,"starter_room");
    Item.player = controller.getPlayer();
    Item.map = controller.getMap();
    Debug.controller = controller;
    do {
      ASCIIart.clearConsole();
      controller.printCurrentRoom();
      controller.getInput();
      if (controller.getCurrentRoom() == "end_room") {
        try {
          map = map.nextStage;
          controller = new Controller(map,player,"starter_room");
          Item.player = controller.getPlayer();
          Item.map = controller.getMap();
        } catch(Exception e) {
          System.out.println("No next stage found.");
          ASCIIart.okToContinue();
          gameOver = true;
        }
      }
    } while (!gameOver);
  }
}