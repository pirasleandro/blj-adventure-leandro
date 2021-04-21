import java.util.Scanner;

public class ASCIIart {
  private ASCIIart() {
    // static class
  }

  public static String colorDoors(String asciiArt) {
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

  public static void clearConsole() {
    System.out.print("\033\143");
  }

  public static void okToContinue() {
    System.out.println("[ok]> continue");
    Scanner scan = new Scanner(System.in);
    String ok = scan.nextLine();
    while (!ok.equals("ok")) {
      ok = scan.nextLine();
    }
  }

  public static String simpleRoom(String color, String up, String upDesc, String left, String leftDesc, String right, String rightDesc, String down, String downDesc) {
    return (
      color + "┌───" + up + "───┐\n" +
      "│   " + upDesc + "   │\n" +
      left + " " + leftDesc + " " + rightDesc + " " + right + "\n" +
      "│   " + downDesc + "   │\n" +
      "└───" + down + "───┘" + AnsiColors.RESET
    );
  }

  public static String simpleRoom(String up, String upDesc, String left, String leftDesc, String right, String rightDesc, String down, String downDesc) {
    return simpleRoom(AnsiColors.WHITE, up, upDesc, left, leftDesc, right, rightDesc, down, downDesc);
  }

  public static String hallwayHorizontal(String color, String up, String upDesc, String up2, String upDesc2, String left, String leftDesc, String right, String rightDesc, String down, String downDesc, String down2, String downDesc2) {
    return (
      color + "┌───" + up + "────────" + up2 + "───┐\n" +
      "│   " + upDesc + "        " + upDesc2 + "   │\n" +
      left + " " + leftDesc + "            " + rightDesc + " " + right + "\n" +
      "│   " + downDesc + "        " + downDesc2 + "   │\n" +
      "└───" + down + "────────" + down2 + "───┘" + AnsiColors.RESET
    );
  }

  public static String hallwayHorizontal(String up, String upDesc, String up2, String upDesc2, String left, String leftDesc, String right, String rightDesc, String down, String downDesc, String down2, String downDesc2) {
    return hallwayHorizontal(AnsiColors.WHITE, up, upDesc, up2, upDesc2, left, leftDesc, right, rightDesc, down, downDesc, down2, downDesc2);
  }

  public static String hallwayVertical(String color, String up, String upDesc, String left, String leftDesc, String left2, String leftDesc2, String right, String rightDesc, String right2, String rightDesc2, String down, String downDesc) {
    return (
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
  }

  public static String hallwayVertical(String up, String upDesc, String left, String leftDesc, String left2, String leftDesc2, String right, String rightDesc, String right2, String rightDesc2, String down, String downDesc) {
    return hallwayVertical(AnsiColors.WHITE, up, upDesc, left, leftDesc, left2, leftDesc2, right, rightDesc, right2, rightDesc2, down, downDesc);
  }

  public static String bigRoom(String color, String up, String upDesc, String up2, String upDesc2, String left, String leftDesc, String left2, String leftDesc2, String right, String rightDesc, String right2, String rightDesc2, String down, String downDesc, String down2, String downDesc2) {
    return (
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
  }

  public static String bigRoom(String up, String upDesc, String up2, String upDesc2, String left, String leftDesc, String left2, String leftDesc2, String right, String rightDesc, String right2, String rightDesc2, String down, String downDesc, String down2, String downDesc2) {
    return bigRoom(AnsiColors.WHITE, up, upDesc, up2, upDesc2, left, leftDesc, left2, leftDesc2, right, rightDesc, right2, rightDesc2, down, downDesc, down2, downDesc2);
  }
}
