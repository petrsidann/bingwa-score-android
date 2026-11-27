package eb;

import android.window.BackEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.j f7573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fb.j.c f7574b;

    public class a implements fb.j.c {
        public a() {
        }

        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            dVar.a(null);
        }
    }

    public b(ta.a aVar) {
        a aVar2 = new a();
        this.f7574b = aVar2;
        fb.j jVar = new fb.j(aVar, "flutter/backgesture", fb.q.f8299b);
        this.f7573a = jVar;
        jVar.e(aVar2);
    }

    public final Map<String, Object> a(BackEvent backEvent) {
        HashMap map = new HashMap(3);
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        map.put("touchOffset", (Float.isNaN(touchX) || Float.isNaN(touchY)) ? null : Arrays.asList(Float.valueOf(touchX), Float.valueOf(touchY)));
        map.put("progress", Float.valueOf(backEvent.getProgress()));
        map.put("swipeEdge", Integer.valueOf(backEvent.getSwipeEdge()));
        return map;
    }

    public void b() {
        qa.b.f("BackGestureChannel", "Sending message to cancel back gesture");
        this.f7573a.c("cancelBackGesture", null);
    }

    public void c() {
        qa.b.f("BackGestureChannel", "Sending message to commit back gesture");
        this.f7573a.c("commitBackGesture", null);
    }

    public void d(BackEvent backEvent) {
        qa.b.f("BackGestureChannel", "Sending message to start back gesture");
        this.f7573a.c("startBackGesture", a(backEvent));
    }

    public void e(BackEvent backEvent) {
        qa.b.f("BackGestureChannel", "Sending message to update back gesture progress");
        this.f7573a.c("updateBackGestureProgress", a(backEvent));
    }
}
