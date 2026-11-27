package z5;

/* JADX INFO: loaded from: classes.dex */
public class j extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f20228a = -1.0f;

    @Override // z5.d
    public void a(m mVar, float f10, float f11, float f12) {
        mVar.o(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        float f13 = f12 * 2.0f * f11;
        mVar.a(0.0f, 0.0f, f13, f13, 180.0f, f10);
    }
}
