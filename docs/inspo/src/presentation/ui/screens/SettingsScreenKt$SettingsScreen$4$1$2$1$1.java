package com.example.bingwahybrid.presentation.ui.screens;

import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.presentation.viewmodel.SettingsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SettingsScreenKt$SettingsScreen$4$1$2$1$1 extends FunctionReferenceImpl implements Function2<AppSetting, Boolean, Unit> {
    SettingsScreenKt$SettingsScreen$4$1$2$1$1(Object obj) {
        super(2, obj, SettingsViewModel.class, "updateSetting", "updateSetting(Lcom/example/bingwahybrid/domain/enums/AppSetting;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(AppSetting appSetting, Boolean bool) {
        invoke(appSetting, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AppSetting p0, boolean z) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((SettingsViewModel) this.receiver).updateSetting(p0, z);
    }
}
