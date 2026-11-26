package com.example.bingwahybrid.presentation.updates.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.repository.AppUpdateRepository;
import com.example.bingwahybrid.domain.updates.enums.UpdateState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: CheckForUpdatesViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/example/bingwahybrid/presentation/updates/viewmodel/CheckForUpdatesViewModel;", "Landroidx/lifecycle/ViewModel;", "appUpdateRepository", "Lcom/example/bingwahybrid/domain/repository/AppUpdateRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/AppUpdateRepository;)V", "updateState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bingwahybrid/domain/updates/enums/UpdateState;", "getUpdateState", "()Lkotlinx/coroutines/flow/StateFlow;", "_uiMessage", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "uiMessage", "getUiMessage", "checkForUpdate", "", "installUpdate", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CheckForUpdatesViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _uiMessage;
    private final AppUpdateRepository appUpdateRepository;
    private final StateFlow<String> uiMessage;
    private final StateFlow<UpdateState> updateState;

    @Inject
    public CheckForUpdatesViewModel(AppUpdateRepository appUpdateRepository) {
        Intrinsics.checkNotNullParameter(appUpdateRepository, "appUpdateRepository");
        this.appUpdateRepository = appUpdateRepository;
        this.updateState = appUpdateRepository.getUpdateState();
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._uiMessage = MutableStateFlow;
        this.uiMessage = MutableStateFlow;
        checkForUpdate();
    }

    public final StateFlow<UpdateState> getUpdateState() {
        return this.updateState;
    }

    public final StateFlow<String> getUiMessage() {
        return this.uiMessage;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.updates.viewmodel.CheckForUpdatesViewModel$checkForUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: CheckForUpdatesViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.updates.viewmodel.CheckForUpdatesViewModel$checkForUpdate$1", f = "CheckForUpdatesViewModel.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CheckForUpdatesViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CheckForUpdatesViewModel.this.appUpdateRepository.checkForUpdates(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void checkForUpdate() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void installUpdate() {
        if (this.updateState.getValue() instanceof UpdateState.UpdateRequired) {
            UpdateState value = this.updateState.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.example.bingwahybrid.domain.updates.enums.UpdateState.UpdateRequired");
            String apkUrl = ((UpdateState.UpdateRequired) value).getApkUrl();
            if (StringsKt.isBlank(apkUrl)) {
                this._uiMessage.setValue("Unable to update app. Something is missing.");
            } else {
                this.appUpdateRepository.downloadAndInstall(apkUrl);
            }
        }
    }
}
