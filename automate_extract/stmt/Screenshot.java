package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.os.Build;
import android.os.Environment;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.C1695w;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("screenshot.html")
@F3.a(C2541R.integer.ic_device_access_screen_capture)
@F3.i(C2541R.string.stmt_screenshot_title)
@F3.h(C2541R.string.stmt_screenshot_summary)
@F3.c(C2541R.string.stmt_screenshot_title)
@F3.e(C2541R.layout.stmt_screenshot_edit)
/* loaded from: classes.dex */
public final class Screenshot extends Action implements AsyncStatement, IntentStatement {
    public InterfaceC1700x0 displayId;
    public InterfaceC1700x0 targetPath;
    public J3.l varImageFile;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        int i8 = Build.VERSION.SDK_INT;
        if (30 > i8) {
            return 30 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.f15540a} : 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.f15547h} : 21 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.f15540a} : new E3.b[]{com.llamalab.automate.access.c.f15551l, com.llamalab.automate.access.c.f15540a};
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        MediaProjection mediaProjection;
        int i8 = C1708z0.f17633Q1;
        int intExtra = intent.getIntExtra("com.llamalab.automate.intent.extra.RESULT_CODE", 0);
        if (-1 != intExtra) {
            throw new IllegalStateException("User canceled screen capture request");
        }
        mediaProjection = C1695w.l(c1708z0.getSystemService("media_projection")).getMediaProjection(intExtra, (Intent) intent.getParcelableExtra("com.llamalab.automate.intent.extra.RESULT_INTENT"));
        if (mediaProjection == null) {
            throw new IllegalStateException("Failed to get MediaProjection");
        }
        c1708z0.w(new Q0(mediaProjection, J3.h.p(c1708z0, this.targetPath)));
        return false;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (94 <= dVar.f6413Z) {
            dVar.g(this.displayId);
        }
        dVar.g(this.targetPath);
        dVar.g(this.varImageFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.displayId);
        visitor.b(this.targetPath);
        visitor.b(this.varImageFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (94 <= cVar.f6409x0) {
            this.displayId = (InterfaceC1700x0) cVar.readObject();
        }
        this.targetPath = (InterfaceC1700x0) cVar.readObject();
        this.varImageFile = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Intent createScreenCaptureIntent;
        c1708z0.q(C2541R.string.stmt_screenshot_title);
        e(c1708z0);
        int i8 = Build.VERSION.SDK_INT;
        if (30 <= i8) {
            int m8 = J3.h.m(c1708z0, this.displayId, 0);
            com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.targetPath);
            AutomateAccessibilityService f8 = AbstractStatement.f();
            R0 r02 = new R0(p8);
            c1708z0.w(r02);
            try {
                f8.takeScreenshot(m8, c1708z0.getMainExecutor(), r02);
            } catch (Throwable th) {
                r02.a();
                throw th;
            }
        } else if (21 <= i8) {
            createScreenCaptureIntent = C1695w.l(c1708z0.getSystemService("media_projection")).createScreenCaptureIntent();
            c1708z0.B(createScreenCaptureIntent.addFlags(MoreOsConstants.O_DIRECTORY), null, 0L, true, c1708z0.f(C2541R.integer.ic_device_access_screen_capture), c1708z0.getText(C2541R.string.stmt_screenshot_title), c1708z0.r());
        } else {
            c1708z0.w(new S0(J3.h.p(c1708z0, this.targetPath)));
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varImageFile;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
