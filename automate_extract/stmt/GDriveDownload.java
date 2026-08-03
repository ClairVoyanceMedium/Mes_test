package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.RequiredArgumentNullException;
import java.util.HashSet;
import s4.AbstractC2313a;

@F3.f("gdrive_download.html")
@F3.a(C2541R.integer.ic_gdrive_download)
@F3.i(C2541R.string.stmt_gdrive_download_title)
@F3.h(C2541R.string.stmt_gdrive_download_summary)
@F3.e(C2541R.layout.stmt_gdrive_download_edit)
/* loaded from: classes.dex */
public final class GDriveDownload extends GDriveTransferAction {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.f15542c, com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.f15542c, com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15542c, com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_gdrive_download);
        l8.t(this.remotePath);
        return l8.q(this.remotePath).y(this.recursive, C2541R.string.caption_recursive, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.F
    public final void c(C1708z0 c1708z0, AbstractC2313a abstractC2313a) {
        com.llamalab.safs.gdrive.c cVar = (com.llamalab.safs.gdrive.c) abstractC2313a;
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.localPath);
        if (p8 == null) {
            throw new RequiredArgumentNullException("localPath");
        }
        com.llamalab.safs.n v8 = J3.h.v(c1708z0, this.remotePath, null, cVar.g(), cVar);
        if (v8 == null) {
            throw new RequiredArgumentNullException("remotePath");
        }
        HashSet hashSet = new HashSet(5);
        hashSet.add(com.llamalab.safs.o.REPLACE_EXISTING);
        hashSet.add(P3.s.MERGE_DIRECTORIES);
        hashSet.add(P3.s.PROCESSOR_INTENSIVE);
        if (J3.h.f(c1708z0, this.recursive, false)) {
            hashSet.add(P3.t.f5936X);
        }
        if (J3.h.f(c1708z0, this.onlyNewerFiles, false)) {
            hashSet.add(P3.s.NOREPLACE_NEWER_FILES);
        }
        P3.f fVar = new P3.f(v8, p8, hashSet, cVar);
        c1708z0.w(fVar);
        fVar.w2();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_gdrive_download_title);
        com.llamalab.automate.access.c.f15542c.w(c1708z0);
        return GoogleAuthorized.b(this, c1708z0, "oauth2:https://www.googleapis.com/auth/drive");
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
