package com.llamalab.automate.stmt;

import android.os.DeadObjectException;
import android.os.SystemClock;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import java.lang.reflect.InvocationTargetException;

@F3.f("device_shutdown.html")
@F3.a(C2541R.integer.ic_device_shutdown)
@F3.i(C2541R.string.stmt_device_shutdown_title)
@F3.h(C2541R.string.stmt_device_shutdown_summary)
@F3.c(C2541R.string.caption_device_shutdown)
@F3.e(C2541R.layout.stmt_device_shutdown_edit)
/* loaded from: classes.dex */
public final class DeviceShutdown extends PowerOffAction {

    public static final class a extends AbstractC1602l2 {
        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.C(lVar);
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

    @Override // com.llamalab.automate.stmt.PowerOffAction
    public final void q(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_device_shutdown_title);
        c1708z0.w(new a());
    }

    @Override // com.llamalab.automate.stmt.PowerOffAction
    public final boolean r(C1708z0 c1708z0, long j8) {
        if (Math.abs((System.currentTimeMillis() - SystemClock.elapsedRealtime()) - j8) < 5000) {
            return false;
        }
        return super.r(c1708z0, j8);
    }
}
