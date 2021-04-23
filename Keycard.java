public class Keycard extends Item {
  public String[] door_id;

  public Keycard(String id, String name, String description, String... door_id) {
    super(id, name, description);
    this.door_id = door_id;
  }

  @Override
  void use(String currentRoomId) {
    for (int i = 0; i < door_id.length; i++) {
      Door door = map.getDoor(door_id[i]);
      Room room = map.getRoom(currentRoomId);
      if (door.roomId1 == room.id || door.roomId2 == room.id) {
        door.isLocked = !door.isLocked;
      }
    }
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
