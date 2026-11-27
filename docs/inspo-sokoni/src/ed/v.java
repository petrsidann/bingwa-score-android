package ed;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class v extends u {
    public static final String p0(String str, int i10) {
        kotlin.jvm.internal.k.e(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(bd.h.c(i10, str.length()));
            kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static final char q0(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(t.x(charSequence));
    }
}
