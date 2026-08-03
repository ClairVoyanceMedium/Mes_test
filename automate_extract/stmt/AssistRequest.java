package com.llamalab.automate.stmt;

import B.C0280g;
import B.C0282i;
import android.app.KeyguardManager;
import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.llamalab.automate.C1701x1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.safs.f;
import i4.C1949c;
import java.util.Set;

@F3.f("assist_request.html")
@F3.a(C2541R.integer.ic_assistance)
@F3.i(C2541R.string.stmt_assist_request_title)
@F3.h(C2541R.string.stmt_assist_request_summary)
@F3.c(C2541R.string.caption_assist_request)
@F3.e(C2541R.layout.stmt_assist_request_edit)
/* loaded from: classes.dex */
public final class AssistRequest extends Action implements IntentStatement {
    public InterfaceC1700x0 title;
    public J3.l varActivityClassName;
    public J3.l varIntentAction;
    public J3.l varIntentCategories;
    public J3.l varIntentExtras;
    public J3.l varIntentMimeType;
    public J3.l varIntentUri;
    public J3.l varPackageName;
    public J3.l varWebUri;
    public InterfaceC1700x0 visibility;

    public static Intent q(Context context) {
        boolean isKeyguardLocked;
        boolean isKeyguardSecure;
        Intent intent = new Intent("com.llamalab.automate.intent.action.ASSIST_REQUEST_ANNOUNCE").setPackage(context.getPackageName());
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (16 <= Build.VERSION.SDK_INT) {
            isKeyguardLocked = keyguardManager.isKeyguardLocked();
            if (isKeyguardLocked) {
                intent.addCategory("com.llamalab.automate.intent.category.KEYGUARD_LOCKED");
                isKeyguardSecure = keyguardManager.isKeyguardSecure();
                if (isKeyguardSecure) {
                    intent.addCategory("com.llamalab.automate.intent.category.KEYGUARD_SECURE");
                }
            }
        } else if (keyguardManager.inKeyguardRestrictedInputMode()) {
            intent.addCategory("com.llamalab.automate.intent.category.KEYGUARD_LOCKED");
        }
        return intent;
    }

    public static IntentFilter r(String... strArr) {
        IntentFilter intentFilter = new IntentFilter("com.llamalab.automate.intent.action.ASSIST_REQUEST_ANNOUNCE");
        for (String str : strArr) {
            intentFilter.addCategory(str);
        }
        return intentFilter;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15560u} : new E3.b[]{com.llamalab.automate.access.c.f15545f};
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        Intent intent2;
        Uri webUri;
        c1708z0.H(C1701x1.class);
        Intent intent3 = (Intent) intent.getParcelableExtra("android.intent.extra.INTENT");
        if (23 > Build.VERSION.SDK_INT) {
            u(c1708z0, intent3.getStringExtra("android.intent.extra.ASSIST_PACKAGE"), null);
            s(c1708z0, null, null);
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        AssistStructure g8 = C0280g.g(intent3.getParcelableExtra("com.llamalab.automate.intent.extra.ASSIST_STRUCTURE"));
        ComponentName activityComponent = g8 != null ? g8.getActivityComponent() : null;
        if (activityComponent != null) {
            u(c1708z0, activityComponent.getPackageName(), activityComponent.getClassName());
        } else {
            u(c1708z0, intent3.getStringExtra("android.intent.extra.ASSIST_PACKAGE"), null);
        }
        AssistContent f8 = C0282i.f(intent3.getParcelableExtra("com.llamalab.automate.intent.extra.ASSIST_CONTENT"));
        if (f8 != null) {
            intent2 = f8.getIntent();
            if (intent2 != null) {
                ((C1949c) f.a.f17733a).O(intent2);
            }
            webUri = f8.getWebUri();
            s(c1708z0, intent2, webUri);
        } else {
            s(c1708z0, null, null);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (78 <= dVar.f6413Z) {
            dVar.g(this.title);
        }
        if (79 <= dVar.f6413Z) {
            dVar.g(this.visibility);
        }
        dVar.g(this.varPackageName);
        if (78 <= dVar.f6413Z) {
            dVar.g(this.varActivityClassName);
        }
        if (96 <= dVar.f6413Z) {
            dVar.g(this.varIntentAction);
            dVar.g(this.varIntentCategories);
            dVar.g(this.varIntentUri);
            dVar.g(this.varIntentMimeType);
            dVar.g(this.varIntentExtras);
            dVar.g(this.varWebUri);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.title);
        visitor.b(this.visibility);
        visitor.b(this.varPackageName);
        visitor.b(this.varActivityClassName);
        visitor.b(this.varIntentAction);
        visitor.b(this.varIntentCategories);
        visitor.b(this.varIntentUri);
        visitor.b(this.varIntentMimeType);
        visitor.b(this.varIntentExtras);
        visitor.b(this.varWebUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (78 <= cVar.f6409x0) {
            this.title = (InterfaceC1700x0) cVar.readObject();
        }
        if (79 <= cVar.f6409x0) {
            this.visibility = (InterfaceC1700x0) cVar.readObject();
        }
        this.varPackageName = (J3.l) cVar.readObject();
        if (78 <= cVar.f6409x0) {
            this.varActivityClassName = (J3.l) cVar.readObject();
        }
        if (96 <= cVar.f6409x0) {
            this.varIntentAction = (J3.l) cVar.readObject();
            this.varIntentCategories = (J3.l) cVar.readObject();
            this.varIntentUri = (J3.l) cVar.readObject();
            this.varIntentMimeType = (J3.l) cVar.readObject();
            this.varIntentExtras = (J3.l) cVar.readObject();
            this.varWebUri = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_assist_request_title);
        String x7 = J3.h.x(c1708z0, this.title, null);
        int m8 = J3.h.m(c1708z0, this.visibility, 0);
        C1701x1 c1701x1 = new C1701x1(C1701x1.s(c1708z0, "com.llamalab.automate.intent.action.ASSIST_REQUEST", x7));
        c1708z0.w(c1701x1);
        if (m8 == -1) {
            c1701x1.m(4, r(new String[0]));
        } else if (m8 != 1) {
            IntentFilter r8 = r(new String[0]);
            IntentFilter[] intentFilterArr = {r("com.llamalab.automate.intent.category.KEYGUARD_LOCKED")};
            c1701x1.m(4, r8);
            c1701x1.m(4, intentFilterArr[0]);
        } else {
            IntentFilter r9 = r(new String[0]);
            IntentFilter[] intentFilterArr2 = {r("com.llamalab.automate.intent.category.KEYGUARD_LOCKED"), r("com.llamalab.automate.intent.category.KEYGUARD_LOCKED", "com.llamalab.automate.intent.category.KEYGUARD_SECURE")};
            c1701x1.m(4, r9);
            for (int i8 = 0; i8 < 2; i8++) {
                c1701x1.m(4, intentFilterArr2[i8]);
            }
        }
        return false;
    }

    public final void s(C1708z0 c1708z0, Intent intent, Uri uri) {
        J3.l lVar = this.varIntentAction;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, intent != null ? intent.getAction() : null);
        }
        if (this.varIntentCategories != null) {
            Set<String> categories = intent != null ? intent.getCategories() : null;
            c1708z0.z(this.varIntentCategories.f4659Y, categories != null ? J3.h.E(categories) : null);
        }
        J3.l lVar2 = this.varIntentUri;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, intent != null ? intent.getDataString() : null);
        }
        J3.l lVar3 = this.varIntentMimeType;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, intent != null ? intent.getType() : null);
        }
        if (this.varIntentExtras != null) {
            Bundle extras = intent != null ? intent.getExtras() : null;
            c1708z0.z(this.varIntentExtras.f4659Y, extras != null ? J3.h.O(0, extras) : null);
        }
        J3.l lVar4 = this.varWebUri;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, uri != null ? uri.toString() : null);
        }
    }

    public final void u(C1708z0 c1708z0, String str, String str2) {
        J3.l lVar = this.varPackageName;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varActivityClassName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str2);
        }
    }
}
