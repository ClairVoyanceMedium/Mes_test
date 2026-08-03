package com.llamalab.automate;

import R3.c;
import R3.h;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import com.llamalab.android.system.MoreOsConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class L0 implements R3.e, T2 {

    /* renamed from: X, reason: collision with root package name */
    public Collection<A2> f15099X;

    /* renamed from: Y, reason: collision with root package name */
    public CharSequence f15100Y;

    public L0() {
        this.f15099X = Collections.emptySet();
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        dVar.writeInt(1279346284);
        dVar.p(114);
        dVar.f6414x0 = true;
        dVar.f(this.f15099X.size());
        Iterator<A2> it = this.f15099X.iterator();
        while (it.hasNext()) {
            dVar.g(it.next());
        }
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        Iterator<A2> it = this.f15099X.iterator();
        while (it.hasNext()) {
            visitor.b(it.next());
        }
    }

    public final void b(ClipData clipData, TreeMap treeMap) {
        Intent intent;
        byte[] byteArrayExtra;
        h.a aVar = R3.h.f6422t1;
        if (clipData != null) {
            ClipDescription description = clipData.getDescription();
            if (description.hasMimeType("text/vnd.android.intent")) {
                int itemCount = clipData.getItemCount();
                for (int i8 = 0; i8 < itemCount; i8++) {
                    ClipData.Item itemAt = clipData.getItemAt(i8);
                    if (itemAt != null && (intent = itemAt.getIntent()) != null && (byteArrayExtra = intent.getByteArrayExtra("com.llamalab.automate.intent.extra.FLOW_DATA")) != null) {
                        c.a aVar2 = new c.a(new ByteArrayInputStream(byteArrayExtra), treeMap);
                        try {
                            aVar2.f6408Z = aVar;
                            o0(aVar2);
                            aVar2.close();
                            this.f15100Y = description.getLabel();
                        } catch (Throwable th) {
                            aVar2.close();
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public final ClipData c() {
        Intent intent = new Intent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(MoreOsConstants.O_DSYNC);
        K0 k02 = new K0(this, byteArrayOutputStream);
        try {
            Y0(k02);
            k02.flush();
            k02.close();
            return new ClipData(this.f15100Y, new String[]{"text/vnd.android.intent"}, new ClipData.Item(this.f15100Y, intent.putExtra("com.llamalab.automate.intent.extra.FLOW_DATA", byteArrayOutputStream.toByteArray()), null));
        } catch (Throwable th) {
            k02.close();
            throw th;
        }
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        int readInt = cVar.readInt();
        if (1279346284 != readInt) {
            throw new StreamCorruptedException(B4.g.f(readInt, new StringBuilder("Bad magic: 0x")));
        }
        cVar.n(114);
        cVar.f6410y0 = 106 <= cVar.f6409x0;
        A2[] a2Arr = (A2[]) cVar.g(A2.f14469E1);
        Arrays.sort(a2Arr, A2.f14470F1);
        this.f15099X = Arrays.asList(a2Arr);
    }

    public L0(String str, HashSet hashSet) {
        this.f15099X = hashSet;
        this.f15100Y = str;
    }
}
