package eb;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.j f7737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f7738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fb.j.c f7739c;

    public class a implements fb.j.c {
        public a() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            Bundle bundle;
            if (s.this.f7738b == null) {
            }
            String str = iVar.f8284a;
            Object obj = iVar.f8285b;
            qa.b.f("TextInputChannel", "Received '" + str + "' message.");
            str.hashCode();
            byte b10 = -1;
            switch (str.hashCode()) {
                case -1779068172:
                    if (str.equals("TextInput.setPlatformViewClient")) {
                        b10 = 0;
                    }
                    break;
                case -1015421462:
                    if (str.equals("TextInput.setEditingState")) {
                        b10 = 1;
                    }
                    break;
                case -37561188:
                    if (str.equals("TextInput.setClient")) {
                        b10 = 2;
                    }
                    break;
                case 270476819:
                    if (str.equals("TextInput.hide")) {
                        b10 = 3;
                    }
                    break;
                case 270803918:
                    if (str.equals("TextInput.show")) {
                        b10 = 4;
                    }
                    break;
                case 649192816:
                    if (str.equals("TextInput.sendAppPrivateCommand")) {
                        b10 = 5;
                    }
                    break;
                case 1204752139:
                    if (str.equals("TextInput.setEditableSizeAndTransform")) {
                        b10 = 6;
                    }
                    break;
                case 1727570905:
                    if (str.equals("TextInput.finishAutofillContext")) {
                        b10 = 7;
                    }
                    break;
                case 1904427655:
                    if (str.equals("TextInput.clearClient")) {
                        b10 = 8;
                    }
                    break;
                case 2113369584:
                    if (str.equals("TextInput.requestAutofill")) {
                        b10 = 9;
                    }
                    break;
            }
            try {
                switch (b10) {
                    case 0:
                        JSONObject jSONObject = (JSONObject) obj;
                        s.this.f7738b.e(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                        dVar.a(null);
                        break;
                    case 1:
                        s.this.f7738b.b(e.a((JSONObject) obj));
                        dVar.a(null);
                        break;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            s.this.f7738b.c(jSONArray.getInt(0), b.a(jSONArray.getJSONObject(1)));
                            dVar.a(null);
                        } catch (NoSuchFieldException e10) {
                            e = e10;
                            dVar.b("error", e.getMessage(), null);
                            return;
                        }
                        break;
                    case 3:
                        s.this.f7738b.j();
                        dVar.a(null);
                        break;
                    case 4:
                        s.this.f7738b.a();
                        dVar.a(null);
                        break;
                    case 5:
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String string = jSONObject2.getString("action");
                        String string2 = jSONObject2.getString("data");
                        if (string2 == null || string2.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("data", string2);
                        }
                        s.this.f7738b.d(string, bundle);
                        dVar.a(null);
                        break;
                    case 6:
                        JSONObject jSONObject3 = (JSONObject) obj;
                        double d10 = jSONObject3.getDouble("width");
                        double d11 = jSONObject3.getDouble("height");
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (int i10 = 0; i10 < 16; i10++) {
                            dArr[i10] = jSONArray2.getDouble(i10);
                        }
                        s.this.f7738b.f(d10, d11, dArr);
                        dVar.a(null);
                        break;
                    case 7:
                        s.this.f7738b.h(((Boolean) obj).booleanValue());
                        dVar.a(null);
                        break;
                    case 8:
                        s.this.f7738b.i();
                        dVar.a(null);
                        break;
                    case 9:
                        s.this.f7738b.g();
                        dVar.a(null);
                        break;
                    default:
                        dVar.c();
                        break;
                }
            } catch (JSONException e11) {
                e = e11;
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f7743c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f7744d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f7745e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d f7746f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c f7747g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Integer f7748h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f7749i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final a f7750j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String[] f7751k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final b[] f7752l;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f7753a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String[] f7754b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final e f7755c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f7756d;

            public a(String str, String[] strArr, String str2, e eVar) {
                this.f7753a = str;
                this.f7754b = strArr;
                this.f7756d = str2;
                this.f7755c = eVar;
            }

            public static a a(JSONObject jSONObject) throws JSONException {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    strArr[i10] = b(jSONArray.getString(i10));
                }
                return new a(string, strArr, string2, e.a(jSONObject2));
            }

            public static String b(String str) {
                str.hashCode();
                switch (str) {
                    case "birthdayYear":
                        return "birthDateYear";
                    case "oneTimeCode":
                        return "smsOTPCode";
                    case "creditCardExpirationMonth":
                        return "creditCardExpirationMonth";
                    case "telephoneNumberNational":
                        return "phoneNational";
                    case "newPassword":
                        return "newPassword";
                    case "creditCardSecurityCode":
                        return "creditCardSecurityCode";
                    case "creditCardExpirationDay":
                        return "creditCardExpirationDay";
                    case "fullStreetAddress":
                        return "streetAddress";
                    case "telephoneNumberDevice":
                        return "phoneNumberDevice";
                    case "countryName":
                        return "addressCountry";
                    case "middleInitial":
                        return "personMiddleInitial";
                    case "addressCity":
                        return "addressLocality";
                    case "gender":
                        return "gender";
                    case "postalAddressExtendedPostalCode":
                        return "extendedPostalCode";
                    case "creditCardNumber":
                        return "creditCardNumber";
                    case "namePrefix":
                        return "personNamePrefix";
                    case "middleName":
                        return "personMiddleName";
                    case "nameSuffix":
                        return "personNameSuffix";
                    case "creditCardExpirationDate":
                        return "creditCardExpirationDate";
                    case "creditCardExpirationYear":
                        return "creditCardExpirationYear";
                    case "telephoneNumberCountryCode":
                        return "phoneCountryCode";
                    case "username":
                        return "username";
                    case "name":
                        return "personName";
                    case "email":
                        return "emailAddress";
                    case "addressState":
                        return "addressRegion";
                    case "birthdayMonth":
                        return "birthDateMonth";
                    case "familyName":
                        return "personFamilyName";
                    case "telephoneNumber":
                        return "phoneNumber";
                    case "newUsername":
                        return "newUsername";
                    case "birthday":
                        return "birthDateFull";
                    case "password":
                        return "password";
                    case "givenName":
                        return "personGivenName";
                    case "postalAddress":
                        return "postalAddress";
                    case "postalAddressExtended":
                        return "extendedAddress";
                    case "postalCode":
                        return "postalCode";
                    case "birthdayDay":
                        return "birthDateDay";
                    default:
                        return str;
                }
            }
        }

        public b(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, d dVar, c cVar, Integer num, String str, a aVar, String[] strArr, b[] bVarArr) {
            this.f7741a = z10;
            this.f7742b = z11;
            this.f7743c = z12;
            this.f7744d = z13;
            this.f7745e = z14;
            this.f7746f = dVar;
            this.f7747g = cVar;
            this.f7748h = num;
            this.f7749i = str;
            this.f7750j = aVar;
            this.f7751k = strArr;
            this.f7752l = bVarArr;
        }

        public static b a(JSONObject jSONObject) throws JSONException {
            b[] bVarArr;
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            if (jSONObject.isNull("fields")) {
                bVarArr = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("fields");
                int length = jSONArray.length();
                b[] bVarArr2 = new b[length];
                for (int i10 = 0; i10 < length; i10++) {
                    bVarArr2[i10] = a(jSONArray.getJSONObject(i10));
                }
                bVarArr = bVarArr2;
            }
            Integer numB = b(string);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = jSONObject.isNull("contentCommitMimeTypes") ? null : jSONObject.getJSONArray("contentCommitMimeTypes");
            if (jSONArray2 != null) {
                for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                    arrayList.add(jSONArray2.optString(i11));
                }
            }
            return new b(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), jSONObject.optBoolean("enableIMEPersonalizedLearning"), jSONObject.optBoolean("enableDeltaModel"), d.h(jSONObject.getString("textCapitalization")), c.a(jSONObject.getJSONObject("inputType")), numB, jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : a.a(jSONObject.getJSONObject("autofill")), (String[]) arrayList.toArray(new String[arrayList.size()]), bVarArr);
        }

        public static Integer b(String str) {
            str.hashCode();
            switch (str) {
                case "TextInputAction.unspecified":
                    return 0;
                case "TextInputAction.done":
                    return 6;
                case "TextInputAction.next":
                    return 5;
                case "TextInputAction.none":
                    return 1;
                case "TextInputAction.send":
                    return 4;
                case "TextInputAction.search":
                    return 3;
                case "TextInputAction.go":
                    return 2;
                case "TextInputAction.newline":
                    return 1;
                case "TextInputAction.previous":
                    return 7;
                default:
                    return 0;
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f7757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f7759c;

        public c(g gVar, boolean z10, boolean z11) {
            this.f7757a = gVar;
            this.f7758b = z10;
            this.f7759c = z11;
        }

        public static c a(JSONObject jSONObject) {
            return new c(g.h(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    public enum d {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7765a;

        d(String str) {
            this.f7765a = str;
        }

        public static d h(String str) throws NoSuchFieldException {
            for (d dVar : values()) {
                if (dVar.f7765a.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f7769d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f7770e;

        public e(String str, int i10, int i11, int i12, int i13) {
            if (!(i10 == -1 && i11 == -1) && (i10 < 0 || i11 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i10) + ", " + String.valueOf(i11) + ")");
            }
            if (!(i12 == -1 && i13 == -1) && (i12 < 0 || i12 > i13)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i12) + ", " + String.valueOf(i13) + ")");
            }
            if (i13 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i12));
            }
            if (i10 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i10));
            }
            if (i11 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i11));
            }
            this.f7766a = str;
            this.f7767b = i10;
            this.f7768c = i11;
            this.f7769d = i12;
            this.f7770e = i13;
        }

        public static e a(JSONObject jSONObject) {
            return new e(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean b() {
            int i10 = this.f7769d;
            return i10 >= 0 && this.f7770e > i10;
        }

        public boolean c() {
            return this.f7767b >= 0;
        }
    }

    public interface f {
        void a();

        void b(e eVar);

        void c(int i10, b bVar);

        void d(String str, Bundle bundle);

        void e(int i10, boolean z10);

        void f(double d10, double d11, double[] dArr);

        void g();

        void h(boolean z10);

        void i();

        void j();
    }

    public enum g {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7783a;

        g(String str) {
            this.f7783a = str;
        }

        public static g h(String str) throws NoSuchFieldException {
            for (g gVar : values()) {
                if (gVar.f7783a.equals(str)) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public s(ta.a aVar) {
        a aVar2 = new a();
        this.f7739c = aVar2;
        fb.j jVar = new fb.j(aVar, "flutter/textinput", fb.f.f8283a);
        this.f7737a = jVar;
        jVar.e(aVar2);
    }

    public static HashMap<Object, Object> c(ArrayList<io.flutter.plugin.editing.e> arrayList) {
        HashMap<Object, Object> map = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        Iterator<io.flutter.plugin.editing.e> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().b());
        }
        map.put("deltas", jSONArray);
        return map;
    }

    public static HashMap<Object, Object> d(String str, int i10, int i11, int i12, int i13) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("text", str);
        map.put("selectionBase", Integer.valueOf(i10));
        map.put("selectionExtent", Integer.valueOf(i11));
        map.put("composingBase", Integer.valueOf(i12));
        map.put("composingExtent", Integer.valueOf(i13));
        return map;
    }

    public void b(int i10, Map<String, Object> map) {
        qa.b.f("TextInputChannel", "Sending 'commitContent' message.");
        this.f7737a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i10), "TextInputAction.commitContent", map));
    }

    public void e(int i10) {
        qa.b.f("TextInputChannel", "Sending 'done' message.");
        this.f7737a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i10), "TextInputAction.done"));
    }

    public void f(int i10) {
        qa.b.f("TextInputChannel", "Sending 'go' message.");
        this.f7737a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i10), "TextInputAction.go"));
    }

    public void g(int i10) {
        qa.b.f("TextInputChannel", "Sending 'newline' message.");
        this.f7737a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i10), "TextInputAction.newline"));
    }

    public void h(int i10) {
        qa.b.f("TextInputChannel", "Sending 'next' message.");
        this.f7737a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i10), "TextInputAction.next"));
    }

    public void i(int i10, String str, Bundle bundle) {
        HashMap map = new HashMap();
        map.put("action", str);
        if (bundle != null) {
            HashMap map2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    map2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    map2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    map2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    map2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    map2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    map2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    map2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    map2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            map.put("data", map2);
        }
        this.f7737a.c("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i10), map));
    }

    public void j(int i10) {
        qa.b.f("TextInputChannel", "Sending 'previous' message.");
        this.f7737a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i10), "TextInputAction.previous"));
    }

    public void k() {
        this.f7737a.c("TextInputClient.requestExistingInputState", null);
    }

    public void l(int i10) {
        qa.b.f("TextInputChannel", "Sending 'search' message.");
        this.f7737a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i10), "TextInputAction.search"));
    }

    public void m(int i10) {
        qa.b.f("TextInputChannel", "Sending 'send' message.");
        this.f7737a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i10), "TextInputAction.send"));
    }

    public void n(f fVar) {
        this.f7738b = fVar;
    }

    public void o(int i10) {
        qa.b.f("TextInputChannel", "Sending 'unspecified' message.");
        this.f7737a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i10), "TextInputAction.unspecified"));
    }

    public void p(int i10, String str, int i11, int i12, int i13, int i14) {
        qa.b.f("TextInputChannel", "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i11 + "\nSelection end: " + i12 + "\nComposing start: " + i13 + "\nComposing end: " + i14);
        this.f7737a.c("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i10), d(str, i11, i12, i13, i14)));
    }

    public void q(int i10, ArrayList<io.flutter.plugin.editing.e> arrayList) {
        qa.b.f("TextInputChannel", "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        this.f7737a.c("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(Integer.valueOf(i10), c(arrayList)));
    }

    public void r(int i10, HashMap<String, e> map) {
        qa.b.f("TextInputChannel", "Sending message to update editing state for " + String.valueOf(map.size()) + " field(s).");
        HashMap map2 = new HashMap();
        for (Map.Entry<String, e> entry : map.entrySet()) {
            e value = entry.getValue();
            map2.put(entry.getKey(), d(value.f7766a, value.f7767b, value.f7768c, -1, -1));
        }
        this.f7737a.c("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i10), map2));
    }
}
