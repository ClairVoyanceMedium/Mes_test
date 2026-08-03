package com.llamalab.automate.stmt;

import android.app.Notification;
import android.content.Context;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.C1619q;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import x3.C2440r;

@F3.f("toast_posted.html")
@F3.a(C2541R.integer.ic_toast_query)
@F3.i(C2541R.string.stmt_toast_posted_title)
@F3.h(C2541R.string.stmt_toast_posted_summary)
@F3.e(C2541R.layout.stmt_toast_posted_edit)
/* loaded from: classes.dex */
public final class ToastPosted extends Action implements AsyncStatement {
    public InterfaceC1700x0 message;
    public InterfaceC1700x0 packageName;
    public J3.l varMessage;
    public J3.l varPackageName;

    public static final class a extends C1619q {

        /* renamed from: N1, reason: collision with root package name */
        public final String f17204N1;

        /* renamed from: O1, reason: collision with root package name */
        public final String f17205O1;

        public a(String str, String str2) {
            super(64, 0);
            this.f17204N1 = str;
            this.f17205O1 = str2;
        }

        @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
        public final void R0(AutomateAccessibilityService automateAccessibilityService, AccessibilityEvent accessibilityEvent) {
            if (64 != accessibilityEvent.getEventType() || (accessibilityEvent.getParcelableData() instanceof Notification)) {
                return;
            }
            CharSequence packageName = accessibilityEvent.getPackageName();
            if (packageName == null) {
                packageName = "android";
            }
            CharSequence charSequence = packageName;
            String str = this.f17204N1;
            if (str == null || str.contentEquals(charSequence)) {
                String join = TextUtils.join("\n", accessibilityEvent.getText());
                String str2 = this.f17205O1;
                if (str2 == null || C2440r.v(str2, join)) {
                    q2(new Object[]{charSequence.toString(), join}, false);
                }
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15540a};
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        dVar.g(this.message);
        dVar.g(this.varPackageName);
        dVar.g(this.varMessage);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.packageName);
        visitor.b(this.message);
        visitor.b(this.varPackageName);
        visitor.b(this.varMessage);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.message = (InterfaceC1700x0) cVar.readObject();
        this.varPackageName = (J3.l) cVar.readObject();
        this.varMessage = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_toast_posted_title);
        c1708z0.w(new a(J3.h.x(c1708z0, this.packageName, null), J3.h.x(c1708z0, this.message, null)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varPackageName;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varMessage;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
