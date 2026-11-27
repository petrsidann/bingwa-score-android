package m8;

import android.content.Context;
import android.content.SharedPreferences;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f12986a;

    public k(Context context, String str) {
        this.f12986a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    public final synchronized void a() {
        long j10 = this.f12986a.getLong("fire-count", 0L);
        String key = "";
        String str = null;
        for (Map.Entry<String, ?> entry : this.f12986a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                for (String str2 : (Set) entry.getValue()) {
                    if (str == null || str.compareTo(str2) > 0) {
                        key = entry.getKey();
                        str = str2;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet(this.f12986a.getStringSet(key, new HashSet()));
        hashSet.remove(str);
        this.f12986a.edit().putStringSet(key, hashSet).putLong("fire-count", j10 - 1).commit();
    }

    public synchronized void b() {
        SharedPreferences.Editor editorEdit = this.f12986a.edit();
        int i10 = 0;
        for (Map.Entry<String, ?> entry : this.f12986a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Set set = (Set) entry.getValue();
                String strD = d(System.currentTimeMillis());
                String key = entry.getKey();
                if (set.contains(strD)) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(strD);
                    i10++;
                    editorEdit.putStringSet(key, hashSet);
                } else {
                    editorEdit.remove(key);
                }
            }
        }
        if (i10 == 0) {
            editorEdit.remove("fire-count");
        } else {
            editorEdit.putLong("fire-count", i10);
        }
        editorEdit.commit();
    }

    public synchronized List<l> c() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.f12986a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                HashSet hashSet = new HashSet((Set) entry.getValue());
                hashSet.remove(d(System.currentTimeMillis()));
                if (!hashSet.isEmpty()) {
                    arrayList.add(l.a(entry.getKey(), new ArrayList(hashSet)));
                }
            }
        }
        l(System.currentTimeMillis());
        return arrayList;
    }

    public final synchronized String d(long j10) {
        return new Date(j10).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public final synchronized String e(String str) {
        for (Map.Entry<String, ?> entry : this.f12986a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    public synchronized boolean f(long j10, long j11) {
        return d(j10).equals(d(j11));
    }

    public synchronized void g() {
        String strD = d(System.currentTimeMillis());
        this.f12986a.edit().putString("last-used-date", strD).commit();
        h(strD);
    }

    public final synchronized void h(String str) {
        String strE = e(str);
        if (strE == null) {
            return;
        }
        HashSet hashSet = new HashSet(this.f12986a.getStringSet(strE, new HashSet()));
        hashSet.remove(str);
        (hashSet.isEmpty() ? this.f12986a.edit().remove(strE) : this.f12986a.edit().putStringSet(strE, hashSet)).commit();
    }

    public synchronized boolean i(long j10) {
        return j("fire-global", j10);
    }

    public synchronized boolean j(String str, long j10) {
        if (!this.f12986a.contains(str)) {
            this.f12986a.edit().putLong(str, j10).commit();
            return true;
        }
        if (f(this.f12986a.getLong(str, -1L), j10)) {
            return false;
        }
        this.f12986a.edit().putLong(str, j10).commit();
        return true;
    }

    public synchronized void k(long j10, String str) {
        String strD = d(j10);
        if (this.f12986a.getString("last-used-date", "").equals(strD)) {
            String strE = e(strD);
            if (strE == null) {
                return;
            }
            if (strE.equals(str)) {
                return;
            }
            m(str, strD);
            return;
        }
        long j11 = this.f12986a.getLong("fire-count", 0L);
        if (j11 + 1 == 30) {
            a();
            j11 = this.f12986a.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.f12986a.getStringSet(str, new HashSet()));
        hashSet.add(strD);
        this.f12986a.edit().putStringSet(str, hashSet).putLong("fire-count", j11 + 1).putString("last-used-date", strD).commit();
    }

    public synchronized void l(long j10) {
        this.f12986a.edit().putLong("fire-global", j10).commit();
    }

    public final synchronized void m(String str, String str2) {
        h(str2);
        HashSet hashSet = new HashSet(this.f12986a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.f12986a.edit().putStringSet(str, hashSet).commit();
    }
}
