package com.tea.entity;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Genus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private
    Integer id;

    /* 中文名称 */
    private String genusNameCh;

    /* 英文名称 */
    private String genusNameEn;

    /* 拉丁名称 */
    private String genusNameLd;

    /* 别名 */
    private String genusNameOth;

    /* 描述 */
    @Column(length = 100000)
    private String genusDesc;

    /* 描述(无富文本标签) */
    @Column(length = 100000)
    private String genusNotagDesc;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getGenusNameCh() {
        return genusNameCh;
    }

    public void setGenusNameCh(String genusNameCh) {
        this.genusNameCh = genusNameCh;
    }

    public String getGenusNameEn() {
        return genusNameEn;
    }

    public void setGenusNameEn(String genusNameEn) {
        this.genusNameEn = genusNameEn;
    }

    public String getGenusNameLd() {
        return genusNameLd;
    }

    public void setGenusNameLd(String genusNameLd) {
        this.genusNameLd = genusNameLd;
    }

    public String getGenusNameOth() {
        return genusNameOth;
    }

    public void setGenusNameOth(String genusNameOth) {
        this.genusNameOth = genusNameOth;
    }

    public String getGenusDesc() {
        return genusDesc;
    }

    public void setGenusDesc(String genusDesc) {
        this.genusDesc = genusDesc;
    }

    public String getGenusNotagDesc() {
        return genusNotagDesc;
    }

    public void setGenusNotagDesc(String genusNotagDesc) {
        this.genusNotagDesc = genusNotagDesc;
    }

    @Override
    public String toString() {
        return "Genus{" +
                "id=" + id +
                ", genusNameCh='" + genusNameCh + '\'' +
                ", genusNameEn='" + genusNameEn + '\'' +
                ", genusNameLd='" + genusNameLd + '\'' +
                ", genusNameOth='" + genusNameOth + '\'' +
                ", genusDesc='" + genusDesc + '\'' +
                ", genusNotagDesc='" + genusNotagDesc + '\'' +
                '}';
    }
}
