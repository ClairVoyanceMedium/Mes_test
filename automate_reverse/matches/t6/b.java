package t6;

import P5.o;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchProviderException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import l6.C2131a;
import l7.i;
import s1.C2305a;
import w6.C2408d;
import y6.InterfaceC2473b;

/* loaded from: classes.dex */
public final class b extends KeyStoreSpi {

    /* renamed from: a, reason: collision with root package name */
    public final Hashtable<String, a> f22520a = new Hashtable<>();

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC2473b f22521b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Date f22522a;

        /* renamed from: b, reason: collision with root package name */
        public final Certificate f22523b;

        public a(Date date, Certificate certificate) {
            this.f22522a = date;
            this.f22523b = certificate;
        }
    }

    /* renamed from: t6.b$b, reason: collision with other inner class name */
    public static final class C0252b extends ByteArrayInputStream {
        public C0252b(byte[] bArr, int i8) {
            super(bArr, 0, i8);
        }

        public final void a() {
            Arrays.fill(((ByteArrayInputStream) this).buf, (byte) 0);
        }
    }

    public b(InterfaceC2473b interfaceC2473b) {
        this.f22521b = interfaceC2473b;
    }

    @Override // java.security.KeyStoreSpi
    public final Enumeration<String> engineAliases() {
        Enumeration<String> keys;
        synchronized (this.f22520a) {
            keys = this.f22520a.keys();
        }
        return keys;
    }

    @Override // java.security.KeyStoreSpi
    public final boolean engineContainsAlias(String str) {
        boolean containsKey;
        if (str == null) {
            throw new NullPointerException("alias value is null");
        }
        synchronized (this.f22520a) {
            containsKey = this.f22520a.containsKey(str);
        }
        return containsKey;
    }

    @Override // java.security.KeyStoreSpi
    public final void engineDeleteEntry(String str) {
        throw new KeyStoreException("BC JKS store is read-only and only supports certificate entries");
    }

    @Override // java.security.KeyStoreSpi
    public final Certificate engineGetCertificate(String str) {
        synchronized (this.f22520a) {
            a aVar = this.f22520a.get(str);
            if (aVar == null) {
                return null;
            }
            return aVar.f22523b;
        }
    }

    @Override // java.security.KeyStoreSpi
    public final String engineGetCertificateAlias(Certificate certificate) {
        synchronized (this.f22520a) {
            for (Map.Entry<String, a> entry : this.f22520a.entrySet()) {
                if (entry.getValue().f22523b.equals(certificate)) {
                    return entry.getKey();
                }
            }
            return null;
        }
    }

    @Override // java.security.KeyStoreSpi
    public final Certificate[] engineGetCertificateChain(String str) {
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public final Date engineGetCreationDate(String str) {
        synchronized (this.f22520a) {
            a aVar = this.f22520a.get(str);
            if (aVar == null) {
                return null;
            }
            return aVar.f22522a;
        }
    }

    @Override // java.security.KeyStoreSpi
    public final Key engineGetKey(String str, char[] cArr) {
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public final boolean engineIsCertificateEntry(String str) {
        boolean containsKey;
        synchronized (this.f22520a) {
            containsKey = this.f22520a.containsKey(str);
        }
        return containsKey;
    }

    @Override // java.security.KeyStoreSpi
    public final boolean engineIsKeyEntry(String str) {
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public final void engineLoad(InputStream inputStream, char[] cArr) {
        C0252b c0252b;
        CertificateFactory g8;
        Hashtable hashtable;
        CertificateFactory g9;
        if (inputStream == null) {
            return;
        }
        o a8 = C2408d.a("SHA-1");
        byte[] i8 = C2305a.i(inputStream);
        if (cArr != null) {
            for (int i9 = 0; i9 < cArr.length; i9++) {
                a8.d((byte) (cArr[i9] >> '\b'));
                a8.d((byte) cArr[i9]);
            }
            a8.update(i.c("Mighty Aphrodite"), 0, 16);
            a8.update(i8, 0, i8.length - a8.e());
            int e8 = a8.e();
            byte[] bArr = new byte[e8];
            a8.c(bArr, 0);
            byte[] bArr2 = new byte[e8];
            System.arraycopy(i8, i8.length - e8, bArr2, 0, e8);
            if (!l7.a.i(bArr, bArr2)) {
                Arrays.fill(i8, (byte) 0);
                throw new IOException("password incorrect or store tampered with");
            }
            c0252b = new C0252b(i8, i8.length - e8);
        } else {
            c0252b = new C0252b(i8, i8.length - a8.e());
        }
        synchronized (this.f22520a) {
            try {
                DataInputStream dataInputStream = new DataInputStream(c0252b);
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                if (readInt == -17957139) {
                    CertificateFactory certificateFactory = null;
                    if (readInt2 == 1) {
                        InterfaceC2473b interfaceC2473b = this.f22521b;
                        if (interfaceC2473b != null) {
                            try {
                                g8 = interfaceC2473b.g("X.509");
                            } catch (NoSuchProviderException e9) {
                                throw new CertificateException(e9.toString());
                            }
                        } else {
                            g8 = CertificateFactory.getInstance("X.509");
                        }
                        CertificateFactory certificateFactory2 = g8;
                        hashtable = null;
                        certificateFactory = certificateFactory2;
                    } else {
                        if (readInt2 != 2) {
                            throw new IllegalStateException("unable to discern store version");
                        }
                        hashtable = new Hashtable();
                    }
                    int readInt3 = dataInputStream.readInt();
                    for (int i10 = 0; i10 < readInt3; i10++) {
                        int readInt4 = dataInputStream.readInt();
                        if (readInt4 == 1) {
                            throw new IOException("BC JKS store is read-only and only supports certificate entries");
                        }
                        if (readInt4 != 2) {
                            throw new IllegalStateException("unable to discern entry type");
                        }
                        String readUTF = dataInputStream.readUTF();
                        Date date = new Date(dataInputStream.readLong());
                        if (readInt2 == 2) {
                            String readUTF2 = dataInputStream.readUTF();
                            if (hashtable.containsKey(readUTF2)) {
                                certificateFactory = (CertificateFactory) hashtable.get(readUTF2);
                            } else {
                                InterfaceC2473b interfaceC2473b2 = this.f22521b;
                                if (interfaceC2473b2 != null) {
                                    try {
                                        g9 = interfaceC2473b2.g(readUTF2);
                                    } catch (NoSuchProviderException e10) {
                                        throw new CertificateException(e10.toString());
                                    }
                                } else {
                                    g9 = CertificateFactory.getInstance(readUTF2);
                                }
                                hashtable.put(readUTF2, g9);
                                certificateFactory = g9;
                            }
                        }
                        int readInt5 = dataInputStream.readInt();
                        byte[] bArr3 = new byte[readInt5];
                        dataInputStream.readFully(bArr3);
                        C0252b c0252b2 = new C0252b(bArr3, readInt5);
                        try {
                            Certificate generateCertificate = certificateFactory.generateCertificate(c0252b2);
                            if (c0252b2.available() != 0) {
                                throw new IOException("password incorrect or store tampered with");
                            }
                            c0252b2.a();
                            this.f22520a.put(readUTF, new a(date, generateCertificate));
                        } catch (Throwable th) {
                            c0252b2.a();
                            throw th;
                        }
                    }
                }
                if (c0252b.available() != 0) {
                    throw new IOException("password incorrect or store tampered with");
                }
                c0252b.a();
            } catch (Throwable th2) {
                c0252b.a();
                throw th2;
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public final boolean engineProbe(InputStream inputStream) {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        int readInt2 = dataInputStream.readInt();
        return readInt == -17957139 && (readInt2 == 1 || readInt2 == 2);
    }

    @Override // java.security.KeyStoreSpi
    public final void engineSetCertificateEntry(String str, Certificate certificate) {
        throw new KeyStoreException("BC JKS store is read-only and only supports certificate entries");
    }

    @Override // java.security.KeyStoreSpi
    public final void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
        throw new KeyStoreException("BC JKS store is read-only and only supports certificate entries");
    }

    @Override // java.security.KeyStoreSpi
    public final int engineSize() {
        return this.f22520a.size();
    }

    @Override // java.security.KeyStoreSpi
    public final void engineStore(OutputStream outputStream, char[] cArr) {
        throw new IOException("BC JKS store is read-only and only supports certificate entries");
    }

    @Override // java.security.KeyStoreSpi
    public final void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
        throw new KeyStoreException("BC JKS store is read-only and only supports certificate entries");
    }

    @Override // java.security.KeyStoreSpi
    public final void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) {
        if (loadStoreParameter == null) {
            return;
        }
        if (!(loadStoreParameter instanceof C2131a)) {
            throw new IllegalArgumentException("no support for 'param' of type ".concat(loadStoreParameter.getClass().getName()));
        }
        c.a(loadStoreParameter);
    }
}
