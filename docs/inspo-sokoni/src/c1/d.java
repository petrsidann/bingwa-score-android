package c1;

import androidx.datastore.preferences.protobuf.b0;
import java.io.InputStream;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3126a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final f a(InputStream input) throws a1.a {
            k.e(input, "input");
            try {
                f fVarR = f.R(input);
                k.d(fVarR, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
                return fVarR;
            } catch (b0 e10) {
                throw new a1.a("Unable to parse preferences proto.", e10);
            }
        }
    }
}
