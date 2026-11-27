package p7;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class i1 implements o7.y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f14262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f14263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FirebaseAuth f14264g;

    public i1(String str, String str2, int i10, int i11, long j10, String str3, FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.r.g(str3, "sessionInfo cannot be empty.");
        com.google.android.gms.common.internal.r.m(firebaseAuth, "firebaseAuth cannot be null.");
        this.f14258a = com.google.android.gms.common.internal.r.g(str, "sharedSecretKey cannot be empty. This is required to generate QR code URL.");
        this.f14259b = com.google.android.gms.common.internal.r.g(str2, "hashAlgorithm cannot be empty.");
        this.f14260c = i10;
        this.f14261d = i11;
        this.f14262e = j10;
        this.f14263f = str3;
        this.f14264g = firebaseAuth;
    }

    @Override // o7.y0
    public final String a() {
        return this.f14259b;
    }

    @Override // o7.y0
    public final int b() {
        return this.f14260c;
    }

    @Override // o7.y0
    public final String c(String str, String str2) {
        com.google.android.gms.common.internal.r.g(str, "accountName cannot be empty.");
        com.google.android.gms.common.internal.r.g(str2, "issuer cannot be empty.");
        return String.format(null, "otpauth://totp/%s:%s?secret=%s&issuer=%s&algorithm=%s&digits=%d", str2, str, this.f14258a, str2, this.f14259b, Integer.valueOf(this.f14260c));
    }

    @Override // o7.y0
    public final String d() {
        return this.f14263f;
    }

    @Override // o7.y0
    public final String e() {
        return c(com.google.android.gms.common.internal.r.g(((o7.a0) com.google.android.gms.common.internal.r.m(this.f14264g.m(), "Current user cannot be null, since user is required to be logged in to enroll for TOTP MFA.")).P(), "Email cannot be empty, since verified email is required to use MFA."), this.f14264g.l().q());
    }

    @Override // o7.y0
    public final long f() {
        return this.f14262e;
    }

    @Override // o7.y0
    public final int g() {
        return this.f14261d;
    }

    @Override // o7.y0
    public final void h(String str) {
        com.google.android.gms.common.internal.r.g(str, "qrCodeUrl cannot be empty.");
        try {
            j(str);
        } catch (ActivityNotFoundException unused) {
            j("https://play.google.com/store/search?q=otpauth&c=apps");
        }
    }

    @Override // o7.y0
    public final String i() {
        return this.f14258a;
    }

    public final void j(String str) {
        this.f14264g.l().m().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
    }
}
