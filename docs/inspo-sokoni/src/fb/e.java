package fb;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements h<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8282a = new e();

    @Override // fb.h
    public ByteBuffer a(Object obj) {
        r rVar;
        String string;
        if (obj == null) {
            return null;
        }
        Object objA = g.a(obj);
        if (objA instanceof String) {
            rVar = r.f8302b;
            string = JSONObject.quote((String) objA);
        } else {
            rVar = r.f8302b;
            string = objA.toString();
        }
        return rVar.a(string);
    }

    @Override // fb.h
    public Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(r.f8302b.b(byteBuffer));
            Object objNextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return objNextValue;
        } catch (JSONException e10) {
            throw new IllegalArgumentException("Invalid JSON", e10);
        }
    }
}
