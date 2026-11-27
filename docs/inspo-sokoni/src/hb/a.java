package hb;

import android.view.PointerIcon;
import eb.i;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static HashMap<String, Integer> f9931c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f9932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f9933b;

    /* JADX INFO: renamed from: hb.a$a, reason: collision with other inner class name */
    public class C0162a implements i.b {
        public C0162a() {
        }

        @Override // eb.i.b
        public void a(String str) {
            a.this.f9932a.setPointerIcon(a.this.d(str));
        }
    }

    public class b extends HashMap<String, Integer> {
        public b() {
            put("alias", 1010);
            put("allScroll", 1013);
            put("basic", 1000);
            put("cell", 1006);
            put("click", 1002);
            put("contextMenu", 1001);
            put("copy", 1011);
            put("forbidden", 1012);
            put("grab", 1020);
            put("grabbing", 1021);
            put("help", 1003);
            put("move", 1013);
            put("none", 0);
            put("noDrop", 1012);
            put("precise", 1007);
            put("text", 1008);
            put("resizeColumn", 1014);
            put("resizeDown", 1015);
            put("resizeUpLeft", 1016);
            put("resizeDownRight", 1017);
            put("resizeLeft", 1014);
            put("resizeLeftRight", 1014);
            put("resizeRight", 1014);
            put("resizeRow", 1015);
            put("resizeUp", 1015);
            put("resizeUpDown", 1015);
            put("resizeUpLeft", 1017);
            put("resizeUpRight", 1016);
            put("resizeUpLeftDownRight", 1017);
            put("resizeUpRightDownLeft", 1016);
            put("verticalText", 1009);
            put("wait", 1004);
            put("zoomIn", 1018);
            put("zoomOut", 1019);
        }
    }

    public interface c {
        PointerIcon a(int i10);

        void setPointerIcon(PointerIcon pointerIcon);
    }

    public a(c cVar, i iVar) {
        this.f9932a = cVar;
        this.f9933b = iVar;
        iVar.b(new C0162a());
    }

    public void c() {
        this.f9933b.b(null);
    }

    public final PointerIcon d(String str) {
        if (f9931c == null) {
            f9931c = new b();
        }
        return this.f9932a.a(f9931c.getOrDefault(str, 1000).intValue());
    }
}
