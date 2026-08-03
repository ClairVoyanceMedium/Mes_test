package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.AbstractC1618p2;

/* loaded from: classes.dex */
public final class F0 extends AbstractC1618p2.c.b {

    /* renamed from: x1, reason: collision with root package name */
    public final String f16616x1;

    /* renamed from: y1, reason: collision with root package name */
    public final boolean f16617y1;

    public F0(String str, boolean z7) {
        this.f16616x1 = str;
        this.f16617y1 = z7;
    }

    @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("com.twofortyfouram.locale.intent.extra.ACTIVITY");
        if (this.f16617y1) {
            F5.n.f(this, "PlugInRequestQueryTask onReceive: activity=" + stringExtra);
        }
        if (stringExtra == null || this.f16616x1.equals(stringExtra)) {
            b(intent);
        }
    }
}
