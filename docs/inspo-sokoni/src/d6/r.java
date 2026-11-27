package d6;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f6414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.material.textfield.a f6415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f6416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f6417d;

    public r(com.google.android.material.textfield.a aVar) {
        this.f6414a = aVar.f4794a;
        this.f6415b = aVar;
        this.f6416c = aVar.getContext();
        this.f6417d = aVar.r();
    }

    public void a(Editable editable) {
    }

    public void b(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public q0.c.b h() {
        return null;
    }

    public boolean i(int i10) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return false;
    }

    public void n(EditText editText) {
    }

    public void o(View view, q0.p pVar) {
    }

    public void p(View view, AccessibilityEvent accessibilityEvent) {
    }

    public void q(boolean z10) {
    }

    public final void r() {
        this.f6415b.L(false);
    }

    public void s() {
    }

    public boolean t() {
        return false;
    }

    public void u() {
    }
}
