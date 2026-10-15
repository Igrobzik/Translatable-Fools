import com.mojang.blaze3d.platform.GlStateManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

public class cyn extends czn {
   private static final qr a = new qr("textures/gui/demo_background.png");

   public cyn() {
      super(new jw("demo.help.title"));
   }

   @Override
   protected void init() {
      int var1 = -16;

      this.addButton(new cwc(
         this.width / 2 - 116,
         this.height / 2 + 62 + var1,
         114,
         20,
         dva.a("demo.help.buy", new Object[0]),
         var0 -> {
            try {
               Path var1x = Files.createTempDirectory("25th");
               Path var2 = var1x.resolve("ORDER.TXT");

               try (
                  OutputStream var3 = Files.newOutputStream(var2);
                  InputStream var5 = getOrderForm()
               ) {
                  IOUtils.copy(var5, var3);
               }

               p.g().a(var2.toUri());
            } catch (IOException var35) {
               var35.printStackTrace();
            }
         }
      ));

      this.addButton(new cwc(
         this.width / 2 + 2,
         this.height / 2 + 62 + var1,
         114,
         20,
         dva.a("demo.help.later", new Object[0]),
         var1x -> {
            this.minecraft.a((czn)null);
            this.minecraft.x.i();
         }
      ));
   }

   private InputStream getOrderForm() throws IOException {
      String language = this.minecraft.w.aN;

      if (language == null || language.trim().isEmpty()) {
         language = "en_us";
      }

      String localizedFile = "ORDER_" + language.trim().toLowerCase(Locale.ROOT) + ".FRM";

      InputStream stream = cyn.class.getClassLoader()
         .getResourceAsStream(localizedFile);

      if (stream == null) {
         stream = cyn.class.getClassLoader()
            .getResourceAsStream("ORDER.FRM");
      }

      if (stream == null) {
         throw new IOException("Missing ORDER.FRM resource");
      }

      return stream;
   }

   @Override
   public void renderBackground() {
      super.renderBackground();
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.minecraft.G().a(a);

      int var1 = (this.width - 248) / 2;
      int var2 = (this.height - 166) / 2;

      this.blit(var1, var2, 0, 0, 248, 166);
   }

   @Override
   public void render(int var1, int var2, float var3) {
      this.renderBackground();

      int var4 = (this.width - 248) / 2 + 10;
      int var5 = (this.height - 166) / 2 + 8;

      this.font.b(this.title.e(), var4, var5, 2039583);
      var5 += 12;

      this.font.b(dva.a("demo.help.nag1", new Object[0]), var4, var5, 5197647);
      this.font.b(dva.a("demo.help.nag2", new Object[0]), var4, var5 + 12, 5197647);
      this.font.b(dva.a("demo.help.nag3", new Object[0]), var4, var5 + 24, 5197647);

      super.render(var1, var2, var3);
   }

   @Override
   public boolean shouldCloseOnEsc() {
      return false;
   }
}
