package eb;

import d9.a0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.j f7611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f7612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fb.j.c f7613c;

    public class a implements fb.j.c {
        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:54:0x00d6  */
        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            String message;
            e eVarH;
            JSONObject jSONObject;
            if (k.this.f7612b == null) {
            }
            String str = iVar.f8284a;
            Object obj = iVar.f8285b;
            qa.b.f("PlatformChannel", "Received '" + str + "' message.");
            try {
                switch (str) {
                    case "SystemSound.play":
                        try {
                            k.this.f7612b.n(i.h((String) obj));
                            dVar.a(null);
                            break;
                        } catch (NoSuchFieldException e10) {
                            message = e10.getMessage();
                            dVar.b("error", message, null);
                            return;
                        }
                        break;
                    case "HapticFeedback.vibrate":
                        try {
                            k.this.f7612b.i(g.h((String) obj));
                            dVar.a(null);
                            break;
                        } catch (NoSuchFieldException e11) {
                            message = e11.getMessage();
                            dVar.b("error", message, null);
                            return;
                        }
                        break;
                    case "SystemChrome.setPreferredOrientations":
                        try {
                            k.this.f7612b.r(k.this.h((JSONArray) obj));
                            dVar.a(null);
                            break;
                        } catch (NoSuchFieldException | JSONException e12) {
                            message = e12.getMessage();
                            dVar.b("error", message, null);
                            return;
                        }
                        break;
                    case "SystemChrome.setApplicationSwitcherDescription":
                        try {
                            k.this.f7612b.q(k.this.g((JSONObject) obj));
                            dVar.a(null);
                            break;
                        } catch (JSONException e13) {
                            message = e13.getMessage();
                            dVar.b("error", message, null);
                            return;
                        }
                        break;
                    case "SystemChrome.setEnabledSystemUIOverlays":
                        try {
                            k.this.f7612b.h(k.this.k((JSONArray) obj));
                            dVar.a(null);
                            break;
                        } catch (NoSuchFieldException | JSONException e14) {
                            message = e14.getMessage();
                            dVar.b("error", message, null);
                            return;
                        }
                        break;
                    case "SystemChrome.setEnabledSystemUIMode":
                        try {
                            k.this.f7612b.l(k.this.j((String) obj));
                            dVar.a(null);
                            break;
                        } catch (NoSuchFieldException | JSONException e15) {
                            message = e15.getMessage();
                            dVar.b("error", message, null);
                            return;
                        }
                        break;
                    case "SystemChrome.setSystemUIChangeListener":
                        k.this.f7612b.o();
                        dVar.a(null);
                        break;
                    case "SystemChrome.restoreSystemUIOverlays":
                        k.this.f7612b.p();
                        dVar.a(null);
                        break;
                    case "SystemChrome.setSystemUIOverlayStyle":
                        try {
                            k.this.f7612b.g(k.this.i((JSONObject) obj));
                            dVar.a(null);
                            break;
                        } catch (NoSuchFieldException | JSONException e16) {
                            message = e16.getMessage();
                            dVar.b("error", message, null);
                            return;
                        }
                        break;
                    case "SystemNavigator.setFrameworkHandlesBack":
                        k.this.f7612b.f(((Boolean) obj).booleanValue());
                        dVar.a(null);
                        break;
                    case "SystemNavigator.pop":
                        k.this.f7612b.b();
                        dVar.a(null);
                        break;
                    case "Clipboard.getData":
                        String str2 = (String) obj;
                        if (str2 != null) {
                            try {
                                eVarH = e.h(str2);
                            } catch (NoSuchFieldException unused) {
                                dVar.b("error", "No such clipboard content format: " + str2, null);
                                eVarH = null;
                            }
                            break;
                        } else {
                            eVarH = null;
                        }
                        CharSequence charSequenceM = k.this.f7612b.m(eVarH);
                        if (charSequenceM != null) {
                            jSONObject = new JSONObject();
                            jSONObject.put("text", charSequenceM);
                            dVar.a(jSONObject);
                            break;
                        }
                        dVar.a(null);
                        break;
                    case "Clipboard.setData":
                        k.this.f7612b.j(((JSONObject) obj).getString("text"));
                        dVar.a(null);
                        break;
                    case "Clipboard.hasStrings":
                        boolean zS = k.this.f7612b.s();
                        jSONObject = new JSONObject();
                        jSONObject.put("value", zS);
                        dVar.a(jSONObject);
                        break;
                    case "Share.invoke":
                        k.this.f7612b.k((String) obj);
                        dVar.a(null);
                        break;
                    default:
                        dVar.c();
                        break;
                }
            } catch (JSONException e17) {
                dVar.b("error", "JSON error: " + e17.getMessage(), null);
            }
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f7616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f7617c;

        static {
            int[] iArr = new int[EnumC0128k.values().length];
            f7617c = iArr;
            try {
                iArr[EnumC0128k.LEAN_BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7617c[EnumC0128k.IMMERSIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7617c[EnumC0128k.IMMERSIVE_STICKY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7617c[EnumC0128k.EDGE_TO_EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[l.values().length];
            f7616b = iArr2;
            try {
                iArr2[l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7616b[l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[f.values().length];
            f7615a = iArr3;
            try {
                iArr3[f.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7615a[f.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7615a[f.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7615a[f.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7619b;

        public c(int i10, String str) {
            this.f7618a = i10;
            this.f7619b = str;
        }
    }

    public enum d {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7623a;

        d(String str) {
            this.f7623a = str;
        }

        public static d h(String str) throws NoSuchFieldException {
            for (d dVar : values()) {
                if (dVar.f7623a.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    public enum e {
        PLAIN_TEXT("text/plain");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7626a;

        e(String str) {
            this.f7626a = str;
        }

        public static e h(String str) throws NoSuchFieldException {
            for (e eVar : values()) {
                if (eVar.f7626a.equals(str)) {
                    return eVar;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    public enum f {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7632a;

        f(String str) {
            this.f7632a = str;
        }

        public static f h(String str) throws NoSuchFieldException {
            for (f fVar : values()) {
                if (fVar.f7632a.equals(str)) {
                    return fVar;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    public enum g {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7639a;

        g(String str) {
            this.f7639a = str;
        }

        public static g h(String str) throws NoSuchFieldException {
            for (g gVar : values()) {
                String str2 = gVar.f7639a;
                if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    public interface h {
        void b();

        default void f(boolean z10) {
        }

        void g(j jVar);

        void h(List<l> list);

        void i(g gVar);

        void j(String str);

        void k(String str);

        void l(EnumC0128k enumC0128k);

        CharSequence m(e eVar);

        void n(i iVar);

        void o();

        void p();

        void q(c cVar);

        void r(int i10);

        boolean s();
    }

    public enum i {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7643a;

        i(String str) {
            this.f7643a = str;
        }

        public static i h(String str) throws NoSuchFieldException {
            for (i iVar : values()) {
                if (iVar.f7643a.equals(str)) {
                    return iVar;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f7644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f7645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f7646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f7647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final d f7648e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f7649f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Boolean f7650g;

        public j(Integer num, d dVar, Boolean bool, Integer num2, d dVar2, Integer num3, Boolean bool2) {
            this.f7644a = num;
            this.f7645b = dVar;
            this.f7646c = bool;
            this.f7647d = num2;
            this.f7648e = dVar2;
            this.f7649f = num3;
            this.f7650g = bool2;
        }
    }

    /* JADX INFO: renamed from: eb.k$k, reason: collision with other inner class name */
    public enum EnumC0128k {
        LEAN_BACK("SystemUiMode.leanBack"),
        IMMERSIVE("SystemUiMode.immersive"),
        IMMERSIVE_STICKY("SystemUiMode.immersiveSticky"),
        EDGE_TO_EDGE("SystemUiMode.edgeToEdge");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7656a;

        EnumC0128k(String str) {
            this.f7656a = str;
        }

        public static EnumC0128k h(String str) throws NoSuchFieldException {
            for (EnumC0128k enumC0128k : values()) {
                if (enumC0128k.f7656a.equals(str)) {
                    return enumC0128k;
                }
            }
            throw new NoSuchFieldException("No such SystemUiMode: " + str);
        }
    }

    public enum l {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7660a;

        l(String str) {
            this.f7660a = str;
        }

        public static l h(String str) throws NoSuchFieldException {
            for (l lVar : values()) {
                if (lVar.f7660a.equals(str)) {
                    return lVar;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public k(ta.a aVar) {
        a aVar2 = new a();
        this.f7613c = aVar2;
        fb.j jVar = new fb.j(aVar, "flutter/platform", fb.f.f8283a);
        this.f7611a = jVar;
        jVar.e(aVar2);
    }

    public final c g(JSONObject jSONObject) throws JSONException {
        int i10 = jSONObject.getInt("primaryColor");
        if (i10 != 0) {
            i10 |= -16777216;
        }
        return new c(i10, jSONObject.getString("label"));
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0053 A[RETURN] */
    public final int h(JSONArray jSONArray) throws NoSuchFieldException {
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < jSONArray.length(); i12++) {
            int i13 = b.f7615a[f.h(jSONArray.getString(i12)).ordinal()];
            if (i13 == 1) {
                i10 |= 1;
            } else if (i13 == 2) {
                i10 |= 4;
            } else if (i13 == 3) {
                i10 |= 2;
            } else if (i13 == 4) {
                i10 |= 8;
            }
            if (i11 == 0) {
                i11 = i10;
            }
        }
        if (i10 == 0) {
            return -1;
        }
        switch (i10) {
            case 2:
                return 0;
            case 3:
            case 6:
            case 7:
            case 9:
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 13:
            case 14:
                if (i11 != 2) {
                    if (i11 == 4) {
                        return 9;
                    }
                    if (i11 != 8) {
                        return 1;
                    }
                    return 8;
                }
                return 0;
            case 4:
                return 9;
            case 5:
                return 12;
            case 8:
                return 8;
            case 10:
                return 11;
            case 11:
                return 2;
            case 15:
                return 13;
            default:
                return 1;
        }
    }

    public final j i(JSONObject jSONObject) {
        return new j(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? d.h(jSONObject.getString("statusBarIconBrightness")) : null, !jSONObject.isNull("systemStatusBarContrastEnforced") ? Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced")) : null, !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null, !jSONObject.isNull("systemNavigationBarIconBrightness") ? d.h(jSONObject.getString("systemNavigationBarIconBrightness")) : null, !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null, jSONObject.isNull("systemNavigationBarContrastEnforced") ? null : Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced")));
    }

    public final EnumC0128k j(String str) {
        int i10 = b.f7617c[EnumC0128k.h(str).ordinal()];
        if (i10 == 1) {
            return EnumC0128k.LEAN_BACK;
        }
        if (i10 == 2) {
            return EnumC0128k.IMMERSIVE;
        }
        if (i10 != 3) {
            return i10 != 4 ? EnumC0128k.EDGE_TO_EDGE : EnumC0128k.EDGE_TO_EDGE;
        }
        return EnumC0128k.IMMERSIVE_STICKY;
    }

    public final List<l> k(JSONArray jSONArray) throws NoSuchFieldException {
        l lVar;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            int i11 = b.f7616b[l.h(jSONArray.getString(i10)).ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    lVar = l.BOTTOM_OVERLAYS;
                }
            } else {
                lVar = l.TOP_OVERLAYS;
            }
            arrayList.add(lVar);
        }
        return arrayList;
    }

    public void l(h hVar) {
        this.f7612b = hVar;
    }

    public void m(boolean z10) {
        qa.b.f("PlatformChannel", "Sending 'systemUIChange' message.");
        this.f7611a.c("SystemChrome.systemUIChange", Arrays.asList(Boolean.valueOf(z10)));
    }
}
