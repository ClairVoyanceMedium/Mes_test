package com.llamalab.automate.stmt;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.S1;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class c1 extends S1 implements TextToSpeech.OnInitListener {

    /* renamed from: R1, reason: collision with root package name */
    public static final String[] f17354R1 = {null, "Generic error", "Unknown error", "Synthesis error", "Service error", "File output error", "Network error", "Network timeout", "Invalid request", "Voice data not installed"};

    /* renamed from: S1, reason: collision with root package name */
    public static final AtomicInteger f17355S1 = new AtomicInteger();

    /* renamed from: L1, reason: collision with root package name */
    public final String f17356L1;

    /* renamed from: M1, reason: collision with root package name */
    public final Locale f17357M1;

    /* renamed from: N1, reason: collision with root package name */
    public final String f17358N1;

    /* renamed from: O1, reason: collision with root package name */
    public final float f17359O1;

    /* renamed from: P1, reason: collision with root package name */
    public final int f17360P1;

    /* renamed from: Q1, reason: collision with root package name */
    public String f17361Q1;

    /* renamed from: y1, reason: collision with root package name */
    public TextToSpeech f17362y1;

    public class a implements Runnable {

        /* renamed from: X, reason: collision with root package name */
        public final /* synthetic */ int f17363X;

        public a(int i8) {
            this.f17363X = i8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                synchronized (c1.this) {
                    c1 c1Var = c1.this;
                    TextToSpeech textToSpeech = c1Var.f17362y1;
                    if (textToSpeech == null) {
                        return;
                    }
                    if (this.f17363X == 0) {
                        c1Var.B2(textToSpeech, new Bundle());
                    } else {
                        throw new IllegalStateException("onInit failed: " + c1.A2(this.f17363X));
                    }
                }
            } catch (Throwable th) {
                c1.this.r2(th);
            }
        }
    }

    public class b extends UtteranceProgressListener {
        public b() {
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public final void onDone(String str) {
            if (c1.this.f17361Q1.equals(str)) {
                c1.this.C2();
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public final void onError(String str) {
            onError(str, -1);
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public final void onStart(String str) {
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public final void onError(String str, int i8) {
            if (c1.this.f17361Q1.equals(str)) {
                c1.this.onError(i8);
            }
        }
    }

    public class c implements TextToSpeech.OnUtteranceCompletedListener {
        public c() {
        }

        @Override // android.speech.tts.TextToSpeech.OnUtteranceCompletedListener
        public final void onUtteranceCompleted(String str) {
            c1 c1Var = c1.this;
            if (c1Var.f17361Q1.equals(str)) {
                c1Var.C2();
            }
        }
    }

    public c1(String str, Locale locale, String str2, int i8, float f8) {
        this.f17356L1 = str;
        this.f17357M1 = locale;
        this.f17358N1 = str2;
        this.f17360P1 = i8;
        this.f17359O1 = f8;
    }

    public static String A2(int i8) {
        int i9 = i8 * (-1);
        String[] strArr = f17354R1;
        return (i9 <= 0 || i9 >= 10) ? strArr[1] : strArr[i9];
    }

    public static HashMap<String, String> D2(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            hashMap.put(str, obj != null ? obj.toString() : null);
        }
        return hashMap;
    }

    public void B2(TextToSpeech textToSpeech, Bundle bundle) {
        String str;
        int speechRate;
        Locale locale = this.f17357M1;
        if (locale != null) {
            int language = textToSpeech.setLanguage(locale);
            if (language == -2) {
                throw new IllegalArgumentException("Language not supported: " + locale);
            }
            if (language == -1) {
                throw new IllegalArgumentException("Language data missing: " + locale);
            }
            if (language != 0 && language != 1 && language != 2) {
                Log.w("SpeakTask", "Unknown setLanguage status: " + language);
            }
        }
        float f8 = this.f17359O1;
        if (f8 != 1.0f && (speechRate = textToSpeech.setSpeechRate(f8)) != 0) {
            throw new IllegalStateException("setSpeechRate failed: " + A2(speechRate));
        }
        int i8 = Build.VERSION.SDK_INT;
        int onUtteranceProgressListener = 15 <= i8 ? textToSpeech.setOnUtteranceProgressListener(new b()) : textToSpeech.setOnUtteranceCompletedListener(new c());
        if (onUtteranceProgressListener != 0) {
            throw new IllegalStateException("setOnUtteranceProgressListener failed: " + A2(onUtteranceProgressListener));
        }
        String str2 = Long.toHexString(this.f15402x0) + "@" + Long.toHexString(this.f15404y0) + ":" + Integer.toHexString(f17355S1.incrementAndGet());
        this.f17361Q1 = str2;
        bundle.putString("utteranceId", str2);
        if (15 <= i8) {
            int i9 = this.f17360P1;
            if (1 == i9) {
                str = "embeddedTts";
            } else if (2 != i9) {
                return;
            } else {
                str = "networkTts";
            }
            bundle.putBoolean(str, true);
        }
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        n2(1);
        synchronized (this) {
            this.f17362y1 = this.f17356L1 != null ? new TextToSpeech(automateService, this, this.f17356L1) : new TextToSpeech(automateService, this);
        }
    }

    public abstract void C2();

    @Override // com.llamalab.automate.S1, com.llamalab.automate.W, com.llamalab.automate.N2
    public void F(AutomateService automateService) {
        TextToSpeech textToSpeech = this.f17362y1;
        if (textToSpeech != null) {
            try {
                textToSpeech.shutdown();
            } catch (Throwable unused) {
            }
            this.f17362y1 = null;
        }
        super.F(automateService);
    }

    public abstract void onError(int i8);

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public final void onInit(int i8) {
        this.f15400Y.f14581L1.post(new a(i8));
    }
}
