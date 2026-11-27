package fb;

import d9.a0;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class p implements h<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f8296a = new p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f8297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f8298c;

    public static final class a extends ByteArrayOutputStream {
        public byte[] d() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    static {
        f8297b = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        f8298c = Charset.forName("UTF8");
    }

    public static final void c(ByteBuffer byteBuffer, int i10) {
        int iPosition = byteBuffer.position() % i10;
        if (iPosition != 0) {
            byteBuffer.position((byteBuffer.position() + i10) - iPosition);
        }
    }

    public static final byte[] d(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[e(byteBuffer)];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static final int e(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        int i10 = byteBuffer.get() & 255;
        if (i10 < 254) {
            return i10;
        }
        return i10 == 254 ? byteBuffer.getChar() : byteBuffer.getInt();
    }

    public static final void h(ByteArrayOutputStream byteArrayOutputStream, int i10) {
        int size = byteArrayOutputStream.size() % i10;
        if (size != 0) {
            for (int i11 = 0; i11 < i10 - size; i11++) {
                byteArrayOutputStream.write(0);
            }
        }
    }

    public static final void i(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        o(byteArrayOutputStream, bArr.length);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    public static final void j(ByteArrayOutputStream byteArrayOutputStream, int i10) {
        if (f8297b) {
            byteArrayOutputStream.write(i10);
            i10 >>>= 8;
        } else {
            byteArrayOutputStream.write(i10 >>> 8);
        }
        byteArrayOutputStream.write(i10);
    }

    public static final void k(ByteArrayOutputStream byteArrayOutputStream, double d10) {
        n(byteArrayOutputStream, Double.doubleToLongBits(d10));
    }

    public static final void l(ByteArrayOutputStream byteArrayOutputStream, float f10) {
        m(byteArrayOutputStream, Float.floatToIntBits(f10));
    }

    public static final void m(ByteArrayOutputStream byteArrayOutputStream, int i10) {
        if (f8297b) {
            byteArrayOutputStream.write(i10);
            byteArrayOutputStream.write(i10 >>> 8);
            byteArrayOutputStream.write(i10 >>> 16);
            i10 >>>= 24;
        } else {
            byteArrayOutputStream.write(i10 >>> 24);
            byteArrayOutputStream.write(i10 >>> 16);
            byteArrayOutputStream.write(i10 >>> 8);
        }
        byteArrayOutputStream.write(i10);
    }

    public static final void n(ByteArrayOutputStream byteArrayOutputStream, long j10) {
        if (f8297b) {
            byteArrayOutputStream.write((byte) j10);
            byteArrayOutputStream.write((byte) (j10 >>> 8));
            byteArrayOutputStream.write((byte) (j10 >>> 16));
            byteArrayOutputStream.write((byte) (j10 >>> 24));
            byteArrayOutputStream.write((byte) (j10 >>> 32));
            byteArrayOutputStream.write((byte) (j10 >>> 40));
            byteArrayOutputStream.write((byte) (j10 >>> 48));
            j10 >>>= 56;
        } else {
            byteArrayOutputStream.write((byte) (j10 >>> 56));
            byteArrayOutputStream.write((byte) (j10 >>> 48));
            byteArrayOutputStream.write((byte) (j10 >>> 40));
            byteArrayOutputStream.write((byte) (j10 >>> 32));
            byteArrayOutputStream.write((byte) (j10 >>> 24));
            byteArrayOutputStream.write((byte) (j10 >>> 16));
            byteArrayOutputStream.write((byte) (j10 >>> 8));
        }
        byteArrayOutputStream.write((byte) j10);
    }

    public static final void o(ByteArrayOutputStream byteArrayOutputStream, int i10) {
        if (i10 < 254) {
            byteArrayOutputStream.write(i10);
        } else if (i10 <= 65535) {
            byteArrayOutputStream.write(254);
            j(byteArrayOutputStream, i10);
        } else {
            byteArrayOutputStream.write(255);
            m(byteArrayOutputStream, i10);
        }
    }

    @Override // fb.h
    public ByteBuffer a(Object obj) {
        if (obj == null) {
            return null;
        }
        a aVar = new a();
        p(aVar, obj);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.d(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // fb.h
    public Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object objF = f(byteBuffer);
        if (byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        return objF;
    }

    public final Object f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            return g(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.HashMap, java.util.Map] */
    public Object g(byte b10, ByteBuffer byteBuffer) {
        int iE;
        int iE2;
        double[] dArr;
        ?? arrayList;
        float[] fArr;
        int i10 = 0;
        switch (b10) {
            case 0:
                return null;
            case 1:
                return Boolean.TRUE;
            case 2:
                return Boolean.FALSE;
            case 3:
                return Integer.valueOf(byteBuffer.getInt());
            case 4:
                return Long.valueOf(byteBuffer.getLong());
            case 5:
                return new BigInteger(new String(d(byteBuffer), f8298c), 16);
            case 6:
                c(byteBuffer, 8);
                return Double.valueOf(byteBuffer.getDouble());
            case 7:
                return new String(d(byteBuffer), f8298c);
            case 8:
                return d(byteBuffer);
            case 9:
                iE = e(byteBuffer);
                int[] iArr = new int[iE];
                c(byteBuffer, 4);
                byteBuffer.asIntBuffer().get(iArr);
                fArr = iArr;
                byteBuffer.position(byteBuffer.position() + (iE * 4));
                return fArr;
            case 10:
                iE2 = e(byteBuffer);
                long[] jArr = new long[iE2];
                c(byteBuffer, 8);
                byteBuffer.asLongBuffer().get(jArr);
                dArr = jArr;
                byteBuffer.position(byteBuffer.position() + (iE2 * 8));
                return dArr;
            case 11:
                iE2 = e(byteBuffer);
                double[] dArr2 = new double[iE2];
                c(byteBuffer, 8);
                byteBuffer.asDoubleBuffer().get(dArr2);
                dArr = dArr2;
                byteBuffer.position(byteBuffer.position() + (iE2 * 8));
                return dArr;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                int iE3 = e(byteBuffer);
                arrayList = new ArrayList(iE3);
                while (i10 < iE3) {
                    arrayList.add(f(byteBuffer));
                    i10++;
                }
                return arrayList;
            case 13:
                int iE4 = e(byteBuffer);
                arrayList = new HashMap();
                while (i10 < iE4) {
                    arrayList.put(f(byteBuffer), f(byteBuffer));
                    i10++;
                }
                return arrayList;
            case 14:
                iE = e(byteBuffer);
                float[] fArr2 = new float[iE];
                c(byteBuffer, 4);
                byteBuffer.asFloatBuffer().get(fArr2);
                fArr = fArr2;
                byteBuffer.position(byteBuffer.position() + (iE * 4));
                return fArr;
            default:
                throw new IllegalArgumentException("Message corrupted");
        }
    }

    public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        int i10 = 0;
        if (obj == null || obj.equals(null)) {
            byteArrayOutputStream.write(0);
            return;
        }
        if (obj instanceof Boolean) {
            byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 2);
            return;
        }
        if (obj instanceof Number) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                byteArrayOutputStream.write(3);
                m(byteArrayOutputStream, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                byteArrayOutputStream.write(4);
                n(byteArrayOutputStream, ((Long) obj).longValue());
                return;
            }
            if ((obj instanceof Float) || (obj instanceof Double)) {
                byteArrayOutputStream.write(6);
                h(byteArrayOutputStream, 8);
                k(byteArrayOutputStream, ((Number) obj).doubleValue());
                return;
            } else {
                if (!(obj instanceof BigInteger)) {
                    throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
                }
                byteArrayOutputStream.write(5);
                i(byteArrayOutputStream, ((BigInteger) obj).toString(16).getBytes(f8298c));
                return;
            }
        }
        if (obj instanceof CharSequence) {
            byteArrayOutputStream.write(7);
            i(byteArrayOutputStream, obj.toString().getBytes(f8298c));
            return;
        }
        if (obj instanceof byte[]) {
            byteArrayOutputStream.write(8);
            i(byteArrayOutputStream, (byte[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            byteArrayOutputStream.write(9);
            int[] iArr = (int[]) obj;
            o(byteArrayOutputStream, iArr.length);
            h(byteArrayOutputStream, 4);
            int length = iArr.length;
            while (i10 < length) {
                m(byteArrayOutputStream, iArr[i10]);
                i10++;
            }
            return;
        }
        if (obj instanceof long[]) {
            byteArrayOutputStream.write(10);
            long[] jArr = (long[]) obj;
            o(byteArrayOutputStream, jArr.length);
            h(byteArrayOutputStream, 8);
            int length2 = jArr.length;
            while (i10 < length2) {
                n(byteArrayOutputStream, jArr[i10]);
                i10++;
            }
            return;
        }
        if (obj instanceof double[]) {
            byteArrayOutputStream.write(11);
            double[] dArr = (double[]) obj;
            o(byteArrayOutputStream, dArr.length);
            h(byteArrayOutputStream, 8);
            int length3 = dArr.length;
            while (i10 < length3) {
                k(byteArrayOutputStream, dArr[i10]);
                i10++;
            }
            return;
        }
        if (obj instanceof List) {
            byteArrayOutputStream.write(12);
            List list = (List) obj;
            o(byteArrayOutputStream, list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                p(byteArrayOutputStream, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            byteArrayOutputStream.write(13);
            Map map = (Map) obj;
            o(byteArrayOutputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                p(byteArrayOutputStream, entry.getKey());
                p(byteArrayOutputStream, entry.getValue());
            }
            return;
        }
        if (!(obj instanceof float[])) {
            throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass() + "'");
        }
        byteArrayOutputStream.write(14);
        float[] fArr = (float[]) obj;
        o(byteArrayOutputStream, fArr.length);
        h(byteArrayOutputStream, 4);
        int length4 = fArr.length;
        while (i10 < length4) {
            l(byteArrayOutputStream, fArr[i10]);
            i10++;
        }
    }
}
