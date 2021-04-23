import boxdrawing.*;

public class ASCIIart {
  private ASCIIart() {
    // static class
  }

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
