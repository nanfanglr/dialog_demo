package com.rui.dialog_demo.dialogfragment.fliterfragment_sidebar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rui on 2018/9/12
 */
public class TestData {


    public static List<ParentModel> getTestData() {
        ArrayList<ParentModel> data = new ArrayList<>();

        ArrayList<ChildModel> childModels = new ArrayList<>();
        ChildModel childModel = new ChildModel(1, "比逆");
        childModels.add(childModel);
        childModel = new ChildModel(1, "米蜜儿");
        childModels.add(childModel);
        childModel = new ChildModel(1, "佩寇");
        childModels.add(childModel);
        childModel = new ChildModel(1, "J21");
        childModels.add(childModel);
        childModel = new ChildModel(1, "哈乐莱");
        childModels.add(childModel);
        childModel = new ChildModel(1, "芒斯特");
        childModels.add(childModel);
        childModel = new ChildModel(1, "弗里睿路");
        childModels.add(childModel);
        childModel = new ChildModel(1, "U1潮品");
        childModels.add(childModel);
        childModel = new ChildModel(1, "野奈");
        childModels.add(childModel);
        childModel = new ChildModel(1, "潮流前线");
        childModels.add(childModel);
        ParentModel parentModel = new ParentModel(1, "品牌", childModels);
        data.add(parentModel);


        ArrayList<ChildModel> childModels5 = new ArrayList<>();
        childModel = new ChildModel(1, "米蜜儿1");
        childModels5.add(childModel);
        childModel = new ChildModel(1, "佩寇1");
        childModels5.add(childModel);
        childModel = new ChildModel(1, "J211");
        childModels5.add(childModel);
        childModel = new ChildModel(1, "哈乐莱1");
        childModels5.add(childModel);
        childModel = new ChildModel(1, "芒斯特1");
        childModels5.add(childModel);
        childModel = new ChildModel(1, "弗里睿路1");
        childModels5.add(childModel);
        childModel = new ChildModel(1, "U1潮品1");
        childModels5.add(childModel);
        childModel = new ChildModel(1, "野奈1");
        childModels5.add(childModel);
        childModel = new ChildModel(1, "潮流前线1");
        childModels5.add(childModel);
        ParentModel parentModel5 = new ParentModel(1, "品牌xx", childModels5);
        data.add(parentModel5);

        ArrayList<ChildModel> childModels1 = new ArrayList<>();

        childModel = new ChildModel(1, "春季");
        childModels1.add(childModel);
        childModel = new ChildModel(1, "夏季");
        childModels1.add(childModel);
        childModel = new ChildModel(1, "秋季");
        childModels1.add(childModel);
        childModel = new ChildModel(1, "冬季");
        childModels1.add(childModel);
        ParentModel parentModel1 = new ParentModel(1, "季节", childModels1);
        data.add(parentModel1);

        ArrayList<ChildModel> childModels2 = new ArrayList<>();

        childModel = new ChildModel(1, "裤子");
        childModels2.add(childModel);
        childModel = new ChildModel(1, "牛仔裤");
        childModels2.add(childModel);
        childModel = new ChildModel(1, "T恤");
        childModels2.add(childModel);
        childModel = new ChildModel(1, "衬衣");
        childModels2.add(childModel);
        childModel = new ChildModel(1, "针织衫");
        childModels2.add(childModel);
        childModel = new ChildModel(1, "风衣");
        childModels2.add(childModel);
        childModel = new ChildModel(1, "毛衣");
        childModels2.add(childModel);
        ParentModel parentModel2 = new ParentModel(1, "男装", childModels2);
        data.add(parentModel2);

        ArrayList<ChildModel> childModels3 = new ArrayList<>();

        childModel = new ChildModel(1, "裙子");
        childModels3.add(childModel);
        childModel = new ChildModel(1, "牛仔裤");
        childModels3.add(childModel);
        childModel = new ChildModel(1, "T恤");
        childModels3.add(childModel);
        childModel = new ChildModel(1, "橡筋裤");
        childModels3.add(childModel);
        childModel = new ChildModel(1, "皮衣");
        childModels3.add(childModel);
        childModel = new ChildModel(1, "风衣");
        childModels3.add(childModel);
        childModel = new ChildModel(1, "毛衣");
        childModels3.add(childModel);
        ParentModel parentModel3 = new ParentModel(1, "女装", childModels3);
        data.add(parentModel3);

        ArrayList<ChildModel> childModels4 = new ArrayList<>();

        childModel = new ChildModel(1, "饰品");
        childModels4.add(childModel);
        childModel = new ChildModel(1, "其他");
        childModels4.add(childModel);
        ParentModel parentModel4 = new ParentModel(1, "其他", childModels4);
        data.add(parentModel4);

        return data;
    }
}
