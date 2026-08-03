package com.llamalab.automate.stmt;

import android.content.Intent;
import android.net.Uri;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class IntentAction extends Action {
    public InterfaceC1700x0 action;
    public InterfaceC1700x0 categories;
    public InterfaceC1700x0 className;
    public InterfaceC1700x0 extras;
    public InterfaceC1700x0 flags;
    public InterfaceC1700x0 mimeType;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 uri;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        s(dVar, 73);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.packageName);
        visitor.b(this.className);
        visitor.b(this.action);
        visitor.b(this.uri);
        visitor.b(this.mimeType);
        visitor.b(this.categories);
        visitor.b(this.extras);
        visitor.b(this.flags);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        r(cVar, 73);
    }

    public final Intent q(int i8, C1708z0 c1708z0, boolean z7) {
        Intent intent;
        String str = null;
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        String x8 = J3.h.x(c1708z0, this.className, null);
        String x9 = J3.h.x(c1708z0, this.action, null);
        String x10 = J3.h.x(c1708z0, this.uri, null);
        String x11 = J3.h.x(c1708z0, this.mimeType, null);
        J3.a e8 = J3.h.e(c1708z0, this.categories);
        J3.e h8 = J3.h.h(c1708z0, this.extras);
        int m8 = J3.h.m(c1708z0, this.flags, 0);
        if (!z7 || x7 == null || x8 != null || x9 != null || x10 != null || x11 != null || (intent = c1708z0.getPackageManager().getLaunchIntentForPackage(x7)) == null) {
            intent = new Intent();
            str = x7;
        }
        if (str != null && x8 != null) {
            intent.setClassName(str, x8);
        } else if (str != null) {
            intent.setPackage(str);
        }
        if (x9 != null) {
            intent.setAction(x9);
        }
        if (x10 != null && x11 != null) {
            intent.setDataAndType(Uri.parse(x10), x11);
        } else if (x10 != null) {
            intent.setData(Uri.parse(x10));
        } else if (x11 != null) {
            intent.setType(x11);
        }
        if (e8 != null) {
            int i9 = 0;
            while (true) {
                if (!(i9 < e8.f4627Y)) {
                    break;
                }
                if (i9 >= e8.f4627Y) {
                    throw new NoSuchElementException();
                }
                intent.addCategory(J3.h.e0(e8.get(i9)));
                i9++;
            }
        }
        if (h8 != null) {
            intent.putExtras(J3.h.K(h8));
        }
        intent.addFlags(i8 & m8);
        return intent;
    }

    public final void r(R3.c cVar, int i8) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.className = (InterfaceC1700x0) cVar.readObject();
        this.action = (InterfaceC1700x0) cVar.readObject();
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.mimeType = (InterfaceC1700x0) cVar.readObject();
        this.categories = (InterfaceC1700x0) cVar.readObject();
        this.extras = (InterfaceC1700x0) cVar.readObject();
        if (i8 <= cVar.f6409x0) {
            this.flags = (InterfaceC1700x0) cVar.readObject();
        }
    }

    public final void s(R3.d dVar, int i8) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        dVar.g(this.className);
        dVar.g(this.action);
        dVar.g(this.uri);
        dVar.g(this.mimeType);
        dVar.g(this.categories);
        dVar.g(this.extras);
        if (i8 <= dVar.f6413Z) {
            dVar.g(this.flags);
        }
    }
}
