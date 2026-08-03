package com.llamalab.automate.stmt;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Build;
import android.view.KeyEvent;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AutomateNotificationListenerServiceKitKat;
import com.llamalab.automate.C1695w;
import com.llamalab.automate.C1699x;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Iterator;
import java.util.List;

@F3.f("audio_player_control.html")
@F3.a(C2541R.integer.ic_remote)
@F3.i(C2541R.string.stmt_audio_player_control_title)
@F3.h(C2541R.string.stmt_audio_player_control_summary)
@F3.e(C2541R.layout.stmt_audio_player_control_edit)
/* loaded from: classes.dex */
public class AudioPlayerControl extends Action {
    public InterfaceC1700x0 className;
    public InterfaceC1700x0 command;
    public InterfaceC1700x0 method;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 position;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 21 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15554o} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.stmt_audio_player_control_title).e(this.command, null, C2541R.xml.audio_player_commands).o(0, this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.command);
        if (79 <= dVar.f6413Z) {
            dVar.g(this.position);
        }
        dVar.g(this.method);
        dVar.g(this.packageName);
        dVar.g(this.className);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.command);
        visitor.b(this.position);
        visitor.b(this.method);
        visitor.b(this.packageName);
        visitor.b(this.className);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return ViewOnClickListenerC1667s.w(null, 2);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.command = (InterfaceC1700x0) cVar.readObject();
        if (79 <= cVar.f6409x0) {
            this.position = (InterfaceC1700x0) cVar.readObject();
        }
        this.method = (InterfaceC1700x0) cVar.readObject();
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.className = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c1, code lost:
    
        r0 = r0.getState();
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        String str;
        int i8;
        List activeSessions;
        MediaController.TransportControls transportControls;
        PlaybackState playbackState;
        int state;
        String packageName;
        c1708z0.q(C2541R.string.stmt_audio_player_control_title);
        int m8 = J3.h.m(c1708z0, this.command, 2);
        int m9 = J3.h.m(c1708z0, this.method, 1);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        if (m9 == 0) {
            String x8 = J3.h.x(c1708z0, this.className, null);
            if (m8 == 2) {
                str = "togglepause";
            } else if (m8 == 4) {
                str = "stop";
            } else if (m8 == 8) {
                str = "next";
            } else {
                if (m8 != 16) {
                    if (m8 != 32 && m8 != 64) {
                        if (m8 == 128) {
                            str = "play";
                        } else if (m8 == 256) {
                            str = "pause";
                        } else if (m8 != 16777216) {
                            throw new IllegalArgumentException("command");
                        }
                    }
                    throw new UnsupportedOperationException(B4.g.g("Broadcast method do not support command: ", m8));
                }
                str = "previous";
            }
            Intent putExtra = new Intent("com.android.music.musicservicecommand").putExtra("com.llamalab.automate.intent.extra.HACK", true);
            if (x7 != null && x8 != null) {
                putExtra.setClassName(x7, x8);
            } else if (x7 != null) {
                putExtra.setPackage(x7);
            }
            c1708z0.sendBroadcast(putExtra.putExtra("command", str));
        } else if (m9 == 1) {
            String x9 = J3.h.x(c1708z0, this.className, null);
            if (m8 == 2) {
                i8 = 85;
            } else if (m8 == 4) {
                i8 = 86;
            } else if (m8 == 8) {
                i8 = 87;
            } else if (m8 == 16) {
                i8 = 88;
            } else if (m8 == 32) {
                i8 = 89;
            } else if (m8 == 64) {
                i8 = 90;
            } else if (m8 == 128) {
                i8 = 126;
            } else {
                if (m8 != 256) {
                    if (m8 != 16777216) {
                        throw new IllegalArgumentException("command");
                    }
                    throw new UnsupportedOperationException(B4.g.g("Media button method do not support command: ", m8));
                }
                i8 = 127;
            }
            Intent putExtra2 = new Intent("android.intent.action.MEDIA_BUTTON").putExtra("com.llamalab.automate.intent.extra.HACK", true);
            if (x7 != null && x9 != null) {
                putExtra2.setClassName(x7, x9);
            } else if (x7 != null) {
                putExtra2.setPackage(x7);
            }
            c1708z0.sendOrderedBroadcast(putExtra2.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i8)), null);
            c1708z0.sendOrderedBroadcast(putExtra2.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, i8)), null);
        } else {
            if (m9 != 2) {
                throw new IllegalArgumentException("method");
            }
            IncapableAndroidVersionException.b(21, "TransportControls method");
            long t8 = J3.h.t(c1708z0, this.position, 0L);
            activeSessions = C1695w.m(c1708z0.getSystemService("media_session")).getActiveSessions(new ComponentName(c1708z0, (Class<?>) AutomateNotificationListenerServiceKitKat.class));
            Iterator it = activeSessions.iterator();
            while (it.hasNext()) {
                MediaController k8 = C1699x.k(it.next());
                if (x7 != null) {
                    packageName = k8.getPackageName();
                    if (x7.equals(packageName)) {
                    }
                }
                transportControls = k8.getTransportControls();
                if (m8 == 2) {
                    playbackState = k8.getPlaybackState();
                    boolean z7 = (playbackState == null || state == 0 || state == 1 || state == 2 || state == 7) ? false : true;
                    if (z7) {
                        transportControls.pause();
                    } else {
                        transportControls.play();
                    }
                } else if (m8 == 4) {
                    transportControls.stop();
                } else if (m8 == 8) {
                    transportControls.skipToNext();
                } else if (m8 == 16) {
                    transportControls.skipToPrevious();
                } else if (m8 == 32) {
                    transportControls.rewind();
                } else if (m8 == 64) {
                    transportControls.fastForward();
                } else if (m8 == 128) {
                    transportControls.play();
                } else if (m8 == 256) {
                    transportControls.pause();
                } else {
                    if (m8 != 16777216) {
                        throw new IllegalArgumentException("command");
                    }
                    transportControls.seekTo(t8);
                }
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
