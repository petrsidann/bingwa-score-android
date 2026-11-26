package com.example.bingwahybrid.presentation.navigation;

import androidx.core.app.NotificationCompat;
import androidx.room.FtsOptions;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.sms.model.SmsSender;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.LinkHeader;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Route.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:)\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./012B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0082\u0001)3456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[¨\u0006\\"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route;", "", "name", "", LinkHeader.Parameters.Title, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getTitle", "SplashScreen", "OnboardingScreen1", "OnboardingScreen2", "Register", "OtpVerification", "PinSetup", "PinLogin", "SimSetup", "Home", "Offers", "AddSiteLinkOffer", "EditOffer", "Settings", "AutoSaveContactsSettings", "TransactionDetails", "MySubscription", "EditProfile", "Customers", "QuickDial", "AutoRenew", "AddAutoRenew", SmsSender.SITELINK, "Login", "PayWithAirtime", "Transactions", "AutoReply", "RescheduleTransaction", "EditCustomer", "EditAutoReplyMessage", "ResetPassword", "CreateSiteLink", "EditSiteLink", SmsSender.HYBRID_CONNECT, "Community", "CommunityOffers", "QrScanner", "CheckForUpdates", "AccessibilityInfo", "BlackList", "AuthorizedSenders", "RedeemCoupon", "Lcom/example/bingwahybrid/presentation/navigation/Route$AccessibilityInfo;", "Lcom/example/bingwahybrid/presentation/navigation/Route$AddAutoRenew;", "Lcom/example/bingwahybrid/presentation/navigation/Route$AddSiteLinkOffer;", "Lcom/example/bingwahybrid/presentation/navigation/Route$AuthorizedSenders;", "Lcom/example/bingwahybrid/presentation/navigation/Route$AutoRenew;", "Lcom/example/bingwahybrid/presentation/navigation/Route$AutoReply;", "Lcom/example/bingwahybrid/presentation/navigation/Route$AutoSaveContactsSettings;", "Lcom/example/bingwahybrid/presentation/navigation/Route$BlackList;", "Lcom/example/bingwahybrid/presentation/navigation/Route$CheckForUpdates;", "Lcom/example/bingwahybrid/presentation/navigation/Route$Community;", "Lcom/example/bingwahybrid/presentation/navigation/Route$CommunityOffers;", "Lcom/example/bingwahybrid/presentation/navigation/Route$CreateSiteLink;", "Lcom/example/bingwahybrid/presentation/navigation/Route$Customers;", "Lcom/example/bingwahybrid/presentation/navigation/Route$EditAutoReplyMessage;", "Lcom/example/bingwahybrid/presentation/navigation/Route$EditCustomer;", "Lcom/example/bingwahybrid/presentation/navigation/Route$EditOffer;", "Lcom/example/bingwahybrid/presentation/navigation/Route$EditProfile;", "Lcom/example/bingwahybrid/presentation/navigation/Route$EditSiteLink;", "Lcom/example/bingwahybrid/presentation/navigation/Route$Home;", "Lcom/example/bingwahybrid/presentation/navigation/Route$HybridConnect;", "Lcom/example/bingwahybrid/presentation/navigation/Route$Login;", "Lcom/example/bingwahybrid/presentation/navigation/Route$MySubscription;", "Lcom/example/bingwahybrid/presentation/navigation/Route$Offers;", "Lcom/example/bingwahybrid/presentation/navigation/Route$OnboardingScreen1;", "Lcom/example/bingwahybrid/presentation/navigation/Route$OnboardingScreen2;", "Lcom/example/bingwahybrid/presentation/navigation/Route$OtpVerification;", "Lcom/example/bingwahybrid/presentation/navigation/Route$PayWithAirtime;", "Lcom/example/bingwahybrid/presentation/navigation/Route$PinLogin;", "Lcom/example/bingwahybrid/presentation/navigation/Route$PinSetup;", "Lcom/example/bingwahybrid/presentation/navigation/Route$QrScanner;", "Lcom/example/bingwahybrid/presentation/navigation/Route$QuickDial;", "Lcom/example/bingwahybrid/presentation/navigation/Route$RedeemCoupon;", "Lcom/example/bingwahybrid/presentation/navigation/Route$Register;", "Lcom/example/bingwahybrid/presentation/navigation/Route$RescheduleTransaction;", "Lcom/example/bingwahybrid/presentation/navigation/Route$ResetPassword;", "Lcom/example/bingwahybrid/presentation/navigation/Route$Settings;", "Lcom/example/bingwahybrid/presentation/navigation/Route$SimSetup;", "Lcom/example/bingwahybrid/presentation/navigation/Route$SiteLink;", "Lcom/example/bingwahybrid/presentation/navigation/Route$SplashScreen;", "Lcom/example/bingwahybrid/presentation/navigation/Route$TransactionDetails;", "Lcom/example/bingwahybrid/presentation/navigation/Route$Transactions;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class Route {
    public static final int $stable = 0;
    private final String name;
    private final String title;

    public /* synthetic */ Route(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$SplashScreen;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SplashScreen extends Route {
        public static final int $stable = 0;
        public static final SplashScreen INSTANCE = new SplashScreen();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SplashScreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -438232011;
        }

        public String toString() {
            return "SplashScreen";
        }

        private SplashScreen() {
            super("splash-screen", "Splash Screen", null);
        }
    }

    private Route(String str, String str2) {
        this.name = str;
        this.title = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$OnboardingScreen1;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnboardingScreen1 extends Route {
        public static final int $stable = 0;
        public static final OnboardingScreen1 INSTANCE = new OnboardingScreen1();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnboardingScreen1)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1903721832;
        }

        public String toString() {
            return "OnboardingScreen1";
        }

        private OnboardingScreen1() {
            super("onboarding-screen-1", "Onboarding Screen", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$OnboardingScreen2;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnboardingScreen2 extends Route {
        public static final int $stable = 0;
        public static final OnboardingScreen2 INSTANCE = new OnboardingScreen2();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnboardingScreen2)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1903721833;
        }

        public String toString() {
            return "OnboardingScreen2";
        }

        private OnboardingScreen2() {
            super("onboarding-screen-2", "Onboarding Screen 2", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$Register;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Register extends Route {
        public static final int $stable = 0;
        public static final Register INSTANCE = new Register();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Register)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -139612635;
        }

        public String toString() {
            return "Register";
        }

        private Register() {
            super("register", "Create Account", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$OtpVerification;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OtpVerification extends Route {
        public static final int $stable = 0;
        public static final OtpVerification INSTANCE = new OtpVerification();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OtpVerification)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1357962020;
        }

        public String toString() {
            return "OtpVerification";
        }

        private OtpVerification() {
            super("verify-otp/{email}", "Otp Verification", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$PinSetup;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PinSetup extends Route {
        public static final int $stable = 0;
        public static final PinSetup INSTANCE = new PinSetup();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PinSetup)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 104451434;
        }

        public String toString() {
            return "PinSetup";
        }

        private PinSetup() {
            super("setup-pin", "Setup Pin", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$PinLogin;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PinLogin extends Route {
        public static final int $stable = 0;
        public static final PinLogin INSTANCE = new PinLogin();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PinLogin)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 98271830;
        }

        public String toString() {
            return "PinLogin";
        }

        private PinLogin() {
            super("pin-login/{email}", "Pin Login", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$SimSetup;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SimSetup extends Route {
        public static final int $stable = 0;
        public static final SimSetup INSTANCE = new SimSetup();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SimSetup)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1009285992;
        }

        public String toString() {
            return "SimSetup";
        }

        private SimSetup() {
            super("sim-setup", "Sim Setup", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$Home;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Home extends Route {
        public static final int $stable = 0;
        public static final Home INSTANCE = new Home();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Home)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 220366177;
        }

        public String toString() {
            return "Home";
        }

        private Home() {
            super("home", "Home", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bJ\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001¨\u0006\u0010"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$Offers;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "settings", "", "offerId", "details", "Ljava/util/UUID;", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Offers extends Route {
        public static final int $stable = 0;
        public static final Offers INSTANCE = new Offers();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Offers)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1510386073;
        }

        public String toString() {
            return "Offers";
        }

        private Offers() {
            super("offers", "Offers", null);
        }

        public final String settings(String offerId) {
            Intrinsics.checkNotNullParameter(offerId, "offerId");
            return "offers/settings/" + offerId;
        }

        public final String details(UUID offerId) {
            Intrinsics.checkNotNullParameter(offerId, "offerId");
            return "offers/edit/" + offerId;
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$AddSiteLinkOffer;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AddSiteLinkOffer extends Route {
        public static final int $stable = 0;
        public static final AddSiteLinkOffer INSTANCE = new AddSiteLinkOffer();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddSiteLinkOffer)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 887900508;
        }

        public String toString() {
            return "AddSiteLinkOffer";
        }

        private AddSiteLinkOffer() {
            super("offers/new/sitelink", "Add SiteLink Offer", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$EditOffer;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EditOffer extends Route {
        public static final int $stable = 0;
        public static final EditOffer INSTANCE = new EditOffer();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditOffer)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1992465616;
        }

        public String toString() {
            return "EditOffer";
        }

        private EditOffer() {
            super("offers/edit/{offerId}", "Edit Offer", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$Settings;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Settings extends Route {
        public static final int $stable = 0;
        public static final Settings INSTANCE = new Settings();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Settings)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1985231781;
        }

        public String toString() {
            return "Settings";
        }

        private Settings() {
            super("settings", "Settings", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$AutoSaveContactsSettings;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AutoSaveContactsSettings extends Route {
        public static final int $stable = 0;
        public static final AutoSaveContactsSettings INSTANCE = new AutoSaveContactsSettings();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AutoSaveContactsSettings)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 600606980;
        }

        public String toString() {
            return "AutoSaveContactsSettings";
        }

        private AutoSaveContactsSettings() {
            super("auto-save-contacts-settings", "Auto-Save Contacts", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$TransactionDetails;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TransactionDetails extends Route {
        public static final int $stable = 0;
        public static final TransactionDetails INSTANCE = new TransactionDetails();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransactionDetails)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1491527302;
        }

        public String toString() {
            return "TransactionDetails";
        }

        private TransactionDetails() {
            super("transactions/{transactionId}?hasScheduledTransactions={hasScheduledTransactions}", "Transaction Details", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$MySubscription;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MySubscription extends Route {
        public static final int $stable = 0;
        public static final MySubscription INSTANCE = new MySubscription();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MySubscription)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1713443093;
        }

        public String toString() {
            return "MySubscription";
        }

        private MySubscription() {
            super("my-subscription", "My Subscription", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$EditProfile;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EditProfile extends Route {
        public static final int $stable = 0;
        public static final EditProfile INSTANCE = new EditProfile();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditProfile)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 2035346813;
        }

        public String toString() {
            return "EditProfile";
        }

        private EditProfile() {
            super("profile/edit", "Edit Profile", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$Customers;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Customers extends Route {
        public static final int $stable = 0;
        public static final Customers INSTANCE = new Customers();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Customers)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1500310803;
        }

        public String toString() {
            return "Customers";
        }

        private Customers() {
            super("customers", "My Customers", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$QuickDial;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class QuickDial extends Route {
        public static final int $stable = 0;
        public static final QuickDial INSTANCE = new QuickDial();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuickDial)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1189042107;
        }

        public String toString() {
            return "QuickDial";
        }

        private QuickDial() {
            super("quick-dial", "Quick Dial", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$AutoRenew;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AutoRenew extends Route {
        public static final int $stable = 0;
        public static final AutoRenew INSTANCE = new AutoRenew();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AutoRenew)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1537598172;
        }

        public String toString() {
            return "AutoRenew";
        }

        private AutoRenew() {
            super("auto-renew", "Auto Renewals", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$AddAutoRenew;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AddAutoRenew extends Route {
        public static final int $stable = 0;
        public static final AddAutoRenew INSTANCE = new AddAutoRenew();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddAutoRenew)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1355731713;
        }

        public String toString() {
            return "AddAutoRenew";
        }

        private AddAutoRenew() {
            super("auto-renew/add", "Add Auto Renewal", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$SiteLink;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SiteLink extends Route {
        public static final int $stable = 0;
        public static final SiteLink INSTANCE = new SiteLink();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SiteLink)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1225557859;
        }

        public String toString() {
            return SmsSender.SITELINK;
        }

        private SiteLink() {
            super("site-link", "Site Link", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$Login;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Login extends Route {
        public static final int $stable = 0;
        public static final Login INSTANCE = new Login();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Login)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1754894553;
        }

        public String toString() {
            return "Login";
        }

        private Login() {
            super(FirebaseAnalytics.Event.LOGIN, "Login", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$PayWithAirtime;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PayWithAirtime extends Route {
        public static final int $stable = 0;
        public static final PayWithAirtime INSTANCE = new PayWithAirtime();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PayWithAirtime)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1099397205;
        }

        public String toString() {
            return "PayWithAirtime";
        }

        private PayWithAirtime() {
            super("payment/airtime", "Pay with Airtime", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$Transactions;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "withStatus", "", NotificationCompat.CATEGORY_STATUS, "Lcom/example/bingwahybrid/domain/enums/TransactionStatus;", "duration", FtsOptions.TOKENIZER_SIMPLE, "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Transactions extends Route {
        public static final int $stable = 0;
        public static final Transactions INSTANCE = new Transactions();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Transactions)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -912558121;
        }

        public String toString() {
            return "Transactions";
        }

        private Transactions() {
            super("transactions/{status}/{duration}", "Transactions", null);
        }

        public static /* synthetic */ String withStatus$default(Transactions transactions, TransactionStatus transactionStatus, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                transactionStatus = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return transactions.withStatus(transactionStatus, str);
        }

        public final String withStatus(TransactionStatus status, String duration) {
            String strName;
            if (status == null || (strName = status.name()) == null) {
                strName = "none";
            }
            if (duration == null) {
                duration = "none";
            }
            return "transactions/" + strName + "/" + duration;
        }

        public final String simple() {
            return "transactions";
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$AutoReply;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AutoReply extends Route {
        public static final int $stable = 0;
        public static final AutoReply INSTANCE = new AutoReply();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AutoReply)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1537600313;
        }

        public String toString() {
            return "AutoReply";
        }

        private AutoReply() {
            super("auto-reply", "Auto Reply", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$RescheduleTransaction;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RescheduleTransaction extends Route {
        public static final int $stable = 0;
        public static final RescheduleTransaction INSTANCE = new RescheduleTransaction();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RescheduleTransaction)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1047092850;
        }

        public String toString() {
            return "RescheduleTransaction";
        }

        private RescheduleTransaction() {
            super("transactions/{transactionId}/reschedule", "Reschedule Offer", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$EditCustomer;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EditCustomer extends Route {
        public static final int $stable = 0;
        public static final EditCustomer INSTANCE = new EditCustomer();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditCustomer)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 279680650;
        }

        public String toString() {
            return "EditCustomer";
        }

        private EditCustomer() {
            super("customers/{customerPhone}/edit", "Edit Customer", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$EditAutoReplyMessage;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EditAutoReplyMessage extends Route {
        public static final int $stable = 0;
        public static final EditAutoReplyMessage INSTANCE = new EditAutoReplyMessage();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditAutoReplyMessage)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -425846856;
        }

        public String toString() {
            return "EditAutoReplyMessage";
        }

        private EditAutoReplyMessage() {
            super("auto-reply/{id}/edit", "Edit AutoReply", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$ResetPassword;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ResetPassword extends Route {
        public static final int $stable = 0;
        public static final ResetPassword INSTANCE = new ResetPassword();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResetPassword)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1302814408;
        }

        public String toString() {
            return "ResetPassword";
        }

        private ResetPassword() {
            super("reset-password/{email}", "Reset Password", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$CreateSiteLink;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CreateSiteLink extends Route {
        public static final int $stable = 0;
        public static final CreateSiteLink INSTANCE = new CreateSiteLink();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateSiteLink)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -208099585;
        }

        public String toString() {
            return "CreateSiteLink";
        }

        private CreateSiteLink() {
            super("site-link/create", "Create SiteLink", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$EditSiteLink;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EditSiteLink extends Route {
        public static final int $stable = 0;
        public static final EditSiteLink INSTANCE = new EditSiteLink();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditSiteLink)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 348462733;
        }

        public String toString() {
            return "EditSiteLink";
        }

        private EditSiteLink() {
            super("site-link/edit", "EditSiteLink", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$HybridConnect;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class HybridConnect extends Route {
        public static final int $stable = 0;
        public static final HybridConnect INSTANCE = new HybridConnect();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HybridConnect)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1618830068;
        }

        public String toString() {
            return SmsSender.HYBRID_CONNECT;
        }

        private HybridConnect() {
            super("hybrid-connect", "Hybrid Connect", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$Community;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Community extends Route {
        public static final int $stable = 0;
        public static final Community INSTANCE = new Community();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Community)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1591500633;
        }

        public String toString() {
            return "Community";
        }

        private Community() {
            super("community", "Community", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$CommunityOffers;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CommunityOffers extends Route {
        public static final int $stable = 0;
        public static final CommunityOffers INSTANCE = new CommunityOffers();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommunityOffers)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -289905378;
        }

        public String toString() {
            return "CommunityOffers";
        }

        private CommunityOffers() {
            super("community/offers", "Community Offers", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$QrScanner;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class QrScanner extends Route {
        public static final int $stable = 0;
        public static final QrScanner INSTANCE = new QrScanner();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QrScanner)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2097612453;
        }

        public String toString() {
            return "QrScanner";
        }

        private QrScanner() {
            super("qr-scanner", "QR Scanner", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$CheckForUpdates;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CheckForUpdates extends Route {
        public static final int $stable = 0;
        public static final CheckForUpdates INSTANCE = new CheckForUpdates();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckForUpdates)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1977624871;
        }

        public String toString() {
            return "CheckForUpdates";
        }

        private CheckForUpdates() {
            super("updates-check", "Check For Updates", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$AccessibilityInfo;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AccessibilityInfo extends Route {
        public static final int $stable = 0;
        public static final AccessibilityInfo INSTANCE = new AccessibilityInfo();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AccessibilityInfo)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1331030566;
        }

        public String toString() {
            return "AccessibilityInfo";
        }

        private AccessibilityInfo() {
            super("accessibility-info", "Accessibility Service Required", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$BlackList;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BlackList extends Route {
        public static final int $stable = 0;
        public static final BlackList INSTANCE = new BlackList();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BlackList)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1220808187;
        }

        public String toString() {
            return "BlackList";
        }

        private BlackList() {
            super("blacklist", "Blacklist Customers", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$AuthorizedSenders;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AuthorizedSenders extends Route {
        public static final int $stable = 0;
        public static final AuthorizedSenders INSTANCE = new AuthorizedSenders();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthorizedSenders)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 422587777;
        }

        public String toString() {
            return "AuthorizedSenders";
        }

        private AuthorizedSenders() {
            super("authorized-senders", "Authorized Senders", null);
        }
    }

    /* JADX INFO: compiled from: Route.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/Route$RedeemCoupon;", "Lcom/example/bingwahybrid/presentation/navigation/Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RedeemCoupon extends Route {
        public static final int $stable = 0;
        public static final RedeemCoupon INSTANCE = new RedeemCoupon();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RedeemCoupon)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1722664804;
        }

        public String toString() {
            return "RedeemCoupon";
        }

        private RedeemCoupon() {
            super("redeem-coupon", "Redeem Coupon", null);
        }
    }
}
