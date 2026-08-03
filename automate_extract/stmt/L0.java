package com.llamalab.automate.stmt;

import com.llamalab.automate.J1;
import java.util.LinkedHashSet;
import java.util.Map;

/* loaded from: classes.dex */
public final class L0 extends J1 {

    /* renamed from: L1, reason: collision with root package name */
    public final Map<String, String> f16848L1;

    public L0(Map<String, String> map) {
        this.f16848L1 = map;
    }

    @Override // com.llamalab.automate.J1
    public final void w2(O3.a aVar) {
        Map<String, String> map = this.f16848L1;
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet(map.size());
            t3.l lVar = new t3.l();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                boolean m12 = aVar.m1(entry.getKey(), entry.getValue(), lVar);
                lVar.c();
                if (m12) {
                    linkedHashSet.add(entry.getKey());
                }
            }
            q2(linkedHashSet, false);
        } catch (Throwable th) {
            r2(th);
        }
    }
}
