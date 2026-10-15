import java.util.List;
import javax.annotation.Nullable;

public class bbr extends bbk {
   private final bam a;
   private final c b;

   public bbr(bbk.a var1, bam var2, c var3) {
      super(var1);
      this.a = var2;
      this.b = var3;
   }

   @Override
   public void a(bbp var1, @Nullable bgx var2, List<jm> var3, bcz var4) {
      var3.add(new jw("item.key.tooltip.plural", new jw("color.minecraft." + this.a.b() + ".plural").a(this.b)));
   }
}