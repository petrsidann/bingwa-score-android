package ge;

import android.content.Intent;
import fe.g;
import java.util.Calendar;
import java.util.Map;
import je.d;
import zd.k;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public String f9278d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public String f9279e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f9280f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public k f9281g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public k f9282h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public Calendar f9283i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public Calendar f9284j0;

    public a() {
        this.f9280f0 = true;
    }

    public a(g gVar, Intent intent) {
        super(gVar, intent);
        this.f9280f0 = true;
        this.f9280f0 = this.D.booleanValue();
    }

    @Override // ge.b, fe.g, fe.a
    public String N() {
        return M();
    }

    @Override // ge.b, fe.g, fe.a
    public Map<String, Object> O() {
        Map<String, Object> mapO = super.O();
        D("actionLifeCycle", mapO, this.f9281g0);
        D("dismissedLifeCycle", mapO, this.f9282h0);
        D("buttonKeyPressed", mapO, this.f9278d0);
        D("buttonKeyInput", mapO, this.f9279e0);
        E("actionDate", mapO, this.f9283i0);
        E("dismissedDate", mapO, this.f9284j0);
        return mapO;
    }

    @Override // ge.b
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public a a(String str) {
        return (a) super.L(str);
    }

    @Override // ge.b
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public a b(Map<String, Object> map) {
        super.b(map);
        this.f9278d0 = h(map, "buttonKeyPressed", String.class, null);
        this.f9279e0 = h(map, "buttonKeyInput", String.class, null);
        this.f9283i0 = i(map, "actionDate", Calendar.class, null);
        this.f9284j0 = i(map, "dismissedDate", Calendar.class, null);
        this.f9281g0 = u(map, "actionLifeCycle", k.class, null);
        this.f9282h0 = u(map, "dismissedLifeCycle", k.class, null);
        return this;
    }

    public void e0(k kVar) {
        d dVarG = d.g();
        try {
            this.f9282h0 = kVar;
            this.f9284j0 = dVarG.f(dVarG.k());
        } catch (ae.a e10) {
            e10.printStackTrace();
        }
    }

    public void f0(k kVar) {
        d dVarG = d.g();
        try {
            this.f9281g0 = kVar;
            this.f9283i0 = dVarG.f(dVarG.k());
        } catch (ae.a e10) {
            e10.printStackTrace();
        }
    }
}
