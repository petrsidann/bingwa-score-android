package e0;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class q {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f6855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IconCompat f6856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h1[] f6857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h1[] f6858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6859e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6860f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f6861g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f6862h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Deprecated
        public int f6863i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f6864j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public PendingIntent f6865k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f6866l;

        /* JADX INFO: renamed from: e0.q$a$a, reason: collision with other inner class name */
        public static final class C0119a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IconCompat f6867a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final CharSequence f6868b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final PendingIntent f6869c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f6870d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final Bundle f6871e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public ArrayList<h1> f6872f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f6873g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f6874h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f6875i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f6876j;

            public C0119a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i10 != 0 ? IconCompat.k(null, "", i10) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public C0119a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public C0119a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, h1[] h1VarArr, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
                this.f6870d = true;
                this.f6874h = true;
                this.f6867a = iconCompat;
                this.f6868b = e.e(charSequence);
                this.f6869c = pendingIntent;
                this.f6871e = bundle;
                this.f6872f = h1VarArr == null ? null : new ArrayList<>(Arrays.asList(h1VarArr));
                this.f6870d = z10;
                this.f6873g = i10;
                this.f6874h = z11;
                this.f6875i = z12;
                this.f6876j = z13;
            }

            public C0119a a(h1 h1Var) {
                if (this.f6872f == null) {
                    this.f6872f = new ArrayList<>();
                }
                if (h1Var != null) {
                    this.f6872f.add(h1Var);
                }
                return this;
            }

            public a b() {
                c();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<h1> arrayList3 = this.f6872f;
                if (arrayList3 != null) {
                    for (h1 h1Var : arrayList3) {
                        if (h1Var.k()) {
                            arrayList.add(h1Var);
                        } else {
                            arrayList2.add(h1Var);
                        }
                    }
                }
                h1[] h1VarArr = arrayList.isEmpty() ? null : (h1[]) arrayList.toArray(new h1[arrayList.size()]);
                return new a(this.f6867a, this.f6868b, this.f6869c, this.f6871e, arrayList2.isEmpty() ? null : (h1[]) arrayList2.toArray(new h1[arrayList2.size()]), h1VarArr, this.f6870d, this.f6873g, this.f6874h, this.f6875i, this.f6876j);
            }

            public final void c() {
                if (this.f6875i && this.f6869c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C0119a d(boolean z10) {
                this.f6870d = z10;
                return this;
            }

            public C0119a e(boolean z10) {
                this.f6875i = z10;
                return this;
            }

            public C0119a f(boolean z10) {
                this.f6874h = z10;
                return this;
            }
        }

        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.k(null, "", i10) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, h1[] h1VarArr, h1[] h1VarArr2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
            this.f6860f = true;
            this.f6856b = iconCompat;
            if (iconCompat != null && iconCompat.o() == 2) {
                this.f6863i = iconCompat.m();
            }
            this.f6864j = e.e(charSequence);
            this.f6865k = pendingIntent;
            this.f6855a = bundle == null ? new Bundle() : bundle;
            this.f6857c = h1VarArr;
            this.f6858d = h1VarArr2;
            this.f6859e = z10;
            this.f6861g = i10;
            this.f6860f = z11;
            this.f6862h = z12;
            this.f6866l = z13;
        }

        public PendingIntent a() {
            return this.f6865k;
        }

        public boolean b() {
            return this.f6859e;
        }

        public Bundle c() {
            return this.f6855a;
        }

        public IconCompat d() {
            int i10;
            if (this.f6856b == null && (i10 = this.f6863i) != 0) {
                this.f6856b = IconCompat.k(null, "", i10);
            }
            return this.f6856b;
        }

        public h1[] e() {
            return this.f6857c;
        }

        public int f() {
            return this.f6861g;
        }

        public boolean g() {
            return this.f6860f;
        }

        public CharSequence h() {
            return this.f6864j;
        }

        public boolean i() {
            return this.f6866l;
        }

        public boolean j() {
            return this.f6862h;
        }
    }

    public static class b extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public IconCompat f6877e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public IconCompat f6878f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f6879g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f6880h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f6881i;

        public static class a {
            public static Notification.BigPictureStyle a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                return bigPictureStyle.bigPicture(bitmap);
            }

            public static Notification.BigPictureStyle b(Notification.Builder builder) {
                return new Notification.BigPictureStyle(builder);
            }

            public static Notification.BigPictureStyle c(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                return bigPictureStyle.setBigContentTitle(charSequence);
            }

            public static void d(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            public static void e(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* JADX INFO: renamed from: e0.q$b$b, reason: collision with other inner class name */
        public static class C0120b {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        public static class c {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z10) {
                bigPictureStyle.showBigPictureWhenCollapsed(z10);
            }
        }

        public static IconCompat n(Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (parcelable instanceof Icon) {
                return IconCompat.b((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.f((Bitmap) parcelable);
            }
            return null;
        }

        public static IconCompat q(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            Parcelable parcelable = bundle.getParcelable("android.picture");
            return parcelable != null ? n(parcelable) : n(bundle.getParcelable("android.pictureIcon"));
        }

        @Override // e0.q.j
        public void b(p pVar) {
            int i10 = Build.VERSION.SDK_INT;
            Notification.BigPictureStyle bigPictureStyleC = a.c(a.b(pVar.a()), this.f6932b);
            IconCompat iconCompat = this.f6877e;
            if (iconCompat != null) {
                if (i10 >= 31) {
                    c.a(bigPictureStyleC, this.f6877e.v(pVar instanceof g0 ? ((g0) pVar).f() : null));
                } else if (iconCompat.o() == 1) {
                    bigPictureStyleC = a.a(bigPictureStyleC, this.f6877e.l());
                }
            }
            if (this.f6879g) {
                if (this.f6878f == null) {
                    a.d(bigPictureStyleC, null);
                } else {
                    C0120b.a(bigPictureStyleC, this.f6878f.v(pVar instanceof g0 ? ((g0) pVar).f() : null));
                }
            }
            if (this.f6934d) {
                a.e(bigPictureStyleC, this.f6933c);
            }
            if (i10 >= 31) {
                c.c(bigPictureStyleC, this.f6881i);
                c.b(bigPictureStyleC, this.f6880h);
            }
        }

        @Override // e0.q.j
        public String h() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @Override // e0.q.j
        public void l(Bundle bundle) {
            super.l(bundle);
            if (bundle.containsKey("android.largeIcon.big")) {
                this.f6878f = n(bundle.getParcelable("android.largeIcon.big"));
                this.f6879g = true;
            }
            this.f6877e = q(bundle);
            this.f6881i = bundle.getBoolean("android.showBigPictureWhenCollapsed");
        }

        public b o(Bitmap bitmap) {
            this.f6878f = bitmap == null ? null : IconCompat.f(bitmap);
            this.f6879g = true;
            return this;
        }

        public b p(Bitmap bitmap) {
            this.f6877e = bitmap == null ? null : IconCompat.f(bitmap);
            return this;
        }

        public b r(CharSequence charSequence) {
            this.f6932b = e.e(charSequence);
            return this;
        }

        public b s(CharSequence charSequence) {
            this.f6933c = e.e(charSequence);
            this.f6934d = true;
            return this;
        }
    }

    public static class c extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f6882e;

        public static class a {
            public static Notification.BigTextStyle a(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.bigText(charSequence);
            }

            public static Notification.BigTextStyle b(Notification.Builder builder) {
                return new Notification.BigTextStyle(builder);
            }

            public static Notification.BigTextStyle c(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setBigContentTitle(charSequence);
            }

            public static Notification.BigTextStyle d(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setSummaryText(charSequence);
            }
        }

        @Override // e0.q.j
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // e0.q.j
        public void b(p pVar) {
            Notification.BigTextStyle bigTextStyleA = a.a(a.c(a.b(pVar.a()), this.f6932b), this.f6882e);
            if (this.f6934d) {
                a.d(bigTextStyleA, this.f6933c);
            }
        }

        @Override // e0.q.j
        public String h() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // e0.q.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f6882e = bundle.getCharSequence("android.bigText");
        }

        public c n(CharSequence charSequence) {
            this.f6882e = e.e(charSequence);
            return this;
        }

        public c o(CharSequence charSequence) {
            this.f6932b = e.e(charSequence);
            return this;
        }

        public c p(CharSequence charSequence) {
            this.f6933c = e.e(charSequence);
            this.f6934d = true;
            return this;
        }
    }

    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    public static class e {
        public boolean A;
        public boolean B;
        public boolean C;
        public String D;
        public Bundle E;
        public int F;
        public int G;
        public Notification H;
        public RemoteViews I;
        public RemoteViews J;
        public RemoteViews K;
        public String L;
        public int M;
        public String N;
        public long O;
        public int P;
        public int Q;
        public boolean R;
        public Notification S;
        public boolean T;
        public Object U;

        @Deprecated
        public ArrayList<String> V;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f6883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<a> f6884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<f1> f6885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList<a> f6886d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence f6887e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f6888f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f6889g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f6890h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public RemoteViews f6891i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public IconCompat f6892j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f6893k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f6894l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f6895m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f6896n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f6897o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f6898p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public j f6899q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public CharSequence f6900r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public CharSequence f6901s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public CharSequence[] f6902t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f6903u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f6904v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f6905w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f6906x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f6907y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f6908z;

        public static class a {
            public static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            public static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i10) {
                return builder.setContentType(i10);
            }

            public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i10) {
                return builder.setLegacyStreamType(i10);
            }

            public static AudioAttributes.Builder e(AudioAttributes.Builder builder, int i10) {
                return builder.setUsage(i10);
            }
        }

        @Deprecated
        public e(Context context) {
            this(context, null);
        }

        public e(Context context, String str) {
            this.f6884b = new ArrayList<>();
            this.f6885c = new ArrayList<>();
            this.f6886d = new ArrayList<>();
            this.f6896n = true;
            this.A = false;
            this.F = 0;
            this.G = 0;
            this.M = 0;
            this.P = 0;
            this.Q = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.f6883a = context;
            this.L = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.f6895m = 0;
            this.V = new ArrayList<>();
            this.R = true;
        }

        public static CharSequence e(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public e A(boolean z10) {
            q(8, z10);
            return this;
        }

        public e B(int i10) {
            this.f6895m = i10;
            return this;
        }

        public e C(int i10, int i11, boolean z10) {
            this.f6903u = i10;
            this.f6904v = i11;
            this.f6905w = z10;
            return this;
        }

        public e D(CharSequence[] charSequenceArr) {
            this.f6902t = charSequenceArr;
            return this;
        }

        public e E(String str) {
            this.N = str;
            return this;
        }

        public e F(boolean z10) {
            this.f6896n = z10;
            return this;
        }

        public e G(boolean z10) {
            this.T = z10;
            return this;
        }

        public e H(int i10) {
            this.S.icon = i10;
            return this;
        }

        public e I(String str) {
            this.f6908z = str;
            return this;
        }

        public e J(Uri uri) {
            Notification notification = this.S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder builderE = a.e(a.c(a.b(), 4), 5);
            this.S.audioAttributes = a.a(builderE);
            return this;
        }

        public e K(j jVar) {
            if (this.f6899q != jVar) {
                this.f6899q = jVar;
                if (jVar != null) {
                    jVar.m(this);
                }
            }
            return this;
        }

        public e L(CharSequence charSequence) {
            this.f6900r = e(charSequence);
            return this;
        }

        public e M(CharSequence charSequence) {
            this.S.tickerText = e(charSequence);
            return this;
        }

        public e N(long j10) {
            this.O = j10;
            return this;
        }

        public e O(boolean z10) {
            this.f6897o = z10;
            return this;
        }

        public e P(long[] jArr) {
            this.S.vibrate = jArr;
            return this;
        }

        public e Q(int i10) {
            this.G = i10;
            return this;
        }

        public e R(long j10) {
            this.S.when = j10;
            return this;
        }

        public e a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f6884b.add(new a(i10, charSequence, pendingIntent));
            return this;
        }

        public e b(a aVar) {
            if (aVar != null) {
                this.f6884b.add(aVar);
            }
            return this;
        }

        public Notification c() {
            return new g0(this).c();
        }

        public Bundle d() {
            if (this.E == null) {
                this.E = new Bundle();
            }
            return this.E;
        }

        public e f(boolean z10) {
            q(16, z10);
            return this;
        }

        public e g(String str) {
            this.D = str;
            return this;
        }

        public e h(String str) {
            this.L = str;
            return this;
        }

        public e i(boolean z10) {
            this.f6898p = z10;
            d().putBoolean("android.chronometerCountDown", z10);
            return this;
        }

        public e j(int i10) {
            this.F = i10;
            return this;
        }

        public e k(boolean z10) {
            this.B = z10;
            this.C = true;
            return this;
        }

        public e l(PendingIntent pendingIntent) {
            this.f6889g = pendingIntent;
            return this;
        }

        public e m(CharSequence charSequence) {
            this.f6888f = e(charSequence);
            return this;
        }

        public e n(CharSequence charSequence) {
            this.f6887e = e(charSequence);
            return this;
        }

        public e o(int i10) {
            Notification notification = this.S;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e p(PendingIntent pendingIntent) {
            this.S.deleteIntent = pendingIntent;
            return this;
        }

        public final void q(int i10, boolean z10) {
            Notification notification;
            int i11;
            if (z10) {
                notification = this.S;
                i11 = i10 | notification.flags;
            } else {
                notification = this.S;
                i11 = (~i10) & notification.flags;
            }
            notification.flags = i11;
        }

        public e r(PendingIntent pendingIntent, boolean z10) {
            this.f6890h = pendingIntent;
            q(128, z10);
            return this;
        }

        public e s(String str) {
            this.f6906x = str;
            return this;
        }

        public e t(int i10) {
            this.P = i10;
            return this;
        }

        public e u(boolean z10) {
            this.f6907y = z10;
            return this;
        }

        public e v(Bitmap bitmap) {
            this.f6892j = bitmap == null ? null : IconCompat.f(q.b(this.f6883a, bitmap));
            return this;
        }

        public e w(int i10, int i11, int i12) {
            Notification notification = this.S;
            notification.ledARGB = i10;
            notification.ledOnMS = i11;
            notification.ledOffMS = i12;
            notification.flags = ((i11 == 0 || i12 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public e x(boolean z10) {
            this.A = z10;
            return this;
        }

        public e y(int i10) {
            this.f6894l = i10;
            return this;
        }

        public e z(boolean z10) {
            q(2, z10);
            return this;
        }
    }

    public static class f extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6909e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public f1 f6910f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PendingIntent f6911g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PendingIntent f6912h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PendingIntent f6913i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f6914j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f6915k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Integer f6916l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public IconCompat f6917m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public CharSequence f6918n;

        public static class a {
            public static void a(Notification.CallStyle callStyle, Notification.Builder builder) {
                callStyle.setBuilder(builder);
            }
        }

        public static class b {
            public static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }

            public static Notification.Builder b(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        public static class c {
            public static Parcelable a(Icon icon) {
                return icon;
            }

            public static Notification.Action.Builder b(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            public static void c(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }
        }

        public static class d {
            public static Notification.Builder a(Notification.Builder builder, Person person) {
                return builder.addPerson(person);
            }

            public static Parcelable b(Person person) {
                return person;
            }
        }

        public static class e {
            public static Notification.CallStyle a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle b(Person person, PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            public static Notification.CallStyle c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle d(Notification.CallStyle callStyle, int i10) {
                return callStyle.setAnswerButtonColorHint(i10);
            }

            public static Notification.Action.Builder e(Notification.Action.Builder builder, boolean z10) {
                return builder.setAuthenticationRequired(z10);
            }

            public static Notification.CallStyle f(Notification.CallStyle callStyle, int i10) {
                return callStyle.setDeclineButtonColorHint(i10);
            }

            public static Notification.CallStyle g(Notification.CallStyle callStyle, boolean z10) {
                return callStyle.setIsVideo(z10);
            }

            public static Notification.CallStyle h(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            public static Notification.CallStyle i(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        @Override // e0.q.j
        public void a(Bundle bundle) {
            String str;
            Parcelable parcelableK;
            super.a(bundle);
            bundle.putInt("android.callType", this.f6909e);
            bundle.putBoolean("android.callIsVideo", this.f6914j);
            f1 f1Var = this.f6910f;
            if (f1Var != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    parcelableK = d.b(f1Var.j());
                    str = "android.callPerson";
                } else {
                    str = "android.callPersonCompat";
                    parcelableK = f1Var.k();
                }
                bundle.putParcelable(str, parcelableK);
            }
            IconCompat iconCompat = this.f6917m;
            if (iconCompat != null) {
                bundle.putParcelable("android.verificationIcon", c.a(iconCompat.v(this.f6931a.f6883a)));
            }
            bundle.putCharSequence("android.verificationText", this.f6918n);
            bundle.putParcelable("android.answerIntent", this.f6911g);
            bundle.putParcelable("android.declineIntent", this.f6912h);
            bundle.putParcelable("android.hangUpIntent", this.f6913i);
            Integer num = this.f6915k;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f6916l;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // e0.q.j
        public void b(p pVar) {
            int i10 = Build.VERSION.SDK_INT;
            CharSequence charSequenceO = null;
            callStyleA = null;
            Notification.CallStyle callStyleA = null;
            charSequenceO = null;
            if (i10 < 31) {
                Notification.Builder builderA = pVar.a();
                f1 f1Var = this.f6910f;
                builderA.setContentTitle(f1Var != null ? f1Var.e() : null);
                Bundle bundle = this.f6931a.E;
                if (bundle != null && bundle.containsKey("android.text")) {
                    charSequenceO = this.f6931a.E.getCharSequence("android.text");
                }
                if (charSequenceO == null) {
                    charSequenceO = o();
                }
                builderA.setContentText(charSequenceO);
                f1 f1Var2 = this.f6910f;
                if (f1Var2 != null) {
                    if (f1Var2.c() != null) {
                        c.c(builderA, this.f6910f.c().v(this.f6931a.f6883a));
                    }
                    if (i10 >= 28) {
                        d.a(builderA, this.f6910f.j());
                    } else {
                        b.a(builderA, this.f6910f.f());
                    }
                }
                b.b(builderA, "call");
                return;
            }
            int i11 = this.f6909e;
            if (i11 == 1) {
                callStyleA = e.a(this.f6910f.j(), this.f6912h, this.f6911g);
            } else if (i11 == 2) {
                callStyleA = e.b(this.f6910f.j(), this.f6913i);
            } else if (i11 == 3) {
                callStyleA = e.c(this.f6910f.j(), this.f6913i, this.f6911g);
            } else if (Log.isLoggable("NotifCompat", 3)) {
                Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f6909e));
            }
            if (callStyleA != null) {
                a.a(callStyleA, pVar.a());
                Integer num = this.f6915k;
                if (num != null) {
                    e.d(callStyleA, num.intValue());
                }
                Integer num2 = this.f6916l;
                if (num2 != null) {
                    e.f(callStyleA, num2.intValue());
                }
                e.i(callStyleA, this.f6918n);
                IconCompat iconCompat = this.f6917m;
                if (iconCompat != null) {
                    e.h(callStyleA, iconCompat.v(this.f6931a.f6883a));
                }
                e.g(callStyleA, this.f6914j);
            }
        }

        @Override // e0.q.j
        public String h() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0046  */
        /* JADX WARN: Code duplicated, block: B:14:0x0051  */
        /* JADX WARN: Code duplicated, block: B:16:0x0059  */
        /* JADX WARN: Code duplicated, block: B:20:0x0092  */
        /* JADX WARN: Code duplicated, block: B:21:0x009b  */
        /* JADX WARN: Code duplicated, block: B:24:0x00a6  */
        @Override // e0.q.j
        public void l(Bundle bundle) {
            f1 f1VarB;
            IconCompat iconCompatA;
            Integer numValueOf;
            super.l(bundle);
            this.f6909e = bundle.getInt("android.callType");
            this.f6914j = bundle.getBoolean("android.callIsVideo");
            if (Build.VERSION.SDK_INT < 28 || !bundle.containsKey("android.callPerson")) {
                if (bundle.containsKey("android.callPersonCompat")) {
                    f1VarB = f1.b(bundle.getBundle("android.callPersonCompat"));
                }
                if (bundle.containsKey("android.verificationIcon")) {
                    if (bundle.containsKey("android.verificationIconCompat")) {
                        iconCompatA = IconCompat.a(bundle.getBundle("android.verificationIconCompat"));
                    }
                    this.f6918n = bundle.getCharSequence("android.verificationText");
                    this.f6911g = (PendingIntent) bundle.getParcelable("android.answerIntent");
                    this.f6912h = (PendingIntent) bundle.getParcelable("android.declineIntent");
                    this.f6913i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
                    if (bundle.containsKey("android.answerColor")) {
                        numValueOf = Integer.valueOf(bundle.getInt("android.answerColor"));
                    } else {
                        numValueOf = null;
                    }
                    this.f6915k = numValueOf;
                    this.f6916l = bundle.containsKey("android.declineColor") ? Integer.valueOf(bundle.getInt("android.declineColor")) : null;
                }
                iconCompatA = IconCompat.b((Icon) bundle.getParcelable("android.verificationIcon"));
                this.f6917m = iconCompatA;
                this.f6918n = bundle.getCharSequence("android.verificationText");
                this.f6911g = (PendingIntent) bundle.getParcelable("android.answerIntent");
                this.f6912h = (PendingIntent) bundle.getParcelable("android.declineIntent");
                this.f6913i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
                if (bundle.containsKey("android.answerColor")) {
                    numValueOf = Integer.valueOf(bundle.getInt("android.answerColor"));
                } else {
                    numValueOf = null;
                }
                this.f6915k = numValueOf;
                this.f6916l = bundle.containsKey("android.declineColor") ? Integer.valueOf(bundle.getInt("android.declineColor")) : null;
            }
            f1VarB = f1.a((Person) bundle.getParcelable("android.callPerson"));
            this.f6910f = f1VarB;
            if (bundle.containsKey("android.verificationIcon")) {
                if (bundle.containsKey("android.verificationIconCompat")) {
                    iconCompatA = IconCompat.a(bundle.getBundle("android.verificationIconCompat"));
                }
                this.f6918n = bundle.getCharSequence("android.verificationText");
                this.f6911g = (PendingIntent) bundle.getParcelable("android.answerIntent");
                this.f6912h = (PendingIntent) bundle.getParcelable("android.declineIntent");
                this.f6913i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
                if (bundle.containsKey("android.answerColor")) {
                    numValueOf = Integer.valueOf(bundle.getInt("android.answerColor"));
                } else {
                    numValueOf = null;
                }
                this.f6915k = numValueOf;
                this.f6916l = bundle.containsKey("android.declineColor") ? Integer.valueOf(bundle.getInt("android.declineColor")) : null;
            }
            iconCompatA = IconCompat.b((Icon) bundle.getParcelable("android.verificationIcon"));
            this.f6917m = iconCompatA;
            this.f6918n = bundle.getCharSequence("android.verificationText");
            this.f6911g = (PendingIntent) bundle.getParcelable("android.answerIntent");
            this.f6912h = (PendingIntent) bundle.getParcelable("android.declineIntent");
            this.f6913i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
            if (bundle.containsKey("android.answerColor")) {
                numValueOf = Integer.valueOf(bundle.getInt("android.answerColor"));
            } else {
                numValueOf = null;
            }
            this.f6915k = numValueOf;
            this.f6916l = bundle.containsKey("android.declineColor") ? Integer.valueOf(bundle.getInt("android.declineColor")) : null;
        }

        public ArrayList<a> n() {
            a aVarS = s();
            a aVarR = r();
            ArrayList<a> arrayList = new ArrayList<>(3);
            arrayList.add(aVarS);
            ArrayList<a> arrayList2 = this.f6931a.f6884b;
            int i10 = 2;
            if (arrayList2 != null) {
                for (a aVar : arrayList2) {
                    if (aVar.j()) {
                        arrayList.add(aVar);
                    } else if (!p(aVar) && i10 > 1) {
                        arrayList.add(aVar);
                        i10--;
                    }
                    if (aVarR != null && i10 == 1) {
                        arrayList.add(aVarR);
                        i10--;
                    }
                }
            }
            if (aVarR != null && i10 >= 1) {
                arrayList.add(aVarR);
            }
            return arrayList;
        }

        public final String o() {
            Resources resources;
            int i10;
            int i11 = this.f6909e;
            if (i11 == 1) {
                resources = this.f6931a.f6883a.getResources();
                i10 = d0.f.f6234e;
            } else if (i11 == 2) {
                resources = this.f6931a.f6883a.getResources();
                i10 = d0.f.f6235f;
            } else {
                if (i11 != 3) {
                    return null;
                }
                resources = this.f6931a.f6883a.getResources();
                i10 = d0.f.f6236g;
            }
            return resources.getString(i10);
        }

        public final boolean p(a aVar) {
            return aVar != null && aVar.c().getBoolean("key_action_priority");
        }

        public final a q(int i10, int i11, Integer num, int i12, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(f0.a.getColor(this.f6931a.f6883a, i12));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f6931a.f6883a.getResources().getString(i11));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            a aVarB = new a.C0119a(IconCompat.j(this.f6931a.f6883a, i10), spannableStringBuilder, pendingIntent).b();
            aVarB.c().putBoolean("key_action_priority", true);
            return aVarB;
        }

        public final a r() {
            int i10 = d0.d.f6202b;
            int i11 = d0.d.f6201a;
            PendingIntent pendingIntent = this.f6911g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z10 = this.f6914j;
            return q(z10 ? i10 : i11, z10 ? d0.f.f6231b : d0.f.f6230a, this.f6915k, d0.b.f6197a, pendingIntent);
        }

        public final a s() {
            int i10;
            Integer num;
            int i11;
            int i12 = d0.d.f6203c;
            PendingIntent pendingIntent = this.f6912h;
            if (pendingIntent == null) {
                i10 = d0.f.f6233d;
                num = this.f6916l;
                i11 = d0.b.f6198b;
                pendingIntent = this.f6913i;
            } else {
                i10 = d0.f.f6232c;
                num = this.f6916l;
                i11 = d0.b.f6198b;
            }
            return q(i12, i10, num, i11, pendingIntent);
        }
    }

    public static class g extends j {

        public static class a {
            public static Notification.Builder a(Notification.Builder builder, Object obj) {
                return builder.setStyle((Notification.Style) obj);
            }
        }

        public static class b {
            public static Notification.DecoratedCustomViewStyle a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        @Override // e0.q.j
        public void b(p pVar) {
            a.a(pVar.a(), b.a());
        }

        @Override // e0.q.j
        public String h() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // e0.q.j
        public RemoteViews i(p pVar) {
            return null;
        }

        @Override // e0.q.j
        public RemoteViews j(p pVar) {
            return null;
        }

        @Override // e0.q.j
        public RemoteViews k(p pVar) {
            return null;
        }
    }

    public static class h extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ArrayList<CharSequence> f6919e = new ArrayList<>();

        public static class a {
            public static Notification.InboxStyle a(Notification.InboxStyle inboxStyle, CharSequence charSequence) {
                return inboxStyle.addLine(charSequence);
            }

            public static Notification.InboxStyle b(Notification.Builder builder) {
                return new Notification.InboxStyle(builder);
            }

            public static Notification.InboxStyle c(Notification.InboxStyle inboxStyle, CharSequence charSequence) {
                return inboxStyle.setBigContentTitle(charSequence);
            }

            public static Notification.InboxStyle d(Notification.InboxStyle inboxStyle, CharSequence charSequence) {
                return inboxStyle.setSummaryText(charSequence);
            }
        }

        @Override // e0.q.j
        public void b(p pVar) {
            Notification.InboxStyle inboxStyleC = a.c(a.b(pVar.a()), this.f6932b);
            if (this.f6934d) {
                a.d(inboxStyleC, this.f6933c);
            }
            Iterator<CharSequence> it = this.f6919e.iterator();
            while (it.hasNext()) {
                a.a(inboxStyleC, it.next());
            }
        }

        @Override // e0.q.j
        public String h() {
            return "androidx.core.app.NotificationCompat$InboxStyle";
        }

        @Override // e0.q.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f6919e.clear();
            if (bundle.containsKey("android.textLines")) {
                Collections.addAll(this.f6919e, bundle.getCharSequenceArray("android.textLines"));
            }
        }

        public h n(CharSequence charSequence) {
            if (charSequence != null) {
                this.f6919e.add(e.e(charSequence));
            }
            return this;
        }

        public h o(CharSequence charSequence) {
            this.f6932b = e.e(charSequence);
            return this;
        }

        public h p(CharSequence charSequence) {
            this.f6933c = e.e(charSequence);
            this.f6934d = true;
            return this;
        }
    }

    public static class i extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<e> f6920e = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<e> f6921f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public f1 f6922g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f6923h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Boolean f6924i;

        public static class a {
            public static Notification.BigTextStyle a(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.bigText(charSequence);
            }

            public static Notification.BigTextStyle b(Notification.Builder builder) {
                return new Notification.BigTextStyle(builder);
            }

            public static Notification.BigTextStyle c(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setBigContentTitle(charSequence);
            }

            public static void d(Notification.Style style, Notification.Builder builder) {
                style.setBuilder(builder);
            }
        }

        public static class b {
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            public static Notification.MessagingStyle b(CharSequence charSequence) {
                return new Notification.MessagingStyle(charSequence);
            }

            public static Notification.MessagingStyle c(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
                return messagingStyle.setConversationTitle(charSequence);
            }
        }

        public static class c {
            public static Notification.MessagingStyle a(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        public static class d {
            public static Notification.MessagingStyle a(Person person) {
                return new Notification.MessagingStyle(person);
            }

            public static Notification.MessagingStyle b(Notification.MessagingStyle messagingStyle, boolean z10) {
                return messagingStyle.setGroupConversation(z10);
            }
        }

        public static final class e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CharSequence f6925a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f6926b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final f1 f6927c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Bundle f6928d = new Bundle();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f6929e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Uri f6930f;

            public static class a {
                public static Notification.MessagingStyle.Message a(CharSequence charSequence, long j10, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j10, charSequence2);
                }

                public static Notification.MessagingStyle.Message b(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            public static class b {
                public static Parcelable a(Person person) {
                    return person;
                }

                public static Notification.MessagingStyle.Message b(CharSequence charSequence, long j10, Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j10, person);
                }
            }

            public e(CharSequence charSequence, long j10, f1 f1Var) {
                this.f6925a = charSequence;
                this.f6926b = j10;
                this.f6927c = f1Var;
            }

            public static Bundle[] a(List<e> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    bundleArr[i10] = list.get(i10).l();
                }
                return bundleArr;
            }

            public static e e(Bundle bundle) {
                f1 f1VarA;
                try {
                    if (bundle.containsKey("text") && bundle.containsKey("time")) {
                        if (bundle.containsKey("person")) {
                            f1VarA = f1.b(bundle.getBundle("person"));
                        } else if (!bundle.containsKey("sender_person") || Build.VERSION.SDK_INT < 28) {
                            f1VarA = bundle.containsKey("sender") ? new f1.b().f(bundle.getCharSequence("sender")).a() : null;
                        } else {
                            f1VarA = f1.a((Person) bundle.getParcelable("sender_person"));
                        }
                        e eVar = new e(bundle.getCharSequence("text"), bundle.getLong("time"), f1VarA);
                        if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                            eVar.j(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
                        }
                        if (bundle.containsKey("extras")) {
                            eVar.d().putAll(bundle.getBundle("extras"));
                        }
                        return eVar;
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            public static List<e> f(Parcelable[] parcelableArr) {
                e eVarE;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (Parcelable parcelable : parcelableArr) {
                    if ((parcelable instanceof Bundle) && (eVarE = e((Bundle) parcelable)) != null) {
                        arrayList.add(eVarE);
                    }
                }
                return arrayList;
            }

            public String b() {
                return this.f6929e;
            }

            public Uri c() {
                return this.f6930f;
            }

            public Bundle d() {
                return this.f6928d;
            }

            public f1 g() {
                return this.f6927c;
            }

            public CharSequence h() {
                return this.f6925a;
            }

            public long i() {
                return this.f6926b;
            }

            public e j(String str, Uri uri) {
                this.f6929e = str;
                this.f6930f = uri;
                return this;
            }

            public Notification.MessagingStyle.Message k() {
                Notification.MessagingStyle.Message messageA;
                f1 f1VarG = g();
                if (Build.VERSION.SDK_INT >= 28) {
                    messageA = b.b(h(), i(), f1VarG != null ? f1VarG.j() : null);
                } else {
                    messageA = a.a(h(), i(), f1VarG != null ? f1VarG.e() : null);
                }
                if (b() != null) {
                    a.b(messageA, b(), c());
                }
                return messageA;
            }

            public final Bundle l() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f6925a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.f6926b);
                f1 f1Var = this.f6927c;
                if (f1Var != null) {
                    bundle.putCharSequence("sender", f1Var.e());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", b.a(this.f6927c.j()));
                    } else {
                        bundle.putBundle("person", this.f6927c.k());
                    }
                }
                String str = this.f6929e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f6930f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.f6928d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }
        }

        public i() {
        }

        public i(f1 f1Var) {
            if (TextUtils.isEmpty(f1Var.e())) {
                throw new IllegalArgumentException("User's name must not be empty.");
            }
            this.f6922g = f1Var;
        }

        @Deprecated
        public i(CharSequence charSequence) {
            this.f6922g = new f1.b().f(charSequence).a();
        }

        public static i q(Notification notification) {
            j jVarG = j.g(notification);
            if (jVarG instanceof i) {
                return (i) jVarG;
            }
            return null;
        }

        @Override // e0.q.j
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.f6922g.e());
            bundle.putBundle("android.messagingStyleUser", this.f6922g.k());
            bundle.putCharSequence("android.hiddenConversationTitle", this.f6923h);
            if (this.f6923h != null && this.f6924i.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.f6923h);
            }
            if (!this.f6920e.isEmpty()) {
                bundle.putParcelableArray("android.messages", e.a(this.f6920e));
            }
            if (!this.f6921f.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", e.a(this.f6921f));
            }
            Boolean bool = this.f6924i;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        @Override // e0.q.j
        public void b(p pVar) {
            w(u());
            Notification.MessagingStyle messagingStyleA = Build.VERSION.SDK_INT >= 28 ? d.a(this.f6922g.j()) : b.b(this.f6922g.e());
            Iterator<e> it = this.f6920e.iterator();
            while (it.hasNext()) {
                b.a(messagingStyleA, it.next().k());
            }
            Iterator<e> it2 = this.f6921f.iterator();
            while (it2.hasNext()) {
                c.a(messagingStyleA, it2.next().k());
            }
            if (this.f6924i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                b.c(messagingStyleA, this.f6923h);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                d.b(messagingStyleA, this.f6924i.booleanValue());
            }
            a.d(messagingStyleA, pVar.a());
        }

        @Override // e0.q.j
        public String h() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        @Override // e0.q.j
        public void l(Bundle bundle) {
            super.l(bundle);
            this.f6920e.clear();
            this.f6922g = bundle.containsKey("android.messagingStyleUser") ? f1.b(bundle.getBundle("android.messagingStyleUser")) : new f1.b().f(bundle.getString("android.selfDisplayName")).a();
            CharSequence charSequence = bundle.getCharSequence("android.conversationTitle");
            this.f6923h = charSequence;
            if (charSequence == null) {
                this.f6923h = bundle.getCharSequence("android.hiddenConversationTitle");
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("android.messages");
            if (parcelableArray != null) {
                this.f6920e.addAll(e.f(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray("android.messages.historic");
            if (parcelableArray2 != null) {
                this.f6921f.addAll(e.f(parcelableArray2));
            }
            if (bundle.containsKey("android.isGroupConversation")) {
                this.f6924i = Boolean.valueOf(bundle.getBoolean("android.isGroupConversation"));
            }
        }

        public i n(e eVar) {
            if (eVar != null) {
                this.f6920e.add(eVar);
                if (this.f6920e.size() > 25) {
                    this.f6920e.remove(0);
                }
            }
            return this;
        }

        public i o(CharSequence charSequence, long j10, f1 f1Var) {
            n(new e(charSequence, j10, f1Var));
            return this;
        }

        @Deprecated
        public i p(CharSequence charSequence, long j10, CharSequence charSequence2) {
            this.f6920e.add(new e(charSequence, j10, new f1.b().f(charSequence2).a()));
            if (this.f6920e.size() > 25) {
                this.f6920e.remove(0);
            }
            return this;
        }

        public CharSequence r() {
            return this.f6923h;
        }

        public List<e> s() {
            return this.f6920e;
        }

        public f1 t() {
            return this.f6922g;
        }

        public boolean u() {
            e eVar = this.f6931a;
            if (eVar != null && eVar.f6883a.getApplicationInfo().targetSdkVersion < 28 && this.f6924i == null) {
                return this.f6923h != null;
            }
            Boolean bool = this.f6924i;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public i v(CharSequence charSequence) {
            this.f6923h = charSequence;
            return this;
        }

        public i w(boolean z10) {
            this.f6924i = Boolean.valueOf(z10);
            return this;
        }
    }

    public static abstract class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f6931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f6932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f6933c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6934d = false;

        public static j c(String str) {
            if (str == null) {
                return null;
            }
            switch (str) {
                case "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle":
                    return new g();
                case "androidx.core.app.NotificationCompat$BigPictureStyle":
                    return new b();
                case "androidx.core.app.NotificationCompat$CallStyle":
                    return new f();
                case "androidx.core.app.NotificationCompat$InboxStyle":
                    return new h();
                case "androidx.core.app.NotificationCompat$BigTextStyle":
                    return new c();
                case "androidx.core.app.NotificationCompat$MessagingStyle":
                    return new i();
                default:
                    return null;
            }
        }

        public static j d(String str) {
            if (str == null) {
                return null;
            }
            if (str.equals(Notification.BigPictureStyle.class.getName())) {
                return new b();
            }
            if (str.equals(Notification.BigTextStyle.class.getName())) {
                return new c();
            }
            if (str.equals(Notification.InboxStyle.class.getName())) {
                return new h();
            }
            if (str.equals(Notification.MessagingStyle.class.getName())) {
                return new i();
            }
            if (str.equals(Notification.DecoratedCustomViewStyle.class.getName())) {
                return new g();
            }
            return null;
        }

        public static j e(Bundle bundle) {
            j jVarC = c(bundle.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
            if (jVarC != null) {
                return jVarC;
            }
            if (bundle.containsKey("android.selfDisplayName") || bundle.containsKey("android.messagingStyleUser")) {
                return new i();
            }
            if (bundle.containsKey("android.picture") || bundle.containsKey("android.pictureIcon")) {
                return new b();
            }
            if (bundle.containsKey("android.bigText")) {
                return new c();
            }
            if (bundle.containsKey("android.textLines")) {
                return new h();
            }
            return bundle.containsKey("android.callType") ? new f() : d(bundle.getString("android.template"));
        }

        public static j f(Bundle bundle) {
            j jVarE = e(bundle);
            if (jVarE == null) {
                return null;
            }
            try {
                jVarE.l(bundle);
                return jVarE;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        public static j g(Notification notification) {
            Bundle bundleA = q.a(notification);
            if (bundleA == null) {
                return null;
            }
            return f(bundleA);
        }

        public void a(Bundle bundle) {
            if (this.f6934d) {
                bundle.putCharSequence("android.summaryText", this.f6933c);
            }
            CharSequence charSequence = this.f6932b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strH = h();
            if (strH != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strH);
            }
        }

        public abstract void b(p pVar);

        public String h() {
            return null;
        }

        public RemoteViews i(p pVar) {
            return null;
        }

        public RemoteViews j(p pVar) {
            return null;
        }

        public RemoteViews k(p pVar) {
            return null;
        }

        public void l(Bundle bundle) {
            if (bundle.containsKey("android.summaryText")) {
                this.f6933c = bundle.getCharSequence("android.summaryText");
                this.f6934d = true;
            }
            this.f6932b = bundle.getCharSequence("android.title.big");
        }

        public void m(e eVar) {
            if (this.f6931a != eVar) {
                this.f6931a = eVar;
                if (eVar != null) {
                    eVar.K(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static Bitmap b(Context context, Bitmap bitmap) {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(d0.c.f6200b);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(d0.c.f6199a);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
    }
}
