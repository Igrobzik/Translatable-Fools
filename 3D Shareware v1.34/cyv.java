import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class cyv extends czi {
   private static final qr o = new qr("textures/gui/loading.png");

   protected final cux a;

   protected static final cyv.a b = new cyv.a(0, 0, 44);
   protected static final cyv.a c = new cyv.a(1, 0, 45);
   protected static final cyv.a d = new cyv.a(2, 0, 43);
   protected static final cyv.a e = new cyv.a(3, 0, 20);
   protected static final cyv.a f = new cyv.a(4, 0, 1);
   protected static final cyv.a g = new cyv.a(5, 0, 28);
   protected static final cyv.a h = new cyv.a(5, 0, 30);
   protected static final cyv.a i = new cyv.a(6, 0, 21);
   protected static final cyv.a j = new cyv.a(7, 0, 43);
   protected static final cyv.a k = new cyv.a(8, 0, 20);
   protected static final cyv.a l = new cyv.a(9, 0, 35);
   protected static final cyv.a m = new cyv.a(10, 0, 10);
   protected static final cyv.a n = new cyv.a(10, 11, 1);

   private long lastUpdate;

   private String cachedWidthTexture;
   private final int[] visibleWidths = new int[11];

   public cyv(cux var1) {
      this.a = var1;
   }

   private static qr getLoadingTexture(cux minecraft) {
      String language = minecraft.w.aN;

      if (language == null || language.trim().isEmpty()) {
         return o;
      }

      language = language.trim().toLowerCase(Locale.ROOT);

      qr localizedTexture =
         new qr("textures/gui/loading_" + language + ".png");

      if (minecraft.J().a().b(wg.a, localizedTexture)) {
         return localizedTexture;
      }

      return o;
   }

   public static void a(cux var0) {
      qr texture = getLoadingTexture(var0);
      var0.G().a(texture, new czc.a(texture));
   }

   protected void a() {
      this.a.G().a(getLoadingTexture(this.a));
   }

   private void calculateVisibleWidths(qr texture) {
      String textureName = texture.toString();

      if (textureName.equals(this.cachedWidthTexture)) {
         return;
      }

      this.cachedWidthTexture = textureName;

      for (int i = 0; i < this.visibleWidths.length; i++) {
         this.visibleWidths[i] = 0;
      }

      ctm image = null;

      try {
         InputStream stream =
            this.a.J().a().a(wg.a, texture);

         image = ctm.a(stream);

         int rows = Math.min(this.visibleWidths.length,
                             (image.b() + 19) / 20);

         for (int row = 0; row < rows; row++) {
            int yStart = row * 20;
            int yEnd = Math.min(yStart + 16, image.b());

            /*
             * The command-line text occupies the first 10
             * character cells. Its animated cursor is separate.
             */
            int maxX = row == 10
               ? Math.min(80, image.a())
               : image.a();

            int rightmost = -1;

            for (int y = yStart; y < yEnd; y++) {
               for (int x = 0; x < maxX; x++) {
                  int pixel = image.a(x, y);
                  int alpha = (pixel >>> 24) & 255;

                  if (alpha != 0) {
                     rightmost = Math.max(rightmost, x);
                  }
               }
            }

            this.visibleWidths[row] = rightmost + 1;
         }
      } catch (IOException exception) {
         for (int i = 0; i < this.visibleWidths.length; i++) {
            this.visibleWidths[i] = 0;
         }
      } finally {
         if (image != null) {
            image.close();
         }
      }
   }

   protected int getLineWidthPixels(int row) {
      qr texture = getLoadingTexture(this.a);
      this.calculateVisibleWidths(texture);

      if (row < 0 || row >= this.visibleWidths.length) {
         return 0;
      }

      return this.visibleWidths[row];
   }

   protected int getLineWidthChars(int row) {
      int pixels = this.getLineWidthPixels(row);

      if (pixels <= 0) {
         return 0;
      }

      return (pixels + 7) / 8;
   }

   private int getSpriteWidthChars(cyv.a sprite) {
      /*
       * Sprites beginning at a nonzero horizontal texture
       * offset are individual animation frames, not full lines.
       */
      if (sprite.b != 0 || sprite.a == 4) {
         return sprite.c;
      }

      int width = this.getLineWidthChars(sprite.a);

      return width > 0 ? width : sprite.c;
   }

   @Override
   public void render(int var1, int var2, float var3) {
      long var4 = p.b();

      if (var4 - this.lastUpdate > 100L) {
         this.lastUpdate = var4;
         f.b = (f.b + 1) % 4;
         n.b = 10 + (n.b + 1) % 2;
      }
   }

   protected void a(ctz var1, cyv.b var2, cyv.a var3) {
      qr texture = getLoadingTexture(this.a);
      this.calculateVisibleWidths(texture);

      int chars = this.getSpriteWidthChars(var3);
      int var4 = 8 + var2.b * 8;
      int var5 = 8 + var2.a * 16;
      int var6 = chars * 8;

      float var8 = var3.b * 8 / 512.0F;
      float var9 = (var3.b * 8 + var6) / 512.0F;
      float var10 = var3.a * 20 / 512.0F;
      float var11 = (var3.a * 20 + 16) / 512.0F;

      var1.b((double)var4, (double)(var5 + 16),
            (double)this.blitOffset)
         .a((double)var8, (double)var11).d();

      var1.b((double)(var4 + var6), (double)(var5 + 16),
            (double)this.blitOffset)
         .a((double)var9, (double)var11).d();

      var1.b((double)(var4 + var6), (double)var5,
            (double)this.blitOffset)
         .a((double)var9, (double)var10).d();

      var1.b((double)var4, (double)var5,
            (double)this.blitOffset)
         .a((double)var8, (double)var10).d();
   }

   @Override
   public boolean b() {
      return true;
   }

   public static class a {
      public final int a;
      public int b;
      public final int c;

      public a(int var1, int var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }

   public static class b {
      public final int a;
      public final int b;

      protected static final cyv.b c = new cyv.b(0, 0);

      public b(int var1, int var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}