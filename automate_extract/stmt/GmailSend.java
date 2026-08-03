package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.GoogleAuthorized;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import p3.C2213b;
import x3.C2434l;

@F3.f("gmail_send.html")
@F3.a(C2541R.integer.ic_content_gmail)
@F3.i(C2541R.string.stmt_gmail_send_title)
@F3.h(C2541R.string.stmt_gmail_send_summary)
@F3.e(C2541R.layout.stmt_gmail_send_edit)
/* loaded from: classes.dex */
public final class GmailSend extends EmailAction implements GoogleAuthorized.Statement, AsyncStatement {
    public InterfaceC1700x0 account;

    public static final class a extends P0 {

        /* renamed from: R1, reason: collision with root package name */
        public final String f16687R1;

        /* renamed from: S1, reason: collision with root package name */
        public final String f16688S1;

        public a(String str, String str2, String[] strArr, String[] strArr2, String[] strArr3, String str3, String str4, com.llamalab.safs.n[] nVarArr) {
            super(strArr, strArr2, strArr3, str3, str4, nVarArr);
            this.f16687R1 = str;
            this.f16688S1 = str2;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            long j8 = 1;
            while (true) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://www.googleapis.com/upload/gmail/v1/users/me/messages/send?uploadType=multipart").openConnection();
                try {
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Connection", "close");
                    httpURLConnection.setRequestProperty("Content-Type", "message/rfc822");
                    httpURLConnection.setRequestProperty("Authorization", "Bearer " + this.f16688S1);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(false);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), C2213b.f21561c);
                    try {
                        B2(outputStreamWriter, true);
                        outputStreamWriter.close();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode >= 200 && responseCode <= 299) {
                            p2(null);
                            return;
                        }
                        if (429 != responseCode) {
                            throw new IOException("Failed to send message (" + responseCode + "): " + httpURLConnection.getResponseMessage());
                        }
                        httpURLConnection.disconnect();
                        double d8 = j8;
                        double random = Math.random();
                        Double.isNaN(d8);
                        Thread.sleep((long) ((random + d8) * 1000.0d));
                        j8 += j8;
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
                } finally {
                    httpURLConnection.disconnect();
                }
            }
        }

        @Override // com.llamalab.automate.stmt.P0
        public final String y2() {
            return "www.googleapis.com";
        }

        @Override // com.llamalab.automate.stmt.P0
        public final String z2() {
            return this.f16687R1;
        }
    }

    @Override // com.llamalab.automate.stmt.AuthTokenStatement
    public final boolean B0(C1708z0 c1708z0, String str, String str2, long j8) {
        InterfaceC1700x0 interfaceC1700x0 = this.to;
        String[] strArr = C2434l.f23396g;
        a aVar = new a(str, str2, J3.h.w(c1708z0, interfaceC1700x0, strArr), J3.h.w(c1708z0, this.cc, strArr), J3.h.w(c1708z0, this.bcc, strArr), J3.h.x(c1708z0, this.subject, null), J3.h.x(c1708z0, this.message, null), J3.h.q(c1708z0, this.attachments, C2434l.f23404o));
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15542c, com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_gmail_send);
        l8.u(C2541R.string.caption_to, this.to);
        l8.v(this.message, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.AuthTokenStatement
    public final InterfaceC1700x0 N0() {
        return this.account;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        return GoogleAuthorized.a(this, c1708z0, intent);
    }

    @Override // com.llamalab.automate.stmt.EmailAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.account);
    }

    @Override // com.llamalab.automate.stmt.EmailAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.account);
    }

    @Override // com.llamalab.automate.stmt.EmailAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.account = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_gmail_send_title);
        com.llamalab.automate.access.c.f15542c.w(c1708z0);
        return GoogleAuthorized.b(this, c1708z0, "oauth2:https://www.googleapis.com/auth/gmail.send");
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
