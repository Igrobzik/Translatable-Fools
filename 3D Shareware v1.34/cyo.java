public class cyo extends czn {
   private static final bhb a = new bhb("North Carolina".hashCode(), bgu.b, true, false, bhe.b).a();
   private cyo.a b;
   private int c;

   public cyo() {
      super(new jw("gui.difficulty.selectDifficulty"));
   }

   @Override
   protected void init() {
      super.init();
      int var1/* $VF was: ☃ */ = 24;
      int var2/* $VF was: ☃x */ = this.height / 4;
      this.addButton(new cyo.a(this.width / 2 - 100, var2/* $VF was: ☃x */ + 0, dva.a("gui.difficulty.helloNoobVille", new Object[0]), agr.a));
      this.addButton(new cyo.a(this.width / 2 - 100, var2/* $VF was: ☃x */ + 24, dva.a("gui.difficulty.filthyCasual", new Object[0]), agr.b));
      this.addButton(new cyo.a(this.width / 2 - 100, var2/* $VF was: ☃x */ + 48, dva.a("gui.difficulty.lemonCurry", new Object[0]), agr.c));
      this.addButton(new cyo.a(this.width / 2 - 100, var2/* $VF was: ☃x */ + 72, dva.a("gui.difficulty.extremeToTheMax", new Object[0]), agr.d));
      this.b = this.addButton(new cyo.a(this.width / 2 - 100, var2/* $VF was: ☃x */ + 96, dva.a("gui.difficulty.obligatoryNightmareMode", new Object[0]), agr.d, true));
   }

   @Override
   public void render(int var1, int var2, float var3) {
      this.renderBackground();
      this.drawCenteredString(this.font, this.getTitle().e(), this.width / 2, this.height / 4 - 60 + 20, 16777215);
      super.render(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */);
      if (this.b != null && this.b.isHovered()) {
         this.c = Math.min(255, this.c + 3);
      } else {
         this.c = Math.max(0, this.c - 3);
      }

      if (this.c != 0) {
         this.fillGradient(0, 0, this.width, this.height, 0, this.c << 24 | 0xFF0000);
      }
   }

   @Override
   public void onClose() {
      this.minecraft.a(new cys());
   }

   class a extends cwc {
      private final agr b;
      private boolean c;

      public a(int var2, int var3, String var4, agr var5) {
         this(var2/* $VF was: ☃ */, var3/* $VF was: ☃ */, var4/* $VF was: ☃ */, var5/* $VF was: ☃ */, false);
      }

      public a(int var2, int var3, String var4, agr var5, boolean var6) {
         super(var2, var3, 200, 20, var4, var3x -> {
            cyo.this.minecraft.a("shareware", dva.a("resultFolder.sharewareWorldName", new Object[0]), cyo.a);

            dxe world = cyo.this.minecraft.B();
            world.e(() -> {
               world.a(var5, true);
               world.c(true);
               world.n(var6);
            });
         });

         this.b = var5;
         this.c = var6;
      }
   }
}
