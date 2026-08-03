package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1572f1;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.FileApkExtract;
import com.llamalab.gush.util.UncheckedIOException;
import i4.C1951e;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.StringWriter;
import java.util.function.Function;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

@F3.f("file_apk_extract.html")
@F3.a(C2541R.integer.ic_glasses)
@F3.i(C2541R.string.stmt_file_apk_extract_title)
@F3.h(C2541R.string.stmt_file_apk_extract_summary)
@F3.e(C2541R.layout.stmt_file_apk_extract_edit)
/* loaded from: classes.dex */
public final class FileApkExtract extends Action implements AsyncStatement {
    public InterfaceC1700x0 sourceFile;
    public J3.l varManifest;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final com.llamalab.safs.n f16619L1;

        public a(com.llamalab.safs.n nVar) {
            this.f16619L1 = nVar;
        }

        public static String y2(XmlResourceParser xmlResourceParser) {
            try {
                StringWriter stringWriter = new StringWriter();
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument("UTF-8", (Boolean) xmlResourceParser.getProperty("http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone"));
                int[] iArr = new int[2];
                while (true) {
                    int nextToken = xmlResourceParser.nextToken();
                    if (nextToken == 1) {
                        newSerializer.endDocument();
                        newSerializer.flush();
                        return stringWriter.toString();
                    }
                    if (nextToken == 2) {
                        newSerializer.setPrefix("android", "http://schemas.android.com/apk/res/android");
                        newSerializer.startTag(xmlResourceParser.getNamespace(), xmlResourceParser.getName());
                        int attributeCount = xmlResourceParser.getAttributeCount();
                        for (int i8 = 0; i8 < attributeCount; i8++) {
                            newSerializer.attribute(xmlResourceParser.getAttributeNamespace(i8), xmlResourceParser.getAttributeName(i8), xmlResourceParser.getAttributeValue(i8));
                        }
                    } else if (nextToken == 3) {
                        newSerializer.endTag(xmlResourceParser.getNamespace(), xmlResourceParser.getName());
                    } else if (nextToken == 4) {
                        newSerializer.text(xmlResourceParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                    } else if (nextToken == 9) {
                        newSerializer.comment(xmlResourceParser.getText());
                    }
                }
            } catch (IOException e8) {
                throw new UncheckedIOException(e8);
            } catch (XmlPullParserException e9) {
                throw new UncheckedIOException((IOException) new IOException(e9).fillInStackTrace());
            }
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            String str;
            try {
                int i8 = Build.VERSION.SDK_INT;
                com.llamalab.safs.n nVar = this.f16619L1;
                if (36 <= i8) {
                    ParcelFileDescriptor b8 = C1951e.b(nVar, new com.llamalab.safs.l[0]);
                    try {
                        str = (String) j2().getPackageManager().parseAndroidManifest(b8, new Function() { // from class: com.llamalab.automate.stmt.D
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return FileApkExtract.a.y2((XmlResourceParser) obj);
                            }
                        });
                        if (b8 != null) {
                            b8.close();
                        }
                    } finally {
                    }
                } else {
                    str = (String) j2().getPackageManager().parseAndroidManifest(nVar.R(), new C1572f1(1));
                }
                p2(str);
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
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_file_apk_extract);
        l8.t(this.sourceFile);
        return l8.q(this.sourceFile).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.sourceFile);
        dVar.g(this.varManifest);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.sourceFile);
        visitor.b(this.varManifest);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.sourceFile = (InterfaceC1700x0) cVar.readObject();
        this.varManifest = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_file_apk_extract_title);
        IncapableAndroidVersionException.a(35);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.sourceFile);
        if (p8 == null) {
            throw new RequiredArgumentNullException("sourceFile");
        }
        a aVar = new a(p8);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varManifest;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
