package be;

import d9.a0;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Serializable, Cloneable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Integer f3081u = 99;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Integer f3082v = 98;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Map<String, Integer> f3083w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Map<String, Integer> f3084x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f3085y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3086a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient TreeSet<Integer> f3088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient TreeSet<Integer> f3089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient TreeSet<Integer> f3090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient TreeSet<Integer> f3091f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public transient TreeSet<Integer> f3092l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public transient TreeSet<Integer> f3093m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public transient TreeSet<Integer> f3094n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TimeZone f3087b = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public transient boolean f3095o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public transient int f3096p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public transient boolean f3097q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public transient boolean f3098r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public transient int f3099s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public transient boolean f3100t = false;

    static {
        HashMap map = new HashMap(20);
        f3083w = map;
        HashMap map2 = new HashMap(60);
        f3084x = map2;
        map.put("JAN", 0);
        map.put("FEB", 1);
        map.put("MAR", 2);
        map.put("APR", 3);
        map.put("MAY", 4);
        map.put("JUN", 5);
        map.put("JUL", 6);
        map.put("AUG", 7);
        map.put("SEP", 8);
        map.put("OCT", 9);
        map.put("NOV", 10);
        map.put("DEC", 11);
        map2.put("SUN", 1);
        map2.put("MON", 2);
        map2.put("TUE", 3);
        map2.put("WED", 4);
        map2.put("THU", 5);
        map2.put("FRI", 6);
        map2.put("SAT", 7);
        f3085y = Calendar.getInstance().get(1) + 100;
    }

    public a(a aVar) {
        String strG = aVar.g();
        this.f3086a = strG;
        try {
            b(strG);
            if (aVar.p() != null) {
                u((TimeZone) aVar.p().clone());
            }
        } catch (ParseException unused) {
            throw new AssertionError();
        }
    }

    public a(String str) throws ParseException {
        if (str == null) {
            throw new IllegalArgumentException("cronExpression cannot be null");
        }
        String upperCase = str.toUpperCase(Locale.US);
        this.f3086a = upperCase;
        b(upperCase);
    }

    public static boolean s(String str) {
        try {
            new a(str);
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:74:0x00bd A[PHI: r1
  0x00bd: PHI (r1v16 int) = (r1v12 int), (r1v12 int), (r1v14 int), (r1v14 int), (r1v17 int), (r1v17 int) binds: [B:84:0x00cf, B:85:0x00d1, B:78:0x00c5, B:79:0x00c7, B:72:0x00b9, B:73:0x00bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:98:0x00e9 A[PHI: r1
  0x00e9: PHI (r1v4 int) = (r1v2 int), (r1v2 int), (r1v19 int), (r1v19 int) binds: [B:96:0x00e5, B:97:0x00e7, B:66:0x00af, B:67:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    public void a(int i10, int i11, int i12, int i13) throws ParseException {
        int i14;
        int i15;
        int i16;
        Integer numValueOf;
        int i17 = i10;
        int i18 = i11;
        int i19 = i12;
        TreeSet<Integer> treeSetN = n(i13);
        if (i13 == 0 || i13 == 1) {
            i14 = 7;
            i15 = 59;
            if ((i17 < 0 || i17 > 59 || i18 > 59) && i17 != 99) {
                throw new ParseException("Minute and Second values must be between 0 and 59", -1);
            }
        } else {
            if (i13 == 2) {
                if ((i17 < 0 || i17 > 23 || i18 > 23) && i17 != 99) {
                    throw new ParseException("Hour values must be between 0 and 23", -1);
                }
            } else if (i13 == 3) {
                if ((i17 < 1 || i17 > 31 || i18 > 31) && i17 != 99 && i17 != 98) {
                    throw new ParseException("Day of month values must be between 1 and 31", -1);
                }
            } else if (i13 != 4) {
                i14 = 7;
                if (i13 == 5 && ((i17 == 0 || i17 > 7 || i18 > 7) && i17 != 99 && i17 != 98)) {
                    throw new ParseException("Day-of-Week values must be between 1 and 7", -1);
                }
                i15 = 59;
            } else if ((i17 < 1 || i17 > 12 || i18 > 12) && i17 != 99) {
                throw new ParseException("Month values must be between 1 and 12", -1);
            }
            i15 = 59;
            i14 = 7;
        }
        if ((i19 == 0 || i19 == -1) && i17 != 99) {
            treeSetN.add(i17 != -1 ? Integer.valueOf(i10) : f3082v);
            return;
        }
        if (i17 == 99 && i19 <= 0) {
            treeSetN.add(f3081u);
            i19 = 1;
        }
        if (i13 == 0 || i13 == 1) {
            if (i18 == -1) {
                i18 = i15;
            }
            if (i17 == -1 || i17 == 99) {
                i17 = 0;
            }
        } else if (i13 == 2) {
            if (i18 == -1) {
                i18 = 23;
            }
            if (i17 == -1 || i17 == 99) {
                i17 = 0;
            }
        } else if (i13 == 3) {
            if (i18 == -1) {
                i18 = 31;
            }
            if (i17 == -1 || i17 == 99) {
                i17 = 1;
            }
        } else if (i13 == 4) {
            if (i18 == -1) {
                i18 = 12;
            }
            if (i17 == -1 || i17 == 99) {
                i17 = 1;
            }
        } else if (i13 == 5) {
            if (i18 == -1) {
                i18 = i14;
            }
            if (i17 == -1 || i17 == 99) {
                i17 = 1;
            }
        } else if (i13 == 6) {
            if (i18 == -1) {
                i18 = f3085y;
            }
            if (i17 == -1 || i17 == 99) {
                i17 = 1970;
            }
        }
        if (i18 < i17) {
            i16 = 60;
            switch (i13) {
                case 0:
                case 1:
                    i18 += i16;
                    break;
                case 2:
                    i16 = 24;
                    i18 += i16;
                    break;
                case 3:
                    i16 = 31;
                    i18 += i16;
                    break;
                case 4:
                    i16 = 12;
                    i18 += i16;
                    break;
                case 5:
                    i16 = i14;
                    i18 += i16;
                    break;
                case 6:
                    throw new IllegalArgumentException("Start year must be less than stop year");
                default:
                    throw new IllegalArgumentException("Unexpected type encountered");
            }
        } else {
            i16 = -1;
        }
        while (i17 <= i18) {
            if (i16 == -1) {
                numValueOf = Integer.valueOf(i17);
            } else {
                int i20 = i17 % i16;
                if (i20 == 0 && (i13 == 4 || i13 == 5 || i13 == 3)) {
                    i20 = i16;
                }
                numValueOf = Integer.valueOf(i20);
            }
            treeSetN.add(numValueOf);
            i17 += i19;
        }
    }

    public void b(String str) throws ParseException {
        this.f3100t = true;
        try {
            if (this.f3088c == null) {
                this.f3088c = new TreeSet<>();
            }
            if (this.f3089d == null) {
                this.f3089d = new TreeSet<>();
            }
            if (this.f3090e == null) {
                this.f3090e = new TreeSet<>();
            }
            if (this.f3091f == null) {
                this.f3091f = new TreeSet<>();
            }
            if (this.f3092l == null) {
                this.f3092l = new TreeSet<>();
            }
            if (this.f3093m == null) {
                this.f3093m = new TreeSet<>();
            }
            if (this.f3094n == null) {
                this.f3094n = new TreeSet<>();
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str, " \t", false);
            int i10 = 0;
            while (stringTokenizer.hasMoreTokens() && i10 <= 6) {
                String strTrim = stringTokenizer.nextToken().trim();
                if (i10 == 3 && strTrim.indexOf(76) != -1 && strTrim.length() > 1 && strTrim.contains(",")) {
                    throw new ParseException("Support for specifying 'L' and 'LW' with other days of the month is not implemented", -1);
                }
                if (i10 == 5 && strTrim.indexOf(76) != -1 && strTrim.length() > 1 && strTrim.contains(",")) {
                    throw new ParseException("Support for specifying 'L' with other days of the week is not implemented", -1);
                }
                if (i10 == 5 && strTrim.indexOf(35) != -1 && strTrim.indexOf(35, strTrim.indexOf(35) + 1) != -1) {
                    throw new ParseException("Support for specifying multiple \"nth\" days is not implemented.", -1);
                }
                StringTokenizer stringTokenizer2 = new StringTokenizer(strTrim, ",");
                while (stringTokenizer2.hasMoreTokens()) {
                    w(0, stringTokenizer2.nextToken(), i10);
                }
                i10++;
            }
            if (i10 <= 5) {
                throw new ParseException("Unexpected end of expression.", str.length());
            }
            if (i10 <= 6) {
                w(0, "*", 6);
            }
            TreeSet<Integer> treeSetN = n(5);
            TreeSet<Integer> treeSetN2 = n(3);
            Integer num = f3082v;
            boolean z10 = !treeSetN2.contains(num);
            boolean z11 = !treeSetN.contains(num);
            if (!z10 || z11) {
                if (!z11 || z10) {
                    throw new ParseException("Support for specifying both a day-of-week AND a day-of-month parameter is not implemented.", 0);
                }
            }
        } catch (ParseException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new ParseException("Illegal cron expression format (" + e11.toString() + ")", 0);
        }
    }

    public final void c(int i10, int i11, int i12) throws ParseException {
        if (i10 > 59 && (i11 == 0 || i11 == 1)) {
            throw new ParseException("Increment > 60 : " + i10, i12);
        }
        if (i10 > 23 && i11 == 2) {
            throw new ParseException("Increment > 24 : " + i10, i12);
        }
        if (i10 > 31 && i11 == 3) {
            throw new ParseException("Increment > 31 : " + i10, i12);
        }
        if (i10 > 7 && i11 == 5) {
            throw new ParseException("Increment > 7 : " + i10, i12);
        }
        if (i10 <= 12 || i11 != 4) {
            return;
        }
        throw new ParseException("Increment > 12 : " + i10, i12);
    }

    @Deprecated
    public Object clone() {
        return new a(this);
    }

    public int d(int i10, String str, int i11, int i12) throws ParseException {
        if (i10 >= str.length()) {
            a(i11, -1, -1, i12);
            return i10;
        }
        char cCharAt = str.charAt(i10);
        if (cCharAt == 'L') {
            if (i12 != 5) {
                throw new ParseException("'L' option is not valid here. (pos=" + i10 + ")", i10);
            }
            if (i11 < 1 || i11 > 7) {
                throw new ParseException("Day-of-Week values must be between 1 and 7", -1);
            }
            this.f3095o = true;
            n(i12).add(Integer.valueOf(i11));
            return i10 + 1;
        }
        if (cCharAt == 'W') {
            if (i12 == 3) {
                this.f3098r = true;
                if (i11 > 31) {
                    throw new ParseException("The 'W' option does not make sense with values larger than 31 (max number of days in a month)", i10);
                }
                n(i12).add(Integer.valueOf(i11));
                return i10 + 1;
            }
            throw new ParseException("'W' option is not valid here. (pos=" + i10 + ")", i10);
        }
        if (cCharAt == '#') {
            if (i12 != 5) {
                throw new ParseException("'#' option is not valid here. (pos=" + i10 + ")", i10);
            }
            int i13 = i10 + 1;
            try {
                int i14 = Integer.parseInt(str.substring(i13));
                this.f3096p = i14;
                if (i14 < 1 || i14 > 5) {
                    throw new Exception();
                }
                n(i12).add(Integer.valueOf(i11));
                return i13 + 1;
            } catch (Exception unused) {
                throw new ParseException("A numeric value between 1 and 5 must follow the '#' option", i13);
            }
        }
        if (cCharAt != '-') {
            if (cCharAt != '/') {
                a(i11, -1, 0, i12);
                return i10 + 1;
            }
            int i15 = i10 + 1;
            if (i15 >= str.length() || str.charAt(i15) == ' ' || str.charAt(i15) == '\t') {
                throw new ParseException("'/' must be followed by an integer.", i10);
            }
            int i16 = Integer.parseInt(String.valueOf(str.charAt(i15)));
            int i17 = i15 + 1;
            if (i17 >= str.length()) {
                c(i16, i12, i17);
                a(i11, -1, i16, i12);
                return i17;
            }
            char cCharAt2 = str.charAt(i17);
            if (cCharAt2 < '0' || cCharAt2 > '9') {
                throw new ParseException("Unexpected character '" + cCharAt2 + "' after '/'", i17);
            }
            b bVarQ = q(i16, str, i17);
            int i18 = bVarQ.f3101a;
            c(i18, i12, i17);
            a(i11, -1, i18, i12);
            return bVarQ.f3102b;
        }
        int i19 = i10 + 1;
        int i20 = Integer.parseInt(String.valueOf(str.charAt(i19)));
        int i21 = i19 + 1;
        if (i21 >= str.length()) {
            a(i11, i20, 1, i12);
            return i21;
        }
        char cCharAt3 = str.charAt(i21);
        if (cCharAt3 >= '0' && cCharAt3 <= '9') {
            b bVarQ2 = q(i20, str, i21);
            i20 = bVarQ2.f3101a;
            i21 = bVarQ2.f3102b;
        }
        if (i21 >= str.length() || str.charAt(i21) != '/') {
            a(i11, i20, 1, i12);
            return i21;
        }
        int i22 = i21 + 1;
        int i23 = Integer.parseInt(String.valueOf(str.charAt(i22)));
        int i24 = i22 + 1;
        if (i24 >= str.length()) {
            a(i11, i20, i23, i12);
            return i24;
        }
        char cCharAt4 = str.charAt(i24);
        if (cCharAt4 < '0' || cCharAt4 > '9') {
            a(i11, i20, i23, i12);
            return i24;
        }
        b bVarQ3 = q(i23, str, i24);
        a(i11, i20, bVarQ3.f3101a, i12);
        return bVarQ3.f3102b;
    }

    public int f(int i10, String str) {
        while (i10 < str.length() && (str.charAt(i10) != ' ' || str.charAt(i10) != '\t')) {
            i10++;
        }
        return i10;
    }

    public String g() {
        return this.f3086a;
    }

    public int h(String str) {
        Integer num = f3084x.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public int i(int i10, int i11) {
        switch (i10) {
            case 1:
                return 31;
            case 2:
                return r(i11) ? 29 : 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return 31;
            default:
                throw new IllegalArgumentException("Illegal month number: " + i10);
        }
    }

    public int j(String str) {
        Integer num = f3083w.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public Date l(Date date) {
        return o(date);
    }

    public int m(String str, int i10) {
        return Integer.parseInt(str.substring(i10, f(i10, str)));
    }

    public TreeSet<Integer> n(int i10) {
        switch (i10) {
            case 0:
                return this.f3088c;
            case 1:
                return this.f3089d;
            case 2:
                return this.f3090e;
            case 3:
                return this.f3091f;
            case 4:
                return this.f3092l;
            case 5:
                return this.f3093m;
            case 6:
                return this.f3094n;
            default:
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:158:0x042b  */
    /* JADX WARN: Code duplicated, block: B:160:0x0437  */
    /* JADX WARN: Code duplicated, block: B:163:0x0449  */
    /* JADX WARN: Code duplicated, block: B:165:0x045a  */
    /* JADX WARN: Code duplicated, block: B:166:0x0479  */
    /* JADX WARN: Code duplicated, block: B:168:0x048f  */
    /* JADX WARN: Code duplicated, block: B:185:0x0429 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x04c5 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x026a  */
    /* JADX WARN: Code duplicated, block: B:85:0x0279 A[PHI: r4
  0x0279: PHI (r4v72 int) = (r4v65 int), (r4v80 int) binds: [B:83:0x0268, B:77:0x024b] A[DONT_GENERATE, DONT_INLINE]] */
    public Date o(Date date) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        SortedSet<Integer> sortedSetTailSet;
        int iIntValue4;
        int i17;
        SortedSet<Integer> sortedSetTailSet2;
        int i18;
        int i19;
        int iIntValue5;
        int i20;
        int i21;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(p());
        Date date2 = new Date(date.getTime() + 1000);
        gregorianCalendar.setTime(date2);
        int i22 = 0;
        gregorianCalendar.set(14, 0);
        boolean z10 = false;
        while (!z10) {
            if (gregorianCalendar.get(1) > 2999) {
                return null;
            }
            int i23 = gregorianCalendar.get(13);
            int i24 = gregorianCalendar.get(12);
            SortedSet<Integer> sortedSetTailSet3 = this.f3088c.tailSet(Integer.valueOf(i23));
            if (sortedSetTailSet3 == null || sortedSetTailSet3.size() == 0) {
                iIntValue = this.f3088c.first().intValue();
                gregorianCalendar.set(12, i24 + 1);
            } else {
                iIntValue = sortedSetTailSet3.first().intValue();
            }
            gregorianCalendar.set(13, iIntValue);
            int i25 = gregorianCalendar.get(12);
            int i26 = gregorianCalendar.get(11);
            SortedSet<Integer> sortedSetTailSet4 = this.f3089d.tailSet(Integer.valueOf(i25));
            if (sortedSetTailSet4 == null || sortedSetTailSet4.size() == 0) {
                iIntValue2 = this.f3089d.first().intValue();
                i26++;
                i25 = -1;
            } else {
                iIntValue2 = sortedSetTailSet4.first().intValue();
            }
            if (iIntValue2 != i25) {
                gregorianCalendar.set(13, i22);
                gregorianCalendar.set(12, iIntValue2);
                t(gregorianCalendar, i26);
            } else {
                gregorianCalendar.set(12, iIntValue2);
                int i27 = gregorianCalendar.get(11);
                int i28 = gregorianCalendar.get(5);
                SortedSet<Integer> sortedSetTailSet5 = this.f3090e.tailSet(Integer.valueOf(i27));
                if (sortedSetTailSet5 == null || sortedSetTailSet5.size() == 0) {
                    iIntValue3 = this.f3090e.first().intValue();
                    i28++;
                    i27 = -1;
                } else {
                    iIntValue3 = sortedSetTailSet5.first().intValue();
                }
                if (iIntValue3 != i27) {
                    gregorianCalendar.set(13, i22);
                    gregorianCalendar.set(12, i22);
                    gregorianCalendar.set(5, i28);
                    t(gregorianCalendar, iIntValue3);
                } else {
                    gregorianCalendar.set(11, iIntValue3);
                    int iIntValue6 = gregorianCalendar.get(5);
                    int i29 = gregorianCalendar.get(2) + 1;
                    TreeSet<Integer> treeSet = this.f3091f;
                    Integer num = f3082v;
                    boolean z11 = !treeSet.contains(num);
                    boolean z12 = !this.f3093m.contains(num);
                    if (z11 && !z12) {
                        SortedSet<Integer> sortedSetTailSet6 = this.f3091f.tailSet(Integer.valueOf(iIntValue6));
                        if (this.f3097q) {
                            if (this.f3098r) {
                                int i30 = i(i29, gregorianCalendar.get(1)) - this.f3099s;
                                Calendar calendar = Calendar.getInstance(p());
                                calendar.set(13, i22);
                                calendar.set(12, i22);
                                calendar.set(11, i22);
                                calendar.set(5, i30);
                                int i31 = i29 - 1;
                                calendar.set(2, i31);
                                calendar.set(1, gregorianCalendar.get(1));
                                int i32 = i(i29, gregorianCalendar.get(1));
                                int i33 = calendar.get(7);
                                if (i33 == 7 && i30 == 1) {
                                    i30 += 2;
                                } else if (i33 == 7) {
                                    i30--;
                                } else if (i33 == 1 && i30 == i32) {
                                    i30 -= 2;
                                } else if (i33 == 1) {
                                    i30++;
                                }
                                calendar.set(13, iIntValue);
                                calendar.set(12, iIntValue2);
                                calendar.set(11, iIntValue3);
                                calendar.set(5, i30);
                                calendar.set(2, i31);
                                if (calendar.getTime().before(date2)) {
                                    i21 = i29 + 1;
                                    i30 = 1;
                                } else {
                                    i21 = i29;
                                }
                                i18 = i29;
                                i29 = i21;
                                i19 = iIntValue6;
                                iIntValue6 = i30;
                            } else {
                                int i34 = i(i29, gregorianCalendar.get(1)) - this.f3099s;
                                if (iIntValue6 > i34) {
                                    int i35 = i29 + 1;
                                    if (i35 > 12) {
                                        gregorianCalendar.add(1, 1);
                                        i18 = 3333;
                                        i29 = 1;
                                    } else {
                                        i29 = i35;
                                        i18 = i29;
                                    }
                                    i19 = iIntValue6;
                                    iIntValue6 = 1;
                                } else {
                                    i19 = iIntValue6;
                                    iIntValue6 = i34;
                                    i18 = i29;
                                }
                            }
                        } else if (this.f3098r) {
                            iIntValue5 = this.f3091f.first().intValue();
                            Calendar calendar2 = Calendar.getInstance(p());
                            calendar2.set(13, 0);
                            calendar2.set(12, 0);
                            calendar2.set(11, 0);
                            calendar2.set(5, iIntValue5);
                            int i36 = i29 - 1;
                            calendar2.set(2, i36);
                            calendar2.set(1, gregorianCalendar.get(1));
                            int i37 = i(i29, gregorianCalendar.get(1));
                            int i38 = calendar2.get(7);
                            if (i38 == 7 && iIntValue5 == 1) {
                                iIntValue5 += 2;
                            } else if (i38 == 7) {
                                iIntValue5--;
                            } else if (i38 == 1 && iIntValue5 == i37) {
                                iIntValue5 -= 2;
                            } else if (i38 == 1) {
                                iIntValue5++;
                            }
                            calendar2.set(13, iIntValue);
                            calendar2.set(12, iIntValue2);
                            calendar2.set(11, iIntValue3);
                            calendar2.set(5, iIntValue5);
                            calendar2.set(2, i36);
                            if (calendar2.getTime().before(date2)) {
                                iIntValue5 = this.f3091f.first().intValue();
                                i20 = i29 + 1;
                            } else {
                                i20 = i29;
                            }
                            i18 = i29;
                            i29 = i20;
                            iIntValue6 = iIntValue5;
                            i19 = iIntValue6;
                        } else if (sortedSetTailSet6 == null || sortedSetTailSet6.size() == 0) {
                            iIntValue6 = this.f3091f.first().intValue();
                            i18 = i29;
                            i19 = -1;
                            i29++;
                        } else {
                            iIntValue5 = sortedSetTailSet6.first().intValue();
                            if (iIntValue5 > i(i29, gregorianCalendar.get(1))) {
                                iIntValue5 = this.f3091f.first().intValue();
                                i20 = i29 + 1;
                            } else {
                                i20 = i29;
                            }
                            i18 = i29;
                            i29 = i20;
                            iIntValue6 = iIntValue5;
                            i19 = iIntValue6;
                        }
                        if (iIntValue6 != i19 || i29 != i18) {
                            gregorianCalendar.set(13, 0);
                            gregorianCalendar.set(12, 0);
                            gregorianCalendar.set(11, 0);
                            gregorianCalendar.set(5, iIntValue6);
                            i29--;
                            gregorianCalendar.set(2, i29);
                            i12 = 0;
                        }
                        i10 = 5;
                        i11 = 2;
                        gregorianCalendar.set(i10, iIntValue6);
                        i15 = gregorianCalendar.get(i11) + 1;
                        i16 = gregorianCalendar.get(1);
                        if (i16 > f3085y) {
                            return null;
                        }
                        sortedSetTailSet = this.f3092l.tailSet(Integer.valueOf(i15));
                        if (sortedSetTailSet != null) {
                            iIntValue4 = this.f3092l.first().intValue();
                            i16++;
                            i17 = -1;
                        } else {
                            iIntValue4 = this.f3092l.first().intValue();
                            i16++;
                            i17 = -1;
                        }
                        if (iIntValue4 != i17) {
                            gregorianCalendar.set(2, iIntValue4 - 1);
                            int i39 = gregorianCalendar.get(1);
                            sortedSetTailSet2 = this.f3094n.tailSet(Integer.valueOf(i39));
                            if (sortedSetTailSet2 == null) {
                            }
                        }
                        gregorianCalendar.set(13, 0);
                        gregorianCalendar.set(12, 0);
                        gregorianCalendar.set(11, 0);
                        gregorianCalendar.set(5, 1);
                        gregorianCalendar.set(2, iIntValue4 - 1);
                        gregorianCalendar.set(1, i16);
                        i12 = 0;
                    } else {
                        if (!z12 || z11) {
                            throw new UnsupportedOperationException("Support for specifying both a day-of-week AND a day-of-month parameter is not implemented.");
                        }
                        if (this.f3095o) {
                            int iIntValue7 = this.f3093m.first().intValue();
                            int i40 = gregorianCalendar.get(7);
                            int i41 = i40 < iIntValue7 ? iIntValue7 - i40 : 0;
                            if (i40 > iIntValue7) {
                                i41 = iIntValue7 + (7 - i40);
                            }
                            int i42 = i(i29, gregorianCalendar.get(1));
                            if (iIntValue6 + i41 > i42) {
                                gregorianCalendar.set(13, 0);
                                gregorianCalendar.set(12, 0);
                                gregorianCalendar.set(11, 0);
                                gregorianCalendar.set(5, 1);
                            } else {
                                while (true) {
                                    i14 = iIntValue6 + i41;
                                    if (i14 + 7 > i42) {
                                        break;
                                    }
                                    i41 += 7;
                                }
                                if (i41 > 0) {
                                    gregorianCalendar.set(13, 0);
                                    gregorianCalendar.set(12, 0);
                                    gregorianCalendar.set(11, 0);
                                    gregorianCalendar.set(5, i14);
                                    i29--;
                                } else {
                                    iIntValue6 = i14;
                                }
                            }
                            gregorianCalendar.set(2, i29);
                            i12 = 0;
                        } else if (this.f3096p != 0) {
                            int iIntValue8 = this.f3093m.first().intValue();
                            int i43 = gregorianCalendar.get(7);
                            if (i43 < iIntValue8) {
                                i13 = iIntValue8 - i43;
                            } else {
                                i13 = i43 > iIntValue8 ? iIntValue8 + (7 - i43) : 0;
                            }
                            boolean z13 = i13 > 0;
                            int i44 = iIntValue6 + i13;
                            int i45 = i44 / 7;
                            if (i44 % 7 > 0) {
                                i45++;
                            }
                            int i46 = (this.f3096p - i45) * 7;
                            iIntValue6 = i44 + i46;
                            if (i46 < 0 || iIntValue6 > i(i29, gregorianCalendar.get(1))) {
                                gregorianCalendar.set(13, 0);
                                gregorianCalendar.set(12, 0);
                                gregorianCalendar.set(11, 0);
                                gregorianCalendar.set(5, 1);
                                gregorianCalendar.set(2, i29);
                                i12 = 0;
                            } else if (i46 > 0 || z13) {
                                gregorianCalendar.set(13, 0);
                                gregorianCalendar.set(12, 0);
                                gregorianCalendar.set(11, 0);
                                gregorianCalendar.set(5, iIntValue6);
                                gregorianCalendar.set(2, i29 - 1);
                                i12 = 0;
                            }
                        } else {
                            int i47 = gregorianCalendar.get(7);
                            int iIntValue9 = this.f3093m.first().intValue();
                            SortedSet<Integer> sortedSetTailSet7 = this.f3093m.tailSet(Integer.valueOf(i47));
                            if (sortedSetTailSet7 != null && sortedSetTailSet7.size() > 0) {
                                iIntValue9 = sortedSetTailSet7.first().intValue();
                            }
                            int i48 = i47 < iIntValue9 ? iIntValue9 - i47 : 0;
                            if (i47 > iIntValue9) {
                                i48 = iIntValue9 + (7 - i47);
                            }
                            int i49 = iIntValue6 + i48;
                            if (i49 > i(i29, gregorianCalendar.get(1))) {
                                gregorianCalendar.set(13, 0);
                                gregorianCalendar.set(12, 0);
                                gregorianCalendar.set(11, 0);
                                gregorianCalendar.set(5, 1);
                                gregorianCalendar.set(2, i29);
                                i12 = 0;
                            } else {
                                i10 = 5;
                                i11 = 2;
                                if (i48 > 0) {
                                    gregorianCalendar.set(13, 0);
                                    gregorianCalendar.set(12, 0);
                                    gregorianCalendar.set(11, 0);
                                    gregorianCalendar.set(5, i49);
                                    gregorianCalendar.set(2, i29 - 1);
                                } else {
                                    gregorianCalendar.set(i10, iIntValue6);
                                    i15 = gregorianCalendar.get(i11) + 1;
                                    i16 = gregorianCalendar.get(1);
                                    if (i16 > f3085y) {
                                        return null;
                                    }
                                    sortedSetTailSet = this.f3092l.tailSet(Integer.valueOf(i15));
                                    if (sortedSetTailSet != null || sortedSetTailSet.size() == 0) {
                                        iIntValue4 = this.f3092l.first().intValue();
                                        i16++;
                                        i17 = -1;
                                    } else {
                                        iIntValue4 = sortedSetTailSet.first().intValue();
                                        i17 = i15;
                                    }
                                    if (iIntValue4 != i17) {
                                        gregorianCalendar.set(13, 0);
                                        gregorianCalendar.set(12, 0);
                                        gregorianCalendar.set(11, 0);
                                        gregorianCalendar.set(5, 1);
                                        gregorianCalendar.set(2, iIntValue4 - 1);
                                        gregorianCalendar.set(1, i16);
                                    } else {
                                        gregorianCalendar.set(2, iIntValue4 - 1);
                                        int i310 = gregorianCalendar.get(1);
                                        sortedSetTailSet2 = this.f3094n.tailSet(Integer.valueOf(i310));
                                        if (sortedSetTailSet2 == null && sortedSetTailSet2.size() != 0) {
                                            int iIntValue10 = sortedSetTailSet2.first().intValue();
                                            if (iIntValue10 != i310) {
                                                i12 = 0;
                                                gregorianCalendar.set(13, 0);
                                                gregorianCalendar.set(12, 0);
                                                gregorianCalendar.set(11, 0);
                                                gregorianCalendar.set(5, 1);
                                                gregorianCalendar.set(2, 0);
                                                gregorianCalendar.set(1, iIntValue10);
                                            } else {
                                                i12 = 0;
                                                gregorianCalendar.set(1, iIntValue10);
                                                z10 = true;
                                            }
                                        }
                                    }
                                }
                                i12 = 0;
                            }
                        }
                        i10 = 5;
                        i11 = 2;
                        gregorianCalendar.set(i10, iIntValue6);
                        i15 = gregorianCalendar.get(i11) + 1;
                        i16 = gregorianCalendar.get(1);
                        if (i16 > f3085y) {
                            return null;
                        }
                        sortedSetTailSet = this.f3092l.tailSet(Integer.valueOf(i15));
                        if (sortedSetTailSet != null) {
                            iIntValue4 = this.f3092l.first().intValue();
                            i16++;
                            i17 = -1;
                        } else {
                            iIntValue4 = this.f3092l.first().intValue();
                            i16++;
                            i17 = -1;
                        }
                        if (iIntValue4 != i17) {
                            gregorianCalendar.set(2, iIntValue4 - 1);
                            int i311 = gregorianCalendar.get(1);
                            sortedSetTailSet2 = this.f3094n.tailSet(Integer.valueOf(i311));
                            return sortedSetTailSet2 == null ? null : null;
                        }
                        gregorianCalendar.set(13, 0);
                        gregorianCalendar.set(12, 0);
                        gregorianCalendar.set(11, 0);
                        gregorianCalendar.set(5, 1);
                        gregorianCalendar.set(2, iIntValue4 - 1);
                        gregorianCalendar.set(1, i16);
                        i12 = 0;
                    }
                }
                i22 = i12;
            }
            i12 = i22;
            i22 = i12;
        }
        return gregorianCalendar.getTime();
    }

    public TimeZone p() {
        if (this.f3087b == null) {
            this.f3087b = TimeZone.getDefault();
        }
        return this.f3087b;
    }

    public b q(int i10, String str, int i11) {
        char cCharAt = str.charAt(i11);
        StringBuilder sb2 = new StringBuilder(String.valueOf(i10));
        while (cCharAt >= '0' && cCharAt <= '9') {
            sb2.append(cCharAt);
            i11++;
            if (i11 >= str.length()) {
                break;
            }
            cCharAt = str.charAt(i11);
        }
        b bVar = new b();
        if (i11 >= str.length()) {
            i11++;
        }
        bVar.f3102b = i11;
        bVar.f3101a = Integer.parseInt(sb2.toString());
        return bVar;
    }

    public boolean r(int i10) {
        return (i10 % 4 == 0 && i10 % 100 != 0) || i10 % 400 == 0;
    }

    public void t(Calendar calendar, int i10) {
        calendar.set(11, i10);
        if (calendar.get(11) == i10 || i10 == 24) {
            return;
        }
        calendar.set(11, i10 + 1);
    }

    public String toString() {
        return this.f3086a;
    }

    public void u(TimeZone timeZone) {
        this.f3087b = timeZone;
    }

    public int v(int i10, String str) {
        while (i10 < str.length() && (str.charAt(i10) == ' ' || str.charAt(i10) == '\t')) {
            i10++;
        }
        return i10;
    }

    public int w(int i10, String str, int i11) throws ParseException {
        int i12;
        int i13;
        int iH;
        int iJ;
        int iV = v(i10, str);
        if (iV >= str.length()) {
            return iV;
        }
        char cCharAt = str.charAt(iV);
        int i14 = 1;
        if (cCharAt >= 'A' && cCharAt <= 'Z' && !str.equals("L") && !str.equals("LW") && !str.matches("^L-[0-9]*[W]?")) {
            int i15 = iV + 3;
            String strSubstring = str.substring(iV, i15);
            if (i11 == 4) {
                iJ = j(strSubstring) + 1;
                if (iJ <= 0) {
                    throw new ParseException("Invalid Month value: '" + strSubstring + "'", iV);
                }
                if (str.length() <= i15 || str.charAt(i15) != '-') {
                    iH = -1;
                } else {
                    iV += 4;
                    String strSubstring2 = str.substring(iV, iV + 3);
                    iH = j(strSubstring2) + 1;
                    if (iH <= 0) {
                        throw new ParseException("Invalid Month value: '" + strSubstring2 + "'", iV);
                    }
                }
            } else {
                if (i11 != 5) {
                    throw new ParseException("Illegal characters for this position: '" + strSubstring + "'", iV);
                }
                int iH2 = h(strSubstring);
                if (iH2 < 0) {
                    throw new ParseException("Invalid Day-of-Week value: '" + strSubstring + "'", iV);
                }
                if (str.length() <= i15) {
                    iH = -1;
                } else {
                    char cCharAt2 = str.charAt(i15);
                    if (cCharAt2 == '-') {
                        iV += 4;
                        String strSubstring3 = str.substring(iV, iV + 3);
                        iH = h(strSubstring3);
                        if (iH < 0) {
                            throw new ParseException("Invalid Day-of-Week value: '" + strSubstring3 + "'", iV);
                        }
                    } else {
                        if (cCharAt2 == '#') {
                            iV += 4;
                            try {
                                int i16 = Integer.parseInt(str.substring(iV));
                                this.f3096p = i16;
                                if (i16 < 1 || i16 > 5) {
                                    throw new Exception();
                                }
                            } catch (Exception unused) {
                                throw new ParseException("A numeric value between 1 and 5 must follow the '#' option", iV);
                            }
                        } else if (cCharAt2 == 'L') {
                            this.f3095o = true;
                            iV++;
                        }
                        iH = -1;
                    }
                }
                iJ = iH2;
            }
            a(iJ, iH, iH == -1 ? 0 : 1, i11);
            return iV + 3;
        }
        if (cCharAt == '?') {
            int i17 = iV + 1;
            int i18 = i17 + 1;
            if (i18 < str.length() && str.charAt(i17) != ' ' && str.charAt(i18) != '\t') {
                throw new ParseException("Illegal character after '?': " + str.charAt(i17), i17);
            }
            if (i11 != 5 && i11 != 3) {
                throw new ParseException("'?' can only be specified for Day-of-Month or Day-of-Week.", i17);
            }
            if (i11 == 5 && !this.f3097q && this.f3091f.last().intValue() == 98) {
                throw new ParseException("'?' can only be specified for Day-of-Month -OR- Day-of-Week.", i17);
            }
            a(98, -1, 0, i11);
            return i17;
        }
        if (cCharAt == '*' || cCharAt == '/') {
            if (cCharAt == '*' && (i13 = iV + 1) >= str.length()) {
                a(99, -1, 0, i11);
                return i13;
            }
            if (cCharAt == '/' && ((i12 = iV + 1) >= str.length() || str.charAt(i12) == ' ' || str.charAt(i12) == '\t')) {
                throw new ParseException("'/' must be followed by an integer.", iV);
            }
            if (cCharAt == '*') {
                iV++;
            }
            if (str.charAt(iV) == '/') {
                int i19 = iV + 1;
                if (i19 >= str.length()) {
                    throw new ParseException("Unexpected end of string.", i19);
                }
                int iM = m(str, i19);
                iV = i19 + 1;
                if (iM > 10) {
                    iV++;
                }
                c(iM, i11, iV);
                i14 = iM;
            }
            a(99, -1, i14, i11);
            return iV;
        }
        if (cCharAt != 'L') {
            if (cCharAt < '0' || cCharAt > '9') {
                throw new ParseException("Unexpected character: " + cCharAt, iV);
            }
            int i20 = Integer.parseInt(String.valueOf(cCharAt));
            int i21 = iV + 1;
            if (i21 >= str.length()) {
                a(i20, -1, -1, i11);
                return i21;
            }
            char cCharAt3 = str.charAt(i21);
            if (cCharAt3 >= '0' && cCharAt3 <= '9') {
                b bVarQ = q(i20, str, i21);
                i20 = bVarQ.f3101a;
                i21 = bVarQ.f3102b;
            }
            return d(i21, str, i20, i11);
        }
        int i22 = iV + 1;
        if (i11 == 3) {
            this.f3097q = true;
        }
        if (i11 == 5) {
            a(7, 7, 0, i11);
        }
        if (i11 != 3 || str.length() <= i22) {
            return i22;
        }
        if (str.charAt(i22) == '-') {
            int i23 = i22 + 1;
            b bVarQ2 = q(0, str, i23);
            int i24 = bVarQ2.f3101a;
            this.f3099s = i24;
            if (i24 > 30) {
                throw new ParseException("Offset from last day must be <= 30", i23);
            }
            i22 = bVarQ2.f3102b;
        }
        if (str.length() <= i22 || str.charAt(i22) != 'W') {
            return i22;
        }
        this.f3098r = true;
        return i22 + 1;
    }
}
