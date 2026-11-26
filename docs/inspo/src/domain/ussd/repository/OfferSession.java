package com.example.bingwahybrid.domain.ussd.repository;

import com.example.bingwahybrid.domain.offers.model.VerifiedOfferStep;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: OfferSession.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u0003H&¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/ussd/repository/OfferSession;", "", "start", "", "steps", "", "Lcom/example/bingwahybrid/domain/offers/model/VerifiedOfferStep;", "currentStep", "moveToNextStep", "incrementPagination", "resetPagination", "currentPagination", "", "isComplete", "", "isActive", "clear", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OfferSession {
    void clear();

    /* JADX INFO: renamed from: currentPagination */
    int getPaginationCount();

    VerifiedOfferStep currentStep();

    void incrementPagination();

    boolean isActive();

    boolean isComplete();

    void moveToNextStep();

    void resetPagination();

    void start(List<VerifiedOfferStep> steps);
}
