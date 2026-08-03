package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.Locale;

@F3.f("speak_to_file.html")
@F3.a(C2541R.integer.ic_megaphone)
@F3.i(C2541R.string.stmt_speak_to_file_title)
@F3.h(C2541R.string.stmt_speak_to_file_summary)
@F3.e(C2541R.layout.stmt_speak_to_file_edit)
/* loaded from: classes.dex */
public final class SpeakToFile extends Action implements AsyncStatement {
    public InterfaceC1700x0 engine;
    public InterfaceC1700x0 language;
    public InterfaceC1700x0 message;
    public InterfaceC1700x0 offline;
    public InterfaceC1700x0 rate;
    public InterfaceC1700x0 targetPath;
    public J3.l varAudioFile;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_speak_to_file_title);
        l8.v(this.message, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.engine);
        if (77 <= dVar.f6413Z) {
            dVar.g(this.offline);
        }
        dVar.g(this.language);
        dVar.g(this.message);
        if (67 <= dVar.f6413Z) {
            dVar.g(this.rate);
        }
        dVar.g(this.targetPath);
        dVar.g(this.varAudioFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.engine);
        visitor.b(this.offline);
        visitor.b(this.language);
        visitor.b(this.message);
        visitor.b(this.rate);
        visitor.b(this.targetPath);
        visitor.b(this.varAudioFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.engine = (InterfaceC1700x0) cVar.readObject();
        if (77 <= cVar.f6409x0) {
            this.offline = (InterfaceC1700x0) cVar.readObject();
        }
        this.language = (InterfaceC1700x0) cVar.readObject();
        this.message = (InterfaceC1700x0) cVar.readObject();
        if (67 <= cVar.f6409x0) {
            this.rate = (InterfaceC1700x0) cVar.readObject();
        }
        this.targetPath = (InterfaceC1700x0) cVar.readObject();
        this.varAudioFile = (J3.l) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        r0 = android.speech.tts.TextToSpeech.getMaxSpeechInputLength();
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        int maxSpeechInputLength;
        c1708z0.q(C2541R.string.stmt_speak_to_file_title);
        String x7 = J3.h.x(c1708z0, this.message, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("message");
        }
        if (18 <= Build.VERSION.SDK_INT && x7.length() > maxSpeechInputLength) {
            throw new IllegalArgumentException(C1.H0.o("Message to long, max ", maxSpeechInputLength, " characters"));
        }
        String x8 = J3.h.x(c1708z0, this.engine, null);
        boolean f8 = J3.h.f(c1708z0, this.offline, false);
        Locale r8 = J3.h.r(c1708z0, this.language, null);
        double i8 = J3.h.i(c1708z0, this.rate, 100.0d) / 100.0d;
        c1708z0.w(new d1(x8, r8, x7, f8 ? 1 : 0, (float) i8, J3.h.p(c1708z0, this.targetPath)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varAudioFile;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
