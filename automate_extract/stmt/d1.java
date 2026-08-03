package com.llamalab.automate.stmt;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import com.llamalab.automate.C2541R;
import i4.C1951e;
import java.util.Locale;

/* loaded from: classes.dex */
public final class d1 extends c1 {

    /* renamed from: T1, reason: collision with root package name */
    public com.llamalab.safs.n f17380T1;

    public d1(String str, Locale locale, String str2, int i8, float f8, com.llamalab.safs.n nVar) {
        super(str, locale, str2, i8, f8);
        this.f17380T1 = nVar;
    }

    @Override // com.llamalab.automate.stmt.c1
    public final void B2(TextToSpeech textToSpeech, Bundle bundle) {
        super.B2(textToSpeech, bundle);
        com.llamalab.safs.n t8 = w0.L.t(this.f17380T1, Environment.DIRECTORY_NOTIFICATIONS, null, C2541R.string.format_audio_file, "wav");
        this.f17380T1 = t8;
        int i8 = Build.VERSION.SDK_INT;
        String str = this.f17358N1;
        int synthesizeToFile = 30 <= i8 ? textToSpeech.synthesizeToFile(str, bundle, C1951e.b(t8, com.llamalab.safs.p.WRITE, com.llamalab.safs.p.CREATE, com.llamalab.safs.p.TRUNCATE_EXISTING), this.f17361Q1) : 21 <= i8 ? textToSpeech.synthesizeToFile(str, bundle, t8.R(), this.f17361Q1) : textToSpeech.synthesizeToFile(str, c1.D2(bundle), this.f17380T1.toString());
        if (synthesizeToFile == 0) {
            return;
        }
        throw new IllegalStateException("synthesizeToFile failed: " + c1.A2(synthesizeToFile));
    }

    @Override // com.llamalab.automate.stmt.c1
    public final void C2() {
        q2(this.f17380T1.toString(), false);
    }

    @Override // com.llamalab.automate.stmt.c1
    public final void onError(int i8) {
        r2(new IllegalStateException("synthesizeToFile error: " + c1.A2(i8)).fillInStackTrace());
    }
}
