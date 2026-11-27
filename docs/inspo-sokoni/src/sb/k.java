package sb;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class k implements xa.a, sb.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f15709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f15710b;

    public static class a implements j {
        @Override // sb.j
        public String a(List<String> list) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(list);
                objectOutputStream.flush();
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // sb.j
        public List<String> b(String str) {
            try {
                return (List) new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 0))).readObject();
            } catch (IOException | ClassNotFoundException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public k() {
        this(new a());
    }

    public k(j jVar) {
        this.f15710b = jVar;
    }

    public final void A(fb.b bVar, Context context) {
        this.f15709a = context.getSharedPreferences("FlutterSharedPreferences", 0);
        try {
            sb.a.b.s(bVar, this);
        } catch (Exception e10) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesPlugin", e10);
        }
    }

    public final Object B(String str, Object obj) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
                return this.f15710b.b(str2.substring(40));
            }
            if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy")) {
                return new BigInteger(str2.substring(44), 36);
            }
            if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
                return Double.valueOf(str2.substring(40));
            }
        } else if (obj instanceof Set) {
            ArrayList arrayList = new ArrayList((Set) obj);
            this.f15709a.edit().remove(str).putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + this.f15710b.a(arrayList)).apply();
            return arrayList;
        }
        return obj;
    }

    @Override // sb.a.b
    public Map<String, Object> f(String str, List<String> list) {
        return z(str, list == null ? null : new HashSet(list));
    }

    @Override // sb.a.b
    public Boolean i(String str, List<String> list) {
        SharedPreferences.Editor editorEdit = this.f15709a.edit();
        Map<String, ?> all = this.f15709a.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (list == null || list.contains(str2))) {
                arrayList.add(str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        return Boolean.valueOf(editorEdit.commit());
    }

    @Override // sb.a.b
    public Boolean j(String str, List<String> list) {
        return Boolean.valueOf(this.f15709a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + this.f15710b.a(list)).commit());
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        A(bVar.b(), bVar.a());
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        sb.a.b.s(bVar.b(), null);
    }

    @Override // sb.a.b
    public Boolean p(String str, Long l10) {
        return Boolean.valueOf(this.f15709a.edit().putLong(str, l10.longValue()).commit());
    }

    @Override // sb.a.b
    public Boolean q(String str, String str2) {
        if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu") || str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy") || str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
            throw new RuntimeException("StorageError: This string cannot be stored as it clashes with special identifier prefixes");
        }
        return Boolean.valueOf(this.f15709a.edit().putString(str, str2).commit());
    }

    @Override // sb.a.b
    public Boolean remove(String str) {
        return Boolean.valueOf(this.f15709a.edit().remove(str).commit());
    }

    @Override // sb.a.b
    public Boolean u(String str, Boolean bool) {
        return Boolean.valueOf(this.f15709a.edit().putBoolean(str, bool.booleanValue()).commit());
    }

    @Override // sb.a.b
    public Boolean v(String str, Double d10) {
        String string = Double.toString(d10.doubleValue());
        return Boolean.valueOf(this.f15709a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit());
    }

    public final Map<String, Object> z(String str, Set<String> set) {
        Map<String, ?> all = this.f15709a.getAll();
        HashMap map = new HashMap();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (set == null || set.contains(str2))) {
                map.put(str2, B(str2, all.get(str2)));
            }
        }
        return map;
    }
}
