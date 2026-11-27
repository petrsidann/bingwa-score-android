package g3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f8635c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f8637b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8638a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<c> f8639b = new ArrayList();

        public d a() {
            return new d(this.f8638a, Collections.unmodifiableList(this.f8639b));
        }

        public a b(List<c> list) {
            this.f8639b = list;
            return this;
        }

        public a c(String str) {
            this.f8638a = str;
            return this;
        }
    }

    public d(String str, List<c> list) {
        this.f8636a = str;
        this.f8637b = list;
    }

    public static a c() {
        return new a();
    }

    @z7.d(tag = 2)
    public List<c> a() {
        return this.f8637b;
    }

    @z7.d(tag = 1)
    public String b() {
        return this.f8636a;
    }
}
