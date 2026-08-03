package com.llamalab.automate.stmt;

import android.os.Bundle;
import android.view.View;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.field.DurationExprField;
import com.llamalab.automate.field.SpinnerField;
import com.llamalab.automate.field.TextExprField;

/* renamed from: com.llamalab.automate.stmt.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1637c0 extends C2 implements com.llamalab.automate.field.t {

    /* renamed from: L1, reason: collision with root package name */
    public TextExprField f17352L1;

    /* renamed from: y1, reason: collision with root package name */
    public DurationExprField f17353y1;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (r4.equals(0) != false) goto L6;
     */
    @Override // com.llamalab.automate.field.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(Object obj) {
        boolean z7 = obj == null;
        this.f17353y1.setEnabled(z7);
        this.f17352L1.setEnabled(true ^ z7);
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((SpinnerField) view.findViewById(C2541R.id.continuity)).setOnFieldValueChangedListener(this);
        this.f17353y1 = (DurationExprField) view.findViewById(C2541R.id.max_fix_age);
        this.f17352L1 = (TextExprField) view.findViewById(C2541R.id.min_distance);
    }
}
