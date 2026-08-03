package com.llamalab.automate.stmt;

import J3.e;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.security.KeyChain;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C2541R;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.NoSuchElementException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import k5.C2051c;
import p3.C2213b;
import s1.C2305a;
import s3.C2311a;
import v3.C2359a;
import v3.C2360b;
import x3.C2429g;

/* loaded from: classes.dex */
public class K extends AbstractRunnableC1694v2 {

    /* renamed from: L1, reason: collision with root package name */
    public final Uri f16820L1;

    /* renamed from: M1, reason: collision with root package name */
    public final String f16821M1;

    /* renamed from: N1, reason: collision with root package name */
    public final J3.e f16822N1;

    /* renamed from: O1, reason: collision with root package name */
    public final CharSequence[] f16823O1;

    /* renamed from: P1, reason: collision with root package name */
    public final com.llamalab.safs.n[] f16824P1;

    /* renamed from: Q1, reason: collision with root package name */
    public final com.llamalab.safs.n f16825Q1;

    /* renamed from: R1, reason: collision with root package name */
    public final String f16826R1;

    /* renamed from: S1, reason: collision with root package name */
    public final int f16827S1;

    /* renamed from: T1, reason: collision with root package name */
    public final int f16828T1;
    public final boolean U1;

    /* renamed from: V1, reason: collision with root package name */
    public final boolean f16829V1;

    public K(Uri uri, int i8, String str, boolean z7, boolean z8, String str2, J3.e eVar, CharSequence[] charSequenceArr, com.llamalab.safs.n[] nVarArr, int i9, com.llamalab.safs.n nVar) {
        this.f16820L1 = uri;
        this.f16827S1 = i8;
        this.f16826R1 = str;
        this.U1 = z7;
        this.f16829V1 = z8;
        this.f16821M1 = str2;
        this.f16822N1 = eVar;
        this.f16823O1 = charSequenceArr;
        this.f16824P1 = nVarArr;
        this.f16828T1 = i9;
        this.f16825Q1 = nVar;
    }

    public static String A2(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getResponseCode() < 400 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
        CharSequence charSequence = null;
        if (inputStream == null) {
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        }
        try {
            String contentType = httpURLConnection.getContentType();
            if (contentType != null) {
                AbstractMap.SimpleImmutableEntry a8 = Y3.F.a(contentType, C2213b.f21559a);
                charSequence = Y3.F.b(a8, "charset", "application/json".contentEquals((CharSequence) a8.getKey()) ? "UTF-8" : null);
            }
            byte[] f8 = com.llamalab.safs.internal.m.f(8192, inputStream);
            if (charSequence == null) {
                q7.b bVar = new q7.b();
                bVar.b(f8, 0, f8.length);
                bVar.a();
                charSequence = (CharSequence) C2305a.o(bVar.f21852f, "UTF-8");
            }
            String str = new String(f8, charSequence.toString());
            inputStream.close();
            return str;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }

    public URLConnection B2(URL url) {
        return url.openConnection();
    }

    public final void C2(HttpURLConnection httpURLConnection) {
        com.llamalab.safs.n nVar;
        CharSequence charSequence;
        CharSequence[] charSequenceArr = this.f16823O1;
        int length = charSequenceArr.length;
        com.llamalab.safs.n[] nVarArr = this.f16824P1;
        if (length == 0 && nVarArr.length == 0) {
            return;
        }
        J3.e eVar = this.f16822N1;
        if (!"identity".equalsIgnoreCase(J3.h.f0("identity", eVar.j0("Transfer-Encoding")))) {
            httpURLConnection.setChunkedStreamingMode(-1);
        }
        httpURLConnection.setDoOutput(true);
        Charset forName = Charset.forName(Y3.F.b(Y3.F.a(J3.h.f0("text/plain", eVar.j0("Content-Type")), C2213b.f21559a), "charset", "UTF-8").toString());
        OutputStream outputStream = httpURLConnection.getOutputStream();
        int i8 = 0;
        while (true) {
            try {
                boolean z7 = i8 < charSequenceArr.length;
                if (z7 && (charSequence = charSequenceArr[i8]) != null && charSequence.length() != 0) {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new d4.g(outputStream), forName);
                    try {
                        outputStreamWriter.append(charSequence);
                        outputStreamWriter.close();
                    } catch (Throwable th) {
                        try {
                            outputStreamWriter.close();
                        } catch (Throwable th2) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                }
                boolean z8 = i8 < nVarArr.length;
                if (z8 && (nVar = nVarArr[i8]) != null) {
                    com.llamalab.safs.i.a(nVar, outputStream);
                }
                i8++;
                if (!z7 && !z8) {
                    break;
                }
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th3, th4);
                        } catch (Exception unused2) {
                        }
                    }
                }
                throw th3;
            }
        }
        if (outputStream != null) {
            outputStream.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0072 A[Catch: all -> 0x00ef, TryCatch #0 {all -> 0x00ef, blocks: (B:3:0x0013, B:5:0x001c, B:8:0x0027, B:9:0x004f, B:10:0x0069, B:11:0x006c, B:13:0x0072, B:14:0x0054, B:16:0x0058, B:17:0x0091, B:22:0x00b8, B:26:0x00cf, B:31:0x00c6, B:32:0x00cb), top: B:2:0x0013 }] */
    @Override // com.llamalab.automate.AbstractRunnableC1694v2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x2() {
        SSLContext sSLContext;
        int i8 = this.f16827S1;
        HttpURLConnection httpURLConnection = (HttpURLConnection) B2(new URL(this.f16820L1.toString()));
        try {
            String str = null;
            if (httpURLConnection instanceof HttpsURLConnection) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                C2429g.a aVar = C2429g.f23385b;
                String str2 = this.f16826R1;
                if (str2 != null) {
                    httpsURLConnection.setHostnameVerifier(aVar);
                    AutomateService automateService = this.f15400Y;
                    C2359a c2359a = new C2359a(str2, KeyChain.getCertificateChain(automateService, str2), KeyChain.getPrivateKey(automateService, str2));
                    sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(new KeyManager[]{c2359a}, new TrustManager[]{new C2360b(c2359a.f22880b)}, null);
                } else {
                    if (this.U1) {
                        httpsURLConnection.setHostnameVerifier(aVar);
                        sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, new TrustManager[]{C2051c.f20520a}, null);
                    }
                    if (25 > Build.VERSION.SDK_INT) {
                        httpsURLConnection.setSSLSocketFactory(new C2311a(httpsURLConnection.getSSLSocketFactory(), "TLSv1.3", "TLSv1.2", "TLSv1.1", "TLSv1"));
                    }
                }
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                if (25 > Build.VERSION.SDK_INT) {
                }
            }
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(this.f16829V1);
            httpURLConnection.setConnectTimeout(i8);
            httpURLConnection.setReadTimeout(i8);
            httpURLConnection.setRequestMethod(this.f16821M1);
            y2(httpURLConnection);
            httpURLConnection.setRequestProperty("Connection", "close");
            int i9 = this.f16828T1;
            httpURLConnection.setDoInput(1 == i9 || 2 == i9);
            C2(httpURLConnection);
            httpURLConnection.connect();
            if (i9 == 1) {
                str = A2(httpURLConnection);
            } else if (i9 == 2) {
                str = z2(httpURLConnection);
            }
            q2(new Object[]{Double.valueOf(httpURLConnection.getResponseCode()), J3.h.P(httpURLConnection.getHeaderFields()), str}, false);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y2(HttpURLConnection httpURLConnection) {
        J3.e eVar = this.f16822N1;
        eVar.getClass();
        C1231k c1231k = (C1231k) eVar.f9362Z;
        while (true) {
            if (!(c1231k != eVar)) {
                return;
            }
            if (c1231k == eVar) {
                throw new NoSuchElementException();
            }
            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
            e.a aVar = (e.a) c1231k;
            Object obj = aVar.f4644x1;
            boolean z7 = obj instanceof J3.a;
            String str = aVar.f4645y0;
            if (z7) {
                J3.a aVar2 = (J3.a) obj;
                aVar2.getClass();
                int i8 = 0;
                while (true) {
                    if (i8 < aVar2.f4627Y) {
                        if (i8 >= aVar2.f4627Y) {
                            throw new NoSuchElementException();
                        }
                        int i9 = i8 + 1;
                        Object obj2 = aVar2.get(i8);
                        if (obj2 != null) {
                            httpURLConnection.addRequestProperty(str, J3.h.e0(obj2));
                        }
                        i8 = i9;
                    }
                }
            } else if (obj != null) {
                httpURLConnection.addRequestProperty(str, J3.h.e0(obj));
            }
            c1231k = c1231k2;
        }
    }

    public final String z2(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getResponseCode() < 400 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
        String str = null;
        if (inputStream == null) {
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        }
        try {
            String contentType = httpURLConnection.getContentType();
            String h8 = contentType != null ? C2429g.h(((CharSequence) Y3.F.a(contentType, C2213b.f21559a).getKey()).toString()) : "bin";
            String lastPathSegment = this.f16820L1.getLastPathSegment();
            if (lastPathSegment == null || !lastPathSegment.isEmpty()) {
                str = lastPathSegment;
            }
            com.llamalab.safs.n t8 = w0.L.t(this.f16825Q1, Environment.DIRECTORY_DOWNLOADS, str, C2541R.string.format_download_file, h8);
            com.llamalab.safs.i.b(inputStream, t8, com.llamalab.safs.o.REPLACE_EXISTING);
            String obj = t8.toString();
            inputStream.close();
            return obj;
        } catch (Throwable th) {
            try {
                inputStream.close();
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
