package com.llamalab.automate.stmt;

import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.field.ComponentExprField;
import com.llamalab.automate.field.PackageExprField;
import com.llamalab.automate.stmt.C1669t;

/* renamed from: com.llamalab.automate.stmt.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ViewOnClickListenerC1667s extends C2 implements View.OnClickListener, View.OnLongClickListener, C1669t.a {

    /* renamed from: L1, reason: collision with root package name */
    public PackageExprField f17515L1;

    /* renamed from: M1, reason: collision with root package name */
    public ComponentExprField f17516M1;

    /* renamed from: y1, reason: collision with root package name */
    public Button f17517y1;

    public static ViewOnClickListenerC1667s w(Intent intent, int i8) {
        return x(ViewOnClickListenerC1667s.class, i8, intent);
    }

    public static <T extends ViewOnClickListenerC1667s> T x(Class<T> cls, int i8, Intent intent) {
        try {
            T newInstance = cls.newInstance();
            Bundle bundle = new Bundle();
            bundle.putInt("componentType", i8);
            bundle.putParcelable("queryIntent", intent);
            newInstance.setArguments(bundle);
            return newInstance;
        } catch (IllegalAccessException e8) {
            throw new Fragment.InstantiationException("Failed to create fragment", e8);
        } catch (InstantiationException e9) {
            throw new Fragment.InstantiationException("Failed to create fragment", e9);
        }
    }

    @Override // com.llamalab.automate.stmt.C1669t.a
    public final void i(ComponentInfo componentInfo) {
        String str = componentInfo.packageName;
        String str2 = componentInfo.name;
        this.f17515L1.setValue((InterfaceC1700x0) L3.W.b(str));
        this.f17516M1.setValue((InterfaceC1700x0) L3.W.b(str2));
    }

    public void onClick(View view) {
        if (view.getId() != C2541R.id.pick_component) {
            return;
        }
        Bundle arguments = getArguments();
        int i8 = arguments.getInt("componentType");
        Intent intent = (Intent) arguments.getParcelable("queryIntent");
        CharSequence text = this.f17517y1.getText();
        Bundle bundle = new Bundle();
        bundle.putInt("componentType", i8);
        bundle.putParcelable("queryIntent", intent);
        bundle.putCharSequence("title", text);
        C1669t c1669t = new C1669t();
        c1669t.setArguments(bundle);
        c1669t.A(getChildFragmentManager());
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (view.getId() != C2541R.id.pick_component) {
            return false;
        }
        this.f17515L1.setValue((InterfaceC1700x0) null);
        this.f17516M1.setValue((InterfaceC1700x0) null);
        return true;
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f17515L1 = (PackageExprField) view.findViewById(C2541R.id.package_name);
        this.f17516M1 = (ComponentExprField) view.findViewById(C2541R.id.component_class);
        Button button = (Button) view.findViewById(C2541R.id.pick_component);
        this.f17517y1 = button;
        button.setOnClickListener(this);
        this.f17517y1.setOnLongClickListener(this);
    }
}
