package com.llamalab.automate.stmt;

import Z3.d;
import Z3.e;
import a4.C1194c;
import a4.C1197f;
import a4.C1203l;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.auth3p.MicrosoftClient;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import l4.InterfaceC2065a;
import p3.C2213b;

@F3.f("file_multipart_extract.html")
@F3.a(C2541R.integer.ic_glasses)
@F3.i(C2541R.string.stmt_file_multipart_extract_title)
@F3.h(C2541R.string.stmt_file_multipart_extract_summary)
@F3.e(C2541R.layout.stmt_file_multipart_extract_edit)
/* loaded from: classes.dex */
public final class FileMultipartExtract extends Decision implements AsyncStatement {
    public InterfaceC1700x0 bodyPath;
    public InterfaceC1700x0 boundaryMark;
    public InterfaceC1700x0 partIndex;
    public InterfaceC1700x0 partName;
    public InterfaceC1700x0 saveBody;
    public InterfaceC1700x0 sourceFile;
    public J3.l varPartBody;
    public J3.l varPartHeaders;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final com.llamalab.safs.n f16620L1;

        /* renamed from: M1, reason: collision with root package name */
        public final byte[] f16621M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f16622N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f16623O1;

        /* renamed from: P1, reason: collision with root package name */
        public final int f16624P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final com.llamalab.safs.n f16625Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final boolean f16626R1;

        public a(com.llamalab.safs.n nVar, byte[] bArr, String str, int i8, int i9, com.llamalab.safs.n nVar2, boolean z7) {
            this.f16620L1 = nVar;
            this.f16621M1 = bArr;
            this.f16622N1 = str;
            this.f16623O1 = i8;
            this.f16624P1 = i9;
            this.f16625Q1 = nVar2;
            this.f16626R1 = z7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.CharSequence] */
        public static AbstractMap.SimpleImmutableEntry y2(C1203l c1203l, String str, String str2) {
            List orDefault = c1203l.getOrDefault(str, null);
            String str3 = str2;
            if (orDefault != null) {
                str3 = str2;
                if (!orDefault.isEmpty()) {
                    str3 = (CharSequence) orDefault.get(0);
                }
            }
            return Y3.F.a(str3, C2213b.f21560b);
        }

        /* JADX WARN: Code restructure failed: missing block: B:105:0x0223, code lost:
        
            r23 = r4;
            r24 = r8;
            r22 = r9;
            r25 = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x022b, code lost:
        
            if (r14 == false) goto L151;
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x022d, code lost:
        
            r4 = r26.f16624P1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x022f, code lost:
        
            r9 = r26.f16626R1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0236, code lost:
        
            if (r4 == 1) goto L126;
         */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x0239, code lost:
        
            if (r4 == 2) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x0260, code lost:
        
            if (r11 != null) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x0262, code lost:
        
            r4 = android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(((java.lang.CharSequence) y2(r10, "Content-Type", com.llamalab.automate.fs.AutomateFileTypeDetector.OCTET_STREAM).getKey()).toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x0278, code lost:
        
            if (r4 != null) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x027a, code lost:
        
            r4 = p3.C2212a.d(O.b.d(null, r12), "bin");
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x0285, code lost:
        
            r19 = r12;
            r12 = null;
            r4 = w0.L.t(r26.f16625Q1, android.os.Environment.DIRECTORY_DOWNLOADS, null, com.llamalab.automate.C2541R.string.format_upload_file, r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x02a9, code lost:
        
            r15 = r4;
            r11 = com.llamalab.safs.i.j(r4, com.llamalab.safs.p.WRITE, com.llamalab.safs.p.CREATE, com.llamalab.safs.p.TRUNCATE_EXISTING);
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x02b9, code lost:
        
            if (r7.f7985f.hasRemaining() == false) goto L218;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x02bb, code lost:
        
            r11.write(r7.f7985f);
         */
        /* JADX WARN: Code restructure failed: missing block: B:126:0x02c1, code lost:
        
            if (r5 == r2) goto L204;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x02c3, code lost:
        
            r6 = r20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x032f, code lost:
        
            r16 = r23;
            r8 = r24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x03c5, code lost:
        
            r13 = r25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:131:0x02c6, code lost:
        
            r0 = new java.lang.Object[3];
            r0[0] = java.lang.Boolean.TRUE;
            r0[1] = r15.toString();
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x02d5, code lost:
        
            if (r9 == false) goto L120;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x02d7, code lost:
        
            r4 = J3.h.P(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x02dd, code lost:
        
            r0[2] = r4;
            q2(r0, false);
         */
        /* JADX WARN: Code restructure failed: missing block: B:135:0x02e4, code lost:
        
            if (r11 == null) goto L124;
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x02e6, code lost:
        
            r11.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x02e9, code lost:
        
            r3.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x02ec, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:139:0x02dc, code lost:
        
            r4 = r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:141:0x02ac, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x03dc, code lost:
        
            r4 = r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x03e2, code lost:
        
            if (r4 != null) goto L165;
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x03e4, code lost:
        
            r4.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x03e7, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x02b0, code lost:
        
            r19 = r12;
            r12 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x023c, code lost:
        
            r0 = new java.lang.Object[3];
            r0[0] = java.lang.Boolean.TRUE;
            r0[1] = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x0247, code lost:
        
            if (r9 == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x0249, code lost:
        
            r4 = J3.h.P(r10);
            r2 = 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x0251, code lost:
        
            r0[r2] = r4;
            q2(r0, false);
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x0257, code lost:
        
            if (r11 == null) goto L99;
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x0259, code lost:
        
            r11.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x025c, code lost:
        
            r3.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x025f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x024f, code lost:
        
            r2 = 2;
            r4 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x02ed, code lost:
        
            r19 = r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x02fa, code lost:
        
            if (r20.remaining() >= r7.f7985f.remaining()) goto L130;
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x02fc, code lost:
        
            r20 = java.nio.ByteBuffer.allocate(1 << (32 - java.lang.Integer.numberOfLeadingZeros(java.lang.Math.max(r20.capacity() + r7.f7985f.remaining(), com.llamalab.android.system.MoreOsConstants.O_DSYNC) - 1))).put((java.nio.ByteBuffer) r20.flip());
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x0325, code lost:
        
            r4 = r20;
            r4.put(r7.f7985f);
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x032c, code lost:
        
            if (r5 == r2) goto L201;
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x032e, code lost:
        
            r6 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:167:0x0335, code lost:
        
            r4.flip();
            r0 = y2(r10, "Content-Type", com.llamalab.automate.fs.AutomateFileTypeDetector.OCTET_STREAM);
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x034c, code lost:
        
            if ("application/json".contentEquals((java.lang.CharSequence) r0.getKey()) == false) goto L138;
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x034e, code lost:
        
            r5 = "UTF-8";
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x0351, code lost:
        
            r0 = Y3.F.b(r0, "charset", r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x0355, code lost:
        
            if (r0 != null) goto L142;
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x0357, code lost:
        
            r0 = new q7.b();
            r0.b(r4.array(), r4.arrayOffset() + r4.position(), r4.remaining());
            r0.a();
            r0 = (java.lang.CharSequence) s1.C2305a.o(r0.f21852f, "UTF-8");
         */
        /* JADX WARN: Code restructure failed: missing block: B:174:0x037b, code lost:
        
            r2 = new java.lang.String(r4.array(), r4.arrayOffset() + r4.position(), r4.remaining(), r0.toString());
            r0 = new java.lang.Object[3];
            r0[0] = java.lang.Boolean.TRUE;
            r0[1] = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:175:0x03a0, code lost:
        
            if (r9 == false) goto L145;
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x03a2, code lost:
        
            r4 = J3.h.P(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x03a8, code lost:
        
            r0[2] = r4;
            q2(r0, false);
         */
        /* JADX WARN: Code restructure failed: missing block: B:178:0x03af, code lost:
        
            if (r11 == null) goto L149;
         */
        /* JADX WARN: Code restructure failed: missing block: B:179:0x03b1, code lost:
        
            r11.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:180:0x03b4, code lost:
        
            r3.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:181:0x03b7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:182:0x03a7, code lost:
        
            r4 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:183:0x0350, code lost:
        
            r5 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:184:0x03b8, code lost:
        
            r19 = r12;
            r6 = r20;
            r16 = r23;
            r8 = r24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x03c1, code lost:
        
            if (r5 != r2) goto L154;
         */
        /* JADX WARN: Code restructure failed: missing block: B:186:0x03c3, code lost:
        
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0162, code lost:
        
            r10.clear();
            r16 = r4;
            r19 = r12;
            r8 = r20;
            r13 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0145, code lost:
        
            if (r13.contentEquals((java.lang.CharSequence) r5.get(0)) == false) goto L60;
         */
        /* JADX WARN: Not initialized variable reg: 15, insn: 0x03e9: IF  (r15 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:192:0x03ee (LINE:1002), block:B:191:0x03e9 */
        /* JADX WARN: Removed duplicated region for block: B:62:0x014c A[Catch: all -> 0x03db, TryCatch #4 {all -> 0x03db, blocks: (B:9:0x003d, B:13:0x0052, B:21:0x03c7, B:28:0x0070, B:37:0x0090, B:40:0x0097, B:42:0x00af, B:43:0x00db, B:57:0x00fa, B:62:0x014c, B:64:0x0152, B:68:0x0162, B:70:0x0111, B:74:0x0124, B:76:0x0134, B:78:0x013a, B:80:0x016f, B:81:0x0178, B:83:0x017e, B:85:0x0190, B:88:0x019d, B:90:0x01a3, B:92:0x01b5, B:94:0x01b9, B:100:0x01e3, B:107:0x022d, B:150:0x023c, B:152:0x0249, B:153:0x0251, B:113:0x0262, B:115:0x027a, B:116:0x0285, B:122:0x02b3, B:124:0x02bb, B:131:0x02c6, B:133:0x02d7, B:134:0x02dd, B:160:0x02f0, B:162:0x02fc, B:163:0x0325, B:167:0x0335, B:171:0x0351, B:173:0x0357, B:174:0x037b, B:176:0x03a2, B:177:0x03a8), top: B:8:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0162 A[EDGE_INSN: B:69:0x0162->B:68:0x0162 BREAK  A[LOOP:2: B:35:0x008c->B:56:0x020c], SYNTHETIC] */
        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void x2() {
            int i8;
            CharSequence charSequence;
            int i9;
            Z3.d dVar;
            boolean z7;
            Z3.d dVar2;
            boolean z8;
            try {
                InterfaceC2065a j8 = com.llamalab.safs.i.j(this.f16620L1, com.llamalab.safs.p.READ);
                try {
                    try {
                        ByteBuffer allocate = ByteBuffer.allocate(8192);
                        ByteBuffer byteBuffer = C1194c.f8200b;
                        Z3.e eVar = new Z3.e(this.f16621M1);
                        Z3.d dVar3 = new Z3.d(Integer.MAX_VALUE);
                        C1203l c1203l = new C1203l(new E0.t(0), new E(0));
                        InterfaceC2065a interfaceC2065a = null;
                        CharSequence charSequence2 = null;
                        boolean z9 = true;
                        boolean z10 = false;
                        com.llamalab.safs.n nVar = null;
                        int i10 = 0;
                        while (true) {
                            try {
                                int read = j8.read((ByteBuffer) allocate.clear());
                                allocate.flip();
                                while (true) {
                                    e.b a8 = eVar.a(allocate, read == -1);
                                    int ordinal = a8.ordinal();
                                    ByteBuffer byteBuffer2 = byteBuffer;
                                    if (ordinal == 4 || ordinal == 5) {
                                        int i11 = i10;
                                        while (true) {
                                            e.b bVar = e.b.f8002x0;
                                            if (!z9) {
                                                break;
                                            }
                                            ByteBuffer byteBuffer3 = eVar.f7985f;
                                            i8 = read;
                                            d.b bVar2 = (d.b) dVar3.c(byteBuffer3, byteBuffer3.position(), bVar == a8);
                                            byteBuffer = byteBuffer2.remaining() < dVar3.f8034b.remaining() ? ByteBuffer.allocate(1 << (32 - Integer.numberOfLeadingZeros(Math.max(byteBuffer2.capacity() + dVar3.f8034b.remaining(), MoreOsConstants.O_DSYNC) - 1))).put((ByteBuffer) byteBuffer2.flip()) : byteBuffer2;
                                            byteBuffer.put(dVar3.f8034b);
                                            int ordinal2 = bVar2.ordinal();
                                            if (ordinal2 == 0) {
                                                break;
                                            }
                                            if (ordinal2 == 1) {
                                                i9 = i11;
                                                dVar = dVar3;
                                                z7 = z9;
                                                ByteBuffer byteBuffer4 = (ByteBuffer) byteBuffer.flip();
                                                String str = new String(byteBuffer4.array(), byteBuffer4.position() + byteBuffer4.arrayOffset(), byteBuffer4.remaining(), C2213b.f21559a);
                                                byteBuffer.clear();
                                                charSequence2 = str;
                                            } else {
                                                if (ordinal2 == 2) {
                                                    break;
                                                }
                                                if (ordinal2 == 3) {
                                                    ByteBuffer byteBuffer5 = (ByteBuffer) byteBuffer.flip();
                                                    while (true) {
                                                        if (!byteBuffer5.hasRemaining()) {
                                                            i9 = i11;
                                                            break;
                                                        }
                                                        int position = byteBuffer5.position();
                                                        i9 = i11;
                                                        if (!Y3.F.d(byteBuffer5.get(position) & 255)) {
                                                            break;
                                                        }
                                                        byteBuffer5.position(position + 1);
                                                        i11 = i9;
                                                    }
                                                    while (byteBuffer5.hasRemaining()) {
                                                        int limit = byteBuffer5.limit() - 1;
                                                        if (!Y3.F.d(byteBuffer5.get(limit) & 255)) {
                                                            break;
                                                        } else {
                                                            byteBuffer5.limit(limit);
                                                        }
                                                    }
                                                    dVar = dVar3;
                                                    z7 = z9;
                                                    c1203l.g(charSequence2, new String(byteBuffer5.array(), byteBuffer5.position() + byteBuffer5.arrayOffset(), byteBuffer5.remaining(), C2213b.f21559a));
                                                    byteBuffer.clear();
                                                } else if (ordinal2 != 4) {
                                                    i9 = i11;
                                                    dVar = dVar3;
                                                    z7 = z9;
                                                } else {
                                                    Z3.d dVar4 = new Z3.d(Integer.MAX_VALUE);
                                                    AbstractMap.SimpleImmutableEntry y22 = y2(c1203l, "Content-Disposition", "inline");
                                                    String str2 = this.f16622N1;
                                                    if (str2 != null) {
                                                        dVar2 = dVar4;
                                                        if (C1197f.e("form-data", (CharSequence) y22.getKey())) {
                                                            List list = (List) ((Map) y22.getValue()).get(MicrosoftClient.PROP_NAME);
                                                            if (list != null) {
                                                                if (!list.isEmpty()) {
                                                                }
                                                            }
                                                        }
                                                        z8 = false;
                                                        if (!z8) {
                                                            int i12 = i11 + 1;
                                                            if (this.f16623O1 != i11) {
                                                                i11 = i12;
                                                                break;
                                                            }
                                                            charSequence2 = Y3.F.b(y22, "filename", null);
                                                            i11 = i12;
                                                            dVar3 = dVar2;
                                                            z9 = false;
                                                            z10 = true;
                                                            byteBuffer2 = byteBuffer;
                                                            read = i8;
                                                        } else {
                                                            break;
                                                        }
                                                    } else {
                                                        dVar2 = dVar4;
                                                    }
                                                    z8 = true;
                                                    if (!z8) {
                                                    }
                                                }
                                            }
                                            i11 = i9;
                                            dVar3 = dVar;
                                            z9 = z7;
                                            byteBuffer2 = byteBuffer;
                                            read = i8;
                                        }
                                        charSequence = charSequence2;
                                        i10 = i11;
                                        dVar3 = dVar3;
                                        z9 = z9;
                                    } else {
                                        if (ordinal == 8) {
                                            q2(new Object[]{Boolean.FALSE, null, null}, false);
                                            if (interfaceC2065a != null) {
                                                interfaceC2065a.close();
                                            }
                                            j8.close();
                                            return;
                                        }
                                        i8 = read;
                                        charSequence = charSequence2;
                                        byteBuffer = byteBuffer2;
                                    }
                                    charSequence2 = charSequence;
                                    if (!allocate.hasRemaining()) {
                                        break;
                                    } else {
                                        read = i8;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                            }
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    InterfaceC2065a interfaceC2065a2 = null;
                }
            } catch (InterruptedIOException e8) {
                if (!Thread.currentThread().isInterrupted()) {
                    throw e8;
                }
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
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_file_multipart_extract);
        l8.t(this.sourceFile);
        return l8.q(this.sourceFile).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.sourceFile);
        dVar.g(this.boundaryMark);
        dVar.g(this.partName);
        dVar.g(this.partIndex);
        dVar.g(this.saveBody);
        dVar.g(this.bodyPath);
        dVar.g(this.varPartBody);
        dVar.g(this.varPartHeaders);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.sourceFile);
        visitor.b(this.boundaryMark);
        visitor.b(this.partName);
        visitor.b(this.partIndex);
        visitor.b(this.saveBody);
        visitor.b(this.bodyPath);
        visitor.b(this.varPartBody);
        visitor.b(this.varPartHeaders);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.sourceFile = (InterfaceC1700x0) cVar.readObject();
        this.boundaryMark = (InterfaceC1700x0) cVar.readObject();
        this.partName = (InterfaceC1700x0) cVar.readObject();
        this.partIndex = (InterfaceC1700x0) cVar.readObject();
        this.saveBody = (InterfaceC1700x0) cVar.readObject();
        this.bodyPath = (InterfaceC1700x0) cVar.readObject();
        this.varPartBody = (J3.l) cVar.readObject();
        this.varPartHeaders = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        com.llamalab.safs.n nVar;
        int i8;
        c1708z0.q(C2541R.string.stmt_file_multipart_extract_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.sourceFile);
        if (p8 == null) {
            throw new RequiredArgumentNullException("sourceFile");
        }
        String x7 = J3.h.x(c1708z0, this.boundaryMark, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("boundaryMark");
        }
        String x8 = J3.h.x(c1708z0, this.partName, null);
        int m8 = J3.h.m(c1708z0, this.partIndex, 0);
        int m9 = J3.h.m(c1708z0, this.saveBody, 0);
        if (m9 != 1) {
            i8 = 2;
            if (m9 == 2) {
                nVar = J3.h.p(c1708z0, this.bodyPath);
            }
            nVar = null;
            i8 = 0;
        } else {
            if (this.varPartBody != null) {
                nVar = null;
                i8 = 1;
            }
            nVar = null;
            i8 = 0;
        }
        a aVar = new a(p8, x7.getBytes(C2213b.f21561c), x8, m8, i8, nVar, this.varPartHeaders != null);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varPartBody;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[1]);
        }
        J3.l lVar2 = this.varPartHeaders;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[2]);
        }
        o(c1708z0, ((Boolean) objArr[0]).booleanValue());
        return true;
    }
}
