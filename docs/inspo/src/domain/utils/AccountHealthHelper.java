package com.example.bingwahybrid.domain.utils;

import android.os.Build;
import com.example.bingwahybrid.data.remote.api.request.AccountHealthRequest;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.enums.SubscriptionType;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.subscriptions.model.Subscription;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccountHealthHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/utils/AccountHealthHelper;", "", "<init>", "()V", "generateHealthCheckPayload", "Lcom/example/bingwahybrid/data/remote/api/request/AccountHealthRequest;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "subscriptionRepository", "Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;", "(Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/subscriptions/repository/SubscriptionRepository;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppVersion", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AccountHealthHelper {
    public static final int $stable = 0;
    public static final AccountHealthHelper INSTANCE = new AccountHealthHelper();

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.utils.AccountHealthHelper$generateHealthCheckPayload$1, reason: invalid class name */
    /* JADX INFO: compiled from: AccountHealthHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.utils.AccountHealthHelper", f = "AccountHealthHelper.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {16, 21}, m = "generateHealthCheckPayload", n = {"settingsRepository", "subscriptionRepository", "settingsRepository", "subscriptionRepository", "subscriptions", "unlimited", "limited"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AccountHealthHelper.this.generateHealthCheckPayload(null, null, this);
        }
    }

    private AccountHealthHelper() {
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object generateHealthCheckPayload(SettingsRepository settingsRepository, SubscriptionRepository subscriptionRepository, Continuation<? super AccountHealthRequest> continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        Object next;
        Subscription subscription;
        Subscription subscription2;
        long limit;
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
        Object activeSubscriptions = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i == 1) {
                subscriptionRepository = (SubscriptionRepository) anonymousClass1.L$1;
                settingsRepository = (SettingsRepository) anonymousClass1.L$0;
                ResultKt.throwOnFailure(activeSubscriptions);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                subscription = (Subscription) anonymousClass1.L$4;
                subscription2 = (Subscription) anonymousClass1.L$3;
                ResultKt.throwOnFailure(activeSubscriptions);
            }
            String str = (String) activeSubscriptions;
            String appVersion = getAppVersion();
            String RELEASE = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
            String deviceModel = DeviceUtils.INSTANCE.getDeviceModel();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (subscription2 != null) {
                limit = subscription2.getLimit();
            } else {
                limit = 0;
            }
            return new AccountHealthRequest(str, appVersion, RELEASE, deviceModel, jCurrentTimeMillis, subscription != null ? subscription.getLimit() : 0L, limit);
        }
        ResultKt.throwOnFailure(activeSubscriptions);
        anonymousClass1.L$0 = settingsRepository;
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(subscriptionRepository);
        anonymousClass1.label = 1;
        activeSubscriptions = subscriptionRepository.getActiveSubscriptions(anonymousClass1);
        if (activeSubscriptions != coroutine_suspended) {
        }
        return coroutine_suspended;
        List list = (List) activeSubscriptions;
        List list2 = list;
        Iterator it = list2.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Subscription) next).getType() != SubscriptionType.UNLIMITED);
        Subscription subscription3 = (Subscription) next;
        for (Object obj2 : list2) {
            if (((Subscription) obj2).getType() == SubscriptionType.LIMITED) {
                obj = obj2;
                break;
            }
        }
        Subscription subscription4 = (Subscription) obj;
        AppSetting appSetting = AppSetting.APP_CONNECT_ID;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(settingsRepository);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(subscriptionRepository);
        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(list);
        anonymousClass1.L$3 = subscription3;
        anonymousClass1.L$4 = subscription4;
        anonymousClass1.label = 2;
        activeSubscriptions = settingsRepository.getSetting(appSetting, anonymousClass1);
        if (activeSubscriptions != coroutine_suspended) {
            subscription = subscription4;
            subscription2 = subscription3;
            String str2 = (String) activeSubscriptions;
            String appVersion2 = getAppVersion();
            String RELEASE2 = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE2, "RELEASE");
            String deviceModel2 = DeviceUtils.INSTANCE.getDeviceModel();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (subscription2 != null) {
                limit = subscription2.getLimit();
            } else {
                limit = 0;
            }
            return new AccountHealthRequest(str2, appVersion2, RELEASE2, deviceModel2, jCurrentTimeMillis2, subscription != null ? subscription.getLimit() : 0L, limit);
        }
        return coroutine_suspended;
    }

    private final String getAppVersion() {
        return Constants.APP_VERSION;
    }
}
