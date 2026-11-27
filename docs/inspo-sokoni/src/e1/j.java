package e1;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;
import n0.o;

/* JADX INFO: loaded from: classes.dex */
public class j implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6957a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Spannable f6958b;

    public static class a {
        public static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        public static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    public static class b {
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof o;
        }
    }

    public static class c extends b {
        @Override // e1.j.b
        public boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof o);
        }
    }

    public j(Spannable spannable) {
        this.f6958b = spannable;
    }

    public j(CharSequence charSequence) {
        this.f6958b = new SpannableString(charSequence);
    }

    public static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    public final void a() {
        Spannable spannable = this.f6958b;
        if (!this.f6957a && c().a(spannable)) {
            this.f6958b = new SpannableString(spannable);
        }
        this.f6957a = true;
    }

    public Spannable b() {
        return this.f6958b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f6958b.charAt(i10);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f6958b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f6958b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f6958b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f6958b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f6958b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return (T[]) this.f6958b.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f6958b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f6958b.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f6958b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        a();
        this.f6958b.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f6958b.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f6958b.toString();
    }
}
