package com.example.bingwahybrid.domain.usecase;

import android.content.Context;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SubscriptionIdFetcherUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u0017\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0087@¢\u0006\u0002\u0010\nJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\tH\u0003J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/SubscriptionIdFetcherUseCase;", "", "context", "Landroid/content/Context;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "<init>", "(Landroid/content/Context;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;)V", "getUssdSubscriptionId", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSmsSimSubscriptionId", "getSubscriptionIdForSimSlot", "simSlot", "(I)Ljava/lang/Integer;", "getUssdPhoneAccountHandle", "Landroid/telecom/PhoneAccountHandle;", "getPhoneAccountHandleForSimSlot", "getSlotFromSubId", "subId", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SubscriptionIdFetcherUseCase {
    public static final int $stable = 8;
    private final Context context;
    private final SettingsRepository settingsRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase$getSmsSimSubscriptionId$1, reason: invalid class name */
    /* JADX INFO: compiled from: SubscriptionIdFetcherUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase", f = "SubscriptionIdFetcherUseCase.kt", i = {}, l = {31}, m = "getSmsSimSubscriptionId", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionIdFetcherUseCase.this.getSmsSimSubscriptionId(this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase$getUssdPhoneAccountHandle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SubscriptionIdFetcherUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase", f = "SubscriptionIdFetcherUseCase.kt", i = {}, l = {50}, m = "getUssdPhoneAccountHandle", n = {}, s = {})
    static final class C06901 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06901(Continuation<? super C06901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionIdFetcherUseCase.this.getUssdPhoneAccountHandle(this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase$getUssdSubscriptionId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SubscriptionIdFetcherUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase", f = "SubscriptionIdFetcherUseCase.kt", i = {}, l = {23}, m = "getUssdSubscriptionId", n = {}, s = {})
    static final class C06911 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06911(Continuation<? super C06911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionIdFetcherUseCase.this.getUssdSubscriptionId(this);
        }
    }

    @Inject
    public SubscriptionIdFetcherUseCase(Context context, SettingsRepository settingsRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        this.context = context;
        this.settingsRepository = settingsRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getUssdSubscriptionId(Continuation<? super Integer> continuation) throws Exception {
        C06911 c06911;
        if (continuation instanceof C06911) {
            c06911 = (C06911) continuation;
            if ((c06911.label & Integer.MIN_VALUE) != 0) {
                c06911.label -= Integer.MIN_VALUE;
            } else {
                c06911 = new C06911(continuation);
            }
        } else {
            c06911 = new C06911(continuation);
        }
        Object setting = c06911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06911.label;
        if (i == 0) {
            ResultKt.throwOnFailure(setting);
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.DIAL_USSD_VIA_SIM_2;
            c06911.label = 1;
            setting = settingsRepository.getSetting(appSetting, c06911);
            if (setting == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(setting);
        }
        int i2 = Boolean.parseBoolean((String) setting) ? 2 : 1;
        Integer subscriptionIdForSimSlot = getSubscriptionIdForSimSlot(i2);
        if (subscriptionIdForSimSlot != null) {
            return Boxing.boxInt(subscriptionIdForSimSlot.intValue());
        }
        throw new Exception("No valid SIM card detected in Slot " + i2 + ". Please insert a SIM card then try again.");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getSmsSimSubscriptionId(Continuation<? super Integer> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object setting = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(setting);
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.SEND_SMS_VIA_SIM_2;
            anonymousClass1.label = 1;
            setting = settingsRepository.getSetting(appSetting, anonymousClass1);
            if (setting == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(setting);
        }
        int i2 = Boolean.parseBoolean((String) setting) ? 2 : 1;
        Integer subscriptionIdForSimSlot = getSubscriptionIdForSimSlot(i2);
        if (subscriptionIdForSimSlot != null) {
            return Boxing.boxInt(subscriptionIdForSimSlot.intValue());
        }
        throw new Exception("No valid SIM card detected in Slot " + i2 + ". Please insert a SIM card then try again.");
    }

    private final Integer getSubscriptionIdForSimSlot(int simSlot) {
        SubscriptionInfo subscriptionInfo;
        int i = simSlot - 1;
        Object systemService = this.context.getSystemService("telephony_subscription_service");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.SubscriptionManager");
        List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) systemService).getActiveSubscriptionInfoList();
        if (activeSubscriptionInfoList == null || (subscriptionInfo = (SubscriptionInfo) CollectionsKt.getOrNull(activeSubscriptionInfoList, i)) == null) {
            return null;
        }
        return Integer.valueOf(subscriptionInfo.getSubscriptionId());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getUssdPhoneAccountHandle(Continuation<? super PhoneAccountHandle> continuation) throws Exception {
        C06901 c06901;
        if (continuation instanceof C06901) {
            c06901 = (C06901) continuation;
            if ((c06901.label & Integer.MIN_VALUE) != 0) {
                c06901.label -= Integer.MIN_VALUE;
            } else {
                c06901 = new C06901(continuation);
            }
        } else {
            c06901 = new C06901(continuation);
        }
        Object setting = c06901.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06901.label;
        if (i == 0) {
            ResultKt.throwOnFailure(setting);
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting appSetting = AppSetting.DIAL_USSD_VIA_SIM_2;
            c06901.label = 1;
            setting = settingsRepository.getSetting(appSetting, c06901);
            if (setting == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(setting);
        }
        PhoneAccountHandle phoneAccountHandleForSimSlot = getPhoneAccountHandleForSimSlot(Boolean.parseBoolean((String) setting) ? 2 : 1);
        if (phoneAccountHandleForSimSlot != null) {
            return phoneAccountHandleForSimSlot;
        }
        throw new Exception("Could not get AccountHandle to run USSD");
    }

    private final PhoneAccountHandle getPhoneAccountHandleForSimSlot(int simSlot) {
        SubscriptionInfo subscriptionInfo;
        Object systemService = this.context.getSystemService("telecom");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telecom.TelecomManager");
        TelecomManager telecomManager = (TelecomManager) systemService;
        Object systemService2 = this.context.getSystemService("telephony_subscription_service");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.telephony.SubscriptionManager");
        List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) systemService2).getActiveSubscriptionInfoList();
        Object obj = null;
        if (activeSubscriptionInfoList == null || (subscriptionInfo = (SubscriptionInfo) CollectionsKt.getOrNull(activeSubscriptionInfoList, simSlot - 1)) == null) {
            return null;
        }
        List<PhoneAccountHandle> callCapablePhoneAccounts = telecomManager.getCallCapablePhoneAccounts();
        Intrinsics.checkNotNull(callCapablePhoneAccounts);
        for (Object obj2 : callCapablePhoneAccounts) {
            String id = ((PhoneAccountHandle) obj2).getId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            String iccId = subscriptionInfo.getIccId();
            Intrinsics.checkNotNullExpressionValue(iccId, "getIccId(...)");
            if (StringsKt.contains$default((CharSequence) id, (CharSequence) iccId, false, 2, (Object) null)) {
                obj = obj2;
                break;
            }
        }
        return (PhoneAccountHandle) obj;
    }

    public final int getSlotFromSubId(int subId) {
        try {
            Object systemService = this.context.getSystemService("telephony_subscription_service");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.SubscriptionManager");
            SubscriptionManager subscriptionManager = (SubscriptionManager) systemService;
            if (subscriptionManager.getActiveSubscriptionInfoList() == null) {
                return -1;
            }
            List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
            Intrinsics.checkNotNull(activeSubscriptionInfoList);
            for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                if (subscriptionInfo.getSubscriptionId() == subId) {
                    return subscriptionInfo.getSimSlotIndex();
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
