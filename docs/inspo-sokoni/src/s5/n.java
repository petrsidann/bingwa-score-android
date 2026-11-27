package s5;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f15541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f15542d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public w5.d f15545g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f15539a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w5.f f15540b = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15543e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<b> f15544f = new WeakReference<>(null);

    public class a extends w5.f {
        public a() {
        }

        @Override // w5.f
        public void a(int i10) {
            n.this.f15543e = true;
            b bVar = (b) n.this.f15544f.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // w5.f
        public void b(Typeface typeface, boolean z10) {
            if (z10) {
                return;
            }
            n.this.f15543e = true;
            b bVar = (b) n.this.f15544f.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public n(b bVar) {
        i(bVar);
    }

    public final float c(String str) {
        if (str == null) {
            return 0.0f;
        }
        return Math.abs(this.f15539a.getFontMetrics().ascent);
    }

    public final float d(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f15539a.measureText(charSequence, 0, charSequence.length());
    }

    public w5.d e() {
        return this.f15545g;
    }

    public TextPaint f() {
        return this.f15539a;
    }

    public float g(String str) {
        if (!this.f15543e) {
            return this.f15541c;
        }
        h(str);
        return this.f15541c;
    }

    public final void h(String str) {
        this.f15541c = d(str);
        this.f15542d = c(str);
        this.f15543e = false;
    }

    public void i(b bVar) {
        this.f15544f = new WeakReference<>(bVar);
    }

    public void j(w5.d dVar, Context context) {
        if (this.f15545g != dVar) {
            this.f15545g = dVar;
            if (dVar != null) {
                dVar.o(context, this.f15539a, this.f15540b);
                b bVar = this.f15544f.get();
                if (bVar != null) {
                    this.f15539a.drawableState = bVar.getState();
                }
                dVar.n(context, this.f15539a, this.f15540b);
                this.f15543e = true;
            }
            b bVar2 = this.f15544f.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void k(boolean z10) {
        this.f15543e = z10;
    }

    public void l(Context context) {
        this.f15545g.n(context, this.f15539a, this.f15540b);
    }
}
