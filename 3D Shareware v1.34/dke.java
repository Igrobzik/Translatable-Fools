import com.google.gson.JsonSyntaxException;
import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class dke implements AutoCloseable, xd {
   private static final Logger LOGGER = LogManager.getLogger();
   private static final qr e = new qr("textures/environment/rain.png");
   private static final qr f = new qr("textures/environment/snow.png");
   private final cux g;
   private final xc h;
   private final Random i = new Random();
   private float j;
   public final dkg a;
   private final cvs k;
   private int l;
   private float m;
   private float n;
   private float o;
   private float fieldP;
   private boolean q = true;
   private boolean r = true;
   private long s;
   private long t = p.b();
   private final dkj u;
   private int v;
   private final float[] w = new float[1024];
   private final float[] x = new float[1024];
   private final dkd y;
   private boolean z;
   private double A = 1.0;
   private double B;
   private double C;
   private bbp D;
   private int E;
   private float F;
   private float G;
   private dkn H;
   private dkn I;
   private static final qr[] J = new qr[]{
      new qr("shaders/post/notch.json"),
      new qr("shaders/post/fxaa.json"),
      new qr("shaders/post/art.json"),
      new qr("shaders/post/bumpy.json"),
      new qr("shaders/post/blobs2.json"),
      new qr("shaders/post/pencil.json"),
      new qr("shaders/post/color_convolve.json"),
      new qr("shaders/post/deconverge.json"),
      new qr("shaders/post/flip.json"),
      new qr("shaders/post/invert.json"),
      new qr("shaders/post/ntsc.json"),
      new qr("shaders/post/outline.json"),
      new qr("shaders/post/phosphor.json"),
      new qr("shaders/post/scan_pincushion.json"),
      new qr("shaders/post/sobel.json"),
      new qr("shaders/post/bits.json"),
      new qr("shaders/post/desaturate.json"),
      new qr("shaders/post/green.json"),
      new qr("shaders/post/blur.json"),
      new qr("shaders/post/wobble.json"),
      new qr("shaders/post/blobs.json"),
      new qr("shaders/post/antialias.json"),
      new qr("shaders/post/creeper.json"),
      new qr("shaders/post/spider.json")
   };
   public static final int b = J.length;
   private int K = b;
   private boolean L;
   private int M;
   private final cun N = new cun();
   public double c = 10.0;
   private int O = 5;
   private int P = 0;

   public dke(cux var1, xc var2) {
      this.g = var1/* $VF was: ☃ */;
      this.h = var2/* $VF was: ☃ */;
      this.a = var1/* $VF was: ☃ */.Y();
      this.k = new cvs(var1/* $VF was: ☃ */.G());
      this.u = new dkj(this);
      this.y = new dkd(this);
      this.H = null;

      for (int var3/* $VF was: ☃ */ = 0; var3/* $VF was: ☃ */ < 32; var3/* $VF was: ☃ */++) {
         for (int var4/* $VF was: ☃x */ = 0; var4/* $VF was: ☃x */ < 32; var4/* $VF was: ☃x */++) {
            float var5/* $VF was: ☃xx */ = var4/* $VF was: ☃x */ - 16;
            float var6/* $VF was: ☃xxx */ = var3/* $VF was: ☃ */ - 16;
            float var7/* $VF was: ☃xxxx */ = zq.c(var5/* $VF was: ☃xx */ * var5/* $VF was: ☃xx */ + var6/* $VF was: ☃xxx */ * var6/* $VF was: ☃xxx */);
            this.w[var3/* $VF was: ☃ */ << 5 | var4/* $VF was: ☃x */] = -var6/* $VF was: ☃xxx */ / var7/* $VF was: ☃xxxx */;
            this.x[var3/* $VF was: ☃ */ << 5 | var4/* $VF was: ☃x */] = var5/* $VF was: ☃xx */ / var7/* $VF was: ☃xxxx */;
         }
      }
   }

   @Override
   public void close() {
      this.u.close();
      this.k.close();
      this.b();
   }

   public boolean a() {
      return GLX.usePostProcess && this.H != null;
   }

   public void b() {
      if (this.H != null) {
         this.H.close();
      }

      this.H = null;
      this.K = b;
   }

   public void c() {
      this.L = !this.L;
   }

   public void a(@Nullable ahz var1) {
      if (GLX.usePostProcess) {
         if (this.H != null) {
            this.H.close();
         }

         this.H = null;
         if (var1/* $VF was: ☃ */ instanceof atl) {
            this.a(new qr("shaders/post/creeper.json"));
         } else if (var1/* $VF was: ☃ */ instanceof aum) {
            this.a(new qr("shaders/post/spider.json"));
         } else if (var1/* $VF was: ☃ */ instanceof atp) {
            this.a(new qr("shaders/post/invert.json"));
         }
      }
   }

   private void a(qr var1) {
      if (this.H != null) {
         this.H.close();
      }

      try {
         this.H = new dkn(this.g.G(), this.h, this.g.c(), var1/* $VF was: ☃ */);
         this.H.a(this.g.g.j(), this.g.g.k());
         this.L = true;
      } catch (IOException var3/* $VF was: ☃ */) {
         LOGGER.warn("Failed to load shader: {}", var1/* $VF was: ☃ */, var3/* $VF was: ☃ */);
         this.K = b;
         this.L = false;
      } catch (JsonSyntaxException var4/* $VF was: ☃ */) {
         LOGGER.warn("Failed to load shader: {}", var1/* $VF was: ☃ */, var4/* $VF was: ☃ */);
         this.K = b;
         this.L = false;
      }
   }

   @Override
   public void a(xc var1) {
      if (this.H != null) {
         this.H.close();
      }

      this.H = null;
      if (this.K == b) {
         this.a(this.g.U());
      } else {
         this.a(J[this.K]);
      }

      if (this.I != null) {
         this.I.close();
      }

      this.I = null;

      try {
         this.I = new dkn(this.g.G(), var1/* $VF was: ☃ */, this.g.c(), new qr("shaders/post/bits.json"));
         this.I.a(this.g.g.j(), this.g.g.k());
      } catch (Exception var3/* $VF was: ☃ */) {
         throw new IllegalStateException("Failed to load only shader that matters", var3/* $VF was: ☃ */);
      }
   }

   public void e() {
      this.o();
      this.u.a();
      if (this.g.U() == null) {
         this.g.a(this.g.j);
      }

      this.N.a();
      this.l++;
      this.a.a();
      this.t();
      this.fieldP = this.o;
      if (this.g.t.l().e()) {
         this.o += 0.05F;
         if (this.o > 1.0F) {
            this.o = 1.0F;
         }
      } else if (this.o > 0.0F) {
         this.o -= 0.0125F;
      }

      if (this.E > 0) {
         this.E--;
         if (this.E == 0) {
            this.D = null;
         }
      }
   }

   public dkn f() {
      return this.H;
   }

   public void a(int var1, int var2) {
      if (GLX.usePostProcess) {
         if (this.H != null) {
            this.H.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
         }

         if (this.I != null) {
            this.I.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
         }

         this.g.i.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
      }
   }

   public void a(float var1) {
      ahz var2/* $VF was: ☃ */ = this.g.U();
      if (var2/* $VF was: ☃ */ != null) {
         if (this.g.h != null) {
            this.g.aq().a("pick");
            this.g.l = null;
            double var3/* $VF was: ☃x */ = this.g.f.c();
            this.g.v = var2/* $VF was: ☃ */.a(var3/* $VF was: ☃x */, var1/* $VF was: ☃ */, false);
            crk var5/* $VF was: ☃xx */ = var2/* $VF was: ☃ */.j(var1/* $VF was: ☃ */);
            boolean var6/* $VF was: ☃xxx */ = false;
            int var7/* $VF was: ☃xxxx */ = 3;
            double var8/* $VF was: ☃xxxxx */ = var3/* $VF was: ☃x */;
            if (this.g.f.h()) {
               var8/* $VF was: ☃xxxxx */ = 6.0;
               var3/* $VF was: ☃x */ = var8/* $VF was: ☃xxxxx */;
            } else {
               if (var8/* $VF was: ☃xxxxx */ > 3.0) {
                  var6/* $VF was: ☃xxx */ = true;
               }

               var3/* $VF was: ☃x */ = var8/* $VF was: ☃xxxxx */;
            }

            var8/* $VF was: ☃xxxxx */ *= var8/* $VF was: ☃xxxxx */;
            if (this.g.v != null) {
               var8/* $VF was: ☃xxxxx */ = this.g.v.e().g(var5/* $VF was: ☃xx */);
            }

            crk var10/* $VF was: ☃xxxxxx */ = var2/* $VF was: ☃ */.f(1.0F);
            crk var11/* $VF was: ☃xxxxxxx */ = var5/* $VF was: ☃xx */.b(
               var10/* $VF was: ☃xxxxxx */.b * var3/* $VF was: ☃x */,
               var10/* $VF was: ☃xxxxxx */.c * var3/* $VF was: ☃x */,
               var10/* $VF was: ☃xxxxxx */.d * var3/* $VF was: ☃x */
            );
            float var12/* $VF was: ☃xxxxxxxx */ = 1.0F;
            crf var13/* $VF was: ☃xxxxxxxxx */ = var2/* $VF was: ☃ */.bG().a(var10/* $VF was: ☃xxxxxx */.a(var3/* $VF was: ☃x */)).c(1.0, 1.0, 1.0);
            crh var14/* $VF was: ☃xxxxxxxxxx */ = awc.a(
               var2/* $VF was: ☃ */,
               var5/* $VF was: ☃xx */,
               var11/* $VF was: ☃xxxxxxx */,
               var13/* $VF was: ☃xxxxxxxxx */,
               var0 -> !var0.t() && var0.aF(),
               var8/* $VF was: ☃xxxxx */
            );
            if (var14/* $VF was: ☃xxxxxxxxxx */ != null) {
               ahz var15/* $VF was: ☃xxxxxxxxxxx */ = var14/* $VF was: ☃xxxxxxxxxx */.a();
               crk var16/* $VF was: ☃xxxxxxxxxxxx */ = var14/* $VF was: ☃xxxxxxxxxx */.e();
               double var17/* $VF was: ☃xxxxxxxxxxxxx */ = var5/* $VF was: ☃xx */.g(var16/* $VF was: ☃xxxxxxxxxxxx */);
               if (var6/* $VF was: ☃xxx */ && var17/* $VF was: ☃xxxxxxxxxxxxx */ > 9.0) {
                  this.g.v = crg.a(
                     var16/* $VF was: ☃xxxxxxxxxxxx */,
                     fa.a(var10/* $VF was: ☃xxxxxx */.b, var10/* $VF was: ☃xxxxxx */.c, var10/* $VF was: ☃xxxxxx */.d),
                     new ev(var16/* $VF was: ☃xxxxxxxxxxxx */)
                  );
               } else if (var17/* $VF was: ☃xxxxxxxxxxxxx */ < var8/* $VF was: ☃xxxxx */ || this.g.v == null) {
                  this.g.v = var14/* $VF was: ☃xxxxxxxxxx */;
                  if (var15/* $VF was: ☃xxxxxxxxxxx */ instanceof aii || var15/* $VF was: ☃xxxxxxxxxxx */ instanceof asu) {
                     this.g.l = var15/* $VF was: ☃xxxxxxxxxxx */;
                  }
               }
            }

            this.g.aq().c();
         }
      }
   }

   private void o() {
      float var1/* $VF was: ☃ */ = 1.0F;
      if (this.g.U() instanceof djo) {
         djo var2/* $VF was: ☃x */ = (djo)this.g.U();
         var1/* $VF was: ☃ */ = var2/* $VF was: ☃x */.v();
      }

      this.n = this.m;
      this.m = this.m + (var1/* $VF was: ☃ */ - this.m) * 0.5F;
      if (this.m > 1.5F) {
         this.m = 1.5F;
      }

      if (this.m < 0.1F) {
         this.m = 0.1F;
      }
   }

   private double a(cun var1, float var2, boolean var3) {
      if (this.z) {
         return 90.0;
      }

      double var4/* $VF was: ☃ */ = 70.0;
      if (var3/* $VF was: ☃ */) {
         var4/* $VF was: ☃ */ = this.g.w.aI;
         var4/* $VF was: ☃ */ *= zq.f(var2/* $VF was: ☃ */, this.n, this.m);
      }

      if (var1/* $VF was: ☃ */.g() instanceof aii && ((aii)var1/* $VF was: ☃ */.g()).cy() <= 0.0F) {
         float var6/* $VF was: ☃x */ = ((aii)var1/* $VF was: ☃ */.g()).ay + var2/* $VF was: ☃ */;
         var4/* $VF was: ☃ */ /= (1.0F - 500.0F / (var6/* $VF was: ☃x */ + 500.0F)) * 2.0F + 1.0F;
      }

      ckn var8/* $VF was: ☃x */ = var1/* $VF was: ☃ */.k();
      if (!var8/* $VF was: ☃x */.e()) {
         var4/* $VF was: ☃ */ = var4/* $VF was: ☃ */ * 60.0 / 70.0;
      }

      return var4/* $VF was: ☃ */;
   }

   private void d(float var1) {
      if (this.g.U() instanceof aii) {
         aii var2/* $VF was: ☃ */ = (aii)this.g.U();
         float var3/* $VF was: ☃x */ = var2/* $VF was: ☃ */.av - var1/* $VF was: ☃ */;
         if (var2/* $VF was: ☃ */.cy() <= 0.0F) {
            float var4/* $VF was: ☃xx */ = var2/* $VF was: ☃ */.ay + var1/* $VF was: ☃ */;
            GlStateManager.rotatef(40.0F - 8000.0F / (var4/* $VF was: ☃xx */ + 200.0F), 0.0F, 0.0F, 1.0F);
         }

         if (var3/* $VF was: ☃x */ < 0.0F) {
            return;
         }

         var3/* $VF was: ☃x */ /= var2/* $VF was: ☃ */.aw;
         var3/* $VF was: ☃x */ = zq.a(var3/* $VF was: ☃x */ * var3/* $VF was: ☃x */ * var3/* $VF was: ☃x */ * var3/* $VF was: ☃x */ * (float) Math.PI);
         float var7/* $VF was: ☃xx */ = var2/* $VF was: ☃ */.ax;
         GlStateManager.rotatef(-var7/* $VF was: ☃xx */, 0.0F, 1.0F, 0.0F);
         GlStateManager.rotatef(-var3/* $VF was: ☃x */ * 14.0F, 0.0F, 0.0F, 1.0F);
         GlStateManager.rotatef(var7/* $VF was: ☃xx */, 0.0F, 1.0F, 0.0F);
      }
   }

   private void e(float var1) {
      if (this.g.U() instanceof avm) {
         avm var2/* $VF was: ☃ */ = (avm)this.g.U();
         float var3/* $VF was: ☃x */ = var2/* $VF was: ☃ */.E - var2/* $VF was: ☃ */.D;
         float var4/* $VF was: ☃xx */ = -(var2/* $VF was: ☃ */.E + var3/* $VF was: ☃x */ * var1/* $VF was: ☃ */);
         float var5/* $VF was: ☃xxx */ = zq.f(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */.bD, var2/* $VF was: ☃ */.bE);
         float var6/* $VF was: ☃xxxx */ = zq.f(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */.aG, var2/* $VF was: ☃ */.aH);
         GlStateManager.translatef(
            zq.a(var4/* $VF was: ☃xx */ * (float) Math.PI) * var5/* $VF was: ☃xxx */ * 0.5F,
            -Math.abs(zq.b(var4/* $VF was: ☃xx */ * (float) Math.PI) * var5/* $VF was: ☃xxx */),
            0.0F
         );
         GlStateManager.rotatef(zq.a(var4/* $VF was: ☃xx */ * (float) Math.PI) * var5/* $VF was: ☃xxx */ * 3.0F, 0.0F, 0.0F, 1.0F);
         GlStateManager.rotatef(Math.abs(zq.b(var4/* $VF was: ☃xx */ * (float) Math.PI - 0.2F) * var5/* $VF was: ☃xxx */) * 5.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.rotatef(var6/* $VF was: ☃xxxx */, 1.0F, 0.0F, 0.0F);
      }
   }

   private void f(float var1) {
      this.j = this.g.w.c * 16;
      GlStateManager.matrixMode(5889);
      GlStateManager.loadIdentity();
      if (this.A != 1.0) {
         GlStateManager.translatef((float)this.B, (float)(-this.C), 0.0F);
         GlStateManager.scaled(this.A, this.A, 1.0);
      }

      GlStateManager.multMatrix(cuh.a(this.a(this.N, var1/* $VF was: ☃ */, true), (float)this.g.g.j() / this.g.g.k(), 0.05F, this.j * zq.a));
      GlStateManager.matrixMode(5888);
      GlStateManager.loadIdentity();
      this.d(var1/* $VF was: ☃ */);
      if (this.g.w.V) {
         this.e(var1/* $VF was: ☃ */);
      }

      float var2/* $VF was: ☃ */ = zq.f(var1/* $VF was: ☃ */, this.g.j.cb, this.g.j.ca);
      if (var2/* $VF was: ☃ */ > 0.0F) {
         int var3/* $VF was: ☃x */ = 20;
         if (this.g.j.a(ahv.i)) {
            var3/* $VF was: ☃x */ = 7;
         }

         float var4/* $VF was: ☃xx */ = 5.0F / (var2/* $VF was: ☃ */ * var2/* $VF was: ☃ */ + 5.0F) - var2/* $VF was: ☃ */ * 0.04F;
         var4/* $VF was: ☃xx */ *= var4/* $VF was: ☃xx */;
         GlStateManager.rotatef((this.l + var1/* $VF was: ☃ */) * var3/* $VF was: ☃x */, 0.0F, 1.0F, 1.0F);
         GlStateManager.scalef(1.0F / var4/* $VF was: ☃xx */, 1.0F, 1.0F);
         GlStateManager.rotatef(-(this.l + var1/* $VF was: ☃ */) * var3/* $VF was: ☃x */, 0.0F, 1.0F, 1.0F);
      }
   }

   private void a(cun var1, float var2) {
      if (!this.z) {
         GlStateManager.matrixMode(5889);
         GlStateManager.loadIdentity();
         GlStateManager.multMatrix(cuh.a(this.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, false), (float)this.g.g.j() / this.g.g.k(), 0.05F, this.j * 2.0F));
         GlStateManager.matrixMode(5888);
         GlStateManager.loadIdentity();
         GlStateManager.pushMatrix();
         this.d(var2/* $VF was: ☃ */);
         if (this.g.w.V) {
            this.e(var2/* $VF was: ☃ */);
         }

         boolean var3/* $VF was: ☃ */ = this.g.U() instanceof aii && ((aii)this.g.U()).dt();
         if (this.g.w.aC == 0 && !var3/* $VF was: ☃ */ && !this.g.w.aB && this.g.f.k() != bgu.e) {
            this.i();
            this.a.a(var2/* $VF was: ☃ */);
            this.h();
         }

         GlStateManager.popMatrix();
         if (this.g.w.aC == 0 && !var3/* $VF was: ☃ */) {
            this.a.b(var2/* $VF was: ☃ */);
            this.d(var2/* $VF was: ☃ */);
         }

         if (this.g.w.V) {
            this.e(var2/* $VF was: ☃ */);
         }
      }
   }

   public void h() {
      this.u.b();
   }

   public void i() {
      this.u.c();
   }

   public float a(aii var1, float var2) {
      int var3/* $VF was: ☃ */ = var1/* $VF was: ☃ */.b(ahv.p).b();
      return var3/* $VF was: ☃ */ > 200 ? 1.0F : 0.7F + zq.a((var3/* $VF was: ☃ */ - var2/* $VF was: ☃ */) * (float) Math.PI * 0.2F) * 0.3F;
   }

   public void a(float var1, long var2, boolean var4) {
      GlStateManager.clear(16640, cux.a);
      if (!this.g.ak() && this.g.w.p && (!this.g.w.T || !this.g.x.d())) {
         if (p.b() - this.t > 500L) {
            this.g.l();
         }
      } else {
         this.t = p.b();
      }

      if (!this.g.u) {
         int var5/* $VF was: ☃ */ = (int)(this.g.x.e() * this.g.g.o() / this.g.g.m());
         int var6/* $VF was: ☃x */ = (int)(this.g.x.f() * this.g.g.p() / this.g.g.n());
         int var7/* $VF was: ☃xx */ = this.g.w.d;
         if (var4/* $VF was: ☃ */ && this.g.h != null) {
            this.g.aq().a("level");
            int var8/* $VF was: ☃xxx */ = Math.min(cux.Z(), var7/* $VF was: ☃xx */);
            var8/* $VF was: ☃xxx */ = Math.max(var8/* $VF was: ☃xxx */, 60);
            long var9/* $VF was: ☃xxxx */ = p.c() - var2/* $VF was: ☃ */;
            long var11/* $VF was: ☃xxxxx */ = Math.max(1000000000 / var8/* $VF was: ☃xxx */ / 4 - var9/* $VF was: ☃xxxx */, 0L);
            this.a(var1/* $VF was: ☃ */, p.c() + var11/* $VF was: ☃xxxxx */);
            if (this.g.A() && this.s < p.b() - 1000L) {
               this.s = p.b();
               if (!this.g.B().q()) {
                  this.r();
               }
            }

            if (GLX.usePostProcess) {
               this.g.i.b();
               if (this.H != null && this.L) {
                  GlStateManager.matrixMode(5890);
                  GlStateManager.pushMatrix();
                  GlStateManager.loadIdentity();
                  this.H.a(var1/* $VF was: ☃ */);
                  GlStateManager.popMatrix();
               }

               this.g.c().a(true);
            }

            this.g.aq().b("gui");
            GlStateManager.alphaFunc(516, 0.1F);
            this.g.g.a(cux.a);
            this.p();
            if (!this.g.w.aB || this.g.o != null) {
               this.a(this.g.g.o(), this.g.g.p(), var1/* $VF was: ☃ */);
               this.g.t.a(var1/* $VF was: ☃ */);
            }

            this.g.aq().c();
         } else {
            GlStateManager.viewport(0, 0, this.g.g.j(), this.g.g.k());
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            this.g.g.a(cux.a);
         }

         if (this.g.p != null) {
            try {
               this.g.p.render(var5/* $VF was: ☃ */, var6/* $VF was: ☃x */, this.g.ae());
            } catch (Throwable var14/* $VF was: ☃xxx */) {
               d var16/* $VF was: ☃xxxx */ = d.a(var14/* $VF was: ☃xxx */, "Rendering overlay");
               e var10/* $VF was: ☃xxxxx */ = var16/* $VF was: ☃xxxx */.a("Overlay render details");
               var10/* $VF was: ☃xxxxx */.a("Overlay name", () -> this.g.p.getClass().getCanonicalName());
               throw new m(var16/* $VF was: ☃xxxx */);
            }
         } else if (this.g.o != null) {
            GlStateManager.clear(256, cux.a);

            try {
               this.g.o.render(var5/* $VF was: ☃ */, var6/* $VF was: ☃x */, this.g.ae());
            } catch (Throwable var13/* $VF was: ☃xxx */) {
               d var17/* $VF was: ☃xxxx */ = d.a(var13/* $VF was: ☃xxx */, "Rendering screen");
               e var18/* $VF was: ☃xxxxx */ = var17/* $VF was: ☃xxxx */.a("Screen render details");
               var18/* $VF was: ☃xxxxx */.a("Screen name", () -> this.g.o.getClass().getCanonicalName());
               var18/* $VF was: ☃xxxxx */.a(
                  "Mouse location",
                  () -> String.format(
                     Locale.ROOT, "Scaled: (%d, %d). Absolute: (%f, %f)", var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, this.g.x.e(), this.g.x.f()
                  )
               );
               var18/* $VF was: ☃xxxxx */.a(
                  "Screen size",
                  () -> String.format(
                     Locale.ROOT,
                     "Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %f",
                     this.g.g.o(),
                     this.g.g.p(),
                     this.g.g.j(),
                     this.g.g.k(),
                     this.g.g.s()
                  )
               );
               throw new m(var17/* $VF was: ☃xxxx */);
            }
         }

         if (this.g.p == null) {
            this.q();
            if (GLX.usePostProcess && this.I != null) {
               GlStateManager.matrixMode(5890);
               GlStateManager.pushMatrix();
               GlStateManager.loadIdentity();
               this.I.a(var1/* $VF was: ☃ */);
               GlStateManager.popMatrix();
               GlStateManager.matrixMode(5888);
            }
         }
      }
   }

   private void p() {
      GlStateManager.disableTexture();
      GlStateManager.enableDepthTest();
      GlStateManager.colorMask(false, false, false, false);
      int var1/* $VF was: ☃ */ = this.g.g.o();
      int var2/* $VF was: ☃x */ = this.g.g.p();
      cuc var3/* $VF was: ☃xx */ = cuc.a();
      ctz var4/* $VF was: ☃xxx */ = var3/* $VF was: ☃xx */.c();
      var4/* $VF was: ☃xxx */.a(7, cub.l);
      var4/* $VF was: ☃xxx */.b(this.c, 10.0 + this.c, 10.0).b(0, 0, 0, 255).d();
      var4/* $VF was: ☃xxx */.b(this.c, var2/* $VF was: ☃x */ - this.c, 10.0).b(0, 0, 0, 255).d();
      var4/* $VF was: ☃xxx */.b(var1/* $VF was: ☃ */ - this.c, var2/* $VF was: ☃x */ - this.c, 10.0).b(0, 0, 0, 255).d();
      var4/* $VF was: ☃xxx */.b(var1/* $VF was: ☃ */ - this.c, 10.0 + this.c, 10.0).b(0, 0, 0, 255).d();
      var3/* $VF was: ☃xx */.b();
      GlStateManager.colorMask(true, true, true, true);
      GlStateManager.enableTexture();
      this.g.G().a(czn.BACKGROUND_LOCATION);
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var5/* $VF was: ☃xxxx */ = 32.0F;
      float var6/* $VF was: ☃xxxxx */ = 0.0F;
      var4/* $VF was: ☃xxx */.a(7, cub.m);
      var4/* $VF was: ☃xxx */.b(0.0, var2/* $VF was: ☃x */, 0.0).a(0.0, var2/* $VF was: ☃x */ / 32.0F + 0.0F).d();
      var4/* $VF was: ☃xxx */.b(var1/* $VF was: ☃ */, var2/* $VF was: ☃x */, 0.0).a(var1/* $VF was: ☃ */ / 32.0F, var2/* $VF was: ☃x */ / 32.0F + 0.0F).d();
      var4/* $VF was: ☃xxx */.b(var1/* $VF was: ☃ */, 0.0, 0.0).a(var1/* $VF was: ☃ */ / 32.0F, 0.0).d();
      var4/* $VF was: ☃xxx */.b(0.0, 0.0, 0.0).a(0.0, 0.0).d();
      var3/* $VF was: ☃xx */.b();
      GlStateManager.disableDepthTest();
      GlStateManager.clear(256, cux.a);
   }

   private void q() {
      GlStateManager.disableLighting();
      int var1 = this.g.g.o();
      cvp var2 = this.g.n;
      String text = dva.a("title.unregisteredVersion", new Object[0]);
      cvq.fill(0, 0, var1, 9 + 4, -65536);

      if ((this.P & 16) != 0) {
         var2.b(text, this.P, 4.0F, -16711936);
      }

      if (this.O++ > 10) {
         this.O = 0;
         this.P += 5;
         if (this.P > var1) {
            this.P = -var2.b(text);
         }
      }
   }

   private void r() {
      if (this.g.i.g() > 10 && this.g.i.m() && !this.g.B().q()) {
         ctm var1/* $VF was: ☃ */ = cvf.a(this.g.g.j(), this.g.g.k(), this.g.c());
         xh.a.execute(() -> {
            int var2/* $VF was: ☃x */ = var1/* $VF was: ☃ */.a();
            int var3/* $VF was: ☃x */ = var1/* $VF was: ☃ */.b();
            int var4/* $VF was: ☃xx */ = 0;
            int var5/* $VF was: ☃xxx */ = 0;
            if (var2/* $VF was: ☃x */ > var3/* $VF was: ☃x */) {
               var4/* $VF was: ☃xx */ = (var2/* $VF was: ☃x */ - var3/* $VF was: ☃x */) / 2;
               var2/* $VF was: ☃x */ = var3/* $VF was: ☃x */;
            } else {
               var5/* $VF was: ☃xxx */ = (var3/* $VF was: ☃x */ - var2/* $VF was: ☃x */) / 2;
               var3/* $VF was: ☃x */ = var2/* $VF was: ☃x */;
            }

            try (ctm var6/* $VF was: ☃xxxx */ = new ctm(64, 64, false)) {
               var1/* $VF was: ☃ */.a(var4/* $VF was: ☃xx */, var5/* $VF was: ☃xxx */, var2/* $VF was: ☃x */, var3/* $VF was: ☃x */, var6/* $VF was: ☃xxxx */);
               var6/* $VF was: ☃xxxx */.a(this.g.B().r());
            } catch (IOException var27/* $VF was: ☃xxxx */) {
               LOGGER.warn("Couldn't save auto screenshot", var27/* $VF was: ☃xxxx */);
            } finally {
               var1/* $VF was: ☃ */.close();
            }
         });
      }
   }

   private boolean s() {
      if (!this.r) {
         return false;
      }

      ahz var1/* $VF was: ☃ */ = this.g.U();
      boolean var2/* $VF was: ☃x */ = var1/* $VF was: ☃ */ instanceof avm && !this.g.w.aB;
      if (var2/* $VF was: ☃x */ && !((avm)var1/* $VF was: ☃ */).bN.e) {
         bbp var3/* $VF was: ☃xx */ = ((aii)var1/* $VF was: ☃ */).cM();
         cri var4/* $VF was: ☃xxx */ = this.g.v;
         if (var4/* $VF was: ☃xxx */ != null && var4/* $VF was: ☃xxx */.c() == Enum.valueOf(cri.a.class, "b")) {
            ev var5/* $VF was: ☃xxxx */ = ((crg)var4/* $VF was: ☃xxx */).a();
            buy var6/* $VF was: ☃xxxxx */ = this.g.h.e_(var5/* $VF was: ☃xxxx */);
            if (this.g.f.k() == bgu.e) {
               var2/* $VF was: ☃x */ = var6/* $VF was: ☃xxxxx */.b(this.g.h, var5/* $VF was: ☃xxxx */) != null;
            } else {
               bvc var7/* $VF was: ☃xxxxxx */ = new bvc(this.g.h, var5/* $VF was: ☃xxxx */, false);
               var2/* $VF was: ☃x */ = !var3/* $VF was: ☃xx */.a()
                  && (var3/* $VF was: ☃xx */.a(this.g.h.t(), var7/* $VF was: ☃xxxxxx */) || var3/* $VF was: ☃xx */.b(this.g.h.t(), var7/* $VF was: ☃xxxxxx */));
            }
         }
      }

      return var2/* $VF was: ☃x */;
   }

   public void a(float var1, long var2) {
      this.u.a(var1/* $VF was: ☃ */);
      if (this.g.U() == null) {
         this.g.a(this.g.j);
      }

      this.a(var1/* $VF was: ☃ */);
      GlStateManager.enableDepthTest();
      GlStateManager.enableAlphaTest();
      GlStateManager.alphaFunc(516, 0.5F);
      this.g.aq().a("center");
      this.b(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
      this.g.aq().c();
   }

   private void b(float var1, long var2) {
      dki var4/* $VF was: ☃ */ = this.g.i;
      dir var5/* $VF was: ☃x */ = this.g.m;
      boolean var6/* $VF was: ☃xx */ = this.s();
      GlStateManager.enableCull();
      this.g.aq().b("camera");
      this.f(var1/* $VF was: ☃ */);
      cun var7/* $VF was: ☃xxx */ = this.N;
      var7/* $VF was: ☃xxx */.a(this.g.h, this.g.U() == null ? this.g.j : this.g.U(), this.g.w.aC > 0, this.g.w.aC == 2, var1/* $VF was: ☃ */);
      dnk var8/* $VF was: ☃xxxx */ = dni.a();
      this.g.aq().b("clear");
      GlStateManager.viewport(0, 0, this.g.g.j(), this.g.g.k());
      this.y.a(var7/* $VF was: ☃xxx */, var1/* $VF was: ☃ */);
      GlStateManager.clear(16640, cux.a);
      this.g.aq().b("culling");
      dnh var9/* $VF was: ☃xxxxx */ = new dnj(var8/* $VF was: ☃xxxx */);
      double var10/* $VF was: ☃xxxxxx */ = var7/* $VF was: ☃xxx */.c().b;
      double var12/* $VF was: ☃xxxxxxx */ = var7/* $VF was: ☃xxx */.c().c;
      double var14/* $VF was: ☃xxxxxxxx */ = var7/* $VF was: ☃xxx */.c().d;
      var9/* $VF was: ☃xxxxx */.a(var10/* $VF was: ☃xxxxxx */, var12/* $VF was: ☃xxxxxxx */, var14/* $VF was: ☃xxxxxxxx */);
      if (this.g.w.c >= 4) {
         this.y.a(var7/* $VF was: ☃xxx */, -1);
         this.g.aq().b("sky");
         GlStateManager.matrixMode(5889);
         GlStateManager.loadIdentity();
         GlStateManager.multMatrix(cuh.a(this.a(var7/* $VF was: ☃xxx */, var1/* $VF was: ☃ */, true), (float)this.g.g.j() / this.g.g.k(), 0.05F, this.j * 2.0F));
         GlStateManager.matrixMode(5888);
         var4/* $VF was: ☃ */.a(var1/* $VF was: ☃ */);
         GlStateManager.matrixMode(5889);
         GlStateManager.loadIdentity();
         GlStateManager.multMatrix(cuh.a(this.a(var7/* $VF was: ☃xxx */, var1/* $VF was: ☃ */, true), (float)this.g.g.j() / this.g.g.k(), 0.05F, this.j * zq.a));
         GlStateManager.matrixMode(5888);
      }

      this.y.a(var7/* $VF was: ☃xxx */, 0);
      GlStateManager.shadeModel(7425);
      if (var7/* $VF was: ☃xxx */.c().c < 128.0) {
         this.a(
            var7/* $VF was: ☃xxx */,
            var4/* $VF was: ☃ */,
            var1/* $VF was: ☃ */,
            var10/* $VF was: ☃xxxxxx */,
            var12/* $VF was: ☃xxxxxxx */,
            var14/* $VF was: ☃xxxxxxxx */
         );
      }

      this.g.aq().b("prepareterrain");
      this.y.a(var7/* $VF was: ☃xxx */, 0);
      this.g.G().a(dud.f);
      cti.a();
      this.g.aq().b("terrain_setup");
      this.g.h.h().j().a(Integer.MAX_VALUE, true, true);
      var4/* $VF was: ☃ */.a(var7/* $VF was: ☃xxx */, var9/* $VF was: ☃xxxxx */, this.M++, this.g.j.t());
      this.g.aq().b("updatechunks");
      this.g.i.a(var2/* $VF was: ☃ */);
      this.g.aq().b("terrain");
      GlStateManager.matrixMode(5888);
      GlStateManager.pushMatrix();
      GlStateManager.disableAlphaTest();
      var4/* $VF was: ☃ */.a(bgj.a, var7/* $VF was: ☃xxx */);
      GlStateManager.enableAlphaTest();
      var4/* $VF was: ☃ */.a(bgj.b, var7/* $VF was: ☃xxx */);
      this.g.G().b(dud.f).b(false, false);
      var4/* $VF was: ☃ */.a(bgj.c, var7/* $VF was: ☃xxx */);
      this.g.G().b(dud.f).b();
      GlStateManager.shadeModel(7424);
      GlStateManager.alphaFunc(516, 0.1F);
      GlStateManager.matrixMode(5888);
      GlStateManager.popMatrix();
      GlStateManager.pushMatrix();
      cti.b();
      this.g.aq().b("entities");
      var4/* $VF was: ☃ */.a(var7/* $VF was: ☃xxx */, var9/* $VF was: ☃xxxxx */, var1/* $VF was: ☃ */);
      cti.a();
      this.h();
      GlStateManager.matrixMode(5888);
      GlStateManager.popMatrix();
      if (var6/* $VF was: ☃xx */ && this.g.v != null) {
         GlStateManager.disableAlphaTest();
         this.g.aq().b("outline");
         var4/* $VF was: ☃ */.a(var7/* $VF was: ☃xxx */, this.g.v, 0);
         GlStateManager.enableAlphaTest();
      }

      if (this.g.r.a()) {
         this.g.r.a(var2/* $VF was: ☃ */);
      }

      this.g.aq().b("destroyProgress");
      GlStateManager.enableBlend();
      GlStateManager.blendFuncSeparate(
         GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO
      );
      this.g.G().b(dud.f).b(false, false);
      var4/* $VF was: ☃ */.a(cuc.a(), cuc.a().c(), var7/* $VF was: ☃xxx */);
      this.g.G().b(dud.f).b();
      GlStateManager.disableBlend();
      this.i();
      this.y.a(var7/* $VF was: ☃xxx */, 0);
      this.g.aq().b("particles");
      var5/* $VF was: ☃x */.a(var7/* $VF was: ☃xxx */, var1/* $VF was: ☃ */);
      this.h();
      GlStateManager.depthMask(false);
      GlStateManager.enableCull();
      this.g.aq().b("weather");
      this.b(var1/* $VF was: ☃ */);
      GlStateManager.depthMask(true);
      var4/* $VF was: ☃ */.a(var7/* $VF was: ☃xxx */, var1/* $VF was: ☃ */);
      GlStateManager.disableBlend();
      GlStateManager.enableCull();
      GlStateManager.blendFuncSeparate(
         GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO
      );
      GlStateManager.alphaFunc(516, 0.1F);
      this.y.a(var7/* $VF was: ☃xxx */, 0);
      GlStateManager.enableBlend();
      GlStateManager.depthMask(false);
      this.g.G().a(dud.f);
      GlStateManager.shadeModel(7425);
      this.g.aq().b("translucent");
      var4/* $VF was: ☃ */.a(bgj.d, var7/* $VF was: ☃xxx */);
      GlStateManager.shadeModel(7424);
      GlStateManager.depthMask(true);
      GlStateManager.enableCull();
      GlStateManager.disableBlend();
      GlStateManager.disableFog();
      if (var7/* $VF was: ☃xxx */.c().c >= 128.0) {
         this.g.aq().b("aboveClouds");
         this.a(
            var7/* $VF was: ☃xxx */,
            var4/* $VF was: ☃ */,
            var1/* $VF was: ☃ */,
            var10/* $VF was: ☃xxxxxx */,
            var12/* $VF was: ☃xxxxxxx */,
            var14/* $VF was: ☃xxxxxxxx */
         );
      }

      this.g.aq().b("hand");
      if (this.q) {
         GlStateManager.clear(256, cux.a);
         this.a(var7/* $VF was: ☃xxx */, var1/* $VF was: ☃ */);
      }
   }

   private void a(cun var1, dki var2, float var3, double var4, double var6, double var8) {
      if (this.g.w.e() != cup.a) {
         this.g.aq().b("clouds");
         GlStateManager.matrixMode(5889);
         GlStateManager.loadIdentity();
         GlStateManager.multMatrix(cuh.a(this.a(var1/* $VF was: ☃ */, var3/* $VF was: ☃ */, true), (float)this.g.g.j() / this.g.g.k(), 0.05F, this.j * 4.0F));
         GlStateManager.matrixMode(5888);
         GlStateManager.pushMatrix();
         this.y.a(var1/* $VF was: ☃ */, 0);
         var2/* $VF was: ☃ */.a(var3/* $VF was: ☃ */, var4/* $VF was: ☃ */, var6/* $VF was: ☃ */, var8/* $VF was: ☃ */);
         GlStateManager.disableFog();
         GlStateManager.popMatrix();
         GlStateManager.matrixMode(5889);
         GlStateManager.loadIdentity();
         GlStateManager.multMatrix(cuh.a(this.a(var1/* $VF was: ☃ */, var3/* $VF was: ☃ */, true), (float)this.g.g.j() / this.g.g.k(), 0.05F, this.j * zq.a));
         GlStateManager.matrixMode(5888);
      }
   }

   private void t() {
      float var1/* $VF was: ☃ */ = this.g.h.h(1.0F);
      if (!this.g.w.f) {
         var1/* $VF was: ☃ */ /= 2.0F;
      }

      if (var1/* $VF was: ☃ */ != 0.0F) {
         this.i.setSeed(this.l * 312987231L);
         bha var2/* $VF was: ☃x */ = this.g.h;
         ev var3/* $VF was: ☃xx */ = new ev(this.N.c());
         int var4/* $VF was: ☃xxx */ = 10;
         double var5/* $VF was: ☃xxxx */ = 0.0;
         double var7/* $VF was: ☃xxxxx */ = 0.0;
         double var9/* $VF was: ☃xxxxxx */ = 0.0;
         int var11/* $VF was: ☃xxxxxxx */ = 0;
         int var12/* $VF was: ☃xxxxxxxx */ = (int)(100.0F * var1/* $VF was: ☃ */ * var1/* $VF was: ☃ */);
         if (this.g.w.aL == cvc.b) {
            var12/* $VF was: ☃xxxxxxxx */ >>= 1;
         } else if (this.g.w.aL == cvc.c) {
            var12/* $VF was: ☃xxxxxxxx */ = 0;
         }

         for (int var13/* $VF was: ☃xxxxxxxxx */ = 0; var13/* $VF was: ☃xxxxxxxxx */ < var12/* $VF was: ☃xxxxxxxx */; var13/* $VF was: ☃xxxxxxxxx */++) {
            ev var14/* $VF was: ☃xxxxxxxxxx */ = var2/* $VF was: ☃x */.a(
               byf.a.e, var3/* $VF was: ☃xx */.b(this.i.nextInt(10) - this.i.nextInt(10), 0, this.i.nextInt(10) - this.i.nextInt(10))
            );
            bhu var15/* $VF was: ☃xxxxxxxxxxx */ = var2/* $VF was: ☃x */.c(var14/* $VF was: ☃xxxxxxxxxx */);
            ev var16/* $VF was: ☃xxxxxxxxxxxx */ = var14/* $VF was: ☃xxxxxxxxxx */.c();
            if (var14/* $VF was: ☃xxxxxxxxxx */.p() <= var3/* $VF was: ☃xx */.p() + 10
               && var14/* $VF was: ☃xxxxxxxxxx */.p() >= var3/* $VF was: ☃xx */.p() - 10
               && var15/* $VF was: ☃xxxxxxxxxxx */.b() == Enum.valueOf(bhu.d.class, "b")
               && var15/* $VF was: ☃xxxxxxxxxxx */.c(var14/* $VF was: ☃xxxxxxxxxx */) >= 0.15F) {
               double var17/* $VF was: ☃xxxxxxxxxxxxx */ = this.i.nextDouble();
               double var19/* $VF was: ☃xxxxxxxxxxxxxx */ = this.i.nextDouble();
               buy var21/* $VF was: ☃xxxxxxxxxxxxxxx */ = var2/* $VF was: ☃x */.e_(var16/* $VF was: ☃xxxxxxxxxxxx */);
               ckn var22/* $VF was: ☃xxxxxxxxxxxxxxxx */ = var2/* $VF was: ☃x */.b(var14/* $VF was: ☃xxxxxxxxxx */);
               cse var23/* $VF was: ☃xxxxxxxxxxxxxxxxx */ = var21/* $VF was: ☃xxxxxxxxxxxxxxx */.j(var2/* $VF was: ☃x */, var16/* $VF was: ☃xxxxxxxxxxxx */);
               double var28/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ = var23/* $VF was: ☃xxxxxxxxxxxxxxxxx */.b(
                  Enum.valueOf(fa.a.class, "b"), var17/* $VF was: ☃xxxxxxxxxxxxx */, var19/* $VF was: ☃xxxxxxxxxxxxxx */
               );
               double var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ = var22/* $VF was: ☃xxxxxxxxxxxxxxxx */.a(var2/* $VF was: ☃x */, var14/* $VF was: ☃xxxxxxxxxx */);
               double var24/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */;
               double var26/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxx */;
               if (var28/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ >= var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */) {
                  var24/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */ = var28/* $VF was: ☃xxxxxxxxxxxxxxxxxx */;
                  var26/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxx */ = var23/* $VF was: ☃xxxxxxxxxxxxxxxxx */.a(
                     Enum.valueOf(fa.a.class, "b"), var17/* $VF was: ☃xxxxxxxxxxxxx */, var19/* $VF was: ☃xxxxxxxxxxxxxx */
                  );
               } else {
                  var24/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */ = 0.0;
                  var26/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxx */ = 0.0;
               }

               if (var24/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */ > -Double.MAX_VALUE) {
                  if (!var22/* $VF was: ☃xxxxxxxxxxxxxxxx */.a(yw.b)
                     && var21/* $VF was: ☃xxxxxxxxxxxxxxx */.d() != bmb.iB
                     && (var21/* $VF was: ☃xxxxxxxxxxxxxxx */.d() != bmb.lV || !var21/* $VF was: ☃xxxxxxxxxxxxxxx */.c(bmk.b))) {
                     if (this.i.nextInt(++var11/* $VF was: ☃xxxxxxx */) == 0) {
                        var5/* $VF was: ☃xxxx */ = var16/* $VF was: ☃xxxxxxxxxxxx */.o() + var17/* $VF was: ☃xxxxxxxxxxxxx */;
                        var7/* $VF was: ☃xxxxx */ = var16/* $VF was: ☃xxxxxxxxxxxx */.p() + 0.1F + var24/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */ - 1.0;
                        var9/* $VF was: ☃xxxxxx */ = var16/* $VF was: ☃xxxxxxxxxxxx */.q() + var19/* $VF was: ☃xxxxxxxxxxxxxx */;
                     }

                     this.g
                        .h
                        .a(
                           gf.P,
                           var16/* $VF was: ☃xxxxxxxxxxxx */.o() + var17/* $VF was: ☃xxxxxxxxxxxxx */,
                           var16/* $VF was: ☃xxxxxxxxxxxx */.p() + 0.1F + var24/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */,
                           var16/* $VF was: ☃xxxxxxxxxxxx */.q() + var19/* $VF was: ☃xxxxxxxxxxxxxx */,
                           0.0,
                           0.0,
                           0.0
                        );
                  } else {
                     this.g
                        .h
                        .a(
                           gf.Q,
                           var14/* $VF was: ☃xxxxxxxxxx */.o() + var17/* $VF was: ☃xxxxxxxxxxxxx */,
                           var14/* $VF was: ☃xxxxxxxxxx */.p() + 0.1F - var26/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxx */,
                           var14/* $VF was: ☃xxxxxxxxxx */.q() + var19/* $VF was: ☃xxxxxxxxxxxxxx */,
                           0.0,
                           0.0,
                           0.0
                        );
                  }
               }
            }
         }

         if (var11/* $VF was: ☃xxxxxxx */ > 0 && this.i.nextInt(3) < this.v++) {
            this.v = 0;
            if (var7/* $VF was: ☃xxxxx */ > var3/* $VF was: ☃xx */.p() + 1
               && var2/* $VF was: ☃x */.a(byf.a.e, var3/* $VF was: ☃xx */).p() > zq.d((float)var3/* $VF was: ☃xx */.p())) {
               this.g.h.a(var5/* $VF was: ☃xxxx */, var7/* $VF was: ☃xxxxx */, var9/* $VF was: ☃xxxxxx */, yi.nf, yj.d, 0.1F, 0.5F, false);
            } else {
               this.g.h.a(var5/* $VF was: ☃xxxx */, var7/* $VF was: ☃xxxxx */, var9/* $VF was: ☃xxxxxx */, yi.ne, yj.d, 0.2F, 1.0F, false);
            }
         }
      }
   }

   protected void b(float var1) {
      float var2/* $VF was: ☃ */ = this.g.h.h(var1/* $VF was: ☃ */);
      if (!(var2/* $VF was: ☃ */ <= 0.0F)) {
         this.i();
         bgx var3/* $VF was: ☃x */ = this.g.h;
         int var4/* $VF was: ☃xx */ = zq.c(this.N.c().b);
         int var5/* $VF was: ☃xxx */ = zq.c(this.N.c().c);
         int var6/* $VF was: ☃xxxx */ = zq.c(this.N.c().d);
         cuc var7/* $VF was: ☃xxxxx */ = cuc.a();
         ctz var8/* $VF was: ☃xxxxxx */ = var7/* $VF was: ☃xxxxx */.c();
         GlStateManager.disableCull();
         GlStateManager.normal3f(0.0F, 1.0F, 0.0F);
         GlStateManager.enableBlend();
         GlStateManager.blendFuncSeparate(
            GlStateManager.SourceFactor.SRC_ALPHA,
            GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
            GlStateManager.SourceFactor.ONE,
            GlStateManager.DestFactor.ZERO
         );
         GlStateManager.alphaFunc(516, 0.1F);
         double var9/* $VF was: ☃xxxxxxx */ = this.N.c().b;
         double var11/* $VF was: ☃xxxxxxxx */ = this.N.c().c;
         double var13/* $VF was: ☃xxxxxxxxx */ = this.N.c().d;
         int var15/* $VF was: ☃xxxxxxxxxx */ = zq.c(var11/* $VF was: ☃xxxxxxxx */);
         int var16/* $VF was: ☃xxxxxxxxxxx */ = 5;
         if (this.g.w.f) {
            var16/* $VF was: ☃xxxxxxxxxxx */ = 10;
         }

         int var17/* $VF was: ☃xxxxxxxxxxxx */ = -1;
         float var18/* $VF was: ☃xxxxxxxxxxxxx */ = this.l + var1/* $VF was: ☃ */;
         var8/* $VF was: ☃xxxxxx */.c(-var9/* $VF was: ☃xxxxxxx */, -var11/* $VF was: ☃xxxxxxxx */, -var13/* $VF was: ☃xxxxxxxxx */);
         GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
         ev.a var19/* $VF was: ☃xxxxxxxxxxxxxx */ = new ev.a();

         for (int var20/* $VF was: ☃xxxxxxxxxxxxxxx */ = var6/* $VF was: ☃xxxx */ - var16/* $VF was: ☃xxxxxxxxxxx */;
            var20/* $VF was: ☃xxxxxxxxxxxxxxx */ <= var6/* $VF was: ☃xxxx */ + var16/* $VF was: ☃xxxxxxxxxxx */;
            var20/* $VF was: ☃xxxxxxxxxxxxxxx */++
         ) {
            for (int var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ = var4/* $VF was: ☃xx */ - var16/* $VF was: ☃xxxxxxxxxxx */;
               var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ <= var4/* $VF was: ☃xx */ + var16/* $VF was: ☃xxxxxxxxxxx */;
               var21/* $VF was: ☃xxxxxxxxxxxxxxxx */++
            ) {
               int var22/* $VF was: ☃xxxxxxxxxxxxxxxxx */ = (var20/* $VF was: ☃xxxxxxxxxxxxxxx */ - var6/* $VF was: ☃xxxx */ + 16) * 32
                  + var21/* $VF was: ☃xxxxxxxxxxxxxxxx */
                  - var4/* $VF was: ☃xx */
                  + 16;
               double var23/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ = this.w[var22/* $VF was: ☃xxxxxxxxxxxxxxxxx */] * 0.5;
               double var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ = this.x[var22/* $VF was: ☃xxxxxxxxxxxxxxxxx */] * 0.5;
               var19/* $VF was: ☃xxxxxxxxxxxxxx */.d(var21/* $VF was: ☃xxxxxxxxxxxxxxxx */, 0, var20/* $VF was: ☃xxxxxxxxxxxxxxx */);
               bhu var27/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */ = var3/* $VF was: ☃x */.c(var19/* $VF was: ☃xxxxxxxxxxxxxx */);
               if (var27/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */.b() != Enum.valueOf(bhu.d.class, "a")) {
                  int var28/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxx */ = var3/* $VF was: ☃x */.a(byf.a.e, var19/* $VF was: ☃xxxxxxxxxxxxxx */).p();
                  int var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */ = var5/* $VF was: ☃xxx */ - var16/* $VF was: ☃xxxxxxxxxxx */;
                  int var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */ = var5/* $VF was: ☃xxx */ + var16/* $VF was: ☃xxxxxxxxxxx */;
                  if (var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */ < var28/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxx */) {
                     var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */ = var28/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxx */;
                  }

                  if (var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */ < var28/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxx */) {
                     var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */ = var28/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxx */;
                  }

                  int var31/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxx */ = var28/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxx */;
                  if (var31/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxx */ < var15/* $VF was: ☃xxxxxxxxxx */) {
                     var31/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxx */ = var15/* $VF was: ☃xxxxxxxxxx */;
                  }

                  if (var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */ != var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */) {
                     this.i
                        .setSeed(
                           var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ * var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ * 3121
                                 + var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ * 45238971
                              ^ var20/* $VF was: ☃xxxxxxxxxxxxxxx */ * var20/* $VF was: ☃xxxxxxxxxxxxxxx */ * 418711
                                 + var20/* $VF was: ☃xxxxxxxxxxxxxxx */ * 13761
                        );
                     var19/* $VF was: ☃xxxxxxxxxxxxxx */.d(
                        var21/* $VF was: ☃xxxxxxxxxxxxxxxx */, var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */, var20/* $VF was: ☃xxxxxxxxxxxxxxx */
                     );
                     float var32/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxx */ = var27/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */.c(var19/* $VF was: ☃xxxxxxxxxxxxxx */);
                     if (var32/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxx */ >= 0.15F) {
                        if (var17/* $VF was: ☃xxxxxxxxxxxx */ != 0) {
                           if (var17/* $VF was: ☃xxxxxxxxxxxx */ >= 0) {
                              var7/* $VF was: ☃xxxxx */.b();
                           }

                           var17/* $VF was: ☃xxxxxxxxxxxx */ = 0;
                           this.g.G().a(e);
                           var8/* $VF was: ☃xxxxxx */.a(7, cub.j);
                        }

                        double var33/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxx */ = -(
                              (double)(
                                    this.l
                                          + var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ * var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ * 3121
                                          + var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ * 45238971
                                          + var20/* $VF was: ☃xxxxxxxxxxxxxxx */ * var20/* $VF was: ☃xxxxxxxxxxxxxxx */ * 418711
                                          + var20/* $VF was: ☃xxxxxxxxxxxxxxx */ * 13761
                                       & 31
                                 )
                                 + var1/* $VF was: ☃ */
                           )
                           / 32.0
                           * (3.0 + this.i.nextDouble());
                        double var35/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxx */ = var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ + 0.5F - this.N.c().b;
                        double var37/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = var20/* $VF was: ☃xxxxxxxxxxxxxxx */ + 0.5F - this.N.c().d;
                        float var39/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = zq.a(
                              var35/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxx */ * var35/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxx */
                                 + var37/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxx */ * var37/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxx */
                           )
                           / var16/* $VF was: ☃xxxxxxxxxxx */;
                        float var40/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = (
                              (1.0F - var39/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ * var39/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxx */) * 0.5F + 0.5F
                           )
                           * var2/* $VF was: ☃ */;
                        var19/* $VF was: ☃xxxxxxxxxxxxxx */.d(
                           var21/* $VF was: ☃xxxxxxxxxxxxxxxx */, var31/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxx */, var20/* $VF was: ☃xxxxxxxxxxxxxxx */
                        );
                        int var41/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = var3/* $VF was: ☃x */.b(var19/* $VF was: ☃xxxxxxxxxxxxxx */, 0);
                        int var42/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = var41/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ >> 16 & 65535;
                        int var43/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = var41/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ & 65535;
                        var8/* $VF was: ☃xxxxxx */.b(
                              var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ - var23/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ + 0.5,
                              var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */,
                              var20/* $VF was: ☃xxxxxxxxxxxxxxx */ - var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ + 0.5
                           )
                           .a(0.0, var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */ * 0.25 + var33/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(1.0F, 1.0F, 1.0F, var40/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(var42/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */, var43/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .d();
                        var8/* $VF was: ☃xxxxxx */.b(
                              var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ + var23/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ + 0.5,
                              var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */,
                              var20/* $VF was: ☃xxxxxxxxxxxxxxx */ + var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ + 0.5
                           )
                           .a(1.0, var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */ * 0.25 + var33/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(1.0F, 1.0F, 1.0F, var40/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(var42/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */, var43/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .d();
                        var8/* $VF was: ☃xxxxxx */.b(
                              var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ + var23/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ + 0.5,
                              var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */,
                              var20/* $VF was: ☃xxxxxxxxxxxxxxx */ + var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ + 0.5
                           )
                           .a(1.0, var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */ * 0.25 + var33/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(1.0F, 1.0F, 1.0F, var40/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(var42/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */, var43/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .d();
                        var8/* $VF was: ☃xxxxxx */.b(
                              var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ - var23/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ + 0.5,
                              var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */,
                              var20/* $VF was: ☃xxxxxxxxxxxxxxx */ - var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ + 0.5
                           )
                           .a(0.0, var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */ * 0.25 + var33/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(1.0F, 1.0F, 1.0F, var40/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(var42/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */, var43/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .d();
                     } else {
                        if (var17/* $VF was: ☃xxxxxxxxxxxx */ != 1) {
                           if (var17/* $VF was: ☃xxxxxxxxxxxx */ >= 0) {
                              var7/* $VF was: ☃xxxxx */.b();
                           }

                           var17/* $VF was: ☃xxxxxxxxxxxx */ = 1;
                           this.g.G().a(f);
                           var8/* $VF was: ☃xxxxxx */.a(7, cub.j);
                        }

                        double var48/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxx */ = -((this.l & 511) + var1/* $VF was: ☃ */) / 512.0F;
                        double var49/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxx */ = this.i.nextDouble()
                           + var18/* $VF was: ☃xxxxxxxxxxxxx */ * 0.01 * (float)this.i.nextGaussian();
                        double var50/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = this.i.nextDouble()
                           + var18/* $VF was: ☃xxxxxxxxxxxxx */ * (float)this.i.nextGaussian() * 0.001;
                        double var51/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ + 0.5F - this.N.c().b;
                        double var52/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = var20/* $VF was: ☃xxxxxxxxxxxxxxx */ + 0.5F - this.N.c().d;
                        float var53/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = zq.a(
                              var51/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ * var51/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxx */
                                 + var52/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ * var52/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */
                           )
                           / var16/* $VF was: ☃xxxxxxxxxxx */;
                        float var44/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = (
                              (1.0F - var53/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ * var53/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */) * 0.3F
                                 + 0.5F
                           )
                           * var2/* $VF was: ☃ */;
                        var19/* $VF was: ☃xxxxxxxxxxxxxx */.d(
                           var21/* $VF was: ☃xxxxxxxxxxxxxxxx */, var31/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxx */, var20/* $VF was: ☃xxxxxxxxxxxxxxx */
                        );
                        int var45/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = (
                              var3/* $VF was: ☃x */.b(var19/* $VF was: ☃xxxxxxxxxxxxxx */, 0) * 3 + 15728880
                           )
                           / 4;
                        int var46/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = var45/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ >> 16 & 65535;
                        int var47/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ = var45/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */ & 65535;
                        var8/* $VF was: ☃xxxxxx */.b(
                              var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ - var23/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ + 0.5,
                              var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */,
                              var20/* $VF was: ☃xxxxxxxxxxxxxxx */ - var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ + 0.5
                           )
                           .a(
                              0.0 + var49/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxx */,
                              var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */ * 0.25
                                 + var48/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxx */
                                 + var50/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxx */
                           )
                           .a(1.0F, 1.0F, 1.0F, var44/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(var46/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */, var47/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .d();
                        var8/* $VF was: ☃xxxxxx */.b(
                              var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ + var23/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ + 0.5,
                              var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */,
                              var20/* $VF was: ☃xxxxxxxxxxxxxxx */ + var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ + 0.5
                           )
                           .a(
                              1.0 + var49/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxx */,
                              var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */ * 0.25
                                 + var48/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxx */
                                 + var50/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxx */
                           )
                           .a(1.0F, 1.0F, 1.0F, var44/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(var46/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */, var47/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .d();
                        var8/* $VF was: ☃xxxxxx */.b(
                              var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ + var23/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ + 0.5,
                              var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */,
                              var20/* $VF was: ☃xxxxxxxxxxxxxxx */ + var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ + 0.5
                           )
                           .a(
                              1.0 + var49/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxx */,
                              var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */ * 0.25
                                 + var48/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxx */
                                 + var50/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxx */
                           )
                           .a(1.0F, 1.0F, 1.0F, var44/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(var46/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */, var47/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .d();
                        var8/* $VF was: ☃xxxxxx */.b(
                              var21/* $VF was: ☃xxxxxxxxxxxxxxxx */ - var23/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ + 0.5,
                              var29/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */,
                              var20/* $VF was: ☃xxxxxxxxxxxxxxx */ - var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ + 0.5
                           )
                           .a(
                              0.0 + var49/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxx */,
                              var30/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */ * 0.25
                                 + var48/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxx */
                                 + var50/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxx */
                           )
                           .a(1.0F, 1.0F, 1.0F, var44/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .a(var46/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */, var47/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx */)
                           .d();
                     }
                  }
               }
            }
         }

         if (var17/* $VF was: ☃xxxxxxxxxxxx */ >= 0) {
            var7/* $VF was: ☃xxxxx */.b();
         }

         var8/* $VF was: ☃xxxxxx */.c(0.0, 0.0, 0.0);
         GlStateManager.enableCull();
         GlStateManager.disableBlend();
         GlStateManager.alphaFunc(516, 0.1F);
         this.h();
      }
   }

   public void d(boolean var1) {
      this.y.a(var1/* $VF was: ☃ */);
   }

   public void j() {
      this.D = null;
      this.k.a();
      this.N.o();
   }

   public cvs k() {
      return this.k;
   }

   public static void a(cvp var0, String var1, float var2, float var3, float var4, int var5, float var6, float var7, boolean var8) {
      GlStateManager.pushMatrix();
      GlStateManager.translatef(var2/* $VF was: ☃ */, var3/* $VF was: ☃ */, var4/* $VF was: ☃ */);
      GlStateManager.normal3f(0.0F, 1.0F, 0.0F);
      GlStateManager.rotatef(-var6/* $VF was: ☃ */, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotatef(var7/* $VF was: ☃ */, 1.0F, 0.0F, 0.0F);
      GlStateManager.scalef(-0.025F, -0.025F, 0.025F);
      GlStateManager.disableLighting();
      GlStateManager.depthMask(false);
      if (!var8/* $VF was: ☃ */) {
         GlStateManager.disableDepthTest();
      }

      GlStateManager.enableBlend();
      GlStateManager.blendFuncSeparate(
         GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO
      );
      int var9/* $VF was: ☃ */ = var0/* $VF was: ☃ */.b(var1/* $VF was: ☃ */) / 2;
      GlStateManager.disableTexture();
      cuc var10/* $VF was: ☃x */ = cuc.a();
      ctz var11/* $VF was: ☃xx */ = var10/* $VF was: ☃x */.c();
      var11/* $VF was: ☃xx */.a(7, cub.l);
      float var12/* $VF was: ☃xxx */ = cux.v().w.a(0.25F);
      var11/* $VF was: ☃xx */.b(-var9/* $VF was: ☃ */ - 1, -1 + var5/* $VF was: ☃ */, 0.0).a(0.0F, 0.0F, 0.0F, var12/* $VF was: ☃xxx */).d();
      var11/* $VF was: ☃xx */.b(-var9/* $VF was: ☃ */ - 1, 8 + var5/* $VF was: ☃ */, 0.0).a(0.0F, 0.0F, 0.0F, var12/* $VF was: ☃xxx */).d();
      var11/* $VF was: ☃xx */.b(var9/* $VF was: ☃ */ + 1, 8 + var5/* $VF was: ☃ */, 0.0).a(0.0F, 0.0F, 0.0F, var12/* $VF was: ☃xxx */).d();
      var11/* $VF was: ☃xx */.b(var9/* $VF was: ☃ */ + 1, -1 + var5/* $VF was: ☃ */, 0.0).a(0.0F, 0.0F, 0.0F, var12/* $VF was: ☃xxx */).d();
      var10/* $VF was: ☃x */.b();
      GlStateManager.enableTexture();
      if (!var8/* $VF was: ☃ */) {
         var0/* $VF was: ☃ */.b(var1/* $VF was: ☃ */, -var0/* $VF was: ☃ */.b(var1/* $VF was: ☃ */) / 2, var5/* $VF was: ☃ */, 553648127);
         GlStateManager.enableDepthTest();
      }

      GlStateManager.depthMask(true);
      var0/* $VF was: ☃ */.b(
         var1/* $VF was: ☃ */, -var0/* $VF was: ☃ */.b(var1/* $VF was: ☃ */) / 2, var5/* $VF was: ☃ */, var8/* $VF was: ☃ */ ? 553648127 : -1
      );
      GlStateManager.enableLighting();
      GlStateManager.disableBlend();
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.popMatrix();
   }

   public void a(bbp var1) {
      this.D = var1/* $VF was: ☃ */;
      this.E = 40;
      this.F = this.i.nextFloat() * 2.0F - 1.0F;
      this.G = this.i.nextFloat() * 2.0F - 1.0F;
   }

   private void a(int var1, int var2, float var3) {
      if (this.D != null && this.E > 0) {
         int var4/* $VF was: ☃ */ = 40 - this.E;
         float var5/* $VF was: ☃x */ = (var4/* $VF was: ☃ */ + var3/* $VF was: ☃ */) / 40.0F;
         float var6/* $VF was: ☃xx */ = var5/* $VF was: ☃x */ * var5/* $VF was: ☃x */;
         float var7/* $VF was: ☃xxx */ = var5/* $VF was: ☃x */ * var6/* $VF was: ☃xx */;
         float var8/* $VF was: ☃xxxx */ = 10.25F * var7/* $VF was: ☃xxx */ * var6/* $VF was: ☃xx */
            - 24.95F * var6/* $VF was: ☃xx */ * var6/* $VF was: ☃xx */
            + 25.5F * var7/* $VF was: ☃xxx */
            - 13.8F * var6/* $VF was: ☃xx */
            + 4.0F * var5/* $VF was: ☃x */;
         float var9/* $VF was: ☃xxxxx */ = var8/* $VF was: ☃xxxx */ * (float) Math.PI;
         float var10/* $VF was: ☃xxxxxx */ = this.F * (var1/* $VF was: ☃ */ / 4);
         float var11/* $VF was: ☃xxxxxxx */ = this.G * (var2/* $VF was: ☃ */ / 4);
         GlStateManager.enableAlphaTest();
         GlStateManager.pushMatrix();
         GlStateManager.pushLightingAttributes();
         GlStateManager.enableDepthTest();
         GlStateManager.disableCull();
         cti.b();
         GlStateManager.translatef(
            var1/* $VF was: ☃ */ / 2 + var10/* $VF was: ☃xxxxxx */ * zq.e(zq.a(var9/* $VF was: ☃xxxxx */ * 2.0F)),
            var2/* $VF was: ☃ */ / 2 + var11/* $VF was: ☃xxxxxxx */ * zq.e(zq.a(var9/* $VF was: ☃xxxxx */ * 2.0F)),
            -50.0F
         );
         float var12/* $VF was: ☃xxxxxxxx */ = 50.0F + 175.0F * zq.a(var9/* $VF was: ☃xxxxx */);
         GlStateManager.scalef(var12/* $VF was: ☃xxxxxxxx */, -var12/* $VF was: ☃xxxxxxxx */, var12/* $VF was: ☃xxxxxxxx */);
         GlStateManager.rotatef(900.0F * zq.e(zq.a(var9/* $VF was: ☃xxxxx */)), 0.0F, 1.0F, 0.0F);
         GlStateManager.rotatef(6.0F * zq.b(var5/* $VF was: ☃x */ * 8.0F), 1.0F, 0.0F, 0.0F);
         GlStateManager.rotatef(6.0F * zq.b(var5/* $VF was: ☃x */ * 8.0F), 0.0F, 0.0F, 1.0F);
         this.g.X().a(this.D, Enum.valueOf(dlo.b.class, "i"));
         GlStateManager.popAttributes();
         GlStateManager.popMatrix();
         cti.a();
         GlStateManager.enableCull();
         GlStateManager.disableDepthTest();
      }
   }

   public cux l() {
      return this.g;
   }

   public float c(float var1) {
      return zq.f(var1/* $VF was: ☃ */, this.fieldP, this.o);
   }

   public float m() {
      return this.j;
   }

   public cun n() {
      return this.N;
   }
}
