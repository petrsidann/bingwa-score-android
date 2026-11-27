package p8;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f14391b = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f14392c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static p f14393d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t8.a f14394a;

    public p(t8.a aVar) {
        this.f14394a = aVar;
    }

    public static p c() {
        return d(t8.b.b());
    }

    public static p d(t8.a aVar) {
        if (f14393d == null) {
            f14393d = new p(aVar);
        }
        return f14393d;
    }

    public static boolean g(String str) {
        return f14392c.matcher(str).matches();
    }

    public static boolean h(String str) {
        return str.contains(":");
    }

    public long a() {
        return this.f14394a.a();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(r8.d dVar) {
        return TextUtils.isEmpty(dVar.b()) || dVar.h() + dVar.c() < b() + f14391b;
    }
}
