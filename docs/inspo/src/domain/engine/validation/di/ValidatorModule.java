package com.example.bingwahybrid.domain.engine.validation.di;

import com.example.bingwahybrid.domain.engine.validation.AdvancedModeValidator;
import com.example.bingwahybrid.domain.engine.validation.AutoTimeValidator;
import com.example.bingwahybrid.domain.engine.validation.CustomerBlacklistValidator;
import com.example.bingwahybrid.domain.engine.validation.OfferValidator;
import com.example.bingwahybrid.domain.engine.validation.PermissionValidator;
import com.example.bingwahybrid.domain.engine.validation.StatusValidator;
import com.example.bingwahybrid.domain.engine.validation.SubscriptionValidator;
import com.example.bingwahybrid.domain.engine.validation.TokenValidator;
import com.example.bingwahybrid.domain.engine.validation.TransactionValidator;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;

/* JADX INFO: compiled from: ValidatorModule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH'J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0015H'¨\u0006\u0016"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/di/ValidatorModule;", "", "<init>", "()V", "bindStatusValidator", "Lcom/example/bingwahybrid/domain/engine/validation/TransactionValidator;", "impl", "Lcom/example/bingwahybrid/domain/engine/validation/StatusValidator;", "bindPermissionValidator", "Lcom/example/bingwahybrid/domain/engine/validation/PermissionValidator;", "bindSubscriptionValidator", "Lcom/example/bingwahybrid/domain/engine/validation/SubscriptionValidator;", "bindTokenValidator", "Lcom/example/bingwahybrid/domain/engine/validation/TokenValidator;", "bindCustomerBlacklistValidator", "Lcom/example/bingwahybrid/domain/engine/validation/CustomerBlacklistValidator;", "bindOfferValidator", "Lcom/example/bingwahybrid/domain/engine/validation/OfferValidator;", "bindAdvancedModeValidator", "Lcom/example/bingwahybrid/domain/engine/validation/AdvancedModeValidator;", "bindAutoTimeValidator", "Lcom/example/bingwahybrid/domain/engine/validation/AutoTimeValidator;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class ValidatorModule {
    public static final int $stable = 0;

    @Binds
    @IntoSet
    public abstract TransactionValidator bindAdvancedModeValidator(AdvancedModeValidator impl);

    @Binds
    @IntoSet
    public abstract TransactionValidator bindAutoTimeValidator(AutoTimeValidator impl);

    @Binds
    @IntoSet
    public abstract TransactionValidator bindCustomerBlacklistValidator(CustomerBlacklistValidator impl);

    @Binds
    @IntoSet
    public abstract TransactionValidator bindOfferValidator(OfferValidator impl);

    @Binds
    @IntoSet
    public abstract TransactionValidator bindPermissionValidator(PermissionValidator impl);

    @Binds
    @IntoSet
    public abstract TransactionValidator bindStatusValidator(StatusValidator impl);

    @Binds
    @IntoSet
    public abstract TransactionValidator bindSubscriptionValidator(SubscriptionValidator impl);

    @Binds
    @IntoSet
    public abstract TransactionValidator bindTokenValidator(TokenValidator impl);
}
