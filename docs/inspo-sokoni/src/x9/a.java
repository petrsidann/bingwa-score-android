package x9;

import lc.h;
import rc.b;

/* JADX INFO: loaded from: classes.dex */
public enum a {
    ACTIVITY_NOT_ATTACHED,
    NOTIFICATION_PERMISSION_REQUEST_CANCELLED;


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ rc.a f18068d = b.a(d());

    /* JADX INFO: renamed from: x9.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0322a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18069a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.ACTIVITY_NOT_ATTACHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.NOTIFICATION_PERMISSION_REQUEST_CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f18069a = iArr;
        }
    }

    public final String h() {
        int i10 = C0322a.f18069a[ordinal()];
        if (i10 == 1) {
            return "Cannot call method using Activity because Activity is not attached to FlutterEngine.";
        }
        if (i10 == 2) {
            return "The dialog was closed or the request was canceled during a runtime notification permission request.";
        }
        throw new h();
    }
}
