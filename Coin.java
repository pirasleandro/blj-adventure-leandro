public class Coin extends Item {

  public Coin(String id, String name, String description) {
    super(id, name, description);
    //TODO Auto-generated constructor stub
  }

  @Override
  void use(String currentRoomId) {
    ASCIIart.clearConsole();
    System.out.println("This item can't be used.");
    ASCIIart.okToContinue();
  }

  @Override
  void take() {
    ASCIIart.clearConsole();
    System.out.println("You picked up a coin.");
    ASCIIart.okToContinue();
  }

  @Override
  void drop() {
    System.out.println("You dropped the coin.");
  }
}
