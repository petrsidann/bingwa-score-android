package com.example.bingwahybrid.domain.usecase;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionHandlerUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/PermissionHandlerUseCase;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "hasNecessaryPermissions", "", "requestNecessaryPermissions", "", "activity", "Landroid/app/Activity;", "hasCallPermissions", "hasReadPhoneStatePermissions", "Companion", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PermissionHandlerUseCase {
    private static final int CALL_PERMISSION_REQUEST_CODE = 1;
    private static final int READ_PHONE_STATE_PERMISSION_REQUEST_CODE = 2;
    private final Context context;
    public static final int $stable = 8;

    @Inject
    public PermissionHandlerUseCase(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final boolean hasNecessaryPermissions() {
        return hasCallPermissions() && hasReadPhoneStatePermissions();
    }

    public final void requestNecessaryPermissions(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!hasCallPermissions()) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.CALL_PHONE"}, 1);
        }
        if (hasReadPhoneStatePermissions()) {
            return;
        }
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_PHONE_STATE"}, 2);
    }

    private final boolean hasCallPermissions() {
        return ContextCompat.checkSelfPermission(this.context, "android.permission.CALL_PHONE") == 0;
    }

    private final boolean hasReadPhoneStatePermissions() {
        return ContextCompat.checkSelfPermission(this.context, "android.permission.READ_PHONE_STATE") == 0;
    }
}
