package org.bouncycastle.jcajce.provider.keystore.bc;

import C1.D1;
import D1.P;
import F5.q;
import L5.D;
import P5.j;
import P5.s;
import S5.n;
import X5.m;
import Y5.b;
import Z5.d;
import c6.M;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import l7.f;
import n6.C2180a;
import n6.C2181b;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import s1.C2305a;
import y6.C2472a;

/* loaded from: classes.dex */
public class BcKeyStoreSpi extends KeyStoreSpi {

    /* renamed from: c, reason: collision with root package name */
    public final int f21374c;

    /* renamed from: a, reason: collision with root package name */
    public final Hashtable f21372a = new Hashtable();

    /* renamed from: b, reason: collision with root package name */
    public final SecureRandom f21373b = j.a();

    /* renamed from: d, reason: collision with root package name */
    public final C2472a f21375d = new C2472a(0);

    public static class BCKeyStoreException extends KeyStoreException {

        /* renamed from: X, reason: collision with root package name */
        public final Exception f21376X;

        public BCKeyStoreException(String str, Exception exc) {
            super(str);
            this.f21376X = exc;
        }

        @Override // java.lang.Throwable
        public final Throwable getCause() {
            return this.f21376X;
        }
    }

    public static class BouncyCastleStore extends BcKeyStoreSpi {
        public BouncyCastleStore() {
            super(1);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi, java.security.KeyStoreSpi
        public final void engineLoad(InputStream inputStream, char[] cArr) {
            Hashtable hashtable = this.f21372a;
            hashtable.clear();
            if (inputStream == null) {
                return;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int readInt = dataInputStream.readInt();
            if (readInt != 2 && readInt != 0 && readInt != 1) {
                throw new IOException("Wrong version of key store.");
            }
            int readInt2 = dataInputStream.readInt();
            byte[] bArr = new byte[readInt2];
            if (readInt2 != 20) {
                throw new IOException("Key store corrupted.");
            }
            dataInputStream.readFully(bArr);
            int readInt3 = dataInputStream.readInt();
            if (readInt3 < 0 || readInt3 > 65536) {
                throw new IOException("Key store corrupted.");
            }
            C2180a c2180a = new C2180a(dataInputStream, f(readInt == 0 ? "OldPBEWithSHAAndTwofish-CBC" : "PBEWithSHAAndTwofish-CBC", 2, cArr, bArr, readInt3));
            n nVar = new n();
            e(new Y5.a(c2180a, nVar, 0));
            byte[] bArr2 = new byte[20];
            nVar.c(bArr2, 0);
            byte[] bArr3 = new byte[20];
            C2305a.k(c2180a, bArr3, 0, 20);
            if (l7.a.i(bArr2, bArr3)) {
                return;
            }
            hashtable.clear();
            throw new IOException("KeyStore integrity check failed.");
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi, java.security.KeyStoreSpi
        public final void engineStore(OutputStream outputStream, char[] cArr) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            byte[] bArr = new byte[20];
            SecureRandom secureRandom = this.f21373b;
            int nextInt = (secureRandom.nextInt() & 1023) + 1024;
            secureRandom.nextBytes(bArr);
            dataOutputStream.writeInt(this.f21374c);
            dataOutputStream.writeInt(20);
            dataOutputStream.write(bArr);
            dataOutputStream.writeInt(nextInt);
            C2181b c2181b = new C2181b(dataOutputStream, f("PBEWithSHAAndTwofish-CBC", 1, cArr, bArr, nextInt));
            b bVar = new b(0, new n());
            g(new n7.b(c2181b, bVar));
            P5.n nVar = (P5.n) bVar.f7919Y;
            byte[] bArr2 = new byte[nVar.e()];
            nVar.c(bArr2, 0);
            c2181b.write(bArr2);
            c2181b.close();
        }
    }

    public static class Std extends BcKeyStoreSpi {
        public Std() {
            super(2);
        }
    }

    public static class Version1 extends BcKeyStoreSpi {
        public Version1() {
            super(1);
            if (!f.b("org.bouncycastle.bks.enable_v1")) {
                throw new IllegalStateException("BKS-V1 not enabled");
            }
        }
    }

    public BcKeyStoreSpi(int i8) {
        this.f21374c = i8;
    }

    public static void c(Certificate certificate, DataOutputStream dataOutputStream) {
        try {
            byte[] encoded = certificate.getEncoded();
            dataOutputStream.writeUTF(certificate.getType());
            dataOutputStream.writeInt(encoded.length);
            dataOutputStream.write(encoded);
        } catch (CertificateEncodingException e8) {
            throw new IOException(e8.toString());
        }
    }

    public static void d(Key key, DataOutputStream dataOutputStream) {
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new IOException("unable to store encoding of protected key");
        }
        dataOutputStream.write(key instanceof PrivateKey ? 0 : key instanceof PublicKey ? 1 : 2);
        dataOutputStream.writeUTF(key.getFormat());
        dataOutputStream.writeUTF(key.getAlgorithm());
        dataOutputStream.writeInt(encoded.length);
        dataOutputStream.write(encoded);
    }

    public final Certificate a(DataInputStream dataInputStream) {
        String readUTF = dataInputStream.readUTF();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        try {
            return this.f21375d.g(readUTF).generateCertificate(new ByteArrayInputStream(bArr));
        } catch (NoSuchProviderException e8) {
            throw new IOException(e8.toString());
        } catch (CertificateException e9) {
            throw new IOException(e9.toString());
        }
    }

    public final Key b(DataInputStream dataInputStream) {
        KeySpec pKCS8EncodedKeySpec;
        int read = dataInputStream.read();
        String readUTF = dataInputStream.readUTF();
        String readUTF2 = dataInputStream.readUTF();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        if (readUTF.equals("PKCS#8") || readUTF.equals("PKCS8")) {
            pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(bArr);
        } else {
            if (!readUTF.equals("X.509") && !readUTF.equals("X509")) {
                if (readUTF.equals("RAW")) {
                    return new SecretKeySpec(bArr, readUTF2);
                }
                throw new IOException(P.o("Key format ", readUTF, " not recognised!"));
            }
            pKCS8EncodedKeySpec = new X509EncodedKeySpec(bArr);
        }
        try {
            if (read == 0) {
                return BouncyCastleProvider.getPrivateKey(q.q(bArr));
            }
            if (read == 1) {
                return BouncyCastleProvider.getPublicKey(D.q(bArr));
            }
            if (read == 2) {
                return SecretKeyFactory.getInstance(readUTF2, (Provider) this.f21375d.f23561X).generateSecret(pKCS8EncodedKeySpec);
            }
            throw new IOException("Key type " + read + " not recognised!");
        } catch (Exception e8) {
            throw new IOException(D1.h(e8, new StringBuilder("Exception creating key: ")));
        }
    }

    public final void e(FilterInputStream filterInputStream) {
        Certificate[] certificateArr;
        a aVar;
        DataInputStream dataInputStream = new DataInputStream(filterInputStream);
        for (int read = dataInputStream.read(); read > 0; read = dataInputStream.read()) {
            String readUTF = dataInputStream.readUTF();
            Date date = new Date(dataInputStream.readLong());
            int readInt = dataInputStream.readInt();
            if (readInt != 0) {
                Certificate[] certificateArr2 = new Certificate[readInt];
                for (int i8 = 0; i8 != readInt; i8++) {
                    certificateArr2[i8] = a(dataInputStream);
                }
                certificateArr = certificateArr2;
            } else {
                certificateArr = null;
            }
            Hashtable hashtable = this.f21372a;
            if (read == 1) {
                aVar = new a(readUTF, date, a(dataInputStream));
            } else if (read == 2) {
                aVar = new a(readUTF, date, 2, b(dataInputStream), certificateArr);
            } else {
                if (read != 3 && read != 4) {
                    throw new IOException("Unknown object type in store.");
                }
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr);
                hashtable.put(readUTF, new a(readUTF, date, read, bArr, certificateArr));
            }
            hashtable.put(readUTF, aVar);
        }
    }

    @Override // java.security.KeyStoreSpi
    public final Enumeration engineAliases() {
        return this.f21372a.keys();
    }

    @Override // java.security.KeyStoreSpi
    public final boolean engineContainsAlias(String str) {
        return this.f21372a.get(str) != null;
    }

    @Override // java.security.KeyStoreSpi
    public final void engineDeleteEntry(String str) {
        Hashtable hashtable = this.f21372a;
        if (hashtable.get(str) == null) {
            return;
        }
        hashtable.remove(str);
    }

    @Override // java.security.KeyStoreSpi
    public final Certificate engineGetCertificate(String str) {
        a aVar = (a) this.f21372a.get(str);
        if (aVar == null) {
            return null;
        }
        if (aVar.f21377a == 1) {
            return (Certificate) aVar.f21379c;
        }
        Certificate[] certificateArr = aVar.f21380d;
        if (certificateArr != null) {
            return certificateArr[0];
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public final String engineGetCertificateAlias(Certificate certificate) {
        Enumeration elements = this.f21372a.elements();
        while (elements.hasMoreElements()) {
            a aVar = (a) elements.nextElement();
            Object obj = aVar.f21379c;
            boolean z7 = obj instanceof Certificate;
            String str = aVar.f21378b;
            if (!z7) {
                Certificate[] certificateArr = aVar.f21380d;
                if (certificateArr != null && certificateArr[0].equals(certificate)) {
                    return str;
                }
            } else if (((Certificate) obj).equals(certificate)) {
                return str;
            }
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public final Certificate[] engineGetCertificateChain(String str) {
        a aVar = (a) this.f21372a.get(str);
        if (aVar != null) {
            return aVar.f21380d;
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public final Date engineGetCreationDate(String str) {
        a aVar = (a) this.f21372a.get(str);
        if (aVar != null) {
            return aVar.f21381e;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x001e, code lost:
    
        if (r4 != false) goto L26;
     */
    @Override // java.security.KeyStoreSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Key engineGetKey(String str, char[] cArr) {
        int i8;
        Object obj;
        Key key;
        a aVar = (a) this.f21372a.get(str);
        if (aVar == null || (i8 = aVar.f21377a) == 1) {
            return null;
        }
        BcKeyStoreSpi bcKeyStoreSpi = BcKeyStoreSpi.this;
        if (cArr == null || cArr.length == 0) {
            Object obj2 = aVar.f21379c;
            boolean z7 = obj2 instanceof Key;
            obj = obj2;
        }
        if (i8 != 4) {
            throw new RuntimeException("forget something!");
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) aVar.f21379c));
        try {
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr);
            try {
                obj = bcKeyStoreSpi.b(new DataInputStream(new C2180a(dataInputStream, BcKeyStoreSpi.this.f("PBEWithSHAAnd3-KeyTripleDES-CBC", 2, cArr, bArr, dataInputStream.readInt()))));
            } catch (Exception unused) {
                DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) aVar.f21379c));
                byte[] bArr2 = new byte[dataInputStream2.readInt()];
                dataInputStream2.readFully(bArr2);
                int readInt = dataInputStream2.readInt();
                try {
                    key = bcKeyStoreSpi.b(new DataInputStream(new C2180a(dataInputStream2, BcKeyStoreSpi.this.f("BrokenPBEWithSHAAnd3-KeyTripleDES-CBC", 2, cArr, bArr2, readInt))));
                } catch (Exception unused2) {
                    DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) aVar.f21379c));
                    bArr2 = new byte[dataInputStream3.readInt()];
                    dataInputStream3.readFully(bArr2);
                    readInt = dataInputStream3.readInt();
                    key = bcKeyStoreSpi.b(new DataInputStream(new C2180a(dataInputStream3, BcKeyStoreSpi.this.f("OldPBEWithSHAAnd3-KeyTripleDES-CBC", 2, cArr, bArr2, readInt))));
                }
                byte[] bArr3 = bArr2;
                int i9 = readInt;
                if (key == null) {
                    throw new UnrecoverableKeyException("no match");
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(bArr3.length);
                dataOutputStream.write(bArr3);
                dataOutputStream.writeInt(i9);
                DataOutputStream dataOutputStream2 = new DataOutputStream(new C2181b(dataOutputStream, BcKeyStoreSpi.this.f("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, cArr, bArr3, i9)));
                bcKeyStoreSpi.getClass();
                d(key, dataOutputStream2);
                dataOutputStream2.close();
                aVar.f21379c = byteArrayOutputStream.toByteArray();
                obj = key;
            }
            return (Key) obj;
        } catch (Exception unused3) {
            throw new UnrecoverableKeyException("no match");
        }
    }

    @Override // java.security.KeyStoreSpi
    public final boolean engineIsCertificateEntry(String str) {
        a aVar = (a) this.f21372a.get(str);
        return aVar != null && aVar.f21377a == 1;
    }

    @Override // java.security.KeyStoreSpi
    public final boolean engineIsKeyEntry(String str) {
        a aVar = (a) this.f21372a.get(str);
        return (aVar == null || aVar.f21377a == 1) ? false : true;
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) {
        Hashtable hashtable = this.f21372a;
        hashtable.clear();
        if (inputStream == null) {
            return;
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        if (readInt != 2 && readInt != 0 && readInt != 1) {
            throw new IOException("Wrong version of key store.");
        }
        int readInt2 = dataInputStream.readInt();
        if (readInt2 <= 0) {
            throw new IOException("Invalid salt detected");
        }
        byte[] bArr = new byte[readInt2];
        dataInputStream.readFully(bArr);
        int readInt3 = dataInputStream.readInt();
        d dVar = new d(new n());
        int i8 = dVar.f8116Y;
        if (cArr == null || cArr.length == 0) {
            e(dataInputStream);
            dataInputStream.readFully(new byte[i8]);
            return;
        }
        byte[] a8 = s.a(cArr);
        m mVar = new m(new n());
        mVar.f(readInt3, a8, bArr);
        M c8 = readInt != 2 ? mVar.c(i8) : mVar.c(i8 * 8);
        Arrays.fill(a8, (byte) 0);
        dVar.c(c8);
        e(new Y5.a(dataInputStream, dVar, 1));
        byte[] bArr2 = new byte[i8];
        dVar.e(bArr2);
        byte[] bArr3 = new byte[i8];
        dataInputStream.readFully(bArr3);
        if (l7.a.i(bArr2, bArr3)) {
            return;
        }
        hashtable.clear();
        throw new IOException("KeyStore integrity check failed.");
    }

    @Override // java.security.KeyStoreSpi
    public final void engineSetCertificateEntry(String str, Certificate certificate) {
        Hashtable hashtable = this.f21372a;
        a aVar = (a) hashtable.get(str);
        if (aVar != null && aVar.f21377a != 1) {
            throw new KeyStoreException(D1.k("key store already has a key entry with alias ", str));
        }
        hashtable.put(str, new a(str, certificate));
    }

    @Override // java.security.KeyStoreSpi
    public final void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
        boolean z7 = key instanceof PrivateKey;
        Hashtable hashtable = this.f21372a;
        if (z7) {
            if (certificateArr == null) {
                throw new KeyStoreException("no certificate chain for private key");
            }
            if (key.getEncoded() == null) {
                hashtable.put(str, new a(str, new Date(), 2, key, certificateArr));
                return;
            }
        }
        try {
            hashtable.put(str, new a(str, key, cArr, certificateArr));
        } catch (Exception e8) {
            throw new BCKeyStoreException(e8.toString(), e8);
        }
    }

    @Override // java.security.KeyStoreSpi
    public final int engineSize() {
        return this.f21372a.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        byte[] bArr = new byte[20];
        SecureRandom secureRandom = this.f21373b;
        int nextInt = (secureRandom.nextInt() & 1023) + 1024;
        secureRandom.nextBytes(bArr);
        int i8 = this.f21374c;
        dataOutputStream.writeInt(i8);
        dataOutputStream.writeInt(20);
        dataOutputStream.write(bArr);
        dataOutputStream.writeInt(nextInt);
        d dVar = new d(new n());
        b bVar = new b(1, dVar);
        m mVar = new m(new n());
        byte[] a8 = s.a(cArr);
        mVar.f(nextInt, a8, bArr);
        int i9 = dVar.f8116Y;
        dVar.c(i8 < 2 ? mVar.c(i9) : mVar.c(i9 * 8));
        for (int i10 = 0; i10 != a8.length; i10++) {
            a8[i10] = 0;
        }
        g(new n7.b(dataOutputStream, bVar));
        byte[] bArr2 = new byte[i9];
        dVar.e(bArr2);
        dataOutputStream.write(bArr2);
        dataOutputStream.close();
    }

    public final Cipher f(String str, int i8, char[] cArr, byte[] bArr, int i9) {
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
            C2472a c2472a = this.f21375d;
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(str, (Provider) c2472a.f23561X);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i9);
            Cipher i10 = c2472a.i(str);
            i10.init(i8, secretKeyFactory.generateSecret(pBEKeySpec), pBEParameterSpec);
            return i10;
        } catch (Exception e8) {
            throw new IOException("Error initialising store of key store: " + e8);
        }
    }

    public final void g(n7.b bVar) {
        Enumeration elements = this.f21372a.elements();
        DataOutputStream dataOutputStream = new DataOutputStream(bVar);
        while (true) {
            if (!elements.hasMoreElements()) {
                dataOutputStream.write(0);
                return;
            }
            a aVar = (a) elements.nextElement();
            dataOutputStream.write(aVar.f21377a);
            dataOutputStream.writeUTF(aVar.f21378b);
            dataOutputStream.writeLong(aVar.f21381e.getTime());
            Certificate[] certificateArr = aVar.f21380d;
            if (certificateArr == null) {
                dataOutputStream.writeInt(0);
            } else {
                dataOutputStream.writeInt(certificateArr.length);
                for (int i8 = 0; i8 != certificateArr.length; i8++) {
                    c(certificateArr[i8], dataOutputStream);
                }
            }
            int i9 = aVar.f21377a;
            if (i9 == 1) {
                c((Certificate) aVar.f21379c, dataOutputStream);
            } else if (i9 == 2) {
                d((Key) aVar.f21379c, dataOutputStream);
            } else {
                if (i9 != 3 && i9 != 4) {
                    throw new IOException("Unknown object type in store.");
                }
                byte[] bArr = (byte[]) aVar.f21379c;
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
            }
        }
    }

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f21377a;

        /* renamed from: b, reason: collision with root package name */
        public final String f21378b;

        /* renamed from: c, reason: collision with root package name */
        public Object f21379c;

        /* renamed from: d, reason: collision with root package name */
        public final Certificate[] f21380d;

        /* renamed from: e, reason: collision with root package name */
        public final Date f21381e;

        public a(String str, Key key, char[] cArr, Certificate[] certificateArr) {
            this.f21381e = new Date();
            this.f21377a = 4;
            this.f21378b = str;
            this.f21380d = certificateArr;
            byte[] bArr = new byte[20];
            BcKeyStoreSpi.this.f21373b.nextBytes(bArr);
            int nextInt = (BcKeyStoreSpi.this.f21373b.nextInt() & 1023) + 1024;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(20);
            dataOutputStream.write(bArr);
            dataOutputStream.writeInt(nextInt);
            DataOutputStream dataOutputStream2 = new DataOutputStream(new C2181b(dataOutputStream, BcKeyStoreSpi.this.f("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, cArr, bArr, nextInt)));
            BcKeyStoreSpi.d(key, dataOutputStream2);
            dataOutputStream2.close();
            this.f21379c = byteArrayOutputStream.toByteArray();
        }

        public a(String str, Certificate certificate) {
            this.f21381e = new Date();
            this.f21377a = 1;
            this.f21378b = str;
            this.f21379c = certificate;
            this.f21380d = null;
        }

        public a(String str, Date date, int i8, Object obj, Certificate[] certificateArr) {
            this.f21381e = new Date();
            this.f21378b = str;
            this.f21381e = date;
            this.f21377a = i8;
            this.f21379c = obj;
            this.f21380d = certificateArr;
        }

        public a(String str, Date date, Certificate certificate) {
            this.f21381e = new Date();
            this.f21378b = str;
            this.f21381e = date;
            this.f21377a = 1;
            this.f21379c = certificate;
        }

        public a(String str, byte[] bArr, Certificate[] certificateArr) {
            this.f21381e = new Date();
            this.f21377a = 3;
            this.f21378b = str;
            this.f21379c = bArr;
            this.f21380d = certificateArr;
        }
    }

    @Override // java.security.KeyStoreSpi
    public final void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
        this.f21372a.put(str, new a(str, bArr, certificateArr));
    }
}
