public class Weapon extends Item {
  public float damage;

  public Weapon(String id, String name, String description, float damage) {
    super(id, name, description);
    this.damage = damage;
  }

  @Override
  void use(String currentRoomId) {
    // TODO Auto-generated method stub
    
  }

  @Override
  void take() {
    // TODO Auto-generated method stub
    
  }

  @Override
  void drop() {
    // TODO Auto-generated method stub
    
  }
  
}
