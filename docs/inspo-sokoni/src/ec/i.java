package ec;

import java.util.List;
import java.util.Map;
import vb.c1;
import vb.l1;
import vb.t0;
import vb.u0;
import vb.v0;
import xb.b1;
import xb.k2;
import xb.r2;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends u0 {
    @Override // vb.t0.c
    public t0 a(t0.e eVar) {
        return new h(eVar, r2.f18900a);
    }

    @Override // vb.u0
    public String b() {
        return "outlier_detection_experimental";
    }

    @Override // vb.u0
    public int c() {
        return 5;
    }

    @Override // vb.u0
    public boolean d() {
        return true;
    }

    @Override // vb.u0
    public c1.c e(Map<String, ?> map) {
        try {
            return f(map);
        } catch (RuntimeException e10) {
            return c1.c.b(l1.f17420t.p(e10).q("Failed parsing configuration for " + b()));
        }
    }

    public final c1.c f(Map<String, ?> map) {
        Long l10 = b1.l(map, "interval");
        Long l11 = b1.l(map, "baseEjectionTime");
        Long l12 = b1.l(map, "maxEjectionTime");
        Integer numI = b1.i(map, "maxEjectionPercentage");
        h.g.a aVar = new h.g.a();
        if (l10 != null) {
            aVar.e(l10);
        }
        if (l11 != null) {
            aVar.b(l11);
        }
        if (l12 != null) {
            aVar.g(l12);
        }
        if (numI != null) {
            aVar.f(numI);
        }
        Map<String, ?> mapJ = b1.j(map, "successRateEjection");
        if (mapJ != null) {
            h.g.c.a aVar2 = new h.g.c.a();
            Integer numI2 = b1.i(mapJ, "stdevFactor");
            Integer numI3 = b1.i(mapJ, "enforcementPercentage");
            Integer numI4 = b1.i(mapJ, "minimumHosts");
            Integer numI5 = b1.i(mapJ, "requestVolume");
            if (numI2 != null) {
                aVar2.e(numI2);
            }
            if (numI3 != null) {
                aVar2.b(numI3);
            }
            if (numI4 != null) {
                aVar2.c(numI4);
            }
            if (numI5 != null) {
                aVar2.d(numI5);
            }
            aVar.h(aVar2.a());
        }
        Map<String, ?> mapJ2 = b1.j(map, "failurePercentageEjection");
        if (mapJ2 != null) {
            h.g.b.a aVar3 = new h.g.b.a();
            Integer numI6 = b1.i(mapJ2, "threshold");
            Integer numI7 = b1.i(mapJ2, "enforcementPercentage");
            Integer numI8 = b1.i(mapJ2, "minimumHosts");
            Integer numI9 = b1.i(mapJ2, "requestVolume");
            if (numI6 != null) {
                aVar3.e(numI6);
            }
            if (numI7 != null) {
                aVar3.b(numI7);
            }
            if (numI8 != null) {
                aVar3.c(numI8);
            }
            if (numI9 != null) {
                aVar3.d(numI9);
            }
            aVar.d(aVar3.a());
        }
        List<k2.a> listA = k2.A(b1.f(map, "childPolicy"));
        if (listA == null || listA.isEmpty()) {
            return c1.c.b(l1.f17419s.q("No child policy in outlier_detection_experimental LB policy: " + map));
        }
        c1.c cVarY = k2.y(listA, v0.b());
        if (cVarY.d() != null) {
            return cVarY;
        }
        aVar.c((k2.b) cVarY.c());
        return c1.c.a(aVar.a());
    }
}
