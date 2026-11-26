package com.example.bingwahybrid.domain.model;

import com.example.bingwahybrid.domain.enums.RescheduleMode;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RescheduleInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/example/bingwahybrid/domain/model/RescheduleInfo;", "", "parentTransactionId", "Ljava/util/UUID;", "time", "", "rescheduleMode", "Lcom/example/bingwahybrid/domain/enums/RescheduleMode;", "<init>", "(Ljava/util/UUID;JLcom/example/bingwahybrid/domain/enums/RescheduleMode;)V", "getParentTransactionId", "()Ljava/util/UUID;", "getTime", "()J", "getRescheduleMode", "()Lcom/example/bingwahybrid/domain/enums/RescheduleMode;", "toJson", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RescheduleInfo {
    public static final int $stable = 8;
    private final UUID parentTransactionId;
    private final RescheduleMode rescheduleMode;
    private final long time;

    public static /* synthetic */ RescheduleInfo copy$default(RescheduleInfo rescheduleInfo, UUID uuid, long j, RescheduleMode rescheduleMode, int i, Object obj) {
        if ((i & 1) != 0) {
            uuid = rescheduleInfo.parentTransactionId;
        }
        if ((i & 2) != 0) {
            j = rescheduleInfo.time;
        }
        if ((i & 4) != 0) {
            rescheduleMode = rescheduleInfo.rescheduleMode;
        }
        return rescheduleInfo.copy(uuid, j, rescheduleMode);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UUID getParentTransactionId() {
        return this.parentTransactionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RescheduleMode getRescheduleMode() {
        return this.rescheduleMode;
    }

    public final RescheduleInfo copy(UUID parentTransactionId, long time, RescheduleMode rescheduleMode) {
        Intrinsics.checkNotNullParameter(rescheduleMode, "rescheduleMode");
        return new RescheduleInfo(parentTransactionId, time, rescheduleMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RescheduleInfo)) {
            return false;
        }
        RescheduleInfo rescheduleInfo = (RescheduleInfo) other;
        return Intrinsics.areEqual(this.parentTransactionId, rescheduleInfo.parentTransactionId) && this.time == rescheduleInfo.time && this.rescheduleMode == rescheduleInfo.rescheduleMode;
    }

    public int hashCode() {
        UUID uuid = this.parentTransactionId;
        return ((((uuid == null ? 0 : uuid.hashCode()) * 31) + Long.hashCode(this.time)) * 31) + this.rescheduleMode.hashCode();
    }

    public String toString() {
        return "RescheduleInfo(parentTransactionId=" + this.parentTransactionId + ", time=" + this.time + ", rescheduleMode=" + this.rescheduleMode + ")";
    }

    public RescheduleInfo(UUID uuid, long j, RescheduleMode rescheduleMode) {
        Intrinsics.checkNotNullParameter(rescheduleMode, "rescheduleMode");
        this.parentTransactionId = uuid;
        this.time = j;
        this.rescheduleMode = rescheduleMode;
    }

    public final UUID getParentTransactionId() {
        return this.parentTransactionId;
    }

    public final long getTime() {
        return this.time;
    }

    public /* synthetic */ RescheduleInfo(UUID uuid, long j, RescheduleMode rescheduleMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : uuid, j, (i & 4) != 0 ? RescheduleMode.ONCE : rescheduleMode);
    }

    public final RescheduleMode getRescheduleMode() {
        return this.rescheduleMode;
    }

    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("parentTransactionId", this.parentTransactionId);
        jSONObject.put("time", this.time);
        jSONObject.put("rescheduleMode", this.rescheduleMode.name());
        return jSONObject;
    }
}
