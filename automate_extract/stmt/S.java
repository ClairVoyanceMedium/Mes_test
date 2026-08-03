package com.llamalab.automate.stmt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InputMethodPickActivity;
import com.llamalab.automate.InterfaceC1700x0;

/* loaded from: classes.dex */
public class S extends C2 implements View.OnClickListener {

    /* renamed from: L1, reason: collision with root package name */
    public com.llamalab.automate.field.l<InterfaceC1700x0> f17076L1;

    /* renamed from: y1, reason: collision with root package name */
    public com.llamalab.automate.field.l<InterfaceC1700x0> f17077y1;

    @Override // com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 1) {
            super.onActivityResult(i8, i9, intent);
        } else if (-1 == i9) {
            this.f17077y1.setValue(L3.W.b(intent.getStringExtra("com.llamalab.automate.intent.extra.INPUT_METHOD_ID")));
            int intExtra = intent.getIntExtra("com.llamalab.automate.intent.extra.INPUT_METHOD_SUBTYPE_HASH", -1);
            this.f17076L1.setValue(intExtra != -1 ? new L3.W(Integer.toString(intExtra)) : null);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != C2541R.id.pick_input_method) {
            return;
        }
        startActivityForResult(new Intent(o(), (Class<?>) InputMethodPickActivity.class), 1);
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f17077y1 = (com.llamalab.automate.field.l) view.findViewById(C2541R.id.input_method);
        this.f17076L1 = (com.llamalab.automate.field.l) view.findViewById(C2541R.id.input_method_subtype);
        view.findViewById(C2541R.id.pick_input_method).setOnClickListener(this);
    }
}
