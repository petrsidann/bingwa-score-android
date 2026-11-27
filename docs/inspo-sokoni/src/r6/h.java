package r6;

import com.google.crypto.tink.shaded.protobuf.c0;
import com.google.crypto.tink.shaded.protobuf.s0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public class h<PrimitiveT, KeyProtoT extends s0> implements g<PrimitiveT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z6.d<KeyProtoT> f15028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<PrimitiveT> f15029b;

    public static class a<KeyFormatProtoT extends s0, KeyProtoT extends s0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z6.d.a<KeyFormatProtoT, KeyProtoT> f15030a;

        public a(z6.d.a<KeyFormatProtoT, KeyProtoT> aVar) {
            this.f15030a = aVar;
        }

        public KeyProtoT a(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return (KeyProtoT) b(this.f15030a.d(iVar));
        }

        public final KeyProtoT b(KeyFormatProtoT keyformatprotot) {
            this.f15030a.e(keyformatprotot);
            return (KeyProtoT) this.f15030a.a(keyformatprotot);
        }
    }

    public h(z6.d<KeyProtoT> dVar, Class<PrimitiveT> cls) {
        if (!dVar.i().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", dVar.toString(), cls.getName()));
        }
        this.f15028a = dVar;
        this.f15029b = cls;
    }

    @Override // r6.g
    public final s0 a(com.google.crypto.tink.shaded.protobuf.i iVar) throws GeneralSecurityException {
        try {
            return e().a(iVar);
        } catch (c0 e10) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.f15028a.f().b().getName(), e10);
        }
    }

    @Override // r6.g
    public final e7.y b(com.google.crypto.tink.shaded.protobuf.i iVar) throws GeneralSecurityException {
        try {
            return e7.y.U().y(c()).z(e().a(iVar).c()).x(this.f15028a.g()).build();
        } catch (c0 e10) {
            throw new GeneralSecurityException("Unexpected proto", e10);
        }
    }

    @Override // r6.g
    public final String c() {
        return this.f15028a.d();
    }

    @Override // r6.g
    public final PrimitiveT d(com.google.crypto.tink.shaded.protobuf.i iVar) throws GeneralSecurityException {
        try {
            return f(this.f15028a.h(iVar));
        } catch (c0 e10) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.f15028a.c().getName(), e10);
        }
    }

    public final a<?, KeyProtoT> e() {
        return new a<>(this.f15028a.f());
    }

    public final PrimitiveT f(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (Void.class.equals(this.f15029b)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.f15028a.j(keyprotot);
        return (PrimitiveT) this.f15028a.e(keyprotot, this.f15029b);
    }
}
