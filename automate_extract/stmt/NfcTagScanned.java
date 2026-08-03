package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.Tag;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import i0.C1896a;

@F3.f("nfc_tag_scanned.html")
@F3.a(C2541R.integer.ic_nfc_tag_read)
@F3.i(C2541R.string.stmt_nfc_tag_scanned_title)
@F3.h(C2541R.string.stmt_nfc_tag_scanned_summary)
@F3.e(C2541R.layout.stmt_nfc_tag_scanned_edit)
/* loaded from: classes.dex */
public final class NfcTagScanned extends Action implements ReceiverStatement {
    public InterfaceC1700x0 content;
    public InterfaceC1700x0 tagId;
    public InterfaceC1700x0 tagType;
    public J3.l varScannedContent;
    public J3.l varScannedId;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.NFC")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_nfc_tag_scanned).e(this.tagType, 1, C2541R.xml.nfc_tag_types).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
        String e8 = C1666r0.e(tag.getId());
        String x7 = J3.h.x(c1708z0, this.tagId, null);
        if (x7 != null && !x7.equalsIgnoreCase(e8)) {
            return false;
        }
        abstractC1618p2.a();
        J3.l lVar = this.varScannedId;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, e8);
        }
        J3.l lVar2 = this.varScannedContent;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, C1666r0.b(tag));
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.tagType);
        if (52 <= dVar.f6413Z) {
            dVar.g(this.tagId);
        }
        dVar.g(this.content);
        dVar.g(this.varScannedId);
        dVar.g(this.varScannedContent);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.tagType);
        visitor.b(this.tagId);
        visitor.b(this.content);
        visitor.b(this.varScannedId);
        visitor.b(this.varScannedContent);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1665q0();
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.tagType = (InterfaceC1700x0) cVar.readObject();
        if (52 <= cVar.f6409x0) {
            this.tagId = (InterfaceC1700x0) cVar.readObject();
        }
        this.content = (InterfaceC1700x0) cVar.readObject();
        this.varScannedId = (J3.l) cVar.readObject();
        this.varScannedContent = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_nfc_tag_scanned_title);
        e(c1708z0);
        int m8 = J3.h.m(c1708z0, this.tagType, 1);
        AbstractC1618p2.a.C0163a c0163a = new AbstractC1618p2.a.C0163a();
        c1708z0.w(c0163a);
        if (m8 != 1) {
            c0163a.j("android.nfc.action.TECH_DISCOVERED", "android.nfc.action.NDEF_DISCOVERED");
            IntentFilter intentFilter = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
            intentFilter.addDataType("*/*");
            C1896a.a(c0163a.f16157Y).b(c0163a, intentFilter);
        }
        String[] strArr = C1666r0.f17511a;
        IntentFilter intentFilter2 = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
        intentFilter2.addDataScheme("vnd.android.nfc");
        intentFilter2.addDataAuthority("ext", null);
        for (int i8 = 1; i8 <= 2; i8++) {
            intentFilter2.addDataPath(C1666r0.f17511a[i8], 0);
        }
        IntentFilter intentFilter3 = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
        intentFilter3.addDataScheme("vnd.android.nfc");
        intentFilter3.addDataAuthority("ext", null);
        intentFilter3.addDataPath("/android.com:pkg", 0);
        c0163a.l(intentFilter2, intentFilter3);
        return false;
    }
}
