package h6;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class v extends p implements w {
    public static w b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
        return iInterfaceQueryLocalInterface instanceof w ? (w) iInterfaceQueryLocalInterface : new u(iBinder);
    }
}
