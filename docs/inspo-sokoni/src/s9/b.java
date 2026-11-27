package s9;

import android.content.Context;
import fb.i;
import fb.j;

/* JADX INFO: loaded from: classes.dex */
public class b implements j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15655a;

    public b(Context context) {
        this.f15655a = context;
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        d dVar2;
        String str = iVar.f8284a;
        str.hashCode();
        switch (str) {
            case "getSent":
                dVar2 = d.Sent;
                break;
            case "getDraft":
                dVar2 = d.Draft;
                break;
            case "getInbox":
                dVar2 = d.Inbox;
                break;
            default:
                dVar.c();
                return;
        }
        new c(this.f15655a, dVar, dVar2, iVar.c("start") ? ((Integer) iVar.a("start")).intValue() : 0, iVar.c("count") ? ((Integer) iVar.a("count")).intValue() : -1, iVar.c("thread_id") ? ((Integer) iVar.a("thread_id")).intValue() : -1, iVar.c("address") ? (String) iVar.a("address") : null).a();
    }
}
