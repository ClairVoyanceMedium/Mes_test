package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("android_version.html")
@F3.a(C2541R.integer.ic_android)
@F3.i(C2541R.string.stmt_android_version_title)
@F3.h(C2541R.string.stmt_android_version_summary)
@F3.e(C2541R.layout.stmt_android_version_edit)
/* loaded from: classes.dex */
public class AndroidVersion extends Decision {
    public InterfaceC1700x0 maxLevel;
    public InterfaceC1700x0 minLevel;
    public J3.l varLevel;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_android_version);
        l8.n(this.minLevel, this.maxLevel, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.minLevel);
        dVar.g(this.maxLevel);
        dVar.g(this.varLevel);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.minLevel);
        visitor.b(this.maxLevel);
        visitor.b(this.varLevel);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.minLevel = (InterfaceC1700x0) cVar.readObject();
        this.maxLevel = (InterfaceC1700x0) cVar.readObject();
        this.varLevel = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_android_version_title);
        Integer o6 = J3.h.o(c1708z0, this.minLevel, null);
        Integer o8 = J3.h.o(c1708z0, this.maxLevel, null);
        int i8 = Build.VERSION.SDK_INT;
        boolean z7 = (o6 == null || i8 >= o6.intValue()) && (o8 == null || i8 <= o8.intValue());
        J3.l lVar = this.varLevel;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, Double.valueOf(i8));
        }
        o(c1708z0, z7);
        return true;
    }
}
