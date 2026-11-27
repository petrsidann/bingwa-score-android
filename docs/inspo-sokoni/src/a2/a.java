package a2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: a2.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0006a extends Binder implements a {

        /* JADX INFO: renamed from: a2.a$a$a, reason: collision with other inner class name */
        public static class C0007a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f333a;

            public C0007a(IBinder iBinder) {
                this.f333a = iBinder;
            }

            @Override // a2.a
            public void D(String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    parcelObtain.writeStringArray(strArr);
                    this.f333a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f333a;
            }
        }

        public static a b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0007a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }

    void D(String[] strArr);
}
