package p9;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import android.util.Log;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import q9.i;
import q9.m;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f14397c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, Object> f14399e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SharedPreferences f14401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i f14402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m f14403i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14395a = "SecureStorageAndroid";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f14398d = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIHNlY3VyZSBzdG9yYWdlCg";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f14400f = "FlutterSecureStorage";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f14404j = Boolean.FALSE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f14396b = StandardCharsets.UTF_8;

    public a(Context context) {
        this.f14397c = context.getApplicationContext();
    }

    public final void a(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        try {
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                Object value = entry.getValue();
                String key = entry.getKey();
                if ((value instanceof String) && key.contains(this.f14398d)) {
                    sharedPreferences2.edit().putString(key, c((String) value)).apply();
                    sharedPreferences.edit().remove(key).apply();
                }
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            this.f14403i.d(editorEdit);
            editorEdit.apply();
        } catch (Exception e10) {
            Log.e("SecureStorageAndroid", "Data migration failed", e10);
        }
    }

    public boolean b(String str) {
        f();
        return this.f14401g.contains(str);
    }

    public final String c(String str) {
        if (str == null) {
            return null;
        }
        return new String(this.f14402h.b(Base64.decode(str, 0)), this.f14396b);
    }

    public void d(String str) {
        f();
        SharedPreferences.Editor editorEdit = this.f14401g.edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public void e() {
        f();
        SharedPreferences.Editor editorEdit = this.f14401g.edit();
        editorEdit.clear();
        if (!g()) {
            this.f14403i.f(editorEdit);
        }
        editorEdit.apply();
    }

    public final void f() {
        if (this.f14399e.containsKey("sharedPreferencesName") && !((String) this.f14399e.get("sharedPreferencesName")).isEmpty()) {
            this.f14400f = (String) this.f14399e.get("sharedPreferencesName");
        }
        if (this.f14399e.containsKey("preferencesKeyPrefix") && !((String) this.f14399e.get("preferencesKeyPrefix")).isEmpty()) {
            this.f14398d = (String) this.f14399e.get("preferencesKeyPrefix");
        }
        SharedPreferences sharedPreferences = this.f14397c.getSharedPreferences(this.f14400f, 0);
        if (this.f14402h == null) {
            try {
                h(sharedPreferences);
            } catch (Exception e10) {
                Log.e("SecureStorageAndroid", "StorageCipher initialization failed", e10);
            }
        }
        if (!g()) {
            this.f14401g = sharedPreferences;
            return;
        }
        try {
            SharedPreferences sharedPreferencesI = i(this.f14397c);
            this.f14401g = sharedPreferencesI;
            a(sharedPreferences, sharedPreferencesI);
        } catch (Exception e11) {
            Log.e("SecureStorageAndroid", "EncryptedSharedPreferences initialization failed", e11);
            this.f14401g = sharedPreferences;
            this.f14404j = Boolean.TRUE;
        }
    }

    public final boolean g() {
        return !this.f14404j.booleanValue() && this.f14399e.containsKey("encryptedSharedPreferences") && this.f14399e.get("encryptedSharedPreferences").equals("true");
    }

    public final void h(SharedPreferences sharedPreferences) {
        i iVarA;
        this.f14403i = new m(sharedPreferences, this.f14399e);
        if (g()) {
            iVarA = this.f14403i.c(this.f14397c);
        } else {
            if (this.f14403i.e()) {
                j(this.f14403i, sharedPreferences);
                return;
            }
            iVarA = this.f14403i.a(this.f14397c);
        }
        this.f14402h = iVarA;
    }

    public final SharedPreferences i(Context context) {
        return c2.a.a(context, this.f14400f, new c2.c.a(context).b(new KeyGenParameterSpec.Builder("_androidx_security_master_key_", 3).setEncryptionPaddings("NoPadding").setBlockModes("GCM").setKeySize(256).build()).a(), c2.a.d.AES256_SIV, c2.a.e.AES256_GCM);
    }

    public final void j(m mVar, SharedPreferences sharedPreferences) {
        try {
            this.f14402h = mVar.c(this.f14397c);
            HashMap map = new HashMap();
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                Object value = entry.getValue();
                String key = entry.getKey();
                if ((value instanceof String) && key.contains(this.f14398d)) {
                    map.put(key, c((String) value));
                }
            }
            this.f14402h = mVar.a(this.f14397c);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            for (Map.Entry entry2 : map.entrySet()) {
                editorEdit.putString((String) entry2.getKey(), Base64.encodeToString(this.f14402h.a(((String) entry2.getValue()).getBytes(this.f14396b)), 0));
            }
            mVar.f(editorEdit);
            editorEdit.apply();
        } catch (Exception e10) {
            Log.e("SecureStorageAndroid", "re-encryption failed", e10);
            this.f14402h = mVar.c(this.f14397c);
        }
    }

    public String k(String str) {
        f();
        String string = this.f14401g.getString(str, null);
        return g() ? string : c(string);
    }

    public Map<String, String> l() {
        f();
        Map<String, ?> all = this.f14401g.getAll();
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getKey().contains(this.f14398d)) {
                String strReplaceFirst = entry.getKey().replaceFirst(this.f14398d + '_', "");
                boolean zG = g();
                String strC = (String) entry.getValue();
                if (!zG) {
                    strC = c(strC);
                }
                map.put(strReplaceFirst, strC);
            }
        }
        return map;
    }

    public void m(String str, String str2) {
        f();
        SharedPreferences.Editor editorEdit = this.f14401g.edit();
        if (!g()) {
            str2 = Base64.encodeToString(this.f14402h.a(str2.getBytes(this.f14396b)), 0);
        }
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }
}
