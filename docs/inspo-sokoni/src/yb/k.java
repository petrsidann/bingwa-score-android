package yb;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import xb.r0;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f19618b = Logger.getLogger(k.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zb.h f19619c = zb.h.e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static k f19620d = d(k.class.getClassLoader());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zb.h f19621a;

    public static final class a extends k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final zb.g<Socket> f19622e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final zb.g<Socket> f19623f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final zb.g<Socket> f19624g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final zb.g<Socket> f19625h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final zb.g<Socket> f19626i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final zb.g<Socket> f19627j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final Method f19628k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final Method f19629l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final Method f19630m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final Method f19631n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final Method f19632o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Method f19633p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Constructor<?> f19634q;

        static {
            Method method;
            Method method2;
            Method method3;
            Method method4;
            Method method5;
            Method method6;
            Class<?> cls = Boolean.TYPE;
            Constructor<?> constructor = null;
            f19622e = new zb.g<>(null, "setUseSessionTickets", cls);
            f19623f = new zb.g<>(null, "setHostname", String.class);
            f19624g = new zb.g<>(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            f19625h = new zb.g<>(null, "setAlpnProtocols", byte[].class);
            f19626i = new zb.g<>(byte[].class, "getNpnSelectedProtocol", new Class[0]);
            f19627j = new zb.g<>(null, "setNpnProtocols", byte[].class);
            try {
                method = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
                try {
                    method2 = SSLParameters.class.getMethod("getApplicationProtocols", new Class[0]);
                    try {
                        method3 = SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                        try {
                            Class<?> cls2 = Class.forName("android.net.ssl.SSLSockets");
                            method4 = cls2.getMethod("isSupportedSocket", SSLSocket.class);
                            try {
                                method5 = cls2.getMethod("setUseSessionTickets", SSLSocket.class, cls);
                            } catch (ClassNotFoundException e10) {
                                e = e10;
                                k.f19618b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                                method5 = null;
                            } catch (NoSuchMethodException e11) {
                                e = e11;
                                k.f19618b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                                method5 = null;
                            }
                        } catch (ClassNotFoundException | NoSuchMethodException e12) {
                            e = e12;
                            method4 = null;
                        }
                    } catch (ClassNotFoundException e13) {
                        e = e13;
                        method3 = null;
                        method4 = method3;
                        k.f19618b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                        method5 = null;
                        f19630m = method;
                        f19631n = method2;
                        f19632o = method3;
                        f19628k = method4;
                        f19629l = method5;
                        method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        f19633p = method6;
                        f19634q = constructor;
                    } catch (NoSuchMethodException e14) {
                        e = e14;
                        method3 = null;
                        method4 = method3;
                        k.f19618b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                        method5 = null;
                        f19630m = method;
                        f19631n = method2;
                        f19632o = method3;
                        f19628k = method4;
                        f19629l = method5;
                        method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                        f19633p = method6;
                        f19634q = constructor;
                    }
                } catch (ClassNotFoundException e15) {
                    e = e15;
                    method2 = null;
                    method3 = method2;
                    method4 = method3;
                    k.f19618b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                    method5 = null;
                    f19630m = method;
                    f19631n = method2;
                    f19632o = method3;
                    f19628k = method4;
                    f19629l = method5;
                    method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    f19633p = method6;
                    f19634q = constructor;
                } catch (NoSuchMethodException e16) {
                    e = e16;
                    method2 = null;
                    method3 = method2;
                    method4 = method3;
                    k.f19618b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                    method5 = null;
                    f19630m = method;
                    f19631n = method2;
                    f19632o = method3;
                    f19628k = method4;
                    f19629l = method5;
                    method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    f19633p = method6;
                    f19634q = constructor;
                }
            } catch (ClassNotFoundException e17) {
                e = e17;
                method = null;
                method2 = null;
            } catch (NoSuchMethodException e18) {
                e = e18;
                method = null;
                method2 = null;
            }
            f19630m = method;
            f19631n = method2;
            f19632o = method3;
            f19628k = method4;
            f19629l = method5;
            try {
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                try {
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                } catch (ClassNotFoundException e19) {
                    e = e19;
                    k.f19618b.log(Level.FINER, "Failed to find Android 7.0+ APIs", e);
                } catch (NoSuchMethodException e20) {
                    e = e20;
                    k.f19618b.log(Level.FINER, "Failed to find Android 7.0+ APIs", e);
                }
            } catch (ClassNotFoundException | NoSuchMethodException e21) {
                e = e21;
                method6 = null;
            }
            f19633p = method6;
            f19634q = constructor;
        }

        public a(zb.h hVar) {
            super(hVar);
        }

        @Override // yb.k
        public void c(SSLSocket sSLSocket, String str, List<zb.i> list) {
            Constructor<?> constructor;
            boolean z10;
            Method method;
            String[] strArrI = k.i(list);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            if (str != null) {
                try {
                    try {
                        if (k.g(str)) {
                            Method method2 = f19628k;
                            if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                                f19622e.e(sSLSocket, Boolean.TRUE);
                            } else {
                                f19629l.invoke(null, sSLSocket, Boolean.TRUE);
                            }
                            Method method3 = f19633p;
                            if (method3 == null || (constructor = f19634q) == null) {
                                f19623f.e(sSLSocket, str);
                            } else {
                                method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                            }
                        }
                    } catch (InvocationTargetException e10) {
                        throw new RuntimeException(e10);
                    }
                } catch (IllegalAccessException e11) {
                    throw new RuntimeException(e11);
                } catch (InstantiationException e12) {
                    throw new RuntimeException(e12);
                }
            }
            Method method4 = f19632o;
            if (method4 != null) {
                try {
                    method4.invoke(sSLSocket, new Object[0]);
                    f19630m.invoke(sSLParameters, strArrI);
                    z10 = true;
                } catch (InvocationTargetException e13) {
                    if (!(e13.getTargetException() instanceof UnsupportedOperationException)) {
                        throw e13;
                    }
                    k.f19618b.log(Level.FINER, "setApplicationProtocol unsupported, will try old methods");
                    z10 = false;
                }
            } else {
                z10 = false;
            }
            sSLSocket.setSSLParameters(sSLParameters);
            if (z10 && (method = f19631n) != null && Arrays.equals(strArrI, (String[]) method.invoke(sSLSocket.getSSLParameters(), new Object[0]))) {
                return;
            }
            Object[] objArr = {zb.h.b(list)};
            if (this.f19621a.i() == zb.h.EnumC0346h.ALPN_AND_NPN) {
                f19625h.f(sSLSocket, objArr);
            }
            if (this.f19621a.i() == zb.h.EnumC0346h.NONE) {
                throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
            }
            f19627j.f(sSLSocket, objArr);
        }

        @Override // yb.k
        public String f(SSLSocket sSLSocket) {
            Method method = f19632o;
            if (method != null) {
                try {
                    return (String) method.invoke(sSLSocket, new Object[0]);
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException(e10);
                } catch (InvocationTargetException e11) {
                    if (!(e11.getTargetException() instanceof UnsupportedOperationException)) {
                        throw new RuntimeException(e11);
                    }
                    k.f19618b.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                }
            }
            if (this.f19621a.i() == zb.h.EnumC0346h.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) f19624g.f(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, zb.l.f20513b);
                    }
                } catch (Exception e12) {
                    k.f19618b.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e12);
                }
            }
            if (this.f19621a.i() == zb.h.EnumC0346h.NONE) {
                return null;
            }
            try {
                byte[] bArr2 = (byte[]) f19626i.f(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, zb.l.f20513b);
                }
                return null;
            } catch (Exception e13) {
                k.f19618b.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e13);
                return null;
            }
        }

        @Override // yb.k
        public String h(SSLSocket sSLSocket, String str, List<zb.i> list) {
            String strF = f(sSLSocket);
            return strF == null ? super.h(sSLSocket, str, list) : strF;
        }
    }

    public k(zb.h hVar) {
        this.f19621a = (zb.h) j6.m.p(hVar, "platform");
    }

    public static k d(ClassLoader classLoader) {
        boolean z10;
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e10) {
            f19618b.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e10);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e11) {
                f19618b.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e11);
                z10 = false;
            }
        }
        z10 = true;
        return z10 ? new a(f19619c) : new k(f19619c);
    }

    public static k e() {
        return f19620d;
    }

    public static boolean g(String str) {
        if (str.contains("_")) {
            return false;
        }
        try {
            r0.c(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static String[] i(List<zb.i> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<zb.i> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void c(SSLSocket sSLSocket, String str, List<zb.i> list) {
        this.f19621a.c(sSLSocket, str, list);
    }

    public String f(SSLSocket sSLSocket) {
        return this.f19621a.h(sSLSocket);
    }

    public String h(SSLSocket sSLSocket, String str, List<zb.i> list) {
        if (list != null) {
            c(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String strF = f(sSLSocket);
            if (strF != null) {
                this.f19621a.a(sSLSocket);
                return strF;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + list);
        } catch (Throwable th) {
            this.f19621a.a(sSLSocket);
            throw th;
        }
    }
}
