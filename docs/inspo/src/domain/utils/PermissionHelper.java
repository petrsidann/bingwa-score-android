package com.example.bingwahybrid.domain.utils;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nJ\u001e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0012"}, d2 = {"Lcom/example/bingwahybrid/domain/utils/PermissionHelper;", "", "<init>", "()V", "hasPermissions", "", "activity", "Landroid/app/Activity;", "permissions", "", "", "requestPermissionsIfNeeded", "", "requestCode", "", "isPermissionGranted", "permission", "requestPermission", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PermissionHelper {
    public static final int $stable = 0;
    public static final PermissionHelper INSTANCE = new PermissionHelper();

    private PermissionHelper() {
    }

    public final boolean hasPermissions(Activity activity, List<String> permissions) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        List<String> list = permissions;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (ContextCompat.checkSelfPermission(activity, (String) it.next()) != 0) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ void requestPermissionsIfNeeded$default(PermissionHelper permissionHelper, Activity activity, List list, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 100;
        }
        permissionHelper.requestPermissionsIfNeeded(activity, list, i);
    }

    public final void requestPermissionsIfNeeded(Activity activity, List<String> permissions, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        ArrayList arrayList = new ArrayList();
        for (Object obj : permissions) {
            if (ContextCompat.checkSelfPermission(activity, (String) obj) != 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        ActivityCompat.requestPermissions(activity, (String[]) arrayList2.toArray(new String[0]), requestCode);
    }

    public final boolean isPermissionGranted(Activity activity, String permission) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ContextCompat.checkSelfPermission(activity, permission) == 0;
    }

    public final void requestPermission(Activity activity, String permission, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permission, "permission");
        ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
    }
}
