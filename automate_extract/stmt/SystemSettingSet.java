package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.llamalab.auth3p.MicrosoftClient;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.Collections;

@F3.f("system_setting_set.html")
@F3.a(C2541R.integer.ic_action_settings)
@F3.i(C2541R.string.stmt_system_setting_set_title)
@F3.h(C2541R.string.stmt_system_setting_set_summary)
@F3.e(C2541R.layout.stmt_system_setting_set_edit)
/* loaded from: classes.dex */
public final class SystemSettingSet extends Action implements AsyncStatement {
    public InterfaceC1700x0 category;
    public InterfaceC1700x0 name;
    public InterfaceC1700x0 value;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15561v} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 o6 = D1.P.l(context, C2541R.string.caption_system_setting_set).o(-1, this.name);
        o6.u(C2541R.string.caption_to, this.value);
        return o6.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.category);
        dVar.g(this.name);
        dVar.g(this.value);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.category);
        visitor.b(this.name);
        visitor.b(this.value);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.category = (InterfaceC1700x0) cVar.readObject();
        this.name = (InterfaceC1700x0) cVar.readObject();
        this.value = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_system_setting_set_title);
        String x7 = J3.h.x(c1708z0, this.name, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException(MicrosoftClient.PROP_NAME);
        }
        String x8 = J3.h.x(c1708z0, this.value, null);
        int m8 = J3.h.m(c1708z0, this.category, 0);
        if (m8 != 0) {
            if (m8 == 1) {
                Settings.Secure.putString(c1708z0.getContentResolver(), x7, x8);
            } else {
                if (m8 != 2) {
                    throw new IllegalArgumentException("category");
                }
                if (17 <= Build.VERSION.SDK_INT) {
                    Settings.Global.putString(c1708z0.getContentResolver(), x7, x8);
                }
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        if (23 <= Build.VERSION.SDK_INT && !e1.d(x7)) {
            if (com.llamalab.automate.access.c.f15550k.A(c1708z0)) {
                c1708z0.w(new L0(Collections.singletonMap(x7, x8)));
                return false;
            }
            if (e1.c(c1708z0)) {
                e1.e(c1708z0, x7, x8);
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
        }
        Settings.System.putString(c1708z0.getContentResolver(), x7, x8);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
