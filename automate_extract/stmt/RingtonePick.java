package com.llamalab.automate.stmt;

import android.content.Intent;
import android.net.Uri;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("ringtone_pick.html")
@F3.a(C2541R.integer.ic_note_select)
@F3.i(C2541R.string.stmt_ringtone_pick_title)
@F3.h(C2541R.string.stmt_ringtone_pick_summary)
@F3.c(C2541R.string.caption_ringtone_pick)
@F3.e(C2541R.layout.stmt_ringtone_pick_edit)
/* loaded from: classes.dex */
public class RingtonePick extends ActivityDecision {
    public InterfaceC1700x0 ringtoneTypes;
    public InterfaceC1700x0 showSilent;
    public J3.l varSoundUri;

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.ringtoneTypes);
        dVar.g(this.showSilent);
        dVar.g(this.varSoundUri);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.ringtoneTypes);
        visitor.b(this.showSilent);
        visitor.b(this.varSoundUri);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.ringtoneTypes = (InterfaceC1700x0) cVar.readObject();
        this.showSilent = (InterfaceC1700x0) cVar.readObject();
        this.varSoundUri = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varSoundUri;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
        String uri2 = uri != null ? uri.toString() : null;
        J3.l lVar2 = this.varSoundUri;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, uri2);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ringtone_pick_title);
        int m8 = J3.h.m(c1708z0, this.ringtoneTypes, 7);
        c1708z0.D(new Intent("android.intent.action.RINGTONE_PICKER").putExtra("android.intent.extra.ringtone.TYPE", m8).putExtra("android.intent.extra.ringtone.SHOW_SILENT", J3.h.f(c1708z0, this.showSilent, false)), null, this, c1708z0.f(C2541R.integer.ic_note_select), c1708z0.getText(C2541R.string.stmt_ringtone_pick_title));
        return false;
    }
}
