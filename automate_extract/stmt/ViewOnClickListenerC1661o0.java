package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.llamalab.automate.A2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.field.TextField;
import n3.m;

/* renamed from: com.llamalab.automate.stmt.o0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC1661o0 extends C2 implements View.OnClickListener, n3.l {

    /* renamed from: L1, reason: collision with root package name */
    public n3.r f17481L1;

    /* renamed from: M1, reason: collision with root package name */
    public n3.o f17482M1;

    /* renamed from: N1, reason: collision with root package name */
    public SensorManager f17483N1;

    /* renamed from: O1, reason: collision with root package name */
    public Button f17484O1;

    /* renamed from: P1, reason: collision with root package name */
    public TextField f17485P1;

    /* renamed from: Q1, reason: collision with root package name */
    public n3.e f17486Q1;

    /* renamed from: R1, reason: collision with root package name */
    public boolean f17487R1;

    /* renamed from: y1, reason: collision with root package name */
    public n3.m f17488y1;

    @Override // n3.l
    public final void c() {
        if (this.f17487R1) {
            x(false, false);
            Toast.makeText(getContext(), getString(C2541R.string.error_gesture_duration_exceeded, Float.valueOf(3.0f)), 0).show();
        }
    }

    @Override // n3.l
    public final void m(n3.o oVar, n3.e eVar) {
        if (this.f17487R1) {
            w(eVar);
            Toast.makeText(getContext(), C2541R.string.toast_gesture_recorded, 0).show();
            return;
        }
        n3.e eVar2 = this.f17486Q1;
        if ((eVar2 == null || eVar2.size() == 0) ? false : true) {
            m.a a8 = this.f17488y1.a(this.f17486Q1, eVar, null);
            Context context = getContext();
            float f8 = a8.f21012a;
            float f9 = a8.f21013b;
            Toast.makeText(context, getString((f8 > f9 ? 1 : (f8 == f9 ? 0 : -1)) < 0 ? C2541R.string.toast_gesture_match : C2541R.string.toast_gesture_match_not, Float.valueOf((1.0f - (f8 / f9)) * 100.0f)), 0).show();
        }
        if (eVar instanceof n3.b) {
            this.f17482M1.l(eVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        this.f17483N1 = (SensorManager) context.getSystemService("sensor");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != C2541R.id.record) {
            return;
        }
        x(!this.f17487R1, true);
    }

    @Override // com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17488y1 = new n3.m();
        this.f17482M1 = new n3.o(this);
        n3.r rVar = new n3.r();
        this.f17481L1 = rVar;
        n3.i iVar = new n3.i();
        rVar.f21027Z = iVar;
        iVar.f21026Y = rVar;
        n3.j jVar = new n3.j();
        iVar.f21027Z = jVar;
        jVar.f21026Y = iVar;
        n3.h hVar = new n3.h();
        jVar.f21027Z = hVar;
        hVar.f21026Y = jVar;
        n3.f fVar = new n3.f();
        hVar.f21027Z = fVar;
        fVar.f21026Y = hVar;
        n3.k kVar = new n3.k();
        fVar.f21027Z = kVar;
        kVar.f21026Y = fVar;
        n3.p pVar = new n3.p();
        kVar.f21027Z = pVar;
        pVar.f21026Y = kVar;
        n3.g gVar = new n3.g();
        pVar.f21027Z = gVar;
        gVar.f21026Y = pVar;
        n3.o oVar = this.f17482M1;
        gVar.f21027Z = oVar;
        oVar.f21026Y = gVar;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        this.f17483N1 = null;
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        x(false, true);
        this.f17483N1.unregisterListener(this.f17481L1);
        this.f17482M1.j(3);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Sensor defaultSensor = this.f17483N1.getDefaultSensor(1);
        if (defaultSensor != null && this.f17483N1.registerListener(this.f17481L1, defaultSensor, 1)) {
            this.f17484O1.setEnabled(true);
        } else {
            this.f17484O1.setEnabled(false);
            Toast.makeText(o(), C2541R.string.toast_sensor_unavailable, 1).show();
        }
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Button button = (Button) view.findViewById(C2541R.id.record);
        this.f17484O1 = button;
        button.setOnClickListener(this);
        this.f17485P1 = (TextField) view.findViewById(C2541R.id.name);
    }

    @Override // n3.l
    public final n3.b r() {
        return new n3.b();
    }

    @Override // com.llamalab.automate.C2
    public final void t() {
        super.t();
        MotionGesture motionGesture = (MotionGesture) this.f14763y0;
        if (motionGesture != null) {
            motionGesture.gesture = this.f17486Q1;
        }
    }

    @Override // com.llamalab.automate.C2
    public final void u(A2 a22, com.llamalab.automate.F0 f02) {
        super.u(a22, f02);
        n3.e eVar = ((MotionGesture) a22).gesture;
        w(eVar != null ? eVar.i() : null);
    }

    @Override // com.llamalab.automate.C2
    public final boolean v() {
        boolean v8 = super.v();
        n3.e eVar = this.f17486Q1;
        boolean z7 = true;
        if (!((eVar == null || eVar.size() == 0) ? false : true)) {
            Toast.makeText(o(), C2541R.string.error_gesture_null, 0).show();
            z7 = false;
        }
        return v8 & z7;
    }

    public final void w(n3.e eVar) {
        n3.e eVar2 = this.f17486Q1;
        if (eVar2 instanceof n3.b) {
            this.f17482M1.l(eVar2);
        }
        this.f17486Q1 = eVar;
        x(false, false);
        this.f17485P1.setVisibility(eVar != null && eVar.size() != 0 ? 0 : 8);
    }

    public final void x(boolean z7, boolean z8) {
        if (this.f17487R1 != z7) {
            this.f17487R1 = z7;
            if (z7) {
                this.f17484O1.setText(C2541R.string.hint_recording_gesture);
                return;
            }
            this.f17484O1.setText(C2541R.string.action_record_gesture);
            if (z8) {
                n3.r rVar = this.f17481L1;
                n3.q qVar = (n3.q) rVar.f21027Z;
                if (qVar != null) {
                    qVar.a(rVar);
                    return;
                }
                n3.q qVar2 = (n3.q) rVar.f21026Y;
                if (qVar2 != null) {
                    qVar2.j(1);
                }
            }
        }
    }
}
