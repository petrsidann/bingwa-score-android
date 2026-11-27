package r2;

import android.util.Log;
import cd.c;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14994a = new a();

    /* JADX WARN: Code duplicated, block: B:13:0x0036 A[PHI: r5
  0x0036: PHI (r5v3 java.lang.StringBuilder) = (r5v1 java.lang.StringBuilder), (r5v4 java.lang.StringBuilder) binds: [B:9:0x0027, B:12:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    public static final boolean e(String str, xc.a<Boolean> block) {
        StringBuilder sb2;
        k.e(block, "block");
        try {
            boolean zBooleanValue = block.invoke().booleanValue();
            if (!zBooleanValue && str != null) {
                Log.e("ReflectionGuard", str);
            }
            return zBooleanValue;
        } catch (ClassNotFoundException unused) {
            sb2 = new StringBuilder();
            sb2.append("ClassNotFound: ");
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            Log.e("ReflectionGuard", sb2.toString());
            return false;
        } catch (NoSuchMethodException unused2) {
            sb2 = new StringBuilder();
            sb2.append("NoSuchMethod: ");
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            Log.e("ReflectionGuard", sb2.toString());
            return false;
        }
    }

    public final boolean a(xc.a<? extends Class<?>> classLoader) {
        k.e(classLoader, "classLoader");
        try {
            classLoader.invoke();
            return true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            return false;
        }
    }

    public final boolean b(Method method, c<?> clazz) {
        k.e(method, "<this>");
        k.e(clazz, "clazz");
        return c(method, wc.a.a(clazz));
    }

    public final boolean c(Method method, Class<?> clazz) {
        k.e(method, "<this>");
        k.e(clazz, "clazz");
        return method.getReturnType().equals(clazz);
    }

    public final boolean d(Method method) {
        k.e(method, "<this>");
        return Modifier.isPublic(method.getModifiers());
    }
}
