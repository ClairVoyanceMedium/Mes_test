package com.llamalab.automate.stmt;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
import com.llamalab.automate.C1684t0;
import com.llamalab.automate.C2541R;
import x3.C2420A;
import x3.C2440r;
import x3.InterfaceC2444v;

/* renamed from: com.llamalab.automate.stmt.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1669t extends com.llamalab.android.app.b implements AdapterView.OnItemClickListener, ExpandableListView.OnChildClickListener {
    public InterfaceC2444v U1;

    /* renamed from: com.llamalab.automate.stmt.t$a */
    public interface a {
        void i(ComponentInfo componentInfo);
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public final boolean onChildClick(ExpandableListView expandableListView, View view, int i8, int i9, long j8) {
        ComponentInfo child = ((I3.d) this.U1).getChild(i8, i9);
        androidx.lifecycle.G parentFragment = getParentFragment();
        if (parentFragment instanceof a) {
            ((a) parentFragment).i(child);
        }
        t(false, false);
        return true;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1258m, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        InterfaceC2444v interfaceC2444v = this.U1;
        if (interfaceC2444v != null) {
            interfaceC2444v.a();
            this.U1 = null;
        }
        super.onDestroyView();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i8, long j8) {
        I3.e eVar = (I3.e) this.U1;
        ComponentInfo p8 = C2440r.p(eVar.getItem(i8), eVar.f4465P1);
        androidx.lifecycle.G parentFragment = getParentFragment();
        if (parentFragment instanceof a) {
            ((a) parentFragment).i(p8);
        }
        t(false, false);
    }

    @Override // f.x, androidx.fragment.app.DialogInterfaceOnCancelListenerC1258m
    public final Dialog v(Bundle bundle) {
        ListView listView;
        Context context = getContext();
        Bundle arguments = getArguments();
        int i8 = arguments.getInt("componentType");
        Intent intent = (Intent) arguments.getParcelable("queryIntent");
        InterfaceC2444v interfaceC2444v = this.U1;
        if (intent != null) {
            if (!(interfaceC2444v instanceof I3.e)) {
                this.U1 = new I3.e(context, i8, intent);
            }
            ListView listView2 = new ListView(context);
            listView2.setAdapter((ListAdapter) this.U1);
            listView2.setOnItemClickListener(this);
            listView = listView2;
        } else {
            if (!(interfaceC2444v instanceof I3.d)) {
                this.U1 = new I3.d(context, i8);
            }
            ExpandableListView expandableListView = new ExpandableListView(context);
            expandableListView.setAdapter((I3.d) this.U1);
            expandableListView.setOnChildClickListener(this);
            listView = expandableListView;
        }
        a2.b bVar = new a2.b(context);
        ViewGroup a8 = C1684t0.a(context, arguments.getCharSequence("title"), context.getResources().getStringArray(C2541R.array.hint_search_component_type)[i8], (Filterable) this.U1);
        AlertController.b bVar2 = bVar.f8607a;
        bVar2.f8578e = a8;
        bVar2.f8592s = listView;
        bVar.g(R.string.cancel, null);
        androidx.appcompat.app.d a9 = bVar.a();
        a9.setOnShowListener(C2420A.f23366b);
        return a9;
    }
}
