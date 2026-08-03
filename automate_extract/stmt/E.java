package com.llamalab.automate.stmt;

import a4.C1197f;
import b4.InterfaceC1292b;

/* loaded from: classes.dex */
public final /* synthetic */ class E implements InterfaceC1292b {

    /* renamed from: X, reason: collision with root package name */
    public final /* synthetic */ int f16612X;

    public /* synthetic */ E(int i8) {
        this.f16612X = i8;
    }

    @Override // b4.InterfaceC1292b
    public final boolean a(Object obj, Object obj2) {
        switch (this.f16612X) {
            case 0:
                return C1197f.e((CharSequence) obj, (CharSequence) obj2);
            case 1:
                return w0.L.i((Integer) obj, (Integer) obj2);
            case 2:
                return w0.L.i((Integer) obj, (Integer) obj2);
            case 3:
                return C1197f.d((CharSequence) obj, (CharSequence) obj2);
            case 4:
                return true;
            default:
                return false;
        }
    }
}
