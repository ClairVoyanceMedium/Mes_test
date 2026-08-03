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
import s4.AbstractC2313a;

@F3.f("gdrive_list.html")
@F3.a(C2541R.integer.ic_gdrive_list)
@F3.i(C2541R.string.stmt_gdrive_list_title)
@F3.h(C2541R.string.stmt_gdrive_list_summary)
@F3.e(C2541R.layout.stmt_gdrive_list_edit)
/* loaded from: classes.dex */
public class GDriveList extends GDriveAction {
    public InterfaceC1700x0 modifiedSince;
    public InterfaceC1700x0 recursive;
    public InterfaceC1700x0 remotePath;
    public InterfaceC1700x0 types;
    public J3.l varFiles;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15542c, com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_gdrive_list);
        l8.t(this.remotePath);
        return l8.q(this.remotePath).f16030c;
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.remotePath);
        dVar.g(this.types);
        dVar.g(this.modifiedSince);
        if (57 <= dVar.f6413Z) {
            dVar.g(this.recursive);
        }
        dVar.g(this.varFiles);
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.remotePath);
        visitor.b(this.types);
        visitor.b(this.modifiedSince);
        visitor.b(this.recursive);
        visitor.b(this.varFiles);
    }

    @Override // com.llamalab.automate.stmt.F
    public final void c(C1708z0 c1708z0, AbstractC2313a abstractC2313a) {
        com.llamalab.safs.gdrive.c cVar = (com.llamalab.safs.gdrive.c) abstractC2313a;
        com.llamalab.safs.n v8 = J3.h.v(c1708z0, this.remotePath, null, cVar.g(), cVar);
        if (v8 == null) {
            throw new RequiredArgumentNullException("remotePath");
        }
        P3.j jVar = new P3.j(v8, J3.h.m(c1708z0, this.types, 3) & 3, k4.f.g(J3.h.t(c1708z0, this.modifiedSince, Long.MIN_VALUE)), J3.h.f(c1708z0, this.recursive, false) ? EnumSet.of(P3.t.f5936X) : Collections.emptySet(), cVar);
        c1708z0.w(jVar);
        jVar.w2();
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.remotePath = (InterfaceC1700x0) cVar.readObject();
        this.types = (InterfaceC1700x0) cVar.readObject();
        this.modifiedSince = (InterfaceC1700x0) cVar.readObject();
        if (57 <= cVar.f6409x0) {
            this.recursive = (InterfaceC1700x0) cVar.readObject();
        }
        this.varFiles = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_gdrive_list_title);
        com.llamalab.automate.access.c.f15542c.w(c1708z0);
        return GoogleAuthorized.b(this, c1708z0, "oauth2:https://www.googleapis.com/auth/drive");
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varFiles;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
