import com.google.common.collect.Queues;
import com.google.common.collect.UnmodifiableIterator;
import com.mojang.authlib.AuthenticationService;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.datafixers.DataFixer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.SocketAddress;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

public class cux extends agf<Runnable> implements ahc, cts, AutoCloseable {
   @Override
   public void a(Runnable task) {
      this.g(task);
   }
   private static final Logger G = LogManager.getLogger();
   public static final boolean a = CuxCompileFixes.isSpecialMode();
   public static final qr b = new qr("default");
   public static final qr c = new qr("alt");
   public static CompletableFuture<zy> d = CompletableFuture.completedFuture(zy.a);
   public static byte[] e = new byte[10485760];
   private static int H = -1;
   private final File I;
   private final PropertyMap J;
   private final ctf K;
   private dhk L;
   private duf M;
   private static cux N;
   private final DataFixer O;
   public dhg f;
   private dkt P;
   public ctr g;
   private boolean Q;
   private d R;
   private boolean S;
   private final cvh T = new cvh(20.0F, 0L);
   private final ahb U = new ahb("client", this, CuxCompileFixes.timeB());
   public dhh h;
   public dki i;
   private dpc V;
   private dpx W;
   private dkg X;
   public djr j;
   @Nullable
   public ahz k;
   @Nullable
   public ahz l;
   public dir m;
   private final dwz Y = new dwz();
   private final cvi Z;
   private boolean aa;
   private float ab;
   public cvp n;
   @Nullable
   public czn o;
   @Nullable
   public czi p;
   public dke q;
   public dnq r;
   protected int s;
   @Nullable
   private dxe ac;
   private final AtomicReference<vr> ad = new AtomicReference<>();
   public cvq t;
   public boolean u;
   public cri v;
   public cvb w;
   private cuu ae;
   public cuy x;
   public cuw y;
   public final File z;
   private final File af;
   private final String ag;
   private final String ah;
   private final Proxy ai;
   private cnr aj;
   private static int ak;
   private int al;
   private String am;
   private int an;
   public final zj A = new zj();
   private long ao = CuxCompileFixes.timeC();
   private final boolean ap;
   private final boolean aq;
   @Nullable
   private ja ar;
   private boolean as;
   private final afu at = new afu(() -> this.T.a);
   private xa au;
   private final dum av;
   private final wr<duz> aw;
   private dvc ax;
   private cvk ay;
   private cvn az;
   private ctc aA;
   private dud aB;
   private dxr aC;
   private dxm aD;
   private cxk aE;
   private dux aF;
   private final MinecraftSessionService aG;
   private duw aH;
   private final Thread aI = Thread.currentThread();
   private dvw aJ;
   private dky aK;
   private duv aL;
   private duu aM;
   private final cxg aN;
   private final cus aO = new cus(this);
   private volatile boolean aP = true;
   public String B = "";
   public boolean F = true;
   private long aQ;
   private int aR;
   private final dyb aS;
   private boolean aT;
   private final Queue<Runnable> aU = Queues.newConcurrentLinkedQueue();
   private CompletableFuture<Void> aV;
   private static final qr aW = new qr("textures/gui/boss_mode.png");
   private qr bossModeTexture = aW;
   private final Random aX = new Random();
   private boolean aY;
   private boolean aZ;
   private int ba = 1800;
   private String bb = "root";

   public cux(ddj var1) {
      super("Client");
      this.K = var1/* $VF was: вѓ */.b;
      N = this;
      this.z = var1/* $VF was: вѓ */.c.a;
      this.af = var1/* $VF was: вѓ */.c.c;
      this.I = var1/* $VF was: вѓ */.c.b;
      this.ag = var1/* $VF was: вѓ */.d.b;
      this.ah = var1/* $VF was: вѓ */.d.c;
      this.J = var1/* $VF was: вѓ */.a.c;
      this.av = new dum(new File(this.z, "server-resource-packs"), var1/* $VF was: вѓ */.c.a());
      this.aw = new wr<>((var0, var1x, var2, var3, var4, var5) -> {
         Supplier<wf> var6/* $VF was: вѓ */;
         if (var4.b() < CuxCompileFixes.packVersion()) {
            var6/* $VF was: вѓ */ = () -> new dus((wf)var2.get(), dus.a);
         } else {
            var6/* $VF was: вѓ */ = var2;
         }

         return new duz(var0, var1x, var6/* $VF was: вѓ */, var3, var4, var5);
      });
      this.aw.a(this.av);
      this.aw.a(new wp(this.I));
      this.ai = var1/* $VF was: вѓ */.a.d == null ? Proxy.NO_PROXY : var1/* $VF was: вѓ */.a.d;
      this.aG = new YggdrasilAuthenticationService(this.ai, UUID.randomUUID().toString()).createMinecraftSessionService();
      this.Z = var1/* $VF was: вѓ */.a.a;
      G.info("Setting user: {}", this.Z.c());
      G.debug("(Session ID is {})", this.Z.a());
      this.aq = var1/* $VF was: вѓ */.d.a;
      this.ap = az();
      this.ac = null;
      if (var1/* $VF was: вѓ */.e.a != null) {
         this.am = var1/* $VF was: вѓ */.e.a;
         this.an = var1/* $VF was: вѓ */.e.b;
      }

      qt.a();
      qt.c();
      jq.b = cuv::a;
      this.O = aab.a();
      this.aN = new cxg(this);
      this.aS = new dyb(this);
   }

   public void b() {
      this.aP = true;

      try {
         this.av();
      } catch (Throwable var10/* $VF was: вѓ */) {
         d var2/* $VF was: вѓx */ = CuxCompileFixes.crashReport(var10/* $VF was: вѓ */, "Initializing game");
         var2/* $VF was: вѓx */.a("Initialization");
         this.c(this.b(var2/* $VF was: вѓx */));
         return;
      }

      try {
         try {
            while (this.aP) {
               if (this.Q && this.R != null) {
                  this.c(this.R);
                  return;
               }

               try {
                  this.d(true);
               } catch (OutOfMemoryError var9/* $VF was: вѓ */) {
                  this.j();
                  this.a(new czh());
                  System.gc();
               }
            }

            return;
         } catch (m var11/* $VF was: вѓ */) {
            this.b(var11/* $VF was: вѓ */.a());
            this.j();
            G.fatal("Reported exception thrown!", var11/* $VF was: вѓ */);
            this.c(var11/* $VF was: вѓ */.a());
         } catch (Throwable var12/* $VF was: вѓ */) {
            d var14/* $VF was: вѓx */ = this.b(new d("Unexpected error", var12/* $VF was: вѓ */));
            G.fatal("Unreported exception thrown!", var12/* $VF was: вѓ */);
            this.j();
            this.c(var14/* $VF was: вѓx */);
         }
      } finally {
         this.i();
      }
   }

   private void av() {
      this.w = new cvb(this, this.z);
      this.ae = new cuu(this.z, this.O);
      this.aA();
      G.info("LWJGL Version: {}", GLX.getLWJGLVersion());
      ctf var1/* $VF was: вѓ */ = this.K;
      if (this.w.s > 0 && this.w.r > 0) {
         var1/* $VF was: вѓ */ = new ctf(this.w.r, this.w.s, var1/* $VF was: вѓ */.c, var1/* $VF was: вѓ */.d, var1/* $VF was: вѓ */.e);
      }

      LongSupplier var2/* $VF was: вѓx */ = GLX.initGlfw();
      if (var2/* $VF was: вѓx */ != null) {
         CuxCompileFixes.setClock(var2)/* $VF was: вѓx */;
      }

      this.P = new dkt(this);
      this.g = this.P.a(var1/* $VF was: вѓ */, this.w.m, "Minecraft " + CuxCompileFixes.gameVersionName());
      this.a(true);

      try {
         InputStream var3/* $VF was: вѓxx */ = this.J().a().a(wg.a, new qr("icons/icon_16x16.png"));
         InputStream var4/* $VF was: вѓxxx */ = this.J().a().a(wg.a, new qr("icons/icon_32x32.png"));
         this.g.a(var3/* $VF was: вѓxx */, var4/* $VF was: вѓxxx */);
      } catch (IOException var6/* $VF was: вѓxx */) {
         G.error("Couldn't set icon", var6/* $VF was: вѓxx */);
      }

      this.g.a(this.w.d);
      this.x = new cuy(this);
      this.x.a(this.g.h());
      this.y = new cuw(this);
      this.y.a(this.g.h());
      GLX.init();
      ctg.a(this.w.E, false);
      this.aA = new ctc(this.g.j(), this.g.k(), true, a);
      this.aA.a(0.0F, 0.0F, 0.0F, 0.0F);
      this.au = new xg(wg.a, this.aI);
      this.w.a(this.aw);
      this.aw.a();
      List<wf> var7/* $VF was: вѓxx */ = this.aw.d().stream().map(wu::d).collect(Collectors.toList());

      for (wf var5/* $VF was: вѓxxx */ : var7/* $VF was: вѓxx */) {
         this.au.a(var5/* $VF was: вѓxxx */);
      }

      this.ax = new dvc(this.w.aN);
      this.au.a(this.ax);
      this.ax.a(var7/* $VF was: вѓxx */);
      this.M = new duf(this.au);
      this.au.a(this.M);

      String bossModeLanguageForTexture = this.w.aN;
      if (bossModeLanguageForTexture != null
            && !bossModeLanguageForTexture.trim().isEmpty()) {
         bossModeLanguageForTexture =
            bossModeLanguageForTexture.trim().toLowerCase(java.util.Locale.ROOT);

         qr localizedBossModeTexture = new qr(
            "textures/gui/boss_mode_" + bossModeLanguageForTexture + ".png"
         );

         if (this.au.b(localizedBossModeTexture)) {
            this.bossModeTexture = localizedBossModeTexture;
         }
      }
      this.a();
      this.aH = new duw(this.M, new File(this.af, "skins"), this.aG);
      this.aj = new cnr(this.z.toPath().resolve("saves"), this.z.toPath().resolve("backups"), this.O);
      this.aC = new dxr(this.au, this.w);
      this.au.a(this.aC);
      this.aF = new dux(this.Z);
      this.au.a(this.aF);
      this.aD = new dxm(this);
      this.aE = new cxk(this.M, this.f());
      this.au.a(this.aE.a());
      this.n = this.aE.a(b);
      if (this.w.aN != null) {
         this.n.a(this.ax.a());
      }

      this.au.a(new dur());
      this.au.a(new duq());
      this.g.a("Startup");
      GlStateManager.enableTexture();
      GlStateManager.shadeModel(7425);
      GlStateManager.clearDepth(1.0);
      GlStateManager.enableDepthTest();
      GlStateManager.depthFunc(515);
      GlStateManager.enableAlphaTest();
      GlStateManager.alphaFunc(516, 0.1F);
      GlStateManager.cullFace(GlStateManager.i.b);
      GlStateManager.matrixMode(5889);
      GlStateManager.loadIdentity();
      GlStateManager.matrixMode(5888);
      this.g.a("Post startup");
      this.aB = new dud("textures");
      this.aB.a(this.w.y);
      this.M.a(dud.f, this.aB);
      this.M.a(dud.f);
      this.aB.a(false, this.w.y > 0);
      this.aJ = new dvw(this.aB);
      this.au.a(this.aJ);
      this.ay = cvk.a();
      this.az = cvn.a(this.ay);
      this.W = new dpx(this.M, this.aJ, this.az);
      this.V = new dpc(this.M, this.W, this.au);
      this.X = new dkg(this);
      this.au.a(this.W);
      this.q = new dke(this, this.au);
      this.au.a(this.q);
      this.aK = new dky(this.aJ.b(), this.ay);
      this.au.a(this.aK);
      this.i = new dki(this);
      this.au.a(this.i);
      this.ay();
      this.au.a(this.Y);
      GlStateManager.viewport(0, 0, this.g.j(), this.g.k());
      this.m = new dir(this.h, this.M);
      this.au.a(this.m);
      this.aL = new duv(this.M);
      this.au.a(this.aL);
      this.aM = new duu(this.M);
      this.au.a(this.aM);
      this.t = new cvq(this);
      this.r = new dnq(this);
      GLX.setGlfwErrorCallback(this::a);
      if (this.w.U && !this.g.i()) {
         this.g.g();
         this.w.U = this.g.i();
      }

      this.g.b(this.w.K);
      this.g.a();
      if (this.am != null) {
         this.a(new cyi(new czr(), this, this.am, this.an));
      } else {
         this.a(new czd());
      }

      czc.a(this);
      cyv.a(this);
      cyl.a(this);
      this.M.a(this.bossModeTexture, new czc.a(this.bossModeTexture));
      this.a(new cyu(this, this.au.a(CuxCompileFixes.executor(), this, CompletableFuture.completedFuture(zy.a)), () -> {
         if (CuxCompileFixes.optionFlag()) {
            this.aB();
         }
      }));
   }

   private void ay() {
      dwy<bbp> var1 = new dwy<>(cux::c, cux::b);
      dwx<bbp> var2 = new dwx<>(cux::a);
      fj<bbp> var3 = fj.a();

      for (bbk var5 : fm.m) {
         var5.a(bag.g, var3);
      }

      var3.forEach(var2x -> cux.a(var1, var2, var2x));

      dwy<dce> var6 = new dwy<>(cux::b, cux::a);
      this.Y.a(dwz.a, var1);
      this.Y.a(dwz.b, var2);
      this.Y.a(dwz.c, var6);
   }

   private void a(int var1, long var2) {
      this.w.K = false;
      this.w.b();
   }

   private static java.util.stream.Stream a(dce var0) {
   return var0.d().stream().map(cux::a);
   }

   private static java.util.stream.Stream b(dce var0) {
   return var0.d().stream()
      .flatMap(cux::b)
      .map(item -> cux.c((jm)item))
      .filter(item -> cux.a((String)item));
   }

   private static void a(dwy var0, dwx var1, bbp var2) {
      var0.a(var2);
      var1.a(var2);
   }

   private static java.util.stream.Stream a(bbp var0) {
      return yx.a().a(var0.b()).stream();
   }

   private static java.util.stream.Stream b(bbp var0) {
      return java.util.stream.Stream.of(fm.m.b(var0.b()));
   }

   private static java.util.stream.Stream c(bbp var0) {
   return var0.a(null, bcz.a.a).stream()
      .map(cux::d)
      .filter(cux::b);
   }
   private static qr a(bdz var0) {
      return fm.m.b(var0.c().b());
   }

   private static java.util.stream.Stream b(bdz var0) {
      return var0.c().a(null, bcz.a.a).stream();
   }

   private static boolean a(String var0) {
      return !var0.isEmpty();
   }

   private static String c(jm var0) {
      return CuxCompileFixes.clean(var0.getString());
   }

   private static boolean b(String var0) {
      return !var0.isEmpty();
   }

   private static String d(jm var0) {
      return CuxCompileFixes.clean(var0.getString());
   }
   private static boolean az() {
      String[] var0/* $VF was: вѓ */ = new String[]{"sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"};

      for (String var4/* $VF was: вѓx */ : var0/* $VF was: вѓ */) {
         String var5/* $VF was: вѓxx */ = System.getProperty(var4/* $VF was: вѓx */);
         if (var5/* $VF was: вѓxx */ != null && var5/* $VF was: вѓxx */.contains("64")) {
            return true;
         }
      }

      return false;
   }

   public ctc c() {
      return this.aA;
   }

   public String d() {
      return this.ag;
   }

   public String e() {
      return this.ah;
   }

   private void aA() {
      Thread var1/* $VF was: вѓ */ = new Thread("Timer hack thread") {
         @Override
         public void run() {
            while (cux.this.aP) {
               try {
                  Thread.sleep(2147483647L);
               } catch (InterruptedException var2) {
               }
            }
         }
      };
      var1/* $VF was: вѓ */.setDaemon(true);
      var1/* $VF was: вѓ */.setUncaughtExceptionHandler(new g(G));
      var1/* $VF was: вѓ */.start();
   }

   public void a(d var1) {
      this.Q = true;
      this.R = var1/* $VF was: вѓ */;
   }

   public void c(d var1) {
      File var2/* $VF was: вѓ */ = new File(v().z, "crash-reports");
      File var3/* $VF was: вѓx */ = new File(var2/* $VF was: вѓ */, "crash-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + "-client.txt");
      qt.a(var1/* $VF was: вѓ */.e());
      if (var1/* $VF was: вѓ */.f() != null) {
         qt.a("#@!@# Game crashed! Crash report saved to: #@!@# " + var1/* $VF was: вѓ */.f());
         System.exit(-1);
      } else if (var1/* $VF was: вѓ */.a(var3/* $VF was: вѓx */)) {
         qt.a("#@!@# Game crashed! Crash report saved to: #@!@# " + var3/* $VF was: вѓx */.getAbsolutePath());
         System.exit(-1);
      } else {
         qt.a("#@?@# Game crashed! Crash report could not be saved. #@?@#");
         System.exit(-2);
      }
   }

   public boolean f() {
      return this.w.M;
   }

   public CompletableFuture<Void> g() {
      if (this.aV != null) {
         return this.aV;
      } else {
         CompletableFuture<Void> var1/* $VF was: вѓ */ = new CompletableFuture<>();
         if (this.p instanceof czc) {
            this.aV = var1/* $VF was: вѓ */;
            return var1/* $VF was: вѓ */;
         } else {
            this.aw.a();
            List<wf> var2/* $VF was: вѓx */ = this.aw.d().stream().map(wu::d).collect(Collectors.toList());
            this.a(new czc(this, this.au.a(CuxCompileFixes.executor(), this, d, var2/* $VF was: вѓx */), () -> {
                this.ax.a(var2);
               if (this.i != null) {
                  this.i.d();
               }

                var1.complete(null);
            }, true));
            return var1/* $VF was: вѓ */;
         }
      }
   }

   private void aB() {
      boolean var1/* $VF was: вѓ */ = false;
      dkx var2/* $VF was: вѓx */ = this.V().a();
      dvs var3/* $VF was: вѓxx */ = var2/* $VF was: вѓx */.a().a();

      for (bma var5/* $VF was: вѓxxx */ : fm.j) {
         UnmodifiableIterator var6 = var5/* $VF was: вѓxxx */.n().a().iterator();

         while (var6.hasNext()) {
            buy var7/* $VF was: вѓxxxx */ = (buy)var6.next();
            if (var7/* $VF was: вѓxxxx */.k() == bqi.c) {
               dvs var8/* $VF was: вѓxxxxx */ = var2/* $VF was: вѓx */.b(var7/* $VF was: вѓxxxx */);
               if (var8/* $VF was: вѓxxxxx */ == var3/* $VF was: вѓxx */) {
                  G.debug("Missing model for: {}", var7/* $VF was: вѓxxxx */);
                  var1/* $VF was: вѓ */ = true;
               }
            }
         }
      }

      due var12/* $VF was: вѓxxx */ = var3/* $VF was: вѓxx */.d();

      for (bma var15/* $VF was: вѓxxxx */ : fm.j) {
         UnmodifiableIterator var17 = var15/* $VF was: вѓxxxx */.n().a().iterator();

         while (var17.hasNext()) {
            buy var19/* $VF was: вѓxxxxx */ = (buy)var17.next();
            due var9/* $VF was: вѓxxxxxx */ = var2/* $VF was: вѓx */.a(var19/* $VF was: вѓxxxxx */);
            if (!var19/* $VF was: вѓxxxxx */.i() && var9/* $VF was: вѓxxxxxx */ == var12/* $VF was: вѓxxx */) {
               G.debug("Missing particle icon for: {}", var19/* $VF was: вѓxxxxx */);
               var1/* $VF was: вѓ */ = true;
            }
         }
      }

      fj<bbp> var14/* $VF was: вѓxxxx */ = fj.a();

      for (bbk var18/* $VF was: вѓxxxxx */ : fm.m) {
         var14/* $VF was: вѓxxxx */.clear();
         var18/* $VF was: вѓxxxxx */.a(bag.g, var14/* $VF was: вѓxxxx */);

         for (bbp var21/* $VF was: вѓxxxxxx */ : var14/* $VF was: вѓxxxx */) {
            String var10/* $VF was: вѓxxxxxxx */ = new jw(var21/* $VF was: вѓxxxxxx */.j()).getString();
            if (var10/* $VF was: вѓxxxxxxx */.toLowerCase(Locale.ROOT).equals(var10/* $VF was: вѓxxxxxxx */)) {
               G.debug("Missing translation for: {} {} {}", var21/* $VF was: вѓxxxxxx */, var21/* $VF was: вѓxxxxxx */.j(), var21/* $VF was: вѓxxxxxx */.b());
               var1/* $VF was: вѓ */ = true;
            }
         }
      }

      var1/* $VF was: вѓ */ |= cze.a();
      if (var1/* $VF was: вѓ */) {
         throw new IllegalStateException("Your game data is foobar, fix the errors above!");
      }
   }

   public cnr h() {
      return this.aj;
   }

   public void a(@Nullable czn var1) {
      if (this.o != null) {
         this.o.removed();
      }

      if (var1/* $VF was: вѓ */ == null && this.h == null) {
         var1/* $VF was: вѓ */ = new czr();
      } else if (var1/* $VF was: вѓ */ == null && this.j.cy() <= 0.0F) {
         var1/* $VF was: вѓ */ = new cym(null, this.h.p_().s());
      }

      if (var1/* $VF was: вѓ */ instanceof czr || var1/* $VF was: вѓ */ instanceof dbs) {
         this.w.aD = false;
         this.t.f().a(true);
      }

      this.o = var1/* $VF was: вѓ */;
      if (var1/* $VF was: вѓ */ != null) {
         this.x.j();
         cuv.b();
         var1/* $VF was: вѓ */.init(this, this.g.o(), this.g.p());
         this.u = false;
         cvu.b.a(var1/* $VF was: вѓ */.getNarrationMessage());
      } else {
         this.aC.e();
         this.x.i();
      }
   }

   public void a(@Nullable czi var1) {
      this.p = var1/* $VF was: вѓ */;
   }

   public void i() {
      try {
         this.aC();
         if (this.o != null) {
            this.o.removed();
         }

         this.close();
      } finally {
         CuxCompileFixes.resetClock();
         if (!this.Q) {
            System.exit(0);
         }
      }
   }

   private void aC() {
      G.info("Stopping!");

      try {
         if (this.h != null) {
            this.h.P();
         }

         this.o();
      } catch (Throwable var2) {
      }
   }

   @Override
   public void close() {
      try {
         this.aB.g();
         this.n.close();
         this.aE.close();
         this.q.close();
         this.i.close();
         this.aC.d();
         this.aw.close();
         this.m.a();
         this.aM.close();
         this.aL.close();
         CuxCompileFixes.shutdown();
      } finally {
         this.P.close();
         this.g.close();
      }
   }

   private void d(boolean var1) {
      this.g.a("Pre render");
      long var2/* $VF was: вѓ */ = CuxCompileFixes.timeC();
      this.at.a();
      if (GLX.shouldClose(this.g)) {
         this.k();
      }

      if (this.aV != null && !(this.p instanceof czc)) {
         CompletableFuture<Void> var4/* $VF was: вѓx */ = this.aV;
         this.aV = null;
          this.g().thenRun(() -> var4.complete(null));
      }

      Runnable var12/* $VF was: вѓx */;
      while ((var12/* $VF was: вѓx */ = this.aU.poll()) != null) {
         var12/* $VF was: вѓx */.run();
      }

      if (var1/* $VF was: вѓ */) {
         this.T.a(CuxCompileFixes.timeB());
         this.at.a("scheduledExecutables");
         this.bf();
         this.at.c();
      }

      long var5/* $VF was: вѓxx */ = CuxCompileFixes.timeC();
      this.at.a("tick");
      if (this.o == null && this.ba-- < 0) {
         this.a(new czf());
         this.ba = (30 + this.aX.nextInt(120)) * 60;
      }

      if (var1/* $VF was: вѓ */) {
         for (int var7/* $VF was: вѓxxx */ = 0; var7/* $VF was: вѓxxx */ < Math.min(10, this.T.a); var7/* $VF was: вѓxxx */++) {
            this.n();
         }
      }

      this.x.a();
      this.g.a("Render");
      GLX.pollEvents();
      long var13/* $VF was: вѓxxx */ = CuxCompileFixes.timeC() - var5/* $VF was: вѓxx */;
      this.at.b("sound");
      this.aC.a(this.q.n());
      this.at.c();
      this.at.a("render");
      GlStateManager.pushMatrix();
      GlStateManager.clear(16640, a);
      this.aA.a(true);
      this.at.a("display");
      GlStateManager.enableTexture();
      this.at.c();
      if (this.w.as.d()) {
         this.aD();
      } else if (!this.u) {
         this.at.b("gameRenderer");
         this.q.a(0.0F, var2/* $VF was: вѓ */, var1/* $VF was: вѓ */);
         this.at.b("toasts");
         this.aN.a();
         this.at.c();
      }

      this.at.b();
      if (this.w.aD && this.w.aE && !this.w.aB) {
         this.at.d().d();
         this.aG();
      } else {
         this.at.d().b();
      }

      this.aA.e();
      GlStateManager.popMatrix();
      GlStateManager.pushMatrix();
      this.aA.a(this.g.j(), this.g.k());
      GlStateManager.popMatrix();
      this.at.a();
      this.b(true);
      Thread.yield();
      this.g.a("Post render");
      this.aR++;
      boolean var9/* $VF was: вѓxxxx */ = this.A() && (this.o != null && this.o.isPauseScreen() || this.p != null && this.p.b()) && !this.ac.ae();
      if (this.aa != var9/* $VF was: вѓxxxx */) {
         if (this.aa) {
            this.ab = this.T.b;
         } else {
            this.T.b = this.ab;
         }

         this.aa = var9/* $VF was: вѓxxxx */;
      }

      long var10/* $VF was: вѓxxxxx */ = CuxCompileFixes.timeC();
      this.A.a(var10/* $VF was: вѓxxxxx */ - this.ao);
      this.ao = var10/* $VF was: вѓxxxxx */;

      while (CuxCompileFixes.timeB() >= this.aQ + 1000L) {
         ak = this.aR;
         this.B = String.format(
            "%d fps (%d chunk update%s) T: %s%s%s%s%s",
            ak,
            dnb.a,
            dnb.a == 1 ? "" : "s",
            this.w.d == cva.h.c() ? "inf" : this.w.d,
            this.w.K ? " vsync" : "",
            this.w.f ? "" : " fast",
            this.w.e == cup.a ? "" : (this.w.e == cup.b ? " fast-clouds" : " fancy-clouds"),
            GLX.useVbo() ? " vbo" : ""
         );
         dnb.a = 0;
         this.aQ += 1000L;
         this.aR = 0;
         this.U.b();
         if (!this.U.d()) {
            this.U.a();
         }
      }

      this.at.b();
   }

   private void aD() {
      GlStateManager.clear(16640, a);
      this.g.a(a);
      this.M.a(this.bossModeTexture);
      cuc var1/* $VF was: вѓ */ = cuc.a();
      ctz var2/* $VF was: вѓx */ = var1/* $VF was: вѓ */.c();
      double var3/* $VF was: вѓxx */ = this.g.j() / this.g.s();
      double var5/* $VF was: вѓxxx */ = this.g.k() / this.g.s();
      var2/* $VF was: вѓx */.a(7, cub.m);
      var2/* $VF was: вѓx */.b(0.0, 0.0, 0.0).a(0.0, 0.0).d();
      var2/* $VF was: вѓx */.b(0.0, var5/* $VF was: вѓxxx */, 0.0).a(0.0, 0.390625).d();
      var2/* $VF was: вѓx */.b(var3/* $VF was: вѓxx */, var5/* $VF was: вѓxxx */, 0.0).a(0.625, 0.390625).d();
      var2/* $VF was: вѓx */.b(var3/* $VF was: вѓxx */, 0.0, 0.0).a(0.625, 0.0).d();
      var1/* $VF was: вѓ */.b();
   }

   @Override
   public void b(boolean var1) {
      this.at.a("display_update");
      this.g.c(this.w.U);
      this.at.c();
      if (var1/* $VF was: вѓ */ && this.aF()) {
         this.at.a("fpslimit_wait");
         this.g.c();
         this.at.c();
      }
   }

   @Override
   public void a() {
      int var1/* $VF was: вѓ */ = this.g.a(this.w.aK, this.f());
      this.g.a((double)var1/* $VF was: вѓ */);
      if (this.o != null) {
         this.o.resize(this, this.g.o(), this.g.p());
      }

      ctc var2/* $VF was: вѓx */ = this.c();
      if (var2/* $VF was: вѓx */ != null) {
         var2/* $VF was: вѓx */.a(this.g.j(), this.g.k(), a);
      }

      if (this.q != null) {
         this.q.a(this.g.j(), this.g.k());
      }

      if (this.x != null) {
         this.x.g();
      }
   }

   private int aE() {
      return this.h != null || this.o == null && this.p == null ? this.g.b() : 60;
   }

   private boolean aF() {
      return this.aE() < cva.h.c();
   }

   public void j() {
      try {
         e = new byte[0];
         this.i.l();
      } catch (Throwable var3) {
      }

      try {
         System.gc();
         if (this.A()) {
            this.ac.a(true);
         }

         this.b(new cyy(new jw("menu.savingLevel")));
      } catch (Throwable var2) {
      }

      System.gc();
   }

   void a(int var1) {
      afx var2/* $VF was: вѓ */ = this.at.d().c();
      List<afz> var3/* $VF was: вѓx */ = var2/* $VF was: вѓ */.a(this.bb);
      if (!var3/* $VF was: вѓx */.isEmpty()) {
         afz var4/* $VF was: вѓxx */ = var3/* $VF was: вѓx */.remove(0);
         if (var1/* $VF was: вѓ */ == 0) {
            if (!var4/* $VF was: вѓxx */.c.isEmpty()) {
               int var5/* $VF was: вѓxxx */ = this.bb.lastIndexOf(46);
               if (var5/* $VF was: вѓxxx */ >= 0) {
                  this.bb = this.bb.substring(0, var5/* $VF was: вѓxxx */);
               }
            }
         } else {
            var1/* $VF was: вѓ */--;
            if (var1/* $VF was: вѓ */ < var3/* $VF was: вѓx */.size() && !"unspecified".equals(var3/* $VF was: вѓx */.get(var1/* $VF was: вѓ */).c)) {
               if (!this.bb.isEmpty()) {
                  this.bb = this.bb + ".";
               }

               this.bb = this.bb + var3/* $VF was: вѓx */.get(var1/* $VF was: вѓ */).c;
            }
         }
      }
   }

   private void aG() {
      if (this.at.d().a()) {
         afx var1/* $VF was: вѓ */ = this.at.d().c();
         List<afz> var2/* $VF was: вѓx */ = var1/* $VF was: вѓ */.a(this.bb);
         afz var3/* $VF was: вѓxx */ = var2/* $VF was: вѓx */.remove(0);
         GlStateManager.clear(256, a);
         GlStateManager.matrixMode(5889);
         GlStateManager.enableColorMaterial();
         GlStateManager.loadIdentity();
         GlStateManager.ortho(0.0, this.g.j(), this.g.k(), 0.0, 1000.0, 3000.0);
         GlStateManager.matrixMode(5888);
         GlStateManager.loadIdentity();
         GlStateManager.translatef(0.0F, 0.0F, -2000.0F);
         GlStateManager.lineWidth(1.0F);
         GlStateManager.disableTexture();
         cuc var4/* $VF was: вѓxxx */ = cuc.a();
         ctz var5/* $VF was: вѓxxxx */ = var4/* $VF was: вѓxxx */.c();
         int var6/* $VF was: вѓxxxxx */ = 160;
         int var7/* $VF was: вѓxxxxxx */ = this.g.j() - 160 - 10;
         int var8/* $VF was: вѓxxxxxxx */ = this.g.k() - 320;
         GlStateManager.enableBlend();
         var5/* $VF was: вѓxxxx */.a(7, cub.l);
         var5/* $VF was: вѓxxxx */.b(var7/* $VF was: вѓxxxxxx */ - 176.0F, var8/* $VF was: вѓxxxxxxx */ - 96.0F - 16.0F, 0.0).b(200, 0, 0, 0).d();
         var5/* $VF was: вѓxxxx */.b(var7/* $VF was: вѓxxxxxx */ - 176.0F, var8/* $VF was: вѓxxxxxxx */ + 320, 0.0).b(200, 0, 0, 0).d();
         var5/* $VF was: вѓxxxx */.b(var7/* $VF was: вѓxxxxxx */ + 176.0F, var8/* $VF was: вѓxxxxxxx */ + 320, 0.0).b(200, 0, 0, 0).d();
         var5/* $VF was: вѓxxxx */.b(var7/* $VF was: вѓxxxxxx */ + 176.0F, var8/* $VF was: вѓxxxxxxx */ - 96.0F - 16.0F, 0.0).b(200, 0, 0, 0).d();
         var4/* $VF was: вѓxxx */.b();
         GlStateManager.disableBlend();
         double var9/* $VF was: вѓxxxxxxxx */ = 0.0;

         for (int var11/* $VF was: вѓxxxxxxxxx */ = 0; var11/* $VF was: вѓxxxxxxxxx */ < var2/* $VF was: вѓx */.size(); var11/* $VF was: вѓxxxxxxxxx */++) {
            afz var12/* $VF was: вѓxxxxxxxxxx */ = var2/* $VF was: вѓx */.get(var11/* $VF was: вѓxxxxxxxxx */);
            int var13/* $VF was: вѓxxxxxxxxxxx */ = zq.c(var12/* $VF was: вѓxxxxxxxxxx */.a / 4.0) + 1;
            var5/* $VF was: вѓxxxx */.a(6, cub.l);
            int var14/* $VF was: вѓxxxxxxxxxxxx */ = var12/* $VF was: вѓxxxxxxxxxx */.a();
            int var15/* $VF was: вѓxxxxxxxxxxxxx */ = var14/* $VF was: вѓxxxxxxxxxxxx */ >> 16 & 0xFF;
            int var16/* $VF was: вѓxxxxxxxxxxxxxx */ = var14/* $VF was: вѓxxxxxxxxxxxx */ >> 8 & 0xFF;
            int var17/* $VF was: вѓxxxxxxxxxxxxxxx */ = var14/* $VF was: вѓxxxxxxxxxxxx */ & 0xFF;
            var5/* $VF was: вѓxxxx */.b(var7/* $VF was: вѓxxxxxx */, var8/* $VF was: вѓxxxxxxx */, 0.0)
               .b(var15/* $VF was: вѓxxxxxxxxxxxxx */, var16/* $VF was: вѓxxxxxxxxxxxxxx */, var17/* $VF was: вѓxxxxxxxxxxxxxxx */, 255)
               .d();

            for (int var18/* $VF was: вѓxxxxxxxxxxxxxxxx */ = var13/* $VF was: вѓxxxxxxxxxxx */;
               var18/* $VF was: вѓxxxxxxxxxxxxxxxx */ >= 0;
               var18/* $VF was: вѓxxxxxxxxxxxxxxxx */--
            ) {
               float var19/* $VF was: вѓxxxxxxxxxxxxxxxxx */ = (float)(
                  (var9/* $VF was: вѓxxxxxxxx */ + var12/* $VF was: вѓxxxxxxxxxx */.a * var18/* $VF was: вѓxxxxxxxxxxxxxxxx */ / var13/* $VF was: вѓxxxxxxxxxxx */)
                     * (float) (Math.PI * 2)
                     / 100.0
               );
               float var20/* $VF was: вѓxxxxxxxxxxxxxxxxxx */ = zq.a(var19/* $VF was: вѓxxxxxxxxxxxxxxxxx */) * 160.0F;
               float var21/* $VF was: вѓxxxxxxxxxxxxxxxxxxx */ = zq.b(var19/* $VF was: вѓxxxxxxxxxxxxxxxxx */) * 160.0F * 0.5F;
               var5/* $VF was: вѓxxxx */.b(
                     var7/* $VF was: вѓxxxxxx */ + var20/* $VF was: вѓxxxxxxxxxxxxxxxxxx */,
                     var8/* $VF was: вѓxxxxxxx */ - var21/* $VF was: вѓxxxxxxxxxxxxxxxxxxx */,
                     0.0
                  )
                  .b(var15/* $VF was: вѓxxxxxxxxxxxxx */, var16/* $VF was: вѓxxxxxxxxxxxxxx */, var17/* $VF was: вѓxxxxxxxxxxxxxxx */, 255)
                  .d();
            }

            var4/* $VF was: вѓxxx */.b();
            var5/* $VF was: вѓxxxx */.a(5, cub.l);

            for (int var33/* $VF was: вѓxxxxxxxxxxxxxxxx */ = var13/* $VF was: вѓxxxxxxxxxxx */;
               var33/* $VF was: вѓxxxxxxxxxxxxxxxx */ >= 0;
               var33/* $VF was: вѓxxxxxxxxxxxxxxxx */--
            ) {
               float var34/* $VF was: вѓxxxxxxxxxxxxxxxxx */ = (float)(
                  (var9/* $VF was: вѓxxxxxxxx */ + var12/* $VF was: вѓxxxxxxxxxx */.a * var33/* $VF was: вѓxxxxxxxxxxxxxxxx */ / var13/* $VF was: вѓxxxxxxxxxxx */)
                     * (float) (Math.PI * 2)
                     / 100.0
               );
               float var35/* $VF was: вѓxxxxxxxxxxxxxxxxxx */ = zq.a(var34/* $VF was: вѓxxxxxxxxxxxxxxxxx */) * 160.0F;
               float var36/* $VF was: вѓxxxxxxxxxxxxxxxxxxx */ = zq.b(var34/* $VF was: вѓxxxxxxxxxxxxxxxxx */) * 160.0F * 0.5F;
               var5/* $VF was: вѓxxxx */.b(
                     var7/* $VF was: вѓxxxxxx */ + var35/* $VF was: вѓxxxxxxxxxxxxxxxxxx */,
                     var8/* $VF was: вѓxxxxxxx */ - var36/* $VF was: вѓxxxxxxxxxxxxxxxxxxx */,
                     0.0
                  )
                  .b(var15/* $VF was: вѓxxxxxxxxxxxxx */ >> 1, var16/* $VF was: вѓxxxxxxxxxxxxxx */ >> 1, var17/* $VF was: вѓxxxxxxxxxxxxxxx */ >> 1, 255)
                  .d();
               var5/* $VF was: вѓxxxx */.b(
                     var7/* $VF was: вѓxxxxxx */ + var35/* $VF was: вѓxxxxxxxxxxxxxxxxxx */,
                     var8/* $VF was: вѓxxxxxxx */ - var36/* $VF was: вѓxxxxxxxxxxxxxxxxxxx */ + 10.0F,
                     0.0
                  )
                  .b(var15/* $VF was: вѓxxxxxxxxxxxxx */ >> 1, var16/* $VF was: вѓxxxxxxxxxxxxxx */ >> 1, var17/* $VF was: вѓxxxxxxxxxxxxxxx */ >> 1, 255)
                  .d();
            }

            var4/* $VF was: вѓxxx */.b();
            var9/* $VF was: вѓxxxxxxxx */ += var12/* $VF was: вѓxxxxxxxxxx */.a;
         }

         DecimalFormat var22/* $VF was: вѓxxxxxxxxx */ = new DecimalFormat("##0.00");
         var22/* $VF was: вѓxxxxxxxxx */.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ROOT));
         GlStateManager.enableTexture();
         String var23/* $VF was: вѓxxxxxxxxxx */ = "";
         if (!"unspecified".equals(var3/* $VF was: вѓxx */.c)) {
            var23/* $VF was: вѓxxxxxxxxxx */ = var23/* $VF was: вѓxxxxxxxxxx */ + "[0] ";
         }

         if (var3/* $VF was: вѓxx */.c.isEmpty()) {
            var23/* $VF was: вѓxxxxxxxxxx */ = var23/* $VF was: вѓxxxxxxxxxx */ + "ROOT ";
         } else {
            var23/* $VF was: вѓxxxxxxxxxx */ = var23/* $VF was: вѓxxxxxxxxxx */ + var3/* $VF was: вѓxx */.c + ' ';
         }

         int var27/* $VF was: вѓxxxxxxxxxxx */ = 16777215;
         this.n.a(var23/* $VF was: вѓxxxxxxxxxx */, var7/* $VF was: вѓxxxxxx */ - 160, var8/* $VF was: вѓxxxxxxx */ - 80 - 16, 16777215);
         var23/* $VF was: вѓxxxxxxxxxx */ = var22/* $VF was: вѓxxxxxxxxx */.format(var3/* $VF was: вѓxx */.b) + "%";
         this.n
            .a(
               var23/* $VF was: вѓxxxxxxxxxx */,
               var7/* $VF was: вѓxxxxxx */ + 160 - this.n.b(var23/* $VF was: вѓxxxxxxxxxx */),
               var8/* $VF was: вѓxxxxxxx */ - 80 - 16,
               16777215
            );

         for (int var26/* $VF was: вѓxxxxxxxxxxxx */ = 0; var26/* $VF was: вѓxxxxxxxxxxxx */ < var2/* $VF was: вѓx */.size(); var26/* $VF was: вѓxxxxxxxxxxxx */++) {
            afz var28/* $VF was: вѓxxxxxxxxxxxxx */ = var2/* $VF was: вѓx */.get(var26/* $VF was: вѓxxxxxxxxxxxx */);
            StringBuilder var29/* $VF was: вѓxxxxxxxxxxxxxx */ = new StringBuilder();
            if ("unspecified".equals(var28/* $VF was: вѓxxxxxxxxxxxxx */.c)) {
               var29/* $VF was: вѓxxxxxxxxxxxxxx */.append("[?] ");
            } else {
               var29/* $VF was: вѓxxxxxxxxxxxxxx */.append("[").append(var26/* $VF was: вѓxxxxxxxxxxxx */ + 1).append("] ");
            }

            String var30/* $VF was: вѓxxxxxxxxxxxxxxx */ = var29/* $VF was: вѓxxxxxxxxxxxxxx */.append(var28/* $VF was: вѓxxxxxxxxxxxxx */.c).toString();
            this.n
               .a(
                  var30/* $VF was: вѓxxxxxxxxxxxxxxx */,
                  var7/* $VF was: вѓxxxxxx */ - 160,
                  var8/* $VF was: вѓxxxxxxx */ + 80 + var26/* $VF was: вѓxxxxxxxxxxxx */ * 8 + 20,
                  var28/* $VF was: вѓxxxxxxxxxxxxx */.a()
               );
            var30/* $VF was: вѓxxxxxxxxxxxxxxx */ = var22/* $VF was: вѓxxxxxxxxx */.format(var28/* $VF was: вѓxxxxxxxxxxxxx */.a) + "%";
            this.n
               .a(
                  var30/* $VF was: вѓxxxxxxxxxxxxxxx */,
                  var7/* $VF was: вѓxxxxxx */ + 160 - 50 - this.n.b(var30/* $VF was: вѓxxxxxxxxxxxxxxx */),
                  var8/* $VF was: вѓxxxxxxx */ + 80 + var26/* $VF was: вѓxxxxxxxxxxxx */ * 8 + 20,
                  var28/* $VF was: вѓxxxxxxxxxxxxx */.a()
               );
            var30/* $VF was: вѓxxxxxxxxxxxxxxx */ = var22/* $VF was: вѓxxxxxxxxx */.format(var28/* $VF was: вѓxxxxxxxxxxxxx */.b) + "%";
            this.n
               .a(
                  var30/* $VF was: вѓxxxxxxxxxxxxxxx */,
                  var7/* $VF was: вѓxxxxxx */ + 160 - this.n.b(var30/* $VF was: вѓxxxxxxxxxxxxxxx */),
                  var8/* $VF was: вѓxxxxxxx */ + 80 + var26/* $VF was: вѓxxxxxxxxxxxx */ * 8 + 20,
                  var28/* $VF was: вѓxxxxxxxxxxxxx */.a()
               );
         }
      }
   }

   public void k() {
      if (this.aZ) {
         this.aP = false;
      } else {
         GLFW.glfwSetWindowShouldClose(this.g.h(), false);
         if (!this.aY) {
            this.e(() -> {
               this.aC();
               this.a(new cyw(this));
               this.aZ = true;
            });
         }

         this.aY = true;
      }
   }

   public void l() {
      if (this.o == null) {
         this.a(new czj());
         if (this.A() && !this.ac.ae()) {
            this.aC.b();
         }
      }
   }

   private void e(boolean var1) {
      if (!var1/* $VF was: вѓ */) {
         this.s = 0;
      }

      if (this.s <= 0 && !this.j.de()) {
         if (var1/* $VF was: вѓ */ && this.v != null && this.v.c() == CuxCompileFixes.modeB()) {
            crg var2/* $VF was: вѓ */ = (crg)this.v;
            ev var3/* $VF was: вѓx */ = var2/* $VF was: вѓ */.a();
            if (!this.h.e_(var3/* $VF was: вѓx */).i()) {
               fa var4/* $VF was: вѓxx */ = var2/* $VF was: вѓ */.b();
               if (this.f.b(var3/* $VF was: вѓx */, var4/* $VF was: вѓxx */)) {
                  this.m.a(var3/* $VF was: вѓx */, var4/* $VF was: вѓxx */);
                  this.j.a(agt.a);
               }
            }
         } else {
            this.f.b();
         }
      }
   }

   private void aH() {
      if (this.s <= 0) {
         if (this.v == null) {
            G.error("Null returned as 'hitResult', this shouldn't happen!");
            if (this.f.f()) {
               this.s = 10;
            }
         } else if (!this.j.I()) {
            switch (this.v.c()) {
               case c:
                  this.f.a(this.j, ((crh)this.v).a());
                  break;
               case b:
                  crg var1/* $VF was: вѓ */ = (crg)this.v;
                  ev var2/* $VF was: вѓx */ = var1/* $VF was: вѓ */.a();
                  if (!this.h.e_(var2/* $VF was: вѓx */).i()) {
                     this.f.a(var2/* $VF was: вѓx */, var1/* $VF was: вѓ */.b());
                     break;
                  }
               case a:
                  if (this.f.f()) {
                     this.s = 10;
                  }

                  this.j.dV();
            }

            this.j.a(agt.a);
         }
      }
   }

   private void aI() {
      if (!this.f.l()) {
         this.al = 4;
         if (!this.j.I()) {
            if (this.v == null) {
               G.warn("Null returned as 'hitResult', this shouldn't happen!");
            }

            for (agt var4/* $VF was: вѓ */ : agt.values()) {
               bbp var5/* $VF was: вѓx */ = this.j.b(var4/* $VF was: вѓ */);
               if (this.v != null) {
                  switch (this.v.c()) {
                     case c:
                        crh var6/* $VF was: вѓxx */ = (crh)this.v;
                        ahz var7/* $VF was: вѓxxx */ = var6/* $VF was: вѓxx */.a();
                        if (this.f.a(this.j, var7/* $VF was: вѓxxx */, var6/* $VF was: вѓxx */, var4/* $VF was: вѓ */) == agu.a) {
                           return;
                        }

                        if (this.f.a(this.j, var7/* $VF was: вѓxxx */, var4/* $VF was: вѓ */) == agu.a) {
                           return;
                        }
                        break;
                     case b:
                        crg var8/* $VF was: вѓxx */ = (crg)this.v;
                        int var9/* $VF was: вѓxxx */ = var5/* $VF was: вѓx */.D();
                        agu var10/* $VF was: вѓxxxx */ = this.f.a(this.j, this.h, var4/* $VF was: вѓ */, var8/* $VF was: вѓxx */);
                        if (var10/* $VF was: вѓxxxx */ == agu.a) {
                           this.j.a(var4/* $VF was: вѓ */);
                           if (!var5/* $VF was: вѓx */.a() && (var5/* $VF was: вѓx */.D() != var9/* $VF was: вѓxxx */ || this.f.g())) {
                              this.q.a.a(var4/* $VF was: вѓ */);
                           }

                           return;
                        }

                        if (var10/* $VF was: вѓxxxx */ == agu.c) {
                           return;
                        }
                  }
               }

               if (!var5/* $VF was: вѓx */.a() && this.f.a(this.j, this.h, var4/* $VF was: вѓ */) == agu.a) {
                  this.q.a.a(var4/* $VF was: вѓ */);
                  return;
               }
            }
         }
      }
   }

   public dxm m() {
      return this.aD;
   }

   public void n() {
      if (this.al > 0) {
         this.al--;
      }

      this.at.a("gui");
      if (!this.aa) {
         this.t.e();
      }

      this.at.c();
      this.q.a(1.0F);
      this.aS.a(this.h, this.v);
      this.at.a("gameMode");
      if (!this.aa && this.h != null) {
         this.f.d();
      }

      this.at.b("textures");
      if (this.h != null) {
         this.M.e();
      }

      if (this.o == null && this.j != null) {
         if (this.j.cy() <= 0.0F && !(this.o instanceof cym)) {
            this.a((czn)null);
         } else if (this.j.dt() && this.h != null) {
            this.a(new cyz());
         }
      } else if (this.o != null && this.o instanceof cyz && !this.j.dt()) {
         this.a((czn)null);
      }

      if (this.o != null) {
         this.s = 10000;
      }

      if (this.o != null) {
         czn.wrapScreenError(() -> this.o.tick(), "Ticking screen", this.o.getClass().getCanonicalName());
      }

      if (!this.w.aD) {
         this.t.m();
      }

      if (this.p == null && (this.o == null || this.o.passEvents)) {
         this.at.b("GLFW events");
         GLX.pollEvents();
         this.aJ();
         if (this.s > 0) {
            this.s--;
         }
      }

      if (this.h != null) {
         this.at.b("gameRenderer");
         if (!this.aa) {
            this.q.e();
         }

         this.at.b("levelRenderer");
         if (!this.aa) {
            this.i.k();
         }

         this.at.b("level");
         if (!this.aa) {
            if (this.h.X() > 0) {
               this.h.c(this.h.X() - 1);
            }

            this.h.d();
         }
      } else if (this.q.a()) {
         this.q.b();
      }

      if (!this.aa && !(this.o instanceof czd)) {
         this.aD.a();
      }

      this.aC.a(this.aa);
      if (this.h != null) {
         if (!this.aa) {
            this.h.a(this.h.ab() != agr.a, true);
            this.aS.d();

            try {
               this.h.a(() -> true);
            } catch (Throwable var4/* $VF was: вѓ */) {
               d var2/* $VF was: вѓx */ = CuxCompileFixes.crashReport(var4/* $VF was: вѓ */, "Exception in world tick");
               if (this.h == null) {
                  e var3/* $VF was: вѓxx */ = var2/* $VF was: вѓx */.a("Affected level");
                  var3/* $VF was: вѓxx */.a("Problem", "Level is null!");
               } else {
                  this.h.a(var2/* $VF was: вѓx */);
               }

               throw new m(var2/* $VF was: вѓx */);
            }
         }

         this.at.b("animateTick");
         if (!this.aa && this.h != null) {
            this.h.a(zq.c(this.j.p), zq.c(this.j.q), zq.c(this.j.r));
         }

         this.at.b("particles");
         if (!this.aa) {
            this.m.b();
         }
      } else if (this.ar != null) {
         this.at.b("pendingConnection");
         this.ar.a();
      }

      this.at.b("keyboard");
      this.y.b();
      this.at.c();
   }

   private void aJ() {
      while (this.w.an.f()) {
         this.w.aC++;
         if (this.w.aC > 2) {
            this.w.aC = 0;
         }

         if (this.w.aC == 0) {
            this.q.a(this.U());
         } else if (this.w.aC == 1) {
            this.q.a((ahz)null);
         }

         this.i.n();
      }

      while (this.w.ao.f()) {
         this.w.aH = !this.w.aH;
      }

      for (int var1/* $VF was: вѓ */ = 0; var1/* $VF was: вѓ */ < 9; var1/* $VF was: вѓ */++) {
         boolean var2/* $VF was: вѓx */ = this.w.aw.d();
         boolean var3/* $VF was: вѓxx */ = this.w.ax.d();
         if (this.w.av[var1/* $VF was: вѓ */].f()) {
            if (this.j.t()) {
               this.t.i().a(var1/* $VF was: вѓ */);
            } else if (!this.j.u() || this.o != null || !var3/* $VF was: вѓxx */ && !var2/* $VF was: вѓx */) {
               this.j.bx.d = var1/* $VF was: вѓ */;
            } else {
               dau.a(this, var1/* $VF was: вѓ */, var3/* $VF was: вѓxx */, var2/* $VF was: вѓx */);
            }
         }
      }

      while (this.w.ad.f()) {
         if (this.f.i()) {
            this.j.z();
         } else {
            this.aS.a();
            this.a(new dbd(this.j));
         }
      }

      while (this.w.ar.f()) {
         this.a(new dab(this.j.e.g()));
      }

      while (this.w.ae.f()) {
         if (!this.j.t()) {
            this.r().a(new oo(oo.a.g, ev.a, fa.a));
         }
      }

      while (this.w.af.f()) {
         if (!this.j.t()) {
            this.j.n(czn.hasControlDown());
         }
      }

      boolean var4/* $VF was: вѓ */ = this.w.j != avk.c;
      if (var4/* $VF was: вѓ */) {
         while (this.w.aj.f()) {
            this.a(new cye(""));
         }

         if (this.o == null && this.p == null && this.w.al.f()) {
            this.a(new cye("/"));
         }
      }

      if (this.j.de()) {
         if (!this.w.ag.d()) {
            this.f.b(this.j);
         }

         while (this.w.ah.f()) {
         }

         while (this.w.ag.f()) {
         }

         while (this.w.ai.f()) {
         }
      } else {
         while (this.w.ah.f()) {
            this.aH();
         }

         while (this.w.ag.f()) {
            this.aI();
         }

         while (this.w.ai.f()) {
            this.aK();
         }
      }

      if (this.w.ag.d() && this.al == 0 && !this.j.de()) {
         this.aI();
      }

      this.e(this.o == null && this.w.ah.d() && this.x.h());
   }

   public void a(String var1, String var2, @Nullable bhb var3) {
      this.o();
      cnp var4/* $VF was: вѓ */ = this.aj.a(var1/* $VF was: вѓ */, (MinecraftServer)null);
      cno var5/* $VF was: вѓx */ = var4/* $VF was: вѓ */.c();
      if (var5/* $VF was: вѓx */ == null && var3/* $VF was: вѓ */ != null) {
         var5/* $VF was: вѓx */ = new cno(var3/* $VF was: вѓ */, var1/* $VF was: вѓ */);
         var4/* $VF was: вѓ */.a(var5/* $VF was: вѓx */);
      }

      if (var3/* $VF was: вѓ */ == null) {
         var3/* $VF was: вѓ */ = new bhb(var5/* $VF was: вѓx */);
      }

      this.ad.set(null);

      try {
         YggdrasilAuthenticationService var6/* $VF was: вѓxx */ = new YggdrasilAuthenticationService(this.ai, UUID.randomUUID().toString());
         MinecraftSessionService var13/* $VF was: вѓxxx */ = var6/* $VF was: вѓxx */.createMinecraftSessionService();
         GameProfileRepository var15/* $VF was: вѓxxxx */ = var6/* $VF was: вѓxx */.createProfileRepository();
         xk var9/* $VF was: вѓxxxxx */ = new xk(var15/* $VF was: вѓxxxx */, new File(this.z, MinecraftServer.b.getName()));
         bty.a(var9/* $VF was: вѓxxxxx */);
         bty.a(var13/* $VF was: вѓxxx */);
         xk.a(false);
         this.ac = new dxe(
            this,
            var1/* $VF was: вѓ */,
            var2/* $VF was: вѓ */,
            var3/* $VF was: вѓ */,
            var6/* $VF was: вѓxx */,
            var13/* $VF was: вѓxxx */,
            var15/* $VF was: вѓxxxx */,
            var9/* $VF was: вѓxxxxx */,
            var1x -> {
               vr timer/* $VF was: вѓxxxxxx */ = new vr(var1x + 0);
                timer.a();
                this.ad.set(timer);
                return new vq(timer, this.aU::add);
            }
         );
         this.ac.v();
         this.as = true;
      } catch (Throwable var11/* $VF was: вѓxx */) {
         d var7/* $VF was: вѓxxx */ = CuxCompileFixes.crashReport(var11/* $VF was: вѓxx */, "Starting integrated server");
         e var8/* $VF was: вѓxxxx */ = var7/* $VF was: вѓxxx */.a("Starting integrated server");
         var8/* $VF was: вѓxxxx */.a("Level ID", var1/* $VF was: вѓ */);
         var8/* $VF was: вѓxxxx */.a("Level Name", var2/* $VF was: вѓ */);
         throw new m(var7/* $VF was: вѓxxx */);
      }

      while (this.ad.get() == null) {
         Thread.yield();
      }

      czb var12/* $VF was: вѓxx */ = new czb(this.ad.get());
      this.a(var12/* $VF was: вѓxx */);

      while (!this.ac.ag()) {
         var12/* $VF was: вѓxx */.tick();
         this.d(false);

         try {
            Thread.sleep(16L);
         } catch (InterruptedException var10) {
         }

         if (this.Q && this.R != null) {
            this.c(this.R);
            return;
         }
      }

      SocketAddress var14/* $VF was: вѓxxx */ = this.ac.af().a();
      ja var16/* $VF was: вѓxxxx */ = ja.a(var14/* $VF was: вѓxxx */);
      var16/* $VF was: вѓxxxx */.a(new dhd(var16/* $VF was: вѓxxxx */, this, null, var0 -> {}));
      var16/* $VF was: вѓxxxx */.a(new pj(var14/* $VF was: вѓxxx */.toString(), 0, jb.d));
      var16/* $VF was: вѓxxxx */.a(new pu(this.D().e()));
      this.ar = var16/* $VF was: вѓxxxx */;
   }

   public void a(dhh var1) {
      czl var2/* $VF was: вѓ */ = new czl();
      var2/* $VF was: вѓ */.a(new jw("connect.joining"));
      this.c(var2/* $VF was: вѓ */);
      this.h = var1/* $VF was: вѓ */;
      this.b(var1/* $VF was: вѓ */);
      if (!this.as) {
         AuthenticationService var3/* $VF was: вѓx */ = new YggdrasilAuthenticationService(this.ai, UUID.randomUUID().toString());
         MinecraftSessionService var4/* $VF was: вѓxx */ = var3/* $VF was: вѓx */.createMinecraftSessionService();
         GameProfileRepository var5/* $VF was: вѓxxx */ = var3/* $VF was: вѓx */.createProfileRepository();
         xk var6/* $VF was: вѓxxxx */ = new xk(var5/* $VF was: вѓxxx */, new File(this.z, MinecraftServer.b.getName()));
         bty.a(var6/* $VF was: вѓxxxx */);
         bty.a(var4/* $VF was: вѓxx */);
         xk.a(false);
      }
   }

   public void o() {
      this.b(new czl());
   }

   public void b(czn var1) {
      dhe var2/* $VF was: вѓ */ = this.r();
      if (var2/* $VF was: вѓ */ != null) {
         this.be();
         var2/* $VF was: вѓ */.c();
      }

      dxe var3/* $VF was: вѓx */ = this.ac;
      this.ac = null;
      this.q.j();
      this.f = null;
      cvu.b.b();
      this.c(var1/* $VF was: вѓ */);
      if (this.h != null) {
         if (var3/* $VF was: вѓx */ != null) {
            while (!var3/* $VF was: вѓx */.w()) {
               this.d(false);
            }
         }

         this.av.c();
         this.t.k();
         this.a((dhk)null);
         this.as = false;
         this.aO.b();
      }

      this.h = null;
      this.b((dhh)null);
      this.j = null;
   }

   private void c(czn var1) {
      this.aD.b();
      this.aC.c();
      this.k = null;
      this.ar = null;
      this.a(var1/* $VF was: вѓ */);
      this.d(false);
   }

   private void b(@Nullable dhh var1) {
      if (this.i != null) {
         this.i.a(var1/* $VF was: вѓ */);
      }

      if (this.m != null) {
         this.m.a(var1/* $VF was: вѓ */);
      }

      dmg.a.a(var1/* $VF was: вѓ */);
   }

   public final boolean q() {
      return this.aq;
   }

   @Nullable
   public dhe r() {
      return this.j == null ? null : this.j.e;
   }

   public static boolean s() {
      return N == null || !N.w.aB;
   }

   public static boolean t() {
      return N != null && N.w.f;
   }

   public static boolean u() {
      return N != null && N.w.g != cuk.a;
   }

   private void aK() {
      if (this.v != null && this.v.c() != CuxCompileFixes.modeA()) {
         boolean var1/* $VF was: вѓ */ = this.j.bN.d;
         btb var2/* $VF was: вѓx */ = null;
         cri.a var4/* $VF was: вѓxx */ = this.v.c();
         bbp var3/* $VF was: вѓxxx */;
         if (var4/* $VF was: вѓxx */ == CuxCompileFixes.modeB()) {
            ev var5/* $VF was: вѓxxxx */ = ((crg)this.v).a();
            buy var6/* $VF was: вѓxxxxx */ = this.h.e_(var5/* $VF was: вѓxxxx */);
            bma var7/* $VF was: вѓxxxxxx */ = var6/* $VF was: вѓxxxxx */.d();
            if (var6/* $VF was: вѓxxxxx */.i()) {
               return;
            }

            var3/* $VF was: РІВС“xxx */ = var7/* $VF was: РІВС“xxxxxx */.a((bgi)this.h, var5, var6);
            if (var3/* $VF was: вѓxxx */.a()) {
               return;
            }

            if (var1/* $VF was: вѓ */ && czn.hasControlDown() && var7/* $VF was: вѓxxxxxx */.h()) {
               var2/* $VF was: вѓx */ = this.h.d(var5/* $VF was: вѓxxxx */);
            }
         } else {
            if (var4/* $VF was: вѓxx */ != CuxCompileFixes.modeC() || !var1/* $VF was: вѓ */) {
               return;
            }

            ahz var8/* $VF was: вѓxxxx */ = ((crh)this.v).a();
            if (var8/* $VF was: вѓxxxx */ instanceof asx) {
               var3/* $VF was: вѓxxx */ = new bbp(bbq.ko);
            } else if (var8/* $VF was: вѓxxxx */ instanceof asv) {
               var3/* $VF was: вѓxxx */ = new bbp(bbq.oq);
            } else if (var8/* $VF was: вѓxxxx */ instanceof asu) {
               asu var11/* $VF was: вѓxxxxx */ = (asu)var8/* $VF was: вѓxxxx */;
               bbp var15/* $VF was: вѓxxxxxx */ = var11/* $VF was: вѓxxxxx */.o();
               if (var15/* $VF was: вѓxxxxxx */.a()) {
                  var3/* $VF was: вѓxxx */ = new bbp(bbq.nG);
               } else {
                  var3/* $VF was: вѓxxx */ = var15/* $VF was: вѓxxxxxx */.i();
               }
            } else if (var8/* $VF was: вѓxxxx */ instanceof axa) {
               axa var12/* $VF was: вѓxxxxx */ = (axa)var8/* $VF was: вѓxxxx */;
               bbk var16/* $VF was: вѓxxxxxx */;
               switch (var12/* $VF was: вѓxxxxx */.o()) {
                  case c:
                     var16/* $VF was: вѓxxxxxx */ = bbq.kV;
                     break;
                  case b:
                     var16/* $VF was: вѓxxxxxx */ = bbq.kU;
                     break;
                  case d:
                     var16/* $VF was: вѓxxxxxx */ = bbq.oc;
                     break;
                  case f:
                     var16/* $VF was: вѓxxxxxx */ = bbq.od;
                     break;
                  case g:
                     var16/* $VF was: вѓxxxxxx */ = bbq.os;
                     break;
                  default:
                     var16/* $VF was: вѓxxxxxx */ = bbq.kA;
               }

               var3/* $VF was: вѓxxx */ = new bbp(var16/* $VF was: вѓxxxxxx */);
            } else if (var8/* $VF was: вѓxxxx */ instanceof axc) {
               var3/* $VF was: вѓxxx */ = new bbp(((axc)var8/* $VF was: вѓxxxx */).f());
            } else if (var8/* $VF was: вѓxxxx */ instanceof ass) {
               var3/* $VF was: вѓxxx */ = new bbp(bbq.ol);
            } else if (var8/* $VF was: вѓxxxx */ instanceof arv) {
               var3/* $VF was: вѓxxx */ = new bbp(bbq.oL);
            } else {
               bco var13/* $VF was: вѓxxxxx */ = bco.a(var8/* $VF was: вѓxxxx */.S());
               if (var13/* $VF was: вѓxxxxx */ == null) {
                  return;
               }

               var3/* $VF was: вѓxxx */ = new bbp(var13/* $VF was: вѓxxxxx */);
            }
         }

         if (var3/* $VF was: вѓxxx */.a()) {
            String var10/* $VF was: вѓxxxx */ = "";
            if (var4/* $VF was: вѓxx */ == CuxCompileFixes.modeB()) {
               var10/* $VF was: вѓxxxx */ = fm.j.b(this.h.e_(((crg)this.v).a()).d()).toString();
            } else if (var4/* $VF was: вѓxx */ == CuxCompileFixes.modeC()) {
               var10/* $VF was: вѓxxxx */ = fm.l.b(((crh)this.v).a().S()).toString();
            }

            G.warn("Picking on: [{}] {} gave null item", var4/* $VF was: вѓxx */, var10/* $VF was: вѓxxxx */);
         } else {
            avl var9/* $VF was: вѓxxxx */ = this.j.bx;
            if (var2/* $VF was: вѓx */ != null) {
               this.a(var3/* $VF was: вѓxxx */, var2/* $VF was: вѓx */);
            }

            int var14/* $VF was: вѓxxxxx */ = var9/* $VF was: вѓxxxx */.b(var3/* $VF was: вѓxxx */);
            if (var1/* $VF was: вѓ */) {
               var9/* $VF was: вѓxxxx */.a(var3/* $VF was: вѓxxx */);
               this.f.a(this.j.b(agt.a), 36 + var9/* $VF was: вѓxxxx */.d);
            } else if (var14/* $VF was: вѓxxxxx */ != -1) {
               if (avl.d(var14/* $VF was: вѓxxxxx */)) {
                  var9/* $VF was: вѓxxxx */.d = var14/* $VF was: вѓxxxxx */;
               } else {
                  this.f.a(var14/* $VF was: вѓxxxxx */);
               }
            }
         }
      }
   }

   private bbp a(bbp var1, btb var2) {
      ib var3/* $VF was: вѓ */ = var2/* $VF was: вѓ */.b(new ib());
      if (var1/* $VF was: вѓ */.b() instanceof bca && var3/* $VF was: вѓ */.e("Owner")) {
         ib var6/* $VF was: вѓx */ = var3/* $VF was: вѓ */.p("Owner");
         var1/* $VF was: вѓ */.p().a("SkullOwner", var6/* $VF was: вѓx */);
         return var1/* $VF was: вѓ */;
      } else {
         var1/* $VF was: вѓ */.a("BlockEntityTag", var3/* $VF was: вѓ */);
         ib var4/* $VF was: вѓx */ = new ib();
         ii var5/* $VF was: вѓxx */ = new ii();
         var5/* $VF was: вѓxx */.add(new ir("\"(+NBT)\""));
         var4/* $VF was: вѓx */.a("Lore", var5/* $VF was: вѓxx */);
         var1/* $VF was: вѓ */.a("display", var4/* $VF was: вѓx */);
         return var1/* $VF was: вѓ */;
      }
   }

   public d b(d var1) {
      e var2/* $VF was: вѓ */ = var1/* $VF was: вѓ */.g();
      var2/* $VF was: вѓ */.a("Launched Version", () -> this.ag);
      var2/* $VF was: вѓ */.a("LWJGL", GLX::getLWJGLVersion);
      var2/* $VF was: вѓ */.a("OpenGL", GLX::getOpenGLVersionString);
      var2/* $VF was: вѓ */.a("GL Caps", GLX::getCapsString);
      var2/* $VF was: вѓ */.a("Using VBOs", () -> "Yes");
      var2/* $VF was: вѓ */.a(
         "Is Modded",
         () -> {
            String var0/* $VF was: вѓx */ = ClientBrandRetriever.getClientModName();
            if (!"vanilla".equals(var0/* $VF was: вѓx */)) {
               return "Definitely; Client brand changed to '" + var0/* $VF was: вѓx */ + "'";
            } else {
               return cux.class.getSigners() == null
                  ? "Very likely; Jar signature invalidated"
                  : "Probably not. Jar signature remains and client brand is untouched.";
            }
         }
      );
      var2/* $VF was: вѓ */.a("Type", "Client (map_client.txt)");
      var2/* $VF was: вѓ */.a("Resource Packs", () -> {
         StringBuilder resourcePacksBuilder = new StringBuilder();

         for (String var3/* $VF was: вѓx */ : this.w.h) {
            if (resourcePacksBuilder.length() > 0) {
               resourcePacksBuilder.append(", ");
            }

            resourcePacksBuilder.append(var3/* $VF was: вѓx */);
            if (this.w.i.contains(var3/* $VF was: вѓx */)) {
               resourcePacksBuilder.append(" (incompatible)");
            }
         }

         return resourcePacksBuilder.toString();
      });
      var2/* $VF was: вѓ */.a("Current Language", () -> this.ax.b().toString());
      var2/* $VF was: вѓ */.a("CPU", GLX::getCpuInfo);
      if (this.h != null) {
         this.h.a(var1/* $VF was: вѓ */);
      }

      return var1/* $VF was: вѓ */;
   }

   public static cux v() {
      return N;
   }

   public CompletableFuture<Void> w() {
      return this.a((java.util.function.Supplier<CompletableFuture<Void>>)this::g).thenCompose(var0 -> var0);
   }

   @Override
   public void a(ahb var1) {
      var1/* $VF was: вѓ */.a("fps", ak);
      var1/* $VF was: вѓ */.a("vsync_enabled", this.w.K);
      int var2/* $VF was: вѓ */ = GLX.getRefreshRate(this.g);
      var1/* $VF was: вѓ */.a("display_frequency", var2/* $VF was: вѓ */);
      var1/* $VF was: вѓ */.a("display_type", this.g.i() ? "fullscreen" : "windowed");
      var1/* $VF was: вѓ */.a("run_time", (CuxCompileFixes.timeB() - var1/* $VF was: вѓ */.g()) / 60L * 1000L);
      var1/* $VF was: вѓ */.a("current_action", this.aL());
      var1/* $VF was: вѓ */.a("language", this.w.aN == null ? "en_us" : this.w.aN);
      String var3/* $VF was: вѓx */ = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN ? "little" : "big";
      var1/* $VF was: вѓ */.a("endianness", var3/* $VF was: вѓx */);
      var1/* $VF was: вѓ */.a("subtitles", this.w.R);
      var1/* $VF was: вѓ */.a("touch", this.w.T ? "touch" : "mouse");
      int var4/* $VF was: вѓxx */ = 0;

      for (duz var6/* $VF was: вѓxxx */ : this.aw.d()) {
         if (!var6/* $VF was: вѓxxx */.f() && !var6/* $VF was: вѓxxx */.g()) {
            var1/* $VF was: вѓ */.a("resource_pack[" + var4/* $VF was: вѓxx */++ + "]", var6/* $VF was: вѓxxx */.e());
         }
      }

      var1/* $VF was: вѓ */.a("resource_packs", var4/* $VF was: вѓxx */);
      if (this.ac != null && this.ac.ak() != null) {
         var1/* $VF was: вѓ */.a("snooper_partner", this.ac.ak().f());
      }
   }

   private String aL() {
      if (this.ac != null) {
         return this.ac.ae() ? "hosting_lan" : "singleplayer";
      } else if (this.L != null) {
         return this.L.d() ? "playing_lan" : "multiplayer";
      } else {
         return "out_of_game";
      }
   }

   public static int x() {
      if (H == -1) {
         for (int var0/* $VF was: вѓ */ = 16384; var0/* $VF was: вѓ */ > 0; var0/* $VF was: вѓ */ >>= 1) {
            GlStateManager.texImage2D(32868, 0, 6408, var0/* $VF was: вѓ */, var0/* $VF was: вѓ */, 0, 6408, 5121, null);
            int var1/* $VF was: вѓx */ = GlStateManager.getTexLevelParameter(32868, 0, 4096);
            if (var1/* $VF was: вѓx */ != 0) {
               H = var0/* $VF was: вѓ */;
               return var0/* $VF was: вѓ */;
            }
         }
      }

      return H;
   }

   public void a(dhk var1) {
      this.L = var1/* $VF was: вѓ */;
   }

   @Nullable
   public dhk y() {
      return this.L;
   }

   public boolean z() {
      return this.as;
   }

   public boolean A() {
      return this.as && this.ac != null;
   }

   @Nullable
   public dxe B() {
      return this.ac;
   }

   public ahb C() {
      return this.U;
   }

   public cvi D() {
      return this.Z;
   }

   public PropertyMap E() {
      if (this.J.isEmpty()) {
         GameProfile var1/* $VF was: вѓ */ = this.S().fillProfileProperties(this.Z.e(), false);
         this.J.putAll(var1/* $VF was: вѓ */.getProperties());
      }

      return this.J;
   }

   public Proxy F() {
      return this.ai;
   }

   public duf G() {
      return this.M;
   }

   public xc H() {
      return this.au;
   }

   public wr<duz> I() {
      return this.aw;
   }

   public dum J() {
      return this.av;
   }

   public File K() {
      return this.I;
   }

   public dvc L() {
      return this.ax;
   }

   public dud M() {
      return this.aB;
   }

   public boolean N() {
      return this.ap;
   }

   public boolean O() {
      return this.aa;
   }

   public dxr P() {
      return this.aC;
   }

   public dxm.a R() {
      if (this.o instanceof czt) {
         return dxm.a.d;
      } else if (this.j == null) {
         return dxm.a.a;
      } else if (this.j.l.q instanceof bxt) {
         return dxm.a.e;
      } else if (this.j.l.q instanceof bxx) {
         return this.t.l().d() ? dxm.a.f : dxm.a.g;
      } else {
         bhu$b var1/* $VF was: вѓ */ = this.j.l.c(new ev(this.j.p, this.j.q, this.j.r)).o();
         if (!this.aD.b(dxm.a.h) && (!this.j.av() || this.aD.b(dxm.a.b) || var1.ordinal() != 11 && var1.ordinal() != 13)) {
            return this.j.bN.d && this.j.bN.c ? dxm.a.c : dxm.a.b;
         } else {
            return dxm.a.h;
         }
      }
   }

   public MinecraftSessionService S() {
      return this.aG;
   }

   public duw T() {
      return this.aH;
   }

   @Nullable
   public ahz U() {
      return this.k;
   }

   public void a(ahz var1) {
      this.k = var1/* $VF was: вѓ */;
      this.q.a(var1/* $VF was: вѓ */);
   }

   @Override
   protected Thread ax() {
      return this.aI;
   }

   @Override
   protected Runnable d(Runnable var1) {
      return var1/* $VF was: вѓ */;
   }

   @Override
   protected boolean c(Runnable var1) {
      return true;
   }

   public dky V() {
      return this.aK;
   }

   public dpc W() {
      return this.V;
   }

   public dpx X() {
      return this.W;
   }

   public dkg Y() {
      return this.X;
   }

   public <T> dww<T> a(dwz.a<T> var1) {
      return this.Y.a(var1/* $VF was: вѓ */);
   }

   public static int Z() {
      return ak;
   }

   public zj aa() {
      return this.A;
   }

   public boolean ab() {
      return this.S;
   }

   public void c(boolean var1) {
      this.S = var1/* $VF was: вѓ */;
   }

   public DataFixer ac() {
      return this.O;
   }

   public float ad() {
      return 0.0F;
   }

   public float ae() {
      return this.T.c;
   }

   public cvk af() {
      return this.ay;
   }

   public boolean ah() {
      return this.j != null && this.j.dR() || this.w.P;
   }

   public cxg ai() {
      return this.aN;
   }

   public dyb aj() {
      return this.aS;
   }

   public boolean ak() {
      return this.aT;
   }

   public cuu al() {
      return this.ae;
   }

   public dvw am() {
      return this.aJ;
   }

   public cxk an() {
      return this.aE;
   }

   public duv ao() {
      return this.aL;
   }

   public duu ap() {
      return this.aM;
   }

   @Override
   public void a(boolean var1) {
      this.aT = var1/* $VF was: вѓ */;
   }

   public afy aq() {
      return this.at;
   }

   public cus ar() {
      return this.aO;
   }

   public dux at() {
      return this.aF;
   }

   @Nullable
   public czi au() {
      return this.p;
   }
}


