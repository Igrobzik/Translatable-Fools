import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.ArabicShapingException;
import com.ibm.icu.text.Bidi;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;

public class avq implements bnn {
private static final ka[] c = new ka[256];
private int[] d = new int[256];
public int a = 9;
public Random b = new Random();
private byte[] e = new byte[65536];
private int[] f = new int[32];
private final ka g;
private final bmn h;
private float i;
private float j;
private boolean k;
private boolean l;
private float m;
private float n;
private float o;
private float p;
private int q;
private boolean r;
private boolean s;
private boolean t;
private boolean u;
private boolean v;

public avq(avk var1, ka var2, bmn var3, boolean var4) {
this.g = var2/* $VF was: ☃ */;
this.h = var3/* $VF was: ☃ */;
this.k = var4/* $VF was: ☃ */;
var3/* $VF was: ☃ */.a(this.g);

  for (int var5/* $VF was: ☃ */ = 0; var5/* $VF was: ☃ */ < 32; var5/* $VF was: ☃ */++) {
     int var6/* $VF was: ☃x */ = (var5/* $VF was: ☃ */ >> 3 & 1) * 85;
     int var7/* $VF was: ☃xx */ = (var5/* $VF was: ☃ */ >> 2 & 1) * 170 + var6/* $VF was: ☃x */;
     int var8/* $VF was: ☃xxx */ = (var5/* $VF was: ☃ */ >> 1 & 1) * 170 + var6/* $VF was: ☃x */;
     int var9/* $VF was: ☃xxxx */ = (var5/* $VF was: ☃ */ >> 0 & 1) * 170 + var6/* $VF was: ☃x */;
     if (var5/* $VF was: ☃ */ == 6) {
        var7/* $VF was: ☃xx */ += 85;
     }

     if (var1/* $VF was: ☃ */.e) {
        int var10/* $VF was: ☃xxxxx */ = (var7/* $VF was: ☃xx */ * 30 + var8/* $VF was: ☃xxx */ * 59 + var9/* $VF was: ☃xxxx */ * 11) / 100;
        int var11/* $VF was: ☃xxxxxx */ = (var7/* $VF was: ☃xx */ * 30 + var8/* $VF was: ☃xxx */ * 70) / 100;
        int var12/* $VF was: ☃xxxxxxx */ = (var7/* $VF was: ☃xx */ * 30 + var9/* $VF was: ☃xxxx */ * 70) / 100;
        var7/* $VF was: ☃xx */ = var10/* $VF was: ☃xxxxx */;
        var8/* $VF was: ☃xxx */ = var11/* $VF was: ☃xxxxxx */;
        var9/* $VF was: ☃xxxx */ = var12/* $VF was: ☃xxxxxxx */;
     }

     if (var5/* $VF was: ☃ */ >= 16) {
        var7/* $VF was: ☃xx */ /= 4;
        var8/* $VF was: ☃xxx */ /= 4;
        var9/* $VF was: ☃xxxx */ /= 4;
     }

     this.f[var5/* $VF was: ☃ */] = (var7/* $VF was: ☃xx */ & 0xFF) << 16 | (var8/* $VF was: ☃xxx */ & 0xFF) << 8 | var9/* $VF was: ☃xxxx */ & 0xFF;
  }

  this.d();

}

@Override
public void a(bnm var1) {
this.c();
}

private void c() {
BufferedImage var1/* $VF was: ☃ */;
try {
var1/* $VF was: ☃ */ = bmp.a(avh.A().Q().a(this.g).b());
} catch (IOException var17/* $VF was: ☃x */) {
throw new RuntimeException(var17/* $VF was: ☃x */);
}

  int var2/* $VF was: ☃x */ = var1/* $VF was: ☃ */.getWidth();
  int var3/* $VF was: ☃xx */ = var1/* $VF was: ☃ */.getHeight();
  int[] var4/* $VF was: ☃xxx */ = new int[var2/* $VF was: ☃x */ * var3/* $VF was: ☃xx */];
  var1/* $VF was: ☃ */.getRGB(0, 0, var2/* $VF was: ☃x */, var3/* $VF was: ☃xx */, var4/* $VF was: ☃xxx */, 0, var2/* $VF was: ☃x */);
  int var5/* $VF was: ☃xxxx */ = var3/* $VF was: ☃xx */ / 16;
  int var6/* $VF was: ☃xxxxx */ = var2/* $VF was: ☃x */ / 16;
  int var7/* $VF was: ☃xxxxxx */ = 1;
  float var8/* $VF was: ☃xxxxxxx */ = 8.0F / var6/* $VF was: ☃xxxxx */;

  for (int var9/* $VF was: ☃xxxxxxxx */ = 0; var9/* $VF was: ☃xxxxxxxx */ < 256; var9/* $VF was: ☃xxxxxxxx */++) {
     int var10/* $VF was: ☃xxxxxxxxx */ = var9/* $VF was: ☃xxxxxxxx */ % 16;
     int var11/* $VF was: ☃xxxxxxxxxx */ = var9/* $VF was: ☃xxxxxxxx */ / 16;
     if (var9/* $VF was: ☃xxxxxxxx */ == 32) {
        this.d[var9/* $VF was: ☃xxxxxxxx */] = 3 + var7/* $VF was: ☃xxxxxx */;
     }

     int var12/* $VF was: ☃xxxxxxxxxxx */;
     for (var12/* $VF was: ☃xxxxxxxxxxx */ = var6/* $VF was: ☃xxxxx */ - 1; var12/* $VF was: ☃xxxxxxxxxxx */ >= 0; var12/* $VF was: ☃xxxxxxxxxxx */--) {
        int var13/* $VF was: ☃xxxxxxxxxxxx */ = var10/* $VF was: ☃xxxxxxxxx */ * var6/* $VF was: ☃xxxxx */ + var12/* $VF was: ☃xxxxxxxxxxx */;
        boolean var14/* $VF was: ☃xxxxxxxxxxxxx */ = true;

        for (int var15/* $VF was: ☃xxxxxxxxxxxxxx */ = 0;
           var15/* $VF was: ☃xxxxxxxxxxxxxx */ < var5/* $VF was: ☃xxxx */ && var14/* $VF was: ☃xxxxxxxxxxxxx */;
           var15/* $VF was: ☃xxxxxxxxxxxxxx */++
        ) {
           int var16/* $VF was: ☃xxxxxxxxxxxxxxx */ = (var11/* $VF was: ☃xxxxxxxxxx */ * var6/* $VF was: ☃xxxxx */ + var15/* $VF was: ☃xxxxxxxxxxxxxx */)
              * var2/* $VF was: ☃x */;
           if ((var4/* $VF was: ☃xxx */[var13/* $VF was: ☃xxxxxxxxxxxx */ + var16/* $VF was: ☃xxxxxxxxxxxxxxx */] >> 24 & 0xFF) != 0) {
              var14/* $VF was: ☃xxxxxxxxxxxxx */ = false;
           }
        }

        if (!var14/* $VF was: ☃xxxxxxxxxxxxx */) {
           break;
        }
     }

     this.d[var9/* $VF was: ☃xxxxxxxx */] = (int)(0.5 + ++var12/* $VF was: ☃xxxxxxxxxxx */ * var8/* $VF was: ☃xxxxxxx */) + var7/* $VF was: ☃xxxxxx */;
  }

}

private void d() {
InputStream var1/* $VF was: ☃ */ = null;

  try {
     var1/* $VF was: ☃ */ = avh.A().Q().a(new ka("font/glyph_sizes.bin")).b();
     var1/* $VF was: ☃ */.read(this.e);
  } catch (IOException var6/* $VF was: ☃x */) {
     throw new RuntimeException(var6/* $VF was: ☃x */);
  } finally {
     IOUtils.closeQuietly(var1/* $VF was: ☃ */);
  }

}

private float a(char var1, boolean var2) {
if (var1/* $VF was: ☃ */ == ' ') {
return 4.0F;
}

  int var3/* $VF was: ☃ */ = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000"
     .indexOf(var1/* $VF was: ☃ */);
  return var3/* $VF was: ☃ */ != -1 && !this.k ? this.a(var3/* $VF was: ☃ */, var2/* $VF was: ☃ */) : this.b(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);

}

private float a(int var1, boolean var2) {
int var3/* $VF was: ☃ */ = var1/* $VF was: ☃ */ % 16 * 8;
int var4/* $VF was: ☃x */ = var1/* $VF was: ☃ */ / 16 * 8;
int var5/* $VF was: ☃xx */ = var2/* $VF was: ☃ */ ? 1 : 0;
this.h.a(this.g);
int var6/* $VF was: ☃xxx */ = this.d[var1/* $VF was: ☃ */];
float var7/* $VF was: ☃xxxx */ = var6/* $VF was: ☃xxx */ - 0.01F;
GL11.glBegin(5);
GL11.glTexCoord2f(var3/* $VF was: ☃ */ / 128.0F, var4/* $VF was: ☃x */ / 128.0F);
GL11.glVertex3f(this.i + var5/* $VF was: ☃xx */, this.j, 0.0F);
GL11.glTexCoord2f(var3/* $VF was: ☃ */ / 128.0F, (var4/* $VF was: ☃x */ + 7.99F) / 128.0F);
GL11.glVertex3f(this.i - var5/* $VF was: ☃xx */, this.j + 7.99F, 0.0F);
GL11.glTexCoord2f((var3/* $VF was: ☃ */ + var7/* $VF was: ☃xxxx */ - 1.0F) / 128.0F, var4/* $VF was: ☃x */ / 128.0F);
GL11.glVertex3f(this.i + var7/* $VF was: ☃xxxx */ - 1.0F + var5/* $VF was: ☃xx */, this.j, 0.0F);
GL11.glTexCoord2f((var3/* $VF was: ☃ */ + var7/* $VF was: ☃xxxx */ - 1.0F) / 128.0F, (var4/* $VF was: ☃x */ + 7.99F) / 128.0F);
GL11.glVertex3f(this.i + var7/* $VF was: ☃xxxx */ - 1.0F - var5/* $VF was: ☃xx */, this.j + 7.99F, 0.0F);
GL11.glEnd();
return var6/* $VF was: ☃xxx */;
}

private ka a(int var1) {
if (c[var1/* $VF was: ☃ */] == null) {
c[var1/* $VF was: ☃ */] = new ka(String.format("textures/font/unicode_page_%02x.png", var1/* $VF was: ☃ */));
}

  return c[var1/* $VF was: ☃ */];

}

private void b(int var1) {
this.h.a(this.a(var1/* $VF was: ☃ */));
}

private float b(char var1, boolean var2) {
if (this.e[var1/* $VF was: ☃ */] == 0) {
return 0.0F;
}

  int var3/* $VF was: ☃ */ = var1/* $VF was: ☃ */ / 256;
  this.b(var3/* $VF was: ☃ */);
  int var4/* $VF was: ☃x */ = this.e[var1/* $VF was: ☃ */] >>> 4;
  int var5/* $VF was: ☃xx */ = this.e[var1/* $VF was: ☃ */] & 15;
  float var6/* $VF was: ☃xxx */ = var4/* $VF was: ☃x */;
  float var7/* $VF was: ☃xxxx */ = var5/* $VF was: ☃xx */ + 1;
  float var8/* $VF was: ☃xxxxx */ = var1/* $VF was: ☃ */ % 16 * 16 + var6/* $VF was: ☃xxx */;
  float var9/* $VF was: ☃xxxxxx */ = (var1/* $VF was: ☃ */ & 255) / 16 * 16;
  float var10/* $VF was: ☃xxxxxxx */ = var7/* $VF was: ☃xxxx */ - var6/* $VF was: ☃xxx */ - 0.02F;
  float var11/* $VF was: ☃xxxxxxxx */ = var2/* $VF was: ☃ */ ? 1.0F : 0.0F;
  GL11.glBegin(5);
  GL11.glTexCoord2f(var8/* $VF was: ☃xxxxx */ / 256.0F, var9/* $VF was: ☃xxxxxx */ / 256.0F);
  GL11.glVertex3f(this.i + var11/* $VF was: ☃xxxxxxxx */, this.j, 0.0F);
  GL11.glTexCoord2f(var8/* $VF was: ☃xxxxx */ / 256.0F, (var9/* $VF was: ☃xxxxxx */ + 15.98F) / 256.0F);
  GL11.glVertex3f(this.i - var11/* $VF was: ☃xxxxxxxx */, this.j + 7.99F, 0.0F);
  GL11.glTexCoord2f((var8/* $VF was: ☃xxxxx */ + var10/* $VF was: ☃xxxxxxx */) / 256.0F, var9/* $VF was: ☃xxxxxx */ / 256.0F);
  GL11.glVertex3f(this.i + var10/* $VF was: ☃xxxxxxx */ / 2.0F + var11/* $VF was: ☃xxxxxxxx */, this.j, 0.0F);
  GL11.glTexCoord2f((var8/* $VF was: ☃xxxxx */ + var10/* $VF was: ☃xxxxxxx */) / 256.0F, (var9/* $VF was: ☃xxxxxx */ + 15.98F) / 256.0F);
  GL11.glVertex3f(this.i + var10/* $VF was: ☃xxxxxxx */ / 2.0F - var11/* $VF was: ☃xxxxxxxx */, this.j + 7.99F, 0.0F);
  GL11.glEnd();
  return (var7/* $VF was: ☃xxxx */ - var6/* $VF was: ☃xxx */) / 2.0F + 1.0F;

}

public int a(String var1, float var2, float var3, int var4) {
return this.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */, var4/* $VF was: ☃ */, true);
}

public int a(String var1, int var2, int var3, int var4) {
return this.a(var1/* $VF was: ☃ */, (float)var2/* $VF was: ☃ */, (float)var3/* $VF was: ☃ */, var4/* $VF was: ☃ */, false);
}

public int a(String var1, float var2, float var3, int var4, boolean var5) {
bfp.d();
this.e();
int var7/* $VF was: ☃ */;
if (var5/* $VF was: ☃ */) {
var7/* $VF was: ☃ */ = this.b(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */ + 1.0F, var3/* $VF was: ☃ */ + 1.0F, var4/* $VF was: ☃ */, true);
var7/* $VF was: ☃ */ = Math.max(
var7/* $VF was: ☃ */, this.b(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */, var4/* $VF was: ☃ */, false)
);
} else {
var7/* $VF was: ☃ */ = this.b(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */, var4/* $VF was: ☃ */, false);
}

  return var7/* $VF was: ☃ */;

}

private String c(String var1) {
try {
Bidi var2/* $VF was: ☃ */ = new Bidi(new ArabicShaping(8).shape(var1/* $VF was: ☃ */), 127);
var2/* $VF was: ☃ */.setReorderingMode(0);
return var2/* $VF was: ☃ */.writeReordered(2);
} catch (ArabicShapingException var3) {
return var1/* $VF was: ☃ */;
}
}

private void e() {
this.r = false;
this.s = false;
this.t = false;
this.u = false;
this.v = false;
}

private void a(String var1, boolean var2) {
for (int var3/* $VF was: ☃ */ = 0; var3/* $VF was: ☃ */ < var1/* $VF was: ☃ */.length(); var3/* $VF was: ☃ */++) {
char var4/* $VF was: ☃x */ = var1/* $VF was: ☃ */.charAt(var3/* $VF was: ☃ */);
if (var4/* $VF was: ☃x */ == 167 && var3/* $VF was: ☃ */ + 1 < var1/* $VF was: ☃ */.length()) {
int var12/* $VF was: ☃xx */ = "0123456789abcdefklmnor".indexOf(var1/* $VF was: ☃ */.toLowerCase().charAt(var3/* $VF was: ☃ */ + 1));
if (var12/* $VF was: ☃xx */ < 16) {
this.r = false;
this.s = false;
this.v = false;
this.u = false;
this.t = false;
if (var12/* $VF was: ☃xx */ < 0 || var12/* $VF was: ☃xx */ > 15) {
var12/* $VF was: ☃xx */ = 15;
}

           if (var2/* $VF was: ☃ */) {
              var12/* $VF was: ☃xx */ += 16;
           }

           int var14/* $VF was: ☃xxx */ = this.f[var12/* $VF was: ☃xx */];
           this.q = var14/* $VF was: ☃xxx */;
           bfp.c(
              (var14/* $VF was: ☃xxx */ >> 16) / 255.0F,
              (var14/* $VF was: ☃xxx */ >> 8 & 0xFF) / 255.0F,
              (var14/* $VF was: ☃xxx */ & 0xFF) / 255.0F,
              this.p
           );
        } else if (var12/* $VF was: ☃xx */ == 16) {
           this.r = true;
        } else if (var12/* $VF was: ☃xx */ == 17) {
           this.s = true;
        } else if (var12/* $VF was: ☃xx */ == 18) {
           this.v = true;
        } else if (var12/* $VF was: ☃xx */ == 19) {
           this.u = true;
        } else if (var12/* $VF was: ☃xx */ == 20) {
           this.t = true;
        } else if (var12/* $VF was: ☃xx */ == 21) {
           this.r = false;
           this.s = false;
           this.v = false;
           this.u = false;
           this.t = false;
           bfp.c(this.m, this.n, this.o, this.p);
        }

        var3/* $VF was: ☃ */++;
     } else {
        int var5/* $VF was: ☃xx */ = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000"
           .indexOf(var4/* $VF was: ☃x */);
        if (this.r && var5/* $VF was: ☃xx */ != -1) {
           int var6/* $VF was: ☃xxx */ = this.a(var4/* $VF was: ☃x */);

           char var7/* $VF was: ☃xxxx */;
           do {
              var5/* $VF was: ☃xx */ = this.b
                 .nextInt(
                    "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000"
                       .length()
                 );
              var7/* $VF was: ☃xxxx */ = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000"
                 .charAt(var5/* $VF was: ☃xx */);
           } while (var6/* $VF was: ☃xxx */ != this.a(var7/* $VF was: ☃xxxx */));

           var4/* $VF was: ☃x */ = var7/* $VF was: ☃xxxx */;
        }

        float var13/* $VF was: ☃xxx */ = this.k ? 0.5F : 1.0F;
        boolean var15/* $VF was: ☃xxxx */ = (var4/* $VF was: ☃x */ == 0 || var5/* $VF was: ☃xx */ == -1 || this.k) && var2/* $VF was: ☃ */;
        if (var15/* $VF was: ☃xxxx */) {
           this.i -= var13/* $VF was: ☃xxx */;
           this.j -= var13/* $VF was: ☃xxx */;
        }

        float var8/* $VF was: ☃xxxxx */ = this.a(var4/* $VF was: ☃x */, this.t);
        if (var15/* $VF was: ☃xxxx */) {
           this.i += var13/* $VF was: ☃xxx */;
           this.j += var13/* $VF was: ☃xxx */;
        }

        if (this.s) {
           this.i += var13/* $VF was: ☃xxx */;
           if (var15/* $VF was: ☃xxxx */) {
              this.i -= var13/* $VF was: ☃xxx */;
              this.j -= var13/* $VF was: ☃xxx */;
           }

           this.a(var4/* $VF was: ☃x */, this.t);
           this.i -= var13/* $VF was: ☃xxx */;
           if (var15/* $VF was: ☃xxxx */) {
              this.i += var13/* $VF was: ☃xxx */;
              this.j += var13/* $VF was: ☃xxx */;
           }

           var8/* $VF was: ☃xxxxx */++;
        }

        if (this.v) {
           bgb var9/* $VF was: ☃xxxxxx */ = bgb.a();
           bfh var10/* $VF was: ☃xxxxxxx */ = var9/* $VF was: ☃xxxxxx */.c();
           bfp.x();
           var10/* $VF was: ☃xxxxxxx */.a(7, bmw.e);
           var10/* $VF was: ☃xxxxxxx */.b(this.i, this.j + this.a / 2, 0.0).d();
           var10/* $VF was: ☃xxxxxxx */.b(this.i + var8/* $VF was: ☃xxxxx */, this.j + this.a / 2, 0.0).d();
           var10/* $VF was: ☃xxxxxxx */.b(this.i + var8/* $VF was: ☃xxxxx */, this.j + this.a / 2 - 1.0F, 0.0).d();
           var10/* $VF was: ☃xxxxxxx */.b(this.i, this.j + this.a / 2 - 1.0F, 0.0).d();
           var9/* $VF was: ☃xxxxxx */.b();
           bfp.w();
        }

        if (this.u) {
           bgb var16/* $VF was: ☃xxxxxx */ = bgb.a();
           bfh var17/* $VF was: ☃xxxxxxx */ = var16/* $VF was: ☃xxxxxx */.c();
           bfp.x();
           var17/* $VF was: ☃xxxxxxx */.a(7, bmw.e);
           int var11/* $VF was: ☃xxxxxxxx */ = this.u ? -1 : 0;
           var17/* $VF was: ☃xxxxxxx */.b(this.i + var11/* $VF was: ☃xxxxxxxx */, this.j + this.a, 0.0).d();
           var17/* $VF was: ☃xxxxxxx */.b(this.i + var8/* $VF was: ☃xxxxx */, this.j + this.a, 0.0).d();
           var17/* $VF was: ☃xxxxxxx */.b(this.i + var8/* $VF was: ☃xxxxx */, this.j + this.a - 1.0F, 0.0).d();
           var17/* $VF was: ☃xxxxxxx */.b(this.i + var11/* $VF was: ☃xxxxxxxx */, this.j + this.a - 1.0F, 0.0).d();
           var16/* $VF was: ☃xxxxxx */.b();
           bfp.w();
        }

        this.i += (int)var8/* $VF was: ☃xxxxx */;
     }
  }

}

private int a(String var1, int var2, int var3, int var4, int var5, boolean var6) {
if (this.l) {
int var7/* $VF was: ☃ */ = this.a(this.c(var1/* $VF was: ☃ */));
var2/* $VF was: ☃ */ = var2/* $VF was: ☃ */ + var4/* $VF was: ☃ */ - var7/* $VF was: ☃ */;
}

  return this.b(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */, var5/* $VF was: ☃ */, var6/* $VF was: ☃ */);

}

private int b(String var1, float var2, float var3, int var4, boolean var5) {
if (var1/* $VF was: ☃ */ == null) {
return 0;
}

  if (this.l) {
     var1/* $VF was: ☃ */ = this.c(var1/* $VF was: ☃ */);
  }

  if ((var4/* $VF was: ☃ */ & -67108864) == 0) {
     var4/* $VF was: ☃ */ |= -16777216;
  }

  if (var5/* $VF was: ☃ */) {
     var4/* $VF was: ☃ */ = (var4/* $VF was: ☃ */ & 16579836) >> 2 | var4/* $VF was: ☃ */ & 0xFF000000;
  }

  this.m = (var4/* $VF was: ☃ */ >> 16 & 0xFF) / 255.0F;
  this.n = (var4/* $VF was: ☃ */ >> 8 & 0xFF) / 255.0F;
  this.o = (var4/* $VF was: ☃ */ & 0xFF) / 255.0F;
  this.p = (var4/* $VF was: ☃ */ >> 24 & 0xFF) / 255.0F;
  bfp.c(this.m, this.n, this.o, this.p);
  this.i = var2/* $VF was: ☃ */;
  this.j = var3/* $VF was: ☃ */;
  this.a(var1/* $VF was: ☃ */, var5/* $VF was: ☃ */);
  return (int)this.i;

}

public int a(String var1) {
if (var1/* $VF was: ☃ */ == null) {
return 0;
}

  int var2/* $VF was: ☃ */ = 0;
  boolean var3/* $VF was: ☃x */ = false;

  for (int var4/* $VF was: ☃xx */ = 0; var4/* $VF was: ☃xx */ < var1/* $VF was: ☃ */.length(); var4/* $VF was: ☃xx */++) {
     char var5/* $VF was: ☃xxx */ = var1/* $VF was: ☃ */.charAt(var4/* $VF was: ☃xx */);
     int var6/* $VF was: ☃xxxx */ = this.a(var5/* $VF was: ☃xxx */);
     if (var6/* $VF was: ☃xxxx */ < 0 && var4/* $VF was: ☃xx */ < var1/* $VF was: ☃ */.length() - 1) {
        var5/* $VF was: ☃xxx */ = var1/* $VF was: ☃ */.charAt(++var4/* $VF was: ☃xx */);
        if (var5/* $VF was: ☃xxx */ == 'l' || var5/* $VF was: ☃xxx */ == 'L') {
           var3/* $VF was: ☃x */ = true;
        } else if (var5/* $VF was: ☃xxx */ == 'r' || var5/* $VF was: ☃xxx */ == 'R') {
           var3/* $VF was: ☃x */ = false;
        }

        var6/* $VF was: ☃xxxx */ = 0;
     }

     var2/* $VF was: ☃ */ += var6/* $VF was: ☃xxxx */;
     if (var3/* $VF was: ☃x */ && var6/* $VF was: ☃xxxx */ > 0) {
        var2/* $VF was: ☃ */++;
     }
  }

  return var2/* $VF was: ☃ */;

}

public int a(char var1) {
if (var1/* $VF was: ☃ */ == 167) {
return -1;
}

  if (var1/* $VF was: ☃ */ == ' ') {
     return 4;
  }

  int var2/* $VF was: ☃x */ = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000"
     .indexOf(var1/* $VF was: ☃ */);
  if (var1/* $VF was: ☃ */ > 0 && var2/* $VF was: ☃ */ != -1 && !this.k) {
     return this.d[var2/* $VF was: ☃ */];
  }

  if (this.e[var1/* $VF was: ☃ */] != 0) {
     int var3/* $VF was: ☃x */ = this.e[var1/* $VF was: ☃ */] >>> 4;
     int var4/* $VF was: ☃xx */ = this.e[var1/* $VF was: ☃ */] & 15;
     var4/* $VF was: ☃xx */++;
     return (var4/* $VF was: ☃xx */ - var3/* $VF was: ☃x */) / 2 + 1;
  } else {
     return 0;
  }

}

public String a(String var1, int var2) {
return this.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, false);
}

public String a(String var1, int var2, boolean var3) {
StringBuilder var4/* $VF was: ☃ */ = new StringBuilder();
int var5/* $VF was: ☃x */ = 0;
int var6/* $VF was: ☃xx */ = var3/* $VF was: ☃ */ ? var1/* $VF was: ☃ */.length() - 1 : 0;
int var7/* $VF was: ☃xxx */ = var3/* $VF was: ☃ */ ? -1 : 1;
boolean var8/* $VF was: ☃xxxx */ = false;
boolean var9/* $VF was: ☃xxxxx */ = false;

  for (int var10/* $VF was: ☃xxxxxx */ = var6/* $VF was: ☃xx */;
     var10/* $VF was: ☃xxxxxx */ >= 0 && var10/* $VF was: ☃xxxxxx */ < var1/* $VF was: ☃ */.length() && var5/* $VF was: ☃x */ < var2/* $VF was: ☃ */;
     var10/* $VF was: ☃xxxxxx */ += var7/* $VF was: ☃xxx */
  ) {
     char var11/* $VF was: ☃xxxxxxx */ = var1/* $VF was: ☃ */.charAt(var10/* $VF was: ☃xxxxxx */);
     int var12/* $VF was: ☃xxxxxxxx */ = this.a(var11/* $VF was: ☃xxxxxxx */);
     if (var8/* $VF was: ☃xxxx */) {
        var8/* $VF was: ☃xxxx */ = false;
        if (var11/* $VF was: ☃xxxxxxx */ == 'l' || var11/* $VF was: ☃xxxxxxx */ == 'L') {
           var9/* $VF was: ☃xxxxx */ = true;
        } else if (var11/* $VF was: ☃xxxxxxx */ == 'r' || var11/* $VF was: ☃xxxxxxx */ == 'R') {
           var9/* $VF was: ☃xxxxx */ = false;
        }
     } else if (var12/* $VF was: ☃xxxxxxxx */ < 0) {
        var8/* $VF was: ☃xxxx */ = true;
     } else {
        var5/* $VF was: ☃x */ += var12/* $VF was: ☃xxxxxxxx */;
        if (var9/* $VF was: ☃xxxxx */) {
           var5/* $VF was: ☃x */++;
        }
     }

     if (var5/* $VF was: ☃x */ > var2/* $VF was: ☃ */) {
        break;
     }

     if (var3/* $VF was: ☃ */) {
        var4/* $VF was: ☃ */.insert(0, var11/* $VF was: ☃xxxxxxx */);
     } else {
        var4/* $VF was: ☃ */.append(var11/* $VF was: ☃xxxxxxx */);
     }
  }

  return var4/* $VF was: ☃ */.toString();

}

private String d(String var1) {
while (var1/* $VF was: ☃ */ != null && var1/* $VF was: ☃ */.endsWith("\n")) {
var1/* $VF was: ☃ */ = var1/* $VF was: ☃ */.substring(0, var1/* $VF was: ☃ */.length() - 1);
}

  return var1/* $VF was: ☃ */;

}

public void a(String var1, int var2, int var3, int var4, int var5) {
this.e();
this.q = var5/* $VF was: ☃ */;
var1/* $VF was: ☃ */ = this.d(var1/* $VF was: ☃ */);
this.a(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */, var4/* $VF was: ☃ */, false);
}

private void a(String var1, int var2, int var3, int var4, boolean var5) {
for (String var8/* $VF was: ☃ */ : this.c(var1/* $VF was: ☃ */, var4/* $VF was: ☃ */)) {
this.a(var8/* $VF was: ☃ */, var2/* $VF was: ☃ */, var3/* $VF was: ☃ */, var4/* $VF was: ☃ */, this.q, var5/* $VF was: ☃ */);
var3/* $VF was: ☃ */ += this.a;
}
}

public int b(String var1, int var2) {
return this.a * this.c(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */).size();
}

public void a(boolean var1) {
this.k = var1/* $VF was: ☃ */;
}

public boolean a() {
return this.k;
}

public void b(boolean var1) {
this.l = var1/* $VF was: ☃ */;
}

public List<String> c(String var1, int var2) {
return Arrays.asList(this.d(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */).split("\n"));
}

String d(String var1, int var2) {
int var3/* $VF was: ☃ */ = this.e(var1/* $VF was: ☃ */, var2/* $VF was: ☃ */);
if (var1/* $VF was: ☃ */.length() <= var3/* $VF was: ☃ */) {
return var1/* $VF was: ☃ */;
}

  String var4/* $VF was: ☃x */ = var1/* $VF was: ☃ */.substring(0, var3/* $VF was: ☃ */);
  char var5/* $VF was: ☃xx */ = var1/* $VF was: ☃ */.charAt(var3/* $VF was: ☃ */);
  boolean var6/* $VF was: ☃xxx */ = var5/* $VF was: ☃xx */ == ' ' || var5/* $VF was: ☃xx */ == '\n';
  String var7/* $VF was: ☃xxxx */ = b(var4/* $VF was: ☃x */) + var1/* $VF was: ☃ */.substring(var3/* $VF was: ☃ */ + (var6/* $VF was: ☃xxx */ ? 1 : 0));
  return var4/* $VF was: ☃x */ + "\n" + this.d(var7/* $VF was: ☃xxxx */, var2/* $VF was: ☃ */);

}

private int e(String var1, int var2) {
int var3/* $VF was: ☃ */ = var1/* $VF was: ☃ */.length();
int var4/* $VF was: ☃x */ = 0;
int var5/* $VF was: ☃xx */ = 0;
int var6/* $VF was: ☃xxx */ = -1;
boolean var7/* $VF was: ☃xxxx */ = false;

  while (var5/* $VF was: ☃xx */ < var3/* $VF was: ☃ */) {
     char var8/* $VF was: ☃xxxxx */ = var1/* $VF was: ☃ */.charAt(var5/* $VF was: ☃xx */);
     switch (var8/* $VF was: ☃xxxxx */) {
        case '\n':
           var5/* $VF was: ☃xx */--;
           break;
        case ' ':
           var6/* $VF was: ☃xxx */ = var5/* $VF was: ☃xx */;
        default:
           var4/* $VF was: ☃x */ += this.a(var8/* $VF was: ☃xxxxx */);
           if (var7/* $VF was: ☃xxxx */) {
              var4/* $VF was: ☃x */++;
           }
           break;
        case '§':
           if (var5/* $VF was: ☃xx */ < var3/* $VF was: ☃ */ - 1) {
              char var9/* $VF was: ☃xxxxxx */ = var1/* $VF was: ☃ */.charAt(++var5/* $VF was: ☃xx */);
              if (var9/* $VF was: ☃xxxxxx */ == 'l' || var9/* $VF was: ☃xxxxxx */ == 'L') {
                 var7/* $VF was: ☃xxxx */ = true;
              } else if (var9/* $VF was: ☃xxxxxx */ == 'r' || var9/* $VF was: ☃xxxxxx */ == 'R' || c(var9/* $VF was: ☃xxxxxx */)) {
                 var7/* $VF was: ☃xxxx */ = false;
              }
           }
     }

     if (var8/* $VF was: ☃xxxxx */ == '\n') {
        var6/* $VF was: ☃xxx */ = ++var5/* $VF was: ☃xx */;
        break;
     }

     if (var4/* $VF was: ☃x */ > var2/* $VF was: ☃ */) {
        break;
     }

     var5/* $VF was: ☃xx */++;
  }

  return var5/* $VF was: ☃xx */ != var3/* $VF was: ☃ */ && var6/* $VF was: ☃xxx */ != -1 && var6/* $VF was: ☃xxx */ < var5/* $VF was: ☃xx */
     ? var6/* $VF was: ☃xxx */
     : var5/* $VF was: ☃xx */;

}

private static boolean c(char var0) {
return var0/* $VF was: ☃ */ >= '0' && var0/* $VF was: ☃ */ <= '9'
|| var0/* $VF was: ☃ */ >= 'a' && var0/* $VF was: ☃ */ <= 'f'
|| var0/* $VF was: ☃ */ >= 'A' && var0/* $VF was: ☃ */ <= 'F';
}

private static boolean d(char var0) {
return var0/* $VF was: ☃ */ >= 'k' && var0/* $VF was: ☃ */ <= 'o'
|| var0/* $VF was: ☃ */ >= 'K' && var0/* $VF was: ☃ */ <= 'O'
|| var0/* $VF was: ☃ */ == 'r'
|| var0/* $VF was: ☃ */ == 'R';
}

public static String b(String var0) {
String var1/* $VF was: ☃ */ = "";
int var2/* $VF was: ☃x */ = -1;
int var3/* $VF was: ☃xx */ = var0/* $VF was: ☃ */.length();

  while ((var2/* $VF was: ☃x */ = var0/* $VF was: ☃ */.indexOf(167, var2/* $VF was: ☃x */ + 1)) != -1) {
     if (var2/* $VF was: ☃x */ < var3/* $VF was: ☃xx */ - 1) {
        char var4/* $VF was: ☃xxx */ = var0/* $VF was: ☃ */.charAt(var2/* $VF was: ☃x */ + 1);
        if (c(var4/* $VF was: ☃xxx */)) {
           var1/* $VF was: ☃ */ = "§" + var4/* $VF was: ☃xxx */;
        } else if (d(var4/* $VF was: ☃xxx */)) {
           var1/* $VF was: ☃ */ = var1/* $VF was: ☃ */ + "§" + var4/* $VF was: ☃xxx */;
        }
     }
  }

  return var1/* $VF was: ☃ */;

}

public boolean b() {
return this.l;
}

public int b(char var1) {
return this.f["0123456789abcdef".indexOf(var1/* $VF was: ☃ */)];
}
}
