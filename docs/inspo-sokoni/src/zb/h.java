package zb;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f20471b = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f20472c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f20473d = d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f20474a;

    public class a implements PrivilegedExceptionAction<Method> {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLEngine.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    public class b implements PrivilegedExceptionAction<Method> {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
        }
    }

    public class c implements PrivilegedExceptionAction<Method> {
        @Override // java.security.PrivilegedExceptionAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            return SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    public static class d extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final zb.g<Socket> f20475e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final zb.g<Socket> f20476f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Method f20477g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Method f20478h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final zb.g<Socket> f20479i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final zb.g<Socket> f20480j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final EnumC0346h f20481k;

        public d(zb.g<Socket> gVar, zb.g<Socket> gVar2, Method method, Method method2, zb.g<Socket> gVar3, zb.g<Socket> gVar4, Provider provider, EnumC0346h enumC0346h) {
            super(provider);
            this.f20475e = gVar;
            this.f20476f = gVar2;
            this.f20477g = method;
            this.f20478h = method2;
            this.f20479i = gVar3;
            this.f20480j = gVar4;
            this.f20481k = enumC0346h;
        }

        @Override // zb.h
        public void c(SSLSocket sSLSocket, String str, List<i> list) {
            if (str != null) {
                this.f20475e.e(sSLSocket, Boolean.TRUE);
                this.f20476f.e(sSLSocket, str);
            }
            if (this.f20480j.g(sSLSocket)) {
                this.f20480j.f(sSLSocket, h.b(list));
            }
        }

        @Override // zb.h
        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            if (this.f20479i.g(sSLSocket) && (bArr = (byte[]) this.f20479i.f(sSLSocket, new Object[0])) != null) {
                return new String(bArr, l.f20513b);
            }
            return null;
        }

        @Override // zb.h
        public EnumC0346h i() {
            return this.f20481k;
        }
    }

    public static class e extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Method f20482e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f20483f;

        public e(Provider provider, Method method, Method method2) {
            super(provider);
            this.f20482e = method;
            this.f20483f = method2;
        }

        public /* synthetic */ e(Provider provider, Method method, Method method2, a aVar) {
            this(provider, method, method2);
        }

        @Override // zb.h
        public void c(SSLSocket sSLSocket, String str, List<i> list) {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayList = new ArrayList(list.size());
            for (i iVar : list) {
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f20482e.invoke(sSLParameters, arrayList.toArray(new String[arrayList.size()]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Override // zb.h
        public String h(SSLSocket sSLSocket) {
            try {
                return (String) this.f20483f.invoke(sSLSocket, new Object[0]);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11);
            }
        }

        @Override // zb.h
        public EnumC0346h i() {
            return EnumC0346h.ALPN_AND_NPN;
        }
    }

    public static class f extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Method f20484e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f20485f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Method f20486g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class<?> f20487h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Class<?> f20488i;

        public f(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2, Provider provider) {
            super(provider);
            this.f20484e = method;
            this.f20485f = method2;
            this.f20486g = method3;
            this.f20487h = cls;
            this.f20488i = cls2;
        }

        @Override // zb.h
        public void a(SSLSocket sSLSocket) {
            try {
                this.f20486g.invoke(null, sSLSocket);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e10) {
                h.f20471b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", (Throwable) e10);
            }
        }

        @Override // zb.h
        public void c(SSLSocket sSLSocket, String str, List<i> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                i iVar = list.get(i10);
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f20484e.invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f20487h, this.f20488i}, new g(arrayList)));
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                throw new AssertionError(e11);
            }
        }

        @Override // zb.h
        public String h(SSLSocket sSLSocket) {
            try {
                g gVar = (g) Proxy.getInvocationHandler(this.f20485f.invoke(null, sSLSocket));
                if (!gVar.f20490b && gVar.f20491c == null) {
                    h.f20471b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (gVar.f20490b) {
                    return null;
                }
                return gVar.f20491c;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                throw new AssertionError();
            }
        }

        @Override // zb.h
        public EnumC0346h i() {
            return EnumC0346h.ALPN_AND_NPN;
        }
    }

    public static class g implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f20489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f20490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f20491c;

        public g(List<String> list) {
            this.f20489a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = l.f20512a;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f20490b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f20489a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj3 = objArr[0];
                if (obj3 instanceof List) {
                    List list = (List) obj3;
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f20489a.contains(list.get(i10))) {
                            obj2 = list.get(i10);
                            String str = (String) obj2;
                            this.f20491c = str;
                            return str;
                        }
                    }
                    obj2 = this.f20489a.get(0);
                    String str2 = (String) obj2;
                    this.f20491c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f20491c = (String) objArr[0];
            return null;
        }
    }

    /* JADX INFO: renamed from: zb.h$h, reason: collision with other inner class name */
    public enum EnumC0346h {
        ALPN_AND_NPN,
        NPN,
        NONE
    }

    public h(Provider provider) {
        this.f20474a = provider;
    }

    public static byte[] b(List<i> list) {
        oe.d dVar = new oe.d();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = list.get(i10);
            if (iVar != i.HTTP_1_0) {
                dVar.writeByte(iVar.toString().length());
                dVar.u(iVar.toString());
            }
        }
        return dVar.O();
    }

    public static h d() throws NoSuchMethodException {
        Method method;
        Method method2;
        EnumC0346h enumC0346h;
        Provider providerF = f();
        a aVar = null;
        if (providerF != null) {
            zb.g gVar = new zb.g(null, "setUseSessionTickets", Boolean.TYPE);
            zb.g gVar2 = new zb.g(null, "setHostname", String.class);
            zb.g gVar3 = new zb.g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            zb.g gVar4 = new zb.g(null, "setAlpnProtocols", byte[].class);
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                method = cls.getMethod("tagSocket", Socket.class);
                try {
                    method2 = cls.getMethod("untagSocket", Socket.class);
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    method2 = null;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                method = null;
            }
            if (providerF.getName().equals("GmsCore_OpenSSL") || providerF.getName().equals("Conscrypt") || providerF.getName().equals("Ssl_Guard") || k()) {
                enumC0346h = EnumC0346h.ALPN_AND_NPN;
            } else {
                enumC0346h = j() ? EnumC0346h.NPN : EnumC0346h.NONE;
            }
            return new d(gVar, gVar2, method, method2, gVar3, gVar4, providerF, enumC0346h);
        }
        try {
            Provider provider = SSLContext.getDefault().getProvider();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS", provider);
                sSLContext.init(null, null, null);
                ((Method) AccessController.doPrivileged(new a())).invoke(sSLContext.createSSLEngine(), new Object[0]);
                return new e(provider, (Method) AccessController.doPrivileged(new b()), (Method) AccessController.doPrivileged(new c()), aVar);
            } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException unused3) {
                try {
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                    return new f(cls2.getMethod("put", SSLSocket.class, cls3), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"), provider);
                } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                    return new h(provider);
                }
            }
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static h e() {
        return f20473d;
    }

    public static Provider f() {
        for (Provider provider : Security.getProviders()) {
            for (String str : f20472c) {
                if (str.equals(provider.getClass().getName())) {
                    f20471b.log(Level.FINE, "Found registered provider {0}", str);
                    return provider;
                }
            }
        }
        f20471b.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    public static boolean j() {
        try {
            h.class.getClassLoader().loadClass("android.app.ActivityOptions");
            return true;
        } catch (ClassNotFoundException e10) {
            f20471b.log(Level.FINE, "Can't find class", (Throwable) e10);
            return false;
        }
    }

    public static boolean k() {
        try {
            h.class.getClassLoader().loadClass("android.net.Network");
            return true;
        } catch (ClassNotFoundException e10) {
            f20471b.log(Level.FINE, "Can't find class", (Throwable) e10);
            return false;
        }
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List<i> list) {
    }

    public Provider g() {
        return this.f20474a;
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public EnumC0346h i() {
        return EnumC0346h.NONE;
    }
}
