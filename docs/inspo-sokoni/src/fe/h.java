package fe;

import android.content.Context;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h extends m {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Calendar f8395p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Calendar f8396q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f8397r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<Calendar> f8398s;

    @Override // fe.a
    public String N() {
        return M();
    }

    @Override // fe.m, fe.a
    public Map<String, Object> O() {
        Map<String, Object> mapO = super.O();
        E("initialDateTime", mapO, this.f8395p);
        E("expirationDateTime", mapO, this.f8396q);
        D("crontabExpression", mapO, this.f8397r);
        F("preciseSchedules", mapO, this.f8398s);
        return mapO;
    }

    @Override // fe.a
    public void P(Context context) throws ae.a {
        Calendar calendar;
        if (this.f8328b.e(this.f8397r).booleanValue() && je.k.a(this.f8398s)) {
            throw ae.b.e().c("NotificationCrontabModel", "INVALID_ARGUMENTS", "At least one schedule parameter is required", "arguments.required");
        }
        try {
            Calendar calendar2 = this.f8395p;
            if (calendar2 != null && (calendar = this.f8396q) != null && (calendar2.equals(calendar) || this.f8395p.after(this.f8396q))) {
                throw ae.b.e().c("NotificationCrontabModel", "INVALID_ARGUMENTS", "Expiration date must be greater than initial date", "arguments.invalid.periodOrder");
            }
            String str = this.f8397r;
            if (str != null && !be.a.s(str)) {
                throw ae.b.e().c("NotificationCrontabModel", "INVALID_ARGUMENTS", "Schedule cron expression is invalid", "arguments.invalid.crontabExpression");
            }
        } catch (ae.a e10) {
            throw e10;
        } catch (Exception unused) {
            throw ae.b.e().c("NotificationCrontabModel", "INVALID_ARGUMENTS", "Schedule time is invalid", "arguments.invalid.scheduleTime");
        }
    }

    @Override // fe.m
    public Calendar R(Calendar calendar) throws ae.a {
        try {
            je.d dVarG = je.d.g();
            if (calendar == null) {
                calendar = dVarG.f(this.f8416e);
            }
            Calendar calendar2 = this.f8396q;
            Calendar calendarB = null;
            if ((calendar2 != null && calendar.after(calendar2)) || calendar.equals(this.f8396q)) {
                return null;
            }
            Calendar calendarX = !je.k.a(this.f8398s) ? X(calendar) : null;
            if (!this.f8328b.e(this.f8397r).booleanValue()) {
                Calendar calendar3 = this.f8395p;
                if (calendar3 != null) {
                    calendar = calendar3;
                }
                calendarB = je.f.b(calendar, this.f8397r, this.f8416e);
            }
            if (calendarX == null) {
                return calendarB;
            }
            return (calendarB == null || calendarX.before(calendarB)) ? calendarX : calendarB;
        } catch (ae.a e10) {
            throw e10;
        } catch (Exception unused) {
            throw ae.b.e().c("NotificationCrontabModel", "INVALID_ARGUMENTS", "Schedule time is invalid", "arguments.invalid.notificationCrontab");
        }
    }

    @Override // fe.a
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public d a(String str) {
        return (d) super.L(str);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public h b(Map<String, Object> map) {
        super.Q(map);
        this.f8395p = i(map, "initialDateTime", Calendar.class, null);
        this.f8396q = i(map, "expirationDateTime", Calendar.class, null);
        this.f8397r = h(map, "crontabExpression", String.class, null);
        this.f8398s = y(map, "preciseSchedules", null);
        return this;
    }

    public final Calendar X(Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(13, 1);
        calendar2.set(14, 0);
        Calendar calendar3 = null;
        for (Calendar calendar4 : this.f8398s) {
            Calendar calendar5 = this.f8395p;
            if (calendar5 == null || !calendar4.before(calendar5)) {
                if (!calendar4.before(calendar2) && (calendar3 == null || calendar4.before(calendar3))) {
                    calendar3 = calendar4;
                }
            }
        }
        return calendar3;
    }
}
