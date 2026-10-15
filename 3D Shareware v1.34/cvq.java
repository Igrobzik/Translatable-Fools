import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Locale;

public class cvq extends cvr {
   private static final qr b = new qr("textures/misc/vignette.png");
   private static final qr WIDGETS_TEXTURE = new qr("textures/gui/widgets.png");
   private static final qr d = new qr("textures/gui/hotbar.png");
   private static qr getHotbarTexture(cux minecraft) {
      String language = minecraft.w.aN;
      if (language == null || language.trim().isEmpty()) {
         return d;
      }
      language = language.trim().toLowerCase(Locale.ROOT);
      qr localizedTexture = new qr("textures/gui/hotbar_" + language + ".png");
      if (minecraft.J().a().b(wg.a, localizedTexture)) {
         return localizedTexture;
      }
      return d;
   }
   private static final qr e = new qr("textures/misc/pumpkinblur.png");
   private final Random f = new Random();
   private final cux g;
   private final dpx h;
   private final cwd i;
   private int j;
   private String k = "";
   private int l;
   private boolean m;
   public float a = 1.0F;
   private int n;
   private bbp o = bbp.a;
   private final cwg overlay;
   private final cws q;
   private final cxa r;
   private final cwo s;
   private final cwb t;
   private int u;
   private String v = "";
   private String w = "";
   private int x;
   private int y;
   private int z;
   private int A;
   private int B;
   private final Map<jk, List<cvt>> C = Maps.newHashMap();

   public cvq(cux var1) {
      this.g = var1/* $VF was: ☃ */;
      this.h = var1/* $VF was: ☃ */.X();
      this.overlay = new cwg(var1/* $VF was: ☃ */);
      this.r = new cxa(var1/* $VF was: ☃ */);
      this.i = new cwd(var1/* $VF was: ☃ */);
      this.s = new cwo(var1/* $VF was: ☃ */, this);
      this.t = new cwb(var1/* $VF was: ☃ */);
      this.q = new cws(var1/* $VF was: ☃ */);

      for (jk var5/* $VF was: ☃ */ : jk.values()) {
         this.C.put(var5/* $VF was: ☃ */, Lists.newArrayList());
      }

      cvt var6/* $VF was: ☃ */ = cvu.b;
      this.C.get(jk.a).add(new cvw(var1/* $VF was: ☃ */));
      this.C.get(jk.a).add(var6/* $VF was: ☃ */);
      this.C.get(jk.b).add(new cvw(var1/* $VF was: ☃ */));
      this.C.get(jk.b).add(var6/* $VF was: ☃ */);
      this.C.get(jk.c).add(new cvv(var1/* $VF was: ☃ */));
      this.a();
   }

   public void a() {
      this.x = 10;
      this.y = 70;
      this.z = 20;
   }

   public void a(float var1) {
      this.A = this.g.g.o();
      this.B = this.g.g.p();
      cvp var2/* $VF was: ☃ */ = this.h();
      GlStateManager.enableBlend();
      if (cux.t()) {
         this.b(this.g.U());
      } else {
         GlStateManager.enableDepthTest();
         GlStateManager.blendFuncSeparate(
            GlStateManager.SourceFactor.SRC_ALPHA,
            GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
            GlStateManager.SourceFactor.ONE,
            GlStateManager.DestFactor.ZERO
         );
      }

      bbp var3/* $VF was: ☃x */ = this.g.j.bx.e(3);
      if (this.g.w.aC == 0 && var3/* $VF was: ☃x */.b() == bmb.cN.g()) {
         this.s();
      }

      if (!this.g.j.a(ahv.i)) {
         float var4/* $VF was: ☃xx */ = zq.f(var1/* $VF was: ☃ */, this.g.j.cb, this.g.j.ca);
         if (var4/* $VF was: ☃xx */ > 0.0F) {
            this.c(var4/* $VF was: ☃xx */);
         }
      }

      if (this.g.f.k() == bgu.e) {
         this.r.a(var1/* $VF was: ☃ */);
      } else if (!this.g.w.aB) {
         this.b(var1/* $VF was: ☃ */);
      }

      if (!this.g.w.aB) {
         GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.g.G().a(GUI_ICONS_LOCATION);
         GlStateManager.enableBlend();
         GlStateManager.enableAlphaTest();
         this.n();
         GlStateManager.blendFuncSeparate(
            GlStateManager.SourceFactor.SRC_ALPHA,
            GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
            GlStateManager.SourceFactor.ONE,
            GlStateManager.DestFactor.ZERO
         );
         this.g.aq().a("bossHealth");
         this.t.a();
         this.g.aq().c();
         GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.g.G().a(GUI_ICONS_LOCATION);
         if (this.g.f.a()) {
            this.q();
         }

         GlStateManager.disableBlend();
         int var9/* $VF was: ☃xx */ = this.A / 2 - 91;
         if (this.g.j.F()) {
            this.a(var9/* $VF was: ☃xx */);
         } else if (this.g.f.e()) {
         }

         if (this.g.w.t && this.g.f.k() != bgu.e) {
            this.c();
         } else if (this.g.j.t()) {
            this.r.a();
         }
      }

      if (this.g.j.dF() > 0) {
         this.g.aq().a("sleep");
         GlStateManager.disableDepthTest();
         GlStateManager.disableAlphaTest();
         float var10/* $VF was: ☃xx */ = this.g.j.dF();
         float var5/* $VF was: ☃xxx */ = var10/* $VF was: ☃xx */ / 100.0F;
         if (var5/* $VF was: ☃xxx */ > 1.0F) {
            var5/* $VF was: ☃xxx */ = 1.0F - (var10/* $VF was: ☃xx */ - 100.0F) / 10.0F;
         }

         int var6/* $VF was: ☃xxxx */ = (int)(220.0F * var5/* $VF was: ☃xxx */) << 24 | 1052704;
         fill(0, 0, this.A, this.B, var6/* $VF was: ☃xxxx */);
         GlStateManager.enableAlphaTest();
         GlStateManager.enableDepthTest();
         this.g.aq().c();
         GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      }

      if (this.g.q()) {
         this.d();
      }

      this.b();
      if (this.g.w.aD) {
         this.overlay.b();
      }

      if (!this.g.w.aB) {
         if (this.l > 0) {
            this.g.aq().a("overlayMessage");
            float var11/* $VF was: ☃xx */ = this.l - var1/* $VF was: ☃ */;
            int var14/* $VF was: ☃xxx */ = (int)(var11/* $VF was: ☃xx */ * 255.0F / 20.0F);
            if (var14/* $VF was: ☃xxx */ > 255) {
               var14/* $VF was: ☃xxx */ = 255;
            }

            if (var14/* $VF was: ☃xxx */ > 8) {
               GlStateManager.pushMatrix();
               GlStateManager.translatef(this.A / 2, this.B - 68, 0.0F);
               GlStateManager.enableBlend();
               GlStateManager.blendFuncSeparate(
                  GlStateManager.SourceFactor.SRC_ALPHA,
                  GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                  GlStateManager.SourceFactor.ONE,
                  GlStateManager.DestFactor.ZERO
               );
               int var18/* $VF was: ☃xxxx */ = 16777215;
               if (this.m) {
                  var18/* $VF was: ☃xxxx */ = zq.e(var11/* $VF was: ☃xx */ / 50.0F, 0.7F, 0.6F) & 16777215;
               }

               int var7/* $VF was: ☃xxxxx */ = var14/* $VF was: ☃xxx */ << 24 & 0xFF000000;
               this.a(var2/* $VF was: ☃ */, -4, var2/* $VF was: ☃ */.b(this.k));
               var2/* $VF was: ☃ */.b(this.k, -var2/* $VF was: ☃ */.b(this.k) / 2, -4.0F, var18/* $VF was: ☃xxxx */ | var7/* $VF was: ☃xxxxx */);
               GlStateManager.disableBlend();
               GlStateManager.popMatrix();
            }

            this.g.aq().c();
         }

         if (this.u > 0) {
            this.g.aq().a("titleAndSubtitle");
            float var12/* $VF was: ☃xx */ = this.u - var1/* $VF was: ☃ */;
            int var15/* $VF was: ☃xxx */ = 255;
            if (this.u > this.z + this.y) {
               float var19/* $VF was: ☃xxxx */ = this.x + this.y + this.z - var12/* $VF was: ☃xx */;
               var15/* $VF was: ☃xxx */ = (int)(var19/* $VF was: ☃xxxx */ * 255.0F / this.x);
            }

            if (this.u <= this.z) {
               var15/* $VF was: ☃xxx */ = (int)(var12/* $VF was: ☃xx */ * 255.0F / this.z);
            }

            var15/* $VF was: ☃xxx */ = zq.a(var15/* $VF was: ☃xxx */, 0, 255);
            if (var15/* $VF was: ☃xxx */ > 8) {
               GlStateManager.pushMatrix();
               GlStateManager.translatef(this.A / 2, this.B / 2, 0.0F);
               GlStateManager.enableBlend();
               GlStateManager.blendFuncSeparate(
                  GlStateManager.SourceFactor.SRC_ALPHA,
                  GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                  GlStateManager.SourceFactor.ONE,
                  GlStateManager.DestFactor.ZERO
               );
               GlStateManager.pushMatrix();
               GlStateManager.scalef(4.0F, 4.0F, 4.0F);
               int var20/* $VF was: ☃xxxx */ = var15/* $VF was: ☃xxx */ << 24 & 0xFF000000;
               int var22/* $VF was: ☃xxxxx */ = var2/* $VF was: ☃ */.b(this.v);
               this.a(var2/* $VF was: ☃ */, -10, var22/* $VF was: ☃xxxxx */);
               var2/* $VF was: ☃ */.a(this.v, -var22/* $VF was: ☃xxxxx */ / 2, -10.0F, 16777215 | var20/* $VF was: ☃xxxx */);
               GlStateManager.popMatrix();
               if (!this.w.isEmpty()) {
                  GlStateManager.pushMatrix();
                  GlStateManager.scalef(2.0F, 2.0F, 2.0F);
                  int var8/* $VF was: ☃xxxxxx */ = var2/* $VF was: ☃ */.b(this.w);
                  this.a(var2/* $VF was: ☃ */, 5, var8/* $VF was: ☃xxxxxx */);
                  var2/* $VF was: ☃ */.a(this.w, -var8/* $VF was: ☃xxxxxx */ / 2, 5.0F, 16777215 | var20/* $VF was: ☃xxxx */);
                  GlStateManager.popMatrix();
               }

               GlStateManager.disableBlend();
               GlStateManager.popMatrix();
            }

            this.g.aq().c();
         }

         this.q.a();
         csk var13/* $VF was: ☃xx */ = this.g.h.D();
         csh var17/* $VF was: ☃xxx */ = null;
         csi var21/* $VF was: ☃xxxx */ = var13/* $VF was: ☃xx */.i(this.g.j.by());
         if (var21/* $VF was: ☃xxxx */ != null) {
            int var23/* $VF was: ☃xxxxx */ = var21/* $VF was: ☃xxxx */.n().b();
            if (var23/* $VF was: ☃xxxxx */ >= 0) {
               var17/* $VF was: ☃xxx */ = var13/* $VF was: ☃xx */.a(3 + var23/* $VF was: ☃xxxxx */);
            }
         }

         csh var24/* $VF was: ☃xxxxx */ = var17/* $VF was: ☃xxx */ != null ? var17/* $VF was: ☃xxx */ : var13/* $VF was: ☃xx */.a(1);
         if (var24/* $VF was: ☃xxxxx */ != null) {
            this.a(var24/* $VF was: ☃xxxxx */);
         }

         GlStateManager.enableBlend();
         GlStateManager.blendFuncSeparate(
            GlStateManager.SourceFactor.SRC_ALPHA,
            GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
            GlStateManager.SourceFactor.ONE,
            GlStateManager.DestFactor.ZERO
         );
         GlStateManager.disableAlphaTest();
         GlStateManager.pushMatrix();
         GlStateManager.translatef(0.0F, this.B - 48, 0.0F);
         this.g.aq().a("chat");
         this.i.a(this.j);
         this.g.aq().c();
         GlStateManager.popMatrix();
         var24/* $VF was: ☃xxxxx */ = var13/* $VF was: ☃xx */.a(0);
         if (!this.g.w.ak.d() || this.g.z() && this.g.j.e.e().size() <= 1 && var24/* $VF was: ☃xxxxx */ == null) {
            this.s.a(false);
         } else {
            this.s.a(true);
            this.s.a(this.A, var13/* $VF was: ☃xx */, var24/* $VF was: ☃xxxxx */);
         }
      }

      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.disableLighting();
      GlStateManager.enableAlphaTest();
   }

   private void a(cvp var1, int var2, int var3) {
      int var4/* $VF was: ☃ */ = this.g.w.b(0.0F);
      if (var4/* $VF was: ☃ */ != 0) {
         int var5/* $VF was: ☃x */ = -var3/* $VF was: ☃ */ / 2;
         fill(
            var5/* $VF was: ☃x */ - 2,
            var2/* $VF was: ☃ */ - 2,
            var5/* $VF was: ☃x */ + var3/* $VF was: ☃ */ + 2,
            var2/* $VF was: ☃ */ + 9 + 2,
            var4/* $VF was: ☃ */
         );
      }
   }

   private void n() {
      cvb var1/* $VF was: ☃ */ = this.g.w;
      if (var1/* $VF was: ☃ */.aC == 0) {
         if (this.g.f.k() != bgu.e || this.a(this.g.v)) {
            if (var1/* $VF was: ☃ */.aD && !var1/* $VF was: ☃ */.aB && !this.g.j.dR() && !var1/* $VF was: ☃ */.P) {
               GlStateManager.pushMatrix();
               GlStateManager.translatef(this.A / 2, this.B / 2, this.blitOffset);
               cun var8/* $VF was: ☃x */ = this.g.q.n();
               GlStateManager.rotatef(var8/* $VF was: ☃x */.e(), -1.0F, 0.0F, 0.0F);
               GlStateManager.rotatef(var8/* $VF was: ☃x */.f(), 0.0F, 1.0F, 0.0F);
               GlStateManager.scalef(-1.0F, -1.0F, -1.0F);
               GLX.renderCrosshair(10);
               GlStateManager.popMatrix();
            } else {
               GlStateManager.blendFuncSeparate(
                  GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR,
                  GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR,
                  GlStateManager.SourceFactor.ONE,
                  GlStateManager.DestFactor.ZERO
               );
               int var2/* $VF was: ☃x */ = 15;
               this.blit((float)(this.A / 2.0F - 7.5F), (float)(this.B / 2.0F - 7.5F), 0, 0, 15, 15);
               if (this.g.w.A == cul.b) {
                  float var3/* $VF was: ☃xx */ = this.g.j.s(0.0F);
                  boolean var4/* $VF was: ☃xxx */ = false;
                  if (this.g.l != null && this.g.l instanceof aii && var3/* $VF was: ☃xx */ >= 1.0F) {
                     var4/* $VF was: ☃xxx */ = this.g.j.dU() > 5.0F;
                     var4/* $VF was: ☃xxx */ &= this.g.l.aJ();
                  }

                  int var5/* $VF was: ☃xxxx */ = this.B / 2 - 7 + 16;
                  int var6/* $VF was: ☃xxxxx */ = this.A / 2 - 8;
                  if (var4/* $VF was: ☃xxx */) {
                     this.blit(var6/* $VF was: ☃xxxxx */, var5/* $VF was: ☃xxxx */, 68, 94, 16, 16);
                  } else if (var3/* $VF was: ☃xx */ < 1.0F) {
                     int var7/* $VF was: ☃xxxxxx */ = (int)(var3/* $VF was: ☃xx */ * 17.0F);
                     this.blit(var6/* $VF was: ☃xxxxx */, var5/* $VF was: ☃xxxx */, 36, 94, 16, 4);
                     this.blit(var6/* $VF was: ☃xxxxx */, var5/* $VF was: ☃xxxx */, 52, 94, var7/* $VF was: ☃xxxxxx */, 4);
                  }
               }
            }
         }
      }
   }

   private boolean a(cri var1) {
      if (var1/* $VF was: ☃ */ == null) {
         return false;
      } else if (var1 instanceof crh) {
         return ((crh)var1/* $VF was: ☃ */).a() instanceof agx;
      } else if (var1 instanceof crg) {
         ev var2/* $VF was: ☃ */ = ((crg)var1/* $VF was: ☃ */).a();
         bgx var3/* $VF was: ☃x */ = this.g.h;
         return var3/* $VF was: ☃x */.e_(var2/* $VF was: ☃ */).b(var3/* $VF was: ☃x */, var2/* $VF was: ☃ */) != null;
      } else {
         return false;
      }
   }

   protected void b() {
      Collection<aht> var1/* $VF was: ☃ */ = this.g.j.cv();
      if (!var1/* $VF was: ☃ */.isEmpty()) {
         GlStateManager.enableBlend();
         int var2/* $VF was: ☃x */ = 0;
         int var3/* $VF was: ☃xx */ = 0;
         duu var4/* $VF was: ☃xxx */ = this.g.ap();
         List<Runnable> var5/* $VF was: ☃xxxx */ = Lists.newArrayListWithExpectedSize(var1/* $VF was: ☃ */.size());
         this.g.G().a(dah.a);

         for (aht var7/* $VF was: ☃xxxxx */ : Ordering.natural().reverse().sortedCopy(var1/* $VF was: ☃ */)) {
            ahr var8/* $VF was: ☃xxxxxx */ = var7/* $VF was: ☃xxxxx */.a();
            if (var7/* $VF was: ☃xxxxx */.f()) {
               int var9/* $VF was: ☃xxxxxxx */ = this.A;
               int var10/* $VF was: ☃xxxxxxxx */ = 1;
               if (this.g.q()) {
                  var10/* $VF was: ☃xxxxxxxx */ += 15;
               }

               if (var8/* $VF was: ☃xxxxxx */.h()) {
                  var2/* $VF was: ☃x */++;
                  var9/* $VF was: ☃xxxxxxx */ -= 25 * var2/* $VF was: ☃x */;
               } else {
                  var3/* $VF was: ☃xx */++;
                  var9/* $VF was: ☃xxxxxxx */ -= 25 * var3/* $VF was: ☃xx */;
                  var10/* $VF was: ☃xxxxxxxx */ += 26;
               }

               GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
               float var11/* $VF was: ☃xxxxxxxxx */ = 1.0F;
               if (var7/* $VF was: ☃xxxxx */.d()) {
                  this.blit(var9/* $VF was: ☃xxxxxxx */, var10/* $VF was: ☃xxxxxxxx */, 165, 166, 24, 24);
               } else {
                  this.blit(var9/* $VF was: ☃xxxxxxx */, var10/* $VF was: ☃xxxxxxxx */, 141, 166, 24, 24);
                  if (var7/* $VF was: ☃xxxxx */.b() <= 200) {
                     int var12/* $VF was: ☃xxxxxxxxxx */ = 10 - var7/* $VF was: ☃xxxxx */.b() / 20;
                     var11/* $VF was: ☃xxxxxxxxx */ = zq.a(var7/* $VF was: ☃xxxxx */.b() / 10.0F / 5.0F * 0.5F, 0.0F, 0.5F)
                        + zq.b(var7/* $VF was: ☃xxxxx */.b() * (float) Math.PI / 5.0F) * zq.a(var12/* $VF was: ☃xxxxxxxxxx */ / 10.0F * 0.25F, 0.0F, 0.25F);
                  }
               }

               due var17/* $VF was: ☃xxxxxxxxxx */ = var4/* $VF was: ☃xxx */.a(var8/* $VF was: ☃xxxxxx */);
               int var13/* $VF was: ☃xxxxxxxxxxx */ = var9/* $VF was: ☃xxxxxxx */;
               int var14/* $VF was: ☃xxxxxxxxxxxx */ = var10/* $VF was: ☃xxxxxxxx */;
               float var15/* $VF was: ☃xxxxxxxxxxxxx */ = var11/* $VF was: ☃xxxxxxxxx */;
               var5/* $VF was: ☃xxxx */.add(() -> {
                  GlStateManager.color4f(1.0F, 1.0F, 1.0F, var15/* $VF was: ☃xxxxxxxxxxxxx */);
                  this.blit(var13/* $VF was: ☃xxxxxxxxxxx */ + 3, var14/* $VF was: ☃xxxxxxxxxxxx */ + 3, var17/* $VF was: ☃xxxxxxxxxx */, 18, 18);
               });
            }
         }

         this.g.G().a(dud.i);
         var5/* $VF was: ☃xxxx */.forEach(Runnable::run);
      }
   }

   protected void b(float var1) {
      avm var2/* $VF was: ☃ */ = this.o();
      if (var2/* $VF was: ☃ */ != null) {
         int var3/* $VF was: ☃x */ = this.A / 2;
         int var4/* $VF was: ☃xx */ = var3/* $VF was: ☃x */ - 128;
         int var5/* $VF was: ☃xxx */ = this.B - 64;
         GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.g.G().a(getHotbarTexture(this.g));
         float var6/* $VF was: ☃xxxx */ = this.blitOffset;
         this.blitOffset = -666.0F;
         this.blit(var4/* $VF was: ☃xx */, var5/* $VF was: ☃xxx */, 0, 64, 256, 64);
         GlStateManager.pushMatrix();
         GlStateManager.translatef(0.0F, 0.0F, -200.0F);
         int var7/* $VF was: ☃xxxxx */ = (int)(p.b() / 2000L % 4L);
         float[] var8/* $VF was: ☃xxxxxx */ = new float[]{-20.0F, 0.0F, 20.0F, 0.0F};
         if (this.g.W().c != null) {
            dbd.a(
               var4/* $VF was: ☃xx */ + 128,
               var5/* $VF was: ☃xxx */ + 135,
               64,
               var8/* $VF was: ☃xxxxxx */[var7/* $VF was: ☃xxxxx */],
               0.0F,
               var2/* $VF was: ☃ */
            );
         }

         GlStateManager.popMatrix();
         GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.g.G().a(getHotbarTexture(this.g));
         this.blitOffset = -90.0F;
         this.blit(var4/* $VF was: ☃xx */, var5/* $VF was: ☃xxx */, 0, 0, 256, 64);
         this.g.G().a(WIDGETS_TEXTURE);
         int var9/* $VF was: ☃xxxxxxx */ = var2/* $VF was: ☃ */.bx.d % 3;
         int var10/* $VF was: ☃xxxxxxxx */ = var2/* $VF was: ☃ */.bx.d / 3;
         this.blit(
            var4/* $VF was: ☃xx */ + 194 + var9/* $VF was: ☃xxxxxxx */ * 20 - 1,
            var5/* $VF was: ☃xxx */ + 2 + var10/* $VF was: ☃xxxxxxxx */ * 20 - 1,
            0,
            22,
            24,
            22
         );
         this.blitOffset = var6/* $VF was: ☃xxxx */;
         GlStateManager.enableRescaleNormal();
         GlStateManager.enableBlend();
         GlStateManager.blendFuncSeparate(
            GlStateManager.SourceFactor.SRC_ALPHA,
            GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
            GlStateManager.SourceFactor.ONE,
            GlStateManager.DestFactor.ZERO
         );
         cti.c();

         for (int var11/* $VF was: ☃xxxxxxxxx */ = 0; var11/* $VF was: ☃xxxxxxxxx */ < 9; var11/* $VF was: ☃xxxxxxxxx */++) {
            int var12/* $VF was: ☃xxxxxxxxxx */ = var4/* $VF was: ☃xx */ + 194 + var11/* $VF was: ☃xxxxxxxxx */ % 3 * 20 + 2;
            int var13/* $VF was: ☃xxxxxxxxxxx */ = var5/* $VF was: ☃xxx */ + 2 + var11/* $VF was: ☃xxxxxxxxx */ / 3 * 20 + 2;
            this.a(
               var12/* $VF was: ☃xxxxxxxxxx */,
               var13/* $VF was: ☃xxxxxxxxxxx */,
               var1/* $VF was: ☃ */,
               var2/* $VF was: ☃ */,
               var2/* $VF was: ☃ */.bx.a.get(var11/* $VF was: ☃xxxxxxxxx */)
            );
         }

         if (this.g.w.A == cul.c) {
            float var15/* $VF was: ☃xxxxxxxxx */ = this.g.j.s(0.0F);
            if (var15/* $VF was: ☃xxxxxxxxx */ < 1.0F) {
               int var16/* $VF was: ☃xxxxxxxxxx */ = var5/* $VF was: ☃xxx */ + 2 + var10/* $VF was: ☃xxxxxxxx */ * 20;
               int var17/* $VF was: ☃xxxxxxxxxxx */ = var4/* $VF was: ☃xx */ + 194 + var9/* $VF was: ☃xxxxxxx */ * 22;
               this.g.G().a(cvr.GUI_ICONS_LOCATION);
               int var14/* $VF was: ☃xxxxxxxxxxxx */ = (int)(var15/* $VF was: ☃xxxxxxxxx */ * 19.0F);
               GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
               this.blit(var17/* $VF was: ☃xxxxxxxxxxx */, var16/* $VF was: ☃xxxxxxxxxx */, 0, 94, 18, 18);
               this.blit(
                  var17/* $VF was: ☃xxxxxxxxxxx */,
                  var16/* $VF was: ☃xxxxxxxxxx */ + 18 - var14/* $VF was: ☃xxxxxxxxxxxx */,
                  18,
                  112 - var14/* $VF was: ☃xxxxxxxxxxxx */,
                  18,
                  var14/* $VF was: ☃xxxxxxxxxxxx */
               );
            }
         }

         cti.a();
         GlStateManager.disableRescaleNormal();
         GlStateManager.disableBlend();
      }
   }

   public void a(int var1) {
      this.g.aq().a("jumpBar");
      this.g.G().a(cvr.GUI_ICONS_LOCATION);
      float var2/* $VF was: ☃ */ = this.g.j.G();
      int var3/* $VF was: ☃x */ = 182;
      int var4/* $VF was: ☃xx */ = (int)(var2/* $VF was: ☃ */ * 183.0F);
      int var5/* $VF was: ☃xxx */ = 20;
      this.blit(var1/* $VF was: ☃ */, 20, 0, 84, 182, 5);
      if (var4/* $VF was: ☃xx */ > 0) {
         this.blit(var1/* $VF was: ☃ */, 20, 0, 89, var4/* $VF was: ☃xx */, 5);
      }

      this.g.aq().c();
   }

   public void c() {
      this.g.aq().a("selectedItemName");
      if (this.n > 0 && !this.o.a()) {
         jm var1/* $VF was: ☃ */ = new jv("").a(this.o.r()).a(this.o.v().e);
         if (this.o.t()) {
            var1/* $VF was: ☃ */.a(c.u);
         }

         String var2/* $VF was: ☃x */ = var1/* $VF was: ☃ */.e();
         int var3/* $VF was: ☃xx */ = (this.A - this.h().b(var2/* $VF was: ☃x */)) / 2;
         int var4/* $VF was: ☃xxx */ = this.B - 84;
         int var5/* $VF was: ☃xxxx */ = (int)(this.n * 256.0F / 10.0F);
         if (var5/* $VF was: ☃xxxx */ > 255) {
            var5/* $VF was: ☃xxxx */ = 255;
         }

         if (var5/* $VF was: ☃xxxx */ > 0) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.blendFuncSeparate(
               GlStateManager.SourceFactor.SRC_ALPHA,
               GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
               GlStateManager.SourceFactor.ONE,
               GlStateManager.DestFactor.ZERO
            );
            fill(
               var3/* $VF was: ☃xx */ - 2,
               var4/* $VF was: ☃xxx */ - 2,
               var3/* $VF was: ☃xx */ + this.h().b(var2/* $VF was: ☃x */) + 2,
               var4/* $VF was: ☃xxx */ + 9 + 2,
               this.g.w.a(0)
            );
            this.h().a(var2/* $VF was: ☃x */, var3/* $VF was: ☃xx */, var4/* $VF was: ☃xxx */, 16777215 + (var5/* $VF was: ☃xxxx */ << 24));
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
         }
      }

      this.g.aq().c();
   }

   public void d() {
      this.g.aq().a("demo");
      String var1/* $VF was: ☃ */;
      if (this.g.h.Q() >= 120500L) {
         var1/* $VF was: ☃ */ = dva.a("demo.demoExpired", new Object[0]);
      } else {
         var1/* $VF was: ☃ */ = dva.a("demo.remainingTime", zw.a((int)(120500L - this.g.h.Q())));
      }

      int var2/* $VF was: ☃x */ = this.h().b(var1/* $VF was: ☃ */);
      this.h().a(var1/* $VF was: ☃ */, this.A - var2/* $VF was: ☃x */ - 10, 5.0F, 16777215);
      this.g.aq().c();
   }

   private void a(csh var1) {
      csk var2/* $VF was: ☃ */ = var1/* $VF was: ☃ */.a();
      Collection<csj> var3/* $VF was: ☃x */ = var2/* $VF was: ☃ */.i(var1/* $VF was: ☃ */);
      List<csj> var4/* $VF was: ☃xx */ = var3/* $VF was: ☃x */.stream()
         .filter(var0 -> var0.e() != null && !var0.e().startsWith("#"))
         .collect(Collectors.toList());
      if (var4/* $VF was: ☃xx */.size() > 15) {
         var3/* $VF was: ☃x */ = Lists.newArrayList(Iterables.skip(var4/* $VF was: ☃xx */, var3/* $VF was: ☃x */.size() - 15));
      } else {
         var3/* $VF was: ☃x */ = var4/* $VF was: ☃xx */;
      }

      String var5/* $VF was: ☃xxx */ = var1/* $VF was: ☃ */.d().e();
      int var6/* $VF was: ☃xxxx */ = this.h().b(var5/* $VF was: ☃xxx */);
      int var7/* $VF was: ☃xxxxx */ = var6/* $VF was: ☃xxxx */;

      for (csj var9/* $VF was: ☃xxxxxx */ : var3/* $VF was: ☃x */) {
         csi var10/* $VF was: ☃xxxxxxx */ = var2/* $VF was: ☃ */.i(var9/* $VF was: ☃xxxxxx */.e());
         String var11/* $VF was: ☃xxxxxxxx */ = csi.a(var10/* $VF was: ☃xxxxxxx */, new jv(var9/* $VF was: ☃xxxxxx */.e())).e()
            + ": "
            + c.m
            + var9/* $VF was: ☃xxxxxx */.b();
         var7/* $VF was: ☃xxxxx */ = Math.max(var7/* $VF was: ☃xxxxx */, this.h().b(var11/* $VF was: ☃xxxxxxxx */));
      }

      int var24/* $VF was: ☃xxxxxx */ = var3/* $VF was: ☃x */.size() * 9;
      int var25/* $VF was: ☃xxxxxxx */ = this.B / 2 + var24/* $VF was: ☃xxxxxx */ / 3;
      int var26/* $VF was: ☃xxxxxxxx */ = 3;
      int var27/* $VF was: ☃xxxxxxxxx */ = this.A - var7/* $VF was: ☃xxxxx */ - 3;
      int var12/* $VF was: ☃xxxxxxxxxx */ = 0;
      int var13/* $VF was: ☃xxxxxxxxxxx */ = this.g.w.b(0.3F);
      int var14/* $VF was: ☃xxxxxxxxxxxx */ = this.g.w.b(0.4F);

      for (csj var16/* $VF was: ☃xxxxxxxxxxxxx */ : var3/* $VF was: ☃x */) {
         var12/* $VF was: ☃xxxxxxxxxx */++;
         csi var17/* $VF was: ☃xxxxxxxxxxxxxx */ = var2/* $VF was: ☃ */.i(var16/* $VF was: ☃xxxxxxxxxxxxx */.e());
         String var18/* $VF was: ☃xxxxxxxxxxxxxxx */ = csi.a(var17/* $VF was: ☃xxxxxxxxxxxxxx */, new jv(var16/* $VF was: ☃xxxxxxxxxxxxx */.e())).e();
         String var19/* $VF was: ☃xxxxxxxxxxxxxxxx */ = c.m + "" + var16/* $VF was: ☃xxxxxxxxxxxxx */.b();
         int var20/* $VF was: ☃xxxxxxxxxxxxxxxxx */ = var27/* $VF was: ☃xxxxxxxxx */;
         int var21/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ = var25/* $VF was: ☃xxxxxxx */ - var12/* $VF was: ☃xxxxxxxxxx */ * 9;
         int var22/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ = this.A - 3 + 2;
         fill(
            var20/* $VF was: ☃xxxxxxxxxxxxxxxxx */ - 2,
            var21/* $VF was: ☃xxxxxxxxxxxxxxxxxx */,
            var22/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */,
            var21/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ + 9,
            var13/* $VF was: ☃xxxxxxxxxxx */
         );
         this.h().b(var18/* $VF was: ☃xxxxxxxxxxxxxxx */, var20/* $VF was: ☃xxxxxxxxxxxxxxxxx */, var21/* $VF was: ☃xxxxxxxxxxxxxxxxxx */, 553648127);
         this.h()
            .b(
               var19/* $VF was: ☃xxxxxxxxxxxxxxxx */,
               var22/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ - this.h().b(var19/* $VF was: ☃xxxxxxxxxxxxxxxx */),
               var21/* $VF was: ☃xxxxxxxxxxxxxxxxxx */,
               553648127
            );
         if (var12/* $VF was: ☃xxxxxxxxxx */ == var3/* $VF was: ☃x */.size()) {
            fill(
               var20/* $VF was: ☃xxxxxxxxxxxxxxxxx */ - 2,
               var21/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ - 9 - 1,
               var22/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */,
               var21/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ - 1,
               var14/* $VF was: ☃xxxxxxxxxxxx */
            );
            fill(
               var20/* $VF was: ☃xxxxxxxxxxxxxxxxx */ - 2,
               var21/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ - 1,
               var22/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */,
               var21/* $VF was: ☃xxxxxxxxxxxxxxxxxx */,
               var13/* $VF was: ☃xxxxxxxxxxx */
            );
            this.h()
               .b(
                  var5/* $VF was: ☃xxx */,
                  var20/* $VF was: ☃xxxxxxxxxxxxxxxxx */ + var7/* $VF was: ☃xxxxx */ / 2 - var6/* $VF was: ☃xxxx */ / 2,
                  var21/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ - 9,
                  553648127
               );
         }
      }
   }

   private avm o() {
      return !(this.g.U() instanceof avm) ? null : (avm)this.g.U();
   }

   private void q() {
      avm var1/* $VF was: ☃ */ = this.o();
      if (var1/* $VF was: ☃ */ != null) {
         int var2/* $VF was: ☃x */ = zq.f(var1/* $VF was: ☃ */.cy());
         this.f.setSeed(this.j * 312871);
         axm var3/* $VF was: ☃xx */ = var1/* $VF was: ☃ */.dK();
         int var4/* $VF was: ☃xxx */ = var3/* $VF was: ☃xx */.a();
         int var5/* $VF was: ☃xxxx */ = this.A / 2;
         int var6/* $VF was: ☃xxxxx */ = var5/* $VF was: ☃xxxx */ - 91;
         int var7/* $VF was: ☃xxxxxx */ = var5/* $VF was: ☃xxxx */ + 91;
         int var8/* $VF was: ☃xxxxxxx */ = this.B - 74;
         int var9/* $VF was: ☃xxxxxxxx */ = zq.f(var1/* $VF was: ☃ */.db());
         this.g.aq().a("armor");
         int var10/* $VF was: ☃xxxxxxxxx */ = var1/* $VF was: ☃ */.cE();
         String var11/* $VF was: ☃xxxxxxxxxx */ = String.format("%02d%%", var10/* $VF was: ☃xxxxxxxxx */ * 100 / 20);
         int var12/* $VF was: ☃xxxxxxxxxxx */ = this.h().b(var11/* $VF was: ☃xxxxxxxxxx */);
         int var13/* $VF was: ☃xxxxxxxxxxxx */ = var5/* $VF was: ☃xxxx */ - 128;
         int var14/* $VF was: ☃xxxxxxxxxxxxx */ = this.B - 64;
         this.h()
            .b(
               var11/* $VF was: ☃xxxxxxxxxx */,
               var13/* $VF was: ☃xxxxxxxxxxxx */ + 25 + (23 - var12/* $VF was: ☃xxxxxxxxxxx */),
               var14/* $VF was: ☃xxxxxxxxxxxxx */ + 41,
               -1
            );
         this.g.aq().b("health");
         float var15/* $VF was: ☃xxxxxxxxxxxxxx */ = var1/* $VF was: ☃ */.cH();
         String var16/* $VF was: ☃xxxxxxxxxxxxxxx */ = String.format(
            "%02.0f%%", (var2/* $VF was: ☃x */ + var9/* $VF was: ☃xxxxxxxx */) / var15/* $VF was: ☃xxxxxxxxxxxxxx */ * 100.0F
         );
         int var17/* $VF was: ☃xxxxxxxxxxxxxxxx */ = this.h().b(var16/* $VF was: ☃xxxxxxxxxxxxxxx */);
         this.h()
            .b(
               var16/* $VF was: ☃xxxxxxxxxxxxxxx */,
               var13/* $VF was: ☃xxxxxxxxxxxx */ + 25 + (23 - var17/* $VF was: ☃xxxxxxxxxxxxxxxx */),
               var14/* $VF was: ☃xxxxxxxxxxxxx */ + 8,
               var9/* $VF was: ☃xxxxxxxx */ > 0 ? -256 : -65536
            );
         this.g.G().a(getHotbarTexture(this.g));
         int var18/* $VF was: ☃xxxxxxxxxxxxxxxxx */ = var8/* $VF was: ☃xxxxxxx */ - 10;
         this.g.aq().b("food");
         int var19/* $VF was: ☃xxxxxxxxxxxxxxxxxx */ = 32 * var4/* $VF was: ☃xxx */ / 20;
         this.blit(var13/* $VF was: ☃xxxxxxxxxxxx */ + 161, var14/* $VF was: ☃xxxxxxxxxxxxx */ + 14, 0, 128, 32, var19/* $VF was: ☃xxxxxxxxxxxxxxxxxx */);
         var18/* $VF was: ☃xxxxxxxxxxxxxxxxx */ -= 10;
         this.g.G().a(cvr.GUI_ICONS_LOCATION);
         this.g.aq().b("air");
         int var20/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ = var1/* $VF was: ☃ */.bl();
         int var21/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */ = var1/* $VF was: ☃ */.bk();
         if (var1/* $VF was: ☃ */.a(yw.a) || var20/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ < var21/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */) {
            int var22/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxx */ = 0;
            var18/* $VF was: ☃xxxxxxxxxxxxxxxxx */ += 0;
            int var23/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */ = zq.f(
               (var20/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ - 2) * 10.0 / var21/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */
            );
            int var24/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */ = zq.f(var20/* $VF was: ☃xxxxxxxxxxxxxxxxxxx */ * 10.0 / var21/* $VF was: ☃xxxxxxxxxxxxxxxxxxxx */)
               - var23/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */;

            for (int var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxx */ = 0;
               var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxx */ < var23/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */ + var24/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxx */;
               var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxx */++
            ) {
               if (var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxx */ < var23/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxx */) {
                  this.blit(
                     var7/* $VF was: ☃xxxxxx */ - var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxx */ * 8 - 9, var18/* $VF was: ☃xxxxxxxxxxxxxxxxx */, 16, 18, 9, 9
                  );
               } else {
                  this.blit(
                     var7/* $VF was: ☃xxxxxx */ - var25/* $VF was: ☃xxxxxxxxxxxxxxxxxxxxxxxx */ * 8 - 9, var18/* $VF was: ☃xxxxxxxxxxxxxxxxx */, 25, 18, 9, 9
                  );
               }
            }
         }

         this.g.aq().c();
      }
   }

   private void s() {
      GlStateManager.disableDepthTest();
      GlStateManager.depthMask(false);
      GlStateManager.blendFuncSeparate(
         GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO
      );
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.disableAlphaTest();
      this.g.G().a(e);
      cuc var1/* $VF was: ☃ */ = cuc.a();
      ctz var2/* $VF was: ☃x */ = var1/* $VF was: ☃ */.c();
      var2/* $VF was: ☃x */.a(7, cub.m);
      var2/* $VF was: ☃x */.b(0.0, this.B, -90.0).a(0.0, 1.0).d();
      var2/* $VF was: ☃x */.b(this.A, this.B, -90.0).a(1.0, 1.0).d();
      var2/* $VF was: ☃x */.b(this.A, 0.0, -90.0).a(1.0, 0.0).d();
      var2/* $VF was: ☃x */.b(0.0, 0.0, -90.0).a(0.0, 0.0).d();
      var1/* $VF was: ☃ */.b();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepthTest();
      GlStateManager.enableAlphaTest();
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void a(ahz var1) {
      if (var1/* $VF was: ☃ */ != null) {
         float var2/* $VF was: ☃ */ = zq.a(1.0F - var1/* $VF was: ☃ */.aD(), 0.0F, 1.0F);
         this.a = (float)(this.a + (var2/* $VF was: ☃ */ - this.a) * 0.01);
      }
   }

   private void b(ahz var1) {
      bwk var2/* $VF was: ☃ */ = this.g.h.q_();
      float var3/* $VF was: ☃x */ = (float)var2/* $VF was: ☃ */.a(var1/* $VF was: ☃ */);
      double var4/* $VF was: ☃xx */ = Math.min(
         var2/* $VF was: ☃ */.p() * var2/* $VF was: ☃ */.q() * 1000.0, Math.abs(var2/* $VF was: ☃ */.k() - var2/* $VF was: ☃ */.i())
      );
      double var6/* $VF was: ☃xxx */ = Math.max(var2/* $VF was: ☃ */.r(), var4/* $VF was: ☃xx */);
      if (var3/* $VF was: ☃x */ < var6/* $VF was: ☃xxx */) {
         var3/* $VF was: ☃x */ = 1.0F - (float)(var3/* $VF was: ☃x */ / var6/* $VF was: ☃xxx */);
      } else {
         var3/* $VF was: ☃x */ = 0.0F;
      }

      GlStateManager.disableDepthTest();
      GlStateManager.depthMask(false);
      GlStateManager.blendFuncSeparate(
         GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO
      );
      if (var3/* $VF was: ☃x */ > 0.0F) {
         GlStateManager.color4f(0.0F, var3/* $VF was: ☃x */, var3/* $VF was: ☃x */, 1.0F);
      } else {
         GlStateManager.color4f(this.a, this.a, this.a, 1.0F);
      }

      this.g.G().a(b);
      cuc var8/* $VF was: ☃xxxx */ = cuc.a();
      ctz var9/* $VF was: ☃xxxxx */ = var8/* $VF was: ☃xxxx */.c();
      var9/* $VF was: ☃xxxxx */.a(7, cub.m);
      var9/* $VF was: ☃xxxxx */.b(0.0, this.B, -90.0).a(0.0, 1.0).d();
      var9/* $VF was: ☃xxxxx */.b(this.A, this.B, -90.0).a(1.0, 1.0).d();
      var9/* $VF was: ☃xxxxx */.b(this.A, 0.0, -90.0).a(1.0, 0.0).d();
      var9/* $VF was: ☃xxxxx */.b(0.0, 0.0, -90.0).a(0.0, 0.0).d();
      var8/* $VF was: ☃xxxx */.b();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepthTest();
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.blendFuncSeparate(
         GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO
      );
   }

   private void c(float var1) {
      if (var1/* $VF was: ☃ */ < 1.0F) {
         var1/* $VF was: ☃ */ *= var1/* $VF was: ☃ */;
         var1/* $VF was: ☃ */ *= var1/* $VF was: ☃ */;
         var1/* $VF was: ☃ */ = var1/* $VF was: ☃ */ * 0.8F + 0.2F;
      }

      GlStateManager.disableAlphaTest();
      GlStateManager.disableDepthTest();
      GlStateManager.depthMask(false);
      GlStateManager.blendFuncSeparate(
         GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO
      );
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, var1/* $VF was: ☃ */);
      this.g.G().a(dud.f);
      due var2/* $VF was: ☃ */ = this.g.V().a().a(bmb.cM.o());
      float var3/* $VF was: ☃x */ = var2/* $VF was: ☃ */.i();
      float var4/* $VF was: ☃xx */ = var2/* $VF was: ☃ */.k();
      float var5/* $VF was: ☃xxx */ = var2/* $VF was: ☃ */.j();
      float var6/* $VF was: ☃xxxx */ = var2/* $VF was: ☃ */.l();
      cuc var7/* $VF was: ☃xxxxx */ = cuc.a();
      ctz var8/* $VF was: ☃xxxxxx */ = var7/* $VF was: ☃xxxxx */.c();
      var8/* $VF was: ☃xxxxxx */.a(7, cub.m);
      var8/* $VF was: ☃xxxxxx */.b(0.0, this.B, -90.0).a(var3/* $VF was: ☃x */, var6/* $VF was: ☃xxxx */).d();
      var8/* $VF was: ☃xxxxxx */.b(this.A, this.B, -90.0).a(var5/* $VF was: ☃xxx */, var6/* $VF was: ☃xxxx */).d();
      var8/* $VF was: ☃xxxxxx */.b(this.A, 0.0, -90.0).a(var5/* $VF was: ☃xxx */, var4/* $VF was: ☃xx */).d();
      var8/* $VF was: ☃xxxxxx */.b(0.0, 0.0, -90.0).a(var3/* $VF was: ☃x */, var4/* $VF was: ☃xx */).d();
      var7/* $VF was: ☃xxxxx */.b();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepthTest();
      GlStateManager.enableAlphaTest();
      GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void a(int var1, int var2, float var3, avm var4, bbp var5) {
      if (!var5/* $VF was: ☃ */.a()) {
         float var6/* $VF was: ☃ */ = var5/* $VF was: ☃ */.C() - var3/* $VF was: ☃ */;
         if (var6/* $VF was: ☃ */ > 0.0F) {
            GlStateManager.pushMatrix();
            float var7/* $VF was: ☃x */ = 1.0F + var6/* $VF was: ☃ */ / 5.0F;
            GlStateManager.translatef(var1/* $VF was: ☃ */ + 8, var2/* $VF was: ☃ */ + 12, 0.0F);
            GlStateManager.scalef(1.0F / var7/* $VF was: ☃x */, (var7/* $VF was: ☃x */ + 1.0F) / 2.0F, 1.0F);
            GlStateManager.translatef(-(var1/* $VF was: ☃ */ + 8), -(var2/* $VF was: ☃ */ + 12), 0.0F);
         }

         this.h.a(var4/* $VF was: ☃ */, var5/* $VF was: ☃ */, var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
         if (var6/* $VF was: ☃ */ > 0.0F) {
            GlStateManager.popMatrix();
         }

         this.h.a(this.g.n, var5/* $VF was: ☃ */, var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
      }
   }

   public void e() {
      if (this.l > 0) {
         this.l--;
      }

      if (this.u > 0) {
         this.u--;
         if (this.u <= 0) {
            this.v = "";
            this.w = "";
         }
      }

      this.j++;
      ahz var1/* $VF was: ☃ */ = this.g.U();
      if (var1/* $VF was: ☃ */ != null) {
         this.a(var1/* $VF was: ☃ */);
      }

      if (this.g.j != null) {
         bbp var2/* $VF was: ☃x */ = this.g.j.bx.f();
         if (var2/* $VF was: ☃x */.a()) {
            this.n = 0;
         } else if (this.o.a() || var2/* $VF was: ☃x */.b() != this.o.b() || !var2/* $VF was: ☃x */.r().equals(this.o.r())) {
            this.n = 40;
         } else if (this.n > 0) {
            this.n--;
         }

         this.o = var2/* $VF was: ☃x */;
      }
   }

   public void a(String var1) {
      this.a(dva.a("record.nowPlaying", var1/* $VF was: ☃ */), true);
   }

   public void a(String var1, boolean var2) {
      this.k = var1/* $VF was: ☃ */;
      this.l = 60;
      this.m = var2/* $VF was: ☃ */;
   }

   public void a(String var1, String var2, int var3, int var4, int var5) {
      if (var1/* $VF was: ☃ */ == null && var2/* $VF was: ☃ */ == null && var3/* $VF was: ☃ */ < 0 && var4/* $VF was: ☃ */ < 0 && var5/* $VF was: ☃ */ < 0) {
         this.v = "";
         this.w = "";
         this.u = 0;
      } else if (var1/* $VF was: ☃ */ != null) {
         this.v = var1/* $VF was: ☃ */;
         this.u = this.x + this.y + this.z;
      } else if (var2/* $VF was: ☃ */ != null) {
         this.w = var2/* $VF was: ☃ */;
      } else {
         if (var3/* $VF was: ☃ */ >= 0) {
            this.x = var3/* $VF was: ☃ */;
         }

         if (var4/* $VF was: ☃ */ >= 0) {
            this.y = var4/* $VF was: ☃ */;
         }

         if (var5/* $VF was: ☃ */ >= 0) {
            this.z = var5/* $VF was: ☃ */;
         }

         if (this.u > 0) {
            this.u = this.x + this.y + this.z;
         }
      }
   }

   public void a(jm var1, boolean var2) {
      this.a(var1/* $VF was: ☃ */.getString(), var2/* $VF was: ☃ */);
   }

   public void a(jk var1, jm var2) {
      for (cvt var4/* $VF was: ☃ */ : this.C.get(var1/* $VF was: ☃ */)) {
         var4/* $VF was: ☃ */.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
      }
   }

   public cwd f() {
      return this.i;
   }

   public int g() {
      return this.j;
   }

   public cvp h() {
      return this.g.n;
   }

   public cxa i() {
      return this.r;
   }

   public cwo j() {
      return this.s;
   }

   public void k() {
      this.s.a();
      this.t.b();
      this.g.ai().b();
   }

   public cwb l() {
      return this.t;
   }

   public void m() {
      this.overlay.a();
   }
}
