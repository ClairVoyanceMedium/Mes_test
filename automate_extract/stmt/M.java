package com.llamalab.automate.stmt;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import com.llamalab.automate.AutomateService;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes.dex */
public final class M extends K {
    public ConnectivityManager W1;

    /* renamed from: X1, reason: collision with root package name */
    public L f16880X1;

    /* renamed from: Y1, reason: collision with root package name */
    public Network f16881Y1;

    /* renamed from: Z1, reason: collision with root package name */
    public final a f16882Z1;

    public class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        public boolean f16883a;

        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network network) {
            if (this.f16883a) {
                return;
            }
            this.f16883a = true;
            try {
                M m8 = M.this;
                m8.getClass();
                try {
                    m8.W1.unregisterNetworkCallback(m8.f16882Z1);
                } catch (Throwable unused) {
                }
                if (26 > Build.VERSION.SDK_INT) {
                    M m9 = M.this;
                    AutomateService automateService = m9.f15400Y;
                    L l8 = m9.f16880X1;
                    if (l8 != null) {
                        automateService.f14581L1.removeCallbacks(l8);
                        m9.f16880X1 = null;
                    }
                }
                M m10 = M.this;
                m10.f16881Y1 = network;
                m10.v2();
            } catch (Throwable th) {
                M.this.r2(th);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onUnavailable() {
            M m8 = M.this;
            m8.getClass();
            m8.r2(new SocketTimeoutException("Network interface unavailable").fillInStackTrace());
        }
    }

    public M(Uri uri, int i8, String str, boolean z7, boolean z8, String str2, J3.e eVar, CharSequence[] charSequenceArr, com.llamalab.safs.n[] nVarArr, int i9, com.llamalab.safs.n nVar) {
        super(uri, i8, str, z7, z8, str2, eVar, charSequenceArr, nVarArr, i9, nVar);
        this.f16882Z1 = new a();
    }

    @Override // com.llamalab.automate.stmt.K
    public final URLConnection B2(URL url) {
        URLConnection openConnection;
        Network network = this.f16881Y1;
        if (network == null) {
            return url.openConnection();
        }
        openConnection = network.openConnection(url);
        return openConnection;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        this.W1 = (ConnectivityManager) automateService.getSystemService("connectivity");
    }

    @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        L l8;
        if (26 > Build.VERSION.SDK_INT && (l8 = this.f16880X1) != null) {
            automateService.f14581L1.removeCallbacks(l8);
            this.f16880X1 = null;
        }
        try {
            this.W1.unregisterNetworkCallback(this.f16882Z1);
        } catch (Throwable unused) {
        }
        super.F(automateService);
    }
}
