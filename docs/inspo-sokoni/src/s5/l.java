package s5;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f15525n = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f15526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f15527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15528c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15530e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f15537l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15529d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Layout.Alignment f15531f = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15532g = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f15533h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f15534i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f15535j = f15525n;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f15536k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextUtils.TruncateAt f15538m = null;

    public static class a extends Exception {
    }

    public l(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f15526a = charSequence;
        this.f15527b = textPaint;
        this.f15528c = i10;
        this.f15530e = charSequence.length();
    }

    public static l b(CharSequence charSequence, TextPaint textPaint, int i10) {
        return new l(charSequence, textPaint, i10);
    }

    public StaticLayout a() {
        if (this.f15526a == null) {
            this.f15526a = "";
        }
        int iMax = Math.max(0, this.f15528c);
        CharSequence charSequenceEllipsize = this.f15526a;
        if (this.f15532g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f15527b, iMax, this.f15538m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f15530e);
        this.f15530e = iMin;
        if (this.f15537l && this.f15532g == 1) {
            this.f15531f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f15529d, iMin, this.f15527b, iMax);
        builderObtain.setAlignment(this.f15531f);
        builderObtain.setIncludePad(this.f15536k);
        builderObtain.setTextDirection(this.f15537l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f15538m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f15532g);
        float f10 = this.f15533h;
        if (f10 != 0.0f || this.f15534i != 1.0f) {
            builderObtain.setLineSpacing(f10, this.f15534i);
        }
        if (this.f15532g > 1) {
            builderObtain.setHyphenationFrequency(this.f15535j);
        }
        return builderObtain.build();
    }

    public l c(Layout.Alignment alignment) {
        this.f15531f = alignment;
        return this;
    }

    public l d(TextUtils.TruncateAt truncateAt) {
        this.f15538m = truncateAt;
        return this;
    }

    public l e(int i10) {
        this.f15535j = i10;
        return this;
    }

    public l f(boolean z10) {
        this.f15536k = z10;
        return this;
    }

    public l g(boolean z10) {
        this.f15537l = z10;
        return this;
    }

    public l h(float f10, float f11) {
        this.f15533h = f10;
        this.f15534i = f11;
        return this;
    }

    public l i(int i10) {
        this.f15532g = i10;
        return this;
    }

    public l j(m mVar) {
        return this;
    }
}
