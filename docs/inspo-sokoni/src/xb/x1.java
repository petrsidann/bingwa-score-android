package xb;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class x1 implements vb.h1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f19035d = Logger.getLogger(x1.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f19036e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j6.r<ProxySelector> f19037f = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j6.r<ProxySelector> f19038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f19039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f19040c;

    public class a implements c {
        @Override // xb.x1.c
        public PasswordAuthentication a(String str, InetAddress inetAddress, int i10, String str2, String str3, String str4) {
            URL url;
            try {
                url = new URL(str2, str, i10, "");
            } catch (MalformedURLException unused) {
                x1.f19035d.log(Level.WARNING, "failed to create URL for Authenticator: {0} {1}", new Object[]{str2, str});
                url = null;
            }
            return Authenticator.requestPasswordAuthentication(str, inetAddress, i10, str2, str3, str4, url, Authenticator.RequestorType.PROXY);
        }
    }

    public class b implements j6.r<ProxySelector> {
        @Override // j6.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    }

    public interface c {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i10, String str2, String str3, String str4);
    }

    public x1() {
        this(f19037f, f19036e, System.getenv("GRPC_PROXY_EXP"));
    }

    public x1(j6.r<ProxySelector> rVar, c cVar, String str) {
        this.f19038a = (j6.r) j6.m.o(rVar);
        this.f19039b = (c) j6.m.o(cVar);
        this.f19040c = str != null ? d(str) : null;
    }

    public static InetSocketAddress d(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(":", 2);
        int i10 = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 80;
        f19035d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(strArrSplit[0], i10);
    }

    @Override // vb.h1
    public vb.g1 a(SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            return this.f19040c != null ? vb.e0.e().c(this.f19040c).d((InetSocketAddress) socketAddress).a() : c((InetSocketAddress) socketAddress);
        }
        return null;
    }

    public final vb.g1 c(InetSocketAddress inetSocketAddress) {
        try {
            try {
                URI uri = new URI("https", null, r0.i(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                ProxySelector proxySelector = this.f19038a.get();
                if (proxySelector == null) {
                    f19035d.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> listSelect = proxySelector.select(uri);
                if (listSelect.size() > 1) {
                    f19035d.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = listSelect.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication passwordAuthenticationA = this.f19039b.a(r0.i(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), "https", "", null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                vb.e0.b bVarC = vb.e0.e().d(inetSocketAddress).c(inetSocketAddress2);
                if (passwordAuthenticationA == null) {
                    return bVarC.a();
                }
                return bVarC.e(passwordAuthenticationA.getUserName()).b(passwordAuthenticationA.getPassword() != null ? new String(passwordAuthenticationA.getPassword()) : null).a();
            } catch (URISyntaxException e10) {
                f19035d.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e10);
                return null;
            }
        } catch (Throwable th) {
            f19035d.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }
}
