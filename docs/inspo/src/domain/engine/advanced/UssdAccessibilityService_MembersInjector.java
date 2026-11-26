package com.example.bingwahybrid.domain.engine.advanced;

import com.example.bingwahybrid.domain.devices.repository.CurrentDeviceRepository;
import com.example.bingwahybrid.domain.repository.AccessibilityRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.ussd.repository.OfferSession;
import com.example.bingwahybrid.domain.ussd.repository.UssdSessionManager;
import com.example.bingwahybrid.domain.ussd.repository.UssdStepsRepository;
import com.example.bingwahybrid.domain.ussd.utils.OfferScanner;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class UssdAccessibilityService_MembersInjector implements MembersInjector<UssdAccessibilityService> {
    private final Provider<AccessibilityRepository> accessibilityRepositoryProvider;
    private final Provider<CurrentDeviceRepository> currentDeviceRepositoryProvider;
    private final Provider<OfferScanner> offerScannerProvider;
    private final Provider<OfferSession> offerSessionProvider;
    private final Provider<UssdSessionManager> sessionManagerProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<UssdStepsRepository> ussdStepsRepositoryProvider;

    private UssdAccessibilityService_MembersInjector(Provider<UssdStepsRepository> ussdStepsRepositoryProvider, Provider<UssdSessionManager> sessionManagerProvider, Provider<AccessibilityRepository> accessibilityRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<CurrentDeviceRepository> currentDeviceRepositoryProvider, Provider<OfferSession> offerSessionProvider, Provider<OfferScanner> offerScannerProvider) {
        this.ussdStepsRepositoryProvider = ussdStepsRepositoryProvider;
        this.sessionManagerProvider = sessionManagerProvider;
        this.accessibilityRepositoryProvider = accessibilityRepositoryProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.currentDeviceRepositoryProvider = currentDeviceRepositoryProvider;
        this.offerSessionProvider = offerSessionProvider;
        this.offerScannerProvider = offerScannerProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(UssdAccessibilityService instance) {
        injectUssdStepsRepository(instance, this.ussdStepsRepositoryProvider.get());
        injectSessionManager(instance, this.sessionManagerProvider.get());
        injectAccessibilityRepository(instance, this.accessibilityRepositoryProvider.get());
        injectSettingsRepository(instance, this.settingsRepositoryProvider.get());
        injectCurrentDeviceRepository(instance, this.currentDeviceRepositoryProvider.get());
        injectOfferSession(instance, this.offerSessionProvider.get());
        injectOfferScanner(instance, this.offerScannerProvider.get());
    }

    public static MembersInjector<UssdAccessibilityService> create(Provider<UssdStepsRepository> ussdStepsRepositoryProvider, Provider<UssdSessionManager> sessionManagerProvider, Provider<AccessibilityRepository> accessibilityRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<CurrentDeviceRepository> currentDeviceRepositoryProvider, Provider<OfferSession> offerSessionProvider, Provider<OfferScanner> offerScannerProvider) {
        return new UssdAccessibilityService_MembersInjector(ussdStepsRepositoryProvider, sessionManagerProvider, accessibilityRepositoryProvider, settingsRepositoryProvider, currentDeviceRepositoryProvider, offerSessionProvider, offerScannerProvider);
    }

    public static void injectUssdStepsRepository(UssdAccessibilityService instance, UssdStepsRepository ussdStepsRepository) {
        instance.ussdStepsRepository = ussdStepsRepository;
    }

    public static void injectSessionManager(UssdAccessibilityService instance, UssdSessionManager sessionManager) {
        instance.sessionManager = sessionManager;
    }

    public static void injectAccessibilityRepository(UssdAccessibilityService instance, AccessibilityRepository accessibilityRepository) {
        instance.accessibilityRepository = accessibilityRepository;
    }

    public static void injectSettingsRepository(UssdAccessibilityService instance, SettingsRepository settingsRepository) {
        instance.settingsRepository = settingsRepository;
    }

    public static void injectCurrentDeviceRepository(UssdAccessibilityService instance, CurrentDeviceRepository currentDeviceRepository) {
        instance.currentDeviceRepository = currentDeviceRepository;
    }

    public static void injectOfferSession(UssdAccessibilityService instance, OfferSession offerSession) {
        instance.offerSession = offerSession;
    }

    public static void injectOfferScanner(UssdAccessibilityService instance, OfferScanner offerScanner) {
        instance.offerScanner = offerScanner;
    }
}
