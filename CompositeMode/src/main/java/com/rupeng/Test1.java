package com.rupeng;

public class Test1 {

	/*
	组合模式  天然树状结构
	 */
    /*
树状结构中有容器节点（有子元素），有叶子节点（没有子元素）。
	组合模式为处理树形结构提供了完美的解决方案，描述了如何将容器和叶子进行递归组合，使得用户在使用时可以一致性地对待容器和叶子。
	通过递归的方式处理所有子节点和后代节点。容器节点和叶子结点有公共父类或者公共接口，这样就可以*****一致****的对待容器节点和叶子结点。
	下面我们针对公司组织结构进行建模：Staff是员工，是叶子节点；OrgUnit是组织单元，是容器节点；他们的公共父类是OrgItem。

    1. 一致性对待(公共接口，公共父类)
    组合模式内置递归接口
     */
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

		print(ouRPGroup, 0);
	}

	/**
	 * 返回由count个Tab键组成的字符串
	 *
	 * @param count
	 * @return
	 */
	static String repeatTab(int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}

	//      编写打印遍历节点信息的方法，采用递归：
	static void print(OrgItem orgItem, int depth) {
		//如果节点是员工节点
		if (orgItem instanceof Staff) {
			Staff staff = (Staff) orgItem;
			System.out.println(repeatTab(depth) + "员工：" + orgItem.getName() + ",级别:" + staff.getLevel() + "，岗位:" + staff.getJobName());
		}
		//如果是组织单元节点
		else if (orgItem instanceof OrgUnit) {
			OrgUnit ou = (OrgUnit) orgItem;
			//在前面输出depth个Tab进行缩进
			System.out.println(repeatTab(depth) + "组织单元：" + orgItem.getName());
			//对于组织单元节点，输出子节点
			for (OrgItem item : ou.getChildren()) {
				print(item, depth + 1);//缩进深入一层
			}
		}
	}


}
