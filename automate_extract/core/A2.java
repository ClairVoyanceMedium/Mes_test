package com.llamalab.automate;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import com.llamalab.automate.C1617p1;
import java.util.Comparator;

/* loaded from: classes.dex */
public interface A2 extends R3.e, T2 {

    /* renamed from: E1, reason: collision with root package name */
    public static final A2[] f14469E1 = new A2[0];

    /* renamed from: F1, reason: collision with root package name */
    public static final a f14470F1 = new a();

    public class a implements Comparator<A2> {
        @Override // java.util.Comparator
        public final int compare(A2 a22, A2 a23) {
            long g8 = a22.g();
            long g9 = a23.g();
            if (g8 < g9) {
                return -1;
            }
            return g8 > g9 ? 1 : 0;
        }
    }

    CharSequence A(Context context);

    void C1(C1708z0 c1708z0);

    E3.b[] K0(Context context);

    CharSequence M1(Context context);

    C1617p1.b N1(Context context, int i8, ColorStateList colorStateList);

    String O0(Context context);

    BlockView c0(Flowchart flowchart, LayoutInflater layoutInflater);

    C2 e0();

    long g();

    CharSequence q0(Context context);

    boolean r1(C1708z0 c1708z0);

    void u0(int i8, int i9);

    void y(long j8);
}
