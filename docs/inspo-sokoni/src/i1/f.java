package i1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import e0.m1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import p0.s1;

/* JADX INFO: loaded from: classes.dex */
public final class f extends x0 {

    public static final class a extends x0.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f10147d;

        /* JADX INFO: renamed from: i1.f$a$a, reason: collision with other inner class name */
        public static final class AnimationAnimationListenerC0169a implements Animation.AnimationListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ x0.d f10148a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f10149b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ View f10150c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f10151d;

            public AnimationAnimationListenerC0169a(x0.d dVar, ViewGroup viewGroup, View view, a aVar) {
                this.f10148a = dVar;
                this.f10149b = viewGroup;
                this.f10150c = view;
                this.f10151d = aVar;
            }

            public static final void b(ViewGroup container, View view, a this$0) {
                kotlin.jvm.internal.k.e(container, "$container");
                kotlin.jvm.internal.k.e(this$0, "this$0");
                container.endViewTransition(view);
                this$0.h().a().f(this$0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                kotlin.jvm.internal.k.e(animation, "animation");
                final ViewGroup viewGroup = this.f10149b;
                final View view = this.f10150c;
                final a aVar = this.f10151d;
                viewGroup.post(new Runnable() { // from class: i1.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.a.AnimationAnimationListenerC0169a.b(viewGroup, view, aVar);
                    }
                });
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.f10148a + " has ended.");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                kotlin.jvm.internal.k.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                kotlin.jvm.internal.k.e(animation, "animation");
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.f10148a + " has reached onAnimationStart.");
                }
            }
        }

        public a(b animationInfo) {
            kotlin.jvm.internal.k.e(animationInfo, "animationInfo");
            this.f10147d = animationInfo;
        }

        @Override // i1.x0.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
            x0.d dVarA = this.f10147d.a();
            View view = dVarA.i().O;
            view.clearAnimation();
            container.endViewTransition(view);
            this.f10147d.a().f(this);
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + dVarA + " has been cancelled.");
            }
        }

        @Override // i1.x0.b
        public void d(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
            if (this.f10147d.b()) {
                this.f10147d.a().f(this);
                return;
            }
            Context context = container.getContext();
            x0.d dVarA = this.f10147d.a();
            View view = dVarA.i().O;
            b bVar = this.f10147d;
            kotlin.jvm.internal.k.d(context, "context");
            v.a aVarC = bVar.c(context);
            if (aVarC == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Animation animation = aVarC.f10442a;
            if (animation == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            if (dVarA.h() != x0.d.b.REMOVED) {
                view.startAnimation(animation);
                this.f10147d.a().f(this);
                return;
            }
            container.startViewTransition(view);
            v.b bVar2 = new v.b(animation, container, view);
            bVar2.setAnimationListener(new AnimationAnimationListenerC0169a(dVarA, container, view, this));
            view.startAnimation(bVar2);
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + dVarA + " has started.");
            }
        }

        public final b h() {
            return this.f10147d;
        }
    }

    public static final class b extends C0170f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f10152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public v.a f10154d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(x0.d operation, boolean z10) {
            super(operation);
            kotlin.jvm.internal.k.e(operation, "operation");
            this.f10152b = z10;
        }

        public final v.a c(Context context) {
            kotlin.jvm.internal.k.e(context, "context");
            if (this.f10153c) {
                return this.f10154d;
            }
            v.a aVarB = v.b(context, a().i(), a().h() == x0.d.b.VISIBLE, this.f10152b);
            this.f10154d = aVarB;
            this.f10153c = true;
            return aVarB;
        }
    }

    public static final class c extends x0.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f10155d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AnimatorSet f10156e;

        public static final class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f10157a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f10158b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f10159c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ x0.d f10160d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ c f10161e;

            public a(ViewGroup viewGroup, View view, boolean z10, x0.d dVar, c cVar) {
                this.f10157a = viewGroup;
                this.f10158b = view;
                this.f10159c = z10;
                this.f10160d = dVar;
                this.f10161e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator anim) {
                kotlin.jvm.internal.k.e(anim, "anim");
                this.f10157a.endViewTransition(this.f10158b);
                if (this.f10159c) {
                    x0.d.b bVarH = this.f10160d.h();
                    View viewToAnimate = this.f10158b;
                    kotlin.jvm.internal.k.d(viewToAnimate, "viewToAnimate");
                    bVarH.h(viewToAnimate, this.f10157a);
                }
                this.f10161e.h().a().f(this.f10161e);
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "Animator from operation " + this.f10160d + " has ended.");
                }
            }
        }

        public c(b animatorInfo) {
            kotlin.jvm.internal.k.e(animatorInfo, "animatorInfo");
            this.f10155d = animatorInfo;
        }

        @Override // i1.x0.b
        public boolean b() {
            return true;
        }

        @Override // i1.x0.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
            AnimatorSet animatorSet = this.f10156e;
            if (animatorSet == null) {
                this.f10155d.a().f(this);
                return;
            }
            x0.d dVarA = this.f10155d.a();
            if (dVarA.n()) {
                e.f10163a.a(animatorSet);
            } else {
                animatorSet.end();
            }
            if (h0.I0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animator from operation ");
                sb2.append(dVarA);
                sb2.append(" has been canceled");
                sb2.append(dVarA.n() ? " with seeking." : ".");
                sb2.append(' ');
                Log.v("FragmentManager", sb2.toString());
            }
        }

        @Override // i1.x0.b
        public void d(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
            x0.d dVarA = this.f10155d.a();
            AnimatorSet animatorSet = this.f10156e;
            if (animatorSet == null) {
                this.f10155d.a().f(this);
                return;
            }
            animatorSet.start();
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Animator from operation " + dVarA + " has started.");
            }
        }

        @Override // i1.x0.b
        public void e(d.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.k.e(backEvent, "backEvent");
            kotlin.jvm.internal.k.e(container, "container");
            x0.d dVarA = this.f10155d.a();
            AnimatorSet animatorSet = this.f10156e;
            if (animatorSet == null) {
                this.f10155d.a().f(this);
                return;
            }
            if (Build.VERSION.SDK_INT < 34 || !dVarA.i().f10339s) {
                return;
            }
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + dVarA);
            }
            long jA = d.f10162a.a(animatorSet);
            long jA2 = (long) (backEvent.a() * jA);
            if (jA2 == 0) {
                jA2 = 1;
            }
            if (jA2 == jA) {
                jA2 = jA - 1;
            }
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Setting currentPlayTime to " + jA2 + " for Animator " + animatorSet + " on operation " + dVarA);
            }
            e.f10163a.b(animatorSet, jA2);
        }

        @Override // i1.x0.b
        public void f(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
            if (this.f10155d.b()) {
                return;
            }
            Context context = container.getContext();
            b bVar = this.f10155d;
            kotlin.jvm.internal.k.d(context, "context");
            v.a aVarC = bVar.c(context);
            this.f10156e = aVarC != null ? aVarC.f10443b : null;
            x0.d dVarA = this.f10155d.a();
            p pVarI = dVarA.i();
            boolean z10 = dVarA.h() == x0.d.b.GONE;
            View view = pVarI.O;
            container.startViewTransition(view);
            AnimatorSet animatorSet = this.f10156e;
            if (animatorSet != null) {
                animatorSet.addListener(new a(container, view, z10, dVarA, this));
            }
            AnimatorSet animatorSet2 = this.f10156e;
            if (animatorSet2 != null) {
                animatorSet2.setTarget(view);
            }
        }

        public final b h() {
            return this.f10155d;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f10162a = new d();

        public final long a(AnimatorSet animatorSet) {
            kotlin.jvm.internal.k.e(animatorSet, "animatorSet");
            return animatorSet.getTotalDuration();
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f10163a = new e();

        public final void a(AnimatorSet animatorSet) {
            kotlin.jvm.internal.k.e(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        public final void b(AnimatorSet animatorSet, long j10) {
            kotlin.jvm.internal.k.e(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(j10);
        }
    }

    /* JADX INFO: renamed from: i1.f$f, reason: collision with other inner class name */
    public static class C0170f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x0.d f10164a;

        public C0170f(x0.d operation) {
            kotlin.jvm.internal.k.e(operation, "operation");
            this.f10164a = operation;
        }

        public final x0.d a() {
            return this.f10164a;
        }

        public final boolean b() {
            x0.d.b bVar;
            View view = this.f10164a.i().O;
            x0.d.b bVarA = view != null ? x0.d.b.f10479a.a(view) : null;
            x0.d.b bVarH = this.f10164a.h();
            return bVarA == bVarH || !(bVarA == (bVar = x0.d.b.VISIBLE) || bVarH == bVar);
        }
    }

    public static final class g extends x0.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<h> f10165d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final x0.d f10166e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final x0.d f10167f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final s0 f10168g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Object f10169h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ArrayList<View> f10170i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final ArrayList<View> f10171j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final t.a<String, String> f10172k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final ArrayList<String> f10173l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final ArrayList<String> f10174m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final t.a<String, View> f10175n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final t.a<String, View> f10176o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f10177p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final l0.f f10178q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f10179r;

        public static final class a extends kotlin.jvm.internal.l implements xc.a<lc.q> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f10181b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f10182c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ViewGroup viewGroup, Object obj) {
                super(0);
                this.f10181b = viewGroup;
                this.f10182c = obj;
            }

            public final void a() {
                g.this.v().e(this.f10181b, this.f10182c);
            }

            @Override // xc.a
            public /* bridge */ /* synthetic */ lc.q invoke() {
                a();
                return lc.q.f12711a;
            }
        }

        public static final class b extends kotlin.jvm.internal.l implements xc.a<lc.q> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f10184b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f10185c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ kotlin.jvm.internal.t<xc.a<lc.q>> f10186d;

            public static final class a extends kotlin.jvm.internal.l implements xc.a<lc.q> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ g f10187a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ViewGroup f10188b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(g gVar, ViewGroup viewGroup) {
                    super(0);
                    this.f10187a = gVar;
                    this.f10188b = viewGroup;
                }

                public static final void c(g this$0, ViewGroup container) {
                    kotlin.jvm.internal.k.e(this$0, "this$0");
                    kotlin.jvm.internal.k.e(container, "$container");
                    Iterator<T> it = this$0.w().iterator();
                    while (it.hasNext()) {
                        x0.d dVarA = ((h) it.next()).a();
                        View viewV = dVarA.i().V();
                        if (viewV != null) {
                            dVarA.h().h(viewV, container);
                        }
                    }
                }

                public final void b() {
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", "Animating to start");
                    }
                    s0 s0VarV = this.f10187a.v();
                    Object objS = this.f10187a.s();
                    kotlin.jvm.internal.k.b(objS);
                    final g gVar = this.f10187a;
                    final ViewGroup viewGroup = this.f10188b;
                    s0VarV.d(objS, new Runnable() { // from class: i1.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.b.a.c(gVar, viewGroup);
                        }
                    });
                }

                @Override // xc.a
                public /* bridge */ /* synthetic */ lc.q invoke() {
                    b();
                    return lc.q.f12711a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ViewGroup viewGroup, Object obj, kotlin.jvm.internal.t<xc.a<lc.q>> tVar) {
                super(0);
                this.f10184b = viewGroup;
                this.f10185c = obj;
                this.f10186d = tVar;
            }

            /* JADX WARN: Type inference failed for: r1v6, types: [T, i1.f$g$b$a] */
            public final void a() {
                g gVar = g.this;
                gVar.C(gVar.v().j(this.f10184b, this.f10185c));
                boolean z10 = g.this.s() != null;
                Object obj = this.f10185c;
                ViewGroup viewGroup = this.f10184b;
                if (!z10) {
                    throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + '.').toString());
                }
                this.f10186d.f12381a = new a(g.this, viewGroup);
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "Started executing operations from " + g.this.t() + " to " + g.this.u());
                }
            }

            @Override // xc.a
            public /* bridge */ /* synthetic */ lc.q invoke() {
                a();
                return lc.q.f12711a;
            }
        }

        public g(List<h> transitionInfos, x0.d dVar, x0.d dVar2, s0 transitionImpl, Object obj, ArrayList<View> sharedElementFirstOutViews, ArrayList<View> sharedElementLastInViews, t.a<String, String> sharedElementNameMapping, ArrayList<String> enteringNames, ArrayList<String> exitingNames, t.a<String, View> firstOutViews, t.a<String, View> lastInViews, boolean z10) {
            kotlin.jvm.internal.k.e(transitionInfos, "transitionInfos");
            kotlin.jvm.internal.k.e(transitionImpl, "transitionImpl");
            kotlin.jvm.internal.k.e(sharedElementFirstOutViews, "sharedElementFirstOutViews");
            kotlin.jvm.internal.k.e(sharedElementLastInViews, "sharedElementLastInViews");
            kotlin.jvm.internal.k.e(sharedElementNameMapping, "sharedElementNameMapping");
            kotlin.jvm.internal.k.e(enteringNames, "enteringNames");
            kotlin.jvm.internal.k.e(exitingNames, "exitingNames");
            kotlin.jvm.internal.k.e(firstOutViews, "firstOutViews");
            kotlin.jvm.internal.k.e(lastInViews, "lastInViews");
            this.f10165d = transitionInfos;
            this.f10166e = dVar;
            this.f10167f = dVar2;
            this.f10168g = transitionImpl;
            this.f10169h = obj;
            this.f10170i = sharedElementFirstOutViews;
            this.f10171j = sharedElementLastInViews;
            this.f10172k = sharedElementNameMapping;
            this.f10173l = enteringNames;
            this.f10174m = exitingNames;
            this.f10175n = firstOutViews;
            this.f10176o = lastInViews;
            this.f10177p = z10;
            this.f10178q = new l0.f();
        }

        public static final void A(x0.d operation, g this$0) {
            kotlin.jvm.internal.k.e(operation, "$operation");
            kotlin.jvm.internal.k.e(this$0, "this$0");
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.f(this$0);
        }

        public static final void p(x0.d dVar, x0.d dVar2, g this$0) {
            kotlin.jvm.internal.k.e(this$0, "this$0");
            q0.a(dVar.i(), dVar2.i(), this$0.f10177p, this$0.f10176o, false);
        }

        public static final void q(s0 impl, View view, Rect lastInEpicenterRect) {
            kotlin.jvm.internal.k.e(impl, "$impl");
            kotlin.jvm.internal.k.e(lastInEpicenterRect, "$lastInEpicenterRect");
            impl.k(view, lastInEpicenterRect);
        }

        public static final void r(ArrayList transitioningViews) {
            kotlin.jvm.internal.k.e(transitioningViews, "$transitioningViews");
            q0.e(transitioningViews, 4);
        }

        public static final void y(x0.d operation, g this$0) {
            kotlin.jvm.internal.k.e(operation, "$operation");
            kotlin.jvm.internal.k.e(this$0, "this$0");
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.f(this$0);
        }

        public static final void z(kotlin.jvm.internal.t seekCancelLambda) {
            kotlin.jvm.internal.k.e(seekCancelLambda, "$seekCancelLambda");
            xc.a aVar = (xc.a) seekCancelLambda.f12381a;
            if (aVar != null) {
                aVar.invoke();
            }
        }

        public final void B(ArrayList<View> arrayList, ViewGroup viewGroup, xc.a<lc.q> aVar) {
            q0.e(arrayList, 4);
            ArrayList<String> arrayListQ = this.f10168g.q(this.f10171j);
            if (h0.I0(2)) {
                Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
                Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
                for (View sharedElementFirstOutViews : this.f10170i) {
                    kotlin.jvm.internal.k.d(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                    View view = sharedElementFirstOutViews;
                    Log.v("FragmentManager", "View: " + view + " Name: " + p0.p0.J(view));
                }
                Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
                for (View sharedElementLastInViews : this.f10171j) {
                    kotlin.jvm.internal.k.d(sharedElementLastInViews, "sharedElementLastInViews");
                    View view2 = sharedElementLastInViews;
                    Log.v("FragmentManager", "View: " + view2 + " Name: " + p0.p0.J(view2));
                }
            }
            aVar.invoke();
            this.f10168g.y(viewGroup, this.f10170i, this.f10171j, arrayListQ, this.f10172k);
            q0.e(arrayList, 0);
            this.f10168g.A(this.f10169h, this.f10170i, this.f10171j);
        }

        public final void C(Object obj) {
            this.f10179r = obj;
        }

        @Override // i1.x0.b
        public boolean b() {
            boolean z10;
            if (!this.f10168g.m()) {
                return false;
            }
            List<h> list = this.f10165d;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z10 = true;
                        break;
                    }
                    h hVar = (h) it.next();
                    if (!(Build.VERSION.SDK_INT >= 34 && hVar.f() != null && this.f10168g.n(hVar.f()))) {
                        z10 = false;
                        break;
                    }
                }
            } else {
                z10 = true;
                break;
            }
            if (!z10) {
                return false;
            }
            Object obj = this.f10169h;
            return obj == null || this.f10168g.n(obj);
        }

        @Override // i1.x0.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
            this.f10178q.a();
        }

        @Override // i1.x0.b
        public void d(ViewGroup container) {
            StringBuilder sb2;
            String str;
            kotlin.jvm.internal.k.e(container, "container");
            if (!container.isLaidOut()) {
                for (h hVar : this.f10165d) {
                    x0.d dVarA = hVar.a();
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Completing operation " + dVarA);
                    }
                    hVar.a().f(this);
                }
                return;
            }
            Object obj = this.f10179r;
            if (obj != null) {
                s0 s0Var = this.f10168g;
                kotlin.jvm.internal.k.b(obj);
                s0Var.c(obj);
                if (!h0.I0(2)) {
                    return;
                }
                sb2 = new StringBuilder();
                str = "Ending execution of operations from ";
            } else {
                lc.i<ArrayList<View>, Object> iVarO = o(container, this.f10167f, this.f10166e);
                ArrayList<View> arrayListA = iVarO.a();
                Object objB = iVarO.b();
                List<h> list = this.f10165d;
                ArrayList<x0.d> arrayList = new ArrayList(mc.p.m(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((h) it.next()).a());
                }
                for (final x0.d dVar : arrayList) {
                    this.f10168g.w(dVar.i(), objB, this.f10178q, new Runnable() { // from class: i1.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.y(dVar, this);
                        }
                    });
                }
                B(arrayListA, container, new a(container, objB));
                if (!h0.I0(2)) {
                    return;
                }
                sb2 = new StringBuilder();
                str = "Completed executing operations from ";
            }
            sb2.append(str);
            sb2.append(this.f10166e);
            sb2.append(" to ");
            sb2.append(this.f10167f);
            Log.v("FragmentManager", sb2.toString());
        }

        @Override // i1.x0.b
        public void e(d.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.k.e(backEvent, "backEvent");
            kotlin.jvm.internal.k.e(container, "container");
            Object obj = this.f10179r;
            if (obj != null) {
                this.f10168g.t(obj, backEvent.a());
            }
        }

        @Override // i1.x0.b
        public void f(ViewGroup container) {
            kotlin.jvm.internal.k.e(container, "container");
            if (!container.isLaidOut()) {
                Iterator<T> it = this.f10165d.iterator();
                while (it.hasNext()) {
                    x0.d dVarA = ((h) it.next()).a();
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Skipping onStart for operation " + dVarA);
                    }
                }
                return;
            }
            if (x() && this.f10169h != null && !b()) {
                Log.i("FragmentManager", "Ignoring shared elements transition " + this.f10169h + " between " + this.f10166e + " and " + this.f10167f + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
            if (b() && x()) {
                final kotlin.jvm.internal.t tVar = new kotlin.jvm.internal.t();
                lc.i<ArrayList<View>, Object> iVarO = o(container, this.f10167f, this.f10166e);
                ArrayList<View> arrayListA = iVarO.a();
                Object objB = iVarO.b();
                List<h> list = this.f10165d;
                ArrayList<x0.d> arrayList = new ArrayList(mc.p.m(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((h) it2.next()).a());
                }
                for (final x0.d dVar : arrayList) {
                    this.f10168g.x(dVar.i(), objB, this.f10178q, new Runnable() { // from class: i1.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.z(tVar);
                        }
                    }, new Runnable() { // from class: i1.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.A(dVar, this);
                        }
                    });
                }
                B(arrayListA, container, new b(container, objB, tVar));
            }
        }

        public final void n(ArrayList<View> arrayList, View view) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (!s1.a(viewGroup)) {
                    int childCount = viewGroup.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        View child = viewGroup.getChildAt(i10);
                        if (child.getVisibility() == 0) {
                            kotlin.jvm.internal.k.d(child, "child");
                            n(arrayList, child);
                        }
                    }
                    return;
                }
                if (arrayList.contains(view)) {
                    return;
                }
            } else if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
        }

        public final lc.i<ArrayList<View>, Object> o(ViewGroup viewGroup, final x0.d dVar, final x0.d dVar2) {
            dVar = dVar;
            View view = new View(viewGroup.getContext());
            final Rect rect = new Rect();
            Iterator<h> it = this.f10165d.iterator();
            boolean z10 = false;
            View view2 = null;
            while (it.hasNext()) {
                if (it.next().g() && dVar2 != null && dVar != null && (!this.f10172k.isEmpty()) && this.f10169h != null) {
                    q0.a(dVar.i(), dVar2.i(), this.f10177p, this.f10175n, true);
                    p0.i0.a(viewGroup, new Runnable() { // from class: i1.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.g.p(dVar, dVar2, this);
                        }
                    });
                    this.f10170i.addAll(this.f10175n.values());
                    if (!this.f10174m.isEmpty()) {
                        String str = this.f10174m.get(0);
                        kotlin.jvm.internal.k.d(str, "exitingNames[0]");
                        view2 = this.f10175n.get(str);
                        this.f10168g.v(this.f10169h, view2);
                    }
                    this.f10171j.addAll(this.f10176o.values());
                    if (!this.f10173l.isEmpty()) {
                        String str2 = this.f10173l.get(0);
                        kotlin.jvm.internal.k.d(str2, "enteringNames[0]");
                        final View view3 = this.f10176o.get(str2);
                        if (view3 != null) {
                            final s0 s0Var = this.f10168g;
                            p0.i0.a(viewGroup, new Runnable() { // from class: i1.k
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f.g.q(s0Var, view3, rect);
                                }
                            });
                            z10 = true;
                        }
                    }
                    this.f10168g.z(this.f10169h, view, this.f10170i);
                    s0 s0Var2 = this.f10168g;
                    Object obj = this.f10169h;
                    s0Var2.s(obj, null, null, null, null, obj, this.f10171j);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator<h> it2 = this.f10165d.iterator();
            Object objP = null;
            Object objP2 = null;
            while (it2.hasNext()) {
                h next = it2.next();
                x0.d dVarA = next.a();
                it2 = it2;
                Object objH = this.f10168g.h(next.f());
                if (objH != null) {
                    final ArrayList<View> arrayList2 = new ArrayList<>();
                    Object obj2 = objP2;
                    View view4 = dVarA.i().O;
                    Object obj3 = objP;
                    kotlin.jvm.internal.k.d(view4, "operation.fragment.mView");
                    n(arrayList2, view4);
                    if (this.f10169h != null && (dVarA == dVar2 || dVarA == dVar)) {
                        arrayList2.removeAll(mc.w.P(dVarA == dVar2 ? this.f10170i : this.f10171j));
                    }
                    if (arrayList2.isEmpty()) {
                        this.f10168g.a(objH, view);
                    } else {
                        this.f10168g.b(objH, arrayList2);
                        this.f10168g.s(objH, objH, arrayList2, null, null, null, null);
                        if (dVarA.h() == x0.d.b.GONE) {
                            dVarA.r(false);
                            ArrayList<View> arrayList3 = new ArrayList<>(arrayList2);
                            arrayList3.remove(dVarA.i().O);
                            this.f10168g.r(objH, dVarA.i().O, arrayList3);
                            p0.i0.a(viewGroup, new Runnable() { // from class: i1.l
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f.g.r(arrayList2);
                                }
                            });
                        }
                    }
                    if (dVarA.h() == x0.d.b.VISIBLE) {
                        arrayList.addAll(arrayList2);
                        if (z10) {
                            this.f10168g.u(objH, rect);
                        }
                        if (h0.I0(2)) {
                            Log.v("FragmentManager", "Entering Transition: " + objH);
                            Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                            for (View transitioningViews : arrayList2) {
                                kotlin.jvm.internal.k.d(transitioningViews, "transitioningViews");
                                Log.v("FragmentManager", "View: " + transitioningViews);
                            }
                        }
                    } else {
                        this.f10168g.v(objH, view2);
                        if (h0.I0(2)) {
                            Log.v("FragmentManager", "Exiting Transition: " + objH);
                            Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                            for (View transitioningViews2 : arrayList2) {
                                kotlin.jvm.internal.k.d(transitioningViews2, "transitioningViews");
                                Log.v("FragmentManager", "View: " + transitioningViews2);
                            }
                        }
                    }
                    if (next.h()) {
                        objP = this.f10168g.p(obj3, objH, null);
                        objP2 = obj2;
                    } else {
                        objP2 = this.f10168g.p(obj2, objH, null);
                        objP = obj3;
                    }
                } else {
                    dVar = dVar;
                    it2 = it2;
                    objP = objP;
                }
            }
            Object objO = this.f10168g.o(objP, objP2, this.f10169h);
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Final merged transition: " + objO);
            }
            return new lc.i<>(arrayList, objO);
        }

        public final Object s() {
            return this.f10179r;
        }

        public final x0.d t() {
            return this.f10166e;
        }

        public final x0.d u() {
            return this.f10167f;
        }

        public final s0 v() {
            return this.f10168g;
        }

        public final List<h> w() {
            return this.f10165d;
        }

        public final boolean x() {
            List<h> list = this.f10165d;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!((h) it.next()).a().i().f10339s) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class h extends C0170f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f10189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f10190c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f10191d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(x0.d operation, boolean z10, boolean z11) {
            Object objO;
            boolean zP;
            Object objQ;
            super(operation);
            kotlin.jvm.internal.k.e(operation, "operation");
            x0.d.b bVarH = operation.h();
            x0.d.b bVar = x0.d.b.VISIBLE;
            if (bVarH == bVar) {
                p pVarI = operation.i();
                objO = z10 ? pVarI.M() : pVarI.w();
            } else {
                p pVarI2 = operation.i();
                objO = z10 ? pVarI2.O() : pVarI2.z();
            }
            this.f10189b = objO;
            if (operation.h() == bVar) {
                p pVarI3 = operation.i();
                zP = z10 ? pVarI3.p() : pVarI3.o();
            } else {
                zP = true;
            }
            this.f10190c = zP;
            if (z11) {
                p pVarI4 = operation.i();
                objQ = z10 ? pVarI4.Q() : pVarI4.P();
            } else {
                objQ = null;
            }
            this.f10191d = objQ;
        }

        public final s0 c() {
            s0 s0VarD = d(this.f10189b);
            s0 s0VarD2 = d(this.f10191d);
            if (s0VarD == null || s0VarD2 == null || s0VarD == s0VarD2) {
                return s0VarD == null ? s0VarD2 : s0VarD;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + a().i() + " returned Transition " + this.f10189b + " which uses a different Transition  type than its shared element transition " + this.f10191d).toString());
        }

        public final s0 d(Object obj) {
            if (obj == null) {
                return null;
            }
            s0 s0Var = q0.f10406b;
            if (s0Var != null && s0Var.g(obj)) {
                return s0Var;
            }
            s0 s0Var2 = q0.f10407c;
            if (s0Var2 != null && s0Var2.g(obj)) {
                return s0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + a().i() + " is not a valid framework Transition or AndroidX Transition");
        }

        public final Object e() {
            return this.f10191d;
        }

        public final Object f() {
            return this.f10189b;
        }

        public final boolean g() {
            return this.f10191d != null;
        }

        public final boolean h() {
            return this.f10190c;
        }
    }

    public static final class i extends kotlin.jvm.internal.l implements xc.l<Map.Entry<String, View>, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection<String> f10192a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Collection<String> collection) {
            super(1);
            this.f10192a = collection;
        }

        @Override // xc.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Map.Entry<String, View> entry) {
            kotlin.jvm.internal.k.e(entry, "entry");
            return Boolean.valueOf(mc.w.s(this.f10192a, p0.p0.J(entry.getValue())));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ViewGroup container) {
        super(container);
        kotlin.jvm.internal.k.e(container, "container");
    }

    public static final void E(f this$0, x0.d operation) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(operation, "$operation");
        this$0.c(operation);
    }

    public final void D(List<b> list) {
        StringBuilder sb2;
        String str;
        ArrayList<b> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            mc.t.o(arrayList2, ((b) it.next()).a().g());
        }
        boolean z10 = !arrayList2.isEmpty();
        boolean z11 = false;
        for (b bVar : list) {
            Context context = t().getContext();
            x0.d dVarA = bVar.a();
            kotlin.jvm.internal.k.d(context, "context");
            v.a aVarC = bVar.c(context);
            if (aVarC != null) {
                if (aVarC.f10443b == null) {
                    arrayList.add(bVar);
                } else {
                    p pVarI = dVarA.i();
                    if (!(!dVarA.g().isEmpty())) {
                        if (dVarA.h() == x0.d.b.GONE) {
                            dVarA.r(false);
                        }
                        dVarA.b(new c(bVar));
                        z11 = true;
                    } else if (h0.I0(2)) {
                        Log.v("FragmentManager", "Ignoring Animator set on " + pVarI + " as this Fragment was involved in a Transition.");
                    }
                }
            }
        }
        for (b bVar2 : arrayList) {
            x0.d dVarA2 = bVar2.a();
            p pVarI2 = dVarA2.i();
            if (z10) {
                if (h0.I0(2)) {
                    sb2 = new StringBuilder();
                    sb2.append("Ignoring Animation set on ");
                    sb2.append(pVarI2);
                    str = " as Animations cannot run alongside Transitions.";
                    sb2.append(str);
                    Log.v("FragmentManager", sb2.toString());
                }
            } else if (!z11) {
                dVarA2.b(new a(bVar2));
            } else if (h0.I0(2)) {
                sb2 = new StringBuilder();
                sb2.append("Ignoring Animation set on ");
                sb2.append(pVarI2);
                str = " as Animations cannot run alongside Animators.";
                sb2.append(str);
                Log.v("FragmentManager", sb2.toString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F(List<h> list, boolean z10, x0.d dVar, x0.d dVar2) {
        Object obj;
        boolean z11;
        s0 s0Var;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterator it;
        ArrayList arrayList3;
        ArrayList<String> arrayListR;
        ArrayList<String> arrayListS;
        m1 m1VarX;
        m1 m1VarA;
        Object obj2;
        String strB;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : list) {
            if (!((h) obj3).b()) {
                arrayList4.add(obj3);
            }
        }
        ArrayList<h> arrayList5 = new ArrayList();
        for (Object obj4 : arrayList4) {
            if (((h) obj4).c() != null) {
                arrayList5.add(obj4);
            }
        }
        s0 s0Var2 = null;
        for (h hVar : arrayList5) {
            s0 s0VarC = hVar.c();
            if (!(s0Var2 == null || s0VarC == s0Var2)) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + hVar.a().i() + " returned Transition " + hVar.f() + " which uses a different Transition type than other Fragments.").toString());
            }
            s0Var2 = s0VarC;
        }
        if (s0Var2 == null) {
            return;
        }
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        t.a aVar = new t.a();
        ArrayList<String> arrayList8 = new ArrayList<>();
        ArrayList<String> arrayList9 = new ArrayList<>();
        t.a<String, View> aVar2 = new t.a<>();
        t.a<String, View> aVar3 = new t.a<>();
        Iterator it2 = arrayList5.iterator();
        ArrayList<String> arrayList10 = arrayList8;
        ArrayList<String> arrayList11 = arrayList9;
        loop3: while (true) {
            obj = null;
            while (true) {
                if (!it2.hasNext()) {
                    break loop3;
                }
                h hVar2 = (h) it2.next();
                if (!hVar2.g() || dVar == null || dVar2 == null) {
                    s0Var = s0Var2;
                    arrayList = arrayList6;
                    arrayList2 = arrayList7;
                    it = it2;
                    arrayList3 = arrayList5;
                } else {
                    Object objB = s0Var2.B(s0Var2.h(hVar2.e()));
                    arrayListR = dVar2.i().R();
                    kotlin.jvm.internal.k.d(arrayListR, "lastIn.fragment.sharedElementSourceNames");
                    ArrayList<String> arrayListR2 = dVar.i().R();
                    kotlin.jvm.internal.k.d(arrayListR2, "firstOut.fragment.sharedElementSourceNames");
                    ArrayList<String> arrayListS2 = dVar.i().S();
                    kotlin.jvm.internal.k.d(arrayListS2, "firstOut.fragment.sharedElementTargetNames");
                    int size = arrayListS2.size();
                    s0Var = s0Var2;
                    it = it2;
                    int i10 = 0;
                    while (i10 < size) {
                        int i11 = size;
                        int iIndexOf = arrayListR.indexOf(arrayListS2.get(i10));
                        if (iIndexOf != -1) {
                            arrayListR.set(iIndexOf, arrayListR2.get(i10));
                        }
                        i10++;
                        size = i11;
                    }
                    arrayListS = dVar2.i().S();
                    kotlin.jvm.internal.k.d(arrayListS, "lastIn.fragment.sharedElementTargetNames");
                    p pVarI = dVar.i();
                    if (z10) {
                        m1VarX = pVarI.x();
                        m1VarA = dVar2.i().A();
                    } else {
                        m1VarX = pVarI.A();
                        m1VarA = dVar2.i().x();
                    }
                    lc.i iVarA = lc.m.a(m1VarX, m1VarA);
                    m1 m1Var = (m1) iVarA.a();
                    m1 m1Var2 = (m1) iVarA.b();
                    int size2 = arrayListR.size();
                    arrayList3 = arrayList5;
                    int i12 = 0;
                    while (true) {
                        arrayList2 = arrayList7;
                        if (i12 >= size2) {
                            break;
                        }
                        int i13 = size2;
                        String str = arrayListR.get(i12);
                        kotlin.jvm.internal.k.d(str, "exitingNames[i]");
                        String str2 = arrayListS.get(i12);
                        kotlin.jvm.internal.k.d(str2, "enteringNames[i]");
                        aVar.put(str, str2);
                        i12++;
                        size2 = i13;
                        arrayList7 = arrayList2;
                    }
                    if (h0.I0(2)) {
                        Log.v("FragmentManager", ">>> entering view names <<<");
                        Iterator<String> it3 = arrayListS.iterator();
                        while (true) {
                            arrayList = arrayList6;
                            if (!it3.hasNext()) {
                                break;
                            }
                            Iterator<String> it4 = it3;
                            Log.v("FragmentManager", "Name: " + it3.next());
                            objB = objB;
                            arrayList6 = arrayList;
                            it3 = it4;
                        }
                        obj2 = objB;
                        Log.v("FragmentManager", ">>> exiting view names <<<");
                        for (Iterator<String> it5 = arrayListR.iterator(); it5.hasNext(); it5 = it5) {
                            Log.v("FragmentManager", "Name: " + it5.next());
                        }
                    } else {
                        arrayList = arrayList6;
                        obj2 = objB;
                    }
                    View view = dVar.i().O;
                    kotlin.jvm.internal.k.d(view, "firstOut.fragment.mView");
                    G(aVar2, view);
                    aVar2.o(arrayListR);
                    if (m1Var != null) {
                        if (h0.I0(2)) {
                            Log.v("FragmentManager", "Executing exit callback for operation " + dVar);
                        }
                        m1Var.a(arrayListR, aVar2);
                        int size3 = arrayListR.size() - 1;
                        if (size3 >= 0) {
                            while (true) {
                                int i14 = size3 - 1;
                                String str3 = arrayListR.get(size3);
                                kotlin.jvm.internal.k.d(str3, "exitingNames[i]");
                                String str4 = str3;
                                View view2 = (View) aVar2.get(str4);
                                if (view2 == null) {
                                    aVar.remove(str4);
                                } else if (!kotlin.jvm.internal.k.a(str4, p0.p0.J(view2))) {
                                    aVar.put(p0.p0.J(view2), (String) aVar.remove(str4));
                                }
                                if (i14 < 0) {
                                    break;
                                } else {
                                    size3 = i14;
                                }
                            }
                        }
                    } else {
                        aVar.o(aVar2.keySet());
                    }
                    View view3 = dVar2.i().O;
                    kotlin.jvm.internal.k.d(view3, "lastIn.fragment.mView");
                    G(aVar3, view3);
                    aVar3.o(arrayListS);
                    aVar3.o(aVar.values());
                    if (m1Var2 != null) {
                        if (h0.I0(2)) {
                            Log.v("FragmentManager", "Executing enter callback for operation " + dVar2);
                        }
                        m1Var2.a(arrayListS, aVar3);
                        int size4 = arrayListS.size() - 1;
                        if (size4 >= 0) {
                            while (true) {
                                int i15 = size4 - 1;
                                String str5 = arrayListS.get(size4);
                                kotlin.jvm.internal.k.d(str5, "enteringNames[i]");
                                String str6 = str5;
                                View view4 = aVar3.get(str6);
                                if (view4 == null) {
                                    String strB2 = q0.b(aVar, str6);
                                    if (strB2 != null) {
                                        aVar.remove(strB2);
                                    }
                                } else if (!kotlin.jvm.internal.k.a(str6, p0.p0.J(view4)) && (strB = q0.b(aVar, str6)) != null) {
                                    aVar.put(strB, p0.p0.J(view4));
                                }
                                if (i15 < 0) {
                                    break;
                                } else {
                                    size4 = i15;
                                }
                            }
                        }
                    } else {
                        q0.d(aVar, aVar3);
                    }
                    Collection<String> collectionKeySet = aVar.keySet();
                    kotlin.jvm.internal.k.d(collectionKeySet, "sharedElementNameMapping.keys");
                    H(aVar2, collectionKeySet);
                    Collection<String> collectionValues = aVar.values();
                    kotlin.jvm.internal.k.d(collectionValues, "sharedElementNameMapping.values");
                    H(aVar3, collectionValues);
                    if (aVar.isEmpty()) {
                        break;
                    }
                    arrayList11 = arrayListR;
                    arrayList10 = arrayListS;
                    obj = obj2;
                }
                it2 = it;
                s0Var2 = s0Var;
                arrayList5 = arrayList3;
                arrayList7 = arrayList2;
                arrayList6 = arrayList;
            }
            Log.i("FragmentManager", "Ignoring shared elements transition " + obj2 + " between " + dVar + " and " + dVar2 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
            arrayList.clear();
            arrayList2.clear();
            arrayList11 = arrayListR;
            arrayList10 = arrayListS;
            it2 = it;
            s0Var2 = s0Var;
            arrayList5 = arrayList3;
            arrayList7 = arrayList2;
            arrayList6 = arrayList;
        }
        s0 s0Var3 = s0Var2;
        ArrayList arrayList12 = arrayList6;
        ArrayList arrayList13 = arrayList7;
        ArrayList arrayList14 = arrayList5;
        if (obj == null) {
            if (arrayList14.isEmpty()) {
                z11 = true;
                break;
            }
            Iterator it6 = arrayList14.iterator();
            while (true) {
                if (it6.hasNext()) {
                    if (!(((h) it6.next()).f() == null)) {
                        z11 = false;
                        break;
                    }
                } else {
                    z11 = true;
                    break;
                }
            }
            if (z11) {
                return;
            }
        }
        g gVar = new g(arrayList14, dVar, dVar2, s0Var3, obj, arrayList12, arrayList13, aVar, arrayList10, arrayList11, aVar2, aVar3, z10);
        Iterator it7 = arrayList14.iterator();
        while (it7.hasNext()) {
            ((h) it7.next()).a().b(gVar);
        }
    }

    public final void G(Map<String, View> map, View view) {
        String strJ = p0.p0.J(view);
        if (strJ != null) {
            map.put(strJ, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View child = viewGroup.getChildAt(i10);
                if (child.getVisibility() == 0) {
                    kotlin.jvm.internal.k.d(child, "child");
                    G(map, child);
                }
            }
        }
    }

    public final void H(t.a<String, View> aVar, Collection<String> collection) {
        Set<Map.Entry<String, View>> entries = aVar.entrySet();
        kotlin.jvm.internal.k.d(entries, "entries");
        mc.t.r(entries, new i(collection));
    }

    public final void I(List<? extends x0.d> list) {
        p pVarI = ((x0.d) mc.w.B(list)).i();
        for (x0.d dVar : list) {
            dVar.i().R.f10356c = pVarI.R.f10356c;
            dVar.i().R.f10357d = pVarI.R.f10357d;
            dVar.i().R.f10358e = pVarI.R.f10358e;
            dVar.i().R.f10359f = pVarI.R.f10359f;
        }
    }

    @Override // i1.x0
    public void d(List<? extends x0.d> operations, boolean z10) {
        x0.d dVar;
        Object next;
        x0.d dVar2;
        x0.d.b bVarA;
        x0.d.b bVar;
        kotlin.jvm.internal.k.e(operations, "operations");
        Iterator<T> it = operations.iterator();
        do {
            dVar = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            dVar2 = (x0.d) next;
            x0.d.b.a aVar = x0.d.b.f10479a;
            View view = dVar2.i().O;
            kotlin.jvm.internal.k.d(view, "operation.fragment.mView");
            bVarA = aVar.a(view);
            bVar = x0.d.b.VISIBLE;
        } while (!(bVarA == bVar && dVar2.h() != bVar));
        x0.d dVar3 = (x0.d) next;
        ListIterator<? extends x0.d> listIterator = operations.listIterator(operations.size());
        while (listIterator.hasPrevious()) {
            x0.d dVarPrevious = listIterator.previous();
            x0.d dVar4 = dVarPrevious;
            x0.d.b.a aVar2 = x0.d.b.f10479a;
            View view2 = dVar4.i().O;
            kotlin.jvm.internal.k.d(view2, "operation.fragment.mView");
            x0.d.b bVarA2 = aVar2.a(view2);
            x0.d.b bVar2 = x0.d.b.VISIBLE;
            if (bVarA2 != bVar2 && dVar4.h() == bVar2) {
                dVar = dVarPrevious;
                break;
            }
        }
        x0.d dVar5 = dVar;
        if (h0.I0(2)) {
            Log.v("FragmentManager", "Executing operations from " + dVar3 + " to " + dVar5);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        I(operations);
        Iterator<? extends x0.d> it2 = operations.iterator();
        while (it2.hasNext()) {
            final x0.d next2 = it2.next();
            arrayList.add(new b(next2, z10));
            arrayList2.add(new h(next2, z10, !z10 ? next2 != dVar5 : next2 != dVar3));
            next2.a(new Runnable() { // from class: i1.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.E(this.f10140a, next2);
                }
            });
        }
        F(arrayList2, z10, dVar3, dVar5);
        D(arrayList);
    }
}
