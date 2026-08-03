package com.llamalab.automate.stmt;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C2541R;
import i4.C1951e;
import x3.C2433k;

/* loaded from: classes.dex */
public final class t1 extends AbstractC1647h0 {
    public static final String[] U1 = {null, "3gp", "mp4", "3gp", "3gp", null, null, null, null, "webm"};

    /* renamed from: O1, reason: collision with root package name */
    public final CamcorderProfile f17523O1;

    /* renamed from: P1, reason: collision with root package name */
    public final boolean f17524P1;

    /* renamed from: Q1, reason: collision with root package name */
    public Camera f17525Q1;

    /* renamed from: R1, reason: collision with root package name */
    public SurfaceTexture f17526R1;

    /* renamed from: S1, reason: collision with root package name */
    public com.llamalab.safs.n f17527S1;

    /* renamed from: T1, reason: collision with root package name */
    public ParcelFileDescriptor f17528T1;

    public t1(MediaRecorder mediaRecorder, int i8, Camera camera, C2433k c2433k, CamcorderProfile camcorderProfile, com.llamalab.safs.n nVar, boolean z7) {
        super(mediaRecorder, i8);
        this.f17525Q1 = camera;
        this.f17526R1 = c2433k;
        this.f17523O1 = camcorderProfile;
        this.f17527S1 = nVar;
        this.f17524P1 = z7;
    }

    @Override // com.llamalab.automate.stmt.AbstractC1647h0
    public final void B2() {
        if (this.f17524P1) {
            a();
        } else {
            q2(this.f17527S1.toString(), false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractC1647h0
    public final void C2(MediaRecorder mediaRecorder) {
        com.llamalab.safs.n t8 = w0.L.t(this.f17527S1, Environment.DIRECTORY_DCIM, null, C2541R.string.format_video_file, U1[this.f17523O1.fileFormat]);
        this.f17527S1 = t8;
        ParcelFileDescriptor b8 = C1951e.b(t8, com.llamalab.safs.p.WRITE, com.llamalab.safs.p.CREATE, com.llamalab.safs.p.TRUNCATE_EXISTING);
        this.f17528T1 = b8;
        mediaRecorder.setOutputFile(b8.getFileDescriptor());
        mediaRecorder.prepare();
        if (this.f17524P1) {
            q2(this.f17527S1.toString(), true);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractC1647h0, com.llamalab.automate.S1, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        super.F(automateService);
        Camera camera = this.f17525Q1;
        if (camera != null) {
            try {
                camera.lock();
            } catch (Throwable unused) {
            }
            try {
                this.f17525Q1.release();
            } catch (Throwable unused2) {
            }
            this.f17525Q1 = null;
        }
        SurfaceTexture surfaceTexture = this.f17526R1;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.release();
            } catch (Throwable unused3) {
            }
            this.f17526R1 = null;
        }
        ParcelFileDescriptor parcelFileDescriptor = this.f17528T1;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (Throwable unused4) {
            }
            this.f17528T1 = null;
        }
    }
}
