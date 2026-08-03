package com.llamalab.automate.stmt;

import P.C1092h;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Iterator;
import java.util.List;

@F3.f("profile_quiet_mode_request.html")
@F3.a(C2541R.integer.ic_corp_off)
@F3.i(C2541R.string.stmt_profile_quiet_mode_request_title)
@F3.h(C2541R.string.stmt_profile_quiet_mode_request_summary)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_profile_quiet_mode_request_edit)
/* loaded from: classes.dex */
public final class ProfileQuietModeRequest extends Decision {
    public InterfaceC1700x0 flags;
    public InterfaceC1700x0 state;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 28 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.MODIFY_QUIET_MODE")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, true, C2541R.string.caption_profile_quiet_mode_enable, C2541R.string.caption_profile_quiet_mode_disable).r(C2541R.string.caption_profile_quiet_mode_request).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.state);
        dVar.g(this.flags);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.state);
        visitor.b(this.flags);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.state = (InterfaceC1700x0) cVar.readObject();
        this.flags = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        UserHandle myUserHandle;
        List userProfiles;
        boolean equals;
        c1708z0.q(C2541R.string.stmt_profile_quiet_mode_request_title);
        IncapableAndroidVersionException.a(28);
        boolean f8 = J3.h.f(c1708z0, this.state, false);
        boolean f9 = J3.h.f(c1708z0, this.flags, false);
        UserManager h8 = C1092h.h(c1708z0.getSystemService("user"));
        myUserHandle = Process.myUserHandle();
        userProfiles = h8.getUserProfiles();
        Iterator it = userProfiles.iterator();
        while (it.hasNext()) {
            UserHandle g8 = N.c.g(it.next());
            equals = myUserHandle.equals(g8);
            if (!equals) {
                o(c1708z0, 30 <= Build.VERSION.SDK_INT ? h8.requestQuietModeEnabled(f8, g8, f9 ? 1 : 0) : h8.requestQuietModeEnabled(f8, g8));
                return true;
            }
        }
        throw new IllegalStateException("No managed profile user found");
    }
}
