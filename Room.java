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
    this.asciiArt = colorDoors(asciiArt);
  }

  private String colorDoors(String asciiArt) {
    asciiArt = asciiArt.replace("RRR", AnsiColors.RED + "═══" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("R", AnsiColors.RED + "║" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("YYY", AnsiColors.YELLOW + "═══" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("Y", AnsiColors.YELLOW + "║" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("GGG", AnsiColors.GREEN + "═══" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("G", AnsiColors.GREEN + "║" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("BBB", AnsiColors.BLUE + "═══" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("B", AnsiColors.BLUE + "║" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("PPP", AnsiColors.PURPLE + "═══" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("P", AnsiColors.PURPLE + "║" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("CCC", AnsiColors.CYAN + "═══" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("C", AnsiColors.CYAN + "║" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("WWW", AnsiColors.WHITE + "═══" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("W", AnsiColors.WHITE + "║" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("LLL", AnsiColors.BLACK_BRIGHT + "═══" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("L", AnsiColors.BLACK_BRIGHT + "║" + AnsiColors.RESET);
    asciiArt = asciiArt.replace("---", "───");
    asciiArt = asciiArt.replace("|", "│");
    return asciiArt;
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