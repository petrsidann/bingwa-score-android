package com.example.bingwahybrid.domain.devices.repository;

import com.example.bingwahybrid.domain.devices.model.LinkedDevice;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: LinkedDevicesRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/devices/repository/LinkedDevicesRepository;", "", "getAllLinkedDevices", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/bingwahybrid/domain/devices/model/LinkedDevice;", "addLinkedDevice", "", "device", "deleteLinkedDevice", "deviceId", "", "updateServerUrl", "serverUrl", "getDevice", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface LinkedDevicesRepository {
    void addLinkedDevice(LinkedDevice device);

    void deleteLinkedDevice(String deviceId);

    Flow<List<LinkedDevice>> getAllLinkedDevices();

    Object getDevice(String str, Continuation<? super LinkedDevice> continuation);

    void updateServerUrl(String deviceId, String serverUrl);
}
