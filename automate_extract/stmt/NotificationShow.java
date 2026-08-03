package com.llamalab.automate.stmt;

import L3.C1047l;
import L3.C1060z;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("notification_show.html")
@F3.a(C2541R.integer.ic_notification)
@F3.i(C2541R.string.stmt_notification_show_title)
@F3.h(C2541R.string.stmt_notification_show_summary)
@F3.e(C2541R.layout.stmt_notification_show_edit)
/* loaded from: classes.dex */
public final class NotificationShow extends IntermittentDecision implements AsyncStatement, IntentStatement {

    /* renamed from: L1, reason: collision with root package name */
    @Deprecated
    public InterfaceC1700x0 f16985L1;

    /* renamed from: M1, reason: collision with root package name */
    @Deprecated
    public InterfaceC1700x0 f16986M1;

    /* renamed from: N1, reason: collision with root package name */
    @Deprecated
    public InterfaceC1700x0 f16987N1;

    /* renamed from: O1, reason: collision with root package name */
    @Deprecated
    public InterfaceC1700x0 f16988O1;

    /* renamed from: P1, reason: collision with root package name */
    @Deprecated
    public InterfaceC1700x0 f16989P1;
    public InterfaceC1700x0 bigLayoutXml;
    public InterfaceC1700x0 cancellable;
    public InterfaceC1700x0 category;
    public InterfaceC1700x0 channelId;
    public InterfaceC1700x0 color;
    public InterfaceC1700x0 groupKey;
    public InterfaceC1700x0 headsUpLayoutXml;
    public InterfaceC1700x0 largeIconUri;
    public InterfaceC1700x0 message;
    public InterfaceC1700x0 ongoing;
    public InterfaceC1700x0 personUri;
    public InterfaceC1700x0 pictureUri;
    public InterfaceC1700x0 primaryLayoutXml;
    public InterfaceC1700x0 progress;
    public InterfaceC1700x0 shortCriticalText;
    public InterfaceC1700x0 smallIconUri;
    public InterfaceC1700x0 title;
    public J3.l varInterfaceUri;
    public J3.l varKey;
    public InterfaceC1700x0 visibility;
    public InterfaceC1700x0 when;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 33 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.POST_NOTIFICATIONS")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_notification_show);
        l8.v(this.title, 0);
        l8.v(this.message, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        RunnableC1672u0 runnableC1672u0 = (RunnableC1672u0) c1708z0.c(RunnableC1672u0.class);
        if (2 == J1(1)) {
            runnableC1672u0.f17548e2 = false;
            runnableC1672u0.A2(c1708z0.j2(), c1708z0.f17641Z, c1708z0, true, new Bundle());
        } else {
            runnableC1672u0.a();
        }
        o(c1708z0, true);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        s(dVar, 68);
        dVar.g(this.continuity);
        dVar.g(this.title);
        dVar.g(this.message);
        if (110 <= dVar.f6413Z) {
            dVar.g(this.shortCriticalText);
        }
        if (79 <= dVar.f6413Z) {
            dVar.g(this.pictureUri);
            dVar.g(this.personUri);
        }
        if (47 <= dVar.f6413Z) {
            dVar.g(this.smallIconUri);
        }
        if (99 <= dVar.f6413Z) {
            dVar.g(this.largeIconUri);
        }
        if (113 <= dVar.f6413Z) {
            dVar.g(this.primaryLayoutXml);
            dVar.g(this.bigLayoutXml);
            dVar.g(this.headsUpLayoutXml);
        }
        if (99 <= dVar.f6413Z) {
            dVar.g(this.color);
        }
        dVar.g(this.cancellable);
        if (17 <= dVar.f6413Z) {
            dVar.g(this.ongoing);
        }
        if (77 > dVar.f6413Z) {
            dVar.g(null);
        }
        if (35 <= dVar.f6413Z) {
            dVar.g(this.visibility);
            dVar.g(this.category);
        }
        if (110 <= dVar.f6413Z) {
            dVar.g(this.groupKey);
        }
        if (77 <= dVar.f6413Z) {
            dVar.g(this.channelId);
        } else {
            dVar.g(null);
            dVar.g(null);
            if (21 <= dVar.f6413Z) {
                dVar.g(null);
            }
            dVar.g(null);
        }
        dVar.g(this.progress);
        if (100 <= dVar.f6413Z) {
            dVar.g(this.when);
        }
        if (16 <= dVar.f6413Z) {
            dVar.g(this.varKey);
        }
        if (113 <= dVar.f6413Z) {
            dVar.g(this.varInterfaceUri);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.title);
        visitor.b(this.message);
        visitor.b(this.shortCriticalText);
        visitor.b(this.pictureUri);
        visitor.b(this.personUri);
        visitor.b(this.smallIconUri);
        visitor.b(this.largeIconUri);
        visitor.b(this.primaryLayoutXml);
        visitor.b(this.bigLayoutXml);
        visitor.b(this.headsUpLayoutXml);
        visitor.b(this.color);
        visitor.b(this.cancellable);
        visitor.b(this.ongoing);
        visitor.b(this.f16985L1);
        visitor.b(this.visibility);
        visitor.b(this.category);
        visitor.b(this.groupKey);
        visitor.b(this.channelId);
        visitor.b(this.f16986M1);
        visitor.b(this.f16987N1);
        visitor.b(this.f16988O1);
        visitor.b(this.f16989P1);
        visitor.b(this.progress);
        visitor.b(this.when);
        visitor.b(this.varKey);
        visitor.b(this.varInterfaceUri);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        InterfaceC1700x0 c1060z;
        p(cVar, 68);
        this.continuity = (Integer) cVar.readObject();
        if (68 > cVar.f6409x0) {
            this.onNegative = this.onPositive;
        }
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.message = (InterfaceC1700x0) cVar.readObject();
        if (110 <= cVar.f6409x0) {
            this.shortCriticalText = (InterfaceC1700x0) cVar.readObject();
        }
        if (79 <= cVar.f6409x0) {
            this.pictureUri = (InterfaceC1700x0) cVar.readObject();
            this.personUri = (InterfaceC1700x0) cVar.readObject();
        }
        if (47 <= cVar.f6409x0) {
            this.smallIconUri = N.b(cVar);
        }
        if (99 <= cVar.f6409x0) {
            this.largeIconUri = (InterfaceC1700x0) cVar.readObject();
        }
        if (113 <= cVar.f6409x0) {
            this.primaryLayoutXml = (InterfaceC1700x0) cVar.readObject();
            this.bigLayoutXml = (InterfaceC1700x0) cVar.readObject();
            this.headsUpLayoutXml = (InterfaceC1700x0) cVar.readObject();
        }
        if (99 <= cVar.f6409x0) {
            this.color = (InterfaceC1700x0) cVar.readObject();
        }
        this.cancellable = (InterfaceC1700x0) cVar.readObject();
        if (17 <= cVar.f6409x0) {
            InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
            this.ongoing = interfaceC1700x0;
            if (110 > cVar.f6409x0) {
                if (interfaceC1700x0 instanceof J3.k) {
                    c1060z = new L3.J(J3.h.J(interfaceC1700x0));
                } else if (interfaceC1700x0 != null) {
                    c1060z = new C1060z(new C1060z(interfaceC1700x0));
                }
                this.ongoing = c1060z;
            }
        }
        if (77 > cVar.f6409x0) {
            this.f16985L1 = (InterfaceC1700x0) cVar.readObject();
        }
        if (35 <= cVar.f6409x0) {
            this.visibility = (InterfaceC1700x0) cVar.readObject();
            this.category = (InterfaceC1700x0) cVar.readObject();
        }
        if (110 <= cVar.f6409x0) {
            this.groupKey = (InterfaceC1700x0) cVar.readObject();
        }
        if (77 <= cVar.f6409x0) {
            this.channelId = (InterfaceC1700x0) cVar.readObject();
        } else {
            this.f16986M1 = (InterfaceC1700x0) cVar.readObject();
            this.f16987N1 = (InterfaceC1700x0) cVar.readObject();
            if (21 <= cVar.f6409x0) {
                this.f16988O1 = (InterfaceC1700x0) cVar.readObject();
            }
            this.f16989P1 = (InterfaceC1700x0) cVar.readObject();
        }
        InterfaceC1700x0 interfaceC1700x02 = (InterfaceC1700x0) cVar.readObject();
        this.progress = interfaceC1700x02;
        if (79 > cVar.f6409x0) {
            if (interfaceC1700x02 instanceof J3.k) {
                this.progress = J3.h.J(interfaceC1700x02) ? new L3.J(-1) : null;
            } else if (interfaceC1700x02 != null) {
                this.progress = new C1047l(interfaceC1700x02, new L3.J(-1), L3.I.f4933X);
            }
        }
        this.when = 100 <= cVar.f6409x0 ? (InterfaceC1700x0) cVar.readObject() : L3.H.f4932X;
        if (16 <= cVar.f6409x0) {
            this.varKey = (J3.l) cVar.readObject();
        }
        if (113 <= cVar.f6409x0) {
            this.varInterfaceUri = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_notification_show_title);
        RunnableC1672u0 runnableC1672u0 = (RunnableC1672u0) c1708z0.c(RunnableC1672u0.class);
        if (runnableC1672u0 != null) {
            runnableC1672u0.f15404y0 = this.f16218X;
        } else {
            runnableC1672u0 = new RunnableC1672u0();
            c1708z0.w(runnableC1672u0);
        }
        try {
            boolean z7 = J1(1) == 0;
            runnableC1672u0.f17549y1 = J3.h.x(c1708z0, this.title, null);
            runnableC1672u0.f17531L1 = J3.h.x(c1708z0, this.message, null);
            runnableC1672u0.f17532M1 = J3.h.x(c1708z0, this.shortCriticalText, null);
            runnableC1672u0.f17533N1 = J3.h.g(c1708z0, this.pictureUri, null);
            runnableC1672u0.f17534O1 = J3.h.g(c1708z0, this.personUri, null);
            runnableC1672u0.f17535P1 = J3.h.g(c1708z0, this.smallIconUri, null);
            runnableC1672u0.f17536Q1 = J3.h.g(c1708z0, this.largeIconUri, null);
            runnableC1672u0.f17537R1 = J3.h.x(c1708z0, this.primaryLayoutXml, null);
            runnableC1672u0.f17538S1 = J3.h.x(c1708z0, this.bigLayoutXml, null);
            runnableC1672u0.f17539T1 = J3.h.x(c1708z0, this.headsUpLayoutXml, null);
            runnableC1672u0.U1 = J3.h.m(c1708z0, this.color, 0);
            runnableC1672u0.f17540V1 = J3.h.f(c1708z0, this.cancellable, false);
            runnableC1672u0.W1 = J3.h.m(c1708z0, this.ongoing, 0);
            runnableC1672u0.f17541X1 = y4.j.d(J3.h.m(c1708z0, this.visibility, 0), -1, 1);
            runnableC1672u0.f17542Y1 = J3.h.x(c1708z0, this.category, null);
            runnableC1672u0.f17543Z1 = J3.h.x(c1708z0, this.groupKey, null);
            runnableC1672u0.f17544a2 = J3.h.x(c1708z0, this.channelId, null);
            runnableC1672u0.f17545b2 = c1708z0.f17641Z.f14843Y;
            runnableC1672u0.f17546c2 = J3.h.l(c1708z0, this.progress, Float.NaN);
            runnableC1672u0.f17547d2 = J3.h.t(c1708z0, this.when, Long.MIN_VALUE);
            Bundle bundle = new Bundle();
            runnableC1672u0.f17548e2 = !z7;
            runnableC1672u0.A2(c1708z0.j2(), c1708z0.f17641Z, c1708z0, z7, bundle);
            J3.l lVar = this.varKey;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, runnableC1672u0.w2());
            }
            J3.l lVar2 = this.varInterfaceUri;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, O.b.d(null, bundle.getParcelable("com.llamalab.automate.intent.extra.INTERFACE_URI")));
            }
            if (!z7) {
                return false;
            }
            o(c1708z0, true);
            return true;
        } catch (Throwable th) {
            runnableC1672u0.a();
            throw th;
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, false);
        return true;
    }
}
