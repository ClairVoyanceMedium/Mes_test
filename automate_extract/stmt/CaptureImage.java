package com.llamalab.automate.stmt;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import g4.C1828b;
import i4.C1951e;

@F3.f("capture_image.html")
@F3.a(C2541R.integer.ic_device_access_camera)
@F3.i(C2541R.string.stmt_capture_image_title)
@F3.h(C2541R.string.stmt_capture_image_summary)
@F3.e(C2541R.layout.stmt_capture_image_edit)
/* loaded from: classes.dex */
public final class CaptureImage extends ActivityDecision implements InterfaceC1622q2, AsyncStatement {

    /* renamed from: L1, reason: collision with root package name */
    public int f16429L1 = -1;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 targetPath;
    public J3.l varImageFile;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        int i8 = Build.VERSION.SDK_INT;
        if (30 > i8) {
            return 23 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CAMERA"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CAMERA"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CAMERA"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (80 <= dVar.f6413Z) {
            dVar.g(this.packageName);
        }
        dVar.g(this.targetPath);
        dVar.g(this.varImageFile);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.packageName);
        visitor.b(this.targetPath);
        visitor.b(this.varImageFile);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f16429L1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (80 <= cVar.f6409x0) {
            this.packageName = (InterfaceC1700x0) cVar.readObject();
        }
        this.targetPath = (InterfaceC1700x0) cVar.readObject();
        this.varImageFile = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            c1708z0.z(this.f16429L1, null);
            J3.l lVar = this.varImageFile;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        String str = (String) c1708z0.j(this.f16429L1);
        c1708z0.z(this.f16429L1, null);
        J3.l lVar2 = this.varImageFile;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_capture_image_title);
        g1 g1Var = new g1(J3.h.p(c1708z0, this.targetPath), Environment.DIRECTORY_DCIM, C2541R.string.format_image_file, "jpg");
        c1708z0.w(g1Var);
        g1Var.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        com.llamalab.safs.n nVar = (com.llamalab.safs.n) obj;
        c1708z0.z(this.f16429L1, nVar.toString());
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        int i8 = Build.VERSION.SDK_INT;
        Intent intent = new Intent(17 <= i8 ? "android.media.action.IMAGE_CAPTURE_SECURE" : "android.media.action.IMAGE_CAPTURE");
        if (x7 != null) {
            intent.setPackage(x7);
        }
        if (16 <= i8) {
            Uri build = C1828b.a(nVar).build();
            intent.putExtra("output", build).addFlags(3).setClipData(ClipData.newRawUri(null, build));
        } else {
            intent.putExtra("output", C1951e.d(nVar));
        }
        c1708z0.D(intent, null, this, c1708z0.f(C2541R.integer.ic_device_access_camera), c1708z0.getText(C2541R.string.stmt_capture_image_title));
        return false;
    }
}
