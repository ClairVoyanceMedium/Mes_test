package com.llamalab.automate.stmt;

import L3.C1053s;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.field.ExpressionField;
import com.llamalab.automate.field.MultiChoiceFlagsExprField;
import com.llamalab.automate.field.SpinnerExprField;
import com.llamalab.automate.field.TextExprField;
import com.llamalab.automate.stmt.V0;
import java.util.Set;

/* renamed from: com.llamalab.automate.stmt.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1636c extends ViewOnClickListenerC1667s implements V0.a {

    /* renamed from: N1, reason: collision with root package name */
    public SpinnerExprField f17346N1;

    /* renamed from: O1, reason: collision with root package name */
    public TextExprField f17347O1;

    /* renamed from: P1, reason: collision with root package name */
    public TextExprField f17348P1;

    /* renamed from: Q1, reason: collision with root package name */
    public SpinnerExprField f17349Q1;

    /* renamed from: R1, reason: collision with root package name */
    public ExpressionField f17350R1;

    /* renamed from: S1, reason: collision with root package name */
    public MultiChoiceFlagsExprField f17351S1;

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c2  */
    @Override // com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onActivityResult(int i8, int i9, Intent intent) {
        String str;
        String str2;
        L3.F f8;
        if (i8 != 1) {
            super.onActivityResult(i8, i9, intent);
            return;
        }
        if (-1 != i9 || intent == null) {
            return;
        }
        Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        if (intent2 == null) {
            Toast.makeText(getContext(), C2541R.string.error_not_available, 0).show();
            return;
        }
        ComponentName component = intent2.getComponent();
        if (component != null) {
            str = component.getPackageName();
            str2 = component.getClassName();
        } else {
            str = intent2.getPackage();
            str2 = null;
        }
        this.f17515L1.setValue((InterfaceC1700x0) L3.W.b(str));
        this.f17516M1.setValue((InterfaceC1700x0) L3.W.b(str2));
        this.f17346N1.setValue((InterfaceC1700x0) L3.W.b(intent2.getAction()));
        this.f17347O1.setValue((InterfaceC1700x0) L3.W.b(intent2.getDataString()));
        this.f17348P1.setValue((InterfaceC1700x0) L3.W.b(intent2.getType()));
        SpinnerExprField spinnerExprField = this.f17349Q1;
        Set<String> categories = intent2.getCategories();
        spinnerExprField.setValue((categories == null || categories.isEmpty()) ? null : categories.size() == 1 ? L3.W.b(categories.iterator().next()) : L3.E.b(categories));
        ExpressionField expressionField = this.f17350R1;
        Bundle extras = intent2.getExtras();
        if (extras != null && !extras.isEmpty()) {
            J3.e O7 = J3.h.O(1, extras);
            if (!O7.isEmpty()) {
                f8 = L3.F.b(O7);
                expressionField.setValue((InterfaceC1700x0) f8);
                MultiChoiceFlagsExprField multiChoiceFlagsExprField = this.f17351S1;
                int flags = intent2.getFlags() & 1823209175;
                multiChoiceFlagsExprField.setValue((InterfaceC1700x0) (flags != 0 ? new C1053s(flags) : null));
            }
        }
        f8 = null;
        expressionField.setValue((InterfaceC1700x0) f8);
        MultiChoiceFlagsExprField multiChoiceFlagsExprField2 = this.f17351S1;
        int flags2 = intent2.getFlags() & 1823209175;
        multiChoiceFlagsExprField2.setValue((InterfaceC1700x0) (flags2 != 0 ? new C1053s(flags2) : null));
    }

    @Override // com.llamalab.automate.stmt.ViewOnClickListenerC1667s, android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != C2541R.id.pick_shortcut) {
            super.onClick(view);
        } else {
            new V0().A(getChildFragmentManager());
        }
    }

    @Override // com.llamalab.automate.stmt.ViewOnClickListenerC1667s, com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f17346N1 = (SpinnerExprField) view.findViewById(C2541R.id.action);
        this.f17347O1 = (TextExprField) view.findViewById(C2541R.id.uri);
        this.f17348P1 = (TextExprField) view.findViewById(C2541R.id.mime_type);
        this.f17349Q1 = (SpinnerExprField) view.findViewById(C2541R.id.categories);
        this.f17350R1 = (ExpressionField) view.findViewById(C2541R.id.extras);
        this.f17351S1 = (MultiChoiceFlagsExprField) view.findViewById(C2541R.id.flags);
        ((Button) view.findViewById(C2541R.id.pick_shortcut)).setOnClickListener(this);
    }

    @Override // com.llamalab.automate.stmt.V0.a
    public final void q(ActivityInfo activityInfo) {
        Intent className = new Intent("android.intent.action.CREATE_SHORTCUT").setClassName(activityInfo.packageName, activityInfo.name);
        try {
            startActivityForResult(className, 1);
        } catch (SecurityException e8) {
            Log.w("ActivityStartFragment", "Failed to start " + className, e8);
            Toast.makeText(getContext(), C2541R.string.error_permission_denied, 0).show();
        }
    }
}
