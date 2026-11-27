package c;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f3103h = "android$support$v4$os$IResultReceiver".replace('$', '.');

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0056a extends Binder implements a {

        /* JADX INFO: renamed from: c.a$a$a, reason: collision with other inner class name */
        public static class C0057a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f3104a;

            public C0057a(IBinder iBinder) {
                this.f3104a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3104a;
            }
        }

        public AbstractBinderC0056a() {
            attachInterface(this, a.f3103h);
        }

        public static a b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f3103h);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0057a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            String str = a.f3103h;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            h1(parcel.readInt(), (Bundle) b.b(parcel, Bundle.CREATOR));
            return true;
        }
    }

    public static class b {
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void h1(int i10, Bundle bundle);
}
