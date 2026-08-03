package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.SensorEvent;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.stmt.SensorLevelDecision;
import x3.C2435m;

@F3.f("device_acceleration.html")
@F3.a(C2541R.integer.ic_bullet)
@F3.i(C2541R.string.stmt_device_acceleration_title)
@F3.h(C2541R.string.stmt_device_acceleration_summary)
@F3.e(C2541R.layout.stmt_device_acceleration_edit)
/* loaded from: classes.dex */
public class DeviceAcceleration extends SensorLevelDecision {

    public static final class a extends SensorLevelDecision.a implements C2435m.a {

        /* renamed from: Q1, reason: collision with root package name */
        public final C2435m f16555Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final float[] f16556R1;

        /* renamed from: S1, reason: collision with root package name */
        public final float[] f16557S1;

        /* renamed from: T1, reason: collision with root package name */
        public int f16558T1;

        public a(Double d8, Double d9, boolean z7) {
            super(d8, d9, z7);
            this.f16555Q1 = new C2435m(this);
            this.f16556R1 = new float[3];
            this.f16557S1 = new float[3];
        }

        @Override // com.llamalab.automate.stmt.SensorLevelDecision.a, x3.C2435m.a
        public final void e2(int i8, float[] fArr) {
            float[] fArr2 = this.f16557S1;
            float[] fArr3 = this.f16556R1;
            if (i8 == 1) {
                System.arraycopy(fArr, 0, fArr3, 0, 3);
            } else if (i8 == 9) {
                System.arraycopy(fArr, 0, fArr2, 0, 3);
            }
            int i9 = (1 << i8) | this.f16558T1;
            this.f16558T1 = i9;
            if (i9 == 514) {
                y2(y4.j.g(fArr3[0] - fArr2[0], fArr3[1] - fArr2[1], fArr3[2] - fArr2[2]));
            }
        }

        @Override // com.llamalab.automate.stmt.SensorLevelDecision.a, android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            this.f16555Q1.onSensorChanged(sensorEvent);
            super.onSensorChanged(sensorEvent);
        }
    }

    @Override // com.llamalab.automate.stmt.SensorLevelDecision
    public final SensorLevelDecision.a G(boolean z7, Double d8, Double d9) {
        return new a(d8, d9, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_device_acceleration_immediate, C2541R.string.caption_device_acceleration_change);
        c1596k0.n(this.minLevel, this.maxLevel, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_device_acceleration_title);
        F(c1708z0, 1);
        return false;
    }
}
