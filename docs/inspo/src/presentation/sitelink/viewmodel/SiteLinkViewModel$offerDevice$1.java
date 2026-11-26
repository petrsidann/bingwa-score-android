package com.example.bingwahybrid.presentation.sitelink.viewmodel;

import com.example.bingwahybrid.domain.devices.model.Device;
import com.example.bingwahybrid.domain.offers.model.Offer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SiteLinkViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n"}, d2 = {"<anonymous>", "", "Ljava/util/UUID;", "Lcom/example/bingwahybrid/domain/devices/model/Device;", "offers", "", "Lcom/example/bingwahybrid/domain/offers/model/Offer;", "devices"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel$offerDevice$1", f = "SiteLinkViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SiteLinkViewModel$offerDevice$1 extends SuspendLambda implements Function3<List<? extends Offer>, List<? extends Device>, Continuation<? super Map<UUID, ? extends Device>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    SiteLinkViewModel$offerDevice$1(Continuation<? super SiteLinkViewModel$offerDevice$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends Offer> list, List<? extends Device> list2, Continuation<? super Map<UUID, ? extends Device>> continuation) {
        return invoke2((List<Offer>) list, (List<Device>) list2, (Continuation<? super Map<UUID, Device>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<Offer> list, List<Device> list2, Continuation<? super Map<UUID, Device>> continuation) {
        SiteLinkViewModel$offerDevice$1 siteLinkViewModel$offerDevice$1 = new SiteLinkViewModel$offerDevice$1(continuation);
        siteLinkViewModel$offerDevice$1.L$0 = list;
        siteLinkViewModel$offerDevice$1.L$1 = list2;
        return siteLinkViewModel$offerDevice$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object next;
        String connectId;
        String relayDevice;
        List<Offer> list = (List) this.L$0;
        List list2 = (List) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList();
        for (Offer offer : list) {
            Iterator it = list2.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                connectId = ((Device) next).getConnectId();
                relayDevice = offer.getRelayDevice();
                if (relayDevice == null || !Boxing.boxBoolean(!StringsKt.isBlank(relayDevice)).booleanValue()) {
                    relayDevice = null;
                }
            } while (!Intrinsics.areEqual(connectId, relayDevice));
            Device device = (Device) next;
            Pair pair = device != null ? TuplesKt.to(offer.getId(), device) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
