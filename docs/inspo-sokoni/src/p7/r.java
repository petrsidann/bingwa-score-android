package p7;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class r {
    public static Status a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return new Status(17499);
        }
        String[] strArrSplit = str.split(":", 2);
        strArrSplit[0] = strArrSplit[0].trim();
        if (strArrSplit.length > 1 && (str2 = strArrSplit[1]) != null) {
            strArrSplit[1] = str2.trim();
        }
        List listAsList = Arrays.asList(strArrSplit);
        return listAsList.size() > 1 ? b((String) listAsList.get(0), (String) listAsList.get(1)) : b((String) listAsList.get(0), null);
    }

    public static Status b(String str, String str2) {
        int i10;
        str.hashCode();
        switch (str) {
            case "USER_CANCELLED":
                i10 = 18001;
                break;
            case "INVALID_RECIPIENT_EMAIL":
                i10 = 17033;
                break;
            case "WEB_CONTEXT_ALREADY_PRESENTED":
                i10 = 17057;
                break;
            case "INTERNAL_SUCCESS_SIGN_OUT":
                i10 = 17091;
                break;
            case "INVALID_IDP_RESPONSE":
            case "INVALID_LOGIN_CREDENTIALS":
            case "INVALID_PENDING_TOKEN":
                i10 = 17004;
                break;
            case "DYNAMIC_LINK_NOT_ACTIVATED":
                i10 = 17068;
                break;
            case "QUOTA_EXCEEDED":
                i10 = 17052;
                break;
            case "WEB_NETWORK_REQUEST_FAILED":
                i10 = 17061;
                break;
            case "INVALID_RECAPTCHA_VERSION":
                i10 = 17206;
                break;
            case "RECAPTCHA_NOT_ENABLED":
                i10 = 17200;
                break;
            case "EXPIRED_OOB_CODE":
                i10 = 17029;
                break;
            case "UNAUTHORIZED_DOMAIN":
                i10 = 17038;
                break;
            case "INVALID_OOB_CODE":
                i10 = 17030;
                break;
            case "MISSING_EMAIL":
                i10 = 17034;
                break;
            case "INVALID_CODE":
                i10 = 17044;
                break;
            case "INVALID_HOSTING_LINK_DOMAIN":
                i10 = 17214;
                break;
            case "TOKEN_EXPIRED":
                i10 = 17021;
                break;
            case "INVALID_TENANT_ID":
                i10 = 17079;
                break;
            case "ALTERNATE_CLIENT_IDENTIFIER_REQUIRED":
                i10 = 18002;
                break;
            case "INVALID_SESSION_INFO":
                i10 = 17046;
                break;
            case "SECOND_FACTOR_EXISTS":
                i10 = 17087;
                break;
            case "INVALID_EMAIL":
            case "INVALID_IDENTIFIER":
                i10 = 17008;
                break;
            case "ADMIN_ONLY_OPERATION":
                i10 = 17085;
                break;
            case "MISSING_OR_INVALID_NONCE":
                i10 = 17094;
                break;
            case "INVALID_CERT_HASH":
                i10 = 17064;
                break;
            case "NO_SUCH_PROVIDER":
                i10 = 17016;
                break;
            case "MFA_ENROLLMENT_NOT_FOUND":
                i10 = 17084;
                break;
            case "MISSING_PASSWORD":
                i10 = 17035;
                break;
            case "CREDENTIAL_TOO_OLD_LOGIN_AGAIN":
                i10 = 17014;
                break;
            case "TIMEOUT":
            case "<<Network Error>>":
                i10 = 17020;
                break;
            case "INVALID_REQ_TYPE":
                i10 = 17207;
                break;
            case "INVALID_RECAPTCHA_ACTION":
                i10 = 17203;
                break;
            case "OPERATION_NOT_ALLOWED":
            case "PASSWORD_LOGIN_DISABLED":
                i10 = 17006;
                break;
            case "WEB_INTERNAL_ERROR":
                i10 = 17062;
                break;
            case "SECOND_FACTOR_LIMIT_EXCEEDED":
                i10 = 17088;
                break;
            case "MISSING_MFA_ENROLLMENT_ID":
                i10 = 17082;
                break;
            case "USER_NOT_FOUND":
            case "EMAIL_NOT_FOUND":
                i10 = 17011;
                break;
            case "CAPTCHA_CHECK_FAILED":
                i10 = 17056;
                break;
            case "WEAK_PASSWORD":
                i10 = 17026;
                break;
            case "UNSUPPORTED_FIRST_FACTOR":
                i10 = 17089;
                break;
            case "INVALID_SENDER":
                i10 = 17032;
                break;
            case "MISSING_PHONE_NUMBER":
                i10 = 17041;
                break;
            case "INVALID_DYNAMIC_LINK_DOMAIN":
                i10 = 17074;
                break;
            case "MISSING_MFA_PENDING_CREDENTIAL":
                i10 = 17081;
                break;
            case "UNSUPPORTED_PASSTHROUGH_OPERATION":
                i10 = 17095;
                break;
            case "EMAIL_EXISTS":
                i10 = 17007;
                break;
            case "INVALID_ID_TOKEN":
                i10 = 17017;
                break;
            case "WEB_STORAGE_UNSUPPORTED":
                i10 = 17065;
                break;
            case "MISSING_CLIENT_TYPE":
                i10 = 17204;
                break;
            case "MISSING_RECAPTCHA_VERSION":
                i10 = 17205;
                break;
            case "UNVERIFIED_EMAIL":
                i10 = 17086;
                break;
            case "REJECTED_CREDENTIAL":
                i10 = 17075;
                break;
            case "INVALID_MFA_PENDING_CREDENTIAL":
                i10 = 17083;
                break;
            case "INVALID_VERIFICATION_PROOF":
                i10 = 17049;
                break;
            case "INVALID_PROVIDER_ID":
                i10 = 17071;
                break;
            case "CREDENTIAL_MISMATCH":
                i10 = 17002;
                break;
            case "WEB_CONTEXT_CANCELED":
                i10 = 17058;
                break;
            case "REQUIRES_SECOND_FACTOR_AUTH":
                i10 = 17078;
                break;
            case "MISSING_CLIENT_IDENTIFIER":
                i10 = 17093;
                break;
            case "INVALID_MESSAGE_PAYLOAD":
                i10 = 17031;
                break;
            case "RESET_PASSWORD_EXCEED_LIMIT":
            case "TOO_MANY_ATTEMPTS_TRY_LATER":
                i10 = 17010;
                break;
            case "INVALID_CUSTOM_TOKEN":
                i10 = 17000;
                break;
            case "INVALID_PASSWORD":
                i10 = 17009;
                break;
            case "INVALID_RECAPTCHA_TOKEN":
                i10 = 17202;
                break;
            case "SESSION_EXPIRED":
                i10 = 17051;
                break;
            case "MISSING_CODE":
                i10 = 17043;
                break;
            case "FEDERATED_USER_ID_ALREADY_LINKED":
                i10 = 17025;
                break;
            case "MISSING_RECAPTCHA_TOKEN":
                i10 = 17201;
                break;
            case "USER_DISABLED":
                i10 = 17005;
                break;
            case "INVALID_PHONE_NUMBER":
                i10 = 17042;
                break;
            case "INVALID_APP_CREDENTIAL":
                i10 = 17028;
                break;
            case "MISSING_CONTINUE_URI":
                i10 = 17040;
                break;
            case "MISSING_SESSION_INFO":
                i10 = 17045;
                break;
            case "EMAIL_CHANGE_NEEDS_VERIFICATION":
                i10 = 17090;
                break;
            case "UNSUPPORTED_TENANT_OPERATION":
                i10 = 17073;
                break;
            default:
                i10 = 17499;
                break;
        }
        if (i10 != 17499) {
            return new Status(i10, str2);
        }
        if (str2 == null) {
            return new Status(i10, str);
        }
        return new Status(i10, str + ":" + str2);
    }
}
