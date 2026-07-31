package com.llamalab.automate;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public final class K0 extends R3.d {

    /* renamed from: y0, reason: collision with root package name */
    public final /* synthetic */ L0 f15087y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K0(L0 l02, ByteArrayOutputStream byteArrayOutputStream) {
        super(byteArrayOutputStream);
        this.f15087y0 = l02;
    }

    @Override // R3.d
    public final void g(Object obj) {
        if ((obj instanceof A2) && !this.f15087y0.f15099X.contains(obj)) {
            obj = null;
        }
        super.g(obj);
    }
}
