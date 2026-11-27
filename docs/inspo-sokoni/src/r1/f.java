package r1;

import android.media.session.MediaSessionManager;

/* JADX INFO: loaded from: classes.dex */
public final class f extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MediaSessionManager.RemoteUserInfo f14990d;

    public f(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
        this.f14990d = remoteUserInfo;
    }

    public f(String str, int i10, int i11) {
        super(str, i10, i11);
        this.f14990d = new MediaSessionManager.RemoteUserInfo(str, i10, i11);
    }

    public static String a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return remoteUserInfo.getPackageName();
    }
}
