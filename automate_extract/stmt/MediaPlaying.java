package com.llamalab.automate.stmt;

import android.content.ComponentName;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.RemoteController;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateNotificationListenerServiceKitKat;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1695w;
import com.llamalab.automate.C1699x;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.a3;
import java.util.Iterator;
import java.util.List;
import x3.C2437o;

@F3.f("media_playing.html")
@F3.a(C2541R.integer.ic_av_playing)
@F3.i(C2541R.string.stmt_media_playing_title)
@F3.h(C2541R.string.stmt_media_playing_summary)
@F3.e(C2541R.layout.stmt_media_playing_edit)
/* loaded from: classes.dex */
public final class MediaPlaying extends IntermittentDecision implements AsyncStatement {

    /* renamed from: L1, reason: collision with root package name */
    public static final String f16898L1 = Integer.toString(7);

    /* renamed from: M1, reason: collision with root package name */
    public static final String f16899M1 = Integer.toString(1);

    /* renamed from: N1, reason: collision with root package name */
    public static final String f16900N1 = Integer.toString(2);

    /* renamed from: O1, reason: collision with root package name */
    public static final String f16901O1 = Integer.toString(9);
    public InterfaceC1700x0 packageName;
    public J3.l varAlbum;
    public J3.l varArtist;
    public J3.l varArtworkUri;
    public J3.l varDuration;
    public J3.l varPackageName;
    public J3.l varPosition;
    public J3.l varTitle;

    public final void B(C1708z0 c1708z0, C2437o c2437o, long j8, String str, String str2, String str3, String str4) {
        J3.l lVar = this.varTitle;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varAlbum;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str2);
        }
        J3.l lVar3 = this.varArtist;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, str3);
        }
        J3.l lVar4 = this.varArtworkUri;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, str4);
        }
        J3.l lVar5 = this.varDuration;
        if (lVar5 != null) {
            if (j8 < 0) {
                c1708z0.z(lVar5.f4659Y, null);
            } else {
                double d8 = j8;
                c1708z0.z(lVar5.f4659Y, F5.n.l(d8, d8, d8, 1000.0d));
            }
        }
        J3.l lVar6 = this.varPosition;
        if (lVar6 != null) {
            if (c2437o.f23413c < 0) {
                c1708z0.z(lVar6.f4659Y, null);
            } else {
                double a8 = j8 < 0 ? c2437o.a(SystemClock.elapsedRealtime()) : Math.min(c2437o.a(SystemClock.elapsedRealtime()), j8);
                c1708z0.z(lVar6.f4659Y, F5.n.l(a8, a8, a8, 1000.0d));
            }
        }
        J3.l lVar7 = this.varPackageName;
        if (lVar7 != null) {
            c1708z0.z(lVar7.f4659Y, c2437o.f23415e);
        }
        o(c1708z0, 7 == c2437o.f23411a);
    }

    public final void C(C1708z0 c1708z0, MediaController mediaController) {
        PlaybackState playbackState;
        String packageName;
        C2437o c8;
        MediaMetadata metadata;
        String packageName2;
        playbackState = mediaController.getPlaybackState();
        if (playbackState != null) {
            packageName2 = mediaController.getPackageName();
            c8 = new C2437o(playbackState, packageName2);
        } else {
            packageName = mediaController.getPackageName();
            c8 = C2437o.c(packageName);
        }
        metadata = mediaController.getMetadata();
        D(c1708z0, c8, metadata);
    }

    public final void D(C1708z0 c1708z0, C2437o c2437o, MediaMetadata mediaMetadata) {
        long j8;
        String string;
        String string2;
        String string3;
        String string4;
        if (mediaMetadata == null) {
            B(c1708z0, c2437o, -1L, null, null, null, null);
            return;
        }
        j8 = mediaMetadata.getLong("android.media.metadata.DURATION");
        string = mediaMetadata.getString("android.media.metadata.TITLE");
        string2 = mediaMetadata.getString("android.media.metadata.ALBUM");
        string3 = mediaMetadata.getString("android.media.metadata.ARTIST");
        string4 = mediaMetadata.getString("android.media.metadata.ALBUM_ART_URI");
        B(c1708z0, c2437o, j8, string, string2, string3, string4);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 19 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15554o} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_media_playing_immediate, C2541R.string.caption_media_playing_change);
        c1596k0.v(this.packageName, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        dVar.g(this.varTitle);
        dVar.g(this.varAlbum);
        dVar.g(this.varArtist);
        if (105 <= dVar.f6413Z) {
            dVar.g(this.varArtworkUri);
        }
        dVar.g(this.varDuration);
        dVar.g(this.varPosition);
        if (74 <= dVar.f6413Z) {
            dVar.g(this.varPackageName);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.packageName);
        visitor.b(this.varTitle);
        visitor.b(this.varAlbum);
        visitor.b(this.varArtist);
        visitor.b(this.varArtworkUri);
        visitor.b(this.varDuration);
        visitor.b(this.varPosition);
        visitor.b(this.varPackageName);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.varTitle = (J3.l) cVar.readObject();
        this.varAlbum = (J3.l) cVar.readObject();
        this.varArtist = (J3.l) cVar.readObject();
        if (105 <= cVar.f6409x0) {
            this.varArtworkUri = (J3.l) cVar.readObject();
        }
        this.varDuration = (J3.l) cVar.readObject();
        this.varPosition = (J3.l) cVar.readObject();
        if (74 <= cVar.f6409x0) {
            this.varPackageName = (J3.l) cVar.readObject();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        if (r1 != null) goto L30;
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        List activeSessions;
        MediaController k8;
        PlaybackState playbackState;
        int state;
        String packageName;
        PlaybackState playbackState2;
        c1708z0.q(C2541R.string.stmt_media_playing_title);
        boolean z7 = J1(1) == 0;
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        int i8 = Build.VERSION.SDK_INT;
        if (21 > i8) {
            if (19 <= i8) {
                c1708z0.w(new RunnableC1643f0(z7));
                return false;
            }
            c1708z0.w(new MediaPlayingTaskLegacy(x7, z7));
            return false;
        }
        if (!z7) {
            c1708z0.w(new C1645g0(x7));
            return false;
        }
        try {
            activeSessions = C1695w.m(c1708z0.getSystemService("media_session")).getActiveSessions(new ComponentName(c1708z0, (Class<?>) AutomateNotificationListenerServiceKitKat.class));
            if (!activeSessions.isEmpty()) {
                if (x7 == null) {
                    k8 = C1699x.k(activeSessions.get(0));
                    Iterator it = activeSessions.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MediaController k9 = C1699x.k(it.next());
                        playbackState = k9.getPlaybackState();
                        if (playbackState != null) {
                            state = playbackState.getState();
                            if (3 == state) {
                                k8 = k9;
                                break;
                            }
                        }
                    }
                } else {
                    Iterator it2 = activeSessions.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        k8 = C1699x.k(it2.next());
                        packageName = k8.getPackageName();
                        if (x7.equals(packageName)) {
                            playbackState2 = k8.getPlaybackState();
                        }
                    }
                }
                C(c1708z0, k8);
                return true;
            }
            B(c1708z0, C2437o.c(x7), -1L, null, null, null, null);
            return true;
        } catch (SecurityException unused) {
            throw new IllegalStateException("Notification access disabled");
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        String string;
        String str;
        String str2;
        String string2;
        String string3;
        String string4;
        String str3;
        String str4;
        String str5;
        Object[] objArr = (Object[]) obj;
        int i8 = Build.VERSION.SDK_INT;
        if (21 <= i8) {
            D(c1708z0, (C2437o) objArr[0], a3.n(objArr[1]));
            return true;
        }
        long j8 = -1;
        if (19 > i8) {
            C2437o c2437o = (C2437o) objArr[0];
            Bundle bundle = (Bundle) objArr[1];
            if (bundle == null) {
                str = null;
                str2 = null;
                string = null;
            } else {
                j8 = bundle.getLong(f16901O1, -1L);
                String string5 = bundle.getString(f16898L1);
                String string6 = bundle.getString(f16899M1);
                string = bundle.getString(f16900N1);
                str = string5;
                str2 = string6;
            }
            B(c1708z0, c2437o, j8, str, str2, string, null);
            return true;
        }
        C2437o c2437o2 = (C2437o) objArr[0];
        RemoteController.MetadataEditor d8 = E3.e.d(objArr[1]);
        if (d8 == null) {
            str4 = null;
            str5 = null;
            str3 = null;
        } else {
            j8 = d8.getLong(9, -1L);
            string2 = d8.getString(7, null);
            string3 = d8.getString(1, null);
            string4 = d8.getString(2, null);
            str3 = string4;
            str4 = string2;
            str5 = string3;
        }
        B(c1708z0, c2437o2, j8, str4, str5, str3, null);
        return true;
    }
}
