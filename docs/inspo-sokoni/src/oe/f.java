package oe;

import java.nio.channels.ReadableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
public interface f extends t, ReadableByteChannel {
    byte[] H(long j10);

    void V(long j10);

    g i(long j10);

    d o();

    boolean p();

    byte readByte();

    int readInt();

    short readShort();

    void skip(long j10);
}
