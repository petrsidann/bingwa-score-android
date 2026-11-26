package com.example.bingwahybrid.presentation.settings.autosave.components;

import android.app.Activity;
import androidx.activity.compose.ManagedActivityResultLauncher;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.utils.PermissionHelper;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoSaveContactsToggleHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a]\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052)\u0010\u0006\u001a%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\t\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u000b0\n0\u00072\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\r¨\u0006\u000f"}, d2 = {"handleAutoSaveContactsToggle", "", "isChecked", "", "activity", "Landroid/app/Activity;", "permissionsLauncher", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "updateSetting", "Lkotlin/Function2;", "Lcom/example/bingwahybrid/domain/enums/AppSetting;", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AutoSaveContactsToggleHandlerKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void handleAutoSaveContactsToggle(boolean z, Activity activity, ManagedActivityResultLauncher<String[], Map<String, Boolean>> permissionsLauncher, Function2<? super AppSetting, ? super Boolean, Unit> updateSetting) {
        Intrinsics.checkNotNullParameter(permissionsLauncher, "permissionsLauncher");
        Intrinsics.checkNotNullParameter(updateSetting, "updateSetting");
        if (z) {
            List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"});
            if (activity != null && PermissionHelper.INSTANCE.hasPermissions(activity, listListOf)) {
                updateSetting.invoke(AppSetting.AUTO_SAVE_CONTACTS, true);
                return;
            } else {
                permissionsLauncher.launch(listListOf.toArray(new String[0]));
                return;
            }
        }
        updateSetting.invoke(AppSetting.AUTO_SAVE_CONTACTS, false);
    }
}
