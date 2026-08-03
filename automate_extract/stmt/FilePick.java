package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.PathPickActivity;
import com.llamalab.automate.Visitor;
import java.io.File;

@F3.f("file_pick.html")
@F3.a(C2541R.integer.ic_content_accept)
@F3.i(C2541R.string.stmt_file_pick_title)
@F3.h(C2541R.string.stmt_file_pick_summary)
@F3.e(C2541R.layout.stmt_file_pick_edit)
/* loaded from: classes.dex */
public final class FilePick extends ActivityDecision {
    public InterfaceC1700x0 allowNew;
    public InterfaceC1700x0 fileExtension;
    public InterfaceC1700x0 initialPath;
    public InterfaceC1700x0 types;
    public J3.l varPickedPath;
    public InterfaceC1700x0 writable;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_file_pick);
        l8.v(this.varPickedPath, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.types);
        if (93 <= dVar.f6413Z) {
            dVar.g(this.writable);
        }
        dVar.g(this.allowNew);
        if (84 <= dVar.f6413Z) {
            dVar.g(this.fileExtension);
        }
        if (36 <= dVar.f6413Z) {
            dVar.g(this.initialPath);
        }
        dVar.g(this.varPickedPath);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.types);
        visitor.b(this.writable);
        visitor.b(this.allowNew);
        visitor.b(this.fileExtension);
        visitor.b(this.initialPath);
        visitor.b(this.varPickedPath);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.types = (InterfaceC1700x0) cVar.readObject();
        if (93 <= cVar.f6409x0) {
            this.writable = (InterfaceC1700x0) cVar.readObject();
        }
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.allowNew = interfaceC1700x0;
        if (93 > cVar.f6409x0 && (interfaceC1700x0 instanceof J3.k) && J3.h.J(interfaceC1700x0)) {
            this.writable = new L3.J(1);
        }
        if (84 <= cVar.f6409x0) {
            this.fileExtension = (InterfaceC1700x0) cVar.readObject();
        }
        if (36 <= cVar.f6409x0) {
            this.initialPath = (InterfaceC1700x0) cVar.readObject();
        }
        this.varPickedPath = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        Uri data;
        if (-1 != i8 || (data = intent.getData()) == null) {
            J3.l lVar = this.varPickedPath;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        String path = data.getPath();
        J3.l lVar2 = this.varPickedPath;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, path);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        String[] split;
        c1708z0.q(C2541R.string.stmt_file_pick_title);
        int m8 = J3.h.m(c1708z0, this.types, 3);
        File k8 = J3.h.k(c1708z0, this.initialPath, null, Environment.getExternalStorageDirectory());
        boolean f8 = J3.h.f(c1708z0, this.allowNew, false);
        boolean f9 = J3.h.f(c1708z0, this.writable, false);
        Object u8 = J3.h.u(c1708z0, this.fileExtension, null);
        if (u8 == null) {
            split = null;
        } else if (u8 instanceof J3.a) {
            split = J3.h.i0((J3.a) u8);
        } else if (u8 instanceof J3.e) {
            J3.e eVar = (J3.e) u8;
            split = (String[]) eVar.t0(new String[eVar.f4641x1]);
        } else {
            split = u8.toString().split("\\s*,\\s*");
        }
        c1708z0.D(new Intent("android.intent.action.PICK", k8 != null ? Uri.fromFile(k8) : null, c1708z0, PathPickActivity.class).putExtra("com.llamalab.automate.intent.extra.PICK_WRITABLE", f9).putExtra("com.llamalab.automate.intent.extra.PICK_NEW", f8).putExtra("com.llamalab.automate.intent.extra.PICK_FILE", (m8 & 1) != 0).putExtra("com.llamalab.automate.intent.extra.PICK_DIRECTORY", (m8 & 2) != 0).putExtra("com.llamalab.automate.intent.extra.PICK_FILE_EXTENSIONS", split), null, this, c1708z0.f(C2541R.integer.ic_content_accept), c1708z0.getText(C2541R.string.stmt_file_pick_title));
        return false;
    }
}
