package com.llamalab.automate.stmt;

import android.os.Bundle;
import android.view.View;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.field.BooleanExprField;
import com.llamalab.automate.field.DateTimeExprField;
import com.llamalab.automate.field.SpinnerField;

/* loaded from: classes.dex */
public class o1 extends C2 implements com.llamalab.automate.field.t {

    /* renamed from: L1, reason: collision with root package name */
    public BooleanExprField f17489L1;

    /* renamed from: y1, reason: collision with root package name */
    public DateTimeExprField f17490y1;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (r4.equals(0) != false) goto L6;
     */
    @Override // com.llamalab.automate.field.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(Object obj) {
        boolean z7 = obj == null;
        this.f17490y1.setEnabled(z7);
        this.f17489L1.setEnabled(true ^ z7);
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((SpinnerField) view.findViewById(C2541R.id.continuity)).setOnFieldValueChangedListener(this);
        this.f17490y1 = (DateTimeExprField) view.findViewById(C2541R.id.timestamp);
        this.f17489L1 = (BooleanExprField) view.findViewById(C2541R.id.wakeup);
    }
}
