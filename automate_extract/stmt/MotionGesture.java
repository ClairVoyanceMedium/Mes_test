package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1564d1;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import java.util.Arrays;
import n3.m;
import n3.n;

@F3.f("motion_gesture.html")
@F3.a(C2541R.integer.ic_wand)
@F3.i(C2541R.string.stmt_motion_gesture_title)
@F3.h(C2541R.string.stmt_motion_gesture_summary)
@F3.e(C2541R.layout.stmt_motion_gesture_edit)
/* loaded from: classes.dex */
public class MotionGesture extends Action implements AsyncStatement {
    public n3.e gesture;
    public String name;

    public static class a extends com.llamalab.automate.W implements C1564d1.a {
        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            C1564d1 c1564d1;
            synchronized (automateService) {
                if (automateService.U1 == null) {
                    automateService.U1 = new C1564d1(automateService);
                }
                c1564d1 = automateService.U1;
            }
            Handler handler = c1564d1.f15705x1;
            handler.sendMessage(handler.obtainMessage(2, this));
            u2();
        }

        @Override // com.llamalab.automate.C1564d1.a
        public final void x0(m.a aVar) {
            if (aVar.f21012a < aVar.f21013b) {
                q2(null, false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_motion_gesture);
        l8.C(this.name);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        n3.d dVar2;
        super.Y0(dVar);
        if (46 <= dVar.f6413Z) {
            dVar.g(this.gesture);
        } else {
            n3.e eVar = this.gesture;
            boolean z7 = eVar instanceof n3.b;
            n.a aVar = n3.n.f21015X;
            if (z7) {
                n3.b bVar = (n3.b) eVar;
                int i8 = bVar.f20992X;
                int i9 = bVar.f20993Y;
                byte[] bArr = bVar.f20994Z;
                int i10 = i9 * i8;
                float[] fArr = new float[i10];
                while (true) {
                    i10--;
                    if (i10 < 0) {
                        break;
                    } else {
                        fArr[i10] = (bArr[i10] - (-128.0f)) / 255.0f;
                    }
                }
                if (i8 <= 0) {
                    throw new IllegalArgumentException("dimensions");
                }
                dVar.f(i8);
                dVar.f(i9);
                int i11 = i9 * i8;
                int i12 = 0;
                while (true) {
                    i11--;
                    if (i11 < 0) {
                        break;
                    }
                    dVar.writeFloat(fArr[i12]);
                    i12++;
                }
            } else {
                if (eVar instanceof n3.d) {
                    n3.d dVar3 = (n3.d) eVar;
                    int i13 = dVar3.f20992X;
                    int i14 = dVar3.f20993Y;
                    dVar2 = new n3.d(i13, i14, Arrays.copyOf(dVar3.f20997Z, i14 * i13));
                    dVar2.j1(aVar, -128.0f, 255.0f);
                } else {
                    dVar2 = new n3.d();
                }
                dVar2.Y0(dVar);
            }
        }
        dVar.k(this.name);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1661o0();
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (46 <= cVar.f6409x0) {
            this.gesture = (n3.e) cVar.readObject();
        } else {
            n3.d dVar = new n3.d();
            this.gesture = dVar;
            dVar.o0(cVar);
            this.gesture.j1(n3.n.f21016Y, 0.0f, 1.0f);
        }
        this.name = cVar.i();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        C1564d1 c1564d1;
        c1708z0.q(C2541R.string.stmt_motion_gesture_title);
        if (this.gesture.size() == 0) {
            throw new IllegalStateException("No gesture recorded");
        }
        a aVar = new a();
        c1708z0.w(aVar);
        n3.e eVar = this.gesture;
        AutomateService automateService = aVar.f15400Y;
        synchronized (automateService) {
            if (automateService.U1 == null) {
                automateService.U1 = new C1564d1(automateService);
            }
            c1564d1 = automateService.U1;
        }
        Handler handler = c1564d1.f15705x1;
        handler.sendMessage(handler.obtainMessage(1, new Object[]{aVar, eVar}));
        if (c1564d1.f15703M1.compareAndSet(false, true)) {
            SensorManager sensorManager = (SensorManager) c1564d1.f15706y0.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                throw new UnsupportedOperationException("No accelerometer");
            }
            if (!sensorManager.registerListener(c1564d1, defaultSensor, 1, handler)) {
                throw new IllegalStateException("Failed to register sensor: " + defaultSensor);
            }
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
