package com.llamalab.automate.stmt;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.os.Build;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("nfc_set_state.html")
@F3.a(C2541R.integer.ic_nfc)
@F3.i(C2541R.string.stmt_nfc_set_state_title)
@F3.h(C2541R.string.stmt_nfc_set_state_summary)
@F3.e(C2541R.layout.stmt_nfc_set_state_edit)
/* loaded from: classes.dex */
public final class NfcSetState extends SetStateAction implements AsyncStatement {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 23 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.NFC"), com.llamalab.automate.access.c.j("android.permission.WRITE_SECURE_SETTINGS"), com.llamalab.automate.access.c.f15561v} : 17 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.NFC"), com.llamalab.automate.access.c.j("android.permission.WRITE_SECURE_SETTINGS")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.NFC")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_nfc_enable, C2541R.string.caption_nfc_disable).r(C2541R.string.caption_nfc_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_nfc_set_state_title);
        boolean q8 = q(c1708z0, false);
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(c1708z0);
        defaultAdapter.getClass().getMethod(q8 ? "enable" : "disable", new Class[0]).invoke(defaultAdapter, new Object[0]);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
