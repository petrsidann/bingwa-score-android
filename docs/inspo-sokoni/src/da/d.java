package da;

import d9.a0;
import d9.d0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import lc.h;

/* JADX INFO: loaded from: classes.dex */
public enum d {
    GET_INBOX("getAllInboxSms"),
    GET_SENT("getAllSentSms"),
    GET_DRAFT("getAllDraftSms"),
    GET_CONVERSATIONS("getAllConversations"),
    SEND_SMS("sendSms"),
    SEND_MULTIPART_SMS("sendMultipartSms"),
    SEND_SMS_INTENT("sendSmsIntent"),
    START_BACKGROUND_SERVICE("startBackgroundService"),
    DISABLE_BACKGROUND_SERVICE("disableBackgroundService"),
    BACKGROUND_SERVICE_INITIALIZED("backgroundServiceInitialized"),
    IS_SMS_CAPABLE("isSmsCapable"),
    GET_CELLULAR_DATA_STATE("getCellularDataState"),
    GET_CALL_STATE("getCallState"),
    GET_DATA_ACTIVITY("getDataActivity"),
    GET_NETWORK_OPERATOR("getNetworkOperator"),
    GET_NETWORK_OPERATOR_NAME("getNetworkOperatorName"),
    GET_DATA_NETWORK_TYPE("getDataNetworkType"),
    GET_PHONE_TYPE("getPhoneType"),
    GET_SIM_OPERATOR("getSimOperator"),
    GET_SIM_OPERATOR_NAME("getSimOperatorName"),
    GET_SIM_STATE("getSimState"),
    GET_SERVICE_STATE("getServiceState"),
    GET_SIGNAL_STRENGTH("getSignalStrength"),
    IS_NETWORK_ROAMING("isNetworkRoaming"),
    REQUEST_SMS_PERMISSIONS("requestSmsPermissions"),
    REQUEST_PHONE_PERMISSIONS("requestPhonePermissions"),
    REQUEST_PHONE_AND_SMS_PERMISSIONS("requestPhoneAndSmsPermissions"),
    OPEN_DIALER("openDialer"),
    DIAL_PHONE_NUMBER("dialPhoneNumber"),
    NO_SUCH_METHOD("noSuchMethod");

    public static final /* synthetic */ rc.a M = rc.b.a(d());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6677b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6697a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final d a(String method) {
            k.e(method, "method");
            for (d dVar : d.values()) {
                if (k.a(dVar.f6697a, method)) {
                    return dVar;
                }
            }
            return d.NO_SUCH_METHOD;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6698a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.GET_INBOX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.GET_SENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.GET_DRAFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.GET_CONVERSATIONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.SEND_SMS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[d.SEND_MULTIPART_SMS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[d.SEND_SMS_INTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[d.NO_SUCH_METHOD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[d.START_BACKGROUND_SERVICE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[d.DISABLE_BACKGROUND_SERVICE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[d.BACKGROUND_SERVICE_INITIALIZED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[d.IS_SMS_CAPABLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[d.GET_CELLULAR_DATA_STATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[d.GET_CALL_STATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[d.GET_DATA_ACTIVITY.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[d.GET_NETWORK_OPERATOR.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[d.GET_NETWORK_OPERATOR_NAME.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[d.GET_DATA_NETWORK_TYPE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[d.GET_PHONE_TYPE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[d.GET_SIM_OPERATOR.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[d.GET_SIM_OPERATOR_NAME.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[d.GET_SIM_STATE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[d.GET_SERVICE_STATE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[d.GET_SIGNAL_STRENGTH.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[d.IS_NETWORK_ROAMING.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[d.REQUEST_SMS_PERMISSIONS.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[d.REQUEST_PHONE_PERMISSIONS.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[d.REQUEST_PHONE_AND_SMS_PERMISSIONS.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[d.OPEN_DIALER.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[d.DIAL_PHONE_NUMBER.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            f6698a = iArr;
        }
    }

    d(String str) {
        this.f6697a = str;
    }

    public final da.a i() {
        switch (b.f6698a[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return da.a.GET_SMS;
            case 5:
            case 6:
            case 7:
            case 8:
                return da.a.SEND_SMS;
            case 9:
            case 10:
            case 11:
                return da.a.BACKGROUND;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 13:
            case 14:
            case 15:
            case 16:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                return da.a.GET;
            case 26:
            case 27:
            case 28:
                return da.a.PERMISSION;
            case 29:
            case 30:
                return da.a.CALL;
            default:
                throw new h();
        }
    }
}
