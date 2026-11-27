package u4;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c7 implements zzo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u6 f16067b;

    public c7(u6 u6Var, String str) {
        this.f16066a = str;
        this.f16067b = u6Var;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map = (Map) this.f16067b.f16845d.get(this.f16066a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
