package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RatingBarNumberDialogActivity;
import com.llamalab.automate.SeekBarNumberDialogActivity;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.WheelNumberDialogActivity;

@F3.f("dialog_number.html")
@F3.a(C2541R.integer.ic_dialog_number)
@F3.i(C2541R.string.stmt_dialog_number_title)
@F3.h(C2541R.string.stmt_dialog_number_summary)
@F3.e(C2541R.layout.stmt_dialog_number_edit)
/* loaded from: classes.dex */
public class DialogNumber extends ActivityDecision {
    public InterfaceC1700x0 initialValue;
    public InterfaceC1700x0 maxValue;
    public InterfaceC1700x0 minValue;
    public InterfaceC1700x0 style;
    public InterfaceC1700x0 title;
    public J3.l varResultValue;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_dialog_number);
        l8.v(this.title, 0);
        l8.v(this.initialValue, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.style);
        dVar.g(this.title);
        dVar.g(this.minValue);
        dVar.g(this.maxValue);
        dVar.g(this.initialValue);
        dVar.g(this.varResultValue);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.style);
        visitor.b(this.title);
        visitor.b(this.minValue);
        visitor.b(this.maxValue);
        visitor.b(this.initialValue);
        visitor.b(this.varResultValue);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.style = (InterfaceC1700x0) cVar.readObject();
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.minValue = (InterfaceC1700x0) cVar.readObject();
        this.maxValue = (InterfaceC1700x0) cVar.readObject();
        this.initialValue = (InterfaceC1700x0) cVar.readObject();
        this.varResultValue = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varResultValue;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        Double valueOf = intent.hasExtra("com.llamalab.automate.intent.extra.VALUE") ? Double.valueOf(intent.getIntExtra("com.llamalab.automate.intent.extra.VALUE", 0)) : null;
        J3.l lVar2 = this.varResultValue;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, valueOf);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        CharSequence charSequence;
        c1708z0.q(C2541R.string.stmt_dialog_number_title);
        Intent intent = new Intent();
        int m8 = J3.h.m(c1708z0, this.style, 0);
        intent.setClass(c1708z0, m8 != 1 ? m8 != 2 ? WheelNumberDialogActivity.class : RatingBarNumberDialogActivity.class : SeekBarNumberDialogActivity.class);
        String x7 = J3.h.x(c1708z0, this.title, null);
        if (TextUtils.isEmpty(x7)) {
            charSequence = c1708z0.getText(C2541R.string.stmt_dialog_number_title);
        } else {
            intent.putExtra("android.intent.extra.TITLE", (CharSequence) x7);
            charSequence = x7;
        }
        Integer o6 = J3.h.o(c1708z0, this.initialValue, null);
        if (o6 != null) {
            intent.putExtra("com.llamalab.automate.intent.extra.VALUE", o6.intValue());
        }
        Integer o8 = J3.h.o(c1708z0, this.minValue, null);
        if (o8 != null) {
            intent.putExtra("com.llamalab.automate.intent.extra.MIN_VALUE", o8.intValue());
        }
        Integer o9 = J3.h.o(c1708z0, this.maxValue, null);
        if (o9 != null) {
            intent.putExtra("com.llamalab.automate.intent.extra.MAX_VALUE", o9.intValue());
        }
        c1708z0.D(intent, null, this, c1708z0.f(C2541R.integer.ic_dialog_number), charSequence);
        return false;
    }
}
