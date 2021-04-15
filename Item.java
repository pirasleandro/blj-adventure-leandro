public class Item {
  String name;
  String id;
  String description;
  boolean useable;

  public Item(String name, String id, boolean useable) {
    this.name = name;
    this.id = id;
    this.useable = useable;
  }

  public void use() {
    if (useable) {
      System.out.println("Nothing happened.");
    } else {
      System.out.println("This item can't be used.");
    }
  }
}