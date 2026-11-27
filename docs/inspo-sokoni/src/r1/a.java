package r1;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f14989a;

    public a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String strA = f.a(remoteUserInfo);
        if (strA == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(strA)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        this.f14989a = new f(remoteUserInfo);
    }

    public a(String str, int i10, int i11) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        this.f14989a = Build.VERSION.SDK_INT >= 28 ? new f(str, i10, i11) : new g(str, i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return this.f14989a.equals(((a) obj).f14989a);
        }
        return false;
    }

    public int hashCode() {
        return this.f14989a.hashCode();
    }
}
