package com.llamalab.automate.stmt;

import E1.g7;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import b3.C1290a;
import c3.C1311a;
import com.google.mlkit.vision.text.internal.TextRecognizerImpl;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import d3.C1719a;
import e3.C1751c;
import f3.C1788a;
import g3.C1826a;
import h3.C1874a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

@F3.f("text_recognition.html")
@F3.a(C2541R.integer.ic_document_scanner)
@F3.i(C2541R.string.stmt_text_recognition_title)
@F3.h(C2541R.string.stmt_text_recognition_summary)
@F3.e(C2541R.layout.stmt_text_recognition_edit)
/* loaded from: classes.dex */
public final class TextRecognition extends Action implements AsyncStatement {

    /* renamed from: L1, reason: collision with root package name */
    public static final String[] f17196L1 = {"gan", "hak", "hsn", "lzh", "nan", "wuu", "yue", "za", "zh"};

    /* renamed from: M1, reason: collision with root package name */
    public static final String[] f17197M1 = {"anp", "awa", "bap", "bfy", "bgc", "bhb", "bhi", "bho", "bjj", "bra", "brx", "btv", "doi", "dty", "gbm", "gom", "gon", "gvr", "hi", "hif", "hne", "hoc", "hoj", "jml", "kfr", "kfy", "khn", "kok", "kru", "ks", "kxv", "lif", "mag", "mai", "mgp", "mr", "mrd", "mtr", "mwr", "ne", "new", "noe", "pi", "raj", "rjs", "sa", "sat", "sck", "sd", "srx", "swv", "taj", "tdg", "tdh", "thl", "thq", "thr", "tkt", "unr", "unx", "wbr", "wtm", "xnr", "xsr"};

    /* renamed from: N1, reason: collision with root package name */
    public static final String[] f17198N1 = {"ja"};

    /* renamed from: O1, reason: collision with root package name */
    public static final String[] f17199O1 = {"ko", "vi"};
    public InterfaceC1700x0 language;
    public InterfaceC1700x0 uri;
    public J3.l varBoundingBoxes;
    public J3.l varConfidenceScores;
    public J3.l varRecognizedLanguages;
    public J3.l varTextBlocks;

    public static final class a extends u1<C1290a, b3.b> {
        public a(TextRecognizerImpl textRecognizerImpl, Uri uri) {
            super(textRecognizerImpl, uri);
        }

        @Override // com.llamalab.automate.stmt.u1
        public final N1.h<C1290a> y2(b3.b bVar, Y2.a aVar) {
            return bVar.l(aVar);
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
        dVar.g(this.language);
        dVar.g(this.varTextBlocks);
        dVar.g(this.varConfidenceScores);
        dVar.g(this.varRecognizedLanguages);
        dVar.g(this.varBoundingBoxes);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.uri);
        visitor.b(this.language);
        visitor.b(this.varTextBlocks);
        visitor.b(this.varConfidenceScores);
        visitor.b(this.varRecognizedLanguages);
        visitor.b(this.varBoundingBoxes);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.language = (InterfaceC1700x0) cVar.readObject();
        this.varTextBlocks = (J3.l) cVar.readObject();
        this.varConfidenceScores = (J3.l) cVar.readObject();
        this.varRecognizedLanguages = (J3.l) cVar.readObject();
        this.varBoundingBoxes = (J3.l) cVar.readObject();
    }

    public final void q(C1708z0 c1708z0, J3.a aVar, J3.a aVar2, J3.a aVar3, J3.a aVar4) {
        J3.l lVar = this.varTextBlocks;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, aVar);
        }
        J3.l lVar2 = this.varConfidenceScores;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, aVar2);
        }
        J3.l lVar3 = this.varRecognizedLanguages;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, aVar3);
        }
        J3.l lVar4 = this.varBoundingBoxes;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, aVar4);
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0104  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        b3.c cVar;
        Executor e8;
        Locale forLanguageTag;
        String script;
        char c8;
        c1708z0.q(C2541R.string.stmt_text_recognition_title);
        IncapableAndroidVersionException.a(21);
        Uri g8 = J3.h.g(c1708z0, this.uri, null);
        if (g8 == null) {
            throw new RequiredArgumentNullException("uri");
        }
        String x7 = J3.h.x(c1708z0, this.language, Locale.getDefault().toString());
        if (x7 != null) {
            forLanguageTag = Locale.forLanguageTag(x7);
            script = forLanguageTag.getScript();
            script.getClass();
            switch (script.hashCode()) {
                case 2126604:
                    if (script.equals("Deva")) {
                        c8 = 0;
                        break;
                    }
                    c8 = 65535;
                    break;
                case 2241682:
                    if (script.equals("Hang")) {
                        c8 = 1;
                        break;
                    }
                    c8 = 65535;
                    break;
                case 2241684:
                    if (script.equals("Hani")) {
                        c8 = 2;
                        break;
                    }
                    c8 = 65535;
                    break;
                case 2241694:
                    if (script.equals("Hans")) {
                        c8 = 3;
                        break;
                    }
                    c8 = 65535;
                    break;
                case 2241695:
                    if (script.equals("Hant")) {
                        c8 = 4;
                        break;
                    }
                    c8 = 65535;
                    break;
                case 2315283:
                    if (script.equals("Jpan")) {
                        c8 = 5;
                        break;
                    }
                    c8 = 65535;
                    break;
                case 2344631:
                    if (script.equals("Kore")) {
                        c8 = 6;
                        break;
                    }
                    c8 = 65535;
                    break;
                default:
                    c8 = 65535;
                    break;
            }
            switch (c8) {
                case 0:
                    cVar = new C1719a();
                    break;
                case 1:
                case 2:
                case 6:
                    cVar = new C1826a();
                    break;
                case 3:
                case 4:
                    cVar = new C1311a();
                    break;
                case 5:
                    cVar = new C1788a();
                    break;
                default:
                    String language = forLanguageTag.getLanguage();
                    if (Arrays.binarySearch(f17196L1, language) < 0) {
                        if (Arrays.binarySearch(f17197M1, language) < 0) {
                            if (Arrays.binarySearch(f17198N1, language) < 0) {
                                if (Arrays.binarySearch(f17199O1, language) >= 0) {
                                    cVar = new C1826a();
                                    break;
                                }
                            } else {
                                cVar = new C1788a();
                                break;
                            }
                        } else {
                            cVar = new C1719a();
                            break;
                        }
                    } else {
                        cVar = new C1311a();
                        break;
                    }
                    break;
            }
            e3.k kVar = (e3.k) S2.h.c().a(e3.k.class);
            kVar.getClass();
            C1751c c1751c = (C1751c) kVar.f18153a.b(cVar);
            e8 = cVar.e();
            S2.d dVar = kVar.f18154b;
            if (e8 == null) {
                dVar.getClass();
            } else {
                e8 = (Executor) dVar.f6479a.get();
            }
            a aVar = new a(new TextRecognizerImpl(c1751c, e8, g7.e(cVar.c()), cVar), g8);
            c1708z0.w(aVar);
            aVar.w2();
            return false;
        }
        cVar = C1874a.f19150c;
        e3.k kVar2 = (e3.k) S2.h.c().a(e3.k.class);
        kVar2.getClass();
        C1751c c1751c2 = (C1751c) kVar2.f18153a.b(cVar);
        e8 = cVar.e();
        S2.d dVar2 = kVar2.f18154b;
        if (e8 == null) {
        }
        a aVar2 = new a(new TextRecognizerImpl(c1751c2, e8, g7.e(cVar.c()), cVar), g8);
        c1708z0.w(aVar2);
        aVar2.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        List list;
        Iterator it;
        String str;
        Iterator it2;
        int i8;
        float f8;
        int i9 = 1;
        if (obj == null) {
            q(c1708z0, null, null, null, null);
            return true;
        }
        List unmodifiableList = Collections.unmodifiableList(((C1290a) obj).f11478a);
        J3.a aVar = this.varTextBlocks != null ? new J3.a(unmodifiableList.size()) : null;
        J3.a aVar2 = this.varConfidenceScores != null ? new J3.a(unmodifiableList.size()) : null;
        J3.a aVar3 = this.varRecognizedLanguages != null ? new J3.a(unmodifiableList.size()) : null;
        J3.a aVar4 = this.varBoundingBoxes != null ? new J3.a(unmodifiableList.size()) : null;
        Iterator it3 = unmodifiableList.iterator();
        int i10 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (it3.hasNext()) {
            C1290a.e eVar = (C1290a.e) it3.next();
            synchronized (eVar) {
                list = eVar.f11485d;
            }
            if (!list.isEmpty()) {
                if (aVar != null) {
                    String str2 = eVar.f11482a;
                    if (str2 == null) {
                        str2 = "";
                    }
                    aVar.add(str2);
                }
                if (aVar2 != null) {
                    if (list.size() == i9) {
                        f8 = ((C1290a.b) list.get(i10)).f11481e;
                    } else {
                        Iterator it4 = list.iterator();
                        float f9 = 1.0f;
                        while (it4.hasNext()) {
                            float f10 = ((C1290a.b) it4.next()).f11481e;
                            if (f9 > f10) {
                                f9 = f10;
                            }
                        }
                        f8 = f9;
                    }
                    if (f8 > 0.0f) {
                        aVar2.add(Double.valueOf(f8));
                        z7 = true;
                    } else {
                        aVar2.add(Double.valueOf(-1.0d));
                    }
                }
                if (aVar3 != null) {
                    String str3 = eVar.f11484c;
                    if ("und".equals(str3)) {
                        if (list.size() == i9) {
                            str = ((C1290a.b) list.get(i10)).f11484c;
                            it = it3;
                        } else {
                            HashMap hashMap = new HashMap();
                            Iterator it5 = list.iterator();
                            String str4 = "und";
                            while (it5.hasNext()) {
                                String str5 = ((C1290a.b) it5.next()).f11484c;
                                if ("und".equals(str5)) {
                                    it2 = it3;
                                } else {
                                    Integer num = (Integer) hashMap.get(str5);
                                    if (num != null) {
                                        i8 = num.intValue() + 1;
                                        it2 = it3;
                                    } else {
                                        it2 = it3;
                                        i8 = 1;
                                    }
                                    Integer valueOf = Integer.valueOf(i8);
                                    hashMap.put(str5, valueOf);
                                    if (i10 <= valueOf.intValue()) {
                                        i10 = valueOf.intValue();
                                        str4 = str5;
                                    }
                                }
                                it3 = it2;
                            }
                            it = it3;
                            str = str4;
                        }
                        if ("und".equals(str)) {
                            aVar3.add(null);
                        } else {
                            str3 = str;
                        }
                    } else {
                        it = it3;
                    }
                    aVar3.add(str3);
                    z8 = true;
                } else {
                    it = it3;
                }
                if (aVar4 != null) {
                    Rect rect = eVar.f11483b;
                    if (rect != null) {
                        aVar4.add(J3.h.D(rect));
                        z9 = true;
                    } else {
                        aVar4.add(null);
                    }
                }
                it3 = it;
                i9 = 1;
                i10 = 0;
            }
        }
        J3.a aVar5 = z7 ? aVar2 : null;
        if (!z8) {
            aVar3 = null;
        }
        if (!z9) {
            aVar4 = null;
        }
        q(c1708z0, aVar, aVar5, aVar3, aVar4);
        return true;
    }
}
