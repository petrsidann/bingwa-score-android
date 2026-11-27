package u4;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ke implements b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ve f16467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ge f16468c;

    public ke(ge geVar, String str, ve veVar) {
        this.f16466a = str;
        this.f16467b = veVar;
        this.f16468c = geVar;
    }

    @Override // u4.b6
    public final void a(String str, int i10, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.f16468c.t(this.f16466a, i10, th, bArr, this.f16467b);
    }
}
