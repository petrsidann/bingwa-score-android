package cc;

import com.google.protobuf.e0;
import com.google.protobuf.g1;
import com.google.protobuf.j;
import com.google.protobuf.q;
import com.google.protobuf.w0;
import j6.m;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import vb.b1;
import vb.l1;
import vb.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile q f3478a = q.b();

    public static final class a<T extends w0> implements b1.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ThreadLocal<Reference<byte[]>> f3479d = new ThreadLocal<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g1<T> f3480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f3481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3482c;

        public a(T t10, int i10) {
            this.f3481b = (T) m.p(t10, "defaultInstance cannot be null");
            this.f3480a = (g1<T>) t10.g();
            this.f3482c = i10;
        }

        @Override // vb.b1.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public T a(InputStream inputStream) {
            j jVarF;
            byte[] bArr;
            if ((inputStream instanceof cc.a) && ((cc.a) inputStream).k() == this.f3480a) {
                try {
                    return (T) ((cc.a) inputStream).e();
                } catch (IllegalStateException unused) {
                }
            }
            try {
                if (inputStream instanceof s0) {
                    int iAvailable = inputStream.available();
                    if (iAvailable <= 0 || iAvailable > 4194304) {
                        if (iAvailable == 0) {
                            return this.f3481b;
                        }
                        jVarF = null;
                    } else {
                        ThreadLocal<Reference<byte[]>> threadLocal = f3479d;
                        Reference<byte[]> reference = threadLocal.get();
                        if (reference == null || (bArr = reference.get()) == null || bArr.length < iAvailable) {
                            bArr = new byte[iAvailable];
                            threadLocal.set(new WeakReference(bArr));
                        }
                        int i10 = iAvailable;
                        while (i10 > 0) {
                            int i11 = inputStream.read(bArr, iAvailable - i10, i10);
                            if (i11 == -1) {
                                break;
                            }
                            i10 -= i11;
                        }
                        if (i10 != 0) {
                            throw new RuntimeException("size inaccurate: " + iAvailable + " != " + (iAvailable - i10));
                        }
                        jVarF = j.k(bArr, 0, iAvailable);
                    }
                } else {
                    jVarF = null;
                }
                if (jVarF == null) {
                    jVarF = j.f(inputStream);
                }
                jVarF.H(com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER);
                int i12 = this.f3482c;
                if (i12 >= 0) {
                    jVarF.G(i12);
                }
                try {
                    return (T) d(jVarF);
                } catch (e0 e10) {
                    throw l1.f17419s.q("Invalid protobuf byte sequence").p(e10).d();
                }
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        }

        public final T d(j jVar) throws e0 {
            T tB = this.f3480a.b(jVar, b.f3478a);
            try {
                jVar.a(0);
                return tB;
            } catch (e0 e10) {
                e10.k(tB);
                throw e10;
            }
        }

        @Override // vb.b1.c
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public InputStream b(T t10) {
            return new cc.a(t10, this.f3480a);
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        m.p(inputStream, "inputStream cannot be null!");
        m.p(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j10 = 0;
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return j10;
            }
            outputStream.write(bArr, 0, i10);
            j10 += (long) i10;
        }
    }

    public static <T extends w0> b1.c<T> b(T t10) {
        return new a(t10, -1);
    }
}
