package y2;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import z2.i;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f19338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b f19339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.a f19340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19342e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f19344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f19345c;

        public a(Context context, String str, String str2, c.InterfaceC0335c interfaceC0335c) {
            this.f19343a = context;
            this.f19344b = str;
            this.f19345c = str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
            try {
                d.this.g(this.f19343a, this.f19344b, this.f19345c);
                throw null;
            } catch (UnsatisfiedLinkError unused) {
                throw null;
            } catch (y2.b unused2) {
                throw null;
            }
        }
    }

    public class b implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19347a;

        public b(String str) {
            this.f19347a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f19347a);
        }
    }

    public d() {
        this(new e(), new y2.a());
    }

    public d(c.b bVar, c.a aVar) {
        this.f19338a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f19339b = bVar;
        this.f19340c = aVar;
    }

    public void b(Context context, String str, String str2) {
        File fileC = c(context);
        File fileD = d(context, str, str2);
        File[] fileArrListFiles = fileC.listFiles(new b(this.f19339b.a(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f19341d || !file.getAbsolutePath().equals(fileD.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public File c(Context context) {
        return context.getDir("lib", 0);
    }

    public File d(Context context, String str, String str2) {
        String strA = this.f19339b.a(str);
        if (f.a(str2)) {
            return new File(c(context), strA);
        }
        return new File(c(context), strA + "." + str2);
    }

    public void e(Context context, String str) {
        f(context, str, null, null);
    }

    public void f(Context context, String str, String str2, c.InterfaceC0335c interfaceC0335c) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (f.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        i("Beginning load of %s...", str);
        if (interfaceC0335c == null) {
            g(context, str, str2);
        } else {
            new Thread(new a(context, str, str2, interfaceC0335c)).start();
        }
    }

    public final void g(Context context, String str, String str2) throws Throwable {
        if (this.f19338a.contains(str) && !this.f19341d) {
            i("%s already loaded previously!", str);
            return;
        }
        try {
            this.f19339b.b(str);
            this.f19338a.add(str);
            i("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e10) {
            i("Loading the library normally failed: %s", Log.getStackTraceString(e10));
            i("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileD = d(context, str, str2);
            if (!fileD.exists() || this.f19341d) {
                if (this.f19341d) {
                    i("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                this.f19340c.a(context, this.f19339b.d(), this.f19339b.a(str), fileD, this);
            }
            try {
                if (this.f19342e) {
                    i iVar = null;
                    try {
                        i iVar2 = new i(fileD);
                        try {
                            List<String> listK = iVar2.k();
                            iVar2.close();
                            Iterator<String> it = listK.iterator();
                            while (it.hasNext()) {
                                e(context, this.f19339b.c(it.next()));
                            }
                        } catch (Throwable th) {
                            th = th;
                            iVar = iVar2;
                            if (iVar != null) {
                                iVar.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (IOException unused) {
            }
            this.f19339b.e(fileD.getAbsolutePath());
            this.f19338a.add(str);
            i("%s (%s) was re-linked!", str, str2);
        }
    }

    public void h(String str) {
    }

    public void i(String str, Object... objArr) {
        h(String.format(Locale.US, str, objArr));
    }
}
