package bd;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.k;
import mc.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3068d;

    public b(char c10, char c11, int i10) {
        this.f3065a = i10;
        this.f3066b = c11;
        boolean z10 = true;
        if (i10 <= 0 ? k.f(c10, c11) < 0 : k.f(c10, c11) > 0) {
            z10 = false;
        }
        this.f3067c = z10;
        this.f3068d = z10 ? c10 : c11;
    }

    @Override // mc.m
    public char b() {
        int i10 = this.f3068d;
        if (i10 != this.f3066b) {
            this.f3068d = this.f3065a + i10;
        } else {
            if (!this.f3067c) {
                throw new NoSuchElementException();
            }
            this.f3067c = false;
        }
        return (char) i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3067c;
    }
}
