package com.longnguyen.service;

import com.longnguyen.algorithm.MyWeka;
import com.longnguyen.algorithm.MydecisionTree;
import weka.classifiers.trees.J48;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class RunService {

    public void saveFileArff(String numPerson, String domain, String restingPlace, String vehicle, String day, String tyleTravel) throws FileNotFoundException {
        PrintWriter pwTrain = new PrintWriter(new File("/Users/ftwbeatn.t.long/Desktop/DoAn - KTDL(Ver1.2)/KTDL/Data/train.arff"));
        pwTrain.println("@relation datatestset");
        pwTrain.println("@attribute Domain {Northern,South,Central}");
        pwTrain.println("@attribute NumberOfDays real");
        pwTrain.println("@attribute NumberOfPeople {groups2pTo4p,groupsofover20P,groups5pTo8p,alone}");
        pwTrain.println("@attribute vehicle {motorcycle,coach,planes}");
        pwTrain.println("@attribute restingPlace {Homestay,home,hotel,No}");
        pwTrain.println("@attribute tyleTravel {Nui,Bien,DanhLam}");
        pwTrain.println("@attribute locationGo  {VinhHaLong,MocChau,Sapa,DaoNgocPhuQuoc,NhaTrang,ThacDaHanDongNai,DaoThanhAnCanTho,PhuYen,HoiAn,DaNang,Hue,PhongNhaKeBang,NuiCamAnGiang,BaiChay,SamSon,Nuilangbiang,ChoNoiCaiRang,ThacBanGioc}");
        pwTrain.println("@data");
        pwTrain.println(domain+"\t"+day+"\t"+numPerson+"\t"+vehicle+"\t"+restingPlace+"\t"+tyleTravel+"\t?");
        pwTrain.flush();
        pwTrain.close();
    }

    public String runAlgorithm() throws Exception {
        //		HomeController home = new HomeController("/Users/ftwbeatn.t.long/Desktop/DoAn - KTDL/Data/datatestset.arff", null, null);
//
//		home.trainSet = home.divideTrainTest(home.dataSet, 20, false);
//
//		home.testSet = home.divideTrainTest(home.dataSet, 20, true);
//
//		System.out.println(home);
//		System.out.println(home.trainSet.toSummaryString());
//		System.out.println(home.testSet.toSummaryString());

//		home.saveFile("/Users/ftwbeatn.t.long/Desktop/dataARFF.arff");

//		home.saveFileCSV("/Users/ftwbeatn.t.long/Desktop/dataCSV.csv");

//		MydecisionTree model = new MydecisionTree("/Users/ftwbeatn.t.long/Desktop/DoAn - KTDL(Ver1.2)/KTDL/Data/datatestset.arff","-C 0.25 -M 2",null);
        MydecisionTree model = new MydecisionTree();

//		model.buildDecisionTree();
//		model.evaluateDecisiontree();
//		System.out.println(model);

//		model.saveModel("/Users/ftwbeatn.t.long/Desktop/DoAn - KTDL(Ver1.2)/KTDL/Data/decisionTree.model", model.tree);
        MyWeka home = new MyWeka("/Users/ftwbeatn.t.long/Desktop/DoAn - KTDL(Ver1.2)/KTDL/Data/train.arff");

        model.tree =  (J48)model.loadModel("/Users/ftwbeatn.t.long/Desktop/DoAn - KTDL(Ver1.2)/KTDL/Data/decisionTree2.model");

        return model.predictClassLable(home.dataSet);
    }

    public String converterData(String data, String numPerson, String domain, String restingPlace, String vehicle, String day, String tyleTravel){
        String dataConver = "";
        String NumberOfPeople = "";
        switch(numPerson) {
            case "alone":
                NumberOfPeople = "Một mình";
                break;
            case "groups2pTo4p":
                NumberOfPeople = "Nhóm 2-4 người";
                break;
            case "groups5pTo8p":
                NumberOfPeople = "Nhóm 5-8 người";
                break;
            case "groupsofover20P":
                NumberOfPeople = "Tren 20 người";
                break;
            default:
        }
        String domainStr = "";
        switch(domain) {
            case "Northern":
                domainStr = "Miền Bắc";
                break;
            case "Central":
                domainStr = "Miền Trung";
                break;
            case "South":
                domainStr = "Miền Nam";
                break;
            default:
        }

        String restingPlaceStr = "";
        switch(restingPlace) {
            case "hotel":
                restingPlaceStr = "Khách sạn";
                break;
            case "Homestay":
                restingPlaceStr = "Homestay";
                break;
            case "home":
                restingPlaceStr = "Nhà riêng";
                break;
            default:
                restingPlaceStr = "Không ở";
        }

        String vehicleStr = "";
        switch(vehicle) {
            case "motorcycle":
                vehicleStr = "Xe máy";
                break;
            case "coach":
                vehicleStr = "Xe khách";
                break;
            default:
                vehicleStr = "Máy bay";
        }

        if(data.equals("VinhHaLong")) {
            dataConver = "Vịnh hạ long.";
        } else if (data.equals("MocChau")) {
            dataConver = "Mộc châu.";
        } else if (data.equals("Sapa")) {
            dataConver = "Sapa.";
        } else if (data.equals("SamSon")) {
            dataConver = "Biển Sầm Sơn - Thanh Hoá.";
        } else if (data.equals("BaiChay")) {
            dataConver = "Bãi cháy - Quảng Ninh.";
        } else if (data.equals("NuiCamAnGiang")) {
            dataConver = "Nuí cấm An Giang.";
        } else if (data.equals("DaoNgocPhuQuoc")) {
            dataConver = "Đảo Ngọc Phú Quốc.";
        } else if (data.equals("NhaTrang")) {
            dataConver = "Nha Trang.";
        } else if (data.equals("ThacDaHanDongNai")) {
            dataConver = "Thác Đá Hàn Đồng Nai.";
        } else if (data.equals("DaoThanhAnCanTho")) {
            dataConver = "Đảo Thanh An Cần Thơ.";
        } else if (data.equals("PhuYen")) {
            dataConver = "Phú yên.";
        } else if (data.equals("HoiAn")) {
            dataConver = "Hội an.";
        } else if (data.equals("DaNang")) {
            dataConver = "Đà Nẵng.";
        } else if (data.equals("Hue")) {
            dataConver = "Huế.";
        } else if (data.equals("PhongNhaKeBang")) {
            dataConver = "Phong Nha Kẻ Bàng.";
        } else if (data.equals("Nuilangbiang")) {
            dataConver = "Núi langbiang - Đà lạt.";
        } else if (data.equals("ChoNoiCaiRang")) {
            dataConver = "Chợ nổi cái răng - Cần Thơ.";
        } else if (data.equals("ThacBanGioc")) {
            dataConver = "Thác bản Giốc - Cao bằng.";
        }

        String tyleTravelStr = "";
        switch(tyleTravel) {
            case "Bien":
                tyleTravelStr = "Đi biển";
                break;
            case "Nui":
                tyleTravelStr = "Đi núi";
                break;
            default:
                tyleTravelStr = "Danh lam thắng cảnh";
        }

        String result = "Với những thông tin bạn đã cung cấp cho chúng tôi: <br> Số người tham gia:"
                + NumberOfPeople + "<br>Địa điểm ở miền: " + domainStr + "<br>Nơi nghỉ ngơi: " + restingPlaceStr
                + "<br>Phương tiện di chuyển: " + vehicleStr + "<br>Số ngày đi du lịch: " + day + "<br>Loại hình du lịch: " + tyleTravelStr
                + "<br>Với những lựa chọn như vậy chúng tôi gợi ý cho bạn đi: <p style=\"color: red\">" + dataConver
                + "</p><br>==> (CHỈ MANG TÍNH CHẤT THAM KHẢO :^:)";
        return result;
    }


}
