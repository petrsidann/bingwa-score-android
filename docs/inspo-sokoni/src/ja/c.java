package ja;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11329b;

    public c(boolean z10, String str) {
        this.f11328a = z10;
        this.f11329b = str;
    }

    public final HashMap<String, Object> a() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("isSuccess", Boolean.valueOf(this.f11328a));
        map.put("errorMessage", this.f11329b);
        return map;
    }
}
