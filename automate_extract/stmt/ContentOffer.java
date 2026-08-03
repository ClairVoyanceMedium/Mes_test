package com.llamalab.automate.stmt;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1693v1;
import com.llamalab.automate.C1701x1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ContentOfferActivity;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("content_offer.html")
@F3.a(C2541R.integer.ic_social_share)
@F3.i(C2541R.string.stmt_content_offer_title)
@F3.h(C2541R.string.stmt_content_offer_summary)
@F3.c(C2541R.string.caption_content_offer)
@F3.e(C2541R.layout.stmt_content_offer_edit)
/* loaded from: classes.dex */
public final class ContentOffer extends Action implements IntentStatement {
    public InterfaceC1700x0 mimeType;
    public InterfaceC1700x0 title;
    public J3.l varContentMimeType;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_content_offer);
        l8.v(this.title, 0);
        l8.v(this.mimeType, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        c1708z0.H(C1701x1.class);
        String type = ((Intent) intent.getParcelableExtra("android.intent.extra.INTENT")).getType();
        String stringExtra = intent.getStringExtra("com.llamalab.automate.intent.extra.MIME_TYPE");
        if (type == null || type.equals("*/*") || (stringExtra != null && !stringExtra.equals("*/*") && type.endsWith("/*"))) {
            type = stringExtra;
        }
        c1708z0.w(new C1673v((PendingIntent) intent.getParcelableExtra("com.llamalab.automate.intent.extra.PENDING_RESULT"), type));
        J3.l lVar = this.varContentMimeType;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, type);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.title);
        dVar.g(this.mimeType);
        dVar.g(this.varContentMimeType);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.title);
        visitor.b(this.mimeType);
        visitor.b(this.varContentMimeType);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.mimeType = (InterfaceC1700x0) cVar.readObject();
        this.varContentMimeType = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_content_offer_title);
        c1708z0.H(C1673v.class);
        String x7 = J3.h.x(c1708z0, this.title, null);
        String x8 = J3.h.x(c1708z0, this.mimeType, "*/*");
        Intent putExtra = C1701x1.s(c1708z0, "com.llamalab.automate.intent.action.CONTENT_OFFER", x7).putExtra("com.llamalab.automate.intent.extra.MIME_TYPE", x8);
        IntentFilter intentFilter = new IntentFilter("com.llamalab.automate.intent.action.CONTENT_OFFER_ANNOUNCE");
        intentFilter.addDataType(x8);
        C1693v1 c1693v1 = new C1693v1(putExtra, c1708z0, ContentOfferActivity.class);
        c1708z0.w(c1693v1);
        c1693v1.m(4, intentFilter);
        return false;
    }
}
