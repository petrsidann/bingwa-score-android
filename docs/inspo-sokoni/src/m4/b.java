package m4;

import android.os.IBinder;
import com.google.android.gms.common.internal.r;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class b<T> extends a.AbstractBinderC0217a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12954a;

    public b(Object obj) {
        this.f12954a = obj;
    }

    public static <T> T f(a aVar) {
        if (aVar instanceof b) {
            return (T) ((b) aVar).f12954a;
        }
        IBinder iBinderAsBinder = aVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i10 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i10++;
                field = field2;
            }
        }
        if (i10 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        r.l(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(iBinderAsBinder);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e10);
        } catch (NullPointerException e11) {
            throw new IllegalArgumentException("Binder object is null.", e11);
        }
    }

    public static <T> a i(T t10) {
        return new b(t10);
    }
}
