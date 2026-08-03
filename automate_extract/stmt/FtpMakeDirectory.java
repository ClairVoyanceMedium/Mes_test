package com.llamalab.automate.stmt;

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
import java.util.ArrayDeque;
import java.util.Iterator;
import p3.C2212a;

@F3.f("ftp_make_directory.html")
@F3.a(C2541R.integer.ic_ftp_folder)
@F3.i(C2541R.string.stmt_ftp_make_directory_title)
@F3.h(C2541R.string.stmt_ftp_make_directory_summary)
@F3.e(C2541R.layout.stmt_ftp_make_directory_edit)
/* loaded from: classes.dex */
public final class FtpMakeDirectory extends FtpAction {
    public InterfaceC1700x0 remotePath;

    public static final class a extends FtpAction.a {

        /* renamed from: Q1, reason: collision with root package name */
        public final File f16664Q1;

        public a(g5.c cVar, String str, int i8, C1231k c1231k, String str2, File file) {
            super(cVar, str, i8, c1231k, str2);
            this.f16664Q1 = file;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            y2();
            ArrayDeque arrayDeque = new ArrayDeque();
            for (File file = this.f16664Q1; file != null; file = file.getParentFile()) {
                if (!file.getName().isEmpty()) {
                    arrayDeque.addFirst(file);
                }
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                File file2 = (File) it.next();
                String name = file2.getName();
                if (!this.f16651L1.o(name)) {
                    if (!I2.o(this.f16651L1.l("MKD", name))) {
                        throw new IOException("mkd failed: " + file2);
                    }
                    if (!this.f16651L1.o(name)) {
                        throw new IOException("cwd failed: " + file2);
                    }
                }
            }
            this.f16651L1.t();
            q2(null, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 q8 = D1.P.l(context, C2541R.string.caption_ftp_make_directory).o(-2, this.host).q(this.host);
        q8.t(this.remotePath);
        return q8.q(this.remotePath).f16030c;
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.remotePath);
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.remotePath);
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.remotePath = (InterfaceC1700x0) cVar.readObject();
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
        a aVar = new a(cVar, str, i8, c1231k, str2, new File(g8));
        c1708z0.w(aVar);
        aVar.w2();
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ftp_make_directory_title);
        super.r1(c1708z0);
        return false;
    }
}
