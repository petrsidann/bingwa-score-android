package zb;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zb.a[] f20445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f20446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f20447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f20448h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f20450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f20451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f20452d;

    /* JADX INFO: renamed from: zb.b$b, reason: collision with other inner class name */
    public static final class C0345b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f20454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f20455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f20456d;

        public C0345b(b bVar) {
            this.f20453a = bVar.f20449a;
            this.f20454b = bVar.f20450b;
            this.f20455c = bVar.f20451c;
            this.f20456d = bVar.f20452d;
        }

        public C0345b(boolean z10) {
            this.f20453a = z10;
        }

        public b e() {
            return new b(this);
        }

        public C0345b f(String... strArr) {
            if (!this.f20453a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr == null) {
                this.f20454b = null;
            } else {
                this.f20454b = (String[]) strArr.clone();
            }
            return this;
        }

        public C0345b g(zb.a... aVarArr) {
            if (!this.f20453a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[aVarArr.length];
            for (int i10 = 0; i10 < aVarArr.length; i10++) {
                strArr[i10] = aVarArr[i10].f20444a;
            }
            this.f20454b = strArr;
            return this;
        }

        public C0345b h(boolean z10) {
            if (!this.f20453a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f20456d = z10;
            return this;
        }

        public C0345b i(String... strArr) {
            if (!this.f20453a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr == null) {
                this.f20455c = null;
            } else {
                this.f20455c = (String[]) strArr.clone();
            }
            return this;
        }

        public C0345b j(k... kVarArr) {
            if (!this.f20453a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (kVarArr.length == 0) {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
            String[] strArr = new String[kVarArr.length];
            for (int i10 = 0; i10 < kVarArr.length; i10++) {
                strArr[i10] = kVarArr[i10].f20511a;
            }
            this.f20455c = strArr;
            return this;
        }
    }

    static {
        zb.a[] aVarArr = {zb.a.TLS_AES_128_GCM_SHA256, zb.a.TLS_AES_256_GCM_SHA384, zb.a.TLS_CHACHA20_POLY1305_SHA256, zb.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, zb.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, zb.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, zb.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, zb.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, zb.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, zb.a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, zb.a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, zb.a.TLS_RSA_WITH_AES_128_GCM_SHA256, zb.a.TLS_RSA_WITH_AES_256_GCM_SHA384, zb.a.TLS_RSA_WITH_AES_128_CBC_SHA, zb.a.TLS_RSA_WITH_AES_256_CBC_SHA, zb.a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f20445e = aVarArr;
        C0345b c0345bG = new C0345b(true).g(aVarArr);
        k kVar = k.TLS_1_3;
        k kVar2 = k.TLS_1_2;
        b bVarE = c0345bG.j(kVar, kVar2).h(true).e();
        f20446f = bVarE;
        f20447g = new C0345b(bVarE).j(kVar, kVar2, k.TLS_1_1, k.TLS_1_0).h(true).e();
        f20448h = new C0345b(false).e();
    }

    public b(C0345b c0345b) {
        this.f20449a = c0345b.f20453a;
        this.f20450b = c0345b.f20454b;
        this.f20451c = c0345b.f20455c;
        this.f20452d = c0345b.f20456d;
    }

    public void c(SSLSocket sSLSocket, boolean z10) {
        b bVarE = e(sSLSocket, z10);
        sSLSocket.setEnabledProtocols(bVarE.f20451c);
        String[] strArr = bVarE.f20450b;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    public List<zb.a> d() {
        String[] strArr = this.f20450b;
        if (strArr == null) {
            return null;
        }
        zb.a[] aVarArr = new zb.a[strArr.length];
        int i10 = 0;
        while (true) {
            String[] strArr2 = this.f20450b;
            if (i10 >= strArr2.length) {
                return l.a(aVarArr);
            }
            aVarArr[i10] = zb.a.d(strArr2[i10]);
            i10++;
        }
    }

    public final b e(SSLSocket sSLSocket, boolean z10) {
        String[] enabledCipherSuites;
        if (this.f20450b != null) {
            enabledCipherSuites = (String[]) l.c(String.class, this.f20450b, sSLSocket.getEnabledCipherSuites());
        } else {
            enabledCipherSuites = null;
        }
        if (z10 && Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            if (enabledCipherSuites == null) {
                enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            }
            int length = enabledCipherSuites.length + 1;
            String[] strArr = new String[length];
            System.arraycopy(enabledCipherSuites, 0, strArr, 0, enabledCipherSuites.length);
            strArr[length - 1] = "TLS_FALLBACK_SCSV";
            enabledCipherSuites = strArr;
        }
        return new C0345b(this).f(enabledCipherSuites).i((String[]) l.c(String.class, this.f20451c, sSLSocket.getEnabledProtocols())).e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        b bVar = (b) obj;
        boolean z10 = this.f20449a;
        if (z10 != bVar.f20449a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f20450b, bVar.f20450b) && Arrays.equals(this.f20451c, bVar.f20451c) && this.f20452d == bVar.f20452d);
    }

    public boolean f() {
        return this.f20452d;
    }

    public List<k> g() {
        k[] kVarArr = new k[this.f20451c.length];
        int i10 = 0;
        while (true) {
            String[] strArr = this.f20451c;
            if (i10 >= strArr.length) {
                return l.a(kVarArr);
            }
            kVarArr[i10] = k.d(strArr[i10]);
            i10++;
        }
    }

    public int hashCode() {
        if (this.f20449a) {
            return ((((527 + Arrays.hashCode(this.f20450b)) * 31) + Arrays.hashCode(this.f20451c)) * 31) + (!this.f20452d ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f20449a) {
            return "ConnectionSpec()";
        }
        List<zb.a> listD = d();
        return "ConnectionSpec(cipherSuites=" + (listD == null ? "[use default]" : listD.toString()) + ", tlsVersions=" + g() + ", supportsTlsExtensions=" + this.f20452d + ")";
    }
}
