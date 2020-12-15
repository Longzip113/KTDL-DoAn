package com.longnguyen.algorithm;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.instance.RemovePercentage;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.File;
import java.io.IOException;

public class MyWeka {
    public DataSource dataSource;
    public Instances dataSet;
    public String[] model_options;
    public String[] data_options;

    public Instances trainSet;
    public Instances testSet;

    public MyWeka() {
        super();
    }

    public MyWeka(String fileName) throws Exception {
        this.dataSource = new DataSource(fileName);
        this.dataSet = dataSource.getDataSet();

        //this.dataSet = divideTrainTest(this.dataSet, 20, true);

        this.dataSet.setClassIndex(this.dataSet.numAttributes() - 1);
    }



    // Xuat du lieu
    public void saveFile(String fileName) throws IOException {
        ArffSaver outData = new ArffSaver();
        outData.setInstances(this.dataSet);
        outData.setFile(new File(fileName));
        //Ghi du lieu ra file
        outData.writeBatch();

        System.out.println("Finished");
    }

    // tao tap du lieu train & test
    public Instances divideTrainTest(Instances originalSet, double percent, boolean isTest) throws Exception {
        RemovePercentage rp = new RemovePercentage();
        rp.setPercentage(percent);
        rp.setInvertSelection(isTest);
        rp.setInputFormat(originalSet);

        return Filter.useFilter(originalSet,rp);
    }

    // Chuyển đổi dữ liệu
    public void saveFileCSV(String fileName) throws IOException {
        CSVSaver outData = new CSVSaver();
        outData.setInstances(this.dataSet);
        outData.setFile(new File(fileName));
        //Ghi du lieu ra file
        outData.writeBatch();

        System.out.println("Converted");
    }

    // loại bỏ các trường dữ liệu thừa
    public Instances removeData(Instances originalData) throws Exception {
        Remove rm = new Remove();
        rm.setOptions(data_options);
        rm.setInputFormat(originalData);
        return Filter.useFilter(originalData, rm);
    }

    public void saveModel(String fileName, Object model) throws Exception {
        weka.core.SerializationHelper.write(fileName, model);
    }

    public Object loadModel(String fileName) throws Exception {
        return weka.core.SerializationHelper.read(fileName);
    }

    public MyWeka(String fileName, String model_option, String data_option) throws Exception {
        this.dataSource = new DataSource(fileName);
        this.dataSet = dataSource.getDataSet();
        this.model_options = weka.core.Utils.splitOptions(model_option);
    }

    @Override
    public String toString() {
        return dataSet.toSummaryString();
    }
}
