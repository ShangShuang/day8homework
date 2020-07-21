package com.example.day8homework.bean;

import java.io.Serializable;
import java.util.List;

public class TeachersBean implements Serializable {
    /**
     * code : 200
     * body : {"result":[{"Description":"<p><img src=\"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/msg/course_1575342406141.jpg\" title=\"\" alt=\"\" width=\"100%\"/><\/p>","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1575342465043.jpg","Title":"形象礼仪专家","TeacherType":[],"ID":191,"follow":false,"TeacherName":"潘文荣","EnterpriseID":0},{"Description":"<p><img src=\"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/msg/course_1575342268415.jpg\" title=\"\" alt=\"\" width=\"100%\"/><\/p>","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1575342286074.jpg","Title":"清华大学五道口金融学院家族企业课程主任","TeacherType":[],"ID":80,"follow":false,"TeacherName":"高皓","EnterpriseID":0},{"Description":"<p><img src=\"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/msg/course_1575860135139.jpg\" title=\"\" alt=\"\" width=\"100%\"/><\/p>","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1576213706489.jpg","Title":"资深企业培训师、国家注册心理咨询师","TeacherType":[{"typename":"通用管理"},{"typename":"职场素养"}],"ID":79,"follow":false,"TeacherName":"曹爱宏","EnterpriseID":0},{"Description":"<p><img src=\"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/msg/course_1575359098521.jpg\" title=\"\" alt=\"\" width=\"100%\"/><\/p>","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1575359101719.jpg","Title":"中国绩效研究院院长","TeacherType":[],"ID":78,"follow":false,"TeacherName":"李太林","EnterpriseID":0},{"Description":"<p><img src=\"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/msg/course_1575345442685.jpg\" title=\"\" alt=\"\" width=\"100%\"/><\/p>","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1575345445735.jpg","Title":"全球著名投资家","TeacherType":[],"ID":77,"follow":false,"TeacherName":"吉姆 罗杰斯","EnterpriseID":0},{"Description":"<p><img src=\"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/msg/course_1575349118029.jpg\" title=\"\" alt=\"\" width=\"100%\"/><\/p>","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1575349121246.jpg","Title":"投资心学创立者、股票期货专业教练","TeacherType":[],"ID":76,"follow":false,"TeacherName":"李尧","EnterpriseID":0},{"Description":"<p><img src=\"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/msg/course_1575349255384.jpg\" title=\"\" alt=\"\" width=\"100%\"/><\/p>","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1575349259999.jpg","Title":"投资人、创业导师","TeacherType":[],"ID":75,"follow":false,"TeacherName":"刘松琳","EnterpriseID":0},{"Description":"<p><img src=\"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/msg/course_1575356525359.jpg\" title=\"\" alt=\"\" width=\"100%\"/><\/p>","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1575356528963.jpg","Title":"果睿投资董事长、投融资专家","TeacherType":[],"ID":74,"follow":false,"TeacherName":"虞涤新","EnterpriseID":0},{"Description":"<p><img src=\"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/msg/course_1575357079484.jpg\" title=\"\" alt=\"\" width=\"100%\"/><\/p>","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1575357091802.jpg","Title":"中华智慧传承导师、上海滩金融集团董事长","TeacherType":[],"ID":73,"follow":false,"TeacherName":"章起华","EnterpriseID":0},{"Description":"<p><img src=\"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/msg/course_1575357014071.jpg\" title=\"\" alt=\"\" width=\"100%\"/><\/p>","TeacherPic":"https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1575357027985.jpg","Title":"中国易经研究院名誉院长、著名风水大师","TeacherType":[],"ID":72,"follow":false,"TeacherName":"张祖源","EnterpriseID":0}]}
     * message : Succes!
     */

    private int code;
    private BodyBean body;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class BodyBean implements Serializable{
        private List<ResultBean> result;

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean implements Serializable{
            /**
             * Description : <p><img src="https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/msg/course_1575342406141.jpg" title="" alt="" width="100%"/></p>
             * TeacherPic : https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/imgurl/teacher/headimg_1575342465043.jpg
             * Title : 形象礼仪专家
             * TeacherType : []
             * ID : 191
             * follow : false
             * TeacherName : 潘文荣
             * EnterpriseID : 0
             */

            private String Description;
            private String TeacherPic;
            private String Title;
            private int ID;
            private boolean follow;
            private String TeacherName;
            private int EnterpriseID;
            private List<?> TeacherType;

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }

            public String getTeacherPic() {
                return TeacherPic;
            }

            public void setTeacherPic(String TeacherPic) {
                this.TeacherPic = TeacherPic;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getTeacherName() {
                return TeacherName;
            }

            public void setTeacherName(String TeacherName) {
                this.TeacherName = TeacherName;
            }

            public int getEnterpriseID() {
                return EnterpriseID;
            }

            public void setEnterpriseID(int EnterpriseID) {
                this.EnterpriseID = EnterpriseID;
            }

            public List<?> getTeacherType() {
                return TeacherType;
            }

            public void setTeacherType(List<?> TeacherType) {
                this.TeacherType = TeacherType;
            }
        }
    }
}
