package com.llamalab.automate.stmt;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import g4.C1828b;
import i4.C1951e;
import java.util.ArrayList;
import x3.C2434l;

@F3.f("compose_email.html")
@F3.a(C2541R.integer.ic_content_new_email)
@F3.i(C2541R.string.stmt_compose_email_title)
@F3.h(C2541R.string.stmt_compose_email_summary)
@F3.e(C2541R.layout.stmt_compose_email_edit)
/* loaded from: classes.dex */
public final class ComposeEmail extends EmailAction {
    public InterfaceC1700x0 packageName;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15547h} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_compose_email_title);
        l8.u(C2541R.string.caption_to, this.to);
        l8.v(this.message, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.EmailAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (91 <= dVar.f6413Z) {
            dVar.g(this.packageName);
        }
    }

    @Override // com.llamalab.automate.stmt.EmailAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.packageName);
    }

    @Override // com.llamalab.automate.stmt.EmailAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (91 <= cVar.f6409x0) {
            this.packageName = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Intent intent;
        Intent selector;
        c1708z0.q(C2541R.string.stmt_compose_email_title);
        e(c1708z0);
        CharSequence charSequence = null;
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        com.llamalab.safs.n[] q8 = J3.h.q(c1708z0, this.attachments, C2434l.f23404o);
        int length = q8.length;
        if (length != 0) {
            int i8 = 0;
            if (length != 1) {
                intent = new Intent("android.intent.action.SEND_MULTIPLE").setType("message/rfc822");
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(q8.length);
                if (16 <= Build.VERSION.SDK_INT) {
                    int length2 = q8.length;
                    ClipData clipData = null;
                    while (i8 < length2) {
                        Uri build = C1828b.a(q8[i8]).build();
                        arrayList.add(build);
                        if (clipData == null) {
                            clipData = ClipData.newRawUri(charSequence, build);
                        } else {
                            clipData.addItem(new ClipData.Item(build));
                        }
                        i8++;
                        charSequence = null;
                    }
                    intent.addFlags(1).setClipData(clipData);
                } else {
                    int length3 = q8.length;
                    while (i8 < length3) {
                        arrayList.add(C1951e.d(q8[i8]));
                        i8++;
                    }
                }
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                if (15 <= Build.VERSION.SDK_INT) {
                    intent.setSelector(new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "", null)).setPackage(x7));
                } else {
                    intent.setPackage(x7);
                }
            } else {
                intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "", null)).setPackage(x7);
                if (16 <= Build.VERSION.SDK_INT) {
                    Uri build2 = C1828b.a(q8[0]).build();
                    intent.putExtra("android.intent.extra.STREAM", build2).addFlags(1).setClipData(ClipData.newRawUri(null, build2));
                } else {
                    intent.putExtra("android.intent.extra.STREAM", C1951e.d(q8[0]));
                }
            }
        } else {
            intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "", null)).setPackage(x7);
        }
        InterfaceC1700x0 interfaceC1700x0 = this.to;
        String[] strArr = C2434l.f23396g;
        String[] w8 = J3.h.w(c1708z0, interfaceC1700x0, strArr);
        if (w8.length != 0) {
            intent.putExtra("android.intent.extra.EMAIL", w8);
        }
        String[] w9 = J3.h.w(c1708z0, this.cc, strArr);
        if (w9.length != 0) {
            intent.putExtra("android.intent.extra.CC", w9);
        }
        String[] w10 = J3.h.w(c1708z0, this.bcc, strArr);
        if (w10.length != 0) {
            intent.putExtra("android.intent.extra.BCC", w10);
        }
        String x8 = J3.h.x(c1708z0, this.subject, null);
        if (x8 != null) {
            intent.putExtra("android.intent.extra.SUBJECT", x8);
        }
        String x9 = J3.h.x(c1708z0, this.message, null);
        if (x9 != null) {
            intent.putExtra("android.intent.extra.TEXT", x9);
        }
        intent.addFlags(268697600);
        try {
            c1708z0.startActivity(intent);
        } catch (ActivityNotFoundException e8) {
            if (15 > Build.VERSION.SDK_INT) {
                throw e8;
            }
            selector = intent.getSelector();
            if (selector == null) {
                throw e8;
            }
            intent.setSelector(null);
            intent.setPackage(x7);
            c1708z0.startActivity(intent);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
