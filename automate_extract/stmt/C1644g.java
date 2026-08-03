package com.llamalab.automate.stmt;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.llamalab.automate.AbstractC1623r0;
import com.llamalab.automate.AutomateService;
import i0.C1896a;
import k0.RunnableC2034k;

/* renamed from: com.llamalab.automate.stmt.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1644g extends AbstractC1623r0 {

    /* renamed from: L1, reason: collision with root package name */
    public Uri f17417L1;

    /* renamed from: M1, reason: collision with root package name */
    public int f17418M1;

    public C1644g(PendingIntent pendingIntent, int i8, Uri uri) {
        super(pendingIntent);
        this.f17418M1 = i8;
        this.f17417L1 = uri;
    }

    @Override // com.llamalab.automate.AbstractC1623r0, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        int i8 = this.f17418M1;
        if (i8 != 0) {
            this.f17418M1 = 0;
            C1896a.a(automateService).c(new Intent("android.appwidget.action.APPWIDGET_DELETED").putExtra("appWidgetId", i8));
        }
        Uri uri = this.f17417L1;
        if (uri != null) {
            this.f17417L1 = null;
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new RunnableC2034k(automateService.getContentResolver(), 24, uri));
        }
        super.F(automateService);
    }

    @Override // com.llamalab.automate.AbstractC1623r0
    public final void v2(Intent intent) {
        this.f17418M1 = 0;
        this.f17417L1 = null;
        super.v2(intent);
    }
}
