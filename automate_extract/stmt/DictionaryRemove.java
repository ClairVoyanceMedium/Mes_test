package com.llamalab.automate.stmt;

import J3.e;
import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("dictionary_remove.html")
@F3.a(C2541R.integer.ic_dict_remove)
@F3.i(C2541R.string.stmt_dictionary_remove_title)
@F3.h(C2541R.string.stmt_dictionary_remove_summary)
@F3.e(C2541R.layout.stmt_dictionary_remove_edit)
/* loaded from: classes.dex */
public final class DictionaryRemove extends DictionarySubscriptAction {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_dictionary_remove);
        l8.v(this.key, 0);
        l8.u(C2541R.string.caption_in, this.varDictionary);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_dictionary_remove_title);
        e.a s02 = q(c1708z0).s0(J3.h.e0(J3.h.u(c1708z0, this.key, null)));
        Object obj = s02 != null ? s02.f4644x1 : null;
        J3.l lVar = this.varOldValue;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
