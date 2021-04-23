public class Ref {
  public static Map map;
  public static Controller controller;
  public static Player player;

  private Ref() {
    // static class
  }

  public static void setRefs(Map mapRef, Controller controllerRef, Player playerRef) {
    map = mapRef;
    controller = controllerRef;
    player = playerRef;
  }
}
