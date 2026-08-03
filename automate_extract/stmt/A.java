package com.llamalab.automate.stmt;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import com.llamalab.automate.C1610n2;
import com.llamalab.automate.P2;
import java.util.Collections;
import java.util.Map;
import x3.C2422C;

/* loaded from: classes.dex */
public final class A extends P2 {

    /* renamed from: L1, reason: collision with root package name */
    public static final Map<String, C2422C.a<A>> f16213L1 = Collections.singletonMap("constant", new a());

    /* renamed from: x0, reason: collision with root package name */
    public final float f16214x0;

    /* renamed from: x1, reason: collision with root package name */
    public final float f16215x1;

    /* renamed from: y0, reason: collision with root package name */
    public final float f16216y0;

    /* renamed from: y1, reason: collision with root package name */
    public final float f16217y1;

    public class a implements C2422C.a<A> {
        @Override // x3.C2422C.a
        public final A a(XmlResourceParser xmlResourceParser, Resources resources) {
            TypedArray obtainAttributes = resources.obtainAttributes(xmlResourceParser, C1610n2.f16130v);
            A a8 = new A(Float.valueOf(obtainAttributes.getFloat(2, Float.NaN)), Float.valueOf(obtainAttributes.getFloat(3, Float.NaN)), Float.valueOf(obtainAttributes.getFloat(4, Float.NaN)), Float.valueOf(obtainAttributes.getFloat(5, Float.NaN)), obtainAttributes.getText(0), obtainAttributes.getText(1));
            obtainAttributes.recycle();
            return a8;
        }
    }

    public A(Float f8, Float f9, Float f10, Float f11, CharSequence charSequence, CharSequence charSequence2) {
        super(charSequence, charSequence2);
        this.f16214x0 = f8.floatValue();
        this.f16216y0 = f9.floatValue();
        this.f16215x1 = f10.floatValue();
        this.f16217y1 = f11.floatValue();
    }
}
