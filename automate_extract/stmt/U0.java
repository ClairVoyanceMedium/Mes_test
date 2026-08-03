package com.llamalab.automate.stmt;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.llamalab.automate.AutomateService;

/* loaded from: classes.dex */
public abstract class U0 extends com.llamalab.automate.W implements SensorEventListener {

    /* renamed from: y1, reason: collision with root package name */
    public SensorManager f17211y1;

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        this.f17211y1 = (SensorManager) automateService.getSystemService("sensor");
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public void F(AutomateService automateService) {
        SensorManager sensorManager = this.f17211y1;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        u2();
    }

    public void onAccuracyChanged(Sensor sensor, int i8) {
    }

    public final void v2(int i8, int i9) {
        Sensor defaultSensor = this.f17211y1.getDefaultSensor(i8);
        if (defaultSensor == null) {
            throw new UnsupportedOperationException(B4.g.g("No default sensor: ", i8));
        }
        x2(defaultSensor, i9);
    }

    public void w2(Sensor sensor) {
        x2(sensor, 0);
    }

    public final void x2(Sensor sensor, int i8) {
        if (19 <= Build.VERSION.SDK_INT ? this.f17211y1.registerListener(this, sensor, 3, i8, this.f15400Y.f14581L1) : this.f17211y1.registerListener(this, sensor, 3, this.f15400Y.f14581L1)) {
            return;
        }
        throw new IllegalStateException("Failed to register sensor: " + sensor);
    }
}
