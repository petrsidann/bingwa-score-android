package hd;

import android.os.Looper;
import gd.k2;
import java.util.List;
import ld.v;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements v {
    @Override // ld.v
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // ld.v
    public k2 b(List<? extends v> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new d(f.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // ld.v
    public int c() {
        return 1073741823;
    }
}
