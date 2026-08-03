package com.llamalab.automate.stmt;

import android.media.MediaRecorder;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C2541R;
import i4.C1951e;
import java.io.IOException;

/* renamed from: com.llamalab.automate.stmt.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1654l extends AbstractC1647h0 {

    /* renamed from: O1, reason: collision with root package name */
    public final EnumC1652k f17463O1;

    /* renamed from: P1, reason: collision with root package name */
    public final boolean f17464P1;

    /* renamed from: Q1, reason: collision with root package name */
    public com.llamalab.safs.n f17465Q1;

    /* renamed from: R1, reason: collision with root package name */
    public ParcelFileDescriptor f17466R1;

    public C1654l(MediaRecorder mediaRecorder, int i8, EnumC1652k enumC1652k, com.llamalab.safs.n nVar, boolean z7) {
        super(mediaRecorder, i8);
        this.f17465Q1 = nVar;
        this.f17463O1 = enumC1652k;
        this.f17464P1 = z7;
    }

    @Override // com.llamalab.automate.stmt.AbstractC1647h0
    public final void B2() {
        if (this.f17464P1) {
            a();
        } else {
            q2(this.f17465Q1.toString(), false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractC1647h0
    public final void C2(MediaRecorder mediaRecorder) {
        com.llamalab.safs.n t8 = w0.L.t(this.f17465Q1, Environment.DIRECTORY_NOTIFICATIONS, null, C2541R.string.format_audio_file, this.f17463O1.f17448x0);
        this.f17465Q1 = t8;
        ParcelFileDescriptor b8 = C1951e.b(t8, com.llamalab.safs.p.WRITE, com.llamalab.safs.p.CREATE, com.llamalab.safs.p.TRUNCATE_EXISTING);
        this.f17466R1 = b8;
        mediaRecorder.setOutputFile(b8.getFileDescriptor());
        mediaRecorder.prepare();
        if (this.f17464P1) {
            q2(this.f17465Q1.toString(), true);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractC1647h0, com.llamalab.automate.S1, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        super.F(automateService);
        ParcelFileDescriptor parcelFileDescriptor = this.f17466R1;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException unused) {
            }
            this.f17466R1 = null;
        }
    }
}
