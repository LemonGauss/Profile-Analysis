package com.pojo;

public class FileUpload {
    private Integer RNO;
    private String RName;
    private  String Position;
    private String content;

    public FileUpload() {
    }

    public FileUpload(Integer RNO, String RName, String Position, String content) {
        this.RNO = RNO;
        this.RName = RName;
        this.Position = Position;
        this.content = content;
    }

    public Integer getRNO() {
        return RNO;
    }

    public void setRNO(Integer RNO) {
        this.RNO = RNO;
    }

    public String getRName() {
        return RName;
    }

    public void setRName(String RName) {
        this.RName = RName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "File{" +
                "RNO=" + RNO +
                ", RName='" + RName + '\'' +
                ", Position='" + Position + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
