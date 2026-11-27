package ra;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class z implements io.flutter.plugin.editing.b.a, eb.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d[] f15325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<KeyEvent> f15326b = new HashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f15327c;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15328a = 0;

        public Character a(int i10) {
            char c10 = (char) i10;
            if ((Integer.MIN_VALUE & i10) != 0) {
                int deadChar = i10 & com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
                int i11 = this.f15328a;
                if (i11 != 0) {
                    deadChar = KeyCharacterMap.getDeadChar(i11, deadChar);
                }
                this.f15328a = deadChar;
            } else {
                int i12 = this.f15328a;
                if (i12 != 0) {
                    int deadChar2 = KeyCharacterMap.getDeadChar(i12, i10);
                    if (deadChar2 > 0) {
                        c10 = (char) deadChar2;
                    }
                    this.f15328a = 0;
                }
            }
            return Character.valueOf(c10);
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KeyEvent f15329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f15331c = false;

        public class a implements d.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f15333a;

            public a() {
                this.f15333a = false;
            }

            @Override // ra.z.d.a
            public void a(boolean z10) {
                if (this.f15333a) {
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
                this.f15333a = true;
                c cVar = c.this;
                int i10 = cVar.f15330b - 1;
                cVar.f15330b = i10;
                boolean z11 = z10 | cVar.f15331c;
                cVar.f15331c = z11;
                if (i10 != 0 || z11) {
                    return;
                }
                z.this.e(cVar.f15329a);
            }
        }

        public c(KeyEvent keyEvent) {
            this.f15330b = z.this.f15325a.length;
            this.f15329a = keyEvent;
        }

        public d.a a() {
            return new a();
        }
    }

    public interface d {

        public interface a {
            void a(boolean z10);
        }

        void a(KeyEvent keyEvent, a aVar);
    }

    public interface e {
        void b(KeyEvent keyEvent);

        boolean c(KeyEvent keyEvent);

        fb.b getBinaryMessenger();
    }

    public z(e eVar) {
        this.f15327c = eVar;
        this.f15325a = new d[]{new y(eVar.getBinaryMessenger()), new t(new eb.e(eVar.getBinaryMessenger()))};
        new eb.f(eVar.getBinaryMessenger()).b(this);
    }

    @Override // io.flutter.plugin.editing.b.a
    public boolean a(KeyEvent keyEvent) {
        if (this.f15326b.remove(keyEvent)) {
            return false;
        }
        if (this.f15325a.length <= 0) {
            e(keyEvent);
            return true;
        }
        c cVar = new c(keyEvent);
        for (d dVar : this.f15325a) {
            dVar.a(keyEvent, cVar.a());
        }
        return true;
    }

    @Override // eb.f.b
    public Map<Long, Long> b() {
        return ((y) this.f15325a[0]).h();
    }

    public void d() {
        int size = this.f15326b.size();
        if (size > 0) {
            qa.b.g("KeyboardManager", "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }

    public final void e(KeyEvent keyEvent) {
        e eVar = this.f15327c;
        if (eVar == null || eVar.c(keyEvent)) {
            return;
        }
        this.f15326b.add(keyEvent);
        this.f15327c.b(keyEvent);
        if (this.f15326b.remove(keyEvent)) {
            qa.b.g("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
        }
    }
}
