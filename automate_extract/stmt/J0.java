package com.llamalab.automate.stmt;

import com.llamalab.automate.T2;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public final class J0 implements R3.e, T2 {

    /* renamed from: x0, reason: collision with root package name */
    public static final J0[] f16816x0 = new J0[0];

    /* renamed from: X, reason: collision with root package name */
    public String f16817X;

    /* renamed from: Y, reason: collision with root package name */
    public String f16818Y;

    /* renamed from: Z, reason: collision with root package name */
    public J3.l f16819Z;

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        dVar.k(this.f16817X);
        dVar.k(this.f16818Y);
        dVar.g(this.f16819Z);
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.f16819Z);
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        this.f16817X = cVar.i();
        this.f16818Y = cVar.i();
        this.f16819Z = (J3.l) cVar.readObject();
    }
}
