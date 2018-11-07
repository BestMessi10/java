package com.aguigu.crowd.beam;

public class DongSearch {
    private Integer id;

    private String name;

    private String time;

    private String tmp;
    
    private Integer cishu;
    

    
    public Integer getCishu() {
		return cishu;
	}

	public void setCishu(Integer cishu) {
		this.cishu = cishu;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp == null ? null : tmp.trim();
    }
}