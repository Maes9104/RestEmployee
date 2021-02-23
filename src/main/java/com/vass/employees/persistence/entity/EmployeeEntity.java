package com.vass.employees.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer idEmployee;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "total_salary")
    private Double totalSalary;

    private Float percentage;

    @Column(name = "id_boss")
    private Integer idBoss;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "id_boss", insertable = false, updatable = false)
    private EmployeeEntity boss;

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public Integer getIdBoss() {
        return idBoss;
    }

    public void setIdBoss(Integer idBoss) {
        this.idBoss = idBoss;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public EmployeeEntity getBoss() {
        return boss;
    }

    public void setBoss(EmployeeEntity boss) {
        this.boss = boss;
    }
}
