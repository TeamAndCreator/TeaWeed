package com.tea.entity;

import javax.persistence.*;

@Entity
public class Spec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Integer id;
    /* 属标识 */
    @ManyToOne
    @JoinColumn(name = "genus_id")
    private Genus genus;

    /* 中文名称 */
    private String specNameCh;

    /* 英文名称 */
    private String specNameEn;

    /* 拉丁名称 */
    private String specNameLd;

    /* 种别名 */
    private String specNameOth;

    /* 种类编码 */
    private String specCode;

    /* 种类条形码 */
    private String specBarCode;

    /* 种类DNA码 */
    private String specDna;

    /* 国内分布 */
    private String specDomestic;

    /* 国外分布 */
    private String specForeign;

    /* 视频 */
    private String specVidio;

    /* 图片 */
    private String specImgs;

    /* 种描述 */
    @Column(length = 100000)
    private String specDesc;

    /* 种描述(无富文本标签） */
    @Column(length = 100000)
    private String specNotagDesc;

    /* 地点 */
    private String specLocation;

    /* 时间 */
    private String addTime;

    public Spec(){}

    public Spec(Integer id,String specNameCh,String specImgs){
        this.id = id;
        this.specNameCh=specNameCh;
        this.specImgs=specImgs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Genus getGenus() {
        return genus;
    }

    public void setGenus(Genus genus) {
        this.genus = genus;
    }

    public String getSpecNameCh() {
        return specNameCh;
    }

    public void setSpecNameCh(String specNameCh) {
        this.specNameCh = specNameCh;
    }

    public String getSpecNameEn() {
        return specNameEn;
    }

    public void setSpecNameEn(String specNameEn) {
        this.specNameEn = specNameEn;
    }

    public String getSpecNameLd() {
        return specNameLd;
    }

    public void setSpecNameLd(String specNameLd) {
        this.specNameLd = specNameLd;
    }

    public String getSpecNameOth() {
        return specNameOth;
    }

    public void setSpecNameOth(String specNameOth) {
        this.specNameOth = specNameOth;
    }

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public String getSpecBarCode() {
        return specBarCode;
    }

    public void setSpecBarCode(String specBarCode) {
        this.specBarCode = specBarCode;
    }

    public String getSpecDna() {
        return specDna;
    }

    public void setSpecDna(String specDna) {
        this.specDna = specDna;
    }

    public String getSpecDomestic() {
        return specDomestic;
    }

    public void setSpecDomestic(String specDomestic) {
        this.specDomestic = specDomestic;
    }

    public String getSpecForeign() {
        return specForeign;
    }

    public void setSpecForeign(String specForeign) {
        this.specForeign = specForeign;
    }

    public String getSpecVidio() {
        return specVidio;
    }

    public void setSpecVidio(String specVidio) {
        this.specVidio = specVidio;
    }

    public String getSpecImgs() {
        return specImgs;
    }

    public void setSpecImgs(String specImgs) {
        this.specImgs = specImgs;
    }

    public String getSpecDesc() {
        return specDesc;
    }

    public void setSpecDesc(String specDesc) {
        this.specDesc = specDesc;
    }

    public String getSpecNotagDesc() {
        return specNotagDesc;
    }

    public void setSpecNotagDesc(String specNotagDesc) {
        this.specNotagDesc = specNotagDesc;
    }

    public String getSpecLocation() {
        return specLocation;
    }

    public void setSpecLocation(String specLocation) {
        this.specLocation = specLocation;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Override
    public String   toString() {
        return "Spec{" +
                "id=" + id +
                ", genus=" + genus +
                ", specNameCh='" + specNameCh + '\'' +
                ", specNameEn='" + specNameEn + '\'' +
                ", specNameLd='" + specNameLd + '\'' +
                ", specNameOth='" + specNameOth + '\'' +
                ", specCode='" + specCode + '\'' +
                ", specBarCode='" + specBarCode + '\'' +
                ", specDna='" + specDna + '\'' +
                ", specDomestic='" + specDomestic + '\'' +
                ", specForeign='" + specForeign + '\'' +
                ", specVidio='" + specVidio + '\'' +
                ", specImgs='" + specImgs + '\'' +
                ", specDesc='" + specDesc + '\'' +
                ", specNotagDesc='" + specNotagDesc + '\'' +
                ", specLocation='" + specLocation + '\'' +
                ", addTime='" + addTime + '\'' +
                '}';
    }
}
