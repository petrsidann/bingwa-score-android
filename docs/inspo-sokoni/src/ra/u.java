package ra;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f15294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f15298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f15299g;

    public enum a {
        kKeyboard(0),
        kDirectionalPad(1),
        kGamepad(2),
        kJoystick(3),
        kHdmi(4);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f15306a;

        a(long j10) {
            this.f15306a = j10;
        }

        public long h() {
            return this.f15306a;
        }
    }

    public enum b {
        kDown(0),
        kUp(1),
        kRepeat(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f15311a;

        b(long j10) {
            this.f15311a = j10;
        }

        public long h() {
            return this.f15311a;
        }
    }

    public ByteBuffer a() {
        try {
            String str = this.f15299g;
            byte[] bytes = str == null ? null : str.getBytes("UTF-8");
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(length + 56);
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocateDirect.putLong(length);
            byteBufferAllocateDirect.putLong(this.f15293a);
            byteBufferAllocateDirect.putLong(this.f15294b.h());
            byteBufferAllocateDirect.putLong(this.f15295c);
            byteBufferAllocateDirect.putLong(this.f15296d);
            byteBufferAllocateDirect.putLong(this.f15297e ? 1L : 0L);
            byteBufferAllocateDirect.putLong(this.f15298f.h());
            if (bytes != null) {
                byteBufferAllocateDirect.put(bytes);
            }
            return byteBufferAllocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }
}
