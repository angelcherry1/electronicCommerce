package com.xhc.bigbusinessu.Entity;

/**
 * @author:lixiaobiao
 * @date:On 2020/4/2
 * @Desriptiong: 23231
 */
public class SkillAndNeedEntity {
//    "status": "1",
//            "msg": "成功",
//            "code": "",
//            "data": {
//        "page": {
//            "totalRows": "1",
//                    "totalPages": "1",
//                    "p": "1"
//        },
//        "list": [
//        {
//            "id": "1",
//                "cat_id1": "1",
//                "cat_id2": "2",
//                "discipline": "上门服务",
//                "introduction": "服务周到，随叫随到，技术一流",
//                "photos": "sfsafasfas",
//                "video": "",
//                "offline": "120.00",
//                "tel": "50.00",
//                "add_time": "1585293036",
//                "lng": null,
//                "lat": null,
//                "type": "1"
//        }
//        ]
//    }

    private int status;
    private String msg;
    private String code;
    private PageBean page;
    private Listbean list;

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

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public Listbean getList() {
        return list;
    }

    public void setList(Listbean list) {
        this.list = list;
    }

    public static class PageBean{
        private String totalRows;
        private String totalPages;
        private String p;

        public String getTotalRows() {
            return totalRows;
        }

        public void setTotalRows(String totalRows) {
            this.totalRows = totalRows;
        }

        public String getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(String totalPages) {
            this.totalPages = totalPages;
        }

        public String getP() {
            return p;
        }

        public void setP(String p) {
            this.p = p;
        }
    }
    public static class Listbean{
        private String id;
        private String cat_id1;
        private String cat_id2;
        private String totalRows;
        private String discipline;
        private String introduction;
        private String photos;
        private String video;
        private String offline;
        private String tel;
        private String add_time;
        private String lng;
        private String lat;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCat_id1() {
            return cat_id1;
        }

        public void setCat_id1(String cat_id1) {
            this.cat_id1 = cat_id1;
        }

        public String getCat_id2() {
            return cat_id2;
        }

        public void setCat_id2(String cat_id2) {
            this.cat_id2 = cat_id2;
        }

        public String getTotalRows() {
            return totalRows;
        }

        public void setTotalRows(String totalRows) {
            this.totalRows = totalRows;
        }

        public String getDiscipline() {
            return discipline;
        }

        public void setDiscipline(String discipline) {
            this.discipline = discipline;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getPhotos() {
            return photos;
        }

        public void setPhotos(String photos) {
            this.photos = photos;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getOffline() {
            return offline;
        }

        public void setOffline(String offline) {
            this.offline = offline;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
