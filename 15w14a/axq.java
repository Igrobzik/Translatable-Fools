import java.io.IOException;
import java.util.Random;

public class axq extends axy {
   private static final ka a = new ka("textures/gui/minescreeper.png");
   private static final a[] f = new a[]{null, a.j, a.c, a.m, a.n, a.g, a.l, a.p, a.h};
   private static final ka g = new ka("random.levelup");
   private static final ka h = new ka("creeper.primed");
   private static final ka i = new ka("dig.grass");
   private static final ka r = new ka("dig.wood");
   private axq.a[][] s;
   private boolean t;
   private boolean u;
   private boolean v = false;
   private String w = "";
   private int x = 20;
   private int y = 8;
   private int z = 16;
   private int A = 16;
   private int B = 1;
   private int C = 1;
   private int D;
   private int E;

   public void b() {
      int var1/* $VF was: ☃ */ = this.m - 100;
      int var2/* $VF was: ☃x */ = this.l / (this.z + this.B);
      int var3/* $VF was: ☃xx */ = var1/* $VF was: ☃ */ / (this.A + this.C);
      if (this.x != var2/* $VF was: ☃x */ || this.y != var3/* $VF was: ☃xx */) {
         this.x = var2/* $VF was: ☃x */;
         this.y = var3/* $VF was: ☃xx */;
         this.a();
      }

      this.E = 80 + (this.m - 80) / 2 - (this.A + this.C) * this.y / 2;
      this.D = this.l / 2 - (this.z + this.B) * this.x / 2;
   }

   private void a() {
      this.t = false;
      this.u = true;
      this.s = new axq.a[this.y][this.x];

      for (int var1/* $VF was: ☃ */ = 0; var1/* $VF was: ☃ */ < this.x; var1/* $VF was: ☃ */++) {
         for (int var2/* $VF was: ☃x */ = 0; var2/* $VF was: ☃x */ < this.y; var2/* $VF was: ☃x */++) {
            this.s[var2/* $VF was: ☃x */][var1/* $VF was: ☃ */] = new axq.a(this.s, var1/* $VF was: ☃ */, var2/* $VF was: ☃x */);
         }
      }
   }

   @Override
   protected void a(char var1, int var2) {
      if (!this.v) {
         if (var1/* $VF was: ☃ */ == 'x' || var1/* $VF was: ☃ */ == 'y' || var1/* $VF was: ☃ */ == 'z') {
            this.w = this.w + var1/* $VF was: ☃ */;
            if (this.w.length() > 5) {
               this.w = this.w.substring(this.w.length() - 5);
            }
         } else if (var2/* $VF was: ☃ */ == 28) {
            if (this.w.equals("xyzzy") && r()) {
               this.w = this.w.toUpperCase();
            } else if (this.w.equals("XYZZY") && !r()) {
               this.v = true;
               this.j.W().a(bpj.a(g, 1.0F));
            } else {
               this.w = "";
            }
         } else if (var2/* $VF was: ☃ */ != 42 && var2/* $VF was: ☃ */ != 54) {
            this.w = "";
         }
      }
   }

   private ka c() {
      String var1 = this.j.S().c().a();
      ka var2 = new ka("textures/gui/minescreeper_" + var1 + ".png");

      try {
         bnl var3 = this.j.P().c().a(var2);
         var3.b().close();
         return var2;
      } catch (IOException var4) {
         return a;
      }
   }

   protected void a(int var1, int var2, int var3) {
      int var4/* $VF was: ☃ */ = (var1/* $VF was: ☃ */ - this.D) / (this.z + this.B);
      int var5/* $VF was: ☃x */ = (var2/* $VF was: ☃ */ - this.E) / (this.A + this.C);
      if (var4/* $VF was: ☃ */ >= 0 && var5/* $VF was: ☃x */ >= 0 && var4/* $VF was: ☃ */ < this.x && var5/* $VF was: ☃x */ < this.y) {
         if (this.t) {
            this.a();
            return;
         }

         axq.a var6/* $VF was: ☃xx */ = this.s[var5/* $VF was: ☃x */][var4/* $VF was: ☃ */];
         boolean var7/* $VF was: ☃xxx */ = false;
         if (var3/* $VF was: ☃ */ == 0) {
            if (this.u) {
               this.b(var4/* $VF was: ☃ */, var5/* $VF was: ☃x */);
               var7/* $VF was: ☃xxx */ = true;
               this.j.W().a(bpj.a(i, 1.0F));
               this.f();
            } else if (var6/* $VF was: ☃xx */.c()) {
               this.t = true;
               var7/* $VF was: ☃xxx */ = true;
               this.j.W().a(bpj.a(h, 1.0F));
            } else if (!var6/* $VF was: ☃xx */.e()) {
               var6/* $VF was: ☃xx */.d();
               var7/* $VF was: ☃xxx */ = true;
               this.j.W().a(bpj.a(i, 1.0F));
               this.f();
            }
         } else if (var3/* $VF was: ☃ */ == 1 && !var6/* $VF was: ☃xx */.e()) {
            var6/* $VF was: ☃xx */.f();
            var7/* $VF was: ☃xxx */ = true;
            this.j.W().a(bpj.a(r, 1.0F));
         }

         if (this.u && var7/* $VF was: ☃xxx */) {
            this.u = false;
         }
      }
   }

   private void f() {
      for (int var1/* $VF was: ☃ */ = 0; var1/* $VF was: ☃ */ < this.x; var1/* $VF was: ☃ */++) {
         for (int var2/* $VF was: ☃x */ = 0; var2/* $VF was: ☃x */ < this.y; var2/* $VF was: ☃x */++) {
            axq.a var3/* $VF was: ☃xx */ = this.s[var2/* $VF was: ☃x */][var1/* $VF was: ☃ */];
            if (!var3/* $VF was: ☃xx */.c() && !var3/* $VF was: ☃xx */.e()) {
               return;
            }
         }
      }

      this.j.a(new ayg());
   }

   private void b(int var1, int var2) {
      do {
         Random var3/* $VF was: ☃ */ = new Random();
         int var4/* $VF was: ☃x */ = (int)(Math.sqrt(this.x * this.y) * 4.0);

         for (int var5/* $VF was: ☃xx */ = 0; var5/* $VF was: ☃xx */ < this.x; var5/* $VF was: ☃xx */++) {
            for (int var6/* $VF was: ☃xxx */ = 0; var6/* $VF was: ☃xxx */ < this.y; var6/* $VF was: ☃xxx */++) {
               this.s[var6/* $VF was: ☃xxx */][var5/* $VF was: ☃xx */] = new axq.a(this.s, var5/* $VF was: ☃xx */, var6/* $VF was: ☃xxx */);
            }
         }

         for (int var8/* $VF was: ☃xx */ = 0; var8/* $VF was: ☃xx */ < var4/* $VF was: ☃x */; var8/* $VF was: ☃xx */++) {
            int var9/* $VF was: ☃xxx */ = var3/* $VF was: ☃ */.nextInt(this.x);
            int var7/* $VF was: ☃xxxx */ = var3/* $VF was: ☃ */.nextInt(this.y);
            if (this.s[var7/* $VF was: ☃xxxx */][var9/* $VF was: ☃xxx */].c()) {
               var8/* $VF was: ☃xx */--;
            } else {
               this.s[var7/* $VF was: ☃xxxx */][var9/* $VF was: ☃xxx */].a(true);
            }
         }

         this.s[var2/* $VF was: ☃ */][var1/* $VF was: ☃xxx */].a(false);
      } while (!this.s[var2/* $VF was: ☃ */][var1/* $VF was: ☃xxx */].i());

      this.s[var2/* $VF was: ☃ */][var1/* $VF was: ☃xxx */].d();
   }

   @Override
   public void a(int var1, int var2, float var3) {
      ka var18 = this.c();
      bfp.w();
      bfp.f();

      for (int var4/* $VF was: ☃ */ = 0; var4/* $VF was: ☃ */ < this.x; var4/* $VF was: ☃ */++) {
         for (int var5/* $VF was: ☃x */ = 0; var5/* $VF was: ☃x */ < this.y; var5/* $VF was: ☃x */++) {
            int var6/* $VF was: ☃xx */ = 0;
            int var7/* $VF was: ☃xxx */ = 0;
            axq.a var8/* $VF was: ☃xxxx */ = this.s[var5/* $VF was: ☃x */][var4/* $VF was: ☃ */];
            String var9/* $VF was: ☃xxxxx */ = null;
            if (var8/* $VF was: ☃xxxx */.c() && this.t) {
               if (var8/* $VF was: ☃xxxx */.g()) {
                  var6/* $VF was: ☃xx */ = 64;
               } else {
                  var6/* $VF was: ☃xx */ = 48;
               }
            } else if (var8/* $VF was: ☃xxxx */.g()) {
               var6/* $VF was: ☃xx */ = 32;
            } else if (var8/* $VF was: ☃xxxx */.e()) {
               var6/* $VF was: ☃xx */ = var8/* $VF was: ☃xxxx */.h() * 16;
               var7/* $VF was: ☃xxx */ = 16;
               int var10/* $VF was: ☃xxxxxx */ = var8/* $VF was: ☃xxxx */.h();
               if (var10/* $VF was: ☃xxxxxx */ >= 0 && var10/* $VF was: ☃xxxxxx */ < f.length && f[var10/* $VF was: ☃xxxxxx */] != null) {
                  var9/* $VF was: ☃xxxxx */ = f[var10/* $VF was: ☃xxxxxx */].toString() + var10/* $VF was: ☃xxxxxx */;
               }
            } else {
               var6/* $VF was: ☃xx */ = 0;
            }

            this.j.P().a(var18);
            int var19/* $VF was: ☃xxxxxx */ = this.D + var4/* $VF was: ☃ */ * (this.z + this.B);
            int var11/* $VF was: ☃xxxxxxx */ = this.E + var5/* $VF was: ☃x */ * (this.A + this.C);
            bfp.c(1.0F, 1.0F, 1.0F);
            a(
               var19/* $VF was: ☃xxxxxx */,
               var11/* $VF was: ☃xxxxxxx */,
               var6/* $VF was: ☃xx */,
               var7/* $VF was: ☃xxx */,
               16,
               16,
               this.z,
               this.A,
               256.0F,
               256.0F
            );

            if (var9/* $VF was: ☃xxxxx */ != null) {
               int var12/* $VF was: ☃xxxxxxxx */ = this.j.k.a(var9/* $VF was: ☃xxxxx */) / 2;
               int var13/* $VF was: ☃xxxxxxxxx */ = this.j.k.a / 2;
               int var14/* $VF was: ☃xxxxxxxxxx */ = var19/* $VF was: ☃xxxxxx */ + this.z / 2;
               int var15/* $VF was: ☃xxxxxxxxxxx */ = var11/* $VF was: ☃xxxxxxx */ + this.A / 2;
               a(
                  var14/* $VF was: ☃xxxxxxxxxx */ - var12/* $VF was: ☃xxxxxxxx */,
                  var15/* $VF was: ☃xxxxxxxxxxx */ - var13/* $VF was: ☃xxxxxxxxx */ - 2,
                  var14/* $VF was: ☃xxxxxxxxxx */ + var12/* $VF was: ☃xxxxxxxx */,
                  var15/* $VF was: ☃xxxxxxxxxxx */ + var13/* $VF was: ☃xxxxxxxxx */ + 1,
                  -1442840576
               );
               this.j.k.a(
                  var9/* $VF was: ☃xxxxx */,
                  var14/* $VF was: ☃xxxxxxxxxx */ - var12/* $VF was: ☃xxxxxxxx */,
                  var15/* $VF was: ☃xxxxxxxxxxx */ - var13/* $VF was: ☃xxxxxxxxx */,
                  16777215
               );
            }
         }
      }

      int var16/* $VF was: ☃ */ = (var1/* $VF was: ☃ */ - this.D) / (this.z + this.B);
      int var17/* $VF was: ☃x */ = (var2/* $VF was: ☃x */ - this.E) / (this.A + this.C);
      if (var16/* $VF was: ☃ */ >= 0 && var17/* $VF was: ☃x */ >= 0 && var16/* $VF was: ☃ */ < this.x && var17/* $VF was: ☃x */ < this.y && this.v) {
         if (this.s[var17/* $VF was: ☃x */][var16/* $VF was: ☃ */].c()) {
            a(0, 0, 1, 1, -16777216);
         } else {
            a(0, 0, 1, 1, -1);
         }
      }

      this.j.P().a(a);
      bfp.c(1.0F, 1.0F, 1.0F);
      bfp.d();
      bfp.l();
      this.b(this.l / 2 - 137, 0, 0, 32, 155, 73);
      this.b(this.l / 2 + 18, 0, 0, 105, 144, 76);
   }

   public static class a {
      private final axq.a[][] a;
      private final int b;
      private final int c;
      private boolean d;
      private boolean e;
      private boolean f;
      private int g;

      public a(axq.a[][] var1, int var2, int var3) {
         this.a = var1/* $VF was: ☃ */;
         this.b = var2/* $VF was: ☃ */;
         this.c = var3/* $VF was: ☃x */;
      }

      public void a(boolean var1) {
         if (this.d != var1/* $VF was: ☃ */) {
            this.d = var1/* $VF was: ☃ */;

            for (int var2/* $VF was: ☃ */ = this.b - 1; var2/* $VF was: ☃ */ <= this.b + 1; var2/* $VF was: ☃ */++) {
               for (int var3/* $VF was: ☃x */ = this.c - 1; var3/* $VF was: ☃x */ <= this.c + 1; var3/* $VF was: ☃x */++) {
                  if ((var2/* $VF was: ☃ */ != this.b || var3/* $VF was: ☃x */ != this.c)
                     && var3/* $VF was: ☃x */ >= 0
                     && var3/* $VF was: ☃x */ < this.a.length
                     && var2/* $VF was: ☃ */ >= 0
                     && var2/* $VF was: ☃ */ < this.a[0].length) {
                     if (var1/* $VF was: ☃ */) {
                        this.a[var3/* $VF was: ☃x */][var2/* $VF was: ☃ */].a(1);
                     } else {
                        this.a[var3/* $VF was: ☃x */][var2/* $VF was: ☃ */].a(-1);
                     }
                  }
               }
            }
         }
      }

      public boolean c() {
         return this.d;
      }

      public void d() {
         this.e = true;
         if (this.h() == 0 && !this.c()) {
            for (int var1/* $VF was: ☃ */ = this.b - 1; var1/* $VF was: ☃ */ <= this.b + 1; var1/* $VF was: ☃ */++) {
               for (int var2/* $VF was: ☃x */ = this.c - 1; var2/* $VF was: ☃x */ <= this.c + 1; var2/* $VF was: ☃x */++) {
                  if ((var1/* $VF was: ☃ */ != this.b || var2/* $VF was: ☃x */ != this.c)
                     && var2/* $VF was: ☃x */ >= 0
                     && var2/* $VF was: ☃x */ < this.a.length
                     && var1/* $VF was: ☃ */ >= 0
                     && var1/* $VF was: ☃ */ < this.a[0].length) {
                     axq.a var3/* $VF was: ☃xx */ = this.a[var2/* $VF was: ☃x */][var1/* $VF was: ☃ */];
                     if (!var3/* $VF was: ☃xx */.e()) {
                        var3/* $VF was: ☃xx */.d();
                     }
                  }
               }
            }
         }
      }

      public boolean e() {
         return this.e;
      }

      public void f() {
         this.f = !this.f;
      }

      public boolean g() {
         return this.f;
      }

      public void a(int var1) {
         this.g += var1/* $VF was: ☃ */;
      }

      public int h() {
         return this.g;
      }

      public boolean i() {
         return !this.c() && this.h() == 0;
      }
   }
}