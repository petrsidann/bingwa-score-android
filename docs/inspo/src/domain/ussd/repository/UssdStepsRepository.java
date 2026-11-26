package com.example.bingwahybrid.domain.ussd.repository;

import java.util.List;
import java.util.Queue;
import kotlin.Metadata;

/* JADX INFO: compiled from: UssdStepsRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0006H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/ussd/repository/UssdStepsRepository;", "", "getSteps", "Ljava/util/Queue;", "", "addSteps", "", "steps", "", "pollStep", "isEmpty", "", "clearSteps", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface UssdStepsRepository {
    void addSteps(List<String> steps);

    void clearSteps();

    Queue<String> getSteps();

    boolean isEmpty();

    String pollStep();
}
