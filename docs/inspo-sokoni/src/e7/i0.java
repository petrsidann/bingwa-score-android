package e7;

/* JADX INFO: loaded from: classes.dex */
public enum i0 implements com.google.crypto.tink.shaded.protobuf.b0.c {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.google.crypto.tink.shaded.protobuf.b0.d<i0> f7041m = new com.google.crypto.tink.shaded.protobuf.b0.d<i0>() { // from class: e7.i0.a
        @Override // com.google.crypto.tink.shaded.protobuf.b0.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i0 a(int i10) {
            return i0.d(i10);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7043a;

    i0(int i10) {
        this.f7043a = i10;
    }

    public static i0 d(int i10) {
        if (i10 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i10 == 1) {
            return TINK;
        }
        if (i10 == 2) {
            return LEGACY;
        }
        if (i10 == 3) {
            return RAW;
        }
        if (i10 != 4) {
            return null;
        }
        return CRUNCHY;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0.c
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f7043a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
