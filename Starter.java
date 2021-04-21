public class Starter {
  public static boolean gameOver = false;
  public static int mapStage = 1;
  public static void main(String[] args) {
    Map map = MapArchive.ENTRANCE_ZONE;
    Player player = new Player("testing");
    Controller controller = new Controller(map,player,"starter_room");
    Item.player = controller.getPlayer();
    Item.map = controller.getMap();
    do {
      ASCIIart.clearConsole();
      
      controller.printCurrentRoom();
      controller.getInput();
      if (controller.getCurrentRoom() == "end_room") {
        map = map.nextStage;
        controller = new Controller(map,player,"starter_room");
        Item.player = controller.getPlayer();
        Item.map = controller.getMap();
      }
    } while (!gameOver);
  }
}