package com.llamalab.automate.stmt;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.llamalab.automate.C1684t0;
import com.llamalab.automate.C2541R;
import x3.C2420A;

/* loaded from: classes.dex */
public final class D0 extends com.llamalab.android.app.b implements DialogInterface.OnClickListener {
    public I3.f U1;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i8) {
        ResolveInfo item;
        if (i8 < 0 || (item = this.U1.getItem(i8)) == null) {
            return;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof B0) {
            B0 b02 = (B0) parentFragment;
            ActivityInfo activityInfo = item.activityInfo;
            b02.getClass();
            if (activityInfo != null) {
                if (activityInfo.packageName.equals(b02.f16320S1) && activityInfo.name.equals(b02.f16321T1)) {
                    return;
                }
                b02.C(activityInfo.loadLabel(b02.f16323y1));
                b02.f16315N1.setVisibility(0);
                b02.B(activityInfo.packageName, activityInfo.name);
                b02.y();
            }
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1258m, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        I3.f fVar = this.U1;
        if (fVar != null) {
            fVar.a();
            this.U1 = null;
        }
    }

    @Override // f.x, androidx.fragment.app.DialogInterfaceOnCancelListenerC1258m
    public final Dialog v(Bundle bundle) {
        Context context = getContext();
        this.U1 = new I3.f(context, new Intent(getArguments().getString("action")));
        a2.b bVar = new a2.b(context);
        bVar.f8607a.f8578e = C1684t0.a(context, context.getText(C2541R.string.label_plugins), getString(C2541R.string.hint_search_plugins), this.U1);
        bVar.f(this.U1, this);
        bVar.g(C2541R.string.action_cancel, null);
        androidx.appcompat.app.d a8 = bVar.a();
        a8.setOnShowListener(C2420A.f23366b);
        return a8;
    }
}
