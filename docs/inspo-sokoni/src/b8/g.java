package b8;

import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.firebase.firestore.j f2899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2901d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2902a;

        static {
            int[] iArr = new int[e8.m.a.values().length];
            f2902a = iArr;
            try {
                iArr[e8.m.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2902a[e8.m.a.METADATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2902a[e8.m.a.MODIFIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2902a[e8.m.a.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum b {
        ADDED,
        MODIFIED,
        REMOVED
    }

    public g(com.google.firebase.firestore.j jVar, b bVar, int i10, int i11) {
        this.f2898a = bVar;
        this.f2899b = jVar;
        this.f2900c = i10;
        this.f2901d = i11;
    }

    public static List<g> a(FirebaseFirestore firebaseFirestore, c1 c1Var, e8.y1 y1Var) {
        int iN;
        int iN2;
        ArrayList arrayList = new ArrayList();
        if (y1Var.g().isEmpty()) {
            h8.h hVar = null;
            int i10 = 0;
            for (e8.m mVar : y1Var.d()) {
                h8.h hVarB = mVar.b();
                com.google.firebase.firestore.j jVarH = com.google.firebase.firestore.j.h(firebaseFirestore, hVarB, y1Var.k(), y1Var.f().contains(hVarB.getKey()));
                l8.b.d(mVar.c() == e8.m.a.ADDED, "Invalid added event for first snapshot", new Object[0]);
                l8.b.d(hVar == null || y1Var.h().c().compare(hVar, hVarB) < 0, "Got added events in wrong order", new Object[0]);
                arrayList.add(new g(jVarH, b.ADDED, -1, i10));
                hVar = hVarB;
                i10++;
            }
        } else {
            h8.m mVarG = y1Var.g();
            for (e8.m mVar2 : y1Var.d()) {
                if (c1Var != c1.EXCLUDE || mVar2.c() != e8.m.a.METADATA) {
                    h8.h hVarB2 = mVar2.b();
                    com.google.firebase.firestore.j jVarH2 = com.google.firebase.firestore.j.h(firebaseFirestore, hVarB2, y1Var.k(), y1Var.f().contains(hVarB2.getKey()));
                    b bVarF = f(mVar2);
                    if (bVarF != b.ADDED) {
                        iN = mVarG.n(hVarB2.getKey());
                        l8.b.d(iN >= 0, "Index for document not found", new Object[0]);
                        mVarG = mVarG.q(hVarB2.getKey());
                    } else {
                        iN = -1;
                    }
                    if (bVarF != b.REMOVED) {
                        mVarG = mVarG.h(hVarB2);
                        iN2 = mVarG.n(hVarB2.getKey());
                        l8.b.d(iN2 >= 0, "Index for document not found", new Object[0]);
                    } else {
                        iN2 = -1;
                    }
                    arrayList.add(new g(jVarH2, bVarF, iN, iN2));
                }
            }
        }
        return arrayList;
    }

    public static b f(e8.m mVar) {
        int i10 = a.f2902a[mVar.c().ordinal()];
        if (i10 == 1) {
            return b.ADDED;
        }
        if (i10 == 2 || i10 == 3) {
            return b.MODIFIED;
        }
        if (i10 == 4) {
            return b.REMOVED;
        }
        throw new IllegalArgumentException("Unknown view change type: " + mVar.c());
    }

    public com.google.firebase.firestore.j b() {
        return this.f2899b;
    }

    public int c() {
        return this.f2901d;
    }

    public int d() {
        return this.f2900c;
    }

    public b e() {
        return this.f2898a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f2898a.equals(gVar.f2898a) && this.f2899b.equals(gVar.f2899b) && this.f2900c == gVar.f2900c && this.f2901d == gVar.f2901d;
    }

    public int hashCode() {
        return (((((this.f2898a.hashCode() * 31) + this.f2899b.hashCode()) * 31) + this.f2900c) * 31) + this.f2901d;
    }
}
