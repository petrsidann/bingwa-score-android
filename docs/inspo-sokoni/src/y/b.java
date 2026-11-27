package y;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(f fVar, x.d dVar, int i10) {
        int i11;
        c[] cVarArr;
        int i12;
        if (i10 == 0) {
            i11 = fVar.G0;
            cVarArr = fVar.J0;
            i12 = 0;
        } else {
            i11 = fVar.H0;
            cVarArr = fVar.I0;
            i12 = 2;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            c cVar = cVarArr[i13];
            cVar.a();
            b(fVar, dVar, i10, i12, cVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0168  */
    /* JADX WARN: Code duplicated, block: B:102:0x0189  */
    /* JADX WARN: Code duplicated, block: B:173:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:189:0x030c  */
    /* JADX WARN: Code duplicated, block: B:190:0x031e  */
    /* JADX WARN: Code duplicated, block: B:192:0x0326  */
    /* JADX WARN: Code duplicated, block: B:193:0x0329  */
    /* JADX WARN: Code duplicated, block: B:196:0x0333  */
    /* JADX WARN: Code duplicated, block: B:198:0x033a  */
    /* JADX WARN: Code duplicated, block: B:255:0x0400  */
    /* JADX WARN: Code duplicated, block: B:258:0x0412  */
    /* JADX WARN: Code duplicated, block: B:259:0x0415  */
    /* JADX WARN: Code duplicated, block: B:25:0x003e A[PHI: r8 r15
  0x003e: PHI (r8v3 boolean) = (r8v1 boolean), (r8v45 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
  0x003e: PHI (r15v3 boolean) = (r15v1 boolean), (r15v35 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:265:0x0435  */
    /* JADX WARN: Code duplicated, block: B:26:0x0040 A[PHI: r8 r15
  0x0040: PHI (r8v43 boolean) = (r8v1 boolean), (r8v45 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]
  0x0040: PHI (r15v33 boolean) = (r15v1 boolean), (r15v35 boolean) binds: [B:24:0x003c, B:15:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x015f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0162  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [x.d] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29, types: [x.i] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [y.e] */
    public static void b(f fVar, x.d dVar, int i10, int i11, c cVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        int i12;
        int i13;
        d dVar2;
        x.i iVar;
        d dVar3;
        x.i iVar2;
        int i14;
        d dVar4;
        int iC;
        int i15;
        int iC2;
        d dVar5;
        x.i iVar3;
        x.i iVar4;
        int size;
        d dVar6;
        int i16;
        e eVar = cVar.f19116a;
        e eVar2 = cVar.f19118c;
        e eVar3 = cVar.f19117b;
        e eVar4 = cVar.f19119d;
        e eVar5 = cVar.f19120e;
        float f10 = cVar.f19126k;
        boolean z13 = fVar.M[i10] == e.b.WRAP_CONTENT;
        if (i10 == 0) {
            int i17 = eVar5.f19182m0;
            z10 = i17 == 0;
            z11 = i17 == 1;
            if (i17 == 2) {
                z12 = true;
            } else {
                z12 = false;
            }
        } else {
            int i18 = eVar5.f19184n0;
            z10 = i18 == 0;
            z11 = i18 == 1;
            if (i18 == 2) {
                z12 = true;
            } else {
                z12 = false;
            }
        }
        boolean z14 = z11;
        boolean z15 = false;
        boolean z16 = z10;
        ?? r10 = eVar;
        while (true) {
            Object obj = null;
            if (z15) {
                break;
            }
            d dVar7 = r10.J[i11];
            int i19 = z12 ? 1 : 4;
            int iC3 = dVar7.c();
            e.b bVar = r10.M[i10];
            float f11 = f10;
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            boolean z17 = bVar == bVar2 && r10.f19183n[i10] == 0;
            d dVar8 = dVar7.f19141d;
            if (dVar8 != null && r10 != eVar) {
                iC3 += dVar8.c();
            }
            int i20 = iC3;
            if (z12 && r10 != eVar && r10 != eVar3) {
                i19 = 5;
            }
            d dVar9 = dVar7.f19141d;
            e eVar6 = eVar5;
            if (dVar9 != null) {
                if (r10 == eVar3) {
                    dVar.h(dVar7.f19144g, dVar9.f19144g, i20, 6);
                } else {
                    dVar.h(dVar7.f19144g, dVar9.f19144g, i20, 8);
                }
                dVar.e(dVar7.f19144g, dVar7.f19141d.f19144g, i20, (!z17 || z12) ? i19 : 5);
            } else {
                eVar = eVar;
            }
            if (z13) {
                if (r10.O() == 8 || r10.M[i10] != bVar2) {
                    i16 = 0;
                } else {
                    d[] dVarArr = r10.J;
                    i16 = 0;
                    dVar.h(dVarArr[i11 + 1].f19144g, dVarArr[i11].f19144g, 0, 5);
                }
                dVar.h(r10.J[i11].f19144g, fVar.J[i11].f19144g, i16, 8);
            }
            d dVar10 = r10.J[i11 + 1].f19141d;
            if (dVar10 != null) {
                e eVar7 = dVar10.f19139b;
                d dVar11 = eVar7.J[i11].f19141d;
                if (dVar11 != null && dVar11.f19139b == r10) {
                    obj = eVar7;
                }
            }
            if (obj != null) {
                r10 = obj;
                z15 = z15;
            } else {
                z15 = true;
            }
            z16 = z16;
            f10 = f11;
            eVar5 = eVar6;
            eVar = eVar;
            r10 = r10;
        }
        e eVar8 = eVar5;
        float f12 = f10;
        e eVar9 = eVar;
        boolean z18 = z16;
        if (eVar4 != null) {
            int i21 = i11 + 1;
            if (eVar2.J[i21].f19141d != null) {
                d dVar12 = eVar4.J[i21];
                if ((eVar4.M[i10] == e.b.MATCH_CONSTRAINT && eVar4.f19183n[i10] == 0) && !z12) {
                    d dVar13 = dVar12.f19141d;
                    if (dVar13.f19139b == fVar) {
                        dVar.e(dVar12.f19144g, dVar13.f19144g, -dVar12.c(), 5);
                    } else if (z12) {
                        dVar6 = dVar12.f19141d;
                        if (dVar6.f19139b == fVar) {
                            dVar.e(dVar12.f19144g, dVar6.f19144g, -dVar12.c(), 4);
                        }
                    }
                } else if (z12) {
                    dVar6 = dVar12.f19141d;
                    if (dVar6.f19139b == fVar) {
                        dVar.e(dVar12.f19144g, dVar6.f19144g, -dVar12.c(), 4);
                    }
                }
                dVar.j(dVar12.f19144g, eVar2.J[i21].f19141d.f19144g, -dVar12.c(), 6);
            }
        }
        if (z13) {
            int i22 = i11 + 1;
            x.i iVar5 = fVar.J[i22].f19144g;
            d dVar14 = eVar2.J[i22];
            dVar.h(iVar5, dVar14.f19144g, dVar14.c(), 8);
        }
        ArrayList<e> arrayList = cVar.f19123h;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f13 = (!cVar.f19133r || cVar.f19135t) ? f12 : cVar.f19125j;
            float f14 = 0.0f;
            float f15 = 0.0f;
            e eVar10 = null;
            int i23 = 0;
            while (i23 < size) {
                e eVar11 = arrayList.get(i23);
                float f16 = eVar11.f19190q0[i10];
                if (f16 < f14) {
                    if (cVar.f19135t) {
                        d[] dVarArr2 = eVar11.J;
                        dVar.e(dVarArr2[i11 + 1].f19144g, dVarArr2[i11].f19144g, 0, 4);
                    } else {
                        f16 = 1.0f;
                    }
                    arrayList = arrayList;
                    i23++;
                    arrayList = arrayList;
                    f14 = 0.0f;
                }
                if (f16 == f14) {
                    d[] dVarArr3 = eVar11.J;
                    dVar.e(dVarArr3[i11 + 1].f19144g, dVarArr3[i11].f19144g, 0, 8);
                    arrayList = arrayList;
                } else {
                    if (eVar10 != null) {
                        d[] dVarArr4 = eVar10.J;
                        x.i iVar6 = dVarArr4[i11].f19144g;
                        int i24 = i11 + 1;
                        x.i iVar7 = dVarArr4[i24].f19144g;
                        d[] dVarArr5 = eVar11.J;
                        x.i iVar8 = dVarArr5[i11].f19144g;
                        x.i iVar9 = dVarArr5[i24].f19144g;
                        x.b bVarR = dVar.r();
                        bVarR.l(f15, f13, f16, iVar6, iVar7, iVar8, iVar9);
                        dVar.d(bVarR);
                    }
                    eVar10 = eVar11;
                    f15 = f16;
                }
                i23++;
                arrayList = arrayList;
                f14 = 0.0f;
            }
        }
        if (eVar3 != null && (eVar3 == eVar4 || z12)) {
            d dVar15 = eVar9.J[i11];
            int i25 = i11 + 1;
            d dVar16 = eVar2.J[i25];
            d dVar17 = dVar15.f19141d;
            x.i iVar10 = dVar17 != null ? dVar17.f19144g : null;
            d dVar18 = dVar16.f19141d;
            x.i iVar11 = dVar18 != null ? dVar18.f19144g : null;
            d dVar19 = eVar3.J[i11];
            d dVar20 = eVar4.J[i25];
            if (iVar10 != null && iVar11 != null) {
                dVar.c(dVar19.f19144g, iVar10, dVar19.c(), i10 == 0 ? eVar8.f19160b0 : eVar8.f19162c0, iVar11, dVar20.f19144g, dVar20.c(), 7);
            }
        } else if (!z18 || eVar3 == null) {
            int i26 = 8;
            if (z14 && eVar3 != null) {
                int i27 = cVar.f19125j;
                boolean z19 = i27 > 0 && cVar.f19124i == i27;
                e eVar12 = eVar3;
                e eVar13 = eVar12;
                while (eVar12 != null) {
                    e eVar14 = eVar12.f19194s0[i10];
                    while (eVar14 != null && eVar14.O() == i26) {
                        eVar14 = eVar14.f19194s0[i10];
                    }
                    if (eVar12 == eVar3 || eVar12 == eVar4 || eVar14 == null) {
                        eVar13 = eVar13;
                        i13 = i26;
                    } else {
                        e eVar15 = eVar14 == eVar4 ? null : eVar14;
                        d dVar21 = eVar12.J[i11];
                        x.i iVar12 = dVar21.f19144g;
                        d dVar22 = dVar21.f19141d;
                        if (dVar22 != null) {
                            x.i iVar13 = dVar22.f19144g;
                        }
                        int i28 = i11 + 1;
                        x.i iVar14 = eVar13.J[i28].f19144g;
                        int iC4 = dVar21.c();
                        int iC5 = eVar12.J[i28].c();
                        if (eVar15 != null) {
                            dVar2 = eVar15.J[i11];
                            iVar = dVar2.f19144g;
                            dVar3 = dVar2.f19141d;
                            if (dVar3 == null) {
                                iVar2 = null;
                            }
                            if (dVar2 != null) {
                                iC5 += dVar2.c();
                            }
                            int i29 = iC5;
                            int iC6 = eVar13.J[i28].c() + iC4;
                            if (z19) {
                                i14 = 8;
                            } else {
                                i14 = 4;
                            }
                            if (iVar12 != null || iVar14 == null || iVar == null || iVar2 == null) {
                                i13 = 8;
                            } else {
                                i13 = 8;
                                dVar.c(iVar12, iVar14, iC6, 0.5f, iVar, iVar2, i29, i14);
                            }
                            eVar14 = eVar15;
                        } else {
                            dVar2 = eVar4.J[i11];
                            iVar = dVar2 != null ? dVar2.f19144g : null;
                            dVar3 = eVar12.J[i28];
                        }
                        iVar2 = dVar3.f19144g;
                        if (dVar2 != null) {
                            iC5 += dVar2.c();
                        }
                        int i210 = iC5;
                        int iC7 = eVar13.J[i28].c() + iC4;
                        if (z19) {
                            i14 = 8;
                        } else {
                            i14 = 4;
                        }
                        if (iVar12 != null) {
                            i13 = 8;
                        } else {
                            i13 = 8;
                        }
                        eVar14 = eVar15;
                    }
                    if (eVar12.O() == i13) {
                        eVar12 = eVar13;
                    }
                    i26 = i13;
                    eVar13 = eVar12;
                    eVar12 = eVar14;
                }
                d dVar23 = eVar3.J[i11];
                d dVar24 = eVar9.J[i11].f19141d;
                int i30 = i11 + 1;
                d dVar25 = eVar4.J[i30];
                d dVar26 = eVar2.J[i30].f19141d;
                if (dVar24 == null) {
                    i12 = 5;
                } else if (eVar3 != eVar4) {
                    i12 = 5;
                    dVar.e(dVar23.f19144g, dVar24.f19144g, dVar23.c(), 5);
                } else {
                    i12 = 5;
                    if (dVar26 != null) {
                        dVar.c(dVar23.f19144g, dVar24.f19144g, dVar23.c(), 0.5f, dVar25.f19144g, dVar26.f19144g, dVar25.c(), 5);
                    }
                }
                if (dVar26 != null && eVar3 != eVar4) {
                    dVar.e(dVar25.f19144g, dVar26.f19144g, -dVar25.c(), i12);
                }
            }
        } else {
            int i31 = cVar.f19125j;
            boolean z20 = i31 > 0 && cVar.f19124i == i31;
            e eVar16 = eVar3;
            e eVar17 = eVar16;
            while (eVar16 != null) {
                e eVar18 = eVar16.f19194s0[i10];
                while (eVar18 != null && eVar18.O() == 8) {
                    eVar18 = eVar18.f19194s0[i10];
                }
                if (eVar18 != null || eVar16 == eVar4) {
                    d dVar27 = eVar16.J[i11];
                    x.i iVar15 = dVar27.f19144g;
                    d dVar28 = dVar27.f19141d;
                    x.i iVar16 = dVar28 != null ? dVar28.f19144g : null;
                    if (eVar17 != eVar16) {
                        dVar4 = eVar17.J[i11 + 1];
                    } else {
                        if (eVar16 == eVar3 && eVar17 == eVar16) {
                            dVar4 = eVar9.J[i11].f19141d;
                            if (dVar4 == null) {
                                iVar16 = null;
                            }
                        }
                        iC = dVar27.c();
                        i15 = i11 + 1;
                        iC2 = eVar16.J[i15].c();
                        if (eVar18 != null) {
                            dVar5 = eVar18.J[i11];
                            x.i iVar17 = dVar5.f19144g;
                            iVar4 = eVar16.J[i15].f19144g;
                            iVar3 = iVar17;
                        } else {
                            dVar5 = eVar2.J[i15].f19141d;
                            if (dVar5 != null) {
                                iVar3 = dVar5.f19144g;
                            } else {
                                iVar3 = null;
                            }
                            iVar4 = eVar16.J[i15].f19144g;
                        }
                        if (dVar5 != null) {
                            iC2 += dVar5.c();
                        }
                        if (eVar17 != null) {
                            iC += eVar17.J[i15].c();
                        }
                        if (iVar15 == null && iVar16 != null && iVar3 != null && iVar4 != null) {
                            if (eVar16 == eVar3) {
                                iC = eVar3.J[i11].c();
                            }
                            dVar.c(iVar15, iVar16, iC, 0.5f, iVar3, iVar4, eVar16 == eVar4 ? eVar4.J[i15].c() : iC2, z20 ? 8 : 5);
                        }
                    }
                    iVar16 = dVar4.f19144g;
                    iC = dVar27.c();
                    i15 = i11 + 1;
                    iC2 = eVar16.J[i15].c();
                    if (eVar18 != null) {
                        dVar5 = eVar18.J[i11];
                        x.i iVar18 = dVar5.f19144g;
                        iVar4 = eVar16.J[i15].f19144g;
                        iVar3 = iVar18;
                    } else {
                        dVar5 = eVar2.J[i15].f19141d;
                        if (dVar5 != null) {
                            iVar3 = dVar5.f19144g;
                        } else {
                            iVar3 = null;
                        }
                        iVar4 = eVar16.J[i15].f19144g;
                    }
                    if (dVar5 != null) {
                        iC2 += dVar5.c();
                    }
                    if (eVar17 != null) {
                        iC += eVar17.J[i15].c();
                    }
                    if (iVar15 == null) {
                    }
                }
                if (eVar16.O() != 8) {
                    eVar17 = eVar16;
                }
                eVar16 = eVar18;
            }
        }
        if ((!z18 && !z14) || eVar3 == null || eVar3 == eVar4) {
            return;
        }
        d[] dVarArr6 = eVar3.J;
        d dVar29 = dVarArr6[i11];
        int i32 = i11 + 1;
        d dVar30 = eVar4.J[i32];
        d dVar31 = dVar29.f19141d;
        x.i iVar19 = dVar31 != null ? dVar31.f19144g : null;
        d dVar32 = dVar30.f19141d;
        ?? r11 = dVar32 != null ? dVar32.f19144g : 0;
        if (eVar2 != eVar4) {
            d dVar33 = eVar2.J[i32].f19141d;
            r11 = dVar33 != null ? dVar33.f19144g : null;
        }
        if (eVar3 == eVar4) {
            dVar30 = dVarArr6[i32];
        }
        if (iVar19 == null || r11 == 0) {
            return;
        }
        dVar.c(dVar29.f19144g, iVar19, dVar29.c(), 0.5f, r11, dVar30.f19144g, eVar4.J[i32].c(), 5);
    }
}
