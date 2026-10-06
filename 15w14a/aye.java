import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.realms.RealmsBridge;
import org.apache.commons.io.Charsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.Project;

public class aye extends axy implements axa {
   private static final AtomicInteger f = new AtomicInteger(0);
   private static final Logger g = LogManager.getLogger();
   private static final Random h = new Random();
   private float i;
   private String r;
   private avv s;
   private int t;
   private bmd u;
   private boolean v = true;
   private final Object w = new Object();
   private String x;
   private String y;
   private String z;
   private static final ka A = new ka("texts/splashes.txt");
   private static final ka B = new ka("textures/gui/title/minecraft.png");
   private static final ka[] C = new ka[]{
      new ka("textures/gui/title/background/panorama_0.png"),
      new ka("textures/gui/title/background/panorama_1.png"),
      new ka("textures/gui/title/background/panorama_2.png"),
      new ka("textures/gui/title/background/panorama_3.png"),
      new ka("textures/gui/title/background/panorama_4.png"),
      new ka("textures/gui/title/background/panorama_5.png")
   };
   public static final String clickMessage = "Please click " + a.t + "here" + a.v + " for more information.";
   private int D;
   private int E;
   private int F;
   private int G;
   private int H;
   private int I;
   private ka J;
   private avv K;

   public aye() {
      this.y = clickMessage;
      this.r = "missingno";
      BufferedReader var1/* $VF was: ☃ */ = null;

      try {
         List<String> var2/* $VF was: ☃x */ = Lists.newArrayList();
         var1/* $VF was: ☃ */ = new BufferedReader(new InputStreamReader(avh.A().Q().a(A).b(), Charsets.UTF_8));

         String var3/* $VF was: ☃xx */;
         while ((var3/* $VF was: ☃xx */ = var1/* $VF was: ☃ */.readLine()) != null) {
            var3/* $VF was: ☃xx */ = var3/* $VF was: ☃xx */.trim();
            if (!var3/* $VF was: ☃xx */.isEmpty()) {
               var2/* $VF was: ☃x */.add(var3/* $VF was: ☃xx */);
            }
         }

         if (!var2/* $VF was: ☃x */.isEmpty()) {
            do {
               this.r = var2/* $VF was: ☃x */.get(h.nextInt(var2/* $VF was: ☃x */.size()));
            } while (this.r.hashCode() == 125780783);
         }
      } catch (IOException var12) {
      } finally {
         if (var1/* $VF was: ☃ */ != null) {
            try {
               var1/* $VF was: ☃ */.close();
            } catch (IOException var11) {
            }
         }
      }

      this.i = h.nextFloat();
      this.x = "";
      if (!GLContext.getCapabilities().OpenGL20 && !bqw.b()) {
         this.x = bnu.a("title.oldgl1");
         this.y = bnu.a("title.oldgl2");
         this.z = "https://help.mojang.com/customer/portal/articles/325948?ref=game";
      }

      this.r = bnu.a("menu.aprilSplash");
   }

   @Override
   public void e() {
      this.t++;
   }

   @Override
   public boolean d() {
      return false;
   }

   @Override
   protected void a(char var1, int var2) {
   }

   @Override
   public void b() {
      this.u = new bmd(256, 256);
      this.J = this.j.P().a("background", this.u);
      Calendar var1/* $VF was: ☃ */ = Calendar.getInstance();
      var1/* $VF was: ☃ */.setTime(new Date());
      if (var1/* $VF was: ☃ */.get(2) + 1 == 11 && var1/* $VF was: ☃ */.get(5) == 9) {
         this.r = "Happy birthday, ez!";
      } else if (var1/* $VF was: ☃ */.get(2) + 1 == 6 && var1/* $VF was: ☃ */.get(5) == 1) {
         this.r = "Happy birthday, Notch!";
      } else if (var1/* $VF was: ☃ */.get(2) + 1 == 12 && var1/* $VF was: ☃ */.get(5) == 24) {
         this.r = "Merry X-mas!";
      } else if (var1/* $VF was: ☃ */.get(2) + 1 == 1 && var1/* $VF was: ☃ */.get(5) == 1) {
         this.r = "Happy new year!";
      } else if (var1/* $VF was: ☃ */.get(2) + 1 == 10 && var1/* $VF was: ☃ */.get(5) == 31) {
         this.r = "OOoooOOOoooo! Spooky!";
      }

      int var2/* $VF was: ☃x */ = 24;
      int var3/* $VF was: ☃xx */ = this.m / 4 + 48;
      if (this.j.t()) {
         this.c(var3/* $VF was: ☃xx */, 24);
      } else {
         this.b(var3/* $VF was: ☃xx */, 24);
      }

      this.n.add(new avv(0, this.l / 2 - 100, var3/* $VF was: ☃xx */ + 72 + 12, 98, 20, bnu.a("menu.options")));
      this.n.add(new avv(4, this.l / 2 + 2, var3/* $VF was: ☃xx */ + 72 + 12, 98, 20, bnu.a("menu.quit")));
      this.n.add(new awc(5, this.l / 2 - 124, var3/* $VF was: ☃xx */ + 72 + 12));
      synchronized (this.w) {
         this.E = this.q.a(this.x);
         this.D = this.q.a(this.y);
         int var5/* $VF was: ☃xxx */ = Math.max(this.E, this.D);
         this.F = (this.l - var5/* $VF was: ☃xxx */) / 2;
         this.G = this.n.get(0).i - 24;
         this.H = this.F + var5/* $VF was: ☃xxx */;
         this.I = this.G + 24;
      }

      this.j.a(false);
      this.r = bnu.a("menu.aprilSplash");
   }

   private void b(int var1, int var2) {
      String var3/* $VF was: ☃ */;
      if (this.j.f().f("existence.af15")) {
         var3/* $VF was: ☃ */ = bnu.a("menu.singleplayer");
         this.n.add(new avv(12, this.l / 2 - 100, var1/* $VF was: ☃ */ + var2/* $VF was: ☃ */ * 2, bnu.a("menu.resetdemo")));
      } else {
         var3/* $VF was: ☃ */ = bnu.a("menu.playdemo");
      }

      this.n.add(new avv(1, this.l / 2 - 100, var1/* $VF was: ☃ */, var3/* $VF was: ☃ */));
      this.n.add(new avv(2, this.l / 2 - 100, var1/* $VF was: ☃ */ + var2/* $VF was: ☃ */ * 1, bnu.a("menu.multiplayer")));
   }

   private void c(int var1, int var2) {
      this.n.add(new avv(11, this.l / 2 - 100, var1/* $VF was: ☃ */, bnu.a("menu.playdemo")));
      this.n.add(this.s = new avv(12, this.l / 2 - 100, var1/* $VF was: ☃ */ + var2/* $VF was: ☃ */ * 1, bnu.a("menu.resetdemo")));
      atu var3/* $VF was: ☃ */ = this.j.f();
      atr var4/* $VF was: ☃x */ = var3/* $VF was: ☃ */.c("Demo_World");
      if (var4/* $VF was: ☃x */ == null) {
         this.s.l = false;
      }
   }

   @Override
   protected void a(avv var1) {
      if (var1/* $VF was: ☃ */.k == 0) {
         this.j.a(new axr(this, this.j.t));
      }

      if (var1/* $VF was: ☃ */.k == 5) {
         this.j.a(new axo(this, this.j.t, this.j.S()));
      }

      if (var1/* $VF was: ☃ */.k == 1) {
         this.j.a(new axz(this));
      }

      if (var1/* $VF was: ☃ */.k == 2) {
         this.j.a(new azl(this));
      }

      if (var1/* $VF was: ☃ */.k == 14 && this.K.m) {
         this.a();
      }

      if (var1/* $VF was: ☃ */.k == 4) {
         this.j.m();
      }

      if (var1/* $VF was: ☃ */.k == 11) {
         this.j.a("Demo_World", "Demo_World", kz.a);
      }

      if (var1/* $VF was: ☃ */.k == 12) {
         atu var2/* $VF was: ☃ */ = this.j.f();
         atr var3/* $VF was: ☃x */ = var2/* $VF was: ☃ */.c("existence.af15");
         if (var3/* $VF was: ☃x */ != null) {
            axb var4/* $VF was: ☃xx */ = axz.a(this, bnu.a("selectWorld.aprilWorldName"), 12);
            this.j.a(var4/* $VF was: ☃xx */);
         }
      }
   }

   private void a() {
      RealmsBridge var1/* $VF was: ☃ */ = new RealmsBridge();
      var1/* $VF was: ☃ */.switchToRealms(this);
   }

   @Override
   public void a(boolean var1, int var2) {
      if (var1/* $VF was: ☃ */ && var2/* $VF was: ☃ */ == 12) {
         atu var6/* $VF was: ☃ */ = this.j.f();
         var6/* $VF was: ☃ */.d();
         var6/* $VF was: ☃ */.e("existence.af15");
         this.j.a(this);
      } else if (var2/* $VF was: ☃ */ == 13 && var1/* $VF was: ☃ */) {
         try {
            Class<?> var3/* $VF was: ☃ */ = Class.forName("java.awt.Desktop");
            Object var4/* $VF was: ☃x */ = var3/* $VF was: ☃ */.getMethod("getDesktop").invoke(null);
            var3/* $VF was: ☃ */.getMethod("browse", URI.class).invoke(var4/* $VF was: ☃x */, new URI(this.z));
         } catch (Throwable var5/* $VF was: ☃ */) {
            g.error("Couldn't open link", var5/* $VF was: ☃ */);
         }
      }

      this.j.a(this);
   }

   private void b(int var1, int var2, float var3) {
      bgb var4/* $VF was: ☃ */ = bgb.a();
      bfh var5/* $VF was: ☃x */ = var4/* $VF was: ☃ */.c();
      bfp.n(5889);
      bfp.E();
      bfp.D();
      Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
      bfp.n(5888);
      bfp.E();
      bfp.D();
      bfp.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfp.b(180.0F, 1.0F, 0.0F, 0.0F);
      bfp.b(90.0F, 0.0F, 0.0F, 1.0F);
      bfp.l();
      bfp.c();
      bfp.p();
      bfp.a(false);
      bfp.a(770, 771, 1, 0);
      int var6/* $VF was: ☃xx */ = 8;

      for (int var7/* $VF was: ☃xxx */ = 0; var7/* $VF was: ☃xxx */ < var6/* $VF was: ☃xx */ * var6/* $VF was: ☃xx */; var7/* $VF was: ☃xxx */++) {
         bfp.E();
         float var8/* $VF was: ☃xxxx */ = ((float)(var7/* $VF was: ☃xxx */ % var6/* $VF was: ☃xx */) / var6/* $VF was: ☃xx */ - 0.5F) / 64.0F;
         float var9/* $VF was: ☃xxxxx */ = ((float)(var7/* $VF was: ☃xxx */ / var6/* $VF was: ☃xx */) / var6/* $VF was: ☃xx */ - 0.5F) / 64.0F;
         float var10/* $VF was: ☃xxxxxx */ = 0.0F;
         bfp.b(var8/* $VF was: ☃xxxx */, var9/* $VF was: ☃xxxxx */, var10/* $VF was: ☃xxxxxx */);
         bfp.b(nu.a((this.t + var3/* $VF was: ☃ */) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
         bfp.b(-(this.t + var3/* $VF was: ☃ */) * 0.1F, 0.0F, 1.0F, 0.0F);

         for (int var11/* $VF was: ☃xxxxxxx */ = 0; var11/* $VF was: ☃xxxxxxx */ < 6; var11/* $VF was: ☃xxxxxxx */++) {
            bfp.E();
            if (var11/* $VF was: ☃xxxxxxx */ == 1) {
               bfp.b(90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var11/* $VF was: ☃xxxxxxx */ == 2) {
               bfp.b(180.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var11/* $VF was: ☃xxxxxxx */ == 3) {
               bfp.b(-90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var11/* $VF was: ☃xxxxxxx */ == 4) {
               bfp.b(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if (var11/* $VF was: ☃xxxxxxx */ == 5) {
               bfp.b(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            this.j.P().a(C[var11/* $VF was: ☃xxxxxxx */]);
            var5/* $VF was: ☃x */.a(7, bmw.i);
            int var12/* $VF was: ☃xxxxxxxx */ = 255 / (var7/* $VF was: ☃xxx */ + 1);
            float var13/* $VF was: ☃xxxxxxxxx */ = 0.0F;
            var5/* $VF was: ☃x */.b(-1.0, -1.0, 1.0).a(0.0, 0.0).b(255, 255, 255, var12/* $VF was: ☃xxxxxxxx */).d();
            var5/* $VF was: ☃x */.b(1.0, -1.0, 1.0).a(1.0, 0.0).b(255, 255, 255, var12/* $VF was: ☃xxxxxxxx */).d();
            var5/* $VF was: ☃x */.b(1.0, 1.0, 1.0).a(1.0, 1.0).b(255, 255, 255, var12/* $VF was: ☃xxxxxxxx */).d();
            var5/* $VF was: ☃x */.b(-1.0, 1.0, 1.0).a(0.0, 1.0).b(255, 255, 255, var12/* $VF was: ☃xxxxxxxx */).d();
            var4/* $VF was: ☃ */.b();
            bfp.F();
         }

         bfp.F();
         bfp.a(true, true, true, false);
      }

      var5/* $VF was: ☃x */.c(0.0, 0.0, 0.0);
      bfp.a(true, true, true, true);
      bfp.n(5889);
      bfp.F();
      bfp.n(5888);
      bfp.F();
      bfp.a(true);
      bfp.o();
      bfp.j();
   }

   private void a(float var1) {
      this.j.P().a(this.J);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
      bfp.l();
      bfp.a(770, 771, 1, 0);
      bfp.a(true, true, true, false);
      bgb var2/* $VF was: ☃ */ = bgb.a();
      bfh var3/* $VF was: ☃x */ = var2/* $VF was: ☃ */.c();
      var3/* $VF was: ☃x */.a(7, bmw.i);
      bfp.c();
      int var4/* $VF was: ☃xx */ = 3;

      for (int var5/* $VF was: ☃xxx */ = 0; var5/* $VF was: ☃xxx */ < var4/* $VF was: ☃xx */; var5/* $VF was: ☃xxx */++) {
         float var6/* $VF was: ☃xxxx */ = 1.0F / (var5/* $VF was: ☃xxx */ + 1);
         int var7/* $VF was: ☃xxxxx */ = this.l;
         int var8/* $VF was: ☃xxxxxx */ = this.m;
         float var9/* $VF was: ☃xxxxxxx */ = (var5/* $VF was: ☃xxx */ - var4/* $VF was: ☃xx */ / 2) / 256.0F;
         var3/* $VF was: ☃x */.b((double)var7/* $VF was: ☃xxxxx */, (double)var8/* $VF was: ☃xxxxxx */, (double)this.e)
            .a(0.0F + var9/* $VF was: ☃xxxxxxx */, 1.0)
            .a(1.0F, 1.0F, 1.0F, var6/* $VF was: ☃xxxx */)
            .d();
         var3/* $VF was: ☃x */.b((double)var7/* $VF was: ☃xxxxx */, 0.0, (double)this.e)
            .a(1.0F + var9/* $VF was: ☃xxxxxxx */, 1.0)
            .a(1.0F, 1.0F, 1.0F, var6/* $VF was: ☃xxxx */)
            .d();
         var3/* $VF was: ☃x */.b(0.0, 0.0, (double)this.e).a(1.0F + var9/* $VF was: ☃xxxxxxx */, 0.0).a(1.0F, 1.0F, 1.0F, var6/* $VF was: ☃xxxx */).d();
         var3/* $VF was: ☃x */.b(0.0, (double)var8/* $VF was: ☃xxxxxx */, (double)this.e)
            .a(0.0F + var9/* $VF was: ☃xxxxxxx */, 0.0)
            .a(1.0F, 1.0F, 1.0F, var6/* $VF was: ☃xxxx */)
            .d();
      }

      var2/* $VF was: ☃ */.b();
      bfp.d();
      bfp.a(true, true, true, true);
   }

   private void c(int var1, int var2, float var3) {
      this.j.b().e();
      bfp.b(0, 0, 256, 256);
      this.b(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */);
      this.a(var3/* $VF was: ☃ */);
      this.a(var3/* $VF was: ☃ */);
      this.a(var3/* $VF was: ☃ */);
      this.a(var3/* $VF was: ☃ */);
      this.a(var3/* $VF was: ☃ */);
      this.a(var3/* $VF was: ☃ */);
      this.a(var3/* $VF was: ☃ */);
      this.j.b().a(true);
      bfp.b(0, 0, this.j.d, this.j.e);
      float var4/* $VF was: ☃ */ = this.l > this.m ? 120.0F / this.l : 120.0F / this.m;
      float var5/* $VF was: ☃x */ = this.m * var4/* $VF was: ☃ */ / 256.0F;
      float var6/* $VF was: ☃xx */ = this.l * var4/* $VF was: ☃ */ / 256.0F;
      int var7/* $VF was: ☃xxx */ = this.l;
      int var8/* $VF was: ☃xxxx */ = this.m;
      bgb var9/* $VF was: ☃xxxxx */ = bgb.a();
      bfh var10/* $VF was: ☃xxxxxx */ = var9/* $VF was: ☃xxxxx */.c();
      var10/* $VF was: ☃xxxxxx */.a(7, bmw.i);
      var10/* $VF was: ☃xxxxxx */.b(0.0, (double)var8/* $VF was: ☃xxxx */, (double)this.e)
         .a(0.5F - var5/* $VF was: ☃x */, 0.5F + var6/* $VF was: ☃xx */)
         .a(1.0F, 1.0F, 1.0F, 1.0F)
         .d();
      var10/* $VF was: ☃xxxxxx */.b((double)var7/* $VF was: ☃xxx */, (double)var8/* $VF was: ☃xxxx */, (double)this.e)
         .a(0.5F - var5/* $VF was: ☃x */, 0.5F - var6/* $VF was: ☃xx */)
         .a(1.0F, 1.0F, 1.0F, 1.0F)
         .d();
      var10/* $VF was: ☃xxxxxx */.b((double)var7/* $VF was: ☃xxx */, 0.0, (double)this.e)
         .a(0.5F + var5/* $VF was: ☃x */, 0.5F - var6/* $VF was: ☃xx */)
         .a(1.0F, 1.0F, 1.0F, 1.0F)
         .d();
      var10/* $VF was: ☃xxxxxx */.b(0.0, 0.0, (double)this.e).a(0.5F + var5/* $VF was: ☃x */, 0.5F + var6/* $VF was: ☃xx */).a(1.0F, 1.0F, 1.0F, 1.0F).d();
      var9/* $VF was: ☃xxxxx */.b();
   }

   @Override
   public void a(int var1, int var2, float var3) {
      bfp.c();
      this.c(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */);
      bfp.d();
      bgb var4/* $VF was: ☃ */ = bgb.a();
      bfh var5/* $VF was: ☃x */ = var4/* $VF was: ☃ */.c();
      int var6/* $VF was: ☃xx */ = 274;
      int var7/* $VF was: ☃xxx */ = this.l / 2 - var6/* $VF was: ☃xx */ / 2;
      int var8/* $VF was: ☃xxxx */ = 30;
      this.a(0, 0, this.l, this.m, -2130706433, 16777215);
      this.a(0, 0, this.l, this.m, 0, Integer.MIN_VALUE);
      this.j.P().a(B);
      bfp.c(1.0F, 1.0F, 1.0F, 1.0F);
      if (this.i < 1.0E-4) {
         this.b(var7/* $VF was: ☃xxx */ + 0, var8/* $VF was: ☃xxxx */ + 0, 0, 0, 99, 44);
         this.b(var7/* $VF was: ☃xxx */ + 99, var8/* $VF was: ☃xxxx */ + 0, 129, 0, 27, 44);
         this.b(var7/* $VF was: ☃xxx */ + 99 + 26, var8/* $VF was: ☃xxxx */ + 0, 126, 0, 3, 44);
         this.b(var7/* $VF was: ☃xxx */ + 99 + 26 + 3, var8/* $VF was: ☃xxxx */ + 0, 99, 0, 26, 44);
         this.b(var7/* $VF was: ☃xxx */ + 155, var8/* $VF was: ☃xxxx */ + 0, 0, 45, 155, 44);
      } else {
         this.b(var7/* $VF was: ☃xxx */ + 0, var8/* $VF was: ☃xxxx */ + 0, 0, 0, 155, 44);
         this.b(var7/* $VF was: ☃xxx */ + 155, var8/* $VF was: ☃xxxx */ + 0, 0, 45, 155, 44);
      }

      bfp.E();
      bfp.b(this.l / 2 + 90, 70.0F, 0.0F);
      bfp.b(-20.0F, 0.0F, 0.0F, 1.0F);
      float var9/* $VF was: ☃xxxxx */ = 1.8F - nu.e(nu.a((float)(avh.J() % 1000L) / 1000.0F * (float) Math.PI * 2.0F) * 0.1F);
      var9/* $VF was: ☃xxxxx */ = var9/* $VF was: ☃xxxxx */ * 100.0F / (this.q.a(this.r) + 32);
      bfp.a(var9/* $VF was: ☃xxxxx */, var9/* $VF was: ☃xxxxx */, var9/* $VF was: ☃xxxxx */);
      this.a(this.q, this.r, 0, -8, -256);
      bfp.F();
      String var10/* $VF was: ☃xxxxxx */ = "Minecraft 15w14a";
      if (this.j.t()) {
         var10/* $VF was: ☃xxxxxx */ = var10/* $VF was: ☃xxxxxx */ + " Demo";
      }

      this.c(this.q, var10/* $VF was: ☃xxxxxx */, 2, this.m - 10, -1);
      String var11/* $VF was: ☃xxxxxxx */ = "Copyright Mojang AB. Do not distribute!";
      this.c(this.q, var11/* $VF was: ☃xxxxxxx */, this.l - this.q.a(var11/* $VF was: ☃xxxxxxx */) - 2, this.m - 10, -1);
      if (this.x != null && this.x.length() > 0) {
         a(this.F - 2, this.G - 2, this.H + 2, this.I - 1, 1428160512);
         this.c(this.q, this.x, this.F, this.G, -1);
         this.c(this.q, this.y, (this.l - this.D) / 2, this.n.get(0).i - 12, -1);
      }

      super.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */);
   }

   @Override
   protected void a(int var1, int var2, int var3) {
      super.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */);
      synchronized (this.w) {
         if (this.x.length() > 0
            && var1/* $VF was: ☃ */ >= this.F
            && var1/* $VF was: ☃ */ <= this.H
            && var2/* $VF was: ☃ */ >= this.G
            && var2/* $VF was: ☃ */ <= this.I) {
            awz var5/* $VF was: ☃ */ = new awz(this, this.z, 13, true);
            var5/* $VF was: ☃ */.f();
            this.j.a(var5/* $VF was: ☃ */);
         }
      }
   }
}
