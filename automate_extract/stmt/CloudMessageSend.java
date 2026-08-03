package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateApplication;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.CloudMessaging;
import com.llamalab.automate.work.CloudMessagingSendWorker;
import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import x3.C2440r;
import x3.C2443u;

@F3.f("cloud_message_send.html")
@F3.a(C2541R.integer.ic_cloud_chat_out)
@F3.i(C2541R.string.stmt_cloud_message_send_title)
@F3.h(C2541R.string.stmt_cloud_message_send_summary)
@F3.e(C2541R.layout.stmt_cloud_message_send_edit)
/* loaded from: classes.dex */
public final class CloudMessageSend extends IntermittentAction implements CloudMessaging.Statement, AsyncStatement {
    public InterfaceC1700x0 cipherAccount;
    public InterfaceC1700x0 fromAccount;
    public InterfaceC1700x0 highPriority;
    public InterfaceC1700x0 payload;
    public InterfaceC1700x0 toAccount;
    public InterfaceC1700x0 toDevice;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final boolean f16464L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String f16465M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f16466N1;

        /* renamed from: O1, reason: collision with root package name */
        public final String f16467O1;

        /* renamed from: P1, reason: collision with root package name */
        public final String f16468P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final boolean f16469Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final byte[] f16470R1;

        public a(boolean z7, String str, String str2, String str3, String str4, boolean z8, byte[] bArr) {
            this.f16464L1 = z7;
            this.f16465M1 = str;
            this.f16466N1 = str2;
            this.f16467O1 = str3;
            this.f16468P1 = str4;
            this.f16469Q1 = z8;
            this.f16470R1 = bArr;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            C2443u c2443u = AutomateApplication.f14524y1;
            synchronized (c2443u) {
                if (!c2443u.a(1)) {
                    throw new SecurityException("Maximum cloud message send rate exceeded");
                }
            }
            CloudMessagingSendWorker.enqueue(w0.J.d(this.f15400Y), this.f16465M1, this.f16466N1, this.f16467O1, this.f16468P1, this.f16469Q1, this.f16470R1, this.f16464L1 ? null : F5.n.c(this));
            if (this.f16464L1) {
                p2(null);
            } else {
                a();
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AuthTokenStatement
    public final boolean B0(C1708z0 c1708z0, String str, String str2, long j8) {
        String c8 = CloudMessaging.c(str2);
        String x7 = J3.h.x(c1708z0, this.toAccount, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("toAccount");
        }
        String x8 = J3.h.x(c1708z0, this.toDevice, null);
        char[] a8 = CloudMessaging.a(this, c1708z0);
        boolean f8 = J3.h.f(c1708z0, this.highPriority, false);
        Object u8 = J3.h.u(c1708z0, this.payload, null);
        boolean z7 = J1(0) == 0;
        String q8 = C2440r.q();
        char[] charArray = x7.toCharArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        byteArrayOutputStream.write(bArr);
        SecretKey b8 = CloudMessaging.b(charArray, a8, bArr);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", BouncyCastleProvider.PROVIDER_NAME);
        cipher.init(1, b8, new IvParameterSpec(bArr));
        R3.d dVar = new R3.d(new DeflaterOutputStream(new CipherOutputStream(byteArrayOutputStream, cipher), new Deflater(9)));
        try {
            dVar.f6413Z = 2;
            dVar.f6414x0 = true;
            dVar.k(x8);
            dVar.k(c8);
            if (2 <= dVar.f6413Z) {
                dVar.k(q8);
            }
            dVar.g(u8);
            dVar.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray.length > 2048) {
                throw new IllegalArgumentException("Payload too large: " + byteArray.length);
            }
            a aVar = new a(z7, str2, q8, x7, x8, f8, byteArray);
            c1708z0.w(aVar);
            aVar.w2();
            return false;
        } finally {
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15542c, com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("com.google.android.c2dm.permission.RECEIVE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_cloud_message_send);
        l8.u(C2541R.string.caption_to, this.toAccount);
        l8.v(this.payload, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.AuthTokenStatement
    public final InterfaceC1700x0 N0() {
        return this.fromAccount;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        String action = intent.getAction();
        if ("com.llamalab.automate.intent.action.CLOUD_MESSAGE_SENT".equals(action)) {
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        if ("com.llamalab.automate.intent.action.CLOUD_MESSAGE_ERROR".equals(action)) {
            throw ((Throwable) intent.getSerializableExtra("com.llamalab.automate.intent.extra.ERROR_CAUSE"));
        }
        return GoogleAuthorized.a(this, c1708z0, intent);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.fromAccount);
        dVar.g(this.cipherAccount);
        dVar.g(this.toAccount);
        dVar.g(this.toDevice);
        if (80 <= dVar.f6413Z) {
            dVar.g(this.highPriority);
        }
        dVar.g(this.payload);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.fromAccount);
        visitor.b(this.cipherAccount);
        visitor.b(this.toAccount);
        visitor.b(this.toDevice);
        visitor.b(this.highPriority);
        visitor.b(this.payload);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new r();
    }

    @Override // com.llamalab.automate.stmt.CloudMessaging.Statement
    public final InterfaceC1700x0 i1() {
        return this.cipherAccount;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.fromAccount = (InterfaceC1700x0) cVar.readObject();
        this.cipherAccount = (InterfaceC1700x0) cVar.readObject();
        this.toAccount = (InterfaceC1700x0) cVar.readObject();
        this.toDevice = (InterfaceC1700x0) cVar.readObject();
        if (80 <= cVar.f6409x0) {
            this.highPriority = (InterfaceC1700x0) cVar.readObject();
        }
        this.payload = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_cloud_message_send_title);
        e(c1708z0);
        return GoogleAuthorized.b(this, c1708z0, "audience:server:client_id:41295325710-fdeqcvl1hko63g9h1ln5jv7gjg6afvn8.apps.googleusercontent.com");
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
