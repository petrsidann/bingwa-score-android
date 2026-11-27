package k8;

import java.util.List;
import vb.l1;

/* JADX INFO: loaded from: classes.dex */
public abstract class y0 {

    public static final class b extends y0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Integer> f11865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Integer> f11866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h8.k f11867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h8.r f11868d;

        public b(List<Integer> list, List<Integer> list2, h8.k kVar, h8.r rVar) {
            super();
            this.f11865a = list;
            this.f11866b = list2;
            this.f11867c = kVar;
            this.f11868d = rVar;
        }

        public h8.k a() {
            return this.f11867c;
        }

        public h8.r b() {
            return this.f11868d;
        }

        public List<Integer> c() {
            return this.f11866b;
        }

        public List<Integer> d() {
            return this.f11865a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f11865a.equals(bVar.f11865a) || !this.f11866b.equals(bVar.f11866b) || !this.f11867c.equals(bVar.f11867c)) {
                return false;
            }
            h8.r rVar = this.f11868d;
            h8.r rVar2 = bVar.f11868d;
            if (rVar != null) {
                return rVar.equals(rVar2);
            }
            return rVar2 == null;
        }

        public int hashCode() {
            int iHashCode = ((((this.f11865a.hashCode() * 31) + this.f11866b.hashCode()) * 31) + this.f11867c.hashCode()) * 31;
            h8.r rVar = this.f11868d;
            return iHashCode + (rVar != null ? rVar.hashCode() : 0);
        }

        public String toString() {
            return "DocumentChange{updatedTargetIds=" + this.f11865a + ", removedTargetIds=" + this.f11866b + ", key=" + this.f11867c + ", newDocument=" + this.f11868d + '}';
        }
    }

    public static final class c extends y0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f11870b;

        public c(int i10, r rVar) {
            super();
            this.f11869a = i10;
            this.f11870b = rVar;
        }

        public r a() {
            return this.f11870b;
        }

        public int b() {
            return this.f11869a;
        }

        public String toString() {
            return "ExistenceFilterWatchChange{targetId=" + this.f11869a + ", existenceFilter=" + this.f11870b + '}';
        }
    }

    public static final class d extends y0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f11871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Integer> f11872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.google.protobuf.i f11873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l1 f11874d;

        public d(e eVar, List<Integer> list, com.google.protobuf.i iVar, l1 l1Var) {
            super();
            l8.b.d(l1Var == null || eVar == e.Removed, "Got cause for a target change that was not a removal", new Object[0]);
            this.f11871a = eVar;
            this.f11872b = list;
            this.f11873c = iVar;
            if (l1Var == null || l1Var.o()) {
                this.f11874d = null;
            } else {
                this.f11874d = l1Var;
            }
        }

        public l1 a() {
            return this.f11874d;
        }

        public e b() {
            return this.f11871a;
        }

        public com.google.protobuf.i c() {
            return this.f11873c;
        }

        public List<Integer> d() {
            return this.f11872b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f11871a != dVar.f11871a || !this.f11872b.equals(dVar.f11872b) || !this.f11873c.equals(dVar.f11873c)) {
                return false;
            }
            l1 l1Var = this.f11874d;
            if (l1Var != null) {
                return dVar.f11874d != null && l1Var.m().equals(dVar.f11874d.m());
            }
            return dVar.f11874d == null;
        }

        public int hashCode() {
            int iHashCode = ((((this.f11871a.hashCode() * 31) + this.f11872b.hashCode()) * 31) + this.f11873c.hashCode()) * 31;
            l1 l1Var = this.f11874d;
            return iHashCode + (l1Var != null ? l1Var.m().hashCode() : 0);
        }

        public String toString() {
            return "WatchTargetChange{changeType=" + this.f11871a + ", targetIds=" + this.f11872b + '}';
        }
    }

    public enum e {
        NoChange,
        Added,
        Removed,
        Current,
        Reset
    }

    public y0() {
    }
}
