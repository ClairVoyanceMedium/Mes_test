package com.llamalab.automate.stmt;

import android.content.Context;
import c1.C1305a;
import com.llamalab.automate.AutomateService;
import com.llamalab.safs.util.UnauthorizedException;
import m4.InterfaceC2147a;

/* loaded from: classes.dex */
public final class H implements InterfaceC2147a {

    /* renamed from: a, reason: collision with root package name */
    public String f16694a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f16695b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16696c;

    public H(AutomateService automateService, String str, String str2) {
        this.f16695b = automateService;
        this.f16696c = str2;
        this.f16694a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
    
        if (r2.f16694a == null) goto L22;
     */
    @Override // m4.InterfaceC2147a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized String a(boolean z7) {
        if (!z7) {
        }
        try {
            C1305a.h(this.f16695b, this.f16694a);
            String c8 = GoogleAuthorized.c(this.f16695b, this.f16696c, "oauth2:https://www.googleapis.com/auth/drive");
            this.f16694a = c8;
            if (c8 == null) {
                throw new IllegalStateException("No authentication token");
            }
        } catch (Throwable th) {
            throw new UnauthorizedException(th.getMessage());
        }
        return this.f16694a;
    }
}
