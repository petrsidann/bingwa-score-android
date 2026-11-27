package g9;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import e9.x;
import e9.y;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d implements y, Cloneable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f9059l = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9063d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f9060a = -1.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9061b = ModuleDescriptor.MODULE_VERSION;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9062c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<e9.a> f9064e = Collections.emptyList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<e9.a> f9065f = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x<T> f9066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f9067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f9068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e9.e f9069d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ l9.a f9070e;

        public a(boolean z10, boolean z11, e9.e eVar, l9.a aVar) {
            this.f9067b = z10;
            this.f9068c = z11;
            this.f9069d = eVar;
            this.f9070e = aVar;
        }

        @Override // e9.x
        public T c(m9.a aVar) throws IOException {
            if (!this.f9067b) {
                return f().c(aVar);
            }
            aVar.v0();
            return null;
        }

        @Override // e9.x
        public void e(m9.c cVar, T t10) throws IOException {
            if (this.f9068c) {
                cVar.L();
            } else {
                f().e(cVar, t10);
            }
        }

        public final x<T> f() {
            x<T> xVar = this.f9066a;
            if (xVar != null) {
                return xVar;
            }
            x<T> xVarM = this.f9069d.m(d.this, this.f9070e);
            this.f9066a = xVarM;
            return xVarM;
        }
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean b(Class<?> cls, boolean z10) {
        return c(cls) || d(cls, z10);
    }

    public final boolean c(Class<?> cls) {
        if (this.f9060a != -1.0d && !m((f9.d) cls.getAnnotation(f9.d.class), (f9.e) cls.getAnnotation(f9.e.class))) {
            return true;
        }
        if (this.f9062c || !h(cls)) {
            return g(cls);
        }
        return true;
    }

    @Override // e9.y
    public <T> x<T> create(e9.e eVar, l9.a<T> aVar) {
        Class<? super T> clsC = aVar.c();
        boolean zC = c(clsC);
        boolean z10 = zC || d(clsC, true);
        boolean z11 = zC || d(clsC, false);
        if (z10 || z11) {
            return new a(z11, z10, eVar, aVar);
        }
        return null;
    }

    public final boolean d(Class<?> cls, boolean z10) {
        Iterator<e9.a> it = (z10 ? this.f9064e : this.f9065f).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(Field field, boolean z10) {
        f9.a aVar;
        if ((this.f9061b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f9060a != -1.0d && !m((f9.d) field.getAnnotation(f9.d.class), (f9.e) field.getAnnotation(f9.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f9063d && ((aVar = (f9.a) field.getAnnotation(f9.a.class)) == null || (!z10 ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f9062c && h(field.getType())) || g(field.getType())) {
            return true;
        }
        List<e9.a> list = z10 ? this.f9064e : this.f9065f;
        if (list.isEmpty()) {
            return false;
        }
        e9.b bVar = new e9.b(field);
        Iterator<e9.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().b(bVar)) {
                return true;
            }
        }
        return false;
    }

    public final boolean g(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || i(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    public final boolean h(Class<?> cls) {
        return cls.isMemberClass() && !i(cls);
    }

    public final boolean i(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public final boolean j(f9.d dVar) {
        if (dVar != null) {
            return this.f9060a >= dVar.value();
        }
        return true;
    }

    public final boolean l(f9.e eVar) {
        if (eVar != null) {
            return this.f9060a < eVar.value();
        }
        return true;
    }

    public final boolean m(f9.d dVar, f9.e eVar) {
        return j(dVar) && l(eVar);
    }
}
