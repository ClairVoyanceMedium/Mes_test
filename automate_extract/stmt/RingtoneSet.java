package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("ringtone_set.html")
@F3.a(C2541R.integer.ic_device_access_ring_sound)
@F3.i(C2541R.string.stmt_ringtone_set_title)
@F3.h(C2541R.string.stmt_ringtone_set_summary)
@F3.e(C2541R.layout.stmt_ringtone_set_edit)
/* loaded from: classes.dex */
public class RingtoneSet extends RingtoneAction {
    public InterfaceC1700x0 soundUri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15561v} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_ringtone_set);
        l8.u(C2541R.string.caption_to, this.soundUri);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.RingtoneAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.soundUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.ringtoneType);
        visitor.b(this.soundUri);
    }

    @Override // com.llamalab.automate.stmt.RingtoneAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.soundUri = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ringtone_set_title);
        String x7 = J3.h.x(c1708z0, this.soundUri, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("soundUri");
        }
        int m8 = J3.h.m(c1708z0, this.ringtoneType, 1);
        if (m8 != 1 && m8 != 2 && m8 != 4) {
            throw new IllegalArgumentException("ringtoneType");
        }
        RingtoneManager.setActualDefaultRingtoneUri(c1708z0, m8, Uri.parse(x7));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
