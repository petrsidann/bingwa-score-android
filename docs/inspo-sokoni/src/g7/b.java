package g7;

import r6.x;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f8666a;

    public b(a aVar) {
        this.f8666a = aVar;
    }

    public static b a(byte[] bArr, x xVar) {
        if (xVar != null) {
            return new b(a.a(bArr));
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public int b() {
        return this.f8666a.c();
    }
}
