package vb;

import java.security.cert.Certificate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f17353f = Logger.getLogger(f0.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f0 f17354g = new f0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentNavigableMap<Long, k0<Object>> f17355a = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentNavigableMap<Long, k0<Object>> f17356b = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentMap<Long, k0<Object>> f17357c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentMap<Long, k0<Object>> f17358d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentMap<Long, Object> f17359e = new ConcurrentHashMap();

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f17360a;

        public b(c cVar) {
            this.f17360a = (c) j6.m.o(cVar);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Certificate f17362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Certificate f17363c;

        public c(SSLSession sSLSession) {
            String cipherSuite = sSLSession.getCipherSuite();
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            Certificate certificate = null;
            Certificate certificate2 = localCertificates != null ? localCertificates[0] : null;
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                if (peerCertificates != null) {
                    certificate = peerCertificates[0];
                }
            } catch (SSLPeerUnverifiedException e10) {
                f0.f17353f.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", sSLSession.getPeerHost()), (Throwable) e10);
            }
            this.f17361a = cipherSuite;
            this.f17362b = certificate2;
            this.f17363c = certificate;
        }
    }

    public static <T extends k0<?>> void b(Map<Long, T> map, T t10) {
        map.put(Long.valueOf(t10.g().d()), t10);
    }

    public static long f(r0 r0Var) {
        return r0Var.g().d();
    }

    public static f0 g() {
        return f17354g;
    }

    public static <T extends k0<?>> void h(Map<Long, T> map, T t10) {
        map.remove(Long.valueOf(f(t10)));
    }

    public void c(k0<Object> k0Var) {
        b(this.f17358d, k0Var);
    }

    public void d(k0<Object> k0Var) {
        b(this.f17356b, k0Var);
    }

    public void e(k0<Object> k0Var) {
        b(this.f17357c, k0Var);
    }

    public void i(k0<Object> k0Var) {
        h(this.f17358d, k0Var);
    }

    public void j(k0<Object> k0Var) {
        h(this.f17356b, k0Var);
    }

    public void k(k0<Object> k0Var) {
        h(this.f17357c, k0Var);
    }
}
