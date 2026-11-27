package qd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* JADX INFO: loaded from: classes2.dex */
public class d extends je.b {
    public static void o() {
        je.b bVar = je.b.f11402b;
        if (bVar == null || bVar.getClass() != d.class) {
            je.b.f11402b = new d();
        }
    }

    @Override // je.b
    public Bitmap e(Context context, String str) {
        String strA = a(str);
        if (strA == null) {
            return null;
        }
        try {
            return BitmapFactory.decodeStream(context.getAssets().open("flutter_assets/" + strA));
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
