package com.llamalab.automate.stmt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ShortcutInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import com.llamalab.automate.A2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.stmt.V0;

/* loaded from: classes.dex */
public class W0 extends C2 implements View.OnClickListener, View.OnLongClickListener, V0.a {

    /* renamed from: M1, reason: collision with root package name */
    public static final /* synthetic */ int f17249M1 = 0;

    /* renamed from: L1, reason: collision with root package name */
    public final a f17250L1 = new a();

    /* renamed from: y1, reason: collision with root package name */
    public TextInputLayout f17251y1;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            int i8 = W0.f17249M1;
            W0.this.w(intent);
        }
    }

    @Override // com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 1) {
            super.onActivityResult(i8, i9, intent);
        } else {
            if (-1 != i9 || intent == null) {
                return;
            }
            w(intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != C2541R.id.pick_shortcut) {
            return;
        }
        new V0().A(getChildFragmentManager());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        getContext().unregisterReceiver(this.f17250L1);
        super.onDestroy();
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (view.getId() != C2541R.id.pick_shortcut) {
            return false;
        }
        ShortcutStart shortcutStart = (ShortcutStart) this.f14763y0;
        if (shortcutStart != null) {
            shortcutStart.intent = null;
            shortcutStart.label = null;
        }
        this.f17251y1.getEditText().setText((CharSequence) null);
        this.f17251y1.setVisibility(TextUtils.isEmpty(null) ? 8 : 0);
        return true;
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f17251y1 = (TextInputLayout) view.findViewById(C2541R.id.label_layout);
        Button button = (Button) view.findViewById(C2541R.id.pick_shortcut);
        button.setOnClickListener(this);
        button.setOnLongClickListener(this);
        D.c.k(getContext(), this.f17250L1, new IntentFilter("com.android.launcher.action.INSTALL_SHORTCUT"), "com.android.launcher.permission.INSTALL_SHORTCUT", null, 2);
    }

    @Override // com.llamalab.automate.stmt.V0.a
    public final void q(ActivityInfo activityInfo) {
        Intent className = new Intent("android.intent.action.CREATE_SHORTCUT").setClassName(activityInfo.packageName, activityInfo.name);
        try {
            startActivityForResult(className, 1);
        } catch (SecurityException e8) {
            Log.w("ShortcutFragment", "Failed to start " + className, e8);
            Toast.makeText(getContext(), C2541R.string.error_permission_denied, 0).show();
        }
    }

    @Override // com.llamalab.automate.C2
    public final void u(A2 a22, com.llamalab.automate.F0 f02) {
        super.u(a22, f02);
        String str = ((ShortcutStart) a22).label;
        this.f17251y1.getEditText().setText(str);
        this.f17251y1.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        r0 = r0.getShortcutInfo();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        r1 = r0.getIntent();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w(Intent intent) {
        ShortcutInfo shortcutInfo;
        Intent intent2;
        CharSequence shortLabel;
        if (26 <= Build.VERSION.SDK_INT && (r0 = B.b0.i(intent.getParcelableExtra("android.content.pm.extra.PIN_ITEM_REQUEST"))) != null && shortcutInfo != null && intent2 != null) {
            shortLabel = shortcutInfo.getShortLabel();
            String charSequence = shortLabel != null ? shortLabel.toString() : null;
            ShortcutStart shortcutStart = (ShortcutStart) this.f14763y0;
            if (shortcutStart != null) {
                shortcutStart.intent = intent2;
                shortcutStart.label = charSequence;
            }
            this.f17251y1.getEditText().setText(charSequence);
            this.f17251y1.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
            return;
        }
        Intent intent3 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        if (intent3 != null) {
            String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
            ShortcutStart shortcutStart2 = (ShortcutStart) this.f14763y0;
            if (shortcutStart2 != null) {
                shortcutStart2.intent = intent3;
                shortcutStart2.label = stringExtra;
            }
            this.f17251y1.getEditText().setText(stringExtra);
            this.f17251y1.setVisibility(TextUtils.isEmpty(stringExtra) ? 8 : 0);
        }
    }
}
