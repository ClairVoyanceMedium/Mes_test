package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.safs.DirectoryNotEmptyException;
import com.llamalab.safs.FileAlreadyExistsException;
import com.llamalab.safs.NoSuchFileException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import k4.InterfaceC2047b;
import k4.InterfaceC2048c;

@F3.f("zip_compress.html")
@F3.a(C2541R.integer.ic_zip_up)
@F3.i(C2541R.string.stmt_zip_compress_title)
@F3.h(C2541R.string.stmt_zip_compress_summary)
@F3.e(C2541R.layout.stmt_zip_compress_edit)
/* loaded from: classes.dex */
public final class ZipCompress extends Action implements AsyncStatement {
    public InterfaceC1700x0 compressionMethod;
    public InterfaceC1700x0 recursive;
    public InterfaceC1700x0 sourcePath;
    public InterfaceC1700x0 targetPath;
    public InterfaceC1700x0 update;
    public InterfaceC1700x0 zipFile;

    public static final class a extends P3.o {

        /* renamed from: N1, reason: collision with root package name */
        public final com.llamalab.safs.n f17329N1;

        /* renamed from: O1, reason: collision with root package name */
        public final com.llamalab.safs.n f17330O1;

        /* renamed from: P1, reason: collision with root package name */
        public final Set<? extends com.llamalab.safs.b> f17331P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final t4.u f17332Q1;

        /* renamed from: R1, reason: collision with root package name */
        public com.llamalab.safs.n f17333R1;

        /* renamed from: S1, reason: collision with root package name */
        public com.llamalab.safs.n f17334S1;

        public a(com.llamalab.safs.n nVar, com.llamalab.safs.n nVar2, HashSet hashSet, t4.u uVar, Closeable... closeableArr) {
            super(closeableArr);
            this.f17329N1 = nVar;
            this.f17330O1 = nVar2;
            this.f17331P1 = hashSet;
            this.f17332Q1 = uVar;
        }

        public final boolean D2(InterfaceC2047b interfaceC2047b, com.llamalab.safs.n nVar, Set set) {
            if (interfaceC2047b.l()) {
                return set.contains(P3.t.f5936X);
            }
            if (set.contains(P3.s.NOREPLACE_NEWER_FILES)) {
                try {
                    if (interfaceC2047b.d().compareTo(com.llamalab.safs.i.o(nVar, InterfaceC2047b.class, com.llamalab.safs.k.f17866X).d()) <= 0) {
                        return false;
                    }
                } catch (NoSuchFileException unused) {
                }
            }
            return true;
        }

        public final void E2(com.llamalab.safs.n nVar, InterfaceC2047b interfaceC2047b) {
            if (this.f17331P1.contains(com.llamalab.safs.o.COPY_ATTRIBUTES)) {
                try {
                    k4.f d8 = interfaceC2047b.d();
                    com.llamalab.safs.k[] kVarArr = com.llamalab.safs.i.f17783a;
                    nVar.E().f22244X.setAttribute(nVar, "lastModifiedTime", d8, new com.llamalab.safs.k[0]);
                } catch (IOException e8) {
                    Charset charset = com.llamalab.safs.internal.m.f17837a;
                    try {
                        com.llamalab.safs.i.e(nVar);
                    } catch (Throwable unused) {
                    }
                    throw e8;
                }
            }
        }

        @Override // com.llamalab.safs.h
        public final void X(com.llamalab.safs.n nVar, InterfaceC2047b interfaceC2047b) {
            com.llamalab.safs.n F7 = this.f17334S1.F(this.f17333R1.B(nVar));
            Set<? extends com.llamalab.safs.b> set = this.f17331P1;
            if (D2(interfaceC2047b, F7, set)) {
                try {
                    P3.b.y2();
                    com.llamalab.safs.i.c(this.f17330O1, new InterfaceC2048c[0]);
                    if (set.contains(com.llamalab.safs.o.REPLACE_EXISTING)) {
                        com.llamalab.safs.i.f(F7);
                    }
                    OutputStream l8 = com.llamalab.safs.i.l(F7, com.llamalab.safs.p.WRITE, com.llamalab.safs.p.CREATE_NEW, this.f17332Q1);
                    try {
                        com.llamalab.safs.i.a(nVar, l8);
                        if (l8 != null) {
                            l8.close();
                        }
                        E2(F7, interfaceC2047b);
                    } catch (Throwable th) {
                        if (l8 != null) {
                            try {
                                l8.close();
                            } catch (Throwable th2) {
                                try {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                } catch (Exception unused) {
                                }
                            }
                        }
                        throw th;
                    }
                } catch (FileAlreadyExistsException e8) {
                    if (!set.contains(P3.s.MERGE_DIRECTORIES)) {
                        throw e8;
                    }
                }
            }
        }

        @Override // com.llamalab.safs.h
        public final int x1(com.llamalab.safs.n nVar, InterfaceC2047b interfaceC2047b) {
            com.llamalab.safs.n F7 = this.f17334S1.F(this.f17333R1.B(nVar));
            Set<? extends com.llamalab.safs.b> set = this.f17331P1;
            if (!D2(interfaceC2047b, F7, set)) {
                return 3;
            }
            try {
                P3.b.y2();
                if (set.contains(com.llamalab.safs.o.REPLACE_EXISTING) && !((com.llamalab.safs.zip.a) F7.E()).g().equals(F7)) {
                    com.llamalab.safs.i.f(F7);
                }
                com.llamalab.safs.i.c(F7, new InterfaceC2048c[0]);
                E2(F7, interfaceC2047b);
            } catch (DirectoryNotEmptyException | FileAlreadyExistsException e8) {
                if (!set.contains(P3.s.MERGE_DIRECTORIES)) {
                    throw e8;
                }
            }
            return 1;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            com.llamalab.safs.n nVar = this.f17329N1;
            try {
                try {
                    if (this.f17331P1.contains(P3.s.PROCESSOR_INTENSIVE)) {
                        Process.setThreadPriority(Process.getThreadPriority(Process.myTid()) - 1);
                    }
                    com.llamalab.safs.c<com.llamalab.safs.n> z22 = P3.o.z2(nVar);
                    try {
                        Iterator<com.llamalab.safs.n> it = z22.iterator();
                        if (!it.hasNext()) {
                            throw new NoSuchFileException(nVar.toString());
                        }
                        this.f17333R1 = it.next();
                        boolean hasNext = it.hasNext();
                        EnumSet enumSet = P3.o.f5922M1;
                        com.llamalab.safs.n nVar2 = this.f17330O1;
                        if (hasNext) {
                            while (true) {
                                P3.b.y2();
                                this.f17334S1 = nVar2.F(this.f17333R1.C());
                                com.llamalab.safs.i.q(this.f17333R1, enumSet, this);
                                if (!it.hasNext()) {
                                    break;
                                } else {
                                    this.f17333R1 = it.next();
                                }
                            }
                        } else {
                            s4.d C7 = this.f17333R1.C();
                            if (C7 != null) {
                                this.f17334S1 = nVar2.F(C7);
                            } else {
                                this.f17334S1 = nVar2;
                            }
                            com.llamalab.safs.i.q(this.f17333R1, enumSet, this);
                        }
                        z22.close();
                        close();
                        q2(null, false);
                    } catch (Throwable th) {
                        if (z22 != null) {
                            try {
                                z22.close();
                            } catch (Throwable th2) {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            }
                        }
                        throw th;
                    }
                } catch (InterruptedIOException e8) {
                    if (!Thread.currentThread().isInterrupted()) {
                        throw e8;
                    }
                    close();
                }
            } catch (Throwable th3) {
                close();
                throw th3;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_zip_compress);
        l8.t(this.zipFile);
        return l8.q(this.zipFile).y(this.update, C2541R.string.caption_update, 0).y(this.recursive, C2541R.string.caption_recursive, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.zipFile);
        dVar.g(this.sourcePath);
        dVar.g(this.targetPath);
        dVar.g(this.recursive);
        dVar.g(this.update);
        if (93 <= dVar.f6413Z) {
            dVar.g(this.compressionMethod);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.zipFile);
        visitor.b(this.sourcePath);
        visitor.b(this.targetPath);
        visitor.b(this.recursive);
        visitor.b(this.update);
        visitor.b(this.compressionMethod);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.zipFile = (InterfaceC1700x0) cVar.readObject();
        this.sourcePath = (InterfaceC1700x0) cVar.readObject();
        this.targetPath = (InterfaceC1700x0) cVar.readObject();
        this.recursive = (InterfaceC1700x0) cVar.readObject();
        this.update = (InterfaceC1700x0) cVar.readObject();
        if (93 <= cVar.f6409x0) {
            this.compressionMethod = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_zip_compress_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.zipFile);
        if (p8 == null) {
            throw new RequiredArgumentNullException("zipFile");
        }
        boolean f8 = J3.h.f(c1708z0, this.update, false);
        EnumSet of = EnumSet.of(com.llamalab.safs.p.READ, com.llamalab.safs.p.WRITE, com.llamalab.safs.p.CREATE);
        if (!f8) {
            of.add(com.llamalab.safs.p.TRUNCATE_EXISTING);
        }
        P3.e eVar = new P3.e(p8, Collections.singletonMap("openOptions", of));
        c1708z0.w(eVar);
        eVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        t4.u uVar;
        if (!(w8 instanceof P3.e)) {
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        com.llamalab.safs.zip.a aVar = (com.llamalab.safs.zip.a) obj;
        try {
            com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.sourcePath);
            if (p8 == null) {
                throw new RequiredArgumentNullException("sourcePath");
            }
            com.llamalab.safs.n v8 = J3.h.v(c1708z0, this.targetPath, aVar.g(), aVar.g(), aVar);
            if (v8 == null) {
                throw new RequiredArgumentNullException("targetPath");
            }
            boolean f8 = J3.h.f(c1708z0, this.recursive, false);
            int m8 = J3.h.m(c1708z0, this.compressionMethod, 6);
            if (m8 == 0) {
                uVar = t4.u.STORED;
            } else if (m8 == 1) {
                uVar = t4.u.DEFLATED_FASTEST;
            } else if (m8 == 3) {
                uVar = t4.u.DEFLATED_FAST;
            } else if (m8 == 6) {
                uVar = t4.u.DEFLATED;
            } else {
                if (m8 != 9) {
                    throw new IllegalArgumentException("compressionMethod");
                }
                uVar = t4.u.DEFLATED_BEST;
            }
            t4.u uVar2 = uVar;
            HashSet hashSet = new HashSet(5);
            hashSet.add(com.llamalab.safs.o.REPLACE_EXISTING);
            hashSet.add(com.llamalab.safs.o.COPY_ATTRIBUTES);
            hashSet.add(P3.s.MERGE_DIRECTORIES);
            hashSet.add(P3.s.PROCESSOR_INTENSIVE);
            if (f8) {
                hashSet.add(P3.t.f5936X);
            }
            a aVar2 = new a(p8, v8, hashSet, uVar2, aVar);
            c1708z0.w(aVar2);
            aVar2.w2();
            return false;
        } catch (Throwable th) {
            Charset charset = com.llamalab.safs.internal.m.f17837a;
            try {
                aVar.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }
}
