package je;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static o f11417a;

    public static o c() {
        if (f11417a == null) {
            f11417a = new o();
        }
        return f11417a;
    }

    public String a(String str) {
        if (str == null) {
            str = "";
        }
        try {
            byte[] bytes = str.replaceAll("\\W+", "").getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);
            return String.format("%032x", new BigInteger(1, messageDigest.digest()));
        } catch (Exception unused) {
            return str;
        }
    }

    public <T extends Enum<T>> T b(Class<T> cls, String str) {
        if (cls == null || str == null) {
            return null;
        }
        try {
            return (T) Enum.valueOf(cls, str.trim());
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String d(String str, String str2) {
        return e(str).booleanValue() ? str2 : str;
    }

    public Boolean e(String str) {
        return Boolean.valueOf(str == null || str.trim().isEmpty());
    }

    public String f(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Objects.toString(next, "");
        }
        StringBuilder sb2 = new StringBuilder(256);
        if (next != null) {
            sb2.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                sb2.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                sb2.append(next2);
            }
        }
        return sb2.toString();
    }
}
