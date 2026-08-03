package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.DurationPickActivity;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("duration_pick.html")
@F3.a(C2541R.integer.ic_device_access_timer_flip)
@F3.i(C2541R.string.stmt_duration_pick_title)
@F3.h(C2541R.string.stmt_duration_pick_summary)
@F3.e(C2541R.layout.stmt_duration_pick_edit)
/* loaded from: classes.dex */
public final class DurationPick extends ActivityDecision {
    public InterfaceC1700x0 initialDuration;
    public InterfaceC1700x0 showSeconds;
    public InterfaceC1700x0 signed;
    public InterfaceC1700x0 title;
    public J3.l varDuration;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_duration_pick);
        l8.v(this.varDuration, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (109 <= dVar.f6413Z) {
            dVar.g(this.title);
        }
        if (99 <= dVar.f6413Z) {
            dVar.g(this.signed);
        }
        dVar.g(this.showSeconds);
        if (93 <= dVar.f6413Z) {
            dVar.g(this.initialDuration);
        }
        dVar.g(this.varDuration);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.title);
        visitor.b(this.signed);
        visitor.b(this.showSeconds);
        visitor.b(this.initialDuration);
        visitor.b(this.varDuration);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (109 <= cVar.f6409x0) {
            this.title = (InterfaceC1700x0) cVar.readObject();
        }
        if (99 <= cVar.f6409x0) {
            this.signed = (InterfaceC1700x0) cVar.readObject();
        }
        this.showSeconds = (InterfaceC1700x0) cVar.readObject();
        if (93 <= cVar.f6409x0) {
            this.initialDuration = (InterfaceC1700x0) cVar.readObject();
        }
        this.varDuration = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varDuration;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        int i9 = intent.getBooleanExtra("com.llamalab.automate.intent.extra.NEGATIVE", false) ? -1 : 1;
        int intExtra = intent.getIntExtra("com.llamalab.automate.intent.extra.HOURS", 0);
        int intExtra2 = intent.getIntExtra("com.llamalab.automate.intent.extra.MINUTES", 0);
        int intExtra3 = intent.getIntExtra("com.llamalab.automate.intent.extra.SECONDS", 0);
        double d8 = i9;
        double d9 = intExtra;
        Double.isNaN(d9);
        Double.isNaN(d9);
        double d10 = intExtra2;
        Double.isNaN(d10);
        Double.isNaN(d10);
        double d11 = intExtra3;
        Double.isNaN(d11);
        Double.isNaN(d11);
        Double.isNaN(d8);
        Double.isNaN(d8);
        Double valueOf = Double.valueOf(((((d9 * 60.0d) + d10) * 60.0d) + d11) * d8);
        J3.l lVar2 = this.varDuration;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, valueOf);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        CharSequence charSequence;
        c1708z0.q(C2541R.string.stmt_duration_pick_title);
        Intent intent = new Intent(c1708z0, (Class<?>) DurationPickActivity.class);
        String x7 = J3.h.x(c1708z0, this.title, null);
        if (TextUtils.isEmpty(x7)) {
            charSequence = c1708z0.getText(C2541R.string.stmt_duration_pick_title);
        } else {
            intent.putExtra("android.intent.extra.TITLE", (CharSequence) x7);
            charSequence = x7;
        }
        intent.putExtra("com.llamalab.automate.intent.extra.SIGNED", J3.h.f(c1708z0, this.signed, false));
        intent.putExtra("com.llamalab.automate.intent.extra.SHOW_SECONDS", J3.h.f(c1708z0, this.showSeconds, false));
        Double j8 = J3.h.j(c1708z0, this.initialDuration);
        if (j8 != null) {
            intent.putExtra("com.llamalab.automate.intent.extra.HOURS", (int) (j8.doubleValue() / 3600.0d)).putExtra("com.llamalab.automate.intent.extra.MINUTES", (int) ((j8.doubleValue() / 60.0d) % 60.0d)).putExtra("com.llamalab.automate.intent.extra.SECONDS", (int) (j8.doubleValue() % 60.0d));
        }
        c1708z0.D(intent, null, this, c1708z0.f(C2541R.integer.ic_device_access_timer_flip), charSequence);
        return false;
    }
}
