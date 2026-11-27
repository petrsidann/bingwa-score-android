package q3;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class b extends d4.a {
    public static final Parcelable.Creator<b> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public String f14638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Account f14639d;

    public b(int i10, int i11, String str, Account account) {
        this.f14636a = i10;
        this.f14637b = i11;
        this.f14638c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f14639d = account;
        } else {
            this.f14639d = new Account(str, "com.google");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f14636a);
        d4.c.t(parcel, 2, this.f14637b);
        d4.c.E(parcel, 3, this.f14638c, false);
        d4.c.C(parcel, 4, this.f14639d, i10, false);
        d4.c.b(parcel, iA);
    }
}
