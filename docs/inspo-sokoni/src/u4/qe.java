package u4;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class qe implements cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ge f16752a;

    public qe(ge geVar) {
        this.f16752a = geVar;
    }

    @Override // u4.cf
    public final void a(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f16752a.zzl().y(new pe(this, str, str2, bundle));
        } else if (this.f16752a.f16239l != null) {
            this.f16752a.f16239l.zzj().C().b("AppId not known when logging event", str2);
        }
    }
}
