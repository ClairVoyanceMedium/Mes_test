package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import p4.C2216c;
import s4.AbstractC2313a;

@F3.f("onedrive_make_directory.html")
@F3.a(C2541R.integer.ic_ftp_folder)
@F3.i(C2541R.string.stmt_onedrive_make_directory_title)
@F3.h(C2541R.string.stmt_onedrive_make_directory_summary)
@F3.e(C2541R.layout.stmt_onedrive_make_directory_edit)
/* loaded from: classes.dex */
public final class OneDriveMakeDirectory extends OneDriveAction {
    public InterfaceC1700x0 remotePath;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15542c, com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_onedrive_make_directory);
        l8.t(this.remotePath);
        return l8.q(this.remotePath).f16030c;
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.remotePath);
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.remotePath);
    }

    @Override // com.llamalab.automate.stmt.F
    public final void c(C1708z0 c1708z0, AbstractC2313a abstractC2313a) {
        C2216c c2216c = (C2216c) abstractC2313a;
        com.llamalab.safs.n v8 = J3.h.v(c1708z0, this.remotePath, null, c2216c.g(), c2216c);
        if (v8 == null) {
            throw new RequiredArgumentNullException("remotePath");
        }
        P3.k kVar = new P3.k(v8, c2216c);
        c1708z0.w(kVar);
        kVar.w2();
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.remotePath = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_onedrive_make_directory_title);
        com.llamalab.automate.access.c.f15542c.w(c1708z0);
        ThirdPartyAuthorized.a(this, c1708z0);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        if (!(w8 instanceof P3.k)) {
            return ThirdPartyAuthorized.b(this, c1708z0, w8, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
