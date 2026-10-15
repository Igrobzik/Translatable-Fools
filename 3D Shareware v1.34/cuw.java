import com.google.common.collect.ImmutableMap;
import com.mojang.authlib.GameProfile;
import java.util.Locale;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.CheatCodes;
import net.minecraft.server.MinecraftServer;

public class cuw {
   private final cux a;
   private boolean b;
   private final ctd clipboard = new ctd();
   private long d = -1L;
   private long e = -1L;
   private long f = -1L;
   private boolean g;
   private String h = "";
   private final Random i = new Random();

   public cuw(cux var1) {
      this.a = var1/* $VF was: ☃ */;
   }

   private void a(String var1, Object... var2) {
      this.a.t.f().a(new jv("").a(new jw("debug.prefix").a(c.o, c.r)).a(" ").a(new jw(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */)));
   }

   private void b(String var1, Object... var2) {
      this.a.t.f().a(new jv("").a(new jw("debug.prefix").a(c.m, c.r)).a(" ").a(new jw(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */)));
   }

   private boolean c(int var1) {
      if (this.d > 0L && this.d < p.b() - 100L) {
         return true;
      }

      switch (var1/* $VF was: ☃ */) {
         case 65:
            this.a.i.d();
            this.a("debug.reload_chunks.message");
            return true;
         case 66: {
            boolean var2/* $VF was: ☃ */ = !this.a.W().b();
            this.a.W().b(var2/* $VF was: ☃ */);
            this.a(var2/* $VF was: ☃ */ ? "debug.show_hitboxes.on" : "debug.show_hitboxes.off");
            return true;
         }
         case 67:
            if (this.a.j.dR()) {
               return false;
            }

            this.a("debug.copy_location.message");
            this.a(
               String.format(
                  Locale.ROOT,
                  "/execute in %s run tp @s %.2f %.2f %.2f %.2f %.2f",
                  bxs.a(this.a.j.l.q.p()),
                  this.a.j.p,
                  this.a.j.q,
                  this.a.j.r,
                  this.a.j.s,
                  this.a.j.t
               )
            );
            return true;
         case 68:
            if (this.a.t != null) {
               this.a.t.f().a(false);
            }

            return true;
         case 69:
         case 74:
         case 75:
         case 76:
         case 77:
         case 79:
         case 82:
         case 83:
         default:
            return false;
         case 70:
            cva.m.a(this.a.w, zq.a(this.a.w.c + (czn.hasShiftDown() ? -1 : 1), cva.m.b(), cva.m.c()));
            this.a("debug.cycle_renderdistance.message", this.a.w.c);
            return true;
         case 71: {
            boolean var3/* $VF was: ☃ */ = this.a.r.b();
            this.a(var3/* $VF was: ☃ */ ? "debug.chunk_boundaries.on" : "debug.chunk_boundaries.off");
            return true;
         }
         case 72:
            this.a.w.o = !this.a.w.o;
            this.a(this.a.w.o ? "debug.advanced_tooltips.on" : "debug.advanced_tooltips.off");
            this.a.w.b();
            return true;
         case 73:
            if (!this.a.j.dR()) {
               this.a(this.a.j.j(2), !czn.hasShiftDown());
            }

            return true;
         case 78:
            if (!this.a.j.j(2)) {
               this.a("debug.creative_spectator.error");
            } else if (this.a.j.u()) {
               this.a.j.f("/gamemode spectator");
            } else if (this.a.j.t()) {
               this.a.j.f("/gamemode creative");
            }

            return true;
         case 80:
            this.a.w.p = !this.a.w.p;
            this.a.w.b();
            this.a(this.a.w.p ? "debug.pause_focus.on" : "debug.pause_focus.off");
            return true;
         case 81: {
            this.a("debug.help.message");
            cwd var4/* $VF was: ☃ */ = this.a.t.f();
            var4/* $VF was: ☃ */.a(new jw("debug.reload_chunks.help"));
            var4/* $VF was: ☃ */.a(new jw("debug.show_hitboxes.help"));
            var4/* $VF was: ☃ */.a(new jw("debug.copy_location.help"));
            var4/* $VF was: ☃ */.a(new jw("debug.clear_chat.help"));
            var4/* $VF was: ☃ */.a(new jw("debug.cycle_renderdistance.help"));
            var4/* $VF was: ☃ */.a(new jw("debug.chunk_boundaries.help"));
            var4/* $VF was: ☃ */.a(new jw("debug.advanced_tooltips.help"));
            var4/* $VF was: ☃ */.a(new jw("debug.inspect.help"));
            var4/* $VF was: ☃ */.a(new jw("debug.creative_spectator.help"));
            var4/* $VF was: ☃ */.a(new jw("debug.pause_focus.help"));
            var4/* $VF was: ☃ */.a(new jw("debug.help.help"));
            var4/* $VF was: ☃ */.a(new jw("debug.reload_resourcepacks.help"));
            return true;
         }
         case 84:
            this.a("debug.reload_resourcepacks.message");
            this.a.g();
            return true;
      }
   }

   private void a(boolean var1, boolean var2) {
      cri var3/* $VF was: ☃ */ = this.a.v;
      if (var3/* $VF was: ☃ */ != null) {
         switch (var3/* $VF was: ☃ */.c()) {
            case b:
               ev var8/* $VF was: ☃xxxx */ = ((crg)var3/* $VF was: ☃ */).a();
               buy var9/* $VF was: ☃xxxxx */ = this.a.j.l.e_(var8/* $VF was: ☃xxxx */);
               if (var1/* $VF was: ☃ */) {
                  if (var2/* $VF was: ☃ */) {
                     this.a.j.e.k().a(var8/* $VF was: ☃xxxx */, var3x -> {
                        this.a(var9/* block type */, var8/* block position */, var3x);
                        this.a("debug.inspect.server.block");
                     });
                  } else {
                     btb var10/* $VF was: ☃xxxxxx */ = this.a.j.l.d(var8/* $VF was: ☃xxxx */);
                     ib var11/* $VF was: ☃xxxxxxx */ = var10/* $VF was: ☃xxxxxx */ != null ? var10/* $VF was: ☃xxxxxx */.b(new ib()) : null;
                     this.a(var9/* $VF was: ☃xxxxx */, var8/* $VF was: ☃xxxx */, var11/* $VF was: ☃xxxxxxx */);
                     this.a("debug.inspect.client.block");
                  }
               } else {
                  this.a(var9/* $VF was: ☃xxxxx */, var8/* $VF was: ☃xxxx */, null);
                  this.a("debug.inspect.client.block");
               }
               break;
            case c:
               ahz var4/* $VF was: ☃x */ = ((crh)var3/* $VF was: ☃ */).a();
               qr var5/* $VF was: ☃xx */ = fm.l.b(var4/* $VF was: ☃x */.S());
               crk var6/* $VF was: ☃xxx */ = new crk(var4/* $VF was: ☃x */.p, var4/* $VF was: ☃x */.q, var4/* $VF was: ☃x */.r);
               if (var1/* $VF was: ☃ */) {
                  if (var2/* $VF was: ☃ */) {
                     this.a.j.e.k().a(var4/* $VF was: ☃x */.T(), var3x -> {
                        this.a(var5/* entity type */, var6/* entity position */, var3x);
                        this.a("debug.inspect.server.entity");
                     });
                  } else {
                     ib var7/* $VF was: ☃xxxx */ = var4/* $VF was: ☃x */.e(new ib());
                     this.a(var5/* $VF was: ☃xx */, var6/* $VF was: ☃xxx */, var7/* $VF was: ☃xxxx */);
                     this.a("debug.inspect.client.entity");
                  }
               } else {
                  this.a(var5/* $VF was: ☃xx */, var6/* $VF was: ☃xxx */, null);
                  this.a("debug.inspect.client.entity");
               }
         }
      }
   }

   private void a(buy var1, ev var2, @Nullable ib var3) {
      if (var3/* $VF was: ☃ */ != null) {
         var3/* $VF was: ☃ */.r("x");
         var3/* $VF was: ☃ */.r("y");
         var3/* $VF was: ☃ */.r("z");
         var3/* $VF was: ☃ */.r("id");
      }

      StringBuilder var4/* $VF was: ☃ */ = new StringBuilder(dh.a(var1/* $VF was: ☃ */));
      if (var3/* $VF was: ☃ */ != null) {
         var4/* $VF was: ☃ */.append(var3/* $VF was: ☃ */);
      }

      String var5/* $VF was: ☃x */ = String.format(
         Locale.ROOT, "/setblock %d %d %d %s", var2/* $VF was: ☃ */.o(), var2/* $VF was: ☃ */.p(), var2/* $VF was: ☃ */.q(), var4/* $VF was: ☃ */
      );
      this.a(var5/* $VF was: ☃x */);
   }

   private void a(qr var1, crk var2, @Nullable ib var3) {
      String var4/* $VF was: ☃ */;
      if (var3/* $VF was: ☃ */ != null) {
         var3/* $VF was: ☃ */.r("UUIDMost");
         var3/* $VF was: ☃ */.r("UUIDLeast");
         var3/* $VF was: ☃ */.r("Pos");
         var3/* $VF was: ☃ */.r("Dimension");
         String var5/* $VF was: ☃x */ = var3/* $VF was: ☃ */.k().getString();
         var4/* $VF was: ☃ */ = String.format(
            Locale.ROOT,
            "/summon %s %.2f %.2f %.2f %s",
            var1/* $VF was: ☃ */.toString(),
            var2/* $VF was: ☃ */.b,
            var2/* $VF was: ☃ */.c,
            var2/* $VF was: ☃ */.d,
            var5/* $VF was: ☃x */
         );
      } else {
         var4/* $VF was: ☃ */ = String.format(
            Locale.ROOT, "/summon %s %.2f %.2f %.2f", var1/* $VF was: ☃ */.toString(), var2/* $VF was: ☃ */.b, var2/* $VF was: ☃ */.c, var2/* $VF was: ☃ */.d
         );
      }

      this.a(var4/* $VF was: ☃ */);
   }

   public void a(long var1, int var3, int var4, int var5, int var6) {
      if (var1/* $VF was: ☃ */ == this.a.g.h()) {
         if (this.d > 0L) {
            if (!cth.a(cux.v().g.h(), 67) || !cth.a(cux.v().g.h(), 292)) {
               this.d = -1L;
            }
         } else if (cth.a(cux.v().g.h(), 67) && cth.a(cux.v().g.h(), 292)) {
            this.g = true;
            this.d = p.b();
            this.e = p.b();
            this.f = 0L;
         }

         if (this.a.p instanceof cyw) {
            this.a.k();
         } else {
            cwx var7/* $VF was: ☃ */ = this.a.o;
            if (var5/* $VF was: ☃ */ == 1 && (!(this.a.o instanceof dae) || ((dae)var7/* $VF was: ☃ */).b <= p.b() - 20L)) {
               if (this.a.w.ap.a(var3/* $VF was: ☃ */, var4/* $VF was: ☃ */)) {
                  this.a.g.g();
                  this.a.w.U = this.a.g.i();
                  return;
               }

               if (this.a.w.am.a(var3/* $VF was: ☃ */, var4/* $VF was: ☃ */)) {
                  if (czn.hasControlDown()) {
                  }

                  cvf.a(this.a.z, this.a.g.j(), this.a.g.k(), this.a.c(), var1x -> this.a.execute(() -> this.a.t.f().a(var1x)));
                  return;
               }

               if (this.a.w.at.a(var3/* $VF was: ☃ */, var4/* $VF was: ☃ */)) {
                  this.a.q.c = Math.max(0.0, this.a.q.c - 5.0);
               } else if (this.a.w.au.a(var3/* $VF was: ☃ */, var4/* $VF was: ☃ */)) {
                  this.a.q.c = Math.min(100.0, this.a.q.c + 5.0);
               }
            }

            if (var5/* $VF was: ☃ */ != 0 && var3/* $VF was: ☃ */ == 66 && czn.hasControlDown()) {
               cva.v.a(this.a.w, 1);
               if (var7/* $VF was: ☃ */ instanceof cyd) {
                  ((cyd)var7/* $VF was: ☃ */).a();
               }

               if (var7/* $VF was: ☃ */ instanceof cya) {
                  ((cya)var7/* $VF was: ☃ */).a();
               }
            }

            if (var7/* $VF was: ☃ */ != null) {
               boolean[] var8/* $VF was: ☃x */ = new boolean[]{false};
               czn.wrapScreenError(() -> {
                  if (var5 != 1 && (var5 != 2 || !this.b)) {
                     if (var5 == 0) {
                        var8[0] = var7.a(var3, var4, var6);
                     }
                  } else {
                     var8[0] = var7.keyPressed(var3, var4, var6);
                  }
               }, "keyPressed event handler", var7.getClass().getCanonicalName());
               if (var8/* $VF was: ☃x */[0]) {
                  return;
               }
            }

            cth.a var11/* $VF was: ☃x */ = cth.a(var3/* $VF was: ☃ */, var4/* $VF was: ☃ */);
            if (this.a.w.as.c(var11/* $VF was: ☃x */)) {
               cuv.a(var11/* $VF was: ☃x */, var5/* $VF was: ☃ */ != 0);
            }

            if (this.a.o == null || this.a.o.passEvents) {
               if (var5/* $VF was: ☃ */ == 0) {
                  cuv.a(var11/* $VF was: ☃x */, false);
                  if (var3/* $VF was: ☃ */ == 292) {
                     if (this.g) {
                        this.g = false;
                     } else {
                        this.a.w.aD = !this.a.w.aD;
                        this.a.w.aE = this.a.w.aD && czn.hasShiftDown();
                        this.a.w.aF = this.a.w.aD && czn.hasAltDown();
                     }
                  }
               } else {
                  if (var3/* $VF was: ☃ */ == 293 && this.a.q != null) {
                     this.a.q.c();
                  }

                  boolean var9/* $VF was: ☃xx */ = false;
                  if (this.a.o == null) {
                     if (var3/* $VF was: ☃ */ == 256) {
                        this.a.l();
                     }

                     var9/* $VF was: ☃xx */ = cth.a(cux.v().g.h(), 292) && this.c(var3/* $VF was: ☃ */);
                     this.g |= var9/* $VF was: ☃xx */;
                     if (var3/* $VF was: ☃ */ == 290) {
                        this.a.w.aB = !this.a.w.aB;
                     }
                  }

                  if (var9/* $VF was: ☃xx */) {
                     cuv.a(var11/* $VF was: ☃x */, false);
                  } else {
                     cuv.a(var11/* $VF was: ☃x */, true);
                     cuv.a(var11/* $VF was: ☃x */);
                  }

                  if (this.a.w.aE) {
                     if (var3/* $VF was: ☃ */ == 48) {
                        this.a.a(0);
                     }

                     for (int var10/* $VF was: ☃xxx */ = 0; var10/* $VF was: ☃xxx */ < 9; var10/* $VF was: ☃xxx */++) {
                        if (var3/* $VF was: ☃ */ == 49 + var10/* $VF was: ☃xxx */) {
                           this.a.a(var10/* $VF was: ☃xxx */ + 1);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @Nullable
   private static ev a(bgx var0, ev var1, int var2) {
      int var3/* $VF was: ☃ */ = 2 - var2/* $VF was: ☃ */;
      ev.a var7/* $VF was: ☃x */ = new ev.a();

      for (int var8/* $VF was: ☃xx */ = 0; var8/* $VF was: ☃xx */ < 20; var8/* $VF was: ☃xx */++) {
         float var9/* $VF was: ☃xxx */ = var0/* $VF was: ☃ */.p.nextFloat() * (float) (Math.PI * 2);
         int var4/* $VF was: ☃xxxx */ = var1/* $VF was: ☃ */.o()
            + (int)(zq.b(var9/* $VF was: ☃xxx */) * 20.0F * var3/* $VF was: ☃ */)
            + var0/* $VF was: ☃ */.p.nextInt(5);
         int var6/* $VF was: ☃xxxxx */ = var1/* $VF was: ☃ */.q()
            + (int)(zq.a(var9/* $VF was: ☃xxx */) * 20.0F * var3/* $VF was: ☃ */)
            + var0/* $VF was: ☃ */.p.nextInt(5);
         int var5/* $VF was: ☃xxxxxx */ = var0/* $VF was: ☃ */.a(byf.a.b, var4/* $VF was: ☃xxxx */, var6/* $VF was: ☃xxxxx */);
         var7/* $VF was: ☃x */.d(var4/* $VF was: ☃xxxx */, var5/* $VF was: ☃xxxxxx */, var6/* $VF was: ☃xxxxx */);
         if (var0/* $VF was: ☃ */.a(
               var7/* $VF was: ☃x */.o() - 10,
               var7/* $VF was: ☃x */.p() - 10,
               var7/* $VF was: ☃x */.q() - 10,
               var7/* $VF was: ☃x */.o() + 10,
               var7/* $VF was: ☃x */.p() + 10,
               var7/* $VF was: ☃x */.q() + 10
            )
            && bhh.a(aiv.b.a, var0/* $VF was: ☃ */, var7/* $VF was: ☃x */, aid.l)) {
            return var7/* $VF was: ☃x */;
         }
      }

      return null;
   }

   private void a(long window, int codePoint, int modifiers) {
      if (window == this.a.g.h()) {
         this.h = this.h + Character.toUpperCase((char)codePoint);
         if (this.h.length() > CheatCodes.MAX_CHEAT_LEN) {
            this.h = this.h.substring(this.h.length() - CheatCodes.MAX_CHEAT_LEN);
         }

         MinecraftServer server = this.a.B();
         GameProfile profile = this.a.j != null ? this.a.j.dD() : null;
         if (this.h.endsWith("COWSCOWSCOWS")) {
            this.a.j.a(new jw("cheatCode.cowscowscows").a(c.q));
         } else if (server != null && profile != null) {
            vf player = server.ad().a(profile.getId());
            if (player != null) {
               if (this.h.endsWith("IDKFA")) {
                  server.e(() -> {
                     player.bx.e(new bbp(bbq.pT));
                     player.bx.e(new bbp(bbq.pU));
                     player.bx.e(new bbp(bbq.pV));
                     this.a.j.a(new jw("cheatCode.idkfa"));
                  });
               } else if (this.h.endsWith("MOREDAKKA")) {
                  server.e(() -> {
                     bbp ammo = new bbp(bbq.py);
                     bfb.a(ImmutableMap.of(bfd.G, 12), ammo);
                     player.bx.e(ammo);
                     player.bx.e(bfb.a(this.i, new bbp(bbq.jv), 30, true));
                     player.bx.e(bfb.a(this.i, new bbp(bbq.jy), 30, true));
                     player.bx.e(bfb.a(this.i, new bbp(bbq.jx), 30, true));
                     player.bx.e(bfb.a(this.i, new bbp(bbq.jM), 30, true));
                     player.bx.e(bfb.a(this.i, new bbp(bbq.lW), 30, true));
                     player.bx.e(bfb.a(this.i, new bbp(bbq.jf), 30, true));
                     player.a(aie.f, bfb.a(this.i, new bbp(bbq.kd), 30, true));
                     player.a(aie.e, bfb.a(this.i, new bbp(bbq.ke), 30, true));
                     player.a(aie.d, bfb.a(this.i, new bbp(bbq.kf), 30, true));
                     player.a(aie.c, bfb.a(this.i, new bbp(bbq.kg), 30, true));
                     player.a(aie.b, new bbp(bbq.oW));
                     this.a.j.a(new jw("cheatCode.moredakka"));
                  });
               } else if (this.h.endsWith("PIGSONTHEWING")) {
                  server.e(() -> {
                     player.bN.c = !player.bN.c;
                     player.r();
                     this.a.j.a(new jw("cheatCode.pigsonthewing"));
                  });
               } else if (this.h.endsWith("POWEROVERWHELMING")) {
                  server.e(() -> {
                     player.bN.a = !player.bN.a;
                     player.r();
                     this.a.j.a(new jw("cheatCode.poweroverwhelming"));
                  });
               } else if (this.h.endsWith("FLASHAAAAA")) {
                  server.e(() -> {
                     player.c(new aht(ahv.h, 1200, 20));
                     player.c(new aht(ahv.a, 1200, 20));
                     player.c(new aht(ahv.c, 1200, 20));
                     this.a.j.a(new jw("cheatCode.flashaaaaa"));
                  });
               } else if (this.h.endsWith("HOWDOYOUTURNTHISON")) {
                  server.e(() -> {
                     crk playerPos = player.cd();
                     crk spawnPos = new crk(
                        playerPos.b + this.i.nextFloat() * 3.0F,
                        playerPos.c,
                        playerPos.d + this.i.nextFloat() * 3.0F
                     );
                     ark vehicle = aid.F.a(player.l);
                     vehicle.c(spawnPos.b, spawnPos.c, spawnPos.d);
                     vehicle.a(aug.a).a(200.0);
                     vehicle.a(ark.bz).a(3.0);
                     vehicle.a(aug.d).a(3.0);
                     vehicle.s(true);
                     vehicle.s(0);
                     vehicle.a_(401, new bbp(bbq.oo));
                     vehicle.a_(400, new bbp(bbq.kB));
                     player.l.c(vehicle);
                     this.a.j.a(new jw("cheatCode.howdoyouturnthison"));
                  });
               } else if (this.h.endsWith("NEEEERD")) {
                  server.e(() -> {
                     ev playerPos = new ev(player);
                     for (int attempt = 0; attempt < 5; attempt++) {
                        ev spawnPos = a(player.l, playerPos, attempt);
                        if (spawnPos != null) {
                           atl creeper = aid.l.a(player.l);
                           creeper.c(spawnPos.o() + 0.5, spawnPos.p() + 0.5, spawnPos.q() + 0.5);
                           creeper.dW();
                           player.l.c(creeper);
                           this.a.j.a(new jw("cheatCode.neeeerd"));
                           break;
                        }
                     }
                  });
               }
            }
         }

         cwx screen = this.a.o;
         if (screen != null && this.a.au() == null) {
            if (Character.charCount(codePoint) == 1) {
               czn.wrapScreenError(
                  () -> screen.charTyped((char)codePoint, modifiers),
                  "charTyped event handler",
                  screen.getClass().getCanonicalName()
               );
            } else {
               for (char character : Character.toChars(codePoint)) {
                  final char currentCharacter = character;
                  czn.wrapScreenError(
                     () -> screen.charTyped(currentCharacter, modifiers),
                     "charTyped event handler",
                     screen.getClass().getCanonicalName()
                  );
               }
            }
         }
      }
   }

   public void a(boolean var1) {
      this.b = var1/* $VF was: ☃ */;
   }

   public void a(long var1) {
      cth.a(var1/* $VF was: ☃ */, this::a, this::a);
   }

   public String a() {
      return this.clipboard.a(this.a.g.h(), (var1, var2) -> {
         if (var1 != 65545) {
            this.a.g.a(var1, var2);
         }
      });
   }

   public void a(String var1) {
      this.clipboard.a(this.a.g.h(), var1/* $VF was: ☃ */);
   }

   public void b() {
      if (this.d > 0L) {
         long var1/* $VF was: ☃ */ = p.b();
         long var3/* $VF was: ☃x */ = 10000L - (var1/* $VF was: ☃ */ - this.d);
         long var5/* $VF was: ☃xx */ = var1/* $VF was: ☃ */ - this.e;
         if (var3/* $VF was: ☃x */ < 0L) {
            if (czn.hasControlDown()) {
               csq.a();
            }

            throw new m(new d("Manually triggered debug crash", new Throwable()));
         }

         if (var5/* $VF was: ☃xx */ >= 1000L) {
            if (this.f == 0L) {
               this.a("debug.crash.message");
            } else {
               this.b("debug.crash.warning", zq.f((float)var3/* $VF was: ☃x */ / 1000.0F));
            }

            this.e = var1/* $VF was: ☃ */;
            this.f++;
         }
      }
   }
}
