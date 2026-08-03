package com.llamalab.automate.stmt;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.llamalab.automate.A2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.FlowShortcutInstallActivity;
import com.llamalab.automate.field.TextField;
import com.llamalab.automate.field.ValueText;
import g4.C1827a;

/* loaded from: classes.dex */
public final class G extends C2 implements View.OnClickListener {

    /* renamed from: L1, reason: collision with root package name */
    public ValueText f16673L1;

    /* renamed from: M1, reason: collision with root package name */
    public String f16674M1;

    /* renamed from: y1, reason: collision with root package name */
    public TextField f16675y1;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == C2541R.id.install_shortcut && this.f14763y0 != null) {
            Intent intent = new Intent("android.intent.action.INSERT", C1827a.g.b.a(this.f14762x0.f14847y0, this.f14763y0.g()).build(), getContext(), FlowShortcutInstallActivity.class);
            String value = this.f16675y1.getValue();
            if (TextUtils.isEmpty(value)) {
                value = this.f16674M1;
                if (TextUtils.isEmpty(value)) {
                    value = getString(R.string.untitled);
                }
            }
            startActivity(intent.putExtra("android.intent.extra.SUBJECT", value));
        }
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f16675y1 = (TextField) view.findViewById(C2541R.id.title);
        ((Button) view.findViewById(C2541R.id.install_shortcut)).setOnClickListener(this);
        this.f16673L1 = (ValueText) view.findViewById(C2541R.id.flow_uri);
    }

    @Override // com.llamalab.automate.C2
    public final void u(A2 a22, com.llamalab.automate.F0 f02) {
        super.u(a22, f02);
        this.f16673L1.setText(C1827a.g.b.a(this.f14762x0.f14847y0, this.f14763y0.g()).build().toString());
        this.f16674M1 = f02.f14842X;
    }
}
