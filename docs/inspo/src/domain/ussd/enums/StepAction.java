package com.example.bingwahybrid.domain.ussd.enums;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StepAction.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\b\tB\u0013\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/ussd/enums/StepAction;", "", FirebaseAnalytics.Param.INDEX, "", "<init>", "(Ljava/lang/String;)V", "getIndex", "()Ljava/lang/String;", "TargetFound", "More", "Lcom/example/bingwahybrid/domain/ussd/enums/StepAction$More;", "Lcom/example/bingwahybrid/domain/ussd/enums/StepAction$TargetFound;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class StepAction {
    public static final int $stable = 0;
    private final String index;

    public /* synthetic */ StepAction(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* JADX INFO: compiled from: StepAction.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/example/bingwahybrid/domain/ussd/enums/StepAction$TargetFound;", "Lcom/example/bingwahybrid/domain/ussd/enums/StepAction;", FirebaseAnalytics.Param.INDEX, "", "<init>", "(Ljava/lang/String;)V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TargetFound extends StepAction {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TargetFound(String index) {
            super(index, null);
            Intrinsics.checkNotNullParameter(index, "index");
        }
    }

    private StepAction(String str) {
        this.index = str;
    }

    public final String getIndex() {
        return this.index;
    }

    /* JADX INFO: compiled from: StepAction.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/example/bingwahybrid/domain/ussd/enums/StepAction$More;", "Lcom/example/bingwahybrid/domain/ussd/enums/StepAction;", FirebaseAnalytics.Param.INDEX, "", "<init>", "(Ljava/lang/String;)V", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class More extends StepAction {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public More(String index) {
            super(index, null);
            Intrinsics.checkNotNullParameter(index, "index");
        }
    }
}
