public class Starter {
  public static boolean gameOver = false;
  public static int mapStage = 1;
  public static void main(String[] args) {
    Map map = MapArchive.ENTRANCE_ZONE;
    Player player = new Player("testing");
    Controller controller = new Controller("spawn_room");
    Ref.setRefs(map, controller, player);
    do {
      ConsoleUtil.clear();
      controller.printCurrentRoom();
      controller.getInput();
      if (controller.getCurrentRoom().equals("end_room")) {
        try {
          map = map.nextStage;
          controller.setCurrentRoom("spawn_room");
        } catch(Exception e) {
          ConsoleUtil.cToClose("No next stage found.");
          gameOver = true;
        }
      }
    } while (!gameOver);
  }
}