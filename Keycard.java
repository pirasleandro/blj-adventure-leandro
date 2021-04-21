public class Keycard extends Item {
  public String door_id;

  public Keycard(String id, String name, String description, String door_id) {
    super(id, name, description);
    this.door_id = door_id;
  }

  @Override
  void use(String currentRoomId) {
    Door door = map.getDoor(door_id);
    Room room = map.getRoom(currentRoomId);
    if (door.roomId1 == room.id || door.roomId2 == room.id) {
      door.isLocked = !door.isLocked;
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
