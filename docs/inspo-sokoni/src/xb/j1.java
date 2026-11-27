package xb;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f18655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, b> f18656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, b> f18657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c2.d0 f18658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f18659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, ?> f18660f;

    public static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final vb.c.C0304c<b> f18661g = vb.c.C0304c.b("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f18662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f18663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f18664c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f18665d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final d2 f18666e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final t0 f18667f;

        public b(Map<String, ?> map, boolean z10, int i10, int i11) {
            this.f18662a = k2.w(map);
            this.f18663b = k2.x(map);
            Integer numL = k2.l(map);
            this.f18664c = numL;
            if (numL != null) {
                j6.m.k(numL.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", numL);
            }
            Integer numK = k2.k(map);
            this.f18665d = numK;
            if (numK != null) {
                j6.m.k(numK.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", numK);
            }
            Map<String, ?> mapR = z10 ? k2.r(map) : null;
            this.f18666e = mapR == null ? null : b(mapR, i10);
            Map<String, ?> mapD = z10 ? k2.d(map) : null;
            this.f18667f = mapD != null ? a(mapD, i11) : null;
        }

        public static t0 a(Map<String, ?> map, int i10) {
            int iIntValue = ((Integer) j6.m.p(k2.h(map), "maxAttempts cannot be empty")).intValue();
            j6.m.h(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i10);
            long jLongValue = ((Long) j6.m.p(k2.c(map), "hedgingDelay cannot be empty")).longValue();
            j6.m.j(jLongValue >= 0, "hedgingDelay must not be negative: %s", jLongValue);
            return new t0(iMin, jLongValue, k2.p(map));
        }

        public static d2 b(Map<String, ?> map, int i10) {
            int iIntValue = ((Integer) j6.m.p(k2.i(map), "maxAttempts cannot be empty")).intValue();
            boolean z10 = true;
            j6.m.h(iIntValue >= 2, "maxAttempts must be greater than 1: %s", iIntValue);
            int iMin = Math.min(iIntValue, i10);
            long jLongValue = ((Long) j6.m.p(k2.e(map), "initialBackoff cannot be empty")).longValue();
            j6.m.j(jLongValue > 0, "initialBackoffNanos must be greater than 0: %s", jLongValue);
            long jLongValue2 = ((Long) j6.m.p(k2.j(map), "maxBackoff cannot be empty")).longValue();
            j6.m.j(jLongValue2 > 0, "maxBackoff must be greater than 0: %s", jLongValue2);
            double dDoubleValue = ((Double) j6.m.p(k2.a(map), "backoffMultiplier cannot be empty")).doubleValue();
            j6.m.k(dDoubleValue > 0.0d, "backoffMultiplier must be greater than 0: %s", Double.valueOf(dDoubleValue));
            Long lQ = k2.q(map);
            j6.m.k(lQ == null || lQ.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", lQ);
            Set<vb.l1.b> setS = k2.s(map);
            if (lQ == null && setS.isEmpty()) {
                z10 = false;
            }
            j6.m.e(z10, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            return new d2(iMin, jLongValue, jLongValue2, dDoubleValue, lQ, setS);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return j6.i.a(this.f18662a, bVar.f18662a) && j6.i.a(this.f18663b, bVar.f18663b) && j6.i.a(this.f18664c, bVar.f18664c) && j6.i.a(this.f18665d, bVar.f18665d) && j6.i.a(this.f18666e, bVar.f18666e) && j6.i.a(this.f18667f, bVar.f18667f);
        }

        public int hashCode() {
            return j6.i.b(this.f18662a, this.f18663b, this.f18664c, this.f18665d, this.f18666e, this.f18667f);
        }

        public String toString() {
            return j6.g.b(this).d("timeoutNanos", this.f18662a).d("waitForReady", this.f18663b).d("maxInboundMessageSize", this.f18664c).d("maxOutboundMessageSize", this.f18665d).d("retryPolicy", this.f18666e).d("hedgingPolicy", this.f18667f).toString();
        }
    }

    public static final class c extends vb.h0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j1 f18668b;

        public c(j1 j1Var) {
            this.f18668b = j1Var;
        }

        @Override // vb.h0
        public vb.h0.b a(vb.t0.g gVar) {
            return vb.h0.b.d().b(this.f18668b).a();
        }
    }

    public j1(b bVar, Map<String, b> map, Map<String, b> map2, c2.d0 d0Var, Object obj, Map<String, ?> map3) {
        this.f18655a = bVar;
        this.f18656b = Collections.unmodifiableMap(new HashMap(map));
        this.f18657c = Collections.unmodifiableMap(new HashMap(map2));
        this.f18658d = d0Var;
        this.f18659e = obj;
        this.f18660f = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public static j1 a() {
        return new j1(null, new HashMap(), new HashMap(), null, null, null);
    }

    public static j1 b(Map<String, ?> map, boolean z10, int i10, int i11, Object obj) {
        c2.d0 d0VarV = z10 ? k2.v(map) : null;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Map<String, ?> mapB = k2.b(map);
        List<Map<String, ?>> listM = k2.m(map);
        if (listM == null) {
            return new j1(null, map2, map3, d0VarV, obj, mapB);
        }
        b bVar = null;
        for (Map<String, ?> map4 : listM) {
            b bVar2 = new b(map4, z10, i10, i11);
            List<Map<String, ?>> listO = k2.o(map4);
            if (listO != null && !listO.isEmpty()) {
                for (Map<String, ?> map5 : listO) {
                    String strT = k2.t(map5);
                    String strN = k2.n(map5);
                    if (j6.q.a(strT)) {
                        j6.m.k(j6.q.a(strN), "missing service name for method %s", strN);
                        j6.m.k(bVar == null, "Duplicate default method config in service config %s", map);
                        bVar = bVar2;
                    } else if (j6.q.a(strN)) {
                        j6.m.k(!map3.containsKey(strT), "Duplicate service %s", strT);
                        map3.put(strT, bVar2);
                    } else {
                        String strB = vb.b1.b(strT, strN);
                        j6.m.k(!map2.containsKey(strB), "Duplicate method name %s", strB);
                        map2.put(strB, bVar2);
                    }
                }
            }
        }
        return new j1(bVar, map2, map3, d0VarV, obj, mapB);
    }

    public vb.h0 c() {
        if (this.f18657c.isEmpty() && this.f18656b.isEmpty() && this.f18655a == null) {
            return null;
        }
        return new c();
    }

    public Map<String, ?> d() {
        return this.f18660f;
    }

    public Object e() {
        return this.f18659e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j1.class != obj.getClass()) {
            return false;
        }
        j1 j1Var = (j1) obj;
        return j6.i.a(this.f18655a, j1Var.f18655a) && j6.i.a(this.f18656b, j1Var.f18656b) && j6.i.a(this.f18657c, j1Var.f18657c) && j6.i.a(this.f18658d, j1Var.f18658d) && j6.i.a(this.f18659e, j1Var.f18659e);
    }

    public b f(vb.b1<?, ?> b1Var) {
        b bVar = this.f18656b.get(b1Var.c());
        if (bVar == null) {
            bVar = this.f18657c.get(b1Var.d());
        }
        return bVar == null ? this.f18655a : bVar;
    }

    public c2.d0 g() {
        return this.f18658d;
    }

    public int hashCode() {
        return j6.i.b(this.f18655a, this.f18656b, this.f18657c, this.f18658d, this.f18659e);
    }

    public String toString() {
        return j6.g.b(this).d("defaultMethodConfig", this.f18655a).d("serviceMethodMap", this.f18656b).d("serviceMap", this.f18657c).d("retryThrottling", this.f18658d).d("loadBalancingConfig", this.f18659e).toString();
    }
}
