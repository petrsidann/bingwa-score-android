package h6;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class e0 extends p implements f0 {
    public e0() {
        super("com.google.android.play.core.integrity.protocol.IRequestDialogCallback");
    }

    @Override // h6.p
    public final boolean a(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 != 2) {
            return false;
        }
        Bundle bundle = (Bundle) q.a(parcel, Bundle.CREATOR);
        q.b(parcel);
        b(bundle);
        return true;
    }
}
