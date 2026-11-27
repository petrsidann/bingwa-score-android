package g9;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static boolean a(Type type) {
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }
}
