package com.xhc.bigbusinessu.Entity;

import java.util.List;

public class GoodsClassifyEntity {


    /**
     * status : 1
     * msg : 成功
     * code :
     * data : [{"name":"食品","id":"849","sub_category":[{"name":"饼干","id":"850"},{"name":"零食","id":"855"}]},{"name":"生鲜","id":"851","sub_category":[{"name":"蔬菜","id":"856"},{"name":"水果","id":"857"},{"name":"肉类","id":"858"}]},{"name":"百货","id":"852"},{"name":"手机","id":"853","sub_category":[{"name":"手机","id":"859"},{"name":"手机配件","id":"860"}]},{"name":"服装","id":"854"}]
     */

    private int status;
    private String msg;
    private String code;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 食品
         * id : 849
         * sub_category : [{"name":"饼干","id":"850"},{"name":"零食","id":"855"}]
         */

        private String name;
        private String id;
        private List<SubCategoryBean> sub_category;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<SubCategoryBean> getSub_category() {
            return sub_category;
        }

        public void setSub_category(List<SubCategoryBean> sub_category) {
            this.sub_category = sub_category;
        }

        public static class SubCategoryBean {
            /**
             * name : 饼干
             * id : 850
             */

            private String name;
            private String id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
