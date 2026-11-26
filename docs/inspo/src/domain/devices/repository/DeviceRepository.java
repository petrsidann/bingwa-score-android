package com.example.bingwahybrid.domain.devices.repository;

import com.example.bingwahybrid.domain.devices.model.Device;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: DeviceRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000bJ\n\u0010\f\u001a\u0004\u0018\u00010\tH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/devices/repository/DeviceRepository;", "", "getMyDevices", "", "Lcom/example/bingwahybrid/domain/devices/model/Device;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeviceToken", "", "connectId", "", "token", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyFcmToken", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeviceRepository {
    Object getMyDevices(Continuation<? super List<Device>> continuation);

    String getMyFcmToken();

    Object updateDeviceToken(String str, String str2, Continuation<? super Unit> continuation);
}
