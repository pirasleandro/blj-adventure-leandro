import java.util.Scanner;

public class Debug {
  private static Scanner scan = new Scanner(System.in);

  private Debug() {
    // static class
  }

  public static void enterCommand() {
    System.out.println("Enter command: ");
    String input = scan.nextLine();
    switch (input) {
      case "tp" -> {
        tp();
      }
      case "open" -> {
        open();
      }
      case "heal" -> {
        heal();
      }
      case "hurt" -> {
        hurt();
      }
    }
  }

  private static void tp() {
    System.out.println("Enter room id: ");
    Ref.controller.setCurrentRoom(scan.nextLine());
  }

  private static void open() {
    System.out.println("Enter door id:");
    Ref.getDoor(scan.nextLine()).isLocked = false;
  }

  private static void heal() {
    System.out.println("Enter amount: ");
    String input = scan.nextLine();
    if (input.equals("max")) {
      Ref.player.heal(Ref.player.maxHealth);
    } else {
      Ref.player.heal(Integer.parseInt(input));
    }
  }

  private static void hurt() {
    System.out.println("Enter amount: ");
      String input = scan.nextLine();
      if (input.equals("max")) {
        Ref.player.kill();
      } else {
        Ref.player.hurt(Integer.parseInt(input));
      }
  }
}