package com.llamalab.automate.stmt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.llamalab.automate.AutomateService;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import x3.C2424b;

/* renamed from: com.llamalab.automate.stmt.l0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1655l0 extends AbstractC1651j0 {

    /* renamed from: V1, reason: collision with root package name */
    public final a f17467V1;

    /* renamed from: com.llamalab.automate.stmt.l0$a */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            C1655l0 c1655l0 = C1655l0.this;
            if (2 == intent.getIntExtra("networkType", -1)) {
                try {
                    NetworkInfo networkInfo = c1655l0.f17439S1.getNetworkInfo(2);
                    if (networkInfo == null || !networkInfo.isConnected()) {
                        return;
                    }
                    context.unregisterReceiver(this);
                    c1655l0.v2();
                } catch (Throwable th) {
                    c1655l0.r2(th);
                }
            }
        }
    }

    public C1655l0(String[] strArr, String str, String str2, com.llamalab.safs.n nVar, int i8) {
        super(strArr, str, str2, nVar, i8);
        this.f17467V1 = new a();
    }

    @Override // com.llamalab.automate.stmt.AbstractC1651j0, com.llamalab.automate.stmt.AbstractC1653k0, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        ConnectivityManager connectivityManager = this.f17439S1;
        int i8 = C2424b.f23370a;
        try {
            int intValue = ((Integer) connectivityManager.getClass().getMethod("startUsingNetworkFeature", Integer.TYPE, String.class).invoke(connectivityManager, 5, "enableMMS")).intValue();
            if (intValue == 0) {
                w2();
            } else {
                if (intValue != 1) {
                    if (intValue == 2) {
                        throw new IllegalStateException("No APN for MMS available");
                    }
                    throw new IllegalStateException(B4.g.g("Failed to start MMS network: ", intValue));
                }
                n2(1);
                automateService.registerReceiver(this.f17467V1, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        } catch (IllegalAccessException e8) {
            throw new RuntimeException(e8);
        } catch (NoSuchMethodException e9) {
            throw new RuntimeException(e9);
        } catch (InvocationTargetException e10) {
            throw ((RuntimeException) e10.getTargetException());
        }
    }

    public final void E2(InetAddress inetAddress) {
        boolean booleanValue;
        ConnectivityManager connectivityManager = this.f17439S1;
        int i8 = C2424b.f23370a;
        try {
            booleanValue = ((Boolean) connectivityManager.getClass().getMethod("requestRouteToHostAddress", Integer.TYPE, InetAddress.class).invoke(connectivityManager, 2, inetAddress)).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException unused) {
            int i9 = 0;
            for (byte b8 : inetAddress.getAddress()) {
                i9 = (i9 << 8) | (b8 & 255);
            }
            try {
                Class<?> cls = connectivityManager.getClass();
                Class<?> cls2 = Integer.TYPE;
                booleanValue = ((Boolean) cls.getMethod("requestRouteToHost", cls2, cls2).invoke(connectivityManager, 2, Integer.valueOf(i9))).booleanValue();
            } catch (IllegalAccessException e8) {
                throw new RuntimeException(e8);
            } catch (NoSuchMethodException e9) {
                throw new RuntimeException(e9);
            } catch (InvocationTargetException e10) {
                throw ((RuntimeException) e10.getTargetException());
            }
        } catch (InvocationTargetException e11) {
            throw ((RuntimeException) e11.getTargetException());
        }
        if (booleanValue) {
            return;
        }
        throw new NoRouteToHostException("Route request failed: " + inetAddress);
    }

    @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        ConnectivityManager connectivityManager = this.f17439S1;
        int i8 = C2424b.f23370a;
        try {
            ((Integer) connectivityManager.getClass().getMethod("stopUsingNetworkFeature", Integer.TYPE, String.class).invoke(connectivityManager, 0, "enableMMS")).intValue();
            try {
                automateService.unregisterReceiver(this.f17467V1);
            } catch (Throwable unused) {
            }
            super.F(automateService);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException(e8);
        } catch (NoSuchMethodException e9) {
            throw new RuntimeException(e9);
        } catch (InvocationTargetException e10) {
            throw ((RuntimeException) e10.getTargetException());
        }
    }

    @Override // com.llamalab.automate.AbstractRunnableC1694v2
    public final void x2() {
        String simOperator;
        Object invoke;
        Pair C22;
        TelephonyManager createForSubscriptionId;
        URLConnection openConnection;
        Uri uri;
        int i8 = Build.VERSION.SDK_INT;
        int i9 = this.f17455P1;
        if (29 <= i8) {
            uri = Telephony.Carriers.SIM_APN_URI;
            C22 = C2(uri.buildUpon().appendEncodedPath(Integer.toString(i9)).build(), null);
        } else {
            Uri uri2 = 19 <= i8 ? Telephony.Carriers.CONTENT_URI : w3.n.f23256c;
            StringBuilder sb = new StringBuilder("current");
            TelephonyManager telephonyManager = this.f17456Q1;
            String[] strArr = w3.n.f23254a;
            if (24 <= i8) {
                createForSubscriptionId = telephonyManager.createForSubscriptionId(i9);
                simOperator = createForSubscriptionId.getSimOperator();
            } else {
                if (22 <= i8) {
                    invoke = telephonyManager.getClass().getMethod("getSimOperator", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i9));
                } else if (21 <= i8) {
                    invoke = telephonyManager.getClass().getMethod("getSimOperator", Long.TYPE).invoke(telephonyManager, Long.valueOf(w3.n.a(i9)));
                } else {
                    simOperator = telephonyManager.getSimOperator();
                }
                simOperator = (String) invoke;
            }
            if (!TextUtils.isEmpty(simOperator)) {
                sb.append(" and numeric='");
                sb.append(simOperator);
                sb.append("'");
            }
            if (28 <= i8) {
                sb.append(" and owned_by!=0");
            }
            C22 = C2(uri2, sb.toString());
        }
        Object obj = C22.second;
        if (obj != null) {
            E2(((InetSocketAddress) ((Proxy) obj).address()).getAddress());
            openConnection = ((URL) C22.first).openConnection((Proxy) C22.second);
        } else {
            E2(InetAddress.getByName(((URL) C22.first).getHost()));
            openConnection = ((URL) C22.first).openConnection();
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        try {
            D2(httpURLConnection);
            httpURLConnection.disconnect();
            q2(null, false);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
