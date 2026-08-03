package com.llamalab.automate.stmt;

import android.content.ComponentName;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Handler;
import com.llamalab.automate.AutomateNotificationListenerServiceKitKat;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1695w;
import com.llamalab.automate.C1699x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import x3.C2437o;

/* renamed from: com.llamalab.automate.stmt.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1645g0 extends com.llamalab.automate.W implements MediaSessionManager.OnActiveSessionsChangedListener {

    /* renamed from: M1, reason: collision with root package name */
    public final String f17420M1;

    /* renamed from: y1, reason: collision with root package name */
    public final AtomicBoolean f17421y1 = new AtomicBoolean();

    /* renamed from: L1, reason: collision with root package name */
    public final HashMap f17419L1 = new HashMap();

    /* renamed from: com.llamalab.automate.stmt.g0$a */
    public final class a extends MediaController.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final MediaController f17422a;

        /* renamed from: b, reason: collision with root package name */
        public final C2437o f17423b;

        public a(MediaController mediaController, Handler handler) {
            this.f17422a = mediaController;
            PlaybackState playbackState = mediaController.getPlaybackState();
            if (playbackState != null) {
                this.f17423b = new C2437o(playbackState, mediaController.getPackageName());
            }
            mediaController.registerCallback(this, handler);
        }

        @Override // android.media.session.MediaController.Callback
        public final void onMetadataChanged(MediaMetadata mediaMetadata) {
        }

        @Override // android.media.session.MediaController.Callback
        public final void onPlaybackStateChanged(PlaybackState playbackState) {
            int state;
            String packageName;
            MediaMetadata metadata;
            if (playbackState != null) {
                state = playbackState.getState();
                if (state != 0) {
                    packageName = this.f17422a.getPackageName();
                    C2437o c2437o = new C2437o(playbackState, packageName);
                    metadata = this.f17422a.getMetadata();
                    if (metadata == null || c2437o.b(this.f17423b)) {
                        return;
                    }
                    C1645g0.this.q2(new Object[]{c2437o, metadata}, false);
                }
            }
        }

        @Override // android.media.session.MediaController.Callback
        public final void onSessionDestroyed() {
            MediaSession.Token sessionToken;
            try {
                this.f17422a.unregisterCallback(this);
            } catch (Throwable unused) {
            }
            synchronized (C1645g0.this.f17419L1) {
                HashMap hashMap = C1645g0.this.f17419L1;
                sessionToken = this.f17422a.getSessionToken();
                hashMap.remove(sessionToken);
            }
        }

        public final String toString() {
            String packageName;
            MediaSession.Token sessionToken;
            int hashCode;
            StringBuilder sb = new StringBuilder();
            packageName = this.f17422a.getPackageName();
            sb.append(packageName);
            sb.append("#");
            sessionToken = this.f17422a.getSessionToken();
            hashCode = sessionToken.hashCode();
            sb.append(Integer.toHexString(hashCode));
            return sb.toString();
        }
    }

    public C1645g0(String str) {
        this.f17420M1 = str;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        List<MediaController> activeSessions;
        super.C(automateService, j8, j9, j10);
        MediaSessionManager m8 = C1695w.m(automateService.getSystemService("media_session"));
        try {
            this.f17421y1.set(true);
            ComponentName componentName = new ComponentName(automateService, (Class<?>) AutomateNotificationListenerServiceKitKat.class);
            m8.addOnActiveSessionsChangedListener(this, componentName, automateService.f14581L1);
            activeSessions = m8.getActiveSessions(componentName);
            onActiveSessionsChanged(activeSessions);
        } catch (SecurityException unused) {
            throw new IllegalStateException("Notification access disabled");
        }
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        if (this.f17421y1.compareAndSet(true, false)) {
            try {
                C1695w.m(automateService.getSystemService("media_session")).removeOnActiveSessionsChangedListener(this);
            } catch (Throwable unused) {
            }
        }
        synchronized (this.f17419L1) {
            for (a aVar : this.f17419L1.values()) {
                aVar.getClass();
                try {
                    aVar.f17422a.unregisterCallback(aVar);
                } catch (Throwable unused2) {
                }
            }
            this.f17419L1.clear();
        }
        u2();
    }

    @Override // android.media.session.MediaSessionManager.OnActiveSessionsChangedListener
    public final void onActiveSessionsChanged(List<MediaController> list) {
        MediaSession.Token sessionToken;
        MediaSession.Token sessionToken2;
        String packageName;
        if (this.f17421y1.get()) {
            Handler handler = this.f15400Y.f14581L1;
            synchronized (this.f17419L1) {
                Iterator<MediaController> it = list.iterator();
                while (it.hasNext()) {
                    MediaController k8 = C1699x.k(it.next());
                    String str = this.f17420M1;
                    if (str != null) {
                        packageName = k8.getPackageName();
                        if (str.equals(packageName)) {
                        }
                    }
                    HashMap hashMap = this.f17419L1;
                    sessionToken = k8.getSessionToken();
                    if (!hashMap.containsKey(sessionToken)) {
                        HashMap hashMap2 = this.f17419L1;
                        sessionToken2 = k8.getSessionToken();
                        hashMap2.put(sessionToken2, new a(k8, handler));
                    }
                }
            }
        }
    }
}
