package p2;

import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import j2.h;
import j2.j;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import mc.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0247a f14110b = new C0247a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14111c = a.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f14112a;

    /* JADX INFO: renamed from: p2.a$a, reason: collision with other inner class name */
    public static final class C0247a {
        public C0247a() {
        }

        public /* synthetic */ C0247a(g gVar) {
            this();
        }

        public final int a(SidecarDeviceState sidecarDeviceState) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            try {
                return sidecarDeviceState.posture;
            } catch (NoSuchFieldError unused) {
                try {
                    Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                    k.c(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) objInvoke).intValue();
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                    return 0;
                }
            }
        }

        public final int b(SidecarDeviceState sidecarDeviceState) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            int iA = a(sidecarDeviceState);
            if (iA < 0 || iA > 4) {
                return 0;
            }
            return iA;
        }

        public final List<SidecarDisplayFeature> c(SidecarWindowLayoutInfo info) {
            k.e(info, "info");
            try {
                try {
                    List<SidecarDisplayFeature> list = info.displayFeatures;
                    return list == null ? o.g() : list;
                } catch (NoSuchFieldError unused) {
                    Object objInvoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(info, new Object[0]);
                    k.c(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                    return (List) objInvoke;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return o.g();
            }
            return o.g();
        }

        public final void d(SidecarDeviceState sidecarDeviceState, int i10) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i10;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i10));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }
    }

    public static final class b extends l implements xc.l<SidecarDisplayFeature, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14113a = new b();

        public b() {
            super(1);
        }

        @Override // xc.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            k.e(require, "$this$require");
            boolean z10 = true;
            if (require.getType() != 1 && require.getType() != 2) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class c extends l implements xc.l<SidecarDisplayFeature, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14114a = new c();

        public c() {
            super(1);
        }

        @Override // xc.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            k.e(require, "$this$require");
            return Boolean.valueOf((require.getRect().width() == 0 && require.getRect().height() == 0) ? false : true);
        }
    }

    public static final class d extends l implements xc.l<SidecarDisplayFeature, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14115a = new d();

        public d() {
            super(1);
        }

        @Override // xc.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            k.e(require, "$this$require");
            boolean z10 = true;
            if (require.getType() == 1 && require.getRect().width() != 0 && require.getRect().height() != 0) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class e extends l implements xc.l<SidecarDisplayFeature, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f14116a = new e();

        public e() {
            super(1);
        }

        @Override // xc.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SidecarDisplayFeature require) {
            k.e(require, "$this$require");
            return Boolean.valueOf(require.getRect().left == 0 || require.getRect().top == 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a(j verificationMode) {
        k.e(verificationMode, "verificationMode");
        this.f14112a = verificationMode;
    }

    public /* synthetic */ a(j jVar, int i10, g gVar) {
        this((i10 & 1) != 0 ? j.QUIET : jVar);
    }

    public final boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (k.a(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        C0247a c0247a = f14110b;
        return c0247a.b(sidecarDeviceState) == c0247a.b(sidecarDeviceState2);
    }

    public final boolean b(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (k.a(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return k.a(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public final boolean c(List<SidecarDisplayFeature> list, List<SidecarDisplayFeature> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!b(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public final boolean d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (k.a(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        C0247a c0247a = f14110b;
        return c(c0247a.c(sidecarWindowLayoutInfo), c0247a.c(sidecarWindowLayoutInfo2));
    }

    public final List<m2.a> e(List<SidecarDisplayFeature> sidecarDisplayFeatures, SidecarDeviceState deviceState) {
        k.e(sidecarDisplayFeatures, "sidecarDisplayFeatures");
        k.e(deviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sidecarDisplayFeatures.iterator();
        while (it.hasNext()) {
            m2.a aVarG = g((SidecarDisplayFeature) it.next(), deviceState);
            if (aVarG != null) {
                arrayList.add(aVarG);
            }
        }
        return arrayList;
    }

    public final m2.j f(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState state) {
        k.e(state, "state");
        if (sidecarWindowLayoutInfo == null) {
            return new m2.j(o.g());
        }
        SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
        C0247a c0247a = f14110b;
        c0247a.d(sidecarDeviceState, c0247a.b(state));
        return new m2.j(e(c0247a.c(sidecarWindowLayoutInfo), sidecarDeviceState));
    }

    public final m2.a g(SidecarDisplayFeature feature, SidecarDeviceState deviceState) {
        m2.d.b bVarA;
        m2.c.b bVar;
        k.e(feature, "feature");
        k.e(deviceState, "deviceState");
        h.a aVar = h.f11181a;
        String TAG = f14111c;
        k.d(TAG, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) h.a.b(aVar, feature, TAG, this.f14112a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", b.f14113a).c("Feature bounds must not be 0", c.f14114a).c("TYPE_FOLD must have 0 area", d.f14115a).c("Feature be pinned to either left or top", e.f14116a).a();
        if (sidecarDisplayFeature == null) {
            return null;
        }
        int type = sidecarDisplayFeature.getType();
        if (type == 1) {
            bVarA = m2.d.b.f12917b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = m2.d.b.f12917b.b();
        }
        int iB = f14110b.b(deviceState);
        if (iB == 0 || iB == 1) {
            return null;
        }
        if (iB == 2) {
            bVar = m2.c.b.f12911d;
        } else {
            if (iB != 3 && iB == 4) {
                return null;
            }
            bVar = m2.c.b.f12910c;
        }
        Rect rect = feature.getRect();
        k.d(rect, "feature.rect");
        return new m2.d(new j2.b(rect), bVarA, bVar);
    }
}
