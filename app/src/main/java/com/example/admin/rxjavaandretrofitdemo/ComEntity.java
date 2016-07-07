package com.example.admin.rxjavaandretrofitdemo;

/**
 * Created by admin on 2016/6/17.
 */

public class ComEntity {


    /**
     * ResultMsg : _ok
     * ID : 4935
     * Cityid : 1
     * Name : 郑荷国
     * Password : 0,1,2
     * CityName : 厦门
     * Pos : 118.143447,24.482243
     * TipsMsg : 2016年4月4日欢迎您加入好慷！
     * ShopId : 1
     * ShopName : 莲前1站
     * Addr : 厦门思明区厦门市思明区dsafgadsfdsa
     */

    private String ResultMsg;
    private int ID;
    private int Cityid;
    private String Name;
    private String Password;
    private String CityName;
    private String Pos;
    private String TipsMsg;
    private int ShopId;
    private String ShopName;
    private String Addr;

    public String getResultMsg() {
        return ResultMsg;
    }

    public void setResultMsg(String ResultMsg) {
        this.ResultMsg = ResultMsg;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCityid() {
        return Cityid;
    }

    public void setCityid(int Cityid) {
        this.Cityid = Cityid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public String getPos() {
        return Pos;
    }

    public void setPos(String Pos) {
        this.Pos = Pos;
    }

    public String getTipsMsg() {
        return TipsMsg;
    }

    public void setTipsMsg(String TipsMsg) {
        this.TipsMsg = TipsMsg;
    }

    public int getShopId() {
        return ShopId;
    }

    public void setShopId(int ShopId) {
        this.ShopId = ShopId;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String ShopName) {
        this.ShopName = ShopName;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String Addr) {
        this.Addr = Addr;
    }
}
