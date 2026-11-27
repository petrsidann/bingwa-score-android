package z2;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19772a = 1179403647;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileChannel f19773b;

    public i(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f19773b = new FileInputStream(file).getChannel();
    }

    public long B(ByteBuffer byteBuffer, long j10) throws IOException {
        t(byteBuffer, j10, 8);
        return byteBuffer.getLong();
    }

    public String C(ByteBuffer byteBuffer, long j10) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            long j11 = 1 + j10;
            short sV = v(byteBuffer, j10);
            if (sV == 0) {
                return sb2.toString();
            }
            sb2.append((char) sV);
            j10 = j11;
        }
    }

    public long D(ByteBuffer byteBuffer, long j10) throws IOException {
        t(byteBuffer, j10, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19773b.close();
    }

    public final long d(d dVar, long j10, long j11) {
        for (long j12 = 0; j12 < j10; j12++) {
            e eVarB = dVar.b(j12);
            if (eVarB.f19765a == 1) {
                long j13 = eVarB.f19767c;
                if (j13 <= j11 && j11 <= eVarB.f19768d + j13) {
                    return (j11 - j13) + eVarB.f19766b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public d e() throws IOException {
        this.f19773b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (D(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sV = v(byteBufferAllocate, 4L);
        boolean z10 = v(byteBufferAllocate, 5L) == 2;
        if (sV == 1) {
            return new g(z10, this);
        }
        if (sV == 2) {
            return new h(z10, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    public List<String> k() throws IOException {
        long j10;
        c cVarA;
        this.f19773b.position(0L);
        ArrayList arrayList = new ArrayList();
        d dVarE = e();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVarE.f19756a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = dVarE.f19761f;
        int i10 = 0;
        if (j11 == 65535) {
            j11 = dVarE.c(0).f19769a;
        }
        long j12 = 0;
        while (true) {
            if (j12 >= j11) {
                j10 = 0;
                break;
            }
            e eVarB = dVarE.b(j12);
            if (eVarB.f19765a == 2) {
                j10 = eVarB.f19766b;
                break;
            }
            j12++;
        }
        if (j10 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j13 = 0;
        do {
            cVarA = dVarE.a(j10, i10);
            long j14 = cVarA.f19754a;
            if (j14 == 1) {
                arrayList2.add(Long.valueOf(cVarA.f19755b));
            } else if (j14 == 5) {
                j13 = cVarA.f19755b;
            }
            i10++;
        } while (cVarA.f19754a != 0);
        if (j13 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jD = d(dVarE, j11, j13);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(C(byteBufferAllocate, ((Long) it.next()).longValue() + jD));
        }
        return arrayList;
    }

    public void t(ByteBuffer byteBuffer, long j10, int i10) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i10);
        long j11 = 0;
        while (j11 < i10) {
            int i11 = this.f19773b.read(byteBuffer, j10 + j11);
            if (i11 == -1) {
                throw new EOFException();
            }
            j11 += (long) i11;
        }
        byteBuffer.position(0);
    }

    public short v(ByteBuffer byteBuffer, long j10) throws IOException {
        t(byteBuffer, j10, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public int z(ByteBuffer byteBuffer, long j10) throws IOException {
        t(byteBuffer, j10, 2);
        return byteBuffer.getShort() & 65535;
    }
}
