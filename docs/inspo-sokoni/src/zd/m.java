package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum m implements p {
    unknown("unknown", -1),
    none("none", 0),
    stopped("stopped", 1),
    paused("paused", 2),
    playing("playing", 3),
    forwarding("forwarding", 4),
    rewinding("rewinding", 5),
    buffering("buffering", 6),
    error("error", 7),
    connecting("connecting", 8),
    previous("previous", 9),
    next("next", 10),
    skippingToQueueItem("skippingToQueueItem", 11);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20653b;

    m(String str, int i10) {
        this.f20652a = str;
        this.f20653b = i10;
    }

    public static m i(Object obj) {
        int i10 = 0;
        if (obj instanceof String) {
            String str = (String) obj;
            m[] mVarArrValues = values();
            int length = mVarArrValues.length;
            while (i10 < length) {
                m mVar = mVarArrValues[i10];
                if (mVar.f20652a.equalsIgnoreCase(str)) {
                    return mVar;
                }
                i10++;
            }
            return null;
        }
        if (!(obj instanceof Number)) {
            return null;
        }
        int iIntValue = ((Number) obj).intValue();
        m[] mVarArrValues2 = values();
        int length2 = mVarArrValues2.length;
        while (i10 < length2) {
            m mVar2 = mVarArrValues2[i10];
            if (mVar2.f20653b == iIntValue) {
                return mVar2;
            }
            i10++;
        }
        return null;
    }

    @Override // zd.p
    public String h() {
        return this.f20652a;
    }
}
