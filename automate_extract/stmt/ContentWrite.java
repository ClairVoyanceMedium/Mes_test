package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.io.OutputStream;

@F3.f("content_write.html")
@F3.a(C2541R.integer.ic_sdcard_content)
@F3.i(C2541R.string.stmt_content_write_title)
@F3.h(C2541R.string.stmt_content_write_summary)
@F3.e(C2541R.layout.stmt_content_write_edit)
/* loaded from: classes.dex */
public final class ContentWrite extends Action implements AsyncStatement {
    public InterfaceC1700x0 openMode;
    public InterfaceC1700x0 sourcePath;
    public InterfaceC1700x0 targetUri;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final com.llamalab.safs.n f16497L1;

        /* renamed from: M1, reason: collision with root package name */
        public final Uri f16498M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f16499N1;

        public a(com.llamalab.safs.n nVar, Uri uri, String str) {
            this.f16497L1 = nVar;
            this.f16498M1 = uri;
            this.f16499N1 = str;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            OutputStream openOutputStream = this.f15400Y.getContentResolver().openOutputStream(this.f16498M1, this.f16499N1);
            try {
                com.llamalab.safs.i.a(this.f16497L1, openOutputStream);
                if (openOutputStream != null) {
                    openOutputStream.close();
                }
                q2(null, false);
            } catch (Throwable th) {
                if (openOutputStream != null) {
                    try {
                        openOutputStream.close();
                    } catch (Throwable th2) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        } catch (Exception unused) {
                        }
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_content_write);
        l8.v(this.sourcePath, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.sourcePath);
        dVar.g(this.targetUri);
        dVar.g(this.openMode);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.sourcePath);
        visitor.b(this.targetUri);
        visitor.b(this.openMode);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.sourcePath = (InterfaceC1700x0) cVar.readObject();
        this.targetUri = (InterfaceC1700x0) cVar.readObject();
        this.openMode = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_content_write_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.sourcePath);
        if (p8 == null) {
            throw new RequiredArgumentNullException("sourcePath");
        }
        Uri g8 = J3.h.g(c1708z0, this.targetUri, null);
        if (g8 == null) {
            throw new RequiredArgumentNullException("targetUri");
        }
        if ("content".equals(g8.getScheme()) && "com.llamalab.automate.provider".equals(g8.getAuthority())) {
            throw new SecurityException("Automate is not permitted");
        }
        a aVar = new a(p8, g8, J3.h.x(c1708z0, this.openMode, "w"));
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
