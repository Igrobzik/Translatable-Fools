import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class nm extends mp {
   private int a = 0;
   private final int b;
   private static final List c = new ArrayList();
   private static final Random d = new Random();

   public nm(aac var1, int var2, int var3, int var4) {
      this(var1, var2 + 0.5F, var3 + 0.5F, var4 + 0.5F);
   }

   public nm(aac var1, double var2, double var4, double var6) {
      super(var1);
      this.a(0.2F, 0.2F);
      this.N = this.P / 2.0F;
      this.b(var2, var4, var6);
      this.U = var2;
      this.V = var4;
      this.W = var6;
      this.b = 20;
   }

   @Override
   protected boolean f_() {
      return false;
   }

   @Override
   protected void a() {
      this.ah.a(31, "");
   }

   public void a(String var1) {
      this.ah.b(31, var1);
   }

   public String c() {
      return this.ah.e(31);
   }

   @Override
   public void l_() {
      this.r = this.u;
      this.s = this.v;
      this.t = this.w;
      if (this.a++ >= this.b) {
         this.w();
      }

      this.x = 0.0;
      this.y = 0.0;
      this.z = 0.0;
   }

   @Override
   public void b(bs var1) {
   }

   @Override
   public void a(bs var1) {
   }

   @Override
   public boolean ap() {
      return false;
   }

   public static String d() {
      return (String)c.get(d.nextInt(c.size()));
   }

   static {
      c.add("speechBubble.thatHurts");
      c.add("speechBubble.myEye");
      c.add("speechBubble.zzzzz");
      c.add("speechBubble.why");
      c.add("speechBubble.illBeBack");
      c.add("speechBubble.youDidnt");
      c.add("speechBubble.oof");
      c.add("speechBubble.censored");
      c.add("speechBubble.ouch");
      c.add("speechBubble.hiThere");
      c.add("speechBubble.thatTickles");
      c.add("speechBubble.whosThere");
      c.add("speechBubble.iThoughtWeWereFriends");
      c.add("speechBubble.youreMean");
      c.add("speechBubble.whiiii");
      c.add("speechBubble.notDroppingAnything");
      c.add("speechBubble.iLikeYou");
      c.add("speechBubble.iHateYou");
      c.add("speechBubble.youNoTakeCobble");
      c.add("speechBubble.imDiamond");
      c.add("speechBubble.youPunchedMe");
      c.add("speechBubble.stopPunchingMe");
      c.add("speechBubble.imDirt");
      c.add("speechBubble.mummy");
      c.add("speechBubble.ssssssst");
      c.add("speechBubble.kaboom");
      c.add("speechBubble.bully");
      c.add("speechBubble.imTelling");
      c.add("speechBubble.creeperBehindYou");
      c.add("speechBubble.didIDoBad");
      c.add("speechBubble.hello");
   }
}
