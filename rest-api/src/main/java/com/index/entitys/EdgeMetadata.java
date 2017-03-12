package com.index.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jacr on 07/01/17.
 */
@Entity
@Table(name = "edge_metadata")
public class EdgeMetadata implements Serializable{

    @EmbeddedId
    private EdgeMetadataKey edgeMetadataKey;

    @Column
    private int times;

    @Column
    private Date lastDate;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(
                    name = "smiles_to",
                    referencedColumnName = "smiles_to", insertable=false, updatable=false),
            @JoinColumn(
                    name = "smiles_from",
                    referencedColumnName = "smiles_from", insertable=false, updatable=false)
    })
    private Edge edge;

    @ManyToOne
    @JoinColumn(name = "smiles_to",
            referencedColumnName = "smiles", insertable=false, updatable=false)
    private Structure toStructure;

    public EdgeMetadata() {

    }

    public EdgeMetadata(EdgeMetadataKey edgeMetadataKey) {
        this.edgeMetadataKey = edgeMetadataKey;
    }

    public EdgeMetadata(int userId, String smilesFrom, String smilesTo, int groupId){
        this.edgeMetadataKey = new EdgeMetadataKey(userId, groupId, smilesFrom, smilesTo);
    }

    @PrePersist
    protected void onCreate() {
        lastDate = new Date();
        times = 1;
    }

    @PreUpdate
    protected void onUpdate() {
        lastDate = new Date();
    }

    public EdgeMetadataKey getEdgeMetadataKey() {
        return edgeMetadataKey;
    }

    public int getUserId() {
        return edgeMetadataKey.getUserId();
    }

    public void setUserId(int userId) {
        edgeMetadataKey.setUserId(userId);
    }

    public String getSmilesTo() {
        return edgeMetadataKey.getSmilesTo();
    }

    public void setSmilesTo(String smilesTo) {
        edgeMetadataKey.setSmilesTo(smilesTo);
    }

    public String getSmilesFrom() {
        return edgeMetadataKey.getSmilesFrom();
    }

    public void setSmilesFrom(String smilesFrom) {
        edgeMetadataKey.setSmilesFrom(smilesFrom);
    }

    public void setEdgeMetadataKey(EdgeMetadataKey edgeMetadataKey) {
        this.edgeMetadataKey = edgeMetadataKey;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public int getGroupId() {
        return edgeMetadataKey.getGroupId();
    }

    public void setGroupId(int groupId) {
        edgeMetadataKey.setGroupId(groupId);
    }
}

