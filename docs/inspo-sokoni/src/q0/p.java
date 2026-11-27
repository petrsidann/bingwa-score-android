package q0;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f14577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14578b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14579c = -1;

    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;
        public static final a R;
        public static final a S;
        public static final a T;
        public static final a U;
        public static final a V;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f14580e = new a(1, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f14581f = new a(2, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f14582g = new a(4, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f14583h = new a(8, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f14584i = new a(16, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f14585j = new a(32, null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f14586k = new a(64, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f14587l = new a(128, null);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f14588m = new a(256, (CharSequence) null, (Class<? extends v.a>) v.b.class);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f14589n = new a(512, (CharSequence) null, (Class<? extends v.a>) v.b.class);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f14590o = new a(1024, (CharSequence) null, (Class<? extends v.a>) v.c.class);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f14591p = new a(2048, (CharSequence) null, (Class<? extends v.a>) v.c.class);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f14592q = new a(4096, null);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f14593r = new a(8192, null);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f14594s = new a(16384, null);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f14595t = new a(32768, null);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f14596u = new a(65536, null);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f14597v = new a(131072, (CharSequence) null, (Class<? extends v.a>) v.g.class);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f14598w = new a(262144, null);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f14599x = new a(524288, null);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f14600y = new a(1048576, null);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final a f14601z = new a(2097152, (CharSequence) null, (Class<? extends v.a>) v.h.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f14602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<? extends v.a> f14604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final v f14605d;

        static {
            int i10 = Build.VERSION.SDK_INT;
            A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, v.e.class);
            C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            G = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            H = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            I = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            J = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, v.f.class);
            M = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, v.d.class);
            N = new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            O = new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            P = new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            Q = new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            R = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            S = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            T = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            U = new a(i10 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            V = new a(i10 >= 34 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i10, CharSequence charSequence) {
            this(null, i10, charSequence, null, null);
        }

        public a(int i10, CharSequence charSequence, Class<? extends v.a> cls) {
            this(null, i10, charSequence, null, cls);
        }

        public a(int i10, CharSequence charSequence, v vVar) {
            this(null, i10, charSequence, vVar, null);
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(Object obj, int i10, CharSequence charSequence, v vVar, Class<? extends v.a> cls) {
            this.f14603b = i10;
            this.f14605d = vVar;
            this.f14602a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence) : obj;
            this.f14604c = cls;
        }

        public a a(CharSequence charSequence, v vVar) {
            return new a(null, this.f14603b, charSequence, vVar, this.f14604c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f14602a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f14602a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            if (this.f14605d == null) {
                return false;
            }
            Class<? extends v.a> cls = this.f14604c;
            v.a aVar = null;
            if (cls != null) {
                try {
                    v.a aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        aVarNewInstance.a(bundle);
                        aVar = aVarNewInstance;
                    } catch (Exception e10) {
                        e = e10;
                        aVar = aVarNewInstance;
                        Class<? extends v.a> cls2 = this.f14604c;
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            }
            return this.f14605d.a(view, aVar);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            Object obj2 = this.f14602a;
            Object obj3 = ((a) obj).f14602a;
            if (obj2 == null) {
                return obj3 == null;
            }
            return obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f14602a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AccessibilityActionCompat: ");
            String strG = p.g(this.f14603b);
            if (strG.equals("ACTION_UNKNOWN") && c() != null) {
                strG = c().toString();
            }
            sb2.append(strG);
            return sb2.toString();
        }
    }

    public static class b {
        public static g a(int i10, int i11, int i12, int i13, boolean z10) {
            return new g(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10));
        }

        public static Object b(int i10, float f10, float f11, float f12) {
            return AccessibilityNodeInfo.RangeInfo.obtain(i10, f10, f11, f12);
        }

        public static Bundle c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtras();
        }
    }

    public static class c {
        public static Object a(int i10, float f10, float f11, float f12) {
            return new AccessibilityNodeInfo.RangeInfo(i10, f10, f11, f12);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    public static class d {
        public static g a(boolean z10, int i10, int i11, int i12, int i13, boolean z11, String str, String str2) {
            return new g(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z10).setColumnIndex(i10).setRowIndex(i11).setColumnSpan(i12).setRowSpan(i13).setSelected(z11).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static p b(AccessibilityNodeInfo accessibilityNodeInfo, int i10, int i11) {
            return p.E0(accessibilityNodeInfo.getChild(i10, i11));
        }

        public static String c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static p f(AccessibilityNodeInfo accessibilityNodeInfo, int i10) {
            return p.E0(accessibilityNodeInfo.getParent(i10));
        }

        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z10) {
            accessibilityNodeInfo.setTextSelectable(z10);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    public static class e {
        public static void a(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void f(AccessibilityNodeInfo accessibilityNodeInfo, boolean z10) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z10);
        }

        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, long j10) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j10));
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z10) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z10);
        }

        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, boolean z10) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z10);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f14606a;

        public f(Object obj) {
            this.f14606a = obj;
        }

        public static f a(int i10, int i11, boolean z10, int i12) {
            return new f(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12));
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f14607a;

        public g(Object obj) {
            this.f14607a = obj;
        }

        public static g a(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            return new g(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11));
        }
    }

    public p(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f14577a = accessibilityNodeInfo;
    }

    @Deprecated
    public p(Object obj) {
        this.f14577a = (AccessibilityNodeInfo) obj;
    }

    public static p D0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new p(accessibilityNodeInfo);
    }

    public static p E0(Object obj) {
        if (obj != null) {
            return new p(obj);
        }
        return null;
    }

    public static p S() {
        return D0(AccessibilityNodeInfo.obtain());
    }

    public static p T(View view) {
        return D0(AccessibilityNodeInfo.obtain(view));
    }

    public static p U(p pVar) {
        return D0(AccessibilityNodeInfo.obtain(pVar.f14577a));
    }

    public static String g(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i10) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i10) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i10) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static ClickableSpan[] o(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public final boolean A() {
        return !e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public void A0(View view) {
        this.f14577a.setTraversalAfter(view);
    }

    public boolean B() {
        return Build.VERSION.SDK_INT >= 34 ? e.e(this.f14577a) : i(64);
    }

    public void B0(boolean z10) {
        this.f14577a.setVisibleToUser(z10);
    }

    public boolean C() {
        return this.f14577a.isCheckable();
    }

    public AccessibilityNodeInfo C0() {
        return this.f14577a;
    }

    public boolean D() {
        return this.f14577a.isChecked();
    }

    public boolean E() {
        return this.f14577a.isClickable();
    }

    public boolean F() {
        return this.f14577a.isContextClickable();
    }

    public boolean G() {
        return this.f14577a.isEnabled();
    }

    public boolean H() {
        return this.f14577a.isFocusable();
    }

    public boolean I() {
        return this.f14577a.isFocused();
    }

    public boolean J() {
        return i(67108864);
    }

    public boolean K() {
        return this.f14577a.isImportantForAccessibility();
    }

    public boolean L() {
        return this.f14577a.isLongClickable();
    }

    public boolean M() {
        return this.f14577a.isPassword();
    }

    public boolean N() {
        return this.f14577a.isScrollable();
    }

    public boolean O() {
        return this.f14577a.isSelected();
    }

    public boolean P() {
        return this.f14577a.isShowingHintText();
    }

    public boolean Q() {
        return Build.VERSION.SDK_INT >= 33 ? d.h(this.f14577a) : i(8388608);
    }

    public boolean R() {
        return this.f14577a.isVisibleToUser();
    }

    public boolean V(int i10, Bundle bundle) {
        return this.f14577a.performAction(i10, bundle);
    }

    @Deprecated
    public void W() {
    }

    public void X(boolean z10) {
        this.f14577a.setAccessibilityFocused(z10);
    }

    public final void Y(int i10, boolean z10) {
        Bundle bundleS = s();
        if (bundleS != null) {
            int i11 = bundleS.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i10);
            if (!z10) {
                i10 = 0;
            }
            bundleS.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i10 | i11);
        }
    }

    @Deprecated
    public void Z(Rect rect) {
        this.f14577a.setBoundsInParent(rect);
    }

    public void a(int i10) {
        this.f14577a.addAction(i10);
    }

    public void a0(Rect rect) {
        this.f14577a.setBoundsInScreen(rect);
    }

    public void b(a aVar) {
        this.f14577a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f14602a);
    }

    public void b0(boolean z10) {
        this.f14577a.setCheckable(z10);
    }

    public void c(View view, int i10) {
        this.f14577a.addChild(view, i10);
    }

    public void c0(boolean z10) {
        this.f14577a.setChecked(z10);
    }

    public void d(CharSequence charSequence, View view) {
    }

    public void d0(CharSequence charSequence) {
        this.f14577a.setClassName(charSequence);
    }

    public final List<Integer> e(String str) {
        ArrayList<Integer> integerArrayList = b.c(this.f14577a).getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        b.c(this.f14577a).putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void e0(boolean z10) {
        this.f14577a.setClickable(z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f14577a;
        if (accessibilityNodeInfo == null) {
            if (pVar.f14577a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(pVar.f14577a)) {
            return false;
        }
        return this.f14579c == pVar.f14579c && this.f14578b == pVar.f14578b;
    }

    public List<a> f() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f14577a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10)));
        }
        return arrayList;
    }

    public void f0(Object obj) {
        this.f14577a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((f) obj).f14606a);
    }

    public void g0(Object obj) {
        this.f14577a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((g) obj).f14607a);
    }

    @Deprecated
    public int h() {
        return this.f14577a.getActions();
    }

    public void h0(CharSequence charSequence) {
        this.f14577a.setContentDescription(charSequence);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f14577a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final boolean i(int i10) {
        Bundle bundleS = s();
        return bundleS != null && (bundleS.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i10) == i10;
    }

    public void i0(boolean z10) {
        this.f14577a.setEnabled(z10);
    }

    @Deprecated
    public void j(Rect rect) {
        this.f14577a.getBoundsInParent(rect);
    }

    public void j0(CharSequence charSequence) {
        this.f14577a.setError(charSequence);
    }

    public void k(Rect rect) {
        this.f14577a.getBoundsInScreen(rect);
    }

    public void k0(boolean z10) {
        this.f14577a.setFocusable(z10);
    }

    public void l(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            e.a(this.f14577a, rect);
            return;
        }
        Rect rect2 = (Rect) b.c(this.f14577a).getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void l0(boolean z10) {
        this.f14577a.setFocused(z10);
    }

    public int m() {
        return this.f14577a.getChildCount();
    }

    public void m0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f14577a.setHeading(z10);
        } else {
            Y(2, z10);
        }
    }

    public CharSequence n() {
        return this.f14577a.getClassName();
    }

    public void n0(CharSequence charSequence) {
        this.f14577a.setHintText(charSequence);
    }

    public void o0(View view) {
        this.f14577a.setLabelFor(view);
    }

    public CharSequence p() {
        return Build.VERSION.SDK_INT >= 34 ? e.b(this.f14577a) : b.c(this.f14577a).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void p0(int i10) {
        this.f14577a.setMaxTextLength(i10);
    }

    public CharSequence q() {
        return this.f14577a.getContentDescription();
    }

    public void q0(CharSequence charSequence) {
        this.f14577a.setPackageName(charSequence);
    }

    public CharSequence r() {
        return this.f14577a.getError();
    }

    public void r0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f14577a.setPaneTitle(charSequence);
        } else {
            b.c(this.f14577a).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public Bundle s() {
        return b.c(this.f14577a);
    }

    public void s0(View view) {
        this.f14578b = -1;
        this.f14577a.setParent(view);
    }

    public int t() {
        return this.f14577a.getMaxTextLength();
    }

    public void t0(View view, int i10) {
        this.f14578b = i10;
        this.f14577a.setParent(view, i10);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        j(rect);
        sb2.append("; boundsInParent: " + rect);
        k(rect);
        sb2.append("; boundsInScreen: " + rect);
        l(rect);
        sb2.append("; boundsInWindow: " + rect);
        sb2.append("; packageName: ");
        sb2.append(u());
        sb2.append("; className: ");
        sb2.append(n());
        sb2.append("; text: ");
        sb2.append(w());
        sb2.append("; error: ");
        sb2.append(r());
        sb2.append("; maxTextLength: ");
        sb2.append(t());
        sb2.append("; stateDescription: ");
        sb2.append(v());
        sb2.append("; contentDescription: ");
        sb2.append(q());
        sb2.append("; tooltipText: ");
        sb2.append(x());
        sb2.append("; viewIdResName: ");
        sb2.append(z());
        sb2.append("; uniqueId: ");
        sb2.append(y());
        sb2.append("; checkable: ");
        sb2.append(C());
        sb2.append("; checked: ");
        sb2.append(D());
        sb2.append("; focusable: ");
        sb2.append(H());
        sb2.append("; focused: ");
        sb2.append(I());
        sb2.append("; selected: ");
        sb2.append(O());
        sb2.append("; clickable: ");
        sb2.append(E());
        sb2.append("; longClickable: ");
        sb2.append(L());
        sb2.append("; contextClickable: ");
        sb2.append(F());
        sb2.append("; enabled: ");
        sb2.append(G());
        sb2.append("; password: ");
        sb2.append(M());
        sb2.append("; scrollable: " + N());
        sb2.append("; containerTitle: ");
        sb2.append(p());
        sb2.append("; granularScrollingSupported: ");
        sb2.append(J());
        sb2.append("; importantForAccessibility: ");
        sb2.append(K());
        sb2.append("; visible: ");
        sb2.append(R());
        sb2.append("; isTextSelectable: ");
        sb2.append(Q());
        sb2.append("; accessibilityDataSensitive: ");
        sb2.append(B());
        sb2.append("; [");
        List<a> listF = f();
        for (int i10 = 0; i10 < listF.size(); i10++) {
            a aVar = listF.get(i10);
            String strG = g(aVar.b());
            if (strG.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                strG = aVar.c().toString();
            }
            sb2.append(strG);
            if (i10 != listF.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public CharSequence u() {
        return this.f14577a.getPackageName();
    }

    public void u0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f14577a.setScreenReaderFocusable(z10);
        } else {
            Y(1, z10);
        }
    }

    public CharSequence v() {
        return Build.VERSION.SDK_INT >= 30 ? c.b(this.f14577a) : b.c(this.f14577a).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public void v0(boolean z10) {
        this.f14577a.setScrollable(z10);
    }

    public CharSequence w() {
        if (!A()) {
            return this.f14577a.getText();
        }
        List<Integer> listE = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> listE2 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> listE3 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> listE4 = e("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f14577a.getText(), 0, this.f14577a.getText().length()));
        for (int i10 = 0; i10 < listE.size(); i10++) {
            spannableString.setSpan(new q0.a(listE4.get(i10).intValue(), this, s().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), listE.get(i10).intValue(), listE2.get(i10).intValue(), listE3.get(i10).intValue());
        }
        return spannableString;
    }

    public void w0(boolean z10) {
        this.f14577a.setShowingHintText(z10);
    }

    public CharSequence x() {
        return Build.VERSION.SDK_INT >= 28 ? this.f14577a.getTooltipText() : b.c(this.f14577a).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public void x0(View view, int i10) {
        this.f14579c = i10;
        this.f14577a.setSource(view, i10);
    }

    public String y() {
        return Build.VERSION.SDK_INT >= 33 ? d.g(this.f14577a) : b.c(this.f14577a).getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void y0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            c.c(this.f14577a, charSequence);
        } else {
            b.c(this.f14577a).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public String z() {
        return this.f14577a.getViewIdResourceName();
    }

    public void z0(CharSequence charSequence) {
        this.f14577a.setText(charSequence);
    }
}
