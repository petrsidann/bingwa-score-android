package pb;

import android.app.Activity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a0 implements fb.n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f14425b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14424a = 240;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14426c = false;

    @FunctionalInterface
    public interface a {
        void a(int i10);
    }

    public void a(Activity activity, a aVar, b bVar) {
        String str;
        if (this.f14426c) {
            str = "A request for permissions is already running, please wait for it to finish before doing another request.";
        } else {
            if (activity != null) {
                this.f14425b = aVar;
                ArrayList arrayList = new ArrayList();
                arrayList.add("android.permission.POST_NOTIFICATIONS");
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                if (this.f14426c) {
                    return;
                }
                e0.b.e(activity, strArr, 240);
                this.f14426c = true;
                return;
            }
            str = "Unable to detect current Android Activity.";
        }
        bVar.a(str);
    }

    @Override // fb.n
    public boolean onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        a aVar;
        int i11 = 0;
        if (!this.f14426c || i10 != 240 || (aVar = this.f14425b) == null) {
            return false;
        }
        this.f14426c = false;
        if (iArr.length > 0 && iArr[0] == 0) {
            i11 = 1;
        }
        aVar.a(i11);
        return true;
    }
}
