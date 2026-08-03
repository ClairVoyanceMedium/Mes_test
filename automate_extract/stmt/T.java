package com.llamalab.automate.stmt;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import com.llamalab.automate.C1608n0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ConstantInfo;
import com.llamalab.automate.InspectLayoutActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import x3.C2434l;

/* loaded from: classes.dex */
public class T extends C2 implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: L1, reason: collision with root package name */
    public androidx.appcompat.widget.H f17186L1;

    /* renamed from: y1, reason: collision with root package name */
    public C1608n0 f17187y1;

    public static Intent w(PackageManager packageManager, Intent intent, String[] strArr, String str) {
        HashSet hashSet = new HashSet();
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 0).iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            hashSet.add(new ComponentName(activityInfo.packageName, activityInfo.name));
            z7 = true;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            Intent dataAndType = new Intent(intent).setDataAndType(intent.getData(), str2);
            Iterator<ResolveInfo> it2 = packageManager.queryIntentActivities(dataAndType, 0).iterator();
            while (it2.hasNext()) {
                ActivityInfo activityInfo2 = it2.next().activityInfo;
                ComponentName componentName = new ComponentName(activityInfo2.packageName, activityInfo2.name);
                if (!hashSet.add(componentName)) {
                    arrayList.add(new Intent(dataAndType).setComponent(componentName));
                }
            }
        }
        if (!z7 && !arrayList.isEmpty()) {
            intent = (Intent) arrayList.remove(0);
        }
        Intent addFlags = Intent.createChooser(intent, str).addFlags(268435456);
        if (!arrayList.isEmpty()) {
            addFlags.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(C2434l.f23399j));
        }
        return addFlags;
    }

    @Override // com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 10) {
            super.onActivityResult(i8, i9, intent);
        } else {
            if (-1 != i9 || intent == null) {
                return;
            }
            try {
                startActivity(w(requireContext().getPackageManager(), intent, new String[]{"application/xhtml+xml", "text/plain"}, getString(C2541R.string.action_view)));
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(requireContext(), C2541R.string.error_activity_not_found, 0).show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != C2541R.id.inspect) {
            return;
        }
        if (21 > Build.VERSION.SDK_INT) {
            startActivityForResult(new Intent(requireContext(), (Class<?>) InspectLayoutActivity.class).putExtra("com.llamalab.automate.intent.extra.SCHEMA_NAMESPACE_URI", "http://schemas.android.com/apk/res/android/layout"), 10);
        } else {
            this.f17186L1.a();
            this.f17186L1.f8996Z.setId(C2541R.id.inspect);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f17186L1.dismiss();
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i8, long j8) {
        if (adapterView.getId() != C2541R.id.inspect) {
            return;
        }
        startActivityForResult(new Intent(requireContext(), (Class<?>) InspectLayoutActivity.class).putExtra("com.llamalab.automate.intent.extra.SCHEMA_NAMESPACE_URI", (String) ((ConstantInfo) adapterView.getItemAtPosition(i8)).f14795x0), 10);
        this.f17186L1.dismiss();
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Context requireContext = requireContext();
        Button button = (Button) view.findViewById(C2541R.id.inspect);
        button.setOnClickListener(this);
        ArrayList g8 = ConstantInfo.g(requireContext, C2541R.xml.layout_schemas, 3);
        this.f17187y1 = new C1608n0(requireContext, g8, ConstantInfo.f(g8) ? C2541R.layout.spinner_dropdown_item_3line : C2541R.layout.spinner_dropdown_item_1line, C2541R.style.MaterialItem_Spinner_Dropdown);
        androidx.appcompat.widget.H h8 = new androidx.appcompat.widget.H(requireContext);
        this.f17186L1 = h8;
        h8.f8989S1 = button;
        h8.f8990T1 = this;
        h8.p(this.f17187y1);
    }
}
