package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AutomateService;

/* renamed from: com.llamalab.automate.stmt.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1671u extends AbstractC1618p2.c {

    /* renamed from: x1, reason: collision with root package name */
    public Configuration f17529x1;

    /* renamed from: y1, reason: collision with root package name */
    public final int f17530y1;

    public C1671u(Configuration configuration, int i8) {
        this.f17529x1 = new Configuration(configuration);
        this.f17530y1 = i8;
    }

    @Override // com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        h("android.intent.action.CONFIGURATION_CHANGED");
    }

    @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Configuration configuration = context.getResources().getConfiguration();
        if ((this.f17529x1.diff(configuration) & this.f17530y1) != 0) {
            r(configuration, intent);
        }
        this.f17529x1 = new Configuration(configuration);
    }

    public void r(Configuration configuration, Intent intent) {
        throw null;
    }
}
