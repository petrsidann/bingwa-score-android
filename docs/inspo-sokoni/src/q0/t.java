package q0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14608a;

    public static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f14609a;

        public a(t tVar) {
            this.f14609a = tVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            p pVarB = this.f14609a.b(i10);
            if (pVarB == null) {
                return null;
            }
            return pVarB.C0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            List<p> listC = this.f14609a.c(str, i10);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(listC.get(i11).C0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f14609a.f(i10, i11, bundle);
        }
    }

    public static class b extends a {
        public b(t tVar) {
            super(tVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i10) {
            p pVarD = this.f14609a.d(i10);
            if (pVarD == null) {
                return null;
            }
            return pVarD.C0();
        }
    }

    public static class c extends b {
        public c(t tVar) {
            super(tVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f14609a.a(i10, p.D0(accessibilityNodeInfo), str, bundle);
        }
    }

    public t() {
        this.f14608a = new c(this);
    }

    public t(Object obj) {
        this.f14608a = obj;
    }

    public void a(int i10, p pVar, String str, Bundle bundle) {
    }

    public p b(int i10) {
        return null;
    }

    public List<p> c(String str, int i10) {
        return null;
    }

    public p d(int i10) {
        return null;
    }

    public Object e() {
        return this.f14608a;
    }

    public boolean f(int i10, int i11, Bundle bundle) {
        return false;
    }
}
