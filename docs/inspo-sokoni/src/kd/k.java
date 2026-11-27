package kd;

/* JADX INFO: loaded from: classes2.dex */
public interface k<T> extends jd.d<T> {

    public static final class a {
        public static /* synthetic */ jd.d a(k kVar, oc.i iVar, int i10, id.a aVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i11 & 1) != 0) {
                iVar = oc.j.f13812a;
            }
            if ((i11 & 2) != 0) {
                i10 = -3;
            }
            if ((i11 & 4) != 0) {
                aVar = id.a.SUSPEND;
            }
            return kVar.c(iVar, i10, aVar);
        }
    }

    jd.d<T> c(oc.i iVar, int i10, id.a aVar);
}
