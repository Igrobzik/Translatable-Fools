import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class cyu extends cyv {
    private final wz o;
    private final Runnable finishCallback;
    private final List<cyu.Entry> q = new ArrayList<>();
    private int r = 0;
    private long s;

    private static final cyu.a[] t = new cyu.a[] {
        new cyu.a(var0 -> {
        }, 1),

        new cyu.a(var0 -> {
            var0.add(new cyu.Entry(new cyv.b(0, 0), b));
            var0.add(new cyu.Entry(new cyv.b(1, 0), c));
        }, 2),

        new cyu.a(var0 -> {
            var0.add(new cyu.Entry(new cyv.b(3, 0), e));
            var0.add(new cyu.Entry(new cyv.b(3, e.c + 2), f));
            var0.add(new cyu.Entry(new cyv.b(4, 0), d));
        }, 3),

        new cyu.a(var0 -> {
            var0.remove(var0.size() - 2);
            var0.add(new cyu.Entry(new cyv.b(6, 0), g));
            var0.add(new cyu.Entry(new cyv.b(6, g.c + 2), f));
        }, 2),

        new cyu.a(var0 -> {
            var0.remove(var0.size() - 1);
            var0.remove(var0.size() - 1);
            var0.add(new cyu.Entry(new cyv.b(6, 0), h));
            var0.add(new cyu.Entry(new cyv.b(7, 0), i));
            var0.add(new cyu.Entry(new cyv.b(8, 0), j));
            var0.add(new cyu.Entry(new cyv.b(10, 0), k));
            var0.add(new cyu.Entry(new cyv.b(10, k.c + 2), f));
        }, 2),

        new cyu.a(var0 -> {
        }, Integer.MAX_VALUE)
    };

    public cyu(cux var1, wz var2, Runnable var3) {
        super(var1);
        this.o = var2;
        this.finishCallback = var3;
    }

    @Override
    public void render(int var1, int var2, float var3) {
        super.render(var1, var2, var3);

        long var4 = p.b();
        long var6 = var4 / 1000L;

        if (this.r == t.length - 1) {
            if (this.o.d()) {
                this.o.e();
                this.finishCallback.run();

                if (this.a.o != null) {
                    this.a.o.init(this.a, this.a.g.o(), this.a.g.p());
                }

                this.a.a((czi)null);
            }
        } else if (var6 - this.s > t[this.r].b) {
            this.r++;
            t[this.r].a.accept(this.q);
            this.s = var6;
        }

        this.a();

        cuc var8 = cuc.a();
        ctz var9 = var8.c();
        var9.a(7, cub.m);

        for (cyu.Entry entry : this.q) {
            cyv.a sprite = entry.sprite;
            cyv.b position = entry.position;

            if (sprite == f) {
                int width = this.getLineWidthBeforeCursor();
                position = new cyv.b(position.a, width + 2);
            }

            this.a(var9, position, sprite);
        }

        var8.b();
    }

    private int getLineWidthBeforeCursor() {
        for (int index = this.q.size() - 1; index >= 0; index--) {
            cyu.Entry entry = this.q.get(index);

            if (entry.sprite == f && index > 0) {
                cyv.a previousSprite = this.q.get(index - 1).sprite;
                return this.getLineWidthChars(previousSprite.a);
            }
        }

        return 0;
    }

    private static class Entry {
        private final cyv.b position;
        private final cyv.a sprite;

        private Entry(cyv.b position, cyv.a sprite) {
            this.position = position;
            this.sprite = sprite;
        }
    }

    public static class a {
        private final Consumer<List<cyu.Entry>> a;
        private final long b;

        public a(Consumer<List<cyu.Entry>> var1, int var2) {
            this.a = var1;
            this.b = var2;
        }
    }
}