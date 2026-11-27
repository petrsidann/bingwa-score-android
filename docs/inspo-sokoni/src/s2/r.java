package s2;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import d9.a0;
import d9.d0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r {
    public static String a(Context context, String str) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31 && e(context, null, str)) {
            return str;
        }
        if (i10 >= 29) {
            if (e(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
                return "android.permission.ACCESS_FINE_LOCATION";
            }
            return null;
        }
        if (e(context, null, "android.permission.ACCESS_FINE_LOCATION")) {
            return "android.permission.ACCESS_FINE_LOCATION";
        }
        if (e(context, null, "android.permission.ACCESS_COARSE_LOCATION")) {
            return "android.permission.ACCESS_COARSE_LOCATION";
        }
        return null;
    }

    public static int b(Activity activity, String str) {
        if (activity == null) {
            return 0;
        }
        boolean zL = l(activity, str);
        boolean z10 = true;
        boolean z11 = !f(activity, str);
        if (!zL) {
            z10 = z11;
        } else if (z11) {
            z10 = false;
        }
        if (!zL && z10) {
            h(activity, str);
        }
        return (zL && z10) ? 4 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:172:0x0243 A[PHI: r7
  0x0243: PHI (r7v74 java.lang.String) = 
  (r7v2 java.lang.String)
  (r7v3 java.lang.String)
  (r7v11 java.lang.String)
  (r7v34 java.lang.String)
  (r7v35 java.lang.String)
  (r7v49 java.lang.String)
  (r7v51 java.lang.String)
  (r7v56 java.lang.String)
  (r7v59 java.lang.String)
  (r7v75 java.lang.String)
 binds: [B:177:0x0256, B:171:0x0241, B:145:0x01eb, B:116:0x0178, B:111:0x016a, B:82:0x0103, B:79:0x00f9, B:61:0x00c7, B:53:0x00ac, B:14:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x00ea A[PHI: r6
  0x00ea: PHI (r6v42 java.lang.String) = 
  (r6v4 java.lang.String)
  (r6v6 java.lang.String)
  (r6v8 java.lang.String)
  (r6v11 java.lang.String)
  (r6v15 java.lang.String)
  (r6v17 java.lang.String)
  (r6v21 java.lang.String)
  (r6v23 java.lang.String)
  (r6v26 java.lang.String)
  (r6v29 java.lang.String)
  (r6v31 java.lang.String)
  (r6v32 java.lang.String)
  (r6v33 java.lang.String)
  (r6v34 java.lang.String)
  (r6v36 java.lang.String)
  (r6v38 java.lang.String)
  (r6v40 java.lang.String)
  (r6v44 java.lang.String)
 binds: [B:169:0x0237, B:160:0x0215, B:154:0x01fe, B:143:0x01e1, B:109:0x0161, B:94:0x0126, B:74:0x00e8, B:68:0x00d8, B:59:0x00be, B:51:0x00a3, B:48:0x0098, B:44:0x008d, B:39:0x0080, B:34:0x0072, B:30:0x0064, B:25:0x0054, B:20:0x0044, B:12:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    public static List<String> c(Context context, int i10) {
        String str;
        String strA;
        ArrayList arrayList = new ArrayList();
        switch (i10) {
            case 0:
            case 37:
                if (e(context, arrayList, "android.permission.WRITE_CALENDAR")) {
                    arrayList.add("android.permission.WRITE_CALENDAR");
                }
                str = "android.permission.READ_CALENDAR";
                if (e(context, arrayList, "android.permission.READ_CALENDAR")) {
                    arrayList.add(str);
                }
                return arrayList;
            case 1:
                str = "android.permission.CAMERA";
                if (e(context, arrayList, "android.permission.CAMERA")) {
                    arrayList.add(str);
                }
                return arrayList;
            case 2:
                if (e(context, arrayList, "android.permission.READ_CONTACTS")) {
                    arrayList.add("android.permission.READ_CONTACTS");
                }
                if (e(context, arrayList, "android.permission.WRITE_CONTACTS")) {
                    arrayList.add("android.permission.WRITE_CONTACTS");
                }
                if (e(context, arrayList, "android.permission.GET_ACCOUNTS")) {
                    strA = "android.permission.GET_ACCOUNTS";
                    arrayList.add(strA);
                }
                return arrayList;
            case 3:
            case 4:
            case 5:
                if (i10 != 4 || Build.VERSION.SDK_INT < 29) {
                    if (e(context, arrayList, "android.permission.ACCESS_COARSE_LOCATION")) {
                        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                    }
                    if (e(context, arrayList, "android.permission.ACCESS_FINE_LOCATION")) {
                        strA = "android.permission.ACCESS_FINE_LOCATION";
                        arrayList.add(strA);
                    }
                } else if (e(context, arrayList, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    strA = "android.permission.ACCESS_BACKGROUND_LOCATION";
                    arrayList.add(strA);
                }
                return arrayList;
            case 6:
            case 11:
            case 20:
                return null;
            case 7:
            case 14:
                str = "android.permission.RECORD_AUDIO";
                if (e(context, arrayList, "android.permission.RECORD_AUDIO")) {
                    arrayList.add(str);
                }
                return arrayList;
            case 8:
                if (e(context, arrayList, "android.permission.READ_PHONE_STATE")) {
                    arrayList.add("android.permission.READ_PHONE_STATE");
                }
                if (Build.VERSION.SDK_INT > 29 && e(context, arrayList, "android.permission.READ_PHONE_NUMBERS")) {
                    arrayList.add("android.permission.READ_PHONE_NUMBERS");
                }
                if (e(context, arrayList, "android.permission.CALL_PHONE")) {
                    arrayList.add("android.permission.CALL_PHONE");
                }
                if (e(context, arrayList, "android.permission.READ_CALL_LOG")) {
                    arrayList.add("android.permission.READ_CALL_LOG");
                }
                if (e(context, arrayList, "android.permission.WRITE_CALL_LOG")) {
                    arrayList.add("android.permission.WRITE_CALL_LOG");
                }
                if (e(context, arrayList, "com.android.voicemail.permission.ADD_VOICEMAIL")) {
                    arrayList.add("com.android.voicemail.permission.ADD_VOICEMAIL");
                }
                if (e(context, arrayList, "android.permission.USE_SIP")) {
                    arrayList.add("android.permission.USE_SIP");
                }
                if (e(context, arrayList, "android.permission.ANSWER_PHONE_CALLS")) {
                    strA = "android.permission.ANSWER_PHONE_CALLS";
                    arrayList.add(strA);
                }
                return arrayList;
            case 9:
                if (Build.VERSION.SDK_INT >= 33) {
                    str = "android.permission.READ_MEDIA_IMAGES";
                    if (e(context, arrayList, "android.permission.READ_MEDIA_IMAGES")) {
                        arrayList.add(str);
                    }
                }
                return arrayList;
            case 10:
            case 25:
            case 26:
            default:
                return arrayList;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                str = "android.permission.BODY_SENSORS";
                if (e(context, arrayList, "android.permission.BODY_SENSORS")) {
                    arrayList.add(str);
                }
                return arrayList;
            case 13:
                if (e(context, arrayList, "android.permission.SEND_SMS")) {
                    arrayList.add("android.permission.SEND_SMS");
                }
                if (e(context, arrayList, "android.permission.RECEIVE_SMS")) {
                    arrayList.add("android.permission.RECEIVE_SMS");
                }
                if (e(context, arrayList, "android.permission.READ_SMS")) {
                    arrayList.add("android.permission.READ_SMS");
                }
                if (e(context, arrayList, "android.permission.RECEIVE_WAP_PUSH")) {
                    arrayList.add("android.permission.RECEIVE_WAP_PUSH");
                }
                if (e(context, arrayList, "android.permission.RECEIVE_MMS")) {
                    strA = "android.permission.RECEIVE_MMS";
                    arrayList.add(strA);
                }
                return arrayList;
            case 15:
                if (e(context, arrayList, "android.permission.READ_EXTERNAL_STORAGE")) {
                    arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
                }
                int i11 = Build.VERSION.SDK_INT;
                if ((i11 < 29 || (i11 == 29 && Environment.isExternalStorageLegacy())) && e(context, arrayList, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    strA = "android.permission.WRITE_EXTERNAL_STORAGE";
                    arrayList.add(strA);
                }
                return arrayList;
            case 16:
                str = "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS";
                if (e(context, arrayList, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) {
                    arrayList.add(str);
                }
                return arrayList;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                if (Build.VERSION.SDK_INT >= 33) {
                    str = "android.permission.POST_NOTIFICATIONS";
                    if (e(context, arrayList, "android.permission.POST_NOTIFICATIONS")) {
                        arrayList.add(str);
                    }
                }
                return arrayList;
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                if (Build.VERSION.SDK_INT < 29) {
                    return null;
                }
                if (e(context, arrayList, "android.permission.ACCESS_MEDIA_LOCATION")) {
                    strA = "android.permission.ACCESS_MEDIA_LOCATION";
                    arrayList.add(strA);
                }
                return arrayList;
            case 19:
                if (Build.VERSION.SDK_INT < 29) {
                    return null;
                }
                if (e(context, arrayList, "android.permission.ACTIVITY_RECOGNITION")) {
                    strA = "android.permission.ACTIVITY_RECOGNITION";
                    arrayList.add(strA);
                }
                return arrayList;
            case 21:
                str = "android.permission.BLUETOOTH";
                if (e(context, arrayList, "android.permission.BLUETOOTH")) {
                    arrayList.add(str);
                }
                return arrayList;
            case 22:
                if (Build.VERSION.SDK_INT >= 30 && e(context, arrayList, "android.permission.MANAGE_EXTERNAL_STORAGE")) {
                    strA = "android.permission.MANAGE_EXTERNAL_STORAGE";
                    arrayList.add(strA);
                }
                return arrayList;
            case 23:
                str = "android.permission.SYSTEM_ALERT_WINDOW";
                if (e(context, arrayList, "android.permission.SYSTEM_ALERT_WINDOW")) {
                    arrayList.add(str);
                }
                return arrayList;
            case 24:
                if (e(context, arrayList, "android.permission.REQUEST_INSTALL_PACKAGES")) {
                    strA = "android.permission.REQUEST_INSTALL_PACKAGES";
                    arrayList.add(strA);
                }
                return arrayList;
            case 27:
                if (e(context, arrayList, "android.permission.ACCESS_NOTIFICATION_POLICY")) {
                    strA = "android.permission.ACCESS_NOTIFICATION_POLICY";
                    arrayList.add(strA);
                }
                return arrayList;
            case 28:
                if (Build.VERSION.SDK_INT >= 31 && (strA = a(context, "android.permission.BLUETOOTH_SCAN")) != null) {
                    arrayList.add(strA);
                }
                return arrayList;
            case 29:
                if (Build.VERSION.SDK_INT >= 31 && (strA = a(context, "android.permission.BLUETOOTH_ADVERTISE")) != null) {
                    arrayList.add(strA);
                }
                return arrayList;
            case 30:
                if (Build.VERSION.SDK_INT >= 31 && (strA = a(context, "android.permission.BLUETOOTH_CONNECT")) != null) {
                    arrayList.add(strA);
                }
                return arrayList;
            case 31:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, "android.permission.NEARBY_WIFI_DEVICES")) {
                    strA = "android.permission.NEARBY_WIFI_DEVICES";
                    arrayList.add(strA);
                }
                return arrayList;
            case 32:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, "android.permission.READ_MEDIA_VIDEO")) {
                    strA = "android.permission.READ_MEDIA_VIDEO";
                    arrayList.add(strA);
                }
                return arrayList;
            case 33:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, "android.permission.READ_MEDIA_AUDIO")) {
                    strA = "android.permission.READ_MEDIA_AUDIO";
                    arrayList.add(strA);
                }
                return arrayList;
            case 34:
                str = "android.permission.SCHEDULE_EXACT_ALARM";
                if (e(context, arrayList, "android.permission.SCHEDULE_EXACT_ALARM")) {
                    arrayList.add(str);
                }
                return arrayList;
            case 35:
                if (Build.VERSION.SDK_INT >= 33 && e(context, arrayList, "android.permission.BODY_SENSORS_BACKGROUND")) {
                    strA = "android.permission.BODY_SENSORS_BACKGROUND";
                    arrayList.add(strA);
                }
                return arrayList;
            case 36:
                if (e(context, arrayList, "android.permission.WRITE_CALENDAR")) {
                    arrayList.add("android.permission.WRITE_CALENDAR");
                }
                return arrayList;
        }
    }

    public static PackageInfo d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        int i10 = Build.VERSION.SDK_INT;
        String packageName = context.getPackageName();
        return i10 >= 33 ? packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(4096L)) : packageManager.getPackageInfo(packageName, 4096);
    }

    public static boolean e(Context context, ArrayList<String> arrayList, String str) {
        if (arrayList != null) {
            try {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(str)) {
                        return true;
                    }
                }
            } catch (Exception e10) {
                Log.d("permissions_handler", "Unable to check manifest for permission: ", e10);
            }
        }
        if (context == null) {
            Log.d("permissions_handler", "Unable to detect current Activity or App Context.");
            return false;
        }
        PackageInfo packageInfoD = d(context);
        if (packageInfoD == null) {
            Log.d("permissions_handler", "Unable to get Package info, will not be able to determine permissions to request.");
            return false;
        }
        Iterator it2 = new ArrayList(Arrays.asList(packageInfoD.requestedPermissions)).iterator();
        while (it2.hasNext()) {
            if (((String) it2.next()).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(Activity activity, String str) {
        return !e0.b.f(activity, str);
    }

    public static int g(String str) {
        str.hashCode();
        switch (str) {
            case "android.permission.READ_SMS":
            case "android.permission.RECEIVE_WAP_PUSH":
            case "android.permission.RECEIVE_MMS":
            case "android.permission.RECEIVE_SMS":
            case "android.permission.SEND_SMS":
                return 13;
            case "android.permission.READ_CALENDAR":
            case "android.permission.WRITE_CALENDAR":
                return 0;
            case "android.permission.POST_NOTIFICATIONS":
                return 17;
            case "android.permission.READ_CALL_LOG":
            case "android.permission.READ_PHONE_NUMBERS":
            case "android.permission.READ_PHONE_STATE":
            case "android.permission.CALL_PHONE":
            case "android.permission.WRITE_CALL_LOG":
            case "android.permission.USE_SIP":
            case "com.android.voicemail.permission.ADD_VOICEMAIL":
                return 8;
            case "android.permission.ACCESS_FINE_LOCATION":
            case "android.permission.ACCESS_COARSE_LOCATION":
                return 3;
            case "android.permission.MANAGE_EXTERNAL_STORAGE":
                return 22;
            case "android.permission.ACCESS_NOTIFICATION_POLICY":
                return 27;
            case "android.permission.SYSTEM_ALERT_WINDOW":
                return 23;
            case "android.permission.BODY_SENSORS":
                return 12;
            case "android.permission.NEARBY_WIFI_DEVICES":
                return 31;
            case "android.permission.BLUETOOTH_CONNECT":
                return 30;
            case "android.permission.READ_EXTERNAL_STORAGE":
            case "android.permission.WRITE_EXTERNAL_STORAGE":
                return 15;
            case "android.permission.READ_MEDIA_IMAGES":
                return 9;
            case "android.permission.WRITE_CONTACTS":
            case "android.permission.GET_ACCOUNTS":
            case "android.permission.READ_CONTACTS":
                return 2;
            case "android.permission.BODY_SENSORS_BACKGROUND":
                return 35;
            case "android.permission.CAMERA":
                return 1;
            case "android.permission.READ_MEDIA_AUDIO":
                return 33;
            case "android.permission.READ_MEDIA_VIDEO":
                return 32;
            case "android.permission.SCHEDULE_EXACT_ALARM":
                return 34;
            case "android.permission.BLUETOOTH_ADVERTISE":
                return 29;
            case "android.permission.REQUEST_INSTALL_PACKAGES":
                return 24;
            case "android.permission.ACTIVITY_RECOGNITION":
                return 19;
            case "android.permission.RECORD_AUDIO":
                return 7;
            case "android.permission.ACCESS_BACKGROUND_LOCATION":
                return 4;
            case "android.permission.BLUETOOTH_SCAN":
                return 28;
            case "android.permission.ACCESS_MEDIA_LOCATION":
                return 18;
            default:
                return 20;
        }
    }

    public static void h(Context context, String str) {
        context.getSharedPreferences(str, 0).edit().putBoolean("sp_permission_handler_permission_was_denied_before", true).apply();
    }

    public static Integer i(Integer num, Integer num2) {
        HashSet hashSet = new HashSet();
        hashSet.add(num);
        hashSet.add(num2);
        return j(hashSet);
    }

    public static Integer j(Collection<Integer> collection) {
        if (collection.contains(4)) {
            return 4;
        }
        if (collection.contains(2)) {
            return 2;
        }
        if (collection.contains(0)) {
            return 0;
        }
        return collection.contains(3) ? 3 : 1;
    }

    public static int k(Activity activity, String str, int i10) {
        if (i10 == -1) {
            return b(activity, str);
        }
        return 1;
    }

    public static boolean l(Context context, String str) {
        return context.getSharedPreferences(str, 0).getBoolean("sp_permission_handler_permission_was_denied_before", false);
    }
}
