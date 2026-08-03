package com.llamalab.automate.stmt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.WifiNetworkPickActivity;

/* renamed from: com.llamalab.automate.stmt.p0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1663p0 extends C2 implements View.OnClickListener {

    /* renamed from: L1, reason: collision with root package name */
    public com.llamalab.automate.field.l<InterfaceC1700x0> f17493L1;

    /* renamed from: y1, reason: collision with root package name */
    public com.llamalab.automate.field.l<InterfaceC1700x0> f17494y1;

    @Override // com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 1) {
            super.onActivityResult(i8, i9, intent);
        } else if (-1 == i9) {
            this.f17494y1.setValue(L3.W.b(intent.getStringExtra("com.llamalab.automate.intent.extra.SSID")));
            this.f17493L1.setValue(L3.W.b(intent.getStringExtra("com.llamalab.automate.intent.extra.BSSID")));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != C2541R.id.pick_network) {
            return;
        }
        startActivityForResult(new Intent(o(), (Class<?>) WifiNetworkPickActivity.class), 1);
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f17494y1 = (com.llamalab.automate.field.l) view.findViewById(C2541R.id.ssid);
        this.f17493L1 = (com.llamalab.automate.field.l) view.findViewById(C2541R.id.bssid);
        ((Button) view.findViewById(C2541R.id.pick_network)).setOnClickListener(this);
    }
}
