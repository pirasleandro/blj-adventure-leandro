public class Room {
  public String id;
  public String name;
  public String asciiArt;

  public Room(String id, String name, String asciiArt) {
    this.id = id;
    this.name = name;
    this.asciiArt = asciiArt;
  }

  public void print() {
    System.out.println(
      "[" + name + "]\n" +
      asciiArt
    );
  }
}