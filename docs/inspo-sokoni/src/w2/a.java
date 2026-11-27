package w2;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static Long a(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }
}
