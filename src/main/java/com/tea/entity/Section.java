package com.tea.entity;

import javax.persistence.*;

@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private
    Integer id;

    /* 中文名称 */
    private String sectionNameCh;

    /* 英文名称 */
    private String sectionNameEn;

    /* 拉丁名称 */
    private String sectionNameLd;

    /* 别名 */
    private String sectionNameOth;

    /* 描述 */
    @Column(length = 100000)
    private String sectionDesc;

    /* 描述(无富文本标签) */
    @Column(length = 100000)
    private String sectionNotagDesc;

    public Section(){};
    public Section(Integer id){
        this.id=id;
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSectionNameCh() {
        return sectionNameCh;
    }

    public void setSectionNameCh(String sectionNameCh) {
        this.sectionNameCh = sectionNameCh;
    }

    public String getSectionNameEn() {
        return sectionNameEn;
    }

    public void setSectionNameEn(String sectionNameEn) {
        this.sectionNameEn = sectionNameEn;
    }

    public String getSectionNameLd() {
        return sectionNameLd;
    }

    public void setSectionNameLd(String sectionNameLd) {
        this.sectionNameLd = sectionNameLd;
    }

    public String getSectionNameOth() {
        return sectionNameOth;
    }

    public void setSectionNameOth(String sectionNameOth) {
        this.sectionNameOth = sectionNameOth;
    }

    public String getSectionDesc() {
        return sectionDesc;
    }

    public void setSectionDesc(String sectionDesc) {
        this.sectionDesc = sectionDesc;
    }

    public String getSectionNotagDesc() {
        return sectionNotagDesc;
    }

    public void setSectionNotagDesc(String sectionNotagDesc) {
        this.sectionNotagDesc = sectionNotagDesc;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", sectionNameCh='" + sectionNameCh + '\'' +
                ", sectionNameEn='" + sectionNameEn + '\'' +
                ", sectionNameLd='" + sectionNameLd + '\'' +
                ", sectionNameOth='" + sectionNameOth + '\'' +
                ", sectionDesc='" + sectionDesc + '\'' +
                ", sectionNotagDesc='" + sectionNotagDesc + '\'' +
                '}';
    }
}
