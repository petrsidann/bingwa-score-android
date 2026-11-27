package u4;

import com.google.android.gms.internal.measurement.zzgf;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class he {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f16322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fb f16323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzgf.zzo f16324d;

    public he(String str, Map<String, String> map, fb fbVar) {
        this(str, map, fbVar, null);
    }

    public he(String str, Map<String, String> map, fb fbVar, zzgf.zzo zzoVar) {
        this.f16321a = str;
        this.f16322b = map;
        this.f16323c = fbVar;
        this.f16324d = zzoVar;
    }

    public he(String str, fb fbVar) {
        this(str, Collections.emptyMap(), fbVar, null);
    }

    public final fb a() {
        return this.f16323c;
    }

    public final zzgf.zzo b() {
        return this.f16324d;
    }

    public final String c() {
        return this.f16321a;
    }

    public final Map<String, String> d() {
        Map<String, String> map = this.f16322b;
        return map == null ? Collections.emptyMap() : map;
    }
}
