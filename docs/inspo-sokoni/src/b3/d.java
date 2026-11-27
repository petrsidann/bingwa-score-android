package b3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import c3.j;
import c3.k;
import c3.l;
import c3.n;
import c3.o;
import c3.p;
import d3.h;
import d3.i;
import e3.f;
import e3.g;
import e3.m;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w7.a f2770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f2771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f2772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URL f2773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n3.a f2774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n3.a f2775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2776g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final URL f2777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f2778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f2779c;

        public a(URL url, j jVar, String str) {
            this.f2777a = url;
            this.f2778b = jVar;
            this.f2779c = str;
        }

        public a a(URL url) {
            return new a(url, this.f2778b, this.f2779c);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final URL f2781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f2782c;

        public b(int i10, URL url, long j10) {
            this.f2780a = i10;
            this.f2781b = url;
            this.f2782c = j10;
        }
    }

    public d(Context context, n3.a aVar, n3.a aVar2) {
        this(context, aVar, aVar2, 130000);
    }

    public d(Context context, n3.a aVar, n3.a aVar2, int i10) {
        this.f2770a = j.b();
        this.f2772c = context;
        this.f2771b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f2773d = n(b3.a.f2761c);
        this.f2774e = aVar2;
        this.f2775f = aVar;
        this.f2776g = i10;
    }

    public static int f(NetworkInfo networkInfo) {
        o.b bVar;
        if (networkInfo == null) {
            bVar = o.b.UNKNOWN_MOBILE_SUBTYPE;
        } else {
            int subtype = networkInfo.getSubtype();
            if (subtype != -1) {
                if (o.b.d(subtype) != null) {
                    return subtype;
                }
                return 0;
            }
            bVar = o.b.COMBINED;
        }
        return bVar.h();
    }

    public static int g(NetworkInfo networkInfo) {
        return networkInfo == null ? o.c.NONE.h() : networkInfo.getType();
    }

    public static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            h3.a.c("CctTransportBackend", "Unable to find version code for package", e10);
            return -1;
        }
    }

    public static TelephonyManager j(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    public static long k() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    public static /* synthetic */ a l(a aVar, b bVar) {
        URL url = bVar.f2781b;
        if (url == null) {
            return null;
        }
        h3.a.a("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f2781b);
    }

    public static InputStream m(InputStream inputStream, String str) {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    public static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException("Invalid url: " + str, e10);
        }
    }

    @Override // e3.m
    public g a(f fVar) {
        j jVarI = i(fVar);
        URL urlN = this.f2773d;
        String strD = null;
        if (fVar.c() != null) {
            try {
                b3.a aVarC = b3.a.c(fVar.c());
                strD = aVarC.d() != null ? aVarC.d() : null;
                if (aVarC.e() != null) {
                    urlN = n(aVarC.e());
                }
            } catch (IllegalArgumentException unused) {
                return g.a();
            }
        }
        try {
            b bVar = (b) i3.b.a(5, new a(urlN, jVarI, strD), new i3.a() { // from class: b3.b
                @Override // i3.a
                public final Object apply(Object obj) {
                    return this.f2769a.e((d.a) obj);
                }
            }, new i3.c() { // from class: b3.c
                @Override // i3.c
                public final Object a(Object obj, Object obj2) {
                    return d.l((d.a) obj, (d.b) obj2);
                }
            });
            int i10 = bVar.f2780a;
            if (i10 == 200) {
                return g.e(bVar.f2782c);
            }
            if (i10 < 500 && i10 != 404) {
                return i10 == 400 ? g.d() : g.a();
            }
            return g.f();
        } catch (IOException e10) {
            h3.a.c("CctTransportBackend", "Could not make request to the backend", e10);
            return g.f();
        }
    }

    @Override // e3.m
    public i b(i iVar) {
        NetworkInfo activeNetworkInfo = this.f2771b.getActiveNetworkInfo();
        return iVar.l().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", k()).a("net-type", g(activeNetworkInfo)).a("mobile-subtype", f(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", j(this.f2772c).getSimOperator()).c("application_build", Integer.toString(h(this.f2772c))).d();
    }

    public final b e(a aVar) throws IOException {
        h3.a.e("CctTransportBackend", "Making request to: %s", aVar.f2777a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f2777a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f2776g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.1.9"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f2779c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f2770a.a(aVar.f2778b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    h3.a.e("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    h3.a.a("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    h3.a.a("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamM = m(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        try {
                            b bVar = new b(responseCode, null, n.b(new BufferedReader(new InputStreamReader(inputStreamM))).c());
                            if (inputStreamM != null) {
                                inputStreamM.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } catch (Throwable th) {
                            if (inputStreamM != null) {
                                try {
                                    inputStreamM.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
            } catch (Throwable th7) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                    }
                }
                throw th7;
            }
        } catch (ConnectException e10) {
            e = e10;
            h3.a.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e11) {
            e = e11;
            h3.a.c("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e12) {
            e = e12;
            h3.a.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (w7.c e13) {
            e = e13;
            h3.a.c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    public final j i(f fVar) {
        l.a aVarJ;
        HashMap map = new HashMap();
        for (i iVar : fVar.b()) {
            String strJ = iVar.j();
            if (map.containsKey(strJ)) {
                ((List) map.get(strJ)).add(iVar);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iVar);
                map.put(strJ, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            i iVar2 = (i) ((List) entry.getValue()).get(0);
            c3.m.a aVarB = c3.m.a().f(p.DEFAULT).g(this.f2775f.a()).h(this.f2774e.a()).b(k.a().c(k.b.ANDROID_FIREBASE).b(c3.a.a().m(Integer.valueOf(iVar2.g("sdk-version"))).j(iVar2.b("model")).f(iVar2.b("hardware")).d(iVar2.b("device")).l(iVar2.b("product")).k(iVar2.b("os-uild")).h(iVar2.b("manufacturer")).e(iVar2.b("fingerprint")).c(iVar2.b("country")).g(iVar2.b("locale")).i(iVar2.b("mcc_mnc")).b(iVar2.b("application_build")).a()).a());
            try {
                aVarB.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                aVarB.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (i iVar3 : (List) entry.getValue()) {
                h hVarE = iVar3.e();
                a3.c cVarB = hVarE.b();
                if (cVarB.equals(a3.c.b("proto"))) {
                    aVarJ = l.j(hVarE.a());
                } else if (cVarB.equals(a3.c.b("json"))) {
                    aVarJ = l.i(new String(hVarE.a(), Charset.forName("UTF-8")));
                } else {
                    h3.a.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", cVarB);
                }
                aVarJ.c(iVar3.f()).d(iVar3.k()).h(iVar3.h("tz-offset")).e(o.a().c(o.c.d(iVar3.g("net-type"))).b(o.b.d(iVar3.g("mobile-subtype"))).a());
                if (iVar3.d() != null) {
                    aVarJ.b(iVar3.d());
                }
                arrayList3.add(aVarJ.a());
            }
            aVarB.c(arrayList3);
            arrayList2.add(aVarB.a());
        }
        return j.a(arrayList2);
    }
}
