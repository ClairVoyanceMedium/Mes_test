package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.NfcReadTagActivity;
import com.llamalab.automate.NfcWriteTagActivity;
import com.llamalab.automate.field.ExpressionField;

/* renamed from: com.llamalab.automate.stmt.q0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC1665q0 extends C2 implements View.OnClickListener {

    /* renamed from: y1, reason: collision with root package name */
    public ExpressionField f17500y1;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = getContext();
        int id = view.getId();
        if (id == C2541R.id.read_tag) {
            startActivity(new Intent(context, (Class<?>) NfcReadTagActivity.class));
            return;
        }
        if (id != C2541R.id.write_tag) {
            return;
        }
        if (!this.f17500y1.e()) {
            this.f17500y1.requestFocus();
        } else {
            InterfaceC1700x0 value = this.f17500y1.getValue();
            startActivityForResult(new Intent(context, (Class<?>) NfcWriteTagActivity.class).putExtra("com.llamalab.automate.intent.extra.NDEF_MESSAGE", C1666r0.a(value != null ? value.c2(null) : null)), 1);
        }
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f17500y1 = (ExpressionField) view.findViewById(C2541R.id.content);
        Button button = (Button) view.findViewById(C2541R.id.write_tag);
        if (button != null) {
            button.setOnClickListener(this);
        }
        Button button2 = (Button) view.findViewById(C2541R.id.read_tag);
        if (button2 != null) {
            button2.setOnClickListener(this);
        }
    }
}
