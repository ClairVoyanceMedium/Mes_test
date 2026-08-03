package com.llamalab.automate.stmt;

import A4.g;
import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import com.llamalab.automate.AutomateService;
import d4.C1722c;
import g4.C1827a;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collections;
import z4.C2538s;
import z4.InterfaceC2537r;

/* renamed from: com.llamalab.automate.stmt.m0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1657m0 extends AbstractC1653k0 {

    /* renamed from: S1, reason: collision with root package name */
    public PendingIntent f17473S1;

    public C1657m0(String[] strArr, String str, String str2, com.llamalab.safs.n nVar, int i8, PendingIntent pendingIntent) {
        super(strArr, str, str2, nVar, i8);
        this.f17473S1 = pendingIntent;
    }

    @Override // com.llamalab.automate.stmt.AbstractC1653k0, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        w2();
    }

    @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        PendingIntent pendingIntent = this.f17473S1;
        if (pendingIntent != null) {
            pendingIntent.cancel();
        }
        super.F(automateService);
    }

    @Override // com.llamalab.automate.AbstractRunnableC1694v2
    public final void x2() {
        AutomateService automateService = this.f15400Y;
        SmsManager l8 = w3.n.l(this.f17455P1);
        A4.k z22 = z2();
        File createTempFile = File.createTempFile("mms-", ".pdu", automateService.getCacheDir());
        try {
            Uri build = C1827a.b.f18778a.buildUpon().appendPath(createTempFile.getName()).appendQueryParameter("oneshot", "true").build();
            C2538s c2538s = new C2538s(new C1722c(A2(), new FileOutputStream(createTempFile)));
            try {
                z22.d(c2538s);
                c2538s.close();
                InterfaceC2537r[] interfaceC2537rArr = (InterfaceC2537r[]) z22.f23792a.get(g.c.f95w);
                B2((interfaceC2537rArr != null ? Arrays.asList(interfaceC2537rArr) : Collections.emptyList()).size());
                l8.sendMultimediaMessage(automateService, build, null, new Bundle(), this.f17473S1);
                this.f17473S1 = null;
                a();
            } catch (Throwable th) {
                try {
                    c2538s.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            createTempFile.delete();
            throw th3;
        }
    }
}
