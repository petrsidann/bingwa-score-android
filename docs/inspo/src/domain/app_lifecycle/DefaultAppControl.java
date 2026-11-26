package com.example.bingwahybrid.domain.app_lifecycle;

import androidx.core.view.MotionEventCompat;
import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.enums.AppState;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.validation.usecase.ValidateStartupUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: DefaultAppControl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0013\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0014\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\b\u0010\u0015\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/example/bingwahybrid/domain/app_lifecycle/DefaultAppControl;", "Lcom/example/bingwahybrid/domain/app_lifecycle/interfaces/AppControl;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "validateStartupUseCase", "Lcom/example/bingwahybrid/domain/validation/usecase/ValidateStartupUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/validation/usecase/ValidateStartupUseCase;)V", "_appState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bingwahybrid/domain/enums/AppState;", "appState", "Lkotlinx/coroutines/flow/StateFlow;", "getAppState", "()Lkotlinx/coroutines/flow/StateFlow;", "startApp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pauseApp", "resumeApp", "stopApp", "initializeAppState", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultAppControl implements AppControl {
    public static final int $stable = 8;
    private final MutableStateFlow<AppState> _appState;
    private final StateFlow<AppState> appState;
    private final SettingsRepository settingsRepository;
    private final ValidateStartupUseCase validateStartupUseCase;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.app_lifecycle.DefaultAppControl$pauseApp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultAppControl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.app_lifecycle.DefaultAppControl", f = "DefaultAppControl.kt", i = {}, l = {41}, m = "pauseApp", n = {}, s = {})
    static final class C06671 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06671(Continuation<? super C06671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultAppControl.this.pauseApp(this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.app_lifecycle.DefaultAppControl$resumeApp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultAppControl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.app_lifecycle.DefaultAppControl", f = "DefaultAppControl.kt", i = {}, l = {MotionEventCompat.AXIS_GENERIC_16, 48}, m = "resumeApp", n = {}, s = {})
    static final class C06681 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06681(Continuation<? super C06681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultAppControl.this.resumeApp(this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.app_lifecycle.DefaultAppControl$startApp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultAppControl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.app_lifecycle.DefaultAppControl", f = "DefaultAppControl.kt", i = {}, l = {30, 31}, m = "startApp", n = {}, s = {})
    static final class C06691 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06691(Continuation<? super C06691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultAppControl.this.startApp(this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.app_lifecycle.DefaultAppControl$stopApp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultAppControl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.app_lifecycle.DefaultAppControl", f = "DefaultAppControl.kt", i = {}, l = {58}, m = "stopApp", n = {}, s = {})
    static final class C06701 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06701(Continuation<? super C06701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultAppControl.this.stopApp(this);
        }
    }

    @Inject
    public DefaultAppControl(SettingsRepository settingsRepository, ValidateStartupUseCase validateStartupUseCase) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(validateStartupUseCase, "validateStartupUseCase");
        this.settingsRepository = settingsRepository;
        this.validateStartupUseCase = validateStartupUseCase;
        MutableStateFlow<AppState> MutableStateFlow = StateFlowKt.MutableStateFlow(AppState.STATE_STOPPED);
        this._appState = MutableStateFlow;
        this.appState = FlowKt.asStateFlow(MutableStateFlow);
        initializeAppState();
    }

    @Override // com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppStateProvider
    public StateFlow<AppState> getAppState() {
        return this.appState;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r6.saveSetting(r2, "STATE_RUNNING", r0) == r1) goto L21;
     */
    @Override // com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object startApp(Continuation<? super Unit> continuation) {
        C06691 c06691;
        if (continuation instanceof C06691) {
            c06691 = (C06691) continuation;
            if ((c06691.label & Integer.MIN_VALUE) != 0) {
                c06691.label -= Integer.MIN_VALUE;
            } else {
                c06691 = new C06691(continuation);
            }
        } else {
            c06691 = new C06691(continuation);
        }
        Object obj = c06691.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06691.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ValidateStartupUseCase validateStartupUseCase = this.validateStartupUseCase;
            c06691.label = 1;
            if (validateStartupUseCase.invoke(c06691) != coroutine_suspended) {
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
        this._appState.setValue(AppState.STATE_RUNNING);
        return Unit.INSTANCE;
        SettingsRepository settingsRepository = this.settingsRepository;
        AppSetting appSetting = AppSetting.APP_STATE;
        c06691.label = 2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl
    public Object pauseApp(Continuation<? super Unit> continuation) {
        C06671 c06671;
        if (continuation instanceof C06671) {
            c06671 = (C06671) continuation;
            if ((c06671.label & Integer.MIN_VALUE) != 0) {
                c06671.label -= Integer.MIN_VALUE;
            } else {
                c06671 = new C06671(continuation);
            }
        } else {
            c06671 = new C06671(continuation);
        }
        Object obj = c06671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06671.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.APP_STATE;
            c06671.label = 1;
            if (settingsRepository.saveSetting(appSetting, "STATE_PAUSED", c06671) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this._appState.setValue(AppState.STATE_PAUSED);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r6.saveSetting(r2, "STATE_RUNNING", r0) == r1) goto L21;
     */
    @Override // com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object resumeApp(Continuation<? super Unit> continuation) {
        C06681 c06681;
        if (continuation instanceof C06681) {
            c06681 = (C06681) continuation;
            if ((c06681.label & Integer.MIN_VALUE) != 0) {
                c06681.label -= Integer.MIN_VALUE;
            } else {
                c06681 = new C06681(continuation);
            }
        } else {
            c06681 = new C06681(continuation);
        }
        Object obj = c06681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06681.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ValidateStartupUseCase validateStartupUseCase = this.validateStartupUseCase;
            c06681.label = 1;
            if (validateStartupUseCase.invoke(c06681) != coroutine_suspended) {
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
        this._appState.setValue(AppState.STATE_RUNNING);
        return Unit.INSTANCE;
        SettingsRepository settingsRepository = this.settingsRepository;
        AppSetting appSetting = AppSetting.APP_STATE;
        c06681.label = 2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl
    public Object stopApp(Continuation<? super Unit> continuation) {
        C06701 c06701;
        if (continuation instanceof C06701) {
            c06701 = (C06701) continuation;
            if ((c06701.label & Integer.MIN_VALUE) != 0) {
                c06701.label -= Integer.MIN_VALUE;
            } else {
                c06701 = new C06701(continuation);
            }
        } else {
            c06701 = new C06701(continuation);
        }
        Object obj = c06701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06701.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.APP_STATE;
            c06701.label = 1;
            if (settingsRepository.saveSetting(appSetting, "STATE_STOPPED", c06701) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this._appState.setValue(AppState.STATE_STOPPED);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.app_lifecycle.DefaultAppControl$initializeAppState$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultAppControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.app_lifecycle.DefaultAppControl$initializeAppState$1", f = "DefaultAppControl.kt", i = {1}, l = {65, 70}, m = "invokeSuspend", n = {"<unused var>"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultAppControl.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
        
            if (r6.this$0.settingsRepository.saveSetting(com.example.bingwahybrid.domain.enums.AppSetting.APP_STATE, "STATE_STOPPED", r6) == r0) goto L24;
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
                    obj = DefaultAppControl.this.settingsRepository.getSetting(AppSetting.APP_STATE, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        DefaultAppControl.this._appState.setValue(AppState.STATE_STOPPED);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                String str = (String) obj;
                if (StringsKt.isBlank(str)) {
                    str = "STATE_STOPPED";
                }
                DefaultAppControl.this._appState.setValue(AppState.valueOf(str));
            } catch (Exception e) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(e);
                this.label = 2;
            }
            return Unit.INSTANCE;
        }
    }

    private final void initializeAppState() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
    }
}
