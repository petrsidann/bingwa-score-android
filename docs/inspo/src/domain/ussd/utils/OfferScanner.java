package com.example.bingwahybrid.domain.ussd.utils;

import com.example.bingwahybrid.domain.ussd.enums.StepAction;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OfferScanner.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/ussd/utils/OfferScanner;", "", "<init>", "()V", "indexRegex", "Lkotlin/text/Regex;", "moreRegex", "findAction", "Lcom/example/bingwahybrid/domain/ussd/enums/StepAction;", "screenText", "", "textRegex", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfferScanner {
    public static final int $stable = 8;
    private final Regex indexRegex = new Regex("([0-9#*]+)[\\s.:)]+(.*)", RegexOption.IGNORE_CASE);
    private final Regex moreRegex = new Regex("([0-9#*]+)\\s*[:.)]?\\s*(MORE|NEXT)", RegexOption.IGNORE_CASE);

    @Inject
    public OfferScanner() {
    }

    public final StepAction findAction(String screenText, String textRegex) {
        Intrinsics.checkNotNullParameter(screenText, "screenText");
        Intrinsics.checkNotNullParameter(textRegex, "textRegex");
        try {
            Regex regex = new Regex(textRegex, RegexOption.IGNORE_CASE);
            List<String> listLines = StringsKt.lines(screenText);
            Iterator<String> it = listLines.iterator();
            while (it.hasNext()) {
                MatchResult matchResultMatchEntire = this.indexRegex.matchEntire(StringsKt.trim((CharSequence) it.next()).toString());
                if (matchResultMatchEntire != null) {
                    MatchResult.Destructured destructured = matchResultMatchEntire.getDestructured();
                    String str = destructured.getMatch().getGroupValues().get(1);
                    if (regex.containsMatchIn(destructured.getMatch().getGroupValues().get(2))) {
                        return new StepAction.TargetFound(str);
                    }
                }
            }
            Iterator<String> it2 = listLines.iterator();
            while (it2.hasNext()) {
                Iterator it3 = Regex.findAll$default(this.moreRegex, it2.next(), 0, 2, null).iterator();
                if (it3.hasNext()) {
                    return new StepAction.More(((MatchResult) it3.next()).getDestructured().getMatch().getGroupValues().get(1));
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
