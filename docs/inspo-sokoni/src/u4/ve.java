package u4;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzgf;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zzgf.zzj f16917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f16919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public fb f16920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f16921f;

    public ve(long j10, zzgf.zzj zzjVar, String str, Map<String, String> map, fb fbVar, long j11, long j12) {
        this.f16916a = j10;
        this.f16917b = zzjVar;
        this.f16918c = str;
        this.f16919d = map;
        this.f16920e = fbVar;
        this.f16921f = j12;
    }

    public final long a() {
        return this.f16916a;
    }

    public final zd b() {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : this.f16919d.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return new zd(this.f16916a, this.f16917b.zzce(), this.f16918c, bundle, this.f16920e.zza(), this.f16921f);
    }

    public final he c() {
        return new he(this.f16918c, this.f16919d, this.f16920e);
    }

    public final zzgf.zzj d() {
        return this.f16917b;
    }

    public final String e() {
        return this.f16918c;
    }
}
