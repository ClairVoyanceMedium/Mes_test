package com.llamalab.automate.stmt;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AutomateDreamService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1692v0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.util.concurrent.atomic.AtomicBoolean;

@F3.f("dream_created.html")
@F3.a(C2541R.integer.ic_mobile_screensaver)
@F3.i(C2541R.string.stmt_dream_created_title)
@F3.h(C2541R.string.stmt_dream_created_summary)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_dream_created_edit)
/* loaded from: classes.dex */
public final class DreamCreated extends Decision implements InterfaceC1622q2, ReceiverStatement {

    /* renamed from: L1, reason: collision with root package name */
    public int f16607L1 = -1;
    public J3.l varFeatures;
    public J3.l varInterfaceUri;

    public static final class a extends AbstractC1618p2.c implements InterfaceC1692v0 {

        /* renamed from: L1, reason: collision with root package name */
        public C0171a f16608L1;

        /* renamed from: x1, reason: collision with root package name */
        public final AtomicBoolean f16609x1 = new AtomicBoolean();

        /* renamed from: y1, reason: collision with root package name */
        public final long f16610y1;

        /* renamed from: com.llamalab.automate.stmt.DreamCreated$a$a, reason: collision with other inner class name */
        public class C0171a extends ContentObserver {
            public C0171a(Handler handler) {
                super(handler);
            }

            @Override // android.database.ContentObserver
            public final void onChange(boolean z7) {
                boolean z8;
                a aVar = a.this;
                AutomateService automateService = aVar.f16157Y;
                String string = Settings.System.getString(automateService.getContentResolver(), "screensaver_components");
                if (string != null && !string.isEmpty()) {
                    for (String str : string.split(":")) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (automateService.getPackageName().equals(unflattenFromString.getPackageName()) && AutomateDreamService.class.getName().equals(unflattenFromString.getClassName())) {
                            z8 = true;
                            break;
                        }
                    }
                }
                z8 = false;
                if (z8 || !aVar.f16609x1.compareAndSet(false, true)) {
                    return;
                }
                aVar.c(new Intent(), new Object[]{Boolean.FALSE, null, null}, false);
            }
        }

        public a(long j8) {
            this.f16610y1 = j8;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            ContentResolver contentResolver = automateService.getContentResolver();
            Uri uriFor = Settings.Secure.getUriFor("screensaver_components");
            C0171a c0171a = new C0171a(automateService.f14581L1);
            this.f16608L1 = c0171a;
            contentResolver.registerContentObserver(uriFor, false, c0171a);
            AutomateDreamService.a(this);
        }

        @Override // com.llamalab.automate.AbstractC1618p2.c, com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            if (this.f16608L1 != null) {
                automateService.getContentResolver().unregisterContentObserver(this.f16608L1);
            }
            AutomateDreamService.f14534P1.remove(this);
            try {
                automateService.unregisterReceiver(this);
            } catch (Throwable unused) {
            }
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final /* synthetic */ void Q0(AutomateDreamService automateDreamService, Configuration configuration) {
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final boolean Y1(AutomateDreamService automateDreamService) {
            long j8 = automateDreamService.f14536L1;
            AtomicBoolean atomicBoolean = this.f16609x1;
            if (this.f16610y1 != j8) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    c(new Intent(), new Object[]{Boolean.FALSE, null, null}, false);
                }
                return false;
            }
            if (automateDreamService.f14538N1 || !atomicBoolean.compareAndSet(false, true)) {
                return false;
            }
            automateDreamService.f14538N1 = true;
            c(new Intent(), new Object[]{Boolean.TRUE, String.valueOf(automateDreamService.f14546y1), Double.valueOf(automateDreamService.b() ? 1.0d : 0.0d)}, false);
            return true;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.getClass();
            if (action.equals("com.llamalab.automate.intent.action.DREAM_SETTINGS_CHANGED") && this.f16609x1.compareAndSet(false, true)) {
                c(intent, new Object[]{Boolean.FALSE, null, null}, false);
            }
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final /* synthetic */ void t0() {
        }
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        if (objArr[1] != null) {
            objArr[1] = Y.c(c1708z0.getContentResolver(), c1708z0.f17641Z, 4, (String) objArr[1]).toString();
        }
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        String str = (String) objArr[1];
        Double d8 = (Double) objArr[2];
        J3.l lVar = this.varInterfaceUri;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varFeatures;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d8);
        }
        o(c1708z0, booleanValue);
        return true;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varInterfaceUri);
        dVar.g(this.varFeatures);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varInterfaceUri);
        visitor.b(this.varFeatures);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f16607L1 = c1625r2.d(true);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varInterfaceUri = (J3.l) cVar.readObject();
        this.varFeatures = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_dream_created_title);
        IncapableAndroidVersionException.a(17);
        Long l8 = (Long) c1708z0.j(this.f16607L1);
        if (l8 == null) {
            l8 = Long.valueOf(c1708z0.f17644y0);
            c1708z0.z(this.f16607L1, l8);
        }
        a aVar = new a(l8.longValue());
        c1708z0.w(aVar);
        aVar.o(4, "com.llamalab.automate.intent.action.DREAM_SETTINGS_CHANGED");
        return false;
    }
}
