import java.util.ArrayList;

import boxdrawing.*;

public class MapArchive {

  private MapArchive() {
    // static class
  }

  public static final Map TESTING_MAP = new Map(
    new Room[] {
      new Room("starter_room", "Starter Room",
      new Item[]{
        new Coin("coin", "Coin", "A shiny coin."),
        new Coin("coin2", "Coin", "A shiny coin."),
        new Coin("coin3", "Coin", "A shiny coin.")
      },
        "┌─────────┐\n" +
        "│         │\n" +
        "│         B\n" +
        "│         │\n" +
        "└───RRR───┘"
      ),
      new Room("second_room", "Second Room", new Item[0],
        "┌─────────┐\n" +
        "│         │\n" +
        "B         │\n" +
        "│         │\n" +
        "└───GGG───┘"
      ),
      new Room("third_room", "Third Room", new Item[0],
        "┌───RRR────────GGG───┐\n" + 
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
