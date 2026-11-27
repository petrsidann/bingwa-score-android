package i1;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import e0.g1;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {
    public static boolean U = false;
    public static boolean V = true;
    public i1.p A;
    public f.c<Intent> F;
    public f.c<f.f> G;
    public f.c<String[]> H;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public ArrayList<i1.a> O;
    public ArrayList<Boolean> P;
    public ArrayList<i1.p> Q;
    public k0 R;
    public j1.c.C0182c S;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10199b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<i1.p> f10202e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d.p f10204g;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public z<?> f10221x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public w f10222y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public i1.p f10223z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<n> f10198a = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o0 f10200c = new o0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<i1.a> f10201d = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a0 f10203f = new a0(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i1.a f10205h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10206i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d.o f10207j = new b(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f10208k = new AtomicInteger();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, i1.c> f10209l = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Bundle> f10210m = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Object> f10211n = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<m> f10212o = new ArrayList<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b0 f10213p = new b0(this);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList<l0> f10214q = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final o0.a<Configuration> f10215r = new o0.a() { // from class: i1.c0
        @Override // o0.a
        public final void accept(Object obj) {
            this.f10139a.R0((Configuration) obj);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final o0.a<Integer> f10216s = new o0.a() { // from class: i1.d0
        @Override // o0.a
        public final void accept(Object obj) {
            this.f10142a.S0((Integer) obj);
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final o0.a<e0.n> f10217t = new o0.a() { // from class: i1.e0
        @Override // o0.a
        public final void accept(Object obj) {
            this.f10146a.T0((e0.n) obj);
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final o0.a<g1> f10218u = new o0.a() { // from class: i1.f0
        @Override // o0.a
        public final void accept(Object obj) {
            this.f10193a.U0((g1) obj);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p0.y f10219v = new c();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10220w = -1;
    public y B = null;
    public y C = new d();
    public y0 D = null;
    public y0 E = new e();
    public ArrayDeque<l> I = new ArrayDeque<>();
    public Runnable T = new f();

    public class a implements f.b<Map<String, Boolean>> {
        public a() {
        }

        @Override // f.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<String, Boolean> map) {
            StringBuilder sb2;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            l lVarPollFirst = h0.this.I.pollFirst();
            if (lVarPollFirst == null) {
                sb2 = new StringBuilder();
                sb2.append("No permissions were requested for ");
                sb2.append(this);
            } else {
                String str = lVarPollFirst.f10234a;
                int i11 = lVarPollFirst.f10235b;
                i1.p pVarI = h0.this.f10200c.i(str);
                if (pVarI != null) {
                    pVarI.J0(i11, strArr, iArr);
                    return;
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("Permission request result delivered for unknown Fragment ");
                    sb2.append(str);
                }
            }
            Log.w("FragmentManager", sb2.toString());
        }
    }

    public class b extends d.o {
        public b(boolean z10) {
            super(z10);
        }

        @Override // d.o
        public void c() {
            if (h0.I0(3)) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = " + h0.V + " fragment manager " + h0.this);
            }
            if (h0.V) {
                h0.this.o();
                h0.this.f10205h = null;
            }
        }

        @Override // d.o
        public void d() {
            if (h0.I0(3)) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = " + h0.V + " fragment manager " + h0.this);
            }
            h0.this.E0();
        }

        @Override // d.o
        public void e(d.b bVar) {
            if (h0.I0(2)) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = " + h0.V + " fragment manager " + h0.this);
            }
            h0 h0Var = h0.this;
            if (h0Var.f10205h != null) {
                Iterator<x0> it = h0Var.u(new ArrayList<>(Collections.singletonList(h0.this.f10205h)), 0, 1).iterator();
                while (it.hasNext()) {
                    it.next().y(bVar);
                }
                Iterator<m> it2 = h0.this.f10212o.iterator();
                while (it2.hasNext()) {
                    it2.next().d(bVar);
                }
            }
        }

        @Override // d.o
        public void f(d.b bVar) {
            if (h0.I0(3)) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = " + h0.V + " fragment manager " + h0.this);
            }
            if (h0.V) {
                h0.this.X();
                h0.this.g1();
            }
        }
    }

    public class c implements p0.y {
        public c() {
        }

        @Override // p0.y
        public boolean a(MenuItem menuItem) {
            return h0.this.J(menuItem);
        }

        @Override // p0.y
        public void b(Menu menu) {
            h0.this.K(menu);
        }

        @Override // p0.y
        public void c(Menu menu, MenuInflater menuInflater) {
            h0.this.C(menu, menuInflater);
        }

        @Override // p0.y
        public void d(Menu menu) {
            h0.this.O(menu);
        }
    }

    public class d extends y {
        public d() {
        }

        @Override // i1.y
        public i1.p a(ClassLoader classLoader, String str) {
            return h0.this.v0().f(h0.this.v0().o(), str, null);
        }
    }

    public class e implements y0 {
        public e() {
        }

        @Override // i1.y0
        public x0 a(ViewGroup viewGroup) {
            return new i1.f(viewGroup);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h0.this.a0(true);
        }
    }

    public class g implements l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i1.p f10230a;

        public g(i1.p pVar) {
            this.f10230a = pVar;
        }

        @Override // i1.l0
        public void b(h0 h0Var, i1.p pVar) {
            this.f10230a.n0(pVar);
        }
    }

    public class h implements f.b<f.a> {
        public h() {
        }

        @Override // f.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f.a aVar) {
            l lVarPollLast = h0.this.I.pollLast();
            if (lVarPollLast == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = lVarPollLast.f10234a;
            int i10 = lVarPollLast.f10235b;
            i1.p pVarI = h0.this.f10200c.i(str);
            if (pVarI != null) {
                pVarI.k0(i10, aVar.b(), aVar.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    public class i implements f.b<f.a> {
        public i() {
        }

        @Override // f.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(f.a aVar) {
            l lVarPollFirst = h0.this.I.pollFirst();
            if (lVarPollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = lVarPollFirst.f10234a;
            int i10 = lVarPollFirst.f10235b;
            i1.p pVarI = h0.this.f10200c.i(str);
            if (pVarI != null) {
                pVarI.k0(i10, aVar.b(), aVar.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    public static class j extends g.a<f.f, f.a> {
        @Override // g.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, f.f fVar) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = fVar.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    fVar = new f.f.a(fVar.d()).b(null).c(fVar.c(), fVar.b()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", fVar);
            if (h0.I0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // g.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public f.a c(int i10, Intent intent) {
            return new f.a(i10, intent);
        }
    }

    public static abstract class k {
    }

    public static class l implements Parcelable {
        public static final Parcelable.Creator<l> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10235b;

        public class a implements Parcelable.Creator<l> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public l createFromParcel(Parcel parcel) {
                return new l(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public l[] newArray(int i10) {
                return new l[i10];
            }
        }

        public l(Parcel parcel) {
            this.f10234a = parcel.readString();
            this.f10235b = parcel.readInt();
        }

        public l(String str, int i10) {
            this.f10234a = str;
            this.f10235b = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f10234a);
            parcel.writeInt(this.f10235b);
        }
    }

    public interface m {
        default void a(i1.p pVar, boolean z10) {
        }

        default void b(i1.p pVar, boolean z10) {
        }

        default void c() {
        }

        default void d(d.b bVar) {
        }

        void onBackStackChanged();
    }

    public interface n {
        boolean a(ArrayList<i1.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class o implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10238c;

        public o(String str, int i10, int i11) {
            this.f10236a = str;
            this.f10237b = i10;
            this.f10238c = i11;
        }

        @Override // i1.h0.n
        public boolean a(ArrayList<i1.a> arrayList, ArrayList<Boolean> arrayList2) {
            i1.p pVar = h0.this.A;
            if (pVar == null || this.f10237b >= 0 || this.f10236a != null || !pVar.s().b1()) {
                return h0.this.e1(arrayList, arrayList2, this.f10236a, this.f10237b, this.f10238c);
            }
            return false;
        }
    }

    public class p implements n {
        public p() {
        }

        @Override // i1.h0.n
        public boolean a(ArrayList<i1.a> arrayList, ArrayList<Boolean> arrayList2) {
            boolean zF1 = h0.this.f1(arrayList, arrayList2);
            h0 h0Var = h0.this;
            h0Var.f10206i = true;
            if (!h0Var.f10212o.isEmpty() && arrayList.size() > 0) {
                boolean zBooleanValue = arrayList2.get(arrayList.size() - 1).booleanValue();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator<i1.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.addAll(h0.this.n0(it.next()));
                }
                for (m mVar : h0.this.f10212o) {
                    Iterator it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        mVar.b((i1.p) it2.next(), zBooleanValue);
                    }
                }
            }
            return zF1;
        }
    }

    public static i1.p C0(View view) {
        Object tag = view.getTag(h1.b.f9582a);
        if (tag instanceof i1.p) {
            return (i1.p) tag;
        }
        return null;
    }

    public static boolean I0(int i10) {
        return U || Log.isLoggable("FragmentManager", i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(Configuration configuration) {
        if (K0()) {
            z(configuration, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(Integer num) {
        if (K0() && num.intValue() == 80) {
            F(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(e0.n nVar) {
        if (K0()) {
            G(nVar.a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(g1 g1Var) {
        if (K0()) {
            N(g1Var.a(), false);
        }
    }

    public static void c0(ArrayList<i1.a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        while (i10 < i11) {
            i1.a aVar = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue()) {
                aVar.p(-1);
                aVar.u();
            } else {
                aVar.p(1);
                aVar.t();
            }
            i10++;
        }
    }

    public static h0 k0(View view) {
        u uVar;
        i1.p pVarL0 = l0(view);
        if (pVarL0 != null) {
            if (pVarL0.a0()) {
                return pVarL0.s();
            }
            throw new IllegalStateException("The Fragment " + pVarL0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                uVar = null;
                break;
            }
            if (context instanceof u) {
                uVar = (u) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (uVar != null) {
            return uVar.S();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    public static i1.p l0(View view) {
        while (view != null) {
            i1.p pVarC0 = C0(view);
            if (pVarC0 != null) {
                return pVarC0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static int l1(int i10) {
        int i11 = 4097;
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 != 8194) {
            i11 = 8197;
            if (i10 == 8197) {
                return 4100;
            }
            if (i10 == 4099) {
                return 4099;
            }
            if (i10 != 4100) {
                return 0;
            }
        }
        return i11;
    }

    public boolean A(MenuItem menuItem) {
        if (this.f10220w < 1) {
            return false;
        }
        for (i1.p pVar : this.f10200c.o()) {
            if (pVar != null && pVar.T0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public y0 A0() {
        y0 y0Var = this.D;
        if (y0Var != null) {
            return y0Var;
        }
        i1.p pVar = this.f10223z;
        return pVar != null ? pVar.f10346z.A0() : this.E;
    }

    public void B() {
        this.K = false;
        this.L = false;
        this.R.o(false);
        S(1);
    }

    public j1.c.C0182c B0() {
        return this.S;
    }

    public boolean C(Menu menu, MenuInflater menuInflater) {
        if (this.f10220w < 1) {
            return false;
        }
        ArrayList<i1.p> arrayList = null;
        boolean z10 = false;
        for (i1.p pVar : this.f10200c.o()) {
            if (pVar != null && M0(pVar) && pVar.V0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(pVar);
                z10 = true;
            }
        }
        if (this.f10202e != null) {
            for (int i10 = 0; i10 < this.f10202e.size(); i10++) {
                i1.p pVar2 = this.f10202e.get(i10);
                if (arrayList == null || !arrayList.contains(pVar2)) {
                    pVar2.v0();
                }
            }
        }
        this.f10202e = arrayList;
        return z10;
    }

    public void D() {
        this.M = true;
        a0(true);
        X();
        s();
        S(-1);
        Object obj = this.f10221x;
        if (obj instanceof f0.g) {
            ((f0.g) obj).t(this.f10216s);
        }
        Object obj2 = this.f10221x;
        if (obj2 instanceof f0.f) {
            ((f0.f) obj2).i(this.f10215r);
        }
        Object obj3 = this.f10221x;
        if (obj3 instanceof e0.p0) {
            ((e0.p0) obj3).g(this.f10217t);
        }
        Object obj4 = this.f10221x;
        if (obj4 instanceof e0.q0) {
            ((e0.q0) obj4).c(this.f10218u);
        }
        Object obj5 = this.f10221x;
        if ((obj5 instanceof p0.v) && this.f10223z == null) {
            ((p0.v) obj5).p(this.f10219v);
        }
        this.f10221x = null;
        this.f10222y = null;
        this.f10223z = null;
        if (this.f10204g != null) {
            this.f10207j.h();
            this.f10204g = null;
        }
        f.c<Intent> cVar = this.F;
        if (cVar != null) {
            cVar.c();
            this.G.c();
            this.H.c();
        }
    }

    public androidx.lifecycle.i0 D0(i1.p pVar) {
        return this.R.l(pVar);
    }

    public void E() {
        S(1);
    }

    public void E0() {
        a0(true);
        if (!V || this.f10205h == null) {
            if (this.f10207j.g()) {
                if (I0(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                b1();
                return;
            } else {
                if (I0(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                this.f10204g.k();
                return;
            }
        }
        if (!this.f10212o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(n0(this.f10205h));
            for (m mVar : this.f10212o) {
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    mVar.a((i1.p) it.next(), true);
                }
            }
        }
        Iterator<p0.a> it2 = this.f10205h.f10378c.iterator();
        while (it2.hasNext()) {
            i1.p pVar = it2.next().f10396b;
            if (pVar != null) {
                pVar.f10339s = false;
            }
        }
        Iterator<x0> it3 = u(new ArrayList<>(Collections.singletonList(this.f10205h)), 0, 1).iterator();
        while (it3.hasNext()) {
            it3.next().f();
        }
        this.f10205h = null;
        v1();
        if (I0(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + this.f10207j.g() + " for  FragmentManager " + this);
        }
    }

    public void F(boolean z10) {
        if (z10 && (this.f10221x instanceof f0.g)) {
            u1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (i1.p pVar : this.f10200c.o()) {
            if (pVar != null) {
                pVar.b1();
                if (z10) {
                    pVar.B.F(true);
                }
            }
        }
    }

    public void F0(i1.p pVar) {
        if (I0(2)) {
            Log.v("FragmentManager", "hide: " + pVar);
        }
        if (pVar.G) {
            return;
        }
        pVar.G = true;
        pVar.U = true ^ pVar.U;
        r1(pVar);
    }

    public void G(boolean z10, boolean z11) {
        if (z11 && (this.f10221x instanceof e0.p0)) {
            u1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (i1.p pVar : this.f10200c.o()) {
            if (pVar != null) {
                pVar.c1(z10);
                if (z11) {
                    pVar.B.G(z10, true);
                }
            }
        }
    }

    public void G0(i1.p pVar) {
        if (pVar.f10337q && J0(pVar)) {
            this.J = true;
        }
    }

    public void H(i1.p pVar) {
        Iterator<l0> it = this.f10214q.iterator();
        while (it.hasNext()) {
            it.next().b(this, pVar);
        }
    }

    public boolean H0() {
        return this.M;
    }

    public void I() {
        for (i1.p pVar : this.f10200c.l()) {
            if (pVar != null) {
                pVar.z0(pVar.b0());
                pVar.B.I();
            }
        }
    }

    public boolean J(MenuItem menuItem) {
        if (this.f10220w < 1) {
            return false;
        }
        for (i1.p pVar : this.f10200c.o()) {
            if (pVar != null && pVar.d1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean J0(i1.p pVar) {
        return (pVar.K && pVar.L) || pVar.B.p();
    }

    public void K(Menu menu) {
        if (this.f10220w < 1) {
            return;
        }
        for (i1.p pVar : this.f10200c.o()) {
            if (pVar != null) {
                pVar.e1(menu);
            }
        }
    }

    public final boolean K0() {
        i1.p pVar = this.f10223z;
        if (pVar == null) {
            return true;
        }
        return pVar.a0() && this.f10223z.H().K0();
    }

    public final void L(i1.p pVar) {
        if (pVar == null || !pVar.equals(f0(pVar.f10328f))) {
            return;
        }
        pVar.i1();
    }

    public boolean L0(i1.p pVar) {
        if (pVar == null) {
            return false;
        }
        return pVar.b0();
    }

    public void M() {
        S(5);
    }

    public boolean M0(i1.p pVar) {
        if (pVar == null) {
            return true;
        }
        return pVar.d0();
    }

    public void N(boolean z10, boolean z11) {
        if (z11 && (this.f10221x instanceof e0.q0)) {
            u1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (i1.p pVar : this.f10200c.o()) {
            if (pVar != null) {
                pVar.g1(z10);
                if (z11) {
                    pVar.B.N(z10, true);
                }
            }
        }
    }

    public boolean N0(i1.p pVar) {
        if (pVar == null) {
            return true;
        }
        h0 h0Var = pVar.f10346z;
        return pVar.equals(h0Var.z0()) && N0(h0Var.f10223z);
    }

    public boolean O(Menu menu) {
        boolean z10 = false;
        if (this.f10220w < 1) {
            return false;
        }
        for (i1.p pVar : this.f10200c.o()) {
            if (pVar != null && M0(pVar) && pVar.h1(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean O0(int i10) {
        return this.f10220w >= i10;
    }

    public void P() {
        v1();
        L(this.A);
    }

    public boolean P0() {
        return this.K || this.L;
    }

    public void Q() {
        this.K = false;
        this.L = false;
        this.R.o(false);
        S(7);
    }

    public void R() {
        this.K = false;
        this.L = false;
        this.R.o(false);
        S(5);
    }

    public final void S(int i10) {
        try {
            this.f10199b = true;
            this.f10200c.d(i10);
            W0(i10, false);
            Iterator<x0> it = t().iterator();
            while (it.hasNext()) {
                it.next().q();
            }
            this.f10199b = false;
            a0(true);
        } catch (Throwable th) {
            this.f10199b = false;
            throw th;
        }
    }

    public void T() {
        this.L = true;
        this.R.o(true);
        S(4);
    }

    public void U() {
        S(2);
    }

    public final void V() {
        if (this.N) {
            this.N = false;
            t1();
        }
    }

    public void V0(i1.p pVar, Intent intent, int i10, Bundle bundle) {
        if (this.F == null) {
            this.f10221x.A(pVar, intent, i10, bundle);
            return;
        }
        this.I.addLast(new l(pVar.f10328f, i10));
        if (bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.F.a(intent);
    }

    public void W(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2 = str + "    ";
        this.f10200c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<i1.p> arrayList = this.f10202e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size; i10++) {
                i1.p pVar = this.f10202e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(pVar.toString());
            }
        }
        int size2 = this.f10201d.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size2; i11++) {
                i1.a aVar = this.f10201d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.r(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f10208k.get());
        synchronized (this.f10198a) {
            int size3 = this.f10198a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i12 = 0; i12 < size3; i12++) {
                    n nVar = this.f10198a.get(i12);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i12);
                    printWriter.print(": ");
                    printWriter.println(nVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f10221x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f10222y);
        if (this.f10223z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f10223z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f10220w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.K);
        printWriter.print(" mStopped=");
        printWriter.print(this.L);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.M);
        if (this.J) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.J);
        }
    }

    public void W0(int i10, boolean z10) {
        z<?> zVar;
        if (this.f10221x == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i10 != this.f10220w) {
            this.f10220w = i10;
            this.f10200c.t();
            t1();
            if (this.J && (zVar = this.f10221x) != null && this.f10220w == 7) {
                zVar.B();
                this.J = false;
            }
        }
    }

    public final void X() {
        Iterator<x0> it = t().iterator();
        while (it.hasNext()) {
            it.next().q();
        }
    }

    public void X0() {
        if (this.f10221x == null) {
            return;
        }
        this.K = false;
        this.L = false;
        this.R.o(false);
        for (i1.p pVar : this.f10200c.o()) {
            if (pVar != null) {
                pVar.i0();
            }
        }
    }

    public void Y(n nVar, boolean z10) {
        if (!z10) {
            if (this.f10221x == null) {
                if (!this.M) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            q();
        }
        synchronized (this.f10198a) {
            if (this.f10221x == null) {
                if (!z10) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f10198a.add(nVar);
                n1();
            }
        }
    }

    public void Y0(FragmentContainerView fragmentContainerView) {
        View view;
        for (n0 n0Var : this.f10200c.k()) {
            i1.p pVarK = n0Var.k();
            if (pVarK.E == fragmentContainerView.getId() && (view = pVarK.O) != null && view.getParent() == null) {
                pVarK.N = fragmentContainerView;
                n0Var.b();
            }
        }
    }

    public final void Z(boolean z10) {
        if (this.f10199b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f10221x == null) {
            if (!this.M) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f10221x.w().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10) {
            q();
        }
        if (this.O == null) {
            this.O = new ArrayList<>();
            this.P = new ArrayList<>();
        }
    }

    public void Z0(n0 n0Var) {
        i1.p pVarK = n0Var.k();
        if (pVarK.P) {
            if (this.f10199b) {
                this.N = true;
            } else {
                pVarK.P = false;
                n0Var.m();
            }
        }
    }

    public boolean a0(boolean z10) {
        Z(z10);
        boolean z11 = false;
        while (o0(this.O, this.P)) {
            z11 = true;
            this.f10199b = true;
            try {
                i1(this.O, this.P);
                r();
            } catch (Throwable th) {
                r();
                throw th;
            }
        }
        v1();
        V();
        this.f10200c.b();
        return z11;
    }

    public void a1(int i10, int i11, boolean z10) {
        if (i10 >= 0) {
            Y(new o(null, i10, i11), z10);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public void b0(n nVar, boolean z10) {
        if (z10 && (this.f10221x == null || this.M)) {
            return;
        }
        Z(z10);
        if (nVar.a(this.O, this.P)) {
            this.f10199b = true;
            try {
                i1(this.O, this.P);
                r();
            } catch (Throwable th) {
                r();
                throw th;
            }
        }
        v1();
        V();
        this.f10200c.b();
    }

    public boolean b1() {
        return d1(null, -1, 0);
    }

    public boolean c1(int i10, int i11) {
        if (i10 >= 0) {
            return d1(null, i10, i11);
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public final void d0(ArrayList<i1.a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        boolean z10 = arrayList.get(i10).f10393r;
        ArrayList<i1.p> arrayList3 = this.Q;
        if (arrayList3 == null) {
            this.Q = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.Q.addAll(this.f10200c.o());
        i1.p pVarZ0 = z0();
        boolean z11 = false;
        for (int i12 = i10; i12 < i11; i12++) {
            i1.a aVar = arrayList.get(i12);
            pVarZ0 = !arrayList2.get(i12).booleanValue() ? aVar.v(this.Q, pVarZ0) : aVar.y(this.Q, pVarZ0);
            z11 = z11 || aVar.f10384i;
        }
        this.Q.clear();
        if (!z10 && this.f10220w >= 1) {
            for (int i13 = i10; i13 < i11; i13++) {
                Iterator<p0.a> it = arrayList.get(i13).f10378c.iterator();
                while (it.hasNext()) {
                    i1.p pVar = it.next().f10396b;
                    if (pVar != null && pVar.f10346z != null) {
                        this.f10200c.r(v(pVar));
                    }
                }
            }
        }
        c0(arrayList, arrayList2, i10, i11);
        boolean zBooleanValue = arrayList2.get(i11 - 1).booleanValue();
        if (z11 && !this.f10212o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<i1.a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(n0(it2.next()));
            }
            if (this.f10205h == null) {
                for (m mVar : this.f10212o) {
                    Iterator it3 = linkedHashSet.iterator();
                    while (it3.hasNext()) {
                        mVar.b((i1.p) it3.next(), zBooleanValue);
                    }
                }
                for (m mVar2 : this.f10212o) {
                    Iterator it4 = linkedHashSet.iterator();
                    while (it4.hasNext()) {
                        mVar2.a((i1.p) it4.next(), zBooleanValue);
                    }
                }
            }
        }
        for (int i14 = i10; i14 < i11; i14++) {
            i1.a aVar2 = arrayList.get(i14);
            if (zBooleanValue) {
                for (int size = aVar2.f10378c.size() - 1; size >= 0; size--) {
                    i1.p pVar2 = aVar2.f10378c.get(size).f10396b;
                    if (pVar2 != null) {
                        v(pVar2).m();
                    }
                }
            } else {
                Iterator<p0.a> it5 = aVar2.f10378c.iterator();
                while (it5.hasNext()) {
                    i1.p pVar3 = it5.next().f10396b;
                    if (pVar3 != null) {
                        v(pVar3).m();
                    }
                }
            }
        }
        W0(this.f10220w, true);
        for (x0 x0Var : u(arrayList, i10, i11)) {
            x0Var.B(zBooleanValue);
            x0Var.x();
            x0Var.n();
        }
        while (i10 < i11) {
            i1.a aVar3 = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue() && aVar3.f10115v >= 0) {
                aVar3.f10115v = -1;
            }
            aVar3.x();
            i10++;
        }
        if (z11) {
            j1();
        }
    }

    public final boolean d1(String str, int i10, int i11) {
        a0(false);
        Z(true);
        i1.p pVar = this.A;
        if (pVar != null && i10 < 0 && str == null && pVar.s().b1()) {
            return true;
        }
        boolean zE1 = e1(this.O, this.P, str, i10, i11);
        if (zE1) {
            this.f10199b = true;
            try {
                i1(this.O, this.P);
                r();
            } catch (Throwable th) {
                r();
                throw th;
            }
        }
        v1();
        V();
        this.f10200c.b();
        return zE1;
    }

    public boolean e0() {
        boolean zA0 = a0(true);
        m0();
        return zA0;
    }

    public boolean e1(ArrayList<i1.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i10, int i11) {
        int iG0 = g0(str, i10, (i11 & 1) != 0);
        if (iG0 < 0) {
            return false;
        }
        for (int size = this.f10201d.size() - 1; size >= iG0; size--) {
            arrayList.add(this.f10201d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public i1.p f0(String str) {
        return this.f10200c.f(str);
    }

    public boolean f1(ArrayList<i1.a> arrayList, ArrayList<Boolean> arrayList2) {
        ArrayList<i1.a> arrayList3 = this.f10201d;
        i1.a aVar = arrayList3.get(arrayList3.size() - 1);
        this.f10205h = aVar;
        Iterator<p0.a> it = aVar.f10378c.iterator();
        while (it.hasNext()) {
            i1.p pVar = it.next().f10396b;
            if (pVar != null) {
                pVar.f10339s = true;
            }
        }
        return e1(arrayList, arrayList2, null, -1, 0);
    }

    public final int g0(String str, int i10, boolean z10) {
        if (this.f10201d.isEmpty()) {
            return -1;
        }
        if (str == null && i10 < 0) {
            if (z10) {
                return 0;
            }
            return this.f10201d.size() - 1;
        }
        int size = this.f10201d.size() - 1;
        while (size >= 0) {
            i1.a aVar = this.f10201d.get(size);
            if ((str != null && str.equals(aVar.w())) || (i10 >= 0 && i10 == aVar.f10115v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z10) {
            if (size == this.f10201d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            i1.a aVar2 = this.f10201d.get(size - 1);
            if ((str == null || !str.equals(aVar2.w())) && (i10 < 0 || i10 != aVar2.f10115v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    public void g1() {
        Y(new p(), false);
    }

    public void h(i1.a aVar) {
        this.f10201d.add(aVar);
    }

    public i1.p h0(int i10) {
        return this.f10200c.g(i10);
    }

    public void h1(i1.p pVar) {
        if (I0(2)) {
            Log.v("FragmentManager", "remove: " + pVar + " nesting=" + pVar.f10345y);
        }
        boolean z10 = !pVar.c0();
        if (!pVar.H || z10) {
            this.f10200c.u(pVar);
            if (J0(pVar)) {
                this.J = true;
            }
            pVar.f10338r = true;
            r1(pVar);
        }
    }

    public n0 i(i1.p pVar) {
        String str = pVar.X;
        if (str != null) {
            j1.c.f(pVar, str);
        }
        if (I0(2)) {
            Log.v("FragmentManager", "add: " + pVar);
        }
        n0 n0VarV = v(pVar);
        pVar.f10346z = this;
        this.f10200c.r(n0VarV);
        if (!pVar.H) {
            this.f10200c.a(pVar);
            pVar.f10338r = false;
            if (pVar.O == null) {
                pVar.U = false;
            }
            if (J0(pVar)) {
                this.J = true;
            }
        }
        return n0VarV;
    }

    public i1.p i0(String str) {
        return this.f10200c.h(str);
    }

    public final void i1(ArrayList<i1.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (!arrayList.get(i10).f10393r) {
                if (i11 != i10) {
                    d0(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (arrayList2.get(i10).booleanValue()) {
                    while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).f10393r) {
                        i11++;
                    }
                }
                d0(arrayList, arrayList2, i10, i11);
                i10 = i11 - 1;
            }
            i10++;
        }
        if (i11 != size) {
            d0(arrayList, arrayList2, i11, size);
        }
    }

    public void j(l0 l0Var) {
        this.f10214q.add(l0Var);
    }

    public i1.p j0(String str) {
        return this.f10200c.i(str);
    }

    public final void j1() {
        for (int i10 = 0; i10 < this.f10212o.size(); i10++) {
            this.f10212o.get(i10).onBackStackChanged();
        }
    }

    public int k() {
        return this.f10208k.getAndIncrement();
    }

    public void k1(Parcelable parcelable) {
        n0 n0Var;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f10221x.o().getClassLoader());
                this.f10210m.put(str.substring(7), bundle2);
            }
        }
        HashMap<String, Bundle> map = new HashMap<>();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f10221x.o().getClassLoader());
                map.put(str2.substring(9), bundle);
            }
        }
        this.f10200c.x(map);
        j0 j0Var = (j0) bundle3.getParcelable("state");
        if (j0Var == null) {
            return;
        }
        this.f10200c.v();
        Iterator<String> it = j0Var.f10246a.iterator();
        while (it.hasNext()) {
            Bundle bundleB = this.f10200c.B(it.next(), null);
            if (bundleB != null) {
                i1.p pVarH = this.R.h(((m0) bundleB.getParcelable("state")).f10269b);
                if (pVarH != null) {
                    if (I0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + pVarH);
                    }
                    n0Var = new n0(this.f10213p, this.f10200c, pVarH, bundleB);
                } else {
                    n0Var = new n0(this.f10213p, this.f10200c, this.f10221x.o().getClassLoader(), t0(), bundleB);
                }
                i1.p pVarK = n0Var.k();
                pVarK.f10320b = bundleB;
                pVarK.f10346z = this;
                if (I0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + pVarK.f10328f + "): " + pVarK);
                }
                n0Var.o(this.f10221x.o().getClassLoader());
                this.f10200c.r(n0Var);
                n0Var.s(this.f10220w);
            }
        }
        for (i1.p pVar : this.R.k()) {
            if (!this.f10200c.c(pVar.f10328f)) {
                if (I0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + pVar + " that was not found in the set of active Fragments " + j0Var.f10246a);
                }
                this.R.n(pVar);
                pVar.f10346z = this;
                n0 n0Var2 = new n0(this.f10213p, this.f10200c, pVar);
                n0Var2.s(1);
                n0Var2.m();
                pVar.f10338r = true;
                n0Var2.m();
            }
        }
        this.f10200c.w(j0Var.f10247b);
        if (j0Var.f10248c != null) {
            this.f10201d = new ArrayList<>(j0Var.f10248c.length);
            int i10 = 0;
            while (true) {
                i1.b[] bVarArr = j0Var.f10248c;
                if (i10 >= bVarArr.length) {
                    break;
                }
                i1.a aVarB = bVarArr[i10].b(this);
                if (I0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i10 + " (index " + aVarB.f10115v + "): " + aVarB);
                    PrintWriter printWriter = new PrintWriter(new u0("FragmentManager"));
                    aVarB.s("  ", printWriter, false);
                    printWriter.close();
                }
                this.f10201d.add(aVarB);
                i10++;
            }
        } else {
            this.f10201d = new ArrayList<>();
        }
        this.f10208k.set(j0Var.f10249d);
        String str3 = j0Var.f10250e;
        if (str3 != null) {
            i1.p pVarF0 = f0(str3);
            this.A = pVarF0;
            L(pVarF0);
        }
        ArrayList<String> arrayList = j0Var.f10251f;
        if (arrayList != null) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                this.f10209l.put(arrayList.get(i11), j0Var.f10252l.get(i11));
            }
        }
        this.I = new ArrayDeque<>(j0Var.f10253m);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021  */
    /* JADX WARN: Code duplicated, block: B:16:0x0028  */
    /* JADX WARN: Code duplicated, block: B:18:0x0033  */
    /* JADX WARN: Code duplicated, block: B:21:0x003b  */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:26:0x0053  */
    /* JADX WARN: Code duplicated, block: B:32:0x0088  */
    /* JADX WARN: Code duplicated, block: B:35:0x0091  */
    /* JADX WARN: Code duplicated, block: B:37:0x0099  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:42:0x0129  */
    /* JADX WARN: Code duplicated, block: B:45:0x0136  */
    /* JADX WARN: Code duplicated, block: B:48:0x0143  */
    /* JADX WARN: Code duplicated, block: B:51:0x0150  */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x0099, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    public void l(z<?> zVar, w wVar, i1.p pVar) {
        l0 gVar;
        k0 k0Var;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        String str;
        Bundle bundleB;
        androidx.lifecycle.k kVar;
        if (this.f10221x != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f10221x = zVar;
        this.f10222y = wVar;
        this.f10223z = pVar;
        if (pVar == null) {
            if (zVar instanceof l0) {
                gVar = (l0) zVar;
            }
            if (this.f10223z != null) {
                v1();
            }
            if (zVar instanceof d.r) {
                d.r rVar = (d.r) zVar;
                d.p pVarH = rVar.h();
                this.f10204g = pVarH;
                kVar = rVar;
                if (pVar != null) {
                    kVar = pVar;
                }
                pVarH.h(kVar, this.f10207j);
            }
            if (pVar != null) {
                k0Var = pVar.f10346z.q0(pVar);
            } else if (zVar instanceof androidx.lifecycle.j0) {
                k0Var = k0.j(((androidx.lifecycle.j0) zVar).m());
            } else {
                k0Var = new k0(false);
            }
            this.R = k0Var;
            this.R.o(P0());
            this.f10200c.A(this.R);
            obj = this.f10221x;
            if ((obj instanceof b2.f) && pVar == null) {
                b2.d dVarV = ((b2.f) obj).v();
                dVarV.h("android:support:fragments", new b2.d.c() { // from class: i1.g0
                    @Override // b2.d.c
                    public final Bundle a() {
                        return this.f10196a.Q0();
                    }
                });
                bundleB = dVarV.b("android:support:fragments");
                if (bundleB != null) {
                    k1(bundleB);
                }
            }
            obj2 = this.f10221x;
            if (obj2 instanceof f.e) {
                f.d dVarK = ((f.e) obj2).k();
                if (pVar != null) {
                    str = pVar.f10328f + ":";
                } else {
                    str = "";
                }
                String str2 = "FragmentManager:" + str;
                this.F = dVarK.i(str2 + "StartActivityForResult", new g.c(), new h());
                this.G = dVarK.i(str2 + "StartIntentSenderForResult", new j(), new i());
                this.H = dVarK.i(str2 + "RequestPermissions", new g.b(), new a());
            }
            obj3 = this.f10221x;
            if (obj3 instanceof f0.f) {
                ((f0.f) obj3).d(this.f10215r);
            }
            obj4 = this.f10221x;
            if (obj4 instanceof f0.g) {
                ((f0.g) obj4).s(this.f10216s);
            }
            obj5 = this.f10221x;
            if (obj5 instanceof e0.p0) {
                ((e0.p0) obj5).e(this.f10217t);
            }
            obj6 = this.f10221x;
            if (obj6 instanceof e0.q0) {
                ((e0.q0) obj6).u(this.f10218u);
            }
            obj7 = this.f10221x;
            if ((obj7 instanceof p0.v) || pVar != null) {
            }
            ((p0.v) obj7).r(this.f10219v);
            return;
        }
        gVar = new g(pVar);
        j(gVar);
        if (this.f10223z != null) {
            v1();
        }
        if (zVar instanceof d.r) {
            d.r rVar2 = (d.r) zVar;
            d.p pVarH2 = rVar2.h();
            this.f10204g = pVarH2;
            kVar = rVar2;
            if (pVar != null) {
                kVar = pVar;
            }
            pVarH2.h(kVar, this.f10207j);
        }
        if (pVar != null) {
            k0Var = pVar.f10346z.q0(pVar);
        } else if (zVar instanceof androidx.lifecycle.j0) {
            k0Var = k0.j(((androidx.lifecycle.j0) zVar).m());
        } else {
            k0Var = new k0(false);
        }
        this.R = k0Var;
        this.R.o(P0());
        this.f10200c.A(this.R);
        obj = this.f10221x;
        if (obj instanceof b2.f) {
            b2.d dVarV2 = ((b2.f) obj).v();
            dVarV2.h("android:support:fragments", new b2.d.c() { // from class: i1.g0
                @Override // b2.d.c
                public final Bundle a() {
                    return this.f10196a.Q0();
                }
            });
            bundleB = dVarV2.b("android:support:fragments");
            if (bundleB != null) {
                k1(bundleB);
            }
        }
        obj2 = this.f10221x;
        if (obj2 instanceof f.e) {
            f.d dVarK2 = ((f.e) obj2).k();
            if (pVar != null) {
                str = pVar.f10328f + ":";
            } else {
                str = "";
            }
            String str3 = "FragmentManager:" + str;
            this.F = dVarK2.i(str3 + "StartActivityForResult", new g.c(), new h());
            this.G = dVarK2.i(str3 + "StartIntentSenderForResult", new j(), new i());
            this.H = dVarK2.i(str3 + "RequestPermissions", new g.b(), new a());
        }
        obj3 = this.f10221x;
        if (obj3 instanceof f0.f) {
            ((f0.f) obj3).d(this.f10215r);
        }
        obj4 = this.f10221x;
        if (obj4 instanceof f0.g) {
            ((f0.g) obj4).s(this.f10216s);
        }
        obj5 = this.f10221x;
        if (obj5 instanceof e0.p0) {
            ((e0.p0) obj5).e(this.f10217t);
        }
        obj6 = this.f10221x;
        if (obj6 instanceof e0.q0) {
            ((e0.q0) obj6).u(this.f10218u);
        }
        obj7 = this.f10221x;
        if (obj7 instanceof p0.v) {
        }
    }

    public void m(i1.p pVar) {
        if (I0(2)) {
            Log.v("FragmentManager", "attach: " + pVar);
        }
        if (pVar.H) {
            pVar.H = false;
            if (pVar.f10337q) {
                return;
            }
            this.f10200c.a(pVar);
            if (I0(2)) {
                Log.v("FragmentManager", "add from attach: " + pVar);
            }
            if (J0(pVar)) {
                this.J = true;
            }
        }
    }

    public final void m0() {
        Iterator<x0> it = t().iterator();
        while (it.hasNext()) {
            it.next().r();
        }
    }

    /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
    public Bundle Q0() {
        i1.b[] bVarArr;
        Bundle bundle = new Bundle();
        m0();
        X();
        a0(true);
        this.K = true;
        this.R.o(true);
        ArrayList<String> arrayListY = this.f10200c.y();
        HashMap<String, Bundle> mapM = this.f10200c.m();
        if (!mapM.isEmpty()) {
            ArrayList<String> arrayListZ = this.f10200c.z();
            int size = this.f10201d.size();
            if (size > 0) {
                bVarArr = new i1.b[size];
                for (int i10 = 0; i10 < size; i10++) {
                    bVarArr[i10] = new i1.b(this.f10201d.get(i10));
                    if (I0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i10 + ": " + this.f10201d.get(i10));
                    }
                }
            } else {
                bVarArr = null;
            }
            j0 j0Var = new j0();
            j0Var.f10246a = arrayListY;
            j0Var.f10247b = arrayListZ;
            j0Var.f10248c = bVarArr;
            j0Var.f10249d = this.f10208k.get();
            i1.p pVar = this.A;
            if (pVar != null) {
                j0Var.f10250e = pVar.f10328f;
            }
            j0Var.f10251f.addAll(this.f10209l.keySet());
            j0Var.f10252l.addAll(this.f10209l.values());
            j0Var.f10253m = new ArrayList<>(this.I);
            bundle.putParcelable("state", j0Var);
            for (String str : this.f10210m.keySet()) {
                bundle.putBundle("result_" + str, this.f10210m.get(str));
            }
            for (String str2 : mapM.keySet()) {
                bundle.putBundle("fragment_" + str2, mapM.get(str2));
            }
        } else if (I0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    public p0 n() {
        return new i1.a(this);
    }

    public Set<i1.p> n0(i1.a aVar) {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < aVar.f10378c.size(); i10++) {
            i1.p pVar = aVar.f10378c.get(i10).f10396b;
            if (pVar != null && aVar.f10384i) {
                hashSet.add(pVar);
            }
        }
        return hashSet;
    }

    public void n1() {
        synchronized (this.f10198a) {
            boolean z10 = true;
            if (this.f10198a.size() != 1) {
                z10 = false;
            }
            if (z10) {
                this.f10221x.w().removeCallbacks(this.T);
                this.f10221x.w().post(this.T);
                v1();
            }
        }
    }

    public void o() {
        i1.a aVar = this.f10205h;
        if (aVar != null) {
            aVar.f10114u = false;
            aVar.f();
            e0();
            Iterator<m> it = this.f10212o.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
    }

    public final boolean o0(ArrayList<i1.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f10198a) {
            if (this.f10198a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f10198a.size();
                boolean zA = false;
                for (int i10 = 0; i10 < size; i10++) {
                    zA |= this.f10198a.get(i10).a(arrayList, arrayList2);
                }
                this.f10198a.clear();
                this.f10221x.w().removeCallbacks(this.T);
                return zA;
            } catch (Throwable th) {
                this.f10198a.clear();
                this.f10221x.w().removeCallbacks(this.T);
                throw th;
            }
        }
    }

    public void o1(i1.p pVar, boolean z10) {
        ViewGroup viewGroupS0 = s0(pVar);
        if (viewGroupS0 == null || !(viewGroupS0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupS0).setDrawDisappearingViewsLast(!z10);
    }

    public boolean p() {
        boolean zJ0 = false;
        for (i1.p pVar : this.f10200c.l()) {
            if (pVar != null) {
                zJ0 = J0(pVar);
            }
            if (zJ0) {
                return true;
            }
        }
        return false;
    }

    public int p0() {
        return this.f10201d.size() + (this.f10205h != null ? 1 : 0);
    }

    public void p1(i1.p pVar, androidx.lifecycle.g.b bVar) {
        if (pVar.equals(f0(pVar.f10328f)) && (pVar.A == null || pVar.f10346z == this)) {
            pVar.Y = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + pVar + " is not an active fragment of FragmentManager " + this);
    }

    public final void q() {
        if (P0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final k0 q0(i1.p pVar) {
        return this.R.i(pVar);
    }

    public void q1(i1.p pVar) {
        if (pVar == null || (pVar.equals(f0(pVar.f10328f)) && (pVar.A == null || pVar.f10346z == this))) {
            i1.p pVar2 = this.A;
            this.A = pVar;
            L(pVar2);
            L(this.A);
            return;
        }
        throw new IllegalArgumentException("Fragment " + pVar + " is not an active fragment of FragmentManager " + this);
    }

    public final void r() {
        this.f10199b = false;
        this.P.clear();
        this.O.clear();
    }

    public w r0() {
        return this.f10222y;
    }

    public final void r1(i1.p pVar) {
        ViewGroup viewGroupS0 = s0(pVar);
        if (viewGroupS0 == null || pVar.u() + pVar.y() + pVar.J() + pVar.K() <= 0) {
            return;
        }
        int i10 = h1.b.f9584c;
        if (viewGroupS0.getTag(i10) == null) {
            viewGroupS0.setTag(i10, pVar);
        }
        ((i1.p) viewGroupS0.getTag(i10)).z1(pVar.I());
    }

    public final void s() {
        boolean zM;
        z<?> zVar = this.f10221x;
        if (zVar instanceof androidx.lifecycle.j0) {
            zM = this.f10200c.p().m();
        } else {
            zM = zVar.o() instanceof Activity ? !((Activity) this.f10221x.o()).isChangingConfigurations() : true;
        }
        if (zM) {
            Iterator<i1.c> it = this.f10209l.values().iterator();
            while (it.hasNext()) {
                Iterator<String> it2 = it.next().f10137a.iterator();
                while (it2.hasNext()) {
                    this.f10200c.p().f(it2.next(), false);
                }
            }
        }
    }

    public final ViewGroup s0(i1.p pVar) {
        ViewGroup viewGroup = pVar.N;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (pVar.E > 0 && this.f10222y.l()) {
            View viewJ = this.f10222y.j(pVar.E);
            if (viewJ instanceof ViewGroup) {
                return (ViewGroup) viewJ;
            }
        }
        return null;
    }

    public void s1(i1.p pVar) {
        if (I0(2)) {
            Log.v("FragmentManager", "show: " + pVar);
        }
        if (pVar.G) {
            pVar.G = false;
            pVar.U = !pVar.U;
        }
    }

    public final Set<x0> t() {
        HashSet hashSet = new HashSet();
        Iterator<n0> it = this.f10200c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().N;
            if (viewGroup != null) {
                hashSet.add(x0.v(viewGroup, A0()));
            }
        }
        return hashSet;
    }

    public y t0() {
        y yVar = this.B;
        if (yVar != null) {
            return yVar;
        }
        i1.p pVar = this.f10223z;
        return pVar != null ? pVar.f10346z.t0() : this.C;
    }

    public final void t1() {
        Iterator<n0> it = this.f10200c.k().iterator();
        while (it.hasNext()) {
            Z0(it.next());
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        i1.p pVar = this.f10223z;
        if (pVar == null) {
            z<?> zVar = this.f10221x;
            if (zVar != null) {
                sb2.append(zVar.getClass().getSimpleName());
                sb2.append("{");
                obj = this.f10221x;
            } else {
                sb2.append("null");
            }
            sb2.append("}}");
            return sb2.toString();
        }
        sb2.append(pVar.getClass().getSimpleName());
        sb2.append("{");
        obj = this.f10223z;
        sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        sb2.append("}");
        sb2.append("}}");
        return sb2.toString();
    }

    public Set<x0> u(ArrayList<i1.a> arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator<p0.a> it = arrayList.get(i10).f10378c.iterator();
            while (it.hasNext()) {
                i1.p pVar = it.next().f10396b;
                if (pVar != null && (viewGroup = pVar.N) != null) {
                    hashSet.add(x0.u(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    public List<i1.p> u0() {
        return this.f10200c.o();
    }

    public final void u1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new u0("FragmentManager"));
        z<?> zVar = this.f10221x;
        try {
            if (zVar != null) {
                zVar.x("  ", null, printWriter, new String[0]);
            } else {
                W("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e10) {
            Log.e("FragmentManager", "Failed dumping state", e10);
            throw runtimeException;
        }
    }

    public n0 v(i1.p pVar) {
        n0 n0VarN = this.f10200c.n(pVar.f10328f);
        if (n0VarN != null) {
            return n0VarN;
        }
        n0 n0Var = new n0(this.f10213p, this.f10200c, pVar);
        n0Var.o(this.f10221x.o().getClassLoader());
        n0Var.s(this.f10220w);
        return n0Var;
    }

    public z<?> v0() {
        return this.f10221x;
    }

    public final void v1() {
        synchronized (this.f10198a) {
            if (!this.f10198a.isEmpty()) {
                this.f10207j.j(true);
                if (I0(3)) {
                    Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                }
                return;
            }
            boolean z10 = p0() > 0 && N0(this.f10223z);
            if (I0(3)) {
                Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z10);
            }
            this.f10207j.j(z10);
        }
    }

    public void w(i1.p pVar) {
        if (I0(2)) {
            Log.v("FragmentManager", "detach: " + pVar);
        }
        if (pVar.H) {
            return;
        }
        pVar.H = true;
        if (pVar.f10337q) {
            if (I0(2)) {
                Log.v("FragmentManager", "remove from detach: " + pVar);
            }
            this.f10200c.u(pVar);
            if (J0(pVar)) {
                this.J = true;
            }
            r1(pVar);
        }
    }

    public LayoutInflater.Factory2 w0() {
        return this.f10203f;
    }

    public void x() {
        this.K = false;
        this.L = false;
        this.R.o(false);
        S(4);
    }

    public b0 x0() {
        return this.f10213p;
    }

    public void y() {
        this.K = false;
        this.L = false;
        this.R.o(false);
        S(0);
    }

    public i1.p y0() {
        return this.f10223z;
    }

    public void z(Configuration configuration, boolean z10) {
        if (z10 && (this.f10221x instanceof f0.f)) {
            u1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (i1.p pVar : this.f10200c.o()) {
            if (pVar != null) {
                pVar.S0(configuration);
                if (z10) {
                    pVar.B.z(configuration, true);
                }
            }
        }
    }

    public i1.p z0() {
        return this.A;
    }
}
