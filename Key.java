public class Key extends Item {
  public String door_id;

  public Key(String id, String name, String description, String door_id) {
    super(id, name, description);
    this.door_id = door_id;
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
