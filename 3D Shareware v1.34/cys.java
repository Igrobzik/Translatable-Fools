public class cys extends czn {
   public cys() {
      super(new jw("gui.episode.selectEpisode"));
   }

   @Override
   protected void init() {
      super.init();
      int var1/* $VF was: ☃ */ = 24;
      int var2/* $VF was: ☃x */ = this.height / 4;
      this.addButton(new cwc(this.width / 2 - 100, var2/* $VF was: ☃x */, 200, 20, dva.a("gui.episode.thePlayerIsYou", new Object[0]), var1x -> this.minecraft.a(new cyo())));
      this.addButton(new cys.a(this.width / 2 - 100, var2/* $VF was: ☃x */ + 24, dva.a("gui.episode.kneeDeepInLava", new Object[0])));
      this.addButton(new cys.a(this.width / 2 - 100, var2/* $VF was: ☃x */ + 48, dva.a("gui.episode.notJustTheEndermen", new Object[0])));
      this.addButton(new cys.a(this.width / 2 - 100, var2/* $VF was: ☃x */ + 72, dva.a("gui.episode.removingHerobrine", new Object[0])));
      this.addButton(new cys.a(this.width / 2 - 100, var2/* $VF was: ☃x */ + 96, dva.a("gui.episode.allTheseWorldsAreYoursExcept", new Object[0])));
   }

   @Override
   public void render(int var1, int var2, float var3) {
      this.renderBackground();
      this.drawCenteredString(this.font, this.getTitle().e(), this.width / 2, this.height / 4 - 60 + 20, 16777215);
      super.render(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */);

      for (cwa var5/* $VF was: ☃ */ : this.buttons) {
         if (var5/* $VF was: ☃ */.isHovered() && var5/* $VF was: ☃ */ instanceof cys.a) {
            this.renderTooltip(dva.a("gui.episode.availableInRegisteredVersion", new Object[0]), var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
            break;
         }
      }
   }

   @Override
   public void onClose() {
      this.minecraft.a(new czr());
   }

   static class a extends cwc {
      public a(int var1, int var2, String var3) {
         super(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, 200, 20, var3/* $VF was: ☃ */, var0 -> {});
         this.active = false;
      }
   }
}
