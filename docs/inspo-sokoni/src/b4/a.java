package b4;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d4.a {
    public static final Parcelable.Creator<a> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f2783a;

    public a(Intent intent) {
        this.f2783a = intent;
    }

    public Intent S() {
        return this.f2783a;
    }

    public String T() {
        String stringExtra = this.f2783a.getStringExtra("google.message_id");
        return stringExtra == null ? this.f2783a.getStringExtra("message_id") : stringExtra;
    }

    public final Integer U() {
        if (this.f2783a.hasExtra("google.product_id")) {
            return Integer.valueOf(this.f2783a.getIntExtra("google.product_id", 0));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 1, this.f2783a, i10, false);
        d4.c.b(parcel, iA);
    }
}
