package e0;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class n1 implements Iterable<Intent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Intent> f6830a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6831b;

    public interface a {
        Intent l();
    }

    public n1(Context context) {
        this.f6831b = context;
    }

    public static n1 j(Context context) {
        return new n1(context);
    }

    public n1 e(Intent intent) {
        this.f6830a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n1 h(Activity activity) {
        Intent intentL = activity instanceof a ? ((a) activity).l() : null;
        if (intentL == null) {
            intentL = o.a(activity);
        }
        if (intentL != null) {
            ComponentName component = intentL.getComponent();
            if (component == null) {
                component = intentL.resolveActivity(this.f6831b.getPackageManager());
            }
            i(component);
            e(intentL);
        }
        return this;
    }

    public n1 i(ComponentName componentName) {
        int size = this.f6830a.size();
        try {
            Context context = this.f6831b;
            while (true) {
                Intent intentB = o.b(context, componentName);
                if (intentB == null) {
                    return this;
                }
                this.f6830a.add(size, intentB);
                context = this.f6831b;
                componentName = intentB.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e10);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f6830a.iterator();
    }

    public void k() {
        l(null);
    }

    public void l(Bundle bundle) {
        if (this.f6830a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f6830a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (f0.a.startActivities(this.f6831b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f6831b.startActivity(intent);
    }
}
