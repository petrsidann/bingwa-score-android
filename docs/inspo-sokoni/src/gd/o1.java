package gd;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o1 extends j0 implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9242c = new a(null);

    public static final class a extends oc.b<j0, o1> {

        /* JADX INFO: renamed from: gd.o1$a$a, reason: collision with other inner class name */
        public static final class C0158a extends kotlin.jvm.internal.l implements xc.l<oc.i.b, o1> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0158a f9243a = new C0158a();

            public C0158a() {
                super(1);
            }

            @Override // xc.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final o1 invoke(oc.i.b bVar) {
                if (bVar instanceof o1) {
                    return (o1) bVar;
                }
                return null;
            }
        }

        public a() {
            super(j0.f9218b, C0158a.f9243a);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }
}
