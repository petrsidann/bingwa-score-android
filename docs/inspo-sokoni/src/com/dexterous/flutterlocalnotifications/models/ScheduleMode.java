package com.dexterous.flutterlocalnotifications.models;

import androidx.annotation.Keep;
import e9.i;
import e9.j;
import e9.k;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
@Keep
public enum ScheduleMode {
    alarmClock,
    exact,
    exactAllowWhileIdle,
    inexact,
    inexactAllowWhileIdle;

    public static class a implements j<ScheduleMode> {
        @Override // e9.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScheduleMode a(k kVar, Type type, i iVar) {
            try {
                return ScheduleMode.valueOf(kVar.k());
            } catch (Exception unused) {
                return kVar.e() ? ScheduleMode.exactAllowWhileIdle : ScheduleMode.exact;
            }
        }
    }

    public boolean useAlarmClock() {
        return this == alarmClock;
    }

    public boolean useAllowWhileIdle() {
        return this == exactAllowWhileIdle || this == inexactAllowWhileIdle;
    }

    public boolean useExactAlarm() {
        return this == exact || this == exactAllowWhileIdle;
    }
}
