import java.util.Scanner;

public class ASCIIart {
  private ASCIIart() {
    // static class
  }

  public static String red(String string) {
    return (AnsiColors.RED + string + AnsiColors.RESET);
  }

  public static String yellow(String string) {
    return (AnsiColors.YELLOW + string + AnsiColors.RESET);
  }

  public static String green(String string) {
    return (AnsiColors.GREEN + string + AnsiColors.RESET);
  }

  public static String blue(String string) {
    return (AnsiColors.BLUE + string + AnsiColors.RESET);
  }

  public static String purple(String string) {
    return (AnsiColors.PURPLE + string + AnsiColors.RESET);
  }

  public static String cyan(String string) {
    return (AnsiColors.CYAN + string + AnsiColors.RESET);
  }

  public static String horizontalDoor(String color) {
    return (color + "═══" + AnsiColors.RESET);
  }

  public static String verticalDoor(String color) {
    return (color + "║" + AnsiColors.RESET);
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

  public static String simpleRoom(String up, String upDesc, String left, String leftDesc, String right, String rightDesc, String down, String downDesc) {
    return (
      "┌───" + up + "───┐\n" +
      "│   " + upDesc + "   │\n" +
      left + " " + leftDesc + " " + rightDesc + " " + right + "\n" +
      "│   " + downDesc + "   │\n" +
      "└───" + down + "───┘"
    );
  }

  public static String hallwayHorizontal(String up, String upDesc, String up2, String upDesc2, String left, String leftDesc, String right, String rightDesc, String down, String downDesc, String down2, String downDesc2) {
    return (
      "┌───" + up + "────────" + up2 + "───┐\n" +
      "│   " + upDesc + "        " + upDesc2 + "   │\n" +
      left + " " + leftDesc + "            " + rightDesc + " " + right + "\n" +
      "│   " + downDesc + "        " + downDesc2 + "   │\n" +
      "└───" + down + "────────" + down2 + "───┘"
    );
  }

  public static String hallwayVertical(String up, String upDesc, String left, String leftDesc, String left2, String leftDesc2, String right, String rightDesc, String right2, String rightDesc2, String down, String downDesc) {
    return (
      "┌───" + up + "───┐\n" +
      "│   " + upDesc + "   │\n" +
      left + " " + leftDesc + " " + rightDesc + " " + right + "\n" +
      "│         │\n" +
      "│         │\n" +
      "│         │\n" +
      "│         │\n" +
      left2 + " " + leftDesc2 + " " + rightDesc2 + " " + right2 + "\n" +
      "│   " + downDesc + "   │\n" +
      "└───" + down + "───┘"
    );
  }

  public static String bigRoom(String up, String upDesc, String up2, String upDesc2, String left, String leftDesc, String left2, String leftDesc2, String right, String rightDesc, String right2, String rightDesc2, String down, String downDesc, String down2, String downDesc2) {
    return (
      "┌───" + up + "────────" + up2 + "───┐\n" + 
      "│   " + upDesc + "        " + upDesc2 + "   │\n" +
      left + " " + leftDesc + "            " + rightDesc + " " + right + "\n" +
      "│                    │\n" +
      "│                    │\n" +
      "│                    │\n" +
      "│                    │\n" +
      left2 + " " + leftDesc2 + "            " + rightDesc2 + " " + right2 + "\n" +
      "│   " + downDesc + "        " + downDesc2 + "   │\n" +
      "└───" + down + "────────" + down2 + "───┘"
    );
  }
}
