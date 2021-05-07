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
      if (door.roomId1.equals(room.id) || door.roomId2.equals(room.id)) {
        door.isLocked = !door.isLocked;
      }
    }
  }

  void use() {
    use(Ref.controller.currentRoomId);
  }

  @Override
  void take() {
    System.out.println("You picked up a keycard.");
  }

  @Override
  void drop() {
    System.out.println("You dropped the keycard.");
  }
}