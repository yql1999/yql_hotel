package com.ASH.service;

import com.ASH.dao.checkInDao;
import com.ASH.entity.CheckIn;
import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.enums.ImageFormat;
import com.arcsoft.face.toolkit.ImageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;

/*
返回人脸信息
 */
@WebServlet("/faceSel.do")
public class faceServlet extends HttpServlet {
    public faceServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String appId = "C5NVXpX7DuGy7AY85kEyzwafTR679m8g4tLeuCUDBZuG";
        String sdkKey = "F3Dx79kGs9cTkMgpKGj4dAepqF64PtKFrFdgE2ukMXYM";

        FaceEngine faceEngine = new FaceEngine("D:\\work\\extra\\ArcSoft\\arcsoft_rar\\libs\\WIN64");
        //激活引擎
        int activeCode = faceEngine.activeOnline(appId, sdkKey);

        if (activeCode != ErrorInfo.MOK.getValue() && activeCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
            System.out.println("引擎激活失败");
        }

        //引擎配置
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_0_ONLY);

        //功能配置
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportAge(true);
        functionConfiguration.setSupportFace3dAngle(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        functionConfiguration.setSupportGender(true);
        functionConfiguration.setSupportLiveness(true);
        functionConfiguration.setSupportIRLiveness(true);
        engineConfiguration.setFunctionConfiguration(functionConfiguration);


        //初始化引擎
        int initCode = faceEngine.init(engineConfiguration);

        if (initCode != ErrorInfo.MOK.getValue()) {
            System.out.println("初始化引擎失败");
        }

        checkInDao checkInDao=new checkInDao();

        //接收存储文件
        PrintWriter out=response.getWriter();
        File path=new File("F://photo_save");
        if(!path.exists())
            path.mkdir();
        Part part=request.getPart("StuPhoto");
        //String filename=part.getSubmittedFileName();Tomcat8
        String cd = part.getHeader("Content-Disposition");
        //截取不同类型的文件需要自行判断
        String filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);

        filename = filename.substring(filename.lastIndexOf('.'));
        filename=Math.random()+filename;//学号.后缀

        String filePath = path.getPath() + File.separator + filename;
        part.write(filePath);

        //读取文件，提取特征值
        //人脸检测
        ImageInfo imageInfo = getRGBData(new File(filePath));
        List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
        int detectCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList);
        if(detectCode==0) {
            //System.out.println(faceInfoList);

            //特征提取
            FaceFeature faceFeature = new FaceFeature();
            byte[] Face = new byte[1032];

            //返回是否检测成功0
            int extractCode = faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), ImageFormat.CP_PAF_BGR24, faceInfoList.get(0), faceFeature);
            //System.out.println("特征值大小：" + faceFeature.getFeatureData().length);

            //特征提取
            Face = faceFeature.getFeatureData();

            if (extractCode == 0) {
                CheckIn checkIn=checkInDao.findByFace(Face);
                if (checkIn!=null) {
                    request.getSession().setAttribute("checkIn",checkIn);
                    String mess = "找到该人脸信息！";
                    request.getSession().setAttribute("msg", mess);
                    response.setCharacterEncoding("utf-8");
                    response.sendRedirect("pages/forms/face_result.jsp");
                } else {
                    request.getSession().setAttribute("msg", "位找到该人脸信息！");
                }
            } else {
                request.getSession().setAttribute("msg", "人脸识别失败！");
            }
        }
        else{
            request.getSession().setAttribute("msg","未识别到人脸！");
        }
    }

}
