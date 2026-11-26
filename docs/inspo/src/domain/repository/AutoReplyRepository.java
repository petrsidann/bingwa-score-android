package com.example.bingwahybrid.domain.repository;

import com.example.bingwahybrid.domain.enums.AutoReplyType;
import com.example.bingwahybrid.domain.model.AutoReply;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: AutoReplyRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH¦@¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u000bH&J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/AutoReplyRepository;", "", "addAutoReply", "", "autoReply", "Lcom/example/bingwahybrid/domain/model/AutoReply;", "(Lcom/example/bingwahybrid/domain/model/AutoReply;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoReplies", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAutoRepliesFlow", "Lkotlinx/coroutines/flow/Flow;", "getAutoReplyByType", "autoReplyType", "Lcom/example/bingwahybrid/domain/enums/AutoReplyType;", "(Lcom/example/bingwahybrid/domain/enums/AutoReplyType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoReplyById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAutoReply", "activateAutoReply", "deactivateAutoReply", "deleteAutoReply", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AutoReplyRepository {
    Object activateAutoReply(AutoReplyType autoReplyType, Continuation<? super Unit> continuation);

    Object addAutoReply(AutoReply autoReply, Continuation<? super Unit> continuation);

    Object deactivateAutoReply(AutoReplyType autoReplyType, Continuation<? super Unit> continuation);

    Object deleteAutoReply(long j, Continuation<? super Boolean> continuation);

    Flow<List<AutoReply>> getAllAutoRepliesFlow();

    Object getAutoReplies(Continuation<? super List<AutoReply>> continuation);

    Object getAutoReplyById(long j, Continuation<? super AutoReply> continuation);

    Object getAutoReplyByType(AutoReplyType autoReplyType, Continuation<? super AutoReply> continuation);

    Object updateAutoReply(AutoReply autoReply, Continuation<? super Unit> continuation);
}
