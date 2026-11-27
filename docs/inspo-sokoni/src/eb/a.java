package eb;

import io.flutter.embedding.engine.FlutterJNI;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.a<Object> f7568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlutterJNI f7569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f7570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fb.a.d<Object> f7571d;

    /* JADX INFO: renamed from: eb.a$a, reason: collision with other inner class name */
    public class C0127a implements fb.a.d<Object> {
        public C0127a() {
        }

        @Override // fb.a.d
        public void a(Object obj, fb.a.e<Object> eVar) {
            if (a.this.f7570c == null) {
                eVar.a(null);
                return;
            }
            HashMap map = (HashMap) obj;
            String str = (String) map.get("type");
            HashMap map2 = (HashMap) map.get("data");
            qa.b.f("AccessibilityChannel", "Received " + str + " message.");
            str.hashCode();
            switch (str) {
                case "tooltip":
                    String str2 = (String) map2.get("message");
                    if (str2 != null) {
                        a.this.f7570c.e(str2);
                        break;
                    }
                    break;
                case "announce":
                    String str3 = (String) map2.get("message");
                    if (str3 != null) {
                        a.this.f7570c.d(str3);
                        break;
                    }
                    break;
                case "tap":
                    Integer num = (Integer) map.get("nodeId");
                    if (num != null) {
                        a.this.f7570c.c(num.intValue());
                        break;
                    }
                    break;
                case "focus":
                    Integer num2 = (Integer) map.get("nodeId");
                    if (num2 != null) {
                        a.this.f7570c.f(num2.intValue());
                        break;
                    }
                    break;
                case "longPress":
                    Integer num3 = (Integer) map.get("nodeId");
                    if (num3 != null) {
                        a.this.f7570c.g(num3.intValue());
                        break;
                    }
                    break;
            }
            eVar.a(null);
        }
    }

    public interface b extends FlutterJNI.a {
        void c(int i10);

        void d(String str);

        void e(String str);

        void f(int i10);

        void g(int i10);
    }

    public a(ta.a aVar, FlutterJNI flutterJNI) {
        C0127a c0127a = new C0127a();
        this.f7571d = c0127a;
        fb.a<Object> aVar2 = new fb.a<>(aVar, "flutter/accessibility", fb.p.f8296a);
        this.f7568a = aVar2;
        aVar2.e(c0127a);
        this.f7569b = flutterJNI;
    }

    public void b(int i10, io.flutter.view.e.g gVar) {
        this.f7569b.dispatchSemanticsAction(i10, gVar);
    }

    public void c(int i10, io.flutter.view.e.g gVar, Object obj) {
        this.f7569b.dispatchSemanticsAction(i10, gVar, obj);
    }

    public void d() {
        this.f7569b.setSemanticsEnabled(false);
    }

    public void e() {
        this.f7569b.setSemanticsEnabled(true);
    }

    public void f(int i10) {
        this.f7569b.setAccessibilityFeatures(i10);
    }

    public void g(b bVar) {
        this.f7570c = bVar;
        this.f7569b.setAccessibilityDelegate(bVar);
    }
}
