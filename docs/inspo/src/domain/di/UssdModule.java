package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.data.ussd.repository.UssdSessionManagerImpl;
import com.example.bingwahybrid.domain.ussd.repository.UssdSessionManager;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: compiled from: UssdModule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/example/bingwahybrid/domain/di/UssdModule;", "", "<init>", "()V", "bindUssdSessionManager", "Lcom/example/bingwahybrid/domain/ussd/repository/UssdSessionManager;", "impl", "Lcom/example/bingwahybrid/data/ussd/repository/UssdSessionManagerImpl;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class UssdModule {
    public static final int $stable = 0;

    @Singleton
    @Binds
    public abstract UssdSessionManager bindUssdSessionManager(UssdSessionManagerImpl impl);
}
