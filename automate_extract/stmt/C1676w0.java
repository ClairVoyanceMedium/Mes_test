package com.llamalab.automate.stmt;

import android.os.Bundle;
import android.view.View;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.field.SpinnerField;

/* renamed from: com.llamalab.automate.stmt.w0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1676w0 extends C2 implements com.llamalab.automate.field.t {

    /* renamed from: L1, reason: collision with root package name */
    public View f17561L1;

    /* renamed from: y1, reason: collision with root package name */
    public View f17562y1;

    @Override // com.llamalab.automate.field.t
    public final void l(Object obj) {
        boolean z7 = true;
        int intValue = obj != null ? ((Integer) obj).intValue() : 1;
        boolean z8 = false;
        if (intValue != 1) {
            if (intValue != 2) {
                z7 = false;
            } else {
                z8 = true;
            }
        }
        this.f17562y1.setEnabled(z7);
        this.f17561L1.setEnabled(z8);
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((SpinnerField) view.findViewById(C2541R.id.continuity)).setOnFieldValueChangedListener(this);
        this.f17562y1 = view.findViewById(C2541R.id.min_steps);
        this.f17561L1 = view.findViewById(C2541R.id.still_duration);
    }
}
