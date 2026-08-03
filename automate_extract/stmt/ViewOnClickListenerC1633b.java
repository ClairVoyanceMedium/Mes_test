package com.llamalab.automate.stmt;

import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;

/* renamed from: com.llamalab.automate.stmt.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1633b extends C2 implements View.OnClickListener {

    /* renamed from: L1, reason: collision with root package name */
    public com.llamalab.automate.field.l<InterfaceC1700x0> f17337L1;

    /* renamed from: y1, reason: collision with root package name */
    public com.llamalab.automate.field.l<InterfaceC1700x0> f17338y1;

    @Override // com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 1) {
            super.onActivityResult(i8, i9, intent);
        } else {
            if (-1 != i9 || intent == null) {
                return;
            }
            this.f17338y1.setValue(L3.W.b(intent.getStringExtra("authAccount")));
            this.f17337L1.setValue(L3.W.b(intent.getStringExtra("accountType")));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != C2541R.id.pick_account) {
            return;
        }
        startActivityForResult(AccountManager.newChooseAccountIntent(null, null, null, true, null, null, null, null), 1);
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f17338y1 = (com.llamalab.automate.field.l) view.findViewById(C2541R.id.account_name);
        this.f17337L1 = (com.llamalab.automate.field.l) view.findViewById(C2541R.id.account_type);
        View findViewById = view.findViewById(C2541R.id.pick_account);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
    }
}
