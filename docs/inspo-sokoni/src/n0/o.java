package n0;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes.dex */
public class o implements Spannable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f13391d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Spannable f13392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f13393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PrecomputedText f13394c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextPaint f13395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f13396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f13398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f13399e;

        /* JADX INFO: renamed from: n0.o$a$a, reason: collision with other inner class name */
        public static class C0226a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextPaint f13400a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f13402c = 1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f13403d = 1;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f13401b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public C0226a(TextPaint textPaint) {
                this.f13400a = textPaint;
            }

            public a a() {
                return new a(this.f13400a, this.f13401b, this.f13402c, this.f13403d);
            }

            public C0226a b(int i10) {
                this.f13402c = i10;
                return this;
            }

            public C0226a c(int i10) {
                this.f13403d = i10;
                return this;
            }

            public C0226a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f13401b = textDirectionHeuristic;
                return this;
            }
        }

        public a(PrecomputedText.Params params) {
            this.f13395a = params.getTextPaint();
            this.f13396b = params.getTextDirection();
            this.f13397c = params.getBreakStrategy();
            this.f13398d = params.getHyphenationFrequency();
            this.f13399e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
            this.f13399e = Build.VERSION.SDK_INT >= 29 ? new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i10).setHyphenationFrequency(i11).setTextDirection(textDirectionHeuristic).build() : null;
            this.f13395a = textPaint;
            this.f13396b = textDirectionHeuristic;
            this.f13397c = i10;
            this.f13398d = i11;
        }

        public boolean a(a aVar) {
            if (this.f13397c != aVar.b() || this.f13398d != aVar.c() || this.f13395a.getTextSize() != aVar.e().getTextSize() || this.f13395a.getTextScaleX() != aVar.e().getTextScaleX() || this.f13395a.getTextSkewX() != aVar.e().getTextSkewX() || this.f13395a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f13395a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) || this.f13395a.getFlags() != aVar.e().getFlags() || !this.f13395a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return false;
            }
            if (this.f13395a.getTypeface() == null) {
                return aVar.e().getTypeface() == null;
            }
            return this.f13395a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.f13397c;
        }

        public int c() {
            return this.f13398d;
        }

        public TextDirectionHeuristic d() {
            return this.f13396b;
        }

        public TextPaint e() {
            return this.f13395a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f13396b == aVar.d();
        }

        public int hashCode() {
            return o0.c.b(Float.valueOf(this.f13395a.getTextSize()), Float.valueOf(this.f13395a.getTextScaleX()), Float.valueOf(this.f13395a.getTextSkewX()), Float.valueOf(this.f13395a.getLetterSpacing()), Integer.valueOf(this.f13395a.getFlags()), this.f13395a.getTextLocales(), this.f13395a.getTypeface(), Boolean.valueOf(this.f13395a.isElegantTextHeight()), this.f13396b, Integer.valueOf(this.f13397c), Integer.valueOf(this.f13398d));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("{");
            sb2.append("textSize=" + this.f13395a.getTextSize());
            sb2.append(", textScaleX=" + this.f13395a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f13395a.getTextSkewX());
            sb2.append(", letterSpacing=" + this.f13395a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f13395a.isElegantTextHeight());
            sb2.append(", textLocale=" + this.f13395a.getTextLocales());
            sb2.append(", typeface=" + this.f13395a.getTypeface());
            sb2.append(", variationSettings=" + this.f13395a.getFontVariationSettings());
            sb2.append(", textDir=" + this.f13396b);
            sb2.append(", breakStrategy=" + this.f13397c);
            sb2.append(", hyphenationFrequency=" + this.f13398d);
            sb2.append("}");
            return sb2.toString();
        }
    }

    public a a() {
        return this.f13393b;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f13392a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f13392a.charAt(i10);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f13392a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f13392a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f13392a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f13394c.getSpans(i10, i11, cls) : (T[]) this.f13392a.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f13392a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f13392a.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f13394c.removeSpan(obj);
        } else {
            this.f13392a.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f13394c.setSpan(obj, i10, i11, i12);
        } else {
            this.f13392a.setSpan(obj, i10, i11, i12);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f13392a.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f13392a.toString();
    }
}
