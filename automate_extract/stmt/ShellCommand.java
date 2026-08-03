package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.RequiredArgumentNullException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import p3.C2212a;

@F3.f("shell_command.html")
@F3.a(C2541R.integer.ic_cli)
@F3.i(C2541R.string.stmt_shell_command_title)
@F3.h(C2541R.string.stmt_shell_command_summary)
@F3.e(C2541R.layout.stmt_shell_command_edit)
/* loaded from: classes.dex */
public final class ShellCommand extends ShellCommandAction {

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final ProcessBuilder f17104L1;

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f17105M1;

        /* renamed from: N1, reason: collision with root package name */
        public final boolean f17106N1;

        /* renamed from: O1, reason: collision with root package name */
        public Process f17107O1;

        public a(ProcessBuilder processBuilder, boolean z7, boolean z8) {
            this.f17104L1 = processBuilder;
            this.f17105M1 = z7;
            this.f17106N1 = z8;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            Process process = this.f17107O1;
            if (process != null) {
                this.f17107O1 = null;
                try {
                    process.destroy();
                } catch (Throwable unused) {
                }
            }
            super.F(automateService);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            Object[] objArr = 0;
            boolean z7 = this.f17105M1;
            ByteArrayOutputStream byteArrayOutputStream = z7 ? new ByteArrayOutputStream() : null;
            boolean z8 = this.f17106N1;
            ByteArrayOutputStream byteArrayOutputStream2 = z8 ? new ByteArrayOutputStream() : null;
            this.f17107O1 = this.f17104L1.start();
            try {
                d4.k kVar = new d4.k(this.f17107O1.getInputStream(), byteArrayOutputStream, "ShellCommand-stdout");
                kVar.f18009x0 = z7 ? 1000 : -1;
                try {
                    d4.k kVar2 = new d4.k(this.f17107O1.getErrorStream(), byteArrayOutputStream2, "ShellCommand-stderr");
                    kVar2.f18009x0 = z8 ? 1000 : -1;
                    try {
                        kVar.start();
                        kVar2.start();
                        int waitFor = this.f17107O1.waitFor();
                        kVar2.close();
                        kVar.close();
                        if (r0 != null) {
                            try {
                                this.f17107O1.destroy();
                            } catch (Throwable unused) {
                            }
                        }
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = Double.valueOf(waitFor);
                        objArr2[1] = z7 ? byteArrayOutputStream.toString() : null;
                        objArr2[2] = z8 ? byteArrayOutputStream2.toString() : null;
                        q2(objArr2, false);
                    } finally {
                        try {
                        } catch (Throwable th) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
                            } catch (Exception unused2) {
                            }
                        }
                    }
                } finally {
                    try {
                    } catch (Throwable th2) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        } catch (Exception unused3) {
                        }
                    }
                }
            } finally {
                Process process = this.f17107O1;
                if (process != null) {
                    this.f17107O1 = null;
                    try {
                        process.destroy();
                    } catch (Throwable unused4) {
                    }
                }
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.EXECUTE_SHELL_COMMAND")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_shell_command_title);
        l8.v(this.command, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_shell_command_title);
        e(c1708z0);
        String x7 = J3.h.x(c1708z0, this.command, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("command");
        }
        List i8 = C2212a.i(x7);
        if (i8.isEmpty()) {
            throw new IllegalArgumentException("command");
        }
        File e8 = C2212a.e();
        a aVar = new a(new ProcessBuilder((List<String>) i8).directory(J3.h.k(c1708z0, this.workDir, e8, e8)), this.varStdout != null, this.varStderr != null);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }
}
