package m4;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.common.zzb;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: m4.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0217a extends zzb implements a {
        public AbstractBinderC0217a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new c(iBinder);
        }
    }
}
