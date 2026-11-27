package u4;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ad extends fe {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, zc> f15992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n6 f15993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n6 f15994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n6 f15995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n6 f15996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n6 f15997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n6 f15998j;

    public ad(ge geVar) {
        super(geVar);
        this.f15992d = new HashMap();
        i6 i6VarE = e();
        Objects.requireNonNull(i6VarE);
        this.f15993e = new n6(i6VarE, "last_delete_stale", 0L);
        i6 i6VarE2 = e();
        Objects.requireNonNull(i6VarE2);
        this.f15994f = new n6(i6VarE2, "last_delete_stale_batch", 0L);
        i6 i6VarE3 = e();
        Objects.requireNonNull(i6VarE3);
        this.f15995g = new n6(i6VarE3, "backoff", 0L);
        i6 i6VarE4 = e();
        Objects.requireNonNull(i6VarE4);
        this.f15996h = new n6(i6VarE4, "last_upload", 0L);
        i6 i6VarE5 = e();
        Objects.requireNonNull(i6VarE5);
        this.f15997i = new n6(i6VarE5, "last_upload_attempt", 0L);
        i6 i6VarE6 = e();
        Objects.requireNonNull(i6VarE6);
        this.f15998j = new n6(i6VarE6, "midnight_offset", 0L);
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

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ we k() {
        return super.k();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ kf l() {
        return super.l();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ s m() {
        return super.m();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ u6 n() {
        return super.n();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ ad o() {
        return super.o();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ ee p() {
        return super.p();
    }

    @Override // u4.fe
    public final boolean t() {
        return false;
    }

    @Deprecated
    public final Pair<String, Boolean> u(String str) {
        zc zcVar;
        p3.a.C0248a c0248aA;
        j();
        long jB = zzb().b();
        zc zcVar2 = this.f15992d.get(str);
        if (zcVar2 != null && jB < zcVar2.f17006c) {
            return new Pair<>(zcVar2.f17004a, Boolean.valueOf(zcVar2.f17005b));
        }
        p3.a.b(true);
        long jA = a().A(str) + jB;
        try {
            try {
                c0248aA = p3.a.a(zza());
            } catch (PackageManager.NameNotFoundException unused) {
                if (zcVar2 != null && jB < zcVar2.f17006c + a().y(str, p0.f16641c)) {
                    return new Pair<>(zcVar2.f17004a, Boolean.valueOf(zcVar2.f17005b));
                }
                c0248aA = null;
            }
            if (c0248aA == null) {
                return new Pair<>("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
            }
            String strA = c0248aA.a();
            zcVar = strA != null ? new zc(strA, c0248aA.b(), jA) : new zc("", c0248aA.b(), jA);
            this.f15992d.put(str, zcVar);
            p3.a.b(false);
            return new Pair<>(zcVar.f17004a, Boolean.valueOf(zcVar.f17005b));
        } catch (Exception e10) {
            zzj().B().b("Unable to get advertising id", e10);
            zcVar = new zc("", false, jA);
        }
    }

    public final Pair<String, Boolean> v(String str, s8 s8Var) {
        return s8Var.w() ? u(str) : new Pair<>("", Boolean.FALSE);
    }

    @Deprecated
    public final String w(String str, boolean z10) {
        j();
        String str2 = z10 ? (String) u(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestO0 = af.O0();
        if (messageDigestO0 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestO0.digest(str2.getBytes())));
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
