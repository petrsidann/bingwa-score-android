package s2;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import e0.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class p implements fb.l, fb.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f15428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f15429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<Integer, Integer> f15431e;

    @FunctionalInterface
    public interface a {
        void a(int i10);
    }

    @FunctionalInterface
    public interface b {
        void a(Map<Integer, Integer> map);
    }

    @FunctionalInterface
    public interface c {
        void a(boolean z10);
    }

    public p(Context context) {
        this.f15427a = context;
    }

    public final int a() {
        List<String> listC = r.c(this.f15427a, 21);
        if (!(listC == null || listC.isEmpty())) {
            return 1;
        }
        Log.d("permissions_handler", "Bluetooth permission missing in manifest");
        return 0;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT < 33) {
            return o0.e(this.f15427a).a() ? 1 : 0;
        }
        if (this.f15427a.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
            return 1;
        }
        return r.b(this.f15429c, "android.permission.POST_NOTIFICATIONS");
    }

    public void c(int i10, a aVar) {
        aVar.a(d(i10));
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00c1  */
    /* JADX WARN: Multi-variable type inference failed */
    public final int d(int i10) {
        int iValueOf;
        int iIsExternalStorageManager;
        if (i10 == 17) {
            return b();
        }
        if (i10 == 21) {
            return a();
        }
        if ((i10 == 30 || i10 == 28 || i10 == 29) && Build.VERSION.SDK_INT < 31) {
            return a();
        }
        if ((i10 == 37 || i10 == 0) && !e()) {
            return 0;
        }
        List<String> listC = r.c(this.f15427a, i10);
        if (listC == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i10);
            return 1;
        }
        if (listC.size() == 0) {
            Log.d("permissions_handler", "No permissions found in manifest for: " + listC + i10);
            return (i10 != 22 || Build.VERSION.SDK_INT >= 30) ? 0 : 2;
        }
        if (this.f15427a.getApplicationInfo().targetSdkVersion >= 23) {
            HashSet hashSet = new HashSet();
            for (String str : listC) {
                if (i10 == 16) {
                    String packageName = this.f15427a.getPackageName();
                    PowerManager powerManager = (PowerManager) this.f15427a.getSystemService("power");
                    if (powerManager == null || !powerManager.isIgnoringBatteryOptimizations(packageName)) {
                        iValueOf = 0;
                    } else {
                        iValueOf = 1;
                    }
                    hashSet.add(iValueOf);
                } else {
                    if (i10 == 22) {
                        if (Build.VERSION.SDK_INT < 30) {
                            hashSet.add(2);
                        }
                        iIsExternalStorageManager = Environment.isExternalStorageManager();
                    } else if (i10 == 23) {
                        iIsExternalStorageManager = Settings.canDrawOverlays(this.f15427a);
                    } else if (i10 == 24) {
                        iIsExternalStorageManager = this.f15427a.getPackageManager().canRequestPackageInstalls();
                    } else if (i10 == 27) {
                        iIsExternalStorageManager = ((NotificationManager) this.f15427a.getSystemService("notification")).isNotificationPolicyAccessGranted();
                    } else if (i10 == 34) {
                        if (Build.VERSION.SDK_INT >= 31) {
                            iIsExternalStorageManager = ((AlarmManager) this.f15427a.getSystemService("alarm")).canScheduleExactAlarms();
                        } else {
                            iValueOf = 1;
                        }
                        hashSet.add(iValueOf);
                    } else if (f0.a.checkSelfPermission(this.f15427a, str) != 0) {
                        iIsExternalStorageManager = r.b(this.f15429c, str);
                    }
                    iValueOf = Integer.valueOf(iIsExternalStorageManager);
                    hashSet.add(iValueOf);
                }
            }
            if (!hashSet.isEmpty()) {
                return r.j(hashSet).intValue();
            }
        }
        return 1;
    }

    public final boolean e() {
        List<String> listC = r.c(this.f15427a, 37);
        boolean z10 = listC != null && listC.contains("android.permission.WRITE_CALENDAR");
        boolean z11 = listC != null && listC.contains("android.permission.READ_CALENDAR");
        if (z10 && z11) {
            return true;
        }
        if (!z10) {
            Log.d("permissions_handler", "android.permission.WRITE_CALENDAR missing in manifest");
        }
        if (!z11) {
            Log.d("permissions_handler", "android.permission.READ_CALENDAR missing in manifest");
        }
        return false;
    }

    public final void f(String str, int i10) {
        if (this.f15429c == null) {
            return;
        }
        Intent intent = new Intent(str);
        if (!str.equals("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS")) {
            intent.setData(Uri.parse("package:" + this.f15429c.getPackageName()));
        }
        this.f15429c.startActivityForResult(intent, i10);
        this.f15430d++;
    }

    public void g(List<Integer> list, b bVar, s2.b bVar2) {
        int iValueOf;
        Map<Integer, Integer> map;
        String str;
        int i10;
        int size;
        String str2;
        if (this.f15430d > 0) {
            str2 = "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).";
        } else {
            if (this.f15429c != null) {
                this.f15428b = bVar;
                this.f15431e = new HashMap();
                this.f15430d = 0;
                ArrayList arrayList = new ArrayList();
                for (Integer num : list) {
                    int i11 = 1;
                    if (d(num.intValue()) != 1) {
                        List<String> listC = r.c(this.f15429c, num.intValue());
                        i11 = 2;
                        if (listC != null && !listC.isEmpty()) {
                            int i12 = Build.VERSION.SDK_INT;
                            if (num.intValue() == 16) {
                                str = "android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS";
                                i10 = 209;
                            } else if (i12 >= 30 && num.intValue() == 22) {
                                str = "android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION";
                                i10 = 210;
                            } else if (num.intValue() == 23) {
                                str = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
                                i10 = 211;
                            } else if (num.intValue() == 24) {
                                str = "android.settings.MANAGE_UNKNOWN_APP_SOURCES";
                                i10 = 212;
                            } else if (num.intValue() == 27) {
                                str = "android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS";
                                i10 = 213;
                            } else if (i12 < 31 || num.intValue() != 34) {
                                if (num.intValue() != 37 && num.intValue() != 0) {
                                    arrayList.addAll(listC);
                                    size = this.f15430d + listC.size();
                                } else if (e()) {
                                    arrayList.add("android.permission.WRITE_CALENDAR");
                                    arrayList.add("android.permission.READ_CALENDAR");
                                    size = this.f15430d + 2;
                                } else {
                                    map = this.f15431e;
                                    iValueOf = 0;
                                    map.put(num, iValueOf);
                                }
                                this.f15430d = size;
                            } else {
                                str = "android.settings.REQUEST_SCHEDULE_EXACT_ALARM";
                                i10 = 214;
                            }
                            f(str, i10);
                        } else if (!this.f15431e.containsKey(num)) {
                            num.intValue();
                            this.f15431e.put(num, 0);
                            if (num.intValue() != 22 || Build.VERSION.SDK_INT >= 30) {
                                map = this.f15431e;
                                iValueOf = 0;
                            } else {
                                map = this.f15431e;
                                iValueOf = Integer.valueOf(i11);
                            }
                            map.put(num, iValueOf);
                        }
                    } else if (!this.f15431e.containsKey(num)) {
                        map = this.f15431e;
                        iValueOf = Integer.valueOf(i11);
                        map.put(num, iValueOf);
                    }
                }
                if (arrayList.size() > 0) {
                    e0.b.e(this.f15429c, (String[]) arrayList.toArray(new String[0]), 24);
                }
                b bVar3 = this.f15428b;
                if (bVar3 == null || this.f15430d != 0) {
                    return;
                }
                bVar3.a(this.f15431e);
                return;
            }
            Log.d("permissions_handler", "Unable to detect current Activity.");
            str2 = "Unable to detect current Android Activity.";
        }
        bVar2.a("PermissionHandler.PermissionManager", str2);
    }

    public void h(Activity activity) {
        this.f15429c = activity;
    }

    public void i(int i10, c cVar, s2.b bVar) {
        Activity activity = this.f15429c;
        if (activity == null) {
            Log.d("permissions_handler", "Unable to detect current Activity.");
            bVar.a("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.");
            return;
        }
        List<String> listC = r.c(activity, i10);
        if (listC == null) {
            Log.d("permissions_handler", "No android specific permissions needed for: " + i10);
            cVar.a(false);
            return;
        }
        if (!listC.isEmpty()) {
            cVar.a(e0.b.f(this.f15429c, listC.get(0)));
            return;
        }
        Log.d("permissions_handler", "No permissions found in manifest for: " + i10 + " no need to show request rationale");
        cVar.a(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // fb.l
    public boolean onActivityResult(int i10, int i11, Intent intent) {
        int i12;
        int iCanScheduleExactAlarms;
        Activity activity = this.f15429c;
        boolean z10 = false;
        z10 = false;
        if (activity == null) {
            return false;
        }
        if (i10 == 209) {
            String packageName = this.f15427a.getPackageName();
            PowerManager powerManager = (PowerManager) this.f15427a.getSystemService("power");
            if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(packageName)) {
                z10 = true;
            }
            i12 = 16;
            iCanScheduleExactAlarms = z10;
        } else if (i10 == 210) {
            if (Build.VERSION.SDK_INT < 30) {
                return false;
            }
            i12 = 22;
            iCanScheduleExactAlarms = Environment.isExternalStorageManager();
        } else if (i10 == 211) {
            i12 = 23;
            iCanScheduleExactAlarms = Settings.canDrawOverlays(activity);
        } else if (i10 == 212) {
            i12 = 24;
            iCanScheduleExactAlarms = activity.getPackageManager().canRequestPackageInstalls();
        } else if (i10 == 213) {
            i12 = 27;
            iCanScheduleExactAlarms = ((NotificationManager) activity.getSystemService("notification")).isNotificationPolicyAccessGranted();
        } else {
            if (i10 != 214) {
                return false;
            }
            i12 = 34;
            iCanScheduleExactAlarms = Build.VERSION.SDK_INT >= 31 ? ((AlarmManager) activity.getSystemService("alarm")).canScheduleExactAlarms() : true;
        }
        this.f15431e.put(Integer.valueOf(i12), Integer.valueOf(iCanScheduleExactAlarms));
        int i13 = this.f15430d - 1;
        this.f15430d = i13;
        b bVar = this.f15428b;
        if (bVar != null && i13 == 0) {
            bVar.a(this.f15431e);
        }
        return true;
    }

    @Override // fb.n
    public boolean onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        int iG;
        Map<Integer, Integer> map;
        int i11;
        Integer numValueOf;
        if (i10 != 24) {
            this.f15430d = 0;
            return false;
        }
        if (this.f15431e == null) {
            return false;
        }
        if (strArr.length == 0 && iArr.length == 0) {
            Log.w("permissions_handler", "onRequestPermissionsResult is called without results. This is probably caused by interfering request codes. If you see this error, please file an issue in flutter-permission-handler, including a list of plugins used by this application: https://github.com/Baseflow/flutter-permission-handler/issues");
            return false;
        }
        List listAsList = Arrays.asList(strArr);
        int iIndexOf = listAsList.indexOf("android.permission.WRITE_CALENDAR");
        if (iIndexOf >= 0) {
            int iK = r.k(this.f15429c, "android.permission.WRITE_CALENDAR", iArr[iIndexOf]);
            this.f15431e.put(36, Integer.valueOf(iK));
            int iIndexOf2 = listAsList.indexOf("android.permission.READ_CALENDAR");
            if (iIndexOf2 >= 0) {
                int iIntValue = r.i(Integer.valueOf(iK), Integer.valueOf(r.k(this.f15429c, "android.permission.READ_CALENDAR", iArr[iIndexOf2]))).intValue();
                this.f15431e.put(37, Integer.valueOf(iIntValue));
                this.f15431e.put(0, Integer.valueOf(iIntValue));
            }
        }
        for (int i12 = 0; i12 < strArr.length; i12++) {
            String str = strArr[i12];
            if (!str.equals("android.permission.WRITE_CALENDAR") && !str.equals("android.permission.READ_CALENDAR") && (iG = r.g(str)) != 20) {
                int i13 = iArr[i12];
                if (iG == 8) {
                    numValueOf = r.i(this.f15431e.get(8), Integer.valueOf(r.k(this.f15429c, str, i13)));
                    map = this.f15431e;
                    i11 = 8;
                } else if (iG == 7) {
                    if (!this.f15431e.containsKey(7)) {
                        this.f15431e.put(7, Integer.valueOf(r.k(this.f15429c, str, i13)));
                    }
                    if (!this.f15431e.containsKey(14)) {
                        this.f15431e.put(14, Integer.valueOf(r.k(this.f15429c, str, i13)));
                    }
                } else if (iG == 4) {
                    int iK2 = r.k(this.f15429c, str, i13);
                    if (!this.f15431e.containsKey(4)) {
                        map = this.f15431e;
                        i11 = 4;
                        numValueOf = Integer.valueOf(iK2);
                    }
                } else if (iG == 3) {
                    int iK3 = r.k(this.f15429c, str, i13);
                    if (Build.VERSION.SDK_INT < 29 && !this.f15431e.containsKey(4)) {
                        this.f15431e.put(4, Integer.valueOf(iK3));
                    }
                    if (!this.f15431e.containsKey(5)) {
                        this.f15431e.put(5, Integer.valueOf(iK3));
                    }
                    this.f15431e.put(Integer.valueOf(iG), Integer.valueOf(iK3));
                } else if (!this.f15431e.containsKey(Integer.valueOf(iG))) {
                    this.f15431e.put(Integer.valueOf(iG), Integer.valueOf(r.k(this.f15429c, str, i13)));
                }
                map.put(i11, numValueOf);
            }
        }
        int length = this.f15430d - iArr.length;
        this.f15430d = length;
        b bVar = this.f15428b;
        if (bVar == null || length != 0) {
            return true;
        }
        bVar.a(this.f15431e);
        return true;
    }
}
