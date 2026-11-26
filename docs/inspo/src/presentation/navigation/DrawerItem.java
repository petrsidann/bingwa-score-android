package com.example.bingwahybrid.presentation.navigation;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ForwardToInboxKt;
import androidx.compose.material.icons.automirrored.outlined.LogoutKt;
import androidx.compose.material.icons.filled.AutorenewKt;
import androidx.compose.material.icons.outlined.DialpadKt;
import androidx.compose.material.icons.outlined.GroupsKt;
import androidx.compose.material.icons.outlined.HomeKt;
import androidx.compose.material.icons.outlined.LeakAddKt;
import androidx.compose.material.icons.outlined.LinkKt;
import androidx.compose.material.icons.outlined.LocalOfferKt;
import androidx.compose.material.icons.outlined.PeopleKt;
import androidx.compose.material.icons.outlined.SettingsKt;
import androidx.compose.material.icons.outlined.SubscriptionsKt;
import androidx.compose.material.icons.outlined.UpdateKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.example.bingwahybrid.domain.sms.model.SmsSender;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DrawerItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\r\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\r\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%¨\u0006&"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "", LinkHeader.Parameters.Title, "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "Home", "AutoRenew", "Offers", "Customers", "Settings", "QuickDial", SmsSender.SITELINK, "AutoReply", "Subscription", SmsSender.HYBRID_CONNECT, "Community", "Logout", "CheckForUpdates", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$AutoRenew;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$AutoReply;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$CheckForUpdates;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Community;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Customers;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Home;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$HybridConnect;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Logout;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Offers;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$QuickDial;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Settings;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$SiteLink;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Subscription;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DrawerItem {
    public static final int $stable = 0;
    private final ImageVector icon;
    private final String title;

    public /* synthetic */ DrawerItem(String str, ImageVector imageVector, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, imageVector);
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Home;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Home extends DrawerItem {
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
            return -1964207284;
        }

        public String toString() {
            return "Home";
        }

        private Home() {
            super("Home", HomeKt.getHome(Icons.Outlined.INSTANCE), null);
        }
    }

    private DrawerItem(String str, ImageVector imageVector) {
        this.title = str;
        this.icon = imageVector;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$AutoRenew;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AutoRenew extends DrawerItem {
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
            return -1407266863;
        }

        public String toString() {
            return "AutoRenew";
        }

        private AutoRenew() {
            super("Auto Renewals", AutorenewKt.getAutorenew(Icons.INSTANCE.getDefault()), null);
        }
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Offers;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Offers extends DrawerItem {
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
            return -1920669500;
        }

        public String toString() {
            return "Offers";
        }

        private Offers() {
            super("Offers", LocalOfferKt.getLocalOffer(Icons.Outlined.INSTANCE), null);
        }
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Customers;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Customers extends DrawerItem {
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
            return -1444554232;
        }

        public String toString() {
            return "Customers";
        }

        private Customers() {
            super("Customer Balances", PeopleKt.getPeople(Icons.Outlined.INSTANCE), null);
        }
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Settings;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Settings extends DrawerItem {
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
            return -1019257840;
        }

        public String toString() {
            return "Settings";
        }

        private Settings() {
            super("Settings", SettingsKt.getSettings(Icons.Outlined.INSTANCE), null);
        }
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$QuickDial;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class QuickDial extends DrawerItem {
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
            return -1755822928;
        }

        public String toString() {
            return "QuickDial";
        }

        private QuickDial() {
            super("Quick Dial", DialpadKt.getDialpad(Icons.Outlined.INSTANCE), null);
        }
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$SiteLink;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SiteLink extends DrawerItem {
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
            return -1778931762;
        }

        public String toString() {
            return SmsSender.SITELINK;
        }

        private SiteLink() {
            super("Site Link", LinkKt.getLink(Icons.Outlined.INSTANCE), null);
        }
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$AutoReply;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AutoReply extends DrawerItem {
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
            return -1407264722;
        }

        public String toString() {
            return "AutoReply";
        }

        private AutoReply() {
            super("AutoReplies", ForwardToInboxKt.getForwardToInbox(Icons.AutoMirrored.Outlined.INSTANCE), null);
        }
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Subscription;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Subscription extends DrawerItem {
        public static final int $stable = 0;
        public static final Subscription INSTANCE = new Subscription();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subscription)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 297220746;
        }

        public String toString() {
            return "Subscription";
        }

        private Subscription() {
            super("Subscriptions", SubscriptionsKt.getSubscriptions(Icons.Outlined.INSTANCE), null);
        }
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$HybridConnect;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class HybridConnect extends DrawerItem {
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
            return -14547071;
        }

        public String toString() {
            return SmsSender.HYBRID_CONNECT;
        }

        private HybridConnect() {
            super("Hybrid Connect", LeakAddKt.getLeakAdd(Icons.Outlined.INSTANCE), null);
        }
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Community;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Community extends DrawerItem {
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
            return -241398372;
        }

        public String toString() {
            return "Community";
        }

        private Community() {
            super("Community", GroupsKt.getGroups(Icons.Outlined.INSTANCE), null);
        }
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$Logout;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Logout extends DrawerItem {
        public static final int $stable = 0;
        public static final Logout INSTANCE = new Logout();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Logout)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1998205769;
        }

        public String toString() {
            return "Logout";
        }

        private Logout() {
            super("Logout", LogoutKt.getLogout(Icons.AutoMirrored.Outlined.INSTANCE), null);
        }
    }

    /* JADX INFO: compiled from: DrawerItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/presentation/navigation/DrawerItem$CheckForUpdates;", "Lcom/example/bingwahybrid/presentation/navigation/DrawerItem;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CheckForUpdates extends DrawerItem {
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
            return 1800325724;
        }

        public String toString() {
            return "CheckForUpdates";
        }

        private CheckForUpdates() {
            super("Check For Updates", UpdateKt.getUpdate(Icons.Outlined.INSTANCE), null);
        }
    }
}
