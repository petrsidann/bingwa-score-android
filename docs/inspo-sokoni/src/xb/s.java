package xb;

/* JADX INFO: loaded from: classes2.dex */
public interface s extends q2 {

    public enum a {
        PROCESSED,
        REFUSED,
        DROPPED,
        MISCARRIED
    }

    void c(vb.l1 l1Var, a aVar, vb.a1 a1Var);

    void d(vb.a1 a1Var);
}
