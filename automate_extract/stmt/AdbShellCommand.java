package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.AdbAction;
import j3.AbstractC2007c;
import j3.InterfaceC2011g;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import p3.C2212a;

@F3.f("adb_shell_command.html")
@F3.a(C2541R.integer.ic_cli)
@F3.i(C2541R.string.stmt_adb_shell_command_title)
@F3.h(C2541R.string.stmt_adb_shell_command_summary)
@F3.e(C2541R.layout.stmt_adb_shell_command_edit)
/* loaded from: classes.dex */
public final class AdbShellCommand extends AdbAction {
    public InterfaceC1700x0 command;
    public J3.l varExitCode;
    public J3.l varStderr;
    public J3.l varStdout;

    public static final class a extends AdbAction.a {

        /* renamed from: P1, reason: collision with root package name */
        public final List<String> f16234P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final boolean f16235Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final boolean f16236R1;

        /* renamed from: S1, reason: collision with root package name */
        public InterfaceC2011g f16237S1;

        public a(String str, int i8, boolean z7, String str2, List<String> list, boolean z8, boolean z9) {
            super(i8, str, str2, z7);
            this.f16234P1 = list;
            this.f16235Q1 = z8;
            this.f16236R1 = z9;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            InterfaceC2011g interfaceC2011g = this.f16237S1;
            if (interfaceC2011g != null) {
                Charset charset = com.llamalab.safs.internal.m.f17837a;
                try {
                    interfaceC2011g.close();
                } catch (Throwable unused) {
                }
                this.f16237S1 = null;
            }
            super.F(automateService);
        }

        @Override // com.llamalab.automate.stmt.AdbAction.a
        public final void z2(AbstractC2007c abstractC2007c) {
            boolean z7 = this.f16235Q1;
            ByteArrayOutputStream byteArrayOutputStream = z7 ? new ByteArrayOutputStream() : null;
            boolean z8 = this.f16236R1;
            ByteArrayOutputStream byteArrayOutputStream2 = z8 ? new ByteArrayOutputStream() : null;
            List<String> list = this.f16234P1;
            this.f16237S1 = list.isEmpty() ? D1.P.u(abstractC2007c, 1, Collections.emptyList()) : D1.P.u(abstractC2007c, 2, list);
            try {
                d4.k kVar = new d4.k(this.f16237S1.w(), byteArrayOutputStream, "AdbShellCommand-stdout");
                kVar.f18009x0 = z7 ? 1000 : -1;
                try {
                    d4.k kVar2 = new d4.k(this.f16237S1.o(), byteArrayOutputStream2, "AdbShellCommand-stderr");
                    kVar2.f18009x0 = z8 ? 1000 : -1;
                    try {
                        kVar.start();
                        kVar2.start();
                        int Q12 = this.f16237S1.Q1();
                        kVar2.close();
                        kVar.close();
                        InterfaceC2011g interfaceC2011g = this.f16237S1;
                        Charset charset = com.llamalab.safs.internal.m.f17837a;
                        try {
                            interfaceC2011g.close();
                        } catch (Throwable unused) {
                        }
                        this.f16237S1 = null;
                        Object[] objArr = new Object[3];
                        objArr[0] = Double.valueOf(Q12);
                        objArr[1] = z7 ? byteArrayOutputStream.toString() : null;
                        objArr[2] = z8 ? byteArrayOutputStream2.toString() : null;
                        q2(objArr, false);
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                InterfaceC2011g interfaceC2011g2 = this.f16237S1;
                Charset charset2 = com.llamalab.safs.internal.m.f17837a;
                try {
                    interfaceC2011g2.close();
                } catch (Throwable unused2) {
                }
                this.f16237S1 = null;
                throw th;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 21 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_adb_shell_command_title);
        l8.v(this.command, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.AdbAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.command);
        dVar.g(this.varStdout);
        dVar.g(this.varStderr);
        dVar.g(this.varExitCode);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.host);
        visitor.b(this.port);
        visitor.b(this.security);
        visitor.b(this.alias);
        visitor.b(this.command);
        visitor.b(this.varStdout);
        visitor.b(this.varStderr);
        visitor.b(this.varExitCode);
    }

    @Override // com.llamalab.automate.stmt.AdbAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.command = (InterfaceC1700x0) cVar.readObject();
        this.varStdout = (J3.l) cVar.readObject();
        this.varStderr = (J3.l) cVar.readObject();
        this.varExitCode = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.AdbAction
    public final void q(C1708z0 c1708z0, String str, int i8, boolean z7, String str2) {
        String x7 = J3.h.x(c1708z0, this.command, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("command");
        }
        List i9 = C2212a.i(x7);
        if (i9.isEmpty()) {
            throw new IllegalArgumentException("command");
        }
        a aVar = new a(str, i8, z7, str2, i9, this.varStdout != null, this.varStderr != null);
        c1708z0.w(aVar);
        aVar.w2();
    }

    @Override // com.llamalab.automate.stmt.AdbAction, com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_adb_shell_command_title);
        super.r1(c1708z0);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varExitCode;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varStdout;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        J3.l lVar3 = this.varStderr;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, objArr[2]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
