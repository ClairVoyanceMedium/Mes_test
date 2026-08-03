package com.llamalab.automate.stmt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.LocationPickActivity;

/* renamed from: com.llamalab.automate.stmt.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1634b0 extends C2 implements View.OnClickListener {

    /* renamed from: L1, reason: collision with root package name */
    public com.llamalab.automate.field.l<InterfaceC1700x0> f17339L1;

    /* renamed from: M1, reason: collision with root package name */
    public com.llamalab.automate.field.l<InterfaceC1700x0> f17340M1;

    /* renamed from: y1, reason: collision with root package name */
    public com.llamalab.automate.field.l<InterfaceC1700x0> f17341y1;

    @Override // com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 1) {
            super.onActivityResult(i8, i9, intent);
            return;
        }
        if (-1 == i9) {
            this.f17341y1.setValue(new L3.J(intent.getDoubleExtra("com.llamalab.automate.intent.extra.LATITUDE", 0.0d)));
            this.f17339L1.setValue(new L3.J(intent.getDoubleExtra("com.llamalab.automate.intent.extra.LONGITUDE", 0.0d)));
            if (this.f17340M1 != null) {
                if (intent.hasExtra("com.llamalab.automate.intent.extra.RADIUS")) {
                    this.f17340M1.setValue(new L3.J(intent.getDoubleExtra("com.llamalab.automate.intent.extra.RADIUS", 0.0d)));
                } else {
                    this.f17340M1.setValue(null);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != C2541R.id.pick_location) {
            return;
        }
        Intent intent = new Intent(o(), (Class<?>) LocationPickActivity.class);
        if (this.f17340M1 != null) {
            intent.putExtra("com.llamalab.automate.intent.extra.RADIUS_SELECTION", true);
        }
        InterfaceC1700x0 value = this.f17341y1.getValue();
        InterfaceC1700x0 value2 = this.f17339L1.getValue();
        if ((value instanceof L3.K) && (value2 instanceof L3.K)) {
            intent.putExtra("com.llamalab.automate.intent.extra.LATITUDE", J3.h.V((L3.K) value)).putExtra("com.llamalab.automate.intent.extra.LONGITUDE", J3.h.V((L3.K) value2));
        }
        com.llamalab.automate.field.l<InterfaceC1700x0> lVar = this.f17340M1;
        if (lVar != null) {
            InterfaceC1700x0 value3 = lVar.getValue();
            if (value3 instanceof L3.K) {
                intent.putExtra("com.llamalab.automate.intent.extra.RADIUS", J3.h.V((L3.K) value3));
            }
        }
        startActivityForResult(intent, 1);
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f17341y1 = (com.llamalab.automate.field.l) view.findViewById(C2541R.id.latitude);
        this.f17339L1 = (com.llamalab.automate.field.l) view.findViewById(C2541R.id.longitude);
        this.f17340M1 = (com.llamalab.automate.field.l) view.findViewById(C2541R.id.radius);
        view.findViewById(C2541R.id.pick_location).setOnClickListener(this);
    }
}
