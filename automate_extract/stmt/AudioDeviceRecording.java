package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.media.MediaRecorder;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.W;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@F3.f("audio_device_recording.html")
@F3.a(C2541R.integer.ic_perm_group_voicemail)
@F3.i(C2541R.string.stmt_audio_device_recording_title)
@F3.h(C2541R.string.stmt_audio_device_recording_summary)
@F3.e(C2541R.layout.stmt_audio_device_recording_edit)
/* loaded from: classes.dex */
public final class AudioDeviceRecording extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 audioSource;
    public InterfaceC1700x0 deviceBrand;
    public InterfaceC1700x0 deviceType;
    public J3.l varRecordedAudioSource;
    public J3.l varRecordingDeviceBrand;
    public J3.l varRecordingDeviceType;

    public static final class a extends W.a<b> {

        /* renamed from: N1, reason: collision with root package name */
        public Set<b> f16291N1;

        /* renamed from: O1, reason: collision with root package name */
        public Set<b> f16292O1;

        /* renamed from: P1, reason: collision with root package name */
        public final ArrayList f16293P1;

        /* renamed from: Q1, reason: collision with root package name */
        public AudioManager f16294Q1;

        /* renamed from: R1, reason: collision with root package name */
        public String f16295R1;

        /* renamed from: S1, reason: collision with root package name */
        public int f16296S1;

        /* renamed from: T1, reason: collision with root package name */
        public int f16297T1;
        public final C0168a U1;

        /* renamed from: com.llamalab.automate.stmt.AudioDeviceRecording$a$a, reason: collision with other inner class name */
        public class C0168a extends AudioManager.AudioRecordingCallback {
            public C0168a() {
            }

            @Override // android.media.AudioManager.AudioRecordingCallback
            public final void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
                try {
                    a aVar = a.this;
                    Set<b> set = aVar.f16291N1;
                    aVar.f16291N1 = aVar.f16292O1;
                    aVar.f16292O1 = set;
                    Iterator<AudioRecordingConfiguration> it = list.iterator();
                    while (it.hasNext()) {
                        b bVar = new b(B.X.e(it.next()));
                        a.this.f16291N1.add(bVar);
                        if (!a.this.f16292O1.remove(bVar)) {
                            a.this.f16293P1.add(bVar);
                        }
                    }
                    for (b bVar2 : a.this.f16292O1) {
                        a.this.v2(new b(bVar2.f16299a, bVar2.f16300b, bVar2.f16301c, false));
                    }
                    a.this.f16292O1.clear();
                    Iterator it2 = a.this.f16293P1.iterator();
                    while (it2.hasNext()) {
                        a.this.v2((b) it2.next());
                    }
                    a.this.f16293P1.clear();
                } catch (Throwable th) {
                    a.this.r2(th);
                }
            }
        }

        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public final AudioDeviceInfo f16299a;

            /* renamed from: b, reason: collision with root package name */
            public final int f16300b;

            /* renamed from: c, reason: collision with root package name */
            public final int f16301c;

            /* renamed from: d, reason: collision with root package name */
            public final boolean f16302d;

            public b(AudioDeviceInfo audioDeviceInfo, int i8, int i9, boolean z7) {
                this.f16299a = audioDeviceInfo;
                this.f16300b = i8;
                this.f16301c = i9;
                this.f16302d = z7;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return O.b.a(this.f16299a, bVar.f16299a) && this.f16300b == bVar.f16300b && this.f16301c == bVar.f16301c;
            }

            public final int hashCode() {
                AudioDeviceInfo audioDeviceInfo = this.f16299a;
                return ((((527 + (audioDeviceInfo != null ? audioDeviceInfo.hashCode() : 0)) * 31) + this.f16300b) * 31) + this.f16301c;
            }

            public final String toString() {
                return super.toString() + "[device=" + this.f16299a + ", source=" + this.f16300b + ", sessionId=" + this.f16301c + ", recording=" + this.f16302d + "]";
            }

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b(AudioRecordingConfiguration audioRecordingConfiguration) {
                this(r0, r1, r4, true);
                AudioDeviceInfo audioDevice;
                int clientAudioSource;
                int clientAudioSessionId;
                audioDevice = audioRecordingConfiguration.getAudioDevice();
                clientAudioSource = audioRecordingConfiguration.getClientAudioSource();
                clientAudioSessionId = audioRecordingConfiguration.getClientAudioSessionId();
            }
        }

        public a() {
            super(256, 500L);
            this.f16291N1 = new HashSet();
            this.f16292O1 = new HashSet();
            this.f16293P1 = new ArrayList();
            this.U1 = new C0168a();
        }

        @Override // com.llamalab.automate.W.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            List activeRecordingConfigurations;
            super.C(automateService, j8, j9, j10);
            AudioManager audioManager = (AudioManager) automateService.getSystemService("audio");
            this.f16294Q1 = audioManager;
            activeRecordingConfigurations = audioManager.getActiveRecordingConfigurations();
            Iterator it = activeRecordingConfigurations.iterator();
            while (it.hasNext()) {
                this.f16291N1.add(new b(B.X.e(it.next())));
            }
            this.f16294Q1.registerAudioRecordingCallback(this.U1, automateService.f14581L1);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            try {
                this.f16294Q1.unregisterAudioRecordingCallback(this.U1);
            } catch (Throwable unused) {
            }
            u2();
        }

        @Override // com.llamalab.automate.W.a
        public final void w2(b bVar) {
            Double d8;
            CharSequence charSequence;
            int type;
            b bVar2 = bVar;
            int i8 = this.f16296S1;
            String str = this.f16295R1;
            AudioDeviceInfo audioDeviceInfo = bVar2.f16299a;
            if (C1650j.a(audioDeviceInfo, i8, str)) {
                int i9 = this.f16297T1;
                int i10 = bVar2.f16300b;
                if (i9 < 0 || i9 == i10) {
                    if (audioDeviceInfo != null) {
                        type = audioDeviceInfo.getType();
                        d8 = Double.valueOf(type);
                        charSequence = audioDeviceInfo.getProductName();
                    } else {
                        d8 = null;
                        charSequence = null;
                    }
                    q2(new Object[]{Boolean.valueOf(bVar2.f16302d), d8, charSequence, Double.valueOf(i10)}, false);
                }
            }
        }
    }

    public final void B(C1708z0 c1708z0, boolean z7, Double d8, CharSequence charSequence, Double d9) {
        J3.l lVar = this.varRecordingDeviceType;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varRecordingDeviceBrand;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, O.b.d(null, charSequence));
        }
        J3.l lVar3 = this.varRecordedAudioSource;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d9);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_audio_device_recording_immediate, C2541R.string.caption_audio_device_recording_change);
        return c1596k0.e(this.deviceType, null, C2541R.xml.audio_device_types).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.deviceType);
        dVar.g(this.deviceBrand);
        dVar.g(this.audioSource);
        dVar.g(this.varRecordingDeviceType);
        dVar.g(this.varRecordingDeviceBrand);
        dVar.g(this.varRecordedAudioSource);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.deviceType);
        visitor.b(this.deviceBrand);
        visitor.b(this.audioSource);
        visitor.b(this.varRecordingDeviceType);
        visitor.b(this.varRecordingDeviceBrand);
        visitor.b(this.varRecordedAudioSource);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.deviceType = (InterfaceC1700x0) cVar.readObject();
        this.deviceBrand = (InterfaceC1700x0) cVar.readObject();
        this.audioSource = (InterfaceC1700x0) cVar.readObject();
        this.varRecordingDeviceType = (J3.l) cVar.readObject();
        this.varRecordingDeviceBrand = (J3.l) cVar.readObject();
        this.varRecordedAudioSource = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        List activeRecordingConfigurations;
        Double d8;
        CharSequence charSequence;
        Double d9;
        boolean z7;
        AudioDeviceInfo audioDevice;
        CharSequence charSequence2;
        int clientAudioSource;
        int type;
        int clientAudioSource2;
        c1708z0.q(C2541R.string.stmt_audio_device_recording_title);
        IncapableAndroidVersionException.a(24);
        int m8 = J3.h.m(c1708z0, this.deviceType, -1);
        Double d10 = null;
        String x7 = J3.h.x(c1708z0, this.deviceBrand, null);
        int m9 = J3.h.m(c1708z0, this.audioSource, -1);
        if (m9 > MediaRecorder.getAudioSourceMax()) {
            throw new IllegalArgumentException("audioSource");
        }
        if (J1(1) != 0) {
            a aVar = (a) c1708z0.d(a.class, this);
            if (aVar != null) {
                aVar.f16297T1 = m9;
                aVar.f16296S1 = m8;
                aVar.f16295R1 = x7;
                aVar.x2();
            } else {
                a aVar2 = new a();
                aVar2.f16297T1 = m9;
                aVar2.f16296S1 = m8;
                aVar2.f16295R1 = x7;
                c1708z0.w(aVar2);
            }
            return false;
        }
        activeRecordingConfigurations = ((AudioManager) c1708z0.getSystemService("audio")).getActiveRecordingConfigurations();
        Iterator it = activeRecordingConfigurations.iterator();
        while (it.hasNext()) {
            AudioRecordingConfiguration e8 = B.X.e(it.next());
            audioDevice = e8.getAudioDevice();
            if (C1650j.a(audioDevice, m8, x7)) {
                if (m9 >= 0) {
                    clientAudioSource2 = e8.getClientAudioSource();
                    if (m9 != clientAudioSource2) {
                    }
                }
                if (audioDevice != null) {
                    type = audioDevice.getType();
                    d10 = Double.valueOf(type);
                    charSequence2 = audioDevice.getProductName();
                } else {
                    charSequence2 = null;
                }
                clientAudioSource = e8.getClientAudioSource();
                charSequence = charSequence2;
                d9 = Double.valueOf(clientAudioSource);
                d8 = d10;
                z7 = true;
                B(c1708z0, z7, d8, charSequence, d9);
                return true;
            }
        }
        d8 = null;
        charSequence = null;
        d9 = null;
        z7 = false;
        B(c1708z0, z7, d8, charSequence, d9);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (Double) objArr[1], (CharSequence) objArr[2], (Double) objArr[3]);
        return true;
    }
}
