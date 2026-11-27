package vb;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j6.f f17543c = j6.f.e(',');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w f17544d = a().f(new m.a(), true).f(m.b.f17449a, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f17545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f17546b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v f17547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17548b;

        public a(v vVar, boolean z10) {
            this.f17547a = (v) j6.m.p(vVar, "decompressor");
            this.f17548b = z10;
        }
    }

    public w() {
        this.f17545a = new LinkedHashMap(0);
        this.f17546b = new byte[0];
    }

    public w(v vVar, boolean z10, w wVar) {
        String strA = vVar.a();
        j6.m.e(!strA.contains(","), "Comma is currently not allowed in message encoding");
        int size = wVar.f17545a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(wVar.f17545a.containsKey(vVar.a()) ? size : size + 1);
        for (a aVar : wVar.f17545a.values()) {
            String strA2 = aVar.f17547a.a();
            if (!strA2.equals(strA)) {
                linkedHashMap.put(strA2, new a(aVar.f17547a, aVar.f17548b));
            }
        }
        linkedHashMap.put(strA, new a(vVar, z10));
        this.f17545a = Collections.unmodifiableMap(linkedHashMap);
        this.f17546b = f17543c.c(b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static w a() {
        return new w();
    }

    public static w c() {
        return f17544d;
    }

    public Set<String> b() {
        HashSet hashSet = new HashSet(this.f17545a.size());
        for (Map.Entry<String, a> entry : this.f17545a.entrySet()) {
            if (entry.getValue().f17548b) {
                hashSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public byte[] d() {
        return this.f17546b;
    }

    public v e(String str) {
        a aVar = this.f17545a.get(str);
        if (aVar != null) {
            return aVar.f17547a;
        }
        return null;
    }

    public w f(v vVar, boolean z10) {
        return new w(vVar, z10, this);
    }
}
