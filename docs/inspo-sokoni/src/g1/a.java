package g1;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f8481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8482b = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8483c = 0;

    /* JADX INFO: renamed from: g1.a$a, reason: collision with other inner class name */
    public static class C0148a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditText f8484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f8485b;

        public C0148a(EditText editText, boolean z10) {
            this.f8484a = editText;
            g gVar = new g(editText, z10);
            this.f8485b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(g1.b.getInstance());
        }

        @Override // g1.a.b
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // g1.a.b
        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f8484a, inputConnection, editorInfo);
        }

        @Override // g1.a.b
        public void c(boolean z10) {
            this.f8485b.c(z10);
        }
    }

    public static class b {
        public KeyListener a(KeyListener keyListener) {
            throw null;
        }

        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            throw null;
        }

        public void c(boolean z10) {
            throw null;
        }
    }

    public a(EditText editText, boolean z10) {
        o0.h.h(editText, "editText cannot be null");
        this.f8481a = new C0148a(editText, z10);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f8481a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f8481a.b(inputConnection, editorInfo);
    }

    public void c(boolean z10) {
        this.f8481a.c(z10);
    }
}
