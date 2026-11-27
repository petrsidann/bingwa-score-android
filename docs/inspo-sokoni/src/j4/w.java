package j4;

import android.os.StrictMode;

/* JADX INFO: loaded from: classes.dex */
public final class w {
    public static StrictMode.VmPolicy a() {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (m.i()) {
            StrictMode.setVmPolicy(v.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
        }
        return vmPolicy;
    }
}
