public class Coin extends Item {

  // temp class used to debug
  public Coin(String id, String name, String description) {
    super(id, name, description);
  }

  @Override
  void use(String currentRoomId) {
    ConsoleUtil.cToClose("This item can't be used.");
  }

  @Override
  void use() {
    ConsoleUtil.cToClose("This item can't be used.");
  }

  @Override
  void take() {
    ConsoleUtil.cToClose("You picked up a coin.");
  }

  @Override
  void drop() {
    ConsoleUtil.cToClose("You dropped the coin.");
  }
}
