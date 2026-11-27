package j4;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.internal.common.zzab;
import com.google.android.gms.internal.common.zzac;
import com.google.android.gms.internal.common.zzj;
import com.google.android.gms.internal.common.zzl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f11234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f11235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f11236c;

    public static String a() throws Throwable {
        BufferedReader bufferedReader;
        if (f11234a == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                f11234a = Application.getProcessName();
            } else {
                int iMyPid = f11235b;
                if (iMyPid == 0) {
                    iMyPid = Process.myPid();
                    f11235b = iMyPid;
                }
                String strTrim = null;
                strTrim = null;
                strTrim = null;
                BufferedReader bufferedReader2 = null;
                if (iMyPid > 0) {
                    try {
                        String str = "/proc/" + iMyPid + "/cmdline";
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(str));
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            try {
                                String line = bufferedReader.readLine();
                                com.google.android.gms.common.internal.r.l(line);
                                strTrim = line.trim();
                            } catch (IOException unused) {
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader;
                                j.a(bufferedReader2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            throw th2;
                        }
                    } catch (IOException unused2) {
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    j.a(bufferedReader);
                }
                f11234a = strTrim;
            }
        }
        return f11234a;
    }

    public static boolean b() {
        Boolean boolValueOf = f11236c;
        if (boolValueOf == null) {
            if (m.f()) {
                boolValueOf = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Object objZza = zzl.zza(Process.class, "isIsolated", new zzj[0]);
                    Object[] objArr = new Object[0];
                    if (objZza == null) {
                        throw new zzac(zzab.zza("expected a non-null reference", objArr));
                    }
                    boolValueOf = (Boolean) objZza;
                } catch (ReflectiveOperationException unused) {
                    boolValueOf = Boolean.FALSE;
                }
            }
            f11236c = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }
}
