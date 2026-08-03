package com.llamalab.automate.stmt;

import android.media.RingtoneManager;
import android.net.Uri;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.Visitor;

@F3.f("ringtone_get.html")
@F3.a(C2541R.integer.ic_device_access_ring_sound)
@F3.i(C2541R.string.stmt_ringtone_get_title)
@F3.h(C2541R.string.stmt_ringtone_get_summary)
@F3.c(C2541R.string.caption_ringtone_get)
@F3.e(C2541R.layout.stmt_ringtone_get_edit)
/* loaded from: classes.dex */
public class RingtoneGet extends RingtoneAction {
    public J3.l varSoundUri;

    @Override // com.llamalab.automate.stmt.RingtoneAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varSoundUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.ringtoneType);
        visitor.b(this.varSoundUri);
    }

    @Override // com.llamalab.automate.stmt.RingtoneAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varSoundUri = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ringtone_get_title);
        if (this.varSoundUri != null) {
            int m8 = J3.h.m(c1708z0, this.ringtoneType, 1);
            if (m8 != 1 && m8 != 2 && m8 != 4) {
                throw new IllegalArgumentException("ringtoneType");
            }
            Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(c1708z0, m8);
            c1708z0.z(this.varSoundUri.f4659Y, actualDefaultRingtoneUri != null ? actualDefaultRingtoneUri.toString() : null);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
