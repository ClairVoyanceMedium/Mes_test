package com.llamalab.automate.stmt;

import A4.g;
import C1.D1;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.expr.func.Type;
import com.llamalab.io.HttpStatusException;
import d4.C1722c;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import x3.C2429g;
import z4.C2538s;
import z4.InterfaceC2529j;
import z4.InterfaceC2537r;

/* renamed from: com.llamalab.automate.stmt.j0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1651j0 extends AbstractC1653k0 {

    /* renamed from: T1, reason: collision with root package name */
    public static final String[] f17438T1 = {Type.NAME, "mmsc", "mmsproxy", "mmsport"};
    public static final Pattern U1 = Pattern.compile("(?:.*,)?\\s*(?:\\*|mms)\\s*(?:,.*)?", 66);

    /* renamed from: S1, reason: collision with root package name */
    public ConnectivityManager f17439S1;

    public AbstractC1651j0(String[] strArr, String str, String str2, com.llamalab.safs.n nVar, int i8) {
        super(strArr, str, str2, nVar, i8);
    }

    @Override // com.llamalab.automate.stmt.AbstractC1653k0, com.llamalab.automate.W, com.llamalab.automate.N2
    public void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        this.f17439S1 = (ConnectivityManager) automateService.getSystemService("connectivity");
    }

    public final Pair C2(Uri uri, String str) {
        String str2;
        Proxy proxy;
        Cursor query = this.f15400Y.getContentResolver().query(uri, f17438T1, str, null, null);
        while (query.moveToNext()) {
            try {
                String string = query.getString(0);
                if (!TextUtils.isEmpty(string) && U1.matcher(string).matches()) {
                    String string2 = query.getString(1);
                    if (TextUtils.isEmpty(string2)) {
                        continue;
                    } else {
                        String string3 = query.getString(2);
                        String string4 = query.getString(3);
                        try {
                            try {
                                URL url = new URL(string2);
                                if (TextUtils.isEmpty(string3) || TextUtils.isEmpty(string4)) {
                                    proxy = null;
                                } else {
                                    byte[] k8 = C2429g.k(string3);
                                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(k8 != null ? InetAddress.getByAddress(k8) : InetAddress.getByName(string3), Integer.parseInt(string4)));
                                }
                                if (C1710z2.a(this.f17457R1)) {
                                    F5.n.f(this, "APN: mmsc=" + string2 + ", mmsproxy=" + string3 + ", mmsport=" + string4 + ", proxy=" + proxy);
                                }
                                return new Pair(url, proxy);
                            } catch (UnknownHostException e8) {
                                Log.e("MmsSendTaskHttp", "Bad mmsproxy: " + string3);
                                throw e8;
                            }
                        } catch (NumberFormatException unused) {
                            str2 = "Bad mmsport: " + string4;
                            Log.w("MmsSendTaskHttp", str2);
                        } catch (MalformedURLException unused2) {
                            str2 = "Bad mmsc: " + string2;
                            Log.w("MmsSendTaskHttp", str2);
                        }
                    }
                }
            } finally {
                query.close();
            }
        }
        query.close();
        throw new UnknownServiceException("No suitable APN for MMS found");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0076, code lost:
    
        if (android.text.TextUtils.isEmpty(r10) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009b, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D2(HttpURLConnection httpURLConnection) {
        String str;
        TelephonyManager createForSubscriptionId;
        TelephonyManager createForSubscriptionId2;
        com.llamalab.automate.access.c.j("android.permission.SEND_SMS").w(this.f15400Y);
        A4.k z22 = z2();
        InterfaceC2537r[] interfaceC2537rArr = (InterfaceC2537r[]) z22.f23792a.get(g.c.f95w);
        List asList = interfaceC2537rArr != null ? Arrays.asList(interfaceC2537rArr) : Collections.emptyList();
        B2(asList.size());
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Connection", "close");
        InterfaceC2529j.e eVar = InterfaceC2529j.e.f23786Y;
        httpURLConnection.setRequestProperty("Content-Type", "application/vnd.wap.mms-message");
        int i8 = Build.VERSION.SDK_INT;
        String str2 = null;
        int i9 = this.f17455P1;
        if (19 <= i8) {
            TelephonyManager telephonyManager = this.f17456Q1;
            String[] strArr = w3.n.f23254a;
            if (24 <= i8) {
                createForSubscriptionId2 = telephonyManager.createForSubscriptionId(i9);
                str = createForSubscriptionId2.getMmsUserAgent();
            } else {
                str = 19 <= i8 ? telephonyManager.getMmsUserAgent() : null;
            }
        }
        str = "Android Messaging";
        httpURLConnection.setRequestProperty("User-Agent", str);
        if (19 <= i8) {
            TelephonyManager telephonyManager2 = this.f17456Q1;
            String[] strArr2 = w3.n.f23254a;
            if (24 <= i8) {
                createForSubscriptionId = telephonyManager2.createForSubscriptionId(i9);
                str2 = createForSubscriptionId.getMmsUAProfUrl();
            } else if (19 <= i8) {
                str2 = telephonyManager2.getMmsUAProfUrl();
            }
        }
        str2 = "http://www.gstatic.com/android/hangouts/hangouts_mms_ua_profile.xml";
        httpURLConnection.setRequestProperty("X-WAP-Profile", str2);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        C2538s c2538s = new C2538s(new C1722c(A2(), httpURLConnection.getOutputStream()));
        try {
            z22.d(c2538s);
            c2538s.close();
            if (200 != httpURLConnection.getResponseCode()) {
                throw new HttpStatusException(httpURLConnection);
            }
            Iterator it = asList.iterator();
            while (it.hasNext()) {
                C1655l0 c1655l0 = (C1655l0) this;
                c1655l0.g1().g(c1655l0.f15402x0, c1655l0.f15404y0, "W", c1655l0.f15400Y.getString(C2541R.string.log_mms_sent, (A4.e) it.next()));
            }
            String contentType = httpURLConnection.getContentType();
            InterfaceC2529j.e eVar2 = InterfaceC2529j.e.f23786Y;
            if (!"application/vnd.wap.mms-message".equals(contentType)) {
                throw new IOException(D1.k("Illegal response content-type: ", contentType));
            }
            AbstractC1653k0.y2(httpURLConnection.getInputStream());
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
    }
}
