package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.func.Type;
import com.llamalab.automate.stmt.CloudMessaging;
import com.llamalab.automate.work.CloudMessagingRegisterWorker;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.util.Arrays;
import java.util.zip.InflaterInputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import q.C2234i;
import x3.C2434l;
import x3.C2440r;

@F3.f("cloud_message_receive.html")
@F3.a(C2541R.integer.ic_cloud_chat_in)
@F3.i(C2541R.string.stmt_cloud_message_receive_title)
@F3.h(C2541R.string.stmt_cloud_message_receive_summary)
@F3.c(C2541R.string.caption_cloud_message_receive)
@F3.e(C2541R.layout.stmt_cloud_message_receive_edit)
/* loaded from: classes.dex */
public final class CloudMessageReceive extends Action implements CloudMessaging.Statement, ReceiverStatement {
    public InterfaceC1700x0 cipherAccount;
    public InterfaceC1700x0 toAccount;
    public J3.l varFromAccount;
    public J3.l varFromDevice;
    public J3.l varPayload;

    public static final class a extends AbstractC1618p2.b.a {

        /* renamed from: M1, reason: collision with root package name */
        public String f16461M1;

        /* renamed from: N1, reason: collision with root package name */
        public String f16462N1;

        /* renamed from: O1, reason: collision with root package name */
        public char[] f16463O1;

        public a() {
            super(MoreOsConstants.KEY_BRL_DOT4, 4000L);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #0 {all -> 0x003d, blocks: (B:2:0x0000, B:13:0x002e, B:15:0x0039, B:17:0x0014, B:20:0x001e), top: B:1:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
        @Override // com.llamalab.automate.AbstractC1618p2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(AutomateService automateService, Intent intent) {
            char c8;
            try {
                String action = intent.getAction();
                int hashCode = action.hashCode();
                if (hashCode != 234716250) {
                    if (hashCode == 807129383 && action.equals("com.llamalab.automate.intent.action.CLOUD_MESSAGES_DELETED")) {
                        c8 = 1;
                        if (c8 != 0) {
                            o(intent);
                            return;
                        } else {
                            if (c8 != 1) {
                                return;
                            }
                            F5.n.g(this, automateService.getText(C2541R.string.log_gcm_deleted_messages));
                            return;
                        }
                    }
                    c8 = 65535;
                    if (c8 != 0) {
                    }
                } else {
                    if (action.equals("com.llamalab.automate.intent.action.CLOUD_MESSAGE_RECEIVED")) {
                        c8 = 0;
                        if (c8 != 0) {
                        }
                    }
                    c8 = 65535;
                    if (c8 != 0) {
                    }
                }
            } catch (Throwable th) {
                d(th);
            }
        }

        public final void o(Intent intent) {
            int parseInt;
            String str;
            char[] cArr;
            M2.v vVar = (M2.v) intent.getParcelableExtra("com.llamalab.automate.intent.extras.REMOTE_MESSAGE");
            String str2 = (String) ((C2234i) vVar.b()).getOrDefault("version", null);
            if (str2 == null || 2 < (parseInt = Integer.parseInt(str2))) {
                F5.n.g(this, "CloudMessageReceive Received message from newer version of Automate: " + str2);
                return;
            }
            if ("MESSAGE".equals(((C2234i) vVar.b()).getOrDefault(Type.NAME, null))) {
                String str3 = (String) ((C2234i) vVar.b()).getOrDefault("data", null);
                byte[] decode = TextUtils.isEmpty(str3) ? C2434l.f23390a : Base64.decode(str3, 0);
                try {
                    synchronized (this) {
                        str = this.f16462N1;
                        cArr = this.f16463O1;
                    }
                    if (decode.length < 12) {
                        throw new EOFException("Message data too short: " + decode.length);
                    }
                    byte[] copyOfRange = Arrays.copyOfRange(decode, 0, 12);
                    SecretKey b8 = CloudMessaging.b(str.toCharArray(), cArr, copyOfRange);
                    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding", BouncyCastleProvider.PROVIDER_NAME);
                    cipher.init(2, b8, new IvParameterSpec(copyOfRange));
                    R3.c cVar = new R3.c(new InflaterInputStream(new ByteArrayInputStream(cipher.doFinal(decode, 12, decode.length - 12))));
                    try {
                        cVar.f6409x0 = parseInt;
                        cVar.f6410y0 = true;
                        String i8 = cVar.i();
                        String i9 = cVar.i();
                        String i10 = 2 <= cVar.f6409x0 ? cVar.i() : null;
                        Object readObject = cVar.readObject();
                        if (i8 == null || i8.equals(C2440r.q())) {
                            c(intent, new Object[]{i9, i10, readObject}, false);
                        }
                        cVar.close();
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
                } catch (BadPaddingException unused2) {
                }
            }
        }

        @Override // com.llamalab.automate.AbstractC1618p2.b, com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            try {
                if ("com.llamalab.automate.intent.action.CLOUD_NEW_TOKEN".equals(intent.getAction())) {
                    intent.getStringExtra("com.llamalab.automate.intent.extra.TOKEN");
                    p();
                } else {
                    super.onReceive(context, intent);
                }
            } catch (Throwable th) {
                d(th);
            }
        }

        public final void p() {
            String str;
            String str2;
            synchronized (this) {
                str = this.f16462N1;
                str2 = this.f16461M1;
            }
            CloudMessagingRegisterWorker.enqueue(w0.J.d(this.f16157Y), str2, str, C2440r.q());
            AutomateService automateService = this.f16157Y;
            String str3 = CloudMessaging.f16471a;
            automateService.getSharedPreferences("cloud-messaging-registrations-v2", 4).edit().putBoolean(str, true).apply();
        }

        public final synchronized void q(String str, String str2, char[] cArr) {
            this.f16461M1 = str;
            this.f16462N1 = str2;
            this.f16463O1 = cArr;
        }
    }

    @Override // com.llamalab.automate.stmt.AuthTokenStatement
    public final boolean B0(C1708z0 c1708z0, String str, String str2, long j8) {
        String c8 = CloudMessaging.c(str2);
        char[] a8 = CloudMessaging.a(this, c1708z0);
        SharedPreferences sharedPreferences = c1708z0.getSharedPreferences("cloud-messaging-registrations-v2", 4);
        if (!sharedPreferences.getBoolean(c8, false)) {
            CloudMessagingRegisterWorker.enqueue(w0.J.d(c1708z0), str2, c8, C2440r.q());
            sharedPreferences.edit().putBoolean(c8, true).apply();
        }
        a aVar = (a) c1708z0.d(a.class, this);
        if (aVar != null) {
            aVar.q(str2, c8, a8);
            aVar.i0();
        } else {
            a aVar2 = new a();
            synchronized (aVar2) {
                aVar2.f16461M1 = str2;
                aVar2.f16462N1 = c8;
                aVar2.f16463O1 = a8;
            }
            c1708z0.w(aVar2);
            aVar2.j("com.llamalab.automate.intent.action.CLOUD_MESSAGE_RECEIVED", "com.llamalab.automate.intent.action.CLOUD_MESSAGES_DELETED", "com.llamalab.automate.intent.action.CLOUD_NEW_TOKEN");
        }
        return false;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15542c, com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("com.google.android.c2dm.permission.RECEIVE")};
    }

    @Override // com.llamalab.automate.stmt.AuthTokenStatement
    public final InterfaceC1700x0 N0() {
        return this.toAccount;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        return GoogleAuthorized.a(this, c1708z0, intent);
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varFromAccount;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varFromDevice;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        J3.l lVar3 = this.varPayload;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, objArr[2]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.toAccount);
        dVar.g(this.cipherAccount);
        dVar.g(this.varFromAccount);
        dVar.g(this.varFromDevice);
        dVar.g(this.varPayload);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.toAccount);
        visitor.b(this.cipherAccount);
        visitor.b(this.varFromAccount);
        visitor.b(this.varFromDevice);
        visitor.b(this.varPayload);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new r();
    }

    @Override // com.llamalab.automate.stmt.CloudMessaging.Statement
    public final InterfaceC1700x0 i1() {
        return this.cipherAccount;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.toAccount = (InterfaceC1700x0) cVar.readObject();
        this.cipherAccount = (InterfaceC1700x0) cVar.readObject();
        this.varFromAccount = (J3.l) cVar.readObject();
        this.varFromDevice = (J3.l) cVar.readObject();
        this.varPayload = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_cloud_message_receive_title);
        e(c1708z0);
        return GoogleAuthorized.b(this, c1708z0, "audience:server:client_id:41295325710-fdeqcvl1hko63g9h1ln5jv7gjg6afvn8.apps.googleusercontent.com");
    }
}
