/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Manager {
    int ID;
    String Name,Gender;
    int   ChiSoCu;
    String Ngay, MaKH, MaHoaDon;
    public Manager(){
        
    }
    public Manager(int ID, String Name,String Gender, String MaKH, String MaHoaDon, String Ngay){
        this.ID= ID;
        this.Name=Name;
        this.Gender=Gender;
        this.MaKH=MaKH;
        this.MaHoaDon=MaHoaDon;
        this.Ngay=Ngay;
    }
    public Manager(String Name,String Gender, String MaKH, String MaHoaDon, String Ngay){
        this.Name=Name;
        this.Gender=Gender;
        this.MaKH=MaKH;
        this.MaHoaDon=MaHoaDon;
        this.Ngay=Ngay;
    }
    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID=ID;
    }
    
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }
      public String getGender(){
        return Gender;
      }
    public void setGender(String Gender){
        this.Gender=Gender;
    } 
    public String getMaKH(){
        return MaKH;
        }
    public void setMaKH(String MaKH){
        this.MaKH=MaKH;
    }
    public String getMaHoaDon(){
        return MaHoaDon;
    }
    public void setMaHoaDon(String MaHoaDon){
        this.MaHoaDon=MaHoaDon;
    }
    public String getNgay(){
        return Ngay;
      }
    public void setNgay(String Ngay){
        this.Ngay=Ngay;
    } 

    //@Override
    //public String toString() {
        //return "Manager{" + "Name=" + Name + ", Gender=" + Gender + ", MaKH=" + MaKH + ", MaHoaDon=" + MaHoaDon + ", ChiSoCu=" + ChiSoCu + ", Ngay=" + Ngay + '}';
    //}

     

    

    

 

 
    
}
