package com.llamalab.automate.stmt;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Log;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.InterfaceC1592j0;
import com.llamalab.automate.S1;

/* renamed from: com.llamalab.automate.stmt.h0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1647h0 extends S1 implements InterfaceC1592j0, AudioManager.OnAudioFocusChangeListener, MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener {

    /* renamed from: L1, reason: collision with root package name */
    public MediaRecorder f17429L1;

    /* renamed from: M1, reason: collision with root package name */
    public a f17430M1;

    /* renamed from: N1, reason: collision with root package name */
    public int f17431N1;

    /* renamed from: y1, reason: collision with root package name */
    public AudioManager f17432y1;

    /* renamed from: com.llamalab.automate.stmt.h0$a */
    public final class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            AbstractC1647h0 abstractC1647h0 = AbstractC1647h0.this;
            try {
                abstractC1647h0.C2(abstractC1647h0.f17429L1);
                if (abstractC1647h0.f17431N1 == 0) {
                    abstractC1647h0.f17429L1.start();
                } else {
                    AbstractC1647h0.A2(abstractC1647h0);
                }
            } catch (Throwable th) {
                abstractC1647h0.r2(th);
            }
        }
    }

    public AbstractC1647h0(MediaRecorder mediaRecorder, int i8) {
        this.f17429L1 = mediaRecorder;
        this.f17431N1 = i8;
        mediaRecorder.setOnInfoListener(this);
        mediaRecorder.setOnErrorListener(this);
    }

    public static void A2(AbstractC1647h0 abstractC1647h0) {
        AudioManager audioManager = (AudioManager) abstractC1647h0.f15400Y.getSystemService("audio");
        abstractC1647h0.f17432y1 = audioManager;
        int requestAudioFocus = 26 <= Build.VERSION.SDK_INT ? audioManager.requestAudioFocus(new AudioFocusRequest.Builder(abstractC1647h0.f17431N1).setAudioAttributes(new AudioAttributes.Builder().setContentType(0).setUsage(2).build()).setAcceptsDelayedFocusGain(true).setWillPauseWhenDucked(false).setOnAudioFocusChangeListener(abstractC1647h0, abstractC1647h0.f15400Y.f14581L1).build()) : audioManager.requestAudioFocus(abstractC1647h0, 3, abstractC1647h0.f17431N1);
        if (requestAudioFocus != 1) {
            if (requestAudioFocus != 2) {
                throw new IllegalStateException(B4.g.g("requestAudioFocus failed: ", requestAudioFocus));
            }
        } else {
            abstractC1647h0.f17431N1 = 0;
            abstractC1647h0.f17429L1.start();
        }
    }

    public abstract void B2();

    public abstract void C2(MediaRecorder mediaRecorder);

    @Override // com.llamalab.automate.S1, com.llamalab.automate.W, com.llamalab.automate.N2
    public void F(AutomateService automateService) {
        a aVar = this.f17430M1;
        if (aVar != null) {
            try {
                aVar.interrupt();
            } catch (Throwable unused) {
            }
            this.f17430M1 = null;
        }
        MediaRecorder mediaRecorder = this.f17429L1;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (Throwable unused2) {
            }
            try {
                this.f17429L1.release();
            } catch (Throwable unused3) {
            }
            this.f17429L1 = null;
        }
        AudioManager audioManager = this.f17432y1;
        if (audioManager != null) {
            try {
                audioManager.abandonAudioFocus(this);
            } catch (Throwable unused4) {
            }
        }
        super.F(automateService);
    }

    @Override // com.llamalab.automate.InterfaceC1592j0
    public final void P0(AutomateService automateService, Intent intent) {
        MediaRecorder mediaRecorder = this.f17429L1;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (Throwable unused) {
            }
            B2();
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i8) {
        if (1 == i8) {
            try {
                if (this.f17431N1 != 0) {
                    this.f17431N1 = 0;
                    this.f17429L1.start();
                }
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // android.media.MediaRecorder.OnErrorListener
    public final void onError(MediaRecorder mediaRecorder, int i8, int i9) {
        try {
            if (i8 == 1) {
                throw new IllegalStateException("Media recorder unknown error: " + i9);
            }
            if (i8 == 100) {
                throw new IllegalStateException("Media server died: " + i9);
            }
            throw new IllegalStateException("Media recorder error 0x" + Integer.toHexString(i8) + ": " + i9);
        } catch (Throwable th) {
            r2(th);
        }
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public final void onInfo(MediaRecorder mediaRecorder, int i8, int i9) {
        StringBuilder sb;
        StringBuilder sb2;
        if (i8 != 1) {
            switch (i8) {
                case 800:
                case 801:
                    B2();
                    return;
                case 802:
                    sb2 = new StringBuilder("onInfo: MEDIA_RECORDER_INFO_MAX_FILESIZE_APPROACHING: ");
                    break;
                case 803:
                    sb2 = new StringBuilder("onInfo: MEDIA_RECORDER_INFO_NEXT_OUTPUT_FILE_STARTED: ");
                    break;
                default:
                    sb = new StringBuilder("onInfo: Non-standard info 0x");
                    sb.append(Integer.toHexString(i8));
                    sb.append(": ");
                    break;
            }
            sb2.append(i9);
            Log.i("MediaRecorderTask", sb2.toString());
            return;
        }
        sb = new StringBuilder("onInfo: MEDIA_RECORDER_INFO_UNKNOWN: ");
        sb.append(i9);
        Log.w("MediaRecorderTask", sb.toString());
    }
}
