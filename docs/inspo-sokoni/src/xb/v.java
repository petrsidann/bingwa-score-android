package xb;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class v extends xb.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f<Void> f19004f = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f<Void> f19005l = new b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final f<byte[]> f19006m = new c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f<ByteBuffer> f19007n = new d();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final g<OutputStream> f19008o = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque<y1> f19009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Deque<y1> f19010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<y1> f19012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19013e;

    public class a implements f<Void> {
        @Override // xb.v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y1 y1Var, int i10, Void r10, int i11) {
            return y1Var.readUnsignedByte();
        }
    }

    public class b implements f<Void> {
        @Override // xb.v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y1 y1Var, int i10, Void r10, int i11) {
            y1Var.skipBytes(i10);
            return 0;
        }
    }

    public class c implements f<byte[]> {
        @Override // xb.v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y1 y1Var, int i10, byte[] bArr, int i11) {
            y1Var.w(bArr, i11, i10);
            return i11 + i10;
        }
    }

    public class d implements f<ByteBuffer> {
        @Override // xb.v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y1 y1Var, int i10, ByteBuffer byteBuffer, int i11) {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i10);
            y1Var.W(byteBuffer);
            byteBuffer.limit(iLimit);
            return 0;
        }
    }

    public class e implements g<OutputStream> {
        @Override // xb.v.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(y1 y1Var, int i10, OutputStream outputStream, int i11) {
            y1Var.N(outputStream, i10);
            return 0;
        }
    }

    public interface f<T> extends g<T> {
    }

    public interface g<T> {
        int a(y1 y1Var, int i10, T t10, int i11);
    }

    public v() {
        this.f19012d = new ArrayDeque(2);
        this.f19009a = new ArrayDeque();
    }

    public v(int i10) {
        this.f19012d = new ArrayDeque(2);
        this.f19009a = new ArrayDeque(i10);
    }

    @Override // xb.b, xb.y1
    public void A() {
        if (this.f19010b == null) {
            this.f19010b = new ArrayDeque(Math.min(this.f19009a.size(), 16));
        }
        while (!this.f19010b.isEmpty()) {
            this.f19010b.remove().close();
        }
        this.f19013e = true;
        y1 y1VarPeek = this.f19009a.peek();
        if (y1VarPeek != null) {
            y1VarPeek.A();
        }
    }

    public final <T> int B(f<T> fVar, int i10, T t10, int i11) {
        try {
            return z(fVar, i10, t10, i11);
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // xb.y1
    public void N(OutputStream outputStream, int i10) {
        z(f19008o, i10, outputStream, 0);
    }

    @Override // xb.y1
    public void W(ByteBuffer byteBuffer) {
        B(f19007n, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // xb.y1
    public int a() {
        return this.f19011c;
    }

    @Override // xb.b, xb.y1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.f19009a.isEmpty()) {
            this.f19009a.remove().close();
        }
        if (this.f19010b != null) {
            while (!this.f19010b.isEmpty()) {
                this.f19010b.remove().close();
            }
        }
    }

    public void e(y1 y1Var) {
        boolean z10 = this.f19013e && this.f19009a.isEmpty();
        v(y1Var);
        if (z10) {
            this.f19009a.peek().A();
        }
    }

    public final void k() {
        if (!this.f19013e) {
            this.f19009a.remove().close();
            return;
        }
        this.f19010b.add(this.f19009a.remove());
        y1 y1VarPeek = this.f19009a.peek();
        if (y1VarPeek != null) {
            y1VarPeek.A();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [xb.y1] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [xb.y1] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [xb.v] */
    /* JADX WARN: Type inference failed for: r1v3, types: [xb.v] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // xb.y1
    public y1 l(int i10) {
        y1 y1VarPoll;
        int i11;
        y1 y1VarL;
        ?? r10;
        ?? r11;
        if (i10 <= 0) {
            return z1.a();
        }
        d(i10);
        this.f19011c -= i10;
        ?? r12 = 0;
        ?? vVar = 0;
        while (true) {
            y1 y1VarPeek = this.f19009a.peek();
            int iA = y1VarPeek.a();
            if (iA > i10) {
                y1VarL = y1VarPeek.l(i10);
                i11 = 0;
            } else {
                if (this.f19013e) {
                    y1VarPoll = y1VarPeek.l(iA);
                    k();
                } else {
                    y1VarPoll = this.f19009a.poll();
                }
                y1 y1Var = y1VarPoll;
                i11 = i10 - iA;
                y1VarL = y1Var;
            }
            if (r12 == 0) {
                r11 = y1VarL;
                r10 = vVar;
            } else {
                if (vVar == 0) {
                    vVar = new v(i11 != 0 ? Math.min(this.f19009a.size() + 2, 16) : 2);
                    vVar.e(r12);
                    r12 = vVar;
                }
                vVar.e(y1VarL);
                r11 = r12;
                r10 = vVar;
            }
            if (i11 <= 0) {
                return r11;
            }
            i10 = i11;
            r12 = r11;
            vVar = r10;
        }
    }

    @Override // xb.b, xb.y1
    public boolean markSupported() {
        Iterator<y1> it = this.f19009a.iterator();
        while (it.hasNext()) {
            if (!it.next().markSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // xb.y1
    public int readUnsignedByte() {
        return B(f19004f, 1, null, 0);
    }

    @Override // xb.b, xb.y1
    public void reset() {
        if (!this.f19013e) {
            throw new InvalidMarkException();
        }
        y1 y1VarPeek = this.f19009a.peek();
        if (y1VarPeek != null) {
            int iA = y1VarPeek.a();
            y1VarPeek.reset();
            this.f19011c += y1VarPeek.a() - iA;
        }
        while (true) {
            y1 y1VarPollLast = this.f19010b.pollLast();
            if (y1VarPollLast == null) {
                return;
            }
            y1VarPollLast.reset();
            this.f19009a.addFirst(y1VarPollLast);
            this.f19011c += y1VarPollLast.a();
        }
    }

    @Override // xb.y1
    public void skipBytes(int i10) {
        B(f19005l, i10, null, 0);
    }

    public final void t() {
        if (this.f19009a.peek().a() == 0) {
            k();
        }
    }

    public final void v(y1 y1Var) {
        if (!(y1Var instanceof v)) {
            this.f19009a.add(y1Var);
            this.f19011c += y1Var.a();
            return;
        }
        v vVar = (v) y1Var;
        while (!vVar.f19009a.isEmpty()) {
            this.f19009a.add(vVar.f19009a.remove());
        }
        this.f19011c += vVar.f19011c;
        vVar.f19011c = 0;
        vVar.close();
    }

    @Override // xb.y1
    public void w(byte[] bArr, int i10, int i11) {
        B(f19006m, i11, bArr, i10);
    }

    public final <T> int z(g<T> gVar, int i10, T t10, int i11) {
        d(i10);
        if (this.f19009a.isEmpty()) {
            t();
        } else {
            t();
        }
        while (i10 > 0 && !this.f19009a.isEmpty()) {
            y1 y1VarPeek = this.f19009a.peek();
            int iMin = Math.min(i10, y1VarPeek.a());
            i11 = gVar.a(y1VarPeek, iMin, t10, i11);
            i10 -= iMin;
            this.f19011c -= iMin;
            t();
        }
        if (i10 <= 0) {
            return i11;
        }
        throw new AssertionError("Failed executing read operation");
    }
}
