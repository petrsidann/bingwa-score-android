package gb;

import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import eb.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f9127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f9128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h.b f9129c;

    /* JADX INFO: renamed from: gb.a$a, reason: collision with other inner class name */
    public class C0156a implements h.b {
        public C0156a() {
        }

        @Override // eb.h.b
        public String a(String str, String str2) {
            Context contextCreateConfigurationContext = a.this.f9128b;
            if (str2 != null) {
                Locale localeB = a.b(str2);
                Configuration configuration = new Configuration(a.this.f9128b.getResources().getConfiguration());
                configuration.setLocale(localeB);
                contextCreateConfigurationContext = a.this.f9128b.createConfigurationContext(configuration);
            }
            int identifier = contextCreateConfigurationContext.getResources().getIdentifier(str, "string", a.this.f9128b.getPackageName());
            if (identifier != 0) {
                return contextCreateConfigurationContext.getResources().getString(identifier);
            }
            return null;
        }
    }

    public a(Context context, h hVar) {
        C0156a c0156a = new C0156a();
        this.f9129c = c0156a;
        this.f9128b = context;
        this.f9127a = hVar;
        hVar.c(c0156a);
    }

    public static Locale b(String str) {
        String str2;
        String[] strArrSplit = str.replace('_', '-').split("-", -1);
        String str3 = strArrSplit[0];
        String str4 = "";
        int i10 = 1;
        if (strArrSplit.length <= 1 || strArrSplit[1].length() != 4) {
            str2 = "";
        } else {
            str2 = strArrSplit[1];
            i10 = 2;
        }
        if (strArrSplit.length > i10 && strArrSplit[i10].length() >= 2 && strArrSplit[i10].length() <= 3) {
            str4 = strArrSplit[i10];
        }
        return new Locale(str3, str4, str2);
    }

    public Locale c(List<Locale> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        LocaleList locales = this.f9128b.getResources().getConfiguration().getLocales();
        int size = locales.size();
        for (int i10 = 0; i10 < size; i10++) {
            Locale locale = locales.get(i10);
            String language = locale.getLanguage();
            if (!locale.getScript().isEmpty()) {
                language = language + "-" + locale.getScript();
            }
            if (!locale.getCountry().isEmpty()) {
                language = language + "-" + locale.getCountry();
            }
            arrayList.add(new Locale.LanguageRange(language));
            arrayList.add(new Locale.LanguageRange(locale.getLanguage()));
            arrayList.add(new Locale.LanguageRange(locale.getLanguage() + "-*"));
        }
        Locale localeLookup = Locale.lookup(arrayList, list);
        return localeLookup != null ? localeLookup : list.get(0);
    }

    public void d(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        LocaleList locales = configuration.getLocales();
        int size = locales.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(locales.get(i10));
        }
        this.f9127a.b(arrayList);
    }
}
