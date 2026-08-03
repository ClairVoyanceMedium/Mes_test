package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.N2;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.safs.f;
import i4.C1949c;
import java.util.NoSuchElementException;
import java.util.Set;
import x3.C2440r;

@F3.f("broadcast_receive.html")
@F3.a(C2541R.integer.ic_app_receive)
@F3.i(C2541R.string.stmt_broadcast_receive_title)
@F3.h(C2541R.string.stmt_broadcast_receive_summary)
@F3.e(C2541R.layout.stmt_broadcast_receive_edit)
/* loaded from: classes.dex */
public final class BroadcastReceive extends Action implements ReceiverStatement {
    public InterfaceC1700x0 action;
    public InterfaceC1700x0 categories;
    public InterfaceC1700x0 mimeType;
    public InterfaceC1700x0 uriAuthority;
    public InterfaceC1700x0 uriPath;
    public InterfaceC1700x0 uriScheme;
    public InterfaceC1700x0 useSticky;
    public J3.l varBroadcastAction;
    public J3.l varBroadcastCategories;
    public J3.l varBroadcastExtras;
    public J3.l varBroadcastMimeType;
    public J3.l varBroadcastUri;

    public interface a extends N2 {
        IntentFilter getFilter();

        AbstractC1618p2.b i0();
    }

    public static final class b extends AbstractC1618p2.b.a implements a {

        /* renamed from: M1, reason: collision with root package name */
        public IntentFilter f16388M1;

        public b() {
            super(512, 1000L);
        }

        @Override // com.llamalab.automate.AbstractC1618p2.b.a, com.llamalab.automate.AbstractC1618p2
        public final AbstractC1618p2 f(IntentFilter intentFilter) {
            this.f16388M1 = intentFilter;
            super.f(intentFilter);
            return this;
        }

        @Override // com.llamalab.automate.stmt.BroadcastReceive.a
        public final IntentFilter getFilter() {
            return this.f16388M1;
        }

        @Override // com.llamalab.automate.AbstractC1618p2.b.a
        /* renamed from: m */
        public final AbstractC1618p2.b.a f(IntentFilter intentFilter) {
            this.f16388M1 = intentFilter;
            super.f(intentFilter);
            return this;
        }
    }

    public static final class c extends AbstractC1618p2.b.C0164b.a implements a {

        /* renamed from: M1, reason: collision with root package name */
        public IntentFilter f16389M1;

        @Override // com.llamalab.automate.AbstractC1618p2.b.C0164b, com.llamalab.automate.AbstractC1618p2
        public final /* bridge */ /* synthetic */ AbstractC1618p2 f(IntentFilter intentFilter) {
            f(intentFilter);
            return this;
        }

        @Override // com.llamalab.automate.stmt.BroadcastReceive.a
        public final IntentFilter getFilter() {
            return this.f16389M1;
        }

        @Override // com.llamalab.automate.AbstractC1618p2.b.C0164b
        /* renamed from: m */
        public final AbstractC1618p2.b.C0164b f(IntentFilter intentFilter) {
            this.f16389M1 = intentFilter;
            this.f16161L1 = true;
            D.c.j(this.f16157Y, this, intentFilter, 2);
            return this;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_broadcast_receive).o(-1, this.action).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        r(c1708z0, intent);
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.action);
        dVar.g(this.categories);
        dVar.g(this.uriScheme);
        dVar.g(this.uriAuthority);
        dVar.g(this.uriPath);
        dVar.g(this.mimeType);
        dVar.g(this.useSticky);
        dVar.g(this.varBroadcastAction);
        dVar.g(this.varBroadcastCategories);
        dVar.g(this.varBroadcastUri);
        dVar.g(this.varBroadcastMimeType);
        dVar.g(this.varBroadcastExtras);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.action);
        visitor.b(this.categories);
        visitor.b(this.uriScheme);
        visitor.b(this.uriAuthority);
        visitor.b(this.uriPath);
        visitor.b(this.mimeType);
        visitor.b(this.useSticky);
        visitor.b(this.varBroadcastAction);
        visitor.b(this.varBroadcastCategories);
        visitor.b(this.varBroadcastUri);
        visitor.b(this.varBroadcastMimeType);
        visitor.b(this.varBroadcastExtras);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.action = (InterfaceC1700x0) cVar.readObject();
        this.categories = (InterfaceC1700x0) cVar.readObject();
        this.uriScheme = (InterfaceC1700x0) cVar.readObject();
        this.uriAuthority = (InterfaceC1700x0) cVar.readObject();
        this.uriPath = (InterfaceC1700x0) cVar.readObject();
        this.mimeType = (InterfaceC1700x0) cVar.readObject();
        this.useSticky = (InterfaceC1700x0) cVar.readObject();
        this.varBroadcastAction = (J3.l) cVar.readObject();
        this.varBroadcastCategories = (J3.l) cVar.readObject();
        this.varBroadcastUri = (J3.l) cVar.readObject();
        this.varBroadcastMimeType = (J3.l) cVar.readObject();
        this.varBroadcastExtras = (J3.l) cVar.readObject();
    }

    public final void q(C1708z0 c1708z0, IntentFilter intentFilter) {
        b bVar;
        a aVar = (a) c1708z0.d(a.class, this);
        if (aVar == null) {
            bVar = new b();
        } else if (C2440r.i(aVar.getFilter(), intentFilter)) {
            aVar.i0();
            return;
        } else {
            aVar.a();
            bVar = new b();
        }
        c1708z0.w(bVar);
        bVar.f(intentFilter);
    }

    public final void r(C1708z0 c1708z0, Intent intent) {
        if (19 <= Build.VERSION.SDK_INT) {
            ((C1949c) f.a.f17733a).O(intent);
        }
        J3.l lVar = this.varBroadcastAction;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, intent.getAction());
        }
        if (this.varBroadcastCategories != null) {
            Set<String> categories = intent.getCategories();
            c1708z0.z(this.varBroadcastCategories.f4659Y, categories != null ? J3.h.E(categories) : null);
        }
        J3.l lVar2 = this.varBroadcastUri;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, intent.getDataString());
        }
        J3.l lVar3 = this.varBroadcastMimeType;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, intent.getType());
        }
        if (this.varBroadcastExtras != null) {
            Bundle extras = intent.getExtras();
            c1708z0.z(this.varBroadcastExtras.f4659Y, extras != null ? J3.h.O(0, extras) : null);
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        IntentFilter intentFilter;
        J3.a e8;
        String x7;
        c cVar;
        Intent j8;
        c1708z0.q(C2541R.string.stmt_broadcast_receive_title);
        String x8 = J3.h.x(c1708z0, this.action, null);
        if (x8 == null) {
            throw new RequiredArgumentNullException("action");
        }
        intentFilter = new IntentFilter(x8);
        e8 = J3.h.e(c1708z0, this.categories);
        if (e8 != null) {
            int i8 = 0;
            while (true) {
                if (!(i8 < e8.f4627Y)) {
                    break;
                }
                if (i8 >= e8.f4627Y) {
                    throw new NoSuchElementException();
                }
                intentFilter.addCategory(J3.h.e0(e8.get(i8)));
                i8++;
            }
        }
        String x9 = J3.h.x(c1708z0, this.mimeType, null);
        if (x9 != null) {
            intentFilter.addDataType(x9);
        }
        x7 = J3.h.x(c1708z0, this.uriScheme, null);
        if (x7 != null) {
            intentFilter.addDataScheme(x7);
        }
        String x10 = J3.h.x(c1708z0, this.uriAuthority, null);
        if (x10 != null) {
            intentFilter.addDataAuthority(x10, null);
        }
        String x11 = J3.h.x(c1708z0, this.uriPath, null);
        if (x11 != null) {
            intentFilter.addDataPath(x11, 2);
        }
        switch (x8) {
            case "android.intent.action.VIEW":
                if ("automate".equals(x7) && e8 != null && e8.contains("android.intent.category.BROWSABLE")) {
                    q(c1708z0, intentFilter);
                    return false;
                }
                break;
            case "com.llamalab.automate.intent.action.SERVICE_STARTED":
            case "android.intent.action.BOOT_COMPLETED":
            case "android.intent.action.MY_PACKAGE_REPLACED":
                q(c1708z0, intentFilter);
                return false;
        }
        if (J3.h.f(c1708z0, this.useSticky, false) && (j8 = D.c.j(c1708z0, null, intentFilter, 2)) != null) {
            r(c1708z0, j8);
            return true;
        }
        a aVar = (a) c1708z0.d(a.class, this);
        if (aVar == null) {
            cVar = new c();
        } else {
            if (C2440r.i(aVar.getFilter(), intentFilter)) {
                aVar.i0();
                return false;
            }
            aVar.a();
            cVar = new c();
        }
        c1708z0.w(cVar);
        cVar.f(intentFilter);
        return false;
    }
}
