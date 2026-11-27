package ed;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7903a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f7904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f7905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f7906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f7907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f7908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f7909g;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.k.d(charsetForName, "forName(...)");
        f7904b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.k.d(charsetForName2, "forName(...)");
        f7905c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.k.d(charsetForName3, "forName(...)");
        f7906d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.k.d(charsetForName4, "forName(...)");
        f7907e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.k.d(charsetForName5, "forName(...)");
        f7908f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.k.d(charsetForName6, "forName(...)");
        f7909g = charsetForName6;
    }
}
