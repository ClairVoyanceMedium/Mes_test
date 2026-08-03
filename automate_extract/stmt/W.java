package com.llamalab.automate.stmt;

import L3.C1053s;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import com.llamalab.android.widget.GenericInputLayout;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.L2;
import com.llamalab.automate.M2;
import com.llamalab.automate.SwipePickActivity;
import com.llamalab.automate.field.SpinnerExprField;
import com.llamalab.automate.field.TextExprField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import x3.C2440r;

/* loaded from: classes.dex */
public class W extends C2 implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener {

    /* renamed from: L1, reason: collision with root package name */
    public androidx.appcompat.widget.H f17240L1;

    /* renamed from: M1, reason: collision with root package name */
    public M2 f17241M1;

    /* renamed from: N1, reason: collision with root package name */
    public SpinnerExprField f17242N1;

    /* renamed from: O1, reason: collision with root package name */
    public TextExprField f17243O1;

    /* renamed from: P1, reason: collision with root package name */
    public TextExprField f17244P1;

    /* renamed from: Q1, reason: collision with root package name */
    public TextExprField f17245Q1;

    /* renamed from: R1, reason: collision with root package name */
    public TextExprField f17246R1;

    /* renamed from: S1, reason: collision with root package name */
    public TextExprField f17247S1;

    /* renamed from: y1, reason: collision with root package name */
    public GenericInputLayout f17248y1;

    @Override // com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 10) {
            super.onActivityResult(i8, i9, intent);
            return;
        }
        if (-1 != i9 || intent == null) {
            return;
        }
        intent.setExtrasClassLoader(getClass().getClassLoader());
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.llamalab.automate.intent.extra.SWIPES");
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            return;
        }
        this.f17241M1.a(parcelableArrayListExtra);
        int intExtra = intent.getIntExtra("com.llamalab.automate.intent.extra.SELECTED_POSITION", -1);
        if (intExtra != -1) {
            x((L2) parcelableArrayListExtra.get(intExtra));
        }
        this.f17248y1.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case C2541R.id.record /* 2131296976 */:
                startActivityForResult(new Intent(requireContext(), (Class<?>) SwipePickActivity.class), 10);
                break;
            case C2541R.id.recordings /* 2131296977 */:
                if (!this.f17240L1.d()) {
                    this.f17240L1.a();
                    break;
                } else {
                    this.f17240L1.dismiss();
                    break;
                }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.f17240L1.dismiss();
        w((ArrayList) this.f17241M1.f23653X);
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i8, long j8) {
        x((L2) adapterView.getItemAtPosition(i8));
        this.f17240L1.dismiss();
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (view.getId() != C2541R.id.recordings) {
            return false;
        }
        this.f17240L1.dismiss();
        this.f17248y1.setVisibility(8);
        this.f17241M1.a(null);
        w(null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onViewCreated(View view, Bundle bundle) {
        ArrayList arrayList;
        super.onViewCreated(view, bundle);
        Context requireContext = requireContext();
        ((Button) view.findViewById(C2541R.id.record)).setOnClickListener(this);
        this.f17248y1 = (GenericInputLayout) view.findViewById(C2541R.id.recordings_layout);
        Button button = (Button) view.findViewById(C2541R.id.recordings);
        button.setOnClickListener(this);
        button.setOnLongClickListener(this);
        this.f17241M1 = new M2(requireContext, C2541R.layout.spinner_dropdown_item_2line, C2541R.style.MaterialItem_Spinner_Dropdown, 0, 0);
        androidx.appcompat.widget.H h8 = new androidx.appcompat.widget.H(requireContext);
        this.f17240L1 = h8;
        h8.f8989S1 = button;
        h8.t();
        this.f17240L1.p(this.f17241M1);
        this.f17240L1.f8990T1 = this;
        this.f17242N1 = (SpinnerExprField) view.findViewById(C2541R.id.gesture);
        this.f17243O1 = (TextExprField) view.findViewById(C2541R.id.f23852x0);
        this.f17244P1 = (TextExprField) view.findViewById(C2541R.id.f23855y0);
        this.f17245Q1 = (TextExprField) view.findViewById(C2541R.id.f23853x1);
        this.f17246R1 = (TextExprField) view.findViewById(C2541R.id.f23856y1);
        this.f17247S1 = (TextExprField) view.findViewById(C2541R.id.speed);
        if (bundle == null) {
            Context requireContext2 = requireContext();
            try {
                FileInputStream openFileInput = requireContext2.openFileInput("swipes");
                try {
                    arrayList = C2440r.C(L2.CREATOR, 1, openFileInput);
                    openFileInput.close();
                } catch (Throwable th) {
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (Throwable th2) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused) {
                arrayList = null;
                if (arrayList == null) {
                    return;
                } else {
                    return;
                }
            } catch (Throwable th3) {
                Log.w("InteractTouchFragment", "Failed to load recorded swipes", th3);
                new File(requireContext2.getFilesDir(), "swipes").delete();
                arrayList = null;
                if (arrayList == null) {
                }
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            this.f17241M1.a(arrayList);
            this.f17248y1.setVisibility(0);
        }
    }

    public final void w(ArrayList<L2> arrayList) {
        Context requireContext = requireContext();
        if (arrayList != null && !arrayList.isEmpty()) {
            try {
                FileOutputStream openFileOutput = requireContext.openFileOutput("swipes", 0);
                try {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInt(1);
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
                Log.w("InteractTouchFragment", "Failed to save recorded swipes", th3);
            }
        }
        new File(requireContext.getFilesDir(), "swipes").delete();
    }

    public final void x(L2 l22) {
        Display defaultDisplay = ((WindowManager) getContext().getApplicationContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (17 <= Build.VERSION.SDK_INT) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        this.f17242N1.setValue((InterfaceC1700x0) new C1053s(4));
        this.f17243O1.setValue((InterfaceC1700x0) new L3.J(M2.e(l22.f15106Z)));
        TextExprField textExprField = this.f17244P1;
        float f8 = l22.f15107x0;
        textExprField.setValue((InterfaceC1700x0) new L3.J(M2.e(f8)));
        TextExprField textExprField2 = this.f17245Q1;
        float f9 = l22.f15109y0;
        textExprField2.setValue((InterfaceC1700x0) new L3.J(M2.e(f9)));
        TextExprField textExprField3 = this.f17246R1;
        float f10 = l22.f15108x1;
        textExprField3.setValue((InterfaceC1700x0) new L3.J(M2.e(f10)));
        float f11 = displayMetrics.widthPixels;
        float f12 = l22.f15106Z * f11;
        float f13 = displayMetrics.heightPixels;
        float f14 = f9 * f11;
        int i8 = y4.j.f23551b;
        float f15 = f12 - f14;
        float f16 = (f8 * f13) - (f10 * f13);
        float sqrt = (float) Math.sqrt((f16 * f16) + (f15 * f15));
        TextExprField textExprField4 = this.f17247S1;
        double d8 = sqrt;
        double d9 = l22.f15105Y;
        Double.isNaN(d9);
        Double.isNaN(d9);
        Double.isNaN(d8);
        Double.isNaN(d8);
        textExprField4.setValue((InterfaceC1700x0) new L3.J(Math.round(d8 / (d9 / 1000.0d)) / displayMetrics.density));
    }
}
