package com.rupeng;

import java.util.LinkedList;
import java.util.List;

public class OrgUnit extends OrgItem{
    private List<OrgItem> children = new LinkedList<>();

    public OrgUnit(String name) {
        this.setName(name);
    }

    /**
     * 增加子节点
     * @param child
     */
    public void addChild(OrgItem child) {
        children.add(child);
    }

    /**
     * 删除子节点
     * @param child
     */
    public void removeChild(OrgItem child) {
        children.remove(child);
    }

    /**
     * 获取所有子节点
     * @return
     */
    public OrgItem[] getChildren() {
        return children.toArray(new OrgItem[children.size()]);
    }

}
