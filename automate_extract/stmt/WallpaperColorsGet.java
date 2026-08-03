package com.llamalab.automate.stmt;

import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.N2;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.W;

@F3.f("wallpaper_colors_get.html")
@F3.a(C2541R.integer.ic_colorize)
@F3.i(C2541R.string.stmt_wallpaper_colors_get_title)
@F3.h(C2541R.string.stmt_wallpaper_colors_get_summary)
@F3.e(C2541R.layout.stmt_wallpaper_colors_get_edit)
/* loaded from: classes.dex */
public final class WallpaperColorsGet extends IntermittentAction implements AsyncStatement {
    public J3.l varColorModel;
    public J3.l varPrimaryColorComponents;
    public J3.l varSecondaryColorComponents;
    public J3.l varTertiaryColorComponents;
    public InterfaceC1700x0 which;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17263a;

        static {
            ColorSpace.Model[] values;
            ColorSpace.Model model;
            int ordinal;
            ColorSpace.Model model2;
            int ordinal2;
            ColorSpace.Model model3;
            int ordinal3;
            ColorSpace.Model model4;
            int ordinal4;
            values = ColorSpace.Model.values();
            int[] iArr = new int[values.length];
            f17263a = iArr;
            try {
                model4 = ColorSpace.Model.CMYK;
                ordinal4 = model4.ordinal();
                iArr[ordinal4] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f17263a;
                model3 = ColorSpace.Model.RGB;
                ordinal3 = model3.ordinal();
                iArr2[ordinal3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f17263a;
                model2 = ColorSpace.Model.XYZ;
                ordinal2 = model2.ordinal();
                iArr3[ordinal2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f17263a;
                model = ColorSpace.Model.LAB;
                ordinal = model.ordinal();
                iArr4[ordinal] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class b extends W.a<WallpaperColors> implements WallpaperManager.OnColorsChangedListener {

        /* renamed from: N1, reason: collision with root package name */
        public final int f17264N1;

        /* renamed from: O1, reason: collision with root package name */
        public WallpaperManager f17265O1;

        /* renamed from: P1, reason: collision with root package name */
        public WallpaperColors f17266P1;

        public b(int i8) {
            super(256, 1000L);
            this.f17264N1 = i8;
        }

        @Override // com.llamalab.automate.W.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(automateService);
            this.f17265O1 = wallpaperManager;
            wallpaperManager.addOnColorsChangedListener(this, automateService.f14581L1);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            try {
                this.f17265O1.removeOnColorsChangedListener(this);
            } catch (Throwable unused) {
            }
            u2();
        }

        @Override // android.app.WallpaperManager.OnColorsChangedListener
        public final void onColorsChanged(WallpaperColors wallpaperColors, int i8) {
            if ((i8 & this.f17264N1) != 0) {
                v2(wallpaperColors);
            }
        }

        @Override // com.llamalab.automate.W.a
        public final void w2(WallpaperColors wallpaperColors) {
            WallpaperColors a8 = w1.a(wallpaperColors);
            this.f17266P1 = a8;
            q2(a8, false);
        }
    }

    public static final class c extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final int f17267L1;

        public c(int i8) {
            this.f17267L1 = i8;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            WallpaperColors wallpaperColors;
            wallpaperColors = WallpaperManager.getInstance(this.f15400Y).getWallpaperColors(this.f17267L1);
            q2(wallpaperColors, false);
        }
    }

    public static void u(C1708z0 c1708z0, J3.l lVar, Color color, ColorSpace colorSpace) {
        ColorSpace colorSpace2;
        int componentCount;
        float component;
        if (lVar != null) {
            if (color == null) {
                c1708z0.z(lVar.f4659Y, null);
                return;
            }
            colorSpace2 = color.getColorSpace();
            if (colorSpace2 != colorSpace) {
                color = color.convert(colorSpace);
            }
            componentCount = color.getComponentCount();
            int i8 = componentCount - 1;
            J3.a aVar = new J3.a(i8);
            for (int i9 = 0; i9 < i8; i9++) {
                component = color.getComponent(i9);
                aVar.add(Double.valueOf(component));
            }
            c1708z0.z(lVar.f4659Y, aVar);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_wallpaper_colors_get_immediate, C2541R.string.caption_wallpaper_colors_get_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.which);
        dVar.g(this.varColorModel);
        dVar.g(this.varPrimaryColorComponents);
        dVar.g(this.varSecondaryColorComponents);
        dVar.g(this.varTertiaryColorComponents);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.which);
        visitor.b(this.varColorModel);
        visitor.b(this.varPrimaryColorComponents);
        visitor.b(this.varSecondaryColorComponents);
        visitor.b(this.varTertiaryColorComponents);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.which = (InterfaceC1700x0) cVar.readObject();
        this.varColorModel = (J3.l) cVar.readObject();
        this.varPrimaryColorComponents = (J3.l) cVar.readObject();
        this.varSecondaryColorComponents = (J3.l) cVar.readObject();
        this.varTertiaryColorComponents = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 bVar;
        c cVar;
        c1708z0.q(C2541R.string.stmt_wallpaper_colors_get_title);
        IncapableAndroidVersionException.b(27, "wallpaper colors");
        int m8 = J3.h.m(c1708z0, this.which, 1);
        if (Integer.bitCount(m8) != 1) {
            throw new IllegalArgumentException("which");
        }
        b bVar2 = (b) c1708z0.c(b.class);
        if (J1(1) != 0) {
            if (bVar2 == null) {
                bVar = new b(m8);
            } else {
                if (bVar2.f17264N1 == m8) {
                    bVar2.x2();
                    return false;
                }
                bVar2.a();
                bVar = new b(m8);
            }
            c1708z0.w(bVar);
            return false;
        }
        if (bVar2 == null) {
            cVar = new c(m8);
        } else {
            if (bVar2.f17264N1 == m8) {
                F5.n.h(bVar2);
                F5.n.i(bVar2, bVar2.f15405L1);
                s(c1708z0, bVar2.f17266P1);
                return true;
            }
            bVar2.a();
            cVar = new c(m8);
        }
        c1708z0.w(cVar);
        cVar.w2();
        return false;
    }

    public final void s(C1708z0 c1708z0, WallpaperColors wallpaperColors) {
        Color primaryColor;
        ColorSpace colorSpace;
        ColorSpace.Model model;
        int ordinal;
        Color secondaryColor;
        Color tertiaryColor;
        ColorSpace.Model model2;
        String name;
        ColorSpace.Named named;
        if (wallpaperColors != null) {
            primaryColor = wallpaperColors.getPrimaryColor();
            colorSpace = primaryColor.getColorSpace();
            int[] iArr = a.f17263a;
            model = colorSpace.getModel();
            ordinal = model.ordinal();
            int i8 = iArr[ordinal];
            if (i8 != 1 && i8 != 2 && i8 != 3) {
                named = ColorSpace.Named.CIE_XYZ;
                colorSpace = ColorSpace.get(named);
            }
            J3.l lVar = this.varColorModel;
            if (lVar != null) {
                model2 = colorSpace.getModel();
                name = model2.name();
                c1708z0.z(lVar.f4659Y, name);
            }
            u(c1708z0, this.varPrimaryColorComponents, primaryColor, colorSpace);
            J3.l lVar2 = this.varSecondaryColorComponents;
            secondaryColor = wallpaperColors.getSecondaryColor();
            u(c1708z0, lVar2, secondaryColor, colorSpace);
            J3.l lVar3 = this.varTertiaryColorComponents;
            tertiaryColor = wallpaperColors.getTertiaryColor();
            u(c1708z0, lVar3, tertiaryColor, colorSpace);
        } else {
            J3.l lVar4 = this.varColorModel;
            if (lVar4 != null) {
                c1708z0.z(lVar4.f4659Y, null);
            }
            J3.l lVar5 = this.varPrimaryColorComponents;
            if (lVar5 != null) {
                c1708z0.z(lVar5.f4659Y, null);
            }
            J3.l lVar6 = this.varSecondaryColorComponents;
            if (lVar6 != null) {
                c1708z0.z(lVar6.f4659Y, null);
            }
            J3.l lVar7 = this.varTertiaryColorComponents;
            if (lVar7 != null) {
                c1708z0.z(lVar7.f4659Y, null);
            }
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        s(c1708z0, w1.a(obj));
        return true;
    }
}
