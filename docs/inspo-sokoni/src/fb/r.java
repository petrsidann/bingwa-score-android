package fb;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements h<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f8301a = Charset.forName("UTF8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f8302b = new r();

    @Override // fb.h
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String b(ByteBuffer byteBuffer) {
        byte[] bArrArray;
        int iArrayOffset;
        if (byteBuffer == null) {
            return null;
        }
        int iRemaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArrArray = byteBuffer.array();
            iArrayOffset = byteBuffer.arrayOffset();
        } else {
            bArrArray = new byte[iRemaining];
            byteBuffer.get(bArrArray);
            iArrayOffset = 0;
        }
        return new String(bArrArray, iArrayOffset, iRemaining, f8301a);
    }

    @Override // fb.h
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(f8301a);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bytes.length);
        byteBufferAllocateDirect.put(bytes);
        return byteBufferAllocateDirect;
    }
}
