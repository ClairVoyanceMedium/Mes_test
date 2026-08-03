package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.NfcWriteTagActivity;
import com.llamalab.automate.Visitor;
import java.nio.ByteBuffer;
import java.util.Locale;
import p3.C2213b;
import x3.C2424b;

@F3.f("nfc_tag_write.html")
@F3.a(C2541R.integer.ic_nfc_tag_write)
@F3.i(C2541R.string.stmt_nfc_tag_write_title)
@F3.h(C2541R.string.stmt_nfc_tag_write_summary)
@F3.e(C2541R.layout.stmt_nfc_tag_write_edit)
/* loaded from: classes.dex */
public final class NfcTagWrite extends ActivityDecision {
    public InterfaceC1700x0 content;
    public InterfaceC1700x0 ndefType;
    public J3.l varWrittenId;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.NFC")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_nfc_tag_write);
        l8.v(this.content, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.content);
        if (82 <= dVar.f6413Z) {
            dVar.g(this.ndefType);
        }
        dVar.g(this.varWrittenId);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.content);
        visitor.b(this.ndefType);
        visitor.b(this.varWrittenId);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1665q0();
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.content = (InterfaceC1700x0) cVar.readObject();
        if (82 <= cVar.f6409x0) {
            this.ndefType = (InterfaceC1700x0) cVar.readObject();
        }
        this.varWrittenId = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varWrittenId;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        if (intent == null) {
            J3.l lVar2 = this.varWrittenId;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, null);
            }
            o(c1708z0, true);
            return;
        }
        String e8 = C1666r0.e(intent.getByteArrayExtra("com.llamalab.automate.intent.extra.TAG_ID"));
        J3.l lVar3 = this.varWrittenId;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, e8);
        }
        o(c1708z0, true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        char c8;
        NdefRecord ndefRecord;
        NdefMessage ndefMessage;
        c1708z0.q(C2541R.string.stmt_nfc_tag_write_title);
        Object u8 = J3.h.u(c1708z0, this.content, null);
        String x7 = J3.h.x(c1708z0, this.ndefType, "urn:nfc:ext:com.llamalab.automate.v2:externaltype");
        x7.getClass();
        switch (x7.hashCode()) {
            case -1178146270:
                if (x7.equals("urn:nfc:wkt:T")) {
                    c8 = 0;
                    break;
                }
                c8 = 65535;
                break;
            case -1178146269:
                if (x7.equals("urn:nfc:wkt:U")) {
                    c8 = 1;
                    break;
                }
                c8 = 65535;
                break;
            case -392746015:
                if (x7.equals("urn:nfc:ext:com.llamalab.automate.v2:externaltype")) {
                    c8 = 2;
                    break;
                }
                c8 = 65535;
                break;
            default:
                c8 = 65535;
                break;
        }
        if (c8 == 0) {
            NdefRecord[] ndefRecordArr = new NdefRecord[1];
            String f02 = J3.h.f0("", u8);
            int i8 = C2424b.f23370a;
            if (21 <= Build.VERSION.SDK_INT) {
                ndefRecord = NdefRecord.createTextRecord(null, f02);
            } else {
                if (f02 == null) {
                    throw new NullPointerException("text is null");
                }
                byte[] bytes = Locale.getDefault().getLanguage().getBytes(C2213b.f21560b);
                if (bytes.length >= 64) {
                    throw new IllegalArgumentException("language code is too long, must be < 64 bytes.");
                }
                byte[] bytes2 = f02.getBytes(C2213b.f21561c);
                ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 1 + bytes2.length);
                allocate.put((byte) (bytes.length & 255));
                allocate.put(bytes);
                allocate.put(bytes2);
                ndefRecord = new NdefRecord((short) 1, NdefRecord.RTD_TEXT, null, allocate.array());
            }
            ndefRecordArr[0] = ndefRecord;
            ndefMessage = new NdefMessage(ndefRecordArr);
        } else if (c8 == 1) {
            ndefMessage = new NdefMessage(new NdefRecord[]{NdefRecord.createUri(J3.h.f0("", u8))});
        } else {
            if (c8 != 2) {
                throw new IllegalArgumentException("ndefType");
            }
            ndefMessage = C1666r0.a(u8);
        }
        c1708z0.D(new Intent(c1708z0, (Class<?>) NfcWriteTagActivity.class).putExtra("com.llamalab.automate.intent.extra.NDEF_MESSAGE", ndefMessage), null, this, c1708z0.f(C2541R.integer.ic_nfc_tag_write), c1708z0.getText(C2541R.string.stmt_nfc_tag_write_title));
        return false;
    }
}
