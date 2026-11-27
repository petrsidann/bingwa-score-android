package u4;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class oa implements cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e9 f16627a;

    public oa(e9 e9Var) {
        this.f16627a = e9Var;
    }

    @Override // u4.cf
    public final void a(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f16627a.S0("auto", str2, bundle);
        } else {
            this.f16627a.T("auto", str2, bundle, str);
        }
    }
}
