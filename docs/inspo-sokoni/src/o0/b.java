package o0;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(Object obj, StringBuilder sb2) {
        String hexString;
        int iLastIndexOf;
        if (obj == null) {
            hexString = "null";
        } else {
            String simpleName = obj.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(iLastIndexOf + 1);
            }
            sb2.append(simpleName);
            sb2.append('{');
            hexString = Integer.toHexString(System.identityHashCode(obj));
        }
        sb2.append(hexString);
    }
}
