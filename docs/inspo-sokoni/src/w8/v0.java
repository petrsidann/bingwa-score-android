package w8;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f17790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17792c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f17794e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<String> f17793d = new ArrayDeque<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17795f = false;

    public v0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f17790a = sharedPreferences;
        this.f17791b = str;
        this.f17792c = str2;
        this.f17794e = executor;
    }

    public static v0 d(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        v0 v0Var = new v0(sharedPreferences, str, str2, executor);
        v0Var.e();
        return v0Var;
    }

    public boolean b(String str) {
        boolean zC;
        if (TextUtils.isEmpty(str) || str.contains(this.f17792c)) {
            return false;
        }
        synchronized (this.f17793d) {
            zC = c(this.f17793d.add(str));
        }
        return zC;
    }

    public final boolean c(boolean z10) {
        if (z10 && !this.f17795f) {
            j();
        }
        return z10;
    }

    public final void e() {
        synchronized (this.f17793d) {
            this.f17793d.clear();
            String string = this.f17790a.getString(this.f17791b, "");
            if (!TextUtils.isEmpty(string) && string.contains(this.f17792c)) {
                String[] strArrSplit = string.split(this.f17792c, -1);
                if (strArrSplit.length == 0) {
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str : strArrSplit) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f17793d.add(str);
                    }
                }
            }
        }
    }

    public String f() {
        String strPeek;
        synchronized (this.f17793d) {
            strPeek = this.f17793d.peek();
        }
        return strPeek;
    }

    public boolean g(Object obj) {
        boolean zC;
        synchronized (this.f17793d) {
            zC = c(this.f17793d.remove(obj));
        }
        return zC;
    }

    public String h() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.f17793d.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            sb2.append(this.f17792c);
        }
        return sb2.toString();
    }

    public final void i() {
        synchronized (this.f17793d) {
            this.f17790a.edit().putString(this.f17791b, h()).commit();
        }
    }

    public final void j() {
        this.f17794e.execute(new Runnable() { // from class: w8.u0
            @Override // java.lang.Runnable
            public final void run() {
                this.f17788a.i();
            }
        });
    }
}
