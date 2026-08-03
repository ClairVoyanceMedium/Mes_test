package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.safs.f;
import i4.C1949c;

@F3.f("activity_start_result.html")
@F3.a(C2541R.integer.ic_app_decision)
@F3.i(C2541R.string.stmt_activity_start_result_title)
@F3.h(C2541R.string.stmt_activity_start_result_summary)
@F3.e(C2541R.layout.stmt_activity_start_result_edit)
/* loaded from: classes.dex */
public final class ActivityStartResult extends ActivityIntentDecision {
    public InterfaceC1700x0 activityOptions;
    public J3.l varResultExtras;
    public J3.l varResultUri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_activity_start_result).o(-1, this.action).o(-1, this.className).q(this.className).o(-1, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (89 <= dVar.f6413Z) {
            dVar.g(this.activityOptions);
        }
        dVar.g(this.varResultUri);
        dVar.g(this.varResultExtras);
    }

    @Override // com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.activityOptions);
        visitor.b(this.varResultUri);
        visitor.b(this.varResultExtras);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return ViewOnClickListenerC1667s.w(null, 1);
    }

    @Override // com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (89 <= cVar.f6409x0) {
            this.activityOptions = (InterfaceC1700x0) cVar.readObject();
        }
        this.varResultUri = (J3.l) cVar.readObject();
        this.varResultExtras = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        Bundle bundle;
        Uri uri;
        if (intent != null) {
            if (19 <= Build.VERSION.SDK_INT) {
                ((C1949c) f.a.f17733a).O(intent);
            }
            uri = intent.getData();
            bundle = intent.getExtras();
        } else {
            bundle = null;
            uri = null;
        }
        J3.l lVar = this.varResultUri;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, uri != null ? uri.toString() : null);
        }
        J3.l lVar2 = this.varResultExtras;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, bundle != null ? J3.h.O(0, bundle) : null);
        }
        o(c1708z0, -1 == i8);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_activity_start_result_title);
        Intent w8 = w(77854423, c1708z0, true);
        ActivityStart.u(w8);
        c1708z0.D(w8, J3.h.d(c1708z0, this.activityOptions), this, c1708z0.f(C2541R.integer.ic_app_decision), c1708z0.getText(C2541R.string.stmt_activity_start_result_title));
        return false;
    }
}
