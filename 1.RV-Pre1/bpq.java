import java.util.List;

public class bpq extends bpk<aqn> {
   private static final kk a = new kk("textures/entity/sign.png");
   private static final kk d = new kk("textures/entity/sign2.png");
   private final bjl e = new bjl();

   public void a(aqn var1, double var2, double var4, double var6, float var8, int var9) {
      ajt var10/* $VF was: ☃ */ = var1/* $VF was: ☃ */.w();
      bnf.G();
      float var11/* $VF was: ☃x */ = 0.6666667F;
      if (var10/* $VF was: ☃ */ == aju.an) {
         bnf.c((float)var2/* $VF was: ☃ */ + 0.5F, (float)var4/* $VF was: ☃ */ + 0.75F * var11/* $VF was: ☃x */, (float)var6/* $VF was: ☃ */ + 0.5F);
         float var12/* $VF was: ☃xx */ = var1/* $VF was: ☃ */.u() * 360 / 16.0F;
         bnf.b(-var12/* $VF was: ☃xx */, 0.0F, 1.0F, 0.0F);
         this.e.b.j = true;
      } else {
         int var19/* $VF was: ☃xx */ = var1/* $VF was: ☃ */.u();
         float var13/* $VF was: ☃xxx */ = 0.0F;
         if (var19/* $VF was: ☃xx */ == 2) {
            var13/* $VF was: ☃xxx */ = 180.0F;
         }

         if (var19/* $VF was: ☃xx */ == 4) {
            var13/* $VF was: ☃xxx */ = 90.0F;
         }

         if (var19/* $VF was: ☃xx */ == 5) {
            var13/* $VF was: ☃xxx */ = -90.0F;
         }

         bnf.c((float)var2/* $VF was: ☃ */ + 0.5F, (float)var4/* $VF was: ☃ */ + 0.75F * var11/* $VF was: ☃x */, (float)var6/* $VF was: ☃ */ + 0.5F);
         bnf.b(-var13/* $VF was: ☃xxx */, 0.0F, 1.0F, 0.0F);
         bnf.c(0.0F, -0.3125F, -0.4375F);
         this.e.b.j = false;
      }

      int var20/* $VF was: ☃xx */ = 3390259;
      if (var9/* $VF was: ☃ */ >= 0) {
         this.a(b[var9/* $VF was: ☃ */]);
         bnf.n(5890);
         bnf.G();
         bnf.b(4.0F, 2.0F, 1.0F);
         bnf.c(0.0625F, 0.0625F, 0.0625F);
         bnf.n(5888);
      } else {
         this.a(a);
         rr var21/* $VF was: ☃xxx */ = bcc.z().aa();
         if (var21/* $VF was: ☃xxx */ instanceof sa && ((sa)var21/* $VF was: ☃xxx */).a(rw.f) != null && ((sa)var21/* $VF was: ☃xxx */).a(rw.f).b() == ads.cX) {
            if (var1/* $VF was: ☃ */.f < 0) {
               String languageCode = bcc.z().Q().c().a();
               kk signTexture = d;
               kk localizedTexture = new kk(
                  "textures/entity/sign2_"
                  + languageCode.toLowerCase(java.util.Locale.ROOT)
                  + ".png"
               );

               if (this.c.e.d(localizedTexture)) {
                  signTexture = localizedTexture;
               }

               this.a(signTexture);
            }

            var20/* $VF was: ☃xx */ = 1144593;
         }
      }

      bnf.D();
      bnf.G();
      bnf.b(var11/* $VF was: ☃x */, -var11/* $VF was: ☃x */, -var11/* $VF was: ☃x */);
      this.e.a();
      bnf.H();
      bcq var22/* $VF was: ☃xxx */ = this.b();
      float var14/* $VF was: ☃xxxx */ = 0.015625F * var11/* $VF was: ☃x */;
      bnf.c(0.0F, 0.5F * var11/* $VF was: ☃x */, 0.07F * var11/* $VF was: ☃x */);
      bnf.b(var14/* $VF was: ☃xxxx */, -var14/* $VF was: ☃xxxx */, var14/* $VF was: ☃xxxx */);
      bnf.a(0.0F, 0.0F, -1.0F * var14/* $VF was: ☃xxxx */);
      bnf.a(false);
      if (var9/* $VF was: ☃ */ < 0) {
         for (int var15/* $VF was: ☃xxxxx */ = 0; var15/* $VF was: ☃xxxxx */ < var1/* $VF was: ☃ */.a.length; var15/* $VF was: ☃xxxxx */++) {
            if (var1/* $VF was: ☃ */.a[var15/* $VF was: ☃xxxxx */] != null) {
               eu var16/* $VF was: ☃xxxxxx */ = var1/* $VF was: ☃ */.a[var15/* $VF was: ☃xxxxx */];
               List<eu> var17/* $VF was: ☃xxxxxxx */ = bcy.a(var16/* $VF was: ☃xxxxxx */, 90, var22/* $VF was: ☃xxx */, false, true);
               String var18/* $VF was: ☃xxxxxxxx */ = var17/* $VF was: ☃xxxxxxx */ != null && !var17/* $VF was: ☃xxxxxxx */.isEmpty()
                  ? var17/* $VF was: ☃xxxxxxx */.get(0).d()
                  : "";
               if (var15/* $VF was: ☃xxxxx */ == var1/* $VF was: ☃ */.f) {
                  var18/* $VF was: ☃xxxxxxxx */ = "> " + var18/* $VF was: ☃xxxxxxxx */ + " <";
                  bnf.g();
                  var22/* $VF was: ☃xxx */.a(
                     var18/* $VF was: ☃xxxxxxxx */,
                     -var22/* $VF was: ☃xxx */.a(var18/* $VF was: ☃xxxxxxxx */) / 2,
                     var15/* $VF was: ☃xxxxx */ * 10 - var1/* $VF was: ☃ */.a.length * 5,
                     var20/* $VF was: ☃xx */
                  );
                  bnf.f();
               } else {
                  bnf.g();
                  var22/* $VF was: ☃xxx */.a(
                     var18/* $VF was: ☃xxxxxxxx */,
                     -var22/* $VF was: ☃xxx */.a(var18/* $VF was: ☃xxxxxxxx */) / 2,
                     var15/* $VF was: ☃xxxxx */ * 10 - var1/* $VF was: ☃ */.a.length * 5,
                     var20/* $VF was: ☃xx */
                  );
                  bnf.f();
               }
            }
         }
      }

      bnf.a(true);
      bnf.c(1.0F, 1.0F, 1.0F, 1.0F);
      bnf.H();
      if (var9/* $VF was: ☃ */ >= 0) {
         bnf.n(5890);
         bnf.H();
         bnf.n(5888);
      }
   }
}
