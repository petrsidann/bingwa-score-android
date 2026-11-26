package com.example.bingwahybrid.domain.sms.di;

import com.example.bingwahybrid.domain.sms.messageextractor.MessageExtractor;
import com.example.bingwahybrid.domain.sms.messageextractor.MpesaMessageExtractor;
import com.example.bingwahybrid.domain.sms.messageextractor.PayBillMessageExtractor;
import com.example.bingwahybrid.domain.sms.messageextractor.SiteLinkMessageExtractor;
import com.example.bingwahybrid.domain.sms.messageextractor.TillMessageExtractor;
import com.example.bingwahybrid.domain.sms.usecases.ExtractMessageDetailsUseCase;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageExtractorModule.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\rH'¨\u0006\u000f"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/di/MessageExtractorModule;", "", "<init>", "()V", "bindMpesaMessageExtractor", "Lcom/example/bingwahybrid/domain/sms/messageextractor/MessageExtractor;", "impl", "Lcom/example/bingwahybrid/domain/sms/messageextractor/MpesaMessageExtractor;", "bindTillMessageExtractor", "Lcom/example/bingwahybrid/domain/sms/messageextractor/TillMessageExtractor;", "bindSiteLinkMessageExtractor", "Lcom/example/bingwahybrid/domain/sms/messageextractor/SiteLinkMessageExtractor;", "bindPayBillMessageExtractor", "Lcom/example/bingwahybrid/domain/sms/messageextractor/PayBillMessageExtractor;", "Companion", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class MessageExtractorModule {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Singleton
    @Binds
    @Named("mpesaMessageExtractor")
    public abstract MessageExtractor bindMpesaMessageExtractor(MpesaMessageExtractor impl);

    @Singleton
    @Binds
    @Named("payBillMessageExtractor")
    public abstract MessageExtractor bindPayBillMessageExtractor(PayBillMessageExtractor impl);

    @Singleton
    @Binds
    @Named("siteLinkMessageExtractor")
    public abstract MessageExtractor bindSiteLinkMessageExtractor(SiteLinkMessageExtractor impl);

    @Singleton
    @Binds
    @Named("tillMessageExtractor")
    public abstract MessageExtractor bindTillMessageExtractor(TillMessageExtractor impl);

    /* JADX INFO: compiled from: MessageExtractorModule.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u0007H\u0007¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/di/MessageExtractorModule$Companion;", "", "<init>", "()V", "provideExtractMessageDetailsUseCase", "Lcom/example/bingwahybrid/domain/sms/usecases/ExtractMessageDetailsUseCase;", "mpesaMessageExtractor", "Lcom/example/bingwahybrid/domain/sms/messageextractor/MessageExtractor;", "tillMessagesExtractor", "payBillMessageExtractor", "siteLinkMessageExtractor", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Provides
        @Singleton
        public final ExtractMessageDetailsUseCase provideExtractMessageDetailsUseCase(@Named("mpesaMessageExtractor") MessageExtractor mpesaMessageExtractor, @Named("tillMessageExtractor") MessageExtractor tillMessagesExtractor, @Named("payBillMessageExtractor") MessageExtractor payBillMessageExtractor, @Named("siteLinkMessageExtractor") MessageExtractor siteLinkMessageExtractor) {
            Intrinsics.checkNotNullParameter(mpesaMessageExtractor, "mpesaMessageExtractor");
            Intrinsics.checkNotNullParameter(tillMessagesExtractor, "tillMessagesExtractor");
            Intrinsics.checkNotNullParameter(payBillMessageExtractor, "payBillMessageExtractor");
            Intrinsics.checkNotNullParameter(siteLinkMessageExtractor, "siteLinkMessageExtractor");
            return new ExtractMessageDetailsUseCase(mpesaMessageExtractor, tillMessagesExtractor, payBillMessageExtractor, siteLinkMessageExtractor);
        }
    }
}
