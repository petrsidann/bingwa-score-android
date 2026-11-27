package mb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13029b;

    /* JADX INFO: renamed from: mb.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0220a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13030a;

        static {
            int[] iArr = new int[com.google.firebase.firestore.f.a.values().length];
            f13030a = iArr;
            try {
                iArr[com.google.firebase.firestore.f.a.ABORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.ALREADY_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.DATA_LOSS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.DEADLINE_EXCEEDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.FAILED_PRECONDITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.INTERNAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.INVALID_ARGUMENT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.NOT_FOUND.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.OUT_OF_RANGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.PERMISSION_DENIED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.RESOURCE_EXHAUSTED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.UNAUTHENTICATED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.UNAVAILABLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.UNIMPLEMENTED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f13030a[com.google.firebase.firestore.f.a.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0232  */
    public a(com.google.firebase.firestore.f fVar, Throwable th) {
        String str;
        String str2;
        String str3;
        String message;
        String str4;
        super(fVar != null ? fVar.getMessage() : "", th);
        if (th != null && th.getMessage() != null) {
            str = "Operation was attempted past the valid range.";
            if (th.getMessage().contains(":")) {
                Matcher matcher = Pattern.compile("([A-Z_]{3,25}):\\s(.*)").matcher(th.getMessage());
                if (matcher.find()) {
                    String strTrim = matcher.group(1).trim();
                    str2 = "out-of-range";
                    String strTrim2 = matcher.group(2).trim();
                    strTrim.hashCode();
                    switch (strTrim) {
                        case "DATA_LOSS":
                            message = "Unrecoverable data loss or corruption.";
                            str3 = "data-loss";
                            break;
                        case "INVALID_ARGUMENT":
                            message = "Client specified an invalid argument. Note that this differs from failed-precondition. invalid-argument indicates arguments that are problematic regardless of the state of the system (e.g., an invalid field name).";
                            str3 = "invalid-argument";
                            break;
                        case "PERMISSION_DENIED":
                            str3 = "permission-denied";
                            message = "The caller does not have permission to execute the specified operation.";
                            break;
                        case "CANCELLED":
                            message = "The operation was cancelled (typically by the caller).";
                            str3 = "cancelled";
                            break;
                        case "RESOURCE_EXHAUSTED":
                            str3 = "resource-exhausted";
                            message = "Some resource has been exhausted, perhaps a per-user quota, or perhaps the entire file system is out of space.";
                            break;
                        case "UNAUTHENTICATED":
                            str3 = "unauthenticated";
                            message = "The request does not have valid authentication credentials for the operation.";
                            break;
                        case "ABORTED":
                            message = "The operation was aborted, typically due to a concurrency issue like transaction aborts, etc.";
                            str3 = "aborted";
                            break;
                        case "DEADLINE_EXCEEDED":
                            message = "Deadline expired before operation could complete. For operations that change the state of the system, this error may be returned even if the operation has completed successfully. For example, a successful response from a server could have been delayed long enough for the deadline to expire.";
                            str3 = "deadline-exceeded";
                            break;
                        case "UNKNOWN":
                            str3 = "unknown";
                            message = "Operation is not implemented or not supported/enabled.";
                            break;
                        case "OUT_OF_RANGE":
                            message = str;
                            str3 = str2;
                            break;
                        case "FAILED_PRECONDITION":
                            message = strTrim2.contains("index") ? strTrim2 : "Operation was rejected because the system is not in a state required for the operation's execution. If performing a query, ensure it has been indexed via the Firebase console.";
                            str3 = "failed-precondition";
                            break;
                        case "NOT_FOUND":
                            message = "Some requested document was not found.";
                            str3 = "not-found";
                            break;
                        case "INTERNAL":
                            message = "Internal errors. Means some invariants expected by underlying system has been broken. If you see one of these errors, something is very broken.";
                            str3 = "internal";
                            break;
                        case "UNAVAILABLE":
                            str3 = "unavailable";
                            message = "The service is currently unavailable. This is a most likely a transient condition and may be corrected by retrying with a backoff.";
                            break;
                        case "ALREADY_EXISTS":
                            message = "Some document that we attempted to create already exists.";
                            str3 = "already-exists";
                            break;
                        case "UNIMPLEMENTED":
                            str3 = "unimplemented";
                            message = "Operation is not implemented or not supported/enabled.";
                            break;
                    }
                }
                str3 = null;
                message = null;
            }
            if (str3 != null && fVar != null) {
                switch (C0220a.f13030a[fVar.a().ordinal()]) {
                    case 1:
                        message = "The operation was aborted, typically due to a concurrency issue like transaction aborts, etc.";
                        str4 = "aborted";
                        break;
                    case 2:
                        message = "Some document that we attempted to create already exists.";
                        str4 = "already-exists";
                        break;
                    case 3:
                        message = "The operation was cancelled (typically by the caller).";
                        str4 = "cancelled";
                        break;
                    case 4:
                        message = "Unrecoverable data loss or corruption.";
                        str4 = "data-loss";
                        break;
                    case 5:
                        message = "Deadline expired before operation could complete. For operations that change the state of the system, this error may be returned even if the operation has completed successfully. For example, a successful response from a server could have been delayed long enough for the deadline to expire.";
                        str4 = "deadline-exceeded";
                        break;
                    case 6:
                        message = ((fVar.getMessage() == null || !fVar.getMessage().contains("query requires an index")) && !fVar.getMessage().contains("ensure it has been indexed")) ? "Operation was rejected because the system is not in a state required for the operation's execution. If performing a query, ensure it has been indexed via the Firebase console." : fVar.getMessage();
                        str4 = "failed-precondition";
                        break;
                    case 7:
                        message = "Internal errors. Means some invariants expected by underlying system has been broken. If you see one of these errors, something is very broken.";
                        str4 = "internal";
                        break;
                    case 8:
                        message = "Client specified an invalid argument. Note that this differs from failed-precondition. invalid-argument indicates arguments that are problematic regardless of the state of the system (e.g., an invalid field name).";
                        str4 = "invalid-argument";
                        break;
                    case 9:
                        message = "Some requested document was not found.";
                        str4 = "not-found";
                        break;
                    case 10:
                        message = str;
                        str4 = str2;
                        break;
                    case 11:
                        str4 = "permission-denied";
                        message = "The caller does not have permission to execute the specified operation.";
                        break;
                    case d9.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                        str4 = "resource-exhausted";
                        message = "Some resource has been exhausted, perhaps a per-user quota, or perhaps the entire file system is out of space.";
                        break;
                    case 13:
                        str4 = "unauthenticated";
                        message = "The request does not have valid authentication credentials for the operation.";
                        break;
                    case 14:
                        str4 = "unavailable";
                        message = "The service is currently unavailable. This is a most likely a transient condition and may be corrected by retrying with a backoff.";
                        break;
                    case 15:
                        str4 = "unimplemented";
                        message = "Operation is not implemented or not supported/enabled.";
                        break;
                    case 16:
                        message = "Unknown error or an error from a different error domain.";
                        str4 = "unknown";
                        break;
                    default:
                        message = "An unknown error occurred";
                        str4 = "unknown";
                        break;
                }
            } else {
                str4 = str3;
            }
            this.f13028a = str4;
            this.f13029b = message;
        }
        str = "Operation was attempted past the valid range.";
        str2 = "out-of-range";
        str3 = null;
        message = null;
        if (str3 != null) {
            str4 = str3;
        } else {
            str4 = str3;
        }
        this.f13028a = str4;
        this.f13029b = message;
    }

    public String a() {
        return this.f13028a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f13029b;
    }
}
