package f2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class n0 extends l {
    public static final String[] P = {"android:visibility:visibility", "android:visibility:parent"};
    public int O = 3;

    public class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f8130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f8131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f8132c;

        public a(ViewGroup viewGroup, View view, View view2) {
            this.f8130a = viewGroup;
            this.f8131b = view;
            this.f8132c = view2;
        }

        @Override // f2.m, f2.l.f
        public void b(l lVar) {
            x.a(this.f8130a).d(this.f8131b);
        }

        @Override // f2.l.f
        public void c(l lVar) {
            this.f8132c.setTag(i.f8085a, null);
            x.a(this.f8130a).d(this.f8131b);
            lVar.U(this);
        }

        @Override // f2.m, f2.l.f
        public void e(l lVar) {
            if (this.f8131b.getParent() == null) {
                x.a(this.f8130a).c(this.f8131b);
            } else {
                n0.this.g();
            }
        }
    }

    public static class b extends AnimatorListenerAdapter implements l.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f8134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f8136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f8137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8139f = false;

        public b(View view, int i10, boolean z10) {
            this.f8134a = view;
            this.f8135b = i10;
            this.f8136c = (ViewGroup) view.getParent();
            this.f8137d = z10;
            g(true);
        }

        @Override // f2.l.f
        public void a(l lVar) {
        }

        @Override // f2.l.f
        public void b(l lVar) {
            g(false);
        }

        @Override // f2.l.f
        public void c(l lVar) {
            f();
            lVar.U(this);
        }

        @Override // f2.l.f
        public void d(l lVar) {
        }

        @Override // f2.l.f
        public void e(l lVar) {
            g(true);
        }

        public final void f() {
            if (!this.f8139f) {
                a0.h(this.f8134a, this.f8135b);
                ViewGroup viewGroup = this.f8136c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z10) {
            ViewGroup viewGroup;
            if (!this.f8137d || this.f8138e == z10 || (viewGroup = this.f8136c) == null) {
                return;
            }
            this.f8138e = z10;
            x.c(viewGroup, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f8139f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f8139f) {
                return;
            }
            a0.h(this.f8134a, this.f8135b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f8139f) {
                return;
            }
            a0.h(this.f8134a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8143d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ViewGroup f8144e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ViewGroup f8145f;
    }

    @Override // f2.l
    public String[] H() {
        return P;
    }

    @Override // f2.l
    public boolean K(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f8153a.containsKey("android:visibility:visibility") != sVar.f8153a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarI0 = i0(sVar, sVar2);
        if (cVarI0.f8140a) {
            return cVarI0.f8142c == 0 || cVarI0.f8143d == 0;
        }
        return false;
    }

    @Override // f2.l
    public void h(s sVar) {
        h0(sVar);
    }

    public final void h0(s sVar) {
        sVar.f8153a.put("android:visibility:visibility", Integer.valueOf(sVar.f8154b.getVisibility()));
        sVar.f8153a.put("android:visibility:parent", sVar.f8154b.getParent());
        int[] iArr = new int[2];
        sVar.f8154b.getLocationOnScreen(iArr);
        sVar.f8153a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0093  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
    
        if (r9 == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
    
        if (r0.f8144e == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
    
        if (r0.f8142c == 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c i0(s sVar, s sVar2) {
        c cVar = new c();
        cVar.f8140a = false;
        cVar.f8141b = false;
        if (sVar == null || !sVar.f8153a.containsKey("android:visibility:visibility")) {
            cVar.f8142c = -1;
            cVar.f8144e = null;
        } else {
            cVar.f8142c = ((Integer) sVar.f8153a.get("android:visibility:visibility")).intValue();
            cVar.f8144e = (ViewGroup) sVar.f8153a.get("android:visibility:parent");
        }
        if (sVar2 == null || !sVar2.f8153a.containsKey("android:visibility:visibility")) {
            cVar.f8143d = -1;
            cVar.f8145f = null;
        } else {
            cVar.f8143d = ((Integer) sVar2.f8153a.get("android:visibility:visibility")).intValue();
            cVar.f8145f = (ViewGroup) sVar2.f8153a.get("android:visibility:parent");
        }
        if (sVar != null && sVar2 != null) {
            int i10 = cVar.f8142c;
            int i11 = cVar.f8143d;
            if (i10 == i11 && cVar.f8144e == cVar.f8145f) {
                return cVar;
            }
            if (i10 != i11) {
                if (i10 == 0) {
                    cVar.f8141b = false;
                    cVar.f8140a = true;
                }
            } else if (cVar.f8145f == null) {
                cVar.f8141b = false;
                cVar.f8140a = true;
            }
        } else if (sVar == null && cVar.f8143d == 0) {
            cVar.f8141b = true;
            cVar.f8140a = true;
        } else if (sVar2 == null) {
        }
        return cVar;
    }

    public abstract Animator j0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public Animator k0(ViewGroup viewGroup, s sVar, int i10, s sVar2, int i11) {
        if ((this.O & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f8154b.getParent();
            if (i0(v(view, false), I(view, false)).f8140a) {
                return null;
            }
        }
        return j0(viewGroup, sVar2.f8154b, sVar, sVar2);
    }

    @Override // f2.l
    public void l(s sVar) {
        h0(sVar);
    }

    public abstract Animator l0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    public Animator m0(ViewGroup viewGroup, s sVar, int i10, s sVar2, int i11) {
        View view;
        boolean z10;
        boolean z11;
        View view2;
        if ((this.O & 2) != 2 || sVar == null) {
            return null;
        }
        View view3 = sVar.f8154b;
        View viewA = sVar2 != null ? sVar2.f8154b : null;
        int i12 = i.f8085a;
        View view4 = (View) view3.getTag(i12);
        if (view4 != null) {
            view2 = null;
            z11 = true;
        } else {
            if (viewA == null || viewA.getParent() == null) {
                if (viewA != null) {
                    view = null;
                    z10 = false;
                } else {
                    viewA = null;
                    view = null;
                    z10 = true;
                }
            } else if (i11 == 4 || view3 == viewA) {
                view = viewA;
                z10 = false;
                viewA = null;
            } else {
                viewA = null;
                view = null;
                z10 = true;
            }
            if (z10) {
                if (view3.getParent() != null) {
                    if (view3.getParent() instanceof View) {
                        View view5 = (View) view3.getParent();
                        if (i0(I(view5, true), v(view5, true)).f8140a) {
                            int id2 = view5.getId();
                            if (view5.getParent() != null || id2 == -1 || viewGroup.findViewById(id2) == null || !this.B) {
                            }
                        } else {
                            viewA = r.a(viewGroup, view3, view5);
                        }
                    }
                    z11 = false;
                    View view6 = view;
                    view4 = viewA;
                    view2 = view6;
                }
                view2 = view;
                z11 = false;
                view4 = view3;
            } else {
                z11 = false;
                View view7 = view;
                view4 = viewA;
                view2 = view7;
            }
        }
        if (view4 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            a0.h(view2, 0);
            Animator animatorL0 = l0(viewGroup, view2, sVar, sVar2);
            if (animatorL0 != null) {
                b bVar = new b(view2, i11, true);
                animatorL0.addListener(bVar);
                f2.a.a(animatorL0, bVar);
                a(bVar);
            } else {
                a0.h(view2, visibility);
            }
            return animatorL0;
        }
        if (!z11) {
            int[] iArr = (int[]) sVar.f8153a.get("android:visibility:screenLocation");
            int i13 = iArr[0];
            int i14 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view4.offsetLeftAndRight((i13 - iArr2[0]) - view4.getLeft());
            view4.offsetTopAndBottom((i14 - iArr2[1]) - view4.getTop());
            x.a(viewGroup).c(view4);
        }
        Animator animatorL1 = l0(viewGroup, view4, sVar, sVar2);
        if (!z11) {
            if (animatorL1 == null) {
                x.a(viewGroup).d(view4);
            } else {
                view3.setTag(i12, view4);
                a(new a(viewGroup, view4, view3));
            }
        }
        return animatorL1;
    }

    public void n0(int i10) {
        if ((i10 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.O = i10;
    }

    @Override // f2.l
    public Animator p(ViewGroup viewGroup, s sVar, s sVar2) {
        c cVarI0 = i0(sVar, sVar2);
        if (!cVarI0.f8140a) {
            return null;
        }
        if (cVarI0.f8144e == null && cVarI0.f8145f == null) {
            return null;
        }
        return cVarI0.f8141b ? k0(viewGroup, sVar, cVarI0.f8142c, sVar2, cVarI0.f8143d) : m0(viewGroup, sVar, cVarI0.f8142c, sVar2, cVarI0.f8143d);
    }
}
