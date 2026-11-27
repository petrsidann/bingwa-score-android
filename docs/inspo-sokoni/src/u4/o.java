package u4;

import java.util.EnumMap;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap<s8.a, n> f16620a;

    public o() {
        this.f16620a = new EnumMap<>(s8.a.class);
    }

    public o(EnumMap<s8.a, n> enumMap) {
        EnumMap<s8.a, n> enumMap2 = new EnumMap<>(s8.a.class);
        this.f16620a = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public static o b(String str) {
        EnumMap enumMap = new EnumMap(s8.a.class);
        if (str.length() >= s8.a.values().length) {
            int i10 = 0;
            if (str.charAt(0) == '1') {
                s8.a[] aVarArrValues = s8.a.values();
                int length = aVarArrValues.length;
                int i11 = 1;
                while (i10 < length) {
                    enumMap.put(aVarArrValues[i10], n.h(str.charAt(i11)));
                    i10++;
                    i11++;
                }
                return new o(enumMap);
            }
        }
        return new o();
    }

    public final n a(s8.a aVar) {
        n nVar = this.f16620a.get(aVar);
        return nVar == null ? n.UNSET : nVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001b  */
    public final void c(s8.a aVar, int i10) {
        n nVar = n.UNSET;
        if (i10 == -30) {
            nVar = n.TCF;
        } else if (i10 == -20) {
            nVar = n.API;
        } else if (i10 == -10) {
            nVar = n.MANIFEST;
        } else if (i10 == 0) {
            nVar = n.API;
        } else if (i10 == 30) {
            nVar = n.INITIALIZATION;
        }
        this.f16620a.put(aVar, nVar);
    }

    public final void d(s8.a aVar, n nVar) {
        this.f16620a.put(aVar, nVar);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("1");
        for (s8.a aVar : s8.a.values()) {
            n nVar = this.f16620a.get(aVar);
            if (nVar == null) {
                nVar = n.UNSET;
            }
            sb2.append(nVar.f16568a);
        }
        return sb2.toString();
    }
}
