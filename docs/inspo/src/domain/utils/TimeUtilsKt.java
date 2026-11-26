package com.example.bingwahybrid.domain.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u001a\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u001a\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u001a\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u001a\u0006\u0010\u000b\u001a\u00020\u0003\u001a\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e\u001a\u000e\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0003¨\u0006\u0011"}, d2 = {"formatTimeAgo", "", "timeInMillis", "", "now", "formatDateTime", "todayRange", "Lkotlin/Pair;", "last7DaysRange", "last30DaysRange", "yesterdayRange", "getNextMidnightPlusOneMinute", "getTimeAfterMinutes", "minutes", "", "formatDurationMillis", "durationMillis", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TimeUtilsKt {
    public static final String formatTimeAgo(long j, long j2) {
        long j3 = j2 - j;
        if (j3 < TimeUnit.MINUTES.toMillis(1L)) {
            return "Just now";
        }
        if (j3 < TimeUnit.HOURS.toMillis(1L)) {
            return TimeUnit.MILLISECONDS.toMinutes(j3) + "min ago";
        }
        if (j3 < TimeUnit.DAYS.toMillis(1L)) {
            return TimeUnit.MILLISECONDS.toHours(j3) + "h " + (TimeUnit.MILLISECONDS.toMinutes(j3) % ((long) 60)) + "min ago";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        calendar.add(6, -1);
        int i = calendar.get(6);
        calendar.setTimeInMillis(j);
        if (calendar.get(6) == i) {
            return "Yesterday, " + new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j));
        }
        String str = new SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault()).format(new Date(j));
        Intrinsics.checkNotNull(str);
        return str;
    }

    public static final String formatDateTime(long j) {
        String str = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(new Date(j));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final Pair<Long, Long> todayRange() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.add(5, 1);
        return TuplesKt.to(Long.valueOf(timeInMillis), Long.valueOf(calendar.getTimeInMillis() - 1));
    }

    public static final Pair<Long, Long> last7DaysRange() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -7);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return TuplesKt.to(Long.valueOf(calendar.getTimeInMillis()), Long.valueOf(Calendar.getInstance().getTimeInMillis()));
    }

    public static final Pair<Long, Long> last30DaysRange() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -30);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return TuplesKt.to(Long.valueOf(calendar.getTimeInMillis()), Long.valueOf(Calendar.getInstance().getTimeInMillis()));
    }

    public static final Pair<Long, Long> yesterdayRange() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -1);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return TuplesKt.to(Long.valueOf(timeInMillis), Long.valueOf(calendar.getTimeInMillis()));
    }

    public static final long getNextMidnightPlusOneMinute() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 1);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static final long getTimeAfterMinutes(int i) {
        return System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(i);
    }

    public static final String formatDurationMillis(long j) {
        long j2 = j / ((long) 60000);
        long j3 = 60;
        long j4 = j2 / j3;
        long j5 = j2 % j3;
        if (j4 > 0 && j5 > 0) {
            return j4 + " hour" + (j4 > 1 ? "s" : "") + " and " + j5 + " minute" + (j5 <= 1 ? "" : "s");
        }
        if (j4 > 0) {
            return j4 + " hour" + (j4 <= 1 ? "" : "s");
        }
        if (j5 > 0) {
            return j5 + " minute" + (j5 <= 1 ? "" : "s");
        }
        return "less than a minute";
    }
}
