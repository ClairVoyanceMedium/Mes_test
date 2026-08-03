package com.llamalab.automate.stmt;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.security.KeyChain;
import android.security.KeyChainAliasCallback;
import android.view.View;
import com.llamalab.automate.C1687u;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import f.RunnableC1764A;

/* renamed from: com.llamalab.automate.stmt.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1642f extends Z implements androidx.fragment.app.C {

    /* renamed from: N1, reason: collision with root package name */
    public static final /* synthetic */ int f17399N1 = 0;

    /* renamed from: L1, reason: collision with root package name */
    public com.llamalab.automate.field.n<InterfaceC1700x0> f17400L1;

    /* renamed from: M1, reason: collision with root package name */
    public com.llamalab.automate.field.n<InterfaceC1700x0> f17401M1;

    @Override // com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 4) {
            super.onActivityResult(i8, i9, intent);
        } else if (-1 == i9 && intent != null && J3.h.B(this.f17400L1.getValue())) {
            this.f17400L1.setValue(L3.W.b(intent.getStringExtra("android.security.extra.KEY_ALIAS")));
        }
    }

    @Override // com.llamalab.automate.stmt.Z, android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case C2541R.id.pair_device_other /* 2131296906 */:
                CharSequence text = getText(C2541R.string.reason_adb_pair_device);
                boolean z7 = false;
                E3.b[] bVarArr = {com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.CHANGE_NETWORK_STATE")};
                if (com.llamalab.automate.access.c.a(getContext(), bVarArr)) {
                    z7 = true;
                } else {
                    if (!(this.f15701X != -1)) {
                        startActivityForResult(com.llamalab.automate.access.c.g(getContext(), text, bVarArr), 2);
                        this.f15701X = 2;
                    }
                }
                if (z7) {
                    w();
                    break;
                }
                break;
            case C2541R.id.pair_device_this /* 2131296907 */:
                x();
                break;
            default:
                super.onClick(view);
                break;
        }
    }

    @Override // com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.fragment.app.x childFragmentManager = getChildFragmentManager();
        int i8 = C1687u.f17586f2;
        childFragmentManager.V(this, this);
    }

    @Override // com.llamalab.automate.stmt.Z, com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(C2541R.id.pair_device_other).setOnClickListener(this);
        if (21 <= Build.VERSION.SDK_INT) {
            View findViewById = view.findViewById(C2541R.id.pair_device_this);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        this.f17401M1 = (com.llamalab.automate.field.n) view.findViewById(C2541R.id.host);
        this.f17400L1 = (com.llamalab.automate.field.n) view.findViewById(C2541R.id.alias);
    }

    @Override // androidx.fragment.app.C
    public final void p(Bundle bundle, String str) {
        int i8 = C1687u.f17586f2;
        if ("com.llamalab.automate.u".equals(str)) {
            if (J3.h.B(this.f17401M1.getValue())) {
                this.f17401M1.setValue(L3.W.b(bundle.getString("com.llamalab.automate.intent.extra.HOSTNAME")));
            }
            if (J3.h.B(this.f17400L1.getValue())) {
                this.f17400L1.setValue(L3.W.b(bundle.getString("android.security.extra.KEY_ALIAS")));
            }
        }
    }

    @Override // com.llamalab.automate.C1563d0
    public final void s(int i8, E3.b[] bVarArr) {
        if (i8 == 2) {
            if (com.llamalab.automate.access.c.a(getContext(), bVarArr)) {
                w();
            }
        } else if (i8 == 3 && com.llamalab.automate.access.c.a(getContext(), bVarArr)) {
            x();
        }
    }

    public final void w() {
        InterfaceC1700x0 value = this.f17401M1.getValue();
        String f02 = value instanceof J3.k ? J3.h.f0("localhost", value) : "localhost";
        InterfaceC1700x0 value2 = this.f17400L1.getValue();
        String f03 = value2 instanceof J3.k ? J3.h.f0(null, value2) : null;
        int i8 = C1687u.f17586f2;
        Bundle bundle = new Bundle();
        bundle.putString("hostname", f02);
        bundle.putInt("port", 5555);
        bundle.putString("alias", f03);
        com.llamalab.android.app.b bVar = 16 <= Build.VERSION.SDK_INT ? new C1687u.b() : new C1687u();
        bVar.setArguments(bundle);
        bVar.A(getChildFragmentManager());
    }

    public final void x() {
        InterfaceC1700x0 value = this.f17400L1.getValue();
        KeyChain.choosePrivateKeyAlias(requireActivity(), new KeyChainAliasCallback() { // from class: com.llamalab.automate.stmt.e
            @Override // android.security.KeyChainAliasCallback
            public final void alias(String str) {
                int i8 = C1642f.f17399N1;
                C1642f c1642f = C1642f.this;
                c1642f.getClass();
                if (str != null) {
                    try {
                        c1642f.requireActivity().runOnUiThread(new RunnableC1764A(c1642f, 20, str));
                    } catch (Throwable unused) {
                    }
                }
            }
        }, new String[]{"RSA"}, null, null, -1, value instanceof J3.k ? J3.h.f0(null, value) : null);
    }
}
