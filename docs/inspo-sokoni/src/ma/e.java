package ma;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import fb.i;
import fb.j;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class e implements j.c, xa.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f13025c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f13026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f13027b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public final String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = i10 * 2;
            cArr2[i12] = cArr[i11 >>> 4];
            cArr2[i12 + 1] = cArr[i11 & 15];
        }
        return new String(cArr2);
    }

    public final String b(PackageManager packageManager) {
        String strE;
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Context context = this.f13026a;
                k.b(context);
                Signature[] signatureArr = packageManager.getPackageInfo(context.getPackageName(), 64).signatures;
                boolean z10 = true;
                if (signatureArr != null) {
                    if (!(signatureArr.length == 0)) {
                        z10 = false;
                    }
                }
                if (!z10 && mc.k.n(signatureArr) != null) {
                    byte[] byteArray = ((Signature) mc.k.n(signatureArr)).toByteArray();
                    k.d(byteArray, "toByteArray(...)");
                    strE = e(byteArray);
                }
                return null;
            }
            Context context2 = this.f13026a;
            k.b(context2);
            SigningInfo signingInfo = packageManager.getPackageInfo(context2.getPackageName(), 134217728).signingInfo;
            if (signingInfo == null) {
                return null;
            }
            if (signingInfo.hasMultipleSigners()) {
                Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
                k.d(apkContentsSigners, "getApkContentsSigners(...)");
                byte[] byteArray2 = ((Signature) mc.k.n(apkContentsSigners)).toByteArray();
                k.d(byteArray2, "toByteArray(...)");
                strE = e(byteArray2);
            } else {
                Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                k.d(signingCertificateHistory, "getSigningCertificateHistory(...)");
                byte[] byteArray3 = ((Signature) mc.k.n(signingCertificateHistory)).toByteArray();
                k.d(byteArray3, "toByteArray(...)");
                strE = e(byteArray3);
            }
            return strE;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public final String c() {
        Context context = this.f13026a;
        k.b(context);
        PackageManager packageManager = context.getPackageManager();
        Context context2 = this.f13026a;
        k.b(context2);
        String packageName = context2.getPackageName();
        return Build.VERSION.SDK_INT >= 30 ? packageManager.getInstallSourceInfo(packageName).getInitiatingPackageName() : packageManager.getInstallerPackageName(packageName);
    }

    public final long d(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
    }

    public final String e(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        k.b(bArrDigest);
        return a(bArrDigest);
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b binding) {
        k.e(binding, "binding");
        this.f13026a = binding.a();
        j jVar = new j(binding.b(), "dev.fluttercommunity.plus/package_info");
        this.f13027b = jVar;
        k.b(jVar);
        jVar.e(this);
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b binding) {
        k.e(binding, "binding");
        this.f13026a = null;
        j jVar = this.f13027b;
        k.b(jVar);
        jVar.e(null);
        this.f13027b = null;
    }

    @Override // fb.j.c
    public void onMethodCall(i call, j.d result) {
        String string;
        CharSequence charSequenceLoadLabel;
        k.e(call, "call");
        k.e(result, "result");
        try {
            if (!k.a(call.f8284a, "getAll")) {
                result.c();
                return;
            }
            Context context = this.f13026a;
            k.b(context);
            PackageManager packageManager = context.getPackageManager();
            Context context2 = this.f13026a;
            k.b(context2);
            PackageInfo packageInfo = packageManager.getPackageInfo(context2.getPackageName(), 0);
            k.b(packageManager);
            String strB = b(packageManager);
            String strC = c();
            HashMap map = new HashMap();
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            String str = "";
            if (applicationInfo == null || (charSequenceLoadLabel = applicationInfo.loadLabel(packageManager)) == null || (string = charSequenceLoadLabel.toString()) == null) {
                string = "";
            }
            map.put("appName", string);
            Context context3 = this.f13026a;
            k.b(context3);
            map.put("packageName", context3.getPackageName());
            String str2 = packageInfo.versionName;
            if (str2 != null) {
                str = str2;
            }
            map.put("version", str);
            k.b(packageInfo);
            map.put("buildNumber", String.valueOf(d(packageInfo)));
            if (strB != null) {
                map.put("buildSignature", strB);
            }
            if (strC != null) {
                map.put("installerStore", strC);
            }
            result.a(map);
        } catch (PackageManager.NameNotFoundException e10) {
            result.b("Name not found", e10.getMessage(), null);
        }
    }
}
