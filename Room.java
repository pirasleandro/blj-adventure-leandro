import java.util.ArrayList;

public class Room {
  public String id;
  public String name;
  public ArrayList<Item> items = new ArrayList<Item>();
  public String asciiArt;

  public Room(String id, String name, Item[] items, String asciiArt) {
    this.id = id;
    this.name = name;
    for (int i = 0; i < items.length; i++) {
      this.items.add(items[i]);
    }
    this.asciiArt = ASCIIart.colorDoors(asciiArt);
  }

  public Item getItem(String id) {
    Item output = null;
    boolean itemFound = false;
    for (Item item : items) {
      if (item.id == id) {
        output = item;
        itemFound = true;
      }
    }
    if (itemFound) {
      return output;
    } else {
      System.out.println("Item not found.");
      return null;
    }
  }

  public ArrayList<String> getItems() {
    ArrayList<String> output = new ArrayList<String>();
    for (Item item : items) {
      output.add(item.id);
    }
    return output;
  }

  public void print() {
    System.out.println(
      "[" + name + "]\n" +
      asciiArt
    );
  }
}