package com.llamalab.automate.stmt;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Pair;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.fs.AutomateFileTypeDetector;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import x3.C2429g;

@F3.f("content_read.html")
@F3.a(C2541R.integer.ic_sdcard_content)
@F3.i(C2541R.string.stmt_content_read_title)
@F3.h(C2541R.string.stmt_content_read_summary)
@F3.e(C2541R.layout.stmt_content_read_edit)
/* loaded from: classes.dex */
public final class ContentRead extends Action implements AsyncStatement {
    public InterfaceC1700x0 sourceUri;
    public InterfaceC1700x0 targetPath;
    public J3.l varContentDisplayName;
    public J3.l varContentFile;
    public J3.l varContentMimeType;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final Uri f16490L1;

        /* renamed from: M1, reason: collision with root package name */
        public final com.llamalab.safs.n f16491M1;

        public a(Uri uri, com.llamalab.safs.n nVar) {
            this.f16490L1 = uri;
            this.f16491M1 = nVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void x2() {
            String str;
            String str2;
            Cursor query;
            Throwable th;
            Uri uri = this.f16490L1;
            String scheme = uri.getScheme();
            String str3 = null;
            if ("data".equals(scheme)) {
                Pair<String, byte[]> j8 = C2429g.j(uri);
                y2(new ByteArrayInputStream((byte[]) j8.second), (String) j8.first, null);
                return;
            }
            Uri uri2 = this.f16490L1;
            ContentResolver contentResolver = this.f15400Y.getContentResolver();
            InputStream openInputStream = contentResolver.openInputStream(uri2);
            try {
                if ("content".equals(scheme)) {
                    try {
                        query = contentResolver.query(uri2, null, null, null, null);
                    } catch (Throwable unused) {
                    }
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                int columnIndex = query.getColumnIndex("_display_name");
                                str = columnIndex != -1 ? query.getString(columnIndex) : null;
                                try {
                                    int columnIndex2 = query.getColumnIndex("mime_type");
                                    str2 = columnIndex2 != -1 ? query.getString(columnIndex2) : null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        query.close();
                                        throw th;
                                    } catch (Throwable unused2) {
                                        str2 = null;
                                    }
                                }
                            } else {
                                str = null;
                                str2 = null;
                            }
                            try {
                                query.close();
                            } catch (Throwable unused3) {
                            }
                            if (str2 == null) {
                                try {
                                    str2 = contentResolver.getType(uri2);
                                } catch (Throwable unused4) {
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            str = null;
                        }
                    }
                    str = null;
                    str2 = null;
                    if (str2 == null) {
                    }
                } else {
                    str = null;
                    str2 = null;
                }
                if (str == null) {
                    str = uri2.getLastPathSegment();
                }
                if (str == null || !str.isEmpty()) {
                    str3 = str;
                }
                if (str2 == null && (str2 = AutomateFileTypeDetector.probeContentType(uri2)) == null) {
                    str2 = AutomateFileTypeDetector.OCTET_STREAM;
                }
                y2(openInputStream, str2, str3);
                if (openInputStream != null) {
                    openInputStream.close();
                }
            } catch (Throwable th4) {
                if (openInputStream != null) {
                    try {
                        openInputStream.close();
                    } catch (Throwable th5) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th4, th5);
                        } catch (Exception unused5) {
                        }
                    }
                }
                throw th4;
            }
        }

        public final void y2(InputStream inputStream, String str, String str2) {
            com.llamalab.safs.n t8 = w0.L.t(this.f16491M1, Environment.DIRECTORY_DOWNLOADS, str2, C2541R.string.format_download_file, C2429g.h(str));
            com.llamalab.safs.i.b(inputStream, t8, com.llamalab.safs.o.REPLACE_EXISTING);
            q2(new Object[]{t8.toString(), str2, str}, false);
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
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_content_read);
        l8.v(this.sourceUri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.sourceUri);
        dVar.g(this.targetPath);
        dVar.g(this.varContentFile);
        dVar.g(this.varContentDisplayName);
        dVar.g(this.varContentMimeType);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.sourceUri);
        visitor.b(this.targetPath);
        visitor.b(this.varContentFile);
        visitor.b(this.varContentDisplayName);
        visitor.b(this.varContentMimeType);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.sourceUri = (InterfaceC1700x0) cVar.readObject();
        this.targetPath = (InterfaceC1700x0) cVar.readObject();
        this.varContentFile = (J3.l) cVar.readObject();
        this.varContentDisplayName = (J3.l) cVar.readObject();
        this.varContentMimeType = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_content_read_title);
        Uri g8 = J3.h.g(c1708z0, this.sourceUri, null);
        if (g8 == null) {
            throw new RequiredArgumentNullException("sourceUri");
        }
        a aVar = new a(g8, J3.h.p(c1708z0, this.targetPath));
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varContentFile;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varContentDisplayName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        J3.l lVar3 = this.varContentMimeType;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, objArr[2]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
