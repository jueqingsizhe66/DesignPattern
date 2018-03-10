package com.rupengCompo;

/*
最根本原则， 把叶子结点和容器当作统一节点，一致性看待！！！ human create equal!（刚出生）
humanity create nothing!(渐渐发展）
 */
public class Test2 {
    public static void main(String[] args) {
        OrgUnit ouRPGroup = new OrgUnit("如鹏集团");

        OrgUnit ouRPUSA = new OrgUnit("如鹏美国");
        OrgUnit ouRPChina = new OrgUnit("如鹏中国");
        ouRPGroup.addChild(ouRPUSA);
        ouRPGroup.addChild(ouRPChina);

        OrgUnit ouRPBJ = new OrgUnit("如鹏北京");
        ouRPChina.addChild(ouRPBJ);

        Staff sWFF = new Staff("卫飞飞");
        sWFF.setLevel("P5");
        sWFF.setJobName("总裁");
        ouRPBJ.addChild(sWFF);


        OrgUnit ouRPBJDev = new OrgUnit("北京如鹏研发中心");
        ouRPBJ.addChild(ouRPBJDev);

        OrgUnit ouRPBJTeach = new OrgUnit("北京如鹏教学中心");
        ouRPBJ.addChild(ouRPBJTeach);

        OrgUnit ouRPBJDevHT = new OrgUnit("如鹏北研后台开发部");
        OrgUnit ouRPBJDevData = new OrgUnit("如鹏北研数据分析部");
        ouRPBJDev.addChild(ouRPBJDevHT);
        ouRPBJDev.addChild(ouRPBJDevData);

        Staff sGosling = new Staff("高斯林");
        sGosling.setLevel("P6");
        sGosling.setJobName("Java开发工程师");

        Staff sBillGates = new Staff("比尔盖茨");
        sBillGates.setLevel("P7");
        sBillGates.setJobName("VB开发工程师");

        ouRPBJDevHT.addChild(sGosling);
        ouRPBJDevHT.addChild(sBillGates);

        OrgUnit ouRPGZ = new OrgUnit("如鹏广州");
        ouRPChina.addChild(ouRPGZ);

        Staff sZXL = new Staff("张小龙");
        sZXL.setJobName("产品经理");
        sZXL.setLevel("P9");
        ouRPGZ.addChild(sZXL);

        Staff sMHT = new Staff("马化腾");
        sMHT.setJobName("C++工程师");
        sZXL.setLevel("P5");
        ouRPGZ.addChild(sMHT);

        print(ouRPGroup,0);

    }
    //编写打印遍历节点信息的方法，采用递归：
    static void print(OrgItem orgItem,int depth)
    {
        //如果节点是员工节点
        if(orgItem instanceof Staff)
        {
            Staff staff = (Staff)orgItem;
            System.out.println(repeatTab(depth)+"员工："+orgItem.getName()+",级别:"+staff.getLevel()+"，岗位:"+staff.getJobName());
        }
        //如果是组织单元节点
        else if(orgItem instanceof OrgUnit)
        {
            OrgUnit ou = (OrgUnit)orgItem;
            //在前面输出depth个Tab进行缩进
            System.out.println(repeatTab(depth)+"组织单元："+orgItem.getName());
            //对于组织单元节点，输出子节点
            for(OrgItem item : ou.getChildren())
            {
                print(item,depth+1);//缩进深入一层
            }
        }
    }

    /**
     * 返回由count个Tab键组成的字符串
     * @param count
     * @return
     */
    static String repeatTab(int count)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count;i++)
        {
            sb.append("\t");
        }
        return sb.toString();
    }

}
