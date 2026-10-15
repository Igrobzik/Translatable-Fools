import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

public class dux extends xe<List<String>> {
   private static final qr a = new qr("texts/splashes.txt");
   private static final Random b = new Random();
   private final List<String> c = Lists.newArrayList();
   private final cvi d;

   public dux(cvi var1) {
      this.d = var1;
   }

   protected List<String> a(xc var1, afy var2) {
      String language = cux.v().w.aN;

      if (language != null && !language.trim().isEmpty()) {
         language = language.trim().toLowerCase(Locale.ROOT);

         qr localized = new qr("texts/splashes_" + language + ".txt");

         if (var1.b(localized)) {
            try {
               return this.loadSplashes(var1, localized);
            } catch (IOException exception) {
               // Fall back to the original splashes file.
            }
         }
      }

      try {
         return this.loadSplashes(var1, a);
      } catch (IOException exception) {
         return Collections.emptyList();
      }
   }

   private List<String> loadSplashes(xc resources, qr location)
      throws IOException {
      try (
         xb resource = resources.a(location);
         BufferedReader reader = new BufferedReader(
            new InputStreamReader(resource.b(), StandardCharsets.UTF_8)
         )
      ) {
         return reader.lines()
            .map(String::trim)
            .filter(line -> line.hashCode() != 125780783)
            .collect(Collectors.toList());
      }
   }

   protected void a(List<String> var1, xc var2, afy var3) {
      this.c.clear();
      this.c.addAll(var1);
   }

   @Nullable
   public String a() {
      Calendar var1 = Calendar.getInstance();
      var1.setTime(new Date());

      if (var1.get(2) + 1 == 12 && var1.get(5) == 24) {
         return "Merry X-mas!";
      } else if (var1.get(2) + 1 == 1 && var1.get(5) == 1) {
         return "Happy new year!";
      } else if (var1.get(2) + 1 == 10 && var1.get(5) == 31) {
         return "OOoooOOOoooo! Spooky!";
      } else if (this.c.isEmpty()) {
         return new jw("splash.shareware.missingNo", new Object[0]).getString();
      } else {
         return this.d != null && b.nextInt(this.c.size()) == 42
            ? new jw("splash.shareware.run", this.d.c().toUpperCase(Locale.ROOT)).getString()
            : this.c.get(b.nextInt(this.c.size()));
      }
   }
}