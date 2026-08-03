package com.llamalab.automate.stmt;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public abstract class SensorLevelDecision extends LevelDecision implements AsyncStatement {

    public static class a extends U0 {

        /* renamed from: L1, reason: collision with root package name */
        public final Double f17099L1;

        /* renamed from: M1, reason: collision with root package name */
        public final Double f17100M1;

        /* renamed from: N1, reason: collision with root package name */
        public double f17101N1;

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f17102O1;

        /* renamed from: P1, reason: collision with root package name */
        public Boolean f17103P1 = null;

        /* renamed from: com.llamalab.automate.stmt.SensorLevelDecision$a$a, reason: collision with other inner class name */
        public static final class C0178a extends a {
            public C0178a(Double d8, Double d9, boolean z7) {
                super(d8, d9, z7);
            }

            @Override // com.llamalab.automate.stmt.SensorLevelDecision.a, x3.C2435m.a
            public final void e2(int i8, float[] fArr) {
                y2(y4.j.g(fArr[0], fArr[1], fArr[2]));
            }
        }

        public a(Double d8, Double d9, boolean z7) {
            this.f17102O1 = z7;
            this.f17099L1 = d8;
            this.f17100M1 = d9;
        }

        public void e2(int i8, float[] fArr) {
            y2(fArr[0]);
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            e2(sensorEvent.sensor.getType(), sensorEvent.values);
        }

        public final void y2(float f8) {
            Boolean bool;
            double d8 = f8;
            this.f17101N1 = d8;
            Double d9 = this.f17099L1;
            Double d10 = this.f17100M1;
            Boolean valueOf = Boolean.valueOf(LevelDecision.E(d8, d9, d10));
            if (!this.f17102O1 && ((d9 != null || d10 != null) && ((bool = this.f17103P1) == null || valueOf.equals(bool)))) {
                this.f17103P1 = valueOf;
            } else {
                this.f17103P1 = valueOf;
                p2(null);
            }
        }
    }

    public final void F(C1708z0 c1708z0, int i8) {
        Sensor defaultSensor = ((SensorManager) c1708z0.getSystemService("sensor")).getDefaultSensor(i8);
        if (defaultSensor == null) {
            throw new UnsupportedOperationException(B4.g.g("No default sensor: ", i8));
        }
        a G7 = G(J1(1) == 0, D(c1708z0), C(c1708z0));
        c1708z0.w(G7);
        G7.w2(defaultSensor);
    }

    public a G(boolean z7, Double d8, Double d9) {
        return new a(d8, d9, z7);
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        a aVar = (a) w8;
        B(c1708z0, aVar.f17103P1.booleanValue(), Double.valueOf(aVar.f17101N1));
        return true;
    }
}
