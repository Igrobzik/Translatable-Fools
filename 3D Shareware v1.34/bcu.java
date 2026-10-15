import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;

public class bcu extends bbk {
   private static final Random a = new Random();

   public bcu(bbk.a var1) {
      super(var1/* $VF was: ☃ */);
   }

   @Override
   public bbp a(bbp var1, bgx var2, aii var3) {
      bbp var4/* $VF was: ☃ */ = super.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */);
      if (var3/* $VF was: ☃ */ instanceof vf) {
         ((vf)var3/* $VF was: ☃ */).b.a(new li(11, 0.0F));
      }

      return var4/* $VF was: ☃ */;
   }

   @Override
   public void a(bbp var1, @Nullable bgx var2, List<jm> var3, bcz var4) {
      c[] var5/* $VF was: ☃ */ = c.values();
      c var6/* $VF was: ☃x */ = var5/* $VF was: ☃ */[a.nextInt(var5/* $VF was: ☃ */.length)];
      var3.add(new jw("item.minecraft.3d.description").a(var6));
   }
}
