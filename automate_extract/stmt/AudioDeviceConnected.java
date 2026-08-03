package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.SystemClock;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.W;

@F3.f("audio_device_connected.html")
@F3.a(C2541R.integer.ic_jack_plug)
@F3.i(C2541R.string.stmt_audio_device_connected_title)
@F3.h(C2541R.string.stmt_audio_device_connected_summary)
@F3.e(C2541R.layout.stmt_audio_device_connected_edit)
/* loaded from: classes.dex */
public final class AudioDeviceConnected extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 deviceAddress;
    public InterfaceC1700x0 deviceBrand;
    public InterfaceC1700x0 deviceMode;
    public InterfaceC1700x0 deviceType;
    public J3.l varConnectedDeviceAddress;
    public J3.l varConnectedDeviceBrand;
    public J3.l varConnectedDeviceId;
    public J3.l varConnectedDeviceMode;
    public J3.l varConnectedDeviceType;

    public static final class a extends W.a<b> {

        /* renamed from: N1, reason: collision with root package name */
        public AudioManager f16281N1;

        /* renamed from: O1, reason: collision with root package name */
        public String f16282O1;

        /* renamed from: P1, reason: collision with root package name */
        public String f16283P1;

        /* renamed from: Q1, reason: collision with root package name */
        public int f16284Q1;

        /* renamed from: R1, reason: collision with root package name */
        public int f16285R1;

        /* renamed from: S1, reason: collision with root package name */
        public long f16286S1;

        /* renamed from: T1, reason: collision with root package name */
        public final C0167a f16287T1;

        /* renamed from: com.llamalab.automate.stmt.AudioDeviceConnected$a$a, reason: collision with other inner class name */
        public class C0167a extends AudioDeviceCallback {
            public C0167a() {
            }

            @Override // android.media.AudioDeviceCallback
            public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                if (a.this.f16286S1 <= SystemClock.elapsedRealtime()) {
                    for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                        a.this.v2(new b(audioDeviceInfo, true));
                    }
                }
            }

            @Override // android.media.AudioDeviceCallback
            public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                    a.this.v2(new b(audioDeviceInfo, false));
                }
            }
        }

        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public final AudioDeviceInfo f16289a;

            /* renamed from: b, reason: collision with root package name */
            public final boolean f16290b;

            public b(AudioDeviceInfo audioDeviceInfo, boolean z7) {
                this.f16289a = audioDeviceInfo;
                this.f16290b = z7;
            }
        }

        public a() {
            super(128, 500L);
            this.f16287T1 = new C0167a();
        }

        @Override // com.llamalab.automate.W.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            this.f16281N1 = (AudioManager) automateService.getSystemService("audio");
            this.f16286S1 = SystemClock.elapsedRealtime() + 50;
            this.f16281N1.registerAudioDeviceCallback(this.f16287T1, automateService.f14581L1);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            try {
                this.f16281N1.unregisterAudioDeviceCallback(this.f16287T1);
            } catch (Throwable unused) {
            }
            u2();
        }

        @Override // com.llamalab.automate.W.a
        public final void w2(b bVar) {
            boolean isSource;
            boolean isSink;
            int i8;
            int type;
            Object productName;
            int id;
            b bVar2 = bVar;
            AudioDeviceInfo audioDeviceInfo = bVar2.f16289a;
            if (audioDeviceInfo == null) {
                i8 = 0;
            } else {
                isSource = audioDeviceInfo.isSource();
                isSink = audioDeviceInfo.isSink();
                i8 = (isSource ? 1 : 0) | (isSink ? 2 : 0);
            }
            if ((this.f16285R1 & i8) == 0 || !C1650j.b(audioDeviceInfo, this.f16284Q1, this.f16282O1, this.f16283P1)) {
                return;
            }
            Object[] objArr = new Object[6];
            objArr[0] = Boolean.valueOf(bVar2.f16290b);
            type = audioDeviceInfo.getType();
            objArr[1] = Double.valueOf(type);
            objArr[2] = Double.valueOf(i8);
            productName = audioDeviceInfo.getProductName();
            objArr[3] = productName;
            objArr[4] = 28 <= Build.VERSION.SDK_INT ? audioDeviceInfo.getAddress() : null;
            id = audioDeviceInfo.getId();
            objArr[5] = Double.valueOf(id);
            q2(objArr, false);
        }
    }

    public final void B(C1708z0 c1708z0, boolean z7, Double d8, Double d9, CharSequence charSequence, String str, Double d10) {
        J3.l lVar = this.varConnectedDeviceType;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varConnectedDeviceMode;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d9);
        }
        J3.l lVar3 = this.varConnectedDeviceBrand;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, charSequence != null ? charSequence.toString() : null);
        }
        J3.l lVar4 = this.varConnectedDeviceAddress;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, str);
        }
        J3.l lVar5 = this.varConnectedDeviceId;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, d10);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_audio_device_connected_immediate, C2541R.string.caption_audio_device_connected_change);
        return c1596k0.e(this.deviceType, null, C2541R.xml.audio_device_types).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.deviceType);
        dVar.g(this.deviceMode);
        dVar.g(this.deviceBrand);
        if (110 <= dVar.f6413Z) {
            dVar.g(this.deviceAddress);
        }
        dVar.g(this.varConnectedDeviceType);
        dVar.g(this.varConnectedDeviceMode);
        dVar.g(this.varConnectedDeviceBrand);
        if (110 <= dVar.f6413Z) {
            dVar.g(this.varConnectedDeviceAddress);
            dVar.g(this.varConnectedDeviceId);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.deviceType);
        visitor.b(this.deviceMode);
        visitor.b(this.deviceBrand);
        visitor.b(this.deviceAddress);
        visitor.b(this.varConnectedDeviceType);
        visitor.b(this.varConnectedDeviceMode);
        visitor.b(this.varConnectedDeviceBrand);
        visitor.b(this.varConnectedDeviceAddress);
        visitor.b(this.varConnectedDeviceId);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.deviceType = (InterfaceC1700x0) cVar.readObject();
        this.deviceMode = (InterfaceC1700x0) cVar.readObject();
        this.deviceBrand = (InterfaceC1700x0) cVar.readObject();
        if (110 <= cVar.f6409x0) {
            this.deviceAddress = (InterfaceC1700x0) cVar.readObject();
        }
        this.varConnectedDeviceType = (J3.l) cVar.readObject();
        this.varConnectedDeviceMode = (J3.l) cVar.readObject();
        this.varConnectedDeviceBrand = (J3.l) cVar.readObject();
        if (110 <= cVar.f6409x0) {
            this.varConnectedDeviceAddress = (J3.l) cVar.readObject();
            this.varConnectedDeviceId = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        AudioDeviceInfo[] devices;
        Double d8;
        Double d9;
        CharSequence charSequence;
        String str;
        Double d10;
        boolean z7;
        int type;
        boolean isSource;
        boolean isSink;
        CharSequence productName;
        int id;
        c1708z0.q(C2541R.string.stmt_audio_device_connected_title);
        IncapableAndroidVersionException.a(23);
        String x7 = J3.h.x(c1708z0, this.deviceBrand, null);
        int m8 = J3.h.m(c1708z0, this.deviceType, -1);
        int m9 = J3.h.m(c1708z0, this.deviceMode, 3) & 3;
        String x8 = J3.h.x(c1708z0, this.deviceAddress, null);
        if (J1(1) != 0) {
            a aVar = (a) c1708z0.d(a.class, this);
            if (aVar != null) {
                aVar.f16282O1 = x7;
                aVar.f16284Q1 = m8;
                aVar.f16285R1 = m9;
                aVar.f16283P1 = x8;
                aVar.x2();
            } else {
                a aVar2 = new a();
                aVar2.f16282O1 = x7;
                aVar2.f16284Q1 = m8;
                aVar2.f16285R1 = m9;
                aVar2.f16283P1 = x8;
                c1708z0.w(aVar2);
            }
            return false;
        }
        devices = ((AudioManager) c1708z0.getSystemService("audio")).getDevices(m9);
        int length = devices.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                d8 = null;
                d9 = null;
                charSequence = null;
                str = null;
                d10 = null;
                z7 = false;
                break;
            }
            AudioDeviceInfo audioDeviceInfo = devices[i8];
            if (C1650j.b(audioDeviceInfo, m8, x7, x8)) {
                type = audioDeviceInfo.getType();
                Double valueOf = Double.valueOf(type);
                isSource = audioDeviceInfo.isSource();
                isSink = audioDeviceInfo.isSink();
                Double valueOf2 = Double.valueOf((isSource ? 1 : 0) | (isSink ? 2 : 0));
                productName = audioDeviceInfo.getProductName();
                String address = 28 <= Build.VERSION.SDK_INT ? audioDeviceInfo.getAddress() : null;
                id = audioDeviceInfo.getId();
                str = address;
                d10 = Double.valueOf(id);
                z7 = true;
                charSequence = productName;
                d9 = valueOf2;
                d8 = valueOf;
            } else {
                i8++;
            }
        }
        B(c1708z0, z7, d8, d9, charSequence, str, d10);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (Double) objArr[1], (Double) objArr[2], (CharSequence) objArr[3], (String) objArr[4], (Double) objArr[5]);
        return true;
    }
}
