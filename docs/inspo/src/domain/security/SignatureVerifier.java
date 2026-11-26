package com.example.bingwahybrid.domain.security;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: SignatureVerifier.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/security/SignatureVerifier;", "", "verify", "", ExifInterface.GPS_DIRECTION_TRUE, "data", "signature", "", "publicKey", "", "(Ljava/lang/Object;Ljava/lang/String;[B)Z", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SignatureVerifier {
    <T> boolean verify(T data, String signature, byte[] publicKey);
}
