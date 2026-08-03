package com.llamalab.automate.stmt;

import C1.C0416j9;
import C1.C0493q9;
import C1.Z8;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.google.mlkit.vision.barcode.internal.zzh;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

@F3.f("barcode_scan.html")
@F3.a(C2541R.integer.ic_qr_code_2)
@F3.i(C2541R.string.stmt_barcode_scan_title)
@F3.h(C2541R.string.stmt_barcode_scan_summary)
@F3.e(C2541R.layout.stmt_barcode_scan_edit)
/* loaded from: classes.dex */
public final class BarcodeScan extends Action implements AsyncStatement {
    public InterfaceC1700x0 formats;
    public InterfaceC1700x0 uri;
    public J3.l varBoundingBoxes;
    public J3.l varFormats;
    public J3.l varRawValues;

    public static final class a extends u1<List<V2.a>, U2.a> {
        public a(zzh zzhVar, Uri uri) {
            super(zzhVar, uri);
        }

        @Override // com.llamalab.automate.stmt.u1
        public final N1.h<List<V2.a>> y2(U2.a aVar, Y2.a aVar2) {
            return aVar.l(aVar2);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        int i8 = Build.VERSION.SDK_INT;
        if (30 > i8) {
            return 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_MEDIA_LOCATION"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_MEDIA_LOCATION"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_MEDIA_LOCATION"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.uri);
        dVar.g(this.formats);
        dVar.g(this.varRawValues);
        dVar.g(this.varFormats);
        dVar.g(this.varBoundingBoxes);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.uri);
        visitor.b(this.formats);
        visitor.b(this.varRawValues);
        visitor.b(this.varFormats);
        visitor.b(this.varBoundingBoxes);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.formats = (InterfaceC1700x0) cVar.readObject();
        this.varRawValues = (J3.l) cVar.readObject();
        this.varFormats = (J3.l) cVar.readObject();
        this.varBoundingBoxes = (J3.l) cVar.readObject();
    }

    public final void q(C1708z0 c1708z0, J3.a aVar, J3.a aVar2, J3.a aVar3) {
        J3.l lVar = this.varRawValues;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, aVar);
        }
        J3.l lVar2 = this.varFormats;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, aVar2);
        }
        J3.l lVar3 = this.varBoundingBoxes;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, aVar3);
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int i8;
        C0416j9 b8;
        c1708z0.q(C2541R.string.stmt_barcode_scan_title);
        IncapableAndroidVersionException.a(21);
        Uri g8 = J3.h.g(c1708z0, this.uri, null);
        if (g8 == null) {
            throw new RequiredArgumentNullException("uri");
        }
        int[] n8 = J3.h.n(c1708z0, this.formats, null);
        if (n8 == null || n8.length == 0) {
            i8 = 0;
        } else {
            i8 = n8[0];
            int[] copyOfRange = Arrays.copyOfRange(n8, 1, n8.length);
            if (copyOfRange != null) {
                for (int i9 : copyOfRange) {
                    i8 |= i9;
                }
            }
        }
        U2.b bVar = new U2.b(i8);
        X2.c cVar = (X2.c) S2.h.c().a(X2.c.class);
        cVar.getClass();
        X2.f fVar = (X2.f) cVar.f7422a.b(bVar);
        Executor executor = (Executor) cVar.f7423b.f6479a.get();
        String str = true != X2.a.c() ? "play-services-mlkit-barcode-scanning" : "barcode-scanning";
        synchronized (C0493q9.class) {
            byte b9 = (byte) (((byte) 1) | 2);
            if (b9 != 3) {
                StringBuilder sb = new StringBuilder();
                if ((b9 & 1) == 0) {
                    sb.append(" enableFirelog");
                }
                if ((b9 & 2) == 0) {
                    sb.append(" firelogEventType");
                }
                throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
            }
            b8 = C0493q9.b(new Z8(str, true, 1));
        }
        a aVar = new a(new zzh(bVar, fVar, executor, b8), g8);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.a aVar = null;
        if (obj == null) {
            q(c1708z0, null, null, null);
            return true;
        }
        List<V2.a> list = (List) obj;
        J3.a aVar2 = this.varRawValues != null ? new J3.a(list.size()) : null;
        J3.a aVar3 = this.varFormats != null ? new J3.a(list.size()) : null;
        J3.a aVar4 = this.varBoundingBoxes != null ? new J3.a(list.size()) : null;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        for (V2.a aVar5 : list) {
            String a8 = aVar5.f6983a.a();
            if (a8 != null) {
                if (aVar2 != null) {
                    aVar2.add(a8);
                    z7 = true;
                }
                if (aVar3 != null) {
                    int format = aVar5.f6983a.getFormat();
                    if (format > 4096 || format == 0) {
                        format = -1;
                    }
                    if (-1 != format) {
                        aVar3.add(Double.valueOf(format));
                        z8 = true;
                    } else {
                        aVar3.add(null);
                    }
                }
                if (aVar4 != null) {
                    Rect rect = aVar5.f6984b;
                    if (rect != null) {
                        aVar4.add(J3.h.D(rect));
                        z9 = true;
                    } else {
                        aVar4.add(null);
                    }
                }
            }
        }
        if (!z7) {
            aVar2 = null;
        }
        if (!z7 || !z8) {
            aVar3 = null;
        }
        if (z7 && z9) {
            aVar = aVar4;
        }
        q(c1708z0, aVar2, aVar3, aVar);
        return true;
    }
}
