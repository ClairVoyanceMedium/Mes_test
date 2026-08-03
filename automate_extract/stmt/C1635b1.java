package com.llamalab.automate.stmt;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.InterfaceC1592j0;
import java.util.Locale;

/* renamed from: com.llamalab.automate.stmt.b1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1635b1 extends c1 implements InterfaceC1592j0, AudioManager.OnAudioFocusChangeListener {

    /* renamed from: T1, reason: collision with root package name */
    public final int f17342T1;
    public final float U1;

    /* renamed from: V1, reason: collision with root package name */
    public int f17343V1;
    public final boolean W1;

    /* renamed from: X1, reason: collision with root package name */
    public AudioManager f17344X1;

    /* renamed from: Y1, reason: collision with root package name */
    public Bundle f17345Y1;

    public C1635b1(boolean z7, String str, Locale locale, String str2, int i8, float f8, int i9, float f9, int i10) {
        super(str, locale, str2, i8, f8);
        this.W1 = z7;
        this.f17342T1 = i9;
        this.U1 = f9;
        this.f17343V1 = i10;
    }

    @Override // com.llamalab.automate.stmt.c1
    public final void B2(TextToSpeech textToSpeech, Bundle bundle) {
        int requestAudioFocus;
        super.B2(textToSpeech, bundle);
        this.f17345Y1 = bundle;
        int i8 = this.f17342T1;
        bundle.putInt("streamType", i8);
        bundle.putFloat("volume", this.U1);
        if (this.f17343V1 == 0) {
            E2();
            return;
        }
        this.f17344X1 = (AudioManager) this.f15400Y.getSystemService("audio");
        int i9 = Build.VERSION.SDK_INT;
        if (26 <= i9) {
            AudioAttributes build = new AudioAttributes.Builder().setLegacyStreamType(i8).setContentType(1).build();
            int audioAttributes = this.f17362y1.setAudioAttributes(build);
            if (audioAttributes != 0) {
                throw new IllegalStateException("setAudioAttributes failed: " + c1.A2(audioAttributes));
            }
            requestAudioFocus = this.f17344X1.requestAudioFocus(new AudioFocusRequest.Builder(this.f17343V1).setAudioAttributes(build).setAcceptsDelayedFocusGain(true).setWillPauseWhenDucked(false).setOnAudioFocusChangeListener(this, this.f15400Y.f14581L1).build());
        } else {
            if (21 <= i9) {
                int audioAttributes2 = this.f17362y1.setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(i8).setContentType(1).build());
                if (audioAttributes2 != 0) {
                    throw new IllegalStateException("setAudioAttributes failed: " + c1.A2(audioAttributes2));
                }
            }
            requestAudioFocus = this.f17344X1.requestAudioFocus(this, i8, this.f17343V1);
        }
        if (requestAudioFocus != 1) {
            if (requestAudioFocus != 2) {
                throw new IllegalStateException(B4.g.g("requestAudioFocus failed: ", requestAudioFocus));
            }
        } else {
            this.f17343V1 = 0;
            E2();
        }
    }

    @Override // com.llamalab.automate.stmt.c1
    public final void C2() {
        q2(null, false);
    }

    public final void E2() {
        TextToSpeech textToSpeech = this.f17362y1;
        if (textToSpeech != null) {
            int i8 = Build.VERSION.SDK_INT;
            String str = this.f17358N1;
            int speak = 21 <= i8 ? textToSpeech.speak(str, 1, this.f17345Y1, this.f17361Q1) : textToSpeech.speak(str, 1, c1.D2(this.f17345Y1));
            if (speak == 0) {
                return;
            }
            throw new IllegalStateException("speak failed: " + c1.A2(speak));
        }
    }

    @Override // com.llamalab.automate.stmt.c1, com.llamalab.automate.S1, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        super.F(automateService);
        AudioManager audioManager = this.f17344X1;
        if (audioManager != null) {
            try {
                audioManager.abandonAudioFocus(this);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.llamalab.automate.InterfaceC1592j0
    public final void P0(AutomateService automateService, Intent intent) {
        TextToSpeech textToSpeech = this.f17362y1;
        if (textToSpeech != null) {
            try {
                textToSpeech.stop();
            } catch (Throwable unused) {
            }
        }
        p2(null);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i8) {
        if (1 == i8) {
            try {
                if (this.f17343V1 != 0) {
                    this.f17343V1 = 0;
                    E2();
                }
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.c1
    public final void onError(int i8) {
        r2(new IllegalStateException("speak error: " + c1.A2(i8)).fillInStackTrace());
    }

    @Override // com.llamalab.automate.W
    public final void q2(Object obj, boolean z7) {
        if (this.W1) {
            super.q2(obj, false);
        } else {
            a();
        }
    }
}
