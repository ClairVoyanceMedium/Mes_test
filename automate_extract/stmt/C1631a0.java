package com.llamalab.automate.stmt;

import android.content.Intent;
import android.os.Bundle;
import com.llamalab.automate.InterfaceC1590i2;
import java.util.Arrays;
import x3.C2434l;

/* renamed from: com.llamalab.automate.stmt.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1631a0 extends com.llamalab.automate.W implements InterfaceC1590i2 {

    /* renamed from: y1, reason: collision with root package name */
    public Intent[] f17336y1 = C2434l.f23405p;

    /* renamed from: L1, reason: collision with root package name */
    public Bundle[] f17335L1 = C2434l.f23406q;

    @Override // com.llamalab.automate.W, R3.e
    public final void Y0(R3.d dVar) {
        dVar.d(this.f15404y0);
        int length = this.f17336y1.length;
        dVar.f(length);
        if (length > 0) {
            dVar.m(this.f17336y1);
            dVar.m(this.f17335L1);
        }
    }

    @Override // com.llamalab.automate.W, R3.e
    public final void o0(R3.c cVar) {
        this.f15404y0 = cVar.b();
        int d8 = cVar.d();
        if (d8 > 0) {
            Intent[] intentArr = new Intent[d8];
            this.f17336y1 = intentArr;
            cVar.k(intentArr, Intent.CREATOR);
            Bundle[] bundleArr = new Bundle[d8];
            this.f17335L1 = bundleArr;
            cVar.k(bundleArr, Bundle.CREATOR);
        }
    }

    public final void v2(Intent intent, Bundle bundle) {
        Intent[] intentArr = this.f17336y1;
        int length = intentArr.length;
        int i8 = length + 1;
        this.f17336y1 = (Intent[]) Arrays.copyOf(intentArr, i8);
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(this.f17335L1, i8);
        this.f17335L1 = bundleArr;
        this.f17336y1[length] = intent;
        bundleArr[length] = bundle;
    }
}
