package com.llamalab.automate.stmt;

import C1.D1;
import android.content.Context;
import androidx.appcompat.widget.C1231k;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.FtpAction;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import p3.C2212a;
import x3.C2440r;

@F3.f("ftp_delete.html")
@F3.a(C2541R.integer.ic_ftp_discard)
@F3.i(C2541R.string.stmt_ftp_delete_title)
@F3.h(C2541R.string.stmt_ftp_delete_summary)
@F3.e(C2541R.layout.stmt_ftp_delete_edit)
/* loaded from: classes.dex */
public final class FtpDelete extends FtpAction {
    public InterfaceC1700x0 recursive;
    public InterfaceC1700x0 remotePath;

    public static final class a extends FtpAction.a {

        /* renamed from: Q1, reason: collision with root package name */
        public final File f16656Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final boolean f16657R1;

        /* renamed from: S1, reason: collision with root package name */
        public String f16658S1;

        public a(g5.c cVar, String str, int i8, C1231k c1231k, String str2, File file, boolean z7) {
            super(cVar, str, i8, c1231k, str2);
            this.f16656Q1 = file;
            this.f16657R1 = z7;
        }

        public final void A2(String str) {
            C2(str, this.f16651L1.r(str));
            if (!I2.o(this.f16651L1.l("RMD", str))) {
                throw new IOException(D1.k("rmd failed: ", str));
            }
        }

        public final void B2(String str) {
            if (!I2.o(this.f16651L1.l("DELE", str))) {
                throw new IOException(D1.k("dele failed: ", str));
            }
        }

        public final void C2(String str, g5.e[] eVarArr) {
            String str2;
            if (eVarArr == null) {
                throw new IOException(D1.k("list failed: ", str));
            }
            for (g5.e eVar : eVarArr) {
                if (C2212a.f(eVar.f18828Z)) {
                    if (str != null) {
                        StringBuilder p8 = C1.H0.p(str, "/");
                        p8.append(eVar.f18828Z);
                        str2 = p8.toString();
                    } else {
                        str2 = eVar.f18828Z;
                    }
                    if (!(eVar.f18826X == 2) && eVar.a()) {
                        A2(str2);
                    } else {
                        B2(str2);
                    }
                }
            }
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            y2();
            g5.c cVar = this.f16651L1;
            File file = this.f16656Q1;
            if (!cVar.o(file.getPath())) {
                this.f16658S1 = file.getName();
                String parent = file.getParent();
                if (parent != null && !this.f16651L1.o(parent)) {
                    throw new IOException("Parent not a directory: ".concat(parent));
                }
                g5.h q8 = this.f16651L1.q(null);
                ArrayList arrayList = new ArrayList();
                for (String str : q8.f18832a) {
                    g5.e d8 = q8.f18833b.d(str);
                    if (d8 == null && q8.f18834c) {
                        d8 = new g5.e(str);
                    }
                    if (z2(d8)) {
                        arrayList.add(d8);
                    }
                }
                C2(null, (g5.e[]) arrayList.toArray(g5.h.f18831d));
            } else if (this.f16657R1) {
                if (!I2.o(this.f16651L1.l("CDUP", null))) {
                    throw new IOException("cdup failed");
                }
                A2(file.getName());
            }
            this.f16651L1.t();
            q2(null, false);
        }

        public final boolean z2(g5.e eVar) {
            if (!C2212a.f(eVar.f18828Z)) {
                return false;
            }
            String str = this.f16658S1;
            if (str != null && !C2440r.v(str, eVar.f18828Z)) {
                return false;
            }
            if (!this.f16657R1) {
                if (!(eVar.f18826X == 0)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 q8 = D1.P.l(context, C2541R.string.caption_ftp_delete).o(-2, this.host).q(this.host);
        q8.t(this.remotePath);
        return q8.q(this.remotePath).y(this.recursive, C2541R.string.caption_recursive, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.remotePath);
        dVar.g(this.recursive);
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.remotePath);
        visitor.b(this.recursive);
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.remotePath = (InterfaceC1700x0) cVar.readObject();
        this.recursive = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.FtpAction
    public final void q(C1708z0 c1708z0, g5.c cVar, String str, int i8, C1231k c1231k, String str2) {
        String x7 = J3.h.x(c1708z0, this.remotePath, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("remotePath");
        }
        String g8 = C2212a.g(x7);
        if (g8 == null) {
            throw new IllegalArgumentException("remotePath");
        }
        if ("/".equals(g8)) {
            throw new SecurityException("Deleting root is not permitted");
        }
        a aVar = new a(cVar, str, i8, c1231k, str2, new File(g8), J3.h.f(c1708z0, this.recursive, false));
        c1708z0.w(aVar);
        aVar.w2();
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ftp_delete_title);
        super.r1(c1708z0);
        return false;
    }
}
