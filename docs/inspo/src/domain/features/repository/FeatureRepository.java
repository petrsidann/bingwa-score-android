package com.example.bingwahybrid.domain.features.repository;

import com.example.bingwahybrid.domain.features.model.Feature;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: FeatureRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/features/repository/FeatureRepository;", "", "fetchAllFeatures", "", "Lcom/example/bingwahybrid/domain/features/model/Feature;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchFeatureByCode", "code", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeatureByCode", "saveFeatures", "", "features", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FeatureRepository {
    Object fetchAllFeatures(Continuation<? super List<Feature>> continuation);

    Object fetchFeatureByCode(String str, Continuation<? super Feature> continuation);

    Feature getFeatureByCode(String code);

    Object saveFeatures(List<Feature> list, Continuation<? super Unit> continuation);
}
