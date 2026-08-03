package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1616p0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import x3.C2425c;

@F3.f("screen_brightness.html")
@F3.a(C2541R.integer.ic_device_access_brightness_medium)
@F3.i(C2541R.string.stmt_screen_brightness_title)
@F3.h(C2541R.string.stmt_screen_brightness_summary)
@F3.e(C2541R.layout.stmt_screen_brightness_edit)
/* loaded from: classes.dex */
public final class ScreenBrightness extends LevelDecision implements AsyncStatement {
    public InterfaceC1700x0 auto;
    public InterfaceC1700x0 scale;
    public J3.l varAdjustment;
    public J3.l varAuto;

    public static final class a extends C1616p0 {

        /* renamed from: L1, reason: collision with root package name */
        public final Boolean f17083L1;

        /* renamed from: M1, reason: collision with root package name */
        public final Double f17084M1;

        /* renamed from: N1, reason: collision with root package name */
        public final Double f17085N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f17086O1;

        /* renamed from: P1, reason: collision with root package name */
        public final boolean f17087P1;

        /* renamed from: Q1, reason: collision with root package name */
        public Boolean f17088Q1;

        public a(Boolean bool, boolean z7, Boolean bool2, Double d8, Double d9, int i8) {
            this.f17088Q1 = bool;
            this.f17087P1 = z7;
            this.f17083L1 = bool2;
            this.f17084M1 = d8;
            this.f17085N1 = d9;
            this.f17086O1 = i8;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:
        
            if (r3.booleanValue() != false) goto L12;
         */
        @Override // com.llamalab.automate.C1616p0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void x2(Uri uri) {
            boolean E7;
            Boolean valueOf;
            Boolean bool;
            try {
                AutomateService automateService = this.f15400Y;
                int i8 = Settings.System.getInt(automateService.getContentResolver(), "screen_brightness_mode");
                double H7 = ScreenBrightness.H(automateService, this.f17086O1);
                Double G7 = ScreenBrightness.G(automateService);
                Boolean bool2 = this.f17083L1;
                Double d8 = this.f17084M1;
                Double d9 = this.f17085N1;
                if (bool2 != null) {
                    if (i8 != 0) {
                        if (i8 == 1 && !bool2.booleanValue()) {
                            E7 = false;
                        }
                    }
                    valueOf = Boolean.valueOf(E7);
                    if (!this.f17087P1 && ((bool = this.f17088Q1) == null || valueOf.equals(bool))) {
                        this.f17088Q1 = valueOf;
                        return;
                    }
                    this.f17088Q1 = valueOf;
                    q2(new Object[]{valueOf, Double.valueOf(H7), Integer.valueOf(i8), G7}, false);
                }
                E7 = LevelDecision.E(H7, d8, d9);
                valueOf = Boolean.valueOf(E7);
                if (!this.f17087P1) {
                    this.f17088Q1 = valueOf;
                    return;
                }
                this.f17088Q1 = valueOf;
                q2(new Object[]{valueOf, Double.valueOf(H7), Integer.valueOf(i8), G7}, false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static Double G(Context context) {
        if (16 > Build.VERSION.SDK_INT) {
            return null;
        }
        try {
            double d8 = Settings.System.getFloat(context.getContentResolver(), "screen_auto_brightness_adj");
            Double.isNaN(d8);
            Double.isNaN(d8);
            return Double.valueOf(d8 * 100.0d);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double H(Context context, int i8) {
        float f8 = C2425c.f("config_screenBrightnessSettingMinimumFloat", "config_screenBrightnessSettingMinimum", 0.039215688f);
        float f9 = C2425c.f("config_screenBrightnessSettingMaximumFloat", "config_screenBrightnessSettingMaximum", 1.0f);
        float c8 = (y4.j.c(Settings.System.getInt(context.getContentResolver(), "screen_brightness") / 255.0f, f8, f9) - f8) / (f9 - f8);
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalArgumentException("scale");
            }
            float f10 = c8 * 12.0f;
            c8 = f10 <= 1.0f ? ((float) Math.sqrt(f10)) * 0.5f : (((float) Math.log(f10 - 0.28466892f)) * 0.17883277f) + 0.5599107f;
        }
        return c8 * 100.0f;
    }

    public final void F(C1708z0 c1708z0, boolean z7, Double d8, int i8, Double d9) {
        J3.l lVar = this.varAuto;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, Double.valueOf(J3.h.Y(i8 == 1)));
        }
        J3.l lVar2 = this.varAdjustment;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d9);
        }
        B(c1708z0, z7, d8);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_screen_brightness_immediate, C2541R.string.caption_screen_brightness_change);
        C1596k0 y7 = c1596k0.y(this.auto, C2541R.string.caption_auto, 0);
        y7.n(this.minLevel, this.maxLevel, 0);
        return y7.f16030c;
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (81 <= dVar.f6413Z) {
            dVar.g(this.scale);
        }
        dVar.g(this.auto);
        if (2 <= dVar.f6413Z) {
            dVar.g(this.varAuto);
        }
        if (34 <= dVar.f6413Z) {
            dVar.g(this.varAdjustment);
        }
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.scale);
        visitor.b(this.auto);
        visitor.b(this.varAuto);
        visitor.b(this.varAdjustment);
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (81 <= cVar.f6409x0) {
            this.scale = (InterfaceC1700x0) cVar.readObject();
        }
        this.auto = (InterfaceC1700x0) cVar.readObject();
        if (2 <= cVar.f6409x0) {
            this.varAuto = (J3.l) cVar.readObject();
        }
        if (34 <= cVar.f6409x0) {
            this.varAdjustment = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Object c22;
        c1708z0.q(C2541R.string.stmt_screen_brightness_title);
        Double D7 = D(c1708z0);
        Double C7 = C(c1708z0);
        int m8 = J3.h.m(c1708z0, this.scale, 0);
        InterfaceC1700x0 interfaceC1700x0 = this.auto;
        Boolean valueOf = (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) ? null : Boolean.valueOf(J3.h.J(c22));
        boolean z7 = J1(1) == 0;
        int i8 = Settings.System.getInt(c1708z0.getContentResolver(), "screen_brightness_mode");
        double H7 = H(c1708z0, m8);
        boolean E7 = (valueOf == null || (i8 == 0 ? !valueOf.booleanValue() : i8 != 1 || valueOf.booleanValue())) ? LevelDecision.E(H7, D7, C7) : false;
        if (z7) {
            F(c1708z0, E7, Double.valueOf(H7), i8, G(c1708z0));
            return true;
        }
        if (valueOf == null && D7 == null && C7 == null) {
            z7 = true;
        }
        a aVar = new a(Boolean.valueOf(E7), z7, valueOf, D7, C7, m8);
        c1708z0.w(aVar);
        if (z7 || valueOf != null) {
            aVar.w2(false, Settings.System.getUriFor("screen_brightness_mode"));
        }
        if (z7 || (D7 != null && C7 != null)) {
            aVar.w2(false, Settings.System.getUriFor("screen_brightness"));
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        F(c1708z0, ((Boolean) objArr[0]).booleanValue(), (Double) objArr[1], ((Integer) objArr[2]).intValue(), (Double) objArr[3]);
        return true;
    }
}
