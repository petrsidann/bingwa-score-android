package com.example.bingwahybrid.domain.repository;

import com.example.bingwahybrid.domain.sms.model.AuthorizedSender;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: AuthorizedSenderRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/AuthorizedSenderRepository;", "", "authorizedSenders", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/bingwahybrid/domain/sms/model/AuthorizedSender;", "getAuthorizedSenders", "()Lkotlinx/coroutines/flow/Flow;", "addAuthorizedSender", "", "sender", "(Lcom/example/bingwahybrid/domain/sms/model/AuthorizedSender;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSender", "isSenderAuthorized", "", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AuthorizedSenderRepository {
    Object addAuthorizedSender(AuthorizedSender authorizedSender, Continuation<? super Unit> continuation);

    Object deleteSender(AuthorizedSender authorizedSender, Continuation<? super Unit> continuation);

    Flow<List<AuthorizedSender>> getAuthorizedSenders();

    Object isSenderAuthorized(String str, Continuation<? super Boolean> continuation);
}
