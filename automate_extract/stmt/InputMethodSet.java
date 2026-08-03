package com.llamalab.automate.stmt;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@F3.f("input_method_set.html")
@F3.a(C2541R.integer.ic_input_method)
@F3.i(C2541R.string.stmt_input_method_set_title)
@F3.h(C2541R.string.stmt_input_method_set_summary)
@F3.e(C2541R.layout.stmt_input_method_set_edit)
/* loaded from: classes.dex */
public final class InputMethodSet extends Action implements AsyncStatement {
    public InterfaceC1700x0 enable;
    public InterfaceC1700x0 inputMethod;
    public InterfaceC1700x0 inputMethodSubtype;

    public static String q(LinkedHashMap linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            sb.append(str);
            sb.append((String) entry.getKey());
            for (String str2 : (Set) entry.getValue()) {
                sb.append(";");
                sb.append(str2);
            }
            str = ":";
        }
        return sb.toString();
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 23 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SECURE_SETTINGS"), com.llamalab.automate.access.c.f15561v} : 17 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS"), com.llamalab.automate.access.c.j("android.permission.WRITE_SECURE_SETTINGS")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 q8 = D1.P.l(context, C2541R.string.caption_input_method_set).o(2, this.inputMethod).q(this.inputMethod);
        q8.v(this.inputMethodSubtype, 0);
        return q8.y(this.enable, C2541R.string.caption_enable, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.inputMethod);
        dVar.g(this.inputMethodSubtype);
        dVar.g(this.enable);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.inputMethod);
        visitor.b(this.inputMethodSubtype);
        visitor.b(this.enable);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new S();
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.inputMethod = (InterfaceC1700x0) cVar.readObject();
        this.inputMethodSubtype = (InterfaceC1700x0) cVar.readObject();
        this.enable = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0183 A[LOOP:3: B:42:0x017d->B:44:0x0183, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016b  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        InputMethodInfo inputMethodInfo;
        LinkedHashMap linkedHashMap;
        c1708z0.q(C2541R.string.stmt_input_method_set_title);
        InputMethodManager inputMethodManager = (InputMethodManager) c1708z0.getSystemService("input_method");
        InputMethodSubtype inputMethodSubtype = null;
        String x7 = J3.h.x(c1708z0, this.inputMethod, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("inputMethod");
        }
        Iterator<InputMethodInfo> it = inputMethodManager.getInputMethodList().iterator();
        while (true) {
            if (!it.hasNext()) {
                inputMethodInfo = null;
                break;
            }
            inputMethodInfo = it.next();
            if (x7.equals(inputMethodInfo.getId())) {
                break;
            }
        }
        if (inputMethodInfo == null) {
            throw new IllegalArgumentException("Input method not found");
        }
        String x8 = J3.h.x(c1708z0, this.inputMethodSubtype, null);
        if (!TextUtils.isEmpty(x8)) {
            try {
                int parseInt = Integer.parseInt(x8);
                Iterator<InputMethodSubtype> it2 = inputMethodManager.getEnabledInputMethodSubtypeList(inputMethodInfo, true).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    InputMethodSubtype next = it2.next();
                    if (parseInt == next.hashCode()) {
                        inputMethodSubtype = next;
                        break;
                    }
                }
            } catch (NumberFormatException unused) {
            }
            if (inputMethodSubtype == null) {
                throw new IllegalArgumentException("Input method subtype not found");
            }
        }
        boolean z7 = false;
        boolean f8 = J3.h.f(c1708z0, this.enable, false);
        ContentResolver contentResolver = c1708z0.getContentResolver();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(3);
        if (34 <= Build.VERSION.SDK_INT) {
            linkedHashMap = new LinkedHashMap();
            for (InputMethodInfo inputMethodInfo2 : inputMethodManager.getEnabledInputMethodList()) {
                List<InputMethodSubtype> enabledInputMethodSubtypeList = inputMethodManager.getEnabledInputMethodSubtypeList(inputMethodInfo2, z7);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator<InputMethodSubtype> it3 = enabledInputMethodSubtypeList.iterator();
                while (it3.hasNext()) {
                    int hashCode = it3.next().hashCode();
                    if (hashCode != 0) {
                        linkedHashSet.add(Integer.toString(hashCode));
                    }
                }
                linkedHashMap.put(inputMethodInfo2.getId(), linkedHashSet);
                z7 = false;
            }
        } else {
            String string = Settings.Secure.getString(contentResolver, "enabled_input_methods");
            linkedHashMap = new LinkedHashMap();
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(":");
                int length = split.length;
                int i8 = 0;
                while (i8 < length) {
                    String[] split2 = split[i8].split(";");
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    String[] strArr = split;
                    for (int i9 = 1; i9 < split2.length; i9++) {
                        linkedHashSet2.add(split2[i9]);
                    }
                    linkedHashMap.put(split2[0], linkedHashSet2);
                    i8++;
                    split = strArr;
                }
            }
        }
        Set set = (Set) linkedHashMap.get(x7);
        if (set != null) {
            if (!TextUtils.isEmpty(x8) && !set.contains(x8)) {
                if (!f8) {
                    throw new IllegalStateException("Input method subtype not enabled");
                }
                set.add(x8);
            }
            linkedHashMap2.put("default_input_method", x7);
            linkedHashMap2.put("selected_input_method_subtype", Integer.toString(inputMethodSubtype == null ? inputMethodSubtype.hashCode() : -1));
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                Settings.Secure.putString(contentResolver, (String) entry.getKey(), (String) entry.getValue());
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        if (!f8) {
            throw new IllegalStateException("Input method not enabled");
        }
        linkedHashMap.put(x7, TextUtils.isEmpty(x8) ? Collections.emptySet() : Collections.singleton(x8));
        linkedHashMap2.put("enabled_input_methods", q(linkedHashMap));
        linkedHashMap2.put("default_input_method", x7);
        linkedHashMap2.put("selected_input_method_subtype", Integer.toString(inputMethodSubtype == null ? inputMethodSubtype.hashCode() : -1));
        while (r2.hasNext()) {
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
