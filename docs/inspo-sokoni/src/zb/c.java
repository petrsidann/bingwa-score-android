package zb;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static String a(String str, String str2) {
        try {
            return "Basic " + oe.g.t((str + ":" + str2).getBytes("ISO-8859-1")).d();
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
