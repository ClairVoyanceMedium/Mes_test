package com.llamalab.automate.stmt;

import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.field.TextExprField;

/* renamed from: com.llamalab.automate.stmt.n0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1659n0 extends C2 implements View.OnClickListener {

    /* renamed from: L1, reason: collision with root package name */
    public TextExprField f17478L1;

    /* renamed from: y1, reason: collision with root package name */
    public TextExprField f17479y1;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != C2541R.id.current_operator) {
            return;
        }
        TelephonyManager telephonyManager = (TelephonyManager) o().getSystemService("phone");
        this.f17479y1.setValue((InterfaceC1700x0) L3.W.b(telephonyManager.getNetworkOperatorName()));
        this.f17478L1.setValue((InterfaceC1700x0) L3.W.b(telephonyManager.getNetworkOperator()));
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f17479y1 = (TextExprField) view.findViewById(C2541R.id.operator_name);
        this.f17478L1 = (TextExprField) view.findViewById(C2541R.id.operator_code);
        view.findViewById(C2541R.id.current_operator).setOnClickListener(this);
    }
}
