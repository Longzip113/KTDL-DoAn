package com.longnguyen.algorithm;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Debug;
import weka.core.Instances;

public class MydecisionTree extends MyWeka{
    public J48 tree;

    public MydecisionTree() {
        super();
    }

    public MydecisionTree(String fileName, String model_option, String data_option) throws Exception {
        super(fileName, model_option, data_option);
        // TODO Auto-generated constructor stub
    }

    // xay dung decision tree
    public void buildDecisionTree() throws Exception {
        // tap du lieu train & set
        this.trainSet = divideTrainTest(this.dataSet, 20, false);
        this.testSet = divideTrainTest(this.dataSet, 20, true);

        this.trainSet.setClassIndex(this.trainSet.numAttributes() - 1);
        this.testSet.setClassIndex(this.testSet.numAttributes() - 1);
        //thiet lap thong so cho mo hinh cay quyet dinh
        tree = new J48();
        tree.setOptions(this.model_options);
        //Huan luyen mo hinh voi tap du lieu train.
        tree.buildClassifier(this.trainSet);
    }

    // danh gia mo dinh
    public void evaluateDecisiontree() throws Exception {

        Debug.Random rd = new Debug.Random(1);
        int folds = 10;

        Evaluation eval = new Evaluation(this.trainSet);

        eval.crossValidateModel(tree, this.testSet, folds, rd);

        System.out.println(eval.toSummaryString("\nKết quả đánh giá mô hình 10-folds cross Validation: \n-----\n", false));
    }

    public String predictClassLable(Instances input) throws Exception {
        String kq = "";
        for (int i = 0; i < input.numInstances(); i++) {
            double predict = tree.classifyInstance(input.instance(i));
            double actual = input.instance(i).classValue();

            System.out.println("Instance " + i + ": predict = " + input.classAttribute().value((int)predict) +
                    "; actual = " + input.classAttribute().value((int)actual));

            kq = input.classAttribute().value((int)predict);
            //input.instance(i).setClassValue(predict);
        }
        return kq;
    }

    @Override
    public String toString() {
        return tree.toSummaryString();
    }
}
