/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.ayudantes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class Respaldo {
        
    public static void respaldar() throws IOException{
        try{
        Process proceso=Runtime.getRuntime().exec("mysqldump -u root -p colegio");
        new HiloLector(proceso.getErrorStream()).start();
        InputStream is=proceso.getInputStream();
        FileOutputStream fos=new FileOutputStream("backup_colegio.sql");
        byte[] buffer=new byte[1000];
        int leido =is.read(buffer);
        while(leido>0){
            fos.write(buffer,0,leido);
            leido =is.read(buffer);
        }
        
        fos.close();
        JOptionPane.showMessageDialog(null,"Respaldo creado");
        }catch(IOException exe){
            System.out.println(exe.getMessage());
        }
    }
    
    public static void restaurar() throws IOException{
        Process proceso=Runtime.getRuntime().exec("mysql -u root -p colegio");
        OutputStream os=proceso.getOutputStream();
        FileInputStream fis=new FileInputStream("backup_colegio.sql");
        byte[] buffer=new byte[5000];
        int leido =fis.read(buffer);
        while(leido>0){
            os.write(buffer,0,leido);
            leido =fis.read(buffer);
        }
        os.flush();
        os.close();
        fis.close();
    }
    
    
    
}
