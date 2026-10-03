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
      c.add(bp.a().a("speechBubble.thatHurts"));
      c.add(bp.a().a("speechBubble.myEye"));
      c.add(bp.a().a("speechBubble.zzzzz"));
      c.add(bp.a().a("speechBubble.why"));
      c.add(bp.a().a("speechBubble.illBeBack"));
      c.add(bp.a().a("speechBubble.youDidnt"));
      c.add(bp.a().a("speechBubble.oof"));
      c.add(bp.a().a("speechBubble.censored"));
      c.add(bp.a().a("speechBubble.ouch"));
      c.add(bp.a().a("speechBubble.hiThere"));
      c.add(bp.a().a("speechBubble.thatTickles"));
      c.add(bp.a().a("speechBubble.whosThere"));
      c.add(bp.a().a("speechBubble.iThoughtWeWereFriends"));
      c.add(bp.a().a("speechBubble.youreMean"));
      c.add(bp.a().a("speechBubble.whiiii"));
      c.add(bp.a().a("speechBubble.notDroppingAnything"));
      c.add(bp.a().a("speechBubble.iLikeYou"));
      c.add(bp.a().a("speechBubble.iHateYou"));
      c.add(bp.a().a("speechBubble.youNoTakeCobble"));
      c.add(bp.a().a("speechBubble.imDiamond"));
      c.add(bp.a().a("speechBubble.youPunchedMe"));
      c.add(bp.a().a("speechBubble.stopPunchingMe"));
      c.add(bp.a().a("speechBubble.imDirt"));
      c.add(bp.a().a("speechBubble.mummy"));
      c.add(bp.a().a("speechBubble.ssssssst"));
      c.add(bp.a().a("speechBubble.kaboom"));
      c.add(bp.a().a("speechBubble.bully"));
      c.add(bp.a().a("speechBubble.imTelling"));
      c.add(bp.a().a("speechBubble.creeperBehindYou"));
      c.add(bp.a().a("speechBubble.didIDoBad"));
      c.add(bp.a().a("speechBubble.hello"));
   }
}
