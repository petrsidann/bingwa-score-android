package ob;

import android.util.Log;
import com.google.firebase.firestore.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import mb.z;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static Map<String, String> a(Exception exc) {
        mb.a aVar;
        HashMap map = new HashMap();
        if (exc == null) {
            return map;
        }
        if (exc instanceof f) {
            aVar = new mb.a((f) exc, exc.getCause());
        } else if (exc.getCause() == null || !(exc.getCause() instanceof f)) {
            aVar = null;
        } else {
            aVar = new mb.a((f) exc.getCause(), exc.getCause().getCause() != null ? exc.getCause().getCause() : exc.getCause());
        }
        if (aVar != null) {
            map.put("code", aVar.a());
            map.put("message", aVar.getMessage());
        }
        if (map.containsKey("code")) {
            String str = (String) map.get("code");
            Objects.requireNonNull(str);
            if (str.equals("unknown")) {
                Log.e("FLTFirebaseFirestore", "An unknown error occurred", exc);
            }
        }
        return map;
    }

    public static void b(z.x xVar, Exception exc) {
        xVar.b(new z.j("firebase_firestore", exc != null ? exc.getMessage() : null, a(exc)));
    }
}
