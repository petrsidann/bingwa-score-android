package o6;

import j6.m;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> extends a<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f13678a;

    public b() {
        Type typeA = a();
        this.f13678a = typeA;
        m.x(!(typeA instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", typeA);
    }

    public final Type b() {
        return this.f13678a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f13678a.equals(((b) obj).f13678a);
        }
        return false;
    }

    public int hashCode() {
        return this.f13678a.hashCode();
    }

    public String toString() {
        return c.a(this.f13678a);
    }
}
