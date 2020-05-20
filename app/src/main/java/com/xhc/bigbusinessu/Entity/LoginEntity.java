package com.xhc.bigbusinessu.Entity;

public class LoginEntity {


    /**
     * status : 1
     * msg : 登陆成功
     * code :
     * data : {"user_id":"50","nickname":"","mobile":"13693692073","head_pic":"","reg_time":"1570591385","token":"c7b0bdd3a6b4f4b500f839ca49c19110"}
     */

    private int status;
    private String msg;
    private String code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 50
         * nickname :
         * mobile : 13693692073
         * head_pic :
         * reg_time : 1570591385
         * token : c7b0bdd3a6b4f4b500f839ca49c19110
         */

        private String user_id;
        private String nickname;
        private String mobile;
        private String head_pic;
        private String reg_time;
        private String token;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getHead_pic() {
            return head_pic;
        }

        public void setHead_pic(String head_pic) {
            this.head_pic = head_pic;
        }

        public String getReg_time() {
            return reg_time;
        }

        public void setReg_time(String reg_time) {
            this.reg_time = reg_time;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
