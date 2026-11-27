package na;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f13454f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f13455l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f13456m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f13457n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f13458o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f13459p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f13460q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f13461r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList<c> f13462s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList<c> f13463t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList<d> f13464u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte[] f13465v;

    public a() {
        this.f13462s = new ArrayList<>();
        this.f13463t = new ArrayList<>();
        this.f13464u = new ArrayList<>();
        this.f13465v = new byte[0];
    }

    public a(String str) {
        this.f13462s = new ArrayList<>();
        this.f13463t = new ArrayList<>();
        this.f13464u = new ArrayList<>();
        this.f13465v = new byte[0];
        this.f13449a = str;
    }

    public static a h(HashMap map) {
        a aVar = new a();
        aVar.f13449a = (String) map.get("identifier");
        aVar.f13451c = (String) map.get("givenName");
        aVar.f13452d = (String) map.get("middleName");
        aVar.f13453e = (String) map.get("familyName");
        aVar.f13454f = (String) map.get("prefix");
        aVar.f13455l = (String) map.get("suffix");
        aVar.f13456m = (String) map.get("company");
        aVar.f13457n = (String) map.get("jobTitle");
        aVar.f13465v = (byte[]) map.get("avatar");
        aVar.f13458o = (String) map.get("note");
        aVar.f13459p = (String) map.get("birthday");
        aVar.f13460q = (String) map.get("androidAccountType");
        aVar.f13461r = (String) map.get("androidAccountName");
        ArrayList arrayList = (ArrayList) map.get("emails");
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.f13462s.add(c.a((HashMap) it.next()));
            }
        }
        ArrayList arrayList2 = (ArrayList) map.get("phones");
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                aVar.f13463t.add(c.a((HashMap) it2.next()));
            }
        }
        ArrayList arrayList3 = (ArrayList) map.get("postalAddresses");
        if (arrayList3 != null) {
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                aVar.f13464u.add(d.a((HashMap) it3.next()));
            }
        }
        return aVar;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        String str;
        String str2 = this.f13451c;
        String lowerCase = "";
        String lowerCase2 = str2 == null ? "" : str2.toLowerCase();
        if (aVar != null && (str = aVar.f13451c) != null) {
            lowerCase = str.toLowerCase();
        }
        return lowerCase2.compareTo(lowerCase);
    }

    public HashMap<String, Object> i() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("identifier", this.f13449a);
        map.put("displayName", this.f13450b);
        map.put("givenName", this.f13451c);
        map.put("middleName", this.f13452d);
        map.put("familyName", this.f13453e);
        map.put("prefix", this.f13454f);
        map.put("suffix", this.f13455l);
        map.put("company", this.f13456m);
        map.put("jobTitle", this.f13457n);
        map.put("avatar", this.f13465v);
        map.put("note", this.f13458o);
        map.put("birthday", this.f13459p);
        map.put("androidAccountType", this.f13460q);
        map.put("androidAccountName", this.f13461r);
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = this.f13462s.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().d());
        }
        map.put("emails", arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<c> it2 = this.f13463t.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().d());
        }
        map.put("phones", arrayList2);
        ArrayList arrayList3 = new ArrayList();
        Iterator<d> it3 = this.f13464u.iterator();
        while (it3.hasNext()) {
            arrayList3.add(it3.next().c());
        }
        map.put("postalAddresses", arrayList3);
        return map;
    }
}
