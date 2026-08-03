package com.llamalab.automate.stmt;

import C1.D1;
import android.os.Bundle;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import java.util.EnumSet;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import r3.AbstractRunnableC2258a;
import r3.EnumC2263f;
import r3.InterfaceC2264g;
import x3.C2446x;

/* renamed from: com.llamalab.automate.stmt.d0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC1639d0 extends C2 implements InterfaceC2264g, Runnable, View.OnClickListener {

    /* renamed from: T1, reason: collision with root package name */
    public static final char[] f17370T1 = {'?', '?', 'V', 'D', 'I', 'W', 'E', 'F', 'S'};

    /* renamed from: O1, reason: collision with root package name */
    public int f17374O1;

    /* renamed from: P1, reason: collision with root package name */
    public boolean f17375P1;

    /* renamed from: Q1, reason: collision with root package name */
    public TextInputLayout f17376Q1;

    /* renamed from: R1, reason: collision with root package name */
    public TextView f17377R1;

    /* renamed from: S1, reason: collision with root package name */
    public AbstractRunnableC2258a f17378S1;

    /* renamed from: y1, reason: collision with root package name */
    public final ReentrantLock f17379y1 = new ReentrantLock();

    /* renamed from: L1, reason: collision with root package name */
    public final Formatter f17371L1 = new Formatter(new StringBuilder());

    /* renamed from: M1, reason: collision with root package name */
    public final int[] f17372M1 = new int[101];

    /* renamed from: N1, reason: collision with root package name */
    public String f17373N1 = "";

    @Override // r3.InterfaceC2264g
    public final /* synthetic */ boolean a(int i8) {
        return true;
    }

    @Override // r3.InterfaceC2264g
    public final /* synthetic */ boolean b(CharSequence charSequence) {
        return true;
    }

    @Override // r3.InterfaceC2264g
    public final void h(EnumC2263f enumC2263f, long j8, int i8, int i9, CharSequence charSequence, CharSequence charSequence2) {
        int[] iArr = this.f17372M1;
        Formatter formatter = this.f17371L1;
        ReentrantLock reentrantLock = this.f17379y1;
        reentrantLock.lock();
        try {
            StringBuilder sb = (StringBuilder) formatter.out();
            sb.delete(0, iArr[this.f17374O1]);
            int length = sb.length();
            char c8 = f17370T1[y4.j.d(i9, 0, 8)];
            CharSequence m8 = C2446x.m(charSequence2);
            if (i8 != -1) {
                String nameForUid = getContext().getPackageManager().getNameForUid(i8);
                if (nameForUid != null) {
                    formatter.format(Locale.US, "%1$s%2$tm-%2$td %2$tT.%2$tL %3$s %4$s %5$c %6$s: %7$s", this.f17373N1, Long.valueOf(j8), enumC2263f, nameForUid, Character.valueOf(c8), charSequence, m8);
                } else {
                    formatter.format(Locale.US, "%1$s%2$tm-%2$td %2$tT.%2$tL %3$s %4$d %5$c %6$s: %7$s", this.f17373N1, Long.valueOf(j8), enumC2263f, Integer.valueOf(i8), Character.valueOf(c8), charSequence, m8);
                }
            } else {
                formatter.format(Locale.US, "%1$s%2$tm-%2$td %2$tT.%2$tL %3$s %4$c %5$s: %6$s", this.f17373N1, Long.valueOf(j8), enumC2263f, Character.valueOf(c8), charSequence, m8);
            }
            iArr[(this.f17374O1 + 100) % 101] = sb.length() - length;
            this.f17374O1 = (this.f17374O1 + 1) % 101;
            this.f17373N1 = "\n";
            this.f17375P1 = true;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AbstractRunnableC2258a abstractRunnableC2258a = this.f17378S1;
        if (abstractRunnableC2258a != null) {
            if (abstractRunnableC2258a.f21887Y.get()) {
                x();
            } else {
                w();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        AbstractRunnableC2258a abstractRunnableC2258a = this.f17378S1;
        if (abstractRunnableC2258a != null) {
            abstractRunnableC2258a.a();
            this.f17378S1 = null;
            this.f17377R1.removeCallbacks(this);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        w();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        x();
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C2541R.id.log_lines_layout);
        this.f17376Q1 = textInputLayout;
        textInputLayout.setEndIconOnClickListener(this);
        TextView textView = (TextView) view.findViewById(C2541R.id.log_lines);
        this.f17377R1 = textView;
        textView.setHorizontallyScrolling(true);
        this.f17377R1.setMovementMethod(new ScrollingMovementMethod());
        this.f17377R1.setOnTouchListener(new z3.n());
        this.f17377R1.setSpannableFactory(new z3.r());
        EnumC2263f[] enumC2263fArr = EnumC2263f.f21924L1;
        this.f17378S1 = D1.x(EnumSet.of(enumC2263fArr[0], enumC2263fArr), System.currentTimeMillis() - 300000, false, this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17377R1.postDelayed(this, 1000L);
        ReentrantLock reentrantLock = this.f17379y1;
        if (reentrantLock.tryLock()) {
            try {
                StringBuilder sb = (StringBuilder) this.f17371L1.out();
                if (this.f17375P1 && sb.length() != 0) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
                    this.f17375P1 = false;
                    reentrantLock.unlock();
                    Selection.setSelection(spannableStringBuilder, TextUtils.lastIndexOf(spannableStringBuilder, '\n') + 1);
                    this.f17377R1.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void w() {
        AbstractRunnableC2258a abstractRunnableC2258a = this.f17378S1;
        if (abstractRunnableC2258a != null) {
            abstractRunnableC2258a.f21887Y.set(true);
            this.f17377R1.removeCallbacks(this);
            this.f17376Q1.setEndIconDrawable(C2541R.drawable.ic_play_circle_outline_black_24dp);
            this.f17376Q1.setEndIconContentDescription(C2541R.string.action_resume);
        }
    }

    public final void x() {
        AbstractRunnableC2258a abstractRunnableC2258a = this.f17378S1;
        if (abstractRunnableC2258a != null) {
            AtomicBoolean atomicBoolean = abstractRunnableC2258a.f21887Y;
            if (atomicBoolean.get()) {
                while (abstractRunnableC2258a.e()) {
                }
                atomicBoolean.set(false);
            }
            this.f17376Q1.setEndIconDrawable(C2541R.drawable.ic_pause_circle_outline_black_24dp);
            this.f17376Q1.setEndIconContentDescription(C2541R.string.action_pause);
            this.f17377R1.postDelayed(this, 1000L);
        }
    }
}
