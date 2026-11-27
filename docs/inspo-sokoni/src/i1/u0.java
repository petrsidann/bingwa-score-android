package i1;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class u0 extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f10441b = new StringBuilder(128);

    public u0(String str) {
        this.f10440a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d();
    }

    public final void d() {
        if (this.f10441b.length() > 0) {
            Log.d(this.f10440a, this.f10441b.toString());
            StringBuilder sb2 = this.f10441b;
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        d();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                d();
            } else {
                this.f10441b.append(c10);
            }
        }
    }
}
