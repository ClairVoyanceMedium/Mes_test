package com.llamalab.automate.stmt;

import android.widget.EditText;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.stmt.Interact;

/* loaded from: classes.dex */
public final class U extends EditText {

    /* renamed from: x0, reason: collision with root package name */
    public final /* synthetic */ Interact.c f17210x0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(Interact.c cVar, AutomateService automateService) {
        super(automateService);
        this.f17210x0 = cVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z7) {
        Interact.c cVar = this.f17210x0;
        if (z7) {
            cVar.f15400Y.f14581L1.post(cVar);
        } else {
            cVar.getClass();
        }
    }
}
