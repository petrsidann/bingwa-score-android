package ra;

import android.view.KeyEvent;

/* JADX INFO: loaded from: classes.dex */
public class t implements z.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final eb.e f15291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z.b f15292b = new z.b();

    public t(eb.e eVar) {
        this.f15291a = eVar;
    }

    @Override // ra.z.d
    public void a(KeyEvent keyEvent, final z.d.a aVar) {
        int action = keyEvent.getAction();
        if (action == 0 || action == 1) {
            this.f15291a.e(new eb.e.b(keyEvent, this.f15292b.a(keyEvent.getUnicodeChar())), action != 0, new eb.e.a() { // from class: ra.s
                @Override // eb.e.a
                public final void a(boolean z10) {
                    aVar.a(z10);
                }
            });
        } else {
            aVar.a(false);
        }
    }
}
