abstract class Item {
  public String id;
  public String name;
  public String description;
  public boolean useable;

  public Item(String id, String name, String description, boolean useable) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.useable = useable;
  }

  abstract void use();
  abstract void take();
  abstract void drop();

  public String getInfo() {
    return ("[" + name + "]\n" + description);
  }
}