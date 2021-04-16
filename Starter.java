public class Starter {
  public static boolean gameOver = false;
  public static void main(String[] args) {
    Map map = MapArchive.TESTING_MAP;
    Player player = new Player("testing");
    Controller controller = new Controller(map,player,"starter_room");
    do {
      ASCIIart.clearConsole();
      controller.printCurrentRoom();
      controller.getInput();
    } while (!gameOver);
  }
}