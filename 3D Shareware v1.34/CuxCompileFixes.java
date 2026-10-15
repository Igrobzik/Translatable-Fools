import java.util.concurrent.Executor;
import java.util.concurrent.CompletableFuture;
import java.util.function.LongSupplier;

final class CuxCompileFixes {
    private CuxCompileFixes() {}

    private static Object enumValue(String className, int index) {
        try {
            Object[] values = (Object[]) Class.forName(className)
                .getMethod("values").invoke(null);
            return values[index];
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean isSpecialMode() {
        return p.g() == p.b.d;
    }

    static long timeB() {
        return p.b();
    }

    static long timeC() {
        return p.c();
    }

    static Executor executor() {
        return p.e();
    }

    static void shutdown() {
        p.f();
    }

    static void setClock(LongSupplier supplier) {
        p.a = supplier;
    }

    static void resetClock() {
        p.a = System::nanoTime;
    }

    static int packVersion() {
        try {
            Object version = Class.forName("o").getMethod("a").invoke(null);
            return ((Number) version.getClass()
                .getMethod("getPackVersion").invoke(version)).intValue();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Cannot read game pack version", e);
        }
    }

    static String gameVersionName() {
        try {
            Object version = Class.forName("o").getMethod("a").invoke(null);
            return (String) version.getClass()
                .getMethod("getName").invoke(version);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Cannot read game version name", e);
        }
    }

    static boolean optionFlag() {
        return o.b;
    }

    static String clean(String value) {
        return c.b(value).trim();
    }

    static d crashReport(Throwable error, String description) {
        return d.a(error, description);
    }

    static <T> T modeA() { return (T) enumValue("cri$a", 0); }

    static <T> T modeB() { return (T) enumValue("cri$a", 1); }

    static <T> T modeC() { return (T) enumValue("cri$a", 2); }
}
