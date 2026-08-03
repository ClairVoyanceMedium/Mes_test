package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("pedometer.html")
@F3.a(C2541R.integer.ic_action_goto)
@F3.i(C2541R.string.stmt_pedometer_title)
@F3.h(C2541R.string.stmt_pedometer_summary)
@F3.e(C2541R.layout.stmt_pedometer_edit)
/* loaded from: classes.dex */
public class Pedometer extends IntermittentAction implements AsyncStatement {
    public InterfaceC1700x0 minSteps;
    public InterfaceC1700x0 stillDuration;
    public J3.l varLastStepTime;
    public J3.l varStepCount;

    public static final class a extends U0 {

        /* renamed from: L1, reason: collision with root package name */
        public volatile SensorEvent f17020L1;

        /* renamed from: M1, reason: collision with root package name */
        public boolean f17021M1 = true;

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            this.f17020L1 = sensorEvent;
            if (this.f17021M1) {
                this.f17021M1 = false;
                o2(1250L, new Object[]{Double.valueOf(sensorEvent.values[0]), Double.valueOf(Pedometer.s(sensorEvent.timestamp))});
            }
        }
    }

    public static final class b extends U0 {

        /* renamed from: L1, reason: collision with root package name */
        public volatile int f17022L1 = Integer.MAX_VALUE;

        /* renamed from: M1, reason: collision with root package name */
        public int f17023M1 = Integer.MAX_VALUE;

        /* renamed from: N1, reason: collision with root package name */
        public int f17024N1;

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            int i8 = (int) sensorEvent.values[0];
            int max = this.f17024N1 + ((int) Math.max(i8 - this.f17023M1, 1L));
            this.f17024N1 = max;
            this.f17023M1 = i8;
            if (max >= this.f17022L1) {
                this.f17022L1 = Integer.MAX_VALUE;
                o2(1000L, new Object[]{Double.valueOf(this.f17024N1), Double.valueOf(Pedometer.s(sensorEvent.timestamp))});
                this.f17024N1 = 0;
            }
        }
    }

    public static final class c extends U0 {

        /* renamed from: L1, reason: collision with root package name */
        public int f17025L1;

        /* renamed from: M1, reason: collision with root package name */
        public volatile boolean f17026M1;

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            this.f17025L1++;
            if (this.f17026M1) {
                this.f17026M1 = false;
                o2(1000L, new Object[]{Double.valueOf(this.f17025L1), Double.valueOf(Pedometer.s(sensorEvent.timestamp))});
                this.f17025L1 = 0;
            }
        }
    }

    public static final class d extends U0 implements Runnable {

        /* renamed from: M1, reason: collision with root package name */
        public long f17028M1;

        /* renamed from: O1, reason: collision with root package name */
        public int f17030O1;

        /* renamed from: P1, reason: collision with root package name */
        public long f17031P1;

        /* renamed from: L1, reason: collision with root package name */
        public volatile int f17027L1 = Integer.MAX_VALUE;

        /* renamed from: N1, reason: collision with root package name */
        public int f17029N1 = Integer.MAX_VALUE;

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            int i8 = (int) sensorEvent.values[0];
            this.f17031P1 = sensorEvent.timestamp;
            int max = this.f17030O1 + ((int) Math.max(i8 - this.f17029N1, 1L));
            this.f17030O1 = max;
            this.f17029N1 = i8;
            if (max >= this.f17027L1) {
                Handler handler = this.f15400Y.f14581L1;
                handler.removeCallbacks(this);
                handler.postDelayed(this, this.f17028M1);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f17027L1 = Integer.MAX_VALUE;
            o2(1000L, new Object[]{Double.valueOf(this.f17030O1), Double.valueOf(Pedometer.s(this.f17031P1))});
            this.f17030O1 = 0;
        }
    }

    public static double s(long j8) {
        double currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        double d8 = j8;
        Double.isNaN(d8);
        Double.isNaN(currentTimeMillis);
        return ((d8 / 1000000.0d) + currentTimeMillis) / 1000.0d;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACTIVITY_RECOGNITION")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_pedometer_immediate, C2541R.string.caption_pedometer_steps_taken, C2541R.string.caption_pedometer_standstill);
        c1596k0.v(this.minSteps, 0);
        c1596k0.w(1, this.stillDuration);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.minSteps);
        dVar.g(this.stillDuration);
        dVar.g(this.varStepCount);
        dVar.g(this.varLastStepTime);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.minSteps);
        visitor.b(this.stillDuration);
        visitor.b(this.varStepCount);
        visitor.b(this.varLastStepTime);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new C1676w0();
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.minSteps = (InterfaceC1700x0) cVar.readObject();
        this.stillDuration = (InterfaceC1700x0) cVar.readObject();
        this.varStepCount = (J3.l) cVar.readObject();
        this.varLastStepTime = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_pedometer_title);
        IncapableAndroidVersionException.b(19, "pedometer sensor");
        int J12 = J1(1);
        if (J12 == 0) {
            a aVar = (a) c1708z0.c(a.class);
            if (aVar == null) {
                a aVar2 = new a();
                c1708z0.w(aVar2);
                aVar2.v2(19, 100000);
                return false;
            }
            F5.n.h(aVar);
            SensorEvent sensorEvent = aVar.f17020L1;
            Double valueOf = Double.valueOf(sensorEvent.values[0]);
            Double valueOf2 = Double.valueOf(s(sensorEvent.timestamp));
            J3.l lVar = this.varStepCount;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, valueOf);
            }
            J3.l lVar2 = this.varLastStepTime;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, valueOf2);
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        if (J12 != 1) {
            if (J12 != 2) {
                throw new IllegalStateException("continuity");
            }
            int max = Math.max(J3.h.m(c1708z0, this.minSteps, 1), 1);
            long max2 = Math.max(J3.h.t(c1708z0, this.stillDuration, 5000L), 1000L);
            d dVar = (d) c1708z0.c(d.class);
            if (dVar != null) {
                F5.n.h(dVar);
            } else {
                dVar = new d();
                c1708z0.w(dVar);
                dVar.v2(19, 1000000);
            }
            dVar.f17028M1 = max2;
            dVar.f17027L1 = max;
            return false;
        }
        int max3 = Math.max(J3.h.m(c1708z0, this.minSteps, 1), 1);
        if (max3 == 1) {
            c cVar = (c) c1708z0.c(c.class);
            if (cVar != null) {
                F5.n.h(cVar);
            } else {
                cVar = new c();
                c1708z0.w(cVar);
                cVar.v2(18, 0);
            }
            c1708z0.H(b.class);
            cVar.f17026M1 = true;
        } else {
            b bVar = (b) c1708z0.c(b.class);
            if (bVar != null) {
                F5.n.h(bVar);
            } else {
                bVar = new b();
                c1708z0.w(bVar);
                bVar.v2(19, 500000);
            }
            c1708z0.H(c.class);
            bVar.f17022L1 = max3;
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        Double d8 = (Double) objArr[0];
        Double d9 = (Double) objArr[1];
        J3.l lVar = this.varStepCount;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varLastStepTime;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d9);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
