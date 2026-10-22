
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.Map.Entry;

public final class aaa {
   public static final DecimalFormat numberFormat = new DecimalFormat("#.###");
   public int b;
   public int c;
   private zz d;
   private dp e;
   private int f;
   private ur g;
   private afk h = null;
   private boolean i = false;
   private afk j = null;
   private boolean k = false;

   public aaa(afk var1) {
      this(var1, 1);
   }

   public aaa(afk var1, int var2) {
      this(var1, var2, 0);
   }

   public aaa(afk var1, int var2, int var3) {
      this(zz.a(var1), var2, var3);
   }

   public aaa(zz var1) {
      this(var1, 1);
   }

   public aaa(zz var1, int var2) {
      this(var1, var2, 0);
   }

   public aaa(zz var1, int var2, int var3) {
      this.d = var1;
      this.b = var2;
      this.f = var3;
      if (this.f < 0) {
         this.f = 0;
      }
   }

   public static aaa a(dp var0) {
      aaa var1 = new aaa();
      var1.c(var0);
      return var1.b() != null ? var1 : null;
   }

   private aaa() {
   }

   public aaa a(int var1) {
      aaa var2 = new aaa(this.d, var1, this.f);
      if (this.e != null) {
         var2.e = (dp)this.e.b();
      }

      this.b -= var1;
      return var2;
   }

   public zz b() {
      return this.d;
   }

   public boolean a(wq var1, adp var2, ck var3, cr var4, float var5, float var6, float var7) {
      boolean var8 = this.b().a(this, var1, var2, var3, var4, var5, var6, var7);
      if (var8) {
         var1.b(nc.ad[zz.b(this.d)]);
      }

      return var8;
   }

   public float a(afk var1) {
      return this.b().a(this, var1);
   }

   public aaa a(adp var1, wq var2) {
      return this.b().a(this, var1, var2);
   }

   public aaa b(adp var1, wq var2) {
      return this.b().b(this, var1, var2);
   }

   public dp b(dp var1) {
      ka var2 = zz.e.c(this.d);
      var1.a("id", var2 == null ? "minecraft:air" : var2.toString());
      var1.a("Count", (byte)this.b);
      var1.a("Damage", (short)this.f);
      if (this.e != null) {
         var1.a("tag", this.e);
      }

      return var1;
   }

   public void c(dp var1) {
      if (var1.b("id", 8)) {
         this.d = zz.d(var1.j("id"));
      } else {
         this.d = zz.b(var1.e("id"));
      }

      this.b = var1.d("Count");
      this.f = var1.e("Damage");
      if (this.f < 0) {
         this.f = 0;
      }

      if (var1.b("tag", 10)) {
         this.e = var1.m("tag");
         if (this.d != null) {
            this.d.a(this.e);
         }
      }
   }

   public int c() {
      return this.b().j();
   }

   public boolean d() {
      return this.c() > 1 && (!this.e() || !this.g());
   }

   public boolean e() {
      if (this.d == null) {
         return false;
      } else {
         return this.d.l() <= 0 ? false : !this.n() || !this.o().n("Unbreakable");
      }
   }

   public boolean f() {
      return this.d.k();
   }

   public boolean g() {
      return this.e() && this.f > 0;
   }

   public int h() {
      return this.f;
   }

   public int i() {
      return this.f;
   }

   public void b(int var1) {
      this.f = var1;
      if (this.f < 0) {
         this.f = 0;
      }
   }

   public int j() {
      return this.d.l();
   }

   public boolean a(int var1, Random var2) {
      if (!this.e()) {
         return false;
      }

      if (var1 > 0) {
         int var3 = acn.a(acl.t.B, this);
         int var4 = 0;

         for (int var5 = 0; var3 > 0 && var5 < var1; var5++) {
            if (acj.a(this, var3, var2)) {
               var4++;
            }
         }

         var1 -= var4;
         if (var1 <= 0) {
            return false;
         }
      }

      this.f += var1;
      return this.f > this.j();
   }

   public void a(int var1, pt var2) {
      if (!(var2 instanceof wq) || !((wq)var2).bA.d) {
         if (this.e()) {
            if (this.a(var1, var2.bc())) {
               var2.b(this);
               this.b--;
               if (var2 instanceof wq) {
                  wq var3 = (wq)var2;
                  var3.b(nc.ae[zz.b(this.d)]);
                  if (this.b == 0 && this.b() instanceof yw) {
                     var3.ca();
                  }
               }

               if (this.b < 0) {
                  this.b = 0;
               }

               this.f = 0;
            }
         }
      }
   }

   public void a(pt var1, wq var2) {
      boolean var3 = this.d.a(this, var1, var2);
      if (var3) {
         var2.b(nc.ad[zz.b(this.d)]);
      }
   }

   public void a(adp var1, afk var2, ck var3, wq var4) {
      boolean var5 = this.d.a(this, var1, var2, var3, var4);
      if (var5) {
         var4.b(nc.ad[zz.b(this.d)]);
      }
   }

   public boolean b(afk var1) {
      return this.d.b(var1);
   }

   public boolean a(wq var1, pt var2) {
      return this.d.a(this, var1, var2);
   }

   public aaa k() {
      aaa var1 = new aaa(this.d, this.b, this.f);
      if (this.e != null) {
         var1.e = (dp)this.e.b();
      }

      return var1;
   }

   public static boolean a(aaa var0, aaa var1) {
      if (var0 == null && var1 == null) {
         return true;
      } else if (var0 == null || var1 == null) {
         return false;
      } else {
         return var0.e == null && var1.e != null
            ? false
            : var0.e == null || var0.e.equals(var1.e);
      }
   }

   public static boolean b(aaa var0, aaa var1) {
      if (var0 == null && var1 == null) {
         return true;
      } else {
         return var0 != null && var1 != null ? var0.d(var1) : false;
      }
   }

   private boolean d(aaa var1) {
      if (this.b != var1.b) {
         return false;
      } else if (this.d != var1.d) {
         return false;
      } else if (this.f != var1.f) {
         return false;
      } else {
         return this.e == null && var1.e != null ? false : this.e == null || this.e.equals(var1.e);
      }
   }

   public static boolean c(aaa var0, aaa var1) {
      if (var0 == null && var1 == null) {
         return true;
      } else {
         return var0 != null && var1 != null ? var0.a(var1) : false;
      }
   }

   public boolean a(aaa var1) {
      return var1 != null && this.d == var1.d && this.f == var1.f;
   }

   public String a() {
      return this.d.e_(this);
   }

   public static aaa b(aaa var0) {
      return var0 == null ? null : var0.k();
   }

   @Override
   public String toString() {
      return this.b + "x" + this.d.a() + "@" + this.f;
   }

   public void a(adp var1, pm var2, int var3, boolean var4) {
      if (this.c > 0) {
         this.c--;
      }

      this.d.a(this, var1, var2, var3, var4);
   }

   public void a(adp var1, wq var2, int var3) {
      var2.a(nc.ac[zz.b(this.d)], var3);
      this.d.d(this, var1, var2);
   }

   public boolean c(aaa var1) {
      return this.d(var1);
   }

   public int l() {
      return this.b().d(this);
   }

   public abd m() {
      return this.b().e(this);
   }

   public void b(adp var1, wq var2, int var3) {
      this.b().a(this, var1, var2, var3);
   }

   public boolean n() {
      return this.e != null;
   }

   public dp o() {
      return this.e;
   }

   public dp a(String var1, boolean var2) {
      if (this.e != null && this.e.b(var1, 10)) {
         return this.e.m(var1);
      } else if (var2) {
         dp var3 = new dp();
         this.a(var1, var3);
         return var3;
      } else {
         return null;
      }
   }

   public dv p() {
      return this.e == null ? null : this.e.c("ench", 10);
   }

   public void d(dp var1) {
      this.e = var1;
   }

   public String q() {
      String var1 = this.b().a(this);

      if (this.e != null && this.e.b("display", 10)) {
         dp var2 = this.e.m("display");
         if (var2.b("Name", 8)) {
            var1 = var2.j("Name");
         }
      }

      if ("Thanks for your donation".equals(var1)) {
         return dj.a("item.thanksForDonation");
      }

      return var1;
   }

   public aaa c(String var1) {
      if (this.e == null) {
         this.e = new dp();
      }

      if (!this.e.b("display", 10)) {
         this.e.a("display", new dp());
      }

      this.e.m("display").a("Name", var1);
      return this;
   }

   public void r() {
      if (this.e != null) {
         if (this.e.b("display", 10)) {
            dp var1 = this.e.m("display");
            var1.o("Name");
            if (var1.c_()) {
               this.e.o("display");
               if (this.e.c_()) {
                  this.d((dp)null);
               }
            }
         }
      }
   }

   public boolean s() {
      if (this.e == null) {
         return false;
      } else {
         return !this.e.b("display", 10) ? false : this.e.m("display").b("Name", 8);
      }
   }

   public List<String> a(wq var1, boolean var2) {
      List<String> var3 = Lists.newArrayList();
      String var4 = this.q();
      if (this.s()) {
         var4 = a.u + var4;
      }

      var4 = var4 + a.v;
      if (var2) {
         String var5 = "";
         if (var4.length() > 0) {
            var4 = var4 + " (";
            var5 = ")";
         }

         int var6 = zz.b(this.d);
         if (this.f()) {
            var4 = var4 + String.format("#%04d/%d%s", var6, this.f, var5);
         } else {
            var4 = var4 + String.format("#%04d%s", var6, var5);
         }
      } else if (!this.s() && this.d == aab.be) {
         var4 = var4 + " #" + this.f;
      }

      var3.add(var4);
      int var15 = 0;
      if (this.n() && this.e.b("HideFlags", 99)) {
         var15 = this.e.f("HideFlags");
      }

      if ((var15 & 32) == 0) {
         this.d.a(this, var1, var3, var2);
      }

      if (this.n()) {
         if ((var15 & 1) == 0) {
            dv var16 = this.p();
            if (var16 != null) {
               for (int var7 = 0; var7 < var16.c(); var7++) {
                  int var8 = var16.b(var7).e("id");
                  int var9 = var16.b(var7).e("lvl");
                  if (acl.c(var8) != null) {
                     var3.add(acl.c(var8).d(var9));
                  }
               }
            }
         }

         if (this.e.b("display", 10)) {
            dp var17 = this.e.m("display");
            if (var17.b("color", 3)) {
               if (var2) {
                  var3.add("Color: #" + Integer.toHexString(var17.f("color")).toUpperCase());
               } else {
                  var3.add(a.u + dj.a("item.dyed"));
               }
            }

            if (var17.b("Lore") == 9) {
               dv var19 = var17.c("Lore", 8);
               if (var19.c() > 0) {
                  for (int var23 = 0; var23 < var19.c(); var23++) {
                     var3.add(a.f + "" + a.u + var19.f(var23));
                  }
               }
            }
         }
      }

      Multimap<String, qf> var18 = this.B();
      if (!var18.isEmpty() && (var15 & 2) == 0) {
         var3.add("");

         for (Entry<String, qf> var24 : var18.entries()) {
            qf var27 = var24.getValue();
            double var10 = var27.d();
            if (var27.a() == zz.f) {
               var10 += acn.a(this, py.a);
            }

            double var12;
            if (var27.c() != 1 && var27.c() != 2) {
               var12 = var10;
            } else {
               var12 = var10 * 100.0;
            }

            if (var10 > 0.0) {
               var3.add(
                  a.j
                     + dj.a(
                        "attribute.modifier.plus." + var27.c(),
                        numberFormat.format(var12),
                        dj.a("attribute.name." + var24.getKey())
                     )
               );
            } else if (var10 < 0.0) {
               var12 *= -1.0;
               var3.add(
                  a.m
                     + dj.a(
                        "attribute.modifier.take." + var27.c(),
                        numberFormat.format(var12),
                        dj.a("attribute.name." + var24.getKey())
                     )
               );
            }
         }
      }

      if (this.n() && this.o().n("Unbreakable") && (var15 & 4) == 0) {
         var3.add(a.j + dj.a("item.unbreakable"));
      }

      if (this.n() && this.e.b("CanDestroy", 9) && (var15 & 8) == 0) {
         dv var21 = this.e.c("CanDestroy", 8);
         if (var21.c() > 0) {
            var3.add("");
            var3.add(a.h + dj.a("item.canBreak"));

            for (int var25 = 0; var25 < var21.c(); var25++) {
               afk var28 = afk.b(var21.f(var25));
               if (var28 != null) {
                  var3.add(a.i + var28.f());
               } else {
                  var3.add(a.i + "missingno");
               }
            }
         }
      }

      if (this.n() && this.e.b("CanPlaceOn", 9) && (var15 & 16) == 0) {
         dv var22 = this.e.c("CanPlaceOn", 8);
         if (var22.c() > 0) {
            var3.add("");
            var3.add(a.h + dj.a("item.canPlace"));

            for (int var26 = 0; var26 < var22.c(); var26++) {
               afk var29 = afk.b(var22.f(var26));
               if (var29 != null) {
                  var3.add(a.i + var29.f());
               } else {
                  var3.add(a.i + "missingno");
               }
            }
         }
      }

      if (var2) {
         if (this.g()) {
            var3.add("Durability: " + (this.j() - this.h()) + " / " + this.j());
         }

         var3.add(a.i + zz.e.c(this.d).toString());
         if (this.n()) {
            var3.add(a.i + "NBT: " + this.o().c().size() + " tag(s)");
         }
      }

      return var3;
   }

   public boolean t() {
      return this.b().f(this);
   }

   public aam u() {
      return this.b().g(this);
   }

   public boolean v() {
      return !this.b().f_(this) ? false : !this.w();
   }

   public void a(acl var1, int var2) {
      if (this.e == null) {
         this.d(new dp());
      }

      if (!this.e.b("ench", 9)) {
         this.e.a("ench", new dv());
      }

      dv var3 = this.e.c("ench", 10);
      dp var4 = new dp();
      var4.a("id", (short)var1.B);
      var4.a("lvl", (short)((byte)var2));
      var3.a(var4);
   }

   public boolean w() {
      return this.e != null && this.e.b("ench", 9);
   }

   public void a(String var1, ec var2) {
      if (this.e == null) {
         this.d(new dp());
      }

      this.e.a(var1, var2);
   }

   public boolean x() {
      return this.b().s();
   }

   public boolean y() {
      return this.g != null;
   }

   public void a(ur var1) {
      this.g = var1;
   }

   public ur z() {
      return this.g;
   }

   public int A() {
      return this.n() && this.e.b("RepairCost", 3) ? this.e.f("RepairCost") : 0;
   }

   public void c(int var1) {
      if (!this.n()) {
         this.e = new dp();
      }

      this.e.a("RepairCost", var1);
   }

   public Multimap<String, qf> B() {
      Multimap<String, qf> var1;
      if (this.n() && this.e.b("AttributeModifiers", 9)) {
         var1 = HashMultimap.create();
         dv var2 = this.e.c("AttributeModifiers", 10);

         for (int var3 = 0; var3 < var2.c(); var3++) {
            dp var4 = var2.b(var3);
            qf var5 = wb.a(var4);
            if (var5 != null
               && var5.a().getLeastSignificantBits() != 0L
               && var5.a().getMostSignificantBits() != 0L) {
               var1.put(var4.j("AttributeName"), var5);
            }
         }
      } else {
         var1 = this.b().i();
      }

      return var1;
   }

   public void a(zz var1) {
      this.d = var1;
   }

   public ev C() {
      fb var1 = new fb(this.q());
      if (this.s()) {
         var1.b().b(true);
      }

      ev var2 = new fb("[").a(var1).a("]");
      if (this.d != null) {
         dp var3 = new dp();
         this.b(var3);
         var2.b().a(new ex(ex.a.c, new fb(var3.toString())));
         var2.b().a(this.u().e);
      }

      return var2;
   }

   public boolean c(afk var1) {
      if (var1 == this.h) {
         return this.i;
      }

      this.h = var1;
      if (this.n() && this.e.b("CanDestroy", 9)) {
         dv var2 = this.e.c("CanDestroy", 8);

         for (int var3 = 0; var3 < var2.c(); var3++) {
            afk var4 = afk.b(var2.f(var3));
            if (var4 == var1) {
               this.i = true;
               return true;
            }
         }
      }

      this.i = false;
      return false;
   }

   public boolean d(afk var1) {
      if (var1 == this.j) {
         return this.k;
      }

      this.j = var1;
      if (this.n() && this.e.b("CanPlaceOn", 9)) {
         dv var2 = this.e.c("CanPlaceOn", 8);

         for (int var3 = 0; var3 < var2.c(); var3++) {
            afk var4 = afk.b(var2.f(var3));
            if (var4 == var1) {
               this.k = true;
               return true;
            }
         }
      }

      this.k = false;
      return false;
   }
}
