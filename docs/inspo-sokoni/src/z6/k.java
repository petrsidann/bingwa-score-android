package z6;

import com.google.crypto.tink.shaded.protobuf.s0;

/* JADX INFO: loaded from: classes.dex */
public abstract class k<PrimitiveT, KeyProtoT extends s0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<PrimitiveT> f20330a;

    public k(Class<PrimitiveT> cls) {
        this.f20330a = cls;
    }

    public abstract PrimitiveT a(KeyProtoT keyprotot);

    public final Class<PrimitiveT> b() {
        return this.f20330a;
    }
}
