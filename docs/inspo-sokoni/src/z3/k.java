package z3;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class k extends n {
    public k(com.google.android.gms.common.api.f fVar) {
        super(fVar);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.api.k createFailedResult(Status status) {
        return status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.d
    public final /* bridge */ /* synthetic */ void doExecute(com.google.android.gms.common.api.a.b bVar) {
        i iVar = (i) bVar;
        ((u) iVar.getService()).f(new j(this), iVar.c());
    }
}
