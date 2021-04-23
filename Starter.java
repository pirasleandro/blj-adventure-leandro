public class Starter {
  public static boolean gameOver = false;
  public static int mapStage = 1;
  public static void main(String[] args) {
    Map map = MapArchive.ENTRANCE_ZONE;
    Player player = new Player("testing");
    Controller controller = new Controller(map,player,"starter_room");
    Item.player = controller.getPlayer();
    Item.map = controller.getMap();
    Debug.controller = controller;
    do {
      ConsoleUtil.clear();
      controller.printCurrentRoom();
      controller.getInput();
      if (controller.getCurrentRoom().equals("end_room")) {
        try {
          map = map.nextStage;
          controller = new Controller(map,player,"starter_room");
          Item.player = controller.getPlayer();
          Item.map = controller.getMap();
        } catch(Exception e) {
          ConsoleUtil.cToClose("No next stage found.");
          gameOver = true;
        }
      }
    } while (!gameOver);
  }
}