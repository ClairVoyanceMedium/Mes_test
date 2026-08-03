package com.llamalab.automate.stmt;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("significant_device_motion.html")
@F3.a(C2541R.integer.ic_boxing_glove)
@F3.i(C2541R.string.stmt_significant_device_motion_title)
@F3.h(C2541R.string.stmt_significant_device_motion_summary)
@F3.c(C2541R.string.stmt_significant_device_motion_title)
@F3.e(C2541R.layout.stmt_significant_device_motion_edit)
/* loaded from: classes.dex */
public class SignificantDeviceMotion extends Action implements AsyncStatement {

    public static final class a extends com.llamalab.automate.W {

        /* renamed from: L1, reason: collision with root package name */
        public Sensor f17124L1;

        /* renamed from: M1, reason: collision with root package name */
        public final C0179a f17125M1 = new C0179a();

        /* renamed from: y1, reason: collision with root package name */
        public SensorManager f17126y1;

        /* renamed from: com.llamalab.automate.stmt.SignificantDeviceMotion$a$a, reason: collision with other inner class name */
        public class C0179a extends TriggerEventListener {
            public C0179a() {
            }

            @Override // android.hardware.TriggerEventListener
            public final void onTrigger(TriggerEvent triggerEvent) {
                a.this.p2(null);
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            SensorManager sensorManager = (SensorManager) automateService.getSystemService("sensor");
            this.f17126y1 = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(17);
            this.f17124L1 = defaultSensor;
            if (defaultSensor == null) {
                throw new UnsupportedOperationException("No significant motion sensor");
            }
            this.f17126y1.requestTriggerSensor(this.f17125M1, defaultSensor);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            u2();
            SensorManager sensorManager = this.f17126y1;
            if (sensorManager != null) {
                Sensor sensor = this.f17124L1;
                if (sensor != null) {
                    sensorManager.cancelTriggerSensor(this.f17125M1, sensor);
                    this.f17124L1 = null;
                }
                this.f17126y1 = null;
            }
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_significant_device_motion_title);
        IncapableAndroidVersionException.a(18);
        c1708z0.w(new a());
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
