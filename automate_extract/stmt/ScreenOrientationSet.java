package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import com.llamalab.automate.AbstractC1553a2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("screen_orientation_set.html")
@F3.a(C2541R.integer.ic_device_access_screen_rotation)
@F3.i(C2541R.string.stmt_screen_orientation_set_title)
@F3.h(C2541R.string.stmt_screen_orientation_set_summary)
@F3.e(C2541R.layout.stmt_screen_orientation_set_edit)
/* loaded from: classes.dex */
public class ScreenOrientationSet extends Action {
    public InterfaceC1700x0 orientation;

    public static final class a extends AbstractC1553a2 {
        public final void x2(int i8) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, AbstractC1553a2.f15480M1, 280, -3);
            layoutParams.gravity = 51;
            layoutParams.alpha = 0.0f;
            layoutParams.softInputMode = 1;
            layoutParams.screenOrientation = i8;
            w2(layoutParams);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15547h} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.SYSTEM_ALERT_WINDOW")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_screen_orientation_set).e(this.orientation, -1, C2541R.xml.screen_orientations_window).q(this.orientation).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.orientation);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.orientation);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.orientation = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (18 <= android.os.Build.VERSION.SDK_INT) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        boolean z7;
        a aVar;
        c1708z0.q(C2541R.string.stmt_screen_orientation_set_title);
        int m8 = J3.h.m(c1708z0, this.orientation, -1);
        switch (m8) {
            case -1:
                z7 = true;
                aVar = (a) c1708z0.c(a.class);
                if (aVar == null) {
                    if (z7) {
                        aVar.a();
                    } else {
                        aVar.x2(m8);
                    }
                } else if (!z7) {
                    a aVar2 = new a();
                    c1708z0.w(aVar2);
                    aVar2.x2(m8);
                }
                c1708z0.f17642x0 = this.onComplete;
                return true;
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                z7 = false;
                aVar = (a) c1708z0.c(a.class);
                if (aVar == null) {
                }
                c1708z0.f17642x0 = this.onComplete;
                return true;
            case 3:
            default:
                throw new IllegalArgumentException("orientation");
            case 11:
            case 12:
            case 13:
                break;
        }
    }
}
