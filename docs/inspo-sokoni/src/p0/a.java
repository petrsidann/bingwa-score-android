package p0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f13922c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f13923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.AccessibilityDelegate f13924b;

    /* JADX INFO: renamed from: p0.a$a, reason: collision with other inner class name */
    public static final class C0240a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f13925a;

        public C0240a(a aVar) {
            this.f13925a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f13925a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            q0.t tVarB = this.f13925a.b(view);
            if (tVarB != null) {
                return (AccessibilityNodeProvider) tVarB.e();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f13925a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            q0.p pVarD0 = q0.p.D0(accessibilityNodeInfo);
            pVarD0.u0(p0.W(view));
            pVarD0.m0(p0.R(view));
            pVarD0.r0(p0.p(view));
            pVarD0.y0(p0.I(view));
            this.f13925a.g(view, pVarD0);
            pVarD0.d(accessibilityNodeInfo.getText(), view);
            List<q0.p.a> listC = a.c(view);
            for (int i10 = 0; i10 < listC.size(); i10++) {
                pVarD0.b(listC.get(i10));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f13925a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f13925a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            return this.f13925a.j(view, i10, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i10) {
            this.f13925a.l(view, i10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f13925a.m(view, accessibilityEvent);
        }
    }

    public static class b {
        public static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        public static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i10, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i10, bundle);
        }
    }

    public a() {
        this(f13922c);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f13923a = accessibilityDelegate;
        this.f13924b = new C0240a(this);
    }

    public static List<q0.p.a> c(View view) {
        List<q0.p.a> list = (List) view.getTag(d0.e.H);
        return list == null ? Collections.emptyList() : list;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f13923a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public q0.t b(View view) {
        AccessibilityNodeProvider accessibilityNodeProviderA = b.a(this.f13923a, view);
        if (accessibilityNodeProviderA != null) {
            return new q0.t(accessibilityNodeProviderA);
        }
        return null;
    }

    public View.AccessibilityDelegate d() {
        return this.f13924b;
    }

    public final boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrO = q0.p.o(view.createAccessibilityNodeInfo().getText());
            for (int i10 = 0; clickableSpanArrO != null && i10 < clickableSpanArrO.length; i10++) {
                if (clickableSpan.equals(clickableSpanArrO[i10])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f13923a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, q0.p pVar) {
        this.f13923a.onInitializeAccessibilityNodeInfo(view, pVar.C0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f13923a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f13923a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i10, Bundle bundle) {
        List<q0.p.a> listC = c(view);
        boolean zB = false;
        for (int i11 = 0; i11 < listC.size(); i11++) {
            q0.p.a aVar = listC.get(i11);
            if (aVar.b() == i10) {
                zB = aVar.d(view, bundle);
                break;
            }
        }
        if (!zB) {
            zB = b.b(this.f13923a, view, i10, bundle);
        }
        return (zB || i10 != d0.e.f6204a || bundle == null) ? zB : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public final boolean k(int i10, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(d0.e.I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i10)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public void l(View view, int i10) {
        this.f13923a.sendAccessibilityEvent(view, i10);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f13923a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
