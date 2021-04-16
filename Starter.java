public class Starter {
  public static boolean gameOver = false;
  public static void main(String[] args) {
    Map map = MapArchive.TESTING_MAP;
    Controller controller = new Controller(map,"starter_room");
    do {
      controller.printCurrentRoom();
      controller.getInput();
    } while (!gameOver);
  }
}