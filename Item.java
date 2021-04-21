abstract class Item {
  public static Map map;
  public static Player player;
  public String id;
  public String name;
  public String description;

  public Item(String id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  abstract void use(String currentRoomId);
  abstract void take();
  abstract void drop();

  public String getInfo() {
    return ("[" + name + "] " + description);
  }
}