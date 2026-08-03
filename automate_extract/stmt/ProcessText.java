package com.llamalab.automate.stmt;

import android.app.PendingIntent;
import android.content.Intent;
import com.llamalab.automate.A2;
import com.llamalab.automate.C1693v1;
import com.llamalab.automate.C1701x1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ProcessTextActivity;
import com.llamalab.automate.Visitor;
import java.util.regex.Pattern;

@F3.a(C2541R.integer.ic_action_process_text)
@F3.f("process_text.html")
@F3.i(C2541R.string.stmt_process_text_title)
@F3.h(C2541R.string.stmt_process_text_summary)
@F3.c(C2541R.string.caption_process_text)
@F3.b(C2541R.layout.block_process_text)
@F3.e(C2541R.layout.stmt_process_text_edit)
/* loaded from: classes.dex */
public final class ProcessText extends Action implements IntentStatement {

    @F3.d(C2541R.id.right)
    public A2 onExpectResult;
    public InterfaceC1700x0 title;
    public J3.l varSelectedText;

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        c1708z0.H(C1693v1.class);
        CharSequence charSequenceExtra = ((Intent) intent.getParcelableExtra("android.intent.extra.INTENT")).getCharSequenceExtra("android.intent.extra.PROCESS_TEXT");
        Pattern pattern = J3.h.f4650a;
        String charSequence = charSequenceExtra == null ? null : charSequenceExtra.toString();
        J3.l lVar = this.varSelectedText;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, charSequence);
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("com.llamalab.automate.intent.extra.PENDING_RESULT");
        if (pendingIntent != null) {
            if (this.onExpectResult != null) {
                c1708z0.w(new K0(pendingIntent, charSequence));
                c1708z0.f17642x0 = this.onExpectResult;
                return true;
            }
            pendingIntent.send(c1708z0, 0, new Intent());
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.onExpectResult);
        dVar.g(this.title);
        dVar.g(this.varSelectedText);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.onExpectResult);
        visitor.b(this.title);
        visitor.b(this.varSelectedText);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.onExpectResult = (A2) cVar.readObject();
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.varSelectedText = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_process_text_title);
        c1708z0.H(K0.class);
        C1693v1 c1693v1 = new C1693v1(C1701x1.s(c1708z0, "com.llamalab.automate.intent.action.PROCESS_TEXT", J3.h.x(c1708z0, this.title, null)).putExtra("android.intent.extra.PROCESS_TEXT_READONLY", this.onExpectResult == null), c1708z0, ProcessTextActivity.class);
        c1708z0.w(c1693v1);
        c1693v1.o(4, "com.llamalab.automate.intent.action.PROCESS_TEXT_ANNOUNCE");
        return false;
    }
}
