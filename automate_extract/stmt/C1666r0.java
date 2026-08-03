package com.llamalab.automate.stmt;

import C1.D1;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.expr.ConversionType;
import com.llamalab.automate.expr.func.MimeType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Locale;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import p3.C2213b;
import s1.C2305a;

/* renamed from: com.llamalab.automate.stmt.r0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1666r0 {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f17511a = new String[3];

    /* renamed from: b, reason: collision with root package name */
    public static final byte[][] f17512b = new byte[3][];

    static {
        for (int i8 = 1; i8 <= 2; i8++) {
            String format = String.format(Locale.US, "com.llamalab.automate.v%d:externaltype", Integer.valueOf(i8));
            f17511a[i8] = D1.k("/", format);
            f17512b[i8] = format.getBytes(C2213b.f21560b);
        }
    }

    public static NdefMessage a(Object obj) {
        byte[] byteArray;
        if (obj != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                R3.d dVar = new R3.d(new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9)));
                try {
                    dVar.f6413Z = 2;
                    dVar.f6414x0 = true;
                    dVar.g(obj);
                    dVar.close();
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    try {
                        dVar.close();
                    } catch (Throwable th2) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e8) {
                throw new RuntimeException(e8);
            }
        } else {
            byteArray = null;
        }
        return new NdefMessage(new NdefRecord[]{new NdefRecord((short) 4, f17512b[2], null, byteArray)});
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01bf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object b(Tag tag) {
        NdefMessage cachedNdefMessage;
        J3.e c8;
        J3.e eVar;
        int i8;
        int i9;
        byte[] payload;
        String str;
        Ndef ndef = Ndef.get(tag);
        if (ndef == null || (cachedNdefMessage = ndef.getCachedNdefMessage()) == null) {
            return null;
        }
        NdefRecord[] records = cachedNdefMessage.getRecords();
        for (NdefRecord ndefRecord : records) {
            if (4 == ndefRecord.getTnf()) {
                byte[] type = ndefRecord.getType();
                int i10 = 1;
                while (i10 <= 2) {
                    if (Arrays.equals(f17512b[i10], type)) {
                        try {
                            byte[] payload2 = ndefRecord.getPayload();
                            if (payload2 == null || payload2.length == 0) {
                                return null;
                            }
                            R3.c cVar = new R3.c(new InflaterInputStream(new ByteArrayInputStream(payload2)));
                            try {
                                cVar.f6409x0 = i10;
                                cVar.f6410y0 = 2 <= i10;
                                Object readObject = cVar.readObject();
                                if (readObject instanceof InterfaceC1700x0) {
                                    readObject = ((InterfaceC1700x0) readObject).c2(null);
                                }
                                cVar.close();
                                return readObject;
                            } catch (Throwable th) {
                                try {
                                    cVar.close();
                                } catch (Throwable th2) {
                                    try {
                                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                    } catch (Exception unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e8) {
                            Log.e("NfcTagUtils", "getAutomatePayload failed", e8);
                            return null;
                        }
                    }
                    i10++;
                }
            }
        }
        J3.a aVar = null;
        for (NdefRecord ndefRecord2 : records) {
            short tnf = ndefRecord2.getTnf();
            if (tnf == 1) {
                byte[] type2 = ndefRecord2.getType();
                if (Arrays.equals(NdefRecord.RTD_URI, type2) || Arrays.equals(NdefRecord.RTD_SMART_POSTER, type2)) {
                    c8 = c(ndefRecord2);
                    if (c8 != null) {
                        if (aVar == null) {
                            aVar = new J3.a();
                        }
                        aVar.add(c8);
                    }
                } else if (Arrays.equals(NdefRecord.RTD_TEXT, type2)) {
                    byte[] payload3 = ndefRecord2.getPayload();
                    if (payload3 == null || payload3.length == 0 || (i9 = (i8 = payload3[0] & 255) + 1) >= payload3.length) {
                        eVar = null;
                    } else {
                        eVar = new J3.e(2);
                        if (i8 != 0) {
                            eVar.m0("language", new String(payload3, 1, i8, C2213b.f21560b), null);
                        }
                        eVar.m0("text", new String(payload3, i9, (payload3.length - i8) - 1, C2213b.f21561c), null);
                    }
                    if (eVar != null) {
                        if (aVar == null) {
                            aVar = new J3.a();
                        }
                        aVar.add(eVar);
                    }
                }
            } else if (tnf != 2) {
                if (tnf == 3 && (c8 = c(ndefRecord2)) != null) {
                    if (aVar == null) {
                        aVar = new J3.a();
                    }
                    aVar.add(c8);
                }
            } else {
                try {
                    payload = ndefRecord2.getPayload();
                } catch (UnsupportedEncodingException e9) {
                    Log.w("NfcTagUtils", "getMimePayload failed", e9);
                }
                if (payload == null && payload.length == 0) {
                    c8 = null;
                    if (c8 != null) {
                    }
                } else {
                    byte[] type3 = ndefRecord2.getType();
                    Charset charset = C2213b.f21560b;
                    AbstractMap.SimpleImmutableEntry a8 = Y3.F.a(new String(type3, charset), charset);
                    String charSequence = ((CharSequence) a8.getKey()).toString();
                    if (!"application/json".equals(charSequence) && !charSequence.startsWith("application/json+")) {
                        if (!charSequence.startsWith("text/") && !"application/xml".equals(charSequence) && !charSequence.startsWith("application/xml+")) {
                            str = Base64.encodeToString(payload, 2);
                            c8 = d(charSequence, str);
                            if (c8 != null) {
                                if (aVar == null) {
                                    aVar = new J3.a();
                                }
                                aVar.add(c8);
                            }
                        }
                        CharSequence b8 = Y3.F.b(a8, "charset", null);
                        if (b8 == null) {
                            q7.b bVar = new q7.b();
                            bVar.b(payload, 0, payload.length);
                            bVar.a();
                            b8 = (CharSequence) C2305a.o(bVar.f21852f, "UTF-8");
                        }
                        c8 = d(charSequence, new String(payload, b8.toString()));
                        if (c8 != null) {
                        }
                    }
                    str = new String(payload, C2213b.f21561c);
                    c8 = d(charSequence, str);
                    if (c8 != null) {
                    }
                }
            }
        }
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r3 = r3.toUri();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static J3.e c(NdefRecord ndefRecord) {
        Uri uri;
        if (16 > Build.VERSION.SDK_INT || uri == null) {
            return null;
        }
        J3.e eVar = new J3.e(1);
        eVar.m0("uri", uri.toString(), ConversionType.Uri);
        return eVar;
    }

    public static J3.e d(String str, String str2) {
        J3.e eVar = new J3.e(2);
        eVar.m0(MimeType.NAME, str, null);
        eVar.m0("payload", str2, null);
        return eVar;
    }

    public static String e(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return V3.b.h(bArr, bArr.length, V3.b.f6988b);
    }
}
