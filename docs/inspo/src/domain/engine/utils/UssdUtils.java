package com.example.bingwahybrid.domain.engine.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: compiled from: UssdUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/utils/UssdUtils;", "", "<init>", "()V", "Companion", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UssdUtils {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex SUCCESS_REGEX = new Regex("(?i)\\b(Kindly wait as we process your request|Kindly wait while we process your request|You have successfully purchased|You have transferred \\d+\\.\\d{2} KSH from your account to|You have transferred \\d+ Bonga Points to|Airtime Bal\\s*:|Tafadhali subiri tunaposhughulikia ombi lako|Message Sent|Message has been sent successfully|Umetuma shilingi \\d+\\.\\d{2}|Recommendation for \\d{10,13} submitted successfully).*");

    /* JADX INFO: compiled from: UssdUtils.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/utils/UssdUtils$Companion;", "", "<init>", "()V", "SUCCESS_REGEX", "Lkotlin/text/Regex;", "isSuccessfulResponse", "", "response", "", "isInsufficientAirtimeResponse", "responseMessage", "extractSteps", "", "ussdCode", "formatFirstStep", "step", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isSuccessfulResponse(String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            return UssdUtils.SUCCESS_REGEX.containsMatchIn(response);
        }

        public final boolean isInsufficientAirtimeResponse(String responseMessage) {
            Intrinsics.checkNotNullParameter(responseMessage, "responseMessage");
            return StringsKt.contains((CharSequence) responseMessage, (CharSequence) "do not have sufficient airtime", true);
        }

        public final List<String> extractSteps(String ussdCode) {
            String value;
            String value2;
            Intrinsics.checkNotNullParameter(ussdCode, "ussdCode");
            ArrayList arrayList = new ArrayList();
            MatchResult matchResultMatchEntire = new Regex("^\\[\\*?([^]]+)](.*)").matchEntire(ussdCode);
            if (matchResultMatchEntire != null) {
                MatchGroup matchGroup = matchResultMatchEntire.getGroups().get(1);
                String str = "";
                if (matchGroup == null || (value = matchGroup.getValue()) == null) {
                    value = "";
                }
                MatchGroup matchGroup2 = matchResultMatchEntire.getGroups().get(2);
                if (matchGroup2 != null && (value2 = matchGroup2.getValue()) != null) {
                    str = value2;
                }
                arrayList.add(Marker.ANY_MARKER + value + "#");
                if (str.length() > 0) {
                    List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.trimEnd(str, '#'), new String[]{Marker.ANY_MARKER}, false, 0, 6, (Object) null);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : listSplit$default) {
                        if (((String) obj).length() > 0) {
                            arrayList2.add(obj);
                        }
                    }
                    arrayList.addAll(arrayList2);
                }
                return arrayList;
            }
            List listSplit$default2 = StringsKt.split$default((CharSequence) StringsKt.trimEnd(ussdCode, '#'), new String[]{Marker.ANY_MARKER}, false, 0, 6, (Object) null);
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : listSplit$default2) {
                if (((String) obj2).length() > 0) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            if (!arrayList4.isEmpty()) {
                arrayList.add(Marker.ANY_MARKER + CollectionsKt.first((List) arrayList4) + "#");
                arrayList.addAll(CollectionsKt.drop(arrayList4, 1));
            }
            return arrayList;
        }

        public final String formatFirstStep(String step) {
            Intrinsics.checkNotNullParameter(step, "step");
            if (StringsKt.startsWith$default(step, Marker.ANY_MARKER, false, 2, (Object) null) && StringsKt.endsWith$default(step, "#", false, 2, (Object) null)) {
                return step;
            }
            if (StringsKt.startsWith$default(step, Marker.ANY_MARKER, false, 2, (Object) null)) {
                return step + "#";
            }
            if (StringsKt.endsWith$default(step, "#", false, 2, (Object) null)) {
                return Marker.ANY_MARKER + step;
            }
            return Marker.ANY_MARKER + step + "#";
        }
    }
}
