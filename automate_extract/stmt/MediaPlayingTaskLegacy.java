package com.llamalab.automate.stmt;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.SystemClock;
import com.llamalab.automate.AutomateService;
import t3.AbstractBinderC2328f;
import x3.C2437o;

/* loaded from: classes.dex */
public final class MediaPlayingTaskLegacy extends com.llamalab.automate.W implements Runnable {

    /* renamed from: L1, reason: collision with root package name */
    public final boolean f16902L1;

    /* renamed from: M1, reason: collision with root package name */
    public C2437o f16903M1;

    /* renamed from: N1, reason: collision with root package name */
    public Bundle f16904N1;

    /* renamed from: O1, reason: collision with root package name */
    public C2437o f16905O1;

    /* renamed from: Q1, reason: collision with root package name */
    public long f16907Q1;

    /* renamed from: y1, reason: collision with root package name */
    public final String f16909y1;

    /* renamed from: P1, reason: collision with root package name */
    public long f16906P1 = Long.MAX_VALUE;

    /* renamed from: R1, reason: collision with root package name */
    public final AbstractBinderC2328f f16908R1 = new AbstractBinderC2328f() { // from class: com.llamalab.automate.stmt.MediaPlayingTaskLegacy.1

        /* renamed from: L1, reason: collision with root package name */
        public PendingIntent f16910L1;

        /* renamed from: M1, reason: collision with root package name */
        public int f16911M1 = -1;

        @AbstractBinderC2328f.c
        public void setAllMetadata(int i8, Bundle bundle, Bitmap bitmap) {
            PendingIntent pendingIntent;
            MediaPlayingTaskLegacy mediaPlayingTaskLegacy = MediaPlayingTaskLegacy.this;
            String str = mediaPlayingTaskLegacy.f16909y1;
            if (this.f16911M1 == i8 && (str == null || (pendingIntent = this.f16910L1) == null || str.equals(pendingIntent.getTargetPackage()))) {
                mediaPlayingTaskLegacy.f16904N1 = bundle;
                if (mediaPlayingTaskLegacy.f16903M1 != null) {
                    MediaPlayingTaskLegacy.v2(mediaPlayingTaskLegacy);
                }
            }
        }

        @AbstractBinderC2328f.c
        public void setArtwork(int i8, Bitmap bitmap) {
        }

        @AbstractBinderC2328f.c
        public void setCurrentClientId(int i8, PendingIntent pendingIntent, boolean z7) {
            this.f16911M1 = i8;
            this.f16910L1 = pendingIntent;
            MediaPlayingTaskLegacy mediaPlayingTaskLegacy = MediaPlayingTaskLegacy.this;
            mediaPlayingTaskLegacy.f16903M1 = null;
            mediaPlayingTaskLegacy.f16904N1 = null;
        }

        @AbstractBinderC2328f.c(min = 19)
        public void setEnabled(boolean z7) {
        }

        @AbstractBinderC2328f.c
        public void setMetadata(int i8, Bundle bundle) {
            PendingIntent pendingIntent;
            MediaPlayingTaskLegacy mediaPlayingTaskLegacy = MediaPlayingTaskLegacy.this;
            String str = mediaPlayingTaskLegacy.f16909y1;
            if (this.f16911M1 == i8 && (str == null || (pendingIntent = this.f16910L1) == null || str.equals(pendingIntent.getTargetPackage()))) {
                mediaPlayingTaskLegacy.f16904N1 = bundle;
                if (mediaPlayingTaskLegacy.f16903M1 != null) {
                    MediaPlayingTaskLegacy.v2(mediaPlayingTaskLegacy);
                }
            }
        }

        @AbstractBinderC2328f.c
        public void setPlaybackState(int i8, int i9, long j8, long j9, float f8) {
            PendingIntent pendingIntent;
            MediaPlayingTaskLegacy mediaPlayingTaskLegacy = MediaPlayingTaskLegacy.this;
            String str = mediaPlayingTaskLegacy.f16909y1;
            if (this.f16911M1 == i8 && (str == null || (pendingIntent = this.f16910L1) == null || str.equals(pendingIntent.getTargetPackage()))) {
                mediaPlayingTaskLegacy.f16907Q1 = SystemClock.elapsedRealtime();
                float f9 = f8 == 0.0f ? 1.0f : f8;
                PendingIntent pendingIntent2 = this.f16910L1;
                mediaPlayingTaskLegacy.f16903M1 = new C2437o(i9, j8, j9, f9, pendingIntent2 != null ? pendingIntent2.getTargetPackage() : null);
                if (mediaPlayingTaskLegacy.f16904N1 != null) {
                    MediaPlayingTaskLegacy.v2(mediaPlayingTaskLegacy);
                }
            }
        }

        @AbstractBinderC2328f.c(max = 17)
        public void setTransportControlFlags(int i8, int i9) {
        }

        @AbstractBinderC2328f.c(min = 18)
        public void setTransportControlInfo(int i8, int i9, int i10) {
        }
    };

    public MediaPlayingTaskLegacy(String str, boolean z7) {
        this.f16902L1 = z7;
        this.f16909y1 = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r0.b(r7.f16905O1) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void v2(MediaPlayingTaskLegacy mediaPlayingTaskLegacy) {
        if (!mediaPlayingTaskLegacy.f16902L1) {
            if (mediaPlayingTaskLegacy.f16906P1 < SystemClock.elapsedRealtime()) {
                long j8 = mediaPlayingTaskLegacy.f16907Q1;
                C2437o c2437o = mediaPlayingTaskLegacy.f16903M1;
                if (j8 - c2437o.f23412b < 150) {
                    if (c2437o.f23411a != 1) {
                    }
                }
            }
            mediaPlayingTaskLegacy.f16905O1 = mediaPlayingTaskLegacy.f16903M1;
        }
        mediaPlayingTaskLegacy.q2(new Object[]{mediaPlayingTaskLegacy.f16903M1, mediaPlayingTaskLegacy.f16904N1}, false);
        mediaPlayingTaskLegacy.f16905O1 = mediaPlayingTaskLegacy.f16903M1;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        AudioManager audioManager = (AudioManager) automateService.getSystemService("audio");
        Class<?> cls = audioManager.getClass();
        AbstractBinderC2328f abstractBinderC2328f = this.f16908R1;
        cls.getMethod("registerRemoteControlDisplay", abstractBinderC2328f.f22398Z).invoke(audioManager, abstractBinderC2328f.f22399x0);
        this.f16906P1 = SystemClock.elapsedRealtime() + 150;
        if (this.f16902L1) {
            automateService.f14581L1.postDelayed(this, 150L);
        }
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        if (this.f16902L1) {
            automateService.f14581L1.removeCallbacks(this);
        }
        try {
            AudioManager audioManager = (AudioManager) automateService.getSystemService("audio");
            Class<?> cls = audioManager.getClass();
            Class<?>[] clsArr = new Class[1];
            AbstractBinderC2328f abstractBinderC2328f = this.f16908R1;
            clsArr[0] = abstractBinderC2328f.f22398Z;
            cls.getMethod("unregisterRemoteControlDisplay", clsArr).invoke(audioManager, abstractBinderC2328f.f22399x0);
        } catch (Throwable unused) {
        }
        u2();
    }

    @Override // java.lang.Runnable
    public final void run() {
        q2(new Object[]{C2437o.c(this.f16909y1), null}, false);
    }
}
