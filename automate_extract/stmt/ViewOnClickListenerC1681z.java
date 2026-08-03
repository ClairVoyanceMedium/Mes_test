package com.llamalab.automate.stmt;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import androidx.fragment.app.ActivityC1261p;
import com.llamalab.automate.C1567e0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.P2;
import com.llamalab.automate.field.TextExprField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import x3.C2422C;

/* renamed from: com.llamalab.automate.stmt.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1681z extends C2 implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: L1, reason: collision with root package name */
    public C1567e0 f17568L1;

    /* renamed from: M1, reason: collision with root package name */
    public TextExprField f17569M1;

    /* renamed from: N1, reason: collision with root package name */
    public TextExprField f17570N1;

    /* renamed from: O1, reason: collision with root package name */
    public TextExprField f17571O1;

    /* renamed from: P1, reason: collision with root package name */
    public TextExprField f17572P1;

    /* renamed from: y1, reason: collision with root package name */
    public androidx.appcompat.widget.H f17573y1;

    public static void w(TextExprField textExprField, float f8) {
        textExprField.setValue((InterfaceC1700x0) (Float.isNaN(f8) ? null : new L3.J(f8)));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != C2541R.id.preset) {
            return;
        }
        if (this.f17573y1.d()) {
            this.f17573y1.dismiss();
        } else {
            this.f17573y1.a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.f17573y1.dismiss();
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i8, long j8) {
        A a8 = (A) this.f17568L1.getItem(i8);
        if (a8 != null) {
            w(this.f17569M1, a8.f16214x0);
            w(this.f17570N1, a8.f16216y0);
            w(this.f17571O1, a8.f16215x1);
            w(this.f17572P1, a8.f16217y1);
        }
        this.f17573y1.dismiss();
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ActivityC1261p o6 = o();
        this.f17569M1 = (TextExprField) view.findViewById(C2541R.id.azimuth);
        this.f17570N1 = (TextExprField) view.findViewById(C2541R.id.pitch);
        this.f17571O1 = (TextExprField) view.findViewById(C2541R.id.roll);
        this.f17572P1 = (TextExprField) view.findViewById(C2541R.id.tolerance);
        Button button = (Button) view.findViewById(C2541R.id.preset);
        button.setOnClickListener(this);
        Map<String, C2422C.a<A>> map = A.f16213L1;
        P2.a aVar = P2.f15224Z;
        ArrayList a8 = C2422C.a(o6, C2541R.xml.device_orientations, map);
        Collections.sort(a8, aVar);
        this.f17568L1 = new C1567e0(C2541R.layout.spinner_dropdown_item_2line, C2541R.style.MaterialItem_Spinner_Dropdown, 2, o6, a8);
        androidx.appcompat.widget.H h8 = new androidx.appcompat.widget.H(o6);
        this.f17573y1 = h8;
        h8.f8989S1 = button;
        h8.p(this.f17568L1);
        androidx.appcompat.widget.H h9 = this.f17573y1;
        h9.f8990T1 = this;
        h9.t();
    }
}
