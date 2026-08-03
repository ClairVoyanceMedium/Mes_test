package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.AbstractC1647h0;

@F3.f("audio_record_start.html")
@F3.a(C2541R.integer.ic_perm_group_voicemail)
@F3.i(C2541R.string.stmt_audio_record_start_title)
@F3.h(C2541R.string.stmt_audio_record_start_summary)
@F3.e(C2541R.layout.stmt_audio_record_start_edit)
/* loaded from: classes.dex */
public final class AudioRecordStart extends IntermittentAction implements AsyncStatement {
    public InterfaceC1700x0 audioDeviceId;
    public InterfaceC1700x0 encoding;
    public InterfaceC1700x0 focus;
    public InterfaceC1700x0 maxDuration;
    public InterfaceC1700x0 notificationChannelId;
    public InterfaceC1700x0 quality;
    public InterfaceC1700x0 source;
    public InterfaceC1700x0 targetPath;
    public J3.l varAudioFile;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.RECORD_AUDIO"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.RECORD_AUDIO"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.RECORD_AUDIO"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_audio_record_start).e(this.source, 1, C2541R.xml.audio_sources).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.source);
        if (110 <= dVar.f6413Z) {
            dVar.g(this.audioDeviceId);
        }
        if (80 <= dVar.f6413Z) {
            dVar.g(this.focus);
        }
        dVar.g(this.encoding);
        dVar.g(this.quality);
        dVar.g(this.maxDuration);
        dVar.g(this.notificationChannelId);
        dVar.g(this.targetPath);
        dVar.g(this.varAudioFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.source);
        visitor.b(this.audioDeviceId);
        visitor.b(this.focus);
        visitor.b(this.encoding);
        visitor.b(this.quality);
        visitor.b(this.maxDuration);
        visitor.b(this.notificationChannelId);
        visitor.b(this.targetPath);
        visitor.b(this.varAudioFile);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.source = (InterfaceC1700x0) cVar.readObject();
        if (110 <= cVar.f6409x0) {
            this.audioDeviceId = (InterfaceC1700x0) cVar.readObject();
        }
        if (80 <= cVar.f6409x0) {
            this.focus = (InterfaceC1700x0) cVar.readObject();
        }
        this.encoding = (InterfaceC1700x0) cVar.readObject();
        this.quality = (InterfaceC1700x0) cVar.readObject();
        this.maxDuration = (InterfaceC1700x0) cVar.readObject();
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.notificationChannelId = interfaceC1700x0;
        if (77 > cVar.f6409x0 && interfaceC1700x0 != null) {
            this.notificationChannelId = new L3.A(interfaceC1700x0);
        }
        this.targetPath = (InterfaceC1700x0) cVar.readObject();
        this.varAudioFile = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        AudioDeviceInfo[] devices;
        int id;
        c1708z0.q(C2541R.string.stmt_audio_record_start_title);
        c1708z0.H(C1654l.class);
        boolean z7 = J1(1) == 0;
        int m8 = J3.h.m(c1708z0, this.encoding, 2);
        if (m8 < 0 || m8 >= EnumC1652k.values().length) {
            throw new IllegalArgumentException("encoding");
        }
        EnumC1652k enumC1652k = EnumC1652k.values()[m8];
        int i8 = enumC1652k.f17445X;
        int i9 = Build.VERSION.SDK_INT;
        if (i8 > i9) {
            throw new IncapableAndroidVersionException(enumC1652k.f17445X, "encoding " + enumC1652k);
        }
        int m9 = J3.h.m(c1708z0, this.source, 0);
        if (m9 < 0 || m9 > MediaRecorder.getAudioSourceMax()) {
            throw new IllegalArgumentException("source");
        }
        int m10 = J3.h.m(c1708z0, this.audioDeviceId, -1);
        int m11 = J3.h.m(c1708z0, this.focus, 4);
        if (4 == m11) {
            m11 = 2;
        }
        double b8 = y4.j.b(J3.h.i(c1708z0, this.quality, 90.0d) / 100.0d, 0.0d, 1.0d);
        long t8 = J3.h.t(c1708z0, this.maxDuration, 0L);
        String x7 = J3.h.x(c1708z0, this.notificationChannelId, null);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.targetPath);
        MediaRecorder mediaRecorder = new MediaRecorder();
        try {
            mediaRecorder.setAudioSource(m9);
            if (28 <= i9 && m10 != -1) {
                devices = ((AudioManager) c1708z0.getSystemService("audio")).getDevices(1);
                int length = devices.length;
                int i10 = 0;
                while (i10 < length) {
                    AudioDeviceInfo audioDeviceInfo = devices[i10];
                    AudioDeviceInfo[] audioDeviceInfoArr = devices;
                    id = audioDeviceInfo.getId();
                    if (m10 == id) {
                        mediaRecorder.setPreferredDevice(audioDeviceInfo);
                    } else {
                        i10++;
                        devices = audioDeviceInfoArr;
                    }
                }
                throw new IllegalArgumentException("Audio device not found: " + m10);
            }
            mediaRecorder.setOutputFormat(enumC1652k.f17447Z);
            mediaRecorder.setAudioEncoder(enumC1652k.f17446Y);
            int[] iArr = enumC1652k.f17450y0;
            if (iArr != null) {
                mediaRecorder.setAudioSamplingRate(y4.j.h(b8, iArr));
            }
            int[] iArr2 = enumC1652k.f17449x1;
            if (iArr2 != null) {
                mediaRecorder.setAudioEncodingBitRate(y4.j.h(b8, iArr2));
            }
            if (t8 > 0) {
                mediaRecorder.setMaxDuration((int) Math.min(t8, 2147483647L));
            }
            C1654l c1654l = new C1654l(mediaRecorder, m11, enumC1652k, p8, z7);
            c1708z0.w(c1654l);
            if (x7 != null) {
                c1654l.z2(c1708z0, x7, C2541R.drawable.ic_stat_notify_mic, C2541R.string.stmt_audio_record_start_title);
            }
            c1654l.n2(1);
            if (c1654l.f17430M1 != null) {
                return false;
            }
            AbstractC1647h0.a aVar = new AbstractC1647h0.a();
            c1654l.f17430M1 = aVar;
            aVar.start();
            return false;
        } catch (Throwable th) {
            mediaRecorder.release();
            throw th;
        }
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
