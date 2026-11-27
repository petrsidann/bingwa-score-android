package s3;

import android.os.Bundle;
import com.google.android.gms.common.internal.p;

/* JADX INFO: loaded from: classes.dex */
public final class c implements com.google.android.gms.common.api.a.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f15452b = new c(new Bundle(), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f15453a;

    public /* synthetic */ c(Bundle bundle, g gVar) {
        this.f15453a = bundle;
    }

    public final Bundle a() {
        return new Bundle(this.f15453a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return p.a(this.f15453a, ((c) obj).f15453a);
        }
        return false;
    }

    public final int hashCode() {
        return p.c(this.f15453a);
    }
}
