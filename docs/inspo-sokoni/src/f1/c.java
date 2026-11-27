package f1;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f8030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f8033e = d.a();

    public int a(int i10) {
        return i10 + this.f8030b.getInt(i10);
    }

    public int b(int i10) {
        if (i10 < this.f8032d) {
            return this.f8030b.getShort(this.f8031c + i10);
        }
        return 0;
    }

    public void c(int i10, ByteBuffer byteBuffer) {
        short s10;
        this.f8030b = byteBuffer;
        if (byteBuffer != null) {
            this.f8029a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f8031c = i11;
            s10 = this.f8030b.getShort(i11);
        } else {
            s10 = 0;
            this.f8029a = 0;
            this.f8031c = 0;
        }
        this.f8032d = s10;
    }

    public int d(int i10) {
        int i11 = i10 + this.f8029a;
        return i11 + this.f8030b.getInt(i11) + 4;
    }

    public int e(int i10) {
        int i11 = i10 + this.f8029a;
        return this.f8030b.getInt(i11 + this.f8030b.getInt(i11));
    }
}
