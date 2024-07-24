package Maintenance.domain.entity;

import java.util.Date;

public class Maintenance {
    private int idRevision;
    private Date revisionDate;
    private int idPlane;
    
    // Empty constructor
    public Maintenance() {
    }
    // Full constructor
    public Maintenance(int idRevision, Date revisionDate, int idPlane) {
        this.idRevision = idRevision;
        this.revisionDate = revisionDate;
        this.idPlane = idPlane;
    }
    // Getters and setters
    public int getIdRevision() {
        return idRevision;
    }
    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
    }
    public Date getRevisionDate() {
        return revisionDate;
    }
    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }
    public int getIdPlane() {
        return idPlane;
    }
    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }
}
