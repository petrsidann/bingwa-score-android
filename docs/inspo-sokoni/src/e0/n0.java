package e0;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f6828a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f6829b = new Object();

    public static Bundle a(q.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = aVar.d();
        bundle.putInt("icon", iconCompatD != null ? iconCompatD.m() : 0);
        bundle.putCharSequence("title", aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    public static Bundle b(h1 h1Var) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", h1Var.i());
        bundle.putCharSequence("label", h1Var.h());
        bundle.putCharSequenceArray("choices", h1Var.e());
        bundle.putBoolean("allowFreeFormInput", h1Var.c());
        bundle.putBundle("extras", h1Var.g());
        Set<String> setD = h1Var.d();
        if (setD != null && !setD.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setD.size());
            Iterator<String> it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static Bundle[] c(h1[] h1VarArr) {
        if (h1VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[h1VarArr.length];
        for (int i10 = 0; i10 < h1VarArr.length; i10++) {
            bundleArr[i10] = b(h1VarArr[i10]);
        }
        return bundleArr;
    }
}
