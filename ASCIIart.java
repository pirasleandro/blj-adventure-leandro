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
}
