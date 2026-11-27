package f2;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f8154b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f8153a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<l> f8155c = new ArrayList<>();

    @Deprecated
    public s() {
    }

    public s(View view) {
        this.f8154b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f8154b == sVar.f8154b && this.f8153a.equals(sVar.f8153a);
    }

    public int hashCode() {
        return (this.f8154b.hashCode() * 31) + this.f8153a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f8154b + "\n") + "    values:";
        for (String str2 : this.f8153a.keySet()) {
            str = str + "    " + str2 + ": " + this.f8153a.get(str2) + "\n";
        }
        return str;
    }
}
