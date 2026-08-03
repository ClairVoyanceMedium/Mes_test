package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.RequiredArgumentNullException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import p3.C2212a;
import x3.C2425c;

@F3.f("shell_command_superuser.html")
@F3.a(C2541R.integer.ic_cli_su)
@F3.i(C2541R.string.stmt_shell_command_superuser_title)
@F3.h(C2541R.string.stmt_shell_command_superuser_summary)
@F3.e(C2541R.layout.stmt_shell_command_superuser_edit)
/* loaded from: classes.dex */
public final class ShellCommandSuperuser extends ShellCommandAction {

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f17116L1;

        /* renamed from: M1, reason: collision with root package name */
        public final File f17117M1;

        /* renamed from: N1, reason: collision with root package name */
        public final boolean f17118N1;

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f17119O1;

        /* renamed from: P1, reason: collision with root package name */
        public d4.j f17120P1;

        public a(String str, File file, boolean z7, boolean z8) {
            this.f17116L1 = str;
            this.f17117M1 = file;
            this.f17118N1 = z7;
            this.f17119O1 = z8;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            d4.j jVar = this.f17120P1;
            if (jVar != null) {
                jVar.d();
                this.f17120P1 = null;
            }
            super.F(automateService);
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            d4.j jVar = null;
            boolean z7 = this.f17118N1;
            ByteArrayOutputStream byteArrayOutputStream = z7 ? new ByteArrayOutputStream() : null;
            boolean z8 = this.f17119O1;
            ByteArrayOutputStream byteArrayOutputStream2 = z8 ? new ByteArrayOutputStream() : null;
            this.f17120P1 = new d4.j(C1710z2.e(C2425c.c(this.f15400Y)));
            d4.k kVar = new d4.k(this.f17120P1.f17991e, byteArrayOutputStream, "ShellCommandSuperuser-stdout");
            int i8 = 1000;
            kVar.f18009x0 = z7 ? 1000 : -1;
            try {
                d4.k kVar2 = new d4.k(this.f17120P1.f17992f, byteArrayOutputStream2, "ShellCommandSuperuser-stderr");
                if (!z8) {
                    i8 = -1;
                }
                try {
                    kVar2.f18009x0 = i8;
                    try {
                        kVar.start();
                        kVar2.start();
                        File file = this.f17117M1;
                        if (file != null && this.f17120P1.b("cd", file.getAbsolutePath()) != 0) {
                            throw new IllegalStateException("cd failed");
                        }
                        int c8 = this.f17120P1.c(this.f17116L1);
                        kVar2.close();
                        kVar.close();
                        Object[] objArr = new Object[3];
                        objArr[0] = Double.valueOf(c8);
                        objArr[1] = z7 ? byteArrayOutputStream.toString() : null;
                        objArr[2] = z8 ? byteArrayOutputStream2.toString() : null;
                        q2(objArr, false);
                    } finally {
                        this.f17120P1.d();
                        this.f17120P1 = null;
                    }
                } finally {
                }
            } finally {
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_SUPERUSER"), com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_SUPERUSER"), com.llamalab.automate.access.c.j("com.llamalab.automate.permission.EXECUTE_SHELL_COMMAND")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_shell_command_superuser);
        l8.v(this.command, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_shell_command_superuser_title);
        com.llamalab.automate.access.c.j("com.llamalab.automate.permission.EXECUTE_SHELL_COMMAND").w(c1708z0);
        if (!com.llamalab.automate.access.c.j("com.llamalab.automate.permission.SUPERUSER_SHELL").A(c1708z0)) {
            com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_SUPERUSER").w(c1708z0);
        }
        String x7 = J3.h.x(c1708z0, this.command, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("command");
        }
        File e8 = C2212a.e();
        a aVar = new a(x7, J3.h.k(c1708z0, this.workDir, e8, e8), this.varStdout != null, this.varStderr != null);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }
}
