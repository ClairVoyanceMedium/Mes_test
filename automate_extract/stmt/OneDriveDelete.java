package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import p4.C2216c;
import s4.AbstractC2313a;

@F3.f("onedrive_delete.html")
@F3.a(C2541R.integer.ic_ftp_discard)
@F3.i(C2541R.string.stmt_onedrive_delete_title)
@F3.h(C2541R.string.stmt_onedrive_delete_summary)
@F3.e(C2541R.layout.stmt_onedrive_delete_edit)
/* loaded from: classes.dex */
public final class OneDriveDelete extends OneDriveAction {
    public InterfaceC1700x0 recursive;
    public InterfaceC1700x0 remotePath;
    public InterfaceC1700x0 trash;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15542c, com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_onedrive_delete);
        l8.t(this.remotePath);
        return l8.q(this.remotePath).y(this.recursive, C2541R.string.caption_recursive, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.remotePath);
        dVar.g(this.recursive);
        dVar.g(this.trash);
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.remotePath);
        visitor.b(this.recursive);
        visitor.b(this.trash);
    }

    @Override // com.llamalab.automate.stmt.F
    public final void c(C1708z0 c1708z0, AbstractC2313a abstractC2313a) {
        C2216c c2216c = (C2216c) abstractC2313a;
        com.llamalab.safs.n v8 = J3.h.v(c1708z0, this.remotePath, null, c2216c.g(), c2216c);
        if (v8 == null) {
            throw new RequiredArgumentNullException("remotePath");
        }
        Set of = J3.h.f(c1708z0, this.recursive, false) ? EnumSet.of(P3.t.f5936X) : Collections.emptySet();
        c2216c.f21571S1 = J3.h.f(c1708z0, this.trash, true);
        P3.g gVar = new P3.g(v8, of, c2216c);
        c1708z0.w(gVar);
        gVar.w2();
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.remotePath = (InterfaceC1700x0) cVar.readObject();
        this.recursive = (InterfaceC1700x0) cVar.readObject();
        this.trash = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_onedrive_delete_title);
        com.llamalab.automate.access.c.f15542c.w(c1708z0);
        ThirdPartyAuthorized.a(this, c1708z0);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        if (!(w8 instanceof P3.g)) {
            return ThirdPartyAuthorized.b(this, c1708z0, w8, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
