package com.example.bingwahybrid.domain.usecase.customer;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.example.bingwahybrid.domain.enums.AppSetting;
import com.example.bingwahybrid.domain.model.Customer;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.usecase.customer.exceptions.CustomerAlreadySavedInPhoneBookException;
import dagger.hilt.android.qualifiers.ApplicationContext;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SaveContactToPhoneBookUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086B¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/customer/SaveContactToPhoneBookUseCase;", "", "customerRepository", "Lcom/example/bingwahybrid/domain/repository/CustomerRepository;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "context", "Landroid/content/Context;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/CustomerRepository;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Landroid/content/Context;)V", "invoke", "", HintConstants.AUTOFILL_HINT_PHONE, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveContact", "", "customerName", "normalizePhoneNumber", "isNumberInContacts", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SaveContactToPhoneBookUseCase {
    public static final int $stable = 8;
    private final Context context;
    private final CustomerRepository customerRepository;
    private final SettingsRepository settingsRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.usecase.customer.SaveContactToPhoneBookUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SaveContactToPhoneBookUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.usecase.customer.SaveContactToPhoneBookUseCase", f = "SaveContactToPhoneBookUseCase.kt", i = {0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4}, l = {23, 28, 35, 41, 44}, m = "invoke", n = {HintConstants.AUTOFILL_HINT_PHONE, HintConstants.AUTOFILL_HINT_PHONE, HintConstants.AUTOFILL_HINT_PHONE, "customer", "parts", "firstName", "lastName", HintConstants.AUTOFILL_HINT_PHONE, "customer", "parts", "firstName", "lastName", "suffix", "finalName", "saved", HintConstants.AUTOFILL_HINT_PHONE, "e"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SaveContactToPhoneBookUseCase.this.invoke(null, this);
        }
    }

    @Inject
    public SaveContactToPhoneBookUseCase(CustomerRepository customerRepository, SettingsRepository settingsRepository, @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(context, "context");
        this.customerRepository = customerRepository;
        this.settingsRepository = settingsRepository;
        this.context = context;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e6 A[Catch: SecurityException -> 0x0099, CustomerAlreadySavedInPhoneBookException -> 0x009c, Exception -> 0x01fe, TryCatch #0 {Exception -> 0x01fe, blocks: (B:19:0x006b, B:22:0x0084, B:63:0x013f, B:66:0x0155, B:68:0x0184, B:29:0x0095, B:47:0x00d6, B:49:0x00e6, B:51:0x00e9, B:55:0x0109, B:57:0x010f, B:59:0x0117, B:44:0x00c8), top: B:78:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00e9 A[Catch: SecurityException -> 0x0099, CustomerAlreadySavedInPhoneBookException -> 0x009c, Exception -> 0x01fe, TRY_LEAVE, TryCatch #0 {Exception -> 0x01fe, blocks: (B:19:0x006b, B:22:0x0084, B:63:0x013f, B:66:0x0155, B:68:0x0184, B:29:0x0095, B:47:0x00d6, B:49:0x00e6, B:51:0x00e9, B:55:0x0109, B:57:0x010f, B:59:0x0117, B:44:0x00c8), top: B:78:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0108  */
    /* JADX WARN: Code duplicated, block: B:57:0x010f A[Catch: SecurityException -> 0x0099, CustomerAlreadySavedInPhoneBookException -> 0x009c, Exception -> 0x01fe, TryCatch #0 {Exception -> 0x01fe, blocks: (B:19:0x006b, B:22:0x0084, B:63:0x013f, B:66:0x0155, B:68:0x0184, B:29:0x0095, B:47:0x00d6, B:49:0x00e6, B:51:0x00e9, B:55:0x0109, B:57:0x010f, B:59:0x0117, B:44:0x00c8), top: B:78:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0116  */
    /* JADX WARN: Code duplicated, block: B:62:0x0137  */
    /* JADX WARN: Code duplicated, block: B:65:0x0153  */
    /* JADX WARN: Code duplicated, block: B:68:0x0184 A[Catch: SecurityException -> 0x0089, CustomerAlreadySavedInPhoneBookException -> 0x008d, Exception -> 0x01fe, TRY_LEAVE, TryCatch #0 {Exception -> 0x01fe, blocks: (B:19:0x006b, B:22:0x0084, B:63:0x013f, B:66:0x0155, B:68:0x0184, B:29:0x0095, B:47:0x00d6, B:49:0x00e6, B:51:0x00e9, B:55:0x0109, B:57:0x010f, B:59:0x0117, B:44:0x00c8), top: B:78:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01b4, code lost:
    
        if (r13.markCustomerAsSavedInContacts(r11, r2) == r3) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01fb, code lost:
    
        if (r1.markCustomerAsSavedInContacts(r4, r2) == r3) goto L74;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        String str2;
        Customer customer;
        List listSplit$default;
        String str3;
        String str4;
        Object setting;
        Customer customer2;
        String str5;
        String str6;
        String str7;
        String string;
        String str8;
        String string2;
        boolean zSaveContact;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object setting2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str9 = anonymousClass1.label;
        try {
            try {
                if (str9 == 0) {
                    ResultKt.throwOnFailure(setting2);
                    SettingsRepository settingsRepository = this.settingsRepository;
                    AppSetting appSetting = AppSetting.AUTO_SAVE_CONTACTS;
                    anonymousClass1.L$0 = str;
                    anonymousClass1.label = 1;
                    setting2 = settingsRepository.getSetting(appSetting, anonymousClass1);
                    if (setting2 != coroutine_suspended) {
                        str2 = str;
                    }
                    return coroutine_suspended;
                }
                if (str9 == 1) {
                    str2 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(setting2);
                } else {
                    if (str9 == 2) {
                        str2 = (String) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(setting2);
                        customer = (Customer) setting2;
                        if (Intrinsics.areEqual(customer.getName(), customer.getPhone())) {
                            return Unit.INSTANCE;
                        }
                        listSplit$default = StringsKt.split$default((CharSequence) customer.getName(), new String[]{ServerSentEventKt.SPACE}, false, 0, 6, (Object) null);
                        str3 = (String) CollectionsKt.firstOrNull(listSplit$default);
                        if (str3 == null) {
                            str3 = "";
                        }
                        if (listSplit$default.size() > 1) {
                            str4 = (String) CollectionsKt.last(listSplit$default);
                        } else {
                            str4 = "";
                        }
                        SettingsRepository settingsRepository2 = this.settingsRepository;
                        AppSetting appSetting2 = AppSetting.AUTO_SAVE_CONTACTS_SUFFIX;
                        anonymousClass1.L$0 = str2;
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(customer);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(listSplit$default);
                        anonymousClass1.L$3 = str3;
                        anonymousClass1.L$4 = str4;
                        anonymousClass1.label = 3;
                        setting = settingsRepository2.getSetting(appSetting2, anonymousClass1);
                        if (setting != coroutine_suspended) {
                            String str10 = str4;
                            customer2 = customer;
                            setting2 = setting;
                            str5 = str3;
                            str6 = str2;
                            str7 = str10;
                            string = StringsKt.trim((CharSequence) setting2).toString();
                            if (StringsKt.isBlank(string)) {
                                string = "Bingwa";
                            }
                            str8 = string;
                            string2 = StringsKt.trim((CharSequence) (str5 + ServerSentEventKt.SPACE + str7 + ServerSentEventKt.SPACE + str8)).toString();
                            zSaveContact = saveContact(str6, string2);
                            if (zSaveContact) {
                                CustomerRepository customerRepository = this.customerRepository;
                                anonymousClass1.L$0 = str6;
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(customer2);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(listSplit$default);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str7);
                                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                                anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(string2);
                                anonymousClass1.Z$0 = zSaveContact;
                                anonymousClass1.label = 4;
                            }
                        }
                        return coroutine_suspended;
                    }
                    if (str9 == 3) {
                        str7 = (String) anonymousClass1.L$4;
                        str5 = (String) anonymousClass1.L$3;
                        listSplit$default = (List) anonymousClass1.L$2;
                        customer2 = (Customer) anonymousClass1.L$1;
                        str6 = (String) anonymousClass1.L$0;
                        try {
                            ResultKt.throwOnFailure(setting2);
                            string = StringsKt.trim((CharSequence) setting2).toString();
                            if (StringsKt.isBlank(string)) {
                                string = "Bingwa";
                            }
                            str8 = string;
                            string2 = StringsKt.trim((CharSequence) (str5 + ServerSentEventKt.SPACE + str7 + ServerSentEventKt.SPACE + str8)).toString();
                            zSaveContact = saveContact(str6, string2);
                            if (zSaveContact) {
                                CustomerRepository customerRepository2 = this.customerRepository;
                                anonymousClass1.L$0 = str6;
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(customer2);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(listSplit$default);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str7);
                                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                                anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(string2);
                                anonymousClass1.Z$0 = zSaveContact;
                                anonymousClass1.label = 4;
                            }
                        } catch (CustomerAlreadySavedInPhoneBookException e) {
                            e = e;
                            str9 = str6;
                            CustomerRepository customerRepository3 = this.customerRepository;
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(e);
                            anonymousClass1.L$2 = null;
                            anonymousClass1.L$3 = null;
                            anonymousClass1.L$4 = null;
                            anonymousClass1.L$5 = null;
                            anonymousClass1.L$6 = null;
                            anonymousClass1.label = 5;
                        } catch (SecurityException e2) {
                            e = e2;
                            str9 = str6;
                            Log.e("SaveContactToPhoneBook", "Permission denied while saving contact for " + str9 + ": " + e.getMessage(), e);
                        }
                    } else if (str9 == 4) {
                        boolean z = anonymousClass1.Z$0;
                        ResultKt.throwOnFailure(setting2);
                    } else {
                        if (str9 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(setting2);
                    }
                }
                return Unit.INSTANCE;
                if (!Boolean.parseBoolean((String) setting2)) {
                    return Unit.INSTANCE;
                }
                CustomerRepository customerRepository4 = this.customerRepository;
                anonymousClass1.L$0 = str2;
                anonymousClass1.label = 2;
                setting2 = customerRepository4.getCustomerByPhone(str2, anonymousClass1);
                if (setting2 != coroutine_suspended) {
                    customer = (Customer) setting2;
                    if (Intrinsics.areEqual(customer.getName(), customer.getPhone())) {
                        return Unit.INSTANCE;
                    }
                    listSplit$default = StringsKt.split$default((CharSequence) customer.getName(), new String[]{ServerSentEventKt.SPACE}, false, 0, 6, (Object) null);
                    str3 = (String) CollectionsKt.firstOrNull(listSplit$default);
                    if (str3 == null) {
                        str3 = "";
                    }
                    if (listSplit$default.size() > 1) {
                        str4 = (String) CollectionsKt.last(listSplit$default);
                    } else {
                        str4 = "";
                    }
                    SettingsRepository settingsRepository3 = this.settingsRepository;
                    AppSetting appSetting3 = AppSetting.AUTO_SAVE_CONTACTS_SUFFIX;
                    anonymousClass1.L$0 = str2;
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(customer);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(listSplit$default);
                    anonymousClass1.L$3 = str3;
                    anonymousClass1.L$4 = str4;
                    anonymousClass1.label = 3;
                    setting = settingsRepository3.getSetting(appSetting3, anonymousClass1);
                    if (setting != coroutine_suspended) {
                        String str11 = str4;
                        customer2 = customer;
                        setting2 = setting;
                        str5 = str3;
                        str6 = str2;
                        str7 = str11;
                        string = StringsKt.trim((CharSequence) setting2).toString();
                        if (StringsKt.isBlank(string)) {
                            string = "Bingwa";
                        }
                        str8 = string;
                        string2 = StringsKt.trim((CharSequence) (str5 + ServerSentEventKt.SPACE + str7 + ServerSentEventKt.SPACE + str8)).toString();
                        zSaveContact = saveContact(str6, string2);
                        if (zSaveContact) {
                            CustomerRepository customerRepository5 = this.customerRepository;
                            anonymousClass1.L$0 = str6;
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(customer2);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(listSplit$default);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str7);
                            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(str8);
                            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(string2);
                            anonymousClass1.Z$0 = zSaveContact;
                            anonymousClass1.label = 4;
                        }
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            } catch (Exception unused) {
            }
        } catch (CustomerAlreadySavedInPhoneBookException e3) {
            e = e3;
        } catch (SecurityException e4) {
            e = e4;
        }
    }

    private final boolean saveContact(String phone, String customerName) throws RemoteException, CustomerAlreadySavedInPhoneBookException, OperationApplicationException {
        if (isNumberInContacts(phone)) {
            throw new CustomerAlreadySavedInPhoneBookException(phone);
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", null).withValue("account_name", null).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data1", customerName).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", normalizePhoneNumber(phone)).withValue("data2", 2).build());
        this.context.getContentResolver().applyBatch("com.android.contacts", arrayList);
        return true;
    }

    private final String normalizePhoneNumber(String phone) {
        return new Regex("[^0-9+]").replace(phone, "");
    }

    private final boolean isNumberInContacts(String phoneNumber) {
        Cursor cursorQuery = this.context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(normalizePhoneNumber(phoneNumber))), new String[]{"_id"}, null, null, null);
        if (cursorQuery == null) {
            return false;
        }
        Cursor cursor = cursorQuery;
        try {
            boolean z = cursor.getCount() > 0;
            CloseableKt.closeFinally(cursor, null);
            return z;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }
}
