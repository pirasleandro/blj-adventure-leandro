import java.util.ArrayList;

public class Player {
  public String name;
  public int maxHealth = 20;
  private int health = maxHealth;
  public int defense = 5;
  public ArrayList<Item> items = new ArrayList<Item>();

  public Player(String name) {
    this.name = name;
  }

  public void printInventory() {
    if (items.size() > 0) {
      for (Item item : items) {
        System.out.println("[" + items.indexOf(item) + "]> " + item.getInfo());
      }
    } else {
      System.out.println("There are no items in your inventory.");
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

  public void removeItem(String id) {
    items.remove(getItem(id));
  }

  public void heal(int hp) {
    if (health + hp > maxHealth) {
      health = maxHealth;
    } else {
      health += hp;
    }
  }

  public void hurt(int hp) {
    if (health - hp < 0) {
      kill();
    } else {
      health -= hp;
    }
  }

  public void kill() {
    health = 0;
  }
  
  public void printHealthbar() {
    ASCIIart.printBar(health, maxHealth, AnsiColors.RED, AnsiColors.BLACK_BRIGHT);
  }

  public int getHealth() {
    return health;
  }

  public int getMaxHealth() {
    return maxHealth;
  }

  public int itemCount() {
    return items.size();
  }
}
