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
}
