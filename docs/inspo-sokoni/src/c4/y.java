package c4;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class y extends x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f3398b;

    public y(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f3398b = bArr;
    }

    @Override // c4.x
    public final byte[] i() {
        return this.f3398b;
    }
}
