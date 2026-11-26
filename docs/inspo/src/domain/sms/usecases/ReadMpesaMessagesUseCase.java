package com.example.bingwahybrid.domain.sms.usecases;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.example.bingwahybrid.domain.sms.model.RawSmsMessage;
import com.example.bingwahybrid.domain.sms.model.SmsSender;
import com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReadMpesaMessagesUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/usecases/ReadMpesaMessagesUseCase;", "", "context", "Landroid/content/Context;", "subscriptionIdFetcherUseCase", "Lcom/example/bingwahybrid/domain/usecase/SubscriptionIdFetcherUseCase;", "<init>", "(Landroid/content/Context;Lcom/example/bingwahybrid/domain/usecase/SubscriptionIdFetcherUseCase;)V", "invoke", "", "Lcom/example/bingwahybrid/domain/sms/model/RawSmsMessage;", "bufferSize", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReadMpesaMessagesUseCase {
    public static final int $stable = 8;
    private final Context context;
    private final SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase;

    public ReadMpesaMessagesUseCase(Context context, SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subscriptionIdFetcherUseCase, "subscriptionIdFetcherUseCase");
        this.context = context;
        this.subscriptionIdFetcherUseCase = subscriptionIdFetcherUseCase;
    }

    public static /* synthetic */ List invoke$default(ReadMpesaMessagesUseCase readMpesaMessagesUseCase, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 15;
        }
        return readMpesaMessagesUseCase.invoke(i);
    }

    public final List<RawSmsMessage> invoke(int bufferSize) {
        String[] strArr = {SmsSender.MPESA};
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = this.context.getContentResolver().query(Uri.parse("content://sms/inbox"), new String[]{"body", "address", "date", "sub_id"}, "address = ?", strArr, "date DESC LIMIT " + bufferSize);
        if (cursorQuery == null) {
            Log.e("ReadMpesaMessagesUseCase", "Cursor is null");
            return CollectionsKt.emptyList();
        }
        Cursor cursor = cursorQuery;
        try {
            Cursor cursor2 = cursor;
            int columnIndex = cursor2.getColumnIndex("body");
            int columnIndex2 = cursor2.getColumnIndex("address");
            int columnIndex3 = cursor2.getColumnIndex("date");
            int columnIndex4 = cursor2.getColumnIndex("sub_id");
            if (columnIndex != -1 && columnIndex4 != -1) {
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndex);
                    String string2 = cursorQuery.getString(columnIndex2);
                    long j = cursorQuery.getLong(columnIndex3);
                    int slotFromSubId = this.subscriptionIdFetcherUseCase.getSlotFromSubId(cursorQuery.getInt(columnIndex4));
                    Intrinsics.checkNotNull(string);
                    Intrinsics.checkNotNull(string2);
                    arrayList.add(new RawSmsMessage(string, string2, slotFromSubId, j));
                }
                Unit unit = Unit.INSTANCE;
            } else {
                Integer.valueOf(Log.d("ReadMpesaMessagesUseCase", "required parameter is null. Cannot query messages"));
            }
            CloseableKt.closeFinally(cursor, null);
            return arrayList;
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
