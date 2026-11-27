package b2;

import android.os.Bundle;
import androidx.lifecycle.i;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f2748b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f2749a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public b(f owner) {
        k.e(owner, "owner");
        this.f2749a = owner;
    }

    @Override // androidx.lifecycle.i
    public void c(androidx.lifecycle.k source, androidx.lifecycle.g.a event) {
        k.e(source, "source");
        k.e(event, "event");
        if (event != androidx.lifecycle.g.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.a().c(this);
        Bundle bundleB = this.f2749a.v().b("androidx.savedstate.Restarter");
        if (bundleB == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleB.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
    }

    public final void h(String str) {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, b.class.getClassLoader()).asSubclass(d.a.class);
            k.d(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(new Object[0]);
                    k.d(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((d.a) objNewInstance).a(this.f2749a);
                } catch (Exception e10) {
                    throw new RuntimeException("Failed to instantiate " + str, e10);
                }
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
            }
        } catch (ClassNotFoundException e12) {
            throw new RuntimeException("Class " + str + " wasn't found", e12);
        }
    }
}
