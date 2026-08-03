package com.llamalab.automate.stmt;

import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ComponentPickActivity;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import x3.C2434l;
import x3.C2440r;

@F3.a(C2541R.integer.ic_app_target)
/* loaded from: classes.dex */
public abstract class ResolveComponentDecision extends IntermittentActivityDecision {
    public InterfaceC1700x0 action;
    public InterfaceC1700x0 categories;
    public InterfaceC1700x0 className;
    public InterfaceC1700x0 mimeType;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 uri;
    public J3.l varDisplayName;
    public J3.l varResolvedClassName;
    public J3.l varResolvedPackageName;

    public final void E(C1708z0 c1708z0, boolean z7, ComponentInfo componentInfo) {
        J3.l lVar = this.varResolvedPackageName;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, componentInfo != null ? componentInfo.applicationInfo.packageName : null);
        }
        J3.l lVar2 = this.varResolvedClassName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, componentInfo != null ? componentInfo.name : null);
        }
        J3.l lVar3 = this.varDisplayName;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, componentInfo != null ? componentInfo.loadLabel(c1708z0.getPackageManager()).toString() : null);
        }
        o(c1708z0, z7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e8, code lost:
    
        if (r2.size() == 1) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean F(C1708z0 c1708z0, CharSequence charSequence) {
        Intent putExtra;
        char f8;
        int G7 = G();
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        String x8 = J3.h.x(c1708z0, this.className, null);
        String x9 = J3.h.x(c1708z0, this.action, null);
        String x10 = J3.h.x(c1708z0, this.uri, null);
        String x11 = J3.h.x(c1708z0, this.mimeType, null);
        J3.a e8 = J3.h.e(c1708z0, this.categories);
        if (x7 != null || x9 != null || x10 != null || x11 != null || e8 != null) {
            Intent intent = new Intent();
            if (x7 != null && x8 != null) {
                intent.setClassName(x7, x8);
            } else if (x7 != null) {
                intent.setPackage(x7);
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
                int i8 = 0;
                while (true) {
                    if (!(i8 < e8.f4627Y)) {
                        break;
                    }
                    if (i8 >= e8.f4627Y) {
                        throw new NoSuchElementException();
                    }
                    intent.addCategory(J3.h.e0(e8.get(i8)));
                    i8++;
                }
            }
            List B7 = C2440r.B(c1708z0.getPackageManager(), G7, intent);
            if (B7 == null) {
                B7 = Collections.emptyList();
            }
            int J12 = J1(1);
            if (J12 != 0) {
                if (J12 == 2) {
                    if (B7.isEmpty()) {
                        E(c1708z0, false, null);
                        return true;
                    }
                }
                putExtra = new Intent(c1708z0, (Class<?>) ComponentPickActivity.class).putExtra("com.llamalab.automate.intent.extra.COMPONENT_TYPE", G7).putExtra("com.llamalab.automate.intent.extra.RESOLVES", (Parcelable[]) B7.toArray(C2434l.f23399j));
                f8 = c1708z0.f(C2541R.integer.ic_app_target);
            } else if (B7.isEmpty()) {
                E(c1708z0, false, null);
                return true;
            }
            E(c1708z0, true, C2440r.p((ResolveInfo) B7.get(0), G7));
            return true;
        }
        if (G7 != 1 && G7 != 2 && G7 != 4) {
            throw new IllegalArgumentException("componentType");
        }
        if (J1(1) == 0) {
            E(c1708z0, false, null);
            return true;
        }
        putExtra = new Intent(c1708z0, (Class<?>) ComponentPickActivity.class).putExtra("com.llamalab.automate.intent.extra.COMPONENT_TYPE", G7);
        f8 = c1708z0.f(C2541R.integer.ic_app_target);
        c1708z0.D(putExtra, null, this, f8, charSequence);
        return false;
    }

    public abstract int G();

    @Override // com.llamalab.automate.stmt.IntermittentActivityDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        dVar.g(this.className);
        dVar.g(this.action);
        dVar.g(this.uri);
        dVar.g(this.mimeType);
        dVar.g(this.categories);
        dVar.g(this.varResolvedPackageName);
        dVar.g(this.varResolvedClassName);
        dVar.g(this.varDisplayName);
    }

    @Override // com.llamalab.automate.stmt.IntermittentActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.packageName);
        visitor.b(this.className);
        visitor.b(this.action);
        visitor.b(this.uri);
        visitor.b(this.mimeType);
        visitor.b(this.categories);
        visitor.b(this.varResolvedPackageName);
        visitor.b(this.varResolvedClassName);
        visitor.b(this.varDisplayName);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        int G7 = G();
        int i8 = O0.f17007P1;
        return (O0) ViewOnClickListenerC1667s.x(O0.class, G7, null);
    }

    @Override // com.llamalab.automate.stmt.IntermittentActivityDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.className = (InterfaceC1700x0) cVar.readObject();
        this.action = (InterfaceC1700x0) cVar.readObject();
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.mimeType = (InterfaceC1700x0) cVar.readObject();
        this.categories = (InterfaceC1700x0) cVar.readObject();
        this.varResolvedPackageName = (J3.l) cVar.readObject();
        this.varResolvedClassName = (J3.l) cVar.readObject();
        this.varDisplayName = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 == i8) {
            E(c1708z0, true, (ComponentInfo) intent.getParcelableExtra("com.llamalab.automate.intent.extra.COMPONENT"));
        } else {
            E(c1708z0, false, null);
        }
    }
}
