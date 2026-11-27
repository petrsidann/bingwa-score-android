package u4;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class le implements b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f16499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ge f16500c;

    public le(ge geVar, String str, List list) {
        this.f16498a = str;
        this.f16499b = list;
        this.f16500c = geVar;
    }

    @Override // u4.b6
    public final void a(String str, int i10, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.f16500c.N(true, i10, th, bArr, this.f16498a, this.f16499b);
    }
}
