package zc;

import java.io.Serializable;
import kotlin.jvm.internal.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20515a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f20516b = sc.b.f15714a.b();

    public static final class a extends c implements Serializable {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        @Override // zc.c
        public int b() {
            return c.f20516b.b();
        }

        @Override // zc.c
        public int c(int i10) {
            return c.f20516b.c(i10);
        }
    }

    public abstract int b();

    public abstract int c(int i10);
}
