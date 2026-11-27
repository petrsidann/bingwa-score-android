package fe;

import android.content.Context;
import java.util.Calendar;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class i extends m {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f8399p;

    @Override // fe.a
    public String N() {
        return M();
    }

    @Override // fe.m, fe.a
    public Map<String, Object> O() {
        Map<String, Object> mapO = super.O();
        D("interval", mapO, this.f8399p);
        return mapO;
    }

    @Override // fe.a
    public void P(Context context) throws ae.a {
        Integer num = this.f8399p;
        if (num == null || num.intValue() < 5) {
            throw ae.b.e().c("NotificationIntervalModel", "INVALID_ARGUMENTS", "Interval is required and must be greater than 5", "arguments.invalid.notificationInterval.interval");
        }
        if (this.f8418l.booleanValue() && this.f8399p.intValue() < 60) {
            throw ae.b.e().c("NotificationIntervalModel", "INVALID_ARGUMENTS", "time interval must be at least 60 if repeating", "arguments.invalid.notificationInterval.interval");
        }
    }

    @Override // fe.m
    public Calendar R(Calendar calendar) {
        Calendar calendar2;
        je.d dVarG = je.d.g();
        je.c cVarA = je.c.a();
        if (calendar == null) {
            calendar = dVarG.f(this.f8416e);
        }
        Calendar calendar3 = this.f8417f;
        if (calendar3 == null) {
            calendar3 = calendar;
        }
        if (cVarA.c(this.f8418l, Boolean.FALSE)) {
            Long lValueOf = Long.valueOf((Math.abs(Long.valueOf(calendar.getTimeInMillis()).longValue() - Long.valueOf(calendar3.getTimeInMillis()).longValue()) / 1000) % ((long) this.f8399p.intValue()));
            calendar2 = (Calendar) (calendar3.after(calendar) ? calendar3.clone() : calendar.clone());
            calendar2.add(13, this.f8399p.intValue() - lValueOf.intValue());
        } else {
            calendar2 = (Calendar) calendar3.clone();
            calendar2.add(13, this.f8399p.intValue());
        }
        if (calendar2.after(calendar) || calendar2.equals(calendar)) {
            return calendar2;
        }
        return null;
    }

    @Override // fe.a
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public i a(String str) {
        return (i) super.L(str);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public i b(Map<String, Object> map) {
        super.Q(map);
        this.f8399p = f(map, "interval", Integer.class, null);
        return this;
    }
}
