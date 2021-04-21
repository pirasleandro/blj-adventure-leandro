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
    ASCIIart.clearConsole();
    System.out.println("You took " + name);
    ASCIIart.okToContinue();
  }

  @Override
  void drop() {
    ASCIIart.clearConsole();
    System.out.println("You dropped " + name);
    ASCIIart.okToContinue();
  }
}
