package com.llamalab.automate.stmt;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("content_query.html")
@F3.a(C2541R.integer.ic_provider_list)
@F3.i(C2541R.string.stmt_content_query_title)
@F3.h(C2541R.string.stmt_content_query_summary)
@F3.e(C2541R.layout.stmt_content_query_edit)
/* loaded from: classes.dex */
public final class ContentQuery extends Action implements AsyncStatement {
    public InterfaceC1700x0 columnResultType;
    public InterfaceC1700x0 limit;
    public InterfaceC1700x0 offset;
    public InterfaceC1700x0 parameters;
    public InterfaceC1700x0 projection;
    public InterfaceC1700x0 resultType;
    public InterfaceC1700x0 selection;
    public InterfaceC1700x0 sortOrder;
    public InterfaceC1700x0 uri;
    public J3.l varResult;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final Uri f16481L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String[] f16482M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f16483N1;

        /* renamed from: O1, reason: collision with root package name */
        public final String[] f16484O1;

        /* renamed from: P1, reason: collision with root package name */
        public final String f16485P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final int f16486Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final int f16487R1;

        /* renamed from: S1, reason: collision with root package name */
        public final int f16488S1;

        /* renamed from: T1, reason: collision with root package name */
        public final int f16489T1;

        public a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i8, int i9, int i10, int i11) {
            this.f16481L1 = uri;
            this.f16482M1 = strArr;
            this.f16483N1 = str;
            this.f16484O1 = strArr2;
            this.f16485P1 = str2;
            this.f16486Q1 = i8;
            this.f16487R1 = i9;
            this.f16488S1 = i10;
            this.f16489T1 = i11;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            int i8 = this.f16486Q1;
            Cursor query = this.f15400Y.getContentResolver().query(this.f16481L1, this.f16482M1, this.f16483N1, this.f16484O1, this.f16485P1);
            try {
                if (query.moveToPosition(i8)) {
                    q2(w0.L.r(query, Math.min(query.getCount() - i8, this.f16487R1), this.f16488S1, this.f16489T1), false);
                } else {
                    q2(null, false);
                }
            } finally {
                query.close();
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_CALENDAR"), com.llamalab.automate.access.c.j("android.permission.READ_CONTACTS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_content_query);
        l8.v(this.uri, 0);
        l8.v(this.selection, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.uri);
        dVar.g(this.projection);
        dVar.g(this.selection);
        if (68 <= dVar.f6413Z) {
            dVar.g(this.parameters);
        }
        dVar.g(this.sortOrder);
        dVar.g(this.offset);
        dVar.g(this.limit);
        if (68 <= dVar.f6413Z) {
            dVar.g(this.resultType);
        }
        if (112 <= dVar.f6413Z) {
            dVar.g(this.columnResultType);
        }
        dVar.g(this.varResult);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.uri);
        visitor.b(this.projection);
        visitor.b(this.selection);
        visitor.b(this.parameters);
        visitor.b(this.sortOrder);
        visitor.b(this.offset);
        visitor.b(this.limit);
        visitor.b(this.resultType);
        visitor.b(this.columnResultType);
        visitor.b(this.varResult);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.projection = (InterfaceC1700x0) cVar.readObject();
        this.selection = (InterfaceC1700x0) cVar.readObject();
        if (68 <= cVar.f6409x0) {
            this.parameters = (InterfaceC1700x0) cVar.readObject();
        }
        this.sortOrder = (InterfaceC1700x0) cVar.readObject();
        this.offset = (InterfaceC1700x0) cVar.readObject();
        this.limit = (InterfaceC1700x0) cVar.readObject();
        this.resultType = 68 <= cVar.f6409x0 ? (InterfaceC1700x0) cVar.readObject() : new L3.J(2);
        if (112 <= cVar.f6409x0) {
            this.columnResultType = (InterfaceC1700x0) cVar.readObject();
        }
        this.varResult = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        String[] split;
        String[] strArr;
        c1708z0.q(C2541R.string.stmt_content_query_title);
        Uri A7 = J3.h.A(c1708z0, this.uri, null);
        if (A7 == null) {
            throw new RequiredArgumentNullException("uri");
        }
        if (!"content".equals(A7.getScheme())) {
            throw new IllegalArgumentException("Not a content URI");
        }
        Object u8 = J3.h.u(c1708z0, this.projection, null);
        if (u8 == null) {
            strArr = null;
        } else {
            if (u8 instanceof J3.a) {
                split = J3.h.i0((J3.a) u8);
            } else if (u8 instanceof J3.e) {
                J3.e eVar = (J3.e) u8;
                split = (String[]) eVar.t0(new String[eVar.f4641x1]);
            } else {
                String obj = u8.toString();
                split = "*".equals(obj) ? null : obj.split("\\s*,\\s*");
            }
            strArr = split;
        }
        String x7 = J3.h.x(c1708z0, this.selection, null);
        String[] y7 = J3.h.y(c1708z0, this.parameters);
        String x8 = J3.h.x(c1708z0, this.sortOrder, null);
        int m8 = J3.h.m(c1708z0, this.offset, 0);
        int m9 = J3.h.m(c1708z0, this.limit, MoreOsConstants.KEY_BRL_DOT4);
        if (m9 > 500) {
            throw new IllegalArgumentException("Maximum limit is 500");
        }
        a aVar = new a(A7, strArr, x7, y7, x8, m8, m9, J3.h.m(c1708z0, this.resultType, 1), J3.h.m(c1708z0, this.columnResultType, 0));
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varResult;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
