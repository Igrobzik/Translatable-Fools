import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;

public class axe extends axy {
   private axy f;
   private avz worldNameField;
   private avz h;
   private String i;
   private String r = "survival";
   private String s;
   private boolean t = true;
   private boolean u;
   private boolean v;
   private boolean w;
   private boolean x;
   private boolean y;
   private boolean z;
   private avv A;
   private avv B;
   private avv C;
   private avv D;
   private avv E;
   private avv F;
   private avv G;
   private String H;
   private String I;
   private String J;
   private String K;
   private int L;
   public String a = "";
   private static final String[] M = new String[]{
      "CON",
      "COM",
      "PRN",
      "AUX",
      "CLOCK$",
      "NUL",
      "COM1",
      "COM2",
      "COM3",
      "COM4",
      "COM5",
      "COM6",
      "COM7",
      "COM8",
      "COM9",
      "LPT1",
      "LPT2",
      "LPT3",
      "LPT4",
      "LPT5",
      "LPT6",
      "LPT7",
      "LPT8",
      "LPT9"
   };

   public axe(axy var1) {
      this.f = var1/* $VF was: ☃ */;
      this.J = "";
      this.K = bnu.a("selectWorld.newWorld");
   }

   @Override
   public void e() {
      this.worldNameField.a();
      this.h.a();
   }

   @Override
   public void b() {
      Keyboard.enableRepeatEvents(true);
      this.n.clear();
      this.n.add(new avv(0, this.l / 2 - 155, this.m - 28, 150, 20, bnu.a("selectWorld.create")));
      this.n.add(new avv(1, this.l / 2 + 5, this.m - 28, 150, 20, bnu.a("gui.cancel")));
      this.n.add(this.A = new avv(2, this.l / 2 - 75, 115, 150, 20, bnu.a("selectWorld.gameMode")));
      this.n.add(this.B = new avv(3, this.l / 2 - 75, 187, 150, 20, bnu.a("selectWorld.moreWorldOptions")));
      this.n.add(this.C = new avv(4, this.l / 2 - 155, 100, 150, 20, bnu.a("selectWorld.mapFeatures")));
      this.C.m = false;
      this.n.add(this.D = new avv(7, this.l / 2 + 5, 151, 150, 20, bnu.a("selectWorld.bonusItems")));
      this.D.m = false;
      this.n.add(this.E = new avv(5, this.l / 2 + 5, 100, 150, 20, bnu.a("selectWorld.mapType")));
      this.E.m = false;
      this.n.add(this.F = new avv(6, this.l / 2 - 155, 151, 150, 20, bnu.a("selectWorld.allowCommands")));
      this.F.m = false;
      this.n.add(this.G = new avv(8, this.l / 2 + 5, 120, 150, 20, bnu.a("selectWorld.customizeType")));
      this.G.m = false;
      this.worldNameField = new avz(9, this.q, this.l / 2 - 100, 60, 200, 20);
      this.worldNameField.a(bnu.a("createWorld.aprilWorldName"));
      this.worldNameField.c(false);
      this.worldNameField.h(-1580390);
      this.h = new avz(10, this.q, this.l / 2 - 100, 60, 200, 20);
      this.h.a(this.J);
      this.a(this.z);
      this.a();
      this.f();
   }

   private void a() {
      this.i = this.worldNameField.b().trim();

      for (char var4 : g.b) {
         this.i = this.i.replace(var4, '_');
      }

      if (StringUtils.isEmpty(this.i)) {
         this.i = "World";
      }

      this.i = a(this.j.f(), this.i);
   }

   private void f() {
      this.A.j = bnu.a("selectWorld.gameMode") + ": " + bnu.a("selectWorld.gameMode." + this.r);
      this.H = bnu.a("selectWorld.gameMode." + this.r + ".line1");
      this.I = bnu.a("selectWorld.gameMode." + this.r + ".line2");
      this.C.j = bnu.a("selectWorld.mapFeatures") + " ";
      if (this.t) {
         this.C.j = this.C.j + bnu.a("options.on");
      } else {
         this.C.j = this.C.j + bnu.a("options.off");
      }

      this.D.j = bnu.a("selectWorld.bonusItems") + " ";
      if (this.w && !this.x) {
         this.D.j = this.D.j + bnu.a("options.on");
      } else {
         this.D.j = this.D.j + bnu.a("options.off");
      }

      this.E.j = bnu.a("selectWorld.mapType") + " " + bnu.a(adu.a[this.L].b());
      this.F.j = bnu.a("selectWorld.allowCommands") + " ";
      if (this.u && !this.x) {
         this.F.j = this.F.j + bnu.a("options.on");
      } else {
         this.F.j = this.F.j + bnu.a("options.off");
      }
   }

   public static String a(atu var0, String var1) {
      var1/* $VF was: ☃ */ = var1/* $VF was: ☃ */.replaceAll("[\\./\"]", "_");

      for (String var5/* $VF was: ☃ */ : M) {
         if (var1/* $VF was: ☃ */.equalsIgnoreCase(var5/* $VF was: ☃ */)) {
            var1/* $VF was: ☃ */ = "_" + var1/* $VF was: ☃ */ + "_";
         }
      }

      while (var0/* $VF was: ☃ */.c(var1/* $VF was: ☃ */) != null) {
         var1/* $VF was: ☃ */ = var1/* $VF was: ☃ */ + "-";
      }

      return var1/* $VF was: ☃ */;
   }

   @Override
   public void m() {
      Keyboard.enableRepeatEvents(false);
   }

   @Override
   protected void a(avv var1) {
      if (var1/* $VF was: ☃ */.l) {
         if (var1/* $VF was: ☃ */.k == 1) {
            this.j.a(this.f);
         } else if (var1/* $VF was: ☃ */.k == 0) {
            this.j.a((axy)null);
            if (this.y) {
               return;
            }

            this.y = true;
            long var2/* $VF was: ☃ */ = new Random().nextLong();
            String var4/* $VF was: ☃x */ = this.h.b();
            if (!StringUtils.isEmpty(var4/* $VF was: ☃x */)) {
               try {
                  long var5/* $VF was: ☃xx */ = Long.parseLong(var4/* $VF was: ☃x */);
                  if (var5/* $VF was: ☃xx */ != 0L) {
                     var2/* $VF was: ☃ */ = var5/* $VF was: ☃xx */;
                  }
               } catch (NumberFormatException var7/* $VF was: ☃xx */) {
                  var2/* $VF was: ☃ */ = var4/* $VF was: ☃x */.hashCode();
               }
            }

            ads.a var8/* $VF was: ☃xx */ = ads.a.a(this.r);
            ads var6/* $VF was: ☃xxx */ = new ads(var2/* $VF was: ☃ */, var8/* $VF was: ☃xx */, this.t, this.x, adu.a[this.L]);
            var6/* $VF was: ☃xxx */.a(this.a);
            if (this.w && !this.x) {
               var6/* $VF was: ☃xxx */.a();
            }

            if (this.u && !this.x) {
               var6/* $VF was: ☃xxx */.b();
            }

            this.j.a("existence.af15", bnu.a("resultFolder.aprilWorldName"), var6/* $VF was: ☃xxx */);
         } else if (var1/* $VF was: ☃ */.k == 3) {
            this.h();
         } else if (var1/* $VF was: ☃ */.k == 2) {
            if (this.r.equals("survival")) {
               if (!this.v) {
                  this.u = true;
               }

               this.x = false;
               this.r = "creative";
               this.f();
               this.x = false;
               this.F.l = true;
               this.D.l = true;
            } else {
               if (!this.v) {
                  this.u = false;
               }

               this.r = "survival";
               this.f();
               this.F.l = true;
               this.D.l = true;
               this.x = false;
            }

            this.f();
         } else if (var1/* $VF was: ☃ */.k == 4) {
            this.t = !this.t;
            this.f();
         } else if (var1/* $VF was: ☃ */.k == 7) {
            this.w = !this.w;
            this.f();
         } else if (var1/* $VF was: ☃ */.k == 5) {
            this.L++;
            if (this.L >= adu.a.length) {
               this.L = 0;
            }

            while (!this.g()) {
               this.L++;
               if (this.L >= adu.a.length) {
                  this.L = 0;
               }
            }

            this.a = "";
            this.f();
            this.a(this.z);
         } else if (var1/* $VF was: ☃ */.k == 6) {
            this.v = true;
            this.u = !this.u;
            this.f();
         } else if (var1/* $VF was: ☃ */.k == 8) {
            if (adu.a[this.L] == adu.c) {
               this.j.a(new axd(this, this.a));
            } else {
               this.j.a(new axg(this, this.a));
            }
         }
      }
   }

   private boolean g() {
      adu var1/* $VF was: ☃ */ = adu.a[this.L];
      if (var1/* $VF was: ☃ */ == null || !var1/* $VF was: ☃ */.e()) {
         return false;
      } else {
         return var1/* $VF was: ☃ */ == adu.g ? r() : true;
      }
   }

   private void h() {
      this.a(!this.z);
   }

   private void a(boolean var1) {
      this.z = var1/* $VF was: ☃ */;
      if (adu.a[this.L] == adu.g) {
         this.A.m = !this.z;
         this.A.l = false;
         if (this.s == null) {
            this.s = this.r;
         }

         this.r = "spectator";
         this.C.m = false;
         this.D.m = false;
         this.E.m = this.z;
         this.F.m = false;
         this.G.m = false;
      } else {
         this.A.m = !this.z;
         this.A.l = true;
         if (this.s != null) {
            this.r = this.s;
            this.s = null;
         }

         this.C.m = this.z && adu.a[this.L] != adu.f;
         this.D.m = this.z;
         this.E.m = this.z;
         this.F.m = this.z;
         this.G.m = this.z && (adu.a[this.L] == adu.c || adu.a[this.L] == adu.f);
      }

      this.f();
      if (this.z) {
         this.B.j = bnu.a("gui.done");
      } else {
         this.B.j = bnu.a("selectWorld.moreWorldOptions");
      }
   }

   @Override
   protected void a(char var1, int var2) {
      if (this.worldNameField.m() && !this.z) {
         this.K = this.worldNameField.b();
      } else if (this.h.m() && this.z) {
         this.h.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
         this.J = this.h.b();
      }

      if (var2/* $VF was: ☃ */ == 28 || var2/* $VF was: ☃ */ == 156) {
         this.a(this.n.get(0));
      }

      this.n.get(0).l = this.worldNameField.b().length() > 0;
      this.a();
   }

   @Override
   protected void a(int var1, int var2, int var3) {
      super.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */);
      if (this.z) {
         this.h.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */);
      }
   }

   @Override
   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, bnu.a("selectWorld.create"), this.l / 2, 20, -1);
      if (this.z) {
         this.c(this.q, bnu.a("selectWorld.enterSeed"), this.l / 2 - 100, 47, -6250336);
         this.c(this.q, bnu.a("selectWorld.seedInfo"), this.l / 2 - 100, 85, -6250336);
         if (this.C.m) {
            this.c(this.q, bnu.a("selectWorld.mapFeatures.info"), this.l / 2 - 150, 122, -6250336);
         }

         if (this.F.m) {
            this.c(this.q, bnu.a("selectWorld.allowCommands.info"), this.l / 2 - 150, 172, -6250336);
         }

         this.h.g();
         if (adu.a[this.L].h()) {
            this.q.a(bnu.a(adu.a[this.L].c()), this.E.h + 2, this.E.i + 22, this.E.b(), 10526880);
         }
      } else {
         this.c(this.q, bnu.a("selectWorld.enterName"), this.l / 2 - 100, 47, -6250336);
         this.worldNameField.g();
         this.c(this.q, this.H, this.l / 2 - 100, 137, -6250336);
         this.c(this.q, this.I, this.l / 2 - 100, 149, -6250336);
      }

      super.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */);
   }

   public void a(atr var1) {
      this.K = bnu.a("selectWorld.newWorld.copyOf", var1/* $VF was: ☃ */.k());
      this.J = var1/* $VF was: ☃ */.b() + "";
      this.L = var1/* $VF was: ☃ */.u().g();
      this.a = var1/* $VF was: ☃ */.B();
      this.t = var1/* $VF was: ☃ */.s();
      this.u = var1/* $VF was: ☃ */.v();
      if (var1/* $VF was: ☃ */.t()) {
         this.r = "hardcore";
      } else if (var1/* $VF was: ☃ */.r().e()) {
         this.r = "survival";
      } else if (var1/* $VF was: ☃ */.r().d()) {
         this.r = "creative";
      }
   }
}
