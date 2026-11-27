package z7;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d.a f20351b = d.a.DEFAULT;

    /* JADX INFO: renamed from: z7.a$a, reason: collision with other inner class name */
    public static final class C0344a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d.a f20353b;

        public C0344a(int i10, d.a aVar) {
            this.f20352a = i10;
            this.f20353b = aVar;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return d.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f20352a == dVar.tag() && this.f20353b.equals(dVar.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f20352a) + (this.f20353b.hashCode() ^ 2041407134);
        }

        @Override // z7.d
        public d.a intEncoding() {
            return this.f20353b;
        }

        @Override // z7.d
        public int tag() {
            return this.f20352a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f20352a + "intEncoding=" + this.f20353b + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public d a() {
        return new C0344a(this.f20350a, this.f20351b);
    }

    public a c(int i10) {
        this.f20350a = i10;
        return this;
    }
}
