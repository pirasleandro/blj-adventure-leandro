public class Coin extends Item {

  // temp class used to debug
  public Coin(String id, String name, String description) {
    super(id, name, description);
  }

  @Override
  void use(String currentRoomId) {
    ConsoleUI.cToClose("This item can't be used.");
  }

  @Override
  void use() {
    ConsoleUI.cToClose("This item can't be used.");
  }

  @Override
  void take() {
    ConsoleUI.cToClose("You picked up a coin.");
  }

  @Override
  void drop() {
    ConsoleUI.cToClose("You dropped the coin.");
  }
}
