package com.llamalab.automate.stmt;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.InterfaceC1592j0;
import com.llamalab.automate.S1;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/* renamed from: com.llamalab.automate.stmt.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC1641e0 extends S1 implements InterfaceC1592j0, AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, Runnable {

    /* renamed from: L1, reason: collision with root package name */
    public MediaPlayer f17382L1;

    /* renamed from: M1, reason: collision with root package name */
    public final Object f17383M1;

    /* renamed from: N1, reason: collision with root package name */
    public final float f17384N1;

    /* renamed from: O1, reason: collision with root package name */
    public final int f17385O1;

    /* renamed from: P1, reason: collision with root package name */
    public final int f17386P1;

    /* renamed from: Q1, reason: collision with root package name */
    public final boolean f17387Q1;

    /* renamed from: y1, reason: collision with root package name */
    public AudioManager f17388y1;

    public AbstractRunnableC1641e0(MediaPlayer mediaPlayer, Object obj, float f8, int i8, int i9, boolean z7) {
        this.f17382L1 = mediaPlayer;
        this.f17383M1 = obj;
        this.f17384N1 = f8;
        this.f17385O1 = i8;
        this.f17386P1 = i9;
        this.f17387Q1 = z7;
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnSeekCompleteListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
    }

    public final void A2() {
        AudioManager audioManager = (AudioManager) this.f15400Y.getSystemService("audio");
        this.f17388y1 = audioManager;
        int i8 = Build.VERSION.SDK_INT;
        int i9 = this.f17385O1;
        Object obj = this.f17383M1;
        int requestAudioFocus = 26 <= i8 ? audioManager.requestAudioFocus(new AudioFocusRequest.Builder(i9).setAudioAttributes((AudioAttributes) obj).setAcceptsDelayedFocusGain(true).setWillPauseWhenDucked(true).setOnAudioFocusChangeListener(this, this.f15400Y.f14581L1).build()) : audioManager.requestAudioFocus(this, ((Integer) obj).intValue(), i9);
        if (requestAudioFocus == 1) {
            this.f17382L1.start();
        } else if (requestAudioFocus != 2) {
            throw new IllegalStateException(B4.g.g("requestAudioFocus failed: ", requestAudioFocus));
        }
    }

    @Override // com.llamalab.automate.S1, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        automateService.f14581L1.removeCallbacks(this);
        MediaPlayer mediaPlayer = this.f17382L1;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Throwable unused) {
            }
            this.f17382L1 = null;
        }
        AudioManager audioManager = this.f17388y1;
        if (audioManager != null) {
            try {
                audioManager.abandonAudioFocus(this);
            } catch (Throwable unused2) {
            }
        }
        super.F(automateService);
    }

    @Override // com.llamalab.automate.InterfaceC1592j0
    public final void P0(AutomateService automateService, Intent intent) {
        MediaPlayer mediaPlayer = this.f17382L1;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
            } catch (Throwable unused) {
            }
        }
        if (this.f17387Q1) {
            p2(null);
        } else {
            a();
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i8) {
        float f8 = this.f17384N1;
        try {
            if (i8 == -3) {
                this.f17382L1.setVolume(f8 * 0.2f, f8 * 0.2f);
                return;
            }
            if (i8 == -2) {
                this.f17382L1.pause();
                return;
            }
            if (i8 == -1) {
                this.f17382L1.pause();
                this.f15400Y.f14581L1.postDelayed(this, this.f17382L1.getDuration() >= 0 ? r4 - this.f17382L1.getCurrentPosition() : 30000);
            } else {
                if (i8 != 1) {
                    return;
                }
                this.f15400Y.f14581L1.removeCallbacks(this);
                this.f17382L1.setVolume(f8, f8);
                this.f17382L1.start();
            }
        } catch (Throwable th) {
            r2(th);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f17387Q1) {
            p2(null);
        } else {
            a();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i8, int i9) {
        String str;
        Log.e("MediaPlayerTask", "onError: what=" + i8 + ", extra=" + i9);
        if (i8 != 100) {
            try {
                str = " (0x" + Integer.toHexString(i8) + ")";
            } catch (Throwable th) {
                r2(th);
                return true;
            }
        } else {
            str = " (Media server died)";
        }
        if (i9 == -1010) {
            throw new IOException("Media format not supported" + str);
        }
        if (i9 == -1007) {
            throw new IOException("Malformed media content" + str);
        }
        if (i9 == -1004) {
            throw new IOException("Failed to read from file or network" + str);
        }
        if (i9 == -110) {
            throw new TimeoutException("Timed out" + str);
        }
        throw new RuntimeException("Unknown failure (0x" + Integer.toHexString(i9) + ")" + str);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        try {
            float f8 = this.f17384N1;
            mediaPlayer.setVolume(f8, f8);
            int i8 = this.f17386P1;
            if (i8 > 0) {
                mediaPlayer.seekTo(i8);
            } else if (this.f17385O1 == 0) {
                mediaPlayer.start();
            } else {
                A2();
            }
        } catch (Throwable th) {
            r2(th);
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        try {
            if (this.f17385O1 == 0) {
                mediaPlayer.start();
            } else {
                A2();
            }
        } catch (Throwable th) {
            r2(th);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        F5.n.f(this, "MediaPlayerTask lost audio focus");
        onCompletion(this.f17382L1);
    }
}
