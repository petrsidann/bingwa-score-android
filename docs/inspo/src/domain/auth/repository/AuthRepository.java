package com.example.bingwahybrid.domain.auth.repository;

import com.example.bingwahybrid.domain.auth.models.Agent;
import com.example.bingwahybrid.domain.auth.models.AuthDetails;
import com.example.bingwahybrid.domain.auth.models.AuthToken;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AuthRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u001a\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u001b\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/auth/repository/AuthRepository;", "", "agent", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bingwahybrid/domain/auth/models/Agent;", "getAgent", "()Lkotlinx/coroutines/flow/StateFlow;", "registerAgent", "", "(Lcom/example/bingwahybrid/domain/auth/models/Agent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUser", "Lcom/example/bingwahybrid/domain/auth/models/AuthDetails;", "email", "", "pin", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAgent", "getMyProfile", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAgentRemote", "updateAgentPin", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOtp", "verifyOtp", "Lcom/example/bingwahybrid/domain/auth/models/AuthToken;", "otp", "getLoggedInAgent", "logoutUser", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AuthRepository {
    StateFlow<Agent> getAgent();

    Object getLoggedInAgent(Continuation<? super Agent> continuation);

    Object getMyProfile(Continuation<? super Agent> continuation);

    Object loginUser(String str, String str2, Continuation<? super AuthDetails> continuation);

    Object logoutUser(Continuation<? super Unit> continuation);

    Object registerAgent(Agent agent, Continuation<? super Unit> continuation);

    Object saveAgent(Agent agent, Continuation<? super Unit> continuation);

    Object sendOtp(String str, Continuation<? super Unit> continuation);

    Object updateAgentPin(String str, Continuation<? super Unit> continuation);

    Object updateAgentRemote(Agent agent, Continuation<? super Unit> continuation);

    Object verifyOtp(String str, Continuation<? super AuthToken> continuation);
}
