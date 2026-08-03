package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.nio.charset.Charset;

@F3.f("file_read.html")
@F3.a(C2541R.integer.ic_glasses)
@F3.i(C2541R.string.stmt_file_read_title)
@F3.h(C2541R.string.stmt_file_read_summary)
@F3.e(C2541R.layout.stmt_file_read_edit)
/* loaded from: classes.dex */
public final class FileRead extends Action implements AsyncStatement {
    public InterfaceC1700x0 charset;
    public InterfaceC1700x0 sourceFile;
    public J3.l varContent;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_file_read);
        l8.t(this.sourceFile);
        return l8.q(this.sourceFile).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.sourceFile);
        dVar.g(this.charset);
        dVar.g(this.varContent);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.sourceFile);
        visitor.b(this.charset);
        visitor.b(this.varContent);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.sourceFile = (InterfaceC1700x0) cVar.readObject();
        this.charset = (InterfaceC1700x0) cVar.readObject();
        this.varContent = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_file_read_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.sourceFile);
        if (p8 == null) {
            throw new RequiredArgumentNullException("sourceFile");
        }
        String x7 = J3.h.x(c1708z0, this.charset, null);
        P3.m mVar = new P3.m(p8, x7 != null ? Charset.forName(x7) : null);
        c1708z0.w(mVar);
        mVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varContent;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
