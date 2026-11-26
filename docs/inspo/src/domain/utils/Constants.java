package com.example.bingwahybrid.domain.utils;

import com.example.bingwahybrid.domain.enums.AppMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: Constants.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/example/bingwahybrid/domain/utils/Constants;", "", "<init>", "()V", "APP_MODE", "Lcom/example/bingwahybrid/domain/enums/AppMode;", "APP_NAME", "", "CLIENT_TYPE", "APP_VERSION", "DATABASE_NAME", "BASE_URL", "getBASE_URL", "()Ljava/lang/String;", "KEY_PREFS_NAME", "AIRTIME_SUBSCRIPTION_USSD_CODE", "HYBRID_PUBLIC_KEY", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Constants {
    public static final int $stable = 0;
    public static final String AIRTIME_SUBSCRIPTION_USSD_CODE = "*140*AMT*BH#";
    private static final AppMode APP_MODE;
    public static final String APP_NAME = "Bingwa Hybrid";
    public static final String APP_VERSION = "2.5.11";
    private static final String BASE_URL;
    public static final String CLIENT_TYPE = "BingwaHybrid";
    public static final String DATABASE_NAME = "app_database";
    public static final String HYBRID_PUBLIC_KEY = "LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUFqSndndytSMXJCOEx6V1hTWTh0eQp4L2NuWkpmTHMyYzkvZDE3cFZOU2pPSVpPbTd4Vis0SmRXOE05cmxMK1JvdUd0NWo4ZnYyczZFaWxBSDNJdXd2CktqbHdmT0VFQythTUdNZlhIdEtMMTBBaVV5c3BaRGJ3UUVrU1N0MDZPZ3p6MGtCS3YzRUVzMkQzYmc4di9WOGkKRldjYzFIOTErSHZra3hiSHBweDhWNUFoTVRMTkZXMllISDBiSUJ0TEd0WjViUSsxYzY5TmIrQXIrMXRxRWJrUQpzTktGSzdqVmpSb1FQWEo2Mk9QNVBIUG5ZNTNqZEhTT1FVSU9kMnE4ZzNlUWdvQVlRMVNZV2diUzlkSk5MK2hYCm8vbnRoU1Z0SFZtbGhxQ2c0UGNsVnVDYjJLYXZvMXpndUdZZmFzeWdjMTB0MWlZWGQyQ0dwWkNSQ2U0R1NidlkKOHdJREFRQUIKLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==";
    public static final Constants INSTANCE = new Constants();
    public static final String KEY_PREFS_NAME = "bingwa_prefs";

    /* JADX INFO: compiled from: Constants.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppMode.values().length];
            try {
                iArr[AppMode.PRODUCTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppMode.TESTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppMode.DEVELOPMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Constants() {
    }

    static {
        String str;
        AppMode appMode = AppMode.PRODUCTION;
        APP_MODE = appMode;
        int i = WhenMappings.$EnumSwitchMapping$0[appMode.ordinal()];
        if (i == 1) {
            str = "https://api.bingwahybrid.com";
        } else if (i == 2) {
            str = "https://test.api.bingwahybrid.com";
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "http://192.168.100.227:4500";
        }
        BASE_URL = str;
    }

    public final String getBASE_URL() {
        return BASE_URL;
    }
}
