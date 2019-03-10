package com.imefuture.exportBean;

import java.util.Date;

public class TTmoasCoNorecordInfo {
//    sheet.addCell(new jxl.write.Label(1, i, list.get(i - 1).getEntname()));
//                sheet.addCell(new jxl.write.Label(2, i, list.get(i - 1).getEntstatus()));
//                sheet.addCell(new jxl.write.Label(3, i, list.get(i - 1).getUserName()));
//                sheet.addCell(new jxl.write.Label(4, i, list.get(i - 1).getAppCertificateNum()));
    private String entstatus;
    private String entname;
    private String userName;
    private String appCertificateNum;
    private Date appDate;

    public String getEntstatus() {
        return entstatus;
    }

    public void setEntstatus(String entstatus) {
        this.entstatus = entstatus;
    }

    public String getEntname() {
        return entname;
    }

    public void setEntname(String entname) {
        this.entname = entname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAppCertificateNum() {
        return appCertificateNum;
    }

    public void setAppCertificateNum(String appCertificateNum) {
        this.appCertificateNum = appCertificateNum;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }
}
