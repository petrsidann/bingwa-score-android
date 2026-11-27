package g1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f8502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.emoji2.text.c.e f8504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8505d = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8506e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8507f = true;

    public static class a extends androidx.emoji2.text.c.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference<EditText> f8508a;

        public a(EditText editText) {
            this.f8508a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.c.e
        public void b() {
            super.b();
            g.b(this.f8508a.get(), 1);
        }
    }

    public g(EditText editText, boolean z10) {
        this.f8502a = editText;
        this.f8503b = z10;
    }

    public static void b(EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.c.b().o(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    public final androidx.emoji2.text.c.e a() {
        if (this.f8504c == null) {
            this.f8504c = new a(this.f8502a);
        }
        return this.f8504c;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void c(boolean z10) {
        if (this.f8507f != z10) {
            if (this.f8504c != null) {
                androidx.emoji2.text.c.b().t(this.f8504c);
            }
            this.f8507f = z10;
            if (z10) {
                b(this.f8502a, androidx.emoji2.text.c.b().d());
            }
        }
    }

    public final boolean d() {
        return (this.f8507f && (this.f8503b || androidx.emoji2.text.c.h())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (this.f8502a.isInEditMode() || d() || i11 > i12 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iD = androidx.emoji2.text.c.b().d();
        if (iD != 0) {
            if (iD == 1) {
                androidx.emoji2.text.c.b().r((Spannable) charSequence, i10, i10 + i12, this.f8505d, this.f8506e);
                return;
            } else if (iD != 3) {
                return;
            }
        }
        androidx.emoji2.text.c.b().s(a());
    }
}
