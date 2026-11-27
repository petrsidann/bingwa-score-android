package oe;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes2.dex */
public interface r extends Closeable, Flushable {
    void X(d dVar, long j10);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
