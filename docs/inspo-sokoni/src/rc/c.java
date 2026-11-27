package rc;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.k;
import mc.d;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T extends Enum<T>> extends d<T> implements a<T>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T[] f15358b;

    public c(T[] entries) {
        k.e(entries, "entries");
        this.f15358b = entries;
    }

    @Override // mc.b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return j((Enum) obj);
        }
        return false;
    }

    @Override // mc.b
    public int h() {
        return this.f15358b.length;
    }

    @Override // mc.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return l((Enum) obj);
        }
        return -1;
    }

    public boolean j(T element) {
        k.e(element, "element");
        return ((Enum) mc.k.p(this.f15358b, element.ordinal())) == element;
    }

    @Override // mc.d, java.util.List
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public T get(int i10) {
        d.f13286a.b(i10, this.f15358b.length);
        return this.f15358b[i10];
    }

    public int l(T element) {
        k.e(element, "element");
        int iOrdinal = element.ordinal();
        if (((Enum) mc.k.p(this.f15358b, iOrdinal)) == element) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // mc.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return n((Enum) obj);
        }
        return -1;
    }

    public int n(T element) {
        k.e(element, "element");
        return indexOf(element);
    }
}
