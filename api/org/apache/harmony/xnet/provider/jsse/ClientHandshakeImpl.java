package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.security.AccessController;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PrivilegedExceptionAction;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.security.auth.x500.X500Principal;

public class ClientHandshakeImpl extends HandshakeProtocol {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.064 -0400", hash_original_method = "E7725F54B70B03AB684209C7F7E63A02", hash_generated_method = "FEEBAC8AF1F679A50E59BF09FC15BB2E")
      ClientHandshakeImpl(Object owner) {
        super(owner);
        addTaint(owner.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.066 -0400", hash_original_method = "6C060C09ED0246441EBDE47DFEF048B2", hash_generated_method = "3403D44FF3172B973A0689BE5E46B8D3")
    @Override
    public void start() {
    if(session == null)        
        {
            session = findSessionToResume();
        } 
        else
        {
    if(clientHello != null && this.status != FINISHED)            
            {
                return;
            } 
    if(!session.isValid())            
            {
                session = null;
            } 
        } 
    if(session != null)        
        {
            isResuming = true;
        } 
        else
    if(parameters.getEnableSessionCreation())        
        {
            isResuming = false;
            session = new SSLSessionImpl(parameters.getSecureRandom());
    if(engineOwner != null)            
            {
                session.setPeer(engineOwner.getPeerHost(), engineOwner.getPeerPort());
            } 
            else
            {
                session.setPeer(socketOwner.getInetAddress().getHostName(), socketOwner.getPort());
            } 
            session.protocol = ProtocolVersion.getLatestVersion(parameters.getEnabledProtocols());
            recordProtocol.setVersion(session.protocol.version);
        } 
        else
        {
            fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "SSL Session may not be created ");
        } 
        startSession();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.068 -0400", hash_original_method = "A1AF1BC51EE82C9340D705103AD7A155", hash_generated_method = "34AB750B95F9FEAA9E5DB9B016ECCE56")
    private void renegotiateNewSession() {
    if(parameters.getEnableSessionCreation())        
        {
            isResuming = false;
            session = new SSLSessionImpl(parameters.getSecureRandom());
    if(engineOwner != null)            
            {
                session.setPeer(engineOwner.getPeerHost(), engineOwner.getPeerPort());
            } 
            else
            {
                session.setPeer(socketOwner.getInetAddress().getHostName(), socketOwner.getPort());
            } 
            session.protocol = ProtocolVersion.getLatestVersion(parameters.getEnabledProtocols());
            recordProtocol.setVersion(session.protocol.version);
            startSession();
        } 
        else
        {
            status = NOT_HANDSHAKING;
            sendWarningAlert(AlertProtocol.NO_RENEGOTIATION);
        } 
        
        
            
            
            
                
            
                
            
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.070 -0400", hash_original_method = "FFCAFC294E61749148CA1FC19A14A2BB", hash_generated_method = "923F226CD9CCDFFFCDAC17AA0ED53D1F")
    private void startSession() {
        CipherSuite[] cipher_suites;
    if(isResuming)        
        {
            cipher_suites = new CipherSuite[] { session.cipherSuite };
        } 
        else
        {
            cipher_suites = parameters.getEnabledCipherSuitesMember();
        } 
        clientHello = new ClientHello(parameters.getSecureRandom(),
                session.protocol.version, session.id, cipher_suites);
        session.clientRandom = clientHello.random;
        send(clientHello);
        status = NEED_UNWRAP;
        
        
        
            
        
            
        
        
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.077 -0400", hash_original_method = "A389390FF4680222C458E1D6E9083717", hash_generated_method = "BAFE85A38A4B4CEEA52A9E3E6791D53F")
    @Override
    public void unwrap(byte[] bytes) {
        addTaint(bytes[0]);
    if(this.delegatedTaskErr != null)        
        {
            Exception e = this.delegatedTaskErr;
            this.delegatedTaskErr = null;
            this.fatalAlert(AlertProtocol.HANDSHAKE_FAILURE, "Error in delegated task", e);
        } 
        int handshakeType;
        io_stream.append(bytes);
        while
(io_stream.available() > 0)        
        {
            io_stream.mark();
            int length;
            try 
            {
                handshakeType = io_stream.read();
                length = io_stream.readUint24();
    if(io_stream.available() < length)                
                {
                    io_stream.reset();
                    return;
                } 
switch(handshakeType){
                case 0:
                io_stream.removeFromMarkedPosition();
    if(clientHello != null
                            && (clientFinished == null || serverFinished == null))                
                {
                    break;
                } 
    if(session.isValid())                
                {
                    session = (SSLSessionImpl) session.clone();
                    isResuming = true;
                    startSession();
                } 
                else
                {
                    renegotiateNewSession();
                } 
                break;
                case 2:
    if(clientHello == null || serverHello != null)                
                {
                    unexpectedMessage();
                    return;
                } 
                serverHello = new ServerHello(io_stream, length);
                ProtocolVersion servProt = ProtocolVersion.getByVersion(serverHello.server_version);
                String[] enabled = parameters.getEnabledProtocols();
    find                :
                {
for(int i = 0;i < enabled.length;i++)
                    {
    if(servProt.equals(ProtocolVersion.getByName(enabled[i])))                        
                        {
                            break find;
                        } 
                    } 
                    fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                   "Bad server hello protocol version");
                } 
    if(serverHello.compression_method != 0)                
                {
                    fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                   "Bad server hello compression method");
                } 
                CipherSuite[] enabledSuites = parameters.getEnabledCipherSuitesMember();
    find                :
                {
for(int i = 0;i < enabledSuites.length;i++)
                    {
    if(serverHello.cipher_suite.equals(enabledSuites[i]))                        
                        {
                            break find;
                        } 
                    } 
                    fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                   "Bad server hello cipher suite");
                } 
    if(isResuming)                
                {
    if(serverHello.session_id.length == 0)                    
                    {
                        isResuming = false;
                    } 
                    else
    if(!Arrays.equals(serverHello.session_id, clientHello.session_id))                    
                    {
                        isResuming = false;
                    } 
                    else
    if(!session.protocol.equals(servProt))                    
                    {
                        fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                       "Bad server hello protocol version");
                    } 
                    else
    if(!session.cipherSuite.equals(serverHello.cipher_suite))                    
                    {
                        fatalAlert(AlertProtocol.HANDSHAKE_FAILURE,
                                       "Bad server hello cipher suite");
                    } 
    if(serverHello.server_version[1] == 1)                    
                    {
                        computerReferenceVerifyDataTLS("server finished");
                    } 
                    else
                    {
                        computerReferenceVerifyDataSSLv3(SSLv3Constants.server);
                    } 
                } 
                session.protocol = servProt;
                recordProtocol.setVersion(session.protocol.version);
                session.cipherSuite = serverHello.cipher_suite;
                session.id = serverHello.session_id.clone();
                session.serverRandom = serverHello.random;
                break;
                case 11:
    if(serverHello == null || serverKeyExchange != null
                            || serverCert != null || isResuming)                
                {
                    unexpectedMessage();
                    return;
                } 
                serverCert = new CertificateMessage(io_stream, length);
                break;
                case 12:
    if(serverHello == null || serverKeyExchange != null
                            || isResuming)                
                {
                    unexpectedMessage();
                    return;
                } 
                serverKeyExchange = new ServerKeyExchange(io_stream,
                            length, session.cipherSuite.keyExchange);
                break;
                case 13:
    if(serverCert == null || certificateRequest != null
                            || session.cipherSuite.isAnonymous() || isResuming)                
                {
                    unexpectedMessage();
                    return;
                } 
                certificateRequest = new CertificateRequest(io_stream, length);
                break;
                case 14:
    if(serverHello == null || serverHelloDone != null || isResuming)                
                {
                    unexpectedMessage();
                    return;
                } 
                serverHelloDone = new ServerHelloDone(io_stream, length);
    if(this.nonBlocking)                
                {
                    delegatedTasks.add(new DelegatedTask(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.076 -0400", hash_original_method = "0DFF79E1B822BFCDEB6260105932743B", hash_generated_method = "5828D0275E43E6D76D054149775437AB")
        public void run() {
            processServerHelloDone();
            
            
        }
}, this));
                    return;
                } 
                processServerHelloDone();
                break;
                case 20:
    if(!changeCipherSpecReceived)                
                {
                    unexpectedMessage();
                    return;
                } 
                serverFinished = new Finished(io_stream, length);
                verifyFinished(serverFinished.getData());
                session.lastAccessedTime = System.currentTimeMillis();
                session.context = parameters.getClientSessionContext();
                parameters.getClientSessionContext().putSession(session);
    if(isResuming)                
                {
                    sendChangeCipherSpec();
                } 
                else
                {
                    session.lastAccessedTime = System.currentTimeMillis();
                    status = FINISHED;
                } 
                break;
                default:
                unexpectedMessage();
                return;
}
            } 
            catch (IOException e)
            {
                io_stream.reset();
                return;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.080 -0400", hash_original_method = "A121217103E96E47F6E62859875393D7", hash_generated_method = "2FF585C3D5729D57C12D07A25AF1150C")
    @Override
    public void unwrapSSLv2(byte[] bytes) {
        addTaint(bytes[0]);
        unexpectedMessage();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.081 -0400", hash_original_method = "8B073BF3F8F00875CF9B653567C3900A", hash_generated_method = "F31860A050F869286408932C4C5C5720")
    @Override
    protected void makeFinished() {
        byte[] verify_data;
    if(serverHello.server_version[1] == 1)        
        {
            verify_data = new byte[12];
            computerVerifyDataTLS("client finished", verify_data);
        } 
        else
        {
            verify_data = new byte[36];
            computerVerifyDataSSLv3(SSLv3Constants.client, verify_data);
        } 
        clientFinished = new Finished(verify_data);
        send(clientFinished);
    if(isResuming)        
        {
            session.lastAccessedTime = System.currentTimeMillis();
            status = FINISHED;
        } 
        else
        {
    if(serverHello.server_version[1] == 1)            
            {
                computerReferenceVerifyDataTLS("server finished");
            } 
            else
            {
                computerReferenceVerifyDataSSLv3(SSLv3Constants.server);
            } 
            status = NEED_UNWRAP;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.085 -0400", hash_original_method = "2DDF37E22088D1FE8BC73EB3CA83F3A0", hash_generated_method = "2337C43A9C88174D0885EE34102CF3D6")
     void processServerHelloDone() {
        PrivateKey clientKey = null;
    if(serverCert != null)        
        {
    if(session.cipherSuite.isAnonymous())            
            {
                unexpectedMessage();
                return;
            } 
            verifyServerCert();
        } 
        else
        {
    if(!session.cipherSuite.isAnonymous())            
            {
                unexpectedMessage();
                return;
            } 
        } 
    if(certificateRequest != null)        
        {
            X509Certificate[] certs = null;
            String alias = null;
            String[] certTypes = certificateRequest.getTypesAsString();
            X500Principal[] issuers = certificateRequest.certificate_authorities;
            X509KeyManager km = parameters.getKeyManager();
    if(km instanceof X509ExtendedKeyManager)            
            {
                X509ExtendedKeyManager ekm = (X509ExtendedKeyManager)km;
    if(this.socketOwner != null)                
                {
                    alias = ekm.chooseClientAlias(certTypes, issuers, this.socketOwner);
                } 
                else
                {
                    alias = ekm.chooseEngineClientAlias(certTypes, issuers, this.engineOwner);
                } 
    if(alias != null)                
                {
                    certs = ekm.getCertificateChain(alias);
                } 
            } 
            else
            {
                alias = km.chooseClientAlias(certTypes, issuers, this.socketOwner);
    if(alias != null)                
                {
                    certs = km.getCertificateChain(alias);
                } 
            } 
            session.localCertificates = certs;
            clientCert = new CertificateMessage(certs);
            clientKey = km.getPrivateKey(alias);
            send(clientCert);
        } 
    if(session.cipherSuite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA
                || session.cipherSuite.keyExchange == CipherSuite.KEY_EXCHANGE_RSA_EXPORT)        
        {
            Cipher c;
            try 
            {
                c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    if(serverKeyExchange != null)                
                {
                    c.init(Cipher.ENCRYPT_MODE, serverKeyExchange
                            .getRSAPublicKey());
                } 
                else
                {
                    c.init(Cipher.ENCRYPT_MODE, serverCert.certs[0]);
                } 
            } 
            catch (Exception e)
            {
                fatalAlert(AlertProtocol.INTERNAL_ERROR,
                        "Unexpected exception", e);
                return;
            } 
            preMasterSecret = new byte[48];
            parameters.getSecureRandom().nextBytes(preMasterSecret);
            System.arraycopy(clientHello.client_version, 0, preMasterSecret, 0, 2);
            try 
            {
                clientKeyExchange = new ClientKeyExchange(c
                        .doFinal(preMasterSecret),
                        serverHello.server_version[1] == 1);
            } 
            catch (Exception e)
            {
                fatalAlert(AlertProtocol.INTERNAL_ERROR,
                        "Unexpected exception", e);
                return;
            } 
        } 
        else
        {
            try 
            {
                KeyFactory kf = KeyFactory.getInstance("DH");
                KeyAgreement agreement = KeyAgreement.getInstance("DH");
                KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
                PublicKey serverPublic;
                DHParameterSpec spec;
    if(serverKeyExchange != null)                
                {
                    serverPublic = kf.generatePublic(new DHPublicKeySpec(
                            serverKeyExchange.par3, serverKeyExchange.par1,
                            serverKeyExchange.par2));
                    spec = new DHParameterSpec(serverKeyExchange.par1,
                            serverKeyExchange.par2);
                } 
                else
                {
                    serverPublic = serverCert.certs[0].getPublicKey();
                    spec = ((DHPublicKey) serverPublic).getParams();
                } 
                kpg.initialize(spec);
                KeyPair kp = kpg.generateKeyPair();
                Key key = kp.getPublic();
    if(clientCert != null
                        && serverCert != null
                        && (session.cipherSuite.keyExchange == CipherSuite.KEY_EXCHANGE_DHE_RSA
                                || session.cipherSuite.keyExchange == CipherSuite.KEY_EXCHANGE_DHE_DSS))                
                {
                    PublicKey client_pk = clientCert.certs[0].getPublicKey();
                    PublicKey server_pk = serverCert.certs[0].getPublicKey();
    if(client_pk instanceof DHKey
                            && server_pk instanceof DHKey)                    
                    {
    if(((DHKey) client_pk).getParams().getG().equals(
                                ((DHKey) server_pk).getParams().getG())
                                && ((DHKey) client_pk).getParams().getP()
                                    .equals(((DHKey) server_pk).getParams().getG()))                        
                        {
                            clientKeyExchange = new ClientKeyExchange();
                        } 
                    } 
                } 
                else
                {
                    clientKeyExchange = new ClientKeyExchange(
                            ((DHPublicKey) key).getY());
                } 
                key = kp.getPrivate();
                agreement.init(key);
                agreement.doPhase(serverPublic, true);
                preMasterSecret = agreement.generateSecret();
            } 
            catch (Exception e)
            {
                fatalAlert(AlertProtocol.INTERNAL_ERROR,
                        "Unexpected exception", e);
                return;
            } 
        } 
    if(clientKeyExchange != null)        
        {
            send(clientKeyExchange);
        } 
        computerMasterSecret();
    if(clientCert != null && !clientKeyExchange.isEmpty())        
        {
            String authType = clientKey.getAlgorithm();
            DigitalSignature ds = new DigitalSignature(authType);
            ds.init(clientKey);
    if("RSA".equals(authType))            
            {
                ds.setMD5(io_stream.getDigestMD5());
                ds.setSHA(io_stream.getDigestSHA());
            } 
            else
    if("DSA".equals(authType))            
            {
                ds.setSHA(io_stream.getDigestSHA());
            } 
            certificateVerify = new CertificateVerify(ds.sign());
            send(certificateVerify);
        } 
        sendChangeCipherSpec();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.086 -0400", hash_original_method = "D4DFA4A65ECB84B5CCE7F9A88CE9F713", hash_generated_method = "B104F25657ACC58E1B5DF9097A7E0310")
    private void verifyServerCert() {
        String authType = session.cipherSuite.getAuthType(serverKeyExchange != null);
    if(authType == null)        
        {
            return;
        } 
        try 
        {
            parameters.getTrustManager().checkServerTrusted(serverCert.certs, authType);
        } 
        catch (CertificateException e)
        {
            fatalAlert(AlertProtocol.BAD_CERTIFICATE, "Not trusted server certificate", e);
            return;
        } 
        session.peerCertificates = serverCert.certs;
        
        
        
            
        
        
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.087 -0400", hash_original_method = "EC675B353AC97965B98DB90ABCC2C0E4", hash_generated_method = "CBC1E69E18C206F9C2C0CDAD2D5ECA7A")
    @Override
    public void receiveChangeCipherSpec() {
    if(isResuming)        
        {
    if(serverHello == null)            
            {
                unexpectedMessage();
            } 
        } 
        else
    if(clientFinished == null)        
        {
            unexpectedMessage();
        } 
        changeCipherSpecReceived = true;
        
        
            
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.108 -0400", hash_original_method = "BCA1C752C9C2161C7353D057736B9B80", hash_generated_method = "0C8214996616DEDDA9AC254D396BA2D3")
    private SSLSessionImpl findSessionToResume() {
        String host = null;
        int port = -1;
    if(engineOwner != null)        
        {
            host = engineOwner.getPeerHost();
            port = engineOwner.getPeerPort();
        } 
        else
        {
            host = socketOwner.getInetAddress().getHostName();
            port = socketOwner.getPort();
        } 
    if(host == null || port == -1)        
        {
SSLSessionImpl var540C13E9E156B687226421B24F2DF178_624631115 =             null;
            var540C13E9E156B687226421B24F2DF178_624631115.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_624631115;
        } 
        ClientSessionContext context = parameters.getClientSessionContext();
        SSLSessionImpl session = (SSLSessionImpl) context.getSession(host, port);
    if(session != null)        
        {
            session = (SSLSessionImpl) session.clone();
        } 
SSLSessionImpl varD555E544A66E0F97DA6BCDE940E3E79C_311660083 =         session;
        varD555E544A66E0F97DA6BCDE940E3E79C_311660083.addTaint(taint);
        return varD555E544A66E0F97DA6BCDE940E3E79C_311660083;
        
        
        
        
            
            
        
            
            
        
        
            
        
        
        
                
        
            
        
        
    }

    
}

