package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.func.MimeType;
import com.llamalab.automate.fs.AutomateFileTypeDetector;

@F3.f("content_offer_result.html")
@F3.a(C2541R.integer.ic_social_share)
@F3.i(C2541R.string.stmt_content_offer_result_title)
@F3.h(C2541R.string.stmt_content_offer_result_summary)
@F3.c(C2541R.string.caption_content_offer_result)
@F3.e(C2541R.layout.stmt_content_offer_result_edit)
/* loaded from: classes.dex */
public final class ContentOfferResult extends Action {
    public InterfaceC1700x0 contentUri;
    public InterfaceC1700x0 flags;
    public InterfaceC1700x0 mimeType;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_content_offer_result);
        l8.v(this.contentUri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.contentUri);
        dVar.g(this.mimeType);
        dVar.g(this.flags);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.contentUri);
        visitor.b(this.mimeType);
        visitor.b(this.flags);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.contentUri = (InterfaceC1700x0) cVar.readObject();
        this.mimeType = (InterfaceC1700x0) cVar.readObject();
        this.flags = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066 A[Catch: all -> 0x008f, TryCatch #0 {all -> 0x008f, blocks: (B:7:0x0011, B:9:0x001a, B:11:0x0022, B:13:0x002e, B:14:0x0033, B:17:0x003e, B:19:0x0042, B:22:0x004b, B:24:0x0053, B:27:0x0066, B:28:0x006d, B:29:0x005d, B:31:0x006e, B:33:0x0081, B:34:0x0088, B:35:0x0085), top: B:6:0x0011 }] */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        boolean z7;
        c1708z0.q(C2541R.string.stmt_content_offer_result_title);
        C1673v c1673v = (C1673v) c1708z0.c(C1673v.class);
        if (c1673v != null) {
            try {
                Uri g8 = J3.h.g(c1708z0, this.contentUri, null);
                if (g8 != null) {
                    String x7 = J3.h.x(c1708z0, this.mimeType, null);
                    if (x7 == null) {
                        x7 = "file".equals(g8.getScheme()) ? AutomateFileTypeDetector.probeContentType(g8) : c1708z0.getContentResolver().getType(g8);
                    }
                    if (x7 != null) {
                        String str = c1673v.f17552L1;
                        if (str != null && !"*/*".equals(str)) {
                            z7 = str.endsWith("/*") ? x7.regionMatches(0, x7, 0, str.length() - 1) : str.equals(x7);
                            if (z7) {
                                throw new IllegalArgumentException(MimeType.NAME);
                            }
                        }
                        z7 = true;
                        if (z7) {
                        }
                    }
                    Intent addFlags = new Intent().addFlags(J3.h.m(c1708z0, this.flags, 0) & 195);
                    if (x7 != null) {
                        addFlags.setDataAndType(g8, x7);
                    } else {
                        addFlags.setData(g8);
                    }
                    c1673v.v2(addFlags);
                }
            } finally {
                c1673v.a();
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
