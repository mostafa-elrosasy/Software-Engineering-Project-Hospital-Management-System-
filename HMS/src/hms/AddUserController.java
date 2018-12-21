/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

/**
 *
 * @author mosta
 */
public class AddUserController {
    public void Create_User(String username, String password){
        User U = new User(username, password);
    }

}
