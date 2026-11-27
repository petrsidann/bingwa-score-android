package x1;

import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import gd.p;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import l0.m;
import lc.q;
import qc.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17950a = new b(null);

    public static final class a extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MeasurementManager f17951b;

        public a(MeasurementManager mMeasurementManager) {
            k.e(mMeasurementManager, "mMeasurementManager");
            this.f17951b = mMeasurementManager;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Context context) {
            k.e(context, "context");
            Object systemService = context.getSystemService((Class<Object>) MeasurementManager.class);
            k.d(systemService, "context.getSystemService…:class.java\n            )");
            this((MeasurementManager) systemService);
        }

        @Override // x1.c
        public Object a(x1.a aVar, oc.e<? super q> eVar) {
            p pVar = new p(pc.b.b(eVar), 1);
            pVar.B();
            this.f17951b.deleteRegistrations(k(aVar), new x1.b(), m.a(pVar));
            Object objY = pVar.y();
            if (objY == pc.c.c()) {
                h.c(eVar);
            }
            return objY == pc.c.c() ? objY : q.f12711a;
        }

        @Override // x1.c
        public Object b(oc.e<? super Integer> eVar) {
            p pVar = new p(pc.b.b(eVar), 1);
            pVar.B();
            this.f17951b.getMeasurementApiStatus(new x1.b(), m.a(pVar));
            Object objY = pVar.y();
            if (objY == pc.c.c()) {
                h.c(eVar);
            }
            return objY;
        }

        @Override // x1.c
        public Object c(Uri uri, InputEvent inputEvent, oc.e<? super q> eVar) {
            p pVar = new p(pc.b.b(eVar), 1);
            pVar.B();
            this.f17951b.registerSource(uri, inputEvent, new x1.b(), m.a(pVar));
            Object objY = pVar.y();
            if (objY == pc.c.c()) {
                h.c(eVar);
            }
            return objY == pc.c.c() ? objY : q.f12711a;
        }

        @Override // x1.c
        public Object d(Uri uri, oc.e<? super q> eVar) {
            p pVar = new p(pc.b.b(eVar), 1);
            pVar.B();
            this.f17951b.registerTrigger(uri, new x1.b(), m.a(pVar));
            Object objY = pVar.y();
            if (objY == pc.c.c()) {
                h.c(eVar);
            }
            return objY == pc.c.c() ? objY : q.f12711a;
        }

        @Override // x1.c
        public Object e(d dVar, oc.e<? super q> eVar) {
            p pVar = new p(pc.b.b(eVar), 1);
            pVar.B();
            this.f17951b.registerWebSource(l(dVar), new x1.b(), m.a(pVar));
            Object objY = pVar.y();
            if (objY == pc.c.c()) {
                h.c(eVar);
            }
            return objY == pc.c.c() ? objY : q.f12711a;
        }

        @Override // x1.c
        public Object f(e eVar, oc.e<? super q> eVar2) {
            p pVar = new p(pc.b.b(eVar2), 1);
            pVar.B();
            this.f17951b.registerWebTrigger(m(eVar), new x1.b(), m.a(pVar));
            Object objY = pVar.y();
            if (objY == pc.c.c()) {
                h.c(eVar2);
            }
            return objY == pc.c.c() ? objY : q.f12711a;
        }

        public final DeletionRequest k(x1.a aVar) {
            new DeletionRequest.Builder();
            throw null;
        }

        public final WebSourceRegistrationRequest l(d dVar) {
            throw null;
        }

        public final WebTriggerRegistrationRequest m(e eVar) {
            throw null;
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final c a(Context context) {
            k.e(context, "context");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AdServicesInfo.version=");
            u1.a aVar = u1.a.f15976a;
            sb2.append(aVar.a());
            Log.d("MeasurementManager", sb2.toString());
            if (aVar.a() >= 5) {
                return new a(context);
            }
            return null;
        }
    }

    public abstract Object a(x1.a aVar, oc.e<? super q> eVar);

    public abstract Object b(oc.e<? super Integer> eVar);

    public abstract Object c(Uri uri, InputEvent inputEvent, oc.e<? super q> eVar);

    public abstract Object d(Uri uri, oc.e<? super q> eVar);

    public abstract Object e(d dVar, oc.e<? super q> eVar);

    public abstract Object f(e eVar, oc.e<? super q> eVar2);
}
