package com.example.bingwahybrid.domain.sms.usecases;

import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.enums.SmsType;
import com.example.bingwahybrid.domain.exception.InvalidMessageFormatException;
import com.example.bingwahybrid.domain.exception.InvalidSenderException;
import com.example.bingwahybrid.domain.exception.InvalidSubscriptionId;
import com.example.bingwahybrid.domain.exception.RecommendationExpiredException;
import com.example.bingwahybrid.domain.exception.RecommendationTimedOutException;
import com.example.bingwahybrid.domain.repository.AuthorizedSenderRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.sms.model.SmsSender;
import com.example.bingwahybrid.domain.sms.utils.SmsUtilsKt;
import com.example.bingwahybrid.domain.utils.FormatUtilsKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* JADX INFO: compiled from: ValidateMessageUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0086B¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/usecases/ValidateMessageUseCase;", "", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "authorizedSenderRepository", "Lcom/example/bingwahybrid/domain/repository/AuthorizedSenderRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/repository/AuthorizedSenderRepository;)V", "invoke", "", "message", "", "sender", "simSlot", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateEnabledSmsTypes", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkValidMessage", "checkRecommendationTimeoutMessage", "checkRecommendationExpiredMessage", "checkValidSender", "validateEnabledSimCards", "slot", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ValidateMessageUseCase {
    public static final int $stable = 0;
    private final AuthorizedSenderRepository authorizedSenderRepository;
    private final SettingsRepository settingsRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.sms.usecases.ValidateMessageUseCase$checkValidSender$1, reason: invalid class name */
    /* JADX INFO: compiled from: ValidateMessageUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.sms.usecases.ValidateMessageUseCase", f = "ValidateMessageUseCase.kt", i = {0, 0, 0, 0}, l = {85}, m = "checkValidSender", n = {"sender", "formattedSender", "isStandardSender", "isAppAuthorizedSenders"}, s = {"L$0", "L$1", "Z$0", "Z$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ValidateMessageUseCase.this.checkValidSender(null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.sms.usecases.ValidateMessageUseCase$invoke$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ValidateMessageUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.sms.usecases.ValidateMessageUseCase", f = "ValidateMessageUseCase.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {24, 25, 26}, m = "invoke", n = {"message", "sender", "simSlot", "message", "sender", "simSlot", "message", "sender", "simSlot"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
    static final class C06861 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C06861(Continuation<? super C06861> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ValidateMessageUseCase.this.invoke(null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.sms.usecases.ValidateMessageUseCase$validateEnabledSimCards$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ValidateMessageUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.sms.usecases.ValidateMessageUseCase", f = "ValidateMessageUseCase.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {101, 105}, m = "validateEnabledSimCards", n = {"sender", "allowedSimSlots", "slot", "shouldNotCheckSender", "sender", "allowedSimSlots", "slot", "shouldNotCheckSender"}, s = {"L$0", "L$1", "I$0", "Z$0", "L$0", "L$1", "I$0", "Z$0"})
    static final class C06871 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C06871(Continuation<? super C06871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ValidateMessageUseCase.this.validateEnabledSimCards(0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.sms.usecases.ValidateMessageUseCase$validateEnabledSmsTypes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ValidateMessageUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.sms.usecases.ValidateMessageUseCase", f = "ValidateMessageUseCase.kt", i = {0, 0}, l = {37}, m = "validateEnabledSmsTypes", n = {"message", "smsType"}, s = {"L$0", "L$1"})
    static final class C06881 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C06881(Continuation<? super C06881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ValidateMessageUseCase.this.validateEnabledSmsTypes(null, this);
        }
    }

    @Inject
    public ValidateMessageUseCase(SettingsRepository settingsRepository, AuthorizedSenderRepository authorizedSenderRepository) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(authorizedSenderRepository, "authorizedSenderRepository");
        this.settingsRepository = settingsRepository;
        this.authorizedSenderRepository = authorizedSenderRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0097, code lost:
    
        if (validateEnabledSmsTypes(r8, r0) == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(String str, String str2, int i, Continuation<? super Unit> continuation) throws RecommendationTimedOutException, InvalidMessageFormatException, RecommendationExpiredException {
        C06861 c06861;
        if (continuation instanceof C06861) {
            c06861 = (C06861) continuation;
            if ((c06861.label & Integer.MIN_VALUE) != 0) {
                c06861.label -= Integer.MIN_VALUE;
            } else {
                c06861 = new C06861(continuation);
            }
        } else {
            c06861 = new C06861(continuation);
        }
        Object obj = c06861.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c06861.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c06861.L$0 = str;
            c06861.L$1 = str2;
            c06861.I$0 = i;
            c06861.label = 1;
            if (validateEnabledSimCards(i, str2, c06861) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            i = c06861.I$0;
            str2 = (String) c06861.L$1;
            str = (String) c06861.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i2 == 2) {
            int i3 = c06861.I$0;
            str2 = (String) c06861.L$1;
            String str3 = (String) c06861.L$0;
            ResultKt.throwOnFailure(obj);
            i = i3;
            str = str3;
            c06861.L$0 = str;
            c06861.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c06861.I$0 = i;
            c06861.label = 3;
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c06861.I$0;
            str = (String) c06861.L$0;
            ResultKt.throwOnFailure(obj);
        }
        checkRecommendationTimeoutMessage(str);
        checkRecommendationExpiredMessage(str);
        checkValidMessage(str);
        return Unit.INSTANCE;
        c06861.L$0 = str;
        c06861.L$1 = SpillingKt.nullOutSpilledVariable(str2);
        c06861.I$0 = i;
        c06861.label = 2;
        if (checkValidSender(str2, c06861) != coroutine_suspended) {
            c06861.L$0 = str;
            c06861.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c06861.I$0 = i;
            c06861.label = 3;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object validateEnabledSmsTypes(String str, Continuation<? super Unit> continuation) throws Exception {
        C06881 c06881;
        SmsType smsType;
        if (continuation instanceof C06881) {
            c06881 = (C06881) continuation;
            if ((c06881.label & Integer.MIN_VALUE) != 0) {
                c06881.label -= Integer.MIN_VALUE;
            } else {
                c06881 = new C06881(continuation);
            }
        } else {
            c06881 = new C06881(continuation);
        }
        Object obj = c06881.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06881.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SmsType smsType2 = SmsUtilsKt.getSmsType(str);
            if (smsType2.getSettingKey() == null) {
                return Unit.INSTANCE;
            }
            SettingsRepository settingsRepository = this.settingsRepository;
            AppSetting settingKey = smsType2.getSettingKey();
            c06881.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c06881.L$1 = smsType2;
            c06881.label = 1;
            Object setting = settingsRepository.getSetting(settingKey, c06881);
            if (setting == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = setting;
            smsType = smsType2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            smsType = (SmsType) c06881.L$1;
            ResultKt.throwOnFailure(obj);
        }
        if (!Boolean.parseBoolean((String) obj)) {
            throw new Exception(smsType.getErrorMessage());
        }
        return Unit.INSTANCE;
    }

    private final void checkValidMessage(String message) throws InvalidMessageFormatException {
        Set set = CollectionsKt.toSet(SmsType.getEntries());
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (((SmsType) it.next()).matches(message)) {
                    return;
                }
            }
        }
        throw new InvalidMessageFormatException("Invalid message format: " + message);
    }

    private final void checkRecommendationTimeoutMessage(String message) throws RecommendationTimedOutException {
        MatchResult matchResultFind$default = Regex.find$default(new Regex("Recommendation for (\\d{9,12}) timed out", (Set<? extends RegexOption>) SetsKt.setOf(RegexOption.IGNORE_CASE)), message, 0, 2, null);
        if (matchResultFind$default != null) {
            throw new RecommendationTimedOutException(matchResultFind$default.getGroupValues().get(1));
        }
    }

    private final void checkRecommendationExpiredMessage(String message) throws RecommendationExpiredException {
        MatchResult matchResultFind$default = Regex.find$default(new Regex("Recommendation for (\\d{9,12}) expired", (Set<? extends RegexOption>) SetsKt.setOf(RegexOption.IGNORE_CASE)), message, 0, 2, null);
        if (matchResultFind$default != null) {
            throw new RecommendationExpiredException(matchResultFind$default.getGroupValues().get(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object checkValidSender(String str, Continuation<? super Unit> continuation) throws InvalidSenderException {
        AnonymousClass1 anonymousClass1;
        boolean z;
        String str2;
        boolean z2;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (str.length() == 0) {
                throw new InvalidSenderException("Sender cannot be blank");
            }
            boolean zContains = SetsKt.setOf((Object[]) new String[]{SmsSender.MPESA, SmsSender.SAFARICOM}).contains(str);
            boolean zContains2 = SetsKt.setOf((Object[]) new String[]{SmsSender.HYBRID_CONNECT, SmsSender.SITELINK}).contains(str);
            String phoneToTenDigits = FormatUtilsKt.formatPhoneToTenDigits(str);
            AuthorizedSenderRepository authorizedSenderRepository = this.authorizedSenderRepository;
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(phoneToTenDigits);
            anonymousClass1.Z$0 = zContains;
            anonymousClass1.Z$1 = zContains2;
            anonymousClass1.label = 1;
            Object objIsSenderAuthorized = authorizedSenderRepository.isSenderAuthorized(phoneToTenDigits, anonymousClass1);
            if (objIsSenderAuthorized == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objIsSenderAuthorized;
            z = zContains2;
            str2 = str;
            z2 = zContains;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = anonymousClass1.Z$1;
            z2 = anonymousClass1.Z$0;
            str2 = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (!z2 && !zBooleanValue && !z) {
            throw new InvalidSenderException("Not allowed to process messages from sender " + str2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00da  */
    /* JADX WARN: Code duplicated, block: B:40:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object validateEnabledSimCards(int i, String str, Continuation<? super Unit> continuation) throws Exception {
        C06871 c06871;
        boolean zContains;
        int i2;
        Set set;
        Object obj;
        String str2;
        int i3;
        if (continuation instanceof C06871) {
            c06871 = (C06871) continuation;
            if ((c06871.label & Integer.MIN_VALUE) != 0) {
                c06871.label -= Integer.MIN_VALUE;
            } else {
                c06871 = new C06871(continuation);
            }
        } else {
            c06871 = new C06871(continuation);
        }
        Object setting = c06871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c06871.label;
        if (i4 != 0) {
            if (i4 == 1) {
                boolean z = c06871.Z$0;
                i2 = c06871.I$0;
                Set set2 = (Set) c06871.L$1;
                str2 = (String) c06871.L$0;
                ResultKt.throwOnFailure(setting);
                zContains = z;
                set = set2;
                obj = setting;
            } else {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z2 = c06871.Z$0;
                i3 = c06871.I$0;
                set = (Set) c06871.L$1;
                ResultKt.throwOnFailure(setting);
            }
            if (Boolean.parseBoolean((String) setting)) {
                set.add(Boxing.boxInt(1));
            }
            if (set.contains(Boxing.boxInt(i3))) {
                throw new Exception("Not allowed to process messages from SIM " + (i3 + 1));
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(setting);
        if (i < 0) {
            throw new InvalidSubscriptionId("Invalid SIM Slot : " + i);
        }
        zContains = SetsKt.setOf((Object[]) new String[]{SmsSender.HYBRID_CONNECT, SmsSender.SITELINK}).contains(str);
        if (zContains) {
            return Unit.INSTANCE;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        SettingsRepository settingsRepository = this.settingsRepository;
        AppSetting appSetting = AppSetting.RECEIVE_PAYMENTS_VIA_SIM_1;
        c06871.L$0 = SpillingKt.nullOutSpilledVariable(str);
        c06871.L$1 = linkedHashSet;
        c06871.I$0 = i;
        c06871.Z$0 = zContains;
        c06871.label = 1;
        Object setting2 = settingsRepository.getSetting(appSetting, c06871);
        if (setting2 != coroutine_suspended) {
            i2 = i;
            set = linkedHashSet;
            obj = setting2;
            str2 = str;
        }
        return coroutine_suspended;
        if (Boolean.parseBoolean((String) obj)) {
            set.add(Boxing.boxInt(0));
        }
        SettingsRepository settingsRepository2 = this.settingsRepository;
        AppSetting appSetting2 = AppSetting.RECEIVE_PAYMENTS_VIA_SIM_2;
        c06871.L$0 = SpillingKt.nullOutSpilledVariable(str2);
        c06871.L$1 = set;
        c06871.I$0 = i2;
        c06871.Z$0 = zContains;
        c06871.label = 2;
        setting = settingsRepository2.getSetting(appSetting2, c06871);
        if (setting != coroutine_suspended) {
            i3 = i2;
            if (Boolean.parseBoolean((String) setting)) {
                set.add(Boxing.boxInt(1));
            }
            if (set.contains(Boxing.boxInt(i3))) {
                throw new Exception("Not allowed to process messages from SIM " + (i3 + 1));
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
