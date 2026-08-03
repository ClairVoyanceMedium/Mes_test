package com.llamalab.automate.stmt;

import com.llamalab.automate.A2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.CautionStatement;
import com.llamalab.automate.FlowStore;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.ReturnStatement;
import com.llamalab.automate.Visitor;
import g4.C1827a;

@F3.f("subroutine.html")
@F3.a(C2541R.integer.ic_content_divert)
@F3.i(C2541R.string.stmt_subroutine_title)
@F3.h(C2541R.string.stmt_subroutine_summary)
@F3.b(C2541R.layout.block_fork)
@F3.e(C2541R.layout.stmt_subroutine_edit)
/* loaded from: classes.dex */
public final class Subroutine extends Action implements InterfaceC1622q2, ReturnStatement, CautionStatement {

    @F3.d(C2541R.id.right)
    public A2 onChildFiber;
    public J3.l[] returnVariables = J3.l.f4657Z;

    /* renamed from: L1, reason: collision with root package name */
    public int f17167L1 = -1;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.onChildFiber);
        dVar.h(this.returnVariables);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.onChildFiber);
        visitor.a(this.returnVariables);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f17167L1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.onChildFiber = (A2) cVar.readObject();
        this.returnVariables = (J3.l[]) cVar.g(this.returnVariables);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        boolean z7;
        c1708z0.q(C2541R.string.stmt_subroutine_title);
        AutomateService j22 = c1708z0.j2();
        Long l8 = (Long) c1708z0.j(this.f17167L1);
        if (l8 != null) {
            long longValue = l8.longValue();
            FlowStore flowStore = j22.f14588S1;
            if (!flowStore.f14942a.containsKey(Long.valueOf(longValue))) {
                com.llamalab.automate.F0 f02 = c1708z0.f17641Z;
                if (flowStore.d(C1827a.e.a(f02.f14847y0, longValue).build(), "flow_version=" + f02.f14848y1) == 0) {
                    z7 = false;
                    if (!z7) {
                        return false;
                    }
                    c1708z0.z(this.f17167L1, null);
                }
            }
            z7 = true;
            if (!z7) {
            }
        } else if (this.onChildFiber != null) {
            C1708z0 c1708z02 = new C1708z0(c1708z0);
            A2 a22 = this.onChildFiber;
            c1708z02.f17642x0 = a22;
            c1708z02.f17643x1 = a22.g();
            c1708z02.f17645y1 = c1708z0.f17644y0;
            c1708z02.f17634L1 = this.f16218X;
            j22.E(c1708z02, false);
            j22.Y(c1708z02);
            c1708z0.z(this.f17167L1, Long.valueOf(c1708z02.f17644y0));
            return false;
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.ReturnStatement
    public final void t(C1708z0 c1708z0, C1708z0 c1708z02) {
        AutomateService j22 = c1708z0.j2();
        J3.l[] lVarArr = this.returnVariables;
        if (lVarArr.length != 0) {
            for (J3.l lVar : lVarArr) {
                c1708z0.z(lVar.f4659Y, c1708z02.j(lVar.f4659Y));
            }
            j22.g(c1708z0);
        }
        j22.Y(c1708z0);
    }
}
