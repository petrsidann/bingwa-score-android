package vc;

import ed.t;
import java.io.File;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public class g extends f {
    public static final String c(File file) {
        k.e(file, "<this>");
        String name = file.getName();
        k.d(name, "getName(...)");
        return t.i0(name, '.', "");
    }
}
