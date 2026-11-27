package ld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f12737a = new l();

    public final <S> S a(String str, ClassLoader classLoader, Class<S> cls) throws ClassNotFoundException {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    public final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            return mc.w.L(ServiceLoader.load(cls, classLoader));
        }
    }

    public final List<v> c() {
        v vVar;
        if (!m.a()) {
            return b(v.class, v.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            v vVar2 = null;
            try {
                vVar = (v) v.class.cast(Class.forName("hd.a", true, v.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                vVar = null;
            }
            if (vVar != null) {
                arrayList.add(vVar);
            }
            try {
                vVar2 = (v) v.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, v.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (vVar2 == null) {
                return arrayList;
            }
            arrayList.add(vVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(v.class, v.class.getClassLoader());
        }
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        kotlin.jvm.internal.k.d(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            mc.t.o(arrayList, f12737a.e((URL) it.next()));
        }
        Set setP = mc.w.P(arrayList);
        if (!(!setP.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        ArrayList arrayList2 = new ArrayList(mc.p.m(setP, 10));
        Iterator it2 = setP.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f12737a.a((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }

    public final List<String> e(URL url) throws IllegalAccessException, IOException, InvocationTargetException {
        String string = url.toString();
        if (!ed.q.r(string, "jar", false, 2, null)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> listF = f12737a.f(bufferedReader);
                vc.b.a(bufferedReader, null);
                return listF;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    vc.b.a(bufferedReader, th);
                    throw th2;
                }
            }
        }
        String strM0 = ed.t.m0(ed.t.h0(string, "jar:file:", null, 2, null), '!', null, 2, null);
        String strH0 = ed.t.h0(string, "!/", null, 2, null);
        JarFile jarFile = new JarFile(strM0, false);
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(strH0)), "UTF-8"));
            try {
                List<String> listF2 = f12737a.f(bufferedReader2);
                vc.b.a(bufferedReader2, null);
                jarFile.close();
                return listF2;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    vc.b.a(bufferedReader2, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    jarFile.close();
                    throw th6;
                } catch (Throwable th7) {
                    lc.a.a(th5, th7);
                    throw th5;
                }
            }
        }
    }

    public final List<String> f(BufferedReader bufferedReader) throws IOException {
        boolean z10;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return mc.w.L(linkedHashSet);
            }
            String string = ed.t.o0(ed.t.n0(line, "#", null, 2, null)).toString();
            int i10 = 0;
            while (true) {
                if (i10 >= string.length()) {
                    z10 = true;
                    break;
                }
                char cCharAt = string.charAt(i10);
                if (!(cCharAt == '.' || Character.isJavaIdentifierPart(cCharAt))) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (!z10) {
                throw new IllegalArgumentException(("Illegal service provider class name: " + string).toString());
            }
            if (string.length() > 0) {
                linkedHashSet.add(string);
            }
        }
    }
}
