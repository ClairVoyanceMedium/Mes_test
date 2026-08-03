package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import k4.InterfaceC2047b;

@F3.f("media_store_add.html")
@F3.a(C2541R.integer.ic_content_new_picture)
@F3.i(C2541R.string.stmt_media_store_add_title)
@F3.h(C2541R.string.stmt_media_store_add_summary)
@F3.e(C2541R.layout.stmt_media_store_add_edit)
/* loaded from: classes.dex */
public final class MediaStoreAdd extends Action implements AsyncStatement {
    public InterfaceC1700x0 path;

    public static class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final com.llamalab.safs.n f16913L1;

        /* renamed from: com.llamalab.automate.stmt.MediaStoreAdd$a$a, reason: collision with other inner class name */
        public class C0177a implements MediaScannerConnection.MediaScannerConnectionClient {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Semaphore f16914a;

            public C0177a(Semaphore semaphore) {
                this.f16914a = semaphore;
            }

            @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
            public final void onMediaScannerConnected() {
                this.f16914a.release();
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public final void onScanCompleted(String str, Uri uri) {
                this.f16914a.release();
            }
        }

        public class b extends X4.B {

            /* renamed from: Y, reason: collision with root package name */
            public final /* synthetic */ Semaphore f16915Y;

            /* renamed from: Z, reason: collision with root package name */
            public final /* synthetic */ MediaScannerConnection f16916Z;

            public b(Semaphore semaphore, MediaScannerConnection mediaScannerConnection) {
                this.f16915Y = semaphore;
                this.f16916Z = mediaScannerConnection;
            }

            @Override // com.llamalab.safs.h
            public final void X(com.llamalab.safs.n nVar, InterfaceC2047b interfaceC2047b) {
                try {
                    if (!this.f16915Y.tryAcquire(15L, TimeUnit.SECONDS)) {
                        throw new IOException("Scan took too long");
                    }
                    this.f16916Z.scanFile(nVar.toString(), com.llamalab.safs.i.m(nVar));
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException("Task canceled");
                }
            }
        }

        public a(com.llamalab.safs.n nVar) {
            this.f16913L1 = nVar;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            Semaphore semaphore = new Semaphore(1);
            semaphore.acquire();
            MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(this.f15400Y, new C0177a(semaphore));
            try {
                mediaScannerConnection.connect();
                com.llamalab.safs.i.q(this.f16913L1.N(), com.llamalab.safs.i.f17784b, new b(semaphore, mediaScannerConnection));
                mediaScannerConnection.disconnect();
                if (!semaphore.tryAcquire(15L, TimeUnit.SECONDS)) {
                    throw new IOException("Scan took too long");
                }
                q2(null, false);
            } catch (Throwable th) {
                mediaScannerConnection.disconnect();
                throw th;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_media_store_add);
        l8.v(this.path, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.path);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.path);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.path = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_media_store_add_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.path);
        if (p8 == null) {
            throw new RequiredArgumentNullException("path");
        }
        a aVar = new a(p8);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
