package s5;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import p0.p0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final boolean f15454t0 = false;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final Paint f15455u0 = null;
    public Typeface A;
    public Typeface B;
    public Typeface C;
    public w5.a D;
    public w5.a E;
    public CharSequence G;
    public CharSequence H;
    public boolean I;
    public boolean K;
    public Bitmap L;
    public Paint M;
    public float N;
    public float O;
    public float P;
    public float Q;
    public float R;
    public int S;
    public int[] T;
    public boolean U;
    public final TextPaint V;
    public final TextPaint W;
    public TimeInterpolator X;
    public TimeInterpolator Y;
    public float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f15456a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f15457a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f15458b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f15459b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15460c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ColorStateList f15461c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f15462d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f15463d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f15464e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f15465e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f15466f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f15467f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f15468g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public ColorStateList f15469g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f15470h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public float f15471h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f15472i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f15473i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f15475j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public StaticLayout f15477k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f15479l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public float f15481m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f15482n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f15483n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorStateList f15484o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public CharSequence f15485o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f15486p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f15488q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f15490r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f15492s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f15494t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f15495u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f15496v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f15497w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Typeface f15498x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Typeface f15499y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Typeface f15500z;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f15474j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15476k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f15478l = 15.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f15480m = 15.0f;
    public TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    public boolean J = true;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f15487p0 = 1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f15489q0 = 0.0f;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f15491r0 = 1.0f;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f15493s0 = l.f15525n;

    /* JADX INFO: renamed from: s5.a$a, reason: collision with other inner class name */
    public class C0273a implements w5.a.InterfaceC0310a {
        public C0273a() {
        }

        @Override // w5.a.InterfaceC0310a
        public void a(Typeface typeface) {
            a.this.T(typeface);
        }
    }

    public a(View view) {
        this.f15456a = view;
        TextPaint textPaint = new TextPaint(129);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.f15470h = new Rect();
        this.f15468g = new Rect();
        this.f15472i = new RectF();
        this.f15464e = e();
        H(view.getContext().getResources().getConfiguration());
    }

    public static boolean C(float f10, float f11) {
        return Math.abs(f10 - f11) < 1.0E-5f;
    }

    public static float G(float f10, float f11, float f12, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return a5.a.a(f10, f11, f12);
    }

    public static boolean L(Rect rect, int i10, int i11, int i12, int i13) {
        return rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13;
    }

    public static int a(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb(Math.round((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), Math.round((Color.red(i10) * f11) + (Color.red(i11) * f10)), Math.round((Color.green(i10) * f11) + (Color.green(i11) * f10)), Math.round((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
    }

    public final void A(TextPaint textPaint) {
        textPaint.setTextSize(this.f15478l);
        textPaint.setTypeface(this.f15500z);
        textPaint.setLetterSpacing(this.f15473i0);
    }

    public final void B(float f10) {
        if (this.f15460c) {
            this.f15472i.set(f10 < this.f15464e ? this.f15468g : this.f15470h);
            return;
        }
        this.f15472i.left = G(this.f15468g.left, this.f15470h.left, f10, this.X);
        this.f15472i.top = G(this.f15488q, this.f15490r, f10, this.X);
        this.f15472i.right = G(this.f15468g.right, this.f15470h.right, f10, this.X);
        this.f15472i.bottom = G(this.f15468g.bottom, this.f15470h.bottom, f10, this.X);
    }

    public final boolean D() {
        return p0.B(this.f15456a) == 1;
    }

    public final boolean E() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f15484o;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f15482n) != null && colorStateList.isStateful());
    }

    public final boolean F(CharSequence charSequence, boolean z10) {
        return (z10 ? n0.q.f13407d : n0.q.f13406c).isRtl(charSequence, 0, charSequence.length());
    }

    public void H(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f15499y;
            if (typeface != null) {
                this.f15498x = w5.i.b(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = w5.i.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f15498x;
            if (typeface3 == null) {
                typeface3 = this.f15499y;
            }
            this.f15497w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.f15500z = typeface4;
            K(true);
        }
    }

    public final float I(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void J() {
        K(false);
    }

    public void K(boolean z10) {
        if ((this.f15456a.getHeight() <= 0 || this.f15456a.getWidth() <= 0) && !z10) {
            return;
        }
        b(z10);
        c();
    }

    public void M(ColorStateList colorStateList) {
        if (this.f15484o == colorStateList && this.f15482n == colorStateList) {
            return;
        }
        this.f15484o = colorStateList;
        this.f15482n = colorStateList;
        J();
    }

    public void N(int i10, int i11, int i12, int i13) {
        if (L(this.f15470h, i10, i11, i12, i13)) {
            return;
        }
        this.f15470h.set(i10, i11, i12, i13);
        this.U = true;
    }

    public void O(Rect rect) {
        N(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void P(int i10) {
        w5.d dVar = new w5.d(this.f15456a.getContext(), i10);
        if (dVar.i() != null) {
            this.f15484o = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f15480m = dVar.j();
        }
        ColorStateList colorStateList = dVar.f17626c;
        if (colorStateList != null) {
            this.f15461c0 = colorStateList;
        }
        this.f15457a0 = dVar.f17631h;
        this.f15459b0 = dVar.f17632i;
        this.Z = dVar.f17633j;
        this.f15471h0 = dVar.f17635l;
        w5.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        this.E = new w5.a(new C0273a(), dVar.e());
        dVar.h(this.f15456a.getContext(), this.E);
        J();
    }

    public final void Q(float f10) {
        this.f15481m0 = f10;
        p0.g0(this.f15456a);
    }

    public void R(ColorStateList colorStateList) {
        if (this.f15484o != colorStateList) {
            this.f15484o = colorStateList;
            J();
        }
    }

    public void S(int i10) {
        if (this.f15476k != i10) {
            this.f15476k = i10;
            J();
        }
    }

    public void T(Typeface typeface) {
        if (U(typeface)) {
            J();
        }
    }

    public final boolean U(Typeface typeface) {
        w5.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f15499y == typeface) {
            return false;
        }
        this.f15499y = typeface;
        Typeface typefaceB = w5.i.b(this.f15456a.getContext().getResources().getConfiguration(), typeface);
        this.f15498x = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f15499y;
        }
        this.f15497w = typefaceB;
        return true;
    }

    public void V(int i10, int i11, int i12, int i13) {
        if (L(this.f15468g, i10, i11, i12, i13)) {
            return;
        }
        this.f15468g.set(i10, i11, i12, i13);
        this.U = true;
    }

    public void W(Rect rect) {
        V(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void X(float f10) {
        if (this.f15473i0 != f10) {
            this.f15473i0 = f10;
            J();
        }
    }

    public final void Y(float f10) {
        this.f15483n0 = f10;
        p0.g0(this.f15456a);
    }

    public void Z(int i10) {
        if (this.f15474j != i10) {
            this.f15474j = i10;
            J();
        }
    }

    public void a0(float f10) {
        if (this.f15478l != f10) {
            this.f15478l = f10;
            J();
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0077  */
    /* JADX WARN: Code duplicated, block: B:22:0x007d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0085  */
    /* JADX WARN: Code duplicated, block: B:27:0x0099  */
    /* JADX WARN: Code duplicated, block: B:28:0x009f  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00de  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:53:0x0105  */
    public final void b(boolean z10) {
        float fAscent;
        int i10;
        float fCenterX;
        float f10;
        float f11;
        StaticLayout staticLayout;
        float height;
        StaticLayout staticLayout2;
        CharSequence charSequence;
        StaticLayout staticLayout3;
        int lineCount;
        int i11;
        int i12;
        float fCenterX2;
        float f12;
        float fDescent;
        StaticLayout staticLayout4;
        i(1.0f, z10);
        CharSequence charSequence2 = this.H;
        if (charSequence2 != null && (staticLayout4 = this.f15477k0) != null) {
            this.f15485o0 = TextUtils.ellipsize(charSequence2, this.V, staticLayout4.getWidth(), this.F);
        }
        CharSequence charSequence3 = this.f15485o0;
        float fI = 0.0f;
        if (charSequence3 != null) {
            this.f15479l0 = I(this.V, charSequence3);
        } else {
            this.f15479l0 = 0.0f;
        }
        int iB = p0.r.b(this.f15476k, this.I ? 1 : 0);
        int i13 = iB & 112;
        if (i13 != 48) {
            if (i13 != 80) {
                this.f15490r = this.f15470h.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
            } else {
                fAscent = this.f15470h.bottom + this.V.ascent();
            }
            i10 = iB & 8388615;
            if (i10 != 1) {
                if (i10 != 5) {
                    f11 = this.f15470h.left;
                } else {
                    fCenterX = this.f15470h.right;
                    f10 = this.f15479l0;
                }
                this.f15494t = f11;
                i(0.0f, z10);
                staticLayout = this.f15477k0;
                if (staticLayout != null) {
                    height = staticLayout.getHeight();
                } else {
                    height = 0.0f;
                }
                staticLayout2 = this.f15477k0;
                if (staticLayout2 != null || this.f15487p0 <= 1) {
                    charSequence = this.H;
                    if (charSequence != null) {
                        fI = I(this.V, charSequence);
                    }
                } else {
                    fI = staticLayout2.getWidth();
                }
                staticLayout3 = this.f15477k0;
                if (staticLayout3 != null) {
                    lineCount = staticLayout3.getLineCount();
                } else {
                    lineCount = 0;
                }
                this.f15486p = lineCount;
                int iB2 = p0.r.b(this.f15474j, this.I ? 1 : 0);
                i11 = iB2 & 112;
                if (i11 != 48) {
                    if (i11 != 80) {
                        fDescent = this.f15468g.centerY() - (height / 2.0f);
                    } else {
                        fDescent = (this.f15468g.bottom - height) + this.V.descent();
                    }
                    this.f15488q = fDescent;
                } else {
                    this.f15488q = this.f15468g.top;
                }
                i12 = iB2 & 8388615;
                if (i12 != 1) {
                    if (i12 != 5) {
                        f12 = this.f15468g.left;
                    } else {
                        fCenterX2 = this.f15468g.right;
                    }
                    this.f15492s = f12;
                    j();
                    d0(this.f15458b);
                }
                fCenterX2 = this.f15468g.centerX();
                fI /= 2.0f;
                f12 = fCenterX2 - fI;
                this.f15492s = f12;
                j();
                d0(this.f15458b);
            }
            fCenterX = this.f15470h.centerX();
            f10 = this.f15479l0 / 2.0f;
            f11 = fCenterX - f10;
            this.f15494t = f11;
            i(0.0f, z10);
            staticLayout = this.f15477k0;
            if (staticLayout != null) {
                height = staticLayout.getHeight();
            } else {
                height = 0.0f;
            }
            staticLayout2 = this.f15477k0;
            if (staticLayout2 != null) {
                charSequence = this.H;
                if (charSequence != null) {
                    fI = I(this.V, charSequence);
                }
            } else {
                charSequence = this.H;
                if (charSequence != null) {
                    fI = I(this.V, charSequence);
                }
            }
            staticLayout3 = this.f15477k0;
            if (staticLayout3 != null) {
                lineCount = staticLayout3.getLineCount();
            } else {
                lineCount = 0;
            }
            this.f15486p = lineCount;
            int iB3 = p0.r.b(this.f15474j, this.I ? 1 : 0);
            i11 = iB3 & 112;
            if (i11 != 48) {
                if (i11 != 80) {
                    fDescent = this.f15468g.centerY() - (height / 2.0f);
                } else {
                    fDescent = (this.f15468g.bottom - height) + this.V.descent();
                }
                this.f15488q = fDescent;
            } else {
                this.f15488q = this.f15468g.top;
            }
            i12 = iB3 & 8388615;
            if (i12 != 1) {
                if (i12 != 5) {
                    f12 = this.f15468g.left;
                } else {
                    fCenterX2 = this.f15468g.right;
                }
                this.f15492s = f12;
                j();
                d0(this.f15458b);
            }
            fCenterX2 = this.f15468g.centerX();
            fI /= 2.0f;
            f12 = fCenterX2 - fI;
            this.f15492s = f12;
            j();
            d0(this.f15458b);
        }
        fAscent = this.f15470h.top;
        this.f15490r = fAscent;
        i10 = iB & 8388615;
        if (i10 != 1) {
            if (i10 != 5) {
                f11 = this.f15470h.left;
            } else {
                fCenterX = this.f15470h.right;
                f10 = this.f15479l0;
            }
            this.f15494t = f11;
            i(0.0f, z10);
            staticLayout = this.f15477k0;
            if (staticLayout != null) {
                height = staticLayout.getHeight();
            } else {
                height = 0.0f;
            }
            staticLayout2 = this.f15477k0;
            if (staticLayout2 != null) {
                charSequence = this.H;
                if (charSequence != null) {
                    fI = I(this.V, charSequence);
                }
            } else {
                charSequence = this.H;
                if (charSequence != null) {
                    fI = I(this.V, charSequence);
                }
            }
            staticLayout3 = this.f15477k0;
            if (staticLayout3 != null) {
                lineCount = staticLayout3.getLineCount();
            } else {
                lineCount = 0;
            }
            this.f15486p = lineCount;
            int iB4 = p0.r.b(this.f15474j, this.I ? 1 : 0);
            i11 = iB4 & 112;
            if (i11 != 48) {
                if (i11 != 80) {
                    fDescent = this.f15468g.centerY() - (height / 2.0f);
                } else {
                    fDescent = (this.f15468g.bottom - height) + this.V.descent();
                }
                this.f15488q = fDescent;
            } else {
                this.f15488q = this.f15468g.top;
            }
            i12 = iB4 & 8388615;
            if (i12 != 1) {
                if (i12 != 5) {
                    f12 = this.f15468g.left;
                } else {
                    fCenterX2 = this.f15468g.right;
                }
                this.f15492s = f12;
                j();
                d0(this.f15458b);
            }
            fCenterX2 = this.f15468g.centerX();
            fI /= 2.0f;
            f12 = fCenterX2 - fI;
            this.f15492s = f12;
            j();
            d0(this.f15458b);
        }
        fCenterX = this.f15470h.centerX();
        f10 = this.f15479l0 / 2.0f;
        f11 = fCenterX - f10;
        this.f15494t = f11;
        i(0.0f, z10);
        staticLayout = this.f15477k0;
        if (staticLayout != null) {
            height = staticLayout.getHeight();
        } else {
            height = 0.0f;
        }
        staticLayout2 = this.f15477k0;
        if (staticLayout2 != null) {
            charSequence = this.H;
            if (charSequence != null) {
                fI = I(this.V, charSequence);
            }
        } else {
            charSequence = this.H;
            if (charSequence != null) {
                fI = I(this.V, charSequence);
            }
        }
        staticLayout3 = this.f15477k0;
        if (staticLayout3 != null) {
            lineCount = staticLayout3.getLineCount();
        } else {
            lineCount = 0;
        }
        this.f15486p = lineCount;
        int iB5 = p0.r.b(this.f15474j, this.I ? 1 : 0);
        i11 = iB5 & 112;
        if (i11 != 48) {
            if (i11 != 80) {
                fDescent = this.f15468g.centerY() - (height / 2.0f);
            } else {
                fDescent = (this.f15468g.bottom - height) + this.V.descent();
            }
            this.f15488q = fDescent;
        } else {
            this.f15488q = this.f15468g.top;
        }
        i12 = iB5 & 8388615;
        if (i12 != 1) {
            if (i12 != 5) {
                f12 = this.f15468g.left;
            } else {
                fCenterX2 = this.f15468g.right;
            }
            this.f15492s = f12;
            j();
            d0(this.f15458b);
        }
        fCenterX2 = this.f15468g.centerX();
        fI /= 2.0f;
        f12 = fCenterX2 - fI;
        this.f15492s = f12;
        j();
        d0(this.f15458b);
    }

    public final boolean b0(Typeface typeface) {
        w5.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface typefaceB = w5.i.b(this.f15456a.getContext().getResources().getConfiguration(), typeface);
        this.A = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.B;
        }
        this.f15500z = typefaceB;
        return true;
    }

    public final void c() {
        g(this.f15458b);
    }

    public void c0(float f10) {
        float fA = k0.a.a(f10, 0.0f, 1.0f);
        if (fA != this.f15458b) {
            this.f15458b = fA;
            c();
        }
    }

    public final float d(float f10) {
        float f11 = this.f15464e;
        return f10 <= f11 ? a5.a.b(1.0f, 0.0f, this.f15462d, f11, f10) : a5.a.b(0.0f, 1.0f, f11, 1.0f, f10);
    }

    public final void d0(float f10) {
        h(f10);
        boolean z10 = f15454t0 && this.N != 1.0f;
        this.K = z10;
        if (z10) {
            n();
        }
        p0.g0(this.f15456a);
    }

    public final float e() {
        float f10 = this.f15462d;
        return f10 + ((1.0f - f10) * 0.5f);
    }

    public void e0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        J();
    }

    public final boolean f(CharSequence charSequence) {
        boolean zD = D();
        return this.J ? F(charSequence, zD) : zD;
    }

    public final boolean f0(int[] iArr) {
        this.T = iArr;
        if (!E()) {
            return false;
        }
        J();
        return true;
    }

    public final void g(float f10) {
        float f11;
        B(f10);
        if (!this.f15460c) {
            this.f15495u = G(this.f15492s, this.f15494t, f10, this.X);
            this.f15496v = G(this.f15488q, this.f15490r, f10, this.X);
            d0(f10);
            f11 = f10;
        } else if (f10 < this.f15464e) {
            this.f15495u = this.f15492s;
            this.f15496v = this.f15488q;
            d0(0.0f);
            f11 = 0.0f;
        } else {
            this.f15495u = this.f15494t;
            this.f15496v = this.f15490r - Math.max(0, this.f15466f);
            d0(1.0f);
            f11 = 1.0f;
        }
        TimeInterpolator timeInterpolator = a5.a.f361b;
        Q(1.0f - G(0.0f, 1.0f, 1.0f - f10, timeInterpolator));
        Y(G(1.0f, 0.0f, f10, timeInterpolator));
        if (this.f15484o != this.f15482n) {
            this.V.setColor(a(v(), t(), f11));
        } else {
            this.V.setColor(t());
        }
        float f12 = this.f15471h0;
        float f13 = this.f15473i0;
        if (f12 != f13) {
            this.V.setLetterSpacing(G(f13, f12, f10, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f12);
        }
        this.P = G(this.f15463d0, this.Z, f10, null);
        this.Q = G(this.f15465e0, this.f15457a0, f10, null);
        this.R = G(this.f15467f0, this.f15459b0, f10, null);
        int iA = a(u(this.f15469g0), u(this.f15461c0), f10);
        this.S = iA;
        this.V.setShadowLayer(this.P, this.Q, this.R, iA);
        if (this.f15460c) {
            this.V.setAlpha((int) (d(f10) * this.V.getAlpha()));
        }
        p0.g0(this.f15456a);
    }

    public void g0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            J();
        }
    }

    public final void h(float f10) {
        i(f10, false);
    }

    public void h0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        J();
    }

    public final void i(float f10, boolean z10) {
        float f11;
        float f12;
        Typeface typeface;
        if (this.G == null) {
            return;
        }
        float fWidth = this.f15470h.width();
        float fWidth2 = this.f15468g.width();
        if (C(f10, 1.0f)) {
            f11 = this.f15480m;
            f12 = this.f15471h0;
            this.N = 1.0f;
            typeface = this.f15497w;
        } else {
            float f13 = this.f15478l;
            float f14 = this.f15473i0;
            Typeface typeface2 = this.f15500z;
            if (C(f10, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = G(this.f15478l, this.f15480m, f10, this.Y) / this.f15478l;
            }
            float f15 = this.f15480m / this.f15478l;
            fWidth = (z10 || this.f15460c || fWidth2 * f15 <= fWidth) ? fWidth2 : Math.min(fWidth / f15, fWidth2);
            f11 = f13;
            f12 = f14;
            typeface = typeface2;
        }
        boolean z11 = false;
        if (fWidth > 0.0f) {
            boolean z12 = this.O != f11;
            boolean z13 = this.f15475j0 != f12;
            boolean z14 = this.C != typeface;
            StaticLayout staticLayout = this.f15477k0;
            boolean z15 = z12 || z13 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z14 || this.U;
            this.O = f11;
            this.f15475j0 = f12;
            this.C = typeface;
            this.U = false;
            this.V.setLinearText(this.N != 1.0f);
            z11 = z15;
        }
        if (this.H == null || z11) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.C);
            this.V.setLetterSpacing(this.f15475j0);
            this.I = f(this.G);
            StaticLayout staticLayoutK = k(j0() ? this.f15487p0 : 1, fWidth, this.I);
            this.f15477k0 = staticLayoutK;
            this.H = staticLayoutK.getText();
        }
    }

    public void i0(Typeface typeface) {
        boolean zU = U(typeface);
        boolean zB0 = b0(typeface);
        if (zU || zB0) {
            J();
        }
    }

    public final void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    public final boolean j0() {
        return this.f15487p0 > 1 && (!this.I || this.f15460c) && !this.K;
    }

    public final StaticLayout k(int i10, float f10, boolean z10) {
        StaticLayout staticLayoutA = null;
        try {
            staticLayoutA = l.b(this.G, this.V, (int) f10).d(this.F).g(z10).c(i10 == 1 ? Layout.Alignment.ALIGN_NORMAL : y()).f(false).i(i10).h(this.f15489q0, this.f15491r0).e(this.f15493s0).j(null).a();
        } catch (l.a e10) {
            Log.e("CollapsingTextHelper", e10.getCause().getMessage(), e10);
        }
        return (StaticLayout) o0.h.g(staticLayoutA);
    }

    public void l(Canvas canvas) {
        int iSave = canvas.save();
        if (this.H == null || this.f15472i.width() <= 0.0f || this.f15472i.height() <= 0.0f) {
            return;
        }
        this.V.setTextSize(this.O);
        float f10 = this.f15495u;
        float f11 = this.f15496v;
        boolean z10 = this.K && this.L != null;
        float f12 = this.N;
        if (f12 != 1.0f && !this.f15460c) {
            canvas.scale(f12, f12, f10, f11);
        }
        if (z10) {
            canvas.drawBitmap(this.L, f10, f11, this.M);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!j0() || (this.f15460c && this.f15458b <= this.f15464e)) {
            canvas.translate(f10, f11);
            this.f15477k0.draw(canvas);
        } else {
            m(canvas, this.f15495u - this.f15477k0.getLineStart(0), f11);
        }
        canvas.restoreToCount(iSave);
    }

    public final void m(Canvas canvas, float f10, float f11) {
        int alpha = this.V.getAlpha();
        canvas.translate(f10, f11);
        if (!this.f15460c) {
            this.V.setAlpha((int) (this.f15483n0 * alpha));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, m5.a.a(this.S, textPaint.getAlpha()));
            }
            this.f15477k0.draw(canvas);
        }
        if (!this.f15460c) {
            this.V.setAlpha((int) (this.f15481m0 * alpha));
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, m5.a.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f15477k0.getLineBaseline(0);
        CharSequence charSequence = this.f15485o0;
        float f12 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f12, this.V);
        if (i10 >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (this.f15460c) {
            return;
        }
        String strTrim = this.f15485o0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f15477k0.getLineEnd(0), str.length()), 0.0f, f12, (Paint) this.V);
    }

    public final void n() {
        if (this.L != null || this.f15468g.isEmpty() || TextUtils.isEmpty(this.H)) {
            return;
        }
        g(0.0f);
        int width = this.f15477k0.getWidth();
        int height = this.f15477k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f15477k0.draw(new Canvas(this.L));
        if (this.M == null) {
            this.M = new Paint(3);
        }
    }

    public void o(RectF rectF, int i10, int i11) {
        this.I = f(this.G);
        rectF.left = Math.max(r(i10, i11), this.f15470h.left);
        rectF.top = this.f15470h.top;
        rectF.right = Math.min(s(rectF, i10, i11), this.f15470h.right);
        rectF.bottom = this.f15470h.top + q();
    }

    public ColorStateList p() {
        return this.f15484o;
    }

    public float q() {
        z(this.W);
        return -this.W.ascent();
    }

    public final float r(int i10, int i11) {
        if (i11 == 17 || (i11 & 7) == 1) {
            return (i10 / 2.0f) - (this.f15479l0 / 2.0f);
        }
        if ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) {
            return this.I ? this.f15470h.left : this.f15470h.right - this.f15479l0;
        }
        return this.I ? this.f15470h.right - this.f15479l0 : this.f15470h.left;
    }

    public final float s(RectF rectF, int i10, int i11) {
        if (i11 == 17 || (i11 & 7) == 1) {
            return (i10 / 2.0f) + (this.f15479l0 / 2.0f);
        }
        if ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) {
            return this.I ? rectF.left + this.f15479l0 : this.f15470h.right;
        }
        return this.I ? this.f15470h.right : rectF.left + this.f15479l0;
    }

    public int t() {
        return u(this.f15484o);
    }

    public final int u(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final int v() {
        return u(this.f15482n);
    }

    public float w() {
        A(this.W);
        return -this.W.ascent();
    }

    public float x() {
        return this.f15458b;
    }

    public final Layout.Alignment y() {
        int iB = p0.r.b(this.f15474j, this.I ? 1 : 0) & 7;
        if (iB == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (iB != 5) {
            return this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
        return this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
    }

    public final void z(TextPaint textPaint) {
        textPaint.setTextSize(this.f15480m);
        textPaint.setTypeface(this.f15497w);
        textPaint.setLetterSpacing(this.f15471h0);
    }
}
