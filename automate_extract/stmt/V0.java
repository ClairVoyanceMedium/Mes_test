package com.llamalab.automate.stmt;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.d;
import androidx.fragment.app.ActivityC1261p;
import com.llamalab.automate.C2541R;

/* loaded from: classes.dex */
public final class V0 extends com.llamalab.android.app.b implements DialogInterface.OnClickListener {
    public I3.f U1;

    public interface a {
        void q(ActivityInfo activityInfo);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i8) {
        ResolveInfo item = this.U1.getItem(i8);
        if (item != null) {
            androidx.lifecycle.G parentFragment = getParentFragment();
            if (parentFragment instanceof a) {
                ((a) parentFragment).q(item.activityInfo);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        I3.f fVar = this.U1;
        if (fVar != null) {
            fVar.a();
        }
        super.onDestroy();
    }

    @Override // f.x, androidx.fragment.app.DialogInterfaceOnCancelListenerC1258m
    public final Dialog v(Bundle bundle) {
        ActivityC1261p o6 = o();
        if (this.U1 == null) {
            this.U1 = new I3.f(o6, new Intent("android.intent.action.CREATE_SHORTCUT"));
        }
        d.a aVar = new d.a(o6);
        AlertController.b bVar = aVar.f8607a;
        bVar.f8577d = bVar.f8574a.getText(C2541R.string.action_pick_shortcut);
        bVar.f8590q = this.U1;
        bVar.f8591r = this;
        bVar.f8582i = bVar.f8574a.getText(R.string.cancel);
        bVar.f8583j = null;
        return aVar.a();
    }
}
