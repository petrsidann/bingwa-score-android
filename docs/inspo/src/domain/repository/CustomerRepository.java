package com.example.bingwahybrid.domain.repository;

import androidx.autofill.HintConstants;
import com.example.bingwahybrid.domain.model.Customer;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: CustomerRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH¦@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\"\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u0016\u0010#\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u0016\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0'H&J\u0016\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u0016\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u001c\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0'2\u0006\u0010,\u001a\u00020\u0014H&¨\u0006-À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/repository/CustomerRepository;", "", "insertCustomer", "", "customer", "Lcom/example/bingwahybrid/domain/model/Customer;", "(Lcom/example/bingwahybrid/domain/model/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCustomers", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCustomerById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCustomerByStableId", "stableId", "Ljava/util/UUID;", "(Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCustomerByPhone", HintConstants.AUTOFILL_HINT_PHONE, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCustomerRegistered", "", "incrementAccountBalance", "amount", "(Lcom/example/bingwahybrid/domain/model/Customer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decrementAccountBalance", "updateLastPurchaseTime", "lastPurchaseTime", "", "(Lcom/example/bingwahybrid/domain/model/Customer;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCustomerInfo", "deleteCustomer", "isCustomerSavedInContacts", "markCustomerAsSavedInContacts", "addCustomerToBlackList", "removeCustomerFromBlackList", "getBlackListedCustomers", "Lkotlinx/coroutines/flow/Flow;", "removeFromBlackList", "customerPhone", "addToBlackList", "searchCustomer", "searchQuery", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CustomerRepository {
    Object addCustomerToBlackList(Customer customer, Continuation<? super Unit> continuation);

    Object addToBlackList(String str, Continuation<? super Unit> continuation);

    Object decrementAccountBalance(Customer customer, int i, Continuation<? super Unit> continuation);

    Object deleteCustomer(Customer customer, Continuation<? super Unit> continuation);

    Object getAllCustomers(Continuation<? super List<Customer>> continuation);

    Flow<List<Customer>> getBlackListedCustomers();

    Object getCustomerById(int i, Continuation<? super Customer> continuation);

    Object getCustomerByPhone(String str, Continuation<? super Customer> continuation);

    Object getCustomerByStableId(UUID uuid, Continuation<? super Customer> continuation);

    Object incrementAccountBalance(Customer customer, int i, Continuation<? super Unit> continuation);

    Object insertCustomer(Customer customer, Continuation<? super Unit> continuation);

    Object isCustomerRegistered(String str, Continuation<? super Boolean> continuation);

    Object isCustomerSavedInContacts(String str, Continuation<? super Boolean> continuation);

    Object markCustomerAsSavedInContacts(String str, Continuation<? super Unit> continuation);

    Object removeCustomerFromBlackList(Customer customer, Continuation<? super Unit> continuation);

    Object removeFromBlackList(String str, Continuation<? super Unit> continuation);

    Flow<List<Customer>> searchCustomer(String searchQuery);

    Object updateCustomerInfo(Customer customer, Continuation<? super Unit> continuation);

    Object updateLastPurchaseTime(Customer customer, long j, Continuation<? super Unit> continuation);
}
