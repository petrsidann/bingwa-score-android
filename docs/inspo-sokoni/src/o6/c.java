package o6;

import j6.f;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f13679a = f.f(", ").h("null");

    public static String a(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
