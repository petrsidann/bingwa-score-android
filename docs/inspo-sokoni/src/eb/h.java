package eb;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.j f7600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f7601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fb.j.c f7602c;

    public class a implements fb.j.c {
        public a() {
        }

        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            if (h.this.f7601b == null) {
                return;
            }
            String str = iVar.f8284a;
            str.hashCode();
            if (!str.equals("Localization.getStringResource")) {
                dVar.c();
                return;
            }
            JSONObject jSONObject = (JSONObject) iVar.b();
            try {
                dVar.a(h.this.f7601b.a(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
            } catch (JSONException e10) {
                dVar.b("error", e10.getMessage(), null);
            }
        }
    }

    public interface b {
        String a(String str, String str2);
    }

    public h(ta.a aVar) {
        a aVar2 = new a();
        this.f7602c = aVar2;
        fb.j jVar = new fb.j(aVar, "flutter/localization", fb.f.f8283a);
        this.f7600a = jVar;
        jVar.e(aVar2);
    }

    public void b(List<Locale> list) {
        qa.b.f("LocalizationChannel", "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            qa.b.f("LocalizationChannel", "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(locale.getScript());
            arrayList.add(locale.getVariant());
        }
        this.f7600a.c("setLocale", arrayList);
    }

    public void c(b bVar) {
        this.f7601b = bVar;
    }
}
