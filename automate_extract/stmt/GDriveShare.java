package com.llamalab.automate.stmt;

import android.content.Context;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.io.Closeable;
import java.io.InterruptedIOException;
import n4.InterfaceC2178a;
import s4.AbstractC2313a;

@F3.f("gdrive_share.html")
@F3.a(C2541R.integer.ic_gdrive_share)
@F3.i(C2541R.string.stmt_gdrive_share_title)
@F3.h(C2541R.string.stmt_gdrive_share_summary)
@F3.e(C2541R.layout.stmt_gdrive_share_edit)
/* loaded from: classes.dex */
public final class GDriveShare extends GDriveAction {
    public InterfaceC1700x0 remotePath;
    public J3.l varDownloadUrl;

    public static final class a extends P3.b {

        /* renamed from: M1, reason: collision with root package name */
        public final com.llamalab.safs.n f16677M1;

        public a(com.llamalab.safs.n nVar, Closeable... closeableArr) {
            super(closeableArr);
            this.f16677M1 = nVar;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            com.llamalab.safs.n nVar = this.f16677M1;
            try {
                try {
                    com.llamalab.safs.k[] kVarArr = com.llamalab.safs.i.f17783a;
                    ((InterfaceC2178a) nVar.E().f22244X.getFileAttributeView(nVar, InterfaceC2178a.class, new com.llamalab.safs.k[0])).a(new n4.c());
                    P3.b.y2();
                    n4.b bVar = (n4.b) com.llamalab.safs.i.o(nVar, n4.b.class, new com.llamalab.safs.k[0]);
                    StringBuilder sb = new StringBuilder("https://drive.google.com/uc?id=");
                    sb.append(bVar.f());
                    sb.append("&export=download");
                    String b8 = bVar.b();
                    if (!TextUtils.isEmpty(b8)) {
                        sb.append("&resourcekey=");
                        sb.append(b8);
                    }
                    String sb2 = sb.toString();
                    close();
                    q2(sb2, false);
                } catch (InterruptedIOException e8) {
                    if (!Thread.currentThread().isInterrupted()) {
                        throw e8;
                    }
                    close();
                }
            } catch (Throwable th) {
                close();
                throw th;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15542c, com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_gdrive_share);
        l8.t(this.remotePath);
        return l8.q(this.remotePath).f16030c;
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.remotePath);
        dVar.g(this.varDownloadUrl);
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.remotePath);
        visitor.b(this.varDownloadUrl);
    }

    @Override // com.llamalab.automate.stmt.F
    public final void c(C1708z0 c1708z0, AbstractC2313a abstractC2313a) {
        com.llamalab.safs.gdrive.c cVar = (com.llamalab.safs.gdrive.c) abstractC2313a;
        com.llamalab.safs.n v8 = J3.h.v(c1708z0, this.remotePath, null, cVar.g(), cVar);
        if (v8 == null) {
            throw new RequiredArgumentNullException("remotePath");
        }
        a aVar = new a(v8, cVar);
        c1708z0.w(aVar);
        aVar.w2();
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.remotePath = (InterfaceC1700x0) cVar.readObject();
        this.varDownloadUrl = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_gdrive_share_title);
        com.llamalab.automate.access.c.f15542c.w(c1708z0);
        return GoogleAuthorized.b(this, c1708z0, "oauth2:https://www.googleapis.com/auth/drive");
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varDownloadUrl;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
