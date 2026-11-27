package je;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class b extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f11402b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11403a;

        static {
            int[] iArr = new int[zd.g.values().length];
            f11403a = iArr;
            try {
                iArr[zd.g.Resource.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11403a[zd.g.File.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11403a[zd.g.Asset.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11403a[zd.g.Network.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11403a[zd.g.Unknown.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public b() {
        this.f11411a = o.c();
    }

    public static b k() {
        if (f11402b == null) {
            f11402b = new b();
        }
        return f11402b;
    }

    @Override // je.m
    public String a(String str) {
        if (str == null) {
            return null;
        }
        Pattern patternCompile = Pattern.compile("^https?:\\/\\/", 2);
        Pattern patternCompile2 = Pattern.compile("^(asset:\\/\\/)(.*)", 2);
        Pattern patternCompile3 = Pattern.compile("^(file:\\/\\/)(.*)", 2);
        Pattern patternCompile4 = Pattern.compile("^(resource:\\/\\/)(.*)", 2);
        if (patternCompile.matcher(str).find()) {
            return str;
        }
        if (patternCompile2.matcher(str).find()) {
            return patternCompile2.matcher(str).replaceAll("$2");
        }
        if (patternCompile3.matcher(str).find()) {
            return patternCompile3.matcher(str).replaceAll("/$2");
        }
        if (patternCompile4.matcher(str).find()) {
            return patternCompile4.matcher(str).replaceAll("$2");
        }
        return null;
    }

    public Bitmap e(Context context, String str) {
        return null;
    }

    public final Bitmap f(String str) {
        String strA = a(str);
        try {
            return BitmapFactory.decodeFile(new File(strA).getAbsolutePath());
        } catch (Exception e10) {
            ae.b.e().b("BitmapUtils", "INVALID_ARGUMENTS", "The image file '" + strA + "' is invalid", e10);
            return null;
        }
    }

    public Bitmap g(Context context, String str) {
        int iJ = j(context, str);
        if (iJ <= 0) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), iJ);
    }

    public Bitmap h(Context context, String str, boolean z10) {
        Bitmap bitmapG;
        int i10 = a.f11403a[b(str).ordinal()];
        if (i10 == 1) {
            bitmapG = g(context, str);
        } else if (i10 == 2) {
            bitmapG = f(str);
        } else if (i10 != 3) {
            bitmapG = i10 != 4 ? null : i(a(str));
        } else {
            bitmapG = e(context, str);
        }
        return (bitmapG == null || !z10) ? bitmapG : n(bitmapG);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0037 -> B:46:0x005f). Please report as a decompilation issue!!! */
    public final Bitmap i(String str) throws Throwable {
        ?? r10;
        BufferedInputStream bufferedInputStream;
        ?? e10 = a(str);
        Bitmap bitmapDecodeStream = null;
        try {
            try {
                try {
                    URLConnection uRLConnectionOpenConnection = new URL(e10).openConnection();
                    uRLConnectionOpenConnection.setConnectTimeout(5000);
                    uRLConnectionOpenConnection.setReadTimeout(5000);
                    uRLConnectionOpenConnection.connect();
                    e10 = uRLConnectionOpenConnection.getInputStream();
                    try {
                        bufferedInputStream = new BufferedInputStream(e10, 8192);
                        try {
                            bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                            try {
                                bufferedInputStream.close();
                                r10 = bufferedInputStream;
                            } catch (IOException e11) {
                                e11.printStackTrace();
                                r10 = e11;
                            }
                            if (e10 != 0) {
                                e10.close();
                            }
                        } catch (Exception e12) {
                            e = e12;
                            e.printStackTrace();
                            r10 = bufferedInputStream;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                    r10 = bufferedInputStream;
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                    r10 = e13;
                                }
                            }
                            if (e10 != 0) {
                                e10.close();
                            }
                        }
                    } catch (Exception e14) {
                        e = e14;
                        bufferedInputStream = null;
                    } catch (Throwable th) {
                        r10 = 0;
                        th = th;
                        if (r10 != 0) {
                            try {
                                r10.close();
                            } catch (IOException e15) {
                                e15.printStackTrace();
                            }
                        }
                        if (e10 == 0) {
                            throw th;
                        }
                        try {
                            e10.close();
                            throw th;
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e17) {
                e = e17;
                e10 = 0;
                bufferedInputStream = null;
            } catch (Throwable th3) {
                r10 = 0;
                th = th3;
                e10 = 0;
            }
        } catch (IOException e18) {
            e10 = e18;
            e10.printStackTrace();
        }
        return bitmapDecodeStream;
    }

    public int j(Context context, String str) {
        String[] strArrSplit = a(str).split("\\/");
        try {
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[1];
            int identifier = context.getResources().getIdentifier(String.format("res_%1s", str3), str2, rd.a.K(context));
            return identifier == 0 ? context.getResources().getIdentifier(str3, str2, rd.a.K(context)) : identifier;
        } catch (Exception unused) {
            return 0;
        }
    }

    public Boolean l(Context context, String str) {
        if (this.f11411a.e(str).booleanValue()) {
            return Boolean.FALSE;
        }
        if (!d("^((http|https):\\/\\/)(www\\.)?[a-zA-Z0-9@:%.\\-_\\\\+~#?&\\/\\/=]{2,2048}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%.\\-_\\\\+~#?&\\/=]*)$", str, Boolean.FALSE).booleanValue() && !c("^file?:\\/\\/", str).booleanValue()) {
            return c("^resource?:\\/\\/", str).booleanValue() ? m(context, str) : c("^asset?:\\/\\/", str);
        }
        return Boolean.TRUE;
    }

    public final Boolean m(Context context, String str) {
        return Boolean.valueOf(j(context, str) > 0);
    }

    public Bitmap n(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return bitmap;
        }
        float f10 = width / 2.0f;
        canvas.drawCircle(f10, height / 2.0f, f10, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }
}
