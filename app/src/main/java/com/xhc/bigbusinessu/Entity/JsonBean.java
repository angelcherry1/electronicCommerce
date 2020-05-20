package com.xhc.bigbusinessu.Entity;


import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

/**
 * TODO<json数据源>
 *
 * @author: 小嵩
 * @date: 2017/3/16 15:36
 */

public class JsonBean implements IPickerViewData {


    /**
     * id : 1
     * name : 北京市
     * parent_id : 0
     * sub : [{"id":"2","name":"市辖区","parent_id":"1","sub":[{"id":"3","name":"东城区","parent_id":"2"},{"id":"14","name":"西城区","parent_id":"2"},{"id":"22","name":"崇文区","parent_id":"2"},{"id":"30","name":"宣武区","parent_id":"2"},{"id":"39","name":"朝阳区","parent_id":"2"},{"id":"83","name":"丰台区","parent_id":"2"},{"id":"105","name":"石景山区","parent_id":"2"},{"id":"115","name":"海淀区","parent_id":"2"},{"id":"145","name":"门头沟区","parent_id":"2"},{"id":"159","name":"房山区","parent_id":"2"},{"id":"188","name":"通州区","parent_id":"2"},{"id":"204","name":"顺义区","parent_id":"2"},{"id":"227","name":"昌平区","parent_id":"2"},{"id":"245","name":"大兴区","parent_id":"2"},{"id":"264","name":"怀柔区","parent_id":"2"},{"id":"281","name":"平谷区","parent_id":"2"}]},{"id":"300","name":"县","parent_id":"1","sub":[{"id":"301","name":"密云县","parent_id":"300"},{"id":"322","name":"延庆县","parent_id":"300"}]}]
     */

    private String id;
    private String name;
    private String parent_id;
    private List<SubBeanX> sub;

    // 实现 IPickerViewData 接口，
    // 这个用来显示在PickerView上面的字符串，
    // PickerView会通过IPickerViewData获取getPickerViewText方法显示出来。
    @Override
    public String getPickerViewText() {
        return this.name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public List<SubBeanX> getSub() {
        return sub;
    }

    public void setSub(List<SubBeanX> sub) {
        this.sub = sub;
    }


    public static class SubBeanX implements IPickerViewData {
        /**
         * id : 2
         * name : 市辖区
         * parent_id : 1
         * sub : [{"id":"3","name":"东城区","parent_id":"2"},{"id":"14","name":"西城区","parent_id":"2"},{"id":"22","name":"崇文区","parent_id":"2"},{"id":"30","name":"宣武区","parent_id":"2"},{"id":"39","name":"朝阳区","parent_id":"2"},{"id":"83","name":"丰台区","parent_id":"2"},{"id":"105","name":"石景山区","parent_id":"2"},{"id":"115","name":"海淀区","parent_id":"2"},{"id":"145","name":"门头沟区","parent_id":"2"},{"id":"159","name":"房山区","parent_id":"2"},{"id":"188","name":"通州区","parent_id":"2"},{"id":"204","name":"顺义区","parent_id":"2"},{"id":"227","name":"昌平区","parent_id":"2"},{"id":"245","name":"大兴区","parent_id":"2"},{"id":"264","name":"怀柔区","parent_id":"2"},{"id":"281","name":"平谷区","parent_id":"2"}]
         */

        private String id;
        private String name;
        private String parent_id;
        private List<SubBean> sub;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public List<SubBean> getSub() {
            return sub;
        }

        public void setSub(List<SubBean> sub) {
            this.sub = sub;
        }

        @Override
        public String getPickerViewText() {
            return this.name;
        }

        public static class SubBean implements IPickerViewData  {
            /**
             * id : 3
             * name : 东城区
             * parent_id : 2
             */

            private String id;
            private String name;
            private String parent_id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            @Override
            public String getPickerViewText() {
                return this.name;
            }
        }
    }
}
