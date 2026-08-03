package com.llamalab.automate.stmt;

import androidx.appcompat.widget.C1231k;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.FtpAction;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class FtpTransferAction extends FtpAction {
    public InterfaceC1700x0 localPath;
    public InterfaceC1700x0 recursive;
    public InterfaceC1700x0 remotePath;

    public static abstract class a extends FtpAction.a {

        /* renamed from: Q1, reason: collision with root package name */
        public final File f16665Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final File f16666R1;

        /* renamed from: S1, reason: collision with root package name */
        public final boolean f16667S1;

        /* renamed from: T1, reason: collision with root package name */
        public final byte[] f16668T1;

        public a(g5.c cVar, String str, int i8, C1231k c1231k, String str2, File file, File file2, boolean z7) {
            super(cVar, str, i8, c1231k, str2);
            this.f16668T1 = new byte[MoreOsConstants.O_DSYNC];
            this.f16665Q1 = file;
            this.f16666R1 = file2;
            this.f16667S1 = z7;
        }

        @Override // com.llamalab.automate.stmt.FtpAction.a
        public final void y2() {
            boolean z7;
            super.y2();
            g5.c cVar = this.f16651L1;
            cVar.getClass();
            if (I2.o(cVar.l("TYPE", "I"))) {
                cVar.f18813y = 2;
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                throw new IOException("type failed: binary");
            }
        }
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.localPath);
        dVar.g(this.remotePath);
        dVar.g(this.recursive);
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.localPath);
        visitor.b(this.remotePath);
        visitor.b(this.recursive);
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.localPath = (InterfaceC1700x0) cVar.readObject();
        this.remotePath = (InterfaceC1700x0) cVar.readObject();
        this.recursive = (InterfaceC1700x0) cVar.readObject();
    }
}
