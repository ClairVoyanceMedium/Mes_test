package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import com.llamalab.safs.f;
import i4.AbstractC1948b;
import i4.C1949c;
import java.util.Iterator;
import x3.C2440r;

@F3.f("storage_media_mounted.html")
@F3.a(C2541R.integer.ic_device_access_sd_storage)
@F3.i(C2541R.string.stmt_storage_media_mounted_title)
@F3.h(C2541R.string.stmt_storage_media_mounted_summary)
@F3.e(C2541R.layout.stmt_storage_media_mounted_edit)
/* loaded from: classes.dex */
public final class StorageMediaMounted extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 path;
    public J3.l varMountPath;
    public InterfaceC1700x0 writable;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final String f17165x1;

        /* renamed from: y1, reason: collision with root package name */
        public final boolean f17166y1;

        public a(String str, boolean z7) {
            this.f17165x1 = str;
            this.f17166y1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String path;
            Uri data = intent.getData();
            if (data == null || (path = data.getPath()) == null || !C2440r.v(this.f17165x1, path)) {
                return;
            }
            c(intent, new Object[]{Boolean.valueOf("android.intent.action.MEDIA_MOUNTED".equals(intent.getAction()) && !(this.f17166y1 && intent.getBooleanExtra("read-only", false))), path}, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_storage_media_mounted_immediate, C2541R.string.caption_storage_media_mounted_change);
        C1596k0 y7 = c1596k0.y(this.writable, C2541R.string.caption_writable, 0);
        y7.t(this.path);
        return y7.q(this.path).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        String str = (String) objArr[1];
        J3.l lVar = this.varMountPath;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        o(c1708z0, booleanValue);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (72 <= dVar.f6413Z) {
            dVar.g(this.path);
        }
        dVar.g(this.writable);
        dVar.g(this.varMountPath);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.path);
        visitor.b(this.writable);
        visitor.b(this.varMountPath);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (72 <= cVar.f6409x0) {
            this.path = (InterfaceC1700x0) cVar.readObject();
        }
        this.writable = (InterfaceC1700x0) cVar.readObject();
        this.varMountPath = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        AbstractC1948b abstractC1948b;
        String obj;
        c1708z0.q(C2541R.string.stmt_storage_media_mounted_title);
        String x7 = J3.h.x(c1708z0, this.path, Environment.getExternalStorageDirectory().toString());
        boolean f8 = J3.h.f(c1708z0, this.writable, false);
        if (J1(1) != 0) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addDataScheme("file");
            a aVar = new a(x7, f8);
            c1708z0.w(aVar);
            aVar.q(intentFilter);
            return false;
        }
        Iterator<AbstractC1948b> it = ((C1949c) f.a.f17733a).t().iterator();
        do {
            com.llamalab.safs.internal.n nVar = (com.llamalab.safs.internal.n) it;
            if (!nVar.hasNext()) {
                o(c1708z0, false);
                return true;
            }
            abstractC1948b = (AbstractC1948b) nVar.next();
            obj = abstractC1948b.d().toString();
        } while (!C2440r.v(x7, obj));
        String f9 = abstractC1948b.f();
        boolean z7 = "mounted".equals(f9) || "mounted_ro".equals(f9);
        J3.l lVar = this.varMountPath;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        o(c1708z0, z7);
        return true;
    }
}
