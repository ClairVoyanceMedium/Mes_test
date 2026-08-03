package com.llamalab.automate.stmt;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import com.llamalab.android.widget.GenericInputLayout;
import com.llamalab.automate.A2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.field.EditVariable;
import com.llamalab.automate.stmt.C0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import x3.C2434l;

/* loaded from: classes.dex */
public abstract class B0<T extends C0> extends C2 implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: X1, reason: collision with root package name */
    public static final Pattern f16312X1 = Pattern.compile("%?(\\w+)([^\n]+)?(?:\n([^\n]+))?.*", 32);

    /* renamed from: L1, reason: collision with root package name */
    public GenericInputLayout f16313L1;

    /* renamed from: M1, reason: collision with root package name */
    public Button f16314M1;

    /* renamed from: N1, reason: collision with root package name */
    public Button f16315N1;

    /* renamed from: O1, reason: collision with root package name */
    public ViewGroup f16316O1;

    /* renamed from: P1, reason: collision with root package name */
    public TextView f16317P1;

    /* renamed from: Q1, reason: collision with root package name */
    public ViewGroup f16318Q1;

    /* renamed from: R1, reason: collision with root package name */
    public CheckBox f16319R1;

    /* renamed from: S1, reason: collision with root package name */
    public String f16320S1;

    /* renamed from: T1, reason: collision with root package name */
    public String f16321T1;
    public Bundle U1;

    /* renamed from: V1, reason: collision with root package name */
    public String[] f16322V1 = C2434l.f23396g;
    public String W1;

    /* renamed from: y1, reason: collision with root package name */
    public PackageManager f16323y1;

    public static String[] D(Object obj) {
        return obj instanceof String[] ? (String[]) obj : obj instanceof String ? new String[]{(String) obj} : C2434l.f23396g;
    }

    public void A(Intent intent) {
        String[] strArr;
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras == null) {
            extras = new Bundle();
        }
        Bundle bundle = extras.getBundle("com.twofortyfouram.locale.intent.extra.BUNDLE");
        this.U1 = bundle;
        if (bundle == null) {
            this.U1 = extras;
        }
        String string = extras.getString("com.twofortyfouram.locale.intent.extra.BLURB");
        if (string == null) {
            string = this.U1.getString("com.twofortyfouram.locale.intent.extra.BLURB");
        }
        E(string);
        String[] D7 = D(this.U1.get("net.dinglisch.android.tasker.extras.VARIABLE_REPLACE_KEYS"));
        if (D7.length == 0) {
            D7 = D(extras.get("net.dinglisch.android.tasker.extras.VARIABLE_REPLACE_KEYS"));
        }
        if (D7 == null || D7.length == 0) {
            strArr = C2434l.f23396g;
        } else {
            ArrayList arrayList = new ArrayList(D7.length);
            for (String str : D7) {
                if (str != null && !str.isEmpty()) {
                    for (String str2 : str.split("\\s+")) {
                        if (!str2.isEmpty()) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
            strArr = (String[]) arrayList.toArray(C2434l.f23396g);
        }
        this.f16322V1 = strArr;
        String[] D8 = D(extras.get("net.dinglisch.android.tasker.RELEVANT_VARIABLES"));
        HashMap hashMap = new HashMap();
        int childCount = this.f16318Q1.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            EditVariable editVariable = (EditVariable) ((TextInputLayout) this.f16318Q1.getChildAt(childCount)).getEditText();
            hashMap.put((String) editVariable.getTag(), editVariable.getValue());
            this.f16318Q1.removeViewAt(childCount);
        }
        if (D8.length != 0) {
            Arrays.sort(D8);
            for (String str3 : D8) {
                if (str3 != null) {
                    Matcher matcher = f16312X1.matcher(str3);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(3);
                        J3.m mVar = (J3.m) hashMap.get(group);
                        if (mVar == null) {
                            mVar = e().get(group);
                        }
                        w(group, group2, mVar);
                    }
                }
                Log.w("PlugInFragment", "Illegal relevant variable: " + str3);
            }
        }
    }

    public void B(String str, String str2) {
        this.f16320S1 = str;
        this.f16321T1 = str2;
        this.U1 = null;
        this.f16322V1 = C2434l.f23396g;
        E(null);
        this.f16318Q1.removeAllViews();
        this.f16319R1.setChecked(false);
    }

    public final void C(CharSequence charSequence) {
        this.f16314M1.setText(charSequence);
        this.f16313L1.setHintForceCollapsed(!TextUtils.isEmpty(charSequence));
    }

    public final void E(String str) {
        this.W1 = str;
        TextView textView = this.f16317P1;
        if (textView != null) {
            textView.setText(str);
            this.f16316O1.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        }
    }

    public void F(T t8) {
        this.f16320S1 = t8.f16395X;
        this.f16321T1 = t8.f16396Y;
        this.U1 = t8.f16397Z;
        this.f16322V1 = t8.f16400y0;
        E(t8.f16398x0);
        this.f16318Q1.removeAllViews();
        for (J0 j02 : t8.f16399x1) {
            w(j02.f16817X, j02.f16818Y, j02.f16819Z);
        }
        this.f16319R1.setChecked(t8.f16401y1);
    }

    @Override // com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 1) {
            super.onActivityResult(i8, i9, intent);
        } else if (-1 == i9) {
            A(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        this.f16323y1 = context.getPackageManager();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == C2541R.id.configure) {
            y();
            return;
        }
        if (id != C2541R.id.plugin) {
            return;
        }
        String z7 = z();
        Bundle bundle = new Bundle();
        bundle.putString("action", z7);
        D0 d02 = new D0();
        d02.setArguments(bundle);
        d02.A(getChildFragmentManager());
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (view.getId() != C2541R.id.plugin) {
            return false;
        }
        C(null);
        this.f16315N1.setVisibility(8);
        B(null, null);
        return true;
    }

    @Override // com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("packageName", this.f16320S1);
        bundle.putString("className", this.f16321T1);
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f16313L1 = (GenericInputLayout) view.findViewById(C2541R.id.plugin_layout);
        Button button = (Button) view.findViewById(C2541R.id.plugin);
        this.f16314M1 = button;
        button.setOnClickListener(this);
        this.f16314M1.setOnLongClickListener(this);
        Button button2 = (Button) view.findViewById(C2541R.id.configure);
        this.f16315N1 = button2;
        button2.setOnClickListener(this);
        this.f16316O1 = (ViewGroup) view.findViewById(C2541R.id.description_layout);
        this.f16317P1 = (TextView) view.findViewById(C2541R.id.description);
        this.f16318Q1 = (ViewGroup) view.findViewById(C2541R.id.output_variables);
        this.f16319R1 = (CheckBox) view.findViewById(C2541R.id.allow_any_variable);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.f16320S1 = bundle.getString("packageName");
            this.f16321T1 = bundle.getString("className");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.llamalab.automate.C2
    public final void t() {
        A2 a22 = this.f14763y0;
        if (a22 == null) {
            return;
        }
        try {
            x((C0) a22.getClass().getField("plugin").get(a22));
            super.t();
        } catch (IllegalAccessException e8) {
            throw new RuntimeException(e8);
        } catch (NoSuchFieldException e9) {
            throw new RuntimeException(e9);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.llamalab.automate.C2
    public final void u(A2 a22, com.llamalab.automate.F0 f02) {
        super.u(a22, f02);
        try {
            F((C0) a22.getClass().getField("plugin").get(a22));
            if (this.f16320S1 == null || this.f16321T1 == null) {
                return;
            }
            try {
                C(this.f16323y1.getActivityInfo(new ComponentName(this.f16320S1, this.f16321T1), 0).loadLabel(this.f16323y1));
            } catch (PackageManager.NameNotFoundException unused) {
                C(this.f16320S1);
            }
            this.f16315N1.setVisibility(0);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException(e8);
        } catch (NoSuchFieldException e9) {
            throw new RuntimeException(e9);
        }
    }

    @Override // com.llamalab.automate.C2
    public final boolean v() {
        boolean v8 = super.v();
        int childCount = this.f16318Q1.getChildCount();
        boolean z7 = true;
        boolean z8 = true;
        for (int i8 = 0; i8 < childCount; i8++) {
            if (!((EditVariable) ((TextInputLayout) this.f16318Q1.getChildAt(i8)).getEditText()).e()) {
                z8 = false;
            }
        }
        boolean z9 = v8 & z8;
        if ((this.f16320S1 != null || this.f16321T1 != null) && this.U1 == null) {
            Toast.makeText(getContext(), C2541R.string.error_plugin_not_configured, 0).show();
            z7 = false;
        }
        return z9 & z7;
    }

    public final void w(String str, String str2, J3.m mVar) {
        TextInputLayout textInputLayout = (TextInputLayout) LayoutInflater.from(this.f16318Q1.getContext()).inflate(C2541R.layout.widget_plugin_variable, this.f16318Q1, false);
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        textInputLayout.setHint(str2);
        EditVariable editVariable = (EditVariable) textInputLayout.getEditText();
        editVariable.setTag(str);
        this.f16318Q1.addView(textInputLayout);
        editVariable.f(this);
        if (mVar instanceof J3.l) {
            editVariable.setValue((J3.l) mVar);
        }
    }

    public void x(T t8) {
        TextInputLayout textInputLayout;
        t8.f16395X = this.f16320S1;
        t8.f16396Y = this.f16321T1;
        t8.f16397Z = this.U1;
        t8.f16400y0 = this.f16322V1;
        t8.f16398x0 = this.W1;
        int childCount = this.f16318Q1.getChildCount();
        t8.f16399x1 = new J0[childCount];
        for (int i8 = 0; i8 < childCount; i8++) {
            EditVariable editVariable = (EditVariable) ((TextInputLayout) this.f16318Q1.getChildAt(i8)).getEditText();
            J0[] j0Arr = t8.f16399x1;
            J0 j02 = new J0();
            j0Arr[i8] = j02;
            ViewParent parent = editVariable.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    textInputLayout = null;
                    break;
                } else {
                    if (parent instanceof TextInputLayout) {
                        textInputLayout = (TextInputLayout) parent;
                        break;
                    }
                    parent = parent.getParent();
                }
            }
            CharSequence hint = textInputLayout.getHint();
            String str = (String) editVariable.getTag();
            j02.f16817X = str;
            if (!str.contentEquals(hint)) {
                j02.f16818Y = hint.toString();
            }
            j02.f16819Z = editVariable.getValue();
        }
        t8.f16401y1 = this.f16319R1.isChecked();
    }

    public final void y() {
        int i8;
        Context context = getContext();
        if (this.f16320S1 == null || this.f16321T1 == null) {
            i8 = C2541R.string.error_plugin_null;
        } else {
            Intent className = new Intent(z()).setClassName(this.f16320S1, this.f16321T1);
            Bundle bundle = this.U1;
            if (bundle != null) {
                try {
                    className.putExtras(bundle).putExtra("com.twofortyfouram.locale.intent.extra.BUNDLE", this.U1);
                } catch (Throwable th) {
                    Log.e("PlugInFragment", "Invalid configuration bundle", th);
                    Toast.makeText(context, C2541R.string.error_plugin_parcelable, 1).show();
                }
            }
            A2 a22 = this.f14763y0;
            className.putExtra("com.twofortyfouram.locale.intent.extra.BREADCRUMB", a22 != null ? context.getString(C2541R.string.format_selected_block, a22.A(context), Long.valueOf(a22.g())) : this.f16320S1);
            ArrayList arrayList = new ArrayList();
            for (J3.m mVar : e().values()) {
                if (mVar instanceof J3.l) {
                    arrayList.add("%" + mVar.x(0));
                }
            }
            className.putExtra("net.dinglisch.android.tasker.RELEVANT_VARIABLES", (String[]) arrayList.toArray(C2434l.f23396g));
            Pattern pattern = C0.f16394L1;
            Bundle bundle2 = new Bundle();
            bundle2.putInt(".hints.TIMEOUT", 3600000);
            className.putExtra("net.dinglisch.android.tasker.extras.HOST_CAPABILITIES", 94).putExtra("net.dinglisch.android.tasker.extras.HINTS", bundle2);
            try {
                startActivityForResult(className, 1);
                return;
            } catch (Throwable th2) {
                Log.e("PlugInFragment", "Failed to start configuration activity", th2);
                i8 = C2541R.string.error_plugin_not_installed;
            }
        }
        Toast.makeText(context, i8, 0).show();
    }

    public abstract String z();
}
