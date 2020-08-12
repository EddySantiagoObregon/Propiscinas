/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidad;

/**
 *
 * @author PAULA
 */

//Esta clase la usamos para que el comando cmd ejecute funciones en windows.
public class FuncWindows {
    public static void fnOpenFileFromCMD(String pPath){
        try{
            String[] cmd = new String [5];
            cmd[0]="cmd";
            cmd[1]="/C";
            cmd[2]="start";
            cmd[3]="\"\"";
            cmd[4]="\""+pPath+"\"";
            Runtime rt = Runtime.getRuntime(); 
            rt.exec(cmd);
        }catch(Exception ex){
            
        }
    }
}
