package s9;

import android.content.Context;
import android.database.Cursor;
import fb.j;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j.d f15657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f15658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f15661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15662g;

    public c(Context context, j.d dVar, d dVar2, int i10, int i11, int i12, String str) {
        this.f15656a = context;
        this.f15657b = dVar;
        this.f15658c = dVar2;
        this.f15660e = i12;
        this.f15659d = str;
        this.f15661f = i10;
        this.f15662g = i11;
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = this.f15656a.getContentResolver().query(this.f15658c.h(), null, null, null, null);
        if (cursorQuery == null) {
            this.f15657b.b("no_cursor", "flutter_sms_inbox plugin requires cursor to resolve content", null);
            return;
        }
        if (!cursorQuery.moveToFirst()) {
            cursorQuery.close();
            this.f15657b.a(arrayList);
            return;
        }
        do {
            JSONObject jSONObjectB = b(cursorQuery);
            try {
                if ((this.f15660e < 0 || jSONObjectB.getInt("thread_id") == this.f15660e) && (this.f15659d == null || jSONObjectB.getString("address").equals(this.f15659d))) {
                    int i10 = this.f15661f;
                    if (i10 > 0) {
                        this.f15661f = i10 - 1;
                    } else {
                        arrayList.add(jSONObjectB);
                        int i11 = this.f15662g;
                        if (i11 > 0) {
                            this.f15662g = i11 - 1;
                        }
                    }
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            if (!cursorQuery.moveToNext()) {
                break;
            }
        } while (this.f15662g != 0);
        cursorQuery.close();
        this.f15657b.a(arrayList);
    }

    public final JSONObject b(Cursor cursor) {
        JSONObject jSONObject = new JSONObject();
        for (int i10 = 0; i10 < cursor.getColumnCount(); i10++) {
            try {
                if (cursor.getColumnName(i10).equals("address") || cursor.getColumnName(i10).equals("body")) {
                    jSONObject.put(cursor.getColumnName(i10), cursor.getString(i10));
                } else if (cursor.getColumnName(i10).equals("date") || cursor.getColumnName(i10).equals("date_sent")) {
                    jSONObject.put(cursor.getColumnName(i10), cursor.getLong(i10));
                } else {
                    jSONObject.put(cursor.getColumnName(i10), cursor.getInt(i10));
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return jSONObject;
    }
}
