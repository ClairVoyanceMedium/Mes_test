package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

@F3.f("cpu_speed_get.html")
@F3.a(C2541R.integer.ic_hardware_cpu)
@F3.i(C2541R.string.stmt_cpu_speed_get_title)
@F3.h(C2541R.string.stmt_cpu_speed_get_summary)
@F3.e(C2541R.layout.stmt_cpu_speed_get_edit)
/* loaded from: classes.dex */
public final class CpuSpeedGet extends Action implements AsyncStatement {
    public InterfaceC1700x0 cpu;
    public J3.l varAvailableGovernors;
    public J3.l varCpuCount;
    public J3.l varGovernor;
    public J3.l varMaxSpeed;
    public J3.l varMinSpeed;
    public J3.l varUserSpeed;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final int f16500M1;

        /* renamed from: N1, reason: collision with root package name */
        public J3.a f16501N1;

        /* renamed from: O1, reason: collision with root package name */
        public String f16502O1;

        /* renamed from: P1, reason: collision with root package name */
        public int f16503P1;

        /* renamed from: Q1, reason: collision with root package name */
        public Double f16504Q1;

        /* renamed from: R1, reason: collision with root package name */
        public Double f16505R1;

        /* renamed from: S1, reason: collision with root package name */
        public Double f16506S1;

        public a(int i8) {
            this.f16500M1 = i8;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                this.f16503P1 = interfaceC1585h1.T0(lVar);
                lVar.c();
                int i8 = this.f16500M1;
                if (i8 < 0 || i8 >= this.f16503P1) {
                    throw new IllegalArgumentException("Illegal CPU #: " + i8);
                }
                int[] A12 = interfaceC1585h1.A1(3, lVar);
                lVar.c();
                if (Arrays.binarySearch(A12, i8) < 0) {
                    throw new IllegalStateException("CPU #" + i8 + " unavailable");
                }
                String[] t12 = interfaceC1585h1.t1(i8, lVar);
                lVar.c();
                Pattern pattern = J3.h.f4650a;
                int length = t12.length;
                Object[] objArr = new Object[length];
                System.arraycopy(t12, 0, objArr, 0, length);
                this.f16501N1 = new J3.a(length, objArr);
                this.f16502O1 = interfaceC1585h1.r1(i8, lVar);
                lVar.c();
                int[] l12 = interfaceC1585h1.l1(i8, lVar);
                lVar.c();
                if (l12.length != 0) {
                    int i9 = l12[0];
                    int i10 = l12[l12.length - 1];
                    this.f16504Q1 = Double.valueOf(CpuSpeedGet.q(interfaceC1585h1.Z0(i8, lVar), i9, i10));
                    lVar.c();
                    this.f16505R1 = Double.valueOf(CpuSpeedGet.q(interfaceC1585h1.q2(i8, lVar), i9, i10));
                    lVar.c();
                    try {
                        this.f16506S1 = Double.valueOf(CpuSpeedGet.q(interfaceC1585h1.I0(i8, lVar), i9, i10));
                        lVar.c();
                    } catch (FileNotFoundException | Exception unused) {
                    } catch (IOException e8) {
                        throw e8;
                    }
                }
                q2(null, false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static double q(int i8, int i9, int i10) {
        if (i9 == i10) {
            return 100.0d;
        }
        double max = Math.max(0, i8 - i9);
        Double.isNaN(max);
        Double.isNaN(max);
        double d8 = i10 - i9;
        Double.isNaN(d8);
        Double.isNaN(d8);
        return y4.j.b((max * 100.0d) / d8, 0.0d, 100.0d);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_cpu_speed_get);
        l8.v(this.cpu, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.cpu);
        dVar.g(this.varCpuCount);
        dVar.g(this.varAvailableGovernors);
        dVar.g(this.varGovernor);
        dVar.g(this.varMinSpeed);
        dVar.g(this.varMaxSpeed);
        dVar.g(this.varUserSpeed);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.cpu);
        visitor.b(this.varCpuCount);
        visitor.b(this.varAvailableGovernors);
        visitor.b(this.varGovernor);
        visitor.b(this.varMinSpeed);
        visitor.b(this.varMaxSpeed);
        visitor.b(this.varUserSpeed);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.cpu = (InterfaceC1700x0) cVar.readObject();
        this.varCpuCount = (J3.l) cVar.readObject();
        this.varAvailableGovernors = (J3.l) cVar.readObject();
        this.varGovernor = (J3.l) cVar.readObject();
        this.varMinSpeed = (J3.l) cVar.readObject();
        this.varMaxSpeed = (J3.l) cVar.readObject();
        this.varUserSpeed = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_cpu_speed_get_title);
        c1708z0.w(new a(J3.h.m(c1708z0, this.cpu, 0)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        a aVar = (a) w8;
        J3.l lVar = this.varCpuCount;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, Double.valueOf(aVar.f16503P1));
        }
        J3.l lVar2 = this.varAvailableGovernors;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, aVar.f16501N1);
        }
        J3.l lVar3 = this.varGovernor;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, aVar.f16502O1);
        }
        J3.l lVar4 = this.varMinSpeed;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, aVar.f16504Q1);
        }
        J3.l lVar5 = this.varMaxSpeed;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, aVar.f16505R1);
        }
        J3.l lVar6 = this.varUserSpeed;
        if (lVar6 != null) {
            c1708z0.z(lVar6.f4659Y, aVar.f16506S1);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
