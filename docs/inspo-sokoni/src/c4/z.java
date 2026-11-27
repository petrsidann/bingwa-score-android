package c4;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class z extends x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakReference f3399c = new WeakReference(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f3400b;

    public z(byte[] bArr) {
        super(bArr);
        this.f3400b = f3399c;
    }

    @Override // c4.x
    public final byte[] i() {
        byte[] bArrK1;
        synchronized (this) {
            bArrK1 = (byte[]) this.f3400b.get();
            if (bArrK1 == null) {
                bArrK1 = k1();
                this.f3400b = new WeakReference(bArrK1);
            }
        }
        return bArrK1;
    }

    public abstract byte[] k1();
}
