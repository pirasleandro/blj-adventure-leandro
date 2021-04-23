import java.util.Scanner;

public class ConsoleUtil {
  private ConsoleUtil() {
    // static class
  }

  public static void clear() {
    System.out.print("\033\143");
  }

  public static void cToClose() {
    System.out.println("[c]> close");
    Scanner scan = new Scanner(System.in);
    String ok = scan.nextLine();
    while (!ok.equals("c")) {
      ok = scan.nextLine();
    }
    scan.close();
  }

  public static void cToClose(String message) {
    clear();
    System.out.println(message);
    cToClose();
  }
}
