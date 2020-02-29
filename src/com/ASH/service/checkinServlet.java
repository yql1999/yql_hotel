package com.ASH.service;

import com.ASH.dao.checkInDao;
import com.ASH.entity.CheckIn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class checkinServlet {

    public checkinServlet() {
        super();
    }

    //获取当天的每小时的入住0、退房1情况
    public int[][] checkinEachHour() {
        //获取当时时间
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = dateTime.format(formatter);
        //System.out.println(time);

        ArrayList<CheckIn> checkIns = new ArrayList<>();
        checkInDao checkInDao = new checkInDao();
        checkIns = checkInDao.DailyCheckIn(time.substring(0, 10));
        int[][] num = new int[24][2];
        //num[][0]入住 num[][1]退房
        for (int i = 0; i < 24; ++i) {
            for (int j = 0; j < 2; ++j) {
                num[i][j] = 0;
            }
        }
        //int in=0;int out=0;
        for (int i = 0; i < checkIns.size(); ++i) {
            if (checkIns.get(i).getIsCheckOut() == 0) {    //入住
                switch (checkIns.get(i).getTime().substring(0, 2)) {
                    case "00":
                        num[0][0]++;
                        break;
                    case "01":
                        num[1][0]++;
                        break;
                    case "02":
                        num[2][0]++;
                        break;
                    case "03":
                        num[3][0]++;
                        break;
                    case "04":
                        num[4][0]++;
                        break;
                    case "05":
                        num[5][0]++;
                        break;
                    case "06":
                        num[6][0]++;
                        break;
                    case "07":
                        num[7][0]++;
                        break;
                    case "08":
                        num[8][0]++;
                        break;
                    case "09":
                        num[9][0]++;
                        break;
                    case "10":
                        num[10][0]++;
                        break;
                    case "11":
                        num[11][0]++;
                        break;
                    case "12":
                        num[12][0]++;
                        break;
                    case "13":
                        num[13][0]++;
                        break;
                    case "14":
                        num[14][0]++;
                        break;
                    case "15":
                        num[15][0]++;
                        break;
                    case "16":
                        num[16][0]++;
                        break;
                    case "17":
                        num[17][0]++;
                        break;
                    case "18":
                        num[18][0]++;
                        break;
                    case "19":
                        num[19][0]++;
                        break;
                    case "20":
                        num[20][0]++;
                        break;
                    case "21":
                        num[21][0]++;
                        break;
                    case "22":
                        num[22][0]++;
                        break;
                    case "23":
                        num[23][0]++;
                        break;
                }
            } else {
                switch (checkIns.get(i).getTime().substring(0, 2)) {
                    case "00":
                        num[0][1]++;
                        break;
                    case "01":
                        num[1][1]++;
                        break;
                    case "02":
                        num[2][1]++;
                        break;
                    case "03":
                        num[3][1]++;
                        break;
                    case "04":
                        num[4][1]++;
                        break;
                    case "05":
                        num[5][1]++;
                        break;
                    case "06":
                        num[6][1]++;
                        break;
                    case "07":
                        num[7][1]++;
                        break;
                    case "08":
                        num[8][1]++;
                        break;
                    case "09":
                        num[9][1]++;
                        break;
                    case "10":
                        num[10][1]++;
                        break;
                    case "11":
                        num[11][1]++;
                        break;
                    case "12":
                        num[12][1]++;
                        break;
                    case "13":
                        num[13][1]++;
                        break;
                    case "14":
                        num[14][1]++;
                        break;
                    case "15":
                        num[15][1]++;
                        break;
                    case "16":
                        num[16][1]++;
                        break;
                    case "17":
                        num[17][1]++;
                        break;
                    case "18":
                        num[18][1]++;
                        break;
                    case "19":
                        num[19][1]++;
                        break;
                    case "20":
                        num[20][1]++;
                        break;
                    case "21":
                        num[21][1]++;
                        break;
                    case "22":
                        num[22][1]++;
                        break;
                    case "23":
                        num[23][1]++;
                        break;
                }
            }
        }
        return num;
    }

    //获取当年的每个月的人流数
    public int[][] CheckInEachMonth(){
        //获取当前时间
        LocalDateTime dateTime=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time=dateTime.format(formatter);

        checkInDao checkInDao = new checkInDao();
        String year=time.substring(0,4);//本年
        ArrayList<CheckIn> checkIns = new ArrayList<>();
        String month;//月份

        int[][]num=new int[12][2];//num[][0]入住 num[][1]退房
        for(int i=0;i<12;++i){
            for(int j=0;j<2;++j){
                num[i][j]=0;
            }
        }

        for (int i=0;i<Integer.parseInt(time.substring(5,7));++i) {
            month=String.valueOf(i+1);
            if (month.length()==1)
                month="0"+month;
            checkIns = checkInDao.MonthlyCheckIn(year, month);
            System.out.println(checkIns.size());
            for(int j=0;j<checkIns.size();++j){
                if(checkIns.get(j).getIsCheckOut()==0){
                    num[i][0]++;
                }
                else
                    num[i][1]++;
            }
        }
        return num;
    }


}
