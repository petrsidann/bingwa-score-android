package e7;

/* JADX INFO: loaded from: classes.dex */
public enum z implements com.google.crypto.tink.shaded.protobuf.b0.c {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.google.crypto.tink.shaded.protobuf.b0.d<z> f7086l = new com.google.crypto.tink.shaded.protobuf.b0.d<z>() { // from class: e7.z.a
        @Override // com.google.crypto.tink.shaded.protobuf.b0.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public z a(int i10) {
            return z.d(i10);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7088a;

    z(int i10) {
        this.f7088a = i10;
    }

    public static z d(int i10) {
        if (i10 == 0) {
            return UNKNOWN_STATUS;
        }
        if (i10 == 1) {
            return ENABLED;
        }
        if (i10 == 2) {
            return DISABLED;
        }
        if (i10 != 3) {
            return null;
        }
        return DESTROYED;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0.c
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f7088a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
