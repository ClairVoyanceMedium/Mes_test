package com.llamalab.automate.stmt;

import android.content.Context;
import android.util.Log;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Arrays;

@F3.f("cpu_speed_set.html")
@F3.a(C2541R.integer.ic_hardware_cpu)
@F3.i(C2541R.string.stmt_cpu_speed_set_title)
@F3.h(C2541R.string.stmt_cpu_speed_set_summary)
@F3.e(C2541R.layout.stmt_cpu_speed_set_edit)
/* loaded from: classes.dex */
public final class CpuSpeedSet extends Action implements AsyncStatement {
    public InterfaceC1700x0 cpu;
    public InterfaceC1700x0 governor;
    public InterfaceC1700x0 maxSpeed;
    public InterfaceC1700x0 minSpeed;
    public InterfaceC1700x0 userSpeed;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final Integer f16507M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f16508N1;

        /* renamed from: O1, reason: collision with root package name */
        public final Double f16509O1;

        /* renamed from: P1, reason: collision with root package name */
        public final Double f16510P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final Double f16511Q1;

        public a(Integer num, String str, Double d8, Double d9, Double d10) {
            this.f16507M1 = num;
            this.f16508N1 = str;
            this.f16509O1 = d8;
            this.f16510P1 = d9;
            this.f16511Q1 = d10;
        }

        public static int y2(double d8, int[] iArr) {
            return y4.j.h(y4.j.b(d8 / 100.0d, 0.0d, 1.0d), iArr);
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                int[] A12 = interfaceC1585h1.A1(3, lVar);
                lVar.c();
                Integer num = this.f16507M1;
                if (num != null) {
                    int T02 = interfaceC1585h1.T0(lVar);
                    lVar.c();
                    if (num.intValue() < 0 || num.intValue() >= T02) {
                        throw new IllegalArgumentException("Illegal CPU #: " + num);
                    }
                    if (Arrays.binarySearch(A12, num.intValue()) < 0) {
                        throw new IllegalStateException("CPU #" + num + " not possible");
                    }
                    boolean R12 = interfaceC1585h1.R1(num.intValue(), lVar);
                    lVar.c();
                    if (!R12) {
                        throw new IllegalStateException("Cpufreq don't exist for CPU #" + num);
                    }
                    z2(interfaceC1585h1, num.intValue(), lVar);
                    lVar.c();
                } else {
                    for (int i8 : A12) {
                        boolean R13 = interfaceC1585h1.R1(i8, lVar);
                        lVar.c();
                        if (R13) {
                            z2(interfaceC1585h1, i8, lVar);
                            lVar.c();
                        } else {
                            Log.w("CpuSpeedSet", "Cpufreq don't exists for CPU #" + i8);
                        }
                    }
                }
                p2(null);
            } catch (Throwable th) {
                r2(th);
            }
        }

        public final void z2(InterfaceC1585h1 interfaceC1585h1, int i8, t3.l lVar) {
            String str = this.f16508N1;
            if (str != null) {
                String[] t12 = interfaceC1585h1.t1(i8, lVar);
                lVar.c();
                if (Arrays.binarySearch(t12, str) < 0) {
                    throw new IllegalStateException("Governor not available for CPU #" + i8 + ": " + str);
                }
                interfaceC1585h1.C0(i8, lVar, str);
                lVar.c();
            }
            Double d8 = this.f16510P1;
            Double d9 = this.f16509O1;
            Double d10 = this.f16511Q1;
            if (d9 == null && d8 == null && d10 == null) {
                return;
            }
            int[] l12 = interfaceC1585h1.l1(i8, lVar);
            lVar.c();
            if (l12.length == 0) {
                throw new IllegalStateException(B4.g.g("No frequencies available for CPU #", i8));
            }
            if (d8 != null) {
                interfaceC1585h1.p0(i8, y2(d8.doubleValue(), l12), lVar);
                lVar.c();
            }
            if (d9 != null) {
                interfaceC1585h1.b2(i8, y2(d9.doubleValue(), l12), lVar);
                lVar.c();
            }
            if (d10 != null) {
                String r12 = interfaceC1585h1.r1(i8, lVar);
                lVar.c();
                if ("userspace".equals(r12)) {
                    interfaceC1585h1.U(i8, y2(d10.doubleValue(), l12), lVar);
                    lVar.c();
                }
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_cpu_speed_set);
        l8.v(this.cpu, 0);
        l8.v(this.governor, 0);
        l8.w(C2541R.string.caption_percent, this.minSpeed);
        l8.w(C2541R.string.caption_percent, this.maxSpeed);
        l8.w(C2541R.string.caption_percent, this.userSpeed);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.cpu);
        dVar.g(this.governor);
        dVar.g(this.minSpeed);
        dVar.g(this.maxSpeed);
        dVar.g(this.userSpeed);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.cpu);
        visitor.b(this.governor);
        visitor.b(this.minSpeed);
        visitor.b(this.maxSpeed);
        visitor.b(this.userSpeed);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.cpu = (InterfaceC1700x0) cVar.readObject();
        this.governor = (InterfaceC1700x0) cVar.readObject();
        this.minSpeed = (InterfaceC1700x0) cVar.readObject();
        this.maxSpeed = (InterfaceC1700x0) cVar.readObject();
        this.userSpeed = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_cpu_speed_set_title);
        c1708z0.w(new a(J3.h.o(c1708z0, this.cpu, null), J3.h.x(c1708z0, this.governor, null), J3.h.j(c1708z0, this.minSpeed), J3.h.j(c1708z0, this.maxSpeed), J3.h.j(c1708z0, this.userSpeed)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
