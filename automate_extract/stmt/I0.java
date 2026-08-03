package com.llamalab.automate.stmt;

/* loaded from: classes.dex */
public final class I0 extends C0 {

    /* renamed from: M1, reason: collision with root package name */
    public int f16709M1;

    /* renamed from: N1, reason: collision with root package name */
    public boolean f16710N1;

    @Override // com.llamalab.automate.stmt.C0, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.c(this.f16709M1);
        if (84 <= dVar.f6413Z) {
            dVar.write(this.f16710N1 ? 1 : 0);
        }
    }

    @Override // com.llamalab.automate.stmt.C0, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.f16709M1 = cVar.a();
        if (84 <= cVar.f6409x0) {
            this.f16710N1 = cVar.readBoolean();
        }
    }
}
