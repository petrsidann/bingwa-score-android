package u4;

/* JADX INFO: loaded from: classes.dex */
public enum v8 {
    UNINITIALIZED("uninitialized"),
    POLICY("eu_consent_policy"),
    DENIED("denied"),
    GRANTED("granted");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16907a;

    v8(String str) {
        this.f16907a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f16907a;
    }
}
