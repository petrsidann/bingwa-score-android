package u4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzdq;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public final class af extends r8 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f15999i = {"firebase_", "google_", "ga_"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f16000j = {"_err"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f16001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f16002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w1.a f16004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f16005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f16006h;

    public af(k7 k7Var) {
        super(k7Var);
        this.f16006h = null;
        this.f16002d = new AtomicLong(0L);
    }

    public static Bundle C(List<ze> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (ze zeVar : list) {
            String str = zeVar.f17018e;
            if (str != null) {
                bundle.putString(zeVar.f17015b, str);
            } else {
                Long l10 = zeVar.f17017d;
                if (l10 != null) {
                    bundle.putLong(zeVar.f17015b, l10.longValue());
                } else {
                    Double d10 = zeVar.f17020l;
                    if (d10 != null) {
                        bundle.putDouble(zeVar.f17015b, d10.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public static boolean C0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static String E(String str, int i10, boolean z10) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i10) {
            return str;
        }
        if (!z10) {
            return null;
        }
        return str.substring(0, str.offsetByCodePoints(0, i10)) + "...";
    }

    public static boolean E0(String str) {
        com.google.android.gms.common.internal.r.f(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean F0(String str) {
        for (String str2 : f16000j) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static void H(Bundle bundle, int i10, String str, Object obj) {
        if (r0(bundle, i10)) {
            bundle.putString("_ev", E(str, 40, true));
            if (obj != null) {
                com.google.android.gms.common.internal.r.l(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    public static int I0(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return "_lgclid".equals(str) ? 100 : 36;
    }

    public static boolean J0(String str) {
        com.google.android.gms.common.internal.r.l(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    public static MessageDigest O0() {
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                if (messageDigest != null) {
                    return messageDigest;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static void U(hb hbVar, Bundle bundle, boolean z10) {
        if (bundle == null || hbVar == null || (bundle.containsKey("_sc") && !z10)) {
            if (bundle != null && hbVar == null && z10) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = hbVar.f16311a;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = hbVar.f16312b;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", hbVar.f16313c);
    }

    public static void V(cf cfVar, int i10, String str, String str2, int i11) {
        W(cfVar, null, i10, str, str2, i11);
    }

    public static void W(cf cfVar, String str, int i10, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        r0(bundle, i10);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i10 == 6 || i10 == 7 || i10 == 2) {
            bundle.putLong("_el", i11);
        }
        cfVar.a(str, "_err", bundle);
    }

    public static boolean Z(Context context) {
        ActivityInfo receiverInfo;
        com.google.android.gms.common.internal.r.l(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean a0(Context context, boolean z10) {
        com.google.android.gms.common.internal.r.l(context);
        return q0(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    public static boolean b0(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean c0(Bundle bundle, int i10) {
        int i11 = 0;
        if (bundle.size() <= i10) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i11++;
            if (i11 > i10) {
                bundle.remove(str);
            }
        }
        return true;
    }

    public static boolean d0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static boolean i0(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            com.google.android.gms.common.internal.r.l(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return !TextUtils.isEmpty(str4);
            }
            return !str3.equals(str4);
        }
        if (zIsEmpty || !zIsEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public static boolean j0(String str, String[] strArr) {
        com.google.android.gms.common.internal.r.l(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] m0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static ArrayList<Bundle> p0(List<h> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (h hVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", hVar.f16265a);
            bundle.putString("origin", hVar.f16266b);
            bundle.putLong("creation_timestamp", hVar.f16268d);
            bundle.putString("name", hVar.f16267c.f17015b);
            t8.b(bundle, com.google.android.gms.common.internal.r.l(hVar.f16267c.S()));
            bundle.putBoolean("active", hVar.f16269e);
            String str = hVar.f16270f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            n0 n0Var = hVar.f16271l;
            if (n0Var != null) {
                bundle.putString("timed_out_event_name", n0Var.f16569a);
                i0 i0Var = n0Var.f16570b;
                if (i0Var != null) {
                    bundle.putBundle("timed_out_event_params", i0Var.V());
                }
            }
            bundle.putLong("trigger_timeout", hVar.f16272m);
            n0 n0Var2 = hVar.f16273n;
            if (n0Var2 != null) {
                bundle.putString("triggered_event_name", n0Var2.f16569a);
                i0 i0Var2 = n0Var2.f16570b;
                if (i0Var2 != null) {
                    bundle.putBundle("triggered_event_params", i0Var2.V());
                }
            }
            bundle.putLong("triggered_timestamp", hVar.f16267c.f17016c);
            bundle.putLong("time_to_live", hVar.f16274o);
            n0 n0Var3 = hVar.f16275p;
            if (n0Var3 != null) {
                bundle.putString("expired_event_name", n0Var3.f16569a);
                i0 i0Var3 = n0Var3.f16570b;
                if (i0Var3 != null) {
                    bundle.putBundle("expired_event_params", i0Var3.V());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean q0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean r0(Bundle bundle, int i10) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i10);
        return true;
    }

    public static Bundle[] t0(Object obj) {
        Object[] array;
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            array = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else {
            if (!(obj instanceof ArrayList)) {
                return null;
            }
            ArrayList arrayList = (ArrayList) obj;
            array = arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return (Bundle[]) array;
    }

    public static long u(long j10, long j11) {
        return (j10 + (j11 * 60000)) / 86400000;
    }

    public static int u0() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    public static long w(i0 i0Var) {
        long length = 0;
        if (i0Var == null) {
            return 0L;
        }
        Iterator<String> it = i0Var.iterator();
        while (it.hasNext()) {
            Object objX = i0Var.X(it.next());
            if (objX instanceof Parcelable[]) {
                length += (long) ((Parcelable[]) objX).length;
            }
        }
        return length;
    }

    public static long x(byte[] bArr) {
        com.google.android.gms.common.internal.r.l(bArr);
        int i10 = 0;
        com.google.android.gms.common.internal.r.o(bArr.length > 0);
        long j10 = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j10 += (((long) bArr[length]) & 255) << i10;
            i10 += 8;
        }
        return j10;
    }

    public static Bundle z(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i10 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i10 < parcelableArr.length) {
                        if (parcelableArr[i10] instanceof Bundle) {
                            parcelableArr[i10] = new Bundle((Bundle) parcelableArr[i10]);
                        }
                        i10++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i10 < list.size()) {
                        Object obj2 = list.get(i10);
                        if (obj2 instanceof Bundle) {
                            list.set(i10, new Bundle((Bundle) obj2));
                        }
                        i10++;
                    }
                }
            }
        }
        return bundle2;
    }

    public static boolean z0(String str) {
        String strA = p0.f16666m0.a(null);
        return strA.equals("*") || Arrays.asList(strA.split(",")).contains(str);
    }

    public final Bundle A(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object objO0 = o0(str2, bundle.get(str2));
                if (objO0 == null) {
                    zzj().I().b("Param value can't be null", d().f(str2));
                } else {
                    K(bundle2, str2, objO0);
                }
            }
        }
        return bundle2;
    }

    public final boolean A0(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a().P().equals(str);
    }

    public final Bundle B(String str, String str2, Bundle bundle, List<String> list, boolean z10) {
        int iH0;
        int i10;
        boolean zJ0 = j0(str2, y8.f16977d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int iW = a().w();
        int i11 = 0;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str3)) {
                iH0 = !z10 ? H0(str3) : 0;
                if (iH0 == 0) {
                    iH0 = G0(str3);
                }
            } else {
                iH0 = 0;
            }
            if (iH0 != 0) {
                H(bundle2, iH0, str3, iH0 == 3 ? str3 : null);
                bundle2.remove(str3);
                i10 = iW;
            } else {
                i10 = iW;
                int iT = t(str, str2, str3, bundle.get(str3), bundle2, list, z10, zJ0);
                if (iT == 17) {
                    H(bundle2, iT, str3, Boolean.FALSE);
                } else if (iT != 0 && !"_ev".equals(str3)) {
                    H(bundle2, iT, iT == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (E0(str3)) {
                    int i12 = i11 + 1;
                    if (i12 > i10) {
                        zzj().D().c("Event can't contain more than " + i10 + " params", d().b(str2), d().a(bundle));
                        r0(bundle2, 5);
                        bundle2.remove(str3);
                    }
                    i11 = i12;
                }
            }
            iW = i10;
        }
        return bundle2;
    }

    public final boolean B0(String str) {
        j();
        if (l4.d.a(zza()).a(str) == 0) {
            return true;
        }
        zzj().B().b("Permission not granted", str);
        return false;
    }

    public final Object D(int i10, Object obj, boolean z10, boolean z11, String str) {
        Bundle bundleA;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return E(String.valueOf(obj), i10, z10);
        }
        if (!z11 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if ((parcelable instanceof Bundle) && (bundleA = A((Bundle) parcelable, null)) != null && !bundleA.isEmpty()) {
                arrayList.add(bundleA);
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final int D0() {
        if (this.f16006h == null) {
            this.f16006h = Integer.valueOf(c4.f.f().a(zza()) / 1000);
        }
        return this.f16006h.intValue();
    }

    public final URL F(long j10, String str, String str2, long j11, String str3) {
        try {
            com.google.android.gms.common.internal.r.f(str2);
            com.google.android.gms.common.internal.r.f(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j10), Integer.valueOf(D0())), str2, str, Long.valueOf(j11));
            if (str.equals(a().Q())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    strConcat = strConcat.concat("&");
                }
                strConcat = strConcat.concat(str3);
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException | MalformedURLException e10) {
            zzj().C().b("Failed to create BOW URL for Deferred Deep Link. exception", e10.getMessage());
            return null;
        }
    }

    public final n0 G(String str, String str2, Bundle bundle, String str3, long j10, boolean z10, boolean z11) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (r(str2) != 0) {
            zzj().C().b("Invalid conditional property event name", d().g(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleB = B(str, str2, bundle2, j4.e.a("_o"), true);
        if (z10) {
            bundleB = A(bundleB, str);
        }
        com.google.android.gms.common.internal.r.l(bundleB);
        return new n0(str2, new i0(bundleB), str3, j10);
    }

    public final int G0(String str) {
        if (!s0("event param", str)) {
            return 3;
        }
        if (k0("event param", null, str)) {
            return !f0("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    public final int H0(String str) {
        if (!y0("event param", str)) {
            return 3;
        }
        if (k0("event param", null, str)) {
            return !f0("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    public final void I(Bundle bundle, long j10) {
        long j11 = bundle.getLong("_et");
        if (j11 != 0) {
            zzj().H().b("Params already contained engagement", Long.valueOf(j11));
        }
        bundle.putLong("_et", j10 + j11);
    }

    public final void J(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                g().K(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void K(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            zzj().I().c("Not putting event parameter. Invalid value type. name, type", d().f(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final long K0() {
        long j10;
        j();
        if (!z0(this.f16624a.y().C())) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j10 = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j10 = 8;
        } else {
            j10 = u0() < p0.f16654g0.a(null).intValue() ? 16L : 0L;
        }
        if (!B0("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j10 |= 2;
        }
        if (j10 == 0 && !S0()) {
            j10 |= 64;
        }
        if (j10 == 0) {
            return 1L;
        }
        return j10;
    }

    public final void L(zzdq zzdqVar, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i10);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f16624a.zzj().H().b("Error returning int value to wrapper", e10);
        }
    }

    public final long L0() {
        long andIncrement;
        long j10;
        if (this.f16002d.get() != 0) {
            synchronized (this.f16002d) {
                this.f16002d.compareAndSet(-1L, 1L);
                andIncrement = this.f16002d.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.f16002d) {
            long jNextLong = new Random(System.nanoTime() ^ zzb().a()).nextLong();
            int i10 = this.f16003e + 1;
            this.f16003e = i10;
            j10 = jNextLong + ((long) i10);
        }
        return j10;
    }

    public final void M(zzdq zzdqVar, long j10) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j10);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f16624a.zzj().H().b("Error returning long value to wrapper", e10);
        }
    }

    public final w1.a M0() {
        if (this.f16004f == null) {
            this.f16004f = w1.a.a(zza());
        }
        return this.f16004f;
    }

    public final void N(zzdq zzdqVar, Bundle bundle) {
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f16624a.zzj().H().b("Error returning bundle value to wrapper", e10);
        }
    }

    public final String N0() {
        byte[] bArr = new byte[16];
        P0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final void O(zzdq zzdqVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f16624a.zzj().H().b("Error returning string value to wrapper", e10);
        }
    }

    public final void P(zzdq zzdqVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f16624a.zzj().H().b("Error returning bundle list to wrapper", e10);
        }
    }

    public final SecureRandom P0() {
        j();
        if (this.f16001c == null) {
            this.f16001c = new SecureRandom();
        }
        return this.f16001c;
    }

    public final void Q(zzdq zzdqVar, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z10);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f16624a.zzj().H().b("Error returning boolean value to wrapper", e10);
        }
    }

    public final boolean Q0() {
        j();
        return K0() == 1;
    }

    public final void R(zzdq zzdqVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f16624a.zzj().H().b("Error returning byte array to wrapper", e10);
        }
    }

    public final boolean R0() {
        try {
            zza().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void S(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z10) {
        int iH0;
        int iT;
        int i10;
        if (bundle == null) {
            return;
        }
        int i11 = a().g().Y(231100000, true) ? 35 : 0;
        int i12 = 0;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str4)) {
                iH0 = !z10 ? H0(str4) : 0;
                if (iH0 == 0) {
                    iH0 = G0(str4);
                }
            } else {
                iH0 = 0;
            }
            if (iH0 != 0) {
                H(bundle, iH0, str4, iH0 == 3 ? str4 : null);
                bundle.remove(str4);
                i11 = i11;
            } else {
                if (d0(bundle.get(str4))) {
                    zzj().I().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str4);
                    iT = 22;
                } else {
                    iT = t(str, str2, str4, bundle.get(str4), bundle, list, z10, false);
                }
                if (iT == 0 || "_ev".equals(str4)) {
                    if (!E0(str4) || j0(str4, x8.f16953d)) {
                        i10 = i11;
                    } else {
                        int i13 = i12 + 1;
                        if (Y(231100000, true)) {
                            i10 = i11;
                            if (i13 > i10) {
                                zzj().D().c("Item can't contain more than " + i10 + " item-scoped custom params", d().b(str2), d().a(bundle));
                                r0(bundle, 28);
                                bundle.remove(str4);
                            }
                        } else {
                            zzj().D().c("Item array not supported on client's version of Google Play Services (Android Only)", d().b(str2), d().a(bundle));
                            r0(bundle, 23);
                            bundle.remove(str4);
                            i10 = i11;
                        }
                        i12 = i13;
                    }
                    i11 = i10;
                } else {
                    H(bundle, iT, str4, bundle.get(str4));
                    bundle.remove(str4);
                }
            }
            i11 = i11;
        }
    }

    public final boolean S0() {
        Integer num;
        if (this.f16005g == null) {
            w1.a aVarM0 = M0();
            boolean z10 = false;
            if (aVarM0 == null) {
                return false;
            }
            Integer num2 = null;
            try {
                num = aVarM0.b().get(10000L, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z10 = true;
                        }
                    } catch (InterruptedException e10) {
                        e = e10;
                        num2 = num;
                        zzj().H().b("Measurement manager api exception", e);
                        this.f16005g = Boolean.FALSE;
                        num = num2;
                    } catch (CancellationException e11) {
                        e = e11;
                        num2 = num;
                        zzj().H().b("Measurement manager api exception", e);
                        this.f16005g = Boolean.FALSE;
                        num = num2;
                    } catch (ExecutionException e12) {
                        e = e12;
                        num2 = num;
                        zzj().H().b("Measurement manager api exception", e);
                        this.f16005g = Boolean.FALSE;
                        num = num2;
                    } catch (TimeoutException e13) {
                        e = e13;
                        num2 = num;
                        zzj().H().b("Measurement manager api exception", e);
                        this.f16005g = Boolean.FALSE;
                        num = num2;
                    }
                }
                this.f16005g = Boolean.valueOf(z10);
            } catch (InterruptedException e14) {
                e = e14;
            } catch (CancellationException e15) {
                e = e15;
            } catch (ExecutionException e16) {
                e = e16;
            } catch (TimeoutException e17) {
                e = e17;
            }
            zzj().G().b("Measurement manager api status result", num);
        }
        return this.f16005g.booleanValue();
    }

    public final void T(z5 z5Var, int i10) {
        int i11 = 0;
        for (String str : new TreeSet(z5Var.f16994d.keySet())) {
            if (E0(str) && (i11 = i11 + 1) > i10) {
                zzj().D().c("Event can't contain more than " + i10 + " params", d().b(z5Var.f16991a), d().a(z5Var.f16994d));
                r0(z5Var.f16994d, 5);
                z5Var.f16994d.remove(str);
            }
        }
    }

    public final void X(Parcelable[] parcelableArr, int i10) {
        com.google.android.gms.common.internal.r.l(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i11 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (E0(str) && !j0(str, x8.f16953d) && (i11 = i11 + 1) > i10) {
                    zzj().D().c("Param can't contain more than " + i10 + " item-scoped custom parameters", d().f(str), d().a(bundle));
                    r0(bundle, 28);
                    bundle.remove(str);
                }
            }
        }
    }

    public final boolean Y(int i10, boolean z10) {
        Boolean boolY = this.f16624a.I().Y();
        if (D0() < i10 / 1000) {
            return (boolY == null || boolY.booleanValue()) ? false : true;
        }
        return true;
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ h0 c() {
        return super.c();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ s5 d() {
        return super.d();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ i6 e() {
        return super.e();
    }

    public final boolean e0(String str, double d10) {
        try {
            SharedPreferences.Editor editorEdit = zza().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            editorEdit.putString("deeplink", str);
            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(d10));
            return editorEdit.commit();
        } catch (RuntimeException e10) {
            zzj().C().b("Failed to persist Deferred Deep Link. exception", e10);
            return false;
        }
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ ab f() {
        return super.f();
    }

    public final boolean f0(String str, int i10, String str2) {
        if (str2 == null) {
            zzj().D().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i10) {
            return true;
        }
        zzj().D().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i10), str2);
        return false;
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ af g() {
        return super.g();
    }

    public final boolean g0(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (J0(str)) {
                return true;
            }
            if (this.f16624a.p()) {
                zzj().D().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", v5.r(str));
            }
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.f16624a.p()) {
                zzj().D().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        if (J0(str2)) {
            return true;
        }
        zzj().D().b("Invalid admob_app_id. Analytics disabled.", v5.r(str2));
        return false;
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final boolean h0(String str, String str2, int i10, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String strValueOf = String.valueOf(obj);
            if (strValueOf.codePointCount(0, strValueOf.length()) > i10) {
                zzj().I().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
                return false;
            }
        }
        return true;
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    @Override // u4.r8
    public final void k() {
        j();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                zzj().H().a("Utils falling back to Random for random id");
            }
        }
        this.f16002d.set(jNextLong);
    }

    public final boolean k0(String str, String[] strArr, String str2) {
        return l0(str, strArr, null, str2);
    }

    public final boolean l0(String str, String[] strArr, String[] strArr2, String str2) {
        boolean z10;
        if (str2 == null) {
            zzj().D().b("Name is required and can't be null. Type", str);
            return false;
        }
        com.google.android.gms.common.internal.r.l(str2);
        String[] strArr3 = f15999i;
        int length = strArr3.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            if (str2.startsWith(strArr3[i10])) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            zzj().D().c("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr == null || !j0(str2, strArr) || (strArr2 != null && j0(str2, strArr2))) {
            return true;
        }
        zzj().D().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final int n0(String str) {
        if (!s0("user property", str)) {
            return 6;
        }
        if (k0("user property", a9.f15988a, str)) {
            return !f0("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    public final Object o0(String str, Object obj) {
        if ("_ev".equals(str)) {
            return D(a().v(null, false), obj, true, true, null);
        }
        return D(C0(str) ? a().v(null, false) : a().n(null, false), obj, false, true, null);
    }

    @Override // u4.r8
    public final boolean p() {
        return true;
    }

    public final int q(int i10) {
        return c4.f.f().h(zza(), 12451000);
    }

    public final int r(String str) {
        if (!s0("event", str)) {
            return 2;
        }
        if (l0("event", y8.f16974a, y8.f16975b, str)) {
            return !f0("event", 40, str) ? 2 : 0;
        }
        return 13;
    }

    public final int s(String str, Object obj) {
        return h0("_ldl".equals(str) ? "user property referrer" : "user property", str, I0(str), obj) ? 0 : 7;
    }

    public final boolean s0(String str, String str2) {
        if (str2 == null) {
            zzj().D().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzj().D().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            zzj().D().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzj().D().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005b  */
    /* JADX WARN: Code duplicated, block: B:23:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0060  */
    /* JADX WARN: Code duplicated, block: B:26:0x0066  */
    /* JADX WARN: Code duplicated, block: B:27:0x0070  */
    /* JADX WARN: Code duplicated, block: B:29:0x0074  */
    /* JADX WARN: Code duplicated, block: B:31:0x007d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0090  */
    public final int t(String str, String str2, String str3, Object obj, Bundle bundle, List<String> list, boolean z10, boolean z11) {
        int i10;
        int size;
        boolean z12;
        ArrayList arrayList;
        Parcelable[] parcelableArr;
        j();
        boolean z13 = true;
        if (!d0(obj)) {
            i10 = 0;
        } else {
            if (!z11) {
                return 21;
            }
            if (!j0(str3, x8.f16952c)) {
                return 20;
            }
            if (!this.f16624a.I().h0()) {
                return 25;
            }
            boolean z14 = obj instanceof Parcelable[];
            if (z14) {
                size = ((Parcelable[]) obj).length;
            } else {
                if (obj instanceof ArrayList) {
                    size = ((ArrayList) obj).size();
                } else {
                    z12 = true;
                }
                if (z12) {
                    i10 = 0;
                } else {
                    if (z14) {
                        parcelableArr = (Parcelable[]) obj;
                        if (parcelableArr.length > 200) {
                            bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                        }
                    } else if (obj instanceof ArrayList) {
                        arrayList = (ArrayList) obj;
                        if (arrayList.size() > 200) {
                            bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                        }
                    }
                    i10 = 17;
                }
            }
            if (size > 200) {
                zzj().I().d("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                if (z14) {
                    parcelableArr = (Parcelable[]) obj;
                    if (parcelableArr.length > 200) {
                        bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                    }
                } else if (obj instanceof ArrayList) {
                    arrayList = (ArrayList) obj;
                    if (arrayList.size() > 200) {
                        bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                    }
                }
                i10 = 17;
            } else {
                i10 = 0;
            }
        }
        if (h0("param", str3, (C0(str2) || C0(str3)) ? a().v(null, false) : a().n(null, false), obj)) {
            return i10;
        }
        if (!z11) {
            return 4;
        }
        if (obj instanceof Bundle) {
            S(str, str2, str3, (Bundle) obj, list, z10);
        } else if (!(obj instanceof Parcelable[])) {
            if (!(obj instanceof ArrayList)) {
                z13 = false;
                break;
            }
            ArrayList arrayList2 = (ArrayList) obj;
            int size2 = arrayList2.size();
            int i11 = 0;
            while (i11 < size2) {
                Object obj2 = arrayList2.get(i11);
                int i12 = i11 + 1;
                if (!(obj2 instanceof Bundle)) {
                    zzj().I().c("All ArrayList elements must be of type Bundle. Value type, name", obj2 != null ? obj2.getClass() : "null", str3);
                    z13 = false;
                    break;
                }
                S(str, str2, str3, (Bundle) obj2, list, z10);
                i11 = i12;
            }
        } else {
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (!(parcelable instanceof Bundle)) {
                    zzj().I().c("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                    z13 = false;
                    break;
                }
                S(str, str2, str3, (Bundle) parcelable, list, z10);
            }
        }
        if (z13) {
            return i10;
        }
        return 4;
    }

    public final long v(Context context, String str) {
        j();
        com.google.android.gms.common.internal.r.l(context);
        com.google.android.gms.common.internal.r.f(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest messageDigestO0 = O0();
        long jX = -1;
        if (messageDigestO0 == null) {
            zzj().C().a("Could not get MD5 instance");
            return -1L;
        }
        if (packageManager != null) {
            try {
                if (!x0(context, str)) {
                    Signature[] signatureArr = l4.d.a(context).e(zza().getPackageName(), 64).signatures;
                    if (signatureArr == null || signatureArr.length <= 0) {
                        zzj().H().a("Could not get signatures");
                    } else {
                        jX = x(messageDigestO0.digest(signatureArr[0].toByteArray()));
                    }
                    return jX;
                }
            } catch (PackageManager.NameNotFoundException e10) {
                zzj().C().b("Package name not found", e10);
            }
        }
        return 0L;
    }

    public final long v0(String str) {
        if (zza().getPackageManager() == null) {
            return 0L;
        }
        int i10 = 0;
        try {
            ApplicationInfo applicationInfoC = l4.d.a(zza()).c(str, 0);
            if (applicationInfoC != null) {
                i10 = applicationInfoC.targetSdkVersion;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            zzj().F().b("PackageManager failed to find running app: app_id", str);
        }
        return i10;
    }

    public final Object w0(String str, Object obj) {
        return "_ldl".equals(str) ? D(I0(str), obj, true, false, null) : D(I0(str), obj, false, false, null);
    }

    public final boolean x0(Context context, String str) {
        x5 x5VarC;
        String str2;
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoE = l4.d.a(context).e(str, 64);
            if (packageInfoE == null || (signatureArr = packageInfoE.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e10) {
            e = e10;
            x5VarC = zzj().C();
            str2 = "Package name not found";
            x5VarC.b(str2, e);
            return true;
        } catch (CertificateException e11) {
            e = e11;
            x5VarC = zzj().C();
            str2 = "Error obtaining certificate";
            x5VarC.b(str2, e);
            return true;
        }
    }

    public final Bundle y(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = uri.getQueryParameter("gbraid");
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = uri.getQueryParameter("sfmc_id");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("gad_source", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString("term", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("content", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("aclid", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("cp1", queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("source_platform", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("creative_format", queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString("marketing_tactic", queryParameter18);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString("sfmc_id", queryParameter9);
            }
            return bundle;
        } catch (UnsupportedOperationException e10) {
            zzj().H().b("Install referrer url isn't a hierarchical URI", e10);
            return null;
        }
    }

    public final boolean y0(String str, String str2) {
        if (str2 == null) {
            zzj().D().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzj().D().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            zzj().D().c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzj().D().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ j4.d zzb() {
        return super.zzb();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ g zzd() {
        return super.zzd();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ v5 zzj() {
        return super.zzj();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ d7 zzl() {
        return super.zzl();
    }
}
