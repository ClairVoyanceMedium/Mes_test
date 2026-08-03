package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1616p0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("content_changed.html")
@F3.a(C2541R.integer.ic_content_change)
@F3.i(C2541R.string.stmt_content_changed_title)
@F3.h(C2541R.string.stmt_content_changed_summary)
@F3.e(C2541R.layout.stmt_content_changed_edit)
/* loaded from: classes.dex */
public final class ContentChanged extends Action implements AsyncStatement {
    public InterfaceC1700x0 descendants;
    public InterfaceC1700x0 uri;
    public J3.l varChangeUri;

    public static final class a extends C1616p0 {
        @Override // com.llamalab.automate.C1616p0
        public final void x2(Uri uri) {
            q2(uri != null ? uri.toString() : null, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_content_changed);
        l8.v(this.uri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.uri);
        dVar.g(this.descendants);
        dVar.g(this.varChangeUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.uri);
        visitor.b(this.descendants);
        visitor.b(this.varChangeUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.descendants = (InterfaceC1700x0) cVar.readObject();
        this.varChangeUri = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_content_changed_title);
        Uri A7 = J3.h.A(c1708z0, this.uri, null);
        if (A7 == null) {
            throw new RequiredArgumentNullException("uri");
        }
        if (!"content".equals(A7.getScheme())) {
            throw new IllegalArgumentException("Not a content URI");
        }
        boolean f8 = J3.h.f(c1708z0, this.descendants, false);
        a aVar = new a();
        c1708z0.w(aVar);
        aVar.w2(f8, A7);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varChangeUri;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
