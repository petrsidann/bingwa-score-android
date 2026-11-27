package e7;

/* JADX INFO: loaded from: classes.dex */
public enum u implements com.google.crypto.tink.shaded.protobuf.b0.c {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    SHA224(5),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.google.crypto.tink.shaded.protobuf.b0.d<u> f7065n = new com.google.crypto.tink.shaded.protobuf.b0.d<u>() { // from class: e7.u.a
        @Override // com.google.crypto.tink.shaded.protobuf.b0.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public u a(int i10) {
            return u.d(i10);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7067a;

    u(int i10) {
        this.f7067a = i10;
    }

    public static u d(int i10) {
        if (i10 == 0) {
            return UNKNOWN_HASH;
        }
        if (i10 == 1) {
            return SHA1;
        }
        if (i10 == 2) {
            return SHA384;
        }
        if (i10 == 3) {
            return SHA256;
        }
        if (i10 == 4) {
            return SHA512;
        }
        if (i10 != 5) {
            return null;
        }
        return SHA224;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b0.c
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f7067a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
