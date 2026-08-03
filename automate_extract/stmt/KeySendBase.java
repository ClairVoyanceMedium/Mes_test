package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.b(C2541R.layout.block_try)
@F3.a(C2541R.integer.ic_action_key_press)
/* loaded from: classes.dex */
abstract class KeySendBase extends Decision implements AsyncStatement {
    public int method;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = this.method;
        return 1 == i8 ? new E3.b[]{com.llamalab.automate.access.c.f15540a} : i8 == 0 ? new E3.b[]{com.llamalab.automate.access.c.f15549j} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (99 <= dVar.f6413Z) {
            dVar.writeInt(this.method);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.method = 99 <= cVar.f6409x0 ? cVar.readInt() : 0;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
