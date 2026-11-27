package ee;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f7934c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, ge.a> f7935a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ge.a f7936b;

    public static a f() {
        if (f7934c == null) {
            f7934c = new a();
        }
        return f7934c;
    }

    public boolean d(Context context) {
        return true;
    }

    public ge.a e() {
        return this.f7936b;
    }

    public List<ge.a> g(Context context) {
        return new ArrayList(this.f7935a.values());
    }

    public boolean h(Context context, Integer num) {
        this.f7935a.remove(num);
        return true;
    }

    public boolean i(Context context) {
        this.f7936b = null;
        this.f7935a.clear();
        return true;
    }

    public boolean j(Context context, ge.a aVar) {
        return this.f7935a.put(aVar.f8380l, aVar) != null;
    }

    public void k(Context context, ge.a aVar) {
        this.f7936b = aVar;
    }
}
