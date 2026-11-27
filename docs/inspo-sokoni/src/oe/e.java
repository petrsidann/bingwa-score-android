package oe;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
public interface e extends r, WritableByteChannel {
    @Override // oe.r, java.io.Flushable
    void flush();

    e u(String str);

    e write(byte[] bArr);

    e writeByte(int i10);

    e writeInt(int i10);

    e writeShort(int i10);
}
