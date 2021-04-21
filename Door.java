public class Door {
  public String id;
  public String name;
  public String roomId1;
  public String roomId2;
  public boolean isLocked;

  public Door(String id, String name, String roomId1, String roomId2, boolean isLocked) {
    this.id = id;
    this.name = name;
    this.roomId1 = roomId1;
    this.roomId2 = roomId2;
    this.isLocked = isLocked;
  }
}