package com.example.bingwahybrid.presentation.settings.autosave.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.fasterxml.jackson.core.io.doubleparser.FastDoubleMath;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AutoSaveContactsViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/example/bingwahybrid/presentation/settings/autosave/viewmodel/AutoSaveContactsViewModel;", "Landroidx/lifecycle/ViewModel;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/SettingsRepository;)V", "_isAutoSaveEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isAutoSaveEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_autoSaveContactsSuffix", "", "autoSaveContactsSuffix", "getAutoSaveContactsSuffix", "_snackBarMessage", "snackBarMessage", "getSnackBarMessage", "loadAutoSaveSettings", "", "updateAutoSaveEnabled", "isEnabled", "saveAutoSaveContactsSuffix", "rawSuffix", "resetSnackbarMessage", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AutoSaveContactsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _autoSaveContactsSuffix;
    private final MutableStateFlow<Boolean> _isAutoSaveEnabled;
    private final MutableStateFlow<String> _snackBarMessage;
    private final StateFlow<String> autoSaveContactsSuffix;
    private final StateFlow<Boolean> isAutoSaveEnabled;
    private final SettingsRepository settingsRepository;
    private final StateFlow<String> snackBarMessage;

    @Inject
    public AutoSaveContactsViewModel(SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.settingsRepository = settingsRepository;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isAutoSaveEnabled = MutableStateFlow;
        this.isAutoSaveEnabled = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow("Bingwa");
        this._autoSaveContactsSuffix = MutableStateFlow2;
        this.autoSaveContactsSuffix = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._snackBarMessage = MutableStateFlow3;
        this.snackBarMessage = MutableStateFlow3;
        loadAutoSaveSettings();
    }

    public final StateFlow<Boolean> isAutoSaveEnabled() {
        return this.isAutoSaveEnabled;
    }

    public final StateFlow<String> getAutoSaveContactsSuffix() {
        return this.autoSaveContactsSuffix;
    }

    public final StateFlow<String> getSnackBarMessage() {
        return this.snackBarMessage;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.settings.autosave.viewmodel.AutoSaveContactsViewModel$loadAutoSaveSettings$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoSaveContactsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.settings.autosave.viewmodel.AutoSaveContactsViewModel$loadAutoSaveSettings$1", f = "AutoSaveContactsViewModel.kt", i = {1}, l = {37, 40}, m = "invokeSuspend", n = {"isEnabled"}, s = {"Z$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        boolean Z$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoSaveContactsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
        
            if (r6 == r0) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = AutoSaveContactsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS, this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                String string = StringsKt.trim((CharSequence) obj).toString();
                if (StringsKt.isBlank(string)) {
                    string = "Bingwa";
                }
                AutoSaveContactsViewModel.this._autoSaveContactsSuffix.setValue(string);
                return Unit.INSTANCE;
                boolean z = Boolean.parseBoolean((String) obj);
                AutoSaveContactsViewModel.this._isAutoSaveEnabled.setValue(Boxing.boxBoolean(z));
                this.Z$0 = z;
                this.label = 2;
                obj = AutoSaveContactsViewModel.this.settingsRepository.getSetting(AppSetting.AUTO_SAVE_CONTACTS_SUFFIX, this);
            } catch (Exception e) {
                AutoSaveContactsViewModel.this._snackBarMessage.setValue(e.getMessage());
            }
        }
    }

    private final void loadAutoSaveSettings() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.settings.autosave.viewmodel.AutoSaveContactsViewModel$updateAutoSaveEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoSaveContactsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.settings.autosave.viewmodel.AutoSaveContactsViewModel$updateAutoSaveEnabled$1", f = "AutoSaveContactsViewModel.kt", i = {}, l = {FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH}, m = "invokeSuspend", n = {}, s = {})
    static final class C07301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07301(boolean z, Continuation<? super C07301> continuation) {
            super(2, continuation);
            this.$isEnabled = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AutoSaveContactsViewModel.this.new C07301(this.$isEnabled, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (AutoSaveContactsViewModel.this.settingsRepository.saveSetting(AppSetting.AUTO_SAVE_CONTACTS, String.valueOf(this.$isEnabled), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                AutoSaveContactsViewModel.this._isAutoSaveEnabled.setValue(Boxing.boxBoolean(this.$isEnabled));
            } catch (Exception e) {
                AutoSaveContactsViewModel.this._snackBarMessage.setValue(e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    public final void updateAutoSaveEnabled(boolean isEnabled) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07301(isEnabled, null), 2, null);
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.settings.autosave.viewmodel.AutoSaveContactsViewModel$saveAutoSaveContactsSuffix$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AutoSaveContactsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.presentation.settings.autosave.viewmodel.AutoSaveContactsViewModel$saveAutoSaveContactsSuffix$1", f = "AutoSaveContactsViewModel.kt", i = {0}, l = {65}, m = "invokeSuspend", n = {"suffix"}, s = {"L$0"})
    static final class C07291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $rawSuffix;
        Object L$0;
        int label;
        final /* synthetic */ AutoSaveContactsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07291(String str, AutoSaveContactsViewModel autoSaveContactsViewModel, Continuation<? super C07291> continuation) {
            super(2, continuation);
            this.$rawSuffix = str;
            this.this$0 = autoSaveContactsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07291(this.$rawSuffix, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String string = StringsKt.trim((CharSequence) this.$rawSuffix).toString();
                    if (StringsKt.isBlank(string)) {
                        string = "Bingwa";
                    }
                    String str2 = string;
                    this.L$0 = str2;
                    this.label = 1;
                    if (this.this$0.settingsRepository.saveSetting(AppSetting.AUTO_SAVE_CONTACTS_SUFFIX, str2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = str2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0._autoSaveContactsSuffix.setValue(str);
            } catch (Exception e) {
                this.this$0._snackBarMessage.setValue(e.getMessage());
            }
            return Unit.INSTANCE;
        }
    }

    public final void saveAutoSaveContactsSuffix(String rawSuffix) {
        Intrinsics.checkNotNullParameter(rawSuffix, "rawSuffix");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07291(rawSuffix, this, null), 2, null);
    }

    public final void resetSnackbarMessage() {
        this._snackBarMessage.setValue(null);
    }
}
