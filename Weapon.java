public class Weapon extends Item {
  public int damage;

  public Weapon(String id, String name, String description, int damage) {
    super(id, name, description);
    this.damage = damage;
  }

  @Override
  void use(String currentRoomId) {
    // TODO Auto-generated method stub
    
  }

  @Override
  void use() {
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
