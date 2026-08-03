package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.safs.f;
import i4.C1949c;

@F3.f("content_pick.html")
@F3.a(C2541R.integer.ic_social_content)
@F3.i(C2541R.string.stmt_content_pick_title)
@F3.h(C2541R.string.stmt_content_pick_summary)
@F3.e(C2541R.layout.stmt_content_pick_edit)
/* loaded from: classes.dex */
public final class ContentPick extends ActivityDecision {
    public InterfaceC1700x0 mimeType;
    public InterfaceC1700x0 persistent;
    public J3.l varContentMimeType;
    public J3.l varContentUri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_content_pick);
        l8.v(this.mimeType, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.mimeType);
        if (45 <= dVar.f6413Z) {
            dVar.g(this.persistent);
        }
        dVar.g(this.varContentUri);
        if (2 <= dVar.f6413Z) {
            dVar.g(this.varContentMimeType);
        }
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.mimeType);
        visitor.b(this.persistent);
        visitor.b(this.varContentUri);
        visitor.b(this.varContentMimeType);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.mimeType = (InterfaceC1700x0) cVar.readObject();
        if (45 <= cVar.f6409x0) {
            this.persistent = (InterfaceC1700x0) cVar.readObject();
        }
        this.varContentUri = (J3.l) cVar.readObject();
        if (2 <= cVar.f6409x0) {
            this.varContentMimeType = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        Uri data;
        if (-1 != i8 || (data = intent.getData()) == null) {
            J3.l lVar = this.varContentUri;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            J3.l lVar2 = this.varContentMimeType;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        if (19 <= Build.VERSION.SDK_INT) {
            ((C1949c) f.a.f17733a).P(data, intent.getFlags());
        }
        String uri = data.toString();
        String type = intent.getType();
        J3.l lVar3 = this.varContentUri;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, uri);
        }
        J3.l lVar4 = this.varContentMimeType;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, type);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_content_pick_title);
        CharSequence text = c1708z0.getText(C2541R.string.stmt_content_pick_title);
        String x7 = J3.h.x(c1708z0, this.mimeType, "*/*");
        c1708z0.D((19 > Build.VERSION.SDK_INT || !J3.h.f(c1708z0, this.persistent, false)) ? Intent.createChooser(new Intent("android.intent.action.GET_CONTENT").setType(x7).addCategory("android.intent.category.OPENABLE"), text) : new Intent("android.intent.action.OPEN_DOCUMENT").setType(x7).addCategory("android.intent.category.OPENABLE"), null, this, c1708z0.f(C2541R.integer.ic_social_content), text);
        return false;
    }
}
