package com.example.bingwahybrid.domain.offers.model;

import com.example.bingwahybrid.domain.offers.enums.OfferType;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: compiled from: Offer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"supportsStrictMode", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OfferKt {
    public static final boolean supportsStrictMode(Offer offer) {
        Intrinsics.checkNotNullParameter(offer, "<this>");
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.removeSuffix(StringsKt.removePrefix(StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim((CharSequence) offer.getUssdCode()).toString(), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null), (CharSequence) Marker.ANY_MARKER), (CharSequence) "#"), new String[]{Marker.ANY_MARKER}, false, 0, 6, (Object) null);
        if (offer.getType() == OfferType.DATA) {
            List<Pair> listZipWithNext = CollectionsKt.zipWithNext(listSplit$default);
            if (!(listZipWithNext instanceof Collection) || !listZipWithNext.isEmpty()) {
                for (Pair pair : listZipWithNext) {
                    String str = (String) pair.component1();
                    String str2 = (String) pair.component2();
                    if (Intrinsics.areEqual(str, "180") && Intrinsics.areEqual(str2, "5")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
