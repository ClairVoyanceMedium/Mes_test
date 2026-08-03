package com.llamalab.automate.stmt;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import g4.C1828b;
import i4.C1951e;
import x3.C2434l;

@F3.f("compose_mms.html")
@F3.a(C2541R.integer.ic_social_new_chat_pic)
@F3.i(C2541R.string.stmt_compose_mms_title)
@F3.h(C2541R.string.stmt_compose_mms_summary)
@F3.e(C2541R.layout.stmt_compose_mms_edit)
/* loaded from: classes.dex */
public final class ComposeMms extends Action {
    public InterfaceC1700x0 attachment;
    public InterfaceC1700x0 message;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 phoneNumber;
    public InterfaceC1700x0 subject;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15547h} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_compose_mms_title);
        l8.u(C2541R.string.caption_to, this.phoneNumber);
        l8.v(this.subject, 0);
        l8.v(this.message, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.phoneNumber);
        dVar.g(this.subject);
        dVar.g(this.message);
        dVar.g(this.attachment);
        if (91 <= dVar.f6413Z) {
            dVar.g(this.packageName);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.phoneNumber);
        visitor.b(this.subject);
        visitor.b(this.message);
        visitor.b(this.attachment);
        visitor.b(this.packageName);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.phoneNumber = (InterfaceC1700x0) cVar.readObject();
        this.subject = (InterfaceC1700x0) cVar.readObject();
        this.message = (InterfaceC1700x0) cVar.readObject();
        this.attachment = (InterfaceC1700x0) cVar.readObject();
        if (91 <= cVar.f6409x0) {
            this.packageName = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_compose_mms_title);
        e(c1708z0);
        String[] w8 = J3.h.w(c1708z0, this.phoneNumber, C2434l.f23396g);
        String x7 = J3.h.x(c1708z0, this.subject, null);
        String x8 = J3.h.x(c1708z0, this.message, null);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.attachment);
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mms", TextUtils.join(",", w8), null)).addFlags(268697600).setPackage(J3.h.x(c1708z0, this.packageName, null));
        if (x7 != null) {
            intent.putExtra("subject", x7);
        }
        if (x8 != null) {
            intent.putExtra("sms_body", x8);
        }
        if (p8 != null) {
            if (16 <= Build.VERSION.SDK_INT) {
                Uri build = C1828b.a(p8).build();
                intent.putExtra("android.intent.extra.STREAM", build).addFlags(1).setClipData(ClipData.newRawUri(null, build));
            } else {
                intent.putExtra("android.intent.extra.STREAM", C1951e.d(p8));
            }
        }
        c1708z0.startActivity(intent);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
