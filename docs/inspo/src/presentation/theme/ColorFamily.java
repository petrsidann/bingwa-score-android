package com.example.bingwahybrid.presentation.theme;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006!"}, d2 = {"Lcom/example/bingwahybrid/presentation/theme/ColorFamily;", "", "color", "Landroidx/compose/ui/graphics/Color;", "onColor", "colorContainer", "onColorContainer", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getOnColor-0d7_KjU", "getColorContainer-0d7_KjU", "getOnColorContainer-0d7_KjU", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "copy", "copy-jRlVdoo", "(JJJJ)Lcom/example/bingwahybrid/presentation/theme/ColorFamily;", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ColorFamily {
    public static final int $stable = 0;
    private final long color;
    private final long colorContainer;
    private final long onColor;
    private final long onColorContainer;

    public /* synthetic */ ColorFamily(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    /* JADX INFO: renamed from: copy-jRlVdoo$default, reason: not valid java name */
    public static /* synthetic */ ColorFamily m9658copyjRlVdoo$default(ColorFamily colorFamily, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = colorFamily.color;
        }
        long j5 = j;
        if ((i & 2) != 0) {
            j2 = colorFamily.onColor;
        }
        long j6 = j2;
        if ((i & 4) != 0) {
            j3 = colorFamily.colorContainer;
        }
        return colorFamily.m9663copyjRlVdoo(j5, j6, j3, (i & 8) != 0 ? colorFamily.onColorContainer : j4);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnColor() {
        return this.onColor;
    }

    /* JADX INFO: renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
    public final long getColorContainer() {
        return this.colorContainer;
    }

    /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnColorContainer() {
        return this.onColorContainer;
    }

    /* JADX INFO: renamed from: copy-jRlVdoo, reason: not valid java name */
    public final ColorFamily m9663copyjRlVdoo(long color, long onColor, long colorContainer, long onColorContainer) {
        return new ColorFamily(color, onColor, colorContainer, onColorContainer, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorFamily)) {
            return false;
        }
        ColorFamily colorFamily = (ColorFamily) other;
        return Color.m5941equalsimpl0(this.color, colorFamily.color) && Color.m5941equalsimpl0(this.onColor, colorFamily.onColor) && Color.m5941equalsimpl0(this.colorContainer, colorFamily.colorContainer) && Color.m5941equalsimpl0(this.onColorContainer, colorFamily.onColorContainer);
    }

    public int hashCode() {
        return (((((Color.m5947hashCodeimpl(this.color) * 31) + Color.m5947hashCodeimpl(this.onColor)) * 31) + Color.m5947hashCodeimpl(this.colorContainer)) * 31) + Color.m5947hashCodeimpl(this.onColorContainer);
    }

    public String toString() {
        return "ColorFamily(color=" + Color.m5948toStringimpl(this.color) + ", onColor=" + Color.m5948toStringimpl(this.onColor) + ", colorContainer=" + Color.m5948toStringimpl(this.colorContainer) + ", onColorContainer=" + Color.m5948toStringimpl(this.onColorContainer) + ")";
    }

    private ColorFamily(long j, long j2, long j3, long j4) {
        this.color = j;
        this.onColor = j2;
        this.colorContainer = j3;
        this.onColorContainer = j4;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m9664getColor0d7_KjU() {
        return this.color;
    }

    /* JADX INFO: renamed from: getOnColor-0d7_KjU, reason: not valid java name */
    public final long m9666getOnColor0d7_KjU() {
        return this.onColor;
    }

    /* JADX INFO: renamed from: getColorContainer-0d7_KjU, reason: not valid java name */
    public final long m9665getColorContainer0d7_KjU() {
        return this.colorContainer;
    }

    /* JADX INFO: renamed from: getOnColorContainer-0d7_KjU, reason: not valid java name */
    public final long m9667getOnColorContainer0d7_KjU() {
        return this.onColorContainer;
    }
}
