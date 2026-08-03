package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.util.EnumSet;
import p3.C2213b;
import x3.C2434l;
import x3.C2440r;

@F3.f("file_write.html")
@F3.a(C2541R.integer.ic_content_edit)
@F3.i(C2541R.string.stmt_file_write_title)
@F3.h(C2541R.string.stmt_file_write_summary)
@F3.e(C2541R.layout.stmt_file_write_edit)
/* loaded from: classes.dex */
public final class FileWrite extends Action implements AsyncStatement {
    public InterfaceC1700x0 append;
    public InterfaceC1700x0 charset;
    public InterfaceC1700x0 content;
    public InterfaceC1700x0 decode;
    public InterfaceC1700x0 targetFile;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_file_write);
        l8.t(this.targetFile);
        C1596k0 q8 = l8.q(this.targetFile);
        q8.v(this.content, 0);
        return q8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.targetFile);
        dVar.g(this.charset);
        if (82 <= dVar.f6413Z) {
            dVar.g(this.decode);
        }
        dVar.g(this.append);
        dVar.g(this.content);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.targetFile);
        visitor.b(this.charset);
        visitor.b(this.decode);
        visitor.b(this.append);
        visitor.b(this.content);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.targetFile = (InterfaceC1700x0) cVar.readObject();
        this.charset = (InterfaceC1700x0) cVar.readObject();
        if (82 <= cVar.f6409x0) {
            this.decode = (InterfaceC1700x0) cVar.readObject();
        }
        this.append = (InterfaceC1700x0) cVar.readObject();
        this.content = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        AbstractRunnableC1694v2 qVar;
        c1708z0.q(C2541R.string.stmt_file_write_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.targetFile);
        if (p8 == null) {
            throw new RequiredArgumentNullException("targetFile");
        }
        String x7 = J3.h.x(c1708z0, this.content, "");
        InterfaceC1700x0 interfaceC1700x0 = this.charset;
        Charset charset = C2213b.f21561c;
        String x8 = J3.h.x(c1708z0, interfaceC1700x0, null);
        Charset forName = x8 != null ? Charset.forName(x8) : charset;
        String x9 = J3.h.x(c1708z0, this.decode, null);
        boolean f8 = J3.h.f(c1708z0, this.append, false);
        EnumSet of = EnumSet.of(com.llamalab.safs.p.WRITE, com.llamalab.safs.p.CREATE, f8 ? com.llamalab.safs.p.APPEND : com.llamalab.safs.p.TRUNCATE_EXISTING);
        if (x9 == null) {
            qVar = new P3.r(p8, of, forName, x7, new Closeable[0]);
        } else if ("base64".equals(x9)) {
            qVar = new P3.q(p8, of, x7.isEmpty() ? C2434l.f23390a : Base64.decode(x7, 0), new Closeable[0]);
        } else {
            if (!"hex".equals(x9)) {
                throw new IllegalArgumentException("decode");
            }
            qVar = new P3.q(p8, of, x7.isEmpty() ? C2434l.f23390a : C2440r.z(x7), new Closeable[0]);
        }
        c1708z0.w(qVar);
        qVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
