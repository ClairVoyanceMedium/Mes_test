package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.media.audiofx.Visualizer;
import android.os.Build;
import android.os.Process;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.concurrent.atomic.AtomicBoolean;
import x3.C2440r;

@F3.f("sound_level.html")
@F3.a(C2541R.integer.ic_whistle)
@F3.i(C2541R.string.stmt_sound_level_title)
@F3.h(C2541R.string.stmt_sound_level_summary)
@F3.e(C2541R.layout.stmt_sound_level_edit)
/* loaded from: classes.dex */
public final class SoundLevel extends LevelDecision implements AsyncStatement {
    public InterfaceC1700x0 audioDeviceId;
    public InterfaceC1700x0 source;

    public static class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final int f17135L1;

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f17136M1;

        /* renamed from: N1, reason: collision with root package name */
        public final Double f17137N1;

        /* renamed from: O1, reason: collision with root package name */
        public final Double f17138O1;

        /* renamed from: P1, reason: collision with root package name */
        public Boolean f17139P1;

        public a(int i8, Double d8, Double d9, boolean z7) {
            this.f17135L1 = i8;
            this.f17136M1 = z7;
            this.f17137N1 = d8;
            this.f17138O1 = d9;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
        
            r4 = x3.C2440r.c(r2, r4);
            r6 = java.lang.Boolean.valueOf(com.llamalab.automate.stmt.LevelDecision.E(r4, r8.f17137N1, r8.f17138O1));
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
        
            if (r8.f17136M1 != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        
            r7 = r8.f17139P1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        
            if (r7 == null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
        
            if (r6.equals(r7) != false) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
        
            r0.stop();
            q2(new java.lang.Object[]{r6, java.lang.Double.valueOf(r4)}, false);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        
            r8.f17139P1 = r6;
         */
        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void x2() {
            AudioRecord y22 = y2();
            try {
                if (y22.getState() == 0) {
                    throw new IllegalStateException("Uninitialized");
                }
                short[] sArr = new short[4410];
                y22.startRecording();
                Process.setThreadPriority(-19);
                loop0: while (!Thread.currentThread().isInterrupted()) {
                    int i8 = 0;
                    while (true) {
                        int read = y22.read(sArr, i8, 4410 - i8);
                        if (read < 0) {
                            throw new IllegalStateException("Failed to read samples: " + read);
                        }
                        i8 += read;
                        if (Thread.currentThread().isInterrupted()) {
                            break loop0;
                        } else if (i8 >= 4410) {
                            break;
                        }
                    }
                }
            } finally {
                y22.release();
            }
        }

        public AudioRecord y2() {
            return new AudioRecord(this.f17135L1, 44100, 16, 2, Math.max(8820, AudioRecord.getMinBufferSize(44100, 16, 2)));
        }
    }

    public static final class b extends a {

        /* renamed from: Q1, reason: collision with root package name */
        public final AudioDeviceInfo f17140Q1;

        public b(int i8, AudioDeviceInfo audioDeviceInfo, boolean z7, Double d8, Double d9) {
            super(i8, d8, d9, z7);
            this.f17140Q1 = audioDeviceInfo;
        }

        @Override // com.llamalab.automate.stmt.SoundLevel.a
        public final AudioRecord y2() {
            AudioRecord y22 = super.y2();
            AudioDeviceInfo audioDeviceInfo = this.f17140Q1;
            if (audioDeviceInfo != null) {
                y22.setPreferredDevice(audioDeviceInfo);
            }
            return y22;
        }
    }

    public static final class c extends com.llamalab.automate.W implements Visualizer.OnDataCaptureListener {

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f17142M1;

        /* renamed from: N1, reason: collision with root package name */
        public final Double f17143N1;

        /* renamed from: O1, reason: collision with root package name */
        public final Double f17144O1;

        /* renamed from: P1, reason: collision with root package name */
        public Visualizer f17145P1;

        /* renamed from: Q1, reason: collision with root package name */
        public boolean f17146Q1;

        /* renamed from: R1, reason: collision with root package name */
        public Boolean f17147R1;

        /* renamed from: y1, reason: collision with root package name */
        public final AtomicBoolean f17148y1 = new AtomicBoolean();

        /* renamed from: L1, reason: collision with root package name */
        public final int f17141L1 = 0;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                c cVar = c.this;
                Visualizer visualizer = cVar.f17145P1;
                if (visualizer != null) {
                    try {
                        visualizer.release();
                    } catch (Throwable unused) {
                    }
                    cVar.f17145P1 = null;
                }
            }
        }

        public c(Double d8, Double d9, boolean z7) {
            this.f17142M1 = z7;
            this.f17143N1 = d8;
            this.f17144O1 = d9;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0027, code lost:
        
            r1 = r0.f17145P1.setScalingMode(1);
         */
        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            int scalingMode;
            super.C(automateService, j8, j9, j10);
            int[] captureSizeRange = Visualizer.getCaptureSizeRange();
            Visualizer visualizer = new Visualizer(this.f17141L1);
            this.f17145P1 = visualizer;
            try {
                visualizer.setEnabled(false);
            } catch (Throwable unused) {
            }
            int captureSize = this.f17145P1.setCaptureSize(captureSizeRange[1]);
            if (captureSize != 0) {
                throw new IllegalStateException(B4.g.g("setCaptureSize failed: ", captureSize));
            }
            if (16 <= Build.VERSION.SDK_INT && scalingMode != 0) {
                throw new IllegalStateException(B4.g.g("setScalingMode failed: ", scalingMode));
            }
            int dataCaptureListener = this.f17145P1.setDataCaptureListener(this, (int) Math.min(10000L, Visualizer.getMaxCaptureRate()), true, false);
            if (dataCaptureListener != 0) {
                throw new IllegalStateException(B4.g.g("setDataCaptureListener failed: ", dataCaptureListener));
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            automateService.Z(new a());
            u2();
        }

        @Override // android.media.audiofx.Visualizer.OnDataCaptureListener
        public final void onFftDataCapture(Visualizer visualizer, byte[] bArr, int i8) {
        }

        @Override // android.media.audiofx.Visualizer.OnDataCaptureListener
        public final void onWaveFormDataCapture(Visualizer visualizer, byte[] bArr, int i8) {
            Boolean bool;
            AtomicBoolean atomicBoolean = this.f17148y1;
            if (atomicBoolean.get() && bArr != null && bArr.length != 0) {
                double d8 = C2440r.d(bArr, bArr.length);
                if (!this.f17146Q1 || d8 != 0.0d) {
                    Boolean valueOf = Boolean.valueOf(LevelDecision.E(d8, this.f17143N1, this.f17144O1));
                    if (this.f17142M1 || ((bool = this.f17147R1) != null && !valueOf.equals(bool))) {
                        atomicBoolean.set(false);
                        q2(new Object[]{valueOf, Double.valueOf(d8)}, false);
                    }
                    this.f17147R1 = valueOf;
                }
            }
            this.f17146Q1 = false;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.RECORD_AUDIO"), com.llamalab.automate.access.c.j("android.permission.MODIFY_AUDIO_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_sound_level_immediate, C2541R.string.caption_sound_level_change);
        c1596k0.n(this.minLevel, this.maxLevel, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.source);
        if (110 <= dVar.f6413Z) {
            dVar.g(this.audioDeviceId);
        }
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.source);
        visitor.b(this.audioDeviceId);
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.source = (InterfaceC1700x0) cVar.readObject();
        if (110 <= cVar.f6409x0) {
            this.audioDeviceId = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        AbstractRunnableC1694v2 aVar;
        AudioDeviceInfo audioDeviceInfo;
        AudioDeviceInfo[] devices;
        int id;
        c1708z0.q(C2541R.string.stmt_sound_level_title);
        Double D7 = D(c1708z0);
        Double C7 = C(c1708z0);
        int m8 = J3.h.m(c1708z0, this.source, 0);
        int m9 = J3.h.m(c1708z0, this.audioDeviceId, -1);
        boolean z7 = (D7 == null && C7 == null) || J1(1) == 0;
        if (Integer.MAX_VALUE == m8) {
            c cVar = new c(D7, C7, z7);
            c1708z0.w(cVar);
            if (cVar.f17148y1.compareAndSet(false, true)) {
                cVar.f17146Q1 = true;
                int enabled = cVar.f17145P1.setEnabled(true);
                if (enabled != 0) {
                    throw new IllegalStateException(B4.g.g("setEnabled failed: ", enabled));
                }
            }
        } else {
            if (m8 < 0 || m8 > MediaRecorder.getAudioSourceMax()) {
                throw new IllegalArgumentException("source");
            }
            if (23 <= Build.VERSION.SDK_INT) {
                if (m9 != -1) {
                    devices = ((AudioManager) c1708z0.getSystemService("audio")).getDevices(1);
                    for (AudioDeviceInfo audioDeviceInfo2 : devices) {
                        id = audioDeviceInfo2.getId();
                        if (m9 == id) {
                            audioDeviceInfo = audioDeviceInfo2;
                        }
                    }
                    throw new IllegalArgumentException(B4.g.g("Audio device not found: ", m9));
                }
                audioDeviceInfo = null;
                aVar = new b(m8, audioDeviceInfo, z7, D7, C7);
            } else {
                aVar = new a(m8, D7, C7, z7);
            }
            c1708z0.w(aVar);
            aVar.v2();
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (Double) objArr[1]);
        return true;
    }
}
