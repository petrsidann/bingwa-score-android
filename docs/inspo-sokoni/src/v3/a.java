package v3;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d4.a {
    public static final Parcelable.Creator<a> CREATOR = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f17107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GoogleSignInAccount f17108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PendingIntent f17109f;

    public a(String str, String str2, String str3, List<String> list, GoogleSignInAccount googleSignInAccount, PendingIntent pendingIntent) {
        this.f17104a = str;
        this.f17105b = str2;
        this.f17106c = str3;
        this.f17107d = (List) com.google.android.gms.common.internal.r.l(list);
        this.f17109f = pendingIntent;
        this.f17108e = googleSignInAccount;
    }

    public String S() {
        return this.f17105b;
    }

    public List<String> T() {
        return this.f17107d;
    }

    public PendingIntent U() {
        return this.f17109f;
    }

    public String V() {
        return this.f17104a;
    }

    public GoogleSignInAccount W() {
        return this.f17108e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return com.google.android.gms.common.internal.p.b(this.f17104a, aVar.f17104a) && com.google.android.gms.common.internal.p.b(this.f17105b, aVar.f17105b) && com.google.android.gms.common.internal.p.b(this.f17106c, aVar.f17106c) && com.google.android.gms.common.internal.p.b(this.f17107d, aVar.f17107d) && com.google.android.gms.common.internal.p.b(this.f17109f, aVar.f17109f) && com.google.android.gms.common.internal.p.b(this.f17108e, aVar.f17108e);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f17104a, this.f17105b, this.f17106c, this.f17107d, this.f17109f, this.f17108e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, V(), false);
        d4.c.E(parcel, 2, S(), false);
        d4.c.E(parcel, 3, this.f17106c, false);
        d4.c.G(parcel, 4, T(), false);
        d4.c.C(parcel, 5, W(), i10, false);
        d4.c.C(parcel, 6, U(), i10, false);
        d4.c.b(parcel, iA);
    }
}
