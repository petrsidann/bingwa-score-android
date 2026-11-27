package w1;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import gd.c1;
import gd.m0;
import gd.n0;
import kotlin.jvm.internal.g;
import lc.k;
import lc.q;
import p6.e;
import qc.l;
import x1.c;
import xc.p;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17586a = new b(null);

    /* JADX INFO: renamed from: w1.a$a, reason: collision with other inner class name */
    public static final class C0308a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final x1.c f17587b;

        /* JADX INFO: renamed from: w1.a$a$a, reason: collision with other inner class name */
        @qc.f(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1", f = "MeasurementManagerFutures.kt", l = {122}, m = "invokeSuspend")
        public static final class C0309a extends l implements p<m0, oc.e<? super q>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f17588a;

            public C0309a(x1.a aVar, oc.e<? super C0309a> eVar) {
                super(2, eVar);
            }

            @Override // xc.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(m0 m0Var, oc.e<? super q> eVar) {
                return ((C0309a) create(m0Var, eVar)).invokeSuspend(q.f12711a);
            }

            @Override // qc.a
            public final oc.e<q> create(Object obj, oc.e<?> eVar) {
                return C0308a.this.new C0309a(null, eVar);
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objC = pc.c.c();
                int i10 = this.f17588a;
                if (i10 == 0) {
                    k.b(obj);
                    x1.c cVar = C0308a.this.f17587b;
                    this.f17588a = 1;
                    if (cVar.a(null, this) == objC) {
                        return objC;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b(obj);
                }
                return q.f12711a;
            }
        }

        /* JADX INFO: renamed from: w1.a$a$b */
        @qc.f(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1", f = "MeasurementManagerFutures.kt", l = {169}, m = "invokeSuspend")
        public static final class b extends l implements p<m0, oc.e<? super Integer>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f17590a;

            public b(oc.e<? super b> eVar) {
                super(2, eVar);
            }

            @Override // xc.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(m0 m0Var, oc.e<? super Integer> eVar) {
                return ((b) create(m0Var, eVar)).invokeSuspend(q.f12711a);
            }

            @Override // qc.a
            public final oc.e<q> create(Object obj, oc.e<?> eVar) {
                return C0308a.this.new b(eVar);
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objC = pc.c.c();
                int i10 = this.f17590a;
                if (i10 == 0) {
                    k.b(obj);
                    x1.c cVar = C0308a.this.f17587b;
                    this.f17590a = 1;
                    obj = cVar.b(this);
                    if (obj == objC) {
                        return objC;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b(obj);
                }
                return obj;
            }
        }

        /* JADX INFO: renamed from: w1.a$a$c */
        @qc.f(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1", f = "MeasurementManagerFutures.kt", l = {133}, m = "invokeSuspend")
        public static final class c extends l implements p<m0, oc.e<? super q>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f17592a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Uri f17594c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ InputEvent f17595d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Uri uri, InputEvent inputEvent, oc.e<? super c> eVar) {
                super(2, eVar);
                this.f17594c = uri;
                this.f17595d = inputEvent;
            }

            @Override // xc.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(m0 m0Var, oc.e<? super q> eVar) {
                return ((c) create(m0Var, eVar)).invokeSuspend(q.f12711a);
            }

            @Override // qc.a
            public final oc.e<q> create(Object obj, oc.e<?> eVar) {
                return C0308a.this.new c(this.f17594c, this.f17595d, eVar);
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objC = pc.c.c();
                int i10 = this.f17592a;
                if (i10 == 0) {
                    k.b(obj);
                    x1.c cVar = C0308a.this.f17587b;
                    Uri uri = this.f17594c;
                    InputEvent inputEvent = this.f17595d;
                    this.f17592a = 1;
                    if (cVar.c(uri, inputEvent, this) == objC) {
                        return objC;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b(obj);
                }
                return q.f12711a;
            }
        }

        /* JADX INFO: renamed from: w1.a$a$d */
        @qc.f(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1", f = "MeasurementManagerFutures.kt", l = {141}, m = "invokeSuspend")
        public static final class d extends l implements p<m0, oc.e<? super q>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f17596a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Uri f17598c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Uri uri, oc.e<? super d> eVar) {
                super(2, eVar);
                this.f17598c = uri;
            }

            @Override // xc.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(m0 m0Var, oc.e<? super q> eVar) {
                return ((d) create(m0Var, eVar)).invokeSuspend(q.f12711a);
            }

            @Override // qc.a
            public final oc.e<q> create(Object obj, oc.e<?> eVar) {
                return C0308a.this.new d(this.f17598c, eVar);
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objC = pc.c.c();
                int i10 = this.f17596a;
                if (i10 == 0) {
                    k.b(obj);
                    x1.c cVar = C0308a.this.f17587b;
                    Uri uri = this.f17598c;
                    this.f17596a = 1;
                    if (cVar.d(uri, this) == objC) {
                        return objC;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b(obj);
                }
                return q.f12711a;
            }
        }

        /* JADX INFO: renamed from: w1.a$a$e */
        @qc.f(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1", f = "MeasurementManagerFutures.kt", l = {151}, m = "invokeSuspend")
        public static final class e extends l implements p<m0, oc.e<? super q>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f17599a;

            public e(x1.d dVar, oc.e<? super e> eVar) {
                super(2, eVar);
            }

            @Override // xc.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(m0 m0Var, oc.e<? super q> eVar) {
                return ((e) create(m0Var, eVar)).invokeSuspend(q.f12711a);
            }

            @Override // qc.a
            public final oc.e<q> create(Object obj, oc.e<?> eVar) {
                return C0308a.this.new e(null, eVar);
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objC = pc.c.c();
                int i10 = this.f17599a;
                if (i10 == 0) {
                    k.b(obj);
                    x1.c cVar = C0308a.this.f17587b;
                    this.f17599a = 1;
                    if (cVar.e(null, this) == objC) {
                        return objC;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b(obj);
                }
                return q.f12711a;
            }
        }

        /* JADX INFO: renamed from: w1.a$a$f */
        @qc.f(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1", f = "MeasurementManagerFutures.kt", l = {161}, m = "invokeSuspend")
        public static final class f extends l implements p<m0, oc.e<? super q>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f17601a;

            public f(x1.e eVar, oc.e<? super f> eVar2) {
                super(2, eVar2);
            }

            @Override // xc.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(m0 m0Var, oc.e<? super q> eVar) {
                return ((f) create(m0Var, eVar)).invokeSuspend(q.f12711a);
            }

            @Override // qc.a
            public final oc.e<q> create(Object obj, oc.e<?> eVar) {
                return C0308a.this.new f(null, eVar);
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objC = pc.c.c();
                int i10 = this.f17601a;
                if (i10 == 0) {
                    k.b(obj);
                    x1.c cVar = C0308a.this.f17587b;
                    this.f17601a = 1;
                    if (cVar.f(null, this) == objC) {
                        return objC;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b(obj);
                }
                return q.f12711a;
            }
        }

        public C0308a(x1.c mMeasurementManager) {
            kotlin.jvm.internal.k.e(mMeasurementManager, "mMeasurementManager");
            this.f17587b = mMeasurementManager;
        }

        @Override // w1.a
        public p6.e<Integer> b() {
            return v1.b.c(gd.k.b(n0.a(c1.a()), null, null, new b(null), 3, null), null, 1, null);
        }

        @Override // w1.a
        public p6.e<q> c(Uri trigger) {
            kotlin.jvm.internal.k.e(trigger, "trigger");
            return v1.b.c(gd.k.b(n0.a(c1.a()), null, null, new d(trigger, null), 3, null), null, 1, null);
        }

        public p6.e<q> e(x1.a deletionRequest) {
            kotlin.jvm.internal.k.e(deletionRequest, "deletionRequest");
            return v1.b.c(gd.k.b(n0.a(c1.a()), null, null, new C0309a(deletionRequest, null), 3, null), null, 1, null);
        }

        public p6.e<q> f(Uri attributionSource, InputEvent inputEvent) {
            kotlin.jvm.internal.k.e(attributionSource, "attributionSource");
            return v1.b.c(gd.k.b(n0.a(c1.a()), null, null, new c(attributionSource, inputEvent, null), 3, null), null, 1, null);
        }

        public p6.e<q> g(x1.d request) {
            kotlin.jvm.internal.k.e(request, "request");
            return v1.b.c(gd.k.b(n0.a(c1.a()), null, null, new e(request, null), 3, null), null, 1, null);
        }

        public p6.e<q> h(x1.e request) {
            kotlin.jvm.internal.k.e(request, "request");
            return v1.b.c(gd.k.b(n0.a(c1.a()), null, null, new f(request, null), 3, null), null, 1, null);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final a a(Context context) {
            kotlin.jvm.internal.k.e(context, "context");
            c cVarA = c.f17950a.a(context);
            if (cVarA != null) {
                return new C0308a(cVarA);
            }
            return null;
        }
    }

    public static final a a(Context context) {
        return f17586a.a(context);
    }

    public abstract e<Integer> b();

    public abstract e<q> c(Uri uri);
}
