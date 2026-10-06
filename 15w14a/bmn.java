import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bmn implements bmq, bnn {
   private static final Logger a = LogManager.getLogger();
   private final Map<ka, bmo> b = Maps.newHashMap();
   private final List<bmq> c = Lists.newArrayList();
   private final Map<String, Integer> d = Maps.newHashMap();
   private bnm e;

   public bmn(bnm var1) {
      this.e = var1/* $VF was: ☃ */;
   }

   public bnm c() {
      return this.e;
   }

   public void a(ka var1) {
      bmo var2/* $VF was: ☃ */ = this.b.get(var1/* $VF was: ☃ */);
      if (var2/* $VF was: ☃ */ == null) {
         var2/* $VF was: ☃ */ = new bmi(var1/* $VF was: ☃ */);
         this.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
      }

      bmp.b(var2/* $VF was: ☃ */.b());
   }

   public boolean a(ka var1, bmr var2) {
      if (this.a(var1/* $VF was: ☃ */, (bmo)var2/* $VF was: ☃ */)) {
         this.c.add(var2/* $VF was: ☃ */);
         return true;
      } else {
         return false;
      }
   }

   public boolean a(ka var1, bmo var2) {
      boolean var3/* $VF was: ☃ */ = true;

      try {
         var2/* $VF was: ☃ */.a(this.e);
      } catch (IOException var8/* $VF was: ☃x */) {
         a.warn("Failed to load texture: " + var1/* $VF was: ☃ */, var8/* $VF was: ☃x */);
         var2/* $VF was: ☃ */ = bmp.a;
         this.b.put(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
         var3/* $VF was: ☃ */ = false;
      } catch (Throwable var9/* $VF was: ☃x */) {
         b var5/* $VF was: ☃xx */ = b.a(var9/* $VF was: ☃x */, "Registering texture");
         c var6/* $VF was: ☃xxx */ = var5/* $VF was: ☃xx */.a("Resource location being registered");
         final bmo var7/* $VF was: ☃xxxx */ = var2/* $VF was: ☃ */;
         var6/* $VF was: ☃xxx */.a("Resource location", var1/* $VF was: ☃ */);
         var6/* $VF was: ☃xxx */.a("Texture object class", new Callable<String>() {
            public String a() throws Exception {
               return var1/* $VF was: ☃ */.getClass().getName();
            }
         });
         throw new f(var5/* $VF was: ☃xx */);
      }

      this.b.put(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
      return var3/* $VF was: ☃ */;
   }

   public bmo b(ka var1) {
      return this.b.get(var1/* $VF was: ☃ */);
   }

   public ka a(String var1, bmd var2) {
      Integer var3/* $VF was: ☃ */ = this.d.get(var1/* $VF was: ☃ */);
      if (var3/* $VF was: ☃ */ == null) {
         var3/* $VF was: ☃ */ = 1;
      } else {
         var3/* $VF was: ☃ */ = var3/* $VF was: ☃ */ + 1;
      }

      this.d.put(var1/* $VF was: ☃ */, var3/* $VF was: ☃ */);
      ka var4/* $VF was: ☃x */ = new ka(String.format("dynamic/%s_%d", var1/* $VF was: ☃ */, var3/* $VF was: ☃ */));
      this.a(var4/* $VF was: ☃x */, var2/* $VF was: ☃ */);
      return var4/* $VF was: ☃x */;
   }

   @Override
   public void e() {
      for (bmq var2/* $VF was: ☃ */ : this.c) {
         var2/* $VF was: ☃ */.e();
      }
   }

   public void c(ka var1) {
      bmo var2/* $VF was: ☃ */ = this.b(var1/* $VF was: ☃ */);
      if (var2/* $VF was: ☃ */ != null) {
         bmp.a(var2/* $VF was: ☃ */.b());
      }
   }

   @Override
   public void a(bnm var1) {
      for (Entry<ka, bmo> var3/* $VF was: ☃ */ : this.b.entrySet()) {
         this.a(var3/* $VF was: ☃ */.getKey(), var3/* $VF was: ☃ */.getValue());
      }
   }
}
