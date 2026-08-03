package com.llamalab.automate.stmt;

import P.C1091g;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("display_metrics_get.html")
@F3.a(C2541R.integer.ic_cast_connected)
@F3.i(C2541R.string.stmt_display_metrics_get_title)
@F3.h(C2541R.string.stmt_display_metrics_get_summary)
@F3.e(C2541R.layout.stmt_display_metrics_get_edit)
/* loaded from: classes.dex */
public final class DisplayMetricsGet extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 displayId;
    public J3.l varBounds;
    public J3.l varDensity;
    public J3.l varRefreshRate;
    public J3.l varRotation;

    public static final class a extends B {

        /* renamed from: L1, reason: collision with root package name */
        public final int f16584L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16585M1;

        /* renamed from: N1, reason: collision with root package name */
        public boolean f16586N1;

        /* renamed from: O1, reason: collision with root package name */
        public Rect f16587O1;

        /* renamed from: P1, reason: collision with root package name */
        public float f16588P1;

        /* renamed from: Q1, reason: collision with root package name */
        public int f16589Q1;

        /* renamed from: R1, reason: collision with root package name */
        public float f16590R1;

        public a(int i8, int i9, boolean z7, Rect rect, float f8, int i10, float f9) {
            this.f16584L1 = i8;
            this.f16585M1 = i9;
            this.f16586N1 = z7;
            this.f16587O1 = rect;
            this.f16588P1 = f8;
            this.f16589Q1 = i10;
            this.f16590R1 = f9;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
        @Override // android.hardware.display.DisplayManager.DisplayListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onDisplayChanged(int i8) {
            Display display;
            boolean z7;
            if (this.f16584L1 != i8) {
                return;
            }
            display = this.f16311y1.getDisplay(i8);
            if (display == null && this.f16586N1) {
                this.f16586N1 = false;
                q2(new Object[]{Boolean.FALSE, null, null, null, null}, false);
                return;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Rect rect = new Rect();
            display.getRealMetrics(displayMetrics);
            rect.set(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            int rotation = display.getRotation();
            float refreshRate = display.getRefreshRate();
            float f8 = displayMetrics.density;
            if (this.f16586N1 && ((this.f16585M1 & 1) == 0 || this.f16587O1.equals(rect))) {
                int i9 = this.f16585M1;
                if (((i9 & 4) == 0 || this.f16588P1 == f8) && (((i9 & 2) == 0 || this.f16589Q1 == rotation) && ((i9 & 8) == 0 || this.f16590R1 == refreshRate))) {
                    z7 = false;
                    if (z7) {
                        return;
                    }
                    this.f16586N1 = true;
                    this.f16587O1 = rect;
                    this.f16588P1 = displayMetrics.density;
                    this.f16589Q1 = rotation;
                    this.f16590R1 = refreshRate;
                    double d8 = rotation;
                    Double.isNaN(d8);
                    Double.isNaN(d8);
                    q2(new Object[]{Boolean.TRUE, J3.h.D(rect), Double.valueOf(displayMetrics.density), Double.valueOf(d8 * 90.0d), Double.valueOf(refreshRate)}, false);
                    return;
                }
            }
            z7 = true;
            if (z7) {
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i8) {
            if (this.f16584L1 != i8) {
                return;
            }
            this.f16586N1 = false;
            q2(new Object[]{Boolean.FALSE, null, null, null, null}, false);
        }
    }

    public final void B(C1708z0 c1708z0, boolean z7, J3.a aVar, Double d8, Double d9, Double d10) {
        J3.l lVar = this.varBounds;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, aVar);
        }
        J3.l lVar2 = this.varDensity;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d8);
        }
        J3.l lVar3 = this.varRotation;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d9);
        }
        J3.l lVar4 = this.varRefreshRate;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, d10);
        }
        o(c1708z0, z7);
    }

    public final int C() {
        int i8 = this.varBounds != null ? 1 : 0;
        if (this.varDensity != null) {
            i8 |= 4;
        }
        if (this.varRotation != null) {
            i8 |= 2;
        }
        if (this.varRefreshRate != null) {
            i8 |= 8;
        }
        if (i8 != 0) {
            return i8;
        }
        return -1;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_display_metrics_get_immediate, C2541R.string.caption_display_metrics_get_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.displayId);
        dVar.g(this.varBounds);
        dVar.g(this.varDensity);
        dVar.g(this.varRotation);
        dVar.g(this.varRefreshRate);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.displayId);
        visitor.b(this.varBounds);
        visitor.b(this.varDensity);
        visitor.b(this.varRotation);
        visitor.b(this.varRefreshRate);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.displayId = (InterfaceC1700x0) cVar.readObject();
        this.varBounds = (J3.l) cVar.readObject();
        this.varDensity = (J3.l) cVar.readObject();
        this.varRotation = (J3.l) cVar.readObject();
        this.varRefreshRate = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Display display;
        Double valueOf;
        J3.a aVar;
        Double d8;
        Double d9;
        boolean z7;
        c1708z0.q(C2541R.string.stmt_display_metrics_get_title);
        IncapableAndroidVersionException.a(17);
        int m8 = J3.h.m(c1708z0, this.displayId, 0);
        display = C1091g.e(c1708z0.getSystemService("display")).getDisplay(m8);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Rect rect = new Rect();
        if (J1(1) != 0) {
            if (display == null) {
                c1708z0.w(new a(m8, C(), false, rect, 0.0f, 0, 0.0f));
            } else {
                display.getMetrics(displayMetrics);
                rect.set(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                c1708z0.w(new a(m8, C(), true, rect, displayMetrics.density, display.getOrientation(), display.getRefreshRate()));
            }
            return false;
        }
        if (display == null) {
            aVar = null;
            d8 = null;
            d9 = null;
            valueOf = null;
            z7 = false;
        } else {
            display.getRealMetrics(displayMetrics);
            rect.set(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            J3.a D7 = J3.h.D(rect);
            Double valueOf2 = Double.valueOf(displayMetrics.density);
            double orientation = display.getOrientation();
            Double.isNaN(orientation);
            Double.isNaN(orientation);
            Double valueOf3 = Double.valueOf(orientation * 90.0d);
            valueOf = Double.valueOf(display.getRefreshRate());
            aVar = D7;
            d8 = valueOf2;
            d9 = valueOf3;
            z7 = true;
        }
        B(c1708z0, z7, aVar, d8, d9, valueOf);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (J3.a) objArr[1], (Double) objArr[2], (Double) objArr[3], (Double) objArr[4]);
        return true;
    }
}
