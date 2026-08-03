package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.SystemClock;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.concurrent.atomic.AtomicBoolean;
import x3.C2435m;

@F3.f("device_orientation.html")
@F3.a(C2541R.integer.ic_device_orientation)
@F3.i(C2541R.string.stmt_device_orientation_title)
@F3.h(C2541R.string.stmt_device_orientation_summary)
@F3.e(C2541R.layout.stmt_device_orientation_edit)
/* loaded from: classes.dex */
public class DeviceOrientation extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 targetAzimuth;
    public InterfaceC1700x0 targetPitch;
    public InterfaceC1700x0 targetRoll;
    public InterfaceC1700x0 tolerance;
    public J3.l varCurrentAzimuth;
    public J3.l varCurrentPitch;
    public J3.l varCurrentRoll;

    public static class a extends U0 implements C2435m.a {

        /* renamed from: Q1, reason: collision with root package name */
        public final Double f16571Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final Double f16572R1;

        /* renamed from: S1, reason: collision with root package name */
        public final Double f16573S1;

        /* renamed from: T1, reason: collision with root package name */
        public final double f16574T1;

        /* renamed from: V1, reason: collision with root package name */
        public final boolean f16575V1;
        public Boolean W1;

        /* renamed from: X1, reason: collision with root package name */
        public Sensor f16576X1;

        /* renamed from: Y1, reason: collision with root package name */
        public Sensor f16577Y1;

        /* renamed from: Z1, reason: collision with root package name */
        public C2435m f16578Z1;

        /* renamed from: a2, reason: collision with root package name */
        public long f16579a2;

        /* renamed from: b2, reason: collision with root package name */
        public int f16580b2;

        /* renamed from: L1, reason: collision with root package name */
        public final float[] f16566L1 = new float[3];

        /* renamed from: M1, reason: collision with root package name */
        public final float[] f16567M1 = new float[3];

        /* renamed from: N1, reason: collision with root package name */
        public final float[] f16568N1 = new float[3];

        /* renamed from: O1, reason: collision with root package name */
        public final float[] f16569O1 = new float[9];

        /* renamed from: P1, reason: collision with root package name */
        public final float[] f16570P1 = new float[3];
        public final AtomicBoolean U1 = new AtomicBoolean();

        public a(boolean z7, double d8, Double d9, Double d10, Double d11) {
            this.f16575V1 = z7 || (d9 == null && d10 == null && d11 == null);
            this.W1 = null;
            this.f16574T1 = d8;
            this.f16571Q1 = d9;
            this.f16572R1 = d10;
            this.f16573S1 = d11;
        }

        public final boolean A2(Double d8, float f8) {
            if (d8 != null) {
                double doubleValue = d8.doubleValue();
                double d9 = f8;
                Double.isNaN(d9);
                if (Math.abs((((doubleValue - d9) + 180.0d) % 360.0d) - 180.0d) > this.f16574T1) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.llamalab.automate.stmt.U0, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            if (y2(1) == null) {
                throw new UnsupportedOperationException("No accelerometer");
            }
            Sensor y22 = y2(2);
            this.f16576X1 = y22;
            if (y22 == null) {
                throw new UnsupportedOperationException("No magnetometer");
            }
            Sensor y23 = y2(9);
            this.f16577Y1 = y23;
            if (y23 == null) {
                this.f16578Z1 = new C2435m(this);
            }
        }

        @Override // x3.C2435m.a
        public final void e2(int i8, float[] fArr) {
            int i9;
            int i10;
            Boolean bool;
            float[] fArr2 = this.f16568N1;
            float[] fArr3 = this.f16567M1;
            float[] fArr4 = this.f16566L1;
            if (i8 == 1) {
                i9 = 1 << i8;
                if ((this.f16580b2 & i9) != 0) {
                    if (y4.j.g(fArr[0] - fArr4[0], fArr[1] - fArr4[1], fArr[2] - fArr4[2]) >= 0.2f) {
                        z2(false);
                        this.f16579a2 = SystemClock.uptimeMillis();
                    } else if (this.f16579a2 != 0 && SystemClock.uptimeMillis() - this.f16579a2 > 3000) {
                        z2(true);
                        this.f16579a2 = 0L;
                    }
                    int i11 = 3;
                    while (true) {
                        i11--;
                        if (i11 < 0) {
                            break;
                        }
                        float f8 = fArr4[i11];
                        fArr4[i11] = C1.H0.j(fArr[i11], f8, 0.25f, f8);
                    }
                } else {
                    System.arraycopy(fArr, 0, fArr4, 0, 3);
                    i10 = this.f16580b2;
                    this.f16580b2 = i9 | i10;
                }
            } else {
                if (i8 == 2) {
                    System.arraycopy(fArr, 0, fArr3, 0, 3);
                } else if (i8 == 9) {
                    System.arraycopy(fArr, 0, fArr2, 0, 3);
                }
                i10 = this.f16580b2;
                i9 = 1 << i8;
                this.f16580b2 = i9 | i10;
            }
            if (this.U1.get() || this.f16580b2 != 518) {
                return;
            }
            float[] fArr5 = this.f16569O1;
            if (SensorManager.getRotationMatrix(fArr5, null, fArr4, fArr3)) {
                float[] fArr6 = this.f16570P1;
                SensorManager.getOrientation(fArr5, fArr6);
                if (fArr2[2] < 0.0f) {
                    float f9 = fArr6[1];
                    fArr6[1] = (f9 > 0.0f ? 3.1415927f : -3.1415927f) - f9;
                }
                float f10 = fArr6[0] * 57.29578f;
                fArr6[0] = f10;
                fArr6[1] = fArr6[1] * 57.29578f;
                fArr6[2] = fArr6[2] * 57.29578f;
                Boolean valueOf = Boolean.valueOf(A2(this.f16571Q1, f10) && A2(this.f16572R1, fArr6[1]) && A2(this.f16573S1, fArr6[2]));
                if (!this.f16575V1 && ((bool = this.W1) == null || valueOf.equals(bool))) {
                    this.W1 = valueOf;
                } else {
                    this.W1 = valueOf;
                    q2(new Object[]{valueOf, Double.valueOf(fArr6[0]), Double.valueOf(fArr6[1]), Double.valueOf(fArr6[2])}, false);
                }
            }
        }

        @Override // com.llamalab.automate.stmt.U0, android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i8) {
            C2435m c2435m = this.f16578Z1;
            if (c2435m != null) {
                c2435m.getClass();
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            C2435m c2435m = this.f16578Z1;
            if (c2435m != null) {
                c2435m.onSensorChanged(sensorEvent);
            }
            e2(sensorEvent.sensor.getType(), sensorEvent.values);
        }

        public final Sensor y2(int i8) {
            SensorManager sensorManager = this.f17211y1;
            Sensor defaultSensor = sensorManager.getDefaultSensor(i8);
            if (defaultSensor == null || !sensorManager.registerListener(this, defaultSensor, 3, this.f15400Y.f14581L1)) {
                return null;
            }
            return defaultSensor;
        }

        public final void z2(boolean z7) {
            if (this.U1.compareAndSet(!z7, z7)) {
                SensorManager sensorManager = this.f17211y1;
                if (z7) {
                    sensorManager.unregisterListener(this, this.f16576X1);
                    Sensor sensor = this.f16577Y1;
                    if (sensor != null) {
                        sensorManager.unregisterListener(this, sensor);
                        return;
                    }
                    return;
                }
                this.f16580b2 &= 2;
                sensorManager.registerListener(this, this.f16576X1, 3);
                Sensor sensor2 = this.f16577Y1;
                if (sensor2 != null) {
                    sensorManager.registerListener(this, sensor2, 3);
                }
            }
        }
    }

    public static Double B(Double d8) {
        if (d8 == null) {
            return null;
        }
        double d9 = -180.0d;
        if (d8.doubleValue() >= -180.0d) {
            d9 = 180.0d;
            if (d8.doubleValue() <= 180.0d) {
                d9 = d8.doubleValue();
            }
        }
        return Double.valueOf(d9);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_device_orientation_immediate, C2541R.string.caption_device_orientation_change);
        c1596k0.u(C2541R.string.caption_azimuth, this.targetAzimuth);
        c1596k0.u(C2541R.string.caption_pitch, this.targetPitch);
        c1596k0.u(C2541R.string.caption_roll, this.targetRoll);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.targetAzimuth);
        dVar.g(this.targetPitch);
        dVar.g(this.targetRoll);
        dVar.g(this.tolerance);
        dVar.g(this.varCurrentAzimuth);
        dVar.g(this.varCurrentPitch);
        dVar.g(this.varCurrentRoll);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.targetAzimuth);
        visitor.b(this.targetPitch);
        visitor.b(this.targetRoll);
        visitor.b(this.tolerance);
        visitor.b(this.varCurrentAzimuth);
        visitor.b(this.varCurrentPitch);
        visitor.b(this.varCurrentRoll);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1681z();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.targetAzimuth = (InterfaceC1700x0) cVar.readObject();
        this.targetPitch = (InterfaceC1700x0) cVar.readObject();
        this.targetRoll = (InterfaceC1700x0) cVar.readObject();
        this.tolerance = (InterfaceC1700x0) cVar.readObject();
        this.varCurrentAzimuth = (J3.l) cVar.readObject();
        this.varCurrentPitch = (J3.l) cVar.readObject();
        this.varCurrentRoll = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_device_orientation_title);
        c1708z0.w(new a(J1(1) == 0, J3.h.i(c1708z0, this.tolerance, 30.0d), B(J3.h.j(c1708z0, this.targetAzimuth)), B(J3.h.j(c1708z0, this.targetPitch)), B(J3.h.j(c1708z0, this.targetRoll))));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varCurrentAzimuth;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[1]);
        }
        J3.l lVar2 = this.varCurrentPitch;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[2]);
        }
        J3.l lVar3 = this.varCurrentRoll;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, objArr[3]);
        }
        o(c1708z0, ((Boolean) objArr[0]).booleanValue());
        return true;
    }
}
