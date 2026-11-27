package g;

import android.content.Context;
import android.content.Intent;
import bd.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import lc.i;
import lc.m;
import mc.d0;
import mc.e0;
import mc.w;

/* JADX INFO: loaded from: classes.dex */
public final class b extends g.a<String[], Map<String, Boolean>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8423a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final Intent a(String[] input) {
            k.e(input, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
            k.d(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }
    }

    @Override // g.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] input) {
        k.e(context, "context");
        k.e(input, "input");
        return f8423a.a(input);
    }

    @Override // g.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public g.a.C0146a<Map<String, Boolean>> b(Context context, String[] input) {
        k.e(context, "context");
        k.e(input, "input");
        boolean z10 = true;
        if (input.length == 0) {
            return new g.a.C0146a<>(e0.d());
        }
        for (String str : input) {
            if (!(f0.a.checkSelfPermission(context, str) == 0)) {
                z10 = false;
                break;
            }
        }
        if (!z10) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.a(d0.a(input.length), 16));
        for (String str2 : input) {
            i iVarA = m.a(str2, Boolean.TRUE);
            linkedHashMap.put(iVarA.c(), iVarA.d());
        }
        return new g.a.C0146a<>(linkedHashMap);
    }

    @Override // g.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Boolean> c(int i10, Intent intent) {
        if (i10 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return e0.d();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i11 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i11 == 0));
            }
            return e0.k(w.R(mc.k.l(stringArrayExtra), arrayList));
        }
        return e0.d();
    }
}
