package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.SystemClock;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.lang.reflect.InvocationTargetException;

@F3.f("device_reboot.html")
@F3.a(C2541R.integer.ic_device_shutdown)
@F3.i(C2541R.string.stmt_device_reboot_title)
@F3.h(C2541R.string.stmt_device_reboot_summary)
@F3.e(C2541R.layout.stmt_device_reboot_edit)
/* loaded from: classes.dex */
public final class DeviceReboot extends PowerOffAction {
    public InterfaceC1700x0 reason;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final String f16581M1;

        public a(String str) {
            this.f16581M1 = str;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.B2(this.f16581M1, lVar);
                lVar.c();
                a();
            } catch (InvocationTargetException e8) {
                th = e8.getTargetException();
                if (th instanceof DeadObjectException) {
                    a();
                    return;
                }
                r2(th);
            } catch (Throwable th) {
                th = th;
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_device_reboot).o(0, this.reason).q(this.reason).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.reason);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.reason);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.reason = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.PowerOffAction
    public final void q(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_device_reboot_title);
        c1708z0.w(new a(J3.h.x(c1708z0, this.reason, null)));
    }

    @Override // com.llamalab.automate.stmt.PowerOffAction
    public final boolean r(C1708z0 c1708z0, long j8) {
        if (Math.abs((System.currentTimeMillis() - SystemClock.elapsedRealtime()) - j8) < 5000) {
            return false;
        }
        return super.r(c1708z0, j8);
    }
}
