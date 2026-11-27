package vc;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends ByteArrayOutputStream {
    public c(int i10) {
        super(i10);
    }

    public final byte[] d() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        k.d(buf, "buf");
        return buf;
    }
}
