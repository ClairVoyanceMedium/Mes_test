package com.llamalab.automate.stmt;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@F3.f("preferred_activity.html")
@F3.a(C2541R.integer.ic_app_target)
@F3.i(C2541R.string.stmt_preferred_activity_title)
@F3.h(C2541R.string.stmt_preferred_activity_summary)
@F3.e(C2541R.layout.stmt_preferred_activity_edit)
/* loaded from: classes.dex */
public final class PreferredActivity extends Decision {
    public InterfaceC1700x0 action;
    public InterfaceC1700x0 categories;
    public InterfaceC1700x0 className;
    public InterfaceC1700x0 mimeType;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 uri;
    public J3.l varDisplayName;
    public J3.l varPreferredClassName;
    public J3.l varPreferredPackageName;

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        dVar.g(this.className);
        dVar.g(this.action);
        dVar.g(this.uri);
        dVar.g(this.mimeType);
        dVar.g(this.categories);
        dVar.g(this.varPreferredPackageName);
        dVar.g(this.varPreferredClassName);
        dVar.g(this.varDisplayName);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.packageName);
        visitor.b(this.className);
        visitor.b(this.action);
        visitor.b(this.uri);
        visitor.b(this.mimeType);
        visitor.b(this.categories);
        visitor.b(this.varPreferredPackageName);
        visitor.b(this.varPreferredClassName);
        visitor.b(this.varDisplayName);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return ViewOnClickListenerC1667s.w(null, 1);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.className = (InterfaceC1700x0) cVar.readObject();
        this.action = (InterfaceC1700x0) cVar.readObject();
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.mimeType = (InterfaceC1700x0) cVar.readObject();
        this.categories = (InterfaceC1700x0) cVar.readObject();
        this.varPreferredPackageName = (J3.l) cVar.readObject();
        this.varPreferredClassName = (J3.l) cVar.readObject();
        this.varDisplayName = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_preferred_activity_title);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        String x8 = J3.h.x(c1708z0, this.className, null);
        String x9 = J3.h.x(c1708z0, this.action, null);
        String x10 = J3.h.x(c1708z0, this.uri, null);
        String x11 = J3.h.x(c1708z0, this.mimeType, null);
        J3.a e8 = J3.h.e(c1708z0, this.categories);
        ContentResolver contentResolver = c1708z0.getContentResolver();
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
            Uri parse = Uri.parse(x10);
            intent.setDataAndType(parse, contentResolver.getType(parse));
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
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        c1708z0.getPackageManager().getPreferredActivities(arrayList, arrayList2, x7);
        int size = arrayList.size();
        ComponentName componentName = null;
        for (int i9 = 0; i9 < size; i9++) {
            if (((IntentFilter) arrayList.get(i9)).match(contentResolver, intent, false, "PreferredActivity") >= 0) {
                if (componentName == null) {
                    componentName = (ComponentName) arrayList2.get(i9);
                } else if (!componentName.equals(arrayList2.get(i9))) {
                    w(c1708z0, false, null);
                    return true;
                }
            }
        }
        w(c1708z0, componentName != null, componentName);
        return true;
    }

    public final void w(C1708z0 c1708z0, boolean z7, ComponentName componentName) {
        PackageManager packageManager;
        ResolveInfo resolveActivity;
        J3.l lVar = this.varPreferredPackageName;
        String str = null;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, componentName != null ? componentName.getPackageName() : null);
        }
        J3.l lVar2 = this.varPreferredClassName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, componentName != null ? componentName.getClassName() : null);
        }
        if (this.varDisplayName != null) {
            if (componentName != null && (resolveActivity = (packageManager = c1708z0.getPackageManager()).resolveActivity(new Intent().setComponent(componentName), 0)) != null) {
                str = resolveActivity.loadLabel(packageManager).toString();
            }
            c1708z0.z(this.varDisplayName.f4659Y, str);
        }
        o(c1708z0, z7);
    }
}
