package com.example.bingwahybrid.domain.usecase.customer.exceptions;

import com.example.bingwahybrid.domain.model.Customer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerBlackListedException.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/customer/exceptions/CustomerBlackListedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "customer", "Lcom/example/bingwahybrid/domain/model/Customer;", "<init>", "(Lcom/example/bingwahybrid/domain/model/Customer;)V", "getCustomer", "()Lcom/example/bingwahybrid/domain/model/Customer;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerBlackListedException extends Exception {
    public static final int $stable = 8;
    private final Customer customer;

    public final Customer getCustomer() {
        return this.customer;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerBlackListedException(Customer customer) {
        super("Customer " + customer.getName() + " with phone number " + customer.getPhone() + " is blacklisted.");
        Intrinsics.checkNotNullParameter(customer, "customer");
        this.customer = customer;
    }
}
