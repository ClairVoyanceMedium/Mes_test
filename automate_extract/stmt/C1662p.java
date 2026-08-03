package com.llamalab.automate.stmt;

import android.os.Bundle;
import android.view.View;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.field.DateTimeExprField;
import com.llamalab.automate.field.SpinnerField;

/* renamed from: com.llamalab.automate.stmt.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1662p extends C2 implements com.llamalab.automate.field.t {

    /* renamed from: L1, reason: collision with root package name */
    public DateTimeExprField f17491L1;

    /* renamed from: y1, reason: collision with root package name */
    public DateTimeExprField f17492y1;

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        if (r3.equals(1) == false) goto L7;
     */
    @Override // com.llamalab.automate.field.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(Object obj) {
        boolean z7 = obj != null;
        this.f17492y1.setEnabled(z7);
        this.f17491L1.setEnabled(z7);
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((SpinnerField) view.findViewById(C2541R.id.continuity)).setOnFieldValueChangedListener(this);
        this.f17492y1 = (DateTimeExprField) view.findViewById(C2541R.id.min_timestamp);
        this.f17491L1 = (DateTimeExprField) view.findViewById(C2541R.id.max_timestamp);
    }
}
