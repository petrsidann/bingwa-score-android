package com.example.bingwahybrid.domain.model;

import androidx.autofill.HintConstants;
import com.example.bingwahybrid.domain.offers.model.Offer;
import io.ktor.http.ContentType;
import io.ktor.sse.ServerSentEventKt;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AutoReplyPlaceHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00102\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder;", "", "key", "", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getDescription", "FirstName", "Surname", "MpesaCode", "Amount", "OfferName", "OfferPrice", "Companion", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$Amount;", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$FirstName;", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$MpesaCode;", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$OfferName;", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$OfferPrice;", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$Surname;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AutoReplyPlaceHolder {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String description;
    private final String key;

    public /* synthetic */ AutoReplyPlaceHolder(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    /* JADX INFO: compiled from: AutoReplyPlaceHolder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$FirstName;", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FirstName extends AutoReplyPlaceHolder {
        public static final int $stable = 0;
        public static final FirstName INSTANCE = new FirstName();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FirstName)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 102550461;
        }

        public String toString() {
            return "FirstName";
        }

        private FirstName() {
            super("<firstName>", "Customer's first name", null);
        }
    }

    private AutoReplyPlaceHolder(String str, String str2) {
        this.key = str;
        this.description = str2;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: compiled from: AutoReplyPlaceHolder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$Surname;", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Surname extends AutoReplyPlaceHolder {
        public static final int $stable = 0;
        public static final Surname INSTANCE = new Surname();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Surname)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 238592957;
        }

        public String toString() {
            return "Surname";
        }

        private Surname() {
            super("<surname>", "Customer's surname", null);
        }
    }

    /* JADX INFO: compiled from: AutoReplyPlaceHolder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$MpesaCode;", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MpesaCode extends AutoReplyPlaceHolder {
        public static final int $stable = 0;
        public static final MpesaCode INSTANCE = new MpesaCode();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MpesaCode)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 979534175;
        }

        public String toString() {
            return "MpesaCode";
        }

        private MpesaCode() {
            super("<mpesaCode>", "M-Pesa transaction code", null);
        }
    }

    /* JADX INFO: compiled from: AutoReplyPlaceHolder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$Amount;", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Amount extends AutoReplyPlaceHolder {
        public static final int $stable = 0;
        public static final Amount INSTANCE = new Amount();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Amount)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -238003914;
        }

        public String toString() {
            return "Amount";
        }

        private Amount() {
            super("<amount>", "Amount paid by the customer", null);
        }
    }

    /* JADX INFO: compiled from: AutoReplyPlaceHolder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$OfferName;", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OfferName extends AutoReplyPlaceHolder {
        public static final int $stable = 0;
        public static final OfferName INSTANCE = new OfferName();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OfferName)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1914068329;
        }

        public String toString() {
            return "OfferName";
        }

        private OfferName() {
            super("<offerName>", "Name you have given this offer amount", null);
        }
    }

    /* JADX INFO: compiled from: AutoReplyPlaceHolder.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$OfferPrice;", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OfferPrice extends AutoReplyPlaceHolder {
        public static final int $stable = 0;
        public static final OfferPrice INSTANCE = new OfferPrice();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OfferPrice)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -791074261;
        }

        public String toString() {
            return "OfferPrice";
        }

        private OfferPrice() {
            super("<offerPrice>", "Actual price for current offer", null);
        }
    }

    /* JADX INFO: compiled from: AutoReplyPlaceHolder.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\"\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fJ3\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052#\u0010\u000e\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0015\u001a\u00020\u0016J(\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fH\u0002J$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fH\u0002J$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fH\u0002J$\u0010\u001a\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fH\u0002J$\u0010\u001b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fH\u0002J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J\f\u0010!\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010\"\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001d¨\u0006%"}, d2 = {"Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder$Companion;", "", "<init>", "()V", "replacePlaceholders", "", "message", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "renderTemplate", "template", "values", "", "templateString", "builder", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "buildValueMap", "buildValueMapFromCustomer", "customer", "Lcom/example/bingwahybrid/domain/model/Customer;", "normalizeKeys", "processOptionalBlocks", "processPlaceholdersWithDefaults", "processSimplePlaceholders", "processLegacyPlaceholders", "extractPlaceholderKeys", "", ContentType.Text.TYPE, "normalizeKey", "key", "toCamelCase", "toSnakeCase", "allPlaceHolders", "Lcom/example/bingwahybrid/domain/model/AutoReplyPlaceHolder;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String replacePlaceholders(String message, Transaction transaction) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            return renderTemplate(message, buildValueMap(transaction));
        }

        public final String renderTemplate(String template, Map<String, String> values) {
            Intrinsics.checkNotNullParameter(template, "template");
            Intrinsics.checkNotNullParameter(values, "values");
            Map<String, String> mapNormalizeKeys = normalizeKeys(values);
            return StringsKt.trim((CharSequence) processLegacyPlaceholders(processSimplePlaceholders(processPlaceholdersWithDefaults(processOptionalBlocks(template, mapNormalizeKeys), mapNormalizeKeys), mapNormalizeKeys), mapNormalizeKeys)).toString();
        }

        public final String template(String templateString, Function1<? super Map<String, String>, Unit> builder) {
            Intrinsics.checkNotNullParameter(templateString, "templateString");
            Intrinsics.checkNotNullParameter(builder, "builder");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            builder.invoke(linkedHashMap);
            return renderTemplate(templateString, linkedHashMap);
        }

        public final Map<String, String> buildValueMap(Transaction transaction) {
            String name;
            String name2;
            String string;
            String string2;
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            Customer customer = transaction.getCustomer();
            List listSplit$default = StringsKt.split$default((CharSequence) customer.getName(), new String[]{ServerSentEventKt.SPACE}, false, 0, 6, (Object) null);
            String str = (String) CollectionsKt.firstOrNull(listSplit$default);
            String str2 = "";
            if (str == null) {
                str = "";
            }
            String str3 = (String) CollectionsKt.lastOrNull(listSplit$default);
            if (str3 == null) {
                str3 = "";
            }
            Pair[] pairArr = new Pair[11];
            pairArr[0] = TuplesKt.to("firstName", str);
            pairArr[1] = TuplesKt.to("first_name", str);
            pairArr[2] = TuplesKt.to("surname", str3);
            String mpesaCode = transaction.getMpesaCode();
            if (mpesaCode == null) {
                mpesaCode = "";
            }
            pairArr[3] = TuplesKt.to("mpesaCode", mpesaCode);
            String mpesaCode2 = transaction.getMpesaCode();
            if (mpesaCode2 == null) {
                mpesaCode2 = "";
            }
            pairArr[4] = TuplesKt.to("mpesa_code", mpesaCode2);
            pairArr[5] = TuplesKt.to("amount", String.valueOf(transaction.getAmount()));
            Offer offer = transaction.getOffer();
            if (offer == null || (name = offer.getName()) == null) {
                name = "";
            }
            pairArr[6] = TuplesKt.to("offerName", name);
            Offer offer2 = transaction.getOffer();
            if (offer2 == null || (name2 = offer2.getName()) == null) {
                name2 = "";
            }
            pairArr[7] = TuplesKt.to("offer_name", name2);
            Offer offer3 = transaction.getOffer();
            if (offer3 == null || (string = Integer.valueOf(offer3.getPrice()).toString()) == null) {
                string = "";
            }
            pairArr[8] = TuplesKt.to("offerPrice", string);
            Offer offer4 = transaction.getOffer();
            if (offer4 != null && (string2 = Integer.valueOf(offer4.getPrice()).toString()) != null) {
                str2 = string2;
            }
            pairArr[9] = TuplesKt.to("offer_price", str2);
            pairArr[10] = TuplesKt.to(HintConstants.AUTOFILL_HINT_PHONE, customer.getPhone());
            return MapsKt.mapOf(pairArr);
        }

        public final Map<String, String> buildValueMapFromCustomer(Customer customer) {
            Intrinsics.checkNotNullParameter(customer, "customer");
            List listSplit$default = StringsKt.split$default((CharSequence) customer.getName(), new String[]{ServerSentEventKt.SPACE}, false, 0, 6, (Object) null);
            String str = (String) CollectionsKt.firstOrNull(listSplit$default);
            if (str == null) {
                str = "";
            }
            String str2 = (String) CollectionsKt.lastOrNull(listSplit$default);
            return MapsKt.mapOf(TuplesKt.to("firstName", str), TuplesKt.to("first_name", str), TuplesKt.to("surname", str2 != null ? str2 : ""), TuplesKt.to(HintConstants.AUTOFILL_HINT_PHONE, customer.getPhone()));
        }

        private final Map<String, String> normalizeKeys(Map<String, String> values) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, String> entry : values.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                linkedHashMap.put(key, value);
                String camelCase = AutoReplyPlaceHolder.INSTANCE.toCamelCase(key);
                String snakeCase = AutoReplyPlaceHolder.INSTANCE.toSnakeCase(key);
                if (!Intrinsics.areEqual(camelCase, key)) {
                    linkedHashMap.put(camelCase, value);
                }
                if (!Intrinsics.areEqual(snakeCase, key)) {
                    linkedHashMap.put(snakeCase, value);
                }
            }
            return linkedHashMap;
        }

        private final String processOptionalBlocks(String template, final Map<String, String> values) {
            return new Regex("\\{([^}]+)\\}").replace(template, new Function1() { // from class: com.example.bingwahybrid.domain.model.AutoReplyPlaceHolder$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoReplyPlaceHolder.Companion.processOptionalBlocks$lambda$2(values, (MatchResult) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence processOptionalBlocks$lambda$2(Map map, MatchResult matchResult) {
            String str;
            Intrinsics.checkNotNullParameter(matchResult, "matchResult");
            String str2 = matchResult.getGroupValues().get(1);
            List<String> listExtractPlaceholderKeys = AutoReplyPlaceHolder.INSTANCE.extractPlaceholderKeys(str2);
            if (!(listExtractPlaceholderKeys instanceof Collection) || !listExtractPlaceholderKeys.isEmpty()) {
                for (String str3 : listExtractPlaceholderKeys) {
                    if (!map.containsKey(str3) || (str = (String) map.get(str3)) == null || !(!StringsKt.isBlank(str))) {
                        return "";
                    }
                }
            }
            return str2;
        }

        private final String processPlaceholdersWithDefaults(String template, final Map<String, String> values) {
            return new Regex("@(\\w+)\\?='([^']+)'").replace(template, new Function1() { // from class: com.example.bingwahybrid.domain.model.AutoReplyPlaceHolder$Companion$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoReplyPlaceHolder.Companion.processPlaceholdersWithDefaults$lambda$4(values, (MatchResult) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence processPlaceholdersWithDefaults$lambda$4(Map map, MatchResult matchResult) {
            Intrinsics.checkNotNullParameter(matchResult, "matchResult");
            String str = matchResult.getGroupValues().get(1);
            String str2 = matchResult.getGroupValues().get(2);
            String str3 = (String) map.get(AutoReplyPlaceHolder.INSTANCE.normalizeKey(str));
            if (str3 != null) {
                if (StringsKt.isBlank(str3)) {
                    str3 = null;
                }
                if (str3 != null) {
                    return str3;
                }
            }
            return str2;
        }

        private final String processSimplePlaceholders(String template, final Map<String, String> values) {
            return new Regex("@(\\w+)(?!\\?=')").replace(template, new Function1() { // from class: com.example.bingwahybrid.domain.model.AutoReplyPlaceHolder$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoReplyPlaceHolder.Companion.processSimplePlaceholders$lambda$6(values, (MatchResult) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence processSimplePlaceholders$lambda$6(Map map, MatchResult matchResult) {
            Intrinsics.checkNotNullParameter(matchResult, "matchResult");
            String str = matchResult.getGroupValues().get(1);
            String str2 = (String) map.get(AutoReplyPlaceHolder.INSTANCE.normalizeKey(str));
            if (str2 != null) {
                if (StringsKt.isBlank(str2)) {
                    str2 = null;
                }
                if (str2 != null) {
                    return str2;
                }
            }
            return "@" + str;
        }

        private final String processLegacyPlaceholders(String template, Map<String, String> values) {
            Pair[] pairArr = new Pair[6];
            String str = values.get("firstName");
            String str2 = "";
            if (str == null && (str = values.get("first_name")) == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.to("<firstName>", str);
            String str3 = values.get("surname");
            if (str3 == null) {
                str3 = "";
            }
            pairArr[1] = TuplesKt.to("<surname>", str3);
            String str4 = values.get("mpesaCode");
            if (str4 == null && (str4 = values.get("mpesa_code")) == null) {
                str4 = "";
            }
            pairArr[2] = TuplesKt.to("<mpesaCode>", str4);
            String str5 = values.get("amount");
            if (str5 == null) {
                str5 = "";
            }
            pairArr[3] = TuplesKt.to("<amount>", str5);
            String str6 = values.get("offerName");
            if (str6 == null && (str6 = values.get("offer_name")) == null) {
                str6 = "";
            }
            pairArr[4] = TuplesKt.to("<offerName>", str6);
            String str7 = values.get("offerPrice");
            if (str7 == null) {
                String str8 = values.get("offer_price");
                if (str8 != null) {
                    str2 = str8;
                }
            } else {
                str2 = str7;
            }
            pairArr[5] = TuplesKt.to("<offerPrice>", str2);
            String strReplace$default = template;
            for (Map.Entry entry : MapsKt.mapOf(pairArr).entrySet()) {
                strReplace$default = StringsKt.replace$default(strReplace$default, (String) entry.getKey(), (String) entry.getValue(), false, 4, (Object) null);
            }
            return strReplace$default;
        }

        private final List<String> extractPlaceholderKeys(String text) {
            return SequencesKt.toList(SequencesKt.map(SequencesKt.map(Regex.findAll$default(new Regex("@(\\w+)(?:\\?='[^']+')?"), text, 0, 2, null), new Function1() { // from class: com.example.bingwahybrid.domain.model.AutoReplyPlaceHolder$Companion$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoReplyPlaceHolder.Companion.extractPlaceholderKeys$lambda$8((MatchResult) obj);
                }
            }), new Function1() { // from class: com.example.bingwahybrid.domain.model.AutoReplyPlaceHolder$Companion$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoReplyPlaceHolder.Companion.extractPlaceholderKeys$lambda$9((String) obj);
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String extractPlaceholderKeys$lambda$8(MatchResult it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getGroupValues().get(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String extractPlaceholderKeys$lambda$9(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return AutoReplyPlaceHolder.INSTANCE.normalizeKey(it);
        }

        private final String normalizeKey(String key) {
            String str = key;
            if (StringsKt.contains$default((CharSequence) str, '_', false, 2, (Object) null) || !Character.isUpperCase(StringsKt.first(str)) || str.length() <= 0) {
                return key;
            }
            StringBuilder sb = new StringBuilder();
            String strValueOf = String.valueOf(key.charAt(0));
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            StringBuilder sbAppend = sb.append((Object) lowerCase);
            String strSubstring = key.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return sbAppend.append(strSubstring).toString();
        }

        private final String toCamelCase(String str) {
            String strJoinToString$default = CollectionsKt.joinToString$default(StringsKt.split$default((CharSequence) str, new char[]{'_'}, false, 0, 6, (Object) null), "", null, null, 0, null, new Function1() { // from class: com.example.bingwahybrid.domain.model.AutoReplyPlaceHolder$Companion$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoReplyPlaceHolder.Companion.toCamelCase$lambda$12((String) obj);
                }
            }, 30, null);
            if (strJoinToString$default.length() <= 0) {
                return strJoinToString$default;
            }
            StringBuilder sb = new StringBuilder();
            String strValueOf = String.valueOf(strJoinToString$default.charAt(0));
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            StringBuilder sbAppend = sb.append((Object) lowerCase);
            String strSubstring = strJoinToString$default.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return sbAppend.append(strSubstring).toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence toCamelCase$lambda$12(String part) {
            Intrinsics.checkNotNullParameter(part, "part");
            if (part.length() > 0) {
                StringBuilder sb = new StringBuilder();
                char cCharAt = part.charAt(0);
                StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(cCharAt) ? CharsKt.titlecase(cCharAt) : String.valueOf(cCharAt)));
                String strSubstring = part.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                part = sbAppend.append(strSubstring).toString();
            }
            return part;
        }

        private final String toSnakeCase(String str) {
            String lowerCase = new Regex("([a-z])([A-Z])").replace(str, new Function1() { // from class: com.example.bingwahybrid.domain.model.AutoReplyPlaceHolder$Companion$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AutoReplyPlaceHolder.Companion.toSnakeCase$lambda$14((MatchResult) obj);
                }
            }).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence toSnakeCase$lambda$14(MatchResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            String str = result.getGroupValues().get(1);
            String lowerCase = result.getGroupValues().get(2).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return ((Object) str) + "_" + lowerCase;
        }

        public final List<AutoReplyPlaceHolder> allPlaceHolders() {
            return CollectionsKt.listOf((Object[]) new AutoReplyPlaceHolder[]{FirstName.INSTANCE, Surname.INSTANCE, MpesaCode.INSTANCE, Amount.INSTANCE, OfferName.INSTANCE, OfferPrice.INSTANCE});
        }
    }
}
