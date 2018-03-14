/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediafilesecurity.encryptions;

/**
 *
 * @author filippo
 */
public interface Operation {
    
    byte[] encrypt(String key, byte[] content);
    
    byte[] decrypt(String key, byte[] content);
}
