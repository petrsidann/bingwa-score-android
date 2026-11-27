package g1;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f8491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.emoji2.text.c.e f8492b;

    public static class a extends androidx.emoji2.text.c.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference<TextView> f8493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Reference<d> f8494b;

        public a(TextView textView, d dVar) {
            this.f8493a = new WeakReference(textView);
            this.f8494b = new WeakReference(dVar);
        }

        @Override // androidx.emoji2.text.c.e
        public void b() {
            CharSequence text;
            CharSequence charSequenceO;
            super.b();
            TextView textView = this.f8493a.get();
            if (c(textView, this.f8494b.get()) && textView.isAttachedToWindow() && text != (charSequenceO = androidx.emoji2.text.c.b().o((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceO);
                int selectionEnd = Selection.getSelectionEnd(charSequenceO);
                textView.setText(charSequenceO);
                if (charSequenceO instanceof Spannable) {
                    d.b((Spannable) charSequenceO, selectionStart, selectionEnd);
                }
            }
        }

        public final boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }
    }

    public d(TextView textView) {
        this.f8491a = textView;
    }

    public static void b(Spannable spannable, int i10, int i11) {
        if (i10 >= 0 && i11 >= 0) {
            Selection.setSelection(spannable, i10, i11);
        } else if (i10 >= 0) {
            Selection.setSelection(spannable, i10);
        } else if (i11 >= 0) {
            Selection.setSelection(spannable, i11);
        }
    }

    public final androidx.emoji2.text.c.e a() {
        if (this.f8492b == null) {
            this.f8492b = new a(this.f8491a, this);
        }
        return this.f8492b;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        if (this.f8491a.isInEditMode()) {
            return charSequence;
        }
        int iD = androidx.emoji2.text.c.b().d();
        if (iD != 0) {
            boolean z10 = true;
            if (iD == 1) {
                if (i13 == 0 && i12 == 0 && spanned.length() == 0 && charSequence == this.f8491a.getText()) {
                    z10 = false;
                }
                if (!z10 || charSequence == null) {
                    return charSequence;
                }
                if (i10 != 0 || i11 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i10, i11);
                }
                return androidx.emoji2.text.c.b().p(charSequence, 0, charSequence.length());
            }
            if (iD != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.c.b().s(a());
        return charSequence;
    }
}
