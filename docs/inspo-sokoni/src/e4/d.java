package e4;

import android.content.Context;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class d extends com.google.android.gms.common.api.e implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.g f6992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.AbstractC0072a f6993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f6994c;

    static {
        com.google.android.gms.common.api.a.g gVar = new com.google.android.gms.common.api.a.g();
        f6992a = gVar;
        c cVar = new c();
        f6993b = cVar;
        f6994c = new com.google.android.gms.common.api.a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, y yVar) {
        super(context, (com.google.android.gms.common.api.a<y>) f6994c, yVar, com.google.android.gms.common.api.e.a.f3671c);
    }

    @Override // com.google.android.gms.common.internal.x
    public final Task<Void> a(final v vVar) {
        com.google.android.gms.common.api.internal.v.a aVarA = com.google.android.gms.common.api.internal.v.a();
        aVarA.d(zaf.zaa);
        aVarA.c(false);
        aVarA.b(new r() { // from class: e4.b
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.r
            public final void accept(Object obj, Object obj2) {
                com.google.android.gms.common.api.a.g gVar = d.f6992a;
                ((a) ((e) obj).getService()).b(vVar);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        });
        return doBestEffortWrite(aVarA.a());
    }
}
