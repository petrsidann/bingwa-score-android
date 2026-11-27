package h4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h extends d4.a {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f9628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9629c;

    public h(int i10, ArrayList arrayList, String str) {
        this.f9627a = i10;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            f fVar = (f) arrayList.get(i11);
            String str2 = fVar.f9622b;
            HashMap map2 = new HashMap();
            int size2 = ((ArrayList) r.l(fVar.f9623c)).size();
            for (int i12 = 0; i12 < size2; i12++) {
                g gVar = (g) fVar.f9623c.get(i12);
                map2.put(gVar.f9625b, gVar.f9626c);
            }
            map.put(str2, map2);
        }
        this.f9628b = map;
        this.f9629c = (String) r.l(str);
        U();
    }

    public final String S() {
        return this.f9629c;
    }

    public final Map T(String str) {
        return (Map) this.f9628b.get(str);
    }

    public final void U() {
        Iterator it = this.f9628b.keySet().iterator();
        while (it.hasNext()) {
            Map map = (Map) this.f9628b.get((String) it.next());
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                ((a.C0159a) map.get((String) it2.next())).f0(this);
            }
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (String str : this.f9628b.keySet()) {
            sb2.append(str);
            sb2.append(":\n");
            Map map = (Map) this.f9628b.get(str);
            for (String str2 : map.keySet()) {
                sb2.append("  ");
                sb2.append(str2);
                sb2.append(": ");
                sb2.append(map.get(str2));
            }
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f9627a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f9628b.keySet()) {
            arrayList.add(new f(str, (Map) this.f9628b.get(str)));
        }
        d4.c.I(parcel, 2, arrayList, false);
        d4.c.E(parcel, 3, this.f9629c, false);
        d4.c.b(parcel, iA);
    }
}
