package e0;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f6788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence[] f6789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f6792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f6793g;

    public static class a {
        public static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(h1 h1Var) {
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(h1Var.i()).setLabel(h1Var.h()).setChoices(h1Var.e()).setAllowFreeFormInput(h1Var.c()).addExtras(h1Var.g());
            Set<String> setD = h1Var.d();
            if (setD != null) {
                Iterator<String> it = setD.iterator();
                while (it.hasNext()) {
                    b.d(builderAddExtras, it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(builderAddExtras, h1Var.f());
            }
            return builderAddExtras.build();
        }

        public static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    public static class b {
        public static void a(h1 h1Var, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(h1.a(h1Var), intent, map);
        }

        public static Set<String> b(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        public static Map<String, Uri> c(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }

        public static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z10) {
            return builder.setAllowDataType(str, z10);
        }
    }

    public static class c {
        public static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        public static RemoteInput.Builder b(RemoteInput.Builder builder, int i10) {
            return builder.setEditChoicesBeforeSending(i10);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6794a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f6797d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence[] f6798e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f6795b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f6796c = new Bundle();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6799f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f6800g = 0;

        public d(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f6794a = str;
        }

        public h1 a() {
            return new h1(this.f6794a, this.f6797d, this.f6798e, this.f6799f, this.f6800g, this.f6796c, this.f6795b);
        }

        public d b(String str, boolean z10) {
            if (z10) {
                this.f6795b.add(str);
            } else {
                this.f6795b.remove(str);
            }
            return this;
        }

        public d c(boolean z10) {
            this.f6799f = z10;
            return this;
        }

        public d d(CharSequence[] charSequenceArr) {
            this.f6798e = charSequenceArr;
            return this;
        }

        public d e(CharSequence charSequence) {
            this.f6797d = charSequence;
            return this;
        }
    }

    public h1(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z10, int i10, Bundle bundle, Set<String> set) {
        this.f6787a = str;
        this.f6788b = charSequence;
        this.f6789c = charSequenceArr;
        this.f6790d = z10;
        this.f6791e = i10;
        this.f6792f = bundle;
        this.f6793g = set;
        if (f() == 2 && !c()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static RemoteInput a(h1 h1Var) {
        return a.b(h1Var);
    }

    public static RemoteInput[] b(h1[] h1VarArr) {
        if (h1VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[h1VarArr.length];
        for (int i10 = 0; i10 < h1VarArr.length; i10++) {
            remoteInputArr[i10] = a(h1VarArr[i10]);
        }
        return remoteInputArr;
    }

    public static Bundle j(Intent intent) {
        return a.c(intent);
    }

    public boolean c() {
        return this.f6790d;
    }

    public Set<String> d() {
        return this.f6793g;
    }

    public CharSequence[] e() {
        return this.f6789c;
    }

    public int f() {
        return this.f6791e;
    }

    public Bundle g() {
        return this.f6792f;
    }

    public CharSequence h() {
        return this.f6788b;
    }

    public String i() {
        return this.f6787a;
    }

    public boolean k() {
        return (c() || (e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
