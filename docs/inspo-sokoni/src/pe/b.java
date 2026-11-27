package pe;

import kotlin.jvm.internal.k;
import lc.q;
import oe.d;
import oe.g;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f14570a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code duplicated, block: B:101:0x00db  */
    /* JADX WARN: Code duplicated, block: B:103:0x00df  */
    /* JADX WARN: Code duplicated, block: B:104:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:162:0x0163  */
    /* JADX WARN: Code duplicated, block: B:164:0x0167  */
    /* JADX WARN: Code duplicated, block: B:167:0x016d  */
    /* JADX WARN: Code duplicated, block: B:169:0x0171  */
    /* JADX WARN: Code duplicated, block: B:170:0x0174  */
    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX WARN: Code duplicated, block: B:241:0x020e  */
    /* JADX WARN: Code duplicated, block: B:243:0x0212  */
    /* JADX WARN: Code duplicated, block: B:246:0x0218  */
    /* JADX WARN: Code duplicated, block: B:248:0x021c  */
    /* JADX WARN: Code duplicated, block: B:249:0x021f  */
    /* JADX WARN: Code duplicated, block: B:262:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:269:0x00da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:0x016c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:288:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x007b  */
    /* JADX WARN: Code duplicated, block: B:54:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x0082 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x0084  */
    /* JADX WARN: Code duplicated, block: B:58:0x0087  */
    /* JADX WARN: Code duplicated, block: B:97:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:99:0x00d8 A[DONT_INVERT] */
    public static final int b(byte[] bArr, int i10) {
        byte b10;
        int i11;
        boolean z10;
        boolean z11;
        int i12;
        int i13;
        boolean z12;
        int i14;
        boolean z13;
        int i15;
        boolean z14;
        int length = bArr.length;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i16 < length) {
            byte b11 = bArr[i16];
            if (b11 >= 0) {
                int i19 = i18 + 1;
                if (i18 == i10) {
                    return i17;
                }
                if (b11 != 10 && b11 != 13) {
                    if (b11 >= 0 && b11 < 32) {
                        z11 = true;
                    } else {
                        if (127 <= b11 && b11 < 160) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                    }
                    if (!z11) {
                    }
                    return -1;
                }
                if (b11 == 65533) {
                    return -1;
                }
                i17 += b11 < 65536 ? 1 : 2;
                i16++;
                while (true) {
                    i18 = i19;
                    if (i16 >= length || (b10 = bArr[i16]) < 0) {
                        break;
                    }
                    i16++;
                    i19 = i18 + 1;
                    if (i18 == i10) {
                        return i17;
                    }
                    if (b10 != 10 && b10 != 13) {
                        if (b10 >= 0 && b10 < 32) {
                            z10 = true;
                        } else {
                            if (127 <= b10 && b10 < 160) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                        }
                        if (!z10) {
                            if (b10 == 65533) {
                                if (b10 < 65536) {
                                    i11 = 1;
                                } else {
                                    i11 = 2;
                                }
                                i17 += i11;
                            }
                        }
                    } else if (b10 == 65533) {
                        if (b10 < 65536) {
                            i11 = 1;
                        } else {
                            i11 = 2;
                        }
                        i17 += i11;
                    }
                    return -1;
                }
            }
            if ((b11 >> 5) == -2) {
                int i20 = i16 + 1;
                if (length <= i20) {
                    if (i18 == i10) {
                        return i17;
                    }
                    return -1;
                }
                byte b12 = bArr[i20];
                if (!((b12 & 192) == 128)) {
                    if (i18 == i10) {
                        return i17;
                    }
                    return -1;
                }
                int i21 = (b12 ^ 3968) ^ (b11 << 6);
                if (i21 < 128) {
                    if (i18 == i10) {
                        return i17;
                    }
                    return -1;
                }
                i12 = i18 + 1;
                if (i18 == i10) {
                    return i17;
                }
                if (i21 != 10 && i21 != 13) {
                    if (i21 >= 0 && i21 < 32) {
                        z14 = true;
                    } else {
                        if (127 <= i21 && i21 < 160) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                    }
                    if (!z14) {
                        if (i21 == 65533) {
                            if (i21 < 65536) {
                                i15 = 1;
                            } else {
                                i15 = 2;
                            }
                            i17 += i15;
                            q qVar = q.f12711a;
                            i16 += 2;
                        }
                    }
                } else if (i21 == 65533) {
                    if (i21 < 65536) {
                        i15 = 1;
                    } else {
                        i15 = 2;
                    }
                    i17 += i15;
                    q qVar2 = q.f12711a;
                    i16 += 2;
                }
                return -1;
            }
            if ((b11 >> 4) == -2) {
                int i22 = i16 + 2;
                if (length <= i22) {
                    if (i18 == i10) {
                        return i17;
                    }
                    return -1;
                }
                byte b13 = bArr[i16 + 1];
                if (!((b13 & 192) == 128)) {
                    if (i18 == i10) {
                        return i17;
                    }
                    return -1;
                }
                byte b14 = bArr[i22];
                if (!((b14 & 192) == 128)) {
                    if (i18 == i10) {
                        return i17;
                    }
                    return -1;
                }
                int i23 = ((b14 ^ (-123008)) ^ (b13 << 6)) ^ (b11 << 12);
                if (i23 < 2048) {
                    if (i18 == i10) {
                        return i17;
                    }
                    return -1;
                }
                if (55296 <= i23 && i23 < 57344) {
                    if (i18 == i10) {
                        return i17;
                    }
                    return -1;
                }
                i12 = i18 + 1;
                if (i18 == i10) {
                    return i17;
                }
                if (i23 != 10 && i23 != 13) {
                    if (i23 >= 0 && i23 < 32) {
                        z13 = true;
                    } else {
                        if (127 <= i23 && i23 < 160) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                    }
                    if (!z13) {
                        if (i23 == 65533) {
                            if (i23 < 65536) {
                                i14 = 1;
                            } else {
                                i14 = 2;
                            }
                            i17 += i14;
                            q qVar3 = q.f12711a;
                            i16 += 3;
                        }
                    }
                } else if (i23 == 65533) {
                    if (i23 < 65536) {
                        i14 = 1;
                    } else {
                        i14 = 2;
                    }
                    i17 += i14;
                    q qVar4 = q.f12711a;
                    i16 += 3;
                }
                return -1;
            }
            if ((b11 >> 3) != -2) {
                if (i18 == i10) {
                    return i17;
                }
                return -1;
            }
            int i24 = i16 + 3;
            if (length <= i24) {
                if (i18 == i10) {
                    return i17;
                }
                return -1;
            }
            byte b15 = bArr[i16 + 1];
            if (!((b15 & 192) == 128)) {
                if (i18 == i10) {
                    return i17;
                }
                return -1;
            }
            byte b16 = bArr[i16 + 2];
            if (!((b16 & 192) == 128)) {
                if (i18 == i10) {
                    return i17;
                }
                return -1;
            }
            byte b17 = bArr[i24];
            if (!((b17 & 192) == 128)) {
                if (i18 == i10) {
                    return i17;
                }
                return -1;
            }
            int i25 = (((b17 ^ 3678080) ^ (b16 << 6)) ^ (b15 << 12)) ^ (b11 << 18);
            if (i25 > 1114111) {
                if (i18 == i10) {
                    return i17;
                }
                return -1;
            }
            if (55296 <= i25 && i25 < 57344) {
                if (i18 == i10) {
                    return i17;
                }
                return -1;
            }
            if (i25 < 65536) {
                if (i18 == i10) {
                    return i17;
                }
                return -1;
            }
            i12 = i18 + 1;
            if (i18 == i10) {
                return i17;
            }
            if (i25 != 10 && i25 != 13) {
                if (i25 >= 0 && i25 < 32) {
                    z12 = true;
                } else {
                    if (127 <= i25 && i25 < 160) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                }
                if (!z12) {
                    if (i25 == 65533) {
                        if (i25 < 65536) {
                            i13 = 1;
                        } else {
                            i13 = 2;
                        }
                        i17 += i13;
                        q qVar5 = q.f12711a;
                        i16 += 4;
                    }
                }
            } else if (i25 == 65533) {
                if (i25 < 65536) {
                    i13 = 1;
                } else {
                    i13 = 2;
                }
                i17 += i13;
                q qVar6 = q.f12711a;
                i16 += 4;
            }
            return -1;
            i18 = i12;
        }
        return i17;
    }

    public static final void c(g gVar, d buffer, int i10, int i11) {
        k.e(gVar, "<this>");
        k.e(buffer, "buffer");
        buffer.o0(gVar.l(), i10, i11);
    }

    public static final char[] d() {
        return f14570a;
    }
}
