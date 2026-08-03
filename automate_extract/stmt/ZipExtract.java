package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;

@F3.f("zip_extract.html")
@F3.a(C2541R.integer.ic_zip_down)
@F3.i(C2541R.string.stmt_zip_extract_title)
@F3.h(C2541R.string.stmt_zip_extract_summary)
@F3.e(C2541R.layout.stmt_zip_extract_edit)
/* loaded from: classes.dex */
public final class ZipExtract extends Action implements AsyncStatement {
    public InterfaceC1700x0 recursive;
    public InterfaceC1700x0 sourcePath;
    public InterfaceC1700x0 targetPath;
    public InterfaceC1700x0 zipFile;

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
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_zip_extract);
        l8.t(this.zipFile);
        return l8.q(this.zipFile).y(this.recursive, C2541R.string.caption_recursive, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.zipFile);
        dVar.g(this.targetPath);
        dVar.g(this.sourcePath);
        dVar.g(this.recursive);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.zipFile);
        visitor.b(this.targetPath);
        visitor.b(this.sourcePath);
        visitor.b(this.recursive);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.zipFile = (InterfaceC1700x0) cVar.readObject();
        this.targetPath = (InterfaceC1700x0) cVar.readObject();
        this.sourcePath = (InterfaceC1700x0) cVar.readObject();
        this.recursive = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_zip_extract_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.zipFile);
        if (p8 == null) {
            throw new RequiredArgumentNullException("zipFile");
        }
        P3.e eVar = new P3.e(p8, Collections.singletonMap("openOptions", EnumSet.of(com.llamalab.safs.p.READ)));
        c1708z0.w(eVar);
        eVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        if (!(w8 instanceof P3.e)) {
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        com.llamalab.safs.zip.a aVar = (com.llamalab.safs.zip.a) obj;
        try {
            com.llamalab.safs.n v8 = J3.h.v(c1708z0, this.sourcePath, aVar.g(), aVar.g(), aVar);
            if (v8 == null) {
                throw new RequiredArgumentNullException("sourcePath");
            }
            com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.targetPath);
            if (p8 == null) {
                throw new RequiredArgumentNullException("targetPath");
            }
            boolean f8 = J3.h.f(c1708z0, this.recursive, true);
            HashSet hashSet = new HashSet(4);
            hashSet.add(com.llamalab.safs.o.REPLACE_EXISTING);
            hashSet.add(P3.s.MERGE_DIRECTORIES);
            hashSet.add(P3.s.PROCESSOR_INTENSIVE);
            if (f8) {
                hashSet.add(P3.t.f5936X);
            }
            P3.f fVar = new P3.f(v8, p8, hashSet, aVar);
            c1708z0.w(fVar);
            fVar.w2();
            return false;
        } catch (Throwable th) {
            Charset charset = com.llamalab.safs.internal.m.f17837a;
            try {
                aVar.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }
}
