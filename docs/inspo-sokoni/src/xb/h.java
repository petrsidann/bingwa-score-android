package xb;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f18601a = new AtomicLong();

    @Override // xb.e1
    public void add(long j10) {
        this.f18601a.getAndAdd(j10);
    }
}
