package yb;

import java.util.List;
import java.util.logging.Logger;
import vb.a1;
import vb.o0;
import xb.s2;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f19653a = Logger.getLogger(s.class.getName());

    public static a1 a(List<ac.d> list) {
        return o0.c(b(list));
    }

    public static byte[][] b(List<ac.d> list) {
        byte[][] bArr = new byte[list.size() * 2][];
        int i10 = 0;
        for (ac.d dVar : list) {
            int i11 = i10 + 1;
            bArr[i10] = dVar.f452a.B();
            i10 = i11 + 1;
            bArr[i11] = dVar.f453b.B();
        }
        return s2.e(bArr);
    }

    public static a1 c(List<ac.d> list) {
        return o0.c(b(list));
    }
}
