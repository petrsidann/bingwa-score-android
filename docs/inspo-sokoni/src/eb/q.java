package eb;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.j f7732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f7733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fb.j.c f7734c;

    public class a implements fb.j.c {
        public a() {
        }

        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            if (q.this.f7733b == null) {
                qa.b.f("SpellCheckChannel", "No SpellCheckeMethodHandler registered, call not forwarded to spell check API.");
                return;
            }
            String str = iVar.f8284a;
            Object obj = iVar.f8285b;
            qa.b.f("SpellCheckChannel", "Received '" + str + "' message.");
            str.hashCode();
            if (!str.equals("SpellCheck.initiateSpellCheck")) {
                dVar.c();
                return;
            }
            try {
                ArrayList arrayList = (ArrayList) obj;
                q.this.f7733b.a((String) arrayList.get(0), (String) arrayList.get(1), dVar);
            } catch (IllegalStateException e10) {
                dVar.b("error", e10.getMessage(), null);
            }
        }
    }

    public interface b {
        void a(String str, String str2, fb.j.d dVar);
    }

    public q(ta.a aVar) {
        a aVar2 = new a();
        this.f7734c = aVar2;
        fb.j jVar = new fb.j(aVar, "flutter/spellcheck", fb.q.f8299b);
        this.f7732a = jVar;
        jVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f7733b = bVar;
    }
}
