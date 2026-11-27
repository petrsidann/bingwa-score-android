package h6;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f9646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9647b;

    public a(IBinder iBinder, String str) {
        this.f9646a = iBinder;
        this.f9647b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9646a;
    }

    public final Parcel b() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f9647b);
        return parcelObtain;
    }

    public final void f(int i10, Parcel parcel) {
        try {
            this.f9646a.transact(i10, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
