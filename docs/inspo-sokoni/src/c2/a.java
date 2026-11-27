package c2;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import r6.k;
import r6.l;
import r6.m;

/* JADX INFO: loaded from: classes.dex */
public final class a implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f3139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> f3140b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r6.a f3143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r6.d f3144f;

    /* JADX INFO: renamed from: c2.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0060a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3145a;

        static {
            int[] iArr = new int[c.values().length];
            f3145a = iArr;
            try {
                iArr[c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3145a[c.INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3145a[c.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3145a[c.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3145a[c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3145a[c.STRING_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static final class b implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f3146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SharedPreferences.Editor f3147b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AtomicBoolean f3149d = new AtomicBoolean(false);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f3148c = new CopyOnWriteArrayList();

        public b(a aVar, SharedPreferences.Editor editor) {
            this.f3146a = aVar;
            this.f3147b = editor;
        }

        public final void a() {
            if (this.f3149d.getAndSet(false)) {
                for (String str : this.f3146a.getAll().keySet()) {
                    if (!this.f3148c.contains(str) && !this.f3146a.g(str)) {
                        this.f3147b.remove(this.f3146a.d(str));
                    }
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            a();
            this.f3147b.apply();
            b();
            this.f3148c.clear();
        }

        public final void b() {
            for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.f3146a.f3140b) {
                Iterator<String> it = this.f3148c.iterator();
                while (it.hasNext()) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.f3146a, it.next());
                }
            }
        }

        public final void c(String str, byte[] bArr) {
            if (this.f3146a.g(str)) {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
            this.f3148c.add(str);
            if (str == null) {
                str = "__NULL__";
            }
            try {
                Pair<String, String> pairE = this.f3146a.e(str, bArr);
                this.f3147b.putString((String) pairE.first, (String) pairE.second);
            } catch (GeneralSecurityException e10) {
                throw new SecurityException("Could not encrypt data: " + e10.getMessage(), e10);
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f3149d.set(true);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            a();
            try {
                return this.f3147b.commit();
            } finally {
                b();
                this.f3148c.clear();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z10) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
            byteBufferAllocate.putInt(c.BOOLEAN.i());
            byteBufferAllocate.put(z10 ? (byte) 1 : (byte) 0);
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f10) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(c.FLOAT.i());
            byteBufferAllocate.putFloat(f10);
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i10) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
            byteBufferAllocate.putInt(c.INT.i());
            byteBufferAllocate.putInt(i10);
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j10) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
            byteBufferAllocate.putInt(c.LONG.i());
            byteBufferAllocate.putLong(j10);
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            if (str2 == null) {
                str2 = "__NULL__";
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 8);
            byteBufferAllocate.putInt(c.STRING.i());
            byteBufferAllocate.putInt(length);
            byteBufferAllocate.put(bytes);
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            if (set == null) {
                set = new t.b<>();
                set.add("__NULL__");
            }
            ArrayList<byte[]> arrayList = new ArrayList(set.size());
            int size = set.size() * 4;
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                byte[] bytes = it.next().getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes);
                size += bytes.length;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(size + 4);
            byteBufferAllocate.putInt(c.STRING_SET.i());
            for (byte[] bArr : arrayList) {
                byteBufferAllocate.putInt(bArr.length);
                byteBufferAllocate.put(bArr);
            }
            c(str, byteBufferAllocate.array());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            if (!this.f3146a.g(str)) {
                this.f3147b.remove(this.f3146a.d(str));
                this.f3148c.add(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    public enum c {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3157a;

        c(int i10) {
            this.f3157a = i10;
        }

        public static c h(int i10) {
            if (i10 == 0) {
                return STRING;
            }
            if (i10 == 1) {
                return STRING_SET;
            }
            if (i10 == 2) {
                return INT;
            }
            if (i10 == 3) {
                return LONG;
            }
            if (i10 == 4) {
                return FLOAT;
            }
            if (i10 != 5) {
                return null;
            }
            return BOOLEAN;
        }

        public int i() {
            return this.f3157a;
        }
    }

    public enum d {
        AES256_SIV("AES256_SIV");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3160a;

        d(String str) {
            this.f3160a = str;
        }

        public k h() {
            return l.a(this.f3160a);
        }
    }

    public enum e {
        AES256_GCM("AES256_GCM");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3163a;

        e(String str) {
            this.f3163a = str;
        }

        public k h() {
            return l.a(this.f3163a);
        }
    }

    public a(String str, String str2, SharedPreferences sharedPreferences, r6.a aVar, r6.d dVar) {
        this.f3141c = str;
        this.f3139a = sharedPreferences;
        this.f3142d = str2;
        this.f3143e = aVar;
        this.f3144f = dVar;
    }

    public static SharedPreferences a(Context context, String str, c2.c cVar, d dVar, e eVar) {
        return b(str, cVar.a(), context, dVar, eVar);
    }

    @Deprecated
    public static SharedPreferences b(String str, String str2, Context context, d dVar, e eVar) {
        x6.b.a();
        s6.a.b();
        Context applicationContext = context.getApplicationContext();
        m mVarC = new y6.a.b().h(dVar.h()).j(applicationContext, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str).i("android-keystore://" + str2).d().c();
        m mVarC2 = new y6.a.b().h(eVar.h()).j(applicationContext, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str).i("android-keystore://" + str2).d().c();
        return new a(str, str2, applicationContext.getSharedPreferences(str, 0), (r6.a) mVarC2.h(r6.a.class), (r6.d) mVarC.h(r6.d.class));
    }

    public String c(String str) {
        try {
            String str2 = new String(this.f3144f.b(f7.e.a(str, 0), this.f3141c.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals("__NULL__")) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e10) {
            throw new SecurityException("Could not decrypt key. " + e10.getMessage(), e10);
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        if (!g(str)) {
            return this.f3139a.contains(d(str));
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    public String d(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            return f7.e.d(this.f3144f.a(str.getBytes(StandardCharsets.UTF_8), this.f3141c.getBytes()));
        } catch (GeneralSecurityException e10) {
            throw new SecurityException("Could not encrypt key. " + e10.getMessage(), e10);
        }
    }

    public Pair<String, String> e(String str, byte[] bArr) {
        String strD = d(str);
        return new Pair<>(strD, f7.e.d(this.f3143e.a(bArr, strD.getBytes(StandardCharsets.UTF_8))));
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new b(this, this.f3139a.edit());
    }

    public final Object f(String str) {
        if (g(str)) {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String strD = d(str);
            String string = this.f3139a.getString(strD, null);
            if (string == null) {
                return null;
            }
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f3143e.b(f7.e.a(string, 0), strD.getBytes(StandardCharsets.UTF_8)));
            byteBufferWrap.position(0);
            int i10 = byteBufferWrap.getInt();
            c cVarH = c.h(i10);
            if (cVarH == null) {
                throw new SecurityException("Unknown type ID for encrypted pref value: " + i10);
            }
            switch (C0060a.f3145a[cVarH.ordinal()]) {
                case 1:
                    int i11 = byteBufferWrap.getInt();
                    ByteBuffer byteBufferSlice = byteBufferWrap.slice();
                    byteBufferWrap.limit(i11);
                    String string2 = StandardCharsets.UTF_8.decode(byteBufferSlice).toString();
                    if (string2.equals("__NULL__")) {
                        return null;
                    }
                    return string2;
                case 2:
                    return Integer.valueOf(byteBufferWrap.getInt());
                case 3:
                    return Long.valueOf(byteBufferWrap.getLong());
                case 4:
                    return Float.valueOf(byteBufferWrap.getFloat());
                case 5:
                    return Boolean.valueOf(byteBufferWrap.get() != 0);
                case 6:
                    t.b bVar = new t.b();
                    while (byteBufferWrap.hasRemaining()) {
                        int i12 = byteBufferWrap.getInt();
                        ByteBuffer byteBufferSlice2 = byteBufferWrap.slice();
                        byteBufferSlice2.limit(i12);
                        byteBufferWrap.position(byteBufferWrap.position() + i12);
                        bVar.add(StandardCharsets.UTF_8.decode(byteBufferSlice2).toString());
                    }
                    if (bVar.size() == 1 && "__NULL__".equals(bVar.o(0))) {
                        return null;
                    }
                    return bVar;
                default:
                    throw new SecurityException("Unhandled type for encrypted pref value: " + cVarH);
            }
        } catch (GeneralSecurityException e10) {
            throw new SecurityException("Could not decrypt value. " + e10.getMessage(), e10);
        }
    }

    public boolean g(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : this.f3139a.getAll().entrySet()) {
            if (!g(entry.getKey())) {
                String strC = c(entry.getKey());
                map.put(strC, f(strC));
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z10) {
        Object objF = f(str);
        return (objF == null || !(objF instanceof Boolean)) ? z10 : ((Boolean) objF).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f10) {
        Object objF = f(str);
        return (objF == null || !(objF instanceof Float)) ? f10 : ((Float) objF).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i10) {
        Object objF = f(str);
        return (objF == null || !(objF instanceof Integer)) ? i10 : ((Integer) objF).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j10) {
        Object objF = f(str);
        return (objF == null || !(objF instanceof Long)) ? j10 : ((Long) objF).longValue();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        Object objF = f(str);
        return (objF == null || !(objF instanceof String)) ? str2 : (String) objF;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Object objF = f(str);
        Set<String> bVar = objF instanceof Set ? (Set) objF : new t.b<>();
        return bVar.size() > 0 ? bVar : set;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f3140b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f3140b.remove(onSharedPreferenceChangeListener);
    }
}
