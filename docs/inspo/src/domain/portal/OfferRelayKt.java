package com.example.bingwahybrid.domain.portal;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfferRelay.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a,\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0006\b\u0000\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0086\b¢\u0006\u0002\u0010\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TAG", "", "getOrNull", ExifInterface.GPS_DIRECTION_TRUE, "", "", FirebaseAnalytics.Param.INDEX, "", "(Ljava/util/List;I)Ljava/lang/Object;", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OfferRelayKt {
    private static final String TAG = "OfferSocketHandler";

    public static /* synthetic */ Object getOrNull$default(List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() <= i) {
            return null;
        }
        Object obj2 = list.get(i);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (!(obj2 instanceof Object)) {
            return null;
        }
        Object obj3 = list.get(i);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return obj3;
    }

    public static final /* synthetic */ <T> T getOrNull(List<? extends Object> list, int i) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() <= i) {
            return null;
        }
        Object obj = list.get(i);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (!(obj instanceof Object)) {
            return null;
        }
        T t = (T) list.get(i);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }
}
