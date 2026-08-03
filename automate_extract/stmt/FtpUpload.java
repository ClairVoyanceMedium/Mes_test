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
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Pattern;
import p3.C2212a;
import x3.C2440r;

@F3.f("ftp_upload.html")
@F3.a(C2541R.integer.ic_ftp_upload)
@F3.i(C2541R.string.stmt_ftp_upload_title)
@F3.h(C2541R.string.stmt_ftp_upload_summary)
@F3.e(C2541R.layout.stmt_ftp_upload_edit)
/* loaded from: classes.dex */
public final class FtpUpload extends FtpTransferAction {

    public static final class a extends FtpTransferAction.a implements FileFilter {
        public String U1;

        public a(g5.c cVar, String str, int i8, C1231k c1231k, String str2, File file, File file2, boolean z7) {
            super(cVar, str, i8, c1231k, str2, file, file2, z7);
        }

        public final void A2(File file, String str) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                i5.e u8 = this.f16651L1.u(str);
                if (u8 == null) {
                    throw new IOException("put failed: " + str);
                }
                try {
                    com.llamalab.safs.internal.m.i(fileInputStream, u8, this.f16668T1);
                    u8.close();
                    if (I2.o(this.f16651L1.j())) {
                        return;
                    }
                    throw new IOException("put failed: " + str);
                } catch (Throwable th) {
                    u8.close();
                    throw th;
                }
            } finally {
                fileInputStream.close();
            }
        }

        public final void B2(File[] fileArr) {
            for (File file : fileArr) {
                if (file.isDirectory()) {
                    z2(file, file.getName());
                } else {
                    A2(file, file.getName());
                }
            }
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            String str = this.U1;
            return (str == null || C2440r.v(str, file.getName())) && (this.f16667S1 || file.isFile());
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            String name;
            y2();
            File canonicalFile = this.f16665Q1.getCanonicalFile();
            boolean isDirectory = canonicalFile.isDirectory();
            File file = this.f16666R1;
            if (isDirectory) {
                if (this.f16667S1) {
                    if (file == null || this.f16651L1.o(file.getPath())) {
                        name = canonicalFile.getName();
                    } else {
                        String parent = file.getParent();
                        if (parent == null || !this.f16651L1.o(parent)) {
                            throw new IOException("Remote path not a directory: " + file);
                        }
                        name = file.getName();
                    }
                    z2(canonicalFile, name);
                }
                this.f16651L1.t();
                p2(null);
            }
            File parentFile = canonicalFile.getParentFile();
            if (parentFile == null) {
                throw new IOException("Root file?");
            }
            this.U1 = canonicalFile.getName();
            File[] listFiles = parentFile.listFiles(this);
            if (listFiles == null) {
                throw new IOException("Local path not a directory: " + parentFile);
            }
            if (file == null || this.f16651L1.o(file.getPath())) {
                B2(listFiles);
            } else {
                if (listFiles.length > 1) {
                    throw new IOException("Remote path not a directory: " + file);
                }
                canonicalFile = listFiles[0];
                if (canonicalFile.isDirectory()) {
                    name = file.getPath();
                    z2(canonicalFile, name);
                } else {
                    A2(canonicalFile, file.getPath());
                }
            }
            this.f16651L1.t();
            p2(null);
        }

        public final void z2(File file, String str) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("Local path not a directory: " + file);
            }
            this.f16651L1.l("MKD", str);
            if (!this.f16651L1.o(str)) {
                throw new IOException(D1.k("mkdir failed: ", str));
            }
            B2(listFiles);
            if (!I2.o(this.f16651L1.l("CDUP", null))) {
                throw new IOException("cdup failed");
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 q8 = D1.P.l(context, C2541R.string.caption_ftp_upload).o(-2, this.host).q(this.host);
        q8.t(this.localPath);
        return q8.q(this.localPath).y(this.recursive, C2541R.string.caption_recursive, 0).f16030c;
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
        c1708z0.q(C2541R.string.stmt_ftp_upload_title);
        super.r1(c1708z0);
        return false;
    }
}
