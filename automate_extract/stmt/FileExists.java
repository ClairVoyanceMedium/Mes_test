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
import java.io.Closeable;

@F3.f("file_exists.html")
@F3.a(C2541R.integer.ic_collections_collection_exists)
@F3.i(C2541R.string.stmt_file_exists_title)
@F3.h(C2541R.string.stmt_file_exists_summary)
@F3.e(C2541R.layout.stmt_file_exists_edit)
/* loaded from: classes.dex */
public final class FileExists extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 path;
    public J3.l varLastModified;
    public J3.l varSize;
    public J3.l varType;

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
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_file_exists_immediate, C2541R.string.caption_file_exists_change);
        c1596k0.t(this.path);
        return c1596k0.q(this.path).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.path);
        if (56 <= dVar.f6413Z) {
            dVar.g(this.varType);
        }
        if (22 <= dVar.f6413Z) {
            dVar.g(this.varSize);
            dVar.g(this.varLastModified);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.path);
        visitor.b(this.varType);
        visitor.b(this.varSize);
        visitor.b(this.varLastModified);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.path = (InterfaceC1700x0) cVar.readObject();
        if (56 <= cVar.f6409x0) {
            this.varType = (J3.l) cVar.readObject();
        }
        if (22 <= cVar.f6409x0) {
            this.varSize = (J3.l) cVar.readObject();
            this.varLastModified = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_file_exists_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.path);
        if (p8 == null) {
            throw new RequiredArgumentNullException("path");
        }
        if (J1(1) == 0) {
            P3.h hVar = new P3.h(p8, new Closeable[0]);
            c1708z0.w(hVar);
            hVar.w2();
        } else {
            P3.i iVar = new P3.i(p8);
            c1708z0.w(iVar);
            iVar.v2();
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varType;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[1]);
        }
        J3.l lVar2 = this.varSize;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[2]);
        }
        J3.l lVar3 = this.varLastModified;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, objArr[3]);
        }
        o(c1708z0, ((Boolean) objArr[0]).booleanValue());
        return true;
    }
}
