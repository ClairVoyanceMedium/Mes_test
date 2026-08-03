package com.llamalab.automate.stmt;

import android.os.Bundle;
import android.view.View;
import com.llamalab.automate.A2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.L1;
import com.llamalab.automate.field.StatementPickerField;
import com.llamalab.automate.field.VariableCollection;

/* loaded from: classes.dex */
public class r1 extends C2 implements com.llamalab.automate.field.t {

    /* renamed from: L1, reason: collision with root package name */
    public VariableCollection f17513L1;

    /* renamed from: y1, reason: collision with root package name */
    public View f17514y1;

    @Override // com.llamalab.automate.field.t
    public final void l(Object obj) {
        w((VariablesTake) ((L1) obj).f15102X);
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((StatementPickerField) view.findViewById(C2541R.id.taker)).setOnFieldValueChangedListener(this);
        this.f17514y1 = view.findViewById(C2541R.id.given_variables_layout);
        this.f17513L1 = (VariableCollection) view.findViewById(C2541R.id.given_variables);
    }

    @Override // com.llamalab.automate.C2
    public final void t() {
        super.t();
        VariablesTake variablesTake = ((VariablesGive) this.f14763y0).taker.f15102X;
        if (variablesTake != null) {
            variablesTake.variables = this.f17513L1.getValue();
        }
    }

    @Override // com.llamalab.automate.C2
    public final void u(A2 a22, com.llamalab.automate.F0 f02) {
        super.u(a22, f02);
        w(((VariablesGive) this.f14763y0).taker.f15102X);
    }

    @Override // com.llamalab.automate.C2
    public final boolean v() {
        return super.v() & this.f17513L1.a(false);
    }

    public final void w(VariablesTake variablesTake) {
        if (variablesTake != null) {
            this.f17513L1.setValue(variablesTake.variables);
            this.f17514y1.setVisibility(0);
        } else {
            this.f17514y1.setVisibility(8);
            this.f17513L1.setValue(null);
        }
    }
}
