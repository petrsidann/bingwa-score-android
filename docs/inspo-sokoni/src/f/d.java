package f;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, String> f7998a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f7999b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, c> f8000c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<String> f8001d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Map<String, b<?>> f8002e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f8003f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f8004g = new Bundle();

    /* JADX INFO: Add missing generic type declarations: [I] */
    public class a<I> extends f.c<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g.a f8006b;

        public a(String str, g.a aVar) {
            this.f8005a = str;
            this.f8006b = aVar;
        }

        @Override // f.c
        public void b(I i10, e0.d dVar) throws Exception {
            Integer num = d.this.f7999b.get(this.f8005a);
            if (num != null) {
                d.this.f8001d.add(this.f8005a);
                try {
                    d.this.f(num.intValue(), this.f8006b, i10, dVar);
                    return;
                } catch (Exception e10) {
                    d.this.f8001d.remove(this.f8005a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f8006b + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // f.c
        public void c() {
            d.this.k(this.f8005a);
        }
    }

    public static class b<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f.b<O> f8008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g.a<?, O> f8009b;

        public b(f.b<O> bVar, g.a<?, O> aVar) {
            this.f8008a = bVar;
            this.f8009b = aVar;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f8010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<i> f8011b;

        public void a() {
            Iterator<i> it = this.f8011b.iterator();
            while (it.hasNext()) {
                this.f8010a.c(it.next());
            }
            this.f8011b.clear();
        }
    }

    public final void a(int i10, String str) {
        this.f7998a.put(Integer.valueOf(i10), str);
        this.f7999b.put(str, Integer.valueOf(i10));
    }

    public final boolean b(int i10, int i11, Intent intent) {
        String str = this.f7998a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        d(str, i11, intent, this.f8002e.get(str));
        return true;
    }

    public final <O> boolean c(int i10, O o10) {
        f.b<?> bVar;
        String str = this.f7998a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        b<?> bVar2 = this.f8002e.get(str);
        if (bVar2 == null || (bVar = bVar2.f8008a) == null) {
            this.f8004g.remove(str);
            this.f8003f.put(str, o10);
            return true;
        }
        if (!this.f8001d.remove(str)) {
            return true;
        }
        bVar.a(o10);
        return true;
    }

    public final <O> void d(String str, int i10, Intent intent, b<O> bVar) {
        if (bVar == null || bVar.f8008a == null || !this.f8001d.contains(str)) {
            this.f8003f.remove(str);
            this.f8004g.putParcelable(str, new f.a(i10, intent));
        } else {
            bVar.f8008a.a(bVar.f8009b.c(i10, intent));
            this.f8001d.remove(str);
        }
    }

    public final int e() {
        int iC = zc.c.f20515a.c(2147418112);
        while (true) {
            int i10 = iC + 65536;
            if (!this.f7998a.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            iC = zc.c.f20515a.c(2147418112);
        }
    }

    public abstract <I, O> void f(int i10, g.a<I, O> aVar, I i11, e0.d dVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f8001d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f8004g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
            String str = stringArrayList.get(i10);
            if (this.f7999b.containsKey(str)) {
                Integer numRemove = this.f7999b.remove(str);
                if (!this.f8004g.containsKey(str)) {
                    this.f7998a.remove(numRemove);
                }
            }
            a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f7999b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f7999b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f8001d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f8004g.clone());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> f.c<I> i(String str, g.a<I, O> aVar, f.b<O> bVar) {
        j(str);
        this.f8002e.put(str, new b<>(bVar, aVar));
        if (this.f8003f.containsKey(str)) {
            Object obj = this.f8003f.get(str);
            this.f8003f.remove(str);
            bVar.a(obj);
        }
        f.a aVar2 = (f.a) this.f8004g.getParcelable(str);
        if (aVar2 != null) {
            this.f8004g.remove(str);
            bVar.a(aVar.c(aVar2.b(), aVar2.a()));
        }
        return new a(str, aVar);
    }

    public final void j(String str) {
        if (this.f7999b.get(str) != null) {
            return;
        }
        a(e(), str);
    }

    public final void k(String str) {
        Integer numRemove;
        if (!this.f8001d.contains(str) && (numRemove = this.f7999b.remove(str)) != null) {
            this.f7998a.remove(numRemove);
        }
        this.f8002e.remove(str);
        if (this.f8003f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f8003f.get(str));
            this.f8003f.remove(str);
        }
        if (this.f8004g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f8004g.getParcelable(str));
            this.f8004g.remove(str);
        }
        c cVar = this.f8000c.get(str);
        if (cVar != null) {
            cVar.a();
            this.f8000c.remove(str);
        }
    }
}
