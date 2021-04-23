import java.util.Scanner;

public class Debug {
  public static Controller controller;

  private Debug() {
    // static class
  }

  public static void open() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter command: ");
    String input = scan.nextLine();
    switch (input) {
      case "tp" -> {
        System.out.println("Enter room id: ");
        controller.setCurrentRoom(scan.nextLine());
      }
      case "open" -> {
        System.out.println("Enter door id:");
        controller.getMap().getDoor(scan.nextLine()).isLocked = false;
      }
      case "heal" -> {
        System.out.println("Enter amount: ");
        input = scan.nextLine();
        if (input.equals("max")) {
          controller.getPlayer().heal(controller.getPlayer().maxHealth);
        } else {
          controller.getPlayer().heal(Integer.parseInt(input));
        }
      }
      case "hurt" -> {
        System.out.println("Enter amount: ");
        input = scan.nextLine();
        if (input.equals("max")) {
          controller.getPlayer().kill();
        } else {
          controller.getPlayer().hurt(Integer.parseInt(input));
        }
      }
    }
  }
}
