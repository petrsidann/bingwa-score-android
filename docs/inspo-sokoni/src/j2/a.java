package j2;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11159a = new a();

    @Override // j2.g
    public void a(String tag, String message) {
        kotlin.jvm.internal.k.e(tag, "tag");
        kotlin.jvm.internal.k.e(message, "message");
        Log.d(tag, message);
    }
}
