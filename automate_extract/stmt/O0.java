package com.llamalab.automate.stmt;

import android.os.Bundle;
import android.view.View;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.field.BooleanExprField;
import com.llamalab.automate.field.DurationExprField;
import com.llamalab.automate.field.SpinnerField;

/* loaded from: classes.dex */
public class O0 extends ViewOnClickListenerC1667s implements com.llamalab.automate.field.t {

    /* renamed from: P1, reason: collision with root package name */
    public static final /* synthetic */ int f17007P1 = 0;

    /* renamed from: N1, reason: collision with root package name */
    public DurationExprField f17008N1;

    /* renamed from: O1, reason: collision with root package name */
    public BooleanExprField f17009O1;

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        if (r3.equals(0) == false) goto L5;
     */
    @Override // com.llamalab.automate.field.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(Object obj) {
        boolean z7 = obj == null;
        this.f17008N1.setEnabled(z7);
        this.f17009O1.setEnabled(z7);
    }

    @Override // com.llamalab.automate.stmt.ViewOnClickListenerC1667s, com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((SpinnerField) view.findViewById(C2541R.id.continuity)).setOnFieldValueChangedListener(this);
        this.f17008N1 = (DurationExprField) view.findViewById(C2541R.id.activity_timeout);
        this.f17009O1 = (BooleanExprField) view.findViewById(C2541R.id.activity_start);
    }
}
