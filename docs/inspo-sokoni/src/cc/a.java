package cc;

import com.google.protobuf.g1;
import com.google.protobuf.l;
import com.google.protobuf.w0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import vb.s0;
import vb.x;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends InputStream implements x, s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w0 f3475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g1<?> f3476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteArrayInputStream f3477c;

    public a(w0 w0Var, g1<?> g1Var) {
        this.f3475a = w0Var;
        this.f3476b = g1Var;
    }

    @Override // java.io.InputStream
    public int available() {
        w0 w0Var = this.f3475a;
        if (w0Var != null) {
            return w0Var.d();
        }
        ByteArrayInputStream byteArrayInputStream = this.f3477c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // vb.x
    public int d(OutputStream outputStream) {
        w0 w0Var = this.f3475a;
        if (w0Var != null) {
            int iD = w0Var.d();
            this.f3475a.j(outputStream);
            this.f3475a = null;
            return iD;
        }
        ByteArrayInputStream byteArrayInputStream = this.f3477c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int iA = (int) b.a(byteArrayInputStream, outputStream);
        this.f3477c = null;
        return iA;
    }

    public w0 e() {
        w0 w0Var = this.f3475a;
        if (w0Var != null) {
            return w0Var;
        }
        throw new IllegalStateException("message not available");
    }

    public g1<?> k() {
        return this.f3476b;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f3475a != null) {
            this.f3477c = new ByteArrayInputStream(this.f3475a.i());
            this.f3475a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f3477c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        w0 w0Var = this.f3475a;
        if (w0Var != null) {
            int iD = w0Var.d();
            if (iD == 0) {
                this.f3475a = null;
                this.f3477c = null;
                return -1;
            }
            if (i11 >= iD) {
                l lVarH0 = l.h0(bArr, i10, iD);
                this.f3475a.l(lVarH0);
                lVarH0.c0();
                lVarH0.d();
                this.f3475a = null;
                this.f3477c = null;
                return iD;
            }
            this.f3477c = new ByteArrayInputStream(this.f3475a.i());
            this.f3475a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f3477c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i10, i11);
        }
        return -1;
    }
}
