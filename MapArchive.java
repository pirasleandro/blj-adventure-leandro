public class MapArchive {

  private MapArchive() {
    // static class
  }

  public static final Map TESTING_MAP = new Map(AnsiColors.WHITE,
    new Room[] {
      new Room("spawn_room", "Spawn Room",
      new Item[]{
        new Coin("coin", "Coin", "A shiny coin."),
        new Coin("coin2", "Coin", "A shiny coin."),
        new Coin("coin3", "Coin", "A shiny coin.")
      }, ASCIIart.simpleRoom("---", "   ", "|", "   ", "B", "   ", "RRR", "   ")),
      new Room("second_room", "Second Room", new Item[0],
        ASCIIart.simpleRoom("---", "   ", "B", "   ", "|", "   ", "GGG", "   ")),
      new Room("third_room", "Third Room", new Item[0],
        ASCIIart.hallwayHorizontal("RRR", "   ", "GGG", "   ", "|", "   ", "|", "   ", "---", "   ", "---", "   "))
    },
    new Door[] {
      new Door("spawn_second", "Blue Door", "spawn_room", "second_room", false),
      new Door("spawn_third", "Red Door", "spawn_room", "third_room", false),
      new Door("second_third", "Green Door", "second_room", "third_room", false)
    }
  );

  public static final Map LIGHT_CONTAINMENT = new Map(AnsiColors.WHITE,
    new Room[] {
      new Room("spawn_room", "Checkpoint", new Item[0], ASCIIart.bigRoom(AnsiColors.BLACK_BOLD_BRIGHT, "---", "   ", "---", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "---", "   ", "---", "   "))
    },
    new Door[] {

    }
  );

  public static final Map ENTRANCE_ZONE = new Map(AnsiColors.WHITE_BRIGHT,
    new Room[] {
      new Room("spawn_room", "Entrance", new Item[0],
        ASCIIart.bigRoom("LLL","D01","LLL","D02","|","   ","|","   ","L","D03","|","   ","WWW","E01","WWW","E02")
      ),
      new Room("hallway_1", "Hallway", new Item[] {
          new Weapon("fire_extinguisher", "Fire Extinguisher", "Can be used as a weapon.", 5)
        },
        ASCIIart.hallwayHorizontal("LLL","D04","LLL","D05","L","D03","|","   ","LLL","D06","LLL","D07")
      ),
      new Room("cafeteria", "Cafeteria", new Item[] {
          new Food("pizza", "Pizza", "A slice of pizza. Restores some health.", 20)
        },
        ASCIIart.bigRoom("---", "   ", "---", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "LLL", "D04", "LLL", "D05")
      ),
      new Room("office_1", "Office", new Item[0],
        ASCIIart.simpleRoom("LLL", "D06", "|", "   ", "|", "   ", "---", "   ")
      ),
      new Room("office_2", "Office", new Item[] {
          new Keycard("key_1", "Key", "Security Room", "hallway_security")
        },
        ASCIIart.simpleRoom("LLL", "D07", "|", "   ", "|", "   ", "---", "   ")
      ),
      new Room("office_3", "Office", new Item[0],
        ASCIIart.simpleRoom("---", "   ", "|", "   ", "L", "D10", "---", "   ")
      ),
      new Room("wc", "WC", new Item[0],
        ASCIIart.simpleRoom("---", "   ", "|", "   ", "|", "   ", "LLL", "D02")
      ),
      new Room("hallway_2", "Hallway", new Item[0], 
        ASCIIart.hallwayVertical("LLL", "D08", "L", "D09", "L", "D10", "L", "D11", "|", "   ", "LLL", "D01")
      ),
      new Room("weaponry", "Weaponry", new Item[] {
          new Weapon("gun", "Gun", "A simple gun. It's loaded.", 100)
        },
        ASCIIart.simpleRoom("---", "   ", "|", "   ", "L", "D09", "---", "   ")
      ),
      new Room("security", "Security", new Item[] {
          new Keycard("key_2", "Key", "Checkpoint Key", "checkpoint_end", "checkpoint_end_2")
        },
        ASCIIart.simpleRoom("---", "   ", "L", "D11", "|", "   ", "---", "   ")
      ),
      new Room("checkpoint", "Checkpoint", new Item[0],
        ASCIIart.bigRoom("CCC", "E03", "CCC", "E04", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "LLL", "D08", "---", "   ")
      ),
      new Room("end_room", "Checkpoint", new Item[0],
        ASCIIart.bigRoom("---", "   ", "---", "   ", "|", "   ", "|", "   ", "|", "   ", "|", "   ", "CCC", "E03", "CCC", "E04")
      )
    },
    new Door[] {
      new Door("spawn_hallway_2", "D01", "spawn_room", "hallway_2", false),
      new Door("spawn_wc", "D02", "spawn_room", "wc", false),
      new Door("spawn_hallway_1", "D03", "spawn_room", "hallway_1", false),
      new Door("hallway_cafeteria_1", "D04", "hallway_1", "cafeteria", false),
      new Door("hallway_cafeteria_2", "D05", "hallway_1", "cafeteria", false),
      new Door("hallway_office_1", "D06", "hallway_1", "office_1", false),
      new Door("hallway_office_2", "D07", "hallway_1", "office_2", false),
      new Door("hallway_checkpoint", "D08", "hallway_2", "checkpoint", false),
      new Door("hallway_weaponry", "D09", "hallway_2", "weaponry", false),
      new Door("hallway_office_3", "D10", "hallway_2", "office_3", false),
      new Door("hallway_security", "D11", "hallway_2", "security", true),
      new Door("checkpoint_end_1", "E03", "checkpoint", "end_room", true),
      new Door("checkpoint_end_2", "E04", "checkpoint", "end_room", true),
      new Door("spawn_spawn_1", "E01", "spawn_room", "spawn_room", true),
      new Door("spawn_spawn_2", "E02", "spawn_room", "spawn_room", true)
    },
    MapArchive.LIGHT_CONTAINMENT
  );
}
