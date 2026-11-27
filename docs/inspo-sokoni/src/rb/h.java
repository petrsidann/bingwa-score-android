package rb;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h implements xa.a, rb.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15356a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15357a;

        static {
            int[] iArr = new int[rb.a.c.values().length];
            f15357a = iArr;
            try {
                iArr[rb.a.c.ROOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15357a[rb.a.c.MUSIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15357a[rb.a.c.PODCASTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15357a[rb.a.c.RINGTONES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15357a[rb.a.c.ALARMS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15357a[rb.a.c.NOTIFICATIONS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15357a[rb.a.c.PICTURES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15357a[rb.a.c.MOVIES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15357a[rb.a.c.DOWNLOADS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15357a[rb.a.c.DCIM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15357a[rb.a.c.DOCUMENTS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public final String A(rb.a.c cVar) {
        switch (a.f15357a[cVar.ordinal()]) {
            case 1:
                return null;
            case 2:
                return "music";
            case 3:
                return "podcasts";
            case 4:
                return "ringtones";
            case 5:
                return "alarms";
            case 6:
                return "notifications";
            case 7:
                return "pictures";
            case 8:
                return "movies";
            case 9:
                return "downloads";
            case 10:
                return "dcim";
            case 11:
                return "documents";
            default:
                throw new RuntimeException("Unrecognized directory: " + cVar);
        }
    }

    public final void B(fb.b bVar, Context context) {
        try {
            rb.a.b.t(bVar, this);
        } catch (Exception e10) {
            Log.e("PathProviderPlugin", "Received exception while setting up PathProviderPlugin", e10);
        }
        this.f15356a = context;
    }

    @Override // rb.a.b
    public List<String> b() {
        return w();
    }

    @Override // rb.a.b
    public String j() {
        return y();
    }

    @Override // rb.a.b
    public List<String> l(rb.a.c cVar) {
        return x(cVar);
    }

    @Override // rb.a.b
    public String m() {
        return z();
    }

    @Override // rb.a.b
    public String n() {
        return v();
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        B(bVar.b(), bVar.a());
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        rb.a.b.t(bVar.b(), null);
    }

    @Override // rb.a.b
    public String q() {
        return u();
    }

    public final String u() {
        return ub.b.d(this.f15356a);
    }

    public final String v() {
        return ub.b.c(this.f15356a);
    }

    public final List<String> w() {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f15356a.getExternalCacheDirs()) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    public final List<String> x(rb.a.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f15356a.getExternalFilesDirs(A(cVar))) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    public final String y() {
        File externalFilesDir = this.f15356a.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    public final String z() {
        return this.f15356a.getCacheDir().getPath();
    }
}
