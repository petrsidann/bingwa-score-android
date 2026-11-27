package je;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f11410a = "MapUtils";

    public static <T> j6.j<T> a(Object obj, Class<T> cls) {
        if (obj == null) {
            return j6.j.a();
        }
        try {
            if (cls.isInstance(obj)) {
                return j6.j.e(cls.cast(obj));
            }
        } catch (Exception unused) {
            de.a.a(f11410a, "Argument is not a type of " + j6.j.class.getSimpleName());
        }
        return j6.j.a();
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:67:0x0118  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static <T> j6.j<T> b(Map map, String str, Class<T> cls) {
        byte b10;
        TimeZone timeZoneB;
        if (c(map, str).booleanValue()) {
            return j6.j.a();
        }
        try {
            Object objG = map.get(str);
            if (cls == TimeZone.class) {
                if (objG != null && (objG instanceof String) && (timeZoneB = p.a().b((String) objG)) != null) {
                    return j6.j.b(cls.cast(timeZoneB));
                }
                return j6.j.a();
            }
            if (cls == Calendar.class) {
                return objG == null ? j6.j.a() : j6.j.b(cls.cast(d.g().a((String) objG)));
            }
            byte b11 = 0;
            if (Number.class.isAssignableFrom(cls)) {
                if (cls == Long.class && (objG instanceof String)) {
                    Matcher matcher = Pattern.compile("(0x|#)(\\w{2})?(\\w{6})", 2).matcher((String) objG);
                    if (matcher.find()) {
                        String strGroup = matcher.group(2);
                        StringBuilder sb2 = new StringBuilder();
                        if (strGroup == null) {
                            strGroup = "FF";
                        }
                        sb2.append(strGroup);
                        sb2.append(matcher.group(3));
                        String string = sb2.toString();
                        return j6.j.b(cls.cast(Long.valueOf(o.c().e(string).booleanValue() ? 0L : 0 + Long.parseLong(string, 16))));
                    }
                }
                if (objG instanceof Number) {
                    String lowerCase = cls.getSimpleName().toLowerCase();
                    switch (lowerCase.hashCode()) {
                        case -1325958191:
                            if (!lowerCase.equals("double")) {
                                b10 = -1;
                            } else {
                                b10 = 1;
                            }
                            break;
                        case 3039496:
                            if (!lowerCase.equals("byte")) {
                                b10 = -1;
                            } else {
                                b10 = 5;
                            }
                            break;
                        case 3327612:
                            if (!lowerCase.equals("long")) {
                                b10 = -1;
                            } else {
                                b10 = 3;
                            }
                            break;
                        case 97526364:
                            if (!lowerCase.equals("float")) {
                                b10 = -1;
                            } else {
                                b10 = 2;
                            }
                            break;
                        case 109413500:
                            if (!lowerCase.equals("short")) {
                                b10 = -1;
                            } else {
                                b10 = 4;
                            }
                            break;
                        case 1958052158:
                            if (!lowerCase.equals("integer")) {
                                b10 = -1;
                            } else {
                                b10 = 0;
                            }
                            break;
                        default:
                            b10 = -1;
                            break;
                    }
                    if (b10 == 0) {
                        objG = Integer.valueOf(((Number) objG).intValue());
                    } else if (b10 == 1) {
                        objG = Double.valueOf(((Number) objG).doubleValue());
                    } else if (b10 == 2) {
                        objG = Float.valueOf(((Number) objG).floatValue());
                    } else if (b10 == 3) {
                        objG = Long.valueOf(((Number) objG).longValue());
                    } else if (b10 == 4) {
                        objG = Short.valueOf(((Number) objG).shortValue());
                    } else if (b10 == 5) {
                        objG = Byte.valueOf(((Number) objG).byteValue());
                    }
                }
            }
            if (!(objG instanceof List) || !cls.isArray()) {
                if (cls.isInstance(objG)) {
                    return j6.j.b(cls.cast(objG));
                }
                return j6.j.a();
            }
            String lowerCase2 = cls.getSimpleName().toLowerCase();
            switch (lowerCase2.hashCode()) {
                case -1374008726:
                    if (!lowerCase2.equals("byte[]")) {
                        b11 = -1;
                    } else {
                        b11 = 4;
                    }
                    break;
                case -1097129250:
                    if (!lowerCase2.equals("long[]")) {
                        b11 = -1;
                    } else {
                        b11 = 1;
                    }
                    break;
                case -766441794:
                    if (!lowerCase2.equals("float[]")) {
                        b11 = -1;
                    } else {
                        b11 = 5;
                    }
                    break;
                case 100361105:
                    if (!lowerCase2.equals("int[]")) {
                        b11 = -1;
                    } else {
                        b11 = 3;
                    }
                    break;
                case 1359468275:
                    if (!lowerCase2.equals("double[]")) {
                        b11 = -1;
                    }
                    break;
                case 2067161310:
                    if (!lowerCase2.equals("short[]")) {
                        b11 = -1;
                    } else {
                        b11 = 2;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            if (b11 == 0) {
                objG = n6.b.g((List) objG);
            } else if (b11 == 1) {
                objG = n6.h.f((List) objG);
            } else if (b11 == 2) {
                objG = n6.i.f((List) objG);
            } else if (b11 == 3) {
                objG = n6.f.h((List) objG);
            } else if (b11 == 4) {
                objG = n6.a.f((List) objG);
            } else if (b11 == 5) {
                objG = n6.d.f((List) objG);
            }
            return j6.j.b(cls.cast(objG));
        } catch (Exception unused) {
            de.a.a(f11410a, str + " is not a type of " + j6.j.class.getSimpleName());
        }
    }

    public static Boolean c(Map map, String str) {
        if (map == null || map.isEmpty() || !map.containsKey(str)) {
            return Boolean.TRUE;
        }
        Object obj = map.get(str);
        if (obj == null) {
            return Boolean.TRUE;
        }
        if ((obj instanceof String) && ((String) obj).isEmpty()) {
            return Boolean.TRUE;
        }
        if ((obj instanceof Map) && ((Map) obj).isEmpty()) {
            return Boolean.TRUE;
        }
        return obj instanceof List ? Boolean.valueOf(((List) obj).isEmpty()) : Boolean.FALSE;
    }
}
