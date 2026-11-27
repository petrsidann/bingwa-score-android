package d8;

import android.util.Base64;
import com.google.protobuf.f1;
import com.google.protobuf.u1;
import d9.d0;
import d9.u;
import e8.a1;
import e8.b1;
import e8.p;
import e8.q;
import h8.k;
import h8.r;
import h8.s;
import h8.t;
import h8.v;
import h8.y;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import k8.o0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f6496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f6497b;

    public g(o0 o0Var) {
        this.f6497b = o0Var;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        this.f6496a = simpleDateFormat;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
    }

    public static int D(String str) {
        int iCharAt = 0;
        for (int i10 = 0; i10 < 9; i10++) {
            iCharAt *= 10;
            if (i10 < str.length()) {
                if (str.charAt(i10) < '0' || str.charAt(i10) > '9') {
                    throw new IllegalArgumentException("Invalid nanoseconds: " + str);
                }
                iCharAt += str.charAt(i10) - '0';
            }
        }
        return iCharAt;
    }

    public static long z(String str) {
        int iIndexOf = str.indexOf(58);
        if (iIndexOf != -1) {
            return ((Long.parseLong(str.substring(0, iIndexOf)) * 60) + Long.parseLong(str.substring(iIndexOf + 1))) * 60;
        }
        throw new IllegalArgumentException("Invalid offset value: " + str);
    }

    public final void A(List<q> list, JSONObject jSONObject) throws JSONException {
        p.b bVar;
        d0 d0Var;
        h8.q qVarJ = j(jSONObject.getJSONObject("field"));
        String string = jSONObject.getString("op");
        string.hashCode();
        switch (string) {
            case "IS_NAN":
                bVar = p.b.EQUAL;
                d0Var = y.f9783a;
                list.add(p.e(qVarJ, bVar, d0Var));
                return;
            case "IS_NULL":
                bVar = p.b.EQUAL;
                d0Var = y.f9784b;
                list.add(p.e(qVarJ, bVar, d0Var));
                return;
            case "IS_NOT_NAN":
                bVar = p.b.NOT_EQUAL;
                d0Var = y.f9783a;
                list.add(p.e(qVarJ, bVar, d0Var));
                return;
            case "IS_NOT_NULL":
                bVar = p.b.NOT_EQUAL;
                d0Var = y.f9784b;
                list.add(p.e(qVarJ, bVar, d0Var));
                return;
            default:
                throw new IllegalArgumentException("Unexpected unary filter: " + string);
        }
    }

    public final d0 B(JSONObject jSONObject) {
        d0.b bVarB0 = d0.B0();
        if (jSONObject.has("nullValue")) {
            bVarB0.Q(f1.NULL_VALUE);
        } else if (jSONObject.has("booleanValue")) {
            bVarB0.I(jSONObject.optBoolean("booleanValue", false));
        } else if (jSONObject.has("integerValue")) {
            bVarB0.N(jSONObject.optLong("integerValue"));
        } else if (jSONObject.has("doubleValue")) {
            bVarB0.L(jSONObject.optDouble("doubleValue"));
        } else if (jSONObject.has("timestampValue")) {
            y(bVarB0, jSONObject.get("timestampValue"));
        } else if (jSONObject.has("stringValue")) {
            bVarB0.S(jSONObject.optString("stringValue", ""));
        } else if (jSONObject.has("bytesValue")) {
            bVarB0.K(com.google.protobuf.i.q(Base64.decode(jSONObject.getString("bytesValue"), 0)));
        } else if (jSONObject.has("referenceValue")) {
            bVarB0.R(jSONObject.getString("referenceValue"));
        } else if (jSONObject.has("geoPointValue")) {
            l(bVarB0, jSONObject.getJSONObject("geoPointValue"));
        } else if (jSONObject.has("arrayValue")) {
            a(bVarB0, jSONObject.getJSONObject("arrayValue").optJSONArray("values"));
        } else {
            if (!jSONObject.has("mapValue")) {
                throw new IllegalArgumentException("Unexpected value type: " + jSONObject);
            }
            o(bVarB0, jSONObject.getJSONObject("mapValue").optJSONObject("fields"));
        }
        return bVarB0.build();
    }

    public final List<q> C(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            k(arrayList, jSONObject);
        }
        return arrayList;
    }

    public final void E(JSONArray jSONArray) {
        if (jSONArray.length() != 1) {
            throw new IllegalArgumentException("Only queries with a single 'from' clause are supported by the Android SDK");
        }
    }

    public final void F(JSONObject jSONObject) {
        if (jSONObject.has("offset")) {
            throw new IllegalArgumentException("Queries with offsets are not supported by the Android SDK");
        }
    }

    public final void G(JSONObject jSONObject) {
        if (jSONObject.has("select")) {
            throw new IllegalArgumentException("Queries with 'select' statements are not supported by the Android SDK");
        }
    }

    public final void a(d0.b bVar, JSONArray jSONArray) {
        d9.b.C0113b c0113bN0 = d9.b.n0();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                c0113bN0.F(B(jSONArray.getJSONObject(i10)));
            }
        }
        bVar.F(c0113bN0);
    }

    public e b(JSONObject jSONObject) {
        return new e(jSONObject.getString("id"), jSONObject.getInt("version"), t(jSONObject.get("createTime")), jSONObject.getInt("totalDocuments"), jSONObject.getLong("totalBytes"));
    }

    public h c(JSONObject jSONObject) {
        k kVarN = k.n(p(jSONObject.getString("name")));
        v vVarT = t(jSONObject.get("readTime"));
        boolean zOptBoolean = jSONObject.optBoolean("exists", false);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("queries");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                arrayList.add(jSONArrayOptJSONArray.getString(i10));
            }
        }
        return new h(kVarN, vVarT, zOptBoolean, arrayList);
    }

    public final i d(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("structuredQuery");
        G(jSONObject2);
        t tVarP = p(jSONObject.getString("parent"));
        JSONArray jSONArray = jSONObject2.getJSONArray("from");
        E(jSONArray);
        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
        boolean zOptBoolean = jSONObject3.optBoolean("allDescendants", false);
        String string = jSONObject3.getString("collectionId");
        if (!zOptBoolean) {
            tVarP = tVarP.h(string);
            string = null;
        }
        List<q> listC = C(jSONObject2.optJSONObject("where"));
        List<a1> listR = r(jSONObject2.optJSONArray("orderBy"));
        e8.i iVarU = u(jSONObject2.optJSONObject("startAt"));
        e8.i iVarG = g(jSONObject2.optJSONObject("endAt"));
        F(jSONObject2);
        return new i(new b1(tVarP, string, listC, listR, m(jSONObject2), b1.a.LIMIT_TO_FIRST, iVarU, iVarG).D(), n(jSONObject));
    }

    public final void e(List<q> list, JSONObject jSONObject) {
        if (!jSONObject.getString("op").equals("AND")) {
            throw new IllegalArgumentException("The Android SDK only supports composite filters of type 'AND'");
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filters");
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                k(list, jSONArrayOptJSONArray.getJSONObject(i10));
            }
        }
    }

    public b f(JSONObject jSONObject) {
        k kVarN = k.n(p(jSONObject.getString("name")));
        v vVarT = t(jSONObject.get("updateTime"));
        d0.b bVarB0 = d0.B0();
        o(bVarB0, jSONObject.getJSONObject("fields"));
        return new b(r.r(kVarN, vVarT, s.h(bVarB0.E().h0())));
    }

    public final e8.i g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new e8.i(s(jSONObject), !jSONObject.optBoolean("before", false));
    }

    public final void h(List<q> list, JSONObject jSONObject) {
        list.add(p.e(j(jSONObject.getJSONObject("field")), i(jSONObject.getString("op")), B(jSONObject.getJSONObject("value"))));
    }

    public final p.b i(String str) {
        return p.b.valueOf(str);
    }

    public final h8.q j(JSONObject jSONObject) {
        return h8.q.z(jSONObject.getString("fieldPath"));
    }

    public final void k(List<q> list, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("compositeFilter")) {
            e(list, jSONObject.getJSONObject("compositeFilter"));
        } else if (jSONObject.has("fieldFilter")) {
            h(list, jSONObject.getJSONObject("fieldFilter"));
        } else if (jSONObject.has("unaryFilter")) {
            A(list, jSONObject.getJSONObject("unaryFilter"));
        }
    }

    public final void l(d0.b bVar, JSONObject jSONObject) {
        bVar.M(o9.a.j0().E(jSONObject.optDouble("latitude")).F(jSONObject.optDouble("longitude")));
    }

    public final int m(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("limit");
        return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optInt("value", -1) : jSONObject.optInt("limit", -1);
    }

    public final b1.a n(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("limitType", "FIRST");
        if (strOptString.equals("FIRST")) {
            return b1.a.LIMIT_TO_FIRST;
        }
        if (strOptString.equals("LAST")) {
            return b1.a.LIMIT_TO_LAST;
        }
        throw new IllegalArgumentException("Invalid limit type for bundle query: " + strOptString);
    }

    public final void o(d0.b bVar, JSONObject jSONObject) {
        u.b bVarN0 = u.n0();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bVarN0.H(next, B(jSONObject.getJSONObject(next)));
            }
        }
        bVar.O(bVarN0);
    }

    public final t p(String str) {
        t tVarZ = t.z(str);
        if (this.f6497b.c0(tVarZ)) {
            return tVarZ.v(5);
        }
        throw new IllegalArgumentException("Resource name is not valid for current instance: " + str);
    }

    public j q(JSONObject jSONObject) {
        return new j(jSONObject.getString("name"), d(jSONObject.getJSONObject("bundledQuery")), t(jSONObject.get("readTime")));
    }

    public final List<a1> r(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                arrayList.add(a1.d(jSONObject.optString("direction", "ASCENDING").equals("ASCENDING") ? a1.a.ASCENDING : a1.a.DESCENDING, j(jSONObject.getJSONObject("field"))));
            }
        }
        return arrayList;
    }

    public final List<d0> s(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                arrayList.add(B(jSONArrayOptJSONArray.getJSONObject(i10)));
            }
        }
        return arrayList;
    }

    public final v t(Object obj) {
        return new v(v(obj));
    }

    public final e8.i u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new e8.i(s(jSONObject), jSONObject.optBoolean("before", false));
    }

    public final h7.q v(Object obj) {
        if (obj instanceof String) {
            return w((String) obj);
        }
        if (obj instanceof JSONObject) {
            return x((JSONObject) obj);
        }
        throw new IllegalArgumentException("Timestamps must be either ISO 8601-formatted strings or JSON objects");
    }

    public final h7.q w(String str) {
        try {
            int iIndexOf = str.indexOf(84);
            if (iIndexOf == -1) {
                throw new IllegalArgumentException("Invalid timestamp: " + str);
            }
            int iIndexOf2 = str.indexOf(90, iIndexOf);
            if (iIndexOf2 == -1) {
                iIndexOf2 = str.indexOf(43, iIndexOf);
            }
            if (iIndexOf2 == -1) {
                iIndexOf2 = str.indexOf(45, iIndexOf);
            }
            if (iIndexOf2 == -1) {
                throw new IllegalArgumentException("Invalid timestamp: Missing valid timezone offset: " + str);
            }
            int iD = 0;
            String strSubstring = str.substring(0, iIndexOf2);
            String strSubstring2 = "";
            int iIndexOf3 = strSubstring.indexOf(46);
            if (iIndexOf3 != -1) {
                String strSubstring3 = strSubstring.substring(0, iIndexOf3);
                strSubstring2 = strSubstring.substring(iIndexOf3 + 1);
                strSubstring = strSubstring3;
            }
            long time = this.f6496a.parse(strSubstring).getTime() / 1000;
            if (!strSubstring2.isEmpty()) {
                iD = D(strSubstring2);
            }
            if (str.charAt(iIndexOf2) != 'Z') {
                long jZ = z(str.substring(iIndexOf2 + 1));
                time = str.charAt(iIndexOf2) == '+' ? time - jZ : time + jZ;
            } else if (str.length() != iIndexOf2 + 1) {
                throw new IllegalArgumentException("Invalid timestamp: Invalid trailing data \"" + str.substring(iIndexOf2) + "\"");
            }
            return new h7.q(time, iD);
        } catch (ParseException e10) {
            throw new IllegalArgumentException("Failed to parse timestamp", e10);
        }
    }

    public final h7.q x(JSONObject jSONObject) {
        return new h7.q(jSONObject.optLong("seconds"), jSONObject.optInt("nanos"));
    }

    public final void y(d0.b bVar, Object obj) {
        h7.q qVarV = v(obj);
        bVar.T(u1.j0().F(qVarV.k()).E(qVarV.h()));
    }
}
