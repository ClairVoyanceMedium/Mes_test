package com.llamalab.automate.stmt;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.llamalab.automate.AutomateService;
import com.llamalab.safs.util.UnauthorizedException;
import p4.InterfaceC2214a;

/* renamed from: com.llamalab.automate.stmt.v0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1674v0 implements InterfaceC2214a {

    /* renamed from: a, reason: collision with root package name */
    public String f17553a;

    /* renamed from: b, reason: collision with root package name */
    public long f17554b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f17555c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f17556d;

    public C1674v0(long j8, AutomateService automateService, String str, String str2) {
        this.f17555c = automateService;
        this.f17556d = str2;
        this.f17553a = str;
        this.f17554b = j8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r7.f17554b >= java.lang.System.currentTimeMillis()) goto L15;
     */
    @Override // p4.InterfaceC2214a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized String a(boolean z7) {
        if (!z7) {
            if (this.f17553a != null) {
            }
        }
        try {
            Bundle result = AccountManager.get(this.f17555c).getAuthToken(new Account(this.f17556d, "com.llamalab.automate.microsoft"), "openid profile files.readwrite", (Bundle) null, false, (AccountManagerCallback<Bundle>) null, (Handler) null).getResult();
            String string = result.getString("com.llamalab.auth3p.authtokenUncached");
            this.f17553a = string;
            if (string == null) {
                throw new IllegalStateException("No authentication token");
            }
            this.f17554b = result.getLong("android.accounts.expiry", Long.MAX_VALUE);
        } catch (Throwable th) {
            throw new UnauthorizedException(th.getMessage());
        }
        return this.f17553a;
    }
}
