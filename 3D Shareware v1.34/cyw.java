public class cyw extends cyv {
    public static final cyv.b o = new cyv.b(1, 0);
    public static final cyv.b p = new cyv.b(1, m.c);

    public cyw(cux var1) {
        super(var1);
    }

    @Override
    public void render(int var1, int var2, float var3) {
        super.render(var1, var2, var3);
        this.a();

        cuc var4 = cuc.a();
        ctz var5 = var4.c();
        var5.a(7, cub.m);

        this.a(var5, new cyv.b(0, 0), l);
        this.a(var5, o, m);

        int cursorX = this.getLineWidthChars(m.a);
        this.a(var5, new cyv.b(1, cursorX), n);

        var4.b();
    }

    @Override
    public boolean b() {
        return true;
    }
}