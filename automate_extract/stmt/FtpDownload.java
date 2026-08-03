package com.llamalab.automate.stmt;

import C1.D1;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.appcompat.widget.C1231k;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.stmt.FtpTransferAction;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Pattern;
import p3.C2212a;
import x3.C2440r;

@F3.f("ftp_download.html")
@F3.a(C2541R.integer.ic_ftp_download)
@F3.i(C2541R.string.stmt_ftp_download_title)
@F3.h(C2541R.string.stmt_ftp_download_summary)
@F3.e(C2541R.layout.stmt_ftp_download_edit)
/* loaded from: classes.dex */
public final class FtpDownload extends FtpTransferAction {

    public static final class a extends FtpTransferAction.a {
        public String U1;

        public a(g5.c cVar, String str, int i8, C1231k c1231k, String str2, File file, File file2, boolean z7) {
            super(cVar, str, i8, c1231k, str2, file, file2, z7);
        }

        public final void A2(File file, String str) {
            g5.e[] r8 = this.f16651L1.r(str);
            if (r8 == null) {
                throw new IOException(D1.k("list failed: ", str));
            }
            if (!file.exists() && !file.mkdir()) {
                throw new IOException("mkdir failed: " + file);
            }
            for (g5.e eVar : r8) {
                if (eVar != null) {
                    String path = str != null ? new File(str, eVar.f18828Z).getPath() : eVar.f18828Z;
                    File file2 = new File(file, eVar.f18828Z);
                    if (eVar.a()) {
                        A2(file2, path);
                    } else {
                        B2(file2, path);
                    }
                }
            }
        }

        public final void B2(File file, String str) {
            InputStream inputStream;
            i5.d dVar;
            g5.c cVar = this.f16651L1;
            Socket n8 = cVar.n("RETR", str);
            if (n8 == null) {
                dVar = null;
            } else {
                if (cVar.f18813y == 0) {
                    InputStream inputStream2 = n8.getInputStream();
                    inputStream = new i5.c(cVar.f18804B > 0 ? new BufferedInputStream(inputStream2, cVar.f18804B) : new BufferedInputStream(inputStream2));
                } else {
                    inputStream = n8.getInputStream();
                }
                dVar = new i5.d(n8, inputStream);
            }
            if (dVar == null) {
                throw new IOException(D1.k("get failed: ", str));
            }
            try {
                C2212a.p(dVar, file, this.f16668T1);
                dVar.close();
                if (!I2.o(this.f16651L1.j())) {
                    throw new IOException(D1.k("get failed: ", str));
                }
            } catch (Throwable th) {
                dVar.close();
                throw th;
            }
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            y2();
            g5.c cVar = this.f16651L1;
            File file = this.f16666R1;
            boolean o6 = cVar.o(file.getPath());
            File file2 = this.f16665Q1;
            if (!o6) {
                g5.c cVar2 = this.f16651L1;
                String parent = file.getParent();
                if (parent == null) {
                    parent = "/";
                }
                if (cVar2.o(parent)) {
                    this.U1 = file.getName();
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
                    g5.e[] eVarArr = (g5.e[]) arrayList.toArray(g5.h.f18831d);
                    if (eVarArr == null) {
                        throw new IOException("list failed: " + file);
                    }
                    if (file2.isDirectory()) {
                        for (g5.e eVar : eVarArr) {
                            if (eVar.a()) {
                                A2(new File(file2, eVar.f18828Z), eVar.f18828Z);
                            } else {
                                B2(new File(file2, eVar.f18828Z), eVar.f18828Z);
                            }
                        }
                    } else {
                        if (eVarArr.length != 1) {
                            throw new IOException("Local path not a directory: " + file2);
                        }
                        g5.e eVar2 = eVarArr[0];
                        if (eVar2.a()) {
                            A2(file2, eVar2.f18828Z);
                        } else {
                            B2(file2, eVar2.f18828Z);
                        }
                    }
                }
            } else if (this.f16667S1) {
                if (file2.exists()) {
                    file2 = new File(file2, file.getName());
                }
                A2(file2, null);
            }
            this.f16651L1.t();
            q2(null, false);
        }

        public final boolean z2(g5.e eVar) {
            if (eVar == null) {
                return false;
            }
            String str = this.U1;
            if (str != null && !C2440r.v(str, eVar.f18828Z)) {
                return false;
            }
            if (!this.f16667S1) {
                if (!(eVar.f18826X == 0)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 q8 = D1.P.l(context, C2541R.string.caption_ftp_download).o(-2, this.host).q(this.host);
        q8.t(this.remotePath);
        return q8.q(this.remotePath).y(this.recursive, C2541R.string.caption_recursive, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.FtpAction
    public final void q(C1708z0 c1708z0, g5.c cVar, String str, int i8, C1231k c1231k, String str2) {
        InterfaceC1700x0 interfaceC1700x0 = this.localPath;
        Pattern pattern = J3.h.f4650a;
        File k8 = J3.h.k(c1708z0, interfaceC1700x0, null, Environment.getExternalStorageDirectory());
        if (k8 == null) {
            throw new RequiredArgumentNullException("localPath");
        }
        String x7 = J3.h.x(c1708z0, this.remotePath, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("remotePath");
        }
        String g8 = C2212a.g(x7);
        if (g8 == null) {
            throw new IllegalArgumentException("remotePath");
        }
        a aVar = new a(cVar, str, i8, c1231k, str2, k8, new File(g8), J3.h.f(c1708z0, this.recursive, false));
        c1708z0.w(aVar);
        aVar.w2();
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ftp_download_title);
        super.r1(c1708z0);
        return false;
    }
}
