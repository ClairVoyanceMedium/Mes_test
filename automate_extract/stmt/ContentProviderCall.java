package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("content_provider_call.html")
@F3.a(C2541R.integer.ic_provider_list)
@F3.i(C2541R.string.stmt_content_provider_call_title)
@F3.h(C2541R.string.stmt_content_provider_call_summary)
@F3.e(C2541R.layout.stmt_content_provider_call_edit)
/* loaded from: classes.dex */
public final class ContentProviderCall extends Action implements AsyncStatement {
    public InterfaceC1700x0 arg;
    public InterfaceC1700x0 authority;
    public InterfaceC1700x0 extras;
    public InterfaceC1700x0 method;
    public J3.l varResult;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16477L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String f16478M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f16479N1;

        /* renamed from: O1, reason: collision with root package name */
        public final Bundle f16480O1;

        public a(String str, String str2, String str3, Bundle bundle) {
            this.f16477L1 = str;
            this.f16478M1 = str2;
            this.f16479N1 = str3;
            this.f16480O1 = bundle;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            Bundle call;
            int i8 = Build.VERSION.SDK_INT;
            Bundle bundle = this.f16480O1;
            String str = this.f16479N1;
            String str2 = this.f16478M1;
            String str3 = this.f16477L1;
            if (29 <= i8) {
                call = this.f15400Y.getContentResolver().call(str3, str2, str, bundle);
            } else {
                call = this.f15400Y.getContentResolver().call(new Uri.Builder().scheme("content").authority(str3).build(), str2, str, bundle);
            }
            q2(call, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_CALENDAR"), com.llamalab.automate.access.c.j("android.permission.READ_CONTACTS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_content_provider_call);
        l8.v(this.authority, 0);
        l8.v(this.extras, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.authority);
        dVar.g(this.method);
        dVar.g(this.arg);
        dVar.g(this.extras);
        dVar.g(this.varResult);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.authority);
        visitor.b(this.method);
        visitor.b(this.arg);
        visitor.b(this.extras);
        visitor.b(this.varResult);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.authority = (InterfaceC1700x0) cVar.readObject();
        this.method = (InterfaceC1700x0) cVar.readObject();
        this.arg = (InterfaceC1700x0) cVar.readObject();
        this.extras = (InterfaceC1700x0) cVar.readObject();
        this.varResult = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_content_provider_call_title);
        String x7 = J3.h.x(c1708z0, this.authority, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("authority");
        }
        if ("com.llamalab.automate.provider".equals(x7)) {
            throw new SecurityException("Automate is not permitted");
        }
        String x8 = J3.h.x(c1708z0, this.method, null);
        if (x8 == null) {
            throw new RequiredArgumentNullException("method");
        }
        String x9 = J3.h.x(c1708z0, this.arg, null);
        J3.e h8 = J3.h.h(c1708z0, this.extras);
        a aVar = new a(x7, x8, x9, h8 != null ? J3.h.K(h8) : null);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varResult;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj != null ? J3.h.O(0, (Bundle) obj) : null);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
