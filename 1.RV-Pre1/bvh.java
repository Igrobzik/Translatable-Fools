import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bvh implements bvk, bwg {
   private static final Logger a = LogManager.getLogger();
   private final Map<kk, bvi> texturesByLocation = Maps.newHashMap();
   private final List<bvk> c = Lists.newArrayList();
   private final Map<String, Integer> d = Maps.newHashMap();
   private bwf e;

   public bvh(bwf var1) {
      this.e = var1/* $VF was: ☃ */;
   }

   public void a(kk var1) {
      bvi var2/* $VF was: ☃ */ = this.texturesByLocation.get(var1/* $VF was: ☃ */);
      if (var2/* $VF was: ☃ */ == null) {
         var2/* $VF was: ☃ */ = new bvc(var1/* $VF was: ☃ */);
         this.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
      }

      bvj.b(var2/* $VF was: ☃ */.b());
   }

   public boolean a(kk var1, bvl var2) {
      if (this.a(var1/* $VF was: ☃ */, (bvi)var2/* $VF was: ☃ */)) {
         this.c.add(var2/* $VF was: ☃ */);
         return true;
      } else {
         return false;
      }
   }

   public boolean a(kk var1, bvi var2) {
      boolean var3/* $VF was: ☃ */ = true;

      try {
         var2/* $VF was: ☃ */.a(this.e);
      } catch (IOException var8/* $VF was: ☃x */) {
         a.warn("Failed to load texture: " + var1/* $VF was: ☃ */, var8/* $VF was: ☃x */);
         var2/* $VF was: ☃ */ = bvj.a;
         this.texturesByLocation.put(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
         var3/* $VF was: ☃ */ = false;
      } catch (Throwable var9/* $VF was: ☃x */) {
         b var5/* $VF was: ☃xx */ = b.a(var9/* $VF was: ☃x */, "Registering texture");
         c var6/* $VF was: ☃xxx */ = var5/* $VF was: ☃xx */.a("Resource location being registered");
         final bvi var7/* $VF was: ☃xxxx */ = var2/* $VF was: ☃ */;
         var6/* $VF was: ☃xxx */.a("Resource location", var1/* $VF was: ☃ */);
         var6/* $VF was: ☃xxx */.a("Texture object class", new Callable<String>() {
            public String call() throws Exception {
               return var7/* $VF was: ☃xxxx */.getClass().getName();
            }
         });
         throw new e(var5/* $VF was: ☃xx */);
      }

      this.texturesByLocation.put(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
      return var3/* $VF was: ☃ */;
   }

   public boolean d(kk location) {
      try {
         this.e.a(location).close();
         return true;
      } catch (IOException exception) {
         return false;
      }
   }

   public bvi b(kk var1) {
      return this.texturesByLocation.get(var1/* $VF was: ☃ */);
   }

   public kk a(String var1, buw var2) {
      Integer var3/* $VF was: ☃ */ = this.d.get(var1/* $VF was: ☃ */);
      if (var3/* $VF was: ☃ */ == null) {
         var3/* $VF was: ☃ */ = 1;
      } else {
         var3/* $VF was: ☃ */ = var3/* $VF was: ☃ */ + 1;
      }

      this.d.put(var1/* $VF was: ☃ */, var3/* $VF was: ☃ */);
      kk var4/* $VF was: ☃x */ = new kk(String.format("dynamic/%s_%d", var1/* $VF was: ☃ */, var3/* $VF was: ☃ */));
      this.a(var4/* $VF was: ☃x */, var2/* $VF was: ☃ */);
      return var4/* $VF was: ☃x */;
   }

   @Override
   public void e() {
      for (bvk var2/* $VF was: ☃ */ : this.c) {
         var2/* $VF was: ☃ */.e();
      }
   }

   public void c(kk var1) {
      bvi var2/* $VF was: ☃ */ = this.b(var1/* $VF was: ☃ */);
      if (var2/* $VF was: ☃ */ != null) {
         bvj.a(var2/* $VF was: ☃ */.b());
      }
   }

   @Override
   public void a(bwf var1) {
      for (Entry<kk, bvi> var3/* $VF was: ☃ */ : this.texturesByLocation.entrySet()) {
         this.a(var3/* $VF was: ☃ */.getKey(), var3/* $VF was: ☃ */.getValue());
      }
   }
}
