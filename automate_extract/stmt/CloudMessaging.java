package com.llamalab.automate.stmt;

import C1.D1;
import android.net.Network;
import android.os.Build;
import android.util.Base64;
import androidx.appcompat.widget.C1231k;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.fs.AutomateFileTypeDetector;
import com.llamalab.automate.stmt.GoogleAuthorized;
import d4.C1725f;
import e4.C1759b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* loaded from: classes.dex */
public final class CloudMessaging {

    /* renamed from: a, reason: collision with root package name */
    public static final String f16471a = D1.m(new StringBuilder("Automate/1.53.1 ("), Build.FINGERPRINT, ")");

    public interface Statement extends GoogleAuthorized.Statement {
        InterfaceC1700x0 i1();
    }

    public static char[] a(Statement statement, C1708z0 c1708z0) {
        C1231k c8 = J3.h.c(c1708z0, statement.i1());
        if (c8 == null) {
            return null;
        }
        String str = (String) c8.f9362Z;
        if (str == null || str.isEmpty()) {
            throw new IllegalStateException("Cipher account has no password");
        }
        return str.toCharArray();
    }

    public static SecretKey b(char[] cArr, char[] cArr2, byte[] bArr) {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1", BouncyCastleProvider.PROVIDER_NAME);
        SecretKey generateSecret = secretKeyFactory.generateSecret(new PBEKeySpec(cArr, bArr, 250, 256));
        if (cArr2 == null) {
            return generateSecret;
        }
        SecretKey generateSecret2 = secretKeyFactory.generateSecret(new PBEKeySpec(cArr2, bArr, MoreOsConstants.KEY_BRL_DOT4, 256));
        MessageDigest messageDigest = MessageDigest.getInstance("SHA256", BouncyCastleProvider.PROVIDER_NAME);
        messageDigest.update(generateSecret.getEncoded());
        messageDigest.update(generateSecret2.getEncoded());
        return new SecretKeySpec(messageDigest.digest(), "HmacSHA256");
    }

    public static String c(String str) {
        int indexOf = str.indexOf(46) + 1;
        int indexOf2 = str.indexOf(46, indexOf);
        if (indexOf >= indexOf2) {
            throw new IllegalArgumentException("Bad JWT token");
        }
        try {
            C1759b c1759b = new C1759b(Base64.decode(str.substring(indexOf, indexOf2), 8));
            try {
                c1759b.v();
                while (c1759b.p(true)) {
                    if ("email".contentEquals(c1759b)) {
                        String m8 = c1759b.m();
                        c1759b.close();
                        return m8;
                    }
                    c1759b.r();
                }
                c1759b.close();
                throw new IllegalStateException("Invalid JWT: no account email");
            } catch (Throwable th) {
                try {
                    c1759b.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            throw new IllegalArgumentException("Bad JWT token");
        }
    }

    public static void d(HttpURLConnection httpURLConnection, String str, String str2) {
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", f16471a);
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + str);
        httpURLConnection.setRequestProperty("Content-Type", str2);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
    }

    public static int e(Network network, String str, String str2, String str3) {
        URLConnection openConnection;
        if (network == null) {
            return f(str, str2, str3);
        }
        openConnection = network.openConnection(new URL("https://llamalab.com/automate/cloud/api/v2/devices"));
        return g((HttpURLConnection) openConnection, str, str2, str3);
    }

    public static int f(String str, String str2, String str3) {
        return g((HttpURLConnection) new URL("https://llamalab.com/automate/cloud/api/v2/devices").openConnection(), str, str2, str3);
    }

    public static int g(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        d(httpURLConnection, str, "application/x-www-form-urlencoded");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
        try {
            outputStreamWriter.append((CharSequence) "token=").append((CharSequence) URLEncoder.encode(str2, "UTF-8")).append((CharSequence) "&device=").append((CharSequence) URLEncoder.encode(str3, "UTF-8"));
            outputStreamWriter.close();
            int responseCode = httpURLConnection.getResponseCode();
            InputStream inputStream = responseCode < 400 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
            if (inputStream != null) {
                try {
                    try {
                        do {
                        } while (inputStream.read(new byte[MoreOsConstants.O_DSYNC]) != -1);
                        inputStream.close();
                    } catch (Throwable th) {
                        inputStream.close();
                        throw th;
                    }
                } catch (IOException unused) {
                }
            }
            return responseCode;
        } catch (Throwable th2) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th3) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                } catch (Exception unused2) {
                }
            }
            throw th2;
        }
    }

    public static int h(Network network, String str, String str2, String str3, String str4, String str5, boolean z7, byte[] bArr) {
        URLConnection openConnection;
        if (network == null) {
            return i((HttpURLConnection) new URL("https://llamalab.com/automate/cloud/api/v2/messages").openConnection(), str, str2, str3, str4, str5, z7, bArr);
        }
        openConnection = network.openConnection(new URL("https://llamalab.com/automate/cloud/api/v2/messages"));
        return i((HttpURLConnection) openConnection, str, str2, str3, str4, str5, z7, bArr);
    }

    public static int i(HttpURLConnection httpURLConnection, String str, String str2, String str3, String str4, String str5, boolean z7, byte[] bArr) {
        d(httpURLConnection, str, AutomateFileTypeDetector.OCTET_STREAM);
        C1725f c1725f = new C1725f(httpURLConnection.getOutputStream());
        try {
            c1725f.writeShort(2);
            c1725f.b(str2);
            c1725f.b(str3);
            c1725f.b(str4);
            if (str5 == null) {
                str5 = "";
            }
            c1725f.b(str5);
            c1725f.b(z7 ? "HIGH" : "NORMAL");
            c1725f.f(bArr.length);
            c1725f.write(bArr);
            c1725f.close();
            int responseCode = httpURLConnection.getResponseCode();
            InputStream inputStream = responseCode < 400 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
            if (inputStream != null) {
                try {
                    try {
                        do {
                        } while (inputStream.read(new byte[MoreOsConstants.O_DSYNC]) != -1);
                        inputStream.close();
                    } catch (Throwable th) {
                        inputStream.close();
                        throw th;
                    }
                } catch (IOException unused) {
                }
            }
            return responseCode;
        } catch (Throwable th2) {
            try {
                c1725f.close();
            } catch (Throwable th3) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                } catch (Exception unused2) {
                }
            }
            throw th2;
        }
    }
}
