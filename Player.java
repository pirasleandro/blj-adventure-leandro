import java.util.ArrayList;

public class Player {
  public String name;
  public float health = 100;
  public float defense = 20;
  public ArrayList<Item> items = new ArrayList<Item>();

  public Player(String name) {
    this.name = name;
  }

  public void printInventory() {
    for (Item item : items) {
      System.out.println("[" + items.indexOf(item) + "]> " + item.getInfo());
    }
  }

  public void printInventory(String id) {
    for (Item item : items) {
      if (item.id == id) {
        System.out.print(AnsiColors.WHITE_BOLD);
      }
      System.out.println("[" + items.indexOf(item) + "]> " + item.getInfo() + AnsiColors.RESET);
    }
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
}
