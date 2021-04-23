public class Food extends Item {
  public float heal;

  public Food(String id, String name, String description, float heal) {
    super(id, name, description);
    this.heal = heal;
  }

  @Override
  void use(String currentRoomId) {
    player.heal(heal);
  }

  @Override
  void take() {
    ConsoleUtil.cToClose("You took " + name);
  }

  @Override
  void drop() {
    ConsoleUtil.cToClose("You dropped " + name);
  }
}
