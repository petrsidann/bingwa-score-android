package u4;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class v5 extends r8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f16886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f16887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x5 f16889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x5 f16890g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x5 f16891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x5 f16892i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final x5 f16893j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final x5 f16894k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final x5 f16895l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final x5 f16896m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final x5 f16897n;

    public v5(k7 k7Var) {
        super(k7Var);
        this.f16886c = (char) 0;
        this.f16887d = -1L;
        this.f16889f = new x5(this, 6, false, false);
        this.f16890g = new x5(this, 6, true, false);
        this.f16891h = new x5(this, 6, false, true);
        this.f16892i = new x5(this, 5, false, false);
        this.f16893j = new x5(this, 5, true, false);
        this.f16894k = new x5(this, 5, false, true);
        this.f16895l = new x5(this, 4, false, false);
        this.f16896m = new x5(this, 3, false, false);
        this.f16897n = new x5(this, 2, false, false);
    }

    public static String A(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(46)) == -1) ? "" : str.substring(0, iLastIndexOf);
    }

    public static Object r(String str) {
        if (str == null) {
            return null;
        }
        return new a6(str);
    }

    public static String s(boolean z10, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z10) {
                return String.valueOf(obj);
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l10.longValue()));
            return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof a6) {
                return ((a6) obj).f15983a;
            }
            return z10 ? "-" : String.valueOf(obj);
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z10 ? th.getClass().getName() : th.toString());
        String strA = A(k7.class.getCanonicalName());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && A(className).equals(strA)) {
                sb2.append(": ");
                sb2.append(stackTraceElement);
                break;
            }
        }
        return sb2.toString();
    }

    public static String t(boolean z10, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strS = s(z10, obj);
        String strS2 = s(z10, obj2);
        String strS3 = s(z10, obj3);
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strS)) {
            sb2.append(str2);
            sb2.append(strS);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strS2)) {
            str3 = str2;
        } else {
            sb2.append(str2);
            sb2.append(strS2);
        }
        if (!TextUtils.isEmpty(strS3)) {
            sb2.append(str3);
            sb2.append(strS3);
        }
        return sb2.toString();
    }

    public final x5 B() {
        return this.f16896m;
    }

    public final x5 C() {
        return this.f16889f;
    }

    public final x5 D() {
        return this.f16891h;
    }

    public final x5 E() {
        return this.f16890g;
    }

    public final x5 F() {
        return this.f16895l;
    }

    public final x5 G() {
        return this.f16897n;
    }

    public final x5 H() {
        return this.f16892i;
    }

    public final x5 I() {
        return this.f16894k;
    }

    public final x5 J() {
        return this.f16893j;
    }

    public final String K() {
        Pair<String, Long> pairA;
        if (e().f16330f == null || (pairA = e().f16330f.a()) == null || pairA == i6.B) {
            return null;
        }
        return String.valueOf(pairA.second) + ":" + ((String) pairA.first);
    }

    public final String L() {
        String str;
        synchronized (this) {
            if (this.f16888e == null) {
                this.f16888e = this.f16624a.N() != null ? this.f16624a.N() : "FA";
            }
            com.google.android.gms.common.internal.r.l(this.f16888e);
            str = this.f16888e;
        }
        return str;
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ h0 c() {
        return super.c();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ s5 d() {
        return super.d();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ i6 e() {
        return super.e();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ ab f() {
        return super.f();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ af g() {
        return super.g();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    @Override // u4.r8
    public final boolean p() {
        return false;
    }

    public final void u(int i10, String str) {
        Log.println(i10, L(), str);
    }

    public final void v(int i10, boolean z10, boolean z11, String str, Object obj, Object obj2, Object obj3) {
        String str2;
        if (!z10 && y(i10)) {
            u(i10, t(false, str, obj, obj2, obj3));
        }
        if (z11 || i10 < 5) {
            return;
        }
        com.google.android.gms.common.internal.r.l(str);
        d7 d7VarD = this.f16624a.D();
        if (d7VarD == null) {
            str2 = "Scheduler not set. Not logging error/warn";
        } else {
            if (d7VarD.o()) {
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 >= 9) {
                    i10 = 8;
                }
                d7VarD.y(new y5(this, i10, str, obj, obj2, obj3));
                return;
            }
            str2 = "Scheduler not initialized. Not logging error/warn";
        }
        u(6, str2);
    }

    public final boolean y(int i10) {
        return Log.isLoggable(L(), i10);
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ j4.d zzb() {
        return super.zzb();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ g zzd() {
        return super.zzd();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ v5 zzj() {
        return super.zzj();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ d7 zzl() {
        return super.zzl();
    }
}
