package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.StartServiceReceiver;
import com.llamalab.automate.Visitor;
import java.util.concurrent.TimeoutException;
import x3.C2425c;

@F3.f("plugin_setting.html")
@F3.a(C2541R.integer.ic_plugin_action)
@F3.i(C2541R.string.stmt_plugin_setting_title)
@F3.h(C2541R.string.stmt_plugin_setting_summary)
@F3.e(C2541R.layout.stmt_plugin_setting_edit)
/* loaded from: classes.dex */
public final class PlugInSetting extends IntermittentAction implements ReceiverStatement, IntentStatement, AsyncStatement {
    public final I0 plugin = new I0();

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        AbstractStatement.d(c1708z0, this, "com.llamalab.automate.intent.action.PENDING_PLUGIN_TIMEOUT");
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 31 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15557r} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.A(this.plugin.f16398x0);
        c1596k0.r(C2541R.string.stmt_plugin_setting_title);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        String action = intent.getAction();
        if (!"com.llamalab.automate.intent.action.PENDING_PLUGIN_COMPLETE".equals(action)) {
            if ("com.llamalab.automate.intent.action.PENDING_PLUGIN_TIMEOUT".equals(action)) {
                throw new TimeoutException("Plug-in didn't respond within requested timeout");
            }
            return false;
        }
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        int intExtra = intent.getIntExtra("net.dinglisch.android.tasker.extras.RESULT_CODE", -1);
        if (a8) {
            c1708z0.p("PlugInSetting ACTION_PENDING_PLUGIN_COMPLETE: resultCode=" + intExtra);
        }
        return s(c1708z0, intExtra, intent.getExtras(), a8);
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        if (!"com.twofortyfouram.locale.intent.action.FIRE_SETTING".equals(intent.getAction())) {
            return false;
        }
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        int resultCode = abstractC1618p2.getResultCode();
        if (a8) {
            c1708z0.p("PlugInSetting ACTION_FIRE_SETTING: resultCode=" + resultCode);
        }
        return s(c1708z0, resultCode, abstractC1618p2.getResultExtras(false), a8);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        this.plugin.Y0(dVar);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.plugin);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new H0();
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.plugin.o0(cVar);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_plugin_setting_title);
        Intent putExtra = this.plugin.b(c1708z0, "com.twofortyfouram.locale.intent.action.FIRE_SETTING").putExtra("net.dinglisch.android.tasker.extras.COMPLETION_INTENT", new Intent("com.llamalab.automate.intent.action.PENDING_PLUGIN_COMPLETE", F5.n.c(c1708z0), c1708z0, StartServiceReceiver.class).putExtra("net.dinglisch.android.tasker.EXTRA_CALL_SERVICE_PACKAGE", c1708z0.getPackageName()).putExtra("net.dinglisch.android.tasker.EXTRA_CALL_SERVICE", AutomateService.class.getName()).putExtra("net.dinglisch.android.tasker.EXTRA_CALL_SERVICE_FOREGROUND", 26 <= Build.VERSION.SDK_INT).toUri(1));
        A0 a02 = new A0();
        c1708z0.w(a02);
        a02.m(2, new IntentFilter());
        if (this.plugin.f16709M1 == 0 || C0.h(c1708z0, putExtra, null) == null) {
            c1708z0.sendOrderedBroadcast(C0.e(c1708z0, putExtra), null, a02, c1708z0.j2().f14581L1, -1, null, null);
        }
        return false;
    }

    public final boolean s(C1708z0 c1708z0, int i8, Bundle bundle, boolean z7) {
        if (i8 != -1 && i8 != 1) {
            if (i8 == 3) {
                int i9 = this.plugin.f16709M1;
                if (i9 == 3600000) {
                    return false;
                }
                if (i9 <= 0 && (bundle == null || (i9 = bundle.getInt("net.dinglisch.android.tasker.extras.REQUESTED_TIMEOUT", 0)) <= 0 || i9 == 3600000)) {
                    return false;
                }
                if (this.plugin.f16710N1) {
                    if (z7) {
                        c1708z0.p("Ignoring requested " + i9 + "ms timeout");
                    }
                    return false;
                }
                if (z7) {
                    c1708z0.p("Starting " + i9 + "ms timeout, as requested");
                }
                if (i9 > 3599000) {
                    i9 = 3599000;
                }
                AbstractStatement.m(c1708z0, 3, false, i9 + SystemClock.elapsedRealtime(), 0L, "com.llamalab.automate.intent.action.PENDING_PLUGIN_TIMEOUT", null);
                return false;
            }
            if (i8 != 16) {
                throw new IllegalStateException(B4.g.g("Plug-in failed with result code: ", i8));
            }
        }
        AbstractStatement.d(c1708z0, this, "com.llamalab.automate.intent.action.PENDING_PLUGIN_TIMEOUT");
        c1708z0.I(A0.class, this.f16218X);
        this.plugin.c(c1708z0, bundle);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        throw new TimeoutException("Plug-in didn't respond within requested timeout");
    }
}
