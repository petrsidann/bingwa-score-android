package yb;

import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<zb.i> f19636a = Collections.unmodifiableList(Arrays.asList(zb.i.HTTP_2));

    public static String a(String str) {
        return (str.startsWith("[") && str.endsWith("]")) ? str.substring(1, str.length() - 1) : str;
    }

    public static SSLSocket b(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String str, int i10, zb.b bVar) throws SSLPeerUnverifiedException {
        j6.m.p(sSLSocketFactory, "sslSocketFactory");
        j6.m.p(socket, "socket");
        j6.m.p(bVar, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i10, true);
        bVar.c(sSLSocket, false);
        String strH = k.e().h(sSLSocket, str, bVar.f() ? f19636a : null);
        List<zb.i> list = f19636a;
        j6.m.x(list.contains(zb.i.d(strH)), "Only " + list + " are supported, but negotiated protocol is %s", strH);
        if (hostnameVerifier == null) {
            hostnameVerifier = zb.f.f20466a;
        }
        if (hostnameVerifier.verify(a(str), sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
