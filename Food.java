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
    System.out.println("You dropped " + name);
  }

  @Override
  void drop() {
    System.out.println("You dropped " + name);
  }
  
}