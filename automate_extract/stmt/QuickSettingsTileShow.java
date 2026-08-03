package com.llamalab.automate.stmt;

import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import g4.C1827a;

@F3.f("quick_settings_tile_show.html")
@F3.a(C2541R.integer.ic_quick_settings)
@F3.i(C2541R.string.stmt_quick_settings_tile_show_title)
@F3.h(C2541R.string.stmt_quick_settings_tile_show_summary)
@F3.e(C2541R.layout.stmt_quick_settings_tile_show_edit)
/* loaded from: classes.dex */
public final class QuickSettingsTileShow extends Decision implements AsyncStatement {
    public InterfaceC1700x0 active;
    public InterfaceC1700x0 flags;
    public InterfaceC1700x0 iconUri;
    public InterfaceC1700x0 label;
    public InterfaceC1700x0 subtitle;
    public J3.l varFlags;

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.label);
        dVar.g(this.iconUri);
        if (97 <= dVar.f6413Z) {
            dVar.g(this.subtitle);
        }
        dVar.g(this.active);
        if (109 <= dVar.f6413Z) {
            dVar.g(this.flags);
        }
        if (100 <= dVar.f6413Z) {
            dVar.g(this.varFlags);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.label);
        visitor.b(this.iconUri);
        visitor.b(this.subtitle);
        visitor.b(this.active);
        visitor.b(this.flags);
        visitor.b(this.varFlags);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.label = (InterfaceC1700x0) cVar.readObject();
        this.iconUri = N.b(cVar);
        if (97 <= cVar.f6409x0) {
            this.subtitle = (InterfaceC1700x0) cVar.readObject();
        }
        this.active = (InterfaceC1700x0) cVar.readObject();
        if (109 <= cVar.f6409x0) {
            this.flags = (InterfaceC1700x0) cVar.readObject();
        }
        if (100 <= cVar.f6409x0) {
            this.varFlags = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_quick_settings_tile_show_title);
        M0 m02 = (M0) c1708z0.c(M0.class);
        if (m02 != null) {
            F5.n.h(m02);
            m02.f15404y0 = this.f16218X;
        } else {
            m02 = new M0();
            c1708z0.w(m02);
        }
        m02.f16886L1 = J3.h.x(c1708z0, this.label, null);
        m02.f16887M1 = J3.h.g(c1708z0, this.iconUri, C1827a.h.a(c1708z0.getResources().getInteger(C2541R.integer.ic_quick_settings)).build());
        m02.f16888N1 = J3.h.x(c1708z0, this.subtitle, null);
        m02.f16889O1 = J3.h.f(c1708z0, this.active, false);
        m02.f16890P1 = J3.h.m(c1708z0, this.flags, 0);
        try {
            if (m02.B2()) {
                return false;
            }
            m02.a();
            o(c1708z0, false);
            return true;
        } catch (Throwable th) {
            m02.a();
            throw th;
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        if (!((Boolean) objArr[0]).booleanValue()) {
            o(c1708z0, false);
            return true;
        }
        J3.l lVar = this.varFlags;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, (Double) objArr[1]);
        }
        o(c1708z0, true);
        return true;
    }
}
