package xb;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o0 implements y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y1 f18783a;

    public o0(y1 y1Var) {
        this.f18783a = (y1) j6.m.p(y1Var, "buf");
    }

    @Override // xb.y1
    public void A() {
        this.f18783a.A();
    }

    @Override // xb.y1
    public void N(OutputStream outputStream, int i10) {
        this.f18783a.N(outputStream, i10);
    }

    @Override // xb.y1
    public void W(ByteBuffer byteBuffer) {
        this.f18783a.W(byteBuffer);
    }

    @Override // xb.y1
    public int a() {
        return this.f18783a.a();
    }

    @Override // xb.y1
    public y1 l(int i10) {
        return this.f18783a.l(i10);
    }

    @Override // xb.y1
    public boolean markSupported() {
        return this.f18783a.markSupported();
    }

    @Override // xb.y1
    public int readUnsignedByte() {
        return this.f18783a.readUnsignedByte();
    }

    @Override // xb.y1
    public void reset() {
        this.f18783a.reset();
    }

    @Override // xb.y1
    public void skipBytes(int i10) {
        this.f18783a.skipBytes(i10);
    }

    public String toString() {
        return j6.g.b(this).d("delegate", this.f18783a).toString();
    }

    @Override // xb.y1
    public void w(byte[] bArr, int i10, int i11) {
        this.f18783a.w(bArr, i10, i11);
    }
}
