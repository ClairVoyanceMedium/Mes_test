package com.llamalab.automate.stmt;

import android.os.DeadObjectException;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import java.lang.reflect.InvocationTargetException;

@F3.f("device_restart.html")
@F3.a(C2541R.integer.ic_device_shutdown)
@F3.i(C2541R.string.stmt_device_restart_title)
@F3.h(C2541R.string.stmt_device_restart_summary)
@F3.c(C2541R.string.caption_device_restart)
@F3.e(C2541R.layout.stmt_device_restart_edit)
/* loaded from: classes.dex */
public final class DeviceRestart extends PowerOffAction {

    public static final class a extends AbstractC1602l2 {
        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.m2(lVar);
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
        c1708z0.q(C2541R.string.stmt_device_restart_title);
        IncapableAndroidVersionException.a(19);
        c1708z0.w(new a());
    }
}
