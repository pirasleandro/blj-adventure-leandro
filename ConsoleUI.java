import java.util.Scanner;

public class ConsoleUI {
  private static Scanner scan = new Scanner(System.in);

  private ConsoleUI() {
    // static class
  }

  public static void clear() {
    System.out.print("\033\143");
  }

  public static void cToClose() {
    System.out.println("[c]> close");
    String ok = scan.nextLine();
    while (!ok.equals("c")) {
      ok = scan.nextLine();
    }
    ;
  }

  public static void cToClose(String message) {
    clear();
    System.out.println(message);
    cToClose();
  }
