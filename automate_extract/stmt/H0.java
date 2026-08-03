package com.llamalab.automate.stmt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import com.llamalab.automate.C2541R;

/* loaded from: classes.dex */
public final class H0 extends B0<I0> {

    /* renamed from: Y1, reason: collision with root package name */
    public CheckBox f16697Y1;

    /* renamed from: Z1, reason: collision with root package name */
    public int f16698Z1 = 0;

    @Override // com.llamalab.automate.stmt.B0
    public final void A(Intent intent) {
        int i8;
        super.A(intent);
        this.f16698Z1 = 0;
        if (intent != null) {
            if (intent.hasExtra("net.dinglisch.android.tasker.extras.REQUESTED_TIMEOUT")) {
                i8 = intent.getIntExtra("net.dinglisch.android.tasker.extras.REQUESTED_TIMEOUT", 0);
            } else {
                Bundle bundleExtra = intent.getBundleExtra("com.twofortyfouram.locale.intent.extra.BUNDLE");
                if (bundleExtra == null || !bundleExtra.containsKey("net.dinglisch.android.tasker.extras.REQUESTED_TIMEOUT")) {
                    return;
                } else {
                    i8 = bundleExtra.getInt("net.dinglisch.android.tasker.extras.REQUESTED_TIMEOUT", 0);
                }
            }
            this.f16698Z1 = i8;
        }
    }

    @Override // com.llamalab.automate.stmt.B0
    public final void B(String str, String str2) {
        super.B(str, str2);
        this.f16698Z1 = 0;
        this.f16697Y1.setChecked(false);
    }

    @Override // com.llamalab.automate.stmt.B0
    public final void F(I0 i02) {
        I0 i03 = i02;
        super.F(i03);
        this.f16698Z1 = i03.f16709M1;
        this.f16697Y1.setChecked(i03.f16710N1);
    }

    @Override // com.llamalab.automate.stmt.B0, com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f16697Y1 = (CheckBox) view.findViewById(C2541R.id.ignore_timeout);
    }

    @Override // com.llamalab.automate.stmt.B0
    public final void x(I0 i02) {
        I0 i03 = i02;
        super.x(i03);
        i03.f16709M1 = this.f16698Z1;
        i03.f16710N1 = this.f16697Y1.isChecked();
    }

    @Override // com.llamalab.automate.stmt.B0
    public final String z() {
        return "com.twofortyfouram.locale.intent.action.EDIT_SETTING";
    }
}
