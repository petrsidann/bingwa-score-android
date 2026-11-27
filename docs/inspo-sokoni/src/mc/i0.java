package mc;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @qc.f(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, 55, 58}, m = "invokeSuspend")
    public static final class a<T> extends qc.k implements xc.p<dd.d<? super List<? extends T>>, oc.e<? super lc.q>, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f13307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f13308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13309d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13310e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f13311f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f13312l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f13313m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ Iterator<T> f13314n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ boolean f13315o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ boolean f13316p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(int i10, int i11, Iterator<? extends T> it, boolean z10, boolean z11, oc.e<? super a> eVar) {
            super(2, eVar);
            this.f13312l = i10;
            this.f13313m = i11;
            this.f13314n = it;
            this.f13315o = z10;
            this.f13316p = z11;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(dd.d<? super List<? extends T>> dVar, oc.e<? super lc.q> eVar) {
            return ((a) create(dVar, eVar)).invokeSuspend(lc.q.f12711a);
        }

        @Override // qc.a
        public final oc.e<lc.q> create(Object obj, oc.e<?> eVar) {
            a aVar = new a(this.f13312l, this.f13313m, this.f13314n, this.f13315o, this.f13316p, eVar);
            aVar.f13311f = obj;
            return aVar;
        }

        /* JADX WARN: Code duplicated, block: B:47:0x00ec  */
        /* JADX WARN: Code duplicated, block: B:54:0x010a  */
        /* JADX WARN: Code duplicated, block: B:55:0x010c  */
        /* JADX WARN: Code duplicated, block: B:58:0x011f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:80:0x00f9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x0106 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a6 -> B:16:0x0058). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011d -> B:59:0x0120). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x014b -> B:72:0x014e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // qc.a
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 365
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: mc.i0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void a(int i10, int i11) {
        String str;
        if (i10 > 0 && i11 > 0) {
            return;
        }
        if (i10 != i11) {
            str = "Both size " + i10 + " and step " + i11 + " must be greater than zero.";
        } else {
            str = "size " + i10 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public static final <T> Iterator<List<T>> b(Iterator<? extends T> iterator, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.k.e(iterator, "iterator");
        return !iterator.hasNext() ? x.f13317a : dd.e.a(new a(i10, i11, iterator, z11, z10, null));
    }
}
