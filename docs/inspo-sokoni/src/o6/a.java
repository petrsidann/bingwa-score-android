package o6;

import j6.m;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {
    public final Type a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        m.k(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
