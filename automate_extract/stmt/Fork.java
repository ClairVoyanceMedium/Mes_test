package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import com.llamalab.automate.A2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.CautionStatement;
import com.llamalab.automate.Visitor;

@F3.f("fork.html")
@F3.a(C2541R.integer.ic_content_split)
@F3.i(C2541R.string.stmt_fork_title)
@F3.h(C2541R.string.stmt_fork_summary)
@F3.b(C2541R.layout.block_fork)
@F3.e(C2541R.layout.stmt_fork_edit)
/* loaded from: classes.dex */
public final class Fork extends Action implements CautionStatement {

    @F3.d(C2541R.id.right)
    public A2 onChildFiber;
    public boolean stopWithParent;
    public J3.l varChildFiberUri;
    public J3.l varParentFiberUri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_fork_title);
        l8.v(this.varChildFiberUri, 0);
        l8.x(C2541R.string.caption_stop_with, this.stopWithParent, 0);
        l8.v(this.varParentFiberUri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.onChildFiber);
        if (9 <= dVar.f6413Z) {
            dVar.write(this.stopWithParent ? 1 : 0);
        }
        dVar.g(this.varChildFiberUri);
        if (23 <= dVar.f6413Z) {
            dVar.g(this.varParentFiberUri);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.onChildFiber);
        visitor.b(this.varChildFiberUri);
        visitor.b(this.varParentFiberUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.onChildFiber = (A2) cVar.readObject();
        if (9 <= cVar.f6409x0) {
            this.stopWithParent = cVar.readBoolean();
        }
        this.varChildFiberUri = (J3.l) cVar.readObject();
        if (23 <= cVar.f6409x0) {
            this.varParentFiberUri = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int i8;
        String str;
        c1708z0.q(C2541R.string.stmt_fork_title);
        if (this.onChildFiber != null) {
            C1708z0 c1708z02 = new C1708z0(c1708z0);
            A2 a22 = this.onChildFiber;
            c1708z02.f17642x0 = a22;
            c1708z02.f17643x1 = a22.g();
            if (this.stopWithParent) {
                c1708z02.f17645y1 = c1708z0.f17644y0;
            }
            J3.l lVar = this.varParentFiberUri;
            if (lVar != null) {
                c1708z02.z(lVar.f4659Y, F5.n.d(c1708z0).toString());
            }
            AutomateService j22 = c1708z0.j2();
            Uri E7 = j22.E(c1708z02, false);
            j22.Y(c1708z02);
            J3.l lVar2 = this.varChildFiberUri;
            if (lVar2 != null) {
                str = E7.toString();
                i8 = lVar2.f4659Y;
                c1708z0.z(i8, str);
            }
        } else {
            J3.l lVar3 = this.varChildFiberUri;
            if (lVar3 != null) {
                i8 = lVar3.f4659Y;
                str = null;
                c1708z0.z(i8, str);
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
