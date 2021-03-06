package boxdrawing;

public class Block {
   private Block() {
      // static class
   }

   /*

   blocks
      u  = upper
      lo = lower
      r  = right
      le = left
      f  = full

      - blocks are "attached" to the give side
      - the size of the block is declared by a division

   divison
      x_y = x out of y
      h   = half
      
   quadrants:
      0 = empty
      1 = filled

      - quadrant symbols start with "q" followed by four binary digits
      - every digit represents a quadrant
      - they are mentioned in this order:
         - top left
         - top right
         - bottom left
         - bottom right

   other symbols:
      light =  "░";
      medium = "▒";
      dark =   "▓";


   */

   public static final String uh =  "▀";

   public static final String lo1_8 = "▁";
   public static final String lo1_4 = "▂";
   public static final String lo3_8 = "▃";
   public static final String lo1_2 = "▄";
   public static final String lo5_8 = "▅";
   public static final String lo3_4 = "▆";
   public static final String lo7_8 = "▇";

   public static final String f = "█";

   public static final String le7_8 = "▉";
   public static final String le3_4 = "▊";
   public static final String le5_8 = "▋";
   public static final String leh =   "▌";
   public static final String le3_8 = "▍";
   public static final String le1_4 = "▎";
   public static final String le1_8 = "▏";

   public static final String rh = "▐";

   public static final String light =  "░";
   public static final String medium = "▒";
   public static final String dark =   "▓";

   public static final String u1_8 = "▔";
   public static final String r1_8 = "▕";

   public static final String q0010 = "▖";
   public static final String q0001 = "▗";
   public static final String q1000 = "▘";
   public static final String q1011 = "▙";
   public static final String q1010 = "▚";
   public static final String q1110 = "▛";
   public static final String q1101 = "▜";
   public static final String q0100 = "▝";
   public static final String q0101 = "▞";
   public static final String q0111 = "▟";
}
