package com.llamalab.automate.stmt;

import C1.D1;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.E1;
import com.llamalab.automate.F1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import g4.C1827a;

@F3.a(C2541R.integer.ic_publish)
@F3.f("interface_layout_update.html")
@F3.i(C2541R.string.stmt_interface_adapter_update_title)
@F3.h(C2541R.string.stmt_interface_adapter_update_summary)
@F3.c(C2541R.string.caption_interface_layout_update)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_interface_adapter_update_edit)
/* loaded from: classes.dex */
public final class InterfaceAdapterUpdate extends Decision {
    public InterfaceC1700x0 adapterViewId;
    public InterfaceC1700x0 interfaceUri;
    public InterfaceC1700x0 invalidate;
    public InterfaceC1700x0 itemCount;
    public J3.l varItemCount;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_interface_adapter_update);
        l8.v(this.interfaceUri, 0);
        l8.v(this.adapterViewId, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.interfaceUri);
        dVar.g(this.adapterViewId);
        dVar.g(this.itemCount);
        dVar.g(this.invalidate);
        dVar.g(this.varItemCount);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.interfaceUri);
        visitor.b(this.adapterViewId);
        visitor.b(this.itemCount);
        visitor.b(this.invalidate);
        visitor.b(this.varItemCount);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.interfaceUri = (InterfaceC1700x0) cVar.readObject();
        this.adapterViewId = (InterfaceC1700x0) cVar.readObject();
        this.itemCount = (InterfaceC1700x0) cVar.readObject();
        this.invalidate = (InterfaceC1700x0) cVar.readObject();
        this.varItemCount = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Cursor query;
        c1708z0.q(C2541R.string.stmt_interface_adapter_update_title);
        Uri A7 = J3.h.A(c1708z0, this.interfaceUri, null);
        if (A7 == null) {
            throw new RequiredArgumentNullException("InterfaceUri");
        }
        if (J3.h.x(c1708z0, this.adapterViewId, null) == null) {
            throw new RequiredArgumentNullException("adapterViewId");
        }
        Integer o6 = J3.h.o(c1708z0, this.itemCount, null);
        boolean f8 = J3.h.f(c1708z0, this.invalidate, false);
        int match = C1827a.m.C0206a.f18790a.match(A7);
        com.llamalab.automate.F0 f02 = c1708z0.f17641Z;
        if (match == 10) {
            Y.h(f02.f14847y0, A7);
            query = c1708z0.getContentResolver().query(A7, new String[]{"native_id", "data"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
            try {
                if (query.moveToNext()) {
                    int i8 = query.getInt(0);
                    C1646h c1646h = new C1646h(query.getBlob(1));
                    query.close();
                    z(c1708z0, F1.c(c1708z0).a(C1827a.f.AbstractC0203a.b(Y.i(D1.u(c1708z0, c1646h.f16946a), r10), A7).build(), i8), o6, f8);
                } else {
                    w(c1708z0, false, null);
                }
                return true;
            } finally {
            }
        }
        if (match == 12) {
            Y.h(f02.f14847y0, A7);
            IncapableAndroidVersionException.a(17);
            query = c1708z0.getContentResolver().query(A7, new String[]{"data"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
            try {
                if (query.moveToNext()) {
                    C1646h c1646h2 = new C1646h(query.getBlob(0));
                    query.close();
                    z(c1708z0, F1.c(c1708z0).b(C1827a.f.AbstractC0203a.b(Y.i(D1.u(c1708z0, c1646h2.f16946a), r10), A7).build()), o6, f8);
                } else {
                    w(c1708z0, false, null);
                }
                return true;
            } finally {
            }
        }
        if (match != 14) {
            throw new IllegalArgumentException("Unsupported interface URI");
        }
        Y.h(f02.f14847y0, A7);
        IncapableAndroidVersionException.a(21);
        if (Y.f(c1708z0)) {
            query = c1708z0.getContentResolver().query(A7, new String[]{"data"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
            try {
                if (query.moveToNext()) {
                    C1646h c1646h3 = new C1646h(query.getBlob(0));
                    query.close();
                    z(c1708z0, F1.c(c1708z0).b(C1827a.f.AbstractC0203a.b(Y.i(D1.u(c1708z0, c1646h3.f16946a), r10), A7).build()), o6, f8);
                } else {
                    w(c1708z0, false, null);
                }
            } finally {
            }
        } else {
            w(c1708z0, false, null);
        }
        return true;
    }

    public final boolean w(C1708z0 c1708z0, boolean z7, Double d8) {
        J3.l lVar = this.varItemCount;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, z7);
        return true;
    }

    public final void z(C1708z0 c1708z0, E1 e12, Integer num, boolean z7) {
        double d8;
        if (e12 == null) {
            d8 = 0.0d;
        } else {
            int count = e12.getCount();
            if (num != null) {
                e12.e(num.intValue(), z7);
            } else if (z7) {
                e12.notifyDataSetChanged();
            }
            d8 = count;
        }
        w(c1708z0, true, Double.valueOf(d8));
    }
}
