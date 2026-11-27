package ra;

import android.view.KeyEvent;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class y implements z.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.b f15320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Long, Long> f15321b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Long, a0.e> f15322c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z.b f15323d = new z.b();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15324a;

        static {
            int[] iArr = new int[u.b.values().length];
            f15324a = iArr;
            try {
                iArr[u.b.kDown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15324a[u.b.kUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15324a[u.b.kRepeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public y(fb.b bVar) {
        this.f15320a = bVar;
        for (a0.e eVar : a0.a()) {
            this.f15322c.put(Long.valueOf(eVar.f15192c), eVar);
        }
    }

    public static u.b e(KeyEvent keyEvent) {
        boolean z10 = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z10 ? u.b.kRepeat : u.b.kDown;
        }
        if (action == 1) {
            return u.b.kUp;
        }
        throw new AssertionError("Unexpected event type");
    }

    public static long j(long j10, long j11) {
        return (j10 & 4294967295L) | j11;
    }

    public static /* synthetic */ void k(z.d.a aVar, ByteBuffer byteBuffer) {
        Boolean boolValueOf = Boolean.FALSE;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            if (byteBuffer.capacity() != 0) {
                boolValueOf = Boolean.valueOf(byteBuffer.get() != 0);
            }
        } else {
            qa.b.g("KeyEmbedderResponder", "A null reply was received when sending a key event to the framework.");
        }
        aVar.a(boolValueOf.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(a0.c cVar, long j10, KeyEvent keyEvent) {
        q(false, Long.valueOf(cVar.f15187b), Long.valueOf(j10), keyEvent.getEventTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(a0.c cVar, KeyEvent keyEvent) {
        q(false, Long.valueOf(cVar.f15187b), Long.valueOf(cVar.f15186a), keyEvent.getEventTime());
    }

    @Override // ra.z.d
    public void a(KeyEvent keyEvent, z.d.a aVar) {
        if (i(keyEvent, aVar)) {
            return;
        }
        q(true, 0L, 0L, 0L);
        aVar.a(true);
    }

    public final Long f(KeyEvent keyEvent) {
        Long l10 = a0.f15184b.get(Long.valueOf(keyEvent.getKeyCode()));
        return l10 != null ? l10 : Long.valueOf(j(keyEvent.getKeyCode(), 73014444032L));
    }

    public final Long g(KeyEvent keyEvent) {
        int scanCode;
        long scanCode2 = keyEvent.getScanCode();
        if (scanCode2 == 0) {
            scanCode = keyEvent.getKeyCode();
        } else {
            Long l10 = a0.f15183a.get(Long.valueOf(scanCode2));
            if (l10 != null) {
                return l10;
            }
            scanCode = keyEvent.getScanCode();
        }
        return Long.valueOf(j(scanCode, 73014444032L));
    }

    public Map<Long, Long> h() {
        return Collections.unmodifiableMap(this.f15321b);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:60:0x0103  */
    /* JADX WARN: Code duplicated, block: B:62:0x0108  */
    /* JADX WARN: Code duplicated, block: B:64:0x010d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0110  */
    /* JADX WARN: Code duplicated, block: B:66:0x0113  */
    /* JADX WARN: Code duplicated, block: B:67:0x0116  */
    /* JADX WARN: Code duplicated, block: B:71:0x0140 A[LOOP:2: B:69:0x013a->B:71:0x0140, LOOP_END] */
    public final boolean i(KeyEvent keyEvent, z.d.a aVar) {
        boolean z10;
        u.b bVar;
        int source;
        u.a aVar2;
        Iterator<Runnable> it;
        a0.e eVar;
        if (keyEvent.getScanCode() == 0 && keyEvent.getKeyCode() == 0) {
            return false;
        }
        Long lG = g(keyEvent);
        Long lF = f(keyEvent);
        ArrayList<Runnable> arrayList = new ArrayList<>();
        for (a0.d dVar : a0.f15185c) {
            o(dVar, (keyEvent.getMetaState() & dVar.f15188a) != 0, lF.longValue(), lG.longValue(), keyEvent, arrayList);
        }
        for (a0.e eVar2 : this.f15322c.values()) {
            p(eVar2, (keyEvent.getMetaState() & eVar2.f15190a) != 0, lF.longValue(), keyEvent);
        }
        int action = keyEvent.getAction();
        if (action == 0) {
            z10 = true;
        } else {
            if (action != 1) {
                return false;
            }
            z10 = false;
        }
        Long l10 = this.f15321b.get(lG);
        if (z10) {
            if (l10 == null) {
                bVar = u.b.kDown;
            } else if (keyEvent.getRepeatCount() > 0) {
                bVar = u.b.kRepeat;
            } else {
                q(false, l10, lG, keyEvent.getEventTime());
                bVar = u.b.kDown;
            }
            char cCharValue = this.f15323d.a(keyEvent.getUnicodeChar()).charValue();
            String str = cCharValue != 0 ? "" + cCharValue : null;
            if (bVar != u.b.kRepeat) {
                r(lG, z10 ? lF : null);
            }
            if (bVar == u.b.kDown && (eVar = this.f15322c.get(lF)) != null) {
                eVar.f15193d = !eVar.f15193d;
            }
            u uVar = new u();
            source = keyEvent.getSource();
            if (source != 513) {
                aVar2 = u.a.kDirectionalPad;
            } else if (source != 1025) {
                aVar2 = u.a.kGamepad;
            } else if (source != 16777232) {
                aVar2 = u.a.kJoystick;
            } else if (source != 33554433) {
                aVar2 = u.a.kKeyboard;
            } else {
                aVar2 = u.a.kHdmi;
            }
            uVar.f15298f = aVar2;
            uVar.f15293a = keyEvent.getEventTime();
            uVar.f15294b = bVar;
            uVar.f15296d = lF.longValue();
            uVar.f15295c = lG.longValue();
            uVar.f15299g = str;
            uVar.f15297e = false;
            n(uVar, aVar);
            it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            return true;
        }
        if (l10 == null) {
            return false;
        }
        bVar = u.b.kUp;
        if (bVar != u.b.kRepeat) {
            r(lG, z10 ? lF : null);
        }
        if (bVar == u.b.kDown) {
            eVar.f15193d = !eVar.f15193d;
        }
        u uVar2 = new u();
        source = keyEvent.getSource();
        if (source != 513) {
            aVar2 = u.a.kDirectionalPad;
        } else if (source != 1025) {
            aVar2 = u.a.kGamepad;
        } else if (source != 16777232) {
            aVar2 = u.a.kJoystick;
        } else if (source != 33554433) {
            aVar2 = u.a.kKeyboard;
        } else {
            aVar2 = u.a.kHdmi;
        }
        uVar2.f15298f = aVar2;
        uVar2.f15293a = keyEvent.getEventTime();
        uVar2.f15294b = bVar;
        uVar2.f15296d = lF.longValue();
        uVar2.f15295c = lG.longValue();
        uVar2.f15299g = str;
        uVar2.f15297e = false;
        n(uVar2, aVar);
        it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        return true;
    }

    public final void n(u uVar, final z.d.a aVar) {
        this.f15320a.f("flutter/keydata", uVar.a(), aVar == null ? null : new fb.b.InterfaceC0141b() { // from class: ra.v
            @Override // fb.b.InterfaceC0141b
            public final void a(ByteBuffer byteBuffer) {
                y.k(aVar, byteBuffer);
            }
        });
    }

    public void o(a0.d dVar, boolean z10, long j10, final long j11, final KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        a0.c[] cVarArr = dVar.f15189b;
        boolean[] zArr = new boolean[cVarArr.length];
        Boolean[] boolArr = new Boolean[cVarArr.length];
        boolean z11 = false;
        int i10 = 0;
        while (true) {
            a0.c[] cVarArr2 = dVar.f15189b;
            boolean z12 = true;
            if (i10 >= cVarArr2.length) {
                break;
            }
            final a0.c cVar = cVarArr2[i10];
            boolean zContainsKey = this.f15321b.containsKey(Long.valueOf(cVar.f15186a));
            zArr[i10] = zContainsKey;
            if (cVar.f15187b == j10) {
                int i11 = a.f15324a[e(keyEvent).ordinal()];
                if (i11 != 1) {
                    if (i11 == 2) {
                        boolArr[i10] = Boolean.valueOf(zArr[i10]);
                    } else if (i11 == 3) {
                        if (!z10) {
                            arrayList.add(new Runnable() { // from class: ra.x
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f15317a.m(cVar, keyEvent);
                                }
                            });
                        }
                        boolArr[i10] = Boolean.valueOf(zArr[i10]);
                    }
                    i10++;
                } else {
                    boolArr[i10] = Boolean.FALSE;
                    if (!z10) {
                        arrayList.add(new Runnable() { // from class: ra.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f15313a.l(cVar, j11, keyEvent);
                            }
                        });
                    }
                }
            } else if (!z11 && !zContainsKey) {
                z12 = false;
            }
            z11 = z12;
            i10++;
        }
        if (z10) {
            for (int i12 = 0; i12 < dVar.f15189b.length; i12++) {
                if (boolArr[i12] == null) {
                    if (z11) {
                        boolArr[i12] = Boolean.valueOf(zArr[i12]);
                    } else {
                        boolArr[i12] = Boolean.TRUE;
                        z11 = true;
                    }
                }
            }
            if (!z11) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i13 = 0; i13 < dVar.f15189b.length; i13++) {
                if (boolArr[i13] == null) {
                    boolArr[i13] = Boolean.FALSE;
                }
            }
        }
        for (int i14 = 0; i14 < dVar.f15189b.length; i14++) {
            if (zArr[i14] != boolArr[i14].booleanValue()) {
                a0.c cVar2 = dVar.f15189b[i14];
                q(boolArr[i14].booleanValue(), Long.valueOf(cVar2.f15187b), Long.valueOf(cVar2.f15186a), keyEvent.getEventTime());
            }
        }
    }

    public void p(a0.e eVar, boolean z10, long j10, KeyEvent keyEvent) {
        if (eVar.f15192c == j10 || eVar.f15193d == z10) {
            return;
        }
        boolean z11 = !this.f15321b.containsKey(Long.valueOf(eVar.f15191b));
        if (z11) {
            eVar.f15193d = !eVar.f15193d;
        }
        q(z11, Long.valueOf(eVar.f15192c), Long.valueOf(eVar.f15191b), keyEvent.getEventTime());
        if (!z11) {
            eVar.f15193d = !eVar.f15193d;
        }
        q(!z11, Long.valueOf(eVar.f15192c), Long.valueOf(eVar.f15191b), keyEvent.getEventTime());
    }

    public final void q(boolean z10, Long l10, Long l11, long j10) {
        u uVar = new u();
        uVar.f15293a = j10;
        uVar.f15294b = z10 ? u.b.kDown : u.b.kUp;
        uVar.f15296d = l10.longValue();
        uVar.f15295c = l11.longValue();
        uVar.f15299g = null;
        uVar.f15297e = true;
        uVar.f15298f = u.a.kKeyboard;
        if (l11.longValue() != 0 && l10.longValue() != 0) {
            if (!z10) {
                l10 = null;
            }
            r(l11, l10);
        }
        n(uVar, null);
    }

    public void r(Long l10, Long l11) {
        if (l11 != null) {
            if (this.f15321b.put(l10, l11) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.f15321b.remove(l10) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
