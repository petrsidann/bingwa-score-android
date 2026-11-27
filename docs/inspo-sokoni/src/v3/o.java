package v3;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class o implements com.google.android.gms.common.api.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17184a;

    public o(String str) {
        this.f17184a = str;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("session_id", this.f17184a);
        return bundle;
    }

    public final String b() {
        return this.f17184a;
    }

    public final boolean equals(Object obj) {
        return obj instanceof o;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.c(o.class);
    }
}
