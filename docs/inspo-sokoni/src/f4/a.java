package f4;

import android.util.Log;
import com.google.android.gms.common.internal.i;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f8170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8171d;

    public a(String str, String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append("] ");
            string = sb2.toString();
        }
        this.f8169b = string;
        this.f8168a = str;
        this.f8170c = new i(str);
        int i10 = 2;
        while (i10 <= 7 && !Log.isLoggable(this.f8168a, i10)) {
            i10++;
        }
        this.f8171d = i10;
    }

    public void a(String str, Object... objArr) {
        if (f(3)) {
            Log.d(this.f8168a, d(str, objArr));
        }
    }

    public void b(String str, Throwable th, Object... objArr) {
        Log.e(this.f8168a, d(str, objArr), th);
    }

    public void c(String str, Object... objArr) {
        Log.e(this.f8168a, d(str, objArr));
    }

    public String d(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f8169b.concat(str);
    }

    public void e(String str, Object... objArr) {
        Log.i(this.f8168a, d(str, objArr));
    }

    public boolean f(int i10) {
        return this.f8171d <= i10;
    }

    public void g(String str, Object... objArr) {
        if (f(2)) {
            Log.v(this.f8168a, d(str, objArr));
        }
    }

    public void h(String str, Object... objArr) {
        Log.w(this.f8168a, d(str, objArr));
    }

    public void i(String str, Throwable th, Object... objArr) {
        Log.wtf(this.f8168a, d(str, objArr), th);
    }

    public void j(Throwable th) {
        Log.wtf(this.f8168a, th);
    }
}
