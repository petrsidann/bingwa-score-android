package a7;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class a extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g7.b f391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f392c;

    public a(c cVar, g7.b bVar, Integer num) {
        this.f390a = cVar;
        this.f391b = bVar;
        this.f392c = num;
    }

    public static a d(c cVar, g7.b bVar, Integer num) throws GeneralSecurityException {
        if (bVar.b() != 32) {
            throw new GeneralSecurityException("Invalid key size");
        }
        if (cVar.e() && num == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with format with ID requirement");
        }
        if (cVar.e() || num == null) {
            return new a(cVar, bVar, num);
        }
        throw new GeneralSecurityException("Cannot create key with ID requirement with format without ID requirement");
    }

    @Override // a7.k
    public g7.a b() {
        if (this.f390a.d() == c.a.f399e) {
            return g7.a.a(new byte[0]);
        }
        if (this.f390a.d() == c.a.f398d || this.f390a.d() == c.a.f397c) {
            return g7.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(this.f392c.intValue()).array());
        }
        if (this.f390a.d() == c.a.f396b) {
            return g7.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(this.f392c.intValue()).array());
        }
        throw new IllegalStateException("Unknown AesCmacParameters.Variant: " + this.f390a.d());
    }

    @Override // a7.k
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public c a() {
        return this.f390a;
    }
}
