package r6;

import e7.c0;
import e7.i0;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f15026a = new byte[0];

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15027a;

        static {
            int[] iArr = new int[i0.values().length];
            f15027a = iArr;
            try {
                iArr[i0.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15027a[i0.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15027a[i0.TINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15027a[i0.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static byte[] a(c0.c cVar) throws GeneralSecurityException {
        ByteBuffer byteBufferPut;
        int i10 = a.f15027a[cVar.T().ordinal()];
        if (i10 == 1 || i10 == 2) {
            byteBufferPut = ByteBuffer.allocate(5).put((byte) 0);
        } else {
            if (i10 != 3) {
                if (i10 == 4) {
                    return f15026a;
                }
                throw new GeneralSecurityException("unknown output prefix type");
            }
            byteBufferPut = ByteBuffer.allocate(5).put((byte) 1);
        }
        return byteBufferPut.putInt(cVar.S()).array();
    }
}
