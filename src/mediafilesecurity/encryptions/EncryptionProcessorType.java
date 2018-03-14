/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediafilesecurity.encryptions;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mediafilesecurity.utilities.JOPtionUtils;

/**
 *
 * @author filippo
 */
public enum EncryptionProcessorType implements Operation {

    UNKNOWN {

        @Override
        public byte[] encrypt(String key, byte[] content) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public byte[] decrypt(String key, byte[] content) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    AES {
        @Override
        public byte[] encrypt(String key, byte[] content) {
            Cipher cipher;
            byte[] encrypted = null;
            try {
                cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
                encrypted = cipher.doFinal(content);
            } catch (Exception e) {
                JOPtionUtils.showWarningMessage(e.getMessage());
            }
            return encrypted;
        }

        @Override
        public byte[] decrypt(String key, byte[] content) {
            Cipher cipher;
            byte[] decrypted = null;
            try {
                cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
                decrypted = cipher.doFinal(content);
            } catch (Exception e) {
                JOPtionUtils.showWarningMessage(e.getMessage());
                e.printStackTrace();
            }
            return decrypted;
        }
    }, DES {
        @Override
        public byte[] encrypt(String key, byte[] byteArray) {
            Cipher cipher;
            byte[] encrypted = null;
            try {
                cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "DES"), new IvParameterSpec(new byte[]{22, 33, 11, 44, 55, 99, 66, 77}));
                encrypted = cipher.doFinal(byteArray);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return encrypted;
        }

        @Override
        public byte[] decrypt(String key, byte[] content) {
            Cipher cipher;
            byte[] decrypted = null;
            try {
                cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "DES"), new IvParameterSpec(new byte[]{22, 33, 11, 44, 55, 99, 66, 77}));
                decrypted = cipher.doFinal(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return decrypted;
        }

    }, BLOWFISH {
        @Override
        public byte[] encrypt(String key, byte[] byteArray) {
            Cipher cipher;
            byte[] encrypted = null;
            try {
                cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "Blowfish"));
                encrypted = cipher.doFinal(byteArray);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return encrypted;
        }

        @Override
        public byte[] decrypt(String key, byte[] content) {
            Cipher cipher;
            byte[] encrypted = null;
            try {
                cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "Blowfish"));
                encrypted = cipher.doFinal(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return encrypted;
        }
    };

    public static EncryptionProcessorType fromString(String encryptionAlgorim) {
        EncryptionProcessorType processorType = EncryptionProcessorType.UNKNOWN;
        EncryptionProcessorType[] values = values();
        for (EncryptionProcessorType value : values) {
            if (encryptionAlgorim.equalsIgnoreCase(value.name())) {
                processorType = value;
                break;
            }
        }
        return processorType;
    }
}
