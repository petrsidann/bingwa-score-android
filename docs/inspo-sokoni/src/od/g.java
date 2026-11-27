package od;

import gd.o;
import kotlin.jvm.internal.l;
import ld.h0;
import xc.q;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<Object, Object, Object, Object> f13833a = a.f13839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h0 f13834b = new h0("STATE_REG");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h0 f13835c = new h0("STATE_COMPLETED");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h0 f13836d = new h0("STATE_CANCELLED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h0 f13837e = new h0("NO_RESULT");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h0 f13838f = new h0("PARAM_CLAUSE_0");

    public static final class a extends l implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13839a = new a();

        public a() {
            super(3);
        }

        @Override // xc.q
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void e(Object obj, Object obj2, Object obj3) {
            return null;
        }
    }

    public static final h a(int i10) {
        if (i10 == 0) {
            return h.SUCCESSFUL;
        }
        if (i10 == 1) {
            return h.REREGISTER;
        }
        if (i10 == 2) {
            return h.CANCELLED;
        }
        if (i10 == 3) {
            return h.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i10).toString());
    }

    public static final boolean i(o<? super lc.q> oVar, xc.l<? super Throwable, lc.q> lVar) {
        Object objK = oVar.k(lc.q.f12711a, null, lVar);
        if (objK == null) {
            return false;
        }
        oVar.n(objK);
        return true;
    }
}
