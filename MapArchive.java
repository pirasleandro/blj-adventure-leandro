public class MapArchive {
  private MapArchive() {
    // static class
  }

  public static final Map TESTING_MAP = new Map(
    new Room[] {
      new Room("starter_room", "Starter Room",
        "+-----------+\n" +
        "|   STARTER |\n" + 
        "|           a\n" +
        "+------ b --+"
      ),
      new Room("second_room", "Second Room",
        "+----------+\n" +
        "|   SECOND |\n" + 
        "a          |\n" +
        "+-- b -----+"
      ),
      new Room("third_room", "Third Room",
        "+-- a -------- b --+\n" +
        "|   THIRD ROOM     |\n" + 
        "|                  |\n" +
        "+------------------+"
      )
    },
    new Door[] {
      new Door("start_second", "starter_room", "second_room"),
      new Door("start_third", "starter_room", "third_room"),
      new Door("second_third", "second_room", "third_room")
    }
    );
}
