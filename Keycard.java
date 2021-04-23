public class Keycard extends Item {
  public String[] doorIds;

  public Keycard(String id, String name, String description, String... door_id) {
    super(id, name, description);
    this.doorIds = door_id;
  }

  @Override
  void use(String currentRoomId) {
    for (int i = 0; i < doorIds.length; i++) {
      Door door = Ref.getDoor(doorIds[i]);
      Room room = Ref.getRoom(currentRoomId);
      if (door.roomId1 == room.id || door.roomId2 == room.id) {
        door.isLocked = !door.isLocked;
      }
    }
  }

  @Override
  void use() {
    use(Ref.controller.currentRoomId);
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