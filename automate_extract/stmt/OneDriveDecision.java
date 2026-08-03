package com.llamalab.automate.stmt;

import android.content.Intent;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public abstract class OneDriveDecision extends AuthTokenDecision implements OneDriveStatement, AsyncStatement {
    @Override // com.llamalab.automate.stmt.AuthTokenStatement
    public final /* synthetic */ boolean B0(C1708z0 c1708z0, String str, String str2, long j8) {
        D1.P.c(this, c1708z0, str, str2, j8);
        return false;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final /* synthetic */ boolean V(C1708z0 c1708z0, Intent intent) {
        return B4.g.a(this, c1708z0, intent);
    }
}
