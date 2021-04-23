import boxdrawing.*;

public class ASCIIart {
  private ASCIIart() {
    // static class
  }

  /**
   * Replaces Specific Strings with colored Boxdrawing characters.
   * @param asciiArt  the input String
   * @param reset     ansi color-code of the standard wallcolor
   * @return          the input String with replaced characters
   */
  public static String colorDoors(String asciiArt, String reset) {
    asciiArt = asciiArt.replace("RRR", AnsiColors.RED + "═══" + reset);
    asciiArt = asciiArt.replace("R", AnsiColors.RED + "║" + reset);
    asciiArt = asciiArt.replace("YYY", AnsiColors.YELLOW + "═══" + reset);
    asciiArt = asciiArt.replace("Y", AnsiColors.YELLOW + "║" + reset);
    asciiArt = asciiArt.replace("GGG", AnsiColors.GREEN + "═══" + reset);
    asciiArt = asciiArt.replace("G", AnsiColors.GREEN + "║" + reset);
    asciiArt = asciiArt.replace("BBB", AnsiColors.BLUE + "═══" + reset);
    asciiArt = asciiArt.replace("B", AnsiColors.BLUE + "║" + reset);
    asciiArt = asciiArt.replace("PPP", AnsiColors.PURPLE + "═══" + reset);
    asciiArt = asciiArt.replace("P", AnsiColors.PURPLE + "║" + reset);
    asciiArt = asciiArt.replace("CCC", AnsiColors.CYAN + "═══" + reset);
    asciiArt = asciiArt.replace("C", AnsiColors.CYAN + "║" + reset);
    asciiArt = asciiArt.replace("WWW", AnsiColors.WHITE + "═══" + reset);
    asciiArt = asciiArt.replace("W", AnsiColors.WHITE + "║" + reset);
    asciiArt = asciiArt.replace("LLL", AnsiColors.BLACK_BRIGHT + "═══" + reset);
    asciiArt = asciiArt.replace("L", AnsiColors.BLACK_BRIGHT + "║" + reset);
    asciiArt = asciiArt.replace("---", "───");
    asciiArt = asciiArt.replace("|", "│");
    return asciiArt;
  }

  /**
   * Generates a simple 1x1 room with a possible single door at every wall.
   * Every wall is described by either a color-code for a door or ---/| for a normal wall.
   * Three characters will be replaced with a horizontal wall/door and a single
   * character will be raplaced with a vertical wall/door.
   * @param color     ansi color-code of the standard wallcolor
   * @param up        character code of upper wall
   * @param upDesc    description of upper wall
   * @param left      character code of left wall
   * @param leftDesc  description of left wall
   * @param right     character code of right wall
   * @param rightDesc description of right wall
   * @param down      character code lower wall
   * @param downDesc  description of lower wall
   * @return
   */
  public static String simpleRoom(String color, String up, String upDesc, String left, String leftDesc, String right, String rightDesc, String down, String downDesc) {
    String output = (
      color + "┌───" + up + "───┐\n" +
      "│   " + upDesc + "   │\n" +
      left + " " + leftDesc + " " + rightDesc + " " + right + "\n" +
      "│   " + downDesc + "   │\n" +
      "└───" + down + "───┘" + AnsiColors.RESET
    );
    return colorDoors(output, color);
  }

  public static String simpleRoom(String up, String upDesc, String left, String leftDesc, String right, String rightDesc, String down, String downDesc) {
    return simpleRoom(AnsiColors.WHITE, up, upDesc, left, leftDesc, right, rightDesc, down, downDesc);
  }

  public static String hallwayHorizontal(String color, String up, String upDesc, String up2, String upDesc2, String left, String leftDesc, String right, String rightDesc, String down, String downDesc, String down2, String downDesc2) {
    String output = (
      color + "┌───" + up + "────────" + up2 + "───┐\n" +
      "│   " + upDesc + "        " + upDesc2 + "   │\n" +
      left + " " + leftDesc + "            " + rightDesc + " " + right + "\n" +
      "│   " + downDesc + "        " + downDesc2 + "   │\n" +
      "└───" + down + "────────" + down2 + "───┘" + AnsiColors.RESET
    );
    return colorDoors(output, color);
  }

  public static String hallwayHorizontal(String up, String upDesc, String up2, String upDesc2, String left, String leftDesc, String right, String rightDesc, String down, String downDesc, String down2, String downDesc2) {
    return hallwayHorizontal(AnsiColors.WHITE, up, upDesc, up2, upDesc2, left, leftDesc, right, rightDesc, down, downDesc, down2, downDesc2);
  }

  public static String hallwayVertical(String color, String up, String upDesc, String left, String leftDesc, String left2, String leftDesc2, String right, String rightDesc, String right2, String rightDesc2, String down, String downDesc) {
    String output = (
      color + "┌───" + up + "───┐\n" +
      "│   " + upDesc + "   │\n" +
      left + " " + leftDesc + " " + rightDesc + " " + right + "\n" +
      "│         │\n" +
      "│         │\n" +
      "│         │\n" +
      "│         │\n" +
      left2 + " " + leftDesc2 + " " + rightDesc2 + " " + right2 + "\n" +
      "│   " + downDesc + "   │\n" +
      "└───" + down + "───┘" + AnsiColors.RESET
    );
    return colorDoors(output, color);
  }

  public static String hallwayVertical(String up, String upDesc, String left, String leftDesc, String left2, String leftDesc2, String right, String rightDesc, String right2, String rightDesc2, String down, String downDesc) {
    return hallwayVertical(AnsiColors.WHITE, up, upDesc, left, leftDesc, left2, leftDesc2, right, rightDesc, right2, rightDesc2, down, downDesc);
  }

  public static String bigRoom(String color, String up, String upDesc, String up2, String upDesc2, String left, String leftDesc, String left2, String leftDesc2, String right, String rightDesc, String right2, String rightDesc2, String down, String downDesc, String down2, String downDesc2) {
    String output = (
      color + "┌───" + up + "────────" + up2 + "───┐\n" + 
      "│   " + upDesc + "        " + upDesc2 + "   │\n" +
      left + " " + leftDesc + "            " + rightDesc + " " + right + "\n" +
      "│                    │\n" +
      "│                    │\n" +
      "│                    │\n" +
      "│                    │\n" +
      left2 + " " + leftDesc2 + "            " + rightDesc2 + " " + right2 + "\n" +
      "│   " + downDesc + "        " + downDesc2 + "   │\n" +
      "└───" + down + "────────" + down2 + "───┘" + AnsiColors.RESET
    );
    return colorDoors(output, color);
  }

  public static String bigRoom(String up, String upDesc, String up2, String upDesc2, String left, String leftDesc, String left2, String leftDesc2, String right, String rightDesc, String right2, String rightDesc2, String down, String downDesc, String down2, String downDesc2) {
    return bigRoom(AnsiColors.WHITE, up, upDesc, up2, upDesc2, left, leftDesc, left2, leftDesc2, right, rightDesc, right2, rightDesc2, down, downDesc, down2, downDesc2);
  }

  public static void printBar(int current, int max, String filledColor, String emptyColor) {
    System.out.println("[Health: " + current + "/" + max + "]");
    String filled = filledColor + Block.f + AnsiColors.RESET;
    String empty = emptyColor + Block.f + AnsiColors.RESET;
    if (current == max) {
      System.out.println(Box.repeat(filled, max));
    } else if (current > 0) {
      System.out.println(
      Box.repeat(filled, current) + Box.repeat(empty, max-current));
    } else {
      System.out.println(Box.repeat(empty, max));
    }
    System.out.print("\n");
  }
}
