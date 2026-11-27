package e0;

import android.app.Person;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f6763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f6764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6768f;

    public static class a {
        public static f1 a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.b(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        public static Person b(f1 f1Var) {
            return new Person.Builder().setName(f1Var.e()).setIcon(f1Var.c() != null ? f1Var.c().u() : null).setUri(f1Var.f()).setKey(f1Var.d()).setBot(f1Var.g()).setImportant(f1Var.h()).build();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f6769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f6770b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6771c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f6772d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6773e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6774f;

        public f1 a() {
            return new f1(this);
        }

        public b b(boolean z10) {
            this.f6773e = z10;
            return this;
        }

        public b c(IconCompat iconCompat) {
            this.f6770b = iconCompat;
            return this;
        }

        public b d(boolean z10) {
            this.f6774f = z10;
            return this;
        }

        public b e(String str) {
            this.f6772d = str;
            return this;
        }

        public b f(CharSequence charSequence) {
            this.f6769a = charSequence;
            return this;
        }

        public b g(String str) {
            this.f6771c = str;
            return this;
        }
    }

    public f1(b bVar) {
        this.f6763a = bVar.f6769a;
        this.f6764b = bVar.f6770b;
        this.f6765c = bVar.f6771c;
        this.f6766d = bVar.f6772d;
        this.f6767e = bVar.f6773e;
        this.f6768f = bVar.f6774f;
    }

    public static f1 a(Person person) {
        return a.a(person);
    }

    public static f1 b(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new b().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.a(bundle2) : null).g(bundle.getString("uri")).e(bundle.getString("key")).b(bundle.getBoolean("isBot")).d(bundle.getBoolean("isImportant")).a();
    }

    public IconCompat c() {
        return this.f6764b;
    }

    public String d() {
        return this.f6766d;
    }

    public CharSequence e() {
        return this.f6763a;
    }

    public String f() {
        return this.f6765c;
    }

    public boolean g() {
        return this.f6767e;
    }

    public boolean h() {
        return this.f6768f;
    }

    public String i() {
        String str = this.f6765c;
        if (str != null) {
            return str;
        }
        if (this.f6763a == null) {
            return "";
        }
        return "name:" + ((Object) this.f6763a);
    }

    public Person j() {
        return a.b(this);
    }

    public Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f6763a);
        IconCompat iconCompat = this.f6764b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.t() : null);
        bundle.putString("uri", this.f6765c);
        bundle.putString("key", this.f6766d);
        bundle.putBoolean("isBot", this.f6767e);
        bundle.putBoolean("isImportant", this.f6768f);
        return bundle;
    }
}
