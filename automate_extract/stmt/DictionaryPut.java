package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.ConversionType;
import com.llamalab.automate.expr.func.Type;

@F3.f("dictionary_put.html")
@F3.a(C2541R.integer.ic_dict_put)
@F3.i(C2541R.string.stmt_dictionary_put_title)
@F3.h(C2541R.string.stmt_dictionary_put_summary)
@F3.e(C2541R.layout.stmt_dictionary_put_edit)
/* loaded from: classes.dex */
public final class DictionaryPut extends DictionarySubscriptAction {
    public InterfaceC1700x0 type;
    public InterfaceC1700x0 value;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_dictionary_put);
        l8.v(this.key, 0);
        l8.u(C2541R.string.caption_in, this.varDictionary);
        l8.u(C2541R.string.caption_to, this.value);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.DictionarySubscriptAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.value);
        if (79 <= dVar.f6413Z) {
            dVar.g(this.type);
        } else {
            InterfaceC1700x0 interfaceC1700x0 = this.type;
            ConversionType.writeObject(dVar, interfaceC1700x0 instanceof J3.k ? ConversionType.forName(J3.h.f0(null, interfaceC1700x0)) : null);
        }
    }

    @Override // com.llamalab.automate.stmt.DictionarySubscriptAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.value);
        visitor.b(this.type);
    }

    @Override // com.llamalab.automate.stmt.DictionarySubscriptAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.value = (InterfaceC1700x0) cVar.readObject();
        if (79 <= cVar.f6409x0) {
            this.type = (InterfaceC1700x0) cVar.readObject();
            return;
        }
        ConversionType readObject = ConversionType.readObject(cVar);
        if (readObject != null) {
            this.type = new L3.W(readObject.name());
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_dictionary_put_title);
        J3.e q8 = q(c1708z0);
        ConversionType conversionType = null;
        Object u8 = J3.h.u(c1708z0, this.key, null);
        Object u9 = J3.h.u(c1708z0, this.value, null);
        String x7 = J3.h.x(c1708z0, this.type, null);
        if (x7 != null && (conversionType = ConversionType.forName(x7)) == null) {
            throw new IllegalArgumentException(Type.NAME);
        }
        Object m02 = q8.m0(J3.h.e0(u8), u9, conversionType);
        J3.l lVar = this.varOldValue;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, m02);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
