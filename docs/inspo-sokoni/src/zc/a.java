package zc;

import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends c {
    @Override // zc.c
    public int b() {
        return d().nextInt();
    }

    @Override // zc.c
    public int c(int i10) {
        return d().nextInt(i10);
    }

    public abstract Random d();
}
