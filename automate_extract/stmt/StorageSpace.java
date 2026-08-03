package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("storage_space.html")
@F3.a(C2541R.integer.ic_device_access_storage)
@F3.i(C2541R.string.stmt_storage_space_title)
@F3.h(C2541R.string.stmt_storage_space_summary)
@F3.e(C2541R.layout.stmt_storage_space_edit)
/* loaded from: classes.dex */
public class StorageSpace extends IntermittentDecision implements ReceiverStatement {
    public J3.l varUsableSpace;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_storage_space_immediate, C2541R.string.caption_storage_space_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, "android.intent.action.DEVICE_STORAGE_OK".equals(intent.getAction()));
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (47 <= dVar.f6413Z) {
            dVar.g(this.varUsableSpace);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varUsableSpace);
    }

    @Override // com.llamalab.automate.stmt.Decision
    public final void o(C1708z0 c1708z0, boolean z7) {
        J3.l lVar = this.varUsableSpace;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, Double.valueOf(Environment.getExternalStorageDirectory().getUsableSpace()));
        }
        super.o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (47 <= cVar.f6409x0) {
            this.varUsableSpace = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_storage_space_title);
        boolean z7 = c1708z0.registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null;
        if (J1(1) == 0) {
            o(c1708z0, z7);
            return true;
        }
        AbstractC1618p2.c.a aVar = new AbstractC1618p2.c.a();
        c1708z0.w(aVar);
        aVar.h(z7 ? "android.intent.action.DEVICE_STORAGE_LOW" : "android.intent.action.DEVICE_STORAGE_OK");
        return false;
    }
}
