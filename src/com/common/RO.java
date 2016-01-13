package com.common;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lee.J.Eric on 2015/3/30.
 */
public class RO<T> implements Serializable {

    private static final long serialVersionUID = 6113893091029359812L;

    /**
     * �û�״̬
     * @author Lee.J.Eric
     * @time 2015��1��13�� ����11:23:20
     */
    public static enum ROCode {

        ERROR("error",-2),
        ILLEGAL("illegal",-1),
        SUCCESS("success",0),
        FAILED("failed",1);


        private String name;
        private Integer code;

        private ROCode(String name, Integer code) {
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

    }

    private String method;
    private int code;
    private T data;
    private int currentpage=0;//��ǰҳ
    private int totalpage=0;//��ҳ��
    private int currentpagesum=0;//��ǰҳ����
    private int pagesize=0;//ҳ���С
    private long total=0;//��¼����
    private Date datetime = new Date();//�ӿ���Ӧʱ��
    private String msg = "";//��Ϣ��ʾ

    public RO() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getCurrentpagesum() {
		return currentpagesum;
	}

	public void setCurrentpagesum(int currentpagesum) {
		this.currentpagesum = currentpagesum;
	}

	public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
