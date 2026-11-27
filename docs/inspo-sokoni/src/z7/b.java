package z7;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20354a = 0;

    public long d() {
        return this.f20354a;
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        this.f20354a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f20354a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > bArr.length || i11 < 0 || (i12 = i10 + i11) > bArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.f20354a += (long) i11;
    }
}
