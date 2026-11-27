package fb;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.b f8260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h<T> f8262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fb.b.c f8263d;

    public final class b implements fb.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<T> f8264a;

        /* JADX INFO: renamed from: fb.a$b$a, reason: collision with other inner class name */
        public class C0140a implements e<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ fb.b.InterfaceC0141b f8266a;

            public C0140a(fb.b.InterfaceC0141b interfaceC0141b) {
                this.f8266a = interfaceC0141b;
            }

            @Override // fb.a.e
            public void a(T t10) {
                this.f8266a.a(a.this.f8262c.a(t10));
            }
        }

        public b(d<T> dVar) {
            this.f8264a = dVar;
        }

        @Override // fb.b.a
        public void a(ByteBuffer byteBuffer, fb.b.InterfaceC0141b interfaceC0141b) {
            try {
                this.f8264a.a((T) a.this.f8262c.b(byteBuffer), new C0140a(interfaceC0141b));
            } catch (RuntimeException e10) {
                qa.b.c("BasicMessageChannel#" + a.this.f8261b, "Failed to handle message", e10);
                interfaceC0141b.a(null);
            }
        }
    }

    public final class c implements fb.b.InterfaceC0141b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e<T> f8268a;

        public c(e<T> eVar) {
            this.f8268a = eVar;
        }

        @Override // fb.b.InterfaceC0141b
        public void a(ByteBuffer byteBuffer) {
            try {
                this.f8268a.a((T) a.this.f8262c.b(byteBuffer));
            } catch (RuntimeException e10) {
                qa.b.c("BasicMessageChannel#" + a.this.f8261b, "Failed to handle message reply", e10);
            }
        }
    }

    public interface d<T> {
        void a(T t10, e<T> eVar);
    }

    public interface e<T> {
        void a(T t10);
    }

    public a(fb.b bVar, String str, h<T> hVar) {
        this(bVar, str, hVar, null);
    }

    public a(fb.b bVar, String str, h<T> hVar, fb.b.c cVar) {
        this.f8260a = bVar;
        this.f8261b = str;
        this.f8262c = hVar;
        this.f8263d = cVar;
    }

    public void c(T t10) {
        d(t10, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void d(T t10, e<T> eVar) {
        this.f8260a.f(this.f8261b, this.f8262c.a(t10), eVar != null ? new c(eVar) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [fb.b] */
    /* JADX WARN: Type inference failed for: r1v0, types: [fb.a$a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [fb.b$a] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void e(d<T> dVar) {
        ?? r10 = 0;
        if (this.f8263d != null) {
            this.f8260a.c(this.f8261b, dVar != null ? new b(dVar) : null, this.f8263d);
        } else {
            this.f8260a.d(this.f8261b, dVar != null ? new b(dVar) : 0);
        }
    }
}
