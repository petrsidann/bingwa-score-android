package b;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f2727g = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    /* JADX INFO: renamed from: b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0044a extends Binder implements a {

        /* JADX INFO: renamed from: b.a$a$a, reason: collision with other inner class name */
        public static class C0045a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f2728a;

            public C0045a(IBinder iBinder) {
                this.f2728a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2728a;
            }

            @Override // b.a
            public void d1(String str, int i10, String str2, Notification notification) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f2727g);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeString(str2);
                    b.b(parcelObtain, notification, 0);
                    this.f2728a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static a b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f2727g);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0045a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }

    public static class b {
        public static <T extends Parcelable> void b(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void d1(String str, int i10, String str2, Notification notification);
}
