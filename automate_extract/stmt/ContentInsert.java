package com.llamalab.automate.stmt;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("content_insert.html")
@F3.a(C2541R.integer.ic_provider_new)
@F3.i(C2541R.string.stmt_content_insert_title)
@F3.h(C2541R.string.stmt_content_insert_summary)
@F3.e(C2541R.layout.stmt_content_insert_edit)
/* loaded from: classes.dex */
public final class ContentInsert extends Action implements AsyncStatement {
    public InterfaceC1700x0 uri;
    public InterfaceC1700x0 values;
    public J3.l varRowUri;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final Uri f16475L1;

        /* renamed from: M1, reason: collision with root package name */
        public final ContentValues f16476M1;

        public a(Uri uri, ContentValues contentValues) {
            this.f16475L1 = uri;
            this.f16476M1 = contentValues;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            Uri insert = this.f15400Y.getContentResolver().insert(this.f16475L1, this.f16476M1);
            q2(insert != null ? insert.toString() : null, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_CALENDAR"), com.llamalab.automate.access.c.j("android.permission.WRITE_CONTACTS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_content_insert);
        l8.v(this.uri, 0);
        l8.v(this.values, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.uri);
        dVar.g(this.values);
        dVar.g(this.varRowUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.uri);
        visitor.b(this.values);
        visitor.b(this.varRowUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.values = (InterfaceC1700x0) cVar.readObject();
        this.varRowUri = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_content_insert_title);
        Uri A7 = J3.h.A(c1708z0, this.uri, null);
        if (A7 == null) {
            throw new RequiredArgumentNullException("uri");
        }
        if (!"content".equals(A7.getScheme())) {
            throw new IllegalArgumentException("Not a content URI");
        }
        if ("com.llamalab.automate.provider".equals(A7.getAuthority())) {
            throw new SecurityException("Automate is not permitted");
        }
        J3.e h8 = J3.h.h(c1708z0, this.values);
        if (h8 == null) {
            throw new RequiredArgumentNullException("value");
        }
        ContentValues N7 = J3.h.N(h8);
        if (N7.size() == 0) {
            throw new IllegalArgumentException("No values");
        }
        a aVar = new a(A7, N7);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varRowUri;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
