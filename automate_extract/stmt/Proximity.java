package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.stmt.SensorLevelDecision;
import x3.C2425c;

@F3.f("proximity.html")
@F3.a(C2541R.integer.ic_naval_mine)
@F3.i(C2541R.string.stmt_proximity_title)
@F3.h(C2541R.string.stmt_proximity_summary)
@F3.e(C2541R.layout.stmt_proximity_edit)
/* loaded from: classes.dex */
public class Proximity extends SensorLevelDecision {

    public static final class a extends SensorLevelDecision.a implements Runnable {

        /* renamed from: Q1, reason: collision with root package name */
        public boolean f17049Q1;

        /* renamed from: R1, reason: collision with root package name */
        public boolean f17050R1;

        public a(Double d8, Double d9, boolean z7) {
            super(d8, d9, z7 || (d8 == null && d9 == null));
        }

        @Override // com.llamalab.automate.stmt.U0, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            boolean a8 = C1710z2.a(C2425c.c(automateService));
            this.f17050R1 = a8;
            if (a8) {
                F5.n.f(this, "Proximity onRegister: immediate=" + this.f17102O1 + ", minLevel=" + this.f17099L1 + ", maxLevel=" + this.f17100M1);
            }
        }

        @Override // com.llamalab.automate.stmt.U0, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            automateService.f14581L1.removeCallbacks(this);
            super.F(automateService);
        }

        @Override // com.llamalab.automate.stmt.SensorLevelDecision.a, android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            this.f17101N1 = sensorEvent.values[0];
            if (this.f17050R1) {
                F5.n.f(this, "Proximity onSensorChanged: " + this.f17101N1);
            }
            Boolean valueOf = Boolean.valueOf(LevelDecision.E(this.f17101N1, this.f17099L1, this.f17100M1));
            boolean z7 = !valueOf.equals(this.f17103P1);
            this.f17103P1 = valueOf;
            if (this.f17049Q1 && z7) {
                q2(null, false);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f17049Q1 = true;
            if (this.f17102O1) {
                if (this.f17103P1 == null) {
                    this.f17103P1 = Boolean.FALSE;
                }
                p2(null);
            }
        }

        @Override // com.llamalab.automate.stmt.U0
        public final void w2(Sensor sensor) {
            x2(sensor, 0);
            if (this.f17050R1) {
                F5.n.f(this, "Proximity listen: sensor=" + sensor.getName() + ", rateUs=3");
            }
            this.f15400Y.f14581L1.postDelayed(this, 300L);
        }
    }

    @Override // com.llamalab.automate.stmt.SensorLevelDecision
    public final SensorLevelDecision.a G(boolean z7, Double d8, Double d9) {
        return new a(d8, d9, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_proximity_immediate, C2541R.string.caption_proximity_change);
        c1596k0.n(this.minLevel, this.maxLevel, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_proximity_title);
        F(c1708z0, 8);
        return false;
    }
}
