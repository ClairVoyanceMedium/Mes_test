package com.llamalab.automate.stmt;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.fs.AutomateFileTypeDetector;
import d4.C1720a;
import d4.C1723d;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class P0 extends AbstractRunnableC1694v2 {

    /* renamed from: L1, reason: collision with root package name */
    public final String[] f17014L1;

    /* renamed from: M1, reason: collision with root package name */
    public final String[] f17015M1;

    /* renamed from: N1, reason: collision with root package name */
    public final String[] f17016N1;

    /* renamed from: O1, reason: collision with root package name */
    public final String f17017O1;

    /* renamed from: P1, reason: collision with root package name */
    public final String f17018P1;

    /* renamed from: Q1, reason: collision with root package name */
    public final com.llamalab.safs.n[] f17019Q1;

    public P0(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2, com.llamalab.safs.n[] nVarArr) {
        this.f17014L1 = strArr;
        this.f17015M1 = strArr2;
        this.f17016N1 = strArr3;
        this.f17017O1 = str;
        this.f17018P1 = str2;
        this.f17019Q1 = nVarArr;
    }

    public static void A2(Writer writer, String str, String... strArr) {
        StringBuilder sb = null;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (str2 != null) {
                    String trim = str2.trim();
                    if (!trim.isEmpty()) {
                        if (sb != null) {
                            sb.append(", ");
                            sb.append(trim);
                        } else {
                            sb = new StringBuilder(trim);
                        }
                    }
                }
            }
        }
        if (sb != null) {
            writer.append((CharSequence) str).append(": ").append((CharSequence) sb).append((CharSequence) "\r\n");
        }
    }

    public final void B2(Writer writer, boolean z7) {
        String str;
        int indexOf;
        Writer append = writer.append("MIME-Version: 1.0").append("\r\n").append("User-Agent: ");
        try {
            AutomateService automateService = this.f15400Y;
            Writer append2 = append.append((CharSequence) (automateService.getString(C2541R.string.application_name) + "/" + automateService.getPackageManager().getPackageInfo(automateService.getPackageName(), 0).versionName)).append("\r\n").append("Message-ID: ");
            String z22 = z2();
            append2.append((CharSequence) ("<" + UUID.randomUUID() + "@" + ((z22 == null || (indexOf = z22.indexOf(64)) == -1) ? y2() : z22.substring(indexOf + 1)) + ">")).append("\r\n").append("Date: ").append((CharSequence) String.format(Locale.US, "%1$ta, %1$te %1$tb %1$tY %1$tT %1$tz", Long.valueOf(System.currentTimeMillis()))).append("\r\n");
            A2(writer, "From", z2());
            A2(writer, "To", this.f17014L1);
            A2(writer, "Cc", this.f17015M1);
            if (z7) {
                A2(writer, "Bcc", this.f17016N1);
            }
            String str2 = this.f17017O1;
            if (!TextUtils.isEmpty(str2)) {
                writer.append("Subject: ");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new C1723d(writer), "UTF-8");
                try {
                    outputStreamWriter.write(str2);
                    outputStreamWriter.close();
                    writer.append("\r\n");
                } finally {
                }
            }
            com.llamalab.safs.n[] nVarArr = this.f17019Q1;
            boolean z8 = (nVarArr == null || nVarArr.length == 0) ? false : true;
            if (z8) {
                byte[] bArr = new byte[12];
                new Random().nextBytes(bArr);
                str = "BOUN" + V3.b.h(bArr, 12, V3.b.f6988b) + "DARY";
                writer.append("Content-Type: multipart/mixed; boundary=\"").append((CharSequence) str).append('\"').append("\r\n").append("\r\n").append("This is a multi-part message in MIME format.").append("\r\n").append("--").append((CharSequence) str).append("\r\n");
            } else {
                str = null;
            }
            writer.append("Content-Type: text/plain; charset=").append("UTF-8").append("; format=flowed").append("\r\n").append("Content-Transfer-Encoding: quoted-printable").append("\r\n").append("\r\n");
            String str3 = this.f17018P1;
            if (!TextUtils.isEmpty(str3)) {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new d4.h(writer), "UTF-8");
                try {
                    outputStreamWriter2.write(str3);
                    outputStreamWriter2.close();
                } finally {
                }
            }
            if (z8) {
                CharsetEncoder newEncoder = Charset.forName("ISO-8859-1").newEncoder();
                for (com.llamalab.safs.n nVar : nVarArr) {
                    if (nVar == null) {
                        throw new NullPointerException("Null attachment path");
                    }
                    s4.d C7 = nVar.C();
                    if (C7 == null) {
                        throw new IllegalArgumentException("Attachment path missing filename");
                    }
                    String m8 = com.llamalab.safs.i.m(nVar);
                    if (m8 == null) {
                        m8 = AutomateFileTypeDetector.OCTET_STREAM;
                    }
                    Writer append3 = writer.append("\r\n").append("--").append((CharSequence) str).append("\r\n").append("Content-Type: ").append((CharSequence) m8).append("\r\n").append("Content-Transfer-Encoding: base64").append("\r\n").append("Content-Disposition: attachment; filename=\"");
                    String str4 = C7.f22250Y;
                    append3.append((CharSequence) str4).append('\"');
                    if (!newEncoder.canEncode(str4)) {
                        writer.append(" filename*=").append("UTF-8").append("''").append((CharSequence) URLEncoder.encode(str4, "UTF-8"));
                    }
                    writer.append("\r\n").append("\r\n");
                    C1720a c1720a = new C1720a(writer);
                    try {
                        com.llamalab.safs.i.a(nVar, c1720a);
                        c1720a.close();
                    } finally {
                    }
                }
                writer.append("\r\n").append("--").append((CharSequence) str).append("--").append("\r\n");
            }
            writer.flush();
        } catch (PackageManager.NameNotFoundException e8) {
            throw new RuntimeException(e8);
        }
    }

    public abstract String y2();

    public abstract String z2();
}
