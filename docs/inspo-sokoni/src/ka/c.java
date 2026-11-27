package ka;

import android.content.Intent;
import fb.l;
import kotlin.jvm.internal.k;
import lc.q;

/* JADX INFO: loaded from: classes.dex */
public final class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xc.l<Object, q> f11934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xc.q<String, String, Object, q> f11935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11936c;

    /* JADX WARN: Multi-variable type inference failed */
    public c(xc.l<Object, q> onSuccess, xc.q<? super String, ? super String, Object, q> onError) {
        k.e(onSuccess, "onSuccess");
        k.e(onError, "onError");
        this.f11934a = onSuccess;
        this.f11935b = onError;
    }

    @Override // fb.l
    public boolean onActivityResult(int i10, int i11, Intent intent) {
        try {
            if (!this.f11936c && i10 == 5672353) {
                this.f11936c = true;
                this.f11934a.invoke(Boolean.valueOf(i11 == -1));
                return true;
            }
            return false;
        } catch (Exception e10) {
            this.f11935b.e("flutter_background.PermissionHandler", "Error while waiting for user to disable battery optimizations", e10.getLocalizedMessage());
        }
    }
}
