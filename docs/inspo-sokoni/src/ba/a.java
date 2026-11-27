package ba;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3043b;

    public a(Context context) {
        k.e(context, "context");
        this.f3042a = context;
    }

    public final boolean a(String str) {
        return this.f3042a.checkSelfPermission(str) == 0;
    }

    public final String[] b() {
        Context context = this.f3042a;
        String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        return strArr == null ? new String[0] : strArr;
    }

    public final List<String> c() {
        String[] strArrB = b();
        ArrayList arrayList = new ArrayList();
        for (String str : strArrB) {
            if (da.b.f6664a.c().contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> d() {
        String[] strArrB = b();
        ArrayList arrayList = new ArrayList();
        for (String str : strArrB) {
            if (da.b.f6664a.d().contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> e() {
        String[] strArrB = b();
        ArrayList arrayList = new ArrayList();
        for (String str : strArrB) {
            if (da.b.f6664a.e().contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final boolean f(List<String> permissions) {
        k.e(permissions, "permissions");
        while (true) {
            boolean z10 = true;
            for (String str : permissions) {
                if (!z10 || !a(str)) {
                    z10 = false;
                }
            }
            return z10;
        }
    }

    public final void g(Activity activity, List<String> permissions, int i10) {
        k.e(activity, "activity");
        k.e(permissions, "permissions");
        if (this.f3043b) {
            return;
        }
        this.f3043b = true;
        activity.requestPermissions((String[]) permissions.toArray(new String[0]), i10);
    }

    public final void h(boolean z10) {
        this.f3043b = z10;
    }
}
