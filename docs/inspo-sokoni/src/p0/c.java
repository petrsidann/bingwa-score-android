package p0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f13968a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0244c f13969a;

        public a(ClipData clipData, int i10) {
            this.f13969a = Build.VERSION.SDK_INT >= 31 ? new b(clipData, i10) : new d(clipData, i10);
        }

        public c a() {
            return this.f13969a.build();
        }

        public a b(Bundle bundle) {
            this.f13969a.setExtras(bundle);
            return this;
        }

        public a c(int i10) {
            this.f13969a.b(i10);
            return this;
        }

        public a d(Uri uri) {
            this.f13969a.a(uri);
            return this;
        }
    }

    public static final class b implements InterfaceC0244c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentInfo.Builder f13970a;

        public b(ClipData clipData, int i10) {
            this.f13970a = new ContentInfo.Builder(clipData, i10);
        }

        @Override // p0.c.InterfaceC0244c
        public void a(Uri uri) {
            this.f13970a.setLinkUri(uri);
        }

        @Override // p0.c.InterfaceC0244c
        public void b(int i10) {
            this.f13970a.setFlags(i10);
        }

        @Override // p0.c.InterfaceC0244c
        public c build() {
            return new c(new e(this.f13970a.build()));
        }

        @Override // p0.c.InterfaceC0244c
        public void setExtras(Bundle bundle) {
            this.f13970a.setExtras(bundle);
        }
    }

    /* JADX INFO: renamed from: p0.c$c, reason: collision with other inner class name */
    public interface InterfaceC0244c {
        void a(Uri uri);

        void b(int i10);

        c build();

        void setExtras(Bundle bundle);
    }

    public static final class d implements InterfaceC0244c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ClipData f13971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Uri f13974d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bundle f13975e;

        public d(ClipData clipData, int i10) {
            this.f13971a = clipData;
            this.f13972b = i10;
        }

        @Override // p0.c.InterfaceC0244c
        public void a(Uri uri) {
            this.f13974d = uri;
        }

        @Override // p0.c.InterfaceC0244c
        public void b(int i10) {
            this.f13973c = i10;
        }

        @Override // p0.c.InterfaceC0244c
        public c build() {
            return new c(new g(this));
        }

        @Override // p0.c.InterfaceC0244c
        public void setExtras(Bundle bundle) {
            this.f13975e = bundle;
        }
    }

    public static final class e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentInfo f13976a;

        public e(ContentInfo contentInfo) {
            this.f13976a = (ContentInfo) o0.h.g(contentInfo);
        }

        @Override // p0.c.f
        public ClipData a() {
            return this.f13976a.getClip();
        }

        @Override // p0.c.f
        public ContentInfo b() {
            return this.f13976a;
        }

        @Override // p0.c.f
        public int c() {
            return this.f13976a.getSource();
        }

        @Override // p0.c.f
        public int g() {
            return this.f13976a.getFlags();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f13976a + "}";
        }
    }

    public interface f {
        ClipData a();

        ContentInfo b();

        int c();

        int g();
    }

    public static final class g implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClipData f13977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri f13980d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f13981e;

        public g(d dVar) {
            this.f13977a = (ClipData) o0.h.g(dVar.f13971a);
            this.f13978b = o0.h.c(dVar.f13972b, 0, 5, "source");
            this.f13979c = o0.h.f(dVar.f13973c, 1);
            this.f13980d = dVar.f13974d;
            this.f13981e = dVar.f13975e;
        }

        @Override // p0.c.f
        public ClipData a() {
            return this.f13977a;
        }

        @Override // p0.c.f
        public ContentInfo b() {
            return null;
        }

        @Override // p0.c.f
        public int c() {
            return this.f13978b;
        }

        @Override // p0.c.f
        public int g() {
            return this.f13979c;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContentInfoCompat{clip=");
            sb2.append(this.f13977a.getDescription());
            sb2.append(", source=");
            sb2.append(c.e(this.f13978b));
            sb2.append(", flags=");
            sb2.append(c.a(this.f13979c));
            if (this.f13980d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f13980d.toString().length() + ")";
            }
            sb2.append(str);
            sb2.append(this.f13981e != null ? ", hasExtras" : "");
            sb2.append("}");
            return sb2.toString();
        }
    }

    public c(f fVar) {
        this.f13968a = fVar;
    }

    public static String a(int i10) {
        return (i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10);
    }

    public static String e(int i10) {
        if (i10 == 0) {
            return "SOURCE_APP";
        }
        if (i10 == 1) {
            return "SOURCE_CLIPBOARD";
        }
        if (i10 == 2) {
            return "SOURCE_INPUT_METHOD";
        }
        if (i10 == 3) {
            return "SOURCE_DRAG_AND_DROP";
        }
        if (i10 != 4) {
            return i10 != 5 ? String.valueOf(i10) : "SOURCE_PROCESS_TEXT";
        }
        return "SOURCE_AUTOFILL";
    }

    public static c g(ContentInfo contentInfo) {
        return new c(new e(contentInfo));
    }

    public ClipData b() {
        return this.f13968a.a();
    }

    public int c() {
        return this.f13968a.g();
    }

    public int d() {
        return this.f13968a.c();
    }

    public ContentInfo f() {
        ContentInfo contentInfoB = this.f13968a.b();
        Objects.requireNonNull(contentInfoB);
        return contentInfoB;
    }

    public String toString() {
        return this.f13968a.toString();
    }
}
