package com.example.bingwahybrid.domain.devices.repository;

import com.example.bingwahybrid.domain.devices.model.CurrentDevice;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: CurrentDeviceRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/devices/repository/CurrentDeviceRepository;", "", "currentDevice", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/bingwahybrid/domain/devices/model/CurrentDevice;", "getCurrentDevice", "()Lkotlinx/coroutines/flow/StateFlow;", "detectCurrentDevice", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CurrentDeviceRepository {
    void detectCurrentDevice();

    StateFlow<CurrentDevice> getCurrentDevice();
}
