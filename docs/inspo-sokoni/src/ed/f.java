package ed;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7926b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f7927a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public f(String pattern) {
        kotlin.jvm.internal.k.e(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        kotlin.jvm.internal.k.d(patternCompile, "compile(...)");
        this(patternCompile);
    }

    public f(Pattern nativePattern) {
        kotlin.jvm.internal.k.e(nativePattern, "nativePattern");
        this.f7927a = nativePattern;
    }

    public final boolean a(CharSequence input) {
        kotlin.jvm.internal.k.e(input, "input");
        return this.f7927a.matcher(input).matches();
    }

    public String toString() {
        String string = this.f7927a.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        return string;
    }
}
