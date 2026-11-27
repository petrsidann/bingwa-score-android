package d6;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public class x extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f6464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f6465g;

    public x(com.google.android.material.textfield.a aVar, int i10) {
        super(aVar);
        this.f6463e = z4.e.f19865a;
        this.f6465g = new View.OnClickListener() { // from class: d6.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6462a.y(view);
            }
        };
        if (i10 != 0) {
            this.f6463e = i10;
        }
    }

    public static boolean x(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EditText editText;
        PasswordTransformationMethod passwordTransformationMethod;
        EditText editText2 = this.f6464f;
        if (editText2 == null) {
            return;
        }
        int selectionEnd = editText2.getSelectionEnd();
        if (w()) {
            editText = this.f6464f;
            passwordTransformationMethod = null;
        } else {
            editText = this.f6464f;
            passwordTransformationMethod = PasswordTransformationMethod.getInstance();
        }
        editText.setTransformationMethod(passwordTransformationMethod);
        if (selectionEnd >= 0) {
            this.f6464f.setSelection(selectionEnd);
        }
        r();
    }

    @Override // d6.r
    public void b(CharSequence charSequence, int i10, int i11, int i12) {
        r();
    }

    @Override // d6.r
    public int c() {
        return z4.i.f19945v;
    }

    @Override // d6.r
    public int d() {
        return this.f6463e;
    }

    @Override // d6.r
    public View.OnClickListener f() {
        return this.f6465g;
    }

    @Override // d6.r
    public boolean l() {
        return true;
    }

    @Override // d6.r
    public boolean m() {
        return !w();
    }

    @Override // d6.r
    public void n(EditText editText) {
        this.f6464f = editText;
        r();
    }

    @Override // d6.r
    public void s() {
        if (x(this.f6464f)) {
            this.f6464f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // d6.r
    public void u() {
        EditText editText = this.f6464f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public final boolean w() {
        EditText editText = this.f6464f;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
