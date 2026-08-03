package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import com.llamalab.android.widget.GenericInputLayout;
import com.llamalab.automate.C1709z1;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ConstantInfo;
import com.llamalab.automate.InteractionPickActivity;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.field.PackageExprField;
import com.llamalab.automate.field.SpinnerExprField;
import com.llamalab.automate.field.TextExprField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import x3.C2440r;

/* loaded from: classes.dex */
public class V extends T implements View.OnLongClickListener {

    /* renamed from: M1, reason: collision with root package name */
    public GenericInputLayout f17228M1;

    /* renamed from: N1, reason: collision with root package name */
    public SpinnerExprField f17229N1;

    /* renamed from: O1, reason: collision with root package name */
    public PackageExprField f17230O1;

    /* renamed from: P1, reason: collision with root package name */
    public TextExprField f17231P1;

    /* renamed from: Q1, reason: collision with root package name */
    public SpinnerExprField f17232Q1;

    /* renamed from: R1, reason: collision with root package name */
    public TextExprField f17233R1;

    /* renamed from: S1, reason: collision with root package name */
    public androidx.appcompat.widget.H f17234S1;

    /* renamed from: T1, reason: collision with root package name */
    public androidx.appcompat.widget.H f17235T1;
    public com.llamalab.automate.A1 U1;

    @Override // com.llamalab.automate.stmt.T, com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 11) {
            super.onActivityResult(i8, i9, intent);
            return;
        }
        if (-1 != i9 || intent == null) {
            return;
        }
        intent.setExtrasClassLoader(getClass().getClassLoader());
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.llamalab.automate.intent.extra.INTERACTIONS");
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            return;
        }
        this.U1.a(parcelableArrayListExtra);
        int intExtra = intent.getIntExtra("com.llamalab.automate.intent.extra.SELECTED_POSITION", -1);
        if (intExtra != -1) {
            y((C1709z1) parcelableArrayListExtra.get(intExtra));
        }
        this.f17228M1.setVisibility(0);
    }

    @Override // com.llamalab.automate.stmt.T, android.view.View.OnClickListener
    public final void onClick(View view) {
        androidx.appcompat.widget.C c8;
        int i8;
        switch (view.getId()) {
            case C2541R.id.record /* 2131296976 */:
                if (21 > Build.VERSION.SDK_INT) {
                    startActivityForResult(new Intent(requireContext(), (Class<?>) InteractionPickActivity.class).putExtra("com.llamalab.automate.intent.extra.SCHEMA_NAMESPACE_URI", "http://schemas.android.com/apk/res/android/layout"), 11);
                    return;
                }
                this.f17234S1.a();
                c8 = this.f17234S1.f8996Z;
                i8 = C2541R.id.record;
                break;
            case C2541R.id.recordings /* 2131296977 */:
                if (!this.f17235T1.d()) {
                    this.f17235T1.a();
                    c8 = this.f17235T1.f8996Z;
                    i8 = C2541R.id.recordings;
                    break;
                } else {
                    this.f17235T1.dismiss();
                    return;
                }
            default:
                super.onClick(view);
                return;
        }
        c8.setId(i8);
    }

    @Override // com.llamalab.automate.stmt.T, androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.f17235T1.dismiss();
        x((ArrayList) this.U1.f23653X);
        super.onDestroy();
    }

    @Override // com.llamalab.automate.stmt.T, android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i8, long j8) {
        androidx.appcompat.widget.H h8;
        switch (adapterView.getId()) {
            case C2541R.id.record /* 2131296976 */:
                startActivityForResult(new Intent(requireContext(), (Class<?>) InteractionPickActivity.class).putExtra("com.llamalab.automate.intent.extra.SCHEMA_NAMESPACE_URI", (String) ((ConstantInfo) adapterView.getItemAtPosition(i8)).f14795x0), 11);
                h8 = this.f17234S1;
                break;
            case C2541R.id.recordings /* 2131296977 */:
                y((C1709z1) adapterView.getItemAtPosition(i8));
                h8 = this.f17235T1;
                break;
            default:
                super.onItemClick(adapterView, view, i8, j8);
                return;
        }
        h8.dismiss();
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (view.getId() != C2541R.id.recordings) {
            return false;
        }
        this.f17235T1.dismiss();
        this.f17228M1.setVisibility(8);
        this.U1.a(null);
        x(null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // com.llamalab.automate.stmt.T, com.llamalab.automate.C2, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onViewCreated(View view, Bundle bundle) {
        ArrayList arrayList;
        super.onViewCreated(view, bundle);
        Context requireContext = requireContext();
        Button button = (Button) view.findViewById(C2541R.id.record);
        button.setOnClickListener(this);
        androidx.appcompat.widget.H h8 = new androidx.appcompat.widget.H(requireContext);
        this.f17234S1 = h8;
        h8.f8989S1 = button;
        h8.f8990T1 = this;
        h8.p(this.f17187y1);
        this.f17228M1 = (GenericInputLayout) view.findViewById(C2541R.id.recordings_layout);
        Button button2 = (Button) view.findViewById(C2541R.id.recordings);
        button2.setOnClickListener(this);
        button2.setOnLongClickListener(this);
        this.U1 = new com.llamalab.automate.A1(requireContext, C2541R.layout.spinner_dropdown_item_3line, C2541R.style.MaterialItem_Spinner_Dropdown, 0, 0);
        androidx.appcompat.widget.H h9 = new androidx.appcompat.widget.H(requireContext);
        this.f17235T1 = h9;
        h9.f8989S1 = button2;
        h9.t();
        this.f17235T1.p(this.U1);
        this.f17235T1.f8990T1 = this;
        this.f17229N1 = (SpinnerExprField) view.findViewById(C2541R.id.action);
        this.f17230O1 = (PackageExprField) view.findViewById(C2541R.id.package_name);
        this.f17231P1 = (TextExprField) view.findViewById(C2541R.id.display_id);
        this.f17232Q1 = (SpinnerExprField) view.findViewById(C2541R.id.schema);
        this.f17233R1 = (TextExprField) view.findViewById(C2541R.id.xpath_expression);
        if (bundle == null) {
            Context requireContext2 = requireContext();
            try {
                FileInputStream openFileInput = requireContext2.openFileInput("interactions");
                try {
                    arrayList = C2440r.C(C1709z1.CREATOR, 4, openFileInput);
                    openFileInput.close();
                } finally {
                }
            } catch (FileNotFoundException unused) {
                arrayList = null;
                if (arrayList == null) {
                    return;
                } else {
                    return;
                }
            } catch (Throwable th) {
                Log.w("InteractFragment", "Failed to load recorded interactions", th);
                new File(requireContext2.getFilesDir(), "interactions").delete();
                arrayList = null;
                if (arrayList == null) {
                }
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            this.U1.a(arrayList);
            this.f17228M1.setVisibility(0);
        }
    }

    public final void x(ArrayList<C1709z1> arrayList) {
        Context requireContext = requireContext();
        if (arrayList != null && !arrayList.isEmpty()) {
            try {
                FileOutputStream openFileOutput = requireContext.openFileOutput("interactions", 0);
                try {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInt(4);
                        obtain.writeTypedList(arrayList);
                        openFileOutput.write(obtain.marshall());
                        openFileOutput.close();
                        return;
                    } finally {
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (Throwable th2) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            } catch (Exception unused) {
                            }
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Log.w("InteractFragment", "Failed to save recorded interactions", th3);
            }
        }
        new File(requireContext.getFilesDir(), "interactions").delete();
    }

    public final void y(C1709z1 c1709z1) {
        SpinnerExprField spinnerExprField = this.f17229N1;
        if (spinnerExprField != null) {
            spinnerExprField.setValue((InterfaceC1700x0) new L3.J(c1709z1.f17647Y));
        }
        this.f17230O1.setValue((InterfaceC1700x0) L3.W.b(c1709z1.f17648Z));
        TextExprField textExprField = this.f17231P1;
        int i8 = c1709z1.f17649x0;
        textExprField.setValue((InterfaceC1700x0) (i8 < 0 ? new L3.J(i8) : null));
        this.f17233R1.setValue((InterfaceC1700x0) L3.W.b(c1709z1.f17650x1));
        this.f17232Q1.setValue((InterfaceC1700x0) L3.W.b(c1709z1.f17651y0));
    }
}
