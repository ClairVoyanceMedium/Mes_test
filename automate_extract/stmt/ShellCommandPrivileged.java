package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.ParcelFileDescriptor;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AutomateApplication;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.RequiredArgumentNullException;
import f.RunnableC1764A;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import p3.C2212a;
import x3.C2434l;

@F3.f("shell_command_privileged.html")
@F3.a(C2541R.integer.ic_cli_su)
@F3.i(C2541R.string.stmt_shell_command_privileged_title)
@F3.h(C2541R.string.stmt_shell_command_privileged_summary)
@F3.e(C2541R.layout.stmt_shell_command_privileged_edit)
/* loaded from: classes.dex */
public final class ShellCommandPrivileged extends ShellCommandAction {

    public static final class a extends AbstractC1602l2 implements Handler.Callback, IBinder.DeathRecipient {

        /* renamed from: M1, reason: collision with root package name */
        public final String[] f17108M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f17109N1;

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f17110O1;

        /* renamed from: P1, reason: collision with root package name */
        public final boolean f17111P1;

        /* renamed from: Q1, reason: collision with root package name */
        public d4.k f17112Q1;

        /* renamed from: R1, reason: collision with root package name */
        public d4.k f17113R1;

        /* renamed from: S1, reason: collision with root package name */
        public Messenger f17114S1;

        /* renamed from: T1, reason: collision with root package name */
        public volatile boolean f17115T1 = true;

        public a(String[] strArr, String str, boolean z7, boolean z8) {
            this.f17108M1 = strArr;
            this.f17109N1 = str;
            this.f17110O1 = z7;
            this.f17111P1 = z8;
        }

        @Override // com.llamalab.automate.AbstractC1602l2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            Messenger messenger = this.f17114S1;
            if (messenger != null) {
                try {
                    messenger.getBinder().unlinkToDeath(this, 0);
                } catch (Throwable unused) {
                }
                if (this.f17115T1) {
                    try {
                        this.f17114S1.send(Message.obtain((Handler) null, 3));
                    } catch (Throwable unused2) {
                    }
                }
            }
            d4.k kVar = this.f17112Q1;
            if (kVar != null) {
                Charset charset = com.llamalab.safs.internal.m.f17837a;
                try {
                    kVar.close();
                } catch (Throwable unused3) {
                }
            }
            d4.k kVar2 = this.f17113R1;
            if (kVar2 != null) {
                Charset charset2 = com.llamalab.safs.internal.m.f17837a;
                try {
                    kVar2.close();
                } catch (Throwable unused4) {
                }
            }
            super.F(automateService);
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            this.f17115T1 = false;
            r2(new DeadObjectException().fillInStackTrace());
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            try {
                int i8 = message.what;
                if (i8 != 1) {
                    if (i8 != 2) {
                        return false;
                    }
                    this.f17115T1 = false;
                    Bundle data = message.getData();
                    data.setClassLoader(a.class.getClassLoader());
                    ((t3.l) data.getParcelable("throwable")).c();
                    return true;
                }
                this.f17115T1 = false;
                if (this.f17110O1) {
                    this.f17112Q1.join(250L);
                }
                if (this.f17111P1) {
                    this.f17113R1.join(250L);
                }
                Object[] objArr = new Object[3];
                objArr[0] = Double.valueOf(message.arg1);
                objArr[1] = this.f17110O1 ? this.f17112Q1.f18007Y.toString() : null;
                objArr[2] = this.f17111P1 ? this.f17113R1.f18007Y.toString() : null;
                q2(objArr, false);
                return true;
            } catch (Throwable th) {
                r2(th);
                return true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
        @Override // com.llamalab.automate.AbstractC1602l2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            ParcelFileDescriptor[] parcelFileDescriptorArr;
            ParcelFileDescriptor[] createPipe;
            ParcelFileDescriptor[] parcelFileDescriptorArr2 = null;
            boolean z7 = this.f17110O1;
            if (z7) {
                try {
                    createPipe = ParcelFileDescriptor.createPipe();
                    try {
                        d4.k kVar = new d4.k(new ParcelFileDescriptor.AutoCloseInputStream(createPipe[0]), new ByteArrayOutputStream(), "ShellCommandPrivileged-stdout");
                        this.f17112Q1 = kVar;
                        kVar.start();
                    } catch (Throwable th) {
                        th = th;
                        parcelFileDescriptorArr = null;
                        parcelFileDescriptorArr2 = createPipe;
                        if (parcelFileDescriptorArr2 != null) {
                            try {
                                parcelFileDescriptorArr2[0].close();
                            } catch (IOException unused) {
                            }
                            try {
                                parcelFileDescriptorArr2[1].close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (parcelFileDescriptorArr != null) {
                            try {
                                parcelFileDescriptorArr[0].close();
                            } catch (IOException unused3) {
                            }
                            try {
                                parcelFileDescriptorArr[1].close();
                            } catch (IOException unused4) {
                            }
                        }
                        r2(th);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcelFileDescriptorArr = null;
                    if (parcelFileDescriptorArr2 != null) {
                    }
                    if (parcelFileDescriptorArr != null) {
                    }
                    r2(th);
                    return;
                }
            } else {
                createPipe = null;
            }
            boolean z8 = this.f17111P1;
            if (z8) {
                parcelFileDescriptorArr = ParcelFileDescriptor.createPipe();
                try {
                    d4.k kVar2 = new d4.k(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptorArr[0]), new ByteArrayOutputStream(), "ShellCommandPrivileged-stderr");
                    this.f17113R1 = kVar2;
                    kVar2.start();
                } catch (Throwable th3) {
                    th = th3;
                    parcelFileDescriptorArr2 = createPipe;
                    if (parcelFileDescriptorArr2 != null) {
                    }
                    if (parcelFileDescriptorArr != null) {
                    }
                    r2(th);
                    return;
                }
            } else {
                parcelFileDescriptorArr = null;
            }
            Messenger v12 = interfaceC1585h1.v1(this.f17108M1, null, this.f17109N1, null, z7 ? createPipe[1] : null, z8 ? parcelFileDescriptorArr[1] : null, new Messenger(new Handler(this.f15400Y.f14583N1.a(), this)));
            this.f17114S1 = v12;
            if (v12 != null) {
                v12.getBinder().linkToDeath(this, 0);
            }
            if (z7) {
                createPipe[1].close();
            }
            if (z8) {
                parcelFileDescriptorArr[1].close();
            }
            try {
                com.llamalab.android.app.h hVar = ((AutomateApplication) this.f15400Y.getApplicationContext()).f14526Y;
                hVar.getClass();
                hVar.f14189e.post(new RunnableC1764A(hVar, 7, this));
            } catch (Throwable unused5) {
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED"), com.llamalab.automate.access.c.j("com.llamalab.automate.permission.EXECUTE_SHELL_COMMAND")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_shell_command_privileged);
        l8.v(this.command, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_shell_command_privileged_title);
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
        c1708z0.w(new a((String[]) i8.toArray(C2434l.f23396g), J3.h.k(c1708z0, this.workDir, e8, e8).getPath(), this.varStdout != null, this.varStderr != null));
        return false;
    }
}
