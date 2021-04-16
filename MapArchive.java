import boxdrawing.*;

public class MapArchive {

  private MapArchive() {
    // static class
  }

  public static final Map TESTING_MAP = new Map(
    new Room[] {
      new Room("starter_room", "Starter Room",
        "┌─────────┐\n" +
        "│         │\n" +
        "│         " + ASCIIart.verticalDoor(AnsiColors.BLUE) + "\n" +
        "│         │\n" +
        "└───" + ASCIIart.horizontalDoor(AnsiColors.RED) + "───┘"
      ),
      new Room("second_room", "Second Room",
        "┌─────────┐\n" +
        "│         │\n" +
        ASCIIart.verticalDoor(AnsiColors.BLUE) + "         │\n" +
        "│         │\n" +
        "└───" + ASCIIart.horizontalDoor(AnsiColors.GREEN) + "───┘"
      ),
      new Room("third_room", "Third Room",
        "┌───" + ASCIIart.horizontalDoor(AnsiColors.RED) + "────────" + ASCIIart.horizontalDoor(AnsiColors.GREEN) + "───┐\n" + 
        "│                    │\n" +
        "│                    │\n" +
        "│                    │\n" +
        "└────────────────────┘"
      )
    },
    new Door[] {
      new Door("start_second", "Blue Door", "starter_room", "second_room"),
      new Door("start_third", "Red Door", "starter_room", "third_room"),
      new Door("second_third", "Green Door", "second_room", "third_room")
    }
    );
}
