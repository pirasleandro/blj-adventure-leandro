public class Food extends Item {
  public float heal;

  public Food(String id, String name, String description, float heal) {
    super(id, name, description);
    this.heal = heal;
  }

  @Override
  void use(String currentRoomId) {
    use();
  }

  @Override
  void use() {
    Ref.player.heal(heal);
  }

  @Override
  void take() {
    ConsoleUI.cToClose("You took " + name);
  }

  @Override
  void drop() {
    ConsoleUI.cToClose("You dropped " + name);
  }
}